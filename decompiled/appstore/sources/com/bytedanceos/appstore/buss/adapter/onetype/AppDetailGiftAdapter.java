package com.bytedanceos.appstore.buss.adapter.onetype;

import android.widget.TextView;
import com.bytedanceos.appstore.buss.entity.AppDetailGiftEntity;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.obric.appstore.R;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import x7.k0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedanceos/appstore/buss/adapter/onetype/AppDetailGiftAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/bytedanceos/appstore/buss/entity/AppDetailGiftEntity;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "<init>", "()V", "holder", "item", "", "a", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/bytedanceos/appstore/buss/entity/AppDetailGiftEntity;)V", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AppDetailGiftAdapter extends BaseQuickAdapter<AppDetailGiftEntity, BaseViewHolder> {
    public AppDetailGiftAdapter() {
        super(R.layout.tv_item_app_detail_gift, null, 2, null);
    }

    public void a(BaseViewHolder r10, AppDetailGiftEntity r11) {
        q.g(r10, "holder");
        q.g(r11, "item");
        k0 r12 = k0.a(r10.itemView);
        q.f(r12, "bind(...)");
        r12.f25639g.setText(r11.getName());
        r12.f25636d.setText(r11.getContent());
        TextView r13 = r12.f25638f;
        q.f(r13, "tvGet");
        if (r11.getIfReceived() != 1) goto L6;
        r13.setText(getContext().getString(R.string.gift_btn_use));
        r13.setEnabled(true);
        r13.setAlpha(1.0f);
    L9:
        r12.f25637e.setText(getContext().getString(R.string.gift_remain, new Object[]{r11.getRestCount()}));
        return;
    L6:
        if (Integer.parseInt(r11.getRestCount()) != 0) goto L8;
        r13.setText(getContext().getString(R.string.gift_btn_over));
        r13.setEnabled(false);
        r13.setAlpha(0.3f);
        goto L9
    L8:
        r13.setText(getContext().getString(R.string.gift_btn_get));
        r13.setEnabled(true);
        r13.setAlpha(1.0f);
        goto L9
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public /* bridge */ /* synthetic */ void convert(BaseViewHolder r10, AppDetailGiftEntity r11) {
        a(r10, r11);
    }
}
