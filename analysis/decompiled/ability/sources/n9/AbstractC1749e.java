package n9;

import m9.AbstractC1729v;
import m9.InterfaceC1688F;
import s9.AbstractC1921a;
import s9.l;

/* renamed from: n9.e, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1749e extends AbstractC1729v implements InterfaceC1688F {
    @Override // m9.AbstractC1729v
    public AbstractC1729v limitedParallelism(int i, String str) {
        AbstractC1921a.a(i);
        return str != null ? new l(this, str) : this;
    }
}
