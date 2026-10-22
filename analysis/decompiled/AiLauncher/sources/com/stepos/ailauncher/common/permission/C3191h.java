package com.stepos.ailauncher.common.permission;

import Z8.C1165m;
import android.app.Activity;
import com.autonavi.aps.amapapi.config.Const;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\u0003R\u0014\u0010\r\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR \u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00100\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/stepos/ailauncher/common/permission/h;", "", "<init>", "()V", "Landroid/app/Activity;", "activity", "LY8/t;", "c", "(Landroid/app/Activity;)V", Const.INTENT_KEY_UMID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Landroid/app/Activity;", "f", "lock", "Ljava/lang/Object;", "LZ8/m;", "Ljava/lang/ref/WeakReference;", "stack", "LZ8/m;", "permission_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.common.permission.h, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3191h {
    public static final C3191h INSTANCE = new C3191h();
    private static final Object lock = new Object();
    private static final C1165m<WeakReference<Activity>> stack = new C1165m<>();

    public static final boolean e(Activity activity, WeakReference it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.get() == null || it.get() == activity;
    }

    public static final boolean g(WeakReference ref) {
        kotlin.jvm.internal.p.i(ref, "ref");
        Activity activity = (Activity) ref.get();
        return activity == null || !C3193j.INSTANCE.i(activity);
    }

    public final void c(Activity activity) {
        kotlin.jvm.internal.p.i(activity, "activity");
        synchronized (lock) {
            try {
                INSTANCE.f();
                C1165m<WeakReference<Activity>> c1165m = stack;
                if (c1165m == null || !c1165m.isEmpty()) {
                    Iterator<WeakReference<Activity>> it = c1165m.iterator();
                    while (it.hasNext()) {
                        if (it.next().get() == activity) {
                            return;
                        }
                    }
                }
                stack.addLast(new WeakReference<>(activity));
                Y8.t tVar = Y8.t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d(final Activity activity) {
        kotlin.jvm.internal.p.i(activity, "activity");
        synchronized (lock) {
            Z8.A.L(stack, new InterfaceC5074l() { // from class: com.stepos.ailauncher.common.permission.f
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(C3191h.e(activity, (WeakReference) obj));
                }
            });
        }
    }

    public final void f() {
        Z8.A.L(stack, new InterfaceC5074l() { // from class: com.stepos.ailauncher.common.permission.g
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(C3191h.g((WeakReference) obj));
            }
        });
    }

    public final Activity h() {
        Activity activity;
        Activity activity2;
        synchronized (lock) {
            INSTANCE.f();
            WeakReference<Activity> weakReferenceL = stack.l();
            activity = null;
            if (weakReferenceL != null && (activity2 = weakReferenceL.get()) != null) {
                if (C3193j.INSTANCE.i(activity2)) {
                    activity = activity2;
                }
            }
        }
        return activity;
    }
}
