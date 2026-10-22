package com.chad.library.adapter.base;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedanceos.common.toolbox.ServerElements;
import com.chad.library.adapter.base.binder.BaseItemBinder;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001-B\u0017\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J9\u0010\u0011\u001a\u00020\u0000\"\n\b\u0000\u0010\u0012\u0018\u0001*\u00020\u00022\u0010\u0010\u0013\u001a\f\u0012\u0004\u0012\u0002H\u0012\u0012\u0002\b\u00030\u000e2\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u0002H\u0012\u0018\u00010\nH\u0086\bJF\u0010\u0011\u001a\u00020\u0000\"\b\b\u0000\u0010\u0012*\u00020\u00022\u000e\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00120\t2\u0010\u0010\u0013\u001a\f\u0012\u0004\u0012\u0002H\u0012\u0012\u0002\b\u00030\u000e2\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u0002H\u0012\u0018\u00010\nH\u0007J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0010H\u0014J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0003H\u0014J\u0018\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0010H\u0014J\u0018\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0002H\u0014J&\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00022\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020 H\u0014J\u0014\u0010!\u001a\u00020\u00102\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\tH\u0004J\u0010\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u0010H\u0014J\u001c\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000e2\u0006\u0010\u0019\u001a\u00020\u0010H\u0016J\u001e\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e2\u0006\u0010\u0019\u001a\u00020\u0010H\u0016J\u0018\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020(2\u0006\u0010\u0019\u001a\u00020\u0010H\u0014J\u0010\u0010)\u001a\u00020*2\u0006\u0010\u001d\u001a\u00020\u0003H\u0016J\u0010\u0010+\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u0003H\u0016J\u0010\u0010,\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u0003H\u0016RB\u0010\u0007\u001a6\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n0\bj\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u0002\u0012\u0002\b\u00030\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\u000f\u001a&\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u0004\u0012\u00020\u00100\bj\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u0004\u0012\u00020\u0010`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/chad/library/adapter/base/BaseBinderAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", ServerElements.LIST, "", "(Ljava/util/List;)V", "classDiffMap", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lkotlin/collections/HashMap;", "mBinderArray", "Landroid/util/SparseArray;", "Lcom/chad/library/adapter/base/binder/BaseItemBinder;", "mTypeMap", "", "addItemBinder", "T", "baseItemBinder", "callback", "clazz", "bindChildClick", "", "viewHolder", "viewType", "bindClick", "bindViewClickListener", "convert", "holder", "item", "payloads", "", "findViewType", "getDefItemViewType", "position", "getItemBinder", "getItemBinderOrNull", "onCreateDefViewHolder", "parent", "Landroid/view/ViewGroup;", "onFailedToRecycleView", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "ItemCallback", "com.github.CymChad.brvah"}, k = 1, mv = {1, 1, 16})
public class BaseBinderAdapter extends BaseQuickAdapter<Object, BaseViewHolder> {
    private final HashMap<Class<?>, DiffUtil.ItemCallback> classDiffMap;
    private final SparseArray<BaseItemBinder<Object, ?>> mBinderArray;
    private final HashMap<Class<?>, Integer> mTypeMap;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0017J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/chad/library/adapter/base/BaseBinderAdapter$ItemCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "", "(Lcom/chad/library/adapter/base/BaseBinderAdapter;)V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "getChangePayload", "com.github.CymChad.brvah"}, k = 1, mv = {1, 1, 16})
    public final class ItemCallback extends DiffUtil.ItemCallback {
        final /* synthetic */ BaseBinderAdapter this$0;

        public ItemCallback(BaseBinderAdapter r10) {
            this.this$0 = r10;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        @SuppressLint({"DiffUtilEquals"})
        public boolean areContentsTheSame(@NotNull Object r10, @NotNull Object r11) {
            q.h(r10, "oldItem");
            q.h(r11, "newItem");
            if (q.b(r10.getClass(), r11.getClass()) == false) goto L8;
            DiffUtil.ItemCallback r12 = (DiffUtil.ItemCallback) BaseBinderAdapter.access$getClassDiffMap$p(this.this$0).get(r10.getClass());
            if (r12 != null) goto L7;
            return true;
        L7:
            return r12.areContentsTheSame(r10, r11);
        L8:
            return true;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(@NotNull Object r10, @NotNull Object r11) {
            q.h(r10, "oldItem");
            q.h(r11, "newItem");
            if (q.b(r10.getClass(), r11.getClass()) == false) goto L9;
            DiffUtil.ItemCallback r12 = (DiffUtil.ItemCallback) BaseBinderAdapter.access$getClassDiffMap$p(this.this$0).get(r10.getClass());
            if (r12 == null) goto L9;
            return r12.areItemsTheSame(r10, r11);
        L9:
            return q.b(r10, r11);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        @Nullable
        public Object getChangePayload(@NotNull Object r10, @NotNull Object r11) {
            q.h(r10, "oldItem");
            q.h(r11, "newItem");
            if (q.b(r10.getClass(), r11.getClass()) == false) goto L8;
            DiffUtil.ItemCallback r12 = (DiffUtil.ItemCallback) BaseBinderAdapter.access$getClassDiffMap$p(this.this$0).get(r10.getClass());
            if (r12 != null) goto L7;
            return null;
        L7:
            return r12.getChangePayload(r10, r11);
        L8:
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BaseBinderAdapter() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static final /* synthetic */ HashMap access$getClassDiffMap$p(BaseBinderAdapter r10) {
        return r10.classDiffMap;
    }

    public static /* synthetic */ BaseBinderAdapter addItemBinder$default(BaseBinderAdapter r10, Class r11, BaseItemBinder r12, DiffUtil.ItemCallback r13, int r14, Object r15) {
        if (r15 != null) goto L9;
        if ((r14 & 4) == 0) goto L7;
        r13 = null;
    L7:
        return r10.addItemBinder(r11, r12, r13);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addItemBinder");
    }

    @JvmOverloads
    @NotNull
    public final <T> BaseBinderAdapter addItemBinder(@NotNull Class<? extends T> r10, @NotNull BaseItemBinder<T, ?> r11) {
        return addItemBinder$default(this, r10, r11, null, 4, null);
    }

    public void bindChildClick(@NotNull final BaseViewHolder r10, int r11) {
        q.h(r10, "viewHolder");
        if (getOnItemChildClickListener() != null) goto L14;
        final BaseItemBinder<Object, BaseViewHolder> r12 = getItemBinder(r11);
        Iterator<T> r13 = r12.getChildClickViewIds().iterator();
    L6:
        if (r13.hasNext() == false) goto L14;
        int r14 = ((Number) r13.next()).intValue();
        View r15 = r10.itemView.findViewById(r14);
        if (r15 == null) goto L6;
        if (r15.isClickable() == true) goto L12;
        r15.setClickable(true);
    L12:
        r15.setOnClickListener(new BaseBinderAdapter$bindChildClick$$inlined$forEach$lambda$1(this, r10, r12));
    L14:
        if (getOnItemChildLongClickListener() != null) goto L24;
        final BaseItemBinder<Object, BaseViewHolder> r16 = getItemBinder(r11);
        Iterator<T> r17 = r16.getChildLongClickViewIds().iterator();
    L17:
        if (r17.hasNext() == false) goto L35;
        int r18 = ((Number) r17.next()).intValue();
        View r19 = r10.itemView.findViewById(r18);
        if (r19 == null) goto L17;
        if (r19.isLongClickable() == true) goto L23;
        r19.setLongClickable(true);
    L23:
        r19.setOnLongClickListener(new BaseBinderAdapter$bindChildClick$$inlined$forEach$lambda$2(this, r10, r16));
        goto L17
    L35:
        return;
    }

    public void bindClick(@NotNull final BaseViewHolder r10) {
        q.h(r10, "viewHolder");
        if (getOnItemClickListener() != null) goto L6;
        r10.itemView.setOnClickListener(new AnonymousClass1(this, r10));
    L6:
        if (getOnItemLongClickListener() != null) goto L9;
        r10.itemView.setOnLongClickListener(new AnonymousClass2(this, r10));
        return;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void bindViewClickListener(@NotNull BaseViewHolder r10, int r11) {
        q.h(r10, "viewHolder");
        super.bindViewClickListener(r10, r11);
        bindClick(r10);
        bindChildClick(r10, r11);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseViewHolder r10, @NotNull Object r11) {
        q.h(r10, "holder");
        q.h(r11, "item");
        getItemBinder(r10.getItemViewType()).convert(r10, r11);
    }

    public final int findViewType(@NotNull Class<?> r10) {
        q.h(r10, "clazz");
        Integer r11 = this.mTypeMap.get(r10);
        if (r11 == null) goto L7;
        return r11.intValue();
    L7:
        throw new IllegalStateException(("findViewType: ViewType: " + r10 + " Not Find!").toString());
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public int getDefItemViewType(int r10) {
        return findViewType(getData().get(r10).getClass());
    }

    @NotNull
    public BaseItemBinder<Object, BaseViewHolder> getItemBinder(int r10) {
        BaseItemBinder<Object, BaseViewHolder> r11 = (BaseItemBinder) this.mBinderArray.get(r10);
        if (r11 == null) goto L6;
        return r11;
    L6:
        throw new IllegalStateException(("getItemBinder: viewType '" + r10 + "' no such Binder found，please use addItemBinder() first!").toString());
    }

    @Nullable
    public BaseItemBinder<Object, BaseViewHolder> getItemBinderOrNull(int r10) {
        BaseItemBinder<Object, BaseViewHolder> r11 = (BaseItemBinder) this.mBinderArray.get(r10);
        if (r11 != null) goto L6;
        return null;
    L6:
        return r11;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    @NotNull
    public BaseViewHolder onCreateDefViewHolder(@NotNull ViewGroup r10, int r11) {
        q.h(r10, "parent");
        BaseItemBinder<Object, BaseViewHolder> r12 = getItemBinder(r11);
        r12.set_context$com_github_CymChad_brvah(getContext());
        return r12.onCreateViewHolder(r10, r11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ boolean onFailedToRecycleView(RecyclerView.ViewHolder r10) {
        return onFailedToRecycleView((BaseViewHolder) r10);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onViewAttachedToWindow(RecyclerView.ViewHolder r10) {
        onViewAttachedToWindow((BaseViewHolder) r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onViewDetachedFromWindow(RecyclerView.ViewHolder r10) {
        onViewDetachedFromWindow((BaseViewHolder) r10);
    }

    public BaseBinderAdapter(@Nullable List<Object> r10) {
        super(0, r10);
        this.classDiffMap = new HashMap();
        this.mTypeMap = new HashMap();
        this.mBinderArray = new SparseArray();
        setDiffCallback(new ItemCallback(this));
    }

    @JvmOverloads
    @NotNull
    public final <T> BaseBinderAdapter addItemBinder(@NotNull Class<? extends T> r10, @NotNull BaseItemBinder<T, ?> r11, @Nullable DiffUtil.ItemCallback r12) {
        q.h(r10, "clazz");
        q.h(r11, "baseItemBinder");
        int r13 = this.mTypeMap.size() + 1;
        this.mTypeMap.put(r10, Integer.valueOf(r13));
        this.mBinderArray.append(r13, r11);
        r11.set_adapter$com_github_CymChad_brvah(this);
        if (r12 == null) goto L5;
        this.classDiffMap.put(r10, r12);
    L5:
        return this;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseViewHolder r10, @NotNull Object r11, @NotNull List<? extends Object> r12) {
        q.h(r10, "holder");
        q.h(r11, "item");
        q.h(r12, "payloads");
        getItemBinder(r10.getItemViewType()).convert(r10, r11, r12);
    }

    public boolean onFailedToRecycleView(@NotNull BaseViewHolder r10) {
        q.h(r10, "holder");
        BaseItemBinder<Object, BaseViewHolder> r11 = getItemBinderOrNull(r10.getItemViewType());
        if (r11 != null) goto L7;
        return false;
    L7:
        return r11.onFailedToRecycleView(r10);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void onViewAttachedToWindow(@NotNull BaseViewHolder r10) {
        q.h(r10, "holder");
        super.onViewAttachedToWindow(r10);
        BaseItemBinder<Object, BaseViewHolder> r11 = getItemBinderOrNull(r10.getItemViewType());
        if (r11 == null) goto L6;
        r11.onViewAttachedToWindow(r10);
        return;
    }

    public void onViewDetachedFromWindow(@NotNull BaseViewHolder r10) {
        q.h(r10, "holder");
        super.onViewDetachedFromWindow(r10);
        BaseItemBinder<Object, BaseViewHolder> r11 = getItemBinderOrNull(r10.getItemViewType());
        if (r11 == null) goto L6;
        r11.onViewDetachedFromWindow(r10);
        return;
    }

    public static /* synthetic */ BaseBinderAdapter addItemBinder$default(BaseBinderAdapter r10, BaseItemBinder r11, DiffUtil.ItemCallback r12, int r13, Object r14) {
        if (r14 != null) goto L9;
        if ((r13 & 2) == 0) goto L6;
        r12 = null;
    L6:
        q.h(r11, "baseItemBinder");
        q.m(4, "T");
        r10.addItemBinder(Object.class, r11, r12);
        return r10;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addItemBinder");
    }

    public /* synthetic */ BaseBinderAdapter(List r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = null;
    L5:
        this(r10);
    }

    @NotNull
    public final /* synthetic */ <T> BaseBinderAdapter addItemBinder(@NotNull BaseItemBinder<T, ?> r10, @Nullable DiffUtil.ItemCallback r11) {
        q.h(r10, "baseItemBinder");
        q.m(4, "T");
        addItemBinder(Object.class, r10, r11);
        return this;
    }
}
