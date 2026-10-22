package androidx.activity;

import android.window.BackEvent;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: e, reason: collision with root package name */
    public static final a f7343e = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final float f7344a;

    /* renamed from: b, reason: collision with root package name */
    private final float f7345b;

    /* renamed from: c, reason: collision with root package name */
    private final float f7346c;

    /* renamed from: d, reason: collision with root package name */
    private final int f7347d;

    public static final class a {
        public /* synthetic */ a(j4.g gVar) {
            this();
        }

        private a() {
        }
    }

    public b(float f5, float f6, float f7, int i5) {
        this.f7344a = f5;
        this.f7345b = f6;
        this.f7346c = f7;
        this.f7347d = i5;
    }

    public String toString() {
        return "BackEventCompat{touchX=" + this.f7344a + ", touchY=" + this.f7345b + ", progress=" + this.f7346c + ", swipeEdge=" + this.f7347d + '}';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public b(BackEvent backEvent) {
        j4.k.g(backEvent, "backEvent");
        androidx.activity.a aVar = androidx.activity.a.f7342a;
        this(aVar.d(backEvent), aVar.e(backEvent), aVar.b(backEvent), aVar.c(backEvent));
    }
}
