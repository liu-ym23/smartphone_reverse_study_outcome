package com.stepos.familyguard.ui.usage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.usage.z;
import com.stepos.familyguard.ui.usage.z.b;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* renamed from: com.stepos.familyguard.ui.usage.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0599h<T extends z.b> extends x2.c {

    /* renamed from: c, reason: collision with root package name */
    protected Context f15050c;

    /* renamed from: e, reason: collision with root package name */
    private List<T> f15052e;

    /* renamed from: g, reason: collision with root package name */
    protected String f15054g;

    /* renamed from: h, reason: collision with root package name */
    private a<T> f15055h;

    /* renamed from: a, reason: collision with root package name */
    protected int f15048a = Integer.MIN_VALUE;

    /* renamed from: b, reason: collision with root package name */
    protected int f15049b = Integer.MIN_VALUE;

    /* renamed from: f, reason: collision with root package name */
    private int f15053f = 0;

    /* renamed from: d, reason: collision with root package name */
    protected Comparator<T> f15051d = n();

    /* renamed from: com.stepos.familyguard.ui.usage.h$a */
    public interface a<T> {
        void a(int i5, T t5);
    }

    public AbstractC0599h(Context context) {
        this.f15050c = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f15053f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i5) {
        return 0;
    }

    @Override // stepos.support.v7.widget.StepOSRecyclerView.c
    public int immersiveItemType(int i5) {
        if (getItemViewType(i5) != 0) {
            return super.immersiveItemType(i5);
        }
        int itemCount = getItemCount();
        return i5 == 0 ? itemCount == 1 ? 3 : 0 : i5 == itemCount - 1 ? 2 : 1;
    }

    protected int k() {
        List<T> listS = s();
        this.f15048a = 0;
        int size = listS.size();
        this.f15049b = size - 1;
        return size;
    }

    public void l() {
    }

    protected abstract Comparator<T> n();

    protected View p(ViewGroup viewGroup, int i5) {
        return LayoutInflater.from(this.f15050c).inflate(R.layout.us_package_limit_manager_item, viewGroup, false);
    }

    protected T q(int i5) {
        return s().get(i5);
    }

    public List<T> s() {
        return this.f15052e;
    }

    public a<T> t() {
        return this.f15055h;
    }

    public void v(List<T> list) {
        Collections.sort(this.f15052e, this.f15051d);
    }

    public void w(List<T> list, String str) {
        this.f15052e = list;
        this.f15054g = str;
        v(list);
        this.f15053f = k();
        notifyDataSetChanged();
    }

    public void x(a<T> aVar) {
        this.f15055h = aVar;
    }
}
