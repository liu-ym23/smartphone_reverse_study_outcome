package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class y extends ContextWrapper {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f1157c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static ArrayList f1158d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Resources f1159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Resources.Theme f1160b;

    static {
        f1157c = new Object();
    }

    public y(Context r10) {
        super(r10);
        if (h0.c() == false) goto L5;
        h0 r11 = new h0(this, r10.getResources());
        this.f1159a = r11;
        Resources.Theme r12 = r11.newTheme();
        this.f1160b = r12;
        r12.setTo(r10.getTheme());
        return;
    L5:
        this.f1159a = new a0(this, r10.getResources());
        this.f1160b = null;
    }

    public static boolean a(Context r10) {
        if ((r10 instanceof y) == false) goto L5;
        return false;
    L5:
        if ((r10.getResources() instanceof a0) == false) goto L7;
        return false;
    L7:
        if ((r10.getResources() instanceof h0) == false) goto L10;
        return false;
    L10:
        return h0.c();
    }

    public static Context b(Context r10) {
        if (a(r10) == false) goto L36;
        Object r11 = f1157c;
        monitor-enter(r11);
        ArrayList r12 = f1158d;     // Catch: Throwable -> L9
        if (r12 != null) goto L11;
        f1158d = new ArrayList();     // Catch: Throwable -> L9
    L31:
        y r13 = new y(r10);     // Catch: Throwable -> L9
        f1158d.add(new WeakReference(r13));     // Catch: Throwable -> L9
        monitor-exit(r11);     // Catch: Throwable -> L9
        return r13;
    L11:
        int r14 = r12.size() - 1;     // Catch: Throwable -> L9
    L12:
        if (r14 < 0) goto L19;
        WeakReference r15 = (WeakReference) f1158d.get(r14);     // Catch: Throwable -> L9
        if (r15 != null) goto L16;
    L17:
        f1158d.remove(r14);     // Catch: Throwable -> L9
    L18:
        r14 = r14 - 1;     // Catch: Throwable -> L9
        goto L12
    L16:
        if (r15.get() != null) goto L18;
    L19:
        int r16 = f1158d.size() - 1;     // Catch: Throwable -> L9
    L20:
        if (r16 < 0) goto L31;
        WeakReference r17 = (WeakReference) f1158d.get(r16);     // Catch: Throwable -> L9
        if (r17 == null) goto L24;
        y r18 = (y) r17.get();     // Catch: Throwable -> L9
    L25:
        if (r18 == null) goto L30;
        if (r18.getBaseContext() != r10) goto L30;
        monitor-exit(r11);     // Catch: Throwable -> L9
        return r18;
    L30:
        r16 = r16 - 1;     // Catch: Throwable -> L9
        goto L20
    L24:
        r18 = null;
    L9:
        th = move-exception;
        throw th;
    L36:
        return r10;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.f1159a.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.f1159a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme r10 = this.f1160b;
        if (r10 == null) goto L5;
        return r10;
    L5:
        return super.getTheme();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int r10) {
        Resources.Theme r11 = this.f1160b;
        if (r11 != null) goto L5;
        super.setTheme(r10);
        return;
    L5:
        r11.applyStyle(r10, true);
    }
}
