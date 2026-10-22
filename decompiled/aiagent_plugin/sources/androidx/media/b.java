package androidx.media;

import android.content.Context;
import android.media.session.MediaSessionManager;
import android.os.Build;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: MediaSessionManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final boolean f2219a = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f2220c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    a f2221b;

    /* JADX INFO: compiled from: MediaSessionManager.java */
    interface a {
        Context getContext();
    }

    /* JADX INFO: renamed from: androidx.media.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MediaSessionManager.java */
    public static final class C0067b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        c f2222a;

        public C0067b(String r3, int r4, int r5) {
            if (Build.VERSION.SDK_INT < 28) goto L5;
            this.f2222a = new d.a(r3, r4, r5);
            return;
        L5:
            this.f2222a = new e.a(r3, r4, r5);
        }

        public C0067b(MediaSessionManager.RemoteUserInfo r2) {
            this.f2222a = new d.a(r2);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L7;
            return true;
        L7:
            if (ZeusTransformUtils.instanceOf(r3, C0067b.class) == true) goto L11;
            return false;
        L11:
            return this.f2222a.equals(((C0067b) ZeusTransformUtils.preCheckCast(r3, C0067b.class, "com.obric.aiagent.plugin")).f2222a);
        }

        public int hashCode() {
            return this.f2222a.hashCode();
        }
    }

    /* JADX INFO: compiled from: MediaSessionManager.java */
    interface c {
    }

    static {
        f2219a = a("MediaSessionManager", 3);
        f2220c = new Object();
    }

    Context getContext() {
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f2221b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static boolean a(String r1, int r2) {
        if (com.obric.aiagent.apm.impl.a.a() == true) goto L7;
        return Log.isLoggable(r1, r2);
    L7:
        if (r2 == 6) goto L9;
    L11:
        return false;
    L9:
        if (Log.isLoggable(r1, r2) == false) goto L11;
        return true;
    }
}
