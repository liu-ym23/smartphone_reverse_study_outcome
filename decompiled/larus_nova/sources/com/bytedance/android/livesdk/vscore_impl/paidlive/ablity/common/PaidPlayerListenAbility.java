package com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.common;

import com.bytedance.android.livesdk.chatroom.vs_base.base.util.s;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.android.scope.o;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.videoshop.context.VideoContext;
import com.ss.android.videoshop.mediaview.LayerHostMediaLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import mq1.p;
import pu2.k;
import pu2.q;

/* JADX INFO: loaded from: classes11.dex */
public final class PaidPlayerListenAbility implements k, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f160104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<a> f160105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f160106c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i f160107d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f160108e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f160109f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public PaidPlayerListenAbility$registerPaidReplayEventHub$2 f160110g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PaidPlayerListenAbility$registerPaidReplayEventHub$4 f160111h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.bytedance.android.livesdk.vscore_api.paidlive.scope.b f160112i;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f160113a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public q f160114b;

        public a() {
            this("", null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L10;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f160113a, r101.f160113a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f160114b, r101.f160114b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r100 = this.f160113a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            q r104 = this.f160114b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "ListenerItem(key=" + this.f160113a + ", value=" + this.f160114b + ")";
        }

        public a(String r100, q r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            this.f160113a = r100;
            this.f160114b = r101;
        }
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PaidPlayerListenAbility f160115a;

        public b(PaidPlayerListenAbility r100) {
            this.f160115a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            final Boolean r101 = (Boolean) r100;
            PaidPlayerListenAbility.a(this.f160115a.f160105b, new PaidPlayerListenAbility$backgroundHandlerRunningObserver$1$1(r101));
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PaidPlayerListenAbility f160116a;

        public c(PaidPlayerListenAbility r100) {
            this.f160116a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            final Boolean r101 = (Boolean) r100;
            PaidPlayerListenAbility.a(this.f160116a.f160105b, new PaidPlayerListenAbility$playingHandlerRunningObserver$1$1(r101));
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PaidPlayerListenAbility f160117a;

        public d(PaidPlayerListenAbility r100) {
            this.f160117a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            final Boolean r101 = (Boolean) r100;
            if ((!Intrinsics.areEqual(r101, Boolean.TRUE)) == true) goto L7;
            PaidPlayerListenAbility.a(this.f160117a.f160105b, new PaidPlayerListenAbility$registerPaidLiveEventHub$$inlined$apply$lambda$1$1(r101));
            return;
        }
    }

    public static final class e<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PaidPlayerListenAbility f160118a;

        public e(PaidPlayerListenAbility r100) {
            this.f160118a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            final Boolean r101 = (Boolean) r100;
            if ((!Intrinsics.areEqual(r101, Boolean.TRUE)) == true) goto L7;
            PaidPlayerListenAbility.a(this.f160118a.f160105b, new PaidPlayerListenAbility$registerPaidLiveEventHub$$inlined$apply$lambda$2$1(r101));
            return;
        }
    }

    public static final class f<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PaidPlayerListenAbility f160119a;

        public f(PaidPlayerListenAbility r100) {
            this.f160119a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            final String r101 = (String) r100;
            if (r101 == null) goto L7;
            PaidPlayerListenAbility.a(this.f160119a.f160105b, new PaidPlayerListenAbility$registerPaidLiveEventHub$$inlined$apply$lambda$3$1(r101));
            return;
        }
    }

    public static final class g<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PaidPlayerListenAbility f160120a;

        public g(PaidPlayerListenAbility r100) {
            this.f160120a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            final Boolean r101 = (Boolean) r100;
            PaidPlayerListenAbility.a(this.f160120a.f160105b, new PaidPlayerListenAbility$registerPaidLiveEventHub$$inlined$apply$lambda$4$1(r101));
        }
    }

    public static final class h<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PaidPlayerListenAbility f160121a;

        public h(PaidPlayerListenAbility r100) {
            this.f160121a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            final Boolean r101 = (Boolean) r100;
            PaidPlayerListenAbility.a(this.f160121a.f160105b, new PaidPlayerListenAbility$releaseObserver$1$1(r101));
        }
    }

    public static final class i<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PaidPlayerListenAbility f160122a;

        public i(PaidPlayerListenAbility r100) {
            this.f160122a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            final Boolean r101 = (Boolean) r100;
            PaidPlayerListenAbility.a(this.f160122a.f160105b, new PaidPlayerListenAbility$stoppedObserver$1$1(r101));
        }
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    public final IRoomEventHub c() {
        Function0<ILivePlayerClient> r100 = this.f160112i.D().a();
        if (r100 == null) goto L7;
        ILivePlayerClient r101 = r100.invoke();
        if (r101 == null) goto L7;
        return r101.getEventHub();
    L7:
        return null;
    }

    @Override // pu2.k
    public final void yo() {
        if (this.f160112i.w0().isReplay() == true) goto L9;
        IRoomEventHub r100 = c();
        if (r100 == null) goto L7;
        r100.getReleased().removeObserver(this.f160106c);
        r100.getStopped().removeObserver(this.f160107d);
        r100.getPlayingHandlerRunning().removeObserver(this.f160108e);
        r100.getBackgroundHandlerRunning().removeObserver(this.f160109f);
    L7:
        d();
        return;
    }

    public final void d() {
        IRoomEventHub r100 = c();
        if (r100 == null) goto L12;
        r100.getReleased().observeForever(this.f160106c);
        r100.getStopped().observeForever(this.f160107d);
        Boolean r101 = r100.getFirstFrame().getValue();
        Boolean r102 = Boolean.TRUE;
        if (Intrinsics.areEqual(r101, r102) == false) goto L7;
        a(this.f160105b, PaidPlayerListenAbility$registerPaidLiveEventHub$1$1.INSTANCE);
    L7:
        r100.getFirstFrame().observe(this.f160112i.D().g(), new d(this));
        if (Intrinsics.areEqual(r100.getPlaying().getValue(), r102) == false) goto L10;
        a(this.f160105b, PaidPlayerListenAbility$registerPaidLiveEventHub$1$3.INSTANCE);
    L10:
        r100.getPlaying().observe(this.f160112i.D().g(), new e(this));
        r100.getPlayerMediaError().observe(this.f160112i.D().g(), new f(this));
        r100.getPlayingHandlerRunning().observeForever(this.f160108e);
        r100.getBackgroundHandlerRunning().observeForever(this.f160109f);
        r100.getPlayerMute().observe(this.f160112i.D().g(), new g(this));
        return;
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        IRoomEventHub r100 = c();
        if (r100 == null) goto L5;
        r100.getReleased().removeObserver(this.f160106c);
        r100.getStopped().removeObserver(this.f160107d);
        r100.getPlayingHandlerRunning().removeObserver(this.f160108e);
        r100.getBackgroundHandlerRunning().removeObserver(this.f160109f);
    L5:
        PaidPlayerListenAbility$registerPaidReplayEventHub$2 r101 = this.f160110g;
        if (r101 == null) goto L10;
        VideoContext r102 = this.f160112i.D().d();
        if (r102 == null) goto L10;
        r102.K0(r101);
    L10:
        PaidPlayerListenAbility$registerPaidReplayEventHub$4 r103 = this.f160111h;
        if (r103 == null) goto L16;
        p r104 = s.e().a(this.f160112i.D().getDataCenter());
        if (r104 == null) goto L17;
        r104.unregisterReplaySwitchListener(r103);
        return;
    L17:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.common.PaidPlayerListenAbility$registerPaidReplayEventHub$4, mq1.e0] */
    public PaidPlayerListenAbility(com.bytedance.android.livesdk.vscore_api.paidlive.scope.b r100) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        this.f160112i = r100;
        this.f160104a = 1000;
        ArrayList r101 = new ArrayList();
        this.f160105b = r101;
        this.f160106c = new h(this);
        this.f160107d = new i(this);
        this.f160108e = new c(this);
        this.f160109f = new b(this);
        if (r100.w0().isReplay() == true) goto L5;
        d();
        return;
    L5:
        VideoContext r102 = r100.D().d();
        if (r102 != null) goto L8;
    L10:
        PaidPlayerListenAbility$registerPaidReplayEventHub$2 r103 = new PaidPlayerListenAbility$registerPaidReplayEventHub$2(this);
        VideoContext r104 = r100.D().d();
        if (r104 == null) goto L13;
        r104.D0(r103);
    L13:
        Unit r105 = Unit.INSTANCE;
        this.f160110g = r103;
        ?? r106 = new PaidPlayerListenAbility$registerPaidReplayEventHub$4(this);
        p r107 = s.e().a(r100.D().getDataCenter());
        if (r107 == 0) goto L16;
        r107.registerReplaySwitchListener(r106, false);
    L16:
        this.f160111h = r106;
        return;
    L8:
        if (r102.isPlaying() != true) goto L10;
        a(r101, PaidPlayerListenAbility$registerPaidReplayEventHub$1.INSTANCE);
        goto L10
    }

    @Override // pu2.k
    public final void G5(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Iterator<T> r101 = this.f160105b.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Object r102 = r101.next();
        if (Intrinsics.areEqual(((a) r102).f160113a, r100) == false) goto L4;
    L9:
        a r103 = (a) r102;
        List<a> r104 = this.f160105b;
        if (r104 == null) goto L14;
        TypeIntrinsics.asMutableCollection(r104).remove(r103);
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    L8:
        r102 = null;
        goto L9
    }

    public static void a(List r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$forAll");
        Intrinsics.checkNotNullParameter(r101, "action");
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        q r103 = ((a) r102.next()).f160114b;
        if (r103 == null) goto L4;
        r101.invoke(r103);
        goto L4
    }

    @Override // pu2.k
    public final void No(String r100, q r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "listener");
        Iterator r102 = ((ArrayList) this.f160105b).iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if (Intrinsics.areEqual(((a) r103).f160113a, r100) == false) goto L4;
    L9:
        a r104 = (a) r103;
        if (r104 != null) goto L12;
        List<a> r105 = this.f160105b;
        ArrayList r106 = (ArrayList) r105;
        r106.add(new a(r100, r101));
    L13:
        IRoomEventHub r107 = c();
        if (r107 == null) goto L21;
        Boolean r108 = r107.getFirstFrame().getValue();
        Boolean r109 = Boolean.TRUE;
        if (Intrinsics.areEqual(r108, r109) == false) goto L19;
        r101.g(true);
    L19:
        if (Intrinsics.areEqual(r107.getPlaying().getValue(), r109) == false) goto L21;
        r101.n(true);
    L21:
        VideoContext r110 = this.f160112i.D().d();
        if (r110 == null) goto L35;
        LayerHostMediaLayout r111 = r110.f455949c;
        boolean r112 = false;
        if (r111 == null) goto L33;
        qic.a r113 = r111.f456048j;
        if (r113 != null) goto L28;
    L30:
        boolean r114 = false;
    L31:
        if (r114 == false) goto L33;
        r112 = true;
        goto L33
    L28:
        if (r113.isStarted() == false) goto L30;
        r114 = true;
    L33:
        if (r112 != true) goto L35;
        r101.g(true);
    L35:
        VideoContext r115 = this.f160112i.D().d();
        if (r115 != null) goto L38;
        return;
    L38:
        if (r115.isPlaying() != true) goto L45;
        r101.n(true);
        return;
    L45:
        return;
    L12:
        r104.f160114b = r101;
        goto L13
    L8:
        r103 = null;
        goto L9
    }
}
