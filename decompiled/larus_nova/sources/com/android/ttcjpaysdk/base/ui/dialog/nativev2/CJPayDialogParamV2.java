package com.android.ttcjpaysdk.base.ui.dialog.nativev2;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.RetainMsg;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002BQ\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rR\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/dialog/nativev2/CJPayDialogParamV2;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "main_verify", "", "button_verify", "selected_questioner", "voucher_no_list", "", "choose_retain_msg", "Lcom/android/ttcjpaysdk/base/ui/data/RetainMsg;", "hasChoiceChanged", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/android/ttcjpaysdk/base/ui/data/RetainMsg;Z)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayDialogParamV2 implements CJPayObject, Serializable {
    public String button_verify;
    public RetainMsg choose_retain_msg;
    public boolean hasChoiceChanged;
    public String main_verify;
    public String selected_questioner;
    public List<String> voucher_no_list;

    public CJPayDialogParamV2() {
        this(null, null, null, null, null, false, 63, null);
    }

    public CJPayDialogParamV2(String r100, String r101, String r102, List<String> r103, RetainMsg r104, boolean r105) {
        this.main_verify = r100;
        this.button_verify = r101;
        this.selected_questioner = r102;
        this.voucher_no_list = r103;
        this.choose_retain_msg = r104;
        this.hasChoiceChanged = r105;
    }

    public /* synthetic */ CJPayDialogParamV2(String r100, String r101, String r102, List r103, RetainMsg r104, boolean r110, int r111, DefaultConstructorMarker r112) {
        RetainMsg r105 = null;
        if ((r111 & 1) == 0) goto L5;
        String r113 = null;
    L7:
        if ((r111 & 2) == 0) goto L9;
        String r106 = null;
    L11:
        if ((r111 & 4) == 0) goto L13;
        String r107 = null;
    L15:
        if ((r111 & 8) == 0) goto L17;
        List r108 = null;
    L19:
        if ((r111 & 16) != 0) goto L23;
        r105 = r104;
    L23:
        if ((r111 & 32) == 0) goto L25;
        boolean r114 = false;
    L26:
        this(r113, r106, r107, r108, r105, r114);
        return;
    L25:
        r114 = r110;
        goto L26
    L17:
        r108 = r103;
        goto L19
    L13:
        r107 = r102;
        goto L15
    L9:
        r106 = r101;
        goto L11
    L5:
        r113 = r100;
        goto L7
    }
}
