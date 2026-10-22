package androidx.work;

import androidx.work.impl.model.o;
import com.bytedance.tracing.internal.TracingConstants;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.collections.r0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public abstract class l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f5904d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UUID f5905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f5906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f5907c;

    public static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class f5908a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f5909b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public UUID f5910c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public o f5911d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Set f5912e;

        public a(Class r10) {
            q.g(r10, "workerClass");
            this.f5908a = r10;
            UUID r11 = UUID.randomUUID();
            q.f(r11, "randomUUID()");
            this.f5910c = r11;
            String r12 = this.f5910c.toString();
            q.f(r12, "id.toString()");
            String r13 = r10.getName();
            q.f(r13, "workerClass.name");
            this.f5911d = new o(r12, r13);
            String r14 = r10.getName();
            q.f(r14, "workerClass.name");
            this.f5912e = r0.g(new String[]{r14});
        }

        public final l a() {
            l r10 = b();
            androidx.work.a r11 = this.f5911d.f5679j;
            if (r11.e() == false) goto L5;
        L12:
            boolean r12 = true;
        L13:
            o r13 = this.f5911d;
            if (r13.f5686q == false) goto L23;
            if (r12 == true) goto L22;
            if (r13.f5676g <= 0) goto L23;
            throw new IllegalArgumentException("Expedited jobs cannot be delayed");
        L22:
            throw new IllegalArgumentException("Expedited jobs only support network and storage constraints");
        L23:
            UUID r14 = UUID.randomUUID();
            q.f(r14, "randomUUID()");
            h(r14);
            return r10;
        L5:
            if (r11.f() == true) goto L12;
            if (r11.g() == true) goto L12;
            if (r11.h() == true) goto L12;
            r12 = false;
            goto L13
        }

        public abstract l b();

        public final boolean c() {
            return this.f5909b;
        }

        public final UUID d() {
            return this.f5910c;
        }

        public final Set e() {
            return this.f5912e;
        }

        public abstract a f();

        public final o g() {
            return this.f5911d;
        }

        public final a h(UUID r10) {
            q.g(r10, "id");
            this.f5910c = r10;
            String r11 = r10.toString();
            q.f(r11, "id.toString()");
            this.f5911d = new o(r11, this.f5911d);
            return f();
        }

        public a i(long r10, TimeUnit r11) {
            q.g(r11, "timeUnit");
            o r12 = this.f5911d;
            r12.f5676g = r11.toMillis(r10);
            if ((Long.MAX_VALUE - System.currentTimeMillis()) <= this.f5911d.f5676g) goto L7;
            return f();
        L7:
            throw new IllegalArgumentException("The given initial delay is too large and will cause an overflow!");
        }

        public final a j(c r10) {
            q.g(r10, "inputData");
            this.f5911d.f5674e = r10;
            return f();
        }
    }

    public static final class b {
        public /* synthetic */ b(DefaultConstructorMarker r10) {
            this();
        }

        public b() {
        }
    }

    static {
        f5904d = new b(null);
    }

    public l(UUID r10, o r11, Set r12) {
        q.g(r10, "id");
        q.g(r11, "workSpec");
        q.g(r12, TracingConstants.KEY_TAGS);
        this.f5905a = r10;
        this.f5906b = r11;
        this.f5907c = r12;
    }

    public UUID a() {
        return this.f5905a;
    }

    public final String b() {
        String r10 = a().toString();
        q.f(r10, "id.toString()");
        return r10;
    }

    public final Set c() {
        return this.f5907c;
    }

    public final o d() {
        return this.f5906b;
    }
}
