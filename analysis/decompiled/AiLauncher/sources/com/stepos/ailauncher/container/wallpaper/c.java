package com.stepos.ailauncher.container.wallpaper;

import Y8.t;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import w4.RobotInfo;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\f\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000e\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0004\b\u000e\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\bR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR&\u0010\u001c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\t0\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/stepos/ailauncher/container/wallpaper/c;", "", "<init>", "()V", "Landroid/content/Context;", "context", "LY8/t;", "f", "(Landroid/content/Context;)V", "Lkotlin/Function1;", "", "listener", Const.INTENT_KEY_PKGNAME, "(Lp9/l;)V", "e", Const.INTENT_KEY_UMID, "", "TAG", "Ljava/lang/String;", UxipConstants.f30680s, "current", "I", "c", "()I", "", RobotInfo.STATUS_STARTED, "Z", "Ljava/util/concurrent/CopyOnWriteArrayList;", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class c {
    private static final String TAG = "AmooThemeColor";
    private static volatile int current;
    private static volatile boolean started;
    public static final c INSTANCE = new c();
    private static final CopyOnWriteArrayList<InterfaceC5074l<Integer, t>> listeners = new CopyOnWriteArrayList<>();
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/container/wallpaper/c$a", "Landroid/database/ContentObserver;", "", "selfChange", "LY8/t;", "onChange", "(Z)V", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends ContentObserver {
        final /* synthetic */ Context $app;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context, Handler handler) {
            super(handler);
            this.$app = context;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange) {
            c cVar = c.INSTANCE;
            Context context = this.$app;
            p.f(context);
            cVar.d(context);
        }
    }

    public final void b(InterfaceC5074l<? super Integer, t> listener) {
        p.i(listener, "listener");
        listeners.add(listener);
    }

    public final int c() {
        return current;
    }

    public final void d(Context context) {
        int iB = b.INSTANCE.b(context);
        if (iB == current) {
            return;
        }
        current = iB;
        Log.i(TAG, "color=" + iB);
        Iterator<T> it = listeners.iterator();
        while (it.hasNext()) {
            InterfaceC5074l interfaceC5074l = (InterfaceC5074l) it.next();
            try {
                Result.Companion companion = Result.INSTANCE;
                interfaceC5074l.invoke(Integer.valueOf(iB));
                Result.b(t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }
    }

    public final void e(InterfaceC5074l<? super Integer, t> listener) {
        p.i(listener, "listener");
        listeners.remove(listener);
    }

    public final void f(Context context) {
        Object objB;
        p.i(context, "context");
        if (started) {
            return;
        }
        started = true;
        Context applicationContext = context.getApplicationContext();
        a aVar = new a(applicationContext, mainHandler);
        try {
            Result.Companion companion = Result.INSTANCE;
            applicationContext.getContentResolver().registerContentObserver(Settings.System.getUriFor(b.KEY), false, aVar);
            objB = Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.w(TAG, "registerContentObserver failed", thE);
        }
        p.f(applicationContext);
        d(applicationContext);
        Log.i(TAG, "start: color=" + current);
    }
}
