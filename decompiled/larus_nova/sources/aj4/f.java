package aj4;

import com.bytedance.creativex.mediaimport.view.internal.base.BaseMediaSelectListView;
import com.bytedance.creativex.mediaimport.widget.HeaderSpacingItemDecoration;
import kotlin.jvm.internal.Intrinsics;
import ti4.y;

/* JADX INFO: loaded from: classes15.dex */
public final class f implements ti4.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BaseMediaSelectListView.b<?> f3905a;

    public f(BaseMediaSelectListView.b<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "viewConfigure");
        this.f3905a = r100;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [aj4.b] */
    /* JADX WARN: Type inference failed for: r4v0, types: [aj4.c] */
    /* JADX WARN: Type inference failed for: r5v0, types: [aj4.d] */
    /* JADX WARN: Type inference failed for: r6v0, types: [aj4.e] */
    @Override // ti4.d
    public final ti4.c a(ti4.c r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        if ((r100 instanceof y) == false) goto L5;
        y r101 = (y) r100;
    L6:
        y r102 = r101;
        if (r102 != null) goto L9;
        return r100;
    L9:
        return new HeaderSpacingItemDecoration(r102, new b(this), new c(this), new d(this), new e(this));
    L5:
        r101 = null;
        goto L6
    }
}
