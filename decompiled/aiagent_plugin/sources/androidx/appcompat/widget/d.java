package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AppCompatDrawableManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class d {
    private static final String TAG = "AppCompatDrawableManag";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final PorterDuff.Mode f423a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static d f424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private u f425c;

    public d() {
    }

    static /* synthetic */ PorterDuff.Mode c() {
        return f423a;
    }

    static {
        f423a = PorterDuff.Mode.SRC_IN;
    }

    public static synchronized void a() {
        monitor-enter(d.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (f424b != null) goto L7;
        d r1 = new d();     // Catch: Throwable -> L9
        f424b = r1;     // Catch: Throwable -> L9
        r1.f425c = u.a();     // Catch: Throwable -> L9
        f424b.f425c.a(new AnonymousClass1());     // Catch: Throwable -> L9
    L7:
        monitor-exit(d.class);
    }

    public static synchronized d b() {
        monitor-enter(d.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f424b != null) goto L7;
        a();     // Catch: Throwable -> L10
    L7:
        d r1 = f424b;     // Catch: Throwable -> L10
        monitor-exit(d.class);
        return r1;
    }

    public synchronized Drawable a(Context r3, int r4) {
        monitor-enter(this);
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
        Drawable r6 = this.f425c.a(r5, r4);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r6;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized Drawable a(Context r3, int r4, boolean r5) {
        monitor-enter(this);
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
        Drawable r7 = this.f425c.a(r6, r4, r5);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r7;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void a(Context r3) {
        monitor-enter(this);
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
        this.f425c.a(r4);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized ColorStateList b(Context r3, int r4) {
        monitor-enter(this);
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
        ColorStateList r6 = this.f425c.b(r5, r4);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r6;
    L6:
        th = move-exception;
        throw th;
    }

    static void a(Drawable r0, x r1, int[] r2) {
        u.a(r0, r1, r2);
    }

    public static synchronized PorterDuffColorFilter a(int r1, PorterDuff.Mode r2) {
        monitor-enter(d.class);
        PorterDuffColorFilter r3 = u.a(r1, r2);     // Catch: Throwable -> L7
        monitor-exit(d.class);
        return r3;
    L7:
        th = move-exception;
        throw th;
    }
}
