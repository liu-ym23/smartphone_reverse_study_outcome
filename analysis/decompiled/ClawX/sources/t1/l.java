package t1;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class l extends k4.v {
    @Override // k4.v
    public final void E(w wVar, float f3, float f7) {
        float f9 = f7 * f3;
        wVar.d(f9, 180.0f, 90.0f);
        float f10 = f9 * 2.0f;
        s sVar = new s(0.0f, 0.0f, f10, f10);
        sVar.f5538f = 180.0f;
        sVar.f5539g = 90.0f;
        wVar.f5547f.add(sVar);
        q qVar = new q(sVar);
        wVar.a(180.0f);
        wVar.f5548g.add(qVar);
        wVar.d = 270.0f;
        float f11 = (0.0f + f10) * 0.5f;
        float f12 = (f10 - 0.0f) / 2.0f;
        double d = 270.0f;
        wVar.f5544b = (((float) Math.cos(Math.toRadians(d))) * f12) + f11;
        wVar.f5545c = (f12 * ((float) Math.sin(Math.toRadians(d)))) + f11;
    }
}
