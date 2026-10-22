package com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.commonui.LiveSettingKeys;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.VSSettingKeys;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.s;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.ui.MultiCameraLinkerRoomTagView;
import com.bytedance.android.livesdk.vscore_impl.component.tabs.MultiTabManagerImpl;
import com.bytedance.android.livesdk.vscore_impl.component.tabs.u;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/vscore_impl/component/multicamera/linkedroom/MultiCameraLinkedRoomTabsEntrance;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "<init>", "()V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MultiCameraLinkedRoomTabsEntrance extends LiveRecyclableWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MultiCameraLinkerRoomTagView f159563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f159564b;

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_layout_matchroom_camera_portait;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        MultiCameraLinkerRoomTagView r100 = this.f159563a;
        if (r100 == null) goto L5;
        r100.f159695i.clear();
    L5:
        this.f159564b.clear();
    }

    public MultiCameraLinkedRoomTabsEntrance() {
        this.f159564b = new CompositeDisposable();
    }

    public final void wq() {
        s.i().a();
        if (MultiTabManagerImpl.f159902e.g(this.dataCenter) == false) goto L8;
        ALogger.i("MultiCameraLinkedRoomTabsEntrance", "updateView  ugcLayoutModeFilter = true ");
        ViewGroup r100 = this.containerView;
        if (r100 == null) goto L14;
        UtilityKotlinExtentionsKt.v(r100, false);
        return;
    L14:
        return;
    L8:
        MultiCameraLinkerRoomTagView r101 = this.f159563a;
        if (r101 == null) goto L15;
        boolean r102 = r101.b(this.dataCenter, MultiCameraLinkerRoomTagView.Location.TABS_ENTRANCE);
        ViewGroup r103 = this.containerView;
        if (r103 == null) goto L16;
        UtilityKotlinExtentionsKt.v(r103, r102);
        return;
    L16:
        return;
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        if (LiveSettingKeys.LIVE_VS_FOLD_FIX_CONFIG.getValue().getEnable() == false) goto L5;
    L9:
        super.onConfigurationChanged(r100);
        return;
    L5:
        if (FoldScreenUtils.f() == false) goto L9;
        if (VSSettingKeys.LIVE_MATCHROOM_MULITITAB_FOLDSCREEN_ENABLE.getValue().booleanValue() == false) goto L9;
        s.i().a();
        MultiTabManagerImpl.f159902e.b(this.contentView, r100);
        goto L9
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        this.f159563a = (MultiCameraLinkerRoomTagView) findViewById(R.id.match_room_muticamera_widget);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        DataCenter r101 = this.dataCenter;
        if (r101 == null) goto L7;
        Disposable r102 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.b(r101, new AnonymousClass1(this));
        if (r102 == null) goto L7;
        RxUtilKt.c(r102, this.f159564b);
    L7:
        View r103 = this.contentView;
        if (r103 == null) goto L10;
        r103.setOnClickListener(x0.a(new MultiCameraLinkedRoomTabsEntrance$initEvent$1(this)));
    L10:
        ou2.a r104 = ou2.c.a(this.dataCenter);
        if (r104 == null) goto L19;
        com.bytedance.live.datacontext.k<Object> r105 = r104.getDataChanged();
        if (r105 == null) goto L19;
        PublishSubject r106 = r105.onEvent();
        if (r106 == null) goto L19;
        Disposable r107 = r106.subscribe(new g(this));
        if (r107 == null) goto L19;
        RxUtilKt.c(r107, this.f159564b);
    L19:
        int r108 = u.f160005a;
        Configuration r109 = null;
        if (u.a(this.dataCenter) == false) goto L29;
        ou2.a r110 = ou2.c.a(this.dataCenter);
        if ((r110 instanceof MultiCameraLinkedRoomContext) == true) goto L24;
        r110 = null;
    L24:
        MultiCameraLinkedRoomContext r111 = (MultiCameraLinkedRoomContext) r110;
        if (r111 == null) goto L29;
        Disposable r112 = r111.getHideByUgcMultiTabFilter().a().subscribe(new f(this));
        if (r112 == null) goto L29;
        RxUtilKt.c(r112, this.f159564b);
    L29:
        DataCenter r113 = this.dataCenter;
        if (r113 == null) goto L33;
        com.bytedance.android.livesdk.chatroom.vs_base.util.h.f(r113, new AnonymousClass2(this));
    L33:
        if (LiveSettingKeys.LIVE_VS_FOLD_FIX_CONFIG.getValue().getEnable() == true) goto L46;
        Context r114 = this.context;
        if (r114 == null) goto L39;
        Resources r115 = r114.getResources();
        if (r115 == null) goto L39;
        r109 = r115.getConfiguration();
    L39:
        if (r109 != null) goto L41;
        return;
    L41:
        if (FoldScreenUtils.f() == true) goto L43;
        return;
    L43:
        if (VSSettingKeys.LIVE_MATCHROOM_MULITITAB_FOLDSCREEN_ENABLE.getValue().booleanValue() == false) goto L49;
        s.i().a();
        MultiTabManagerImpl.f159902e.b(this.contentView, this.context.getResources().getConfiguration());
        return;
    L49:
        return;
    }
}
