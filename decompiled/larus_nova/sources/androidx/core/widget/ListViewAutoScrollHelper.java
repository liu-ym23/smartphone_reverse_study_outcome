package androidx.core.widget;

import android.widget.ListView;

/* JADX INFO: loaded from: classes17.dex */
public class ListViewAutoScrollHelper extends AutoScrollHelper {
    private final ListView mTarget;

    @Override // androidx.core.widget.AutoScrollHelper
    public boolean canTargetScrollHorizontally(int r100) {
        return false;
    }

    public ListViewAutoScrollHelper(ListView r100) {
        super(r100);
        this.mTarget = r100;
    }

    @Override // androidx.core.widget.AutoScrollHelper
    public boolean canTargetScrollVertically(int r100) {
        ListView r101 = this.mTarget;
        int r102 = r101.getCount();
        if (r102 != 0) goto L5;
        return false;
    L5:
        int r103 = r101.getChildCount();
        int r104 = r101.getFirstVisiblePosition();
        int r105 = r104 + r103;
        if (r100 <= 0) goto L11;
        if (r105 >= r102) goto L9;
    L16:
        return true;
    L9:
        if (r101.getChildAt(r103 - 1).getBottom() > r101.getHeight()) goto L16;
        return false;
    L11:
        if (r100 >= 0) goto L17;
        if (r104 > 0) goto L16;
        if (r101.getChildAt(0).getTop() < 0) goto L16;
        return false;
    L17:
        return false;
    }

    @Override // androidx.core.widget.AutoScrollHelper
    public void scrollTargetBy(int r100, int r101) {
        this.mTarget.scrollListBy(r101);
    }
}
