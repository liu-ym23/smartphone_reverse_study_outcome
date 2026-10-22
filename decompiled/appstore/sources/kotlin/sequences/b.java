package kotlin.sequences;

import java.util.Iterator;
import kotlin.collections.d0;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements Sequence, DropTakeSequence {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f21208a = null;

    static {
        f21208a = new b();
    }

    public b() {
    }

    public b a(int r10) {
        return f21208a;
    }

    public b b(int r10) {
        return f21208a;
    }

    @Override // kotlin.sequences.DropTakeSequence
    public /* bridge */ /* synthetic */ Sequence drop(int r10) {
        return a(r10);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator iterator() {
        return d0.f21090a;
    }

    @Override // kotlin.sequences.DropTakeSequence
    public /* bridge */ /* synthetic */ Sequence take(int r10) {
        return b(r10);
    }
}
