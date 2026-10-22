package p5;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.platform.godzilla.GodzillaCore;
import com.bytedance.platform.godzilla.common.ILog;
import com.bytedance.platform.godzilla.common.IReflectHackHelper;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.plugin.StartType;
import d6.c;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile a f23325c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f23326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f23327b;

    /* JADX INFO: renamed from: p5.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0339a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Application f23328a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HashMap f23329b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ILog f23330c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Logger.Level f23331d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public IReflectHackHelper f23332e;

        public b(Application r10) {
            this.f23329b = new HashMap();
            if (r10 == null) goto L7;
            this.f23328a = r10;
            return;
        L7:
            throw new RuntimeException("Godzilla init, application is null");
        }

        public a a() {
            return new a(this.f23328a, this.f23329b, this.f23330c, this.f23331d, this.f23332e, null);
        }

        public b b(c6.a r10) {
            String r11 = r10.a();
            if (TextUtils.isEmpty(r11) == true) goto L11;
            if (this.f23329b.get(r11) != null) goto L9;
            this.f23329b.put(r11, r10);
            return this;
        L9:
            throw new RuntimeException(String.format("%s plugin is already exist", new Object[]{r11}));
        L11:
            throw new RuntimeException(String.format("%s plugin name is null", new Object[]{r10.getClass().getName()}));
        }
    }

    public /* synthetic */ a(Application r10, HashMap r11, ILog r12, Logger.Level r13, IReflectHackHelper r14, C0339a r15) {
        this(r10, r11, r12, r13, r14);
    }

    public static a a(a r10) {
        if (r10 == null) goto L17;
        monitor-enter(a.class);
    L8:
        th = move-exception;
        throw th;
    L6:
        if (f23325c != null) goto L10;
        f23325c = r10;     // Catch: Throwable -> L8
    L11:
        monitor-exit(a.class);     // Catch: Throwable -> L8
        return f23325c;
    L10:
        Logger.c("Godzilla", "Godzilla instance is already set. this invoking will be ignored");     // Catch: Throwable -> L8
        goto L11
    L17:
        throw new RuntimeException("Godzilla should not be null.");
    }

    public static a d() {
        if (f23325c == null) goto L7;
        return f23325c;
    L7:
        throw new RuntimeException("Godzilla.init() method must be called first");
    }

    public void b() {
        c(StartType.IMMEDIATE);
    }

    public void c(StartType r10) {
        Iterator r11 = this.f23327b.values().iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        c6.a r12 = (c6.a) r11.next();
        if (r12.d() != r10) goto L4;
        r12.c();
        goto L4
    }

    public a(Application r10, HashMap r11, ILog r12, Logger.Level r13, IReflectHackHelper r14) {
        this.f23326a = r10;
        this.f23327b = r11;
        GodzillaCore.INSTANCE.init(r10, r12, r13);
        Iterator r15 = r11.values().iterator();
    L4:
        if (r15.hasNext() == false) goto L6;
        ((c6.a) r15.next()).b(this.f23326a);
        goto L4
    L6:
        c.b(r14);
    }
}
