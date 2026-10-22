package com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom;

import android.content.res.ColorStateList;
import android.view.View;
import android.widget.ImageView;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.ui.ITabView;
import com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.ui.MultiCameraLinkedRoomPagerAdapter;
import com.bytedance.android.livesdk.widget.LivePagerSlidingTabStrip;
import com.bytedance.mt.protector.impl.collections.ListProtector;
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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/vscore_impl/component/multicamera/linkedroom/PortraitVerticalLinkedCameraDialogWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PortraitVerticalLinkedCameraDialogWidget extends LiveRecyclableWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewPager f159609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LivePagerSlidingTabStrip f159610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f159611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageView f159612d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public MultiCameraLinkedRoomPagerAdapter f159613e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f159614f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ITabView.Scene f159615g;

    public interface a {
        void dismiss();
    }

    public static final class b {
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PortraitVerticalLinkedCameraDialogWidget f159616a;

        public c(PortraitVerticalLinkedCameraDialogWidget r100) {
            this.f159616a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f159616a.f159614f.dismiss();
        }
    }

    static {
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_portait_vertical_dialog_widget;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        this.f159611c.clear();
        ViewPager r100 = this.f159609a;
        if (r100 == null) goto L6;
        r100.clearOnPageChangeListeners();
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        this.f159610b = (LivePagerSlidingTabStrip) findViewById(R.id.tab_strip);
        this.f159609a = (ViewPager) findViewById(R.id.viewpager);
        this.f159612d = (ImageView) findViewById(R.id.close);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        MultiCameraLinkedRoomPagerAdapter r101 = new MultiCameraLinkedRoomPagerAdapter(this.dataCenter, this.f159615g, new PortraitVerticalLinkedCameraDialogWidget$initView$1(this));
        this.f159613e = r101;
        r101.h();
        ViewPager r102 = this.f159609a;
        if (r102 == null) goto L5;
        r102.setAdapter(this.f159613e);
    L5:
        LivePagerSlidingTabStrip r103 = this.f159610b;
        if (r103 == null) goto L8;
        r103.setViewPager(this.f159609a);
    L8:
        LivePagerSlidingTabStrip r104 = this.f159610b;
        if (r104 == null) goto L11;
        r104.setTabTextSelectColor(ColorStateList.valueOf(-1));
    L11:
        LivePagerSlidingTabStrip r105 = this.f159610b;
        boolean r106 = false;
        if (r105 == null) goto L14;
        r105.setIndicatorBottomMargin(0);
    L14:
        LivePagerSlidingTabStrip r107 = this.f159610b;
        if (r107 == null) goto L17;
        r107.setIncludeFontPadding(false);
    L17:
        LivePagerSlidingTabStrip r108 = this.f159610b;
        if (r108 == null) goto L20;
        r108.setTextSelectedStyle(1);
    L20:
        LivePagerSlidingTabStrip r109 = this.f159610b;
        if (r109 == null) goto L23;
        r109.A = null;
        r109.B = 0;
        r109.d();
    L23:
        MultiCameraLinkedRoomPagerAdapter r110 = this.f159613e;
        if (r110 == null) goto L28;
        List<ITabView.a> r111 = r110.f159682a;
        if (r111 == null) goto L28;
        int r112 = ((ArrayList) r111).size();
    L29:
        if (r112 <= 0) goto L47;
        HashMap r113 = new HashMap();
        MultiCameraLinkedRoomPagerAdapter r114 = this.f159613e;
        if (r114 == null) goto L40;
        List<ITabView.a> r115 = r114.f159682a;
        if (r115 == null) goto L40;
        ITabView.a r116 = (ITabView.a) ListProtector.get(r115, 0);
        if (r116 == null) goto L40;
        ITabView.TabType r117 = r116.getType();
        if (r117 == null) goto L40;
        String r118 = r117.getTabName();
        if (r118 == null) goto L40;
    L41:
        r113.put(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r118);
        Map<String, String> r119 = com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.util.e.a(this.dataCenter);
        if (r119 == null) goto L44;
        r113.putAll(r119);
    L44:
        r.l().sendLog("livesdk_relevant_live_panel_show", r113, new Object[0]);
        ViewPager r120 = this.f159609a;
        if (r120 == null) goto L47;
        r120.post(new m(this));
    L40:
        r118 = "";
    L47:
        LivePagerSlidingTabStrip r121 = this.f159610b;
        if (r121 == null) goto L58;
        MultiCameraLinkedRoomPagerAdapter r122 = this.f159613e;
        if (r122 == null) goto L54;
        List<ITabView.a> r123 = r122.f159682a;
        if (r123 == null) goto L54;
        int r124 = ((ArrayList) r123).size();
    L55:
        if (r124 <= 1) goto L57;
        r106 = true;
    L57:
        r121.setEnableIndicator(r106);
    L54:
        r124 = 0;
    L58:
        ViewPager r125 = this.f159609a;
        if (r125 == null) goto L61;
        r125.addOnPageChangeListener(new PortraitVerticalLinkedCameraDialogWidget$initView$3(this));
    L61:
        ou2.a r126 = ou2.c.a(this.dataCenter);
        if (r126 == null) goto L64;
        RxUtilKt.c(r126.getDataChanged().onEvent().subscribe(new l(this)), this.f159611c);
    L64:
        ImageView r127 = this.f159612d;
        if (r127 == null) goto L67;
        r127.setOnClickListener(new c(this));
    L67:
        r3.a(this.f159612d, "关闭");
        return;
    L28:
        r112 = 0;
        goto L29
    }

    public PortraitVerticalLinkedCameraDialogWidget(n r100, ITabView.Scene r101) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        Intrinsics.checkNotNullParameter(r101, "scene");
        this.f159614f = r100;
        this.f159615g = r101;
        this.f159611c = new CompositeDisposable();
    }
}
