package com.bytedanceos.appstore.buss.adapter.onetype;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedanceos.appstore.buss.entity.AppCommentEntity;
import com.bytedanceos.appstore.buss.widget.AppCommentView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0018\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/bytedanceos/appstore/buss/adapter/onetype/CommentAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/bytedanceos/appstore/buss/entity/AppCommentEntity;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "<init>", "()V", "Landroid/view/ViewGroup;", "parent", "", "layoutResId", "createBaseViewHolder", "(Landroid/view/ViewGroup;I)Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "holder", "item", "", "a", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/bytedanceos/appstore/buss/entity/AppCommentEntity;)V", "", "Ljava/lang/String;", "getPackageName", "()Ljava/lang/String;", "b", "(Ljava/lang/String;)V", "packageName", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CommentAdapter extends BaseQuickAdapter<AppCommentEntity, BaseViewHolder> implements LoadMoreModule {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f8401a;

    public CommentAdapter() {
        super(0, null, 2, null);
        this.f8401a = "";
    }

    public void a(BaseViewHolder r10, AppCommentEntity r11) {
        q.g(r10, "holder");
        q.g(r11, "item");
        View r12 = r10.itemView;
        q.e(r12, "null cannot be cast to non-null type com.bytedanceos.appstore.buss.widget.AppCommentView");
        ((AppCommentView) r12).setNewData(r11);
    }

    public final void b(String r10) {
        this.f8401a = r10;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public /* bridge */ /* synthetic */ void convert(BaseViewHolder r10, AppCommentEntity r11) {
        a(r10, r11);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public BaseViewHolder createBaseViewHolder(ViewGroup r10, int r11) {
        q.g(r10, "parent");
        Context r12 = r10.getContext();
        q.f(r12, "getContext(...)");
        AppCommentView r13 = new AppCommentView(r12);
        r13.setPackageName(this.f8401a);
        return new BaseViewHolder(r13);
    }
}
