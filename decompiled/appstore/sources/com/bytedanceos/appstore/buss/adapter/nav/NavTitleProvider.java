package com.bytedanceos.appstore.buss.adapter.nav;

import android.view.View;
import com.bytedanceos.appstore.buss.constant.NavItemType;
import com.bytedanceos.appstore.buss.entity.NavTitleEntity;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.provider.BaseNodeProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.obric.appstore.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00060\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/bytedanceos/appstore/buss/adapter/nav/NavTitleProvider;", "Lcom/chad/library/adapter/base/provider/BaseNodeProvider;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "helper", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "item", "", "a", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/chad/library/adapter/base/entity/node/BaseNode;)V", "Landroid/view/View;", "view", "data", "", "position", "b", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Landroid/view/View;Lcom/chad/library/adapter/base/entity/node/BaseNode;I)V", "Lkotlin/Function1;", "Lcom/bytedanceos/appstore/buss/entity/NavTitleEntity;", "Lkotlin/jvm/functions/Function1;", "listener", "getItemViewType", "()I", "itemViewType", "getLayoutId", "layoutId", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class NavTitleProvider extends BaseNodeProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1 f8395a;

    public void a(BaseViewHolder r10, BaseNode r11) {
        q.g(r10, "helper");
        q.g(r11, "item");
        NavTitleEntity r12 = (NavTitleEntity) r11;
        int r13 = r12.getJsonType();
        if (r13 != 1) goto L5;
        r10.setGone(R.id.tv_nav_title, false);
        r10.setGone(R.id.iv_nav_dot, false);
        r10.setGone(R.id.iv_dotted_line, true);
        r10.setText(R.id.tv_nav_title, r12.getTitle());
        boolean r14 = r12.getSelected();
        int r15 = R.color.tv_nav_un_selector;
        if (r14 == false) goto L11;
        int r16 = R.color.tv_nav_selector;
    L12:
        r10.setTextColorRes(R.id.tv_nav_title, r16);
        if (r12.getSelected() == false) goto L15;
        r15 = R.color.tv_nav_selector;
    L15:
        r10.setTextColorRes(R.id.tv_count, r15);
        if (r12.getSelected() == false) goto L18;
        int r17 = r12.getPressId();
    L19:
        r10.setImageResource(R.id.iv_nav_dot, r17);
    L20:
        r10.setVisible(R.id.tv_count, r12.getShowCount());
        r10.setText(R.id.tv_count, String.valueOf(r12.getAppCount()));
        return;
    L18:
        r17 = r12.getNormalId();
        goto L19
    L11:
        r16 = R.color.tv_nav_un_selector;
        goto L12
    L5:
        if (r13 == 2) goto L7;
        r10.setGone(R.id.tv_nav_title, true);
        r10.setGone(R.id.iv_nav_dot, true);
        r10.setGone(R.id.iv_dotted_line, true);
        goto L20
    L7:
        r10.setGone(R.id.tv_nav_title, true);
        r10.setGone(R.id.iv_nav_dot, true);
        r10.setGone(R.id.iv_dotted_line, false);
        goto L20
    }

    public void b(BaseViewHolder r10, View r11, BaseNode r12, int r13) {
        q.g(r10, "helper");
        q.g(r11, "view");
        q.g(r12, "data");
        if (((NavTitleEntity) r12).getJsonType() != 1) goto L6;
        this.f8395a.invoke(r12);
        return;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public /* bridge */ /* synthetic */ void convert(BaseViewHolder r10, BaseNode r11) {
        a(r10, r11);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int getItemViewType() {
        return NavItemType.NAV_TITLE_TYPE.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int getLayoutId() {
        return R.layout.tv_item_nav_title;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public /* bridge */ /* synthetic */ void onClick(BaseViewHolder r10, View r11, BaseNode r12, int r13) {
        b(r10, r11, r12, r13);
    }
}
