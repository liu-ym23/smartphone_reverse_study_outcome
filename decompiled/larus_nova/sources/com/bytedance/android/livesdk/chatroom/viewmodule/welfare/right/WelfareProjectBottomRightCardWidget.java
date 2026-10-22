package com.bytedance.android.livesdk.chatroom.viewmodule.welfare.right;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.welfare.utils.WelfareAppLogger;
import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import com.bytedance.android.livesdk.config.oy0;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.SettingKeyUtils;
import com.bytedance.android.livesdk.utils.q4;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdkapi.depend.model.live.WelfareProjectInfo;
import com.bytedance.frameworks.baselib.network.http.util.UrlBuilder;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.n;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/welfare/right/WelfareProjectBottomRightCardWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/welfare/right/WelfareProjectBottomRightCardPresenter$IView;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WelfareProjectBottomRightCardWidget extends RoomRecyclableWidget implements WelfareProjectBottomRightCardPresenter.IView {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f117640i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WelfareProjectBottomRightCardPresenter f117641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IHybridComponent f117642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FrameLayout f117643c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageView f117644d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Disposable f117645e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public q4.b f117646f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f117647g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public e f117648h;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_welfare_project_bottom_right_card_widget;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.IWidget
    public final /* synthetic */ String getLogTag() {
        return IWidget.CC.$default$getLogTag(this);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        FrameLayout r100 = this.f117643c;
        if (r100 == null) goto L6;
        r100.removeAllViews();
    L6:
        if (SettingKeyUtils.b() == false) goto L12;
        IHybridComponent r101 = this.f117642b;
        if (r101 == null) goto L11;
        r101.release();
    L11:
        this.f117642b = null;
    L12:
        WelfareProjectBottomRightCardPresenter r102 = this.f117641a;
        if (r102 == null) goto L15;
        r102.detachView();
    L15:
        this.f117641a = null;
        Disposable r103 = this.f117645e;
        if (r103 == null) goto L18;
        r103.dispose();
    L18:
        this.f117645e = null;
    }

    public final JSONObject wq() {
        DataCenter r100 = this.dataCenter;
        if (r100 == null) goto L5;
        com.bytedance.android.livesdk.vs.f r101 = com.bytedance.android.livesdk.vs.f.a(r100);
        HashMap r102 = new HashMap();
        o r103 = r101.b(ju2.f.class);
        if (r103 == null) goto L9;
        r103.a(r102);
    L9:
        o r104 = r101.b(iu2.a.class);
        if (r104 == null) goto L12;
        r104.a(r102);
    L12:
        JSONObject r105 = new JSONObject();
        Iterator<Map.Entry<String, String>> r106 = r102.entrySet().iterator();
    L14:
        if (r106.hasNext() == false) goto L20;
        Map.Entry<String, String> r107 = r106.next();
        r105.put(r107.getKey(), r107.getValue());     // Catch: JSONException -> L18
    L18:
        e = move-exception;
        ALogger.w("WelfareProjectCardWidget", "put json with err; err=" + e.getMessage());
        goto L14
    L20:
        return r105;
    L5:
        return new JSONObject();
    }

    public WelfareProjectBottomRightCardWidget() {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        this.f117643c = (FrameLayout) this.contentView.findViewById(R.id.welfare_card_container);
        ImageView r101 = (ImageView) this.contentView.findViewById(R.id.iv_close);
        this.f117644d = r101;
        r3.a(r101, s1.B(R.string.ttlive_a11y_close));
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [T, com.bytedance.android.annie.api.card.IHybridComponent] */
    /* JADX WARN: Type inference failed for: r4v18, types: [T, com.bytedance.android.annie.api.card.HybridCard] */
    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r110) {
        ConcurrentHashMap<String, q4.b> r111 = q4.c.f159141a;
        Intrinsics.checkNotNullParameter("WelfareCardShow", "key");
        this.f117646f = q4.c.f159141a.remove("WelfareCardShow");
        WelfareProjectBottomRightCardPresenter r112 = new WelfareProjectBottomRightCardPresenter();
        this.f117641a = r112;
        r112.g0(this);
        RoomContext r113 = getRoomContext();
        Object r100 = null;
        if (r113 == null) goto L9;
        n<WelfareProjectInfo> r114 = r113.getWelfareProjectInfo();
        if (r114 == null) goto L9;
        WelfareProjectInfo r115 = r114.getValue();
        if (r115 == null) goto L9;
        String r116 = r115.get_containerCardUrl();
    L10:
        this.f117647g = r116;
        if (r116 != null) goto L13;
    L84:
        ImageView r117 = this.f117644d;
        if (r117 == null) goto L87;
        UtilityKotlinExtentionsKt.t(r117);
    L87:
        ImageView r118 = this.f117644d;
        if (r118 == null) goto L90;
        r118.setOnClickListener(x0.a(new AnonymousClass2(this)));
    L90:
        DataCenter r119 = this.dataCenter;
        if (r119 == null) goto L97;
        Object r120 = r119.get("key_welfare_report_card_show", null);
        if ((r120 instanceof Boolean) == false) goto L96;
        r100 = r120;
    L96:
        r100 = (Boolean) r100;
    L97:
        Boolean r121 = Boolean.TRUE;
        if ((!Intrinsics.areEqual(r100, r121)) == false) goto L116;
        DataCenter r101 = this.dataCenter;
        if (r101 == null) goto L102;
        r101.put("key_welfare_report_card_show", r121);
    L102:
        RoomContext r122 = getRoomContext();
        if (r122 == null) goto L109;
        n<WelfareProjectInfo> r123 = r122.getWelfareProjectInfo();
        if (r123 == null) goto L109;
        WelfareProjectInfo r124 = r123.getValue();
        if (r124 == null) goto L109;
        long r102 = r124.getProjectId();
    L110:
        WelfareAppLogger.k(r102);
        return;
    L109:
        r102 = 0;
        goto L110
    L116:
        return;
    L13:
        if (r116.length() != 0) goto L15;
        boolean r103 = true;
    L16:
        if (r103 == true) goto L84;
        UrlBuilder r104 = new UrlBuilder(WelfareAppLogger.b(r116));
        r104.addParam("welfare_card_type", "vertical");
        Ref.ObjectRef r125 = new Ref.ObjectRef();
        ?? r105 = this.f117642b;
        r125.element = r105;
        if (r105 != 0) goto L23;
        String r106 = this.f117647g;
        if (r106 == null) goto L23;
        r125.element = ((IBrowserService) k.n(IBrowserService.class)).getHybridCard(this.context, x6.a.b(r106), new h(this));
    L23:
        IHybridComponent r107 = (IHybridComponent) r125.element;
        if (r107 == null) goto L26;
        View r108 = r107.getHybridView();
    L28:
        if ((r108 instanceof WebView) == false) goto L31;
        r108.setBackgroundColor(0);
        ((WebView) r108).setVisibility(8);
    L31:
        if (r108 == null) goto L33;
        r108.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    L33:
        if (r108 == null) goto L35;
        ViewParent r109 = r108.getParent();
    L36:
        if (r109 == null) goto L41;
        Object r126 = r108.getParent();
        if ((r126 instanceof View) == true) goto L40;
        r126 = null;
    L40:
        r108 = (View) r126;
        goto L33
    L41:
        if (r108 == null) goto L46;
        FrameLayout r127 = this.f117643c;
        if (r127 == null) goto L46;
        r127.addView(r108, 0);
    L46:
        if (v.a() == false) goto L61;
        TextView r128 = new TextView(this.context);
        String r129 = "h5";
        if (SettingKeyUtils.b() == true) goto L50;
        r128.setText("h5");
    L58:
        r128.setBackgroundColor(FakePickerAvatarCreator.GREEN);
        r128.setTextColor(-1);
        FrameLayout.LayoutParams r130 = new FrameLayout.LayoutParams(-2, -2);
        r130.gravity = 8388659;
        FrameLayout r131 = this.f117643c;
        if (r131 == null) goto L61;
        r131.addView(r128, r130);
        goto L61
    L50:
        IHybridComponent r132 = this.f117642b;
        if (r132 == null) goto L53;
        IHybridComponent.HybridType r133 = r132.hybridType();
    L55:
        if (r133 != IHybridComponent.HybridType.LYNX) goto L57;
        r129 = "lynx";
    L57:
        r128.setText(r129);
        goto L58
    L53:
        r133 = null;
    L61:
        View r134 = new View(getContext());
        r134.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        FrameLayout r135 = this.f117643c;
        if (r135 == null) goto L64;
        r135.addView(r134);
    L64:
        FrameLayout r136 = this.f117643c;
        if (r136 == null) goto L67;
        r136.setFocusable(true);
    L67:
        FrameLayout r137 = this.f117643c;
        if (r137 == null) goto L70;
        r137.setFocusableInTouchMode(true);
    L70:
        r134.setBackground(new ColorDrawable(0));
        r3.a(this.f117643c, "公益卡片");
        if (SettingKeyUtils.b() == false) goto L75;
        this.f117642b = (IHybridComponent) r125.element;
    L75:
        if (SettingKeyUtils.b() == false) goto L80;
        IHybridComponent r138 = this.f117642b;
        if (r138 == null) goto L80;
        a7.a.a(r138, r104.build(), null, 2);
    L80:
        Disposable r139 = this.f117645e;
        if (r139 == null) goto L83;
        r139.dispose();
    L83:
        this.f117645e = Observable.timer(oy0.f120941a.getValue().intValue(), TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new i(this));
        goto L84
    L35:
        r109 = null;
        goto L36
    L26:
        r108 = null;
        goto L28
    L15:
        r103 = false;
    L9:
        r116 = null;
        goto L10
    }
}
