package androidx.appcompat.widget;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class p0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f909a;

    /* renamed from: b, reason: collision with root package name */
    public int f910b;

    /* renamed from: c, reason: collision with root package name */
    public int f911c;

    /* renamed from: d, reason: collision with root package name */
    public int f912d;

    /* renamed from: e, reason: collision with root package name */
    public int f913e;

    /* renamed from: f, reason: collision with root package name */
    public int f914f;

    /* renamed from: g, reason: collision with root package name */
    public int f915g;
    public boolean h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f916i;

    public final void a(int i10, int i11) {
        switch (this.f909a) {
            case 0:
                this.f912d = i10;
                this.f913e = i11;
                this.f916i = true;
                if (!this.h) {
                    if (i10 != Integer.MIN_VALUE) {
                        this.f910b = i10;
                    }
                    if (i11 != Integer.MIN_VALUE) {
                        this.f911c = i11;
                        break;
                    }
                } else {
                    if (i11 != Integer.MIN_VALUE) {
                        this.f910b = i11;
                    }
                    if (i10 != Integer.MIN_VALUE) {
                        this.f911c = i10;
                        break;
                    }
                }
                break;
            default:
                this.f912d = i10;
                this.f913e = i11;
                this.f916i = true;
                if (!this.h) {
                    if (i10 != Integer.MIN_VALUE) {
                        this.f910b = i10;
                    }
                    if (i11 != Integer.MIN_VALUE) {
                        this.f911c = i11;
                        break;
                    }
                } else {
                    if (i11 != Integer.MIN_VALUE) {
                        this.f910b = i11;
                    }
                    if (i10 != Integer.MIN_VALUE) {
                        this.f911c = i10;
                        break;
                    }
                }
                break;
        }
    }
}
