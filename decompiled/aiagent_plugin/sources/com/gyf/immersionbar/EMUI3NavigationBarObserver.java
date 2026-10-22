package com.gyf.immersionbar;

import android.app.Application;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
final class EMUI3NavigationBarObserver extends ContentObserver {
    private Application mApplication;
    private ArrayList<h> mCallbacks;
    private Boolean mIsRegister;

    /* JADX INFO: renamed from: com.gyf.immersionbar.EMUI3NavigationBarObserver$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final EMUI3NavigationBarObserver f13816a = null;

        static /* synthetic */ EMUI3NavigationBarObserver a() {
            return f13816a;
        }

        static {
            f13816a = new EMUI3NavigationBarObserver(null);
        }
    }

    /* synthetic */ EMUI3NavigationBarObserver(AnonymousClass1 r1) {
        this();
    }

    static EMUI3NavigationBarObserver getInstance() {
        return a.a();
    }

    private EMUI3NavigationBarObserver() {
        super(new Handler(Looper.getMainLooper()));
        this.mIsRegister = false;
    }

    void register(Application r4) {
        this.mApplication = (Application) ZeusTransformUtils.wrapperContextForParams(r4, Application.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 17) goto L14;
        Application r5 = this.mApplication;
        if (r5 != null) goto L7;
        return;
    L7:
        if (r5.getContentResolver() != null) goto L9;
        return;
    L9:
        if (this.mIsRegister.booleanValue() == true) goto L17;
        Uri r6 = Settings.System.getUriFor("navigationbar_is_min");
        if (r6 == null) goto L18;
        ZeusProviderTransform.registerContentObserver(this.mApplication.getContentResolver(), r6, true, this, "com.obric.aiagent.plugin");
        this.mIsRegister = true;
        return;
    L18:
        return;
    L17:
        return;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean r7) {
        super.onChange(r7);
        if (Build.VERSION.SDK_INT < 17) goto L23;
        Application r8 = this.mApplication;
        if (r8 != null) goto L7;
        return;
    L7:
        if (r8.getContentResolver() == null) goto L28;
        ArrayList<h> r9 = this.mCallbacks;
        if (r9 != null) goto L11;
        return;
    L11:
        if (r9.isEmpty() == true) goto L30;
        int r10 = Settings.System.getInt(this.mApplication.getContentResolver(), "navigationbar_is_min", 0);
        j r0 = j.f13861a;
        if (r10 != 1) goto L15;
        r0 = j.f13862b;
    L15:
        Iterator<h> r6 = this.mCallbacks.iterator();
    L17:
        if (r6.hasNext() == false) goto L31;
        h r3 = (h) ZeusTransformUtils.preCheckCast(r6.next(), h.class, "com.obric.aiagent.plugin");
        if (r10 != 0) goto L21;
        boolean r4 = true;
    L22:
        r3.a(r4, r0);
        goto L17
    L21:
        r4 = false;
        goto L22
    L31:
        return;
    L30:
        return;
    L28:
        return;
    }

    void addOnNavigationBarListener(h r3) {
        h r4 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L6;
        return;
    L6:
        if (this.mCallbacks != null) goto L9;
        this.mCallbacks = new ArrayList();
    L9:
        if (this.mCallbacks.contains(r4) == true) goto L12;
        this.mCallbacks.add(r4);
        return;
    }

    void removeOnNavigationBarListener(h r3) {
        h r4 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L9;
        ArrayList<h> r2 = this.mCallbacks;
        if (r2 == null) goto L10;
        r2.remove(r4);
        return;
    L10:
        return;
    }
}
