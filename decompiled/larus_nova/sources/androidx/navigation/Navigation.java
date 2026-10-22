package androidx.navigation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.core.app.ActivityCompat;
import com.larus.nova.R;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u001e\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\u0007J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\bH\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\fH\u0007¨\u0006\u0017"}, d2 = {"Landroidx/navigation/Navigation;", "", "()V", "createNavigateOnClickListener", "Landroid/view/View$OnClickListener;", "directions", "Landroidx/navigation/NavDirections;", "resId", "", "args", "Landroid/os/Bundle;", "findNavController", "Landroidx/navigation/NavController;", "activity", "Landroid/app/Activity;", "viewId", "view", "Landroid/view/View;", "findViewNavController", "getViewNavController", "setViewNavController", "", "controller", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Navigation {
    public static final Navigation INSTANCE = null;

    static {
        INSTANCE = new Navigation();
    }

    private Navigation() {
    }

    public static /* synthetic */ void a(NavDirections r100, View r101) {
        m7819createNavigateOnClickListener$lambda1(r100, r101);
    }

    public static /* synthetic */ void b(int r100, Bundle r101, View r102) {
        m7818createNavigateOnClickListener$lambda0(r100, r101, r102);
    }

    @JvmStatic
    public static final View.OnClickListener createNavigateOnClickListener(int r100) {
        return createNavigateOnClickListener$default(r100, null, 2, null);
    }

    @JvmStatic
    public static final View.OnClickListener createNavigateOnClickListener(final NavDirections r100) {
        Intrinsics.checkNotNullParameter(r100, "directions");
        return new b(r100);
    }

    @JvmStatic
    public static final NavController findNavController(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        NavController r101 = INSTANCE.findViewNavController(r100);
        if (r101 == null) goto L6;
        return r101;
    L6:
        throw new IllegalStateException("View " + r100 + " does not have a NavController set");
    }

    private final NavController findViewNavController(View r100) {
        return (NavController) SequencesKt.firstOrNull(SequencesKt.mapNotNull(SequencesKt.generateSequence(r100, AnonymousClass1.INSTANCE), AnonymousClass2.INSTANCE));
    }

    private final NavController getViewNavController(View r100) {
        Object r101 = r100.getTag(R.id.nav_controller_view_tag);
        if ((r101 instanceof WeakReference) == false) goto L6;
        return (NavController) ((WeakReference) r101).get();
    L6:
        if ((r101 instanceof NavController) == true) goto L11;
        return null;
    L11:
        return (NavController) r101;
    }

    public static final /* synthetic */ NavController access$getViewNavController(Navigation r100, View r101) {
        return r100.getViewNavController(r101);
    }

    @JvmStatic
    public static final View.OnClickListener createNavigateOnClickListener(final int r100, final Bundle r101) {
        return new c(r100, r101);
    }

    /* JADX INFO: renamed from: createNavigateOnClickListener$lambda-1, reason: not valid java name */
    private static final void m7819createNavigateOnClickListener$lambda1(NavDirections r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "$directions");
        findNavController(r101).navigate(r100);
    }

    @JvmStatic
    public static final NavController findNavController(Activity r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        NavController r102 = INSTANCE.findViewNavController(ActivityCompat.requireViewById(r100, r101));
        if (r102 == null) goto L6;
        return r102;
    L6:
        throw new IllegalStateException("Activity " + r100 + " does not have a NavController set on " + r101);
    }

    @JvmStatic
    public static final void setViewNavController(View r100, NavController r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        r100.setTag(R.id.nav_controller_view_tag, r101);
    }

    /* JADX INFO: renamed from: createNavigateOnClickListener$lambda-0, reason: not valid java name */
    private static final void m7818createNavigateOnClickListener$lambda0(int r100, Bundle r101, View r102) {
        findNavController(r102).navigate(r100, r101);
    }

    public static /* synthetic */ View.OnClickListener createNavigateOnClickListener$default(int r100, Bundle r101, int r102, Object r103) {
        if ((r102 & 2) == 0) goto L6;
        r101 = null;
    L6:
        return createNavigateOnClickListener(r100, r101);
    }
}
