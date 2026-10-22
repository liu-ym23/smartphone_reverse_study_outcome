package com.chad.library.adapter.base;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.b;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u0002B\u0017\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0016J\u0018\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0003H\u0014J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J\u001d\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u001aJ+\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00028\u00002\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0014¢\u0006\u0002\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u0014H\u0014J\u0018\u0010!\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J\u001e\u0010\"\u001a\u00020\u00142\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c2\u0006\u0010 \u001a\u00020\u0014H$J\u0018\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u0014H\u0014R'\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006&"}, d2 = {"Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "T", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "data", "", "(Ljava/util/List;)V", "mItemProviders", "Landroid/util/SparseArray;", "Lcom/chad/library/adapter/base/provider/BaseItemProvider;", "getMItemProviders", "()Landroid/util/SparseArray;", "mItemProviders$delegate", "Lkotlin/Lazy;", "addItemProvider", "", "provider", "bindChildClick", "viewHolder", "viewType", "", "bindClick", "bindViewClickListener", "convert", "holder", "item", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Ljava/lang/Object;)V", "payloads", "", "", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Ljava/lang/Object;Ljava/util/List;)V", "getDefItemViewType", "position", "getItemProvider", "getItemType", "onCreateDefViewHolder", "parent", "Landroid/view/ViewGroup;", "com.github.CymChad.brvah"}, k = 1, mv = {1, 1, 16})
public abstract class BaseProviderMultiAdapter<T> extends BaseQuickAdapter<T, BaseViewHolder> {
    private final Lazy mItemProviders$delegate;

    /* JADX WARN: Multi-variable type inference failed */
    public BaseProviderMultiAdapter() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static final /* synthetic */ SparseArray access$getMItemProviders$p(BaseProviderMultiAdapter r10) {
        return r10.getMItemProviders();
    }

    private final SparseArray<BaseItemProvider<T>> getMItemProviders() {
        return (SparseArray) this.mItemProviders$delegate.getValue();
    }

    public void addItemProvider(@NotNull BaseItemProvider<T> r10) {
        q.h(r10, "provider");
        r10.setAdapter$com_github_CymChad_brvah(this);
        getMItemProviders().put(r10.getItemViewType(), r10);
    }

    public void bindChildClick(@NotNull final BaseViewHolder r10, int r11) {
        q.h(r10, "viewHolder");
        if (getOnItemChildClickListener() != null) goto L17;
        final BaseItemProvider<T> r12 = getItemProvider(r11);
        if (r12 == null) goto L15;
        Iterator<T> r13 = r12.getChildClickViewIds().iterator();
    L8:
        if (r13.hasNext() == false) goto L17;
        int r14 = ((Number) r13.next()).intValue();
        View r15 = r10.itemView.findViewById(r14);
        if (r15 == null) goto L8;
        if (r15.isClickable() == true) goto L14;
        r15.setClickable(true);
    L14:
        r15.setOnClickListener(new BaseProviderMultiAdapter$bindChildClick$$inlined$forEach$lambda$1(this, r10, r12));
        goto L8
    L15:
        return;
    L17:
        if (getOnItemChildLongClickListener() != null) goto L29;
        final BaseItemProvider<T> r16 = getItemProvider(r11);
        if (r16 == null) goto L40;
        Iterator<T> r17 = r16.getChildLongClickViewIds().iterator();
    L22:
        if (r17.hasNext() == false) goto L41;
        int r18 = ((Number) r17.next()).intValue();
        View r19 = r10.itemView.findViewById(r18);
        if (r19 == null) goto L22;
        if (r19.isLongClickable() == true) goto L28;
        r19.setLongClickable(true);
    L28:
        r19.setOnLongClickListener(new BaseProviderMultiAdapter$bindChildClick$$inlined$forEach$lambda$2(this, r10, r16));
        goto L22
    L41:
        return;
    L40:
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
    public void convert(@NotNull BaseViewHolder r10, T r11) {
        q.h(r10, "holder");
        BaseItemProvider<T> r12 = getItemProvider(r10.getItemViewType());
        if (r12 != null) goto L5;
        q.s();
    L5:
        r12.convert(r10, r11);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public int getDefItemViewType(int r10) {
        return getItemType(getData(), r10);
    }

    @Nullable
    public BaseItemProvider<T> getItemProvider(int r10) {
        return getMItemProviders().get(r10);
    }

    public abstract int getItemType(@NotNull List<? extends T> r10, int r11);

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    @NotNull
    public BaseViewHolder onCreateDefViewHolder(@NotNull ViewGroup r10, int r11) {
        q.h(r10, "parent");
        BaseItemProvider<T> r12 = getItemProvider(r11);
        if (r12 == null) goto L7;
        Context r13 = r10.getContext();
        q.c(r13, "parent.context");
        r12.setContext(r13);
        BaseViewHolder r14 = r12.onCreateViewHolder(r10, r11);
        r12.onViewHolderCreated(r14, r11);
        return r14;
    L7:
        throw new IllegalStateException(("ViewType: " + r11 + " no such provider found，please use addItemProvider() first!").toString());
    }

    public /* synthetic */ BaseProviderMultiAdapter(List r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = null;
    L5:
        this(r10);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseViewHolder r10, T r11, @NotNull List<? extends Object> r12) {
        q.h(r10, "holder");
        q.h(r12, "payloads");
        BaseItemProvider<T> r13 = getItemProvider(r10.getItemViewType());
        if (r13 != null) goto L5;
        q.s();
    L5:
        r13.convert(r10, r11, r12);
    }

    public BaseProviderMultiAdapter(@Nullable List<T> r10) {
        super(0, r10);
        this.mItemProviders$delegate = b.a(LazyThreadSafetyMode.NONE, BaseProviderMultiAdapter$mItemProviders$2.INSTANCE);
    }
}
