package androidx.activity;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public final Function0 f2404a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f2405b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f2406c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f2407d;

    public q(n executor, e reportFullyDrawn) {
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(reportFullyDrawn, "reportFullyDrawn");
        this.f2405b = new Object();
        this.f2407d = new ArrayList();
    }

    public final void a() {
        synchronized (this.f2405b) {
            try {
                this.f2406c = true;
                Iterator it = this.f2407d.iterator();
                while (it.hasNext()) {
                    ((Function0) it.next()).invoke();
                }
                this.f2407d.clear();
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
