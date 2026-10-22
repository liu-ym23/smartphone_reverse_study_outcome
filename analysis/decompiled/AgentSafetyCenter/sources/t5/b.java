package t5;

import ad.y;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final List f13173a;

    /* renamed from: b, reason: collision with root package name */
    public final List f13174b;

    /* renamed from: c, reason: collision with root package name */
    public final List f13175c;

    /* renamed from: d, reason: collision with root package name */
    public final List f13176d;

    /* renamed from: e, reason: collision with root package name */
    public final List f13177e;

    public b(List list, List list2, List list3, List list4, List list5) {
        this.f13173a = list;
        this.f13174b = list2;
        this.f13175c = list3;
        this.f13176d = list4;
        this.f13177e = list5;
    }

    public final y a() {
        y yVar = new y();
        List list = this.f13173a;
        list.getClass();
        yVar.f631a = new ArrayList(list);
        List list2 = this.f13174b;
        list2.getClass();
        yVar.f632b = new ArrayList(list2);
        List list3 = this.f13175c;
        list3.getClass();
        yVar.f633c = new ArrayList(list3);
        List list4 = this.f13176d;
        list4.getClass();
        yVar.f634d = new ArrayList(list4);
        List list5 = this.f13177e;
        list5.getClass();
        yVar.f635e = new ArrayList(list5);
        VarHandle.storeStoreFence();
        return yVar;
    }
}
