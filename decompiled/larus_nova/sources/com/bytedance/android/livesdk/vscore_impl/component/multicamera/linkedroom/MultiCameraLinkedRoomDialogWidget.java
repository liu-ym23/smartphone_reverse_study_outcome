package com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom;

import am2.x;
import android.content.res.ColorStateList;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.ui.ITabView;
import com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.ui.MultiCameraLinkedRoomPagerAdapter;
import com.bytedance.android.livesdk.widget.LivePagerSlidingTabStrip;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/vscore_impl/component/multicamera/linkedroom/MultiCameraLinkedRoomDialogWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MultiCameraLinkedRoomDialogWidget extends LiveRecyclableWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f159556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewPager f159557b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LivePagerSlidingTabStrip f159558c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MultiCameraLinkedRoomPagerAdapter f159559d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f159560e;

    public interface a {
        void dismiss();
    }

    public static final class b {
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MultiCameraLinkedRoomDialogWidget f159561a;

        public c(MultiCameraLinkedRoomDialogWidget r100) {
            this.f159561a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MultiCameraLinkedRoomDialogWidget r100 = this.f159561a;     // Catch: Throwable -> L8
            if (r100.isViewValid == false) goto L11;
            ViewGroup r101 = r100.containerView;     // Catch: Throwable -> L8
            if (r101 == null) goto L15;
            r101.setPadding(0, 0, 0, 0);     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_matchroom_camera_dialog_widget;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        this.f159556a.clear();
        ViewPager r100 = this.f159557b;
        if (r100 == null) goto L6;
        r100.clearOnPageChangeListeners();
        return;
    }

    public final void wq() {
        MultiCameraLinkedRoomPagerAdapter r100 = this.f159559d;
        if (r100 == null) goto L5;
        int r101 = r100.getCount();
    L7:
        if (r101 <= 1) goto L17;
        LivePagerSlidingTabStrip r102 = this.f159558c;
        if (r102 == null) goto L11;
        r102.setEnableIndicator(true);
    L11:
        LivePagerSlidingTabStrip r103 = this.f159558c;
        if (r103 == null) goto L14;
        r103.setTextSize(UtilityKotlinExtentionsKt.i(15));
    L14:
        LivePagerSlidingTabStrip r104 = this.f159558c;
        if (r104 == null) goto L27;
        a1.k(r104, UtilityKotlinExtentionsKt.i(44));
    L27:
        if (lu2.b.j(lu2.c.f(this.dataCenter)) == false) goto L32;
        LivePagerSlidingTabStrip r105 = this.f159558c;
        if (r105 == null) goto L40;
        a1.m(r105, UtilityKotlinExtentionsKt.i(0));
        return;
    L40:
        return;
    L32:
        if (RoomKt.hasMultiCamera(lu2.c.f(this.dataCenter)) == false) goto L36;
        LivePagerSlidingTabStrip r106 = this.f159558c;
        if (r106 == null) goto L42;
        a1.m(r106, UtilityKotlinExtentionsKt.i(8));
        return;
    L42:
        return;
    L36:
        LivePagerSlidingTabStrip r107 = this.f159558c;
        if (r107 == null) goto L44;
        a1.m(r107, UtilityKotlinExtentionsKt.i(0));
        return;
    L44:
        return;
    L17:
        LivePagerSlidingTabStrip r108 = this.f159558c;
        if (r108 == null) goto L20;
        r108.setEnableIndicator(false);
    L20:
        LivePagerSlidingTabStrip r109 = this.f159558c;
        if (r109 == null) goto L23;
        r109.setTextSize(UtilityKotlinExtentionsKt.i(17));
    L23:
        LivePagerSlidingTabStrip r110 = this.f159558c;
        if (r110 == null) goto L27;
        a1.k(r110, UtilityKotlinExtentionsKt.i(52));
        goto L27
    L5:
        r101 = 0;
        goto L7
    }

    public MultiCameraLinkedRoomDialogWidget(com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.a r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f159560e = r100;
        this.f159556a = new CompositeDisposable();
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        this.f159558c = (LivePagerSlidingTabStrip) findViewById(R.id.tab_strip);
        this.f159557b = (ViewPager) findViewById(R.id.viewpager);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        MultiCameraLinkedRoomPagerAdapter r101 = new MultiCameraLinkedRoomPagerAdapter(this.dataCenter, ITabView.Scene.SCENE_LANDSCAPE, new MultiCameraLinkedRoomDialogWidget$initView$1(this));
        this.f159559d = r101;
        r101.h();
        ViewPager r102 = this.f159557b;
        if (r102 == null) goto L5;
        r102.setAdapter(this.f159559d);
    L5:
        LivePagerSlidingTabStrip r103 = this.f159558c;
        if (r103 == null) goto L8;
        r103.setViewPager(this.f159557b);
    L8:
        LivePagerSlidingTabStrip r104 = this.f159558c;
        if (r104 == null) goto L11;
        r104.setTabTextSelectColor(ColorStateList.valueOf(-1));
    L11:
        LivePagerSlidingTabStrip r105 = this.f159558c;
        if (r105 == null) goto L14;
        r105.setIndicatorBottomMargin(UtilityKotlinExtentionsKt.i(3));
    L14:
        LivePagerSlidingTabStrip r106 = this.f159558c;
        if (r106 == null) goto L17;
        r106.setTextSelectedStyle(1);
    L17:
        LivePagerSlidingTabStrip r107 = this.f159558c;
        if (r107 == null) goto L20;
        r107.A = null;
        r107.B = 0;
        r107.d();
    L20:
        wq();
        MultiCameraLinkedRoomPagerAdapter r108 = this.f159559d;
        if (r108 == null) goto L25;
        List<ITabView.a> r109 = r108.f159682a;
        if (r109 == null) goto L25;
        int r110 = ((ArrayList) r109).size();
    L26:
        if (r110 <= 0) goto L44;
        HashMap r111 = new HashMap();
        MultiCameraLinkedRoomPagerAdapter r112 = this.f159559d;
        if (r112 == null) goto L37;
        List<ITabView.a> r113 = r112.f159682a;
        if (r113 == null) goto L37;
        ITabView.a r114 = (ITabView.a) ListProtector.get(r113, 0);
        if (r114 == null) goto L37;
        ITabView.TabType r115 = r114.getType();
        if (r115 == null) goto L37;
        String r116 = r115.getTabName();
        if (r116 == null) goto L37;
    L38:
        r111.put(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r116);
        Map<String, String> r117 = com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.util.e.a(this.dataCenter);
        if (r117 == null) goto L41;
        r111.putAll(r117);
    L41:
        r.l().sendLog("livesdk_relevant_live_panel_show", r111, new Object[]{x.class, Room.class});
        ViewPager r118 = this.f159557b;
        if (r118 == null) goto L44;
        r118.post(new e(this));
    L37:
        r116 = "";
    L44:
        ViewPager r119 = this.f159557b;
        if (r119 == null) goto L47;
        r119.addOnPageChangeListener(new MultiCameraLinkedRoomDialogWidget$initView$3(this));
    L47:
        ou2.a r120 = ou2.c.a(this.dataCenter);
        if (r120 == null) goto L50;
        RxUtilKt.c(r120.getDataChanged().onEvent().subscribe(new d(this)), this.f159556a);
    L50:
        ViewGroup r121 = this.containerView;
        if (r121 == null) goto L54;
        r121.postDelayed(new c(this), 100);
        return;
    L54:
        return;
    L25:
        r110 = 0;
        goto L26
    }
}
