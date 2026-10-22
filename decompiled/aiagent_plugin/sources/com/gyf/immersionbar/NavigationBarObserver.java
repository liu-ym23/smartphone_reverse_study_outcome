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
final class NavigationBarObserver extends ContentObserver {
    private Application mApplication;
    private boolean mIsRegister;
    private ArrayList<n> mListeners;

    /* JADX INFO: renamed from: com.gyf.immersionbar.NavigationBarObserver$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final NavigationBarObserver f13817a = null;

        static /* synthetic */ NavigationBarObserver a() {
            return f13817a;
        }

        static {
            f13817a = new NavigationBarObserver(null);
        }
    }

    /* synthetic */ NavigationBarObserver(AnonymousClass1 r1) {
        this();
    }

    static NavigationBarObserver getInstance() {
        return a.a();
    }

    private NavigationBarObserver() {
        super(new Handler(Looper.getMainLooper()));
        this.mIsRegister = false;
    }

    void register(Application r7) {
        this.mApplication = (Application) ZeusTransformUtils.wrapperContextForParams(r7, Application.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 17) goto L56;
        Application r8 = this.mApplication;
        if (r8 != null) goto L7;
        return;
    L7:
        if (r8.getContentResolver() != null) goto L9;
        return;
    L9:
        if (this.mIsRegister == true) goto L59;
        Uri r0 = null;
        if (OSUtils.isHuaWei() == true) goto L41;
        if (OSUtils.isEMUI() == true) goto L41;
        if (OSUtils.isXiaoMi() == false) goto L18;
    L39:
        Uri r9 = Settings.Global.getUriFor("force_fsg_nav_bar");
        Uri r2 = null;
        r0 = Settings.Global.getUriFor("hide_gesture_line");
    L49:
        if (r9 == null) goto L51;
        ZeusProviderTransform.registerContentObserver(this.mApplication.getContentResolver(), r9, true, this, "com.obric.aiagent.plugin");
        this.mIsRegister = true;
    L51:
        if (r0 == null) goto L53;
        ZeusProviderTransform.registerContentObserver(this.mApplication.getContentResolver(), r0, true, this, "com.obric.aiagent.plugin");
    L53:
        if (r2 == null) goto L60;
        ZeusProviderTransform.registerContentObserver(this.mApplication.getContentResolver(), r2, true, this, "com.obric.aiagent.plugin");
        return;
    L60:
        return;
    L18:
        if (OSUtils.isMIUI() == true) goto L39;
        if (OSUtils.isVivo() == false) goto L23;
    L38:
        r9 = Settings.Secure.getUriFor("navigation_gesture_on");
    L47:
        r2 = null;
        goto L49
    L23:
        if (OSUtils.isFuntouchOrOriginOs() == true) goto L38;
        if (OSUtils.isOppo() == false) goto L28;
    L37:
        r9 = Settings.Secure.getUriFor("hide_navigationbar_enable");
        goto L47
    L28:
        if (OSUtils.isColorOs() == true) goto L37;
        if (OSUtils.isSamsung() == true) goto L33;
        r9 = Settings.Secure.getUriFor("navigation_mode");
        goto L47
    L33:
        if (Settings.Global.getInt(this.mApplication.getContentResolver(), "navigationbar_hide_bar_enabled", -1) != (-1)) goto L35;
        r9 = Settings.Global.getUriFor("navigation_bar_gesture_while_hidden");
        r0 = Settings.Global.getUriFor("navigation_bar_gesture_detail_type");
        r2 = Settings.Global.getUriFor("navigation_bar_gesture_hint");
        goto L49
    L35:
        r9 = Settings.Global.getUriFor("navigationbar_hide_bar_enabled");
    L41:
        if (OSUtils.isEMUI3_x() == false) goto L43;
    L46:
        r9 = Settings.System.getUriFor("navigationbar_is_min");
        goto L47
    L43:
        if (Build.VERSION.SDK_INT < 21) goto L46;
        r9 = Settings.Global.getUriFor("navigationbar_is_min");
        goto L47
    L59:
        return;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean r5) {
        super.onChange(r5);
        ArrayList<n> r6 = this.mListeners;
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.isEmpty() == true) goto L19;
        f.a r7 = f.a(this.mApplication);
        boolean r1 = false;
        if (r7.f13844a == true) goto L9;
    L12:
        r1 = true;
    L13:
        Iterator<n> r4 = this.mListeners.iterator();
    L15:
        if (r4.hasNext() == false) goto L20;
        ((n) ZeusTransformUtils.preCheckCast(r4.next(), n.class, "com.obric.aiagent.plugin")).a(r1, r7.f13846c);
        goto L15
    L20:
        return;
    L9:
        if (r7.f13845b == false) goto L13;
        if (com.gyf.immersionbar.a.a(this.mApplication) <= 0) goto L13;
    }

    void addOnNavigationBarListener(n r3) {
        n r4 = (n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L6;
        return;
    L6:
        if (this.mListeners != null) goto L9;
        this.mListeners = new ArrayList();
    L9:
        if (this.mListeners.contains(r4) == true) goto L12;
        this.mListeners.add(r4);
        return;
    }

    void removeOnNavigationBarListener(n r3) {
        n r4 = (n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L9;
        ArrayList<n> r2 = this.mListeners;
        if (r2 == null) goto L10;
        r2.remove(r4);
        return;
    L10:
        return;
    }
}
