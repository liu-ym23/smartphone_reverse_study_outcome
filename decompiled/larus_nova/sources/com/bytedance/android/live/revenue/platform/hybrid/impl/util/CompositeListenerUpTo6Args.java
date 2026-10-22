package com.bytedance.android.live.revenue.platform.hybrid.impl.util;

import java.util.ArrayList;
import kotlin.Function;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes47.dex */
public final class CompositeListenerUpTo6Args<R, F extends Function<? extends R>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<F> f91478a;

    public final void b() {
        if (this.f91478a.isEmpty() == false) goto L5;
        return;
    L5:
        SequencesKt.count(d(null));
    }

    public CompositeListenerUpTo6Args() {
        this.f91478a = new ArrayList(0);
    }

    public final void a(F r100) {
        Intrinsics.checkNotNullParameter(r100, "function");
        this.f91478a.add(r100);
    }

    public final void c(Object... r100) {
        Intrinsics.checkNotNullParameter(r100, "args");
        if (this.f91478a.isEmpty() == false) goto L5;
        return;
    L5:
        SequencesKt.count(d(r100));
    }

    public final Sequence<R> d(final Object[] r100) {
        final int r101 = TypeIntrinsics.getFunctionArity(CollectionsKt.first(this.f91478a));
        boolean r102 = true;
        if (r101 != 0) goto L21;
        if (r100 != null) goto L6;
    L12:
        if (r102 == true) goto L20;
        StringBuilder r103 = new StringBuilder("function requires 0 params, but received ");
        if (r100 == null) goto L16;
        Integer r104 = Integer.valueOf(r100.length);
    L17:
        r103.append(r104);
        throw new IllegalArgumentException(r103.toString().toString());
    L16:
        r104 = null;
        goto L17
    L20:
        return SequencesKt.map(CollectionsKt.asSequence(this.f91478a), CompositeListenerUpTo6Args$transformFunctionCalls$2.INSTANCE);
    L6:
        if (r100.length != 0) goto L8;
        boolean r105 = true;
    L9:
        if (r105 == true) goto L12;
        r102 = false;
        goto L12
    L8:
        r105 = false;
        goto L9
    L21:
        if (r100 == null) goto L23;
        boolean r106 = true;
    L24:
        if (r106 == false) goto L44;
        if (r100.length == r101) goto L29;
        r102 = false;
    L29:
        if (r102 == false) goto L42;
        Sequence r107 = CollectionsKt.asSequence(this.f91478a);
        switch(r101) {
            case 1: goto L40;
            case 2: goto L49;
            case 3: goto L48;
            case 4: goto L47;
            case 5: goto L46;
            case 6: goto L45;
            default: goto L33;
        };
    L33:
        throw new IllegalStateException(("Failed to transform function call typed: " + ((Function) CollectionsKt.first(this.f91478a)).getClass()).toString());
    L45:
        return SequencesKt.map(r107, new CompositeListenerUpTo6Args$transformFunctionCalls$$inlined$run$lambda$6(this, r101, r100));
    L46:
        return SequencesKt.map(r107, new CompositeListenerUpTo6Args$transformFunctionCalls$$inlined$run$lambda$5(this, r101, r100));
    L47:
        return SequencesKt.map(r107, new CompositeListenerUpTo6Args$transformFunctionCalls$$inlined$run$lambda$4(this, r101, r100));
    L48:
        return SequencesKt.map(r107, new CompositeListenerUpTo6Args$transformFunctionCalls$$inlined$run$lambda$3(this, r101, r100));
    L49:
        return SequencesKt.map(r107, new CompositeListenerUpTo6Args$transformFunctionCalls$$inlined$run$lambda$2(this, r101, r100));
    L40:
        return SequencesKt.map(r107, new CompositeListenerUpTo6Args$transformFunctionCalls$$inlined$run$lambda$1(this, r101, r100));
    L42:
        throw new IllegalArgumentException(("function requires " + r101 + " params, but received " + r100.length).toString());
    L44:
        throw new IllegalArgumentException(("received null for args, but need " + r101).toString());
    L23:
        r106 = false;
        goto L24
    }
}
