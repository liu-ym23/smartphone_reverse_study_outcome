package com.bytedance.apm.trace;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.fragment.app.Fragment;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: PageTimeMonitor.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements com.bytedance.services.apm.api.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f4900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f4901b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ViewTreeObserver.OnGlobalLayoutListener f4902c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Runnable f4903d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Handler f4904e;
    private long f;
    private boolean g;

    @Override // com.bytedance.services.apm.api.d
    public void onActivityResume(Activity r2) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.services.apm.api.d
    public void onActivityStarted(Activity r2) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.services.apm.api.d
    public void onBackground(Activity r2) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.services.apm.api.d
    public void onChange(Activity r1, Fragment r2) {
        Activity r0 = (Activity) ZeusTransformUtils.wrapperContextForParams(r1, Activity.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.services.apm.api.d
    public void onFront(Activity r2) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
    }

    public c() {
        this.f4900a = -1;
        this.f4904e = new Handler(Looper.getMainLooper());
    }

    static /* synthetic */ long a(c r0, long r1) {
        r0.f4900a = r1;
        return r1;
    }

    static /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener a(c r0) {
        return r0.f4902c;
    }

    static /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener a(c r2, ViewTreeObserver.OnGlobalLayoutListener r3) {
        ViewTreeObserver.OnGlobalLayoutListener r4 = (ViewTreeObserver.OnGlobalLayoutListener) ZeusTransformUtils.wrapperContextForParams(r3, ViewTreeObserver.OnGlobalLayoutListener.class, "com.obric.aiagent.plugin");
        r2.f4902c = r4;
        return r4;
    }

    static /* synthetic */ Runnable a(c r2, Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        r2.f4903d = r4;
        return r4;
    }

    static /* synthetic */ Runnable b(c r0) {
        return r0.f4903d;
    }

    static /* synthetic */ Handler c(c r0) {
        return r0.f4904e;
    }

    static /* synthetic */ long d(c r2) {
        return r2.f4900a;
    }

    static /* synthetic */ long e(c r2) {
        return r2.f;
    }

    static /* synthetic */ String f(c r0) {
        return r0.f4901b;
    }

    public void a(long r1, boolean r3) {
        this.f = r1;
        this.g = r3;
        ActivityLifeObserver.getInstance().register(this);
    }

    @Override // com.bytedance.services.apm.api.d
    public void onActivityCreated(Activity r2, Bundle r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return;
    L5:
        if (this.g == false) goto L13;
        a(r4);     // Catch: Exception -> L9
        return;
    L14:
        return;
    }

    @Override // com.bytedance.services.apm.api.d
    public void onActivityPause(Activity r5) {
        Activity r6 = (Activity) ZeusTransformUtils.wrapperContextForParams(r5, Activity.class, "com.obric.aiagent.plugin");
        this.f4900a = 0;
        if (this.f4902c == null) goto L6;
        ZeusTransformUtils.getWindow(r6, "com.obric.aiagent.plugin").getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(this.f4902c);     // Catch: Exception -> L10
        this.f4902c = null;     // Catch: Exception -> L10
    L6:
        Runnable r7 = this.f4903d;     // Catch: Exception -> L10
        if (r7 == null) goto L13;
        this.f4904e.removeCallbacks(r7);     // Catch: Exception -> L10
        this.f4903d = null;     // Catch: Exception -> L10
        return;
    L13:
        return;
    }

    private void a(Activity r5) {
        Activity r6 = (Activity) ZeusTransformUtils.wrapperContextForParams(r5, Activity.class, "com.obric.aiagent.plugin");
        this.f4900a = System.currentTimeMillis();
        String r0 = r6.getClass().getCanonicalName();
        this.f4901b = r0;
        final Integer r1 = com.bytedance.apm.trace.b.a.a(r0);
        if (r1 != null) goto L5;
        return;
    L5:
        final WeakReference r2 = new WeakReference(ZeusTransformUtils.getWindow(r6, "com.obric.aiagent.plugin").getDecorView());
        this.f4902c = new PageTimeMonitor$1(this, r2, r1);
        ((View) ZeusTransformUtils.preCheckCast(r2.get(), View.class, "com.obric.aiagent.plugin")).getViewTreeObserver().addOnGlobalLayoutListener(this.f4902c);
        Runnable r7 = new AnonymousClass1(this, r2);
        this.f4903d = r7;
        this.f4904e.postDelayed(r7, this.f);
    }
}
