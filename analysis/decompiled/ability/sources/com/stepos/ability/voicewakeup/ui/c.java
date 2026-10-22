package com.stepos.ability.voicewakeup.ui;

import android.os.SystemClock;
import android.util.Log;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.k;
import m9.C1718k;
import m9.InterfaceC1717j;
import org.libpag.PAGView;

/* loaded from: classes3.dex */
public final class c implements PAGView.PAGViewListener {

    /* renamed from: a, reason: collision with root package name */
    public final WakeupPagAnimation f3437a;
    public final WakeupPagPlayer$Mode b;
    public InterfaceC1717j c;
    public final long d;
    public final long e;
    public final long f;
    public Long g;
    public long h;
    public final AtomicInteger i;

    /* renamed from: j, reason: collision with root package name */
    public final AtomicLong f3438j;
    public long k;
    public long l;
    public boolean m;
    public final b n;
    public boolean o;
    public boolean p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f3439q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f3440r;

    /* renamed from: s, reason: collision with root package name */
    public long f3441s;

    /* renamed from: t, reason: collision with root package name */
    public long f3442t;
    public boolean u;

    /* renamed from: v, reason: collision with root package name */
    public final b f3443v;

    /* renamed from: w, reason: collision with root package name */
    public final /* synthetic */ d f3444w;

    /* JADX WARN: Type inference failed for: r3v6, types: [com.stepos.ability.voicewakeup.ui.b] */
    /* JADX WARN: Type inference failed for: r3v7, types: [com.stepos.ability.voicewakeup.ui.b] */
    public c(final d dVar, WakeupPagAnimation wakeupPagAnimation, WakeupPagPlayer$Mode wakeupPagPlayer$Mode, C1718k c1718k, long j5, int i) {
        c1718k = (i & 4) != 0 ? null : c1718k;
        j5 = (i & 8) != 0 ? 0L : j5;
        this.f3444w = dVar;
        this.f3437a = wakeupPagAnimation;
        this.b = wakeupPagPlayer$Mode;
        this.c = c1718k;
        this.d = j5;
        this.e = d.g.incrementAndGet();
        this.f = SystemClock.uptimeMillis();
        this.i = new AtomicInteger();
        this.f3438j = new AtomicLong(-1L);
        this.k = j5;
        final int i6 = 0;
        this.n = new Runnable() { // from class: com.stepos.ability.voicewakeup.ui.b
            @Override // java.lang.Runnable
            public final void run() {
                int i10 = i6;
                c cVar = this;
                switch (i10) {
                    case 0:
                        AtomicLong atomicLong = d.g;
                        d dVar2 = dVar;
                        if (dVar2.h(cVar) && !dVar2.c && cVar.f3439q) {
                            cVar.m = false;
                            cVar.k = 0L;
                            dVar2.i("replay", cVar, "");
                            dVar2.b(new c(dVar2, cVar.f3437a, WakeupPagPlayer$Mode.c, null, cVar.d, 4));
                            break;
                        }
                        break;
                    default:
                        AtomicLong atomicLong2 = d.g;
                        d dVar3 = dVar;
                        if (dVar3.h(cVar) && !dVar3.c && !cVar.f3439q) {
                            cVar.u = false;
                            Log.w("WakeupPagPlayer", "PAG end callback missing for " + cVar.f3437a.f3431a + "; holding final frame");
                            dVar3.e(cVar, true, WakeupPagPlayer$FinishReason.h);
                            break;
                        }
                        break;
                }
            }
        };
        final int i10 = 1;
        this.f3443v = new Runnable() { // from class: com.stepos.ability.voicewakeup.ui.b
            @Override // java.lang.Runnable
            public final void run() {
                int i102 = i10;
                c cVar = this;
                switch (i102) {
                    case 0:
                        AtomicLong atomicLong = d.g;
                        d dVar2 = dVar;
                        if (dVar2.h(cVar) && !dVar2.c && cVar.f3439q) {
                            cVar.m = false;
                            cVar.k = 0L;
                            dVar2.i("replay", cVar, "");
                            dVar2.b(new c(dVar2, cVar.f3437a, WakeupPagPlayer$Mode.c, null, cVar.d, 4));
                            break;
                        }
                        break;
                    default:
                        AtomicLong atomicLong2 = d.g;
                        d dVar3 = dVar;
                        if (dVar3.h(cVar) && !dVar3.c && !cVar.f3439q) {
                            cVar.u = false;
                            Log.w("WakeupPagPlayer", "PAG end callback missing for " + cVar.f3437a.f3431a + "; holding final frame");
                            dVar3.e(cVar, true, WakeupPagPlayer$FinishReason.h);
                            break;
                        }
                        break;
                }
            }
        };
    }

    @Override // org.libpag.PAGView.PAGViewListener
    public final void onAnimationCancel(PAGView view) {
        k.f(view, "view");
        d dVar = this.f3444w;
        d.a(dVar, new J4.d(dVar, this, 1));
    }

    @Override // org.libpag.PAGView.PAGViewListener
    public final void onAnimationEnd(final PAGView view) {
        k.f(view, "view");
        final d dVar = this.f3444w;
        d.a(dVar, new S7.a() { // from class: com.stepos.ability.voicewakeup.ui.a
            /* JADX WARN: Removed duplicated region for block: B:24:0x0047  */
            /* JADX WARN: Removed duplicated region for block: B:30:0x0071 A[ADDED_TO_REGION] */
            /* JADX WARN: Removed duplicated region for block: B:31:0x0073  */
            /* JADX WARN: Removed duplicated region for block: B:35:0x0093  */
            /* JADX WARN: Removed duplicated region for block: B:36:0x0095  */
            /* JADX WARN: Removed duplicated region for block: B:37:0x0098  */
            @Override // S7.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invoke() {
                /*
                    r10 = this;
                    org.libpag.PAGView r0 = r3
                    java.lang.String r1 = "WakeupPagPlayer"
                    java.util.concurrent.atomic.AtomicLong r2 = com.stepos.ability.voicewakeup.ui.d.g
                    com.stepos.ability.voicewakeup.ui.d r2 = r1
                    com.stepos.ability.voicewakeup.ui.c r10 = r2
                    boolean r3 = r2.h(r10)
                    if (r3 == 0) goto L9e
                    boolean r3 = r10.f3439q
                    if (r3 != 0) goto L9e
                    boolean r3 = r10.p
                    if (r3 == 0) goto L9e
                    com.stepos.ability.voicewakeup.ui.WakeupPagPlayer$Mode r3 = r10.b
                    com.stepos.ability.voicewakeup.ui.WakeupPagPlayer$Mode r4 = com.stepos.ability.voicewakeup.ui.WakeupPagPlayer$Mode.f3433a
                    if (r3 != r4) goto L20
                    goto L9e
                L20:
                    com.stepos.ability.voicewakeup.ui.WakeupPagAnimation r3 = r10.f3437a
                    java.lang.String r3 = r3.f3431a
                    java.lang.String r4 = "checking end of "
                    java.lang.String r3 = r4.concat(r3)
                    r4 = 1
                    r5 = 0
                    double r6 = r0.getProgress()     // Catch: java.lang.LinkageError -> L41 java.lang.RuntimeException -> L43
                    r8 = 4607182418800017408(0x3ff0000000000000, double:1.0)
                    int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                    if (r6 >= 0) goto L47
                    boolean r6 = r2.c     // Catch: java.lang.LinkageError -> L41 java.lang.RuntimeException -> L43
                    if (r6 != 0) goto L45
                    boolean r0 = r0.isPlaying()     // Catch: java.lang.LinkageError -> L41 java.lang.RuntimeException -> L43
                    if (r0 != 0) goto L45
                    goto L47
                L41:
                    r0 = move-exception
                    goto L4a
                L43:
                    r0 = move-exception
                    goto L5c
                L45:
                    r0 = r5
                    goto L48
                L47:
                    r0 = r4
                L48:
                    r1 = r4
                    goto L6f
                L4a:
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder
                    java.lang.String r7 = "PAG native dependency unavailable while "
                    r6.<init>(r7)
                    r6.append(r3)
                    java.lang.String r3 = r6.toString()
                    android.util.Log.w(r1, r3, r0)
                    goto L6d
                L5c:
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder
                    java.lang.String r7 = "PAG error while "
                    r6.<init>(r7)
                    r6.append(r3)
                    java.lang.String r3 = r6.toString()
                    android.util.Log.w(r1, r3, r0)
                L6d:
                    r0 = r5
                    r1 = r0
                L6f:
                    if (r0 != 0) goto L73
                    if (r1 != 0) goto L74
                L73:
                    r5 = r4
                L74:
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    java.lang.String r6 = "accepted="
                    r3.<init>(r6)
                    r3.append(r5)
                    java.lang.String r5 = " stateReadable="
                    r3.append(r5)
                    r3.append(r1)
                    java.lang.String r3 = r3.toString()
                    java.lang.String r5 = "end_callback"
                    r2.i(r5, r10, r3)
                    if (r0 != 0) goto L93
                    if (r1 != 0) goto La5
                L93:
                    if (r1 == 0) goto L98
                    com.stepos.ability.voicewakeup.ui.WakeupPagPlayer$FinishReason r0 = com.stepos.ability.voicewakeup.ui.WakeupPagPlayer$FinishReason.f3432a
                    goto L9a
                L98:
                    com.stepos.ability.voicewakeup.ui.WakeupPagPlayer$FinishReason r0 = com.stepos.ability.voicewakeup.ui.WakeupPagPlayer$FinishReason.g
                L9a:
                    r2.e(r10, r4, r0)
                    goto La5
                L9e:
                    java.lang.String r0 = "end_ignored"
                    java.lang.String r1 = ""
                    r2.i(r0, r10, r1)
                La5:
                    C7.r r10 = C7.r.f317a
                    return r10
                */
                throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.voicewakeup.ui.a.invoke():java.lang.Object");
            }
        });
    }

    @Override // org.libpag.PAGView.PAGViewListener
    public final void onAnimationRepeat(PAGView view) {
        k.f(view, "view");
    }

    @Override // org.libpag.PAGView.PAGViewListener
    public final void onAnimationStart(PAGView view) {
        k.f(view, "view");
        d dVar = this.f3444w;
        d.a(dVar, new J4.d(dVar, this, 0));
    }

    @Override // org.libpag.PAGView.PAGViewListener
    public final void onAnimationUpdate(PAGView view) {
        k.f(view, "view");
        if (this.i.incrementAndGet() != 1) {
            return;
        }
        this.f3438j.set(SystemClock.uptimeMillis());
        d dVar = this.f3444w;
        d.a(dVar, new J4.d(dVar, this, 2));
    }
}
