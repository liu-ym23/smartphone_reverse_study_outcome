package hb;

import java.io.IOException;
import java.util.List;

/* loaded from: classes.dex */
public final class m extends db.a {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f4304e = 1;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ p f4305f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f4306g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ List f4307h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(String str, p pVar, int i2, List list) {
        super(str, true);
        this.f4305f = pVar;
        this.f4306g = i2;
        this.f4307h = list;
    }

    @Override // db.a
    public final long a() {
        switch (this.f4304e) {
            case 0:
                this.f4305f.f4324p.getClass();
                try {
                    this.f4305f.C.k(this.f4306g, 9);
                    synchronized (this.f4305f) {
                        this.f4305f.E.remove(Integer.valueOf(this.f4306g));
                    }
                    return -1L;
                } catch (IOException unused) {
                    return -1L;
                }
            default:
                this.f4305f.f4324p.getClass();
                try {
                    this.f4305f.C.k(this.f4306g, 9);
                    synchronized (this.f4305f) {
                        this.f4305f.E.remove(Integer.valueOf(this.f4306g));
                    }
                    return -1L;
                } catch (IOException unused2) {
                    return -1L;
                }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(String str, p pVar, int i2, List list, boolean z4) {
        super(str, true);
        this.f4305f = pVar;
        this.f4306g = i2;
        this.f4307h = list;
    }
}
