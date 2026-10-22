package com.android.server.locksettings;

import android.R;
import android.app.admin.PasswordMetrics;
import android.content.Context;
import android.content.pm.UserInfo;
import android.hardware.weaver.IWeaver;
import android.hardware.weaver.WeaverConfig;
import android.hardware.weaver.WeaverReadResponse;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.ServiceSpecificException;
import android.os.UserManager;
import android.provider.Settings;
import android.security.Scrypt;
import android.service.gatekeeper.GateKeeperResponse;
import android.service.gatekeeper.IGateKeeperService;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Slog;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.Preconditions;
import com.android.internal.widget.ICheckCredentialProgressCallback;
import com.android.internal.widget.IWeakEscrowTokenRemovedListener;
import com.android.internal.widget.LockPatternUtils;
import com.android.internal.widget.LockscreenCredential;
import com.android.internal.widget.VerifyCredentialResponse;
import com.android.server.utils.Slogf;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import libcore.util.HexEncoding;
import org.apache.commons.compress.compressors.bzip2.BZip2Constants;

/* JADX INFO: loaded from: classes2.dex */
class SyntheticPasswordManager {
    private static final byte[] DEFAULT_PASSWORD = null;
    private static final int INVALID_WEAVER_SLOT = -1;
    public static final long NULL_PROTECTOR_ID = 0;
    private static final String PASSWORD_DATA_NAME = "pwd";
    private static final String PASSWORD_METRICS_NAME = "metrics";
    private static final int PASSWORD_SALT_LENGTH = 16;
    private static final int PASSWORD_SCRYPT_LOG_N = 11;
    private static final int PASSWORD_SCRYPT_LOG_P = 1;
    private static final int PASSWORD_SCRYPT_LOG_R = 3;
    private static final byte[] PERSONALIZATION_AUTHSECRET_ENCRYPTION_KEY = null;
    private static final byte[] PERSONALIZATION_AUTHSECRET_KEY = null;
    private static final byte[] PERSONALIZATION_CONTEXT = null;
    private static final byte[] PERSONALIZATION_E0 = null;
    private static final byte[] PERSONALIZATION_FBE_KEY = null;
    private static final byte[] PERSONALIZATION_KEY_STORE_PASSWORD = null;
    private static final byte[] PERSONALIZATION_PASSWORD_HASH = null;
    private static final byte[] PERSONALIZATION_PASSWORD_METRICS = null;
    private static final byte[] PERSONALIZATION_SECDISCARDABLE = null;
    private static final byte[] PERSONALIZATION_SP_GK_AUTH = null;
    private static final byte[] PERSONALIZATION_SP_SPLIT = null;
    private static final byte[] PERSONALIZATION_USER_GK_AUTH = null;
    private static final byte[] PERSONALIZATION_WEAVER_KEY = null;
    private static final byte[] PERSONALIZATION_WEAVER_PASSWORD = null;
    private static final byte[] PERSONALIZATION_WEAVER_TOKEN = null;
    private static final String PROTECTOR_KEY_ALIAS_PREFIX = "synthetic_password_";
    private static final byte PROTECTOR_TYPE_LSKF_BASED = 0;
    private static final byte PROTECTOR_TYPE_STRONG_TOKEN_BASED = 1;
    private static final byte PROTECTOR_TYPE_WEAK_TOKEN_BASED = 2;
    private static final int SECDISCARDABLE_LENGTH = 16384;
    private static final String SECDISCARDABLE_NAME = "secdis";
    private static final String SP_BLOB_NAME = "spblob";
    private static final String SP_E0_NAME = "e0";
    private static final String SP_HANDLE_NAME = "handle";
    private static final String SP_P1_NAME = "p1";
    private static final int STRETCHED_LSKF_LENGTH = 32;
    private static final int SYNTHETIC_PASSWORD_SECURITY_STRENGTH = 32;
    private static final byte SYNTHETIC_PASSWORD_VERSION_V1 = 1;
    private static final byte SYNTHETIC_PASSWORD_VERSION_V2 = 2;
    private static final byte SYNTHETIC_PASSWORD_VERSION_V3 = 3;
    private static final String TAG = "SyntheticPasswordManager";
    static final int TOKEN_TYPE_STRONG = 0;
    static final int TOKEN_TYPE_WEAK = 1;
    private static final String VENDOR_AUTH_SECRET_NAME = "vendor_auth_secret";
    private static final String WEAVER_SLOT_NAME = "weaver";
    private static final byte WEAVER_VERSION = 1;
    private final Context mContext;
    private final RemoteCallbackList<IWeakEscrowTokenRemovedListener> mListeners;
    private PasswordSlotManager mPasswordSlotManager;
    private LockSettingsStorage mStorage;
    private final UserManager mUserManager;
    private volatile IWeaver mWeaver;
    private WeaverConfig mWeaverConfig;
    private ArrayMap<Integer, ArrayMap<Long, TokenData>> tokenMap;

    static class AuthenticationResult {
        public VerifyCredentialResponse gkResponse;
        public SyntheticPassword syntheticPassword;
        public boolean usedWeaver;

        AuthenticationResult() {
        }
    }

    static class PasswordData {
        public int credentialType;
        public byte[] passwordHandle;
        public int pinLength;
        byte[] salt;
        byte scryptLogN;
        byte scryptLogP;
        byte scryptLogR;

        PasswordData() {
        }

        public static PasswordData create(int credentialType, int pinLength) {
            PasswordData result = new PasswordData();
            result.scryptLogN = 11;
            result.scryptLogR = 3;
            result.scryptLogP = 1;
            result.credentialType = credentialType;
            result.pinLength = pinLength;
            result.salt = SecureRandomUtils.randomBytes(16);
            return result;
        }

        public static boolean isBadFormatFromAndroid14Beta(byte[] data) {
            if (data != null) goto L5;
            return false;
        L5:
            if (data.length >= 2) goto L7;
            return false;
        L7:
            if (data[0] == 0) goto L9;
            return false;
        L9:
            if (data[1] == 2) goto L11;
            return false;
        L11:
            return true;
        }

        public static PasswordData fromBytes(byte[] data) {
            PasswordData result = new PasswordData();
            ByteBuffer buffer = ByteBuffer.allocate(data.length);
            buffer.put(data, 0, data.length);
            buffer.flip();
            result.credentialType = (short) buffer.getInt();
            result.scryptLogN = buffer.get();
            result.scryptLogR = buffer.get();
            result.scryptLogP = buffer.get();
            int saltLen = buffer.getInt();
            result.salt = new byte[saltLen];
            buffer.get(result.salt);
            int handleLen = buffer.getInt();
            if (handleLen <= 0) goto L5;
            result.passwordHandle = new byte[handleLen];
            buffer.get(result.passwordHandle);
        L7:
            if (buffer.remaining() < 4) goto L9;
            result.pinLength = buffer.getInt();
        L10:
            return result;
        L9:
            result.pinLength = -1;
            goto L10
        L5:
            result.passwordHandle = null;
            goto L7
        }

        public byte[] toBytes() {
            int r0 = (this.salt.length + 11) + 4;
            if (this.passwordHandle == null) goto L5;
            int r1 = this.passwordHandle.length;
        L6:
            ByteBuffer buffer = ByteBuffer.allocate((r0 + r1) + 4);
            if (this.credentialType < (-32768)) goto L19;
            if (this.credentialType > 32767) goto L19;
            buffer.putInt(this.credentialType);
            buffer.put(this.scryptLogN);
            buffer.put(this.scryptLogR);
            buffer.put(this.scryptLogP);
            buffer.putInt(this.salt.length);
            buffer.put(this.salt);
            if (this.passwordHandle != null) goto L13;
        L15:
            buffer.putInt(0);
        L16:
            buffer.putInt(this.pinLength);
            return buffer.array();
        L13:
            if (this.passwordHandle.length <= 0) goto L15;
            buffer.putInt(this.passwordHandle.length);
            buffer.put(this.passwordHandle);
        L19:
            throw new IllegalArgumentException("Unknown credential type: " + this.credentialType);
        L5:
            r1 = 0;
            goto L6
        }
    }

    static class SyntheticPassword {
        private byte[] mEncryptedEscrowSplit0;
        private byte[] mEscrowSplit1;
        private byte[] mSyntheticPassword;
        private final byte mVersion;

        /* JADX INFO: renamed from: -$$Nest$fgetmEncryptedEscrowSplit0, reason: not valid java name */
        static /* bridge */ /* synthetic */ byte[] m5486$$Nest$fgetmEncryptedEscrowSplit0(SyntheticPassword r0) {
            return r0.mEncryptedEscrowSplit0;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmEscrowSplit1, reason: not valid java name */
        static /* bridge */ /* synthetic */ byte[] m5487$$Nest$fgetmEscrowSplit1(SyntheticPassword r0) {
            return r0.mEscrowSplit1;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmVersion, reason: not valid java name */
        static /* bridge */ /* synthetic */ byte m5488$$Nest$fgetmVersion(SyntheticPassword r0) {
            return r0.mVersion;
        }

        SyntheticPassword(byte version) {
            this.mVersion = version;
        }

        private byte[] deriveSubkey(byte[] personalization) {
            if (this.mVersion != 3) goto L7;
            return new SP800Derive(this.mSyntheticPassword).withContext(personalization, SyntheticPasswordManager.m5478$$Nest$sfgetPERSONALIZATION_CONTEXT());
        L7:
            return SyntheticPasswordCrypto.personalizedHash(personalization, new byte[][]{this.mSyntheticPassword});
        }

        public byte[] deriveKeyStorePassword() {
            return SyntheticPasswordManager.bytesToHex(deriveSubkey(SyntheticPasswordManager.m5481$$Nest$sfgetPERSONALIZATION_KEY_STORE_PASSWORD()));
        }

        public byte[] deriveGkPassword() {
            return deriveSubkey(SyntheticPasswordManager.m5484$$Nest$sfgetPERSONALIZATION_SP_GK_AUTH());
        }

        public byte[] deriveFileBasedEncryptionKey() {
            return deriveSubkey(SyntheticPasswordManager.m5480$$Nest$sfgetPERSONALIZATION_FBE_KEY());
        }

        public byte[] deriveVendorAuthSecret() {
            return deriveSubkey(SyntheticPasswordManager.m5477$$Nest$sfgetPERSONALIZATION_AUTHSECRET_KEY());
        }

        public byte[] derivePasswordHashFactor() {
            return deriveSubkey(SyntheticPasswordManager.m5482$$Nest$sfgetPERSONALIZATION_PASSWORD_HASH());
        }

        public byte[] deriveMetricsKey() {
            return deriveSubkey(SyntheticPasswordManager.m5483$$Nest$sfgetPERSONALIZATION_PASSWORD_METRICS());
        }

        public byte[] deriveVendorAuthSecretEncryptionKey() {
            return deriveSubkey(SyntheticPasswordManager.m5476$$Nest$sfgetPERSONALIZATION_AUTHSECRET_ENCRYPTION_KEY());
        }

        public void setEscrowData(byte[] encryptedEscrowSplit0, byte[] escrowSplit1) {
            this.mEncryptedEscrowSplit0 = encryptedEscrowSplit0;
            this.mEscrowSplit1 = escrowSplit1;
        }

        public void recreateFromEscrow(byte[] escrowSplit0) {
            this.mEscrowSplit1.getClass();
            this.mEncryptedEscrowSplit0.getClass();
            recreate(escrowSplit0, this.mEscrowSplit1);
        }

        public void recreateDirectly(byte[] syntheticPassword) {
            this.mSyntheticPassword = Arrays.copyOf(syntheticPassword, syntheticPassword.length);
        }

        static SyntheticPassword create() {
            SyntheticPassword result = new SyntheticPassword((byte) 3);
            byte[] escrowSplit0 = SecureRandomUtils.randomBytes(32);
            byte[] escrowSplit1 = SecureRandomUtils.randomBytes(32);
            result.recreate(escrowSplit0, escrowSplit1);
            byte[] encrypteEscrowSplit0 = SyntheticPasswordCrypto.encrypt(result.mSyntheticPassword, SyntheticPasswordManager.m5479$$Nest$sfgetPERSONALIZATION_E0(), escrowSplit0);
            result.setEscrowData(encrypteEscrowSplit0, escrowSplit1);
            return result;
        }

        private void recreate(byte[] escrowSplit0, byte[] escrowSplit1) {
            this.mSyntheticPassword = SyntheticPasswordManager.bytesToHex(SyntheticPasswordCrypto.personalizedHash(SyntheticPasswordManager.m5485$$Nest$sfgetPERSONALIZATION_SP_SPLIT(), new byte[][]{escrowSplit0, escrowSplit1}));
        }

        public byte[] getEscrowSecret() {
            if (this.mEncryptedEscrowSplit0 != null) goto L7;
            return null;
        L7:
            return SyntheticPasswordCrypto.decrypt(this.mSyntheticPassword, SyntheticPasswordManager.m5479$$Nest$sfgetPERSONALIZATION_E0(), this.mEncryptedEscrowSplit0);
        }

        public byte[] getSyntheticPassword() {
            return this.mSyntheticPassword;
        }

        public byte getVersion() {
            return this.mVersion;
        }
    }

    private static class SyntheticPasswordBlob {
        byte[] mContent;
        byte mProtectorType;
        byte mVersion;

        private SyntheticPasswordBlob() {
        }

        public static SyntheticPasswordBlob create(byte version, byte protectorType, byte[] content) {
            SyntheticPasswordBlob result = new SyntheticPasswordBlob();
            result.mVersion = version;
            result.mProtectorType = protectorType;
            result.mContent = content;
            return result;
        }

        public static SyntheticPasswordBlob fromBytes(byte[] data) {
            SyntheticPasswordBlob result = new SyntheticPasswordBlob();
            result.mVersion = data[0];
            result.mProtectorType = data[1];
            result.mContent = Arrays.copyOfRange(data, 2, data.length);
            return result;
        }

        public byte[] toByte() {
            byte[] blob = new byte[(this.mContent.length + 1) + 1];
            blob[0] = this.mVersion;
            blob[1] = this.mProtectorType;
            System.arraycopy(this.mContent, 0, blob, 2, this.mContent.length);
            return blob;
        }
    }

    private static class TokenData {
        byte[] aggregatedSecret;
        LockPatternUtils.EscrowTokenStateChangeCallback mCallback;
        int mType;
        byte[] secdiscardableOnDisk;
        byte[] weaverSecret;

        /* synthetic */ TokenData(SyntheticPasswordManagerIA r1) {
            this();
        }

        private TokenData() {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface TokenType {
    }

    private class WeaverDiedRecipient implements IBinder.DeathRecipient {
        final /* synthetic */ SyntheticPasswordManager this$0;

        /* synthetic */ WeaverDiedRecipient(SyntheticPasswordManager r1, SyntheticPasswordManagerIA r2) {
            this(r1);
        }

        private WeaverDiedRecipient(SyntheticPasswordManager r1) {
            this.this$0 = r1;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Slog.wtf(SyntheticPasswordManager.TAG, "Weaver service has died");
            SyntheticPasswordManager.m5474$$Nest$fgetmWeaver(this.this$0).asBinder().unlinkToDeath(this, 0);
            SyntheticPasswordManager.m5475$$Nest$fputmWeaver(this.this$0, null);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWeaver, reason: not valid java name */
    static /* bridge */ /* synthetic */ IWeaver m5474$$Nest$fgetmWeaver(SyntheticPasswordManager r0) {
        return r0.mWeaver;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmWeaver, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5475$$Nest$fputmWeaver(SyntheticPasswordManager r0, IWeaver r1) {
        r0.mWeaver = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetPERSONALIZATION_AUTHSECRET_ENCRYPTION_KEY, reason: not valid java name */
    static /* bridge */ /* synthetic */ byte[] m5476$$Nest$sfgetPERSONALIZATION_AUTHSECRET_ENCRYPTION_KEY() {
        return PERSONALIZATION_AUTHSECRET_ENCRYPTION_KEY;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetPERSONALIZATION_AUTHSECRET_KEY, reason: not valid java name */
    static /* bridge */ /* synthetic */ byte[] m5477$$Nest$sfgetPERSONALIZATION_AUTHSECRET_KEY() {
        return PERSONALIZATION_AUTHSECRET_KEY;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetPERSONALIZATION_CONTEXT, reason: not valid java name */
    static /* bridge */ /* synthetic */ byte[] m5478$$Nest$sfgetPERSONALIZATION_CONTEXT() {
        return PERSONALIZATION_CONTEXT;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetPERSONALIZATION_E0, reason: not valid java name */
    static /* bridge */ /* synthetic */ byte[] m5479$$Nest$sfgetPERSONALIZATION_E0() {
        return PERSONALIZATION_E0;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetPERSONALIZATION_FBE_KEY, reason: not valid java name */
    static /* bridge */ /* synthetic */ byte[] m5480$$Nest$sfgetPERSONALIZATION_FBE_KEY() {
        return PERSONALIZATION_FBE_KEY;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetPERSONALIZATION_KEY_STORE_PASSWORD, reason: not valid java name */
    static /* bridge */ /* synthetic */ byte[] m5481$$Nest$sfgetPERSONALIZATION_KEY_STORE_PASSWORD() {
        return PERSONALIZATION_KEY_STORE_PASSWORD;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetPERSONALIZATION_PASSWORD_HASH, reason: not valid java name */
    static /* bridge */ /* synthetic */ byte[] m5482$$Nest$sfgetPERSONALIZATION_PASSWORD_HASH() {
        return PERSONALIZATION_PASSWORD_HASH;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetPERSONALIZATION_PASSWORD_METRICS, reason: not valid java name */
    static /* bridge */ /* synthetic */ byte[] m5483$$Nest$sfgetPERSONALIZATION_PASSWORD_METRICS() {
        return PERSONALIZATION_PASSWORD_METRICS;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetPERSONALIZATION_SP_GK_AUTH, reason: not valid java name */
    static /* bridge */ /* synthetic */ byte[] m5484$$Nest$sfgetPERSONALIZATION_SP_GK_AUTH() {
        return PERSONALIZATION_SP_GK_AUTH;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetPERSONALIZATION_SP_SPLIT, reason: not valid java name */
    static /* bridge */ /* synthetic */ byte[] m5485$$Nest$sfgetPERSONALIZATION_SP_SPLIT() {
        return PERSONALIZATION_SP_SPLIT;
    }

    private native long nativeSidFromPasswordHandle(byte[] r1);

    static {
        DEFAULT_PASSWORD = "default-password".getBytes();
        PERSONALIZATION_SECDISCARDABLE = "secdiscardable-transform".getBytes();
        PERSONALIZATION_KEY_STORE_PASSWORD = "keystore-password".getBytes();
        PERSONALIZATION_USER_GK_AUTH = "user-gk-authentication".getBytes();
        PERSONALIZATION_SP_GK_AUTH = "sp-gk-authentication".getBytes();
        PERSONALIZATION_FBE_KEY = "fbe-key".getBytes();
        PERSONALIZATION_AUTHSECRET_KEY = "authsecret-hal".getBytes();
        PERSONALIZATION_AUTHSECRET_ENCRYPTION_KEY = "vendor-authsecret-encryption-key".getBytes();
        PERSONALIZATION_SP_SPLIT = "sp-split".getBytes();
        PERSONALIZATION_PASSWORD_HASH = "pw-hash".getBytes();
        PERSONALIZATION_E0 = "e0-encryption".getBytes();
        PERSONALIZATION_WEAVER_PASSWORD = "weaver-pwd".getBytes();
        PERSONALIZATION_WEAVER_KEY = "weaver-key".getBytes();
        PERSONALIZATION_WEAVER_TOKEN = "weaver-token".getBytes();
        PERSONALIZATION_PASSWORD_METRICS = "password-metrics".getBytes();
        PERSONALIZATION_CONTEXT = "android-synthetic-password-personalization-context".getBytes();
    }

    public SyntheticPasswordManager(Context context, LockSettingsStorage storage, UserManager userManager, PasswordSlotManager passwordSlotManager) {
        this.mListeners = new RemoteCallbackList();
        this.tokenMap = new ArrayMap();
        this.mContext = context;
        this.mStorage = storage;
        this.mUserManager = userManager;
        this.mPasswordSlotManager = passwordSlotManager;
    }

    private boolean isDeviceProvisioned() {
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "device_provisioned", 0) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    private boolean isWeaverDisabledOnUnsecuredUsers() {
        return this.mContext.getResources().getBoolean(R.bool.config_displayBlanksAfterDoze);
    }

    protected android.hardware.weaver.V1_0.IWeaver getWeaverHidlService() throws RemoteException {
        return android.hardware.weaver.V1_0.IWeaver.getService(true);
    L6:
        return null;
    }

    private IWeaver getWeaverAidlService() {
        IWeaver aidlWeaver = IWeaver.Stub.asInterface(ServiceManager.waitForDeclaredService(IWeaver.DESCRIPTOR + "/default"));     // Catch: SecurityException -> L16
        if (aidlWeaver != null) goto L19;
        return null;
    L19:
        int aidlVersion = aidlWeaver.getInterfaceVersion();     // Catch: RemoteException -> L13
        if (aidlVersion >= 2) goto L11;
        Slog.w(TAG, "Ignoring AIDL weaver service v" + aidlVersion + " because only v2 and later are supported");
        return null;
    L11:
        Slog.i(TAG, "Found AIDL weaver service v" + aidlVersion);
        return aidlWeaver;
    L13:
        e = move-exception;
        Slog.e(TAG, "Cannot get AIDL weaver service version", e);
        return null;
    L17:
        Slog.w(TAG, "Does not have permissions to get AIDL weaver service");
        return null;
    }

    private IWeaver getWeaverServiceInternal() {
        IWeaver aidlWeaver = getWeaverAidlService();
        SyntheticPasswordManagerIA r1 = null;
        if (aidlWeaver == null) goto L22;
        Slog.i(TAG, "Using AIDL weaver service");
        aidlWeaver.asBinder().linkToDeath(new WeaverDiedRecipient(this, r1), 0);     // Catch: RemoteException -> L7
    L9:
        return aidlWeaver;
    L7:
        e = move-exception;
        Slog.w(TAG, "Unable to register Weaver death recipient", e);
        goto L9
    L22:
        android.hardware.weaver.V1_0.IWeaver hidlWeaver = getWeaverHidlService();     // Catch: RemoteException -> L14
        if (hidlWeaver == null) goto L18;
        Slog.i(TAG, "Using HIDL weaver service");     // Catch: RemoteException -> L14
        return new WeaverHidlAdapter(hidlWeaver);
    L18:
        Slog.w(TAG, "Device does not support weaver");
        return null;
    L14:
        e = move-exception;
        Slog.w(TAG, "Failed to get HIDL weaver service.", e);
        goto L18
    }

    public boolean isAutoPinConfirmationFeatureAvailable() {
        return LockPatternUtils.isAutoPinConfirmFeatureAvailable();
    }

    private synchronized IWeaver getWeaverService() {
        monitor-enter(this);
        IWeaver weaver = this.mWeaver;     // Catch: Throwable -> L20
        if (weaver == null) goto L7;
        monitor-exit(this);
        return weaver;
    L7:
        IWeaver weaver2 = getWeaverServiceInternal();     // Catch: Throwable -> L20
        if (weaver2 != null) goto L32;
        monitor-exit(this);
        return null;
    L32:
        WeaverConfig weaverConfig = weaver2.getConfig();     // Catch: Throwable -> L20 Throwable -> L25
        if (weaverConfig != null) goto L15;
    L22:
        Slog.e(TAG, "Invalid weaver config");     // Catch: Throwable -> L20
        monitor-exit(this);
        return null;
    L15:
        if (weaverConfig.slots <= 0) goto L22;
        this.mWeaver = weaver2;     // Catch: Throwable -> L20
        this.mWeaverConfig = weaverConfig;     // Catch: Throwable -> L20
        this.mPasswordSlotManager.refreshActiveSlots(getUsedWeaverSlots());     // Catch: Throwable -> L20
        Slog.i(TAG, "Weaver service initialized");     // Catch: Throwable -> L20
        monitor-exit(this);
        return weaver2;
    L25:
        e = move-exception;
        Slog.e(TAG, "Failed to get weaver config", e);     // Catch: Throwable -> L20
        return null;
    L20:
        th = move-exception;
        throw th;
    }

    private byte[] weaverEnroll(IWeaver weaver, int slot, byte[] key, byte[] value) {
        if (slot == (-1)) goto L24;
        if (slot >= this.mWeaverConfig.slots) goto L24;
        if (key != null) goto L9;
        key = new byte[this.mWeaverConfig.keySize];
    L10:
        if (value != null) goto L25;
        value = SecureRandomUtils.randomBytes(this.mWeaverConfig.valueSize);
    L25:
        weaver.write(slot, key, value);     // Catch: ServiceSpecificException -> L15 RemoteException -> L18
        return value;
    L18:
        e = move-exception;
        Slog.e(TAG, "weaver write binder call failed, slot: " + slot, e);
        return null;
    L15:
        e = move-exception;
        Slog.e(TAG, "weaver write failed, slot: " + slot, e);
        return null;
    L9:
        if (key.length == this.mWeaverConfig.keySize) goto L10;
        throw new IllegalArgumentException("Invalid key size for weaver");
    L24:
        throw new IllegalArgumentException("Invalid slot for weaver");
    }

    private static VerifyCredentialResponse responseFromTimeout(WeaverReadResponse response) {
        if (response.timeout <= 2147483647L) goto L5;
    L8:
        int timeout = Integer.MAX_VALUE;
    L10:
        return VerifyCredentialResponse.fromTimeout(timeout);
    L5:
        if (response.timeout < 0) goto L8;
        timeout = (int) response.timeout;
        goto L10
    }

    private VerifyCredentialResponse weaverVerify(IWeaver weaver, int slot, byte[] key) {
        if (slot == (-1)) goto L33;
        if (slot >= this.mWeaverConfig.slots) goto L33;
        if (key != null) goto L9;
        key = new byte[this.mWeaverConfig.keySize];
    L34:
        WeaverReadResponse readResponse = weaver.read(slot, key);     // Catch: RemoteException -> L27
        switch(readResponse.status) {
            case 0: goto L26;
            case 1: goto L23;
            case 2: goto L18;
            case 3: goto L15;
            default: goto L13;
        };
    L13:
        Slog.e(TAG, "weaver read unknown status " + readResponse.status + ", slot: " + slot);
        return VerifyCredentialResponse.ERROR;
    L15:
        Slog.e(TAG, "weaver read failed (THROTTLE), slot: " + slot);
        return responseFromTimeout(readResponse);
    L23:
        Slog.e(TAG, "weaver read failed (FAILED), slot: " + slot);
        return VerifyCredentialResponse.ERROR;
    L18:
        if (readResponse.timeout != 0) goto L21;
        Slog.e(TAG, "weaver read failed (INCORRECT_KEY), slot: " + slot);
        return VerifyCredentialResponse.ERROR;
    L21:
        Slog.e(TAG, "weaver read failed (INCORRECT_KEY/THROTTLE), slot: " + slot);
        return responseFromTimeout(readResponse);
    L26:
        return new VerifyCredentialResponse.Builder().setGatekeeperHAT(readResponse.value).build();
    L27:
        e = move-exception;
        Slog.e(TAG, "weaver read failed, slot: " + slot, e);
        return VerifyCredentialResponse.ERROR;
    L9:
        if (key.length == this.mWeaverConfig.keySize) goto L34;
        throw new IllegalArgumentException("Invalid key size for weaver");
    L33:
        throw new IllegalArgumentException("Invalid slot for weaver");
    }

    public void removeUser(IGateKeeperService gatekeeper, int userId) {
        Iterator<Long> r0 = this.mStorage.listSyntheticPasswordProtectorsForUser(SP_BLOB_NAME, userId).iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        long protectorId = r0.next().longValue();
        destroyWeaverSlot(protectorId, userId);
        destroyProtectorKey(getProtectorKeyAlias(protectorId));
        goto L4
    L11:
        gatekeeper.clearSecureUserId(fakeUserId(userId));     // Catch: RemoteException -> L8
        return;
    L9:
        Slog.w(TAG, "Failed to clear SID from gatekeeper");
    }

    int getPinLength(long protectorId, int userId) {
        byte[] passwordData = loadState(PASSWORD_DATA_NAME, protectorId, userId);
        if (passwordData != null) goto L7;
        return -1;
    L7:
        return PasswordData.fromBytes(passwordData).pinLength;
    }

    int getCredentialType(long protectorId, int userId) {
        byte[] passwordData = loadState(PASSWORD_DATA_NAME, protectorId, userId);
        if (passwordData != null) goto L7;
        return -1;
    L7:
        return PasswordData.fromBytes(passwordData).credentialType;
    }

    int getSpecialUserCredentialType(int userId) {
        LockSettingsStorage.PersistentData data = getSpecialUserPersistentData(userId);
        if (data.type == 1) goto L8;
        if (data.type == 2) goto L8;
        return -1;
    L8:
        if (data.payload != null) goto L10;
        return -1;
    L10:
        int credentialType = PasswordData.fromBytes(data.payload).credentialType;
        if (credentialType == 2) goto L14;
        return credentialType;
    L14:
        return LockPatternUtils.pinOrPasswordQualityToCredentialType(data.qualityForUi);
    }

    private LockSettingsStorage.PersistentData getSpecialUserPersistentData(int userId) {
        if (userId != (-9999)) goto L7;
        return this.mStorage.readPersistentDataBlock();
    L7:
        if (userId != (-9998)) goto L11;
        return this.mStorage.readRepairModePersistentData();
    L11:
        throw new IllegalArgumentException("Unknown special user id " + userId);
    }

    SyntheticPassword newSyntheticPassword(int userId) {
        clearSidForUser(userId);
        SyntheticPassword result = SyntheticPassword.create();
        saveEscrowData(result, userId);
        return result;
    }

    public void newSidForUser(IGateKeeperService gatekeeper, SyntheticPassword sp, int userId) {
        GateKeeperResponse response = gatekeeper.enroll(userId, null, null, sp.deriveGkPassword());     // Catch: RemoteException -> L9
        if (response.getResponseCode() != 0) goto L8;
        saveSyntheticPasswordHandle(response.getPayload(), userId);
        return;
    L8:
        throw new IllegalStateException("Fail to create new SID for user " + userId + " response: " + response.getResponseCode());
    L9:
        e = move-exception;
        throw new IllegalStateException("Failed to create new SID for user", e);
    }

    public void clearSidForUser(int userId) {
        destroyState(SP_HANDLE_NAME, 0, userId);
    }

    public boolean hasSidForUser(int userId) {
        return hasState(SP_HANDLE_NAME, 0, userId);
    }

    private byte[] loadSyntheticPasswordHandle(int userId) {
        return loadState(SP_HANDLE_NAME, 0, userId);
    }

    private void saveSyntheticPasswordHandle(byte[] spHandle, int userId) {
        saveState(SP_HANDLE_NAME, spHandle, 0, userId);
        syncState(userId);
    }

    private boolean loadEscrowData(SyntheticPassword sp, int userId) {
        byte[] e0 = loadState(SP_E0_NAME, 0, userId);
        byte[] p1 = loadState(SP_P1_NAME, 0, userId);
        sp.setEscrowData(e0, p1);
        if (e0 == null) goto L6;
        if (p1 == null) goto L6;
        return true;
    L6:
        return false;
    }

    private void saveEscrowData(SyntheticPassword sp, int userId) {
        saveState(SP_E0_NAME, SyntheticPassword.m5486$$Nest$fgetmEncryptedEscrowSplit0(sp), 0, userId);
        saveState(SP_P1_NAME, SyntheticPassword.m5487$$Nest$fgetmEscrowSplit1(sp), 0, userId);
    }

    public boolean hasEscrowData(int userId) {
        if (hasState(SP_E0_NAME, 0, userId) == true) goto L5;
    L7:
        return false;
    L5:
        if (hasState(SP_P1_NAME, 0, userId) == false) goto L7;
        return true;
    }

    public boolean hasAnyEscrowData(int userId) {
        if (hasState(SP_E0_NAME, 0, userId) == false) goto L5;
    L8:
        return true;
    L5:
        if (hasState(SP_P1_NAME, 0, userId) == true) goto L8;
        return false;
    }

    public void destroyEscrowData(int userId) {
        destroyState(SP_E0_NAME, 0, userId);
        destroyState(SP_P1_NAME, 0, userId);
    }

    private int loadWeaverSlot(long protectorId, int userId) {
        byte[] data = loadState(WEAVER_SLOT_NAME, protectorId, userId);
        if (data != null) goto L5;
    L13:
        return -1;
    L5:
        if (data.length != 5) goto L13;
        ByteBuffer buffer = ByteBuffer.allocate(5);
        buffer.put(data, 0, data.length);
        buffer.flip();
        if (buffer.get() == 1) goto L12;
        Slog.e(TAG, "Invalid weaver slot version for protector " + protectorId);
        return -1;
    L12:
        return buffer.getInt();
    }

    private void saveWeaverSlot(int slot, long protectorId, int userId) {
        ByteBuffer buffer = ByteBuffer.allocate(5);
        buffer.put((byte) 1);
        buffer.putInt(slot);
        saveState(WEAVER_SLOT_NAME, buffer.array(), protectorId, userId);
    }

    private void destroyWeaverSlot(long protectorId, int userId) {
        int slot = loadWeaverSlot(protectorId, userId);
        destroyState(WEAVER_SLOT_NAME, protectorId, userId);
        if (slot == (-1)) goto L13;
        IWeaver weaver = getWeaverService();
        if (weaver != null) goto L8;
        Slog.e(TAG, "Cannot erase Weaver slot because Weaver is unavailable");
        return;
    L8:
        Set<Integer> usedSlots = getUsedWeaverSlots();
        if (usedSlots.contains(Integer.valueOf(slot)) == true) goto L11;
        Slogf.i(TAG, "Erasing Weaver slot %d", new Object[]{Integer.valueOf(slot)});
        weaverEnroll(weaver, slot, null, null);
        this.mPasswordSlotManager.markSlotDeleted(slot);
        return;
    L11:
        Slogf.i(TAG, "Weaver slot %d was already reused; not erasing it", new Object[]{Integer.valueOf(slot)});
        return;
    }

    private Set<Integer> getUsedWeaverSlots() {
        Map<Integer, List<Long>> protectorIds = this.mStorage.listSyntheticPasswordProtectorsForAllUsers(WEAVER_SLOT_NAME);
        HashSet<Integer> slots = new HashSet();
        Iterator<Map.Entry<Integer, List<Long>>> r2 = protectorIds.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L10;
        Map.Entry<Integer, List<Long>> entry = r2.next();
        Iterator<Long> r4 = entry.getValue().iterator();
    L7:
        if (r4.hasNext() == false) goto L4;
        Long protectorId = r4.next();
        int slot = loadWeaverSlot(protectorId.longValue(), entry.getKey().intValue());
        slots.add(Integer.valueOf(slot));
        goto L7
    L10:
        return slots;
    }

    private int getNextAvailableWeaverSlot() {
        Set<Integer> usedSlots = getUsedWeaverSlots();
        usedSlots.addAll(this.mPasswordSlotManager.getUsedSlots());
        if (isDeviceProvisioned() == true) goto L9;
        LockSettingsStorage.PersistentData persistentData = this.mStorage.readPersistentDataBlock();
        if (persistentData == null) goto L9;
        if (persistentData.type != 2) goto L9;
        int slot = persistentData.userId;
        usedSlots.add(Integer.valueOf(slot));
    L9:
        int i = 0;
    L11:
        if (i >= this.mWeaverConfig.slots) goto L17;
        if (usedSlots.contains(Integer.valueOf(i)) == false) goto L14;
        i = i + 1;
        goto L11
    L14:
        return i;
    L17:
        throw new IllegalStateException("Run out of weaver slots.");
    }

    public long createLskfBasedProtector(IGateKeeperService gatekeeper, LockscreenCredential credential, SyntheticPassword sp, int userId) {
        long protectorId = generateProtectorId();
        if (isAutoPinConfirmationFeatureAvailable() == false) goto L5;
        int pinLength = derivePinLength(credential.size(), credential.isPin(), userId);
        int pinLength2 = pinLength;
    L7:
        if (credential.isNone() == false) goto L9;
        PasswordData r0 = null;
    L10:
        PasswordData pwd = r0;
        byte[] stretchedLskf = stretchLskf(credential, pwd);
        long sid = 0;
        Slogf.i(TAG, "Creating LSKF-based protector %016x for user %d", new Object[]{Long.valueOf(protectorId), Integer.valueOf(userId)});
        if (credential.isNone() == true) goto L13;
    L15:
        IWeaver weaver = getWeaverService();
        IWeaver weaver2 = weaver;
    L16:
        if (weaver2 == null) goto L23;
        int weaverSlot = getNextAvailableWeaverSlot();
        Slogf.i(TAG, "Enrolling LSKF for user %d into Weaver slot %d", new Object[]{Integer.valueOf(userId), Integer.valueOf(weaverSlot)});
        byte[] weaverSecret = weaverEnroll(weaver2, weaverSlot, stretchedLskfToWeaverKey(stretchedLskf), null);
        if (weaverSecret == null) goto L21;
        saveWeaverSlot(weaverSlot, protectorId, userId);
        this.mPasswordSlotManager.markSlotInUse(weaverSlot);
        synchronizeWeaverFrpPassword(pwd, 0, userId, weaverSlot);
        byte[] protectorSecret = transformUnderWeaverSecret(stretchedLskf, weaverSecret);
    L40:
        if (credential.isNone() == true) goto L42;
        saveState(PASSWORD_DATA_NAME, pwd.toBytes(), protectorId, userId);
        savePasswordMetrics(credential, sp, protectorId, userId);
    L42:
        createSyntheticPasswordBlob(protectorId, (byte) 0, sp, protectorSecret, sid, userId);
        syncState(userId);
        return protectorId;
    L21:
        throw new IllegalStateException("Fail to enroll user password under weaver " + userId);
    L23:
        if (credential.isNone() == false) goto L44;
    L38:
        protectorSecret = transformUnderSecdiscardable(stretchedLskf, createSecdiscardable(protectorId, userId));
        synchronizeGatekeeperFrpPassword(pwd, 0, userId);
        goto L40
    L44:
        gatekeeper.clearSecureUserId(fakeUserId(userId));     // Catch: RemoteException -> L26
    L28:
        Slogf.i(TAG, "Enrolling LSKF for user %d into Gatekeeper", new Object[]{Integer.valueOf(userId)});
        GateKeeperResponse response = gatekeeper.enroll(fakeUserId(userId), null, null, stretchedLskfToGkPassword(stretchedLskf));     // Catch: RemoteException -> L35
        if (response.getResponseCode() != 0) goto L34;
        pwd.passwordHandle = response.getPayload();
        sid = sidFromPasswordHandle(pwd.passwordHandle);
        goto L38
    L34:
        throw new IllegalStateException("Failed to enroll LSKF for new SP protector for user " + userId);
    L35:
        e = move-exception;
        throw new IllegalStateException("Failed to enroll LSKF for new SP protector for user " + userId, e);
    L27:
        Slog.w(TAG, "Failed to clear SID from gatekeeper");
        goto L28
    L13:
        if (isWeaverDisabledOnUnsecuredUsers() == false) goto L15;
        Slog.w(TAG, "Not using Weaver for unsecured user (disabled by config)");
        weaver2 = null;
        goto L16
    L9:
        r0 = PasswordData.create(credential.getType(), pinLength2);
        goto L10
    L5:
        pinLength2 = -1;
        goto L7
    }

    private int derivePinLength(int sizeOfCredential, boolean isPinCredential, int userId) {
        if (isPinCredential == true) goto L4;
        return -1;
    L4:
        if (this.mStorage.isAutoPinConfirmSettingEnabled(userId) == true) goto L6;
        return -1;
    L6:
        if (sizeOfCredential < 6) goto L12;
        return sizeOfCredential;
    L12:
        return -1;
    }

    public VerifyCredentialResponse verifySpecialUserCredential(int sourceUserId, IGateKeeperService gatekeeper, LockscreenCredential userCredential, ICheckCredentialProgressCallback progressCallback) {
        LockSettingsStorage.PersistentData persistentData = getSpecialUserPersistentData(sourceUserId);
        if (persistentData.type != 1) goto L17;
        PasswordData pwd = PasswordData.fromBytes(persistentData.payload);
        byte[] stretchedLskf = stretchLskf(userCredential, pwd);
        GateKeeperResponse response = gatekeeper.verifyChallenge(fakeUserId(persistentData.userId), 0, pwd.passwordHandle, stretchedLskfToGkPassword(stretchedLskf));     // Catch: RemoteException -> L10
        return VerifyCredentialResponse.fromGateKeeperResponse(response);
    L10:
        e = move-exception;
        RemoteException e = e;
    L14:
        Slog.e(TAG, "Persistent data credential verifyChallenge failed", e);
        return VerifyCredentialResponse.ERROR;
    L12:
        e = move-exception;
        e = e;
        goto L14
    L17:
        if (persistentData.type != 2) goto L24;
        IWeaver weaver = getWeaverService();
        if (weaver != null) goto L22;
        Slog.e(TAG, "No weaver service to verify SP-based persistent data credential");
        return VerifyCredentialResponse.ERROR;
    L22:
        byte[] stretchedLskf2 = stretchLskf(userCredential, PasswordData.fromBytes(persistentData.payload));
        int weaverSlot = persistentData.userId;
        return weaverVerify(weaver, weaverSlot, stretchedLskfToWeaverKey(stretchedLskf2)).stripPayload();
    L24:
        Slog.e(TAG, "persistentData.type must be TYPE_SP_GATEKEEPER or TYPE_SP_WEAVER, but is " + persistentData.type);
        return VerifyCredentialResponse.ERROR;
    }

    public void migrateFrpPasswordLocked(long protectorId, UserInfo userInfo, int requestedQuality) {
        if (this.mStorage.getPersistentDataBlockManager() != null) goto L5;
        return;
    L5:
        if (LockPatternUtils.userOwnsFrpCredential(this.mContext, userInfo) == true) goto L7;
        return;
    L7:
        if (getCredentialType(protectorId, userInfo.id) == (-1)) goto L15;
        Slog.i(TAG, "Migrating FRP credential to persistent data block");
        PasswordData pwd = PasswordData.fromBytes(loadState(PASSWORD_DATA_NAME, protectorId, userInfo.id));
        int weaverSlot = loadWeaverSlot(protectorId, userInfo.id);
        if (weaverSlot == (-1)) goto L11;
        synchronizeWeaverFrpPassword(pwd, requestedQuality, userInfo.id, weaverSlot);
        return;
    L11:
        synchronizeGatekeeperFrpPassword(pwd, requestedQuality, userInfo.id);
        return;
    }

    private static boolean isNoneCredential(PasswordData pwd) {
        if (pwd != null) goto L4;
    L7:
        return true;
    L4:
        if (pwd.credentialType == (-1)) goto L7;
        return false;
    }

    private boolean shouldSynchronizeFrpCredential(PasswordData pwd, int userId) {
        if (this.mStorage.getPersistentDataBlockManager() != null) goto L5;
        return false;
    L5:
        UserInfo userInfo = this.mUserManager.getUserInfo(userId);
        if (LockPatternUtils.userOwnsFrpCredential(this.mContext, userInfo) == true) goto L9;
        return false;
    L9:
        if (isNoneCredential(pwd) == true) goto L11;
        return true;
    L11:
        if (isDeviceProvisioned() == true) goto L16;
        Slog.d(TAG, "Not clearing FRP credential yet because device is not yet provisioned");
        return false;
    L16:
        return true;
    }

    private void synchronizeGatekeeperFrpPassword(PasswordData pwd, int requestedQuality, int userId) {
        if (shouldSynchronizeFrpCredential(pwd, userId) == false) goto L9;
        Slogf.d(TAG, "Syncing Gatekeeper-based FRP credential tied to user %d", new Object[]{Integer.valueOf(userId)});
        if (isNoneCredential(pwd) == true) goto L7;
        this.mStorage.writePersistentDataBlock(1, userId, requestedQuality, pwd.toBytes());
        return;
    L7:
        this.mStorage.writePersistentDataBlock(0, userId, 0, null);
        return;
    }

    private void synchronizeWeaverFrpPassword(PasswordData pwd, int requestedQuality, int userId, int weaverSlot) {
        if (shouldSynchronizeFrpCredential(pwd, userId) == false) goto L9;
        Slogf.d(TAG, "Syncing Weaver-based FRP credential tied to user %d", new Object[]{Integer.valueOf(userId)});
        if (isNoneCredential(pwd) == true) goto L7;
        this.mStorage.writePersistentDataBlock(2, weaverSlot, requestedQuality, pwd.toBytes());
        return;
    L7:
        this.mStorage.writePersistentDataBlock(0, 0, 0, null);
        return;
    }

    public boolean writeRepairModeCredentialLocked(long protectorId, int userId) {
        if (shouldWriteRepairModeCredential(userId) == true) goto L5;
        return false;
    L5:
        byte[] data = loadState(PASSWORD_DATA_NAME, protectorId, userId);
        if (data != null) goto L9;
        Slogf.w(TAG, "Password data not found for user %d", new Object[]{Integer.valueOf(userId)});
        return false;
    L9:
        PasswordData pwd = PasswordData.fromBytes(data);
        if (isNoneCredential(pwd) == false) goto L13;
        Slogf.w(TAG, "User %d has NONE credential", new Object[]{Integer.valueOf(userId)});
        return false;
    L13:
        Slogf.d(TAG, "Writing repair mode credential tied to user %d", new Object[]{Integer.valueOf(userId)});
        int weaverSlot = loadWeaverSlot(protectorId, userId);
        if (weaverSlot == (-1)) goto L16;
        this.mStorage.writeRepairModePersistentData(2, weaverSlot, pwd.toBytes());
    L17:
        return true;
    L16:
        this.mStorage.writeRepairModePersistentData(1, userId, pwd.toBytes());
        goto L17
    }

    private boolean shouldWriteRepairModeCredential(int userId) {
        UserInfo userInfo = this.mUserManager.getUserInfo(userId);
        if (LockPatternUtils.canUserEnterRepairMode(this.mContext, userInfo) == true) goto L7;
        Slogf.w(TAG, "User %d can't enter repair mode", new Object[]{Integer.valueOf(userId)});
        return false;
    L7:
        if (LockPatternUtils.isRepairModeActive(this.mContext) == false) goto L11;
        Slog.w(TAG, "Can't write repair mode credential while repair mode is already active");
        return false;
    L11:
        if (LockPatternUtils.isGsiRunning() == false) goto L14;
        Slog.w(TAG, "Can't write repair mode credential while GSI is running");
        return false;
    L14:
        return true;
    }

    public long addPendingToken(byte[] token, int type, int userId, LockPatternUtils.EscrowTokenStateChangeCallback changeCallback) {
        long tokenHandle = generateProtectorId();
        if (this.tokenMap.containsKey(Integer.valueOf(userId)) == true) goto L5;
        this.tokenMap.put(Integer.valueOf(userId), new ArrayMap());
    L5:
        TokenData tokenData = new TokenData(null);
        tokenData.mType = type;
        byte[] secdiscardable = SecureRandomUtils.randomBytes(16384);
        if (getWeaverService() == null) goto L8;
        tokenData.weaverSecret = SecureRandomUtils.randomBytes(this.mWeaverConfig.valueSize);
        tokenData.secdiscardableOnDisk = SyntheticPasswordCrypto.encrypt(tokenData.weaverSecret, PERSONALIZATION_WEAVER_TOKEN, secdiscardable);
    L9:
        tokenData.aggregatedSecret = transformUnderSecdiscardable(token, secdiscardable);
        tokenData.mCallback = changeCallback;
        this.tokenMap.get(Integer.valueOf(userId)).put(Long.valueOf(tokenHandle), tokenData);
        return tokenHandle;
    L8:
        tokenData.secdiscardableOnDisk = secdiscardable;
        tokenData.weaverSecret = null;
        goto L9
    }

    public Set<Long> getPendingTokensForUser(int userId) {
        if (this.tokenMap.containsKey(Integer.valueOf(userId)) == true) goto L7;
        return Collections.emptySet();
    L7:
        return new ArraySet(this.tokenMap.get(Integer.valueOf(userId)).keySet());
    }

    public boolean removePendingToken(long tokenHandle, int userId) {
        if (this.tokenMap.containsKey(Integer.valueOf(userId)) == true) goto L6;
        return false;
    L6:
        if (this.tokenMap.get(Integer.valueOf(userId)).remove(Long.valueOf(tokenHandle)) == null) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean createTokenBasedProtector(long tokenHandle, SyntheticPassword sp, int userId) {
        if (this.tokenMap.containsKey(Integer.valueOf(userId)) == true) goto L5;
        return false;
    L5:
        TokenData tokenData = this.tokenMap.get(Integer.valueOf(userId)).get(Long.valueOf(tokenHandle));
        if (tokenData != null) goto L9;
        return false;
    L9:
        if (loadEscrowData(sp, userId) == true) goto L12;
        Slog.w(TAG, "User is not escrowable");
        return false;
    L12:
        Slogf.i(TAG, "Creating token-based protector %016x for user %d", new Object[]{Long.valueOf(tokenHandle), Integer.valueOf(userId)});
        IWeaver weaver = getWeaverService();
        if (weaver == null) goto L19;
        int slot = getNextAvailableWeaverSlot();
        Slogf.i(TAG, "Using Weaver slot %d for new token-based protector", new Object[]{Integer.valueOf(slot)});
        if (weaverEnroll(weaver, slot, null, tokenData.weaverSecret) != null) goto L18;
        Slog.e(TAG, "Failed to enroll weaver secret when activating token");
        return false;
    L18:
        saveWeaverSlot(slot, tokenHandle, userId);
        this.mPasswordSlotManager.markSlotInUse(slot);
    L19:
        saveSecdiscardable(tokenHandle, tokenData.secdiscardableOnDisk, userId);
        createSyntheticPasswordBlob(tokenHandle, getTokenBasedProtectorType(tokenData.mType), sp, tokenData.aggregatedSecret, 0, userId);
        syncState(userId);
        this.tokenMap.get(Integer.valueOf(userId)).remove(Long.valueOf(tokenHandle));
        if (tokenData.mCallback == null) goto L24;
        tokenData.mCallback.onEscrowTokenActivated(tokenHandle, userId);
        return true;
    L24:
        return true;
    }

    private void createSyntheticPasswordBlob(long protectorId, byte protectorType, SyntheticPassword sp, byte[] protectorSecret, long sid, int userId) {
        byte version = 2;
        if (protectorType == 1) goto L7;
        if (protectorType == 2) goto L7;
        byte[] spSecret = sp.getSyntheticPassword();
    L8:
        byte[] content = createSpBlob(getProtectorKeyAlias(protectorId), spSecret, protectorSecret, sid);
        if (SyntheticPassword.m5488$$Nest$fgetmVersion(sp) != 3) goto L12;
        version = 3;
    L12:
        SyntheticPasswordBlob blob = SyntheticPasswordBlob.create(version, protectorType, content);
        saveState(SP_BLOB_NAME, blob.toByte(), protectorId, userId);
        return;
    L7:
        byte[] spSecret2 = sp.getEscrowSecret();
        spSecret = spSecret2;
        goto L8
    }

    public AuthenticationResult unlockLskfBasedProtector(IGateKeeperService gatekeeper, long protectorId, LockscreenCredential credential, int userId, ICheckCredentialProgressCallback progressCallback) {
        AuthenticationResult result = new AuthenticationResult();
        if (protectorId != 0) goto L6;
        Slogf.wtf(TAG, "Synthetic password not found for user %d", new Object[]{Integer.valueOf(userId)});
        result.gkResponse = VerifyCredentialResponse.ERROR;
        return result;
    L6:
        byte[] pwdDataBytes = loadState(PASSWORD_DATA_NAME, protectorId, userId);
        if (pwdDataBytes == null) goto L9;
        PasswordData pwd = PasswordData.fromBytes(pwdDataBytes);
        int storedType = pwd.credentialType;
        PasswordData pwd2 = pwd;
        int storedType2 = storedType;
    L11:
        if (credential.checkAgainstStoredType(storedType2) == true) goto L14;
        Slogf.e(TAG, "Credential type mismatch: stored type is %s but provided type is %s", new Object[]{LockPatternUtils.credentialTypeToString(storedType2), LockPatternUtils.credentialTypeToString(credential.getType())});
        result.gkResponse = VerifyCredentialResponse.ERROR;
        return result;
    L14:
        byte[] stretchedLskf = stretchLskf(credential, pwd2);
        long sid = 0;
        int weaverSlot = loadWeaverSlot(protectorId, userId);
        if (weaverSlot == (-1)) goto L24;
        result.usedWeaver = true;
        IWeaver weaver = getWeaverService();
        if (weaver != null) goto L20;
        Slog.e(TAG, "Protector uses Weaver, but Weaver is unavailable");
        result.gkResponse = VerifyCredentialResponse.ERROR;
        return result;
    L20:
        result.gkResponse = weaverVerify(weaver, weaverSlot, stretchedLskfToWeaverKey(stretchedLskf));
        if (result.gkResponse.getResponseCode() == 0) goto L23;
        return result;
    L23:
        byte[] protectorSecret = transformUnderWeaverSecret(stretchedLskf, result.gkResponse.getGatekeeperHAT());
        gatekeeper = gatekeeper;
        byte[] protectorSecret2 = protectorSecret;
    L75:
        if (progressCallback != null) goto L94;
    L80:
        result.syntheticPassword = unwrapSyntheticPasswordBlob(protectorId, (byte) 0, protectorSecret2, sid, userId);
        result.gkResponse = verifyChallenge(gatekeeper, result.syntheticPassword, 0, userId);
        if (result.syntheticPassword != null) goto L83;
    L87:
        return result;
    L83:
        if (credential.isNone() == true) goto L87;
        if (hasPasswordMetrics(protectorId, userId) == true) goto L87;
        savePasswordMetrics(credential, result.syntheticPassword, protectorId, userId);
        syncState(userId);
        goto L87
    L94:
        progressCallback.onCredentialVerified();     // Catch: RemoteException -> L78
    L78:
        e = move-exception;
        Slog.w(TAG, "progressCallback throws exception", e);
        goto L80
    L24:
        if (pwd2 == null) goto L67;
        if (pwd2.passwordHandle == null) goto L67;
        byte[] gkPassword = stretchedLskfToGkPassword(stretchedLskf);
        GateKeeperResponse response = gatekeeper.verifyChallenge(fakeUserId(userId), 0, pwd2.passwordHandle, gkPassword);     // Catch: RemoteException -> L58
        int responseCode = response.getResponseCode();
        if (responseCode != 0) goto L53;
        result.gkResponse = VerifyCredentialResponse.OK;
        if (response.getShouldReEnroll() == true) goto L96;
        gatekeeper = gatekeeper;
    L51:
        sid = sidFromPasswordHandle(pwd2.passwordHandle);
    L70:
        byte[] secdiscardable = loadSecdiscardable(protectorId, userId);
        if (secdiscardable != null) goto L74;
        Slog.e(TAG, "secdiscardable file not found");
        result.gkResponse = VerifyCredentialResponse.ERROR;
        return result;
    L74:
        protectorSecret2 = transformUnderSecdiscardable(stretchedLskf, secdiscardable);
        goto L75
    L96:
        gatekeeper = gatekeeper;
        GateKeeperResponse reenrollResponse = gatekeeper.enroll(fakeUserId(userId), pwd2.passwordHandle, gkPassword, gkPassword);     // Catch: RemoteException -> L40
    L46:
        if (reenrollResponse.getResponseCode() != 0) goto L48;
        pwd2.passwordHandle = reenrollResponse.getPayload();
        pwd2.credentialType = credential.getType();
        saveState(PASSWORD_DATA_NAME, pwd2.toBytes(), protectorId, userId);
        syncState(userId);
        synchronizeGatekeeperFrpPassword(pwd2, 0, userId);
        goto L51
    L48:
        Slog.w(TAG, "Fail to re-enroll user password for user " + userId);
    L40:
        e = e;
    L44:
        Slog.w(TAG, "Fail to invoke gatekeeper.enroll", e);
        reenrollResponse = GateKeeperResponse.ERROR;
    L42:
        e = e;
        gatekeeper = gatekeeper;
        goto L44
    L53:
        if (responseCode != 1) goto L56;
        result.gkResponse = VerifyCredentialResponse.fromTimeout(response.getTimeout());
        return result;
    L56:
        result.gkResponse = VerifyCredentialResponse.ERROR;
        return result;
    L58:
        e = e;
    L63:
        Slog.e(TAG, "gatekeeper verify failed", e);
        result.gkResponse = VerifyCredentialResponse.ERROR;
        return result;
    L61:
        e = e;
    L67:
        if (credential.isNone() == true) goto L70;
        Slog.e(TAG, "Missing Gatekeeper password handle for nonempty LSKF");
        result.gkResponse = VerifyCredentialResponse.ERROR;
        return result;
    L9:
        pwd2 = null;
        storedType2 = -1;
        goto L11
    }

    public boolean refreshPinLengthOnDisk(PasswordMetrics passwordMetrics, long protectorId, int userId) {
        boolean r2 = false;
        if (isAutoPinConfirmationFeatureAvailable() == true) goto L5;
        return false;
    L5:
        byte[] pwdDataBytes = loadState(PASSWORD_DATA_NAME, protectorId, userId);
        if (pwdDataBytes != null) goto L8;
        return false;
    L8:
        PasswordData pwd = PasswordData.fromBytes(pwdDataBytes);
        int r1 = passwordMetrics.length;
        if (passwordMetrics.credType != 3) goto L11;
        r2 = true;
    L11:
        int pinLength = derivePinLength(r1, r2, userId);
        if (pwd.pinLength == pinLength) goto L14;
        pwd.pinLength = pinLength;
        saveState(PASSWORD_DATA_NAME, pwd.toBytes(), protectorId, userId);
        syncState(userId);
    L14:
        return true;
    }

    public AuthenticationResult unlockTokenBasedProtector(IGateKeeperService gatekeeper, long protectorId, byte[] token, int userId) {
        byte[] data = loadState(SP_BLOB_NAME, protectorId, userId);
        if (data != null) goto L6;
        AuthenticationResult result = new AuthenticationResult();
        result.gkResponse = VerifyCredentialResponse.ERROR;
        Slogf.w(TAG, "spblob not found for protector %016x, user %d", new Object[]{Long.valueOf(protectorId), Integer.valueOf(userId)});
        return result;
    L6:
        SyntheticPasswordBlob blob = SyntheticPasswordBlob.fromBytes(data);
        return unlockTokenBasedProtectorInternal(gatekeeper, protectorId, blob.mProtectorType, token, userId);
    }

    public AuthenticationResult unlockStrongTokenBasedProtector(IGateKeeperService gatekeeper, long protectorId, byte[] token, int userId) {
        return unlockTokenBasedProtectorInternal(gatekeeper, protectorId, (byte) 1, token, userId);
    }

    public AuthenticationResult unlockWeakTokenBasedProtector(IGateKeeperService gatekeeper, long protectorId, byte[] token, int userId) {
        return unlockTokenBasedProtectorInternal(gatekeeper, protectorId, (byte) 2, token, userId);
    }

    private AuthenticationResult unlockTokenBasedProtectorInternal(IGateKeeperService gatekeeper, long protectorId, byte expectedProtectorType, byte[] token, int userId) {
        AuthenticationResult result = new AuthenticationResult();
        byte[] secdiscardable = loadSecdiscardable(protectorId, userId);
        if (secdiscardable != null) goto L6;
        Slog.e(TAG, "secdiscardable file not found");
        result.gkResponse = VerifyCredentialResponse.ERROR;
        return result;
    L6:
        int slotId = loadWeaverSlot(protectorId, userId);
        if (slotId == (-1)) goto L20;
        IWeaver weaver = getWeaverService();
        if (weaver != null) goto L12;
        Slog.e(TAG, "Protector uses Weaver, but Weaver is unavailable");
        result.gkResponse = VerifyCredentialResponse.ERROR;
        return result;
    L12:
        VerifyCredentialResponse response = weaverVerify(weaver, slotId, null);
        if (response.getResponseCode() == 0) goto L15;
    L18:
        Slog.e(TAG, "Failed to retrieve Weaver secret when unlocking token-based protector");
        result.gkResponse = VerifyCredentialResponse.ERROR;
        return result;
    L15:
        if (response.getGatekeeperHAT() == null) goto L18;
        byte[] secdiscardable2 = SyntheticPasswordCrypto.decrypt(response.getGatekeeperHAT(), PERSONALIZATION_WEAVER_TOKEN, secdiscardable);
    L21:
        byte[] protectorSecret = transformUnderSecdiscardable(token, secdiscardable2);
        result.syntheticPassword = unwrapSyntheticPasswordBlob(protectorId, expectedProtectorType, protectorSecret, 0, userId);
        if (result.syntheticPassword == null) goto L26;
        result.gkResponse = verifyChallenge(gatekeeper, result.syntheticPassword, 0, userId);
        if (result.gkResponse != null) goto L27;
        result.gkResponse = VerifyCredentialResponse.OK;
    L27:
        return result;
    L26:
        result.gkResponse = VerifyCredentialResponse.ERROR;
        goto L27
    L20:
        secdiscardable2 = secdiscardable;
        goto L21
    }

    private SyntheticPassword unwrapSyntheticPasswordBlob(long protectorId, byte expectedProtectorType, byte[] protectorSecret, long sid, int userId) {
        byte[] data = loadState(SP_BLOB_NAME, protectorId, userId);
        if (data != null) goto L5;
        return null;
    L5:
        SyntheticPasswordBlob blob = SyntheticPasswordBlob.fromBytes(data);
        if (blob.mVersion == 3) goto L15;
        if (blob.mVersion == 2) goto L15;
        if (blob.mVersion == 1) goto L15;
        throw new IllegalArgumentException("Unknown blob version: " + blob.mVersion);
    L15:
        if (blob.mProtectorType != expectedProtectorType) goto L40;
        if (blob.mVersion != 1) goto L19;
        byte[] spSecret = SyntheticPasswordCrypto.decryptBlobV1(getProtectorKeyAlias(protectorId), blob.mContent, protectorSecret);
    L21:
        if (spSecret != null) goto L24;
        Slog.e(TAG, "Fail to decrypt SP for user " + userId);
        return null;
    L24:
        SyntheticPassword result = new SyntheticPassword(blob.mVersion);
        if (blob.mProtectorType == 1) goto L31;
        if (blob.mProtectorType == 2) goto L31;
        result.recreateDirectly(spSecret);
    L36:
        if (blob.mVersion != 1) goto L38;
        Slog.i(TAG, "Upgrading v1 SP blob for user " + userId + ", protectorType = " + blob.mProtectorType);
        createSyntheticPasswordBlob(protectorId, blob.mProtectorType, result, protectorSecret, sid, userId);
        syncState(userId);
    L38:
        return result;
    L31:
        if (loadEscrowData(result, userId) == true) goto L34;
        Slog.e(TAG, "User is not escrowable: " + userId);
        return null;
    L34:
        result.recreateFromEscrow(spSecret);
        goto L36
    L19:
        spSecret = decryptSpBlob(getProtectorKeyAlias(protectorId), blob.mContent, protectorSecret);
        goto L21
    L40:
        throw new IllegalArgumentException("Invalid protector type: " + blob.mProtectorType);
    }

    public VerifyCredentialResponse verifyChallenge(IGateKeeperService gatekeeper, SyntheticPassword sp, long challenge, int userId) {
        return verifyChallengeInternal(gatekeeper, sp.deriveGkPassword(), challenge, userId);
    }

    protected VerifyCredentialResponse verifyChallengeInternal(IGateKeeperService gatekeeper, byte[] gatekeeperPassword, long challenge, int userId) {
        byte[] spHandle = loadSyntheticPasswordHandle(userId);
        if (spHandle != null) goto L31;
        return null;
    L31:
        GateKeeperResponse response = gatekeeper.verifyChallenge(userId, challenge, spHandle, gatekeeperPassword);     // Catch: RemoteException -> L28
        int responseCode = response.getResponseCode();
        if (responseCode != 0) goto L23;
        VerifyCredentialResponse result = new VerifyCredentialResponse.Builder().setGatekeeperHAT(response.getPayload()).build();
        if (response.getShouldReEnroll() == true) goto L33;
    L21:
        return result;
    L33:
        GateKeeperResponse response2 = gatekeeper.enroll(userId, spHandle, gatekeeperPassword, gatekeeperPassword);     // Catch: RemoteException -> L14
    L17:
        if (response2.getResponseCode() != 0) goto L20;
        saveSyntheticPasswordHandle(response2.getPayload(), userId);
        return verifyChallengeInternal(gatekeeper, gatekeeperPassword, challenge, userId);
    L20:
        Slog.w(TAG, "Fail to re-enroll SP handle for user " + userId);
    L14:
        e = move-exception;
        Slog.e(TAG, "Failed to invoke gatekeeper.enroll", e);
        response2 = GateKeeperResponse.ERROR;
        goto L17
    L23:
        if (responseCode != 1) goto L26;
        Slog.e(TAG, "Gatekeeper verification of synthetic password failed with RESPONSE_RETRY");
        return VerifyCredentialResponse.fromTimeout(response.getTimeout());
    L26:
        Slog.e(TAG, "Gatekeeper verification of synthetic password failed with RESPONSE_ERROR");
        return VerifyCredentialResponse.ERROR;
    L28:
        e = move-exception;
        Slog.e(TAG, "Fail to verify with gatekeeper " + userId, e);
        return VerifyCredentialResponse.ERROR;
    }

    public boolean protectorExists(long protectorId, int userId) {
        return hasState(SP_BLOB_NAME, protectorId, userId);
    }

    public void destroyTokenBasedProtector(long protectorId, int userId) {
        Slogf.i(TAG, "Destroying token-based protector %016x for user %d", new Object[]{Long.valueOf(protectorId), Integer.valueOf(userId)});
        SyntheticPasswordBlob blob = SyntheticPasswordBlob.fromBytes(loadState(SP_BLOB_NAME, protectorId, userId));
        destroyProtectorCommon(protectorId, userId);
        if (blob.mProtectorType != 2) goto L6;
        notifyWeakEscrowTokenRemovedListeners(protectorId, userId);
        return;
    }

    public void destroyAllWeakTokenBasedProtectors(int userId) {
        List<Long> protectorIds = this.mStorage.listSyntheticPasswordProtectorsForUser(SP_BLOB_NAME, userId);
        Iterator<Long> r2 = protectorIds.iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        long protectorId = r2.next().longValue();
        SyntheticPasswordBlob blob = SyntheticPasswordBlob.fromBytes(loadState(SP_BLOB_NAME, protectorId, userId));
        if (blob.mProtectorType != 2) goto L4;
        destroyTokenBasedProtector(protectorId, userId);
        goto L4
    }

    public void destroyLskfBasedProtector(long protectorId, int userId) {
        Slogf.i(TAG, "Destroying LSKF-based protector %016x for user %d", new Object[]{Long.valueOf(protectorId), Integer.valueOf(userId)});
        destroyProtectorCommon(protectorId, userId);
        destroyState(PASSWORD_DATA_NAME, protectorId, userId);
        destroyState(PASSWORD_METRICS_NAME, protectorId, userId);
    }

    private void destroyProtectorCommon(long protectorId, int userId) {
        destroyState(SP_BLOB_NAME, protectorId, userId);
        destroyProtectorKey(getProtectorKeyAlias(protectorId));
        destroyState(SECDISCARDABLE_NAME, protectorId, userId);
        if (hasState(WEAVER_SLOT_NAME, protectorId, userId) == false) goto L6;
        destroyWeaverSlot(protectorId, userId);
        return;
    }

    private byte[] transformUnderWeaverSecret(byte[] data, byte[] secret) {
        byte[] weaverSecret = SyntheticPasswordCrypto.personalizedHash(PERSONALIZATION_WEAVER_PASSWORD, new byte[][]{secret});
        return ArrayUtils.concat(new byte[][]{data, weaverSecret});
    }

    private byte[] transformUnderSecdiscardable(byte[] data, byte[] rawSecdiscardable) {
        byte[] secdiscardable = SyntheticPasswordCrypto.personalizedHash(PERSONALIZATION_SECDISCARDABLE, new byte[][]{rawSecdiscardable});
        return ArrayUtils.concat(new byte[][]{data, secdiscardable});
    }

    private byte[] createSecdiscardable(long protectorId, int userId) {
        byte[] data = SecureRandomUtils.randomBytes(16384);
        saveSecdiscardable(protectorId, data, userId);
        return data;
    }

    private void saveSecdiscardable(long protectorId, byte[] secdiscardable, int userId) {
        saveState(SECDISCARDABLE_NAME, secdiscardable, protectorId, userId);
    }

    private byte[] loadSecdiscardable(long protectorId, int userId) {
        return loadState(SECDISCARDABLE_NAME, protectorId, userId);
    }

    private byte getTokenBasedProtectorType(int type) {
        switch(type) {
            case 1: goto L5;
            default: goto L3;
        };
    L3:
        return 1;
    L5:
        return 2;
    }

    boolean hasPasswordData(long protectorId, int userId) {
        return hasState(PASSWORD_DATA_NAME, protectorId, userId);
    }

    public PasswordMetrics getPasswordMetrics(SyntheticPassword sp, long protectorId, int userId) {
        byte[] encrypted = loadState(PASSWORD_METRICS_NAME, protectorId, userId);
        if (encrypted != null) goto L6;
        Slogf.e(TAG, "Failed to read password metrics file for user %d", new Object[]{Integer.valueOf(userId)});
        return null;
    L6:
        byte[] decrypted = SyntheticPasswordCrypto.decrypt(sp.deriveMetricsKey(), new byte[0], encrypted);
        if (decrypted != null) goto L11;
        Slogf.e(TAG, "Failed to decrypt password metrics file for user %d", new Object[]{Integer.valueOf(userId)});
        return null;
    L11:
        return VersionedPasswordMetrics.deserialize(decrypted).getMetrics();
    }

    private void savePasswordMetrics(LockscreenCredential credential, SyntheticPassword sp, long protectorId, int userId) {
        byte[] encrypted = SyntheticPasswordCrypto.encrypt(sp.deriveMetricsKey(), new byte[0], new VersionedPasswordMetrics(credential).serialize());
        saveState(PASSWORD_METRICS_NAME, encrypted, protectorId, userId);
    }

    boolean hasPasswordMetrics(long protectorId, int userId) {
        return hasState(PASSWORD_METRICS_NAME, protectorId, userId);
    }

    private boolean hasState(String stateName, long protectorId, int userId) {
        return !ArrayUtils.isEmpty(loadState(stateName, protectorId, userId));
    }

    private byte[] loadState(String stateName, long protectorId, int userId) {
        return this.mStorage.readSyntheticPasswordState(userId, protectorId, stateName);
    }

    private void saveState(String stateName, byte[] data, long protectorId, int userId) {
        this.mStorage.writeSyntheticPasswordState(userId, protectorId, stateName, data);
    }

    private void syncState(int userId) {
        this.mStorage.syncSyntheticPasswordState(userId);
    }

    private void destroyState(String stateName, long protectorId, int userId) {
        this.mStorage.deleteSyntheticPasswordState(userId, protectorId, stateName);
    }

    protected byte[] decryptSpBlob(String protectorKeyAlias, byte[] blob, byte[] protectorSecret) {
        return SyntheticPasswordCrypto.decryptBlob(protectorKeyAlias, blob, protectorSecret);
    }

    protected byte[] createSpBlob(String protectorKeyAlias, byte[] data, byte[] protectorSecret, long sid) {
        return SyntheticPasswordCrypto.createBlob(protectorKeyAlias, data, protectorSecret, sid);
    }

    protected void destroyProtectorKey(String keyAlias) {
        SyntheticPasswordCrypto.destroyProtectorKey(keyAlias);
    }

    private static long generateProtectorId() {
    L2:
        long result = SecureRandomUtils.randomLong();
        if (result == 0) goto L2;
        return result;
    }

    static int fakeUserId(int userId) {
        return BZip2Constants.BASEBLOCKSIZE + userId;
    }

    private String getProtectorKeyAlias(long protectorId) {
        return TextUtils.formatSimple("%s%x", new Object[]{PROTECTOR_KEY_ALIAS_PREFIX, Long.valueOf(protectorId)});
    }

    byte[] stretchLskf(LockscreenCredential credential, PasswordData data) {
        if (credential.isNone() == false) goto L5;
        byte[] r0 = DEFAULT_PASSWORD;
    L6:
        byte[] password = r0;
        if (data != null) goto L11;
        Preconditions.checkArgument(credential.isNone());
        return Arrays.copyOf(password, 32);
    L11:
        return scrypt(password, data.salt, 1 << data.scryptLogN, 1 << data.scryptLogR, 1 << data.scryptLogP, 32);
    L5:
        r0 = credential.getCredential();
        goto L6
    }

    private byte[] stretchedLskfToGkPassword(byte[] stretchedLskf) {
        return SyntheticPasswordCrypto.personalizedHash(PERSONALIZATION_USER_GK_AUTH, new byte[][]{stretchedLskf});
    }

    private byte[] stretchedLskfToWeaverKey(byte[] stretchedLskf) {
        byte[] key = SyntheticPasswordCrypto.personalizedHash(PERSONALIZATION_WEAVER_KEY, new byte[][]{stretchedLskf});
        if (key.length < this.mWeaverConfig.keySize) goto L7;
        return Arrays.copyOf(key, this.mWeaverConfig.keySize);
    L7:
        throw new IllegalArgumentException("weaver key length too small");
    }

    protected long sidFromPasswordHandle(byte[] handle) {
        return nativeSidFromPasswordHandle(handle);
    }

    protected byte[] scrypt(byte[] password, byte[] salt, int n, int r, int p, int outLen) {
        return new Scrypt().scrypt(password, salt, n, r, p, outLen);
    }

    static byte[] bytesToHex(byte[] bytes) {
        return HexEncoding.encodeToString(bytes).getBytes();
    }

    public boolean migrateKeyNamespace() {
        boolean success = true;
        Map<Integer, List<Long>> allProtectors = this.mStorage.listSyntheticPasswordProtectorsForAllUsers(SP_BLOB_NAME);
        Iterator<List<Long>> r2 = allProtectors.values().iterator();
    L4:
        if (r2.hasNext() == false) goto L10;
        List<Long> userProtectors = r2.next();
        Iterator<Long> r4 = userProtectors.iterator();
    L7:
        if (r4.hasNext() == false) goto L4;
        long protectorId = r4.next().longValue();
        success = success & SyntheticPasswordCrypto.migrateLockSettingsKey(getProtectorKeyAlias(protectorId));
        goto L7
    L10:
        return success;
    }

    public boolean registerWeakEscrowTokenRemovedListener(IWeakEscrowTokenRemovedListener listener) {
        return this.mListeners.register(listener);
    }

    public boolean unregisterWeakEscrowTokenRemovedListener(IWeakEscrowTokenRemovedListener listener) {
        return this.mListeners.unregister(listener);
    }

    private void notifyWeakEscrowTokenRemovedListeners(long protectorId, int userId) {
        int i = this.mListeners.beginBroadcast();
    L3:
        if (i <= 0) goto L14;
        i = i - 1;
        this.mListeners.getBroadcastItem(i).onWeakEscrowTokenRemoved(protectorId, userId);     // Catch: Throwable -> L7 RemoteException -> L9
    L7:
        th = move-exception;
        this.mListeners.finishBroadcast();
        throw th;
    L9:
        e = move-exception;
        Slog.e(TAG, "Exception while notifying WeakEscrowTokenRemovedListener.", e);     // Catch: Throwable -> L7
        goto L3
    L14:
        this.mListeners.finishBroadcast();
    }

    public void writeVendorAuthSecret(byte[] vendorAuthSecret, SyntheticPassword sp, int userId) {
        byte[] encrypted = SyntheticPasswordCrypto.encrypt(sp.deriveVendorAuthSecretEncryptionKey(), new byte[0], vendorAuthSecret);
        saveState(VENDOR_AUTH_SECRET_NAME, encrypted, 0, userId);
        syncState(userId);
    }

    public byte[] readVendorAuthSecret(SyntheticPassword sp, int userId) {
        byte[] encrypted = loadState(VENDOR_AUTH_SECRET_NAME, 0, userId);
        if (encrypted != null) goto L7;
        return null;
    L7:
        return SyntheticPasswordCrypto.decrypt(sp.deriveVendorAuthSecretEncryptionKey(), new byte[0], encrypted);
    }
}
