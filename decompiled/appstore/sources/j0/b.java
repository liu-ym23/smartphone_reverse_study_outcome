package j0;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public final class b extends RecyclerView.ViewHolder {
    public b(FrameLayout r10) {
        super(r10);
    }

    public static b a(ViewGroup r10) {
        FrameLayout r11 = new FrameLayout(r10.getContext());
        r11.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r11.setId(ViewCompat.k());
        r11.setSaveEnabled(false);
        return new b(r11);
    }

    public FrameLayout b() {
        return (FrameLayout) this.itemView;
    }
}
