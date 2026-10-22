package com.bytedance.android.shopping.store.slicecard.view;

import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f186361a = null;

    static {
        f186361a = new f(CollectionsKt.emptyList(), 0.0f);
    }

    public static final boolean a(h r100) {
        if ((r100 instanceof h.a) == false) goto L6;
    L9:
        return true;
    L6:
        if ((r100 instanceof h.b) == false) goto L13;
        if (StringsKt.isBlank(((h.b) r100).f186406a) == false) goto L9;
        return false;
    L13:
        throw new NoWhenBranchMatchedException();
    }

    public static final float b(h r100, float r101) {
        if ((r100 instanceof h.a) == false) goto L6;
        return ((h.a) r100).f186402d;
    L6:
        if ((r100 instanceof h.b) == false) goto L12;
        Float r102 = ((h.b) r100).f186411f;
        if (r102 != null) goto L10;
        return r101;
    L10:
        return r102.floatValue();
    L12:
        throw new NoWhenBranchMatchedException();
    }
}
