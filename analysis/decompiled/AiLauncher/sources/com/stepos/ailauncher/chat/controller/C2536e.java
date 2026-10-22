package com.stepos.ailauncher.chat.controller;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.controller.C2536e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Predicate;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/stepos/ailauncher/chat/controller/e;", "", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.controller.e, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2536e {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static CopyOnWriteArrayList<WeakReference<Activity>> activityList = new CopyOnWriteArrayList<>();

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\r\u001a\u00020\u00062\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0010\u001a\u00020\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00130\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/chat/controller/e$a;", "", "<init>", "()V", "Landroid/app/Application;", "context", "LY8/t;", Const.INTENT_KEY_UMID, "(Landroid/app/Application;)V", "Lkotlin/Function1;", "Landroid/app/Activity;", "", "predicate", "c", "(Lp9/l;)V", "except", Const.INTENT_KEY_APIKEY, "(Landroid/app/Activity;)V", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/lang/ref/WeakReference;", "activityList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.controller.e$a, reason: from kotlin metadata */
    public static final class Companion {

        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\bJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u000bJ\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u000b¨\u0006\u0012"}, d2 = {"com/stepos/ailauncher/chat/controller/e$a$a", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Landroid/app/Activity;", "activity", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onActivityCreated", "(Landroid/app/Activity;Landroid/os/Bundle;)V", "p0", "onActivityDestroyed", "(Landroid/app/Activity;)V", "onActivityStarted", "onActivityResumed", "p1", "onActivitySaveInstanceState", "onActivityPaused", "onActivityStopped", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.chat.controller.e$a$a, reason: collision with other inner class name */
        public static final class C0280a implements Application.ActivityLifecycleCallbacks {
            public static final boolean c(Activity activity, WeakReference weakReference) {
                return kotlin.jvm.internal.p.d(weakReference.get(), activity);
            }

            public static final boolean d(InterfaceC5074l interfaceC5074l, Object obj) {
                return ((Boolean) interfaceC5074l.invoke(obj)).booleanValue();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                kotlin.jvm.internal.p.i(activity, "activity");
                C2536e.activityList.add(new WeakReference(activity));
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(final Activity p02) {
                kotlin.jvm.internal.p.i(p02, "p0");
                CopyOnWriteArrayList copyOnWriteArrayList = C2536e.activityList;
                final InterfaceC5074l interfaceC5074l = new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.controller.c
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(C2536e.Companion.C0280a.c(p02, (WeakReference) obj));
                    }
                };
                copyOnWriteArrayList.removeIf(new Predicate() { // from class: com.stepos.ailauncher.chat.controller.d
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return C2536e.Companion.C0280a.d(interfaceC5074l, obj);
                    }
                });
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                kotlin.jvm.internal.p.i(activity, "activity");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                kotlin.jvm.internal.p.i(activity, "activity");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity p02, Bundle p12) {
                kotlin.jvm.internal.p.i(p02, "p0");
                kotlin.jvm.internal.p.i(p12, "p1");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                kotlin.jvm.internal.p.i(activity, "activity");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                kotlin.jvm.internal.p.i(activity, "activity");
            }
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public static /* synthetic */ void b(Companion companion, Activity activity, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                activity = null;
            }
            companion.a(activity);
        }

        public final void a(Activity except) {
            Log.d("ActivityManager", "clearUselessActivity, size: " + C2536e.activityList.size() + ", except: " + except);
            ArrayList arrayList = new ArrayList();
            for (WeakReference weakReference : C2536e.activityList) {
                Activity activity = (Activity) weakReference.get();
                if (activity != null) {
                    if (activity == except) {
                        kotlin.jvm.internal.p.f(weakReference);
                        arrayList.add(weakReference);
                    } else if (!activity.isFinishing() && !activity.isDestroyed()) {
                        activity.finish();
                    }
                }
            }
            C2536e.activityList.clear();
            C2536e.activityList.addAll(arrayList);
        }

        public final void c(InterfaceC5074l<? super Activity, Boolean> predicate) {
            kotlin.jvm.internal.p.i(predicate, "predicate");
            Iterator it = C2536e.activityList.iterator();
            while (it.hasNext()) {
                Activity activity = (Activity) ((WeakReference) it.next()).get();
                if (activity != null && !activity.isFinishing() && !activity.isDestroyed() && predicate.invoke(activity).booleanValue()) {
                    Log.d("ActivityManager", "finishActivitiesWhere: " + activity.getClass().getName());
                    activity.finish();
                }
            }
        }

        public final void d(Application context) {
            kotlin.jvm.internal.p.i(context, "context");
            context.registerActivityLifecycleCallbacks(new C0280a());
        }

        public Companion() {
        }
    }
}
