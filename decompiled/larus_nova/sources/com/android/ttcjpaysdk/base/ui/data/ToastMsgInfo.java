package com.android.ttcjpaysdk.base.ui.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0005j\b\u0012\u0004\u0012\u00020\u000b`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/ToastMsgInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "bottom_button_content", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/ui/data/ToastContent;", "Lkotlin/collections/ArrayList;", "sub_title_content", "toast_content", "toast_display_option", "Lcom/android/ttcjpaysdk/base/ui/data/ToastDisplayOption;", "toast_style", "", "top_button_content", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ToastMsgInfo implements CJPayObject, Serializable {
    public ArrayList<ToastContent> bottom_button_content;
    public ArrayList<ToastContent> sub_title_content;
    public ArrayList<ToastContent> toast_content;
    public ArrayList<ToastDisplayOption> toast_display_option;
    public String toast_style;
    public ArrayList<ToastContent> top_button_content;

    public ToastMsgInfo() {
        this.toast_content = new ArrayList();
        this.top_button_content = new ArrayList();
        this.bottom_button_content = new ArrayList();
        this.sub_title_content = new ArrayList();
        this.toast_display_option = new ArrayList();
        this.toast_style = "";
    }
}
