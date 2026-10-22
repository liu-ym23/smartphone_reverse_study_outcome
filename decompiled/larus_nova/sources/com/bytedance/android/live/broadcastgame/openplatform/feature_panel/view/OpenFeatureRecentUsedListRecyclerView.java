package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view;

import android.content.Context;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.adapter.OpenFeatureRecentUsedGroupListAdapter;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.m;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/view/OpenFeatureRecentUsedListRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenFeatureRecentUsedListRecyclerView extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OpenFeatureRecentUsedGroupListAdapter f61453a;

    public OpenFeatureRecentUsedListRecyclerView(Context r100, OpenFeatureRecentUsedGroupListAdapter r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "recentUsedAdapter");
        super(r100);
        this.f61453a = r101;
        LinearLayoutManager r102 = new LinearLayoutManager(r100);
        final boolean r103 = false;
        r102.setOrientation(0);
        Unit r104 = Unit.INSTANCE;
        setLayoutManager(r102);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setAdapter(r101);
        setOverScrollMode(2);
        Room r105 = null;
        RoomContext r106 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r106 == null) goto L7;
        m<Room> r107 = r106.getRoom();
        if (r107 == null) goto L7;
        r105 = r107.getValue();
    L7:
        if (r105 == null) goto L9;
        r103 = true;
    L9:
        addItemDecoration(new AnonymousClass2(r103));
    }
}
