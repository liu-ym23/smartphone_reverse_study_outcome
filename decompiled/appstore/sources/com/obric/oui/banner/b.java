package com.obric.oui.banner;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.apm.constant.CommonKey;
import com.obric.common.oui.R$id;
import com.obric.oui.banner.configs.IBannerConfig;
import com.obric.oui.banner.interfaces.BannerOperator;
import com.obric.oui.banner.interfaces.OnBannerItemClickListener;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.collections.b0;
import kotlin.collections.t;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.channels.Channel;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class b extends RecyclerView.Adapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BannerOperator f12443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f12444b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f12445c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public IBannerConfig f12446d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OnBannerItemClickListener f12447e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public WeakHashMap f12448f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List f12449g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f12450h;

    public b(BannerOperator r10) {
        q.g(r10, "bannerOperator");
        this.f12443a = r10;
        this.f12444b = new LinkedHashMap();
        this.f12445c = new ArrayList();
        this.f12448f = new WeakHashMap();
        this.f12449g = t.i();
        this.f12450h = true;
        j(g.f12459g);
    }

    public static /* synthetic */ void a(b r10, View r11) {
        e(r10, r11);
    }

    public static final void e(b r10, View r11) {
        q.g(r10, "this$0");
        Object r12 = r11.getTag(R$id.banner_pos_key);
        if (r12 == null) goto L10;
        int r13 = ((Integer) r12).intValue();
        OnBannerItemClickListener r14 = r10.f12447e;
        if (r14 == null) goto L11;
        r14.onItemClick((BannerData) r10.f12449g.get(r13), r13);
        return;
    L11:
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    public final int b() {
        return this.f12449g.size();
    }

    public final boolean c() {
        return this.f12450h;
    }

    public void d(d r10, int r11) {
        q.g(r10, "holder");
        int r12 = oc.a.f22548a.a(this.f12450h, r11, b());
        if (this.f12449g.isEmpty() == false) goto L6;
        r10.f(r12, new f());
        return;
    L6:
        BannerData r13 = (BannerData) this.f12449g.get(r12);
        if ((r13 instanceof GridBannerData) == false) goto L9;
        ((GridBannerData) r13).setBannerGridConfig(this.f12446d);
    L9:
        r10.f(r12, r13);
        r10.itemView.setTag(R$id.banner_pos_key, Integer.valueOf(r12));
        if (r10.itemView.hasOnClickListeners() == true) goto L13;
        r10.itemView.setOnClickListener(new a(this));
        return;
    }

    public d f(ViewGroup r10, int r11) {
        q.g(r10, "parent");
        if (this.f12445c.isEmpty() == true) goto L7;
        d r12 = ((IBannerViewHolderFactory) this.f12445c.get(r11)).newInstance(r10);
        r12.n(this.f12443a);
        return r12;
    L7:
        throw new IllegalStateException("Register your BannerViewHolder into the Banner ~ ");
    }

    public void g(d r10) {
        q.g(r10, "holder");
        super.onViewAttachedToWindow(r10);
        r10.e();
        this.f12448f.put(r10, Unit.f21064a);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.f12450h == false) goto L6;
        return Channel.UNLIMITED;
    L6:
        return this.f12449g.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r10) {
        if (this.f12445c.isEmpty() == true) goto L11;
        if (this.f12449g.isEmpty() == false) goto L7;
        String r11 = g.f12459g.getKey();
    L8:
        IBannerViewHolderFactory r12 = (IBannerViewHolderFactory) this.f12444b.get(r11);
        return b0.c0(this.f12445c, r12);
    L7:
        List r13 = this.f12449g;
        r11 = ((BannerData) r13.get(r10 % r13.size())).getHolderKey();
        goto L8
    L11:
        throw new IllegalStateException("Register your BannerViewHolder into the Banner ~ ");
    }

    public void h(d r10) {
        q.g(r10, "holder");
        super.onViewDetachedFromWindow(r10);
        r10.h();
        this.f12448f.remove(r10);
    }

    public void i(d r10) {
        q.g(r10, "holder");
        super.onViewRecycled(r10);
        r10.k();
    }

    public final void j(IBannerViewHolderFactory r10) {
        q.g(r10, "factory");
        this.f12444b.put(r10.getKey(), r10);
        this.f12445c.add(r10);
    }

    public final void k(List r10) {
        q.g(r10, CommonKey.KEY_VALUE);
        this.f12449g = r10;
        notifyDataSetChanged();
    }

    public final void l(boolean r10) {
        this.f12450h = r10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r10, int r11) {
        d((d) r10, r11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r10, int r11) {
        return f(r10, r11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onViewAttachedToWindow(RecyclerView.ViewHolder r10) {
        g((d) r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onViewDetachedFromWindow(RecyclerView.ViewHolder r10) {
        h((d) r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onViewRecycled(RecyclerView.ViewHolder r10) {
        i((d) r10);
    }

    public final void setBannerItemClickListener(@NotNull OnBannerItemClickListener r10) {
        q.g(r10, "onBannerClickListener");
        this.f12447e = r10;
    }
}
