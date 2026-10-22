package androidx.appcompat.widget;

/* loaded from: classes.dex */
public final class P0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2898a;

    /* renamed from: b, reason: collision with root package name */
    public int f2899b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f2900c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f2901d = Integer.MIN_VALUE;

    /* renamed from: e, reason: collision with root package name */
    public int f2902e = Integer.MIN_VALUE;

    /* renamed from: f, reason: collision with root package name */
    public int f2903f = 0;

    /* renamed from: g, reason: collision with root package name */
    public int f2904g = 0;

    /* renamed from: h, reason: collision with root package name */
    public boolean f2905h = false;

    /* renamed from: i, reason: collision with root package name */
    public boolean f2906i = false;

    public final void a(int i4, int i5) {
        switch (this.f2898a) {
            case 0:
                this.f2906i = false;
                if (i4 != Integer.MIN_VALUE) {
                    this.f2903f = i4;
                    this.f2899b = i4;
                }
                if (i5 != Integer.MIN_VALUE) {
                    this.f2904g = i5;
                    this.f2900c = i5;
                    break;
                }
                break;
            default:
                this.f2906i = false;
                if (i4 != Integer.MIN_VALUE) {
                    this.f2903f = i4;
                    this.f2899b = i4;
                }
                if (i5 != Integer.MIN_VALUE) {
                    this.f2904g = i5;
                    this.f2900c = i5;
                    break;
                }
                break;
        }
    }

    public final void b(boolean z4) {
        switch (this.f2898a) {
            case 0:
                if (z4 != this.f2905h) {
                    this.f2905h = z4;
                    if (!this.f2906i) {
                        this.f2899b = this.f2903f;
                        this.f2900c = this.f2904g;
                        break;
                    } else if (!z4) {
                        int i4 = this.f2901d;
                        if (i4 == Integer.MIN_VALUE) {
                            i4 = this.f2903f;
                        }
                        this.f2899b = i4;
                        int i5 = this.f2902e;
                        if (i5 == Integer.MIN_VALUE) {
                            i5 = this.f2904g;
                        }
                        this.f2900c = i5;
                        break;
                    } else {
                        int i6 = this.f2902e;
                        if (i6 == Integer.MIN_VALUE) {
                            i6 = this.f2903f;
                        }
                        this.f2899b = i6;
                        int i7 = this.f2901d;
                        if (i7 == Integer.MIN_VALUE) {
                            i7 = this.f2904g;
                        }
                        this.f2900c = i7;
                        break;
                    }
                }
                break;
            default:
                if (z4 != this.f2905h) {
                    this.f2905h = z4;
                    if (!this.f2906i) {
                        this.f2899b = this.f2903f;
                        this.f2900c = this.f2904g;
                        break;
                    } else if (!z4) {
                        int i8 = this.f2901d;
                        if (i8 == Integer.MIN_VALUE) {
                            i8 = this.f2903f;
                        }
                        this.f2899b = i8;
                        int i9 = this.f2902e;
                        if (i9 == Integer.MIN_VALUE) {
                            i9 = this.f2904g;
                        }
                        this.f2900c = i9;
                        break;
                    } else {
                        int i10 = this.f2902e;
                        if (i10 == Integer.MIN_VALUE) {
                            i10 = this.f2903f;
                        }
                        this.f2899b = i10;
                        int i11 = this.f2901d;
                        if (i11 == Integer.MIN_VALUE) {
                            i11 = this.f2904g;
                        }
                        this.f2900c = i11;
                        break;
                    }
                }
                break;
        }
    }

    public final void c(int i4, int i5) {
        switch (this.f2898a) {
            case 0:
                this.f2901d = i4;
                this.f2902e = i5;
                this.f2906i = true;
                if (!this.f2905h) {
                    if (i4 != Integer.MIN_VALUE) {
                        this.f2899b = i4;
                    }
                    if (i5 != Integer.MIN_VALUE) {
                        this.f2900c = i5;
                        break;
                    }
                } else {
                    if (i5 != Integer.MIN_VALUE) {
                        this.f2899b = i5;
                    }
                    if (i4 != Integer.MIN_VALUE) {
                        this.f2900c = i4;
                        break;
                    }
                }
                break;
            default:
                this.f2901d = i4;
                this.f2902e = i5;
                this.f2906i = true;
                if (!this.f2905h) {
                    if (i4 != Integer.MIN_VALUE) {
                        this.f2899b = i4;
                    }
                    if (i5 != Integer.MIN_VALUE) {
                        this.f2900c = i5;
                        break;
                    }
                } else {
                    if (i5 != Integer.MIN_VALUE) {
                        this.f2899b = i5;
                    }
                    if (i4 != Integer.MIN_VALUE) {
                        this.f2900c = i4;
                        break;
                    }
                }
                break;
        }
    }
}
