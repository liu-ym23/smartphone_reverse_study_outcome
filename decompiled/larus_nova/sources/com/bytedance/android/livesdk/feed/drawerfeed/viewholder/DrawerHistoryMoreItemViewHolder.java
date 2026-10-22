package com.bytedance.android.livesdk.feed.drawerfeed.viewholder;

import android.view.View;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.business.depend.feed.IDrawerFeedAction;
import java.util.LinkedHashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/feed/drawerfeed/viewholder/DrawerHistoryMoreItemViewHolder;", "Lcom/bytedance/android/live/core/viewholder/BaseViewHolder;", "Lcom/bytedance/android/livesdk/feed/drawerfeed/viewholder/k0;", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DrawerHistoryMoreItemViewHolder extends BaseViewHolder<k0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f123890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IDrawerFeedAction f123891b;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DrawerHistoryMoreItemViewHolder f123892a;

        public a(DrawerHistoryMoreItemViewHolder r100) {
            this.f123892a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            IDrawerFeedAction r101 = this.f123892a.f123891b;
            if (r101 == null) goto L5;
            r101.enterHistory();
        L5:
            this.f123892a.getClass();
            LinkedHashMap r102 = new LinkedHashMap();
            r102.put("enter_from_merge", "drawer_hot");
            r102.put("enter_method", "live_history_card");
            IUserService r103 = (IUserService) jc1.k.f(IUserService.class);
            if (r103 == null) goto L11;
            com.bytedance.android.livesdk.user.f r104 = r103.user();
            if (r104 == null) goto L11;
            String r105 = r104.n();
            if (r105 == null) goto L11;
        L12:
            r102.put("user_id", r105);
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_history_all_click", r102, new Object[0]);
            return;
        L11:
            r105 = "";
            goto L12
        }
    }

    public static void T3() {
        LinkedHashMap r100 = new LinkedHashMap();
        r100.put("enter_from_merge", "drawer_hot");
        r100.put("enter_method", "live_history_card");
        IUserService r101 = (IUserService) jc1.k.f(IUserService.class);
        if (r101 == null) goto L8;
        com.bytedance.android.livesdk.user.f r102 = r101.user();
        if (r102 == null) goto L8;
        String r103 = r102.n();
        if (r103 == null) goto L8;
    L9:
        r100.put("user_id", r103);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_history_all_show", r100, new Object[0]);
        return;
    L8:
        r103 = "";
        goto L9
    }

    public DrawerHistoryMoreItemViewHolder(View r100, IDrawerFeedAction r101) {
        super(r100);
        this.f123890a = r100;
        this.f123891b = r101;
        if (r100 == null) goto L6;
        r100.setOnClickListener(new a(this));
        return;
    }

    @Override // com.bytedance.android.live.core.viewholder.BaseViewHolder
    public final /* bridge */ /* synthetic */ void bind(k0 r100, int r101) {
        T3();
    }
}
