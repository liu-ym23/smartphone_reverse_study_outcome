package r;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a extends c {

    /* renamed from: h, reason: collision with root package name */
    public int f4903h;

    /* renamed from: j, reason: collision with root package name */
    public int f4904j;

    /* renamed from: k, reason: collision with root package name */
    public o.a f4905k;

    public boolean getAllowsGoneWidget() {
        return this.f4905k.f4185s0;
    }

    public int getMargin() {
        return this.f4905k.f4186t0;
    }

    public int getType() {
        return this.f4903h;
    }

    @Override // r.c
    public final void h(o.d dVar, boolean z) {
        int i8 = this.f4903h;
        this.f4904j = i8;
        if (z) {
            if (i8 == 5) {
                this.f4904j = 1;
            } else if (i8 == 6) {
                this.f4904j = 0;
            }
        } else if (i8 == 5) {
            this.f4904j = 0;
        } else if (i8 == 6) {
            this.f4904j = 1;
        }
        if (dVar instanceof o.a) {
            ((o.a) dVar).f4184r0 = this.f4904j;
        }
    }

    public void setAllowsGoneWidget(boolean z) {
        this.f4905k.f4185s0 = z;
    }

    public void setDpMargin(int i8) {
        this.f4905k.f4186t0 = (int) ((i8 * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void setMargin(int i8) {
        this.f4905k.f4186t0 = i8;
    }

    public void setType(int i8) {
        this.f4903h = i8;
    }
}
