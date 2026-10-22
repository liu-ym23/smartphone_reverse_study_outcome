package com.bytedance.android.livesdk.chatroom.tabliveguide;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes7.dex */
public final class InnerCardTabliveGuideView extends sv2.a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final LiveInnerCardSkyLightAdapter f111636n;

    private final LiveInnerTabGuideManager getManager() {
        LiveInnerTabGuideManager.Companion.getClass();
        return LiveInnerTabGuideManager.b.a();
    }

    @Override // sv2.a
    public final void g() {
        LiveInnerCardSkyLightAdapter r100 = this.f111636n;
        if (r100 == null) goto L12;
        RecyclerView r101 = getSkylightRecyclerView();
        if (r101 == null) goto L9;
        RecyclerView.LayoutManager r102 = r101.getLayoutManager();
        if (r102 == null) goto L9;
        int r103 = r102.getChildCount();
    L10:
        r100.y2(r103, getCommonMobParams());
        return;
    L9:
        r103 = 0;
        goto L10
    }

    @Override // sv2.a
    public final void b() {
        LiveInnerTabGuideManager r100 = getManager();
        if (r100 == null) goto L6;
        r100.removeInnerCardItem();
        return;
    }

    @Override // sv2.a
    public String getTabLiveGuideAnchorIds() {
        String r100 = getViewParams().f543643j.getString("tablive_guide_anchor_id", "");
        RecyclerView r101 = getSkylightRecyclerView();
        boolean r102 = false;
        if (r101 == null) goto L7;
        RecyclerView.LayoutManager r103 = r101.getLayoutManager();
        if (r103 == null) goto L7;
        int r104 = r103.getChildCount();
    L8:
        List r105 = StringsKt.split$default(r100, new String[]{","}, false, 0, 6, null);
        if (r105.size() <= r104) goto L11;
        r102 = true;
    L11:
        if (r102 == true) goto L14;
        r105 = null;
    L14:
        if (r105 == null) goto L22;
        List r106 = CollectionsKt.take(r105, r104);
        if (r106 == null) goto L23;
        String r107 = CollectionsKt.joinToString$default(r106, ",", null, null, 0, null, null, 62, null);
        if (r107 != null) goto L21;
        return r100;
    L21:
        return r107;
    L23:
        return r100;
    L22:
        return r100;
    L7:
        r104 = 0;
        goto L8
    }

    @Override // sv2.a
    public final void h() {
        LiveInnerTabGuideManager r100 = getManager();
        if (r100 == null) goto L6;
        r100.stopTimer();
        return;
    }

    public static final /* synthetic */ LiveInnerTabGuideManager j(InnerCardTabliveGuideView r100) {
        return r100.getManager();
    }

    public InnerCardTabliveGuideView(final Context r100, sv2.c r101, Room r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "viewParams");
        Intrinsics.checkNotNullParameter(r102, "firstRoom");
        super(r100, r101, r102);
        d();
        if (tb1.c.f545230b == false) goto L7;
        FrameLayout r103 = getGoToSeeButton();
        if (r103 == null) goto L7;
        r103.setBackgroundResource(R.drawable.ttlive_inner_tablive_guide_look_button_huoshan);
    L7:
        RecyclerView r104 = getSkylightRecyclerView();
        if (r104 == null) goto L10;
        LinearLayoutManager r105 = new AnonymousClass1(r100);
        r105.setOrientation(0);
        Unit r106 = Unit.INSTANCE;
        r104.setLayoutManager(r105);
    L10:
        LiveInnerTabGuideManager r107 = getManager();
        if (r107 == null) goto L23;
        b r108 = r107.getInnerCardData();
        if (r108 == null) goto L23;
        a r109 = r108.a();
        if (r109 == null) goto L23;
        c r110 = r109.c();
        if (r110 == null) goto L23;
        List<FeedItem> r111 = r110.a();
        if (r111 == null) goto L23;
        LiveInnerCardSkyLightAdapter r112 = new LiveInnerCardSkyLightAdapter(r111, new InnerCardTabliveGuideView$$special$$inlined$let$lambda$1(this));
        this.f111636n = r112;
        RecyclerView r113 = getSkylightRecyclerView();
        if (r113 == null) goto L23;
        r113.setAdapter(r112);
    L23:
        RecyclerView r114 = getSkylightRecyclerView();
        if (r114 == null) goto L26;
        r114.setAdapter(this.f111636n);
    L26:
        LiveInnerTabGuideManager r115 = getManager();
        String r116 = "";
        if (r115 == null) goto L34;
        b r117 = r115.getInnerCardData();
        if (r117 == null) goto L34;
        a r118 = r117.a();
        if (r118 == null) goto L34;
        String r119 = r118.b();
        if (r119 == null) goto L34;
    L35:
        LiveInnerTabGuideManager r120 = getManager();
        if (r120 == null) goto L45;
        b r121 = r120.getInnerCardData();
        if (r121 == null) goto L45;
        a r122 = r121.a();
        if (r122 == null) goto L45;
        String r123 = r122.a();
        if (r123 == null) goto L45;
        r116 = r123;
    L45:
        a(r119, r116);
        return;
    L34:
        r119 = "";
        goto L35
    }
}
