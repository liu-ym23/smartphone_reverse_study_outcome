package aw7;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public interface c<GVH extends RecyclerView.ViewHolder, CVH extends RecyclerView.ViewHolder> {
    RecyclerView.ViewHolder B(ViewGroup r100);

    boolean K0(int r100, boolean r101);

    CVH N(ViewGroup r100, int r101);

    int P(int r100, int r101);

    void R1();

    void a1(GVH r100, int r101, int r102, List<Object> r103);

    void d1(CVH r100, int r101, int r102, int r103);

    void f1(CVH r100, int r101, int r102, int r103, List<Object> r104);

    long getChildId(int r100, int r101);

    int getGroupCount();

    long getGroupId(int r100);

    int i1(int r100);

    boolean l1(int r100);

    void p0(RecyclerView.ViewHolder r100, int r101);

    boolean v1(int r100, boolean r101);

    void v2(RecyclerView.ViewHolder r100);
}
