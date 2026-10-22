package ag5;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.bytedance.ee.bear.middleground.feed.export.bean.MultiBean;

/* JADX INFO: loaded from: classes18.dex */
public interface a<MultiViewHolder extends RecyclerView.ViewHolder, Data extends MultiBean> {
    int b();

    MultiViewHolder c(RecyclerView.Adapter r100, ViewGroup r101);

    void d(RecyclerView.Adapter r100, MultiViewHolder r101, int r102, Data r103, boolean r104);
}
