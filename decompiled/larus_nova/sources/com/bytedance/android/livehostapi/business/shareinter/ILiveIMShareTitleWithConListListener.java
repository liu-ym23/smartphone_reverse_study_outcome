package com.bytedance.android.livehostapi.business.shareinter;

import com.alibaba.gaiax.model.GXScroll;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001a\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u001a\u0010\f\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u001c\u0010\r\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/shareinter/ILiveIMShareTitleWithConListListener;", "", "onCancelClick", "", "onContactCancelSelect", "itemType", "Lcom/bytedance/android/livehostapi/business/shareinter/LiveIMShareContactType;", "contact", "Lcom/bytedance/android/livehostapi/business/shareinter/LiveIMContact;", "onContactVisible", "visible", "", "onItemClick", "onItemVisible", "itemId", "", GXScroll.TYPE_ON_SCROLL_STATE_CHANGED, "newState", "", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveIMShareTitleWithConListListener {
    void onCancelClick();

    void onContactCancelSelect(LiveIMShareContactType r100, LiveIMContact r101);

    void onContactVisible(boolean r100);

    void onItemClick(LiveIMShareContactType r100, LiveIMContact r101);

    void onItemVisible(LiveIMContact r100, String r101);

    void onScrollStateChanged(int r100);
}
