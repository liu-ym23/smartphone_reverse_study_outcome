package androidx.viewpager2.adapter;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes17.dex */
public final class FragmentViewHolder extends RecyclerView.ViewHolder {
    public FrameLayout getContainer() {
        return (FrameLayout) this.itemView;
    }

    private FragmentViewHolder(FrameLayout r100) {
        super(r100);
    }

    public static FragmentViewHolder create(ViewGroup r100) {
        FrameLayout r101 = new FrameLayout(r100.getContext());
        r101.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r101.setId(ViewCompat.generateViewId());
        r101.setSaveEnabled(false);
        return new FragmentViewHolder(r101);
    }
}
