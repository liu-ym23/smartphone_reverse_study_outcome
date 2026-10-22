package com.bytedanceos.appstore.atomic;

import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.toolbox.j;
import com.obric.capabilitykit.AtomicCapabilitySdk;
import com.obric.capabilitykit.EntitySupplier;
import com.obric.capabilitykit.common.BaseFunction;
import com.obric.capabilitykit.logger.ILogger;
import com.obric.capabilitykit.sync.EntitySyncDataSupplier;
import kotlin.jvm.internal.q;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8277a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f8278b;

    /* JADX INFO: renamed from: com.bytedanceos.appstore.atomic.a$a, reason: collision with other inner class name */
    public static final class C0108a implements BaseFunction {
    }

    public static final class b implements ILogger {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f8279a = null;

        static {
            f8279a = new b();
        }

        public b() {
        }

        @Override // com.obric.capabilitykit.logger.ILogger
        public void d(String r10, String r11) {
            q.g(r10, "tag");
            j.a("StoreAtomic " + r10 + TokenParser.SP + r11);
        }

        @Override // com.obric.capabilitykit.logger.ILogger
        public void e(String r10, String r11) {
            q.g(r10, "tag");
            j.b("StoreAtomic " + r10 + TokenParser.SP + r11);
        }

        @Override // com.obric.capabilitykit.logger.ILogger
        public void i(String r10, String r11) {
            q.g(r10, "tag");
            j.e("StoreAtomic " + r10 + TokenParser.SP + r11);
        }

        @Override // com.obric.capabilitykit.logger.ILogger
        public boolean isDebug() {
            return false;
        }

        @Override // com.obric.capabilitykit.logger.ILogger
        public void v(String r10, String r11) {
            q.g(r10, "tag");
            j.l("StoreAtomic " + r10 + TokenParser.SP + r11);
        }

        @Override // com.obric.capabilitykit.logger.ILogger
        public void w(String r10, String r11) {
            q.g(r10, "tag");
            j.m("StoreAtomic " + r10 + TokenParser.SP + r11);
        }

        @Override // com.obric.capabilitykit.logger.ILogger
        public void e(String r10, String r11, Throwable r12) {
            q.g(r10, "tag");
            j.b("StoreAtomic " + r10 + TokenParser.SP + r11);
        }

        @Override // com.obric.capabilitykit.logger.ILogger
        public void w(String r10, String r11, Throwable r12) {
            q.g(r10, "tag");
            j.m("StoreAtomic " + r10 + TokenParser.SP + r11);
        }

        @Override // com.obric.capabilitykit.logger.ILogger
        public void w(String r10, Throwable r11) {
            q.g(r10, "tag");
            StringBuilder r12 = new StringBuilder();
            r12.append("StoreAtomic ");
            r12.append(r10);
            r12.append(TokenParser.SP);
            if (r11 == null) goto L5;
            String r13 = r11.getMessage();
        L6:
            r12.append(r13);
            j.m(r12.toString());
            return;
        L5:
            r13 = null;
            goto L6
        }
    }

    public static final class c implements BaseFunction {
    }

    static {
        f8277a = new a();
    }

    public a() {
    }

    public static final void a() {
        if (f8278b == false) goto L5;
        return;
    L5:
        f8278b = true;
        AtomicCapabilitySdk.setLogger(b.f8279a);
        BaseApplication r10 = BaseApplication.c();
        q.f(r10, "getContext(...)");
        EntitySupplier r11 = null;
        String r12 = null;
        EntitySyncDataSupplier r13 = null;
        AtomicCapabilitySdk.init(new AtomicCapabilitySdk.InitConfig(r10, r11, r12, r13, 14, null));
    }
}
