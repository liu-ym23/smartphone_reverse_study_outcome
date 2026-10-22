package com.stepos.familyguard.ui.usage;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.usage.z;
import com.stepos.familyguard.ui.usage.z.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* renamed from: com.stepos.familyguard.ui.usage.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0598g<T extends z.b> extends x2.c {

    /* renamed from: h, reason: collision with root package name */
    protected Context f15040h;

    /* renamed from: j, reason: collision with root package name */
    protected b<T> f15042j;

    /* renamed from: k, reason: collision with root package name */
    private List<T> f15043k;

    /* renamed from: l, reason: collision with root package name */
    private List<T> f15044l;

    /* renamed from: m, reason: collision with root package name */
    private List<T> f15045m;

    /* renamed from: a, reason: collision with root package name */
    protected int f15033a = Integer.MIN_VALUE;

    /* renamed from: b, reason: collision with root package name */
    protected int f15034b = Integer.MIN_VALUE;

    /* renamed from: c, reason: collision with root package name */
    protected int f15035c = Integer.MIN_VALUE;

    /* renamed from: d, reason: collision with root package name */
    protected int f15036d = Integer.MIN_VALUE;

    /* renamed from: e, reason: collision with root package name */
    protected int f15037e = Integer.MIN_VALUE;

    /* renamed from: f, reason: collision with root package name */
    protected int f15038f = Integer.MIN_VALUE;

    /* renamed from: g, reason: collision with root package name */
    protected int f15039g = Integer.MIN_VALUE;

    /* renamed from: n, reason: collision with root package name */
    private int f15046n = 0;

    /* renamed from: i, reason: collision with root package name */
    protected Comparator<T> f15041i = p();

    /* renamed from: com.stepos.familyguard.ui.usage.g$a */
    protected static class a extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        j2.x f15047a;

        public a(View view) {
            super(view);
            this.f15047a = j2.x.a(view);
        }
    }

    /* renamed from: com.stepos.familyguard.ui.usage.g$b */
    public interface b<T> {
        void a(int i5, T t5);
    }

    /* renamed from: com.stepos.familyguard.ui.usage.g$c */
    protected static class c extends RecyclerView.ViewHolder {
        public c(View view) {
            super(view);
        }
    }

    public AbstractC0598g(Context context) {
        this.f15040h = context;
    }

    private void k(View view, int i5) {
        if (view == null || getItemViewType(i5) != 2) {
            return;
        }
        int iImmersiveItemType = immersiveItemType(i5);
        view.setBackgroundResource(iImmersiveItemType == 0 ? R.drawable.us_limit_manager_card_head : iImmersiveItemType == 2 ? R.drawable.us_limit_manager_card_foot : iImmersiveItemType == 3 ? R.drawable.us_limit_manager_card_alone : R.drawable.us_limit_manager_card_middle);
        View viewFindViewById = view.findViewById(R.id.row_divider);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility((iImmersiveItemType == 2 || iImmersiveItemType == 3) ? 8 : 0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f15046n;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i5) {
        if (i5 == this.f15033a || i5 == this.f15034b) {
            return 0;
        }
        return i5 == this.f15035c ? 1 : 2;
    }

    @Override // stepos.support.v7.widget.StepOSRecyclerView.c
    public int immersiveItemType(int i5) {
        int itemViewType = getItemViewType(i5);
        if (itemViewType == 0 || itemViewType == 1) {
            return 4;
        }
        if (itemViewType != 2) {
            return super.immersiveItemType(i5);
        }
        if (w()) {
            int itemCount = getItemCount();
            if (itemCount <= 1) {
                return 3;
            }
            if (i5 == 0) {
                return 0;
            }
            return i5 == itemCount - 1 ? 2 : 1;
        }
        int size = t() == null ? 0 : t().size();
        int size2 = v() == null ? 0 : v().size();
        if (i5 == this.f15038f) {
            if (size2 == 0) {
                return 1;
            }
            return size2 == 1 ? 3 : 0;
        }
        if (i5 == this.f15039g) {
            return 2;
        }
        if (i5 != this.f15036d) {
            return i5 == this.f15037e ? 2 : 1;
        }
        if (size == 0) {
            return 1;
        }
        return size == 1 ? 3 : 0;
    }

    protected int l() {
        int i5 = 0;
        if (w()) {
            int size = (t() == null ? 0 : t().size()) + (v() == null ? 0 : v().size());
            this.f15033a = Integer.MIN_VALUE;
            this.f15034b = Integer.MIN_VALUE;
            this.f15035c = Integer.MIN_VALUE;
            if (size == 0) {
                this.f15036d = Integer.MIN_VALUE;
                this.f15037e = Integer.MIN_VALUE;
                this.f15038f = Integer.MIN_VALUE;
                this.f15039g = Integer.MIN_VALUE;
                return 0;
            }
            this.f15036d = 0;
            this.f15037e = size - 1;
            this.f15038f = Integer.MIN_VALUE;
            this.f15039g = Integer.MIN_VALUE;
            return size;
        }
        int size2 = t() == null ? 0 : t().size();
        int size3 = v() == null ? 0 : v().size();
        if (size2 > 0) {
            this.f15033a = 0;
            this.f15036d = 1;
            this.f15037e = size2;
            this.f15035c = size2 + 1;
            i5 = size2 + 2;
        } else {
            this.f15033a = Integer.MIN_VALUE;
            this.f15036d = Integer.MIN_VALUE;
            this.f15037e = Integer.MIN_VALUE;
            this.f15035c = Integer.MIN_VALUE;
        }
        if (size3 <= 0) {
            this.f15034b = Integer.MIN_VALUE;
            this.f15038f = Integer.MIN_VALUE;
            this.f15039g = Integer.MIN_VALUE;
            return i5;
        }
        this.f15034b = i5;
        int i6 = i5 + 1;
        this.f15038f = i6;
        int i7 = i6 + size3;
        this.f15039g = i7 - 1;
        return i7;
    }

    public void n() {
    }

    @Override // x2.c, stepos.support.v7.widget.StepOSRecyclerView.c, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i5) throws Resources.NotFoundException {
        super.onBindViewHolder(viewHolder, i5);
        k(viewHolder.itemView, i5);
        if (viewHolder instanceof a) {
            if (i5 == this.f15033a) {
                ((a) viewHolder).f15047a.f17800c.setText(R.string.us_limited);
            } else if (i5 == this.f15034b) {
                ((a) viewHolder).f15047a.f17800c.setText(R.string.us_unlimited);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i5) {
        View viewQ = q(viewGroup, i5);
        if (i5 == 0) {
            return new a(viewQ);
        }
        if (i5 == 1) {
            return new c(viewQ);
        }
        return null;
    }

    protected abstract Comparator<T> p();

    protected View q(ViewGroup viewGroup, int i5) {
        return LayoutInflater.from(this.f15040h).inflate(i5 == 0 ? R.layout.us_category_item : i5 == 1 ? R.layout.us_space_item : R.layout.us_package_limit_manager_item, viewGroup, false);
    }

    protected T s(int i5) {
        int i6;
        if (w()) {
            int size = t() == null ? 0 : t().size();
            if (i5 < size) {
                return t().get(i5);
            }
            int i7 = i5 - size;
            if (v() == null || i7 < 0 || i7 >= v().size()) {
                return null;
            }
            return v().get(i7);
        }
        int i8 = this.f15036d;
        if (i5 >= i8 && i5 <= this.f15037e) {
            int i9 = i5 - i8;
            if (i9 >= t().size()) {
                return null;
            }
            return t().get(i9);
        }
        int i10 = this.f15038f;
        if (i5 < i10 || i5 > this.f15039g || (i6 = i5 - i10) >= v().size()) {
            return null;
        }
        return v().get(i6);
    }

    protected List<T> t() {
        return this.f15044l;
    }

    protected List<T> v() {
        return this.f15045m;
    }

    protected boolean w() {
        return false;
    }

    public void x(List<T> list) {
        if (this.f15044l == null) {
            this.f15044l = new ArrayList();
        }
        this.f15044l.clear();
        if (this.f15045m == null) {
            this.f15045m = new ArrayList();
        }
        this.f15045m.clear();
        for (T t5 : list) {
            if (t5.f15173a) {
                this.f15044l.add(t5);
            } else {
                this.f15045m.add(t5);
            }
        }
        Collections.sort(this.f15044l, this.f15041i);
        Collections.sort(this.f15045m, this.f15041i);
    }

    public void y(List<T> list) {
        this.f15043k = list;
        x(list);
        this.f15046n = l();
        notifyDataSetChanged();
    }

    public void z(b<T> bVar) {
        this.f15042j = bVar;
    }
}
