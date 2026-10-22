package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.LocaleManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.LocaleList;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.DoNotInline;
import androidx.annotation.RestrictTo;
import androidx.core.os.BuildCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class AppCompatDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static i.a f286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static androidx.core.os.e f288c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static androidx.core.os.e f289d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Boolean f290e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f291f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final androidx.collection.a f292g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Object f293h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Object f294i = null;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface NightMode {
    }

    public static class a {
        @DoNotInline
        public static LocaleList a(String r10) {
            return LocaleList.forLanguageTags(r10);
        }
    }

    public static class b {
        @DoNotInline
        public static LocaleList a(Object r10) {
            return ((LocaleManager) r10).getApplicationLocales();
        }

        @DoNotInline
        public static void b(Object r10, LocaleList r11) {
            ((LocaleManager) r10).setApplicationLocales(r11);
        }
    }

    static {
        f286a = new i.a(new i.b());
        f287b = -100;
        f288c = null;
        f289d = null;
        f290e = null;
        f291f = false;
        f292g = new androidx.collection.a();
        f293h = new Object();
        f294i = new Object();
    }

    public AppCompatDelegate() {
    }

    public static void D(AppCompatDelegate r10) {
        Object r11 = f293h;
        monitor-enter(r11);
        E(r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void E(AppCompatDelegate r10) {
        Object r11 = f293h;
        monitor-enter(r11);
        Iterator r12 = f292g.iterator();     // Catch: Throwable -> L11
    L6:
        if (r12.hasNext() == false) goto L13;
        AppCompatDelegate r13 = (AppCompatDelegate) ((WeakReference) r12.next()).get();     // Catch: Throwable -> L11
        if (r13 == r10) goto L10;
        if (r13 != null) goto L6;
    L10:
        r12.remove();     // Catch: Throwable -> L11
        goto L6
    L13:
        monitor-exit(r11);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static void N(final Context r10) {
        if (t(r10) == true) goto L6;
        return;
    L6:
        if (BuildCompat.c() == true) goto L8;
        Object r11 = f294i;
        monitor-enter(r11);
        androidx.core.os.e r12 = f288c;     // Catch: Throwable -> L17
        if (r12 != null) goto L25;
        if (f289d != null) goto L20;
        f289d = androidx.core.os.e.b(i.b(r10));     // Catch: Throwable -> L17
    L20:
        if (f289d.e() == false) goto L23;
        monitor-exit(r11);     // Catch: Throwable -> L17
        return;
    L23:
        f288c = f289d;     // Catch: Throwable -> L17
    L27:
        monitor-exit(r11);     // Catch: Throwable -> L17
        return;
    L25:
        if (r12.equals(f289d) == true) goto L27;
        androidx.core.os.e r13 = f288c;     // Catch: Throwable -> L17
        f289d = r13;     // Catch: Throwable -> L17
        i.a(r10, r13.g());     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    L8:
        if (f291f == true) goto L32;
        f286a.execute(new androidx.appcompat.app.b(r10));
        return;
    }

    public static /* synthetic */ void a(Context r10) {
        u(r10);
    }

    public static void b(AppCompatDelegate r10) {
        Object r11 = f293h;
        monitor-enter(r11);
        E(r10);     // Catch: Throwable -> L7
        f292g.add(new WeakReference(r10));     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static AppCompatDelegate f(Activity r10, AppCompatCallback r11) {
        return new AppCompatDelegateImpl(r10, r11);
    }

    public static AppCompatDelegate g(Dialog r10, AppCompatCallback r11) {
        return new AppCompatDelegateImpl(r10, r11);
    }

    public static androidx.core.os.e i() {
        if (BuildCompat.c() == false) goto L8;
        Object r10 = n();
        if (r10 == null) goto L12;
        return androidx.core.os.e.h(b.a(r10));
    L12:
        return androidx.core.os.e.d();
    L8:
        androidx.core.os.e r11 = f288c;
        if (r11 == null) goto L12;
        return r11;
    }

    public static int k() {
        return f287b;
    }

    public static Object n() {
        Iterator r10 = f292g.iterator();
    L4:
        if (r10.hasNext() == false) goto L11;
        AppCompatDelegate r11 = (AppCompatDelegate) ((WeakReference) r10.next()).get();
        if (r11 == null) goto L4;
        Context r12 = r11.j();
        if (r12 == null) goto L4;
        return r12.getSystemService("locale");
    L11:
        return null;
    }

    public static androidx.core.os.e p() {
        return f288c;
    }

    public static boolean t(Context r10) {
        if (f290e != null) goto L10;
        Bundle r11 = AppLocalesMetadataHolderService.a(r10).metaData;     // Catch: PackageManager.NameNotFoundException -> L8
        if (r11 == null) goto L10;
        f290e = Boolean.valueOf(r11.getBoolean("autoStoreLocales"));     // Catch: PackageManager.NameNotFoundException -> L8
    L8:
        Log.d("AppCompatDelegate", "Checking for metadata for AppLocalesMetadataHolderService : Service not found");
        f290e = Boolean.FALSE;
    L10:
        return f290e.booleanValue();
    }

    public static /* synthetic */ void u(Context r10) {
        i.c(r10);
        f291f = true;
    }

    public abstract void A(Bundle r10);

    public abstract void B();

    public abstract void C();

    public abstract boolean F(int r10);

    public abstract void G(int r10);

    public abstract void H(View r10);

    public abstract void I(View r10, ViewGroup.LayoutParams r11);

    public abstract void J(int r10);

    public void K(OnBackInvokedDispatcher r10) {
    }

    public abstract void L(int r10);

    public abstract void M(CharSequence r10);

    public abstract void c(View r10, ViewGroup.LayoutParams r11);

    public void d(Context r10) {
    }

    public Context e(Context r10) {
        d(r10);
        return r10;
    }

    public abstract View h(int r10);

    public abstract Context j();

    public abstract ActionBarDrawerToggle$Delegate l();

    public abstract int m();

    public abstract MenuInflater o();

    public abstract ActionBar q();

    public abstract void r();

    public abstract void s();

    public abstract void v(Configuration r10);

    public abstract void w(Bundle r10);

    public abstract void x();

    public abstract void y(Bundle r10);

    public abstract void z();
}
