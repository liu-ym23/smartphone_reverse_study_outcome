package com.obric.appstore.buss.detail.brief;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import com.obric.appstore.R;
import com.obric.appstore.buss.detail.p;
import com.obric.appstore.common.core.ui.view.AppItemViewStyle;
import com.obric.appstore.common.core.ui.view.AppStatusBtnStyle;
import com.obric.appstore.common.core.ui.view.ObricAppItemView;
import com.obric.appstore.ui.adapter.ItemAppProvider;
import com.obric.appstore.util.m;
import com.obric.appstore.util.n;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.paneltitlebar.OPanelTitleBar;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import sa.o;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/obric/appstore/buss/detail/brief/AppBriefFragment;", "Lcom/obric/appstore/base/e;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", ServerElements.CONTENT, "B", "(Landroid/view/View;)V", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "toolBar", "D", "(Lcom/obric/oui/titlebar/OFloatingTitleBar;)V", "Lcom/bytedanceos/common/model/AppInfo;", "h", "Lkotlin/Lazy;", "K", "()Lcom/bytedanceos/common/model/AppInfo;", "appInfo", "Lcom/obric/appstore/buss/detail/brief/e;", "i", "Lcom/obric/appstore/buss/detail/brief/e;", "formatter", "", "w", "()I", "layoutId", "j", "a", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAppBriefFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppBriefFragment.kt\ncom/obric/appstore/buss/detail/brief/AppBriefFragment\n+ 2 OUnitExtension.kt\ncom/obric/oui/common/util/OUnitExtensionKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,138:1\n181#2,3:139\n180#2,5:142\n1#3:147\n262#4,2:148\n262#4,2:150\n*S KotlinDebug\n*F\n+ 1 AppBriefFragment.kt\ncom/obric/appstore/buss/detail/brief/AppBriefFragment\n*L\n63#1:139,3\n63#1:142,5\n106#1:148,2\n107#1:150,2\n*E\n"})
public final class AppBriefFragment extends com.obric.appstore.base.e {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f10642j = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f10643h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final e f10644i;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f10642j = new a(null);
    }

    public AppBriefFragment() {
        this.f10643h = kotlin.b.b(new AppBriefFragment$appInfo$2(this));
        this.f10644i = new e();
    }

    public static /* synthetic */ void F(AppBriefFragment r10, AppInfo r11, View r12) {
        O(r10, r11, r12);
    }

    public static /* synthetic */ void G(AppInfo r10, AppBriefFragment r11, View r12) {
        L(r10, r11, r12);
    }

    public static /* synthetic */ void H(AppInfo r10, AppBriefFragment r11, View r12) {
        N(r10, r11, r12);
    }

    public static /* synthetic */ void I(AppInfo r10, AppBriefFragment r11, View r12) {
        M(r10, r11, r12);
    }

    public static final /* synthetic */ Intent J(AppBriefFragment r10) {
        return r10.r();
    }

    private final AppInfo K() {
        return (AppInfo) this.f10643h.getValue();
    }

    public static final void L(AppInfo r10, AppBriefFragment r11, View r12) {
        q.g(r10, "$appInfo");
        q.g(r11, "this$0");
        String r13 = r10.appDeveloperId;
        q.f(r13, "appDeveloperId");
        if (r13.length() <= 0) goto L6;
        n r14 = n.f11086a;
        FragmentActivity r15 = r11.getActivity();
        String r16 = r10.appDeveloperId;
        q.f(r16, "appDeveloperId");
        String r17 = r10.appDeveloper;
        q.f(r17, "appDeveloper");
        r14.g(r15, r16, r17);
        return;
    }

    public static final void M(AppInfo r10, AppBriefFragment r11, View r12) {
        q.g(r10, "$appInfo");
        q.g(r11, "this$0");
        String r13 = r10.appDeveloperId;
        q.f(r13, "appDeveloperId");
        if (r13.length() <= 0) goto L6;
        n r14 = n.f11086a;
        FragmentActivity r15 = r11.getActivity();
        String r16 = r10.appDeveloperId;
        q.f(r16, "appDeveloperId");
        r14.g(r15, r16, p.c(r10));
        return;
    }

    public static final void N(AppInfo r10, AppBriefFragment r11, View r12) {
        q.g(r10, "$appInfo");
        q.g(r11, "this$0");
        String r13 = r10.appDeveloperId;
        q.f(r13, "appDeveloperId");
        if (r13.length() <= 0) goto L6;
        n r14 = n.f11086a;
        FragmentActivity r15 = r11.getActivity();
        String r16 = r10.appDeveloperId;
        q.f(r16, "appDeveloperId");
        String r17 = r10.appDeveloper;
        q.f(r17, "appDeveloper");
        r14.g(r15, r16, r17);
        return;
    }

    public static final void O(AppBriefFragment r10, AppInfo r11, View r12) {
        q.g(r10, "this$0");
        q.g(r11, "$appInfo");
        n.f11086a.i(r10.getActivity(), r11);
    }

    @Override // com.obric.appstore.base.e
    public void B(View r10) {
        q.g(r10, ServerElements.CONTENT);
        super.B(r10);
        o r11 = o.a(r10);
        OPanelTitleBar r12 = r11.f24618f;
        q.f(r12, "briefTitle");
        com.obric.appstore.ui.adapter.b.a(r12);
        OPanelTitleBar r13 = r11.f24627o;
        q.f(r13, "newFeatureTitle");
        com.obric.appstore.ui.adapter.b.a(r13);
        OPanelTitleBar r14 = r11.f24616d;
        q.f(r14, "appinfoTitle");
        com.obric.appstore.ui.adapter.b.a(r14);
        final AppInfo r15 = K();
        if (r15 == null) goto L68;
        r11.f24614b.getAppStatusView().v(AppStatusBtnStyle.DETAIL);
        int r16 = 0;
        r11.f24614b.showLine(false);
        r11.f24614b.j(yf.b.b(TypedValue.applyDimension(1, 88, Resources.getSystem().getDisplayMetrics())));
        r11.f24614b.p(AppItemViewStyle.APP_INFO);
        ObricAppItemView r17 = r11.f24614b;
        q.f(r17, "appinfoItem");
        com.obric.appstore.buss.detail.o.d(r17);
        r11.f24614b.setChangeAlphaWhenPress(false);
        r11.f24614b.setBriefOnClickListener(new com.obric.appstore.buss.detail.brief.a(r15, this));
        ItemAppProvider.a r18 = ItemAppProvider.f11017k;
        FragmentActivity r19 = requireActivity();
        q.f(r19, "requireActivity(...)");
        ObricAppItemView r20 = r11.f24614b;
        q.f(r20, "appinfoItem");
        r18.d(r19, r20, r15, getPageSource());
        TextView r21 = r11.f24617e;
        String r22 = r15.recmd_brief;
        String r23 = "";
        OTextView r24 = null;
        if (r22 == null) goto L16;
        q.d(r22);
        if (r22.length() <= 0) goto L10;
        boolean r25 = true;
    L11:
        if (r25 == true) goto L14;
        r22 = null;
    L14:
        if (r22 == null) goto L16;
    L19:
        r21.setText(r22);
        r11.f24626n.setText(r15.appNewFeature);
        r11.f24619g.setText(r15.appCategoryName);
        TextView r26 = r11.f24632t;
        String r27 = r15.appShowLastUpdateTime;
        if (r27 == null) goto L24;
        q.d(r27);
        String r28 = this.f10644i.a(r27);
        if (r28 == null) goto L24;
    L25:
        r26.setText(r28);
        r11.f24634v.setText(r15.appVersionName);
        OTextView r29 = r11.f24621i;
        if (r29 != null) goto L29;
        r29 = null;
    L29:
        if (r29 == null) goto L31;
        r29.setChangeAlphaWhenPress(true);
    L31:
        r11.f24621i.setText(p.b(r15));
        r11.f24621i.setOnClickListener(new b(r15, this));
        r11.f24621i.setOnClickListener(new c(r15, this));
        String r30 = r15.icp;
        if (r30 == null) goto L36;
        q.d(r30);
        r23 = r30;
    L36:
        if (r23.length() > 0) goto L39;
        r23 = null;
    L39:
        TextView r31 = r11.f24624l;
        q.f(r31, "icpTitle");
        if (r23 == null) goto L42;
        boolean r32 = true;
    L44:
        if (r32 == false) goto L46;
        int r33 = 0;
    L47:
        r31.setVisibility(r33);
        OTextView r34 = r11.f24623k;
        q.f(r34, "icpDetail");
        if (r23 == null) goto L50;
        boolean r35 = true;
    L51:
        if (r35 == true) goto L54;
        r16 = 8;
    L54:
        r34.setVisibility(r16);
        if (r23 == null) goto L57;
        r11.f24623k.setText(r23);
    L57:
        TextView r36 = r11.f24630r;
        AppInfo.From r37 = r15.appFrom;
        if (r37 == null) goto L60;
        String r38 = r37.name;
    L61:
        r36.setText(r38);
        OTextView r39 = r11.f24628p;
        if (r39 == null) goto L64;
        r24 = r39;
    L64:
        if (r24 == null) goto L66;
        r24.setChangeAlphaWhenPress(true);
    L66:
        OTextView r40 = r11.f24628p;
        String r41 = getString(R.string.permission_detail);
        q.f(r41, "getString(...)");
        r40.setText(p.d(r41));
        r11.f24628p.setOnClickListener(new d(this, r15));
        OScrollView r42 = r11.f24615c;
        q.f(r42, "appinfoScrollview");
        u8.c.c(r42, AppBriefFragment$onCreateContentView$1$8.INSTANCE);
        return;
    L60:
        r38 = null;
        goto L61
    L50:
        r35 = false;
        goto L51
    L46:
        r33 = 8;
        goto L47
    L42:
        r32 = false;
    L24:
        r28 = "";
        goto L25
    L10:
        r25 = false;
    L16:
        r22 = r15.appBrief;
        if (r22 != null) goto L19;
        r22 = "";
        goto L19
    }

    @Override // com.obric.appstore.base.e
    public void D(OFloatingTitleBar r10) {
        q.g(r10, "toolBar");
        super.D(r10);
        r10.setCenterTitle(getString(R.string.summary));
        r10.setMaskBlurRadius(8.0f);
    }

    @Override // com.obric.appstore.base.e, androidx.fragment.app.Fragment
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        m.a("appstore_page_show", AnonymousClass1.INSTANCE);
        if (K() != null) goto L6;
        requireActivity().finish();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r10, Bundle r11) {
        q.g(r10, "view");
        super.onViewCreated(r10, r11);
    }

    @Override // com.obric.appstore.base.e
    public int w() {
        return R.layout.obric_fragment_app_brief;
    }
}
