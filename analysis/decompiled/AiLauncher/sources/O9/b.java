package O9;

import ea.C4018b;
import h9.InterfaceC4149a;
import java.lang.Enum;
import java.util.List;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.protobuf.f;
import w9.InterfaceC5751j;
import w9.InterfaceC5752k;

/* loaded from: classes5.dex */
public final class b<Node, E extends Enum<E>> {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC5751j<Node, Integer> f5286a;

    /* renamed from: b, reason: collision with root package name */
    public final C4018b.d<? extends f.a> f5287b;

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC4149a<E> f5288c;

    /* renamed from: d, reason: collision with root package name */
    public final List<c> f5289d;

    public b(InterfaceC5751j<Node, Integer> flags, C4018b.d<? extends f.a> protoSet, InterfaceC4149a<E> entries, List<c> flagValues) {
        p.i(flags, "flags");
        p.i(protoSet, "protoSet");
        p.i(entries, "entries");
        p.i(flagValues, "flagValues");
        this.f5286a = flags;
        this.f5287b = protoSet;
        this.f5288c = entries;
        this.f5289d = flagValues;
    }

    public final E a(Node node, InterfaceC5752k<?> property) {
        p.i(property, "property");
        return this.f5288c.get(this.f5287b.d(this.f5286a.get(node).intValue()).getNumber());
    }
}
