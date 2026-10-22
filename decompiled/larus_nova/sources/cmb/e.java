package cmb;

import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class e implements Function1<ViewGroup, View> {
    public e() {
    }

    @Override // kotlin.jvm.functions.Function1
    public final View invoke(ViewGroup r100) {
        ViewGroup r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "contentView");
        return r101;
    }
}
