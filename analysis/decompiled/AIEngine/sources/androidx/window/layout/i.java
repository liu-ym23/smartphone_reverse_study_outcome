package androidx.window.layout;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import androidx.window.layout.SidecarCompat;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class i implements ComponentCallbacks {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SidecarCompat f2744a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Activity f2745b;

    public i(SidecarCompat sidecarCompat, Activity activity) {
        this.f2744a = sidecarCompat;
        this.f2745b = activity;
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration newConfig) {
        kotlin.jvm.internal.g.f(newConfig, "newConfig");
        SidecarCompat sidecarCompat = this.f2744a;
        SidecarCompat.b bVar = sidecarCompat.f2703e;
        if (bVar == null) {
            return;
        }
        Activity activity = this.f2745b;
        bVar.a(activity, sidecarCompat.c(activity));
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }
}
