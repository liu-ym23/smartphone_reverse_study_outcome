package com.bytedance.android.accessibilityLib_Core.helper;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes43.dex */
public final class b implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<e> f38279a;

    public b() {
        this.f38279a = new ArrayList();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r100) {
        Iterator r101 = ((ArrayList) this.f38279a).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        boolean r102 = ((e) r101.next()).f38281a;
        goto L4
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r100) {
        Iterator r101 = ((ArrayList) this.f38279a).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        boolean r102 = ((e) r101.next()).f38281a;
        goto L4
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r100) {
        Iterator r101 = ((ArrayList) this.f38279a).iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        e r102 = (e) r101.next();
        if (r102.f38281a == false) goto L4;
        r102.f38281a = true;
        goto L4
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r100) {
        Iterator r101 = ((ArrayList) this.f38279a).iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        e r102 = (e) r101.next();
        if (r102.f38281a == false) goto L4;
        r102.f38281a = true;
        goto L4
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r100) {
        Iterator r101 = ((ArrayList) this.f38279a).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        boolean r102 = ((e) r101.next()).f38281a;
        goto L4
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r100, Bundle r101) {
        Iterator r102 = ((ArrayList) this.f38279a).iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        e r103 = (e) r102.next();
        if (r103.f38281a == false) goto L4;
        r103.f38281a = true;
        goto L4
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
        Iterator r102 = ((ArrayList) this.f38279a).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        boolean r103 = ((e) r102.next()).f38281a;
        goto L4
    }
}
