package com.bytedance.crypto.keymanager;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.crypto.cloudsync.network.CloudConfig;
import com.bytedance.crypto.cloudsync.network.SyncKeyData;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.FrameworkSecurityCompat;
import com.bytedance.crypto.utils.LogUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SyncKeyManager {
    private static final String JSON_TAG_APP_ID = "app_id";
    private static final String JSON_TAG_KEY_INFO_LIST = "key_info_list";
    private static final String JSON_TAG_LATEST_VERSION = "latest_version";
    private static final String KEY_INFO_FILE_NAME = "key_info.xml";
    public static final String TAG = "SyncKeyManager";
    private static volatile SyncKeyManager keyManager;
    private volatile HashMap<String, Integer> keyVersionMap;

    public SyncKeyManager() {
        this.keyVersionMap = new HashMap();
    }

    private synchronized int deleteVersionMap(Context r5) {
        monitor-enter(this);
        String r6 = ((Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin")).getFilesDir().getAbsolutePath() + "/" + KEY_INFO_FILE_NAME;     // Catch: Throwable -> L11
        String r0 = TAG;     // Catch: Throwable -> L11
        LogUtils.d(r0, "key_info file path:" + r6);     // Catch: Throwable -> L11
        File r1 = new File(r6);     // Catch: Throwable -> L11
        if (r1.exists() == true) goto L8;
        LogUtils.e(r0, "File not exist:" + r6 + ", need create!!");     // Catch: Throwable -> L11
        monitor-exit(this);
        return 0;
    L8:
        r1.delete();     // Catch: Throwable -> L11
        monitor-exit(this);
        return 0;
    L11:
        th = move-exception;
        throw th;
    }

    public static SyncKeyManager getInstance() {
        if (keyManager != null) goto L15;
        monitor-enter(SyncKeyManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (keyManager != null) goto L9;
        keyManager = new SyncKeyManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(SyncKeyManager.class);     // Catch: Throwable -> L11
    L15:
        return keyManager;
    }

    private synchronized int importToVersionMap(Context r8, List<SyncKeyData> r9) {
        monitor-enter(this);
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        Iterator r11 = ((List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L20
        boolean r2 = false;
    L5:
        if (r11.hasNext() == false) goto L13;
        SyncKeyData r3 = (SyncKeyData) ZeusTransformUtils.preCheckCast(r11.next(), SyncKeyData.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        if (this.keyVersionMap.containsKey(r3.getAppId()) == false) goto L11;
        if (r3.getKeyVersion() <= ((Integer) ZeusTransformUtils.preCheckCast(this.keyVersionMap.get(r3.getAppId()), Integer.class, "com.obric.aiagent.plugin")).intValue()) goto L5;
        this.keyVersionMap.replace(r3.getAppId(), Integer.valueOf(r3.getKeyVersion()));     // Catch: Throwable -> L20
    L12:
        r2 = true;
        goto L5
    L11:
        this.keyVersionMap.put(r3.getAppId(), Integer.valueOf(r3.getKeyVersion()));     // Catch: Throwable -> L20
        goto L12
    L13:
        if (r2 == false) goto L17;
        int r12 = writeVersionMap(r10);     // Catch: Throwable -> L20
        monitor-exit(this);
        return r12;
    L17:
        LogUtils.i(TAG, "Key info exist, no need to update.");     // Catch: Throwable -> L20
        monitor-exit(this);
        return 0;
    L20:
        th = move-exception;
        throw th;
    }

    private int preHandleForXcrypt(Context r3, String r4, byte[] r5, String r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L5;
    L24:
        String r2 = TAG;
        String r8 = "Input param is empty!!";
    L22:
        LogUtils.e(r2, r8);
        return -2;
    L5:
        if (TextUtils.isEmpty(r4) == true) goto L24;
        if (TextUtils.isEmpty(r6) == true) goto L24;
        if (r5 != null) goto L11;
    L21:
        r2 = TAG;
        r8 = "Input data is empty!!";
        goto L22
    L11:
        if (r5.length == 0) goto L21;
        if (this.keyVersionMap.isEmpty() == false) goto L19;
        int r9 = readVersionMap(r7);
        if (r9 == 0) goto L25;
        LogUtils.e(TAG, "Read version map failed!! errorCode:" + r9);
        return r9;
    L25:
        return 0;
    L19:
        return 0;
    }

    private synchronized int readVersionMap(Context r9) {
        monitor-enter(this);
        String r10 = ((Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin")).getFilesDir().getAbsolutePath() + "/" + KEY_INFO_FILE_NAME;     // Catch: Throwable -> L38
        String r0 = TAG;     // Catch: Throwable -> L38
        LogUtils.d(r0, "key_info file path:" + r10);     // Catch: Throwable -> L38
        if (new File(r10).exists() == true) goto L43;
        LogUtils.e(r0, "file not exist:" + r10);     // Catch: Throwable -> L38
        int r11 = -5;
    L7:
        monitor-exit(this);
        return r11;
    L43:
        FileInputStream r1 = new FileInputStream(r10);     // Catch: Exception -> L35 Throwable -> L38
        byte[] r12 = new byte[4096];     // Catch: Throwable -> L29
        r1.read(r12);     // Catch: Throwable -> L29
        JSONArray r2 = new JSONArray(new JSONObject(new String(r12, StandardCharsets.UTF_8)).getString(JSON_TAG_KEY_INFO_LIST));     // Catch: Throwable -> L29
        int r3 = 0;
    L13:
        if (r3 >= r2.length()) goto L21;
        JSONObject r4 = r2.getJSONObject(r3);     // Catch: Throwable -> L29
        String r5 = r4.getString("app_id");     // Catch: Throwable -> L29
        int r6 = r4.getInt(JSON_TAG_LATEST_VERSION);     // Catch: Throwable -> L29
        if (this.keyVersionMap.containsKey(r5) == true) goto L17;
        this.keyVersionMap.put(r5, Integer.valueOf(r6));     // Catch: Throwable -> L29
    L20:
        r3 = r3 + 1;     // Catch: Throwable -> L29
        goto L13
    L17:
        if (r6 <= ((Integer) ZeusTransformUtils.preCheckCast(this.keyVersionMap.get(r5), Integer.class, "com.obric.aiagent.plugin")).intValue()) goto L20;
        this.keyVersionMap.replace(r5, Integer.valueOf(r6));     // Catch: Throwable -> L29
        goto L20
    L21:
        Iterator<String> r7 = this.keyVersionMap.keySet().iterator();     // Catch: Throwable -> L29
    L22:
        if (r7.hasNext() == false) goto L26;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L29
        LogUtils.i(TAG, "keyVersionMap key:" + r8 + " version:" + this.keyVersionMap.get(r8));     // Catch: Throwable -> L29
        goto L22
    L26:
        r1.close();     // Catch: Exception -> L35 Throwable -> L38
        monitor-exit(this);
        return 0;
    L29:
        th = move-exception;
        r1.close();     // Catch: Throwable -> L32
    L34:
        throw th;     // Catch: Exception -> L35 Throwable -> L38
    L32:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L35 Throwable -> L38
    L35:
        e = move-exception;
        LogUtils.e(TAG, "Parse key_info file failed, error:" + e.getMessage());     // Catch: Throwable -> L38
        r11 = -100;
    L38:
        th = move-exception;
        throw th;
    }

    private synchronized int removeFromVersionMap(Context r3, String r4) {
        monitor-enter(this);
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        if (this.keyVersionMap.containsKey(r4) == true) goto L9;
        LogUtils.e(TAG, "AppId not in version map!! appId:" + r4);     // Catch: Throwable -> L17
        monitor-exit(this);
        return -5;
    L9:
        this.keyVersionMap.remove(r4);     // Catch: Throwable -> L17
        if (this.keyVersionMap.isEmpty() == false) goto L14;
        int r6 = deleteVersionMap(r5);     // Catch: Throwable -> L17
        monitor-exit(this);
        return r6;
    L14:
        int r7 = writeVersionMap(r5);     // Catch: Throwable -> L17
        monitor-exit(this);
        return r7;
    L17:
        th = move-exception;
        throw th;
    }

    private String versionMapToJson() {
        if (this.keyVersionMap.isEmpty() == false) goto L15;
        LogUtils.e(TAG, "Key version map is empty!!!");
        return "";
    L15:
        JSONArray r0 = new JSONArray();     // Catch: Exception -> L12
        Iterator<String> r2 = this.keyVersionMap.keySet().iterator();     // Catch: Exception -> L12
    L8:
        if (r2.hasNext() == false) goto L10;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L12
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L12
        r4.put("app_id", r3);     // Catch: Exception -> L12
        r4.put(JSON_TAG_LATEST_VERSION, this.keyVersionMap.get(r3));     // Catch: Exception -> L12
        r0.put(r4);     // Catch: Exception -> L12
        goto L8
    L10:
        JSONObject r7 = new JSONObject();     // Catch: Exception -> L12
        r7.put(JSON_TAG_KEY_INFO_LIST, r0);     // Catch: Exception -> L12
        return r7.toString();
    L12:
        e = move-exception;
        LogUtils.e(TAG, "Version map to json failed, error:" + e.getMessage());
        return "";
    }

    private synchronized int writeVersionMap(Context r4) {
        monitor-enter(this);
        String r5 = ((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin")).getFilesDir().getAbsolutePath() + "/" + KEY_INFO_FILE_NAME;     // Catch: Throwable -> L22
        String r0 = TAG;     // Catch: Throwable -> L22
        LogUtils.d(r0, "key_info file path:" + r5);     // Catch: Throwable -> L22
        if (new File(r5).exists() == true) goto L6;
        LogUtils.e(r0, "File not exist:" + r5 + ", need create!!");     // Catch: Throwable -> L22
    L6:
        String r1 = versionMapToJson();     // Catch: Throwable -> L22
        FileOutputStream r2 = new FileOutputStream(r5);     // Catch: Exception -> L19 Throwable -> L22
        r2.write(r1.getBytes(StandardCharsets.UTF_8));     // Catch: Throwable -> L13
        r2.flush();     // Catch: Throwable -> L13
        r2.close();     // Catch: Exception -> L19 Throwable -> L22
        int r6 = 0;
    L11:
        monitor-exit(this);
        return r6;
    L13:
        th = move-exception;
        r2.close();     // Catch: Throwable -> L16
    L18:
        throw th;     // Catch: Exception -> L19 Throwable -> L22
    L16:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L19 Throwable -> L22
    L19:
        e = move-exception;
        LogUtils.e(TAG, "Write json data failed, error:" + e.getMessage());     // Catch: Throwable -> L22
        r6 = -100;
    L22:
        th = move-exception;
        throw th;
    }

    public byte[] decryptByKeyManager(Context r7, String r8, byte[] r9, String r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        String r0 = TAG;
        LogUtils.i(r0, "Decrypt enter, appId:" + r8);
        LogUtils.d(r0, "Decrypt enter, aad:" + r10);
        if (preHandleForXcrypt(r11, r8, r9, r10) == 0) goto L6;
        LogUtils.e(r0, "Pre handle for Decrypt failed!!");
        return new byte[0];
    L6:
        byte[] r4 = new byte[4];
        if (r9.length >= 4) goto L10;
        LogUtils.e(r0, "Input data len is too short! len:" + r9.length);
        return new byte[0];
    L10:
        System.arraycopy(r9, 0, r4, 0, 4);
        int r5 = CryptoUtils.byteArrayToInt(r4);
        if (r5 == 317657839) goto L15;
        LogUtils.e(r0, "Cannot parse input cipher data! magic:" + r5);
        return new byte[0];
    L15:
        if (r9.length >= 5) goto L18;
        LogUtils.e(r0, "Input data len is too short!! len:" + r9.length);
        return new byte[0];
    L18:
        int r2 = Byte.toUnsignedInt(r9[4]);
        if (r2 <= ((Integer) ZeusTransformUtils.preCheckCast(this.keyVersionMap.get(r8), Integer.class, "com.obric.aiagent.plugin")).intValue()) goto L22;
        LogUtils.e(r0, "Input cipher data version is wrong! version:" + r2);
        return new byte[0];
    L22:
        LogUtils.i(r0, "Decrypt enter, keyVersion:" + r2);
        if (r9.length >= 21) goto L26;
        LogUtils.e(r0, "Input data len is too short for data cipher! len:" + r9.length);
        return new byte[0];
    L26:
        int r6 = r9.length - 5;
        byte[] r1 = new byte[r6];
        System.arraycopy(r9, 5, r1, 0, r6);
        Bundle r12 = new Bundle();
        r12.putString(FrameworkSecurityCompat.KeyManagerConst.ADDITIONAL_DATA(), r10);
        r12.putString(FrameworkSecurityCompat.KeyManagerConst.KEY_ALIAS(), r8 + "_" + r2);
        FrameworkSecurityCompat.KmResult r13 = FrameworkSecurityCompat.xcrypt(r11, 1, r1, r12);
        if (r13.getResultCode() == FrameworkSecurityCompat.KeyManagerErrorCode.KM_SUCCESS()) goto L30;
        LogUtils.e(r0, "Decrypt failed, error code:" + r13.getResultCode());
        return new byte[0];
    L30:
        LogUtils.i(r0, "Decrypt succeed, out data len:" + r13.getOutData().length);
        return r13.getOutData();
    }

    public int deleteSyncKey(Context r9, String r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        if (r11 != null) goto L5;
    L28:
        LogUtils.e(TAG, "Input param is empty!!");
        return -2;
    L5:
        if (TextUtils.isEmpty(r10) == true) goto L28;
        if (this.keyVersionMap.isEmpty() == false) goto L13;
        int r0 = readVersionMap(r11);
        if (r0 == 0) goto L13;
        LogUtils.e(TAG, "Read version map failed!! errorCode:" + r0);
        return r0;
    L13:
        boolean r3 = true;
        if (this.keyVersionMap.containsKey(r10) == false) goto L23;
        int r1 = ((Integer) ZeusTransformUtils.preCheckCast(this.keyVersionMap.get(r10), Integer.class, "com.obric.aiagent.plugin")).intValue();
    L16:
        if (r1 < 1) goto L21;
        String r2 = r10 + "_" + r1;
        int r4 = FrameworkSecurityCompat.deleteSyncKey(r11, r2);
        LogUtils.i(TAG, "delete sync key, keyAlias:" + r2 + " package:" + r11.getPackageName() + " ret:" + r4);
        if (r4 != FrameworkSecurityCompat.KeyManagerErrorCode.KM_SUCCESS()) goto L19;
        r1 = r1 - 1;
        goto L16
    L19:
        r3 = false;
    L21:
        if (r3 == false) goto L24;
        removeFromVersionMap(r11, r10);
    L24:
        if (r3 == true) goto L32;
        return -100;
    L32:
        return 0;
    L23:
        LogUtils.e(TAG, "Key version map find app failed!! appId:" + r10);
        goto L24
    }

    public byte[] encryptByKeyManager(Context r6, String r7, byte[] r8, String r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        String r0 = TAG;
        LogUtils.i(r0, "Encrypt enter, keyAlias:" + r7);
        LogUtils.d(r0, "Encrypt enter, aad:" + r9);
        if (preHandleForXcrypt(r10, r7, r8, r9) == 0) goto L7;
        String r5 = "Pre handle for Encrypt failed!!";
    L5:
        LogUtils.e(r0, r5);
        return new byte[0];
    L7:
        Bundle r2 = new Bundle();
        r2.putString(FrameworkSecurityCompat.KeyManagerConst.ADDITIONAL_DATA(), r9);
        int r11 = ((Integer) ZeusTransformUtils.preCheckCast(this.keyVersionMap.get(r7), Integer.class, "com.obric.aiagent.plugin")).intValue();
        LogUtils.i(r0, "Encrypt enter, keyVersion:" + r11);
        r2.putString(FrameworkSecurityCompat.KeyManagerConst.KEY_ALIAS(), r7 + "_" + r11);
        FrameworkSecurityCompat.KmResult r12 = FrameworkSecurityCompat.xcrypt(r10, 0, r8, r2);
        if (r12.getResultCode() == FrameworkSecurityCompat.KeyManagerErrorCode.KM_SUCCESS()) goto L10;
        r5 = "Encrypt failed, error code:" + r12.getResultCode();
        goto L5
    L10:
        LogUtils.i(r0, "Encrypt succeed, out data len:" + r12.getOutData().length);
        byte[] r13 = new byte[r12.getOutData().length + 5];
        System.arraycopy(CryptoUtils.intToBytes(CryptoConst.BYTES_KEY_CIPHER_MAGIC_NUM), 0, r13, 0, 4);
        r13[4] = (byte) r11;
        System.arraycopy(r12.getOutData(), 0, r13, 5, r12.getOutData().length);
        return r13;
    }

    public boolean importSyncKey(Context r9, List<SyncKeyData> r10, String r11, String r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        List<SyncKeyData> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        if (r13 != null) goto L5;
    L36:
        LogUtils.e(TAG, "Input param is empty!!");
        return false;
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L36;
        if (TextUtils.isEmpty(r12) == true) goto L36;
        if (r14 != null) goto L11;
    L34:
        LogUtils.e(TAG, "Key data list is empty!!");
        return false;
    L11:
        if (r14.isEmpty() == true) goto L34;
        if (this.keyVersionMap.isEmpty() == false) goto L21;
        int r2 = readVersionMap(r13);
        if (r2 == 0) goto L21;
        if (r2 == (-5)) goto L21;
        LogUtils.e(TAG, "Read version map failed!! errorCode:" + r2);
        return false;
    L21:
        Iterator<SyncKeyData> r3 = r14.iterator();
    L23:
        if (r3.hasNext() == false) goto L29;
        SyncKeyData r4 = (SyncKeyData) ZeusTransformUtils.preCheckCast(r3.next(), SyncKeyData.class, "com.obric.aiagent.plugin");
        Bundle r5 = new Bundle();
        String r6 = TAG;
        LogUtils.i(r6, "Import key enter, appid:" + r4.getAppId() + " key version:" + r4.getKeyVersion());
        LogUtils.d(r6, "Import key enter, attKeyAlias:" + r12);
        LogUtils.d(r6, "Import key enter, serverPubKey:" + r11);
        LogUtils.d(r6, "Import key enter, SyncKeyCipher:" + r4.getSyncKeyCipher());
        r5.putString(FrameworkSecurityCompat.KeyManagerConst.KEY_ALIAS(), r4.getAppId() + "_" + r4.getKeyVersion());
        r5.putString("attest_key_alias", r12);
        r5.putString(FrameworkSecurityCompat.KeyManagerConst.ECC_PUBLIC_KEY(), r11);
        r5.putString(FrameworkSecurityCompat.KeyManagerConst.WRAPPED_KEY_DATA(), r4.getSyncKeyCipher());
        String r7 = CloudConfig.getInstance().getPkgName(r4.getAppId());
        r5.putString(FrameworkSecurityCompat.KeyManagerConst.ADDITIONAL_DATA(), r7);
        LogUtils.d(r6, "Import key enter, aad:" + r7);
        int r8 = FrameworkSecurityCompat.importKey(r13, r5);
        if (r8 == FrameworkSecurityCompat.KeyManagerErrorCode.KM_SUCCESS()) goto L23;
        LogUtils.e(r6, "Import key failed, error code:" + r8);
        return false;
    L29:
        if (importToVersionMap(r13, r14) == 0) goto L32;
        LogUtils.e(TAG, "Update version map failed!!");
        return false;
    L32:
        return true;
    }

    public boolean importSyncKeyLegacy(Context r9, List<SyncKeyData> r10, String r11, String r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        List<SyncKeyData> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        if (r13 != null) goto L5;
    L36:
        LogUtils.e(TAG, "Input param is empty!! legacy.");
        return false;
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L36;
        if (TextUtils.isEmpty(r12) == true) goto L36;
        if (r14 != null) goto L11;
    L34:
        LogUtils.e(TAG, "Key data list is empty!! legacy.");
        return false;
    L11:
        if (r14.isEmpty() == true) goto L34;
        if (this.keyVersionMap.isEmpty() == false) goto L21;
        int r2 = readVersionMap(r13);
        if (r2 == 0) goto L21;
        if (r2 == (-5)) goto L21;
        LogUtils.e(TAG, "Read version map failed!!  legacy errorCode:" + r2);
        return false;
    L21:
        Iterator<SyncKeyData> r3 = r14.iterator();
    L23:
        if (r3.hasNext() == false) goto L29;
        SyncKeyData r4 = (SyncKeyData) ZeusTransformUtils.preCheckCast(r3.next(), SyncKeyData.class, "com.obric.aiagent.plugin");
        Bundle r5 = new Bundle();
        String r6 = TAG;
        LogUtils.i(r6, "Import key legacy enter, appid:" + r4.getAppId() + " key version:" + r4.getKeyVersion());
        LogUtils.d(r6, "Import key enter, localPrivKey:" + r12);
        LogUtils.d(r6, "Import key enter, serverPubKey:" + r11);
        LogUtils.d(r6, "Import key enter, SyncKeyCipher:" + r4.getSyncKeyCipher());
        r5.putString(FrameworkSecurityCompat.KeyManagerConst.KEY_ALIAS(), r4.getAppId() + "_" + r4.getKeyVersion());
        r5.putString(FrameworkSecurityCompat.KeyManagerConst.ECC_PRIVATE_KEY(), r12);
        r5.putString(FrameworkSecurityCompat.KeyManagerConst.ECC_PUBLIC_KEY(), r11);
        r5.putString(FrameworkSecurityCompat.KeyManagerConst.WRAPPED_KEY_DATA(), r4.getSyncKeyCipher());
        String r7 = CloudConfig.getInstance().getPkgName(r4.getAppId());
        r5.putString(FrameworkSecurityCompat.KeyManagerConst.ADDITIONAL_DATA(), r7);
        LogUtils.d(r6, "Import key legacy enter, aad:" + r7);
        int r8 = FrameworkSecurityCompat.importKeyLegacy(r13, r5);
        if (r8 == FrameworkSecurityCompat.KeyManagerErrorCode.KM_SUCCESS()) goto L23;
        LogUtils.e(r6, "Import key legacy failed, error code:" + r8);
        return false;
    L29:
        if (importToVersionMap(r13, r14) == 0) goto L32;
        LogUtils.e(TAG, "Update version map failed!! legacy.");
        return false;
    L32:
        return true;
    }
}
