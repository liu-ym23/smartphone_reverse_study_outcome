package com.bytedance.android.livesdkapi.commerce.view;

import android.view.ViewGroup;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.livesdkapi.commerce.ILiveShoppingMessage;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes12.dex */
public interface IPromotionCardView {
    void cancelPromotionCardWhenReceiveMsg(int r100, long r101);

    void createPromotionCardWhenReceiveMsg(String r100);

    void onPromotionCardRestored();

    void onPromotionsChangedWhenReceiveMsg(boolean r100);

    void onRequestPromotionsSuccessWhenEnterRoom(boolean r100);

    void onWidgetLoad(long r100, WeakReference<ViewGroup> r101, ViewModel r102);

    void onWidgetUnload();

    void updatePromotion(ILiveShoppingMessage r100);
}
