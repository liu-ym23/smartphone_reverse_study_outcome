package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.uikit.util.RTLUtil;
import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdk.chatroom.bl.PlatformMessageHelper;
import com.bytedance.android.livesdk.chatroom.widget.CommonToastLayout;
import com.bytedance.android.livesdk.config.yl;
import com.bytedance.android.livesdk.utils.d4;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes8.dex */
public class CommonToastWidget extends LiveWidget implements qo1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f114915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0 f114916b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f114917c;

    public class a extends dmc.e {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ CommonToastWidget f114918d;

        @Override // vlc.l
        public final void onMessage(tlc.d r100) {
            if ((r100 instanceof com.bytedance.android.livesdk.message.model.n3) == false) goto L6;
            this.f114918d.M9((com.bytedance.android.livesdk.message.model.n3) r100);
            return;
        }

        public a(CommonToastWidget r100, Set r101, Set r102, dmc.d r103) {
            this.f114918d = r100;
            super(r101, r102, r103);
        }
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, tw2.b
    public final String getSpm() {
        return "a100.a100.a254";
    }

    @Override // com.bytedance.android.livesdk.ability.IAbility
    public final /* synthetic */ void onAbilityClear() {
        IAbility.CC.$default$onAbilityClear(this);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.android.livesdk.chatroom.viewmodule.d0] */
    public CommonToastWidget() {
        this.f114915a = false;
        this.f114916b = new d0();
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        if (yl.f121698a.getValue().booleanValue() == false) goto L11;
        HashSet r100 = new HashSet();
        r100.add(Integer.valueOf(MessageType.COMMON_TOAST.getIntType()));
        vlc.d r101 = (vlc.d) this.dataCenter.get("data_message_manager");
        a r102 = new a(this, r100, new HashSet(), new dmc.d(0));
        this.f114917c = r102;
        int r103 = d4.f158930a;
        if ((r101 instanceof dmc.a) == true) goto L7;
        r101 = null;
    L7:
        dmc.a r104 = (dmc.a) r101;
        if (r104 == null) goto L11;
        r104.C(r102);
    L11:
        if (ho1.a.o(getComponentContext()) == false) goto L14;
        ho1.a.p(getComponentContext(), qo1.b.class, this);
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        if (this.f114917c == null) goto L11;
        vlc.d r100 = (vlc.d) this.dataCenter.get("data_message_manager");
        a r101 = this.f114917c;
        int r102 = d4.f158930a;
        if ((r100 instanceof dmc.a) == true) goto L7;
        r100 = null;
    L7:
        dmc.a r103 = (dmc.a) r100;
        if (r103 == null) goto L10;
        r103.o(r101);
    L10:
        this.f114917c = null;
    L11:
        ho1.a.q(getComponentContext(), qo1.b.class);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onStart() {
        super.onStart();
        this.f114915a = false;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onStop() {
        super.onStop();
        this.f114915a = true;
    }

    public static String wq(String r100) {
        if (r100.length() == 9) goto L5;
        return r100;
    L5:
        return "#" + r100.substring(7, 9) + r100.substring(1, 7);
    }

    @Override // qo1.b
    public final void M9(com.bytedance.android.livesdk.message.model.n3 r110) {
        if (this.f114915a == false) goto L5;
        return;
    L5:
        Text r100 = r110.getBaseMessage().getDisplayText();
        if (r100 != null) goto L10;
        PlatformMessageHelper.INSTANCE.onMessageFinish();
        return;
    L10:
        if (r100.getPieces() == null) goto L13;
        r100.getPieces().size();
    L13:
        if (r110.G() != null) goto L16;
        r110.d0();
    L16:
        if (r110.E() != null) goto L19;
        r110.X();
    L19:
        if (r110.getTextColor() != null) goto L21;
        r110.setTextColor("#ffffff");
    L21:
        CommonToastLayout r101 = (CommonToastLayout) LayoutInflater.from(this.context).inflate(R.layout.ttlive_view_common_toast, null);
        r101.setOnDetachListener(this.f114916b);
        LinearLayout r102 = (LinearLayout) r101.findViewById(R.id.container);
        TextView r103 = (TextView) r101.findViewById(R.id.tv_content);
        HSImageView r104 = (HSImageView) r101.findViewById(R.id.iv_top);
        int r105 = ColorProtector.parseColor("#ff9d5c");
        int r106 = ColorProtector.parseColor("#ff5c67");
        String r107 = wq(r110.G());     // Catch: Exception -> L24
        String r108 = wq(r110.E());     // Catch: Exception -> L24
        r105 = Color.parseColor(r107);     // Catch: Exception -> L24
        r106 = Color.parseColor(r108);     // Catch: Exception -> L24
    L26:
        int r111 = 0;
        int[] r109 = {r105, r106};
        if (RTLUtil.isAppRTL(this.context) == false) goto L29;
        GradientDrawable r112 = new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, r109);
    L30:
        r112.setCornerRadius(com.bytedance.android.live.core.utils.s1.f(8.0f));
        r102.setBackgroundDrawable(r112);
        if (r110.V() == null) goto L38;
        r104.setVisibility(0);
        if (r110.P() > 0) goto L35;
    L37:
        ImageUtil.loadImage(r104, r110.V(), 0);
    L39:
        String r113 = r100.getDefaultPattern();
        if (TextUtils.isEmpty(r100.getKey()) == false) goto L42;
    L46:
        Objects.toString(sb2.a.i(r113, r100));
        r103.setText(sb2.a.i(r113, r100));
        int r114 = r110.getPosition();
        if (r114 == 0) goto L51;
        if (r114 == 2) goto L50;
        int r115 = 17;
        int r116 = 0;
    L53:
        if (r110.T() == false) goto L57;
        Context r117 = this.context;
        com.bytedance.android.livesdk.widget.x0.d r118 = new com.bytedance.android.livesdk.widget.x0.d();
        r118.f162243b = r117;
        r118.f162242a = 0;
        r118.f162246e = r101;
        final com.bytedance.android.livesdk.widget.x0 r119 = new com.bytedance.android.livesdk.widget.x0(r118.f162243b, r118);
        com.bytedance.android.livesdk.widget.x0.b.g(r119);
        if (r110.getDuration() <= 0) goto L64;
        ((SingleSubscribeProxy) Single.timer(r110.getDuration(), TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).as(autoDispose())).subscribe(new b0(r119), new c0());
        return;
    L64:
        return;
    L57:
        Toast r120 = new Toast(this.context.getApplicationContext());
        r120.setView(r101);
        r120.setGravity(r115, 0, r116);
        if (r110.getDuration() <= 0) goto L60;
        r111 = r110.getDuration();
    L60:
        r120.setDuration(r111);
        r120.show();
        return;
    L50:
        r116 = com.bytedance.android.live.core.utils.s1.f(64.0f);
        r115 = 80;
        goto L53
    L51:
        r116 = com.bytedance.android.live.core.utils.s1.f(72.0f);
        r115 = 48;
        goto L53
    L42:
        if (com.bytedance.android.live.core.i18n.a.b().a(r100.getKey()) == null) goto L46;
        r113 = com.bytedance.android.live.core.i18n.a.b().a(r100.getKey());
        if (TextUtils.isEmpty(r100.getDefaultPattern()) == false) goto L46;
        w50.h.a().b(r100.getKey(), r113, "");
        goto L46
    L35:
        if (r110.H() <= 0) goto L37;
        ViewGroup.LayoutParams r121 = r104.getLayoutParams();
        r121.width = r110.P();
        r121.height = r110.H();
        r104.requestLayout();
        ImageUtil.loadImage(r104, r110.V(), r104.getWidth(), r104.getHeight(), null);
        goto L39
    L38:
        r104.setVisibility(8);
        goto L39
    L29:
        r112 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, r109);
    L24:
        e = move-exception;
        ALogger.stacktrace(6, "CommonToastWidget", e.getStackTrace());
        goto L26
    }
}
