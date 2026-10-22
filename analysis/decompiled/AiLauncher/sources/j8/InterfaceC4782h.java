package j8;

import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import io.github.oshai.kotlinlogging.Level;
import j8.InterfaceC4782h;
import kotlin.Function0;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u0007\u001a\u00020\u00042\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u001f\u0010\b\u001a\u00020\u00042\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00042\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00042\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0006J)\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ)\u0010\u000f\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ7\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00040\u0014H&¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lj8/h;", "", "Lkotlin/Function0;", "message", "LY8/t;", "f", "(Lp9/a;)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "c", "e", Const.INTENT_KEY_UMID, "", "throwable", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/Throwable;Lp9/a;)V", Const.INTENT_KEY_APIKEY, "Lio/github/oshai/kotlinlogging/Level;", "level", "Lj8/l;", "marker", "Lkotlin/Function1;", "Lj8/i;", "block", Const.INTENT_KEY_PKGNAME, "(Lio/github/oshai/kotlinlogging/Level;Lj8/l;Lp9/l;)V", "kotlin-logging_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: j8.h, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public interface InterfaceC4782h {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* renamed from: j8.h$a */
    public static final class a {
        public static /* synthetic */ void h(InterfaceC4782h interfaceC4782h, Level level, InterfaceC4786l interfaceC4786l, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: at");
            }
            if ((i10 & 2) != 0) {
                interfaceC4786l = null;
            }
            interfaceC4782h.b(level, interfaceC4786l, interfaceC5074l);
        }

        public static void i(InterfaceC4782h interfaceC4782h, final InterfaceC5063a<? extends Object> message) {
            p.i(message, "message");
            h(interfaceC4782h, Level.DEBUG, null, new InterfaceC5074l() { // from class: j8.e
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return InterfaceC4782h.a.j(message, (C4783i) obj);
                }
            }, 2, null);
        }

        public static t j(InterfaceC5063a interfaceC5063a, C4783i at) {
            p.i(at, "$this$at");
            at.f(Function0.a(interfaceC5063a));
            return t.f7040a;
        }

        public static void k(InterfaceC4782h interfaceC4782h, final Throwable th, final InterfaceC5063a<? extends Object> message) {
            p.i(message, "message");
            h(interfaceC4782h, Level.ERROR, null, new InterfaceC5074l() { // from class: j8.d
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return InterfaceC4782h.a.n(message, th, (C4783i) obj);
                }
            }, 2, null);
        }

        public static void l(InterfaceC4782h interfaceC4782h, final InterfaceC5063a<? extends Object> message) {
            p.i(message, "message");
            h(interfaceC4782h, Level.ERROR, null, new InterfaceC5074l() { // from class: j8.b
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return InterfaceC4782h.a.m(message, (C4783i) obj);
                }
            }, 2, null);
        }

        public static t m(InterfaceC5063a interfaceC5063a, C4783i at) {
            p.i(at, "$this$at");
            at.f(Function0.a(interfaceC5063a));
            return t.f7040a;
        }

        public static t n(InterfaceC5063a interfaceC5063a, Throwable th, C4783i at) {
            p.i(at, "$this$at");
            at.f(Function0.a(interfaceC5063a));
            at.e(th);
            return t.f7040a;
        }

        public static void o(InterfaceC4782h interfaceC4782h, final InterfaceC5063a<? extends Object> message) {
            p.i(message, "message");
            h(interfaceC4782h, Level.INFO, null, new InterfaceC5074l() { // from class: j8.c
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return InterfaceC4782h.a.p(message, (C4783i) obj);
                }
            }, 2, null);
        }

        public static t p(InterfaceC5063a interfaceC5063a, C4783i at) {
            p.i(at, "$this$at");
            at.f(Function0.a(interfaceC5063a));
            return t.f7040a;
        }

        public static void q(InterfaceC4782h interfaceC4782h, final InterfaceC5063a<? extends Object> message) {
            p.i(message, "message");
            h(interfaceC4782h, Level.TRACE, null, new InterfaceC5074l() { // from class: j8.a
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return InterfaceC4782h.a.r(message, (C4783i) obj);
                }
            }, 2, null);
        }

        public static t r(InterfaceC5063a interfaceC5063a, C4783i at) {
            p.i(at, "$this$at");
            at.f(Function0.a(interfaceC5063a));
            return t.f7040a;
        }

        public static void s(InterfaceC4782h interfaceC4782h, final Throwable th, final InterfaceC5063a<? extends Object> message) {
            p.i(message, "message");
            h(interfaceC4782h, Level.WARN, null, new InterfaceC5074l() { // from class: j8.g
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return InterfaceC4782h.a.v(message, th, (C4783i) obj);
                }
            }, 2, null);
        }

        public static void t(InterfaceC4782h interfaceC4782h, final InterfaceC5063a<? extends Object> message) {
            p.i(message, "message");
            h(interfaceC4782h, Level.WARN, null, new InterfaceC5074l() { // from class: j8.f
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return InterfaceC4782h.a.u(message, (C4783i) obj);
                }
            }, 2, null);
        }

        public static t u(InterfaceC5063a interfaceC5063a, C4783i at) {
            p.i(at, "$this$at");
            at.f(Function0.a(interfaceC5063a));
            return t.f7040a;
        }

        public static t v(InterfaceC5063a interfaceC5063a, Throwable th, C4783i at) {
            p.i(at, "$this$at");
            at.f(Function0.a(interfaceC5063a));
            at.e(th);
            return t.f7040a;
        }
    }

    void a(Throwable throwable, InterfaceC5063a<? extends Object> message);

    void b(Level level, InterfaceC4786l marker, InterfaceC5074l<? super C4783i, t> block);

    void c(InterfaceC5063a<? extends Object> message);

    void d(InterfaceC5063a<? extends Object> message);

    void e(InterfaceC5063a<? extends Object> message);

    void f(InterfaceC5063a<? extends Object> message);

    void g(InterfaceC5063a<? extends Object> message);

    void h(Throwable throwable, InterfaceC5063a<? extends Object> message);
}
