package Fa;

import java.util.Iterator;
import q9.InterfaceC5162a;

/* loaded from: classes5.dex */
public abstract class c<T> implements Iterable<T>, InterfaceC5162a {
    public /* synthetic */ c(kotlin.jvm.internal.i iVar) {
        this();
    }

    public abstract int b();

    public abstract void c(int i10, T t10);

    public abstract T get(int i10);

    @Override // java.lang.Iterable
    public abstract Iterator<T> iterator();

    public c() {
    }
}
