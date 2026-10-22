package com.bytedance.crypto.cloudsync;

import android.content.Context;
import com.bytedance.crypto.cloudsync.network.CloudConfig;
import com.bytedance.crypto.keymanager.SyncKeyManager;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.LogUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public class CryptoContext {
    public static final String TAG = "CryptoContext";
    private String mAppId;
    private Context mContext;
    private SecretKey mFileEncryptKey;
    private byte[] mFileKeyCipher;
    private String mFilePath;

    public CryptoContext(Context r3, String r4, String r5) {
        this.mContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.mFilePath = r4;
        this.mAppId = r5;
    }

    private static SecretKey constructChaCha20Key(byte[] r2) {
        return new SecretKeySpec(r2, "ChaCha20");
    }

    public void deinitFileKey() {
        this.mFileEncryptKey = null;
        this.mFileKeyCipher = new byte[0];
    }

    public String getAppId() {
        return this.mAppId;
    }

    public Context getContext() {
        return this.mContext;
    }

    public SecretKey getFileEncryptKey() {
        return this.mFileEncryptKey;
    }

    public byte[] getFileKeyCipher() {
        return this.mFileKeyCipher;
    }

    public String getFilePath() {
        return this.mFilePath;
    }

    public boolean initFileDecryptKey(byte[] r10) {
        if (this.mContext != null) goto L7;
        LogUtils.e(TAG, "Context is null!!");
        String r5 = this.mAppId;
        int r2 = -2;
        int r3 = 3;
        long r6 = 0;
        int r8 = 0;
        String r4 = "";
    L5:
        EventTrace.eventTrace(r2, r3, r4, r5, r6, r8);
        return false;
    L7:
        String r0 = TAG;
        LogUtils.i(r0, "file key cipher len:" + r10.length);
        byte[] r7 = SyncKeyManager.getInstance().decryptByKeyManager(this.mContext, this.mAppId, r10, CloudConfig.getInstance().getPkgName(this.mAppId) + this.mAppId);
        if (r7 != null) goto L10;
    L14:
        LogUtils.e(r0, "File key decrypt failed!! key cipher len:" + r10.length);
        r4 = this.mContext.getPackageName();
        r5 = this.mAppId;
        r2 = -4;
        r3 = 3;
        r6 = 0;
        r8 = 0;
        goto L5
    L10:
        if (r7.length == 0) goto L14;
        this.mFileEncryptKey = constructChaCha20Key(r7);
        EventTrace.eventTrace(0, 3, this.mContext.getPackageName(), this.mAppId, 0, 0);
        return true;
    }

    public boolean initFileEncryptKey() {
        if (this.mContext != null) goto L6;
        LogUtils.e(TAG, "Context is null!!");
        EventTrace.eventTrace(-2, 2, "", this.mAppId, 0, 0);
        return false;
    L6:
        SecretKey r0 = CryptoUtils.generateSymmetricKey("ChaCha20", 32);
        if (r0 != null) goto L10;
        LogUtils.e(TAG, "Generate file encrypt key failed!!");
        EventTrace.eventTrace(-100, 2, this.mContext.getPackageName(), this.mAppId, 0, 0);
        return false;
    L10:
        String r2 = TAG;
        LogUtils.d(r2, "file key len:" + r0.getEncoded().length);
        byte[] r3 = SyncKeyManager.getInstance().encryptByKeyManager(this.mContext, this.mAppId, r0.getEncoded(), CloudConfig.getInstance().getPkgName(this.mAppId) + this.mAppId);
        if (r3 != null) goto L13;
    L17:
        LogUtils.e(r2, "File key encrypt failed!!");
        EventTrace.eventTrace(-4, 2, this.mContext.getPackageName(), this.mAppId, 0, 0);
        return false;
    L13:
        if (r3.length == 0) goto L17;
        byte[] r4 = new byte[r3.length];
        this.mFileKeyCipher = r4;
        System.arraycopy(r3, 0, r4, 0, r3.length);
        this.mFileEncryptKey = r0;
        EventTrace.eventTrace(0, 2, this.mContext.getPackageName(), this.mAppId, 0, 0);
        return true;
    }
}
