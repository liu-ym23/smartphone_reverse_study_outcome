package com.android.ttcjpaysdk.verify.data.product;

import com.android.ttcjpaysdk.base.service.DyVerifyFlow;
import com.bytedance.android.ec.core.event.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016R\u0012\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/verify/data/product/DyVerifyFingerPrint;", "Lcom/android/ttcjpaysdk/verify/data/product/DyVerifyBase;", "toast", "", "uid", "aid", a.KEY_DID, "verify_type", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "vmFlowType", "Lcom/android/ttcjpaysdk/base/service/DyVerifyFlow;", "getVmFlowType", "()Lcom/android/ttcjpaysdk/base/service/DyVerifyFlow;", "isValid", "", "needMask", "dy-verify-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DyVerifyFingerPrint extends DyVerifyBase {
    public String aid;
    public String did;
    public String toast;
    public String uid;
    public String verify_type;
    private final DyVerifyFlow vmFlowType;

    public DyVerifyFingerPrint() {
        this(null, null, null, null, null, 31, null);
    }

    @Override // com.android.ttcjpaysdk.verify.data.product.DyVerifyBase
    public boolean needMask() {
        return true;
    }

    @Override // com.android.ttcjpaysdk.verify.data.product.DyVerifyBase
    public boolean isValid() {
        if (Intrinsics.areEqual(this.verify_type, "FINGER") == true) goto L5;
    L13:
        return false;
    L5:
        if ((!StringsKt.isBlank(this.uid)) == false) goto L13;
        if ((!StringsKt.isBlank(this.merchant_id)) == false) goto L13;
        if ((!StringsKt.isBlank(this.app_id)) == false) goto L13;
        if ((!StringsKt.isBlank(this.did)) == false) goto L13;
        return true;
    }

    @Override // com.android.ttcjpaysdk.verify.data.product.DyVerifyBase
    public DyVerifyFlow getVmFlowType() {
        return this.vmFlowType;
    }

    public DyVerifyFingerPrint(String r110, String r111, String r112, String r113, String r114) {
        Intrinsics.checkNotNullParameter(r110, "toast");
        Intrinsics.checkNotNullParameter(r111, "uid");
        Intrinsics.checkNotNullParameter(r112, "aid");
        Intrinsics.checkNotNullParameter(r113, a.KEY_DID);
        Intrinsics.checkNotNullParameter(r114, "verify_type");
        super(null, null, null, null, null, 31, null);
        this.toast = r110;
        this.uid = r111;
        this.aid = r112;
        this.did = r113;
        this.verify_type = r114;
        this.vmFlowType = DyVerifyFlow.BIO;
    }

    public /* synthetic */ DyVerifyFingerPrint(String r100, String r101, String r102, String r103, String r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = "";
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r105 = "";
    L11:
        if ((r110 & 4) == 0) goto L13;
        String r106 = "";
    L15:
        if ((r110 & 8) == 0) goto L17;
        String r107 = "";
    L19:
        if ((r110 & 16) == 0) goto L21;
        String r113 = "";
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
