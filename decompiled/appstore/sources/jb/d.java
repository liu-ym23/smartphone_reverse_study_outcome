package jb;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.obric.common.oea.foundation.animation.constants.RepeatMode;
import com.obric.common.oea.foundation.animation.constants.RunMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.b0;
import kotlin.collections.u;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final qb.c f20971d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f20972e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f20973f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f20974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public jb.a f20975b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f20976c;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f20977a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f20978b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f20979c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ View f20980d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ RunMode f20981e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ float f20982f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ RepeatMode f20983g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ List f20984h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ Function3 f20985i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ Function2 f20986j;

        public b(d r10, float r11, boolean r12, View r13, RunMode r14, float r15, RepeatMode r16, List r17, Function3 r18, Function2 r19) {
            this.f20977a = r10;
            this.f20978b = r11;
            this.f20979c = r12;
            this.f20980d = r13;
            this.f20981e = r14;
            this.f20982f = r15;
            this.f20983g = r16;
            this.f20984h = r17;
            this.f20985i = r18;
            this.f20986j = r19;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.a(this.f20977a, this.f20978b, this.f20979c, this.f20980d, this.f20981e, this.f20982f, this.f20983g, this.f20984h, this.f20985i, this.f20986j);
        }
    }

    static {
        f20973f = new a(null);
        f20971d = new qb.c();
    }

    public d() {
        this.f20974a = new c();
        int r10 = f20972e;
        f20972e = r10 + 1;
        this.f20976c = r10;
    }

    public static final /* synthetic */ void a(d r10, float r11, boolean r12, View r13, RunMode r14, float r15, RepeatMode r16, List r17, Function3 r18, Function2 r19) {
        r10.d(r11, r12, r13, r14, r15, r16, r17, r18, r19);
    }

    public static /* synthetic */ void c(d r10, boolean r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r11 = false;
    L5:
        r10.b(r11);
    }

    public final void b(boolean r10) {
        qb.b.f23627c.f("AnimationManager", "cancel, instanceId: [" + this.f20976c + "], clearVelocity: " + r10);
        jb.a r11 = this.f20975b;
        if (r11 == null) goto L6;
        r11.f(r10);
        return;
    }

    public final void d(float r18, boolean r19, View r20, RunMode r21, float r22, RepeatMode r23, List r24, Function3 r25, Function2 r26) {
        qb.b r10 = qb.b.f23627c;
        StringBuilder r11 = new StringBuilder();
        r11.append("start, instanceId: [");
        r11.append(this.f20976c);
        r11.append("], runAnimation, mode: ");
        r11.append(r21);
        r11.append(", speed: ");
        r11.append(r22);
        r11.append(", repeatMode: ");
        r11.append(r23);
        r11.append(", animationInfos: ");
        ArrayList r12 = new ArrayList(u.r(r24, 10));
        Iterator r13 = r24.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r12.add(((gb.a) r13.next()).a());
        goto L4
    L6:
        r11.append(b0.h0(r12, "\n", null, null, 0, null, null, 62, null));
        r10.f("AnimationManager", r11.toString());
        this.f20974a.A(r18);
        this.f20974a.x(r21);
        this.f20974a.w(r23);
        this.f20974a.r(r24);
        this.f20974a.B(r20);
        this.f20974a.y(r22);
        this.f20974a.u(r19);
        jb.a r14 = new jb.a(this.f20974a, r25, r26);
        this.f20975b = r14;
        r14.n();
    }

    public final void e(com.obric.common.oea.foundation.animation.builder.a r12, View r13, List r14, Function3 r15, Function2 r16) {
        q.g(r12, "animConfig");
        q.g(r14, "animationInfos");
        f(r12.e(), r12.a(), r13, r12.c(), r12.d(), r12.b(), r14, r15, r16);
    }

    public final void f(float r14, boolean r15, View r16, RunMode r17, float r18, RepeatMode r19, List r20, Function3 r21, Function2 r22) {
        Looper r10 = Looper.getMainLooper();
        q.f(r10, "Looper.getMainLooper()");
        if (q.b(r10.getThread(), Thread.currentThread()) == true) goto L5;
        new Handler(Looper.getMainLooper()).post(new b(this, r14, r15, r16, r17, r18, r19, r20, r21, r22));
        return;
    L5:
        d(r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }
}
