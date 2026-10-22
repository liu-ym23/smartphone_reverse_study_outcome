package r1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.services.apm.api.IActivityLifeObserver;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f23694a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f23695b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f23696c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f23697d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f23698e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Intent f23699f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static long f23700g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static long f23701h;

    public static class a implements IActivityLifeObserver {
        public a() {
        }

        @Override // com.bytedance.services.apm.api.IActivityLifeObserver
        public void onActivityCreated(Activity r10, Bundle r11) {
            d.d(System.currentTimeMillis());
            if (r11 == null) goto L5;
            boolean r12 = true;
        L6:
            d.e(r12);
            d.c(true);
            return;
        L5:
            r12 = false;
            goto L6
        }

        @Override // com.bytedance.services.apm.api.IActivityLifeObserver
        public void onActivityPause(Activity r10) {
            d.f(r10.getComponentName().getClassName());
        }

        @Override // com.bytedance.services.apm.api.IActivityLifeObserver
        public void onActivityResume(Activity r10) {
        }

        @Override // com.bytedance.services.apm.api.IActivityLifeObserver
        public void onActivityStarted(Activity r10) {
            d.g(System.currentTimeMillis());
        }

        @Override // com.bytedance.services.apm.api.IActivityLifeObserver
        public void onBackground(Activity r10) {
            d.b(true);
            d.c(false);
            d.a("");
        }

        @Override // com.bytedance.services.apm.api.IActivityLifeObserver
        public void onChange(Activity r10, Fragment r11) {
        }

        @Override // com.bytedance.services.apm.api.IActivityLifeObserver
        public void onFront(Activity r10) {
            d.a(r10.getComponentName().getClassName());
        }
    }

    static {
    }

    public static /* synthetic */ String a(String r10) {
        f23697d = r10;
        return r10;
    }

    public static /* synthetic */ boolean b(boolean r10) {
        f23694a = r10;
        return r10;
    }

    public static /* synthetic */ boolean c(boolean r10) {
        f23696c = r10;
        return r10;
    }

    public static /* synthetic */ long d(long r10) {
        f23700g = r10;
        return r10;
    }

    public static /* synthetic */ boolean e(boolean r10) {
        f23695b = r10;
        return r10;
    }

    public static /* synthetic */ String f(String r10) {
        f23698e = r10;
        return r10;
    }

    public static /* synthetic */ long g(long r10) {
        f23701h = r10;
        return r10;
    }

    public static void h() {
        f23699f = f.c();
        ActivityLifeObserver.getInstance().register(new a());
    }
}
