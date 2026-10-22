package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.chatroom.e;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class MorePanelButtonDiffUpdater<Model extends com.bytedance.android.livesdk.chatroom.e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<Pair<ViewGroup, Integer>> f115686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f115687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s<Model> f115688c;

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/MorePanelButtonDiffUpdater$DynamicItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class DynamicItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<? extends Model> f115689a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MorePanelButtonDiffUpdater f115690b;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            List<? extends Model> r100 = this.f115689a;
            if (r100 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("data");
        L6:
            return r100.size();
        }

        public DynamicItemAdapter(MorePanelButtonDiffUpdater r100) {
            this.f115690b = r100;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "vh");
            s<Model> r102 = this.f115690b.f115688c;
            List<? extends Model> r103 = this.f115689a;
            if (r103 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("data");
        L5:
            Object r104 = ListProtector.get(r103, r101);
            Model r105 = (Model) r104;
            r102.o(null, r105, r100.itemView, r101);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "rv");
            final View r102 = this.f115690b.f115688c.x(r100, 4.5f, null);
            return new MorePanelButtonDiffUpdater$DynamicItemAdapter$onCreateViewHolder$1(r102, r102);
        }
    }

    public MorePanelButtonDiffUpdater(ArrayList<Pair<ViewGroup, Integer>> r100, RecyclerView r101, s<Model> r102) {
        Intrinsics.checkNotNullParameter(r100, "layoutList");
        Intrinsics.checkNotNullParameter(r102, "dataViewBinder");
        this.f115686a = r100;
        this.f115687b = r101;
        this.f115688c = r102;
    }
}
