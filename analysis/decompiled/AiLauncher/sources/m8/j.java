package m8;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import io.github.oshai.kotlinlogging.Level;
import j8.InterfaceC4782h;
import j8.InterfaceC4786l;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.p;
import l8.C4876a;
import p9.InterfaceC5063a;
import vc.c;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00028\u00000\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0004¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lm8/j;", "Lvc/c;", ExifInterface.GPS_DIRECTION_TRUE, "Lj8/h;", "", "<init>", "()V", "underlyingLogger", "Lio/github/oshai/kotlinlogging/Level;", "level", "Lj8/l;", "marker", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lvc/c;Lio/github/oshai/kotlinlogging/Level;Lj8/l;)Z", "kotlin-logging_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class j<T extends vc.c> implements InterfaceC4782h {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f37188a;

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
            f37188a = iArr;
        }
    }

    @Override // j8.InterfaceC4782h
    public void a(Throwable th, InterfaceC5063a<? extends Object> interfaceC5063a) {
        InterfaceC4782h.a.k(this, th, interfaceC5063a);
    }

    @Override // j8.InterfaceC4782h
    public void c(InterfaceC5063a<? extends Object> interfaceC5063a) {
        InterfaceC4782h.a.o(this, interfaceC5063a);
    }

    @Override // j8.InterfaceC4782h
    public void d(InterfaceC5063a<? extends Object> interfaceC5063a) {
        InterfaceC4782h.a.l(this, interfaceC5063a);
    }

    @Override // j8.InterfaceC4782h
    public void e(InterfaceC5063a<? extends Object> interfaceC5063a) {
        InterfaceC4782h.a.t(this, interfaceC5063a);
    }

    @Override // j8.InterfaceC4782h
    public void f(InterfaceC5063a<? extends Object> interfaceC5063a) {
        InterfaceC4782h.a.q(this, interfaceC5063a);
    }

    @Override // j8.InterfaceC4782h
    public void g(InterfaceC5063a<? extends Object> interfaceC5063a) {
        InterfaceC4782h.a.i(this, interfaceC5063a);
    }

    @Override // j8.InterfaceC4782h
    public void h(Throwable th, InterfaceC5063a<? extends Object> interfaceC5063a) {
        InterfaceC4782h.a.s(this, th, interfaceC5063a);
    }

    public final boolean i(vc.c underlyingLogger, Level level, InterfaceC4786l marker) {
        p.i(underlyingLogger, "underlyingLogger");
        p.i(level, "level");
        switch (a.f37188a[level.ordinal()]) {
            case 1:
                return underlyingLogger.v(marker != null ? C4876a.a(marker) : null);
            case 2:
                return underlyingLogger.h(marker != null ? C4876a.a(marker) : null);
            case 3:
                return underlyingLogger.z(marker != null ? C4876a.a(marker) : null);
            case 4:
                return underlyingLogger.g(marker != null ? C4876a.a(marker) : null);
            case 5:
                return underlyingLogger.w(marker != null ? C4876a.a(marker) : null);
            case 6:
                return false;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
