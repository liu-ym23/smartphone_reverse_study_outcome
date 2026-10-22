package androidx.slidingpanelayout.widget;

import android.app.Activity;
import androidx.window.layout.DisplayFeature;
import androidx.window.layout.FoldingFeature;
import androidx.window.layout.WindowInfoTracker;
import androidx.window.layout.i;
import java.util.Iterator;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.h;
import kotlinx.coroutines.x0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class FoldingFeatureObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WindowInfoTracker f4737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f4738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Job f4739c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public OnFoldingFeatureChangeListener f4740d;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Landroidx/slidingpanelayout/widget/FoldingFeatureObserver$OnFoldingFeatureChangeListener;", "", "onFoldingFeatureChange", "", "foldingFeature", "Landroidx/window/layout/FoldingFeature;", "slidingpanelayout_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnFoldingFeatureChangeListener {
        void onFoldingFeatureChange(@NotNull FoldingFeature r10);
    }

    public FoldingFeatureObserver(WindowInfoTracker r10, Executor r11) {
        q.g(r10, "windowInfoTracker");
        q.g(r11, "executor");
        this.f4737a = r10;
        this.f4738b = r11;
    }

    public static final /* synthetic */ FoldingFeature a(FoldingFeatureObserver r10, i r11) {
        return r10.d(r11);
    }

    public static final /* synthetic */ OnFoldingFeatureChangeListener b(FoldingFeatureObserver r10) {
        return r10.f4740d;
    }

    public static final /* synthetic */ WindowInfoTracker c(FoldingFeatureObserver r10) {
        return r10.f4737a;
    }

    public final FoldingFeature d(i r10) {
        Iterator r11 = r10.a().iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        Object r12 = r11.next();
        if ((((DisplayFeature) r12) instanceof FoldingFeature) == false) goto L4;
    L10:
        if ((r12 instanceof FoldingFeature) == true) goto L12;
        return null;
    L12:
        return (FoldingFeature) r12;
    L8:
        r12 = null;
        goto L10
    }

    public final void e(Activity r10) {
        q.g(r10, "activity");
        Job r11 = this.f4739c;
        if (r11 == null) goto L6;
        Job.a.b(r11, null, 1, null);
    L6:
        this.f4739c = h.d(d0.a(x0.a(this.f4738b)), null, null, new FoldingFeatureObserver$registerLayoutStateChangeCallback$1(this, r10, null), 3, null);
    }

    public final void f() {
        Job r10 = this.f4739c;
        if (r10 == null) goto L7;
        Job.a.b(r10, null, 1, null);
        return;
    }

    public final void setOnFoldingFeatureChangeListener(@NotNull OnFoldingFeatureChangeListener r10) {
        q.g(r10, "onFoldingFeatureChangeListener");
        this.f4740d = r10;
    }
}
