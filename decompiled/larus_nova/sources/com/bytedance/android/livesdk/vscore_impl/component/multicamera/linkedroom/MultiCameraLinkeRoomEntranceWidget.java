package com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.tetris.layer.core.event.LayerEventDispatcher;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.ui.MultiCameraLinkerRoomTagView;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.RoomKt;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import vr1.u;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/vscore_impl/component/multicamera/linkedroom/MultiCameraLinkeRoomEntranceWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "<init>", "()V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MultiCameraLinkeRoomEntranceWidget extends LiveRecyclableWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MultiCameraLinkerRoomTagView f159549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f159550b;

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_vs_linked_camera_entrance;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        this.f159550b.clear();
        MultiCameraLinkerRoomTagView r100 = this.f159549a;
        if (r100 == null) goto L6;
        r100.f159695i.clear();
        return;
    }

    public MultiCameraLinkeRoomEntranceWidget() {
        this.f159550b = new CompositeDisposable();
    }

    public static final void wq(MultiCameraLinkeRoomEntranceWidget r100) {
        DataCenter r101 = r100.dataCenter;
        IRoom r102 = null;
        if (r101 == null) goto L5;
        Integer r103 = Integer.valueOf(r101.hashCode());
    L6:
        LayerEventDispatcher r104 = o70.c.a(r103);
        if (r104 == null) goto L9;
        r104.b(MultiCameraPanelEvent.f159575b);
    L9:
        DataCenter r105 = r100.dataCenter;
        if (r105 == null) goto L13;
        r102 = lu2.c.f(r105);
    L13:
        if (RoomKt.hasMultiCamera(r102) == false) goto L15;
        final String r106 = "livesdk_more_machine_icon_click";
    L17:
        if (RoomKt.hasMultiCamera(r102) == false) goto L19;
        final Map r107 = new LinkedHashMap();
    L21:
        if (lu2.c.e(r102) == false) goto L25;
        Map<String, String> r108 = com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.util.e.a(r100.dataCenter);
        if (r108 == null) goto L25;
        r107.putAll(r108);
    L25:
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.l> r109 = r.l().h(r100.dataCenter);
        if (r109 == null) goto L28;
        r109.c(new MultiCameraLinkeRoomEntranceWidget$logClick$2(r106, r107));
    L28:
        int r110 = com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.util.a.f159779a;
        com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.util.a.a(r100.dataCenter);
        return;
    L19:
        r107 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("vs_icon_type", "only_relevant_live")});
        goto L21
    L15:
        r106 = "livesdk_relevant_live_icon_click";
        goto L17
    L5:
        r103 = null;
        goto L6
    }

    public static final void xq(final MultiCameraLinkeRoomEntranceWidget r100) {
        MultiCameraLinkerRoomTagView r101 = r100.f159549a;
        if (r101 == null) goto L12;
        boolean r102 = r101.b(r100.dataCenter, MultiCameraLinkerRoomTagView.Location.NO_TABS_ENTRANCE);
        ViewGroup r103 = r100.containerView;
        if (r103 == null) goto L7;
        UtilityKotlinExtentionsKt.v(r103, r102);
    L7:
        if (r102 == false) goto L13;
        DataCenter r104 = r100.dataCenter;
        if (r104 == null) goto L14;
        com.bytedance.android.livesdk.chatroom.vs_base.util.h.f(r104, new MultiCameraLinkeRoomEntranceWidget$updateView$$inlined$let$lambda$1(r100));
        return;
    L14:
        return;
    L13:
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        this.f159549a = (MultiCameraLinkerRoomTagView) findViewById(R.id.tag_view);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        Disposable r101 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.b(this.dataCenter, new AnonymousClass1(this));
        if (r101 == null) goto L5;
        RxUtilKt.c(r101, this.f159550b);
    L5:
        View r102 = this.contentView;
        if (r102 == null) goto L8;
        r102.setOnClickListener(x0.a(new MultiCameraLinkeRoomEntranceWidget$initEvent$1(this)));
    L8:
        ou2.a r103 = ou2.c.a(this.dataCenter);
        if (r103 == null) goto L17;
        com.bytedance.live.datacontext.k<Object> r104 = r103.getDataChanged();
        if (r104 == null) goto L17;
        PublishSubject r105 = r104.onEvent();
        if (r105 == null) goto L17;
        Disposable r106 = r105.subscribe(new b(this));
        if (r106 == null) goto L17;
        RxUtilKt.c(r106, this.f159550b);
    L17:
        u r107 = r.u(this.dataCenter, null, 2);
        if (r107 == null) goto L27;
        com.bytedance.live.datacontext.m<Integer> r108 = r107.J0();
        if (r108 == null) goto L28;
        Observable<Integer> r109 = r108.a();
        if (r109 == null) goto L29;
        Disposable r110 = r109.subscribe(new c(this));
        if (r110 == null) goto L30;
        RxUtilKt.c(r110, this.f159550b);
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    }
}
