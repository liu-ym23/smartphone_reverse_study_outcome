package com.bytedance.android.livehostapi.business.shareinter;

import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/shareinter/ILiveIMSharePostscriptListener;", "", "onMsgSend", "", "toIMContact", "", "Lcom/bytedance/android/livehostapi/business/shareinter/LiveIMContact;", "onOutSideClick", "panelShow", "show", "", "showKeyBoard", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveIMSharePostscriptListener {
    void onMsgSend(List<? extends LiveIMContact> r100);

    void onOutSideClick();

    void panelShow(boolean r100);

    void showKeyBoard(boolean r100);
}
