package com.bytedance.android.shopping.anchorv4.voavhs.base.elements;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.shopping.anchorv4.data.AnchorV4DataManager;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.components.LynxCardComponent;
import com.bytedance.android.shopping.anchorv4.helper.w;
import com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.l;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/base/elements/LynxCardView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/ActionHubAccessor;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/a;", "hub", "", "setActionHub", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LynxCardView extends FrameLayout implements ActionHubAccessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l f167845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f167846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.shopping.anchorv4.voavhs.base.design.a f167847c;

    public LynxCardView(Context r100) {
        this(r100, null, 0, 14);
    }

    public LynxCardView(Context r100, AttributeSet r101) {
        this(r100, r101, 0, 12);
    }

    public LynxCardView(Context r100, AttributeSet r101, int r102) {
        this(r100, r101, r102, 8);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final Action associatedAction() {
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final Object descriptionVO() {
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final com.bytedance.android.shopping.anchorv4.voavhs.base.design.a actionHub() {
        return this.f167847c;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final void dispatchPossibleShow() {
        ActionHubAccessor.DefaultImpls.b(this);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final String getOnLimitClickBindKey(Action r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        return ActionHubAccessor.DefaultImpls.c(r100);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public void setActionHub(com.bytedance.android.shopping.anchorv4.voavhs.base.design.a r100) {
        Intrinsics.checkNotNullParameter(r100, "hub");
        this.f167847c = r100;
    }

    public LynxCardView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f167847c = null;
        this.f167846b = "";
    }

    public static void a(LynxCardView r110, LynxCardComponent r210, boolean r211, int r212) {
        boolean r100 = false;
        if ((r212 & 4) == 0) goto L5;
        boolean r101 = false;
    L6:
        if (r210 != null) goto L8;
        r110.setVisibility(8);
        return;
    L8:
        r110.getClass();
        String r102 = r210.getData();
        if (r102 == null) goto L13;
        JSONObject r103 = k.w(r102);
        if (r103 == null) goto L13;
        Map<String, ? extends Object> r104 = com.bytedance.android.shopping.hybrid.a.b(r103);
    L14:
        String r105 = r210.getSchema();
        if (r105 == null) goto L93;
        Uri.Builder r106 = UriProtector.parse(r105).buildUpon();
        if (r104 == null) goto L22;
        Iterator<Map.Entry<String, ? extends Object>> r107 = r104.entrySet().iterator();
    L20:
        if (r107.hasNext() == false) goto L22;
        Map.Entry<String, ? extends Object> r108 = r107.next();
        r106.appendQueryParameter(r108.getKey(), r108.getValue().toString());
    L22:
        String r109 = AnchorV4DataManager.f166338d;
        if (r109 == null) goto L25;
        r106.appendQueryParameter(LocationMonitorConst.IDENTIFIER, r109);
    L25:
        String r111 = r106.build().toString();
        l r112 = r110.f167845a;
        int r113 = -2;
        if (r112 == null) goto L67;
        if (r110.f167846b.length() <= 0) goto L30;
        boolean r114 = true;
    L31:
        if (r114 == true) goto L90;
    L46:
        r112.renderTemplate(r111, r104);
        View r115 = r112.getHybridView();
        if (r115 == null) goto L54;
        ViewGroup.LayoutParams r116 = r115.getLayoutParams();
        if (r116 == null) goto L54;
        if (r116.height != (-2)) goto L54;
        r100 = true;
    L54:
        if (r100 == r210.getWrapContent()) goto L86;
        View r117 = r112.getHybridView();
        if (r117 == null) goto L86;
        ViewGroup.LayoutParams r118 = r117.getLayoutParams();
        if (r210.getWrapContent() == true) goto L65;
        int r119 = r210.getHeight();
        if (r119 != null) goto L64;
        r119 = 60;
    L64:
        r113 = com.bytedance.android.shopping.extensions.b.b(r119);
    L65:
        r118.height = r113;
        Unit r120 = Unit.INSTANCE;
        r117.setLayoutParams(r118);
    L86:
        r110.f167846b = r111;
        return;
    L90:
        Uri r121 = UriProtector.parse(r110.f167846b);     // Catch: Exception -> L40
        Uri r122 = UriProtector.parse(r111);     // Catch: Exception -> L40
        if (Intrinsics.areEqual(r121.getScheme(), r122.getScheme()) == true) goto L36;
    L42:
        boolean r123 = false;
    L43:
        if (r123 == false) goto L46;
        if (r104 == null) goto L46;
        r112.updateData(r104);
        goto L86
    L36:
        if (Intrinsics.areEqual(r121.getAuthority(), r122.getAuthority()) == false) goto L42;
        if (Intrinsics.areEqual(r121.getPath(), r122.getPath()) == false) goto L42;
        r123 = true;
    L40:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L42
    L30:
        r114 = false;
        goto L31
    L67:
        if ((r110.getContext() instanceof Activity) == false) goto L69;
        Context r124 = r110.getContext();
    L72:
        l r125 = ECLiveHybridUtil.b(r124, r111, r104, null, new b(r104, r101), null, null, false, null, null, false, 4072);
        r110.f167845a = r125;
        w.a.e(w.f166998b, r125, r124, null, 12);
        if (r210.getWrapContent() == false) goto L75;
        int r126 = -2;
    L80:
        l r127 = r110.f167845a;
        if (r127 == null) goto L85;
        View r128 = r127.getHybridView();
        if (r128 == null) goto L85;
        r110.addView(r128, new FrameLayout.LayoutParams(-1, r126));
    L85:
        Unit r129 = Unit.INSTANCE;
        goto L86
    L75:
        int r130 = r210.getHeight();
        if (r130 != null) goto L79;
        r130 = 60;
    L79:
        r126 = com.bytedance.android.shopping.extensions.b.b(r130);
        goto L80
    L69:
        Context r131 = r110.getContext();
        if (r131 == null) goto L88;
        r124 = ((ContextThemeWrapper) r131).getBaseContext();
        goto L72
    L88:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ContextThemeWrapper");
    L93:
        return;
    L13:
        r104 = null;
        goto L14
    L5:
        r101 = r211;
        goto L6
    }
}
