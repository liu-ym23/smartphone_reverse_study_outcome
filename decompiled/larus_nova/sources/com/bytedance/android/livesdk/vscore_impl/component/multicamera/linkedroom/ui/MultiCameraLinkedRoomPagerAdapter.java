package com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.ui;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.chatroom.OverScrollRecyclerView;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.RoomKt;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSLinkedRoomInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/vscore_impl/component/multicamera/linkedroom/ui/MultiCameraLinkedRoomPagerAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MultiCameraLinkedRoomPagerAdapter extends PagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<ITabView.a> f159682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Integer, ITabView> f159683b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DataCenter f159684c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ITabView.Scene f159685d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Unit> f159686e;

    public final List<ITabView.a> f() {
        IRoom r100 = lu2.c.f(this.f159684c);
        ArrayList r101 = new ArrayList();
        if (RoomKt.hasMultiCamera(r100) == false) goto L11;
        ITabView.TabType r102 = ITabView.TabType.TYPE_MULTI_CAMERA;
        EpisodeExtraInfo r103 = lu2.c.a(r100);
        if (r103 == null) goto L8;
        String r104 = r103.getCameraInfosTableTitle();
        if (r104 == null) goto L8;
    L9:
        r101.add(new ITabView.a(r102, r104));
    L8:
        r104 = "更多机位";
    L11:
        if (lu2.c.b(r100) == false) goto L20;
        ITabView.TabType r105 = ITabView.TabType.TYPE_LINKED_ROOM;
        EpisodeExtraInfo r106 = lu2.c.a(r100);
        if (r106 == null) goto L18;
        VSLinkedRoomInfo r107 = r106.getVsLinkedRoomInfo();
        if (r107 == null) goto L18;
        String r108 = r107.getTitle();
        if (r108 == null) goto L18;
    L19:
        r101.add(new ITabView.a(r105, r108));
    L18:
        r108 = "相关直播";
    L20:
        return r101;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        return ((ArrayList) this.f159682a).size();
    }

    public final void h() {
        ((ArrayList) this.f159682a).clear();
        List<ITabView.a> r100 = this.f159682a;
        ArrayList r101 = (ArrayList) r100;
        r101.addAll(f());
    }

    public final boolean g() {
        List<ITabView.a> r100 = f();
        if (Intrinsics.areEqual(this.f159682a, r100) == false) goto L6;
        return false;
    L6:
        ((ArrayList) this.f159682a).clear();
        ((ArrayList) this.f159682a).addAll(r100);
        return true;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final CharSequence getPageTitle(int r100) {
        return ((ITabView.a) ListProtector.get(this.f159682a, r100)).f159650b;
    }

    public final void onPageSelected(int r100) {
        Map<Integer, ITabView> r101 = this.f159683b;
        LinkedHashMap r102 = (LinkedHashMap) r101;
        ITabView r103 = (ITabView) r102.get(Integer.valueOf(r100));
        if (r103 == null) goto L6;
        r103.onVisible();
        return;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final Object instantiateItem(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        ITabView.TabType r102 = ((ITabView.a) ListProtector.get(this.f159682a, r101)).getType();
        int r103 = i.f159765a[r102.ordinal()];
        if (r103 != 1) goto L5;
        ITabView r104 = new LinkedRoomPage(r100, this.f159684c, this.f159685d, this.f159686e);
    L10:
        OverScrollRecyclerView r105 = r104.i();
        r100.addView(r105);
        r104.attach();
        this.f159683b.put(Integer.valueOf(r101), r104);
        return r105;
    L5:
        if (r103 != 2) goto L8;
        r104 = new MultiCameraPage(r100, this.f159684c, this.f159685d, this.f159686e);
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final boolean isViewFromObject(View r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        Intrinsics.checkNotNullParameter(r101, "p1");
        return Intrinsics.areEqual(r100, r101);
    }

    public MultiCameraLinkedRoomPagerAdapter(DataCenter r100, ITabView.Scene r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        Intrinsics.checkNotNullParameter(r101, "scene");
        Intrinsics.checkNotNullParameter(r102, "dismissAction");
        this.f159684c = r100;
        this.f159685d = r101;
        this.f159686e = r102;
        this.f159682a = new ArrayList();
        this.f159683b = new LinkedHashMap();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(ViewGroup r100, int r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r102, "object");
        ITabView r103 = this.f159683b.remove(Integer.valueOf(r101));
        if (r103 == null) goto L6;
        r103.onDestroy();
        return;
    }
}
