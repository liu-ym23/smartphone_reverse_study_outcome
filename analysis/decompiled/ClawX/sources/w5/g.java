package w5;

import java.util.Iterator;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class g implements i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6212a;

    /* renamed from: b, reason: collision with root package name */
    public final i f6213b;

    /* renamed from: c, reason: collision with root package name */
    public final p5.l f6214c;

    public /* synthetic */ g(i iVar, p5.l lVar, int i8) {
        this.f6212a = i8;
        this.f6213b = iVar;
        this.f6214c = lVar;
    }

    @Override // w5.i
    public final Iterator iterator() {
        switch (this.f6212a) {
            case 0:
                return new f(this);
            case 1:
                return new r4.f(this);
            default:
                return new f(this, (byte) 0);
        }
    }

    public g(c5.k kVar, c5.a aVar) {
        this.f6212a = 2;
        l lVar = l.f6221a;
        this.f6213b = kVar;
        this.f6214c = aVar;
    }
}
