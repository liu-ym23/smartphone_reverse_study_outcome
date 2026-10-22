package com.bytedance.android.livehostapi.business.depend.gamecp;

import android.view.View;
import com.bytedance.android.livesdkapi.model.GameIntroduceCardItem;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u0005H&J\b\u0010\r\u001a\u00020\u0003H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGamePromoteCard;", "", "bindCardView", "", BrowserDependency.UrlClickType.CARD, "Landroid/view/View;", "info", "Lcom/bytedance/android/livesdkapi/model/GameIntroduceCardItem;", "cb", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/ICloseClickCallback;", "iconCb", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameCardIconCallBack;", "getView", "onViewDetached", "updateCardView", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IGamePromoteCard {
    void bindCardView(View r100, GameIntroduceCardItem r101, ICloseClickCallback r102, IGameCardIconCallBack r103);

    View getView();

    void onViewDetached();

    void updateCardView(GameIntroduceCardItem r100);
}
