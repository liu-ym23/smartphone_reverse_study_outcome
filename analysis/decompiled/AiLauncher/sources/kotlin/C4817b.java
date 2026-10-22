package kotlin;

import Y8.t;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import io.github.oshai.kotlinlogging.Level;
import j8.C4783i;
import j8.InterfaceC4782h;
import j8.InterfaceC4786l;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J5\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lk8/b;", "Lj8/h;", "", "name", "<init>", "(Ljava/lang/String;)V", "Lio/github/oshai/kotlinlogging/Level;", "level", "Lj8/l;", "marker", "Lkotlin/Function1;", "Lj8/i;", "LY8/t;", "block", Const.INTENT_KEY_PKGNAME, "(Lio/github/oshai/kotlinlogging/Level;Lj8/l;Lp9/l;)V", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lio/github/oshai/kotlinlogging/Level;Lj8/l;)Z", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Ljava/lang/String;", "kotlin-logging_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: k8.b, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C4817b implements InterfaceC4782h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String name;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* renamed from: k8.b$a */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f34637a;

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
            f34637a = iArr;
        }
    }

    public C4817b(String name) {
        p.i(name, "name");
        this.name = name;
    }

    @Override // j8.InterfaceC4782h
    public void a(Throwable th, InterfaceC5063a<? extends Object> interfaceC5063a) {
        InterfaceC4782h.a.k(this, th, interfaceC5063a);
    }

    @Override // j8.InterfaceC4782h
    public void b(Level level, InterfaceC4786l marker, InterfaceC5074l<? super C4783i, t> block) {
        p.i(level, "level");
        p.i(block, "block");
        if (j(level, marker)) {
            C4783i c4783i = new C4783i();
            block.invoke(c4783i);
            switch (a.f34637a[level.ordinal()]) {
                case 1:
                    Log.v(getName(), c4783i.getMessage(), c4783i.getCause());
                    return;
                case 2:
                    Log.d(getName(), c4783i.getMessage(), c4783i.getCause());
                    return;
                case 3:
                    Log.i(getName(), c4783i.getMessage(), c4783i.getCause());
                    return;
                case 4:
                    Log.w(getName(), c4783i.getMessage(), c4783i.getCause());
                    return;
                case 5:
                    Log.e(getName(), c4783i.getMessage(), c4783i.getCause());
                    return;
                case 6:
                    return;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
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

    /* renamed from: i, reason: from getter */
    public String getName() {
        return this.name;
    }

    public boolean j(Level level, InterfaceC4786l marker) {
        p.i(level, "level");
        switch (a.f34637a[level.ordinal()]) {
            case 1:
                return Log.isLoggable(getName(), 2);
            case 2:
                return Log.isLoggable(getName(), 3);
            case 3:
                return Log.isLoggable(getName(), 4);
            case 4:
                return Log.isLoggable(getName(), 5);
            case 5:
                return Log.isLoggable(getName(), 6);
            case 6:
                return false;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
