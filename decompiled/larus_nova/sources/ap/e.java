package ap;

import android.R;
import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class e extends FrameLayout implements Checkable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f15832b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f15833a;

    public static final class a {
    }

    public final View getTagView() {
        return getChildAt(0);
    }

    static {
        f15832b = new int[]{R.attr.state_checked};
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.f15833a);
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f15833a;
    }

    public e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int r100) {
        int[] r101 = super.onCreateDrawableState(r100 + 1);
        if (this.f15833a == false) goto L5;
        FrameLayout.mergeDrawableStates(r101, f15832b);
    L5:
        return r101;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r100) {
        if (this.f15833a == r100) goto L6;
        this.f15833a = r100;
        refreshDrawableState();
        return;
    }
}
