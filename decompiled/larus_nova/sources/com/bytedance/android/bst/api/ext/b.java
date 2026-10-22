package com.bytedance.android.bst.api.ext;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, ArrayList<Function1<Activity, Unit>>> f41920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<Function1<Activity, Boolean>> f41921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f41922c;

    public static final class a implements Application.ActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f41923a;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity r100) {
            ArrayList r101 = new ArrayList();
            Iterator<Function1<Activity, Boolean>> r102 = this.f41923a.f41921b.iterator();
        L4:
            if (r102.hasNext() == false) goto L8;
            Function1<Activity, Boolean> r103 = r102.next();
            if (r103.invoke(r100).booleanValue() == false) goto L4;
            r101.add(r103);
            goto L4
        L8:
            this.f41923a.f41921b.removeAll(CollectionsKt.toSet(r101));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity r100) {
            ArrayList<Function1<Activity, Unit>> r101 = this.f41923a.f41920a.get("onActivityPaused");
            if (r101 == null) goto L8;
            Iterator<T> r102 = r101.iterator();
        L6:
            if (r102.hasNext() == false) goto L10;
            ((Function1) r102.next()).invoke(r100);
            goto L6
        L10:
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r100) {
            ArrayList<Function1<Activity, Unit>> r101 = this.f41923a.f41920a.get("onActivityResumed");
            if (r101 == null) goto L8;
            Iterator<T> r102 = r101.iterator();
        L6:
            if (r102.hasNext() == false) goto L10;
            ((Function1) r102.next()).invoke(r100);
            goto L6
        L10:
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity r100) {
            ArrayList<Function1<Activity, Unit>> r101 = this.f41923a.f41920a.get("onActivityStarted");
            if (r101 == null) goto L8;
            Iterator<T> r102 = r101.iterator();
        L6:
            if (r102.hasNext() == false) goto L10;
            ((Function1) r102.next()).invoke(r100);
            goto L6
        L10:
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity r100) {
            ArrayList<Function1<Activity, Unit>> r101 = this.f41923a.f41920a.get("onActivityStopped");
            if (r101 == null) goto L8;
            Iterator<T> r102 = r101.iterator();
        L6:
            if (r102.hasNext() == false) goto L10;
            ((Function1) r102.next()).invoke(r100);
            goto L6
        L10:
            return;
        }

        public a(b r100, com.bytedance.android.bst.api.ext.a r101) {
            this.f41923a = r100;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r100, Bundle r101) {
            ArrayList<Function1<Activity, Unit>> r102 = this.f41923a.f41920a.get("onActivityCreated");
            if (r102 == null) goto L8;
            Iterator<T> r103 = r102.iterator();
        L6:
            if (r103.hasNext() == false) goto L10;
            ((Function1) r103.next()).invoke(r100);
            goto L6
        L10:
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
            ArrayList<Function1<Activity, Unit>> r102 = this.f41923a.f41920a.get("onActivitySaveInstanceState");
            if (r102 == null) goto L8;
            Iterator<T> r103 = r102.iterator();
        L6:
            if (r103.hasNext() == false) goto L10;
            ((Function1) r103.next()).invoke(r100);
            goto L6
        L10:
            return;
        }
    }

    public b(com.bytedance.android.bst.api.ext.a r100) {
        this.f41920a = new HashMap();
        this.f41921b = new ArrayList();
        this.f41922c = new a(this, r100);
    }
}
