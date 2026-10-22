package p0;

import p.q;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l extends k {

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f9679h;

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f9679h) {
            case 0:
                int i = this.f9678g;
                this.f9678g = i + 2;
                Object[] objArr = this.f9676c;
                return new q(objArr[i], objArr[i + 1]);
            case 1:
                int i3 = this.f9678g;
                this.f9678g = i3 + 2;
                return this.f9676c[i3];
            default:
                int i10 = this.f9678g;
                this.f9678g = i10 + 2;
                return this.f9676c[i10 + 1];
        }
    }
}
