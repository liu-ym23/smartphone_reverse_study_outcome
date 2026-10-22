package com.bytedance.android.ec.window.base.utils.quick;

import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a<S extends QModel, T extends QModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final QIPresenter f49762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<S, T> f49763b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f49762a, r101.f49762a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f49763b, r101.f49763b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        QIPresenter r100 = this.f49762a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Function1<S, T> r104 = this.f49763b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ECGroupElement(presenter=" + this.f49762a + ", transformer=" + this.f49763b + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(QIPresenter r100, Function1<? super S, ? extends T> r101) {
        Intrinsics.checkNotNullParameter(r100, "presenter");
        Intrinsics.checkNotNullParameter(r101, "transformer");
        this.f49762a = r100;
        this.f49763b = r101;
    }
}
