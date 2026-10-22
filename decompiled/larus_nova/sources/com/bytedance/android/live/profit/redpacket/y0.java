package com.bytedance.android.live.profit.redpacket;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.revenue.common.PropertyOwnersKt;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes47.dex */
public final class y0 implements com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f88774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f88775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PropertyOwner<a> f88776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PropertyOwner f88777d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PropertyOwner<Integer> f88778e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PropertyOwner f88779f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final PropertyOwner<Unit> f88780g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final PropertyOwner f88781h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final PropertyOwner<sh6.b<n0>> f88782i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final PropertyOwner f88783j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final r0 f88784k;

    public static abstract class a {

        /* JADX INFO: renamed from: com.bytedance.android.live.profit.redpacket.y0$a$a, reason: collision with other inner class name */
        public static final class C1363a extends a implements d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final com.bytedance.android.live.profit.redpacket.e f88785a;

            public final int hashCode() {
                com.bytedance.android.live.profit.redpacket.e r100 = this.f88785a;
                if (r100 != null) goto L7;
                return 0;
            L7:
                return r100.hashCode();
            }

            public final String toString() {
                return "Available(packet=" + this.f88785a + ")";
            }

            @Override // com.bytedance.android.live.profit.redpacket.y0.a.d
            public final com.bytedance.android.live.profit.redpacket.e a() {
                return this.f88785a;
            }

            public C1363a(com.bytedance.android.live.profit.redpacket.e r100) {
                Intrinsics.checkNotNullParameter(r100, "packet");
                this.f88785a = r100;
            }

            public final boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof C1363a) == true) goto L6;
                return false;
            L6:
                if (Intrinsics.areEqual(this.f88785a, ((C1363a) r100).f88785a) == true) goto L13;
                return false;
            L13:
                return true;
            }
        }

        public static final class b extends a implements d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final com.bytedance.android.live.profit.redpacket.e f88786a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Function0<Unit> f88787b;

            public final int hashCode() {
                com.bytedance.android.live.profit.redpacket.e r100 = this.f88786a;
                int r101 = 0;
                if (r100 == null) goto L5;
                int r102 = r100.hashCode();
            L6:
                int r103 = r102 * 31;
                Function0<Unit> r104 = this.f88787b;
                if (r104 == null) goto L10;
                r101 = r104.hashCode();
            L10:
                return r103 + r101;
            L5:
                r102 = 0;
                goto L6
            }

            public final String toString() {
                return "Empty(packet=" + this.f88786a + ", onAnimFinish=" + this.f88787b + ")";
            }

            @Override // com.bytedance.android.live.profit.redpacket.y0.a.d
            public final com.bytedance.android.live.profit.redpacket.e a() {
                return this.f88786a;
            }

            public final boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof b) == false) goto L10;
                b r101 = (b) r100;
                if (Intrinsics.areEqual(this.f88786a, r101.f88786a) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.f88787b, r101.f88787b) == true) goto L16;
                return false;
            L16:
                return true;
            L10:
                return false;
            }

            public b(com.bytedance.android.live.profit.redpacket.e r100, Function0<Unit> r101) {
                Intrinsics.checkNotNullParameter(r100, "packet");
                Intrinsics.checkNotNullParameter(r101, "onAnimFinish");
                this.f88786a = r100;
                this.f88787b = r101;
            }
        }

        public static final class c extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f88788a = null;

            static {
                f88788a = new c();
            }

            public c() {
            }
        }

        public interface d {
            com.bytedance.android.live.profit.redpacket.e a();
        }

        public static final class e extends a implements d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final com.bytedance.android.live.profit.redpacket.e f88789a;

            public final int hashCode() {
                com.bytedance.android.live.profit.redpacket.e r100 = this.f88789a;
                if (r100 != null) goto L7;
                return 0;
            L7:
                return r100.hashCode();
            }

            public final String toString() {
                return "Wait(packet=" + this.f88789a + ")";
            }

            @Override // com.bytedance.android.live.profit.redpacket.y0.a.d
            public final com.bytedance.android.live.profit.redpacket.e a() {
                return this.f88789a;
            }

            public e(com.bytedance.android.live.profit.redpacket.e r100) {
                Intrinsics.checkNotNullParameter(r100, "packet");
                this.f88789a = r100;
            }

            public final boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof e) == true) goto L6;
                return false;
            L6:
                if (Intrinsics.areEqual(this.f88789a, ((e) r100).f88789a) == true) goto L13;
                return false;
            L13:
                return true;
            }
        }

        public a() {
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y0 f88790a;

        public b(y0 r100) {
            this.f88790a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            List r101 = (List) r100;
            this.f88790a.f88778e.onNext(Integer.valueOf(r101.size()));
            y0.a(this.f88790a, true);
            PropertyOwner<sh6.b<n0>> r102 = this.f88790a.f88782i;
            Intrinsics.checkNotNullParameter(r101, "redPacketList");
            final String r103 = ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).getCurrentUserId();
            com.bytedance.android.live.revenue.common.u0 r104 = com.bytedance.android.live.revenue.common.u0.f90999f;
            final com.bytedance.android.live.revenue.common.u0 r105 = com.bytedance.android.live.revenue.common.u0.a.a(3);
            r102.a(sh6.c.a((n0) SequencesKt.firstOrNull(SequencesKt.filter(SequencesKt.filter(SequencesKt.map(CollectionsKt.asSequence(r101), RedPacketIconHelpersKt$getOwnFirstWaiting3SecRedPacket$1.INSTANCE), new RedPacketIconHelpersKt$getOwnFirstWaiting3SecRedPacket$2(r103)), new RedPacketIconHelpersKt$getOwnFirstWaiting3SecRedPacket$3(r105)))));
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y0 f88791a;

        public c(y0 r100) {
            this.f88791a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Unit r101 = (Unit) r100;
            this.f88791a.f88780g.onNext(Unit.INSTANCE);
        }
    }

    public final int c() {
        Iterable r100 = (Iterable) this.f88784k.f88708e.f267520d;
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add(((RedPacket) r102.next()).getState().getInfo());
        goto L4
    L6:
        Intrinsics.checkNotNullParameter(r101, "infoList");
        Iterator r103 = r101.iterator();
        int r104 = 0;
    L8:
        if (r103.hasNext() == false) goto L10;
        r104 = r104 + ((n0) r103.next()).f88677m;
        goto L8
    L10:
        return r104;
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        RxUtilKt.c(PropertyOwnersKt.c(this.f88784k.f88708e).subscribe(new b(this)), this.f88774a);
        RxUtilKt.c(this.f88784k.f88710g.subscribe(new c(this)), this.f88774a);
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f88774a.dispose();
    }

    public y0(r0 r100) {
        Intrinsics.checkNotNullParameter(r100, "repository");
        this.f88784k = r100;
        CompositeDisposable r101 = new CompositeDisposable();
        this.f88774a = r101;
        CompositeDisposable r102 = new CompositeDisposable();
        RxUtilKt.c(r102, r101);
        this.f88775b = r102;
        PropertyOwner<a> r103 = new PropertyOwner(a.c.f88788a);
        this.f88776c = r103;
        this.f88777d = r103;
        PropertyOwner<Integer> r104 = new PropertyOwner(0);
        this.f88778e = r104;
        this.f88779f = r104;
        PropertyOwner<Unit> r105 = new PropertyOwner(Unit.INSTANCE);
        this.f88780g = r105;
        this.f88781h = r105;
        PropertyOwner<sh6.b<n0>> r106 = new PropertyOwner(sh6.a.f541970a);
        this.f88782i = r106;
        this.f88783j = r106;
    }

    public static final void a(y0 r100, boolean r101) {
        Iterator r102 = ((List) r100.f88784k.f88708e.f267520d).iterator();
    L3:
        RedPacketState r103 = null;
        if (r102.hasNext() == false) goto L8;
        Object r104 = r102.next();
        if ((!f.a(((e) r104).getState())) == false) goto L3;
    L9:
        e r105 = (e) r104;
        Object r106 = r100.f88776c.f64752a;
        if ((r106 instanceof a.d) == true) goto L12;
        r106 = null;
    L12:
        a.d r107 = (a.d) r106;
        if (r107 == null) goto L15;
        e r108 = r107.a();
    L17:
        if (Intrinsics.areEqual(r105, r108) == true) goto L40;
        Object r109 = r100.f88776c.f64752a;
        if ((r109 instanceof a.d) == true) goto L22;
        r109 = null;
    L22:
        a.d r110 = (a.d) r109;
        if (r110 == null) goto L28;
        e r111 = r110.a();
        if (r111 == null) goto L28;
        r103 = r111.getState();
    L28:
        if ((r103 instanceof RedPacketState.Empty) == false) goto L31;
        if (r101 == false) goto L31;
        return;
    L31:
        r100.f88775b.clear();
        if (r105 != null) goto L34;
        r100.f88776c.a(a.c.f88788a);
        return;
    L34:
        RxUtilKt.c(r105.a().map(z0.f88793a).startWith(r105.getState()).subscribe(new a1(r100, r105)), r100.f88775b);
        return;
    L40:
        return;
    L15:
        r108 = null;
        goto L17
    L8:
        r104 = null;
        goto L9
    }
}
