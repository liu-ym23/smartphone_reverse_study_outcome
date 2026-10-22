package com.bytedanceos.appstore.buss.adapter.nav;

import android.view.View;
import com.bytedanceos.appstore.buss.constant.NavItemType;
import com.bytedanceos.appstore.buss.entity.NavEntityWrap;
import com.bytedanceos.appstore.buss.entity.NavTitleEntity;
import com.chad.library.adapter.base.BaseNodeAdapter;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.provider.BaseNodeProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.obric.appstore.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00060\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/bytedanceos/appstore/buss/adapter/nav/NavHeadProvider;", "Lcom/chad/library/adapter/base/provider/BaseNodeProvider;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "helper", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "item", "", "a", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/chad/library/adapter/base/entity/node/BaseNode;)V", "Landroid/view/View;", "view", "data", "", "position", "b", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Landroid/view/View;Lcom/chad/library/adapter/base/entity/node/BaseNode;I)V", "Lkotlin/Function1;", "Lcom/bytedanceos/appstore/buss/entity/NavTitleEntity;", "Lkotlin/jvm/functions/Function1;", "listener", "getItemViewType", "()I", "itemViewType", "getLayoutId", "layoutId", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class NavHeadProvider extends BaseNodeProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1 f8394a;

    public void a(BaseViewHolder r10, BaseNode r11) {
        q.g(r10, "helper");
        q.g(r11, "item");
        if ((r11 instanceof NavEntityWrap) == false) goto L5;
        NavEntityWrap r12 = (NavEntityWrap) r11;
    L6:
        if (r12 == null) goto L13;
        r10.setText(R.id.tv_nav_title, r12.getTitle());
        if (((NavEntityWrap) r11).isExpanded() == false) goto L10;
        int r13 = R.drawable.ic_nav_up;
    L11:
        r10.setImageResource(R.id.iv_nav_icon, r13);
        r10.setText(R.id.tv_nav_count, String.valueOf(r12.getAppCount()));
        r10.setVisible(R.id.tv_nav_count, r12.getShowCount());
        return;
    L10:
        r13 = R.drawable.ic_nav_down;
        goto L11
    L13:
        return;
    L5:
        r12 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.chad.library.adapter.base.BaseNodeAdapter] */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.chad.library.adapter.base.BaseNodeAdapter] */
    public void b(BaseViewHolder r17, View r18, BaseNode r19, int r20) {
        q.g(r17, "helper");
        q.g(r18, "view");
        q.g(r19, "data");
        if ((r19 instanceof NavEntityWrap) == false) goto L5;
        NavEntityWrap r10 = (NavEntityWrap) r19;
    L6:
        if (r10 != null) goto L8;
        return;
    L8:
        if (r10.isExpanded() == false) goto L12;
        ?? r11 = getAdapter();
        if (r11 == 0) goto L20;
        BaseNodeAdapter.collapse$default(r11, r20, false, false, null, 12, null);
        return;
    L20:
        return;
    L12:
        ?? r12 = getAdapter();
        if (r12 == 0) goto L15;
        BaseNodeAdapter.expand$default(r12, r20, false, false, null, 12, null);
    L15:
        NavTitleEntity r13 = ((NavEntityWrap) r19).getItems().get(0);
        if (r13.getJsonType() != 1) goto L22;
        this.f8394a.invoke(r13);
        return;
    L22:
        return;
    L5:
        r10 = null;
        goto L6
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public /* bridge */ /* synthetic */ void convert(BaseViewHolder r10, BaseNode r11) {
        a(r10, r11);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int getItemViewType() {
        return NavItemType.NAV_HEAD_TYPE.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int getLayoutId() {
        return R.layout.tv_item_nav_head;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public /* bridge */ /* synthetic */ void onClick(BaseViewHolder r10, View r11, BaseNode r12, int r13) {
        b(r10, r11, r12, r13);
    }
}
