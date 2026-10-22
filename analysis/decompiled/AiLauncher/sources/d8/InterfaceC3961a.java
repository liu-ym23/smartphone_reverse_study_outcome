package d8;

import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0004\bf\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0007J\u001f\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0007J+\u0010\f\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Ld8/a;", "", "", "tag", "msg", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;)V", "e", "c", "", "throwable", Const.INTENT_KEY_UMID, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "sdk_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: d8.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public interface InterfaceC3961a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = Companion.f32143a;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\b¨\u0006\r"}, d2 = {"Ld8/a$a;", "", "<init>", "()V", "Ld8/a;", Const.INTENT_KEY_PKGNAME, "Ld8/a;", Const.INTENT_KEY_APIKEY, "()Ld8/a;", "DEFAULT", "c", "getNOOP", "NOOP", "sdk_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: d8.a$a, reason: collision with other inner class name and from kotlin metadata */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f32143a = new Companion();

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public static final InterfaceC3961a DEFAULT = new C0387a();

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public static final InterfaceC3961a NOOP = new b();

        @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u001f\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0007J)\u0010\f\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"d8/a$a$a", "Ld8/a;", "", "tag", "msg", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;)V", "e", "c", "", "throwable", Const.INTENT_KEY_UMID, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "sdk_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: d8.a$a$a, reason: collision with other inner class name */
        public static final class C0387a implements InterfaceC3961a {
            @Override // d8.InterfaceC3961a
            public void a(String tag, String msg) {
                p.i(tag, "tag");
                p.i(msg, "msg");
                Log.d(tag, msg);
            }

            @Override // d8.InterfaceC3961a
            public void c(String tag, String msg) {
                p.i(tag, "tag");
                p.i(msg, "msg");
                Log.w(tag, msg);
            }

            @Override // d8.InterfaceC3961a
            public void d(String tag, String msg, Throwable throwable) {
                p.i(tag, "tag");
                p.i(msg, "msg");
                if (throwable != null) {
                    Log.e(tag, msg, throwable);
                } else {
                    Log.e(tag, msg);
                }
            }

            @Override // d8.InterfaceC3961a
            public void e(String tag, String msg) {
                p.i(tag, "tag");
                p.i(msg, "msg");
                Log.i(tag, msg);
            }
        }

        @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u001f\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0007J)\u0010\f\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"d8/a$a$b", "Ld8/a;", "", "tag", "msg", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;)V", "e", "c", "", "throwable", Const.INTENT_KEY_UMID, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "sdk_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: d8.a$a$b */
        public static final class b implements InterfaceC3961a {
            @Override // d8.InterfaceC3961a
            public void a(String tag, String msg) {
                p.i(tag, "tag");
                p.i(msg, "msg");
            }

            @Override // d8.InterfaceC3961a
            public void c(String tag, String msg) {
                p.i(tag, "tag");
                p.i(msg, "msg");
            }

            @Override // d8.InterfaceC3961a
            public void d(String tag, String msg, Throwable throwable) {
                p.i(tag, "tag");
                p.i(msg, "msg");
            }

            @Override // d8.InterfaceC3961a
            public void e(String tag, String msg) {
                p.i(tag, "tag");
                p.i(msg, "msg");
            }
        }

        public final InterfaceC3961a a() {
            return DEFAULT;
        }
    }

    static /* synthetic */ void b(InterfaceC3961a interfaceC3961a, String str, String str2, Throwable th, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: error");
        }
        if ((i10 & 4) != 0) {
            th = null;
        }
        interfaceC3961a.d(str, str2, th);
    }

    void a(String tag, String msg);

    void c(String tag, String msg);

    void d(String tag, String msg, Throwable throwable);

    void e(String tag, String msg);
}
