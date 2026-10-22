package androidx.core.app;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class E implements Iterable {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f3273a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final Context f3274b;

    public E(Context context) {
        this.f3274b = context;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.f3273a.iterator();
    }
}
