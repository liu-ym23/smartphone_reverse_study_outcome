package w;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\b\u0087@\u0018\u0000 \u00152\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\bJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0005J\u001a\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\u0016"}, d2 = {"Lw/b;", "", "", UxipConstants.f30680s, "c", "(I)I", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "(I)Z", "f", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(I)Ljava/lang/String;", "e", "other", Const.INTENT_KEY_UMID, "(ILjava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "I", "getValue", "()I", Const.INTENT_KEY_PKGNAME, "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: w.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5696b {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    public static final int f42959c;

    /* renamed from: d, reason: collision with root package name */
    public static final int f42960d;

    /* renamed from: e, reason: collision with root package name */
    public static final int f42961e;

    /* renamed from: f, reason: collision with root package name */
    public static final int f42962f;

    /* renamed from: g, reason: collision with root package name */
    public static final int f42963g;

    /* renamed from: h, reason: collision with root package name */
    public static final int f42964h;

    /* renamed from: i, reason: collision with root package name */
    public static final List<C5696b> f42965i;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final int value;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bR\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lw/b$a;", "", "<init>", "()V", "", UxipConstants.f30680s, "Lw/b;", Const.INTENT_KEY_APIKEY, "(I)Lw/b;", "", "values", "Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "()Ljava/util/List;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: w.b$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final C5696b a(int value) {
            Object next;
            Iterator<T> it = b().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((C5696b) next).getValue() == value) {
                    break;
                }
            }
            return (C5696b) next;
        }

        public final List<C5696b> b() {
            return C5696b.f42965i;
        }

        public Companion() {
        }
    }

    static {
        int iC = c(0);
        f42959c = iC;
        int iC2 = c(1);
        f42960d = iC2;
        int iC3 = c(2);
        f42961e = iC3;
        int iC4 = c(3);
        f42962f = iC4;
        int iC5 = c(4);
        f42963g = iC5;
        int iC6 = c(5);
        f42964h = iC6;
        f42965i = C1173v.p(b(iC), b(iC2), b(iC3), b(iC4), b(iC5), b(iC6));
    }

    public /* synthetic */ C5696b(int i10) {
        this.value = i10;
    }

    public static final /* synthetic */ C5696b b(int i10) {
        return new C5696b(i10);
    }

    public static int c(int i10) {
        return i10;
    }

    public static boolean d(int i10, Object obj) {
        return (obj instanceof C5696b) && i10 == ((C5696b) obj).getValue();
    }

    public static int e(int i10) {
        return Integer.hashCode(i10);
    }

    public static final boolean f(int i10) {
        return i10 == 3 || i10 == 4;
    }

    public static final boolean g(int i10) {
        return i10 != 0;
    }

    public static String h(int i10) {
        return "AfMode(value=" + i10 + ')';
    }

    public boolean equals(Object obj) {
        return d(this.value, obj);
    }

    public int hashCode() {
        return e(this.value);
    }

    /* renamed from: i, reason: from getter */
    public final /* synthetic */ int getValue() {
        return this.value;
    }

    public String toString() {
        return h(this.value);
    }
}
