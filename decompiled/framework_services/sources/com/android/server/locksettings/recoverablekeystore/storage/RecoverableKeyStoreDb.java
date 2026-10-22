package com.android.server.locksettings.recoverablekeystore.storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import com.android.server.locksettings.recoverablekeystore.TestOnlyInsecureCertificateHelper;
import com.android.server.locksettings.recoverablekeystore.WrappedKey;
import java.io.ByteArrayInputStream;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.cert.CertPath;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringJoiner;

/* JADX INFO: loaded from: classes2.dex */
public class RecoverableKeyStoreDb {
    private static final String CERT_PATH_ENCODING = "PkiPath";
    private static final int IDLE_TIMEOUT_SECONDS = 30;
    private static final int LAST_SYNCED_AT_UNSYNCED = -1;
    private static final String TAG = "RecoverableKeyStoreDb";
    private final RecoverableKeyStoreDbHelper mKeyStoreDbHelper;
    private final TestOnlyInsecureCertificateHelper mTestOnlyInsecureCertificateHelper;

    /* JADX INFO: renamed from: $r8$lambda$Zxt3v_KZ6WLOaobIXxBu-lEyoOU, reason: not valid java name */
    public static /* synthetic */ void m5490$r8$lambda$Zxt3v_KZ6WLOaobIXxBulEyoOU(StringJoiner r0, int r1) {
        lambda$setRecoverySecretTypes$0(r0, r1);
    }

    public static RecoverableKeyStoreDb newInstance(Context context) {
        RecoverableKeyStoreDbHelper helper = new RecoverableKeyStoreDbHelper(context);
        helper.setWriteAheadLoggingEnabled(true);
        helper.setIdleConnectionTimeout(30);
        return new RecoverableKeyStoreDb(helper);
    }

    private RecoverableKeyStoreDb(RecoverableKeyStoreDbHelper keyStoreDbHelper) {
        this.mKeyStoreDbHelper = keyStoreDbHelper;
        this.mTestOnlyInsecureCertificateHelper = new TestOnlyInsecureCertificateHelper();
    }

    public long insertKey(int userId, int uid, String alias, WrappedKey wrappedKey) {
        SQLiteDatabase db = this.mKeyStoreDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("user_id", Integer.valueOf(userId));
        values.put("uid", Integer.valueOf(uid));
        values.put("alias", alias);
        values.put("nonce", wrappedKey.getNonce());
        values.put("wrapped_key", wrappedKey.getKeyMaterial());
        values.put("last_synced_at", -1);
        values.put("platform_key_generation_id", Integer.valueOf(wrappedKey.getPlatformKeyGenerationId()));
        values.put("recovery_status", Integer.valueOf(wrappedKey.getRecoveryStatus()));
        byte[] keyMetadata = wrappedKey.getKeyMetadata();
        if (keyMetadata != null) goto L5;
        values.putNull("key_metadata");
    L7:
        return db.replace("keys", null, values);
    L5:
        values.put("key_metadata", keyMetadata);
        goto L7
    }

    public WrappedKey getKey(int uid, String alias) {
        SQLiteDatabase db = this.mKeyStoreDbHelper.getReadableDatabase();
        String[] projection = {"_id", "nonce", "wrapped_key", "platform_key_generation_id", "recovery_status", "key_metadata"};
        String[] selectionArguments = {Integer.toString(uid), alias};
        Cursor cursor = db.query("keys", projection, "uid = ? AND alias = ?", selectionArguments, null, null, null);
        int count = cursor.getCount();     // Catch: Throwable -> L13
        if (count != 0) goto L9;
        cursor.close();
        return null;
    L9:
        if (count <= 1) goto L15;
        Log.wtf(TAG, String.format(Locale.US, "%d WrappedKey entries found for uid=%d alias='%s'. Should only ever be 0 or 1.", new Object[]{Integer.valueOf(count), Integer.valueOf(uid), alias}));     // Catch: Throwable -> L13
        cursor.close();
        return null;
    L15:
        cursor.moveToFirst();     // Catch: Throwable -> L13
        byte[] nonce = cursor.getBlob(cursor.getColumnIndexOrThrow("nonce"));     // Catch: Throwable -> L13
        byte[] keyMaterial = cursor.getBlob(cursor.getColumnIndexOrThrow("wrapped_key"));     // Catch: Throwable -> L13
        int generationId = cursor.getInt(cursor.getColumnIndexOrThrow("platform_key_generation_id"));     // Catch: Throwable -> L13
        int recoveryStatus = cursor.getInt(cursor.getColumnIndexOrThrow("recovery_status"));     // Catch: Throwable -> L13
        int metadataIdx = cursor.getColumnIndexOrThrow("key_metadata");     // Catch: Throwable -> L13
        if (cursor.isNull(metadataIdx) == false) goto L18;
        byte[] keyMetadata = null;
    L19:
        WrappedKey r7 = new WrappedKey(nonce, keyMaterial, keyMetadata, generationId, recoveryStatus);     // Catch: Throwable -> L13
        cursor.close();
        return r7;
    L18:
        byte[] keyMetadata2 = cursor.getBlob(metadataIdx);     // Catch: Throwable -> L13
        keyMetadata = keyMetadata2;
    L13:
        th = move-exception;
        if (cursor == null) goto L31;
        cursor.close();     // Catch: Throwable -> L25
        throw th;
    L25:
        th = move-exception;
        th.addSuppressed(th);
        throw th;
    L31:
        throw th;
    }

    public boolean removeKey(int uid, String alias) {
        SQLiteDatabase db = this.mKeyStoreDbHelper.getWritableDatabase();
        String[] selectionArgs = {Integer.toString(uid), alias};
        if (db.delete("keys", "uid = ? AND alias = ?", selectionArgs) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public Map<String, Integer> getStatusForAllKeys(int uid) {
        SQLiteDatabase db = this.mKeyStoreDbHelper.getReadableDatabase();
        String[] projection = {"_id", "alias", "recovery_status"};
        String[] selectionArguments = {Integer.toString(uid)};
        Cursor cursor = db.query("keys", projection, "uid = ?", selectionArguments, null, null, null);
        HashMap<String, Integer> statuses = new HashMap();     // Catch: Throwable -> L8
    L5:
        if (cursor.moveToNext() == false) goto L10;
        String alias = cursor.getString(cursor.getColumnIndexOrThrow("alias"));     // Catch: Throwable -> L8
        int recoveryStatus = cursor.getInt(cursor.getColumnIndexOrThrow("recovery_status"));     // Catch: Throwable -> L8
        statuses.put(alias, Integer.valueOf(recoveryStatus));     // Catch: Throwable -> L8
        goto L5
    L10:
        cursor.close();
        return statuses;
    L8:
        th = move-exception;
        if (cursor == null) goto L24;
        cursor.close();     // Catch: Throwable -> L15
        throw th;
    L15:
        th = move-exception;
        th.addSuppressed(th);
        throw th;
    L24:
        throw th;
    }

    public int setRecoveryStatus(int uid, String alias, int status) {
        SQLiteDatabase db = this.mKeyStoreDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("recovery_status", Integer.valueOf(status));
        return db.update("keys", values, "uid = ? AND alias = ?", new String[]{String.valueOf(uid), alias});
    }

    public Map<String, WrappedKey> getAllKeys(int userId, int recoveryAgentUid, int platformKeyGenerationId) {
        SQLiteDatabase db = this.mKeyStoreDbHelper.getReadableDatabase();
        String[] projection = {"_id", "nonce", "wrapped_key", "alias", "recovery_status", "key_metadata"};
        String[] selectionArguments = {Integer.toString(userId), Integer.toString(recoveryAgentUid), Integer.toString(platformKeyGenerationId)};
        Cursor cursor = db.query("keys", projection, "user_id = ? AND uid = ? AND platform_key_generation_id = ?", selectionArguments, null, null, null);
        HashMap<String, WrappedKey> keys = new HashMap();     // Catch: Throwable -> L12
    L4:
        if (cursor.moveToNext() == false) goto L14;
        byte[] nonce = cursor.getBlob(cursor.getColumnIndexOrThrow("nonce"));     // Catch: Throwable -> L12
        byte[] keyMaterial = cursor.getBlob(cursor.getColumnIndexOrThrow("wrapped_key"));     // Catch: Throwable -> L12
        String alias = cursor.getString(cursor.getColumnIndexOrThrow("alias"));     // Catch: Throwable -> L12
        int recoveryStatus = cursor.getInt(cursor.getColumnIndexOrThrow("recovery_status"));     // Catch: Throwable -> L12
        int metadataIdx = cursor.getColumnIndexOrThrow("key_metadata");     // Catch: Throwable -> L12
        if (cursor.isNull(metadataIdx) == false) goto L9;
        byte[] keyMetadata = null;
    L10:
        keys.put(alias, new WrappedKey(nonce, keyMaterial, keyMetadata, platformKeyGenerationId, recoveryStatus));     // Catch: Throwable -> L12
        goto L4
    L9:
        byte[] keyMetadata2 = cursor.getBlob(metadataIdx);     // Catch: Throwable -> L12
        keyMetadata = keyMetadata2;
        goto L10
    L14:
        cursor.close();
        return keys;
    L12:
        th = move-exception;
        if (cursor == null) goto L29;
        cursor.close();     // Catch: Throwable -> L19
        throw th;
    L19:
        th = move-exception;
        th.addSuppressed(th);
        throw th;
    L29:
        throw th;
    }

    public long setPlatformKeyGenerationId(int userId, int generationId) {
        SQLiteDatabase db = this.mKeyStoreDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("user_id", Integer.valueOf(userId));
        values.put("platform_key_generation_id", Integer.valueOf(generationId));
        String[] selectionArguments = {String.valueOf(userId)};
        ensureUserMetadataEntryExists(userId);
        invalidateKeysForUser(userId);
        return db.update("user_metadata", values, "user_id = ?", selectionArguments);
    }

    public Map<Integer, Long> getUserSerialNumbers() {
        SQLiteDatabase db = this.mKeyStoreDbHelper.getReadableDatabase();
        String[] projection = {"user_id", "user_serial_number"};
        String[] selectionArguments = new String[0];
        Cursor cursor = db.query("user_metadata", projection, null, selectionArguments, null, null, null);
        Map<Integer, Long> serialNumbers = new ArrayMap();     // Catch: Throwable -> L8
    L5:
        if (cursor.moveToNext() == false) goto L10;
        int userId = cursor.getInt(cursor.getColumnIndexOrThrow("user_id"));     // Catch: Throwable -> L8
        long serialNumber = cursor.getLong(cursor.getColumnIndexOrThrow("user_serial_number"));     // Catch: Throwable -> L8
        serialNumbers.put(Integer.valueOf(userId), Long.valueOf(serialNumber));     // Catch: Throwable -> L8
        goto L5
    L10:
        cursor.close();
        return serialNumbers;
    L8:
        th = move-exception;
        if (cursor == null) goto L24;
        cursor.close();     // Catch: Throwable -> L15
        throw th;
    L15:
        th = move-exception;
        th.addSuppressed(th);
        throw th;
    L24:
        throw th;
    }

    public long setUserSerialNumber(int userId, long serialNumber) {
        SQLiteDatabase db = this.mKeyStoreDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("user_id", Integer.valueOf(userId));
        values.put("user_serial_number", Long.valueOf(serialNumber));
        String[] selectionArguments = {String.valueOf(userId)};
        ensureUserMetadataEntryExists(userId);
        return db.update("user_metadata", values, "user_id = ?", selectionArguments);
    }

    public long setBadRemoteGuessCounter(int userId, int badGuessCounter) {
        SQLiteDatabase db = this.mKeyStoreDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("user_id", Integer.valueOf(userId));
        values.put("bad_remote_guess_counter", Integer.valueOf(badGuessCounter));
        String[] selectionArguments = {String.valueOf(userId)};
        ensureUserMetadataEntryExists(userId);
        return db.update("user_metadata", values, "user_id = ?", selectionArguments);
    }

    public int getBadRemoteGuessCounter(int userId) {
        SQLiteDatabase db = this.mKeyStoreDbHelper.getReadableDatabase();
        String[] projection = {"bad_remote_guess_counter"};
        String[] selectionArguments = {Integer.toString(userId)};
        Cursor cursor = db.query("user_metadata", projection, "user_id = ?", selectionArguments, null, null, null);
    L10:
        th = move-exception;
        if (cursor == null) goto L22;
        cursor.close();     // Catch: Throwable -> L15
        throw th;
    L15:
        th = move-exception;
        th.addSuppressed(th);
        throw th;
    L22:
        throw th;
    L4:
        if (cursor.getCount() != 0) goto L7;
        cursor.close();
        return 0;
    L7:
        cursor.moveToFirst();     // Catch: Throwable -> L10
        int r0 = cursor.getInt(cursor.getColumnIndexOrThrow("bad_remote_guess_counter"));     // Catch: Throwable -> L10
        cursor.close();
        return r0;
    }

    public void invalidateKeysForUser(int userId) {
        SQLiteDatabase db = this.mKeyStoreDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("recovery_status", 3);
        db.update("keys", values, "user_id = ?", new String[]{String.valueOf(userId)});
    }

    public void invalidateKeysForUserIdOnCustomScreenLock(int userId) {
        SQLiteDatabase db = this.mKeyStoreDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("recovery_status", 3);
        db.update("keys", values, "user_id = ?", new String[]{String.valueOf(userId)});
    }

    public int getPlatformKeyGenerationId(int userId) {
        SQLiteDatabase db = this.mKeyStoreDbHelper.getReadableDatabase();
        String[] projection = {"platform_key_generation_id"};
        String[] selectionArguments = {Integer.toString(userId)};
        Cursor cursor = db.query("user_metadata", projection, "user_id = ?", selectionArguments, null, null, null);
    L10:
        th = move-exception;
        if (cursor == null) goto L22;
        cursor.close();     // Catch: Throwable -> L15
        throw th;
    L15:
        th = move-exception;
        th.addSuppressed(th);
        throw th;
    L22:
        throw th;
    L4:
        if (cursor.getCount() != 0) goto L7;
        cursor.close();
        return -1;
    L7:
        cursor.moveToFirst();     // Catch: Throwable -> L10
        int r0 = cursor.getInt(cursor.getColumnIndexOrThrow("platform_key_generation_id"));     // Catch: Throwable -> L10
        cursor.close();
        return r0;
    }

    public long setRecoveryServicePublicKey(int userId, int uid, PublicKey publicKey) {
        return setBytes(userId, uid, "public_key", publicKey.getEncoded());
    }

    public Long getRecoveryServiceCertSerial(int userId, int uid, String rootAlias) {
        return getLong(userId, uid, rootAlias, "cert_serial");
    }

    public long setRecoveryServiceCertSerial(int userId, int uid, String rootAlias, long serial) {
        return setLong(userId, uid, rootAlias, "cert_serial", serial);
    }

    public CertPath getRecoveryServiceCertPath(int userId, int uid, String rootAlias) {
        byte[] bytes = getBytes(userId, uid, rootAlias, "cert_path");
        if (bytes != null) goto L10;
        return null;
    L10:
        return decodeCertPath(bytes);
    L7:
        e = move-exception;
        Log.wtf(TAG, String.format(Locale.US, "Recovery service CertPath entry cannot be decoded for userId=%d uid=%d.", new Object[]{Integer.valueOf(userId), Integer.valueOf(uid)}), e);
        return null;
    }

    public long setRecoveryServiceCertPath(int userId, int uid, String rootAlias, CertPath certPath) throws CertificateEncodingException {
        if (certPath.getCertificates().size() == 0) goto L7;
        return setBytes(userId, uid, rootAlias, "cert_path", certPath.getEncoded(CERT_PATH_ENCODING));
    L7:
        throw new CertificateEncodingException("No certificate contained in the cert path.");
    }

    public List<Integer> getRecoveryAgents(int userId) {
        SQLiteDatabase db = this.mKeyStoreDbHelper.getReadableDatabase();
        String[] projection = {"uid"};
        String[] selectionArguments = {Integer.toString(userId)};
        Cursor cursor = db.query("recovery_service_metadata", projection, "user_id = ?", selectionArguments, null, null, null);
        int count = cursor.getCount();     // Catch: Throwable -> L8
        ArrayList<Integer> result = new ArrayList(count);     // Catch: Throwable -> L8
    L5:
        if (cursor.moveToNext() == false) goto L10;
        int uid = cursor.getInt(cursor.getColumnIndexOrThrow("uid"));     // Catch: Throwable -> L8
        result.add(Integer.valueOf(uid));     // Catch: Throwable -> L8
        goto L5
    L10:
        cursor.close();
        return result;
    L8:
        th = move-exception;
        if (cursor == null) goto L24;
        cursor.close();     // Catch: Throwable -> L15
        throw th;
    L15:
        th = move-exception;
        th.addSuppressed(th);
        throw th;
    L24:
        throw th;
    }

    public PublicKey getRecoveryServicePublicKey(int userId, int uid) {
        byte[] keyBytes = getBytes(userId, uid, "public_key");
        if (keyBytes != null) goto L10;
        return null;
    L10:
        return decodeX509Key(keyBytes);
    L8:
        Log.wtf(TAG, String.format(Locale.US, "Recovery service public key entry cannot be decoded for userId=%d uid=%d.", new Object[]{Integer.valueOf(userId), Integer.valueOf(uid)}));
        return null;
    }

    public long setRecoverySecretTypes(int userId, int uid, int[] secretTypes) {
        SQLiteDatabase db = this.mKeyStoreDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        final StringJoiner joiner = new StringJoiner(",");
        Arrays.stream(secretTypes).forEach(new RecoverableKeyStoreDb$$ExternalSyntheticLambda0(joiner));
        String typesAsCsv = joiner.toString();
        values.put("secret_types", typesAsCsv);
        ensureRecoveryServiceMetadataEntryExists(userId, uid);
        return db.update("recovery_service_metadata", values, "user_id = ? AND uid = ?", new String[]{String.valueOf(userId), String.valueOf(uid)});
    }

    private static /* synthetic */ void lambda$setRecoverySecretTypes$0(StringJoiner joiner, int i) {
        joiner.add(Integer.toString(i));
    }

    public int[] getRecoverySecretTypes(int userId, int uid) {
        SQLiteDatabase db = this.mKeyStoreDbHelper.getReadableDatabase();
        String[] projection = {"_id", "user_id", "uid", "secret_types"};
        String[] selectionArguments = {Integer.toString(userId), Integer.toString(uid)};
        Cursor cursor = db.query("recovery_service_metadata", projection, "user_id = ? AND uid = ?", selectionArguments, null, null, null);
        int count = cursor.getCount();     // Catch: Throwable -> L8
        if (count != 0) goto L11;
        int[] r0 = new int[0];     // Catch: Throwable -> L8
        cursor.close();
        return r0;
    L11:
        if (count <= 1) goto L15;
        Log.wtf(TAG, String.format(Locale.US, "%d deviceId entries found for userId=%d uid=%d. Should only ever be 0 or 1.", new Object[]{Integer.valueOf(count), Integer.valueOf(userId), Integer.valueOf(uid)}));     // Catch: Throwable -> L8
        int[] r1 = new int[0];     // Catch: Throwable -> L8
        cursor.close();
        return r1;
    L15:
        cursor.moveToFirst();     // Catch: Throwable -> L8
        int idx = cursor.getColumnIndexOrThrow("secret_types");     // Catch: Throwable -> L8
        if (cursor.isNull(idx) == false) goto L20;
        int[] r2 = new int[0];     // Catch: Throwable -> L8
        cursor.close();
        return r2;
    L20:
        String csv = cursor.getString(idx);     // Catch: Throwable -> L8
        if (TextUtils.isEmpty(csv) == false) goto L25;
        int[] r3 = new int[0];     // Catch: Throwable -> L8
        cursor.close();
        return r3;
    L25:
        String[] types = csv.split(",");     // Catch: Throwable -> L8
        int[] result = new int[types.length];     // Catch: Throwable -> L8
        int i = 0;
    L27:
        if (i >= types.length) goto L33;
        result[i] = Integer.parseInt(types[i]);     // Catch: Throwable -> L8 NumberFormatException -> L30
    L32:
        i = i + 1;
    L30:
        e = move-exception;
        Log.wtf(TAG, "String format error " + e);     // Catch: Throwable -> L8
        goto L32
    L33:
        cursor.close();
        return result;
    L8:
        th = move-exception;
        if (cursor == null) goto L49;
        cursor.close();     // Catch: Throwable -> L38
        throw th;
    L38:
        th = move-exception;
        th.addSuppressed(th);
        throw th;
    L49:
        throw th;
    }

    public long setActiveRootOfTrust(int userId, int uid, String rootAlias) {
        SQLiteDatabase db = this.mKeyStoreDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("active_root_of_trust", rootAlias);
        ensureRecoveryServiceMetadataEntryExists(userId, uid);
        return db.update("recovery_service_metadata", values, "user_id = ? AND uid = ?", new String[]{String.valueOf(userId), String.valueOf(uid)});
    }

    public String getActiveRootOfTrust(int userId, int uid) {
        SQLiteDatabase db = this.mKeyStoreDbHelper.getReadableDatabase();
        String[] projection = {"_id", "user_id", "uid", "active_root_of_trust"};
        String[] selectionArguments = {Integer.toString(userId), Integer.toString(uid)};
        Cursor cursor = db.query("recovery_service_metadata", projection, "user_id = ? AND uid = ?", selectionArguments, null, null, null);
        int count = cursor.getCount();     // Catch: Throwable -> L13
        if (count != 0) goto L9;
        cursor.close();
        return null;
    L9:
        if (count <= 1) goto L15;
        Log.wtf(TAG, String.format(Locale.US, "%d deviceId entries found for userId=%d uid=%d. Should only ever be 0 or 1.", new Object[]{Integer.valueOf(count), Integer.valueOf(userId), Integer.valueOf(uid)}));     // Catch: Throwable -> L13
        cursor.close();
        return null;
    L15:
        cursor.moveToFirst();     // Catch: Throwable -> L13
        int idx = cursor.getColumnIndexOrThrow("active_root_of_trust");     // Catch: Throwable -> L13
        if (cursor.isNull(idx) == false) goto L19;
        cursor.close();
        return null;
    L19:
        String result = cursor.getString(idx);     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(result) == false) goto L23;
        cursor.close();
        return null;
    L23:
        cursor.close();
        return result;
    L13:
        th = move-exception;
        if (cursor == null) goto L34;
        cursor.close();     // Catch: Throwable -> L28
        throw th;
    L28:
        th = move-exception;
        th.addSuppressed(th);
        throw th;
    L34:
        throw th;
    }

    public long setCounterId(int userId, int uid, long counterId) {
        return setLong(userId, uid, "counter_id", counterId);
    }

    public Long getCounterId(int userId, int uid) {
        return getLong(userId, uid, "counter_id");
    }

    public long setServerParams(int userId, int uid, byte[] serverParams) {
        return setBytes(userId, uid, "server_params", serverParams);
    }

    public byte[] getServerParams(int userId, int uid) {
        return getBytes(userId, uid, "server_params");
    }

    public long setSnapshotVersion(int userId, int uid, long snapshotVersion) {
        return setLong(userId, uid, "snapshot_version", snapshotVersion);
    }

    public Long getSnapshotVersion(int userId, int uid) {
        return getLong(userId, uid, "snapshot_version");
    }

    public long setShouldCreateSnapshot(int userId, int uid, boolean pending) {
        if (pending == false) goto L5;
        long r0 = 1;
    L7:
        return setLong(userId, uid, "should_create_snapshot", r0);
    L5:
        r0 = 0;
        goto L7
    }

    public boolean getShouldCreateSnapshot(int userId, int uid) {
        Long res = getLong(userId, uid, "should_create_snapshot");
        if (res != null) goto L5;
    L7:
        return false;
    L5:
        if (res.longValue() == 0) goto L7;
        return true;
    }

    private Long getLong(int userId, int uid, String key) {
        SQLiteDatabase db = this.mKeyStoreDbHelper.getReadableDatabase();
        String[] projection = {"_id", "user_id", "uid", key};
        String[] selectionArguments = {Integer.toString(userId), Integer.toString(uid)};
        Cursor cursor = db.query("recovery_service_metadata", projection, "user_id = ? AND uid = ?", selectionArguments, null, null, null);
        int count = cursor.getCount();     // Catch: Throwable -> L13
        if (count != 0) goto L9;
        cursor.close();
        return null;
    L9:
        if (count <= 1) goto L15;
        Log.wtf(TAG, String.format(Locale.US, "%d entries found for userId=%d uid=%d. Should only ever be 0 or 1.", new Object[]{Integer.valueOf(count), Integer.valueOf(userId), Integer.valueOf(uid)}));     // Catch: Throwable -> L13
        cursor.close();
        return null;
    L15:
        cursor.moveToFirst();     // Catch: Throwable -> L13
        int idx = cursor.getColumnIndexOrThrow(key);     // Catch: Throwable -> L13
        if (cursor.isNull(idx) == false) goto L19;
        cursor.close();
        return null;
    L19:
        Long r7 = Long.valueOf(cursor.getLong(idx));     // Catch: Throwable -> L13
        cursor.close();
        return r7;
    L13:
        th = move-exception;
        if (cursor == null) goto L31;
        cursor.close();     // Catch: Throwable -> L25
        throw th;
    L25:
        th = move-exception;
        th.addSuppressed(th);
        throw th;
    L31:
        throw th;
    }

    private long setLong(int userId, int uid, String key, long value) {
        SQLiteDatabase db = this.mKeyStoreDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(key, Long.valueOf(value));
        String[] selectionArguments = {Integer.toString(userId), Integer.toString(uid)};
        ensureRecoveryServiceMetadataEntryExists(userId, uid);
        return db.update("recovery_service_metadata", values, "user_id = ? AND uid = ?", selectionArguments);
    }

    private byte[] getBytes(int userId, int uid, String key) {
        SQLiteDatabase db = this.mKeyStoreDbHelper.getReadableDatabase();
        String[] projection = {"_id", "user_id", "uid", key};
        String[] selectionArguments = {Integer.toString(userId), Integer.toString(uid)};
        Cursor cursor = db.query("recovery_service_metadata", projection, "user_id = ? AND uid = ?", selectionArguments, null, null, null);
        int count = cursor.getCount();     // Catch: Throwable -> L13
        if (count != 0) goto L9;
        cursor.close();
        return null;
    L9:
        if (count <= 1) goto L15;
        Log.wtf(TAG, String.format(Locale.US, "%d entries found for userId=%d uid=%d. Should only ever be 0 or 1.", new Object[]{Integer.valueOf(count), Integer.valueOf(userId), Integer.valueOf(uid)}));     // Catch: Throwable -> L13
        cursor.close();
        return null;
    L15:
        cursor.moveToFirst();     // Catch: Throwable -> L13
        int idx = cursor.getColumnIndexOrThrow(key);     // Catch: Throwable -> L13
        if (cursor.isNull(idx) == false) goto L19;
        cursor.close();
        return null;
    L19:
        byte[] r7 = cursor.getBlob(idx);     // Catch: Throwable -> L13
        cursor.close();
        return r7;
    L13:
        th = move-exception;
        if (cursor == null) goto L31;
        cursor.close();     // Catch: Throwable -> L25
        throw th;
    L25:
        th = move-exception;
        th.addSuppressed(th);
        throw th;
    L31:
        throw th;
    }

    private long setBytes(int userId, int uid, String key, byte[] value) {
        SQLiteDatabase db = this.mKeyStoreDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(key, value);
        String[] selectionArguments = {Integer.toString(userId), Integer.toString(uid)};
        ensureRecoveryServiceMetadataEntryExists(userId, uid);
        return db.update("recovery_service_metadata", values, "user_id = ? AND uid = ?", selectionArguments);
    }

    private byte[] getBytes(int userId, int uid, String rootAlias, String key) {
        String rootAlias2 = this.mTestOnlyInsecureCertificateHelper.getDefaultCertificateAliasIfEmpty(rootAlias);
        SQLiteDatabase db = this.mKeyStoreDbHelper.getReadableDatabase();
        String[] projection = {"_id", "user_id", "uid", "root_alias", key};
        String[] selectionArguments = {Integer.toString(userId), Integer.toString(uid), rootAlias2};
        Cursor cursor = db.query("root_of_trust", projection, "user_id = ? AND uid = ? AND root_alias = ?", selectionArguments, null, null, null);
        int count = cursor.getCount();     // Catch: Throwable -> L13
        if (count != 0) goto L9;
        cursor.close();
        return null;
    L9:
        if (count <= 1) goto L15;
        Log.wtf(TAG, String.format(Locale.US, "%d entries found for userId=%d uid=%d. Should only ever be 0 or 1.", new Object[]{Integer.valueOf(count), Integer.valueOf(userId), Integer.valueOf(uid)}));     // Catch: Throwable -> L13
        cursor.close();
        return null;
    L15:
        cursor.moveToFirst();     // Catch: Throwable -> L13
        int idx = cursor.getColumnIndexOrThrow(key);     // Catch: Throwable -> L13
        if (cursor.isNull(idx) == false) goto L19;
        cursor.close();
        return null;
    L19:
        byte[] r9 = cursor.getBlob(idx);     // Catch: Throwable -> L13
        cursor.close();
        return r9;
    L13:
        th = move-exception;
        if (cursor == null) goto L31;
        cursor.close();     // Catch: Throwable -> L25
        throw th;
    L25:
        th = move-exception;
        th.addSuppressed(th);
        throw th;
    L31:
        throw th;
    }

    private long setBytes(int userId, int uid, String rootAlias, String key, byte[] value) {
        String rootAlias2 = this.mTestOnlyInsecureCertificateHelper.getDefaultCertificateAliasIfEmpty(rootAlias);
        SQLiteDatabase db = this.mKeyStoreDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(key, value);
        String[] selectionArguments = {Integer.toString(userId), Integer.toString(uid), rootAlias2};
        ensureRootOfTrustEntryExists(userId, uid, rootAlias2);
        return db.update("root_of_trust", values, "user_id = ? AND uid = ? AND root_alias = ?", selectionArguments);
    }

    private Long getLong(int userId, int uid, String rootAlias, String key) {
        String rootAlias2 = this.mTestOnlyInsecureCertificateHelper.getDefaultCertificateAliasIfEmpty(rootAlias);
        SQLiteDatabase db = this.mKeyStoreDbHelper.getReadableDatabase();
        String[] projection = {"_id", "user_id", "uid", "root_alias", key};
        String[] selectionArguments = {Integer.toString(userId), Integer.toString(uid), rootAlias2};
        Cursor cursor = db.query("root_of_trust", projection, "user_id = ? AND uid = ? AND root_alias = ?", selectionArguments, null, null, null);
        int count = cursor.getCount();     // Catch: Throwable -> L13
        if (count != 0) goto L9;
        cursor.close();
        return null;
    L9:
        if (count <= 1) goto L15;
        Log.wtf(TAG, String.format(Locale.US, "%d entries found for userId=%d uid=%d. Should only ever be 0 or 1.", new Object[]{Integer.valueOf(count), Integer.valueOf(userId), Integer.valueOf(uid)}));     // Catch: Throwable -> L13
        cursor.close();
        return null;
    L15:
        cursor.moveToFirst();     // Catch: Throwable -> L13
        int idx = cursor.getColumnIndexOrThrow(key);     // Catch: Throwable -> L13
        if (cursor.isNull(idx) == false) goto L19;
        cursor.close();
        return null;
    L19:
        Long r9 = Long.valueOf(cursor.getLong(idx));     // Catch: Throwable -> L13
        cursor.close();
        return r9;
    L13:
        th = move-exception;
        if (cursor == null) goto L31;
        cursor.close();     // Catch: Throwable -> L25
        throw th;
    L25:
        th = move-exception;
        th.addSuppressed(th);
        throw th;
    L31:
        throw th;
    }

    private long setLong(int userId, int uid, String rootAlias, String key, long value) {
        String rootAlias2 = this.mTestOnlyInsecureCertificateHelper.getDefaultCertificateAliasIfEmpty(rootAlias);
        SQLiteDatabase db = this.mKeyStoreDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(key, Long.valueOf(value));
        String[] selectionArguments = {Integer.toString(userId), Integer.toString(uid), rootAlias2};
        ensureRootOfTrustEntryExists(userId, uid, rootAlias2);
        return db.update("root_of_trust", values, "user_id = ? AND uid = ? AND root_alias = ?", selectionArguments);
    }

    public void removeUserFromAllTables(int userId) {
        removeUserFromKeysTable(userId);
        removeUserFromUserMetadataTable(userId);
        removeUserFromRecoveryServiceMetadataTable(userId);
        removeUserFromRootOfTrustTable(userId);
    }

    private boolean removeUserFromKeysTable(int userId) {
        SQLiteDatabase db = this.mKeyStoreDbHelper.getWritableDatabase();
        String[] selectionArgs = {Integer.toString(userId)};
        if (db.delete("keys", "user_id = ?", selectionArgs) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean removeUserFromUserMetadataTable(int userId) {
        SQLiteDatabase db = this.mKeyStoreDbHelper.getWritableDatabase();
        String[] selectionArgs = {Integer.toString(userId)};
        if (db.delete("user_metadata", "user_id = ?", selectionArgs) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean removeUserFromRecoveryServiceMetadataTable(int userId) {
        SQLiteDatabase db = this.mKeyStoreDbHelper.getWritableDatabase();
        String[] selectionArgs = {Integer.toString(userId)};
        if (db.delete("recovery_service_metadata", "user_id = ?", selectionArgs) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean removeUserFromRootOfTrustTable(int userId) {
        SQLiteDatabase db = this.mKeyStoreDbHelper.getWritableDatabase();
        String[] selectionArgs = {Integer.toString(userId)};
        if (db.delete("root_of_trust", "user_id = ?", selectionArgs) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private void ensureRecoveryServiceMetadataEntryExists(int userId, int uid) {
        SQLiteDatabase db = this.mKeyStoreDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("user_id", Integer.valueOf(userId));
        values.put("uid", Integer.valueOf(uid));
        db.insertWithOnConflict("recovery_service_metadata", null, values, 4);
    }

    private void ensureRootOfTrustEntryExists(int userId, int uid, String rootAlias) {
        SQLiteDatabase db = this.mKeyStoreDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("user_id", Integer.valueOf(userId));
        values.put("uid", Integer.valueOf(uid));
        values.put("root_alias", rootAlias);
        db.insertWithOnConflict("root_of_trust", null, values, 4);
    }

    private void ensureUserMetadataEntryExists(int userId) {
        SQLiteDatabase db = this.mKeyStoreDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("user_id", Integer.valueOf(userId));
        db.insertWithOnConflict("user_metadata", null, values, 4);
    }

    public void close() {
        this.mKeyStoreDbHelper.close();
    }

    private static PublicKey decodeX509Key(byte[] keyBytes) throws InvalidKeySpecException {
        X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(keyBytes);
        return KeyFactory.getInstance("EC").generatePublic(publicKeySpec);
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private static CertPath decodeCertPath(byte[] bytes) throws CertificateException {
        CertificateFactory certFactory = CertificateFactory.getInstance("X.509");     // Catch: CertificateException -> L5
        return certFactory.generateCertPath(new ByteArrayInputStream(bytes), CERT_PATH_ENCODING);
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }
}
