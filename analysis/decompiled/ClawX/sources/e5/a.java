package e5;

import java.util.Comparator;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a implements Comparator {

    /* renamed from: b, reason: collision with root package name */
    public static final a f2366b = new a(0);

    /* renamed from: c, reason: collision with root package name */
    public static final a f2367c = new a(1);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2368a;

    public /* synthetic */ a(int i8) {
        this.f2368a = i8;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f2368a) {
            case 0:
                Comparable a9 = (Comparable) obj;
                Comparable b9 = (Comparable) obj2;
                p.e(a9, "a");
                p.e(b9, "b");
                return a9.compareTo(b9);
            default:
                Comparable a10 = (Comparable) obj;
                Comparable b10 = (Comparable) obj2;
                p.e(a10, "a");
                p.e(b10, "b");
                return b10.compareTo(a10);
        }
    }

    @Override // java.util.Comparator
    public final Comparator reversed() {
        switch (this.f2368a) {
            case 0:
                return f2367c;
            default:
                return f2366b;
        }
    }
}
