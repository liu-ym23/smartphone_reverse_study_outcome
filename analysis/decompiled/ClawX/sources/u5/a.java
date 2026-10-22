package u5;

import java.util.Iterator;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class a implements Iterable, q5.a {

    /* renamed from: a, reason: collision with root package name */
    public final char f5657a;

    /* renamed from: b, reason: collision with root package name */
    public final char f5658b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5659c = 1;

    public a(char c3, char c8) {
        this.f5657a = c3;
        this.f5658b = (char) a.a.J(c3, c8, 1);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new b(this.f5657a, this.f5658b, this.f5659c);
    }
}
