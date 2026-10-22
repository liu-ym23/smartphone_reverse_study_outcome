package com.bytedanceos.common.core.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.volley.VolleyError;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$anim;
import com.bytedanceos.common.R$dimen;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.eventbus.LoginEvent;
import com.bytedanceos.common.network.core.ImageLoader;
import com.bytedanceos.common.toolbox.cache.AccountDataCache;
import com.bytedanceos.common.ui.StatusBarActivity;
import com.bytedanceos.common.utils.ActivityUtilKt;
import com.obric.common.oea.style.scene.transition.TransitionAnimStyle;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.lisitem.OListItemGeneral;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.titlebar.OFloatingTitleBar;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes2.dex */
public class SettingsActivity extends StatusBarActivity implements Observer, ImageLoader.ImageListener, CompoundButton.OnCheckedChangeListener, View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m8.a f9757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AccountDataCache f9758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f9759c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f9760d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OListItemGeneral f9761e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public OCardListItem f9762f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public OSwitch f9763g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public OCardListItem f9764h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public OSwitch f9765i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public OListItemGeneral f9766j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public OSwitch f9767k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public OCardListItem f9768l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public OSwitch f9769m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public OListItemGeneral f9770n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public OSwitch f9771o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public OListItemGeneral f9772p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public OSwitch f9773q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public OCardListItem f9774r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f9775s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f9776t;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SettingsActivity f9777a;

        public a(SettingsActivity r10) {
            this.f9777a = r10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r10) {
            com.bytedanceos.common.toolbox.e.d1(this.f9777a);
        }
    }

    public SettingsActivity() {
        this.f9757a = null;
        this.f9758b = null;
        this.f9762f = null;
        this.f9763g = null;
        this.f9764h = null;
        this.f9765i = null;
        this.f9766j = null;
        this.f9767k = null;
        this.f9768l = null;
        this.f9769m = null;
        this.f9770n = null;
        this.f9771o = null;
        this.f9772p = null;
        this.f9773q = null;
        this.f9775s = 0;
        this.f9776t = 0;
    }

    public static /* synthetic */ Map A(Map r10) {
        r10.put("name", "show_update_notification");
        return r10;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void initView() {
        int r10 = tc.f.i(4);
        OCardListItem r11 = (OCardListItem) findViewById(R$id.autoUpdateSwitch);
        this.f9762f = r11;
        r11.setCardPosition(1);
        this.f9762f.setTitle(getString(R$string.settings_idle_auto_update_options));
        this.f9762f.H(true);
        OSwitch r12 = new OSwitch(this);
        this.f9763g = r12;
        r12.setClickable(true);
        this.f9762f.setCustomEndView(this.f9763g);
        this.f9762f.B(true);
        OCardListItem r13 = (OCardListItem) findViewById(R$id.showUpdatedCountSwitch);
        this.f9764h = r13;
        r13.setCardPosition(3);
        this.f9764h.setTitle(getString(R$string.setting_show_update_available_count_options));
        this.f9764h.H(true);
        OSwitch r14 = new OSwitch(this);
        this.f9765i = r14;
        r14.setClickable(true);
        this.f9764h.setCustomEndView(this.f9765i);
        this.f9764h.B(true);
        OCardListItem r15 = (OCardListItem) findViewById(R$id.show_update_notification);
        this.f9768l = r15;
        r15.setTitle(getString(R$string.app_update_notification));
        this.f9768l.H(true);
        this.f9768l.setSubTitle(getString(R$string.new_version_notification));
        this.f9768l.F(true);
        this.f9768l.B(true);
        OSwitch r16 = new OSwitch(this);
        this.f9769m = r16;
        r16.setClickable(true);
        this.f9768l.setCustomEndView(this.f9769m);
        this.f9768l.B(true);
        this.f9766j = (OListItemGeneral) findViewById(R$id.showImageSwitch);
        OSwitch r17 = new OSwitch(this);
        this.f9767k = r17;
        r17.setClickable(true);
        this.f9766j.setTrailingView(this.f9767k);
        this.f9766j.getMTrailingElement().setPadding(r10, 0, r10, 0);
        this.f9770n = (OListItemGeneral) findViewById(R$id.showRecommendMesage);
        OSwitch r18 = new OSwitch(this);
        this.f9771o = r18;
        r18.setClickable(true);
        this.f9770n.setTrailingView(this.f9771o);
        this.f9770n.getMTrailingElement().setPadding(r10, 0, r10, 0);
        this.f9772p = (OListItemGeneral) findViewById(R$id.showTabBottomUpdatedCountSwitch);
        OSwitch r19 = new OSwitch(this);
        this.f9773q = r19;
        r19.setClickable(true);
        this.f9772p.setTrailingView(this.f9773q);
        this.f9772p.getMTrailingElement().setPadding(r10, 0, r10, 0);
        OCardListItem r20 = (OCardListItem) findViewById(R$id.showPrivacyPolicy);
        this.f9774r = r20;
        r20.setTitle(getString(R$string.about_app_store));
        this.f9774r.H(true);
        this.f9774r.G(true);
        OCardListItem r21 = this.f9774r;
        int r22 = R$drawable.oui_icon_right_arrow;
        r21.setTailIcon(r22);
        this.f9774r.G(true);
        ImageView r23 = new ImageView(this);
        r23.setImageResource(r22);
        r23.setPadding(tc.f.i(4), tc.f.i(4), tc.f.i(4), tc.f.i(4));
        FrameLayout.LayoutParams r24 = new FrameLayout.LayoutParams(tc.f.i(18), tc.f.i(28));
        r24.gravity = 17;
        r23.setLayoutParams(r24);
        OListItemGeneral r25 = (OListItemGeneral) findViewById(R$id.userinfo);
        this.f9761e = r25;
        r25.setOnClickListener(this);
        this.f9759c = new ImageView(this);
        FrameLayout.LayoutParams r26 = new FrameLayout.LayoutParams(tc.f.i(36), tc.f.i(36));
        r26.gravity = 17;
        r26.setMargins(tc.f.i(14), tc.f.i(2), tc.f.i(14), tc.f.i(2));
        this.f9759c.setLayoutParams(r26);
        this.f9759c.setImageResource(R$drawable.oui_icon_account_default);
        this.f9760d = this.f9761e.getMTvTitle();
        this.f9761e.setLeadingView(this.f9759c);
        this.f9761e.getMContentElement().setVisibility(8);
        ImageView r27 = new ImageView(this);
        r27.setImageResource(r22);
        r27.setPadding(tc.f.i(4), tc.f.i(4), tc.f.i(4), tc.f.i(4));
        FrameLayout.LayoutParams r28 = new FrameLayout.LayoutParams(tc.f.i(18), tc.f.i(28));
        r28.gravity = 17;
        r27.setLayoutParams(r28);
        this.f9761e.setTrailingView(r27);
        this.f9758b = AccountDataCache.b();
        m8.a r29 = m8.a.i();
        this.f9757a = r29;
        r29.addObserver(this);
        if (this.f9758b.n() == false) goto L5;
        this.f9757a.f();
    L5:
        C();
        B();
        this.f9769m.setOnCheckedChangeListener(this);
        this.f9763g.setOnCheckedChangeListener(this);
        this.f9765i.setOnCheckedChangeListener(this);
        this.f9773q.setOnCheckedChangeListener(this);
        this.f9767k.setOnCheckedChangeListener(this);
        this.f9771o.setOnCheckedChangeListener(this);
        this.f9774r.setOnContentClickListener(new a(this));
    }

    private /* synthetic */ void lambda$initHeaderView$0(View r10) {
        onBackPressed();
    }

    public static /* synthetic */ Map s(Map r10) {
        return A(r10);
    }

    public static /* synthetic */ Map t(Map r10) {
        return y(r10);
    }

    public static /* synthetic */ void u(SettingsActivity r10, View r11) {
        r10.lambda$initHeaderView$0(r11);
    }

    public static /* synthetic */ Map v(Map r10) {
        return z(r10);
    }

    public static /* synthetic */ Map y(Map r10) {
        r10.put("name", "wifi_auto_update");
        return r10;
    }

    public static /* synthetic */ Map z(Map r10) {
        r10.put("name", "show_update_badge");
        return r10;
    }

    public final void B() {
        String r10 = this.f9758b.l();
        if (TextUtils.isEmpty(r10) == true) goto L5;
        this.f9760d.setText(r10);
    L5:
        String r11 = this.f9758b.d();
        if (TextUtils.isEmpty(r11) == false) goto L8;
        this.f9759c.setBackgroundResource(R$drawable.avator_profile_default);
        return;
    L8:
        int r12 = getResources().getDimensionPixelOffset(R$dimen.user_account_icon);
        ImageLoader.l(0.0f).h(r11, this, r12, r12, true);
    }

    public final void C() {
        this.f9763g.setChecked(com.bytedanceos.common.toolbox.s.g(this));
        this.f9765i.setChecked(com.bytedanceos.common.toolbox.s.n(this));
        this.f9767k.setChecked(com.bytedanceos.common.toolbox.s.k(this));
        this.f9771o.setChecked(com.bytedanceos.common.toolbox.s.l(this));
        this.f9769m.setChecked(com.bytedanceos.common.toolbox.s.i(this));
        this.f9773q.setChecked(com.bytedanceos.common.toolbox.s.m(this));
    }

    @Override // com.bytedanceos.common.ui.StatusBarActivity, android.app.Activity
    public void finish() {
        super.finish();
        xb.b.b(this, TransitionAnimStyle.Standard);
    }

    @Override // com.bytedanceos.common.ui.StatusBarActivity
    public View initHeaderView() {
        OFloatingTitleBar r10 = (OFloatingTitleBar) findViewById(R$id.toolbar);
        r10.bringToFront();
        r10.setMaskBlurRadius(8.0f);
        r10.setCenterTitle(R$string.settings);
        r10.k(R$drawable.oui_title_bar_back, -1, new u(this));
        return r10;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r10, boolean r11) {
        int r12 = w(r10.getParent(), 10);
        final HashMap r13 = new HashMap();
        if (r11 == false) goto L5;
        r13.put("target_switch", 1);
    L7:
        if (x(this.f9762f, r10) == false) goto L10;
        com.bytedanceos.common.utils.o.a("appstore_btn_click", new r(r13));
        Intent r14 = new Intent("com.bytedance.appstore.autoupdate.switch");
        r14.putExtra("isChecked", r11);
        r14.setPackage(getPackageName());
        BaseApplication.c().startService(r14);
        return;
    L10:
        if (x(this.f9764h, r10) == false) goto L17;
        com.bytedanceos.common.toolbox.s.A(BaseApplication.c(), r11);
        if (r11 == false) goto L14;
        BaseApplication.c().b().P();
    L15:
        com.bytedanceos.common.utils.o.a("appstore_btn_click", new s(r13));
        com.bytedanceos.common.toolbox.s.z(BaseApplication.c(), r11);
        com.bytedanceos.common.toolbox.e.c1();
        return;
    L14:
        com.bytedanceos.common.toolbox.e.W0(this, 0);
        goto L15
    L17:
        if (x(this.f9768l, r10) == false) goto L20;
        com.bytedanceos.common.utils.o.a("appstore_btn_click", new t(r13));
        com.bytedanceos.common.toolbox.s.v(BaseApplication.c(), r11);
        com.bytedanceos.common.toolbox.e.c1();
        return;
    L20:
        if (r12 != R$id.showImageSwitch) goto L23;
        com.bytedanceos.common.toolbox.s.x(BaseApplication.c(), r11);
        return;
    L23:
        if (r12 != R$id.showRecommendMesage) goto L30;
        com.bytedanceos.common.toolbox.s.y(BaseApplication.c(), r11);
        return;
    L30:
        return;
    L5:
        r13.put("target_switch", 0);
        goto L7
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r10) {
        if (r10.getId() == R$id.userinfo) goto L5;
        return;
    L5:
        if (this.f9758b.n() == false) goto L7;
        Intent r11 = new Intent(this, PersonalAccountSettingsActivity.class);
        r11.putExtra("track_id", "9018");
        startActivity(r11);
        overridePendingTransition(R$anim.pop_up_in, R$anim.fake_anim);
        d9.a.e().P("9028");
        return;
    L7:
        com.bytedanceos.common.toolbox.e.J0(this, "9018", true);
    }

    @Override // com.bytedanceos.common.ui.StatusBarActivity, com.bytedanceos.common.ui.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        ActivityUtilKt.a(this);
        setContentView(R$layout.settings);
        EventBus.getDefault().register(this);
        initView();
    }

    @Override // com.bytedanceos.common.ui.StatusBarActivity, com.bytedanceos.common.ui.BasicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.f9757a.deleteObserver(this);
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    @Override // com.android.volley.Response.ErrorListener
    public void onErrorResponse(VolleyError r10) {
        if (r10 == null) goto L5;
        com.bytedanceos.common.toolbox.j.a(r10.getMessage());
        return;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(LoginEvent r10) {
        B();
    }

    @Override // com.bytedanceos.common.network.core.ImageLoader.ImageListener
    public void onResponse(ImageLoader.ImageContainer r10, boolean r11) {
        if (this.f9759c == null) goto L9;
        if (r10 != null) goto L6;
        return;
    L6:
        if (r10.d() == null) goto L11;
        Bitmap r12 = BitmapFactory.decodeResource(getResources(), R$drawable.mask_user_icon);
        Bitmap r13 = com.bytedanceos.common.toolbox.e.Q(com.bytedanceos.common.toolbox.e.y(r10.d()), r12);
        this.f9759c.setBackground(new BitmapDrawable(null, r13));
        return;
    L11:
        return;
    }

    @Override // java.util.Observer
    public void update(Observable r10, Object r11) {
        if (isFinishing() == false) goto L5;
        return;
    L5:
        C();
        B();
    }

    @Override // com.bytedanceos.common.ui.StatusBarActivity
    public boolean useEdgeToEdgeStatusBar() {
        return true;
    }

    public final int w(ViewParent r10, int r11) {
        if ((r10 instanceof OListItemGeneral) == true) goto L5;
        if (r11 > 0) goto L8;
        return 0;
    L8:
        if ((r10 instanceof ViewGroup) == true) goto L10;
        return 0;
    L10:
        return w(r10.getParent(), r11 - 1);
    L5:
        return ((OListItemGeneral) r10).getId();
    }

    public final boolean x(OCardListItem r10, CompoundButton r11) {
        if (r10 != null) goto L6;
        return false;
    L6:
        if (r10.getEndSwitch() != r11) goto L9;
        return true;
    L9:
        return false;
    }
}
