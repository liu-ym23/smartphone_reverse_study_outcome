package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.config.bg1;
import com.bytedance.android.livesdk.config.yg0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.huawei.hms.android.SystemUtils;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/AnchorInteractBackgroundWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Ljo1/b;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorInteractBackgroundWidget extends MiddlewareRoomWidget implements Observer<KVData>, jo1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.ui.framework.d f113037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.ui.framework.c f113038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f113039c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Configuration f113040d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f113041e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f113042f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f113043g;

    @Override // com.bytedance.android.livesdk.ability.IAbility
    public final /* synthetic */ void onAbilityClear() {
        IAbility.CC.$default$onAbilityClear(this);
    }

    public final HSImageView Tb() {
        com.bytedance.android.livesdk.chatroom.ui.framework.d r100 = this.f113037a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.Tb();
    }

    public AnchorInteractBackgroundWidget() {
        this.f113039c = -1;
        this.f113041e = "SAMSUNG";
        this.f113042f = SystemUtils.PRODUCT_HUAWEI;
        this.f113043g = SystemUtils.PRODUCT_HONOR;
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget, com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        this.f113037a = ho1.a.i(getComponentContext());
        this.f113038b = ho1.a.d(getComponentContext());
        h70.b r100 = getComponentContext();
        if (r100 == null) goto L5;
        ho1.a.p(r100, jo1.b.class, this);
    L5:
        this.dataCenter.observe("cmd_adjust_video_interact_stream_bottom", this);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        h70.b r100 = getComponentContext();
        if (r100 == null) goto L5;
        ho1.a.q(r100, jo1.b.class);
    L5:
        DataCenter r101 = this.dataCenter;
        if (r101 == null) goto L8;
        r101.removeObserver(this);
    L8:
        this.f113038b = null;
        this.f113037a = null;
    }

    @Override // jo1.b
    public final void Go(zg1.z0 r100) {
        int r101 = r100.f572034a;
        boolean r102 = true;
        if (r101 == 0) goto L5;
        if (r101 != 1) goto L10;
        UIUtils.setViewVisibility(Tb(), 8);
    L10:
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == false) goto L21;
        if (StatusBarUtil.JUMP_FROM_LIVE_PLAY_ACTIVITY == false) goto L21;
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L21;
        if (Tb() == null) goto L21;
        HSImageView r103 = Tb();
        if (r103 == null) goto L21;
        r103.setPadding(-3, -StatusBarUtil.getStatusBarHeight(getContext()), -3, -3);
    L21:
        if (PadConfigUtils.c() == false) goto L38;
        int r104 = this.f113039c;
        if (r104 != (-1)) goto L28;
        if (e5.n() == false) goto L31;
    L30:
        r102 = false;
    L31:
        if (r102 == false) goto L33;
        return;
    L33:
        if (Tb() == null) goto L40;
        HSImageView r105 = Tb();
        if (r105 == null) goto L41;
        r105.setPadding(-3, 0, -3, -3);
        return;
    L41:
        return;
    L40:
        return;
    L28:
        if (e5.o(r104) == true) goto L30;
    L38:
        return;
    L5:
        if (bg1.a() == true) goto L10;
        ImageLoader.bindImage(Tb(), yg0.f121687a.getValue());
        UIUtils.setViewVisibility(Tb(), 0);
        goto L10
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (isViewValid() == false) goto L62;
        ViewGroup.LayoutParams r102 = null;
        if (r101 == null) goto L7;
        String r103 = r101.getKey();
    L9:
        if (TextUtils.isEmpty(r103) == true) goto L63;
        if (r101 == null) goto L12;
        Object r104 = r101.getData();
    L13:
        if (r104 == null) goto L69;
        String r105 = r101.getKey();
        if (r105.hashCode() == (-81738768)) goto L19;
        return;
    L19:
        if (r105.equals("cmd_adjust_video_interact_stream_bottom") == false) goto L64;
        Pair r106 = (Pair) r101.getData();
        if (r106 != null) goto L23;
        return;
    L23:
        if (Tb() == null) goto L66;
        HSImageView r107 = Tb();
        if (r107 == null) goto L27;
        r102 = r107.getLayoutParams();
    L27:
        if (r102 == null) goto L61;
        FrameLayout.LayoutParams r108 = (FrameLayout.LayoutParams) r102;
        Object r109 = r106.getFirst();
        Intrinsics.checkNotNull(r109);
        r108.topMargin = ((Number) r109).intValue();
        int r110 = s1.y();
        if (FoldScreenUtils.f() == false) goto L57;
        Configuration r111 = this.f113040d;
        if (r111 == null) goto L57;
        if (FoldScreenUtils.c(r111) != 0) goto L57;
        if (((Number) r106.getSecond()).intValue() < 0) goto L37;
        r110 = ((Number) r106.getSecond()).intValue();
        goto L57
    L37:
        float r112 = s1.w();
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == false) goto L52;
        if (StatusBarUtil.JUMP_FROM_LIVE_PLAY_ACTIVITY == false) goto L52;
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L52;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r113 = this.f113038b;
        if (r113 == null) goto L46;
        boolean r114 = r113.dg();
    L47:
        if (r114 == true) goto L52;
        if (Intrinsics.areEqual(this.f113041e, FoldScreenUtils.d()) == false) goto L56;
        r112 = r112 + s1.A();
    L56:
        r110 = (int) (r112 * 0.5625f);
        goto L57
    L46:
        r114 = false;
    L52:
        if (Intrinsics.areEqual(this.f113042f, FoldScreenUtils.d()) == false) goto L54;
    L55:
        r112 = r112 - s1.A();
        goto L56
    L54:
        if (Intrinsics.areEqual(this.f113043g, FoldScreenUtils.d()) == false) goto L56;
    L57:
        r108.width = r110;
        r108.gravity |= 1;
        HSImageView r115 = Tb();
        if (r115 == null) goto L67;
        r115.setLayoutParams(r108);
        return;
    L67:
        return;
    L61:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L66:
        return;
    L64:
        return;
    L69:
        return;
    L12:
        r104 = null;
        goto L13
    L63:
        return;
    L7:
        r103 = null;
        goto L9
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        if (r100 == null) goto L5;
        int r101 = r100.orientation;
    L6:
        this.f113039c = r101;
        this.f113040d = r100;
        return;
    L5:
        r101 = 0;
        goto L6
    }
}
