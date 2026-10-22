package com.bytedance.android.livesdk.chatroom.viewmodule.welfare;

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
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.welfare.utils.WelfareAppLogger;
import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import com.bytedance.android.livesdk.config.oy0;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.SettingKeyUtils;
import com.bytedance.android.livesdk.utils.q4;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdkapi.depend.model.live.WelfareProjectInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
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
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/welfare/WelfareProjectCardWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/welfare/WelfareProjectCardPresenter$IView;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WelfareProjectCardWidget extends RoomRecyclableWidget implements WelfareProjectCardPresenter.IView {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f117598h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WelfareProjectCardPresenter f117599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IHybridComponent f117600b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FrameLayout f117601c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageView f117602d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Disposable f117603e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public q4.b f117604f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f117605g;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_welfare_project_card_widget;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.IWidget
    public final /* synthetic */ String getLogTag() {
        return IWidget.CC.$default$getLogTag(this);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        FrameLayout r100 = this.f117601c;
        if (r100 == null) goto L6;
        r100.removeAllViews();
    L6:
        if (SettingKeyUtils.b() == false) goto L12;
        IHybridComponent r101 = this.f117600b;
        if (r101 == null) goto L11;
        r101.release();
    L11:
        this.f117600b = null;
    L12:
        WelfareProjectCardPresenter r102 = this.f117599a;
        if (r102 == null) goto L15;
        r102.detachView();
    L15:
        this.f117599a = null;
        Disposable r103 = this.f117603e;
        if (r103 == null) goto L18;
        r103.dispose();
    L18:
        this.f117603e = null;
    }

    public final JSONObject wq() {
        DataCenter r100 = this.dataCenter;
        if (r100 == null) goto L5;
        com.bytedance.android.livesdk.vs.f r101 = com.bytedance.android.livesdk.vs.f.a(r100);
        HashMap r102 = new HashMap();
        com.bytedance.android.livesdk.log.filter.o r103 = r101.b(ju2.f.class);
        if (r103 == null) goto L9;
        r103.a(r102);
    L9:
        com.bytedance.android.livesdk.log.filter.o r104 = r101.b(iu2.a.class);
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

    public WelfareProjectCardWidget() {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        this.f117601c = (FrameLayout) this.contentView.findViewById(R.id.welfare_card_container);
        ImageView r101 = (ImageView) this.contentView.findViewById(R.id.iv_close);
        this.f117602d = r101;
        r3.a(r101, s1.B(R.string.ttlive_a11y_close));
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [T, com.bytedance.android.annie.api.card.IHybridComponent] */
    /* JADX WARN: Type inference failed for: r3v16, types: [T, com.bytedance.android.annie.api.card.HybridCard] */
    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        ConcurrentHashMap<String, q4.b> r101 = q4.c.f159141a;
        Intrinsics.checkNotNullParameter("WelfareCardShow", "key");
        this.f117604f = q4.c.f159141a.remove("WelfareCardShow");
        WelfareProjectCardPresenter r102 = new WelfareProjectCardPresenter();
        this.f117599a = r102;
        r102.g0(this);
        RoomContext r103 = getRoomContext();
        if (r103 == null) goto L9;
        com.bytedance.live.datacontext.n<WelfareProjectInfo> r104 = r103.getWelfareProjectInfo();
        if (r104 == null) goto L9;
        WelfareProjectInfo r105 = r104.getValue();
        if (r105 == null) goto L9;
        String r106 = r105.get_containerCardUrl();
    L10:
        this.f117605g = r106;
        if (r106 != null) goto L13;
    L16:
        boolean r107 = true;
    L17:
        if (r107 == true) goto L84;
        Ref.ObjectRef r108 = new Ref.ObjectRef();
        ?? r109 = this.f117600b;
        r108.element = r109;
        if (r109 != 0) goto L23;
        String r110 = this.f117605g;
        if (r110 == null) goto L23;
        r108.element = ((IBrowserService) jc1.k.n(IBrowserService.class)).getHybridCard(this.context, x6.a.b(r110), new x(this));
    L23:
        IHybridComponent r111 = (IHybridComponent) r108.element;
        if (r111 == null) goto L26;
        View r112 = r111.getHybridView();
    L28:
        if ((r112 instanceof WebView) == false) goto L31;
        r112.setBackgroundColor(0);
        ((WebView) r112).setVisibility(8);
    L31:
        if (r112 == null) goto L33;
        r112.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    L33:
        if (r112 == null) goto L35;
        ViewParent r113 = r112.getParent();
    L36:
        if (r113 == null) goto L41;
        Object r114 = r112.getParent();
        if ((r114 instanceof View) == true) goto L40;
        r114 = null;
    L40:
        r112 = (View) r114;
        goto L33
    L41:
        if (r112 == null) goto L46;
        FrameLayout r115 = this.f117601c;
        if (r115 == null) goto L46;
        r115.addView(r112, 0);
    L46:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L61;
        TextView r116 = new TextView(this.context);
        String r117 = "h5";
        if (SettingKeyUtils.b() == true) goto L50;
        r116.setText("h5");
    L58:
        r116.setBackgroundColor(FakePickerAvatarCreator.GREEN);
        r116.setTextColor(-1);
        FrameLayout.LayoutParams r118 = new FrameLayout.LayoutParams(-2, -2);
        r118.gravity = 8388659;
        FrameLayout r119 = this.f117601c;
        if (r119 == null) goto L61;
        r119.addView(r116, r118);
        goto L61
    L50:
        IHybridComponent r120 = this.f117600b;
        if (r120 == null) goto L53;
        IHybridComponent.HybridType r121 = r120.hybridType();
    L55:
        if (r121 != IHybridComponent.HybridType.LYNX) goto L57;
        r117 = "lynx";
    L57:
        r116.setText(r117);
        goto L58
    L53:
        r121 = null;
    L61:
        View r122 = new View(getContext());
        r122.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        FrameLayout r123 = this.f117601c;
        if (r123 == null) goto L64;
        r123.addView(r122);
    L64:
        FrameLayout r124 = this.f117601c;
        if (r124 == null) goto L67;
        r124.setFocusable(true);
    L67:
        FrameLayout r125 = this.f117601c;
        if (r125 == null) goto L70;
        r125.setFocusableInTouchMode(true);
    L70:
        r122.setBackground(new ColorDrawable(0));
        r3.a(this.f117601c, "公益卡片");
        if (SettingKeyUtils.b() == false) goto L75;
        this.f117600b = (IHybridComponent) r108.element;
    L75:
        if (SettingKeyUtils.b() == false) goto L80;
        IHybridComponent r126 = this.f117600b;
        if (r126 == null) goto L80;
        a7.a.a(r126, this.f117605g, null, 2);
    L80:
        Disposable r127 = this.f117603e;
        if (r127 == null) goto L83;
        r127.dispose();
    L83:
        this.f117603e = Observable.timer(oy0.f120941a.getValue().intValue(), TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new y(this));
        goto L84
    L35:
        r113 = null;
        goto L36
    L26:
        r112 = null;
    L84:
        ImageView r128 = this.f117602d;
        if (r128 == null) goto L87;
        UtilityKotlinExtentionsKt.t(r128);
    L87:
        ImageView r129 = this.f117602d;
        if (r129 == null) goto L90;
        r129.setOnClickListener(x0.a(new AnonymousClass2(this)));
    L90:
        RoomContext r130 = getRoomContext();
        if (r130 == null) goto L97;
        com.bytedance.live.datacontext.n<WelfareProjectInfo> r131 = r130.getWelfareProjectInfo();
        if (r131 == null) goto L97;
        WelfareProjectInfo r132 = r131.getValue();
        if (r132 == null) goto L97;
        long r133 = r132.getProjectId();
    L98:
        WelfareAppLogger.k(r133);
        return;
    L97:
        r133 = 0;
        goto L98
    L13:
        if (r106.length() == 0) goto L16;
        r107 = false;
    L9:
        r106 = null;
        goto L10
    }
}
