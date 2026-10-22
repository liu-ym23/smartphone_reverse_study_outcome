package com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.tetris.layer.core.event.LayerEventDispatcher;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.ui.UgcLinkedRoomTagView;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import vr1.u;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/vscore_impl/component/multicamera/linkedroom/UgcLinkedRoomEntranceWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "<init>", "()V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UgcLinkedRoomEntranceWidget extends LiveRecyclableWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public UgcLinkedRoomTagView f159625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f159626b;

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_vs_ugc_linked_room_entrance;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        this.f159626b.clear();
        UgcLinkedRoomTagView r100 = this.f159625a;
        if (r100 == null) goto L6;
        r100.f159753m.clear();
        return;
    }

    public UgcLinkedRoomEntranceWidget() {
        this.f159626b = new CompositeDisposable();
    }

    public static final void wq(UgcLinkedRoomEntranceWidget r100) {
        DataCenter r101 = r100.dataCenter;
        if (r101 == null) goto L5;
        Integer r102 = Integer.valueOf(r101.hashCode());
    L6:
        LayerEventDispatcher r103 = o70.c.a(r102);
        if (r103 == null) goto L9;
        r103.b(MultiCameraPanelEvent.f159575b);
    L9:
        final Map r104 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("vs_icon_type", "only_relevant_live")});
        Map<String, String> r105 = com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.util.e.a(r100.dataCenter);
        if (r105 == null) goto L12;
        r104.putAll(r105);
    L12:
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.l> r106 = r.l().h(r100.dataCenter);
        if (r106 == null) goto L15;
        final String r107 = "livesdk_relevant_live_icon_click";
        r106.c(new UgcLinkedRoomEntranceWidget$logClick$2(r107, r104));
    L15:
        int r108 = com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.util.a.f159779a;
        com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.util.a.a(r100.dataCenter);
        return;
    L5:
        r102 = null;
        goto L6
    }

    public static final void xq(final UgcLinkedRoomEntranceWidget r100) {
        DataCenter r101 = r100.dataCenter;
        if (com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.util.e.f159782a.booleanValue() == true) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L13;
        ViewGroup r103 = r100.containerView;
        if (r103 == null) goto L26;
        UtilityKotlinExtentionsKt.v(r103, false);
        return;
    L26:
        return;
    L13:
        if (com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.util.e.d(r100.dataCenter) == true) goto L17;
        ViewGroup r104 = r100.containerView;
        if (r104 == null) goto L28;
        UtilityKotlinExtentionsKt.v(r104, false);
        return;
    L28:
        return;
    L17:
        UgcLinkedRoomTagView r105 = r100.f159625a;
        if (r105 == null) goto L30;
        r105.a(r100.dataCenter);
        ViewGroup r106 = r100.containerView;
        if (r106 == null) goto L22;
        UtilityKotlinExtentionsKt.v(r106, true);
    L22:
        DataCenter r107 = r100.dataCenter;
        if (r107 == null) goto L31;
        com.bytedance.android.livesdk.chatroom.vs_base.util.h.f(r107, new UgcLinkedRoomEntranceWidget$updateView$$inlined$let$lambda$1(r100));
        return;
    L31:
        return;
    L30:
        return;
    L5:
        if (com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.util.e.c(r101) == false) goto L7;
        r102 = true;
        goto L8
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        this.f159625a = (UgcLinkedRoomTagView) findViewById(R.id.tag_view);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        Disposable r101 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.b(this.dataCenter, new AnonymousClass1(this));
        if (r101 == null) goto L5;
        RxUtilKt.c(r101, this.f159626b);
    L5:
        View r102 = this.contentView;
        if (r102 == null) goto L8;
        r102.setOnClickListener(x0.a(new UgcLinkedRoomEntranceWidget$initEvent$1(this)));
    L8:
        ou2.a r103 = ou2.c.a(this.dataCenter);
        if (r103 == null) goto L17;
        com.bytedance.live.datacontext.k<Object> r104 = r103.getDataChanged();
        if (r104 == null) goto L17;
        PublishSubject r105 = r104.onEvent();
        if (r105 == null) goto L17;
        Disposable r106 = r105.subscribe(new o(this));
        if (r106 == null) goto L17;
        RxUtilKt.c(r106, this.f159626b);
    L17:
        ou2.a r107 = ou2.c.a(this.dataCenter);
        if ((r107 instanceof MultiCameraLinkedRoomContext) == true) goto L20;
        r107 = null;
    L20:
        MultiCameraLinkedRoomContext r108 = (MultiCameraLinkedRoomContext) r107;
        if (r108 == null) goto L29;
        com.bytedance.live.datacontext.m<Integer> r109 = r108.getPortraitStyle();
        if (r109 == null) goto L29;
        Observable<Integer> r110 = r109.a();
        if (r110 == null) goto L29;
        Disposable r111 = r110.subscribe(new p(this));
        if (r111 == null) goto L29;
        RxUtilKt.c(r111, this.f159626b);
    L29:
        u r112 = r.u(this.dataCenter, null, 2);
        if (r112 == null) goto L39;
        com.bytedance.live.datacontext.m<Integer> r113 = r112.J0();
        if (r113 == null) goto L40;
        Observable<Integer> r114 = r113.a();
        if (r114 == null) goto L41;
        Disposable r115 = r114.subscribe(new q(this));
        if (r115 == null) goto L42;
        RxUtilKt.c(r115, this.f159626b);
        return;
    L42:
        return;
    L41:
        return;
    L40:
        return;
    }
}
