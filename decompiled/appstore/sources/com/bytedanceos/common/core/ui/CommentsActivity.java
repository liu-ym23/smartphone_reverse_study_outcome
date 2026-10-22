package com.bytedanceos.common.core.ui;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$anim;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.core.ui.presenter.APresenter;
import com.bytedanceos.common.core.ui.presenter.IView;
import com.bytedanceos.common.model.AppComments;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.CommentParams;
import com.bytedanceos.common.model.Topic;
import com.bytedanceos.common.network.widget.NetworkImageView;
import com.bytedanceos.common.toolbox.cache.AccountDataCache;
import com.bytedanceos.common.toolbox.e0;
import com.bytedanceos.common.ui.AppInfoFeedBackActivity;
import com.bytedanceos.common.ui.StatusBarActivity;
import com.bytedanceos.common.ui.WebActivity;
import com.bytedanceos.common.ui.adapter.CommentsAdapter;
import com.bytedanceos.common.ui.fragment.AppCommentsView;
import com.bytedanceos.common.ui.fragment.StateView;
import com.bytedanceos.common.ui.widget.RefreshLoadListView;
import com.bytedanceos.common.ui.widget.oui.OUIAppStatusView;
import com.bytedanceos.common.utils.AppStoreCommonError;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.titlebar.OFloatingTitleBar;
import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

/* JADX INFO: loaded from: classes2.dex */
public class CommentsActivity extends StatusBarActivity implements IView<Boolean, APresenter.b>, View.OnClickListener, AdapterView.OnItemClickListener, Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AppInfo f9729b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinearLayout f9730c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f9731d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ViewGroup f9732e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public OUIAppStatusView f9733f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.bytedanceos.common.core.ui.presenter.b f9734g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.bytedanceos.common.utils.a f9735h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AppComments f9736i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f9737j;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentsActivity f9738a;

        public a(CommentsActivity r10) {
            this.f9738a = r10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r10) {
            this.f9738a.finish();
        }
    }

    public class b implements RefreshLoadListView.IXListViewListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentsActivity f9739a;

        public b(CommentsActivity r10) {
            this.f9739a = r10;
        }

        @Override // com.bytedanceos.common.ui.widget.RefreshLoadListView.IXListViewListener
        public void onLoadMore() {
            if (com.bytedanceos.common.toolbox.e.A() != 0) goto L5;
            e0.e(R$string.SOCKET_TIME_OUT);
            AppCommentsView.onLoad(CommentsActivity.u(this.f9739a));
            return;
        L5:
            CommentsActivity r10 = this.f9739a;
            CommentsActivity.v(r10, AppCommentsView.getPage(CommentsActivity.u(r10)));
        }

        @Override // com.bytedanceos.common.ui.widget.RefreshLoadListView.IXListViewListener
        public void onRefresh() {
            AppCommentsView.onLoad(CommentsActivity.u(this.f9739a));
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentsActivity f9740a;

        public c(CommentsActivity r10) {
            this.f9740a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CommentsActivity.w(this.f9740a) != null) goto L5;
            return;
        L5:
            if (CommentsActivity.x(this.f9740a) == null) goto L9;
            CommentsActivity.w(this.f9740a).updateDownloadStatus(CommentsActivity.x(this.f9740a));
            return;
        }
    }

    public CommentsActivity() {
    }

    private void fetchData(int r10) {
        if (r10 != 1) goto L5;
        StateView.showLoadingView(this.f9732e);
    L5:
        CommentParams r11 = new CommentParams();
        r11.mAppPackage = this.f9729b.appPackageName;
        r11.mPageNo = r10;
        this.f9734g.g(700004, null, r11);
    }

    private void initData() {
        Serializable r10 = getIntent().getSerializableExtra("original_data");
        if (r10 != null) goto L5;
    L16:
        com.bytedanceos.common.toolbox.j.e("comment params error..");
        finish();
        return;
    L5:
        if ((r10 instanceof AppInfo) == false) goto L16;
        this.f9729b = (AppInfo) r10;
        this.f9728a = getIntent().getIntExtra("original_from", 1);
        int r11 = getIntent().getIntExtra("original_type", 0);
        if (r11 <= 0) goto L11;
        this.f9734g = new com.bytedanceos.common.core.ui.presenter.b(this, r11);
    L14:
        this.f9735h = new com.bytedanceos.common.utils.a(this.f9734g);
        return;
    L11:
        if (BaseApplication.c().o() == false) goto L13;
        this.f9734g = new com.bytedanceos.common.core.ui.presenter.b(this, 2);
        goto L14
    L13:
        this.f9734g = new com.bytedanceos.common.core.ui.presenter.b(this, 3);
        goto L14
    }

    public static /* synthetic */ void s(CommentsActivity r10, RefreshLoadListView r11, View r12, int r13, int r14, int r15, int r16) {
        r10.z(r11, r12, r13, r14, r15, r16);
    }

    public static /* synthetic */ void t(CommentsActivity r10, ScrollView r11, View r12, int r13, int r14, int r15, int r16) {
        r10.A(r11, r12, r13, r14, r15, r16);
    }

    public static /* synthetic */ LinearLayout u(CommentsActivity r10) {
        return r10.f9730c;
    }

    public static /* synthetic */ void v(CommentsActivity r10, int r11) {
        r10.fetchData(r11);
    }

    public static /* synthetic */ OUIAppStatusView w(CommentsActivity r10) {
        return r10.f9733f;
    }

    public static /* synthetic */ AppInfo x(CommentsActivity r10) {
        return r10.f9729b;
    }

    public final /* synthetic */ void A(ScrollView r10, View r11, int r12, int r13, int r14, int r15) {
        View r16 = this.f9731d;
        if (r10.getScrollY() == 0) goto L5;
        int r17 = 0;
    L6:
        r16.setVisibility(r17);
        return;
    L5:
        r17 = 8;
        goto L6
    }

    public void B(int r10, Boolean r11, APresenter.b r12) {
        if (r11.booleanValue() == true) goto L9;
        AppStoreCommonError r13 = com.bytedanceos.common.utils.n.a(BaseApplication.c(), r12.f9800a, r12.f9801b);
        com.bytedanceos.common.toolbox.i.a("CommentsActivity", "error code  " + r13.getErrorCode());
        if (r13.getErrorCode() != 1602) goto L9;
        this.f9735h.c();
        C();
        return;
    L9:
        switch(r10) {
            case 700004: goto L26;
            case 700005: goto L45;
            case 700006: goto L45;
            case 700007: goto L22;
            case 700008: goto L21;
            case 700009: goto L45;
            case 700010: goto L17;
            case 700011: goto L45;
            case 700012: goto L12;
            default: goto L45;
        };
    L21:
        this.f9735h.g(this, this.f9729b, r11.booleanValue(), r12.f9801b);
        return;
    L22:
        this.f9737j = r11.booleanValue();
        this.f9735h.f(r11.booleanValue(), this.f9729b, r12);
        if (r11.booleanValue() == false) goto L41;
        this.f9730c.setTag(R$id.app_comments_page, 1);
        fetchData(1);
        return;
    L41:
        return;
    L45:
        return;
    L12:
        if (r11.booleanValue() == false) goto L14;
        this.f9735h.e(r12.f9801b, null, r12.f9802c);
    L15:
        update(null, null);
        return;
    L14:
        this.f9735h.e(r12.f9801b, com.bytedanceos.common.utils.n.a(BaseApplication.c(), r12.f9800a, r12.f9801b), r12.f9802c);
        goto L15
    L17:
        if (r11.booleanValue() == false) goto L19;
        this.f9735h.d(r12.f9801b, null, r12.f9802c);
    L20:
        update(null, null);
        return;
    L19:
        this.f9735h.d(r12.f9801b, com.bytedanceos.common.utils.n.a(BaseApplication.c(), r12.f9800a, r12.f9801b), r12.f9802c);
        goto L20
    L26:
        if (r11.booleanValue() == false) goto L34;
        ViewGroup r14 = this.f9732e;
        if (r14 == null) goto L30;
        r14.setVisibility(8);
    L30:
        this.f9736i = c9.a.l(r12.f9801b, null);
        if (this.f9730c.getVisibility() == 0) goto L33;
        this.f9730c.setVisibility(0);
    L33:
        AppCommentsView.updateAppCommentsView(this.f9730c, this.f9736i);
        return;
    L34:
        ViewGroup r15 = this.f9732e;
        if (r15 == null) goto L44;
        StateView.showRefreshView(r15, this);
        return;
    }

    public final void C() {
        Intent r10 = new Intent();
        r10.setComponent(new ComponentName("com.bytedanceos.cloudsync", "com.bytedanceos.cloudsync.AccountsActivityLauncher"));
        r10.putExtra("bytedance_origin_app_tag", "settings");
        r10.putExtra("input_password", true);
        startActivityForResult(r10, 0);
    }

    public final void D(boolean r10, AppInfo r11) {
        if (r10 == false) goto L4;
        OSectionTitleBar r12 = (OSectionTitleBar) findViewById(R$id.app_feature_title);
        r12.setTitleText(getString(R$string.features));
        TextView r13 = (TextView) findViewById(R$id.appFeatures);
        String r14 = r11.appNewFeature;
    L6:
        if (TextUtils.isEmpty(r14) == true) goto L14;
        r12.setVisibility(0);
        r13.setVisibility(0);
        if (r10 == false) goto L11;
        r13.setText(r14);
        return;
    L11:
        if (r11.mIsNeedGms == false) goto L13;
        r13.setText(Html.fromHtml(getString(R$string.gms_notify) + r14.replace("\n", "<br/>")));
        return;
    L13:
        r13.setText(r14.replace("<br/>", "\n"));
        return;
    L14:
        r12.setVisibility(8);
        r13.setVisibility(8);
        return;
    L4:
        r12 = (OSectionTitleBar) findViewById(R$id.app_summary_title);
        r12.setTitleText(getString(R$string.summary));
        r13 = (TextView) findViewById(R$id.appSummary);
        r14 = r11.appBrief;
        goto L6
    }

    public final void E() {
        ((ViewStub) findViewById(R$id.summary_layout)).inflate();
        findViewById(R$id.feedback).setOnClickListener(this);
        final ScrollView r10 = (ScrollView) findViewById(R$id.summary_scroll);
        r10.setOnScrollChangeListener(new p(this, r10));
        D(false, this.f9729b);
        D(true, this.f9729b);
        if (TextUtils.isEmpty(this.f9729b.appAliasName) == true) goto L5;
        ((TextView) findViewById(R$id.appinfo_aliasName)).setText(this.f9729b.appAliasName);
    L6:
        ((TextView) findViewById(R$id.appinfo_category)).setText(this.f9729b.appCategoryName);
        ((TextView) findViewById(R$id.appinfo_update)).setText(this.f9729b.appShowLastUpdateTime);
        ((TextView) findViewById(R$id.appinfo_version)).setText(this.f9729b.appVersionName);
        ((TextView) findViewById(R$id.appinfo_compatibility)).setText(this.f9729b.appScalable);
        TextView r11 = (TextView) findViewById(R$id.appinfo_developers);
        if (TextUtils.isEmpty(this.f9729b.appDeveloper) == true) goto L11;
        SpannableString r12 = new SpannableString(this.f9729b.appDeveloper);
        r12.setSpan(new UnderlineSpan(), 0, r12.length(), 0);
        r11.setText(r12);
        r11.setTag(R$id.develop, this.f9729b);
        if (TextUtils.equals(this.f9729b.appSource, "local") == false) goto L12;
        r11.setClickable(true);
        r11.setOnClickListener(this);
    L12:
        AppInfo.From r13 = this.f9729b.appFrom;
        if (r13 == null) goto L19;
        String r14 = r13.name;
        if (r14 == null) goto L19;
        if (TextUtils.equals("local", r14.trim().toLowerCase()) == true) goto L19;
        TextView r15 = (TextView) findViewById(R$id.appinfo_from);
        r15.setText(this.f9729b.appFrom.name);
        r15.setVisibility(0);
        findViewById(R$id.appinfo_fromLabel).setVisibility(0);
    L19:
        View r16 = findViewById(R$id.tv_permessions);
        TextView r17 = (TextView) findViewById(R$id.tv_view_permessions);
        if (this.f9729b.isSystemApp() == false) goto L22;
    L25:
        r16.setVisibility(8);
        r17.setVisibility(8);
    L26:
        View r18 = findViewById(R$id.tv_icp);
        TextView r19 = (TextView) findViewById(R$id.tv_view_icp);
        if (TextUtils.isEmpty(this.f9729b.icp) == false) goto L29;
        r18.setVisibility(8);
        r19.setVisibility(8);
        return;
    L29:
        r18.setVisibility(0);
        r19.setVisibility(0);
        if (TextUtils.isEmpty(this.f9729b.agreement) == false) goto L32;
        r19.setText(this.f9729b.agreement);
        return;
    L32:
        r19.setOnClickListener(this);
        r19.setClickable(true);
        SpannableString r20 = new SpannableString(this.f9729b.icp);
        r20.setSpan(new UnderlineSpan(), 0, r20.length(), 0);
        r19.setText(r20);
        return;
    L22:
        if (AppInfo.SEARCH_SOURCE_EXTENAL.equals(this.f9729b.appSource) == true) goto L25;
        r16.setVisibility(0);
        r17.setVisibility(0);
        r17.setOnClickListener(this);
        r17.setClickable(true);
        SpannableString r21 = new SpannableString(getString(R$string.view_all_permissions));
        r21.setSpan(new UnderlineSpan(), 0, r21.length(), 0);
        r17.setText(r21);
        goto L26
    L11:
        SpannableString r22 = new SpannableString(getString(R$string.unkown));
        r22.setSpan(new UnderlineSpan(), 0, r22.length(), 0);
        r11.setText(r22);
        goto L12
    L5:
        findViewById(R$id.appinfo_aliasLabel).setVisibility(8);
        findViewById(R$id.appinfo_aliasName).setVisibility(8);
        goto L6
    }

    public final void F() {
        NetworkImageView r10 = (NetworkImageView) findViewById(R$id.appIcon);
        int r11 = R$drawable.oui_default_app_icon;
        r10.setErrorImageResId(r11);
        r10.setDefaultImageResId(r11);
        r10.e(this.f9729b.appIcon, com.bytedanceos.common.toolbox.d.f10012d);
        ((TextView) findViewById(R$id.appName)).setText(this.f9729b.appName);
        ImageView r12 = (ImageView) findViewById(R$id.appRate);
        if (this.f9729b.isSystemApp() == true) goto L5;
        r12.setImageResource(com.bytedanceos.common.toolbox.e.b0(this, this.f9729b.appScores, false));
    L5:
        this.f9731d = findViewById(R$id.line);
        OUIAppStatusView r13 = (OUIAppStatusView) findViewById(R$id.appStatusLay);
        this.f9733f = r13;
        r13.setBtnStyle(2);
        this.f9733f.setOnClickListener(this);
        this.f9733f.updateDownloadStatus(this.f9729b);
        LinearLayout r14 = (LinearLayout) findViewById(R$id.parent_view);
        this.f9730c = r14;
        this.f9732e = StateView.getStateView(r14);
    }

    @Override // com.bytedanceos.common.ui.StatusBarActivity, android.app.Activity
    public void finish() {
        if (this.f9736i != null) goto L5;
    L7:
        this.f9737j = false;
        super.finish();
        return;
    L5:
        if (this.f9737j == false) goto L7;
        Intent r10 = new Intent();
        r10.putExtra("extra_app_comment", this.f9736i);
        setResult(-1, r10);
        goto L7
    }

    @Override // com.bytedanceos.common.ui.StatusBarActivity
    public View initHeaderView() {
        OFloatingTitleBar r10 = (OFloatingTitleBar) findViewById(R$id.toolbar);
        com.bytedanceos.common.utils.u.d(r10);
        r10.k(R$drawable.oui_title_bar_back, -1, new a(this));
        if (this.f9728a != 1) goto L5;
        r10.setCenterTitle(R$string.summary);
    L6:
        return r10;
    L5:
        r10.setCenterTitle(R$string.comments);
        goto L6
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int r10, int r11, Intent r12) {
        super.onActivityResult(r10, r11, r12);
        if (r10 != 1) goto L7;
        if (r11 != 0) goto L8;
        C();
        return;
    L8:
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r10) {
        int r11 = r10.getId();
        if (r11 != R$id.appinfo_developers) goto L6;
        Topic r12 = new Topic();
        r12.setTitle(this.f9729b.appDeveloper);
        r12.setId(this.f9729b.appDeveloperId);
        r12.setType("4");
        com.bytedanceos.common.toolbox.e.x1(this, r12);
        return;
    L6:
        if (r11 != R$id.tv_view_permessions) goto L9;
        com.bytedanceos.common.toolbox.e.m1(this, this.f9729b);
        return;
    L9:
        if (r11 != R$id.addComment) goto L12;
        this.f9735h.b(this, this.f9729b);
        return;
    L12:
        if (r11 != R$id.feedback) goto L24;
        if (this.f9729b != null) goto L17;
        com.bytedanceos.common.toolbox.j.b("Feedback failed because of mAppInfo is null!");
        return;
    L17:
        Intent r13 = new Intent(BaseApplication.c(), AppInfoFeedBackActivity.class);
        r13.putExtra("PackageName", this.f9729b.appPackageName);
        r13.putExtra("AppVersionCode", this.f9729b.appVersionCode);
        startActivity(r13);     // Catch: Exception -> L20
        overridePendingTransition(R$anim.slide_in_from_right, R$anim.slide_out_to_left);     // Catch: Exception -> L20
    L22:
        d9.a.e().P("0017");
        return;
    L20:
        e = move-exception;
        e.printStackTrace();
        goto L22
    L24:
        if (r11 != R$id.left_action_back) goto L26;
        finish();
        return;
    L26:
        int r14 = 2;
        if (r11 != R$id.toolbar_search) goto L30;
        com.bytedanceos.common.toolbox.e.n1(this, null, 0, "page_app_detail", 2);
        return;
    L30:
        if (r11 != R$id.toolbar_modify) goto L33;
        this.f9735h.b(this, this.f9729b);
        return;
    L33:
        if (r11 != R$id.refresh_btn) goto L36;
        fetchData(1);
        return;
    L36:
        if (r11 != R$id.comment_item_support_click) goto L42;
        if (AccountDataCache.b().n() == false) goto L74;
        this.f9735h.h(r10);
        return;
    L74:
        return;
    L42:
        if (r11 != R$id.appStatusLay) goto L52;
        if (com.bytedanceos.common.toolbox.e.p0() == false) goto L69;
        l8.a.a(this, r10, this.f9729b, getSourcePage());
        if (BaseApplication.c().b().B(this.f9729b.appPackageName) != 32) goto L70;
        d9.a r15 = d9.a.e();
        String r16 = this.f9729b.appPackageName;
        if (this.f9728a != 1) goto L50;
        r14 = 1;
    L50:
        r15.y(r16, r14);
        return;
    L70:
        return;
    L69:
        return;
    L52:
        if (r11 != R$id.find_more) goto L55;
        Topic r17 = new Topic();
        r17.setTitle(getString(R$string.onestep_topic_title));
        r17.setId(Topic.ID_ONE_STEP);
        com.bytedanceos.common.toolbox.e.x1(this, r17);
        d9.a.e().P("0033");
        return;
    L55:
        if (r11 != R$id.tv_view_icp) goto L73;
        WebActivity.start(this, this.f9729b.agreement);
        return;
    }

    @Override // com.bytedanceos.common.ui.StatusBarActivity, com.bytedanceos.common.ui.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        initData();
        setContentView(R$layout.comments_activity);
        F();
        if (this.f9728a != 2) goto L5;
        y();
        fetchData(1);
    L6:
        BaseApplication.c().b().addObserver(this);
        return;
    L5:
        E();
        goto L6
    }

    @Override // com.bytedanceos.common.ui.StatusBarActivity, com.bytedanceos.common.ui.BasicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.bytedanceos.common.core.ui.presenter.b r10 = this.f9734g;
        if (r10 == null) goto L5;
        r10.c();
    L5:
        BaseApplication.c().b().deleteObserver(this);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView r10, View r11, int r12, long r13) {
    }

    @Override // com.bytedanceos.common.core.ui.presenter.IView
    public void onRequestError(Throwable r10) {
    }

    @Override // com.bytedanceos.common.core.ui.presenter.IView
    public /* bridge */ /* synthetic */ void onUpdateView(int r10, Boolean r11, APresenter.b r12) {
        B(r10, r11, r12);
    }

    @Override // java.util.Observer
    public void update(Observable r10, Object r11) {
        if (isFinishing() == false) goto L6;
        com.bytedanceos.common.toolbox.j.a("can not update view.");
        return;
    L6:
        runOnUiThread(new c(this));
    }

    public final void y() {
        this.f9730c.setTag(R$id.app_comments_page, 1);
        ((ViewStub) findViewById(R$id.comments_layout)).inflate();
        final RefreshLoadListView r10 = (RefreshLoadListView) this.f9730c.findViewById(R$id.appComments_lv);
        r10.addHeaderView(View.inflate(this, R$layout.appinfo_comment_header, null));
        r10.setPullRefreshEnable(false);
        r10.setAdapter(new CommentsAdapter(this, this));
        r10.setVisibility(8);
        r10.setTag(this.f9729b.appPackageName);
        r10.setPullLoadEnable(true);
        r10.setOnScrollChangeListener(new q(this, r10));
        if (r10.getXListViewListener() != null) goto L6;
        r10.setXListViewListener(new b(this));
        return;
    }

    public final /* synthetic */ void z(RefreshLoadListView r10, View r11, int r12, int r13, int r14, int r15) {
        int r16 = 0;
        View r17 = r10.getChildAt(0);
        if (r10.getFirstVisiblePosition() != 0) goto L8;
        if (r17 != null) goto L6;
    L7:
        boolean r18 = true;
    L9:
        View r19 = this.f9731d;
        if (r18 == false) goto L12;
        r16 = 8;
    L12:
        r19.setVisibility(r16);
        return;
    L6:
        if (r17.getTop() == r10.getPaddingTop()) goto L7;
    L8:
        r18 = false;
        goto L9
    }
}
