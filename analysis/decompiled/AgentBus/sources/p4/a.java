package p4;

import k5.t;
import q7.k;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final f5.b f8402a;

    /* renamed from: b, reason: collision with root package name */
    public final t f8403b;

    /* renamed from: c, reason: collision with root package name */
    public final String f8404c;

    public a(f5.b bVar, t tVar, int i2) {
        switch (i2) {
            case 1:
                k.e(tVar, "logger");
                this.f8402a = bVar;
                this.f8403b = tVar;
                this.f8404c = "OpenClawAtt(out)";
                break;
            default:
                k.e(tVar, "logger");
                this.f8402a = bVar;
                this.f8403b = tVar;
                this.f8404c = "OpenClawAtt(in)";
                break;
        }
    }
}
