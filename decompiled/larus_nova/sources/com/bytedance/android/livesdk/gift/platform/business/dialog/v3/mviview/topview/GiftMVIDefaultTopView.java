package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.topview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode;
import com.bytedance.android.livesdk.gift.platform.business.config.GiftConfigKey;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickDefaultView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopEmptyState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopViewState;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class GiftMVIDefaultTopView extends BaseGiftMVIViewChildNode<GiftTopViewState, GiftTopEmptyState, GiftAction> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextView f128019m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final DataCenter f128020n;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GiftMVIDefaultTopView f128021a;

        public a(GiftMVIDefaultTopView r100) {
            this.f128021a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f128021a.o(new ClickDefaultView());
        }
    }

    @Override // com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode
    public final int s() {
        return R.layout.ttlive_top_default_view;
    }

    @Override // com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode
    public final void q() {
        TextView r100 = (TextView) r().findViewById(R.id.default_title);
        this.f128019m = r100;
        if (r100 == null) goto L5;
        r100.setOnClickListener(new a(this));
    L5:
        boolean r101 = ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).isLogin();
        com.bytedance.android.livesdk.gift.platform.business.config.m r102 = (com.bytedance.android.livesdk.gift.platform.business.config.m) com.bytedance.android.livesdk.gift.util.b.a().d(com.bytedance.android.livesdk.gift.platform.business.config.m.class);
        IRoom r103 = null;
        IRoom r104 = (IRoom) this.f128020n.get("data_room", null);
        if ((r104 instanceof Room) == false) goto L9;
        r103 = r104;
    L9:
        Room r105 = (Room) r103;
        if (r102.j(r101) == false) goto L15;
        TextView r106 = this.f128019m;
        if (r106 == null) goto L16;
        r106.setText(((Number) com.bytedance.android.livesdk.gift.util.b.a().c(GiftConfigKey.KEY_GIFT_DIALOG_DEFAULT_TOP_TEXT, Integer.valueOf(R.string.ttlive_gift_top_bar_xt_default_text))).intValue());
        return;
    L16:
        return;
    }

    @Override // com.bytedance.android.anya.z
    public final void a(com.bytedance.android.anya.dsl.f<GiftTopViewState> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$bindToParent");
        GiftMVIDefaultTopView$bindToParent$1 r101 = GiftMVIDefaultTopView$bindToParent$1.INSTANCE;
        Collection r102 = r100.f41595a;
        ArrayList r103 = (ArrayList) r102;
        r103.add(new com.bytedance.android.anya.dsl.j(this, r101));
    }

    @Override // com.bytedance.android.anya.BaseMVIView
    public final void b(com.bytedance.android.anya.k r100, MVIState r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$handleDiff");
        Intrinsics.checkNotNullParameter((GiftTopEmptyState) r101, "state");
    }

    public GiftMVIDefaultTopView(Context r100, ViewGroup r101, DataCenter r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "containerView");
        Intrinsics.checkNotNullParameter(r102, "dataCenter");
        super(r100, r101);
        this.f128020n = r102;
    }
}
