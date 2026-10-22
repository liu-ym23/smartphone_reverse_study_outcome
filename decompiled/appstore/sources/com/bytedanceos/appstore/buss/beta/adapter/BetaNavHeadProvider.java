package com.bytedanceos.appstore.buss.beta.adapter;

import android.os.Bundle;
import android.view.View;
import com.bytedanceos.appstore.buss.beta.entity.BetaNavEntityWrap;
import com.bytedanceos.appstore.buss.beta.entity.BetaNavTitleEntity;
import com.bytedanceos.appstore.buss.constant.NavItemType;
import com.chad.library.adapter.base.BaseNodeAdapter;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.provider.BaseNodeProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.obric.appstore.R;
import f9.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fRH\u0010\u0019\u001a6\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00060\u0010j\u0002`\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/bytedanceos/appstore/buss/beta/adapter/BetaNavHeadProvider;", "Lcom/chad/library/adapter/base/provider/BaseNodeProvider;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "helper", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "item", "", "a", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/chad/library/adapter/base/entity/node/BaseNode;)V", "Landroid/view/View;", "view", "data", "", "position", "b", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Landroid/view/View;Lcom/chad/library/adapter/base/entity/node/BaseNode;I)V", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isOpenSidebar", "Lcom/bytedanceos/appstore/buss/beta/entity/BetaNavTitleEntity;", "entity", "Lcom/bytedanceos/appstore/buss/beta/adapter/SelectNavListener;", "Lkotlin/jvm/functions/Function2;", "listener", "getItemViewType", "()I", "itemViewType", "getLayoutId", "layoutId", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BetaNavHeadProvider extends BaseNodeProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function2 f8402a;

    public void a(BaseViewHolder r10, BaseNode r11) {
        q.g(r10, "helper");
        q.g(r11, "item");
        if ((r11 instanceof BetaNavEntityWrap) == false) goto L5;
        BetaNavEntityWrap r12 = (BetaNavEntityWrap) r11;
    L6:
        if (r12 == null) goto L13;
        r10.setText(R.id.tv_nav_title, r12.getTitle());
        if (((BetaNavEntityWrap) r11).isExpanded() == false) goto L10;
        int r13 = R.drawable.ic_nav_up;
    L11:
        r10.setImageResource(R.id.iv_nav_icon, r13);
        r10.setText(R.id.tv_nav_count, String.valueOf(r12.getCountNum()));
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

    /* JADX WARN: Type inference failed for: r10v0, types: [com.chad.library.adapter.base.BaseNodeAdapter] */
    /* JADX WARN: Type inference failed for: r3v7, types: [com.chad.library.adapter.base.BaseNodeAdapter] */
    public void b(BaseViewHolder r18, View r19, BaseNode r20, int r21) {
        q.g(r18, "helper");
        q.g(r19, "view");
        q.g(r20, "data");
        if ((r20 instanceof BetaNavEntityWrap) == false) goto L5;
        BetaNavEntityWrap r10 = (BetaNavEntityWrap) r20;
    L6:
        if (r10 != null) goto L8;
        return;
    L8:
        if (r10.isExpanded() == false) goto L12;
        ?? r11 = getAdapter();
        if (r11 == 0) goto L23;
        BaseNodeAdapter.collapse$default(r11, r21, true, false, null, 12, null);
    L23:
        Bundle r12 = new Bundle();
        if (r10.isExpanded() == false) goto L26;
        String r13 = "collapse";
    L27:
        r12.putString("sidebar_expansion_type", r13);
        r12.putString("sidebar_group_name", ((BetaNavEntityWrap) r20).getTitle());
        b.b("sidebar_expansion_state", r12);
        return;
    L26:
        r13 = "expand";
        goto L27
    L12:
        ?? r14 = getAdapter();
        if (r14 == 0) goto L15;
        BaseNodeAdapter.expand$default(r14, r21, false, false, null, 12, null);
    L15:
        BetaNavEntityWrap r15 = (BetaNavEntityWrap) r20;
        List<BetaNavTitleEntity> r16 = r15.getItems();
        if (r16 == null) goto L23;
        if (r16.isEmpty() == true) goto L23;
        BetaNavTitleEntity r17 = r15.getItems().get(0);
        if (r17.getJsonType() != 1) goto L23;
        this.f8402a.mo0invoke(Boolean.TRUE, r17);
        goto L23
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
