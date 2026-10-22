package r6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.ailauncher.task.R$id;
import com.stepos.ailauncher.task.R$layout;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class h {
    private final FrameLayout rootView;
    public final RecyclerView rvMemoryList;
    public final TextView tvEmpty;

    public h(FrameLayout frameLayout, RecyclerView recyclerView, TextView textView) {
        this.rootView = frameLayout;
        this.rvMemoryList = recyclerView;
        this.tvEmpty = textView;
    }

    public static h a(View view) {
        int i10 = R$id.rv_memory_list;
        RecyclerView recyclerView = (RecyclerView) C5437a.a(view, i10);
        if (recyclerView != null) {
            i10 = R$id.tv_empty;
            TextView textView = (TextView) C5437a.a(view, i10);
            if (textView != null) {
                return new h((FrameLayout) view, recyclerView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static h c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_memory_list, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public FrameLayout b() {
        return this.rootView;
    }
}
