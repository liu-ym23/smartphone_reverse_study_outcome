package m8;

import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import io.github.oshai.kotlinlogging.Level;
import j8.C4783i;
import j8.C4784j;
import j8.InterfaceC4782h;
import j8.InterfaceC4786l;
import java.util.Map;
import kotlin.Function0;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import l8.C4876a;
import org.slf4j.Marker;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00020\u00030\u0004B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J)\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J!\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J5\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e0\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001b\u001a\u00020\u000e2\u000e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001d\u001a\u00020\u000e2\u000e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0019H\u0016¢\u0006\u0004\b\u001d\u0010\u001cJ\u001f\u0010\u001e\u001a\u00020\u000e2\u000e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0019H\u0016¢\u0006\u0004\b\u001e\u0010\u001cJ\u001f\u0010\u001f\u001a\u00020\u000e2\u000e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0019H\u0016¢\u0006\u0004\b\u001f\u0010\u001cJ\u001f\u0010 \u001a\u00020\u000e2\u000e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0019H\u0016¢\u0006\u0004\b \u0010\u001cJ)\u0010#\u001a\u00020\u000e2\b\u0010\"\u001a\u0004\u0018\u00010!2\u000e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0019H\u0016¢\u0006\u0004\b#\u0010$J)\u0010%\u001a\u00020\u000e2\b\u0010\"\u001a\u0004\u0018\u00010!2\u000e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0019H\u0016¢\u0006\u0004\b%\u0010$R\u001a\u0010\u0005\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0014\u0010+\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010*R\u0014\u0010.\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010-R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010-R\u0014\u00100\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010-R\u0014\u00101\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010-R\u0014\u00102\u001a\u00020)8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001d\u0010*R\u0014\u00103\u001a\u00020)8\u0002X\u0082D¢\u0006\u0006\n\u0004\b#\u0010*¨\u00064"}, d2 = {"Lm8/h;", "Lj8/h;", "", "Lxc/c;", "Lm8/j;", "underlyingLogger", "<init>", "(Lxc/c;)V", "Lj8/i;", "kLoggingEventBuilder", "Lio/github/oshai/kotlinlogging/Level;", "level", "Lj8/l;", "marker", "LY8/t;", "w", "(Lj8/i;Lio/github/oshai/kotlinlogging/Level;Lj8/l;)V", "x", "", "v", "(Lio/github/oshai/kotlinlogging/Level;Lj8/l;)Z", "Lkotlin/Function1;", "block", Const.INTENT_KEY_PKGNAME, "(Lio/github/oshai/kotlinlogging/Level;Lj8/l;Lp9/l;)V", "Lkotlin/Function0;", "message", "f", "(Lp9/a;)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "c", "e", Const.INTENT_KEY_UMID, "", "throwable", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/Throwable;Lp9/a;)V", Const.INTENT_KEY_APIKEY, "Lxc/c;", "t", "()Lxc/c;", "", "Ljava/lang/String;", "fqcn", "Lorg/slf4j/Marker;", "Lorg/slf4j/Marker;", "ENTRY", "EXIT", "THROWING", "CATCHING", "EXITONLY", "EXITMESSAGE", "kotlin-logging_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class h extends j<xc.c> implements InterfaceC4782h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final xc.c underlyingLogger;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final String fqcn;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Marker ENTRY;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Marker EXIT;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Marker THROWING;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final Marker CATCHING;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final String EXITONLY;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final String EXITMESSAGE;

    public h(xc.c underlyingLogger) {
        p.i(underlyingLogger, "underlyingLogger");
        this.underlyingLogger = underlyingLogger;
        String name = h.class.getName();
        p.h(name, "getName(...)");
        this.fqcn = name;
        C4784j c4784j = C4784j.f34532a;
        this.ENTRY = C4876a.a(c4784j.a("ENTRY"));
        this.EXIT = C4876a.a(c4784j.a("EXIT"));
        this.THROWING = C4876a.a(c4784j.a("THROWING"));
        this.CATCHING = C4876a.a(c4784j.a("CATCHING"));
        this.EXITONLY = "exit";
        this.EXITMESSAGE = "exit with ({})";
    }

    public static final t A(InterfaceC5063a interfaceC5063a, C4783i at) {
        p.i(at, "$this$at");
        at.f(Function0.a(interfaceC5063a));
        return t.f7040a;
    }

    public static final t q(InterfaceC5063a interfaceC5063a, C4783i at) {
        p.i(at, "$this$at");
        at.f(Function0.a(interfaceC5063a));
        return t.f7040a;
    }

    public static final t r(InterfaceC5063a interfaceC5063a, Throwable th, C4783i at) {
        p.i(at, "$this$at");
        at.f(Function0.a(interfaceC5063a));
        at.e(th);
        return t.f7040a;
    }

    public static final t s(InterfaceC5063a interfaceC5063a, C4783i at) {
        p.i(at, "$this$at");
        at.f(Function0.a(interfaceC5063a));
        return t.f7040a;
    }

    public static final t u(InterfaceC5063a interfaceC5063a, C4783i at) {
        p.i(at, "$this$at");
        at.f(Function0.a(interfaceC5063a));
        return t.f7040a;
    }

    public static final t y(InterfaceC5063a interfaceC5063a, C4783i at) {
        p.i(at, "$this$at");
        at.f(Function0.a(interfaceC5063a));
        return t.f7040a;
    }

    public static final t z(InterfaceC5063a interfaceC5063a, Throwable th, C4783i at) {
        p.i(at, "$this$at");
        at.f(Function0.a(interfaceC5063a));
        at.e(th);
        return t.f7040a;
    }

    @Override // m8.j, j8.InterfaceC4782h
    public void a(final Throwable throwable, final InterfaceC5063a<? extends Object> message) {
        p.i(message, "message");
        b(Level.ERROR, null, new InterfaceC5074l() { // from class: m8.d
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return h.r(message, throwable, (C4783i) obj);
            }
        });
    }

    @Override // j8.InterfaceC4782h
    public void b(Level level, InterfaceC4786l marker, InterfaceC5074l<? super C4783i, t> block) {
        p.i(level, "level");
        p.i(block, "block");
        if (v(level, marker)) {
            C4783i c4783i = new C4783i();
            block.invoke(c4783i);
            if (c4783i.d() != null) {
                w(c4783i, level, marker);
            } else {
                x(c4783i, level, marker);
            }
        }
    }

    @Override // m8.j, j8.InterfaceC4782h
    public void c(final InterfaceC5063a<? extends Object> message) {
        p.i(message, "message");
        b(Level.INFO, null, new InterfaceC5074l() { // from class: m8.c
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return h.u(message, (C4783i) obj);
            }
        });
    }

    @Override // m8.j, j8.InterfaceC4782h
    public void d(final InterfaceC5063a<? extends Object> message) {
        p.i(message, "message");
        b(Level.ERROR, null, new InterfaceC5074l() { // from class: m8.a
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return h.s(message, (C4783i) obj);
            }
        });
    }

    @Override // m8.j, j8.InterfaceC4782h
    public void e(final InterfaceC5063a<? extends Object> message) {
        p.i(message, "message");
        b(Level.WARN, null, new InterfaceC5074l() { // from class: m8.f
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return h.A(message, (C4783i) obj);
            }
        });
    }

    @Override // m8.j, j8.InterfaceC4782h
    public void f(final InterfaceC5063a<? extends Object> message) {
        p.i(message, "message");
        b(Level.TRACE, null, new InterfaceC5074l() { // from class: m8.g
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return h.y(message, (C4783i) obj);
            }
        });
    }

    @Override // m8.j, j8.InterfaceC4782h
    public void g(final InterfaceC5063a<? extends Object> message) {
        p.i(message, "message");
        b(Level.DEBUG, null, new InterfaceC5074l() { // from class: m8.e
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return h.q(message, (C4783i) obj);
            }
        });
    }

    @Override // m8.j, j8.InterfaceC4782h
    public void h(final Throwable throwable, final InterfaceC5063a<? extends Object> message) {
        p.i(message, "message");
        b(Level.WARN, null, new InterfaceC5074l() { // from class: m8.b
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return h.z(message, throwable, (C4783i) obj);
            }
        });
    }

    /* renamed from: t, reason: from getter */
    public xc.c getUnderlyingLogger() {
        return this.underlyingLogger;
    }

    public boolean v(Level level, InterfaceC4786l marker) {
        p.i(level, "level");
        return i(getUnderlyingLogger(), level, marker);
    }

    public final void w(C4783i kLoggingEventBuilder, Level level, InterfaceC4786l marker) {
        Marker markerA;
        xc.e eVarE = getUnderlyingLogger().e(C4876a.b(level));
        if (marker != null && (markerA = C4876a.a(marker)) != null) {
            eVarE.e(markerA);
        }
        Map<String, Object> mapD = kLoggingEventBuilder.d();
        if (mapD != null) {
            for (Map.Entry<String, Object> entry : mapD.entrySet()) {
                eVarE.f(entry.getKey(), entry.getValue());
            }
        }
        Object[] arguments = kLoggingEventBuilder.getArguments();
        if (arguments != null) {
            for (Object obj : arguments) {
                eVarE.d(obj);
            }
        }
        eVarE.c(kLoggingEventBuilder.getCause());
        if (eVarE instanceof xc.a) {
            ((xc.a) eVarE).b(this.fqcn);
        }
        eVarE.a(kLoggingEventBuilder.getMessage());
    }

    public final void x(C4783i kLoggingEventBuilder, Level level, InterfaceC4786l marker) {
        getUnderlyingLogger().s(marker != null ? C4876a.a(marker) : null, this.fqcn, C4876a.b(level).toInt(), kLoggingEventBuilder.getMessage(), kLoggingEventBuilder.getArguments(), kLoggingEventBuilder.getCause());
    }
}
