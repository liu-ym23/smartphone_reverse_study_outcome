package com.bytedanceos.appstore.buss.widget.app.pager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import com.bytedanceos.appstore.buss.adapter.BinderAdapter;
import com.bytedanceos.appstore.buss.entity.AppSubEntity;
import com.bytedanceos.appstore.buss.utilities.f;
import com.bytedanceos.appstore.buss.widget.app.base.BaseSubPagerView;
import com.bytedanceos.appstore.buss.widget.recyclerview.CommonRecyclerView;
import com.bytedanceos.common.toolbox.ServerElements;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.obric.appstore.R;
import d7.h;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.b;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u7.a;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\f\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0014¢\u0006\u0004\b\f\u0010\rR`\u0010\u001b\u001a@\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010#\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0017\u0010)\u001a\u00020$8\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001b\u0010/\u001a\u00020*8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R&\u00106\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u000201008\u0014X\u0094\u0004¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105¨\u00067"}, d2 = {"Lcom/bytedanceos/appstore/buss/widget/app/pager/PagerSubView;", "Lcom/bytedanceos/appstore/buss/widget/app/base/BaseSubPagerView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "Lcom/bytedanceos/appstore/buss/entity/AppSubEntity;", ServerElements.LIST, "", "setItems", "(Ljava/util/List;)V", "Lkotlin/Function2;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "entity", "Lcom/bytedanceos/appstore/buss/utilities/AppOnClickListener;", "f", "Lkotlin/jvm/functions/Function2;", "getAppSubOnClickListener", "()Lkotlin/jvm/functions/Function2;", "setAppSubOnClickListener", "(Lkotlin/jvm/functions/Function2;)V", "appSubOnClickListener", "", "g", "Ljava/lang/String;", "getPageSource", "()Ljava/lang/String;", "setPageSource", "(Ljava/lang/String;)V", "pageSource", "Ld7/h;", "h", "Ld7/h;", "getItemSubBinder", "()Ld7/h;", "itemSubBinder", "Lcom/bytedanceos/appstore/buss/widget/recyclerview/CommonRecyclerView;", "i", "Lkotlin/Lazy;", "getRecyclerView", "()Lcom/bytedanceos/appstore/buss/widget/recyclerview/CommonRecyclerView;", "recyclerView", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "j", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "getAdapter", "()Lcom/chad/library/adapter/base/BaseQuickAdapter;", "adapter", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPagerSubView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PagerSubView.kt\ncom/bytedanceos/appstore/buss/widget/app/pager/PagerSubView\n+ 2 BaseBinderAdapter.kt\ncom/chad/library/adapter/base/BaseBinderAdapter\n*L\n1#1,74:1\n57#2,3:75\n*S KotlinDebug\n*F\n+ 1 PagerSubView.kt\ncom/bytedanceos/appstore/buss/widget/app/pager/PagerSubView\n*L\n39#1:75,3\n*E\n"})
public final class PagerSubView extends BaseSubPagerView {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function2 f9228f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f9229g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final h f9230h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f9231i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final BaseQuickAdapter f9232j;

    public /* synthetic */ PagerSubView(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    @Override // com.bytedanceos.appstore.buss.widget.app.base.BasePagerView
    @NotNull
    public BaseQuickAdapter<AppSubEntity, BaseViewHolder> getAdapter() {
        return this.f9232j;
    }

    @Nullable
    public final Function2<View, AppSubEntity, Unit> getAppSubOnClickListener() {
        return this.f9228f;
    }

    @NotNull
    public final h getItemSubBinder() {
        return this.f9230h;
    }

    @Nullable
    public final String getPageSource() {
        return this.f9229g;
    }

    @NotNull
    public final CommonRecyclerView getRecyclerView() {
        return (CommonRecyclerView) this.f9231i.getValue();
    }

    public final void setAppSubOnClickListener(@Nullable Function2<? super View, ? super AppSubEntity, Unit> r10) {
        this.f9228f = r10;
    }

    @Override // com.bytedanceos.appstore.buss.widget.app.base.BaseSubPagerView, com.bytedanceos.appstore.buss.widget.app.base.BasePagerView
    public void setItems(@NotNull List<? extends AppSubEntity> r10) {
        q.g(r10, ServerElements.LIST);
        this.f9230h.b(this.f9228f);
        this.f9230h.c(this.f9229g);
        if (getRecyclerView().getAdapter() != null) goto L13;
        int r11 = r10.size();
        int r12 = f.f8838a.f(getContext());
        if (r11 > (r12 + 1)) goto L7;
        int r13 = 1;
    L12:
        a.f24888a.b(getRecyclerView(), r13);
        GridLayoutManager r14 = new GridLayoutManager(getContext(), r13);
        r14.setOrientation(0);
        getRecyclerView().setLayoutManager(r14);
        new w7.a(r12).b(getRecyclerView());
        getRecyclerView().setHasFixedSize(true);
        getAdapter().setList(r10);
        getRecyclerView().setAdapter(getAdapter());
        return;
    L7:
        int r15 = r12 + 2;
        r13 = 2;
        if (r11 > ((r12 * 2) + 2)) goto L11;
        if (r15 <= r11) goto L12;
    L11:
        r13 = 3;
        goto L12
    L13:
        getAdapter().setList(r10);
    }

    public final void setPageSource(@Nullable String r10) {
        this.f9229g = r10;
    }

    public PagerSubView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11);
        h r12 = new h();
        this.f9230h = r12;
        this.f9231i = b.b(new PagerSubView$recyclerView$2(this));
        BinderAdapter r13 = new BinderAdapter();
        r13.addItemBinder(AppSubEntity.class, r12, null);
        this.f9232j = r13;
        View.inflate(r10, R.layout.tv_item_view_pager_sub, this);
    }
}
