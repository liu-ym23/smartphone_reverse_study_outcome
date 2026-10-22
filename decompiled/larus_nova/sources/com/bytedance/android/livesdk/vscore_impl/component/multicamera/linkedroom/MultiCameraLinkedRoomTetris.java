package com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import com.bytedance.android.live.core.tetris.layer.core.tetris.LiveTetris;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.model.PadOrientation;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.VSOptimizeUtils;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.s;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.vscore_impl.component.tabs.MultiTabManagerImpl;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.RoomKt;
import com.bytedance.android.livesdkapi.model.VSOptimizeConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import vr1.u;
import zg1.i1;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/vscore_impl/component/multicamera/linkedroom/MultiCameraLinkedRoomTetris;", "Lcom/bytedance/android/live/core/tetris/layer/core/tetris/LiveTetris;", "Ld90/d;", "Lzg1/i1;", "event", "", "onEvent", "<init>", "()V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MultiCameraLinkedRoomTetris extends LiveTetris<d90.d> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ViewGroup f159565o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ViewGroup f159566p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public View f159567q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final CompositeDisposable f159568r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f159569s;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MultiCameraLinkedRoomTetris f159570a;

        public a(MultiCameraLinkedRoomTetris r100) {
            this.f159570a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            this.f159570a.W();
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MultiCameraLinkedRoomTetris f159571a;

        public b(MultiCameraLinkedRoomTetris r100) {
            this.f159571a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            sh6.b r101 = (sh6.b) r100;
            View r102 = this.f159571a.f159567q;
            if (r102 == null) goto L6;
            r102.setAlpha(1.0f);
            return;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MultiCameraLinkedRoomTetris f159572a;

        public c(MultiCameraLinkedRoomTetris r100) {
            this.f159572a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            if (((Boolean) r100).booleanValue() == false) goto L18;
            View r101 = this.f159572a.f159567q;
            if (r101 == null) goto L9;
            ViewPropertyAnimator r102 = r101.animate();
            if (r102 == null) goto L9;
            r102.cancel();
        L9:
            View r103 = this.f159572a.f159567q;
            if (r103 == null) goto L33;
            ViewPropertyAnimator r104 = r103.animate();
            if (r104 == null) goto L34;
            ViewPropertyAnimator r105 = r104.alpha(0.0f);
            if (r105 == null) goto L35;
            ViewPropertyAnimator r106 = r105.setDuration(300);
            if (r106 == null) goto L36;
            r106.start();
            return;
        L36:
            return;
        L35:
            return;
        L34:
            return;
        L33:
            return;
        L18:
            View r107 = this.f159572a.f159567q;
            if (r107 == null) goto L23;
            ViewPropertyAnimator r108 = r107.animate();
            if (r108 == null) goto L23;
            r108.cancel();
        L23:
            View r109 = this.f159572a.f159567q;
            if (r109 == null) goto L38;
            ViewPropertyAnimator r110 = r109.animate();
            if (r110 == null) goto L39;
            ViewPropertyAnimator r111 = r110.alpha(1.0f);
            if (r111 == null) goto L40;
            ViewPropertyAnimator r112 = r111.setDuration(300);
            if (r112 == null) goto L41;
            r112.start();
            return;
        L41:
            return;
        L40:
            return;
        L39:
            return;
        }
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final void O() {
        if (((VSOptimizeConfig) VSOptimizeUtils.f117919a.getValue()).getMultiCamera() == false) goto L26;
        DataCenter r100 = getDataCenter();
        IRoom r101 = null;
        if (r100 == null) goto L7;
        IRoom r102 = lu2.c.f(r100);
    L9:
        if (RoomKt.hasMultiCamera(r102) == true) goto L25;
        DataCenter r103 = getDataCenter();
        if (r103 == null) goto L14;
        r101 = lu2.c.f(r103);
    L14:
        if (lu2.c.b(r101) == true) goto L25;
        ou2.a r104 = ou2.c.a(getDataCenter());
        if (r104 == null) goto L27;
        com.bytedance.live.datacontext.k<Object> r105 = r104.getDataChanged();
        if (r105 == null) goto L27;
        PublishSubject r106 = r105.onEvent();
        if (r106 == null) goto L27;
        Disposable r107 = r106.subscribe(new a(this));
        if (r107 == null) goto L27;
        RxUtilKt.c(r107, this.f159568r);
    L27:
        T(i1.class, new MultiCameraLinkedRoomTetris$onViewCreated$2(this));
        if (PadConfigUtils.c() == false) goto L36;
        u r108 = V();
        if (r108 == null) goto L36;
        com.bytedance.live.datacontext.n<PadOrientation> r109 = r108.w();
        if (r109 == null) goto L36;
        Disposable r110 = i80.a.b(r109, new MultiCameraLinkedRoomTetris$onViewCreated$3(this));
        if (r110 == null) goto L36;
        RxUtilKt.c(r110, this.f159568r);
    L36:
        s.i().a();
        if (MultiTabManagerImpl.f159902e.h(getDataCenter()) == true) goto L60;
        u r111 = V();
        if (r111 == null) goto L48;
        com.bytedance.live.datacontext.j<Unit> r112 = r111.k();
        if (r112 == null) goto L48;
        if (r112.hasValue() != true) goto L48;
        View r113 = this.f159567q;
        if (r113 == null) goto L60;
        r113.setAlpha(1.0f);
    L48:
        View r114 = this.f159567q;
        if (r114 == null) goto L51;
        r114.setAlpha(0.0f);
    L51:
        u r115 = V();
        if (r115 == null) goto L60;
        com.bytedance.live.datacontext.j<Unit> r116 = r115.k();
        if (r116 == null) goto L60;
        Maybe<sh6.b<Unit>> r117 = r116.b();
        if (r117 == null) goto L60;
        Disposable r118 = r117.subscribe(new b(this));
        if (r118 == null) goto L60;
        RxUtilKt.c(r118, this.f159568r);
    L60:
        u r119 = V();
        if (r119 == null) goto L70;
        com.bytedance.live.datacontext.m<Boolean> r120 = r119.z1();
        if (r120 == null) goto L71;
        Observable<Boolean> r121 = r120.a();
        if (r121 == null) goto L72;
        Disposable r122 = r121.subscribe(new c(this));
        if (r122 == null) goto L73;
        RxUtilKt.c(r122, this.f159568r);
        return;
    L73:
        return;
    L72:
        return;
    L71:
        return;
    L70:
        return;
    L25:
        W();
        goto L27
    L7:
        r102 = null;
        goto L9
    L26:
        W();
        goto L27
    }

    public final void W() {
        if (this.f159569s == false) goto L5;
        return;
    L5:
        s.i().a();
        if (MultiTabManagerImpl.f159902e.h(getDataCenter()) == false) goto L10;
        ViewGroup r100 = this.f159566p;
        if (r100 == null) goto L16;
        LiveTetris.Q(this, MultiCameraLinkedRoomTabsEntrance.class, r100, false, null, 24);
    L16:
        this.f159569s = true;
        return;
    L10:
        ViewGroup r101 = this.f159565o;
        if (r101 == null) goto L16;
        if (com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.util.e.c(getDataCenter()) == false) goto L15;
        LiveTetris.Q(this, UgcLinkedRoomEntranceWidget.class, r101, false, null, 24);
        goto L16
    L15:
        LiveTetris.Q(this, MultiCameraLinkeRoomEntranceWidget.class, r101, false, null, 24);
        goto L16
    }

    public MultiCameraLinkedRoomTetris() {
        this.f159568r = new CompositeDisposable();
    }

    public final u V() {
        return r.u(getDataCenter(), null, 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final DataCenter getDataCenter() {
        return ((d90.d) K()).f467480h;
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final void onDestroy() {
        super.onDestroy();
        this.f159568r.clear();
        this.f159569s = false;
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final View G(t70.k r100) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r101 = r100.b(R.layout.ttlive_vs_portrait_horizontal_linked_camera_tetris);
        this.f159565o = (ViewGroup) r101.findViewById(R.id.linked_camera_entry_no_tabs);
        this.f159566p = (ViewGroup) r101.findViewById(R.id.linked_camera_entry_with_tabs);
        this.f159567q = r101;
        return r101;
    }

    public final void onEvent(i1 r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (r100.f571850b == false) goto L8;
        View r101 = this.f159567q;
        if (r101 == null) goto L26;
        r101.setVisibility(8);
        return;
    L26:
        return;
    L8:
        if (PadConfigUtils.c() == false) goto L21;
        u r102 = V();
        if (r102 == null) goto L14;
        com.bytedance.live.datacontext.n<PadOrientation> r103 = r102.w();
        if (r103 == null) goto L14;
        PadOrientation r104 = r103.getValue();
    L16:
        if (r104 != PadOrientation.LANDSCAPE) goto L21;
        View r105 = this.f159567q;
        if (r105 == null) goto L25;
        r105.setVisibility(8);
        return;
    L25:
        return;
    L14:
        r104 = null;
    L21:
        View r106 = this.f159567q;
        if (r106 == null) goto L28;
        r106.setVisibility(0);
        return;
    }
}
