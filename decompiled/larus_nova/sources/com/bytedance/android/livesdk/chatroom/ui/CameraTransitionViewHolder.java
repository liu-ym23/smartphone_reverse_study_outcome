package com.bytedance.android.livesdk.chatroom.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.platformplayer.model.VideoRenderViewParams;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.model.PadOrientation;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class CameraTransitionViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f112116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f112117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LiveDoubleColorBallAnimationView f112118c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DataCenter f112119d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f112120e;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/CameraTransitionViewHolder$State;", "", "IDLE", "FADE_IN", "BLACK", "FADE_OUT", "platform-player-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum State extends Enum<State> {
        public static final State BLACK = null;
        public static final State FADE_IN = null;
        public static final State FADE_OUT = null;
        public static final State IDLE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f112121a = null;

        static {
            State r100 = new State("IDLE", 0);
            IDLE = r100;
            State r101 = new State("FADE_IN", 1);
            FADE_IN = r101;
            State r102 = new State("BLACK", 2);
            BLACK = r102;
            State r103 = new State("FADE_OUT", 3);
            FADE_OUT = r103;
            f112121a = new State[]{r100, r101, r102, r103};
        }

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        public static State[] values() {
            return (State[]) f112121a.clone();
        }

        public State(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CameraTransitionViewHolder f112122a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DataCenter f112123b;

        public a(CameraTransitionViewHolder r100, DataCenter r101) {
            this.f112122a = r100;
            this.f112123b = r101;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            VideoViewParams r101 = (VideoViewParams) r100;
            if (PadConfigUtils.c() == false) goto L15;
            RoomContext r102 = RoomContext.a.c(RoomContext.Companion, this.f112123b, 0, 2);
            if (r102 == null) goto L9;
            com.bytedance.live.datacontext.n<PadOrientation> r103 = r102.getPadOrientation();
            if (r103 == null) goto L9;
            PadOrientation r104 = r103.getValue();
        L11:
            if (r104 != PadOrientation.LANDSCAPE) goto L13;
            return;
        L13:
            if (com.bytedance.android.livesdk.utils.e5.n() == false) goto L15;
            return;
        L9:
            r104 = null;
        L15:
            CameraTransitionViewHolder r105 = this.f112122a;
            if (r105.f112120e == false) goto L24;
            if (r101 == null) goto L22;
            r105.c(r101);
            return;
        L22:
            return;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CameraTransitionViewHolder f112124a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f112125b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function0 f112126c;

        public b(CameraTransitionViewHolder r100, View r101, Function0 r102) {
            this.f112124a = r100;
            this.f112125b = r101;
            this.f112126c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CameraTransitionViewHolder r100 = this.f112124a;     // Catch: Throwable -> L10
            View r101 = r100.f112117b;     // Catch: Throwable -> L10
            if (r101 == null) goto L5;
            UtilityKotlinExtentionsKt.w(r101);     // Catch: Throwable -> L10
        L5:
            LiveDoubleColorBallAnimationView r102 = r100.f112118c;     // Catch: Throwable -> L10
            if (r102 == null) goto L8;
            UtilityKotlinExtentionsKt.w(r102);     // Catch: Throwable -> L10
        L8:
            this.f112125b.setAlpha(0.0f);     // Catch: Throwable -> L10
            CameraTransitionViewHolder r103 = this.f112124a;     // Catch: Throwable -> L10
            State r104 = State.IDLE;     // Catch: Throwable -> L10
            r103.getClass();     // Catch: Throwable -> L10
            this.f112126c.invoke();     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L14;
            return;
        L14:
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CameraTransitionViewHolder f112127a;

        public c(CameraTransitionViewHolder r100) {
            this.f112127a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CameraTransitionViewHolder r100 = this.f112127a;     // Catch: Throwable -> L4
            State r101 = State.IDLE;     // Catch: Throwable -> L4
            r100.getClass();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f112128a;

        public d(Function0 r100) {
            this.f112128a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f112128a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final void b() {
        View r100 = this.f112117b;
        if (r100 == null) goto L5;
        UtilityKotlinExtentionsKt.t(r100);
    L5:
        LiveDoubleColorBallAnimationView r101 = this.f112118c;
        if (r101 == null) goto L8;
        UtilityKotlinExtentionsKt.t(r101);
    L8:
        View r102 = this.f112116a;
        if (r102 == null) goto L11;
        UtilityKotlinExtentionsKt.t(r102);
    L11:
        State r103 = State.IDLE;
    }

    public final void c(VideoViewParams r100) {
        View r101 = this.f112116a;
        IRoom r102 = null;
        if (r101 == null) goto L5;
        ViewGroup.LayoutParams r103 = r101.getLayoutParams();
    L7:
        if ((r103 instanceof FrameLayout.LayoutParams) == true) goto L9;
        r103 = null;
    L9:
        FrameLayout.LayoutParams r104 = (FrameLayout.LayoutParams) r103;
        if (r104 == null) goto L38;
        r104.width = r100.f112569a;
        r104.height = r100.f112570b;
        r104.topMargin = r100.f112571c;
        DataCenter r105 = this.f112119d;
        if (r105 == null) goto L14;
        boolean r106 = com.bytedance.android.live.core.utils.a0.l(r105, true);
    L15:
        if (r106 == true) goto L37;
        DataCenter r107 = this.f112119d;
        if (r107 == null) goto L19;
        boolean r108 = com.bytedance.android.live.core.utils.a0.d(r107, false);
    L20:
        DataCenter r109 = this.f112119d;
        if (r109 == null) goto L23;
        IRoom r110 = com.bytedance.android.live.core.utils.a0.n(r109);
    L25:
        if (com.bytedance.android.livesdk.utils.landscape.e.b(r108, r110) == false) goto L32;
        DataCenter r111 = this.f112119d;
        if (r111 == null) goto L30;
        r102 = com.bytedance.android.live.core.utils.a0.n(r111);
    L30:
        if (com.bytedance.android.livesdk.utils.landscape.e.a(r102) == false) goto L32;
        boolean r112 = true;
    L33:
        if (r112 == false) goto L37;
        if (l42.a.f507320g.getValue().booleanValue() == true) goto L37;
        r104.gravity = 8388629;
        r104.rightMargin = (int) UtilityKotlinExtentionsKt.h(200.0f);
    L32:
        r112 = false;
        goto L33
    L23:
        r110 = null;
        goto L25
    L19:
        r108 = false;
    L37:
        r104.gravity = 1;
        r104.rightMargin = 0;
        goto L38
    L14:
        r106 = false;
    L38:
        View r113 = this.f112116a;
        if (r113 == null) goto L42;
        r113.setLayoutParams(r104);
        return;
    L42:
        return;
    L5:
        r103 = null;
        goto L7
    }

    public CameraTransitionViewHolder(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "transitionView");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        State r102 = State.IDLE;
        this.f112116a = r100;
        this.f112119d = r101;
        View r103 = r100.findViewById(R.id.loading_container);
        this.f112117b = r103;
        LiveDoubleColorBallAnimationView r104 = (LiveDoubleColorBallAnimationView) r100.findViewById(R.id.loading_view);
        this.f112118c = r104;
        com.bytedance.android.livesdk.r3.a(r100, com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_match_camera_loading));
        new VideoRenderViewParams(r101).f85723a.observe(r101.lifecycleOwner, new a(this, r101));
        if (r103 == null) goto L5;
        UtilityKotlinExtentionsKt.t(r103);
    L5:
        if (r104 == null) goto L8;
        UtilityKotlinExtentionsKt.t(r104);
        return;
    }

    public final void a(VideoViewParams r100, boolean r101, boolean r102, Function0<Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "transitionViewParams");
        Intrinsics.checkNotNullParameter(r103, "switchStream");
        View r104 = this.f112116a;
        if (r104 != null) goto L5;
        return;
    L5:
        this.f112120e = r101;
        r104.animate().cancel();
        RoomContext r105 = RoomContext.a.c(RoomContext.Companion, this.f112119d, 0, 2);
        if (r105 == null) goto L10;
        com.bytedance.live.datacontext.m<Boolean> r106 = r105.getStreamTransitionAnimating();
        if (r106 == null) goto L10;
        r106.setValue(Boolean.TRUE);
    L10:
        r104.animate().cancel();
        c(r100);
        UtilityKotlinExtentionsKt.w(r104);
        if (r102 == false) goto L13;
        r104.animate().alpha(1.0f).setDuration(150).withStartAction(new b(this, r104, r103)).withEndAction(new c(this)).start();
        return;
    L13:
        UtilityKotlinExtentionsKt.w(r104);
        View r107 = this.f112117b;
        if (r107 == null) goto L16;
        UtilityKotlinExtentionsKt.w(r107);
    L16:
        LiveDoubleColorBallAnimationView r108 = this.f112118c;
        if (r108 == null) goto L19;
        UtilityKotlinExtentionsKt.w(r108);
    L19:
        r104.setAlpha(1.0f);
        State r109 = State.IDLE;
        r104.post(new d(r103));
    }
}
