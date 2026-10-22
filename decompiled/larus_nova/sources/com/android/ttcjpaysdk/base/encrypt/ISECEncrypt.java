package com.android.ttcjpaysdk.base.encrypt;

import android.util.Base64;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.caijing.sdk.infra.base.api.env.INetEnv;
import com.bytedance.caijing.sdk.infra.base.api.sec.CJSecService;
import com.bytedance.caijing.sdk.infra.base.encrypt.CJEncrypt;
import com.bytedance.caijing.sdk.infra.base.env.CJEnv;
import com.huawei.hms.framework.common.ContainerUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import we4.b;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0016J\"\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/android/ttcjpaysdk/base/encrypt/ISECEncrypt;", "Lcom/android/ttcjpaysdk/base/encrypt/CJPayEncryptProxy;", "()V", "secService", "Lcom/bytedance/caijing/sdk/infra/base/api/sec/CJSecService;", "getSecService", "()Lcom/bytedance/caijing/sdk/infra/base/api/sec/CJSecService;", "secService$delegate", "Lkotlin/Lazy;", "getDecryptDataSM", "", "bizScene", "Lcom/android/ttcjpaysdk/base/encrypt/CJEncryptScene;", "encryptedData", "getEncryptDataSM", "rawData", "publicKey", "getEncryptVersion", "", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ISECEncrypt implements CJPayEncryptProxy {
    public static final Companion Companion = null;
    private static final String ISEC_BOE_KEY = "BDp46nfioDU9dw+hDiWRCq7GN1SwsUkuBUV48tJh8q8wfzWahwojayB6ukmSVNqRBDBs+9SChmGK1ygJqZ1rmCM=";
    private static final String ISEC_ONLINE_KEY = "BLGfAX+1hJstOC2J1wOzio2GIU3WliZKr1K1ssAju2bIKzx7QExY37EzG/LmEbDu2KSdwP7XgZBM1VkzVsYVWYk=";
    private final Lazy secService$delegate;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/base/encrypt/ISECEncrypt$Companion;", "", "()V", "ISEC_BOE_KEY", "", "ISEC_ONLINE_KEY", "getIsecKey", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final String getIsecKey() {
            INetEnv r100 = CJEnv.j();
            boolean r101 = false;
            if (r100 != null) goto L5;
        L7:
            if (r101 == true) goto L9;
            return ISECEncrypt.ISEC_ONLINE_KEY;
        L9:
            return ISECEncrypt.ISEC_BOE_KEY;
        L5:
            if (r100.isBoe() != true) goto L7;
            r101 = true;
            goto L7
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // com.android.ttcjpaysdk.base.encrypt.CJPayEncryptProxy
    public int getEncryptVersion() {
        return 20;
    }

    private final CJSecService getSecService() {
        return (CJSecService) this.secService$delegate.getValue();
    }

    public ISECEncrypt() {
        this.secService$delegate = LazyKt.lazy(ISECEncrypt$secService$2.INSTANCE);
    }

    @Override // com.android.ttcjpaysdk.base.encrypt.CJPayEncryptProxy
    public String getDecryptDataSM(CJEncryptScene r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "bizScene");
        Intrinsics.checkNotNullParameter(r101, "encryptedData");
        if (r101.length() != 0) goto L5;
        boolean r102 = true;
    L7:
        if (r102 == false) goto L18;
        return "";
    L18:
        b<String> r103 = getSecService().messageDecrypt(Base64.decode(r101, 2));     // Catch: Exception -> L15
        if (r103.a() == true) goto L12;
        CJPayEncryptUploadUtil.Companion.walletEnigmaErrorUpload(r100, "decrypt", r103.f559397c, "解密失败");     // Catch: Exception -> L15
    L17:
        return "";
    L12:
        return r103.f559397c;
    L15:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("ISECEncrypt#getDecryptDataSM", e);
        CJBasicCommonUtils.logCatch("CJCatch", "ISECEncrypt#getDecryptDataSM", e);
        e.printStackTrace();
        CJPayEncryptUploadUtil.Companion.walletEnigmaErrorUpload(r100, "decrypt", "", "解密异常:" + e.getMessage());
        goto L17
    L5:
        r102 = false;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.android.ttcjpaysdk.base.encrypt.CJPayEncryptProxy
    public synchronized String getEncryptDataSM(CJEncryptScene r110, String r111, String r210) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r110, "bizScene");     // Catch: Throwable -> L40
        Intrinsics.checkNotNullParameter(r111, "rawData");     // Catch: Throwable -> L40
        boolean r100 = false;
        if (r111.length() != 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == true) goto L10;
        if (r210 != null) goto L44;
    L18:
        r100 = true;
    L19:
        if (r100 == false) goto L21;
        String r102 = Companion.getIsecKey();     // Catch: Exception -> L16 Throwable -> L40
    L22:
        Lazy r103 = CJEncrypt.f202287a;     // Catch: Exception -> L16 Throwable -> L40
        b r104 = CJEncrypt.a(r111.getBytes(Charsets.UTF_8), r102, 20, r110.getSceneValue());     // Catch: Exception -> L16 Throwable -> L40
        String r105 = Base64.encodeToString((byte[]) r104.f559397c, 3);     // Catch: Exception -> L16 Throwable -> L40
        if (r104.a() == false) goto L27;
        String r106 = new Regex(ContainerUtils.KEY_VALUE_DELIMITER).replace(StringsKt.replace$default(StringsKt.replace$default(r105, '+', '-', false, 4, null), '/', '_', false, 4, null), "");     // Catch: Exception -> L16 Throwable -> L40
        monitor-exit(this);
        return r106;
    L27:
        CJPayEncryptUploadUtil.Companion r107 = CJPayEncryptUploadUtil.Companion;     // Catch: Exception -> L16 Throwable -> L40
        String r108 = Integer.valueOf(r104.f559395a).toString();     // Catch: Exception -> L16 Throwable -> L40
        if (r108 != null) goto L30;
        r108 = "";
    L30:
        String r109 = r104.f559396b;     // Catch: Exception -> L16 Throwable -> L40
        if (r109 == null) goto L33;
        String r112 = KtSafeMethodExtensionKt.ifNullOrBlank(r109, AnonymousClass1.INSTANCE);     // Catch: Exception -> L16 Throwable -> L40
    L34:
        r107.walletEnigmaErrorUpload(r110, LBSLightLocationTraceLogger.ENCRYPT, r108, r112);     // Catch: Exception -> L16 Throwable -> L40
    L38:
        monitor-exit(this);
        return "";
    L33:
        r112 = null;
        goto L34
    L21:
        r102 = r210;
        goto L22
    L44:
    L16:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("ISECEncrypt#getEncryptDataSM", e);     // Catch: Throwable -> L40
        CJBasicCommonUtils.logCatch("CJCatch", "ISECEncrypt#getEncryptDataSM", e);     // Catch: Throwable -> L40
        e.printStackTrace();     // Catch: Throwable -> L40
        CJPayEncryptUploadUtil.Companion.walletEnigmaErrorUpload(r110, LBSLightLocationTraceLogger.ENCRYPT, "", "加密异常:" + e.getMessage());     // Catch: Throwable -> L40
        goto L38
    L14:
        if (r210.length() != 0) goto L19;
    L10:
        monitor-exit(this);
        return "";
    L7:
        r101 = false;
    L40:
        th = move-exception;
        throw th;
    }
}
