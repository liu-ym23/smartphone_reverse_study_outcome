package com.obric.common.oea.foundation.animation;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.view.View;
import com.obric.common.oea.foundation.animation.manager.d;
import com.obric.common.oea.foundation.b.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: AnimationLifecycleListener.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AnimationLifecycleListener {
    private static final String TAG = "AnimationLifecycleListener";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AnimationLifecycleListener f32287a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ArrayList<d> f32288b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final WeakHashMap<View, a<?>> f32289c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Application.ActivityLifecycleCallbacks f32290d;

    /* JADX INFO: compiled from: AnimationLifecycleListener.kt */
    private static final class ActivityLifeCallback implements Application.ActivityLifecycleCallbacks {
        public ActivityLifeCallback() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity r2, Bundle r3) {
            Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
            o.e(r1, "activity");
            Application.ActivityLifecycleCallbacks r4 = AnimationLifecycleListener.a(AnimationLifecycleListener.f32287a);
            if (r4 == null) goto L6;
            r4.onActivityCreated(r1, r3);
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity r2) {
            Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
            o.e(r1, "activity");
            Application.ActivityLifecycleCallbacks r3 = AnimationLifecycleListener.a(AnimationLifecycleListener.f32287a);
            if (r3 == null) goto L6;
            r3.onActivityStarted(r1);
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity r2) {
            Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
            o.e(r1, "activity");
            Application.ActivityLifecycleCallbacks r3 = AnimationLifecycleListener.a(AnimationLifecycleListener.f32287a);
            if (r3 == null) goto L6;
            r3.onActivityResumed(r1);
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity r2) {
            Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
            o.e(r1, "activity");
            Application.ActivityLifecycleCallbacks r3 = AnimationLifecycleListener.a(AnimationLifecycleListener.f32287a);
            if (r3 == null) goto L6;
            r3.onActivityPaused(r1);
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity r2) {
            Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
            o.e(r1, "activity");
            Application.ActivityLifecycleCallbacks r3 = AnimationLifecycleListener.a(AnimationLifecycleListener.f32287a);
            if (r3 == null) goto L6;
            r3.onActivityStopped(r1);
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity r2, Bundle r3) {
            Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
            o.e(r1, "activity");
            o.e(r3, "outState");
            Application.ActivityLifecycleCallbacks r4 = AnimationLifecycleListener.a(AnimationLifecycleListener.f32287a);
            if (r4 == null) goto L6;
            r4.onActivitySaveInstanceState(r1, r3);
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity r2) {
            Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
            o.e(r1, "activity");
            AnimationLifecycleListener.f32287a.a();
            Application.ActivityLifecycleCallbacks r3 = AnimationLifecycleListener.a(AnimationLifecycleListener.f32287a);
            if (r3 == null) goto L6;
            r3.onActivityDestroyed(r1);
            return;
        }
    }

    static {
        f32287a = new AnimationLifecycleListener();
        f32288b = new ArrayList();
        f32289c = new WeakHashMap();
    }

    private AnimationLifecycleListener() {
    }

    public static final /* synthetic */ Application.ActivityLifecycleCallbacks a(AnimationLifecycleListener r0) {
        return f32290d;
    }

    public final void a(View r3, a<?> r4) {
        o.e(r3, "view");
        o.e(r4, "animationInfo");
        ((Map) ZeusTransformUtils.preCheckCast(f32289c, Map.class, "com.obric.aiagent.plugin")).put(r3, r4);
    }

    public final a<?> a(View r2) {
        o.e(r2, "view");
        return (a) ZeusTransformUtils.preCheckCast(f32289c.get(r2), a.class, "com.obric.aiagent.plugin");
    }

    public final void a(d r3) {
        o.e(r3, "animationManager");
        ArrayList<d> r2 = f32288b;
        r2.add(r3);
        c.f32472a.a(TAG, "addAnimationManager, size: " + r2.size());
    }

    public final void b(d r3) {
        o.e(r3, "animationManager");
        ArrayList<d> r2 = f32288b;
        r2.remove(r3);
        c.f32472a.a(TAG, "removeAnimationManager, size: " + r2.size());
    }

    public final void a() {
        ArrayList r5 = new ArrayList();
        r5.addAll((Collection) ZeusTransformUtils.preCheckCast(f32288b, Collection.class, "com.obric.aiagent.plugin"));
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        d.a((d) ZeusTransformUtils.preCheckCast(r6.next(), d.class, "com.obric.aiagent.plugin"), false, 1, null);
        goto L4
    }
}
