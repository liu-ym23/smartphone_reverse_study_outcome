package com.drakeet.multitype;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tmall.wireless.tangram.dataparser.concrete.Card;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.t;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
public class MultiTypeAdapter extends RecyclerView.Adapter {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f10261d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List f10262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f10263b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Types f10264c;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        f10261d = new a(null);
    }

    public MultiTypeAdapter() {
        List r10 = null;
        int r11 = 0;
        Types r12 = null;
        this(r10, r11, r12, 7, null);
    }

    public List a() {
        return this.f10262a;
    }

    public final c b(RecyclerView.ViewHolder r10) {
        c r11 = c().getType(r10.getItemViewType()).b();
        if (r11 == null) goto L6;
        return r11;
    L6:
        throw new TypeCastException("null cannot be cast to non-null type com.drakeet.multitype.ItemViewDelegate<kotlin.Any, androidx.recyclerview.widget.RecyclerView.ViewHolder>");
    }

    public Types c() {
        return this.f10264c;
    }

    public final int d(int r10, Object r11) {
        q.h(r11, "item");
        int r12 = c().firstIndexOf(r11.getClass());
        if (r12 == (-1)) goto L7;
        return r12 + c().getType(r12).c().index(r10, r11);
    L7:
        throw new DelegateNotFoundException(r11.getClass());
    }

    public final void e(Class r10, b r11) {
        q.h(r10, "clazz");
        q.h(r11, "binder");
        f(r10, r11);
    }

    public final void f(Class r10, c r11) {
        q.h(r10, "clazz");
        q.h(r11, "delegate");
        i(r10);
        g(new d(r10, r11, new com.drakeet.multitype.a()));
    }

    public final void g(d r10) {
        q.h(r10, "type");
        c().register(r10);
        r10.b().set_adapter$multitype(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return a().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int r10) {
        Object r11 = a().get(r10);
        int r12 = getItemViewType(r10);
        return c().getType(r12).b().getItemId(r11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r10) {
        return d(r10, a().get(r10));
    }

    public void h(List r10) {
        q.h(r10, "<set-?>");
        this.f10262a = r10;
    }

    public final void i(Class r10) {
        if (c().unregister(r10) == false) goto L6;
        Log.w("MultiTypeAdapter", "The type " + r10.getSimpleName() + " you originally registered is now overwritten.");
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder r10, int r11) {
        q.h(r10, "holder");
        onBindViewHolder(r10, r11, t.i());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r10, int r11) {
        q.h(r10, "parent");
        c r12 = c().getType(r11).b();
        Context r13 = r10.getContext();
        q.c(r13, "parent.context");
        return r12.onCreateViewHolder(r13, r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(RecyclerView.ViewHolder r10) {
        q.h(r10, "holder");
        return b(r10).onFailedToRecycleView(r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder r10) {
        q.h(r10, "holder");
        b(r10).onViewAttachedToWindow(r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder r10) {
        q.h(r10, "holder");
        b(r10).onViewDetachedFromWindow(r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder r10) {
        q.h(r10, "holder");
        b(r10).onViewRecycled(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ MultiTypeAdapter(List r10, int r11, Types r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = t.i();
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = 0;
    L9:
        if ((r13 & 4) == 0) goto L11;
        r12 = new MutableTypes(r11, null, 2, 0 == true ? 1 : 0);
    L11:
        this(r10, r11, r12);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder r10, int r11, List r12) {
        q.h(r10, "holder");
        q.h(r12, "payloads");
        Object r13 = a().get(r11);
        b(r10).onBindViewHolder(r10, r13, r12);
    }

    public MultiTypeAdapter(List r10, int r11, Types r12) {
        q.h(r10, Card.KEY_ITEMS);
        q.h(r12, "types");
        this.f10262a = r10;
        this.f10263b = r11;
        this.f10264c = r12;
    }
}
