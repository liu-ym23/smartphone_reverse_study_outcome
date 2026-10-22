package com.bytedanceos.appstore.buss.adapter.onetype;

import com.bytedanceos.appstore.buss.entity.AppFeedBackItemEntity;
import com.bytedanceos.common.utils.FeedBackUtil;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.obric.appstore.R;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import x7.n0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedanceos/appstore/buss/adapter/onetype/AppFeedBackAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/bytedanceos/appstore/buss/entity/AppFeedBackItemEntity;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "holder", "item", "", "a", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/bytedanceos/appstore/buss/entity/AppFeedBackItemEntity;)V", "Lcom/bytedanceos/common/utils/FeedBackUtil;", "Lcom/bytedanceos/common/utils/FeedBackUtil;", "feedBackImage", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AppFeedBackAdapter extends BaseQuickAdapter<AppFeedBackItemEntity, BaseViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FeedBackUtil f8400a;

    public void a(BaseViewHolder r10, AppFeedBackItemEntity r11) {
        q.g(r10, "holder");
        q.g(r11, "item");
        n0 r12 = n0.a(r10.itemView);
        q.f(r12, "bind(...)");
        r12.f25707c.setEnabled(true);
        if (r11.getUri() == null) goto L5;
        r12.f25706b.setVisibility(0);
        this.f8400a.y(getItemPosition(r11), r11.getUri(), r11.getAppPackageName(), r12.f25707c);
        return;
    L5:
        if (getItemPosition(r11) >= 4) goto L7;
        r12.f25707c.setVisibility(0);
        r12.f25707c.setImageResource(R.drawable.feedback_bg_selector);
    L8:
        r12.f25706b.setVisibility(8);
        return;
    L7:
        r12.f25707c.setVisibility(8);
        goto L8
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public /* bridge */ /* synthetic */ void convert(BaseViewHolder r10, AppFeedBackItemEntity r11) {
        a(r10, r11);
    }
}
