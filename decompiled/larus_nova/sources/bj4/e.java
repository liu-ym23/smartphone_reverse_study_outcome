package bj4;

import android.animation.TypeEvaluator;
import android.graphics.Rect;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class e implements TypeEvaluator<Rect> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f19214a;

    public e(Rect r100) {
        this.f19214a = r100;
    }

    public final Rect a(float r100, Rect r101, Rect r102) {
        Intrinsics.checkNotNull(r101);
        int r103 = r101.left;
        Intrinsics.checkNotNull(r102);
        int r104 = r103 + ((int) ((r102.left - r101.left) * r100));
        int r105 = r101.top;
        int r106 = r105 + ((int) ((r102.top - r105) * r100));
        int r107 = r101.right;
        int r108 = r107 + ((int) ((r102.right - r107) * r100));
        int r109 = r101.bottom;
        int r110 = r109 + ((int) ((r102.bottom - r109) * r100));
        Rect r111 = this.f19214a;
        if (r111 == null) goto L7;
        Intrinsics.checkNotNull(r111);
        r111.set(r104, r106, r108, r110);
        return this.f19214a;
    L7:
        return new Rect(r104, r106, r108, r110);
    }

    @Override // android.animation.TypeEvaluator
    public final /* bridge */ /* synthetic */ Rect evaluate(float r100, Rect r101, Rect r102) {
        return a(r100, r101, r102);
    }
}
