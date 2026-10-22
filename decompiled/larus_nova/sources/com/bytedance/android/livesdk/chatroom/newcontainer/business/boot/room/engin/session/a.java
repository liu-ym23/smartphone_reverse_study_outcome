package com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.session;

import android.os.Bundle;
import android.view.View;
import com.bytedance.android.livesdk.ability.AbilityCenter;
import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdk.chatroom.adapter.LiveDetailPagerAdapter;
import com.bytedance.android.livesdk.chatroom.h;
import com.bytedance.android.livesdk.landscapeslide.g;
import com.bytedance.android.livesdk.room.state.ContainerScrollLifecycle;
import com.bytedance.android.livesdk.widget.LiveVerticalViewPager;
import com.bytedance.android.livesdkapi.depend.live.IAutoLoadMore;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment;
import com.bytedance.android.livesdkapi.depend.live.IRoomList;
import com.bytedance.android.livesdkapi.feed.ILiveRoomListProvider;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.view.IBackPress;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public interface a extends ILiveRoomPageFragment, IAutoLoadMore, IBackPress, h, IRoomList, IAbility {
    void Cw(ILivePlayerClient r100);

    void DJ();

    void Fg(boolean r100);

    <T> void L7(Class<T> r100, Consumer<T> r101);

    g Lh();

    AbilityCenter M90();

    void ZG();

    void c4(String r100, boolean r101);

    Bundle co();

    LiveDetailPagerAdapter getAdapter();

    LiveVerticalViewPager getViewPager();

    void hf(ContainerScrollLifecycle r100, Integer r101, Integer r102);

    void iR(View r100);

    void onWidgetLoaded();

    ILiveRoomListProvider s5();
}
