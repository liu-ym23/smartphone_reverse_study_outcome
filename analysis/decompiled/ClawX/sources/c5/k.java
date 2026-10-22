package c5;

import java.util.Iterator;
import kotlin.jvm.internal.d0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class k implements w5.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1089a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f1090b;

    public /* synthetic */ k(int i8, Object obj) {
        this.f1089a = i8;
        this.f1090b = obj;
    }

    @Override // w5.i
    public final Iterator iterator() {
        switch (this.f1089a) {
            case 0:
                return d0.c((Object[]) this.f1090b);
            case 1:
                return ((Iterable) this.f1090b).iterator();
            case 2:
                return new m5.m(this);
            case 3:
                return new w5.h(this);
            case 4:
                return (Iterator) this.f1090b;
            default:
                return new x5.f((CharSequence) this.f1090b);
        }
    }

    public k(com.stepos.stepclaw.memory.lightmem.f fVar) {
        this.f1089a = 3;
        x5.k kVar = x5.k.f6300a;
        this.f1090b = fVar;
    }
}
