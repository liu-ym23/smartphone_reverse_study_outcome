package fd;

import android.graphics.Bitmap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f19650d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static b f19651e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f19652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f19653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bitmap[] f19654c;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final b a(String r10) {
            q.g(r10, "letter");
            return new b(0, r10, null, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final b b(String r10) {
            q.g(r10, "letter");
            return new b(1, r10, null, 0 == true ? 1 : 0);
        }

        public final b c(String r10, Bitmap[] r11) {
            q.g(r10, "symbol");
            q.g(r11, "letterBitmaps");
            return new b(2, r10, r11, null);
        }

        public final b d() {
            return b.a();
        }

        public a() {
        }
    }

    static {
        a r10 = new a(null);
        f19650d = r10;
        f19651e = r10.a("#");
    }

    public /* synthetic */ b(int r10, String r11, Bitmap[] r12, DefaultConstructorMarker r13) {
        this(r10, r11, r12);
    }

    public static final /* synthetic */ b a() {
        return f19651e;
    }

    public final String b() {
        return this.f19653b;
    }

    public final Bitmap[] c() {
        return this.f19654c;
    }

    public final int d() {
        return this.f19652a;
    }

    public b(int r10, String r11, Bitmap[] r12) {
        this.f19652a = r10;
        this.f19653b = r11;
        this.f19654c = r12;
        if (r10 != 2) goto L15;
        boolean r13 = false;
        if (r12 != null) goto L7;
        int r14 = 0;
    L9:
        if (r14 != 3) goto L11;
        r13 = true;
    L11:
        if (r13 == false) goto L14;
        this.f19654c = r12;
        return;
    L14:
        throw new IllegalStateException("symbol must have 3 bitmaps!");
    L7:
        r14 = r12.length;
        goto L9
    }
}
