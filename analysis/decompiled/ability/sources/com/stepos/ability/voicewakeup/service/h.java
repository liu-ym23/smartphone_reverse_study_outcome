package com.stepos.ability.voicewakeup.service;

import C7.r;
import android.util.Log;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final /* synthetic */ class h implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3329a;
    public final /* synthetic */ int b;

    public /* synthetic */ h(int i, int i6) {
        this.f3329a = i6;
        this.b = i;
    }

    @Override // S7.a
    public final Object invoke() {
        int i = this.f3329a;
        int i6 = 1;
        final int i10 = this.b;
        switch (i) {
            case 0:
                l lVar = l.f3333a;
                l.o(false, new h(i10, i6));
                return r.f317a;
            default:
                l lVar2 = l.f3333a;
                k kVarG = l.g();
                if (!kVarG.f3332a || kVarG.b != i10) {
                    Log.i("VoiceWakeupController", "attemptRebuild: abandon stale gen=" + i10 + " current=" + kVarG.b);
                    if (l.f3337s && l.u == i10) {
                        l.c(i10);
                        lVar2.l();
                    }
                } else if (l.f3337s && l.u == i10) {
                    l.f3339v = null;
                    if (l.f()) {
                        int i11 = l.f3338t + 1;
                        synchronized (l.k) {
                            if (l.h && l.i == i10) {
                                WakeupEngine wakeupEngine = l.m;
                                l.m = null;
                                l.f3336r.clear();
                                l.f3334j = false;
                                if (wakeupEngine != null) {
                                    try {
                                        wakeupEngine.release();
                                    } catch (Throwable th) {
                                        kotlin.b.a(th);
                                    }
                                }
                                boolean zR = lVar2.r(false);
                                if (!l.h(i10)) {
                                    if (l.f3337s && l.u == i10) {
                                        l.c(i10);
                                    }
                                    lVar2.l();
                                } else if (zR) {
                                    Log.i("VoiceWakeupController", "rebuild succeeded attempt=" + i11 + " gen=" + i10);
                                    l.c(i10);
                                } else {
                                    l.f3338t++;
                                    Log.w("VoiceWakeupController", "rebuild attempt=" + i11 + " result=FAIL gen=" + i10);
                                    if (l.f3338t < 6) {
                                        l.p(i10);
                                    } else if (l.h(i10)) {
                                        Log.e("VoiceWakeupController", "rebuild gave up after 6 attempts gen=" + i10);
                                        l.c(i10);
                                        l.d();
                                        l.g.invoke(new Runnable() { // from class: com.stepos.ability.voicewakeup.service.i
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                l lVar3 = l.f3333a;
                                                k kVarG2 = l.g();
                                                if (kVarG2.f3332a && kVarG2.b == i10) {
                                                    Iterator it = l.l.iterator();
                                                    while (it.hasNext()) {
                                                        try {
                                                            ((EngineStateListener) it.next()).onEngineError();
                                                        } catch (Throwable th2) {
                                                            kotlin.b.a(th2);
                                                        }
                                                    }
                                                }
                                            }
                                        });
                                    }
                                }
                            } else {
                                Log.i("VoiceWakeupController", "attemptRebuild: abandon stale gen=" + i10 + " current=" + l.g().b);
                                if (l.f3337s && l.u == i10) {
                                    l.c(i10);
                                    lVar2.l();
                                }
                            }
                        }
                    } else {
                        Log.i("VoiceWakeupController", "attemptRebuild: abandon (environment disabled) gen=" + i10);
                        l.c(i10);
                    }
                }
                return r.f317a;
        }
    }
}
