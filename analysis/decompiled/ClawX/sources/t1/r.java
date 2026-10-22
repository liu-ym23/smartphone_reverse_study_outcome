package t1;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class r extends v {

    /* renamed from: a, reason: collision with root package name */
    public final t f5531a;

    /* renamed from: b, reason: collision with root package name */
    public final float f5532b;

    /* renamed from: c, reason: collision with root package name */
    public final float f5533c;

    public r(t tVar, float f3, float f7) {
        this.f5531a = tVar;
        this.f5532b = f3;
        this.f5533c = f7;
    }

    public final float a() {
        t tVar = this.f5531a;
        return (float) Math.toDegrees(Math.atan((tVar.f5541c - this.f5533c) / (tVar.f5540b - this.f5532b)));
    }
}
