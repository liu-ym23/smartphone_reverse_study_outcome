package kotlin.sequences;

import Ka.j;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

/* JADX INFO: Add missing generic type declarations: [R] */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* synthetic */ class SequencesKt___SequencesKt$flatMap$2<R> extends FunctionReferenceImpl implements InterfaceC5074l<j<? extends R>, Iterator<? extends R>> {

    /* renamed from: a, reason: collision with root package name */
    public static final SequencesKt___SequencesKt$flatMap$2 f36173a = new SequencesKt___SequencesKt$flatMap$2();

    public SequencesKt___SequencesKt$flatMap$2() {
        super(1, j.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
    }

    @Override // p9.InterfaceC5074l
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public final Iterator<R> invoke(j<? extends R> p02) {
        p.i(p02, "p0");
        return p02.iterator();
    }
}
