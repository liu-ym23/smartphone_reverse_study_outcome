package com.stepos.agentframework.floatcard.view;

import E4.FloatCardPage;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eBI\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u001a\u001a\u00020\b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u001cR&\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001dR&\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/stepos/agentframework/floatcard/view/t;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/stepos/agentframework/floatcard/view/t$a;", "", "LE4/j;", "pages", "Lkotlin/Function2;", "LF4/c;", "LY8/t;", "bindPage", "", "onPageBound", "<init>", "(Ljava/util/List;Lp9/p;Lp9/p;)V", "Landroid/view/ViewGroup;", "parent", "viewType", Const.INTENT_KEY_UMID, "(Landroid/view/ViewGroup;I)Lcom/stepos/agentframework/floatcard/view/t$a;", "holder", "position", "c", "(Lcom/stepos/agentframework/floatcard/view/t$a;I)V", "getItemCount", "()I", "newPages", "e", "(Ljava/util/List;)V", "Ljava/util/List;", "Lp9/p;", Const.INTENT_KEY_APIKEY, "floatcard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class t extends RecyclerView.Adapter<a> {
    private final p9.p<F4.c, FloatCardPage, Y8.t> bindPage;
    private final p9.p<Integer, F4.c, Y8.t> onPageBound;
    private List<FloatCardPage> pages;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/agentframework/floatcard/view/t$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "LF4/c;", "binding", "<init>", "(LF4/c;)V", "LF4/c;", Const.INTENT_KEY_APIKEY, "()LF4/c;", "floatcard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends RecyclerView.ViewHolder {
        private final F4.c binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(F4.c binding) {
            super(binding.b());
            kotlin.jvm.internal.p.i(binding, "binding");
            this.binding = binding;
        }

        /* renamed from: a, reason: from getter */
        public final F4.c getBinding() {
            return this.binding;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public t(List<FloatCardPage> pages, p9.p<? super F4.c, ? super FloatCardPage, Y8.t> bindPage, p9.p<? super Integer, ? super F4.c, Y8.t> onPageBound) {
        kotlin.jvm.internal.p.i(pages, "pages");
        kotlin.jvm.internal.p.i(bindPage, "bindPage");
        kotlin.jvm.internal.p.i(onPageBound, "onPageBound");
        this.pages = pages;
        this.bindPage = bindPage;
        this.onPageBound = onPageBound;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, int position) {
        kotlin.jvm.internal.p.i(holder, "holder");
        FloatCardPage floatCardPage = this.pages.get(position);
        holder.getBinding().layoutOptions.setEnabled(true);
        holder.getBinding().layoutOptions.removeAllViews();
        this.bindPage.invoke(holder.getBinding(), floatCardPage);
        this.onPageBound.invoke(Integer.valueOf(position), holder.getBinding());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup parent, int viewType) {
        kotlin.jvm.internal.p.i(parent, "parent");
        F4.c cVarC = F4.c.c(LayoutInflater.from(parent.getContext()), parent, false);
        kotlin.jvm.internal.p.h(cVarC, "inflate(...)");
        ViewGroup.LayoutParams layoutParams = cVarC.b().getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -1);
        }
        layoutParams.width = -1;
        layoutParams.height = -1;
        cVarC.b().setLayoutParams(layoutParams);
        return new a(cVarC);
    }

    public final void e(List<FloatCardPage> newPages) {
        kotlin.jvm.internal.p.i(newPages, "newPages");
        this.pages = newPages;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.pages.size();
    }
}
