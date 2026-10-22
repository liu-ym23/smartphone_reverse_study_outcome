package com.bytedanceos.appstore.buss.adapter.onetype;

import com.bytedanceos.appstore.buss.entity.CategoryTitleEntity;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.obric.appstore.R;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedanceos/appstore/buss/adapter/onetype/AppCategoryTitleAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/bytedanceos/appstore/buss/entity/CategoryTitleEntity;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "<init>", "()V", "holder", "item", "", "a", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/bytedanceos/appstore/buss/entity/CategoryTitleEntity;)V", "", "selectedPosition", "b", "(I)V", "I", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AppCategoryTitleAdapter extends BaseQuickAdapter<CategoryTitleEntity, BaseViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8396a;

    public AppCategoryTitleAdapter() {
        super(R.layout.tv_item_category_title, null, 2, null);
    }

    public void a(BaseViewHolder r10, CategoryTitleEntity r11) {
        q.g(r10, "holder");
        q.g(r11, "item");
        r10.setText(R.id.tv_title, r11.getName());
        if (r10.getAdapterPosition() != this.f8396a) goto L5;
        r10.setBackgroundResource(R.id.tv_title, R.drawable.tv_app_category_title_shape);
        return;
    L5:
        r10.setBackgroundResource(R.id.tv_title, 0);
    }

    public final void b(int r10) {
        this.f8396a = r10;
        notifyDataSetChanged();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public /* bridge */ /* synthetic */ void convert(BaseViewHolder r10, CategoryTitleEntity r11) {
        a(r10, r11);
    }
}
