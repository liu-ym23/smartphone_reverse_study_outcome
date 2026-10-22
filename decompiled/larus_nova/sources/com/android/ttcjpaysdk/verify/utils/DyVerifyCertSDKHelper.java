package com.android.ttcjpaysdk.verify.utils;

import android.content.Context;
import com.android.ttcjpaysdk.verify.data.DyVerifyQueryCertRes;
import com.bytedance.caijing.sdk.infra.base.api.env.CJHostService;
import com.bytedance.caijing.sdk.infra.base.api.sec.CJSecService;
import com.bytedance.caijing.sdk.infra.base.api.sec.EncryptVendor;
import com.bytedance.caijing.sdk.infra.base.encrypt.CJEncrypt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me4.a;
import we4.b;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 %2\u00020\u0001:\u0001%B\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b#\u0010$J\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002J\"\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005J\u0018\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0018\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\r\u001a\u00020\fJ*\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005J\u001e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005J'\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u00182\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lcom/android/ttcjpaysdk/verify/utils/DyVerifyCertSDKHelper;", "", "Lwe4/b;", "Lcom/android/ttcjpaysdk/verify/data/DyVerifyQueryCertRes$DyVerifyCertInfo;", "encryptCertQuery", "", "csr", "q1Id", "encryptGenPartCsr", "encryptGenCsr", "csrData", "encryptCertInstall", "", "encryptCertUninstall", "signFactor", "signFactorId", "originData", "encryptCertSignData", "prefix", "errCode", "errMsg", "buildErrMsgForBusiness", "rawCode", "rawMsg", "", "parseErrMsgForBusiness", "(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;", "Landroid/content/Context;", "ctx", "Landroid/content/Context;", "pin", "Ljava/lang/String;", "Lcom/bytedance/caijing/sdk/infra/base/api/sec/CJSecService$a;", "certController", "Lcom/bytedance/caijing/sdk/infra/base/api/sec/CJSecService$a;", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "Companion", "dy-verify-sdk_release"}, k = 1, mv = {1, 6, 0})
public final class DyVerifyCertSDKHelper {
    public static final Companion Companion = null;
    private CJSecService.a certController;
    private final Context ctx;
    private String pin;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/verify/utils/DyVerifyCertSDKHelper$Companion;", "", "()V", "getPin", "", "dy-verify-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final String getPin() {
            b r100 = CJEncrypt.b();
            if (r100.a() == true) goto L7;
            return null;
        L7:
            return (String) r100.f559397c;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public final b<DyVerifyQueryCertRes.DyVerifyCertInfo> encryptCertQuery() {
        String r100 = this.pin;
        if (r100 != null) goto L5;
    L21:
        int r101 = b.f559394d;
        return b.a.a(-1, "pin is invalid or checkCertInstall failed", null);
    L5:
        if ((!StringsKt.isBlank(r100)) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L21;
        b<a> r102 = this.certController.d(this.ctx, r100);
        if (r102.a() == false) goto L12;
        b<a> r103 = r102;
    L13:
        if (r103 == null) goto L16;
        a r104 = r103.f559397c;
        if (r104 == null) goto L16;
    L17:
        if (r104 == null) goto L19;
        int r105 = b.f559394d;
        return b.a.b(new DyVerifyQueryCertRes.DyVerifyCertInfo(r104.f513470a, r104.f513471b, r104.f513474e / ((long) 1000), null, 8, null));
    L19:
        int r106 = b.f559394d;
        return b.a.a(r102.f559395a, r102.f559396b, null);
    L16:
        r104 = null;
        goto L17
    L12:
        r103 = null;
        goto L13
    }

    public final boolean encryptCertUninstall() {
        String r100 = this.pin;
        if (r100 != null) goto L5;
        return false;
    L5:
        if ((!StringsKt.isBlank(r100)) == true) goto L8;
        r100 = null;
    L8:
        if (r100 != null) goto L10;
        return false;
    L10:
        return this.certController.b(this.ctx, r100).a();
    }

    public final b<String> encryptCertInstall(String r100) {
        if (r100 == null) goto L24;
        boolean r101 = true;
        if ((!StringsKt.isBlank(r100)) == false) goto L14;
        String r102 = this.pin;
        if (r102 != null) goto L9;
    L11:
        boolean r103 = false;
    L12:
        if (r103 == false) goto L14;
    L15:
        if (r101 == true) goto L18;
        r100 = null;
    L18:
        if (r100 == null) goto L24;
        CJSecService.a r104 = this.certController;
        Context r105 = this.ctx;
        String r106 = this.pin;
        Intrinsics.checkNotNull(r106);
        b<String> r107 = r104.c(r105, r106, r100);
        if (r107.a() == false) goto L22;
        int r108 = b.f559394d;
        String r109 = this.pin;
        Intrinsics.checkNotNull(r109);
        return b.a.b(r109);
    L22:
        int r110 = b.f559394d;
        return b.a.a(r107.f559395a, r107.f559396b, null);
    L9:
        if ((!StringsKt.isBlank(r102)) != true) goto L11;
        r103 = true;
    L14:
        r101 = false;
    L24:
        int r111 = b.f559394d;
        return b.a.a(-1, "pin or csrData is invalid", null);
    }

    public final b<String> encryptGenCsr(String r100) {
        if (r100 == null) goto L24;
        boolean r101 = true;
        if ((!StringsKt.isBlank(r100)) == false) goto L14;
        String r102 = this.pin;
        if (r102 != null) goto L9;
    L11:
        boolean r103 = false;
    L12:
        if (r103 == false) goto L14;
    L15:
        if (r101 == true) goto L18;
        r100 = null;
    L18:
        if (r100 == null) goto L24;
        CJSecService.a r104 = this.certController;
        Context r105 = this.ctx;
        String r106 = this.pin;
        Intrinsics.checkNotNull(r106);
        b<String> r107 = r104.f(r105, r106, r100);
        if (r107.a() == false) goto L22;
        int r108 = b.f559394d;
        return b.a.b(r107.f559397c);
    L22:
        int r109 = b.f559394d;
        return b.a.a(r107.f559395a, r107.f559396b, null);
    L9:
        if ((!StringsKt.isBlank(r102)) != true) goto L11;
        r103 = true;
    L14:
        r101 = false;
    L24:
        int r110 = b.f559394d;
        return b.a.a(-1, "pin or csr is invalid", null);
    }

    public DyVerifyCertSDKHelper(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        this.ctx = r100;
        this.pin = r101;
        this.certController = ((CJSecService) CJEncrypt.f202287a.getValue()).getCertController(EncryptVendor.CCIT);
        String r102 = this.pin;
        if (r102 != null) goto L5;
    L10:
        r102 = Companion.getPin();
    L11:
        this.pin = r102;
        return;
    L5:
        if ((!StringsKt.isBlank(r102)) == true) goto L8;
        r102 = null;
    L8:
        if (r102 == null) goto L10;
        goto L10
    }

    public final b<String> encryptGenPartCsr(String r100, String r101) {
        String r102 = this.pin;
        boolean r103 = false;
        if (r102 != null) goto L5;
    L7:
        boolean r104 = false;
    L9:
        if (r104 == false) goto L25;
        if (r100 != null) goto L12;
    L14:
        boolean r105 = false;
    L15:
        if (r105 == false) goto L25;
        if (r101 != null) goto L18;
    L20:
        if (r103 == false) goto L25;
        CJSecService.a r106 = this.certController;
        Context r107 = this.ctx;
        String r108 = this.pin;
        Intrinsics.checkNotNull(r108);
        b<String> r109 = r106.a(r107, r108, r100, r101);
        if (r109.a() == false) goto L24;
        int r110 = b.f559394d;
        return b.a.b(r109.f559397c);
    L24:
        int r111 = b.f559394d;
        return b.a.a(r109.f559395a, r109.f559396b, null);
    L18:
        if ((!StringsKt.isBlank(r101)) != true) goto L20;
        r103 = true;
        goto L20
    L12:
        if ((!StringsKt.isBlank(r100)) != true) goto L14;
        r105 = true;
    L25:
        int r112 = b.f559394d;
        return b.a.a(-1, "pin or csr or q1Id is invalid", null);
    L5:
        if ((!StringsKt.isBlank(r102)) != true) goto L7;
        r104 = true;
        goto L9
    }

    public final String[] parseErrMsgForBusiness(String r100, String r101) {
        return this.certController.parseErrMsgForBusiness(r100, r101);
    }

    public final String buildErrMsgForBusiness(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "prefix");
        Intrinsics.checkNotNullParameter(r101, "errCode");
        Intrinsics.checkNotNullParameter(r102, "errMsg");
        return this.certController.g(r100, r101, r102);
    }

    public final b<String> encryptCertSignData(String r110, String r111, String r112) {
        String r100 = this.pin;
        if (r100 == null) goto L40;
        boolean r101 = true;
        if ((!StringsKt.isBlank(r100)) == false) goto L25;
        if (r112 != null) goto L8;
    L10:
        boolean r102 = false;
    L11:
        if (r102 == false) goto L25;
        if (r110 != null) goto L14;
    L16:
        boolean r103 = false;
    L17:
        if (r103 == false) goto L25;
        if (r111 != null) goto L20;
    L22:
        boolean r104 = false;
    L23:
        if (r104 == false) goto L25;
    L26:
        if (r101 == true) goto L29;
        r100 = null;
    L29:
        if (r100 == null) goto L40;
        ve4.a.f554342a.getClass();
        CJHostService r105 = (CJHostService) ve4.a.a(CJHostService.class);
        if (r105 == null) goto L34;
        String r106 = r105.getHostAid();
        if (r106 == null) goto L34;
    L35:
        CJSecService.a r107 = this.certController;
        Context r108 = this.ctx;
        String r109 = this.pin;
        Intrinsics.checkNotNull(r109);
        Intrinsics.checkNotNull(r112);
        String r113 = this.pin;
        Intrinsics.checkNotNull(r113);
        Intrinsics.checkNotNull(r110);
        Intrinsics.checkNotNull(r111);
        b<me4.b> r114 = r107.e(r108, r109, r112, r106, r113, r110, r111);
        if (r114.a() == false) goto L38;
        int r115 = b.f559394d;
        return b.a.b(r114.f559397c.f513477a);
    L38:
        int r116 = b.f559394d;
        return b.a.a(r114.f559395a, r114.f559396b, "");
    L34:
        r106 = "1128";
        goto L35
    L20:
        if ((!StringsKt.isBlank(r111)) != true) goto L22;
        r104 = true;
        goto L23
    L14:
        if ((!StringsKt.isBlank(r110)) != true) goto L16;
        r103 = true;
        goto L17
    L8:
        if ((!StringsKt.isBlank(r112)) != true) goto L10;
        r102 = true;
    L25:
        r101 = false;
    L40:
        int r117 = b.f559394d;
        return b.a.a(-1, "signDataWithCert invoke failed for params invalid", "");
    }
}
