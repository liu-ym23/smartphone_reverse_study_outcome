package com.android.ttcjpaysdk.base.ui.dialog.nativev2;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/dialog/nativev2/CJPayKeepDialogUIParams;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "voucher_no_list", "", "", "choose_retain_msg", "Lorg/json/JSONObject;", "has_choice_changed", "", "(Ljava/util/List;Lorg/json/JSONObject;Z)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayKeepDialogUIParams implements CJPayObject, Serializable {
    public JSONObject choose_retain_msg;
    public boolean has_choice_changed;
    public List<String> voucher_no_list;

    public CJPayKeepDialogUIParams() {
        this(null, null, false, 7, null);
    }

    public CJPayKeepDialogUIParams(List<String> r100, JSONObject r101, boolean r102) {
        this.voucher_no_list = r100;
        this.choose_retain_msg = r101;
        this.has_choice_changed = r102;
    }

    public /* synthetic */ CJPayKeepDialogUIParams(List r100, JSONObject r101, boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = false;
    L11:
        this(r100, r101, r102);
    }
}
