package com.android.ttcjpaysdk.base.ui.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/CJPayDoubleConfirmPopInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "()V", "cancel_button_info", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayTopRightBtnInfo;", "main_button_info", "page_desc_icon", "", "page_desc_text", ILiveRoomPlayFragmentConstant.ENTER_LIVE_POP_TYPE, "sub_button_info", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayDoubleConfirmPopInfo implements CJPayObject {
    public CJPayTopRightBtnInfo cancel_button_info;
    public CJPayTopRightBtnInfo main_button_info;
    public String page_desc_icon;
    public String page_desc_text;
    public String pop_type;
    public CJPayTopRightBtnInfo sub_button_info;

    public CJPayDoubleConfirmPopInfo() {
        this.page_desc_text = "";
        this.page_desc_icon = "";
        this.pop_type = "";
    }
}
