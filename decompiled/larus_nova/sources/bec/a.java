package bec;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import bec.a;
import com.ss.android.lark.widget.recyclerview.item.BaseItemAdapter;
import com.ss.android.lark.widget.recyclerview.item.ItemViewHolder;

/* JADX INFO: loaded from: classes38.dex */
public abstract class a<T extends a> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final SparseIntArray f18797c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final SparseArray<View> f18798d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BaseItemAdapter<T> f18800b;

    public abstract void a(ItemViewHolder r100, int r101);

    static {
        f18797c = new SparseIntArray();
        f18798d = new SparseArray();
    }

    public void update() {
        BaseItemAdapter<T> r100 = this.f18800b;
        int r101 = r100.f448189a.indexOf(this);
        if (r101 == (-1)) goto L6;
        r100.notifyItemRangeChanged(r101, 1, null);
        return;
    }

    public a(int r100) {
        int r101 = getClass().hashCode() + r100;
        this.f18799a = r101;
        f18797c.put(r101, r100);
    }
}
