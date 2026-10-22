package com.android.ttcjpaysdk.verify.data.product;

import com.android.ttcjpaysdk.base.service.DyVerifyFlow;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001Bo\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\u0018\b\u0002\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003¢\u0006\u0002\u0010\u0011J\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u0019H\u0016R\u0012\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/android/ttcjpaysdk/verify/data/product/DyVerifyPopup;", "Lcom/android/ttcjpaysdk/verify/data/product/DyVerifyBase;", "title", "", "content", "button_forward", "Lcom/android/ttcjpaysdk/verify/data/product/PopupButtonInfo;", "button_backward", "button_single", "timeout", "", "icon_url", "content_list", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/verify/data/product/ContentListItem;", "Lkotlin/collections/ArrayList;", "time_color", "(Ljava/lang/String;Ljava/lang/String;Lcom/android/ttcjpaysdk/verify/data/product/PopupButtonInfo;Lcom/android/ttcjpaysdk/verify/data/product/PopupButtonInfo;Lcom/android/ttcjpaysdk/verify/data/product/PopupButtonInfo;ILjava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;)V", "vmFlowType", "Lcom/android/ttcjpaysdk/base/service/DyVerifyFlow;", "getVmFlowType", "()Lcom/android/ttcjpaysdk/base/service/DyVerifyFlow;", "setVmFlowType", "(Lcom/android/ttcjpaysdk/base/service/DyVerifyFlow;)V", "isSingleDialog", "", "isValid", "dy-verify-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DyVerifyPopup extends DyVerifyBase {
    public PopupButtonInfo button_backward;
    public PopupButtonInfo button_forward;
    public PopupButtonInfo button_single;
    public String content;
    public ArrayList<ContentListItem> content_list;
    public String icon_url;
    public String time_color;
    public int timeout;
    public String title;
    private DyVerifyFlow vmFlowType;

    public DyVerifyPopup() {
        this(null, null, null, null, null, 0, null, null, null, 511, null);
    }

    public final boolean isSingleDialog() {
        return !StringsKt.isBlank(this.button_single.label);
    }

    @Override // com.android.ttcjpaysdk.verify.data.product.DyVerifyBase
    public boolean isValid() {
        if ((!StringsKt.isBlank(this.button_single.label)) == false) goto L5;
        return true;
    L5:
        if ((!StringsKt.isBlank(this.button_forward.label)) == false) goto L7;
        return true;
    L7:
        if ((!StringsKt.isBlank(this.button_backward.label)) == true) goto L13;
        return false;
    L13:
        return true;
    }

    @Override // com.android.ttcjpaysdk.verify.data.product.DyVerifyBase
    public DyVerifyFlow getVmFlowType() {
        return this.vmFlowType;
    }

    public void setVmFlowType(DyVerifyFlow r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.vmFlowType = r100;
    }

    public DyVerifyPopup(String r110, String r111, PopupButtonInfo r210, PopupButtonInfo r211, PopupButtonInfo r212, int r213, String r214, ArrayList<ContentListItem> r215, String r216) {
        Intrinsics.checkNotNullParameter(r110, "title");
        Intrinsics.checkNotNullParameter(r111, "content");
        Intrinsics.checkNotNullParameter(r210, "button_forward");
        Intrinsics.checkNotNullParameter(r211, "button_backward");
        Intrinsics.checkNotNullParameter(r212, "button_single");
        Intrinsics.checkNotNullParameter(r214, "icon_url");
        Intrinsics.checkNotNullParameter(r215, "content_list");
        Intrinsics.checkNotNullParameter(r216, "time_color");
        super(null, null, null, null, null, 31, null);
        this.title = r110;
        this.content = r111;
        this.button_forward = r210;
        this.button_backward = r211;
        this.button_single = r212;
        this.timeout = r213;
        this.icon_url = r214;
        this.content_list = r215;
        this.time_color = r216;
        this.vmFlowType = DyVerifyFlow.POPUP;
    }

    public /* synthetic */ DyVerifyPopup(String r110, String r111, PopupButtonInfo r112, PopupButtonInfo r113, PopupButtonInfo r210, int r211, String r212, ArrayList r213, String r214, int r215, DefaultConstructorMarker r216) {
        String r100 = "";
        if ((r215 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r215 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r215 & 4) == 0) goto L13;
        PopupButtonInfo r103 = new PopupButtonInfo(null, null, null, true, null, 23, null);
    L15:
        if ((r215 & 8) == 0) goto L17;
        PopupButtonInfo r104 = new PopupButtonInfo(null, null, null, false, null, 23, null);
    L19:
        if ((r215 & 16) == 0) goto L21;
        PopupButtonInfo r105 = new PopupButtonInfo(null, null, null, true, null, 23, null);
    L23:
        if ((r215 & 32) == 0) goto L25;
        int r106 = 0;
    L27:
        if ((r215 & 64) == 0) goto L29;
        String r107 = "";
    L31:
        if ((r215 & 128) == 0) goto L33;
        ArrayList r108 = new ArrayList();
    L35:
        if ((r215 & 256) != 0) goto L38;
        r100 = r214;
    L38:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r100);
        return;
    L33:
        r108 = r213;
        goto L35
    L29:
        r107 = r212;
        goto L31
    L25:
        r106 = r211;
        goto L27
    L21:
        r105 = r210;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
