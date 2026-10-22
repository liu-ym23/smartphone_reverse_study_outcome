package android.view;

import C7.c;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0004"}, d2 = {"findViewTreeLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "view", "Landroid/view/View;", "lifecycle-runtime_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ViewKt {
    @c
    public static final /* synthetic */ LifecycleOwner findViewTreeLifecycleOwner(View view) {
        k.f(view, "view");
        return C0764ViewTreeLifecycleOwner.get(view);
    }
}
