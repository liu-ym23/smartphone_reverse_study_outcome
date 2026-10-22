package l8;

import com.autonavi.aps.amapapi.config.Const;
import io.github.oshai.kotlinlogging.Level;
import io.github.oshai.kotlinlogging.slf4j.internal.Slf4jMarker;
import j8.InterfaceC4786l;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.p;
import org.slf4j.Marker;
import vc.g;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lj8/l;", "Lorg/slf4j/Marker;", Const.INTENT_KEY_APIKEY, "(Lj8/l;)Lorg/slf4j/Marker;", "Lio/github/oshai/kotlinlogging/Level;", "Lorg/slf4j/event/Level;", Const.INTENT_KEY_PKGNAME, "(Lio/github/oshai/kotlinlogging/Level;)Lorg/slf4j/event/Level;", "kotlin-logging_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* renamed from: l8.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C4876a {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* renamed from: l8.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0468a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f36968a;

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
            f36968a = iArr;
        }
    }

    public static final Marker a(InterfaceC4786l interfaceC4786l) {
        p.i(interfaceC4786l, "<this>");
        if (interfaceC4786l instanceof Slf4jMarker) {
            return ((Slf4jMarker) interfaceC4786l).getMarker();
        }
        Marker markerA = g.a(interfaceC4786l.getName());
        p.h(markerA, "getMarker(...)");
        return markerA;
    }

    public static final org.slf4j.event.Level b(Level level) {
        p.i(level, "<this>");
        switch (C0468a.f36968a[level.ordinal()]) {
            case 1:
                return org.slf4j.event.Level.TRACE;
            case 2:
                return org.slf4j.event.Level.DEBUG;
            case 3:
                return org.slf4j.event.Level.INFO;
            case 4:
                return org.slf4j.event.Level.WARN;
            case 5:
                return org.slf4j.event.Level.ERROR;
            case 6:
                throw new IllegalArgumentException("OFF level is not supported");
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
