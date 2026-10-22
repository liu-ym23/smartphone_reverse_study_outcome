package Fa;

import Fa.AbstractC0821a;
import s9.InterfaceC5452d;
import w9.InterfaceC5752k;

/* loaded from: classes5.dex */
public final class n<K, V, T extends V> extends AbstractC0821a.AbstractC0033a<K, V, T> implements InterfaceC5452d<AbstractC0821a<K, V>, V> {
    public n(int i10) {
        super(i10);
    }

    @Override // s9.InterfaceC5452d
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public T getValue(AbstractC0821a<K, V> thisRef, InterfaceC5752k<?> property) {
        kotlin.jvm.internal.p.i(thisRef, "thisRef");
        kotlin.jvm.internal.p.i(property, "property");
        return a(thisRef);
    }
}
