package bw7;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes23.dex */
public final class g {
    /* JADX WARN: Multi-variable type inference failed */
    public static View a(RecyclerView.ViewHolder r100) {
        if ((r100 instanceof f) == true) goto L5;
        return null;
    L5:
        return b((f) r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static View b(f r100) {
        if ((r100 instanceof RecyclerView.ViewHolder) == false) goto L9;
        ConstraintLayout r101 = r100.r1();
        if (r101 == ((RecyclerView.ViewHolder) r100).itemView) goto L8;
        return r101;
    L8:
        throw new IllegalStateException("Inconsistency detected! getSwipeableContainerView() returns itemView");
    L9:
        return null;
    }
}
