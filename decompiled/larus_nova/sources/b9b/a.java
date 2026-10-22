package b9b;

import android.util.SparseIntArray;
import b9b.a;
import com.ss.android.lark.contact.base.entity.mobile.item.BaseItemAdapter;
import com.ss.android.lark.contact.base.entity.mobile.item.ItemViewHolder;

/* JADX INFO: loaded from: classes35.dex */
public abstract class a<T extends a<T>> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final SparseIntArray f18371d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f18372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f18373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BaseItemAdapter<T> f18374c;

    public abstract void a(ItemViewHolder r100, int r101);

    static {
        f18371d = new SparseIntArray();
    }

    public void update() {
        BaseItemAdapter<T> r100 = this.f18374c;
        int r101 = r100.f418888a.indexOf(this);
        if (r101 == (-1)) goto L6;
        r100.notifyItemRangeChanged(r101, 1, null);
        return;
    }

    public a(int r100) {
        this.f18372a = false;
        int r101 = getClass().hashCode() + r100;
        this.f18373b = r101;
        f18371d.put(r101, r100);
    }

    public void b(ItemViewHolder r100) {
        this.f18372a = false;
    }
}
