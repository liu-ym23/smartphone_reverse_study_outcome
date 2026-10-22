package w;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0087@\u0018\u0000 \u00142\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u001a\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\u0015"}, d2 = {"Lw/c;", "", "", UxipConstants.f30680s, "c", "(I)I", "", "f", "(I)Z", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "(I)Ljava/lang/String;", "e", "other", Const.INTENT_KEY_UMID, "(ILjava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "I", "getValue", "()I", Const.INTENT_KEY_PKGNAME, "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: w.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5697c {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    public static final int f42968c;

    /* renamed from: d, reason: collision with root package name */
    public static final int f42969d;

    /* renamed from: e, reason: collision with root package name */
    public static final int f42970e;

    /* renamed from: f, reason: collision with root package name */
    public static final int f42971f;

    /* renamed from: g, reason: collision with root package name */
    public static final int f42972g;

    /* renamed from: h, reason: collision with root package name */
    public static final int f42973h;

    /* renamed from: i, reason: collision with root package name */
    public static final int f42974i;

    /* renamed from: j, reason: collision with root package name */
    public static final int f42975j;

    /* renamed from: k, reason: collision with root package name */
    public static final List<C5697c> f42976k;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final int value;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bR\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lw/c$a;", "", "<init>", "()V", "", UxipConstants.f30680s, "Lw/c;", Const.INTENT_KEY_APIKEY, "(I)Lw/c;", "", "values", "Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "()Ljava/util/List;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: w.c$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final C5697c a(int value) {
            Object next;
            Iterator<T> it = b().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((C5697c) next).getValue() == value) {
                    break;
                }
            }
            return (C5697c) next;
        }

        public final List<C5697c> b() {
            return C5697c.f42976k;
        }

        public Companion() {
        }
    }

    static {
        int iC = c(0);
        f42968c = iC;
        int iC2 = c(1);
        f42969d = iC2;
        int iC3 = c(6);
        f42970e = iC3;
        int iC4 = c(5);
        f42971f = iC4;
        int iC5 = c(2);
        f42972g = iC5;
        int iC6 = c(3);
        f42973h = iC6;
        int iC7 = c(8);
        f42974i = iC7;
        int iC8 = c(7);
        f42975j = iC8;
        f42976k = C1173v.p(b(iC), b(iC2), b(iC3), b(iC4), b(iC5), b(iC6), b(iC7), b(iC8));
    }

    public /* synthetic */ C5697c(int i10) {
        this.value = i10;
    }

    public static final /* synthetic */ C5697c b(int i10) {
        return new C5697c(i10);
    }

    public static int c(int i10) {
        return i10;
    }

    public static boolean d(int i10, Object obj) {
        return (obj instanceof C5697c) && i10 == ((C5697c) obj).getValue();
    }

    public static int e(int i10) {
        return Integer.hashCode(i10);
    }

    public static final boolean f(int i10) {
        return i10 != 0;
    }

    public static String g(int i10) {
        return "AwbMode(value=" + i10 + ')';
    }

    public boolean equals(Object obj) {
        return d(this.value, obj);
    }

    /* renamed from: h, reason: from getter */
    public final /* synthetic */ int getValue() {
        return this.value;
    }

    public int hashCode() {
        return e(this.value);
    }

    public String toString() {
        return g(this.value);
    }
}
