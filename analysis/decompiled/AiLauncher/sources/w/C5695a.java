package w;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0087@\u0018\u0000 \u00142\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u001a\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\u0015"}, d2 = {"Lw/a;", "", "", UxipConstants.f30680s, "e", "(I)I", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(I)Z", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(I)Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "other", "f", "(ILjava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "I", "getValue", "()I", Const.INTENT_KEY_PKGNAME, "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: w.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5695a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    public static final int f42949c;

    /* renamed from: d, reason: collision with root package name */
    public static final int f42950d;

    /* renamed from: e, reason: collision with root package name */
    public static final int f42951e;

    /* renamed from: f, reason: collision with root package name */
    public static final int f42952f;

    /* renamed from: g, reason: collision with root package name */
    public static final int f42953g;

    /* renamed from: h, reason: collision with root package name */
    public static final int f42954h;

    /* renamed from: i, reason: collision with root package name */
    public static final int f42955i;

    /* renamed from: j, reason: collision with root package name */
    public static final List<C5695a> f42956j;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final int value;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lw/a$a;", "", "<init>", "()V", "", UxipConstants.f30680s, "Lw/a;", Const.INTENT_KEY_APIKEY, "(I)Lw/a;", "OFF", "I", Const.INTENT_KEY_PKGNAME, "()I", "ON", "c", "", "values", "Ljava/util/List;", Const.INTENT_KEY_UMID, "()Ljava/util/List;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: w.a$a, reason: collision with other inner class name and from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final C5695a a(int value) {
            Object next;
            Iterator<T> it = d().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((C5695a) next).getValue() == value) {
                    break;
                }
            }
            return (C5695a) next;
        }

        public final int b() {
            return C5695a.f42949c;
        }

        public final int c() {
            return C5695a.f42950d;
        }

        public final List<C5695a> d() {
            return C5695a.f42956j;
        }

        public Companion() {
        }
    }

    static {
        int iE = e(0);
        f42949c = iE;
        int iE2 = e(1);
        f42950d = iE2;
        int iE3 = e(3);
        f42951e = iE3;
        int iE4 = e(2);
        f42952f = iE4;
        int iE5 = e(4);
        f42953g = iE5;
        int iE6 = e(5);
        f42954h = iE6;
        int iE7 = e(6);
        f42955i = iE7;
        f42956j = C1173v.p(d(iE), d(iE2), d(iE4), d(iE3), d(iE5), d(iE6), d(iE7));
    }

    public /* synthetic */ C5695a(int i10) {
        this.value = i10;
    }

    public static final /* synthetic */ C5695a d(int i10) {
        return new C5695a(i10);
    }

    public static int e(int i10) {
        return i10;
    }

    public static boolean f(int i10, Object obj) {
        return (obj instanceof C5695a) && i10 == ((C5695a) obj).getValue();
    }

    public static final boolean g(int i10, int i11) {
        return i10 == i11;
    }

    public static int h(int i10) {
        return Integer.hashCode(i10);
    }

    public static final boolean i(int i10) {
        return i10 != 0;
    }

    public static String j(int i10) {
        return "AeMode(value=" + i10 + ')';
    }

    public boolean equals(Object obj) {
        return f(this.value, obj);
    }

    public int hashCode() {
        return h(this.value);
    }

    /* renamed from: k, reason: from getter */
    public final /* synthetic */ int getValue() {
        return this.value;
    }

    public String toString() {
        return j(this.value);
    }
}
