package com.bytedance.android.livesdk.chatroom.replay.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.View;
import com.bytedance.android.live.commonui.LiveSettingKeys;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.VSSettingKeys;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.EpisodeBasicInfo;
import com.bytedance.android.livesdkapi.depend.model.live.vs.MultiTab;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/widget/ReplayPortraitTabsWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "<init>", "()V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplayPortraitTabsWidget extends LiveRecyclableWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f110325a;

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_replay_tabs_layout;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
    }

    public ReplayPortraitTabsWidget() {
        this.f110325a = LazyKt.lazy(new ReplayPortraitTabsWidget$commonTabsWidget$2(this));
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        if (LiveSettingKeys.LIVE_VS_FOLD_FIX_CONFIG.getValue().getEnable() == false) goto L5;
    L12:
        super.onConfigurationChanged(r100);
        return;
    L5:
        if (FoldScreenUtils.f() == false) goto L12;
        if (VSSettingKeys.LIVE_MATCHROOM_MULITITAB_FOLDSCREEN_ENABLE.getValue().booleanValue() == false) goto L12;
        View r101 = this.contentView;
        if (FoldScreenUtils.c(r100) != 0) goto L11;
        r101.setVisibility(4);
        goto L12
    L11:
        r101.setVisibility(0);
        goto L12
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        enableSubWidgetManager();
        if (LiveSettingKeys.LIVE_VS_FOLD_FIX_CONFIG.getValue().getEnable() == true) goto L19;
        Context r101 = this.context;
        if (r101 == null) goto L9;
        Resources r102 = r101.getResources();
        if (r102 == null) goto L9;
        Configuration r103 = r102.getConfiguration();
    L10:
        if (r103 == null) goto L19;
        if (FoldScreenUtils.f() == false) goto L19;
        if (VSSettingKeys.LIVE_MATCHROOM_MULITITAB_FOLDSCREEN_ENABLE.getValue().booleanValue() == false) goto L19;
        View r104 = this.contentView;
        if (FoldScreenUtils.c(this.context.getResources().getConfiguration()) != 0) goto L18;
        r104.setVisibility(4);
        goto L19
    L18:
        r104.setVisibility(0);
    L9:
        r103 = null;
    L19:
        DataCenter r105 = this.dataCenter;
        if (r105 == null) goto L62;
        Episode r106 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.a(r105);
        if (r106 == null) goto L62;
        EpisodeBasicInfo r107 = r106.episodeBasicInfo;
        if (r107 == null) goto L62;
        MultiTab r108 = r107.getReplaysTabs();
        if (r108 == null) goto L62;
        List<MultiTab.TabItem> r109 = r108.getValidTabs();
        if (r109 == null) goto L62;
        if (r109.size() != 1) goto L62;
        DataCenter r110 = this.dataCenter;
        if (r110 == null) goto L62;
        Episode r111 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.a(r110);
        if (r111 == null) goto L62;
        EpisodeBasicInfo r112 = r111.episodeBasicInfo;
        if (r112 == null) goto L62;
        MultiTab r113 = r112.getReplaysTabs();
        if (r113 == null) goto L62;
        List<MultiTab.TabItem> r114 = r113.getValidTabs();
        if (r114 == null) goto L62;
        List<MultiTab.TabItem> r115 = r114;
        if ((r115 instanceof Collection) == true) goto L44;
    L46:
        Iterator<T> r116 = r115.iterator();
    L48:
        if (r116.hasNext() == false) goto L55;
        if (((MultiTab.TabItem) r116.next()).getTabId() != 5) goto L52;
        boolean r117 = true;
    L53:
        if (r117 == true) goto L48;
        boolean r118 = false;
    L56:
        if (r118 != true) goto L62;
        DataCenter r119 = this.dataCenter;
        if (r119 == null) goto L60;
        r119.put("multi_selected_tab_id", 5L);
    L60:
        this.subWidgetManager.load(R.id.ttlive_replay_tabs_container, new ReplayReplayTabWidget(), false);
        return;
    L52:
        r117 = false;
    L55:
        r118 = true;
        goto L56
    L44:
        if (r115.isEmpty() == false) goto L46;
    L62:
        LiveRecyclableWidget r120 = (LiveRecyclableWidget) this.f110325a.getValue();
        if (r120 == null) goto L71;
        this.subWidgetManager.load(R.id.ttlive_replay_tabs_container, r120, false);
        return;
    }
}
