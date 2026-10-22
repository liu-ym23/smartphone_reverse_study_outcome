package D7;

import java.util.AbstractCollection;
import java.util.Collection;

/* renamed from: D7.i, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC0217i extends AbstractCollection implements Collection, T7.b {
    public abstract int getSize();

    @Override // java.util.AbstractCollection, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }
}
