package c5;

import java.util.Iterator;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class x implements Iterable, q5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1097a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f1098b;

    public /* synthetic */ x(int i8, Object obj) {
        this.f1097a = i8;
        this.f1098b = obj;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        switch (this.f1097a) {
            case 0:
                return new y((Iterator) ((p5.a) this.f1098b).invoke());
            default:
                return new x5.b((x5.c) this.f1098b);
        }
    }
}
