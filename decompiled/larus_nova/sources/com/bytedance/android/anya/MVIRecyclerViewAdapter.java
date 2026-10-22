package com.bytedance.android.anya;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.anya.MVIState;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u0000*\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00012\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00040\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/anya/MVIRecyclerViewAdapter;", "Lcom/bytedance/android/anya/MVIState;", "STATE", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/anya/MVIViewHolderImpl;", "runtime_release"}, k = 1, mv = {1, 4, 0})
public class MVIRecyclerViewAdapter<STATE extends MVIState<?>> extends RecyclerView.Adapter<MVIViewHolderImpl<?, ?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<? extends STATE> f41564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RecyclerView f41565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BaseMVIView<?, ?> f41566c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function2<ViewGroup, Integer, BaseMVIListItem<STATE, ?>> f41567d;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MVIRecyclerViewAdapter f41568a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0 f41569b;

        public a(MVIRecyclerViewAdapter r100, Function0 r101) {
            this.f41568a = r100;
            this.f41569b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f41568a.z2(this.f41569b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f41564a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder r100) {
        MVIViewHolderImpl r101 = (MVIViewHolderImpl) r100;
        r101.f41571b = true;
        r101.f41570a.unbind();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object y2(r0 r100) {
        return ((com.bytedance.android.anya.internal.c) r100).c();
    }

    public final void z2(Function0<Unit> r100) {
        RecyclerView r101 = this.f41565b;
        if (r101 != null) goto L5;
    L10:
        r100.invoke();
        return;
    L5:
        if (r101.isComputingLayout() != true) goto L10;
        RecyclerView r102 = this.f41565b;
        if (r102 == null) goto L12;
        r102.post(new a(this, r100));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MVIRecyclerViewAdapter(BaseMVIView<?, ?> r100, Function2<? super ViewGroup, ? super Integer, ? extends BaseMVIListItem<STATE, ?>> r101) {
        this.f41566c = r100;
        this.f41567d = r101;
        this.f41564a = CollectionsKt.emptyList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        ((MVIViewHolderImpl) r100).T3((MVIState) ListProtector.get(this.f41564a, r101));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        return new MVIViewHolderImpl(this.f41566c, this.f41567d.invoke(r100, Integer.valueOf(r101)));
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public void A2(MVIViewHolderImpl<?, ?> r100, int r101, List<Object> r102) {
        if (r102.isEmpty() == false) goto L6;
        r100.T3((MVIState) ListProtector.get(this.f41564a, r101));
        return;
    L6:
        Object r103 = CollectionsKt.last(r102);
        if (r103 == null) goto L14;
        k<STATE> r104 = (k) ((Map) r103).get(Integer.valueOf(r101));
        if (r104 == null) goto L11;
        r100.f41572c.c(r104);
        return;
    L11:
        r100.T3((MVIState) ListProtector.get(this.f41564a, r101));
        return;
    L14:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.Int, com.bytedance.android.anya.Diff<STATE>>");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, List r102) {
        A2((MVIViewHolderImpl) r100, r101, r102);
    }
}
