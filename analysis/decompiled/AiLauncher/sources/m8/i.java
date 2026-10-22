package m8;

import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import io.github.oshai.kotlinlogging.Level;
import j8.C4783i;
import j8.InterfaceC4782h;
import j8.InterfaceC4786l;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.p;
import l8.C4876a;
import org.slf4j.Marker;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00020\u00030\u0004B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J)\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J!\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J5\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e0\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0005\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lm8/i;", "Lj8/h;", "", "Lvc/c;", "Lm8/j;", "underlyingLogger", "<init>", "(Lvc/c;)V", "Lj8/i;", "kLoggingEventBuilder", "Lio/github/oshai/kotlinlogging/Level;", "level", "Lj8/l;", "marker", "LY8/t;", "l", "(Lj8/i;Lio/github/oshai/kotlinlogging/Level;Lj8/l;)V", "m", "", "k", "(Lio/github/oshai/kotlinlogging/Level;Lj8/l;)Z", "Lkotlin/Function1;", "block", Const.INTENT_KEY_PKGNAME, "(Lio/github/oshai/kotlinlogging/Level;Lj8/l;Lp9/l;)V", Const.INTENT_KEY_APIKEY, "Lvc/c;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Lvc/c;", "kotlin-logging_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class i extends j<vc.c> implements InterfaceC4782h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final vc.c underlyingLogger;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f37187a;

        static {
            int[] iArr = new int[Level.values().length];
            try {
                iArr[Level.TRACE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Level.DEBUG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Level.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Level.WARN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Level.ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Level.OFF.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f37187a = iArr;
        }
    }

    public i(vc.c underlyingLogger) {
        p.i(underlyingLogger, "underlyingLogger");
        this.underlyingLogger = underlyingLogger;
    }

    private final void l(C4783i kLoggingEventBuilder, Level level, InterfaceC4786l marker) {
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
        eVarE.a(kLoggingEventBuilder.getMessage());
    }

    private final void m(C4783i kLoggingEventBuilder, Level level, InterfaceC4786l marker) {
        Marker markerA = marker != null ? C4876a.a(marker) : null;
        String message = kLoggingEventBuilder.getMessage();
        Throwable cause = kLoggingEventBuilder.getCause();
        switch (a.f37187a[level.ordinal()]) {
            case 1:
                getUnderlyingLogger().n(markerA, message, cause);
                return;
            case 2:
                getUnderlyingLogger().x(markerA, message, cause);
                return;
            case 3:
                getUnderlyingLogger().l(markerA, message, cause);
                return;
            case 4:
                getUnderlyingLogger().k(markerA, message, cause);
                return;
            case 5:
                getUnderlyingLogger().y(markerA, message, cause);
                return;
            case 6:
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @Override // j8.InterfaceC4782h
    public void b(Level level, InterfaceC4786l marker, InterfaceC5074l<? super C4783i, t> block) {
        p.i(level, "level");
        p.i(block, "block");
        if (k(level, marker)) {
            C4783i c4783i = new C4783i();
            block.invoke(c4783i);
            if (c4783i.d() != null) {
                l(c4783i, level, marker);
            } else {
                m(c4783i, level, marker);
            }
        }
    }

    /* renamed from: j, reason: from getter */
    public vc.c getUnderlyingLogger() {
        return this.underlyingLogger;
    }

    public boolean k(Level level, InterfaceC4786l marker) {
        p.i(level, "level");
        return i(getUnderlyingLogger(), level, marker);
    }
}
