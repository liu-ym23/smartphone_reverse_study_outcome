package com.bytedanceos.common.core.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedanceos.common.AnimationEndCallBack;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$anim;
import com.bytedanceos.common.R$dimen;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.ad.common.AdConstant;
import com.bytedanceos.common.core.ui.presenter.IView;
import com.bytedanceos.common.eventbus.LoginEvent;
import com.bytedanceos.common.eventbus.OnSubEvent;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.AppList;
import com.bytedanceos.common.model.RecommendAppGroupInfo;
import com.bytedanceos.common.model.RelatedAppInfo;
import com.bytedanceos.common.model.SearchHotWords;
import com.bytedanceos.common.model.SearchParams;
import com.bytedanceos.common.model.SupposeAppInfo;
import com.bytedanceos.common.network.ads.AdsReportManager;
import com.bytedanceos.common.network.api.CommonAPIHelper;
import com.bytedanceos.common.networkv2.entity.Head;
import com.bytedanceos.common.networkv2.entity.SubAppEntity;
import com.bytedanceos.common.toolbox.b0;
import com.bytedanceos.common.toolbox.e0;
import com.bytedanceos.common.ui.GameSubDetailActivity;
import com.bytedanceos.common.ui.StatusBarActivity;
import com.bytedanceos.common.ui.dialog.ReserveGameDialog;
import com.bytedanceos.common.ui.fragment.StateView;
import com.bytedanceos.common.ui.listener.IRelatedClickListener;
import com.bytedanceos.common.ui.listener.ISupposeListener;
import com.bytedanceos.common.ui.widget.AppGroupView;
import com.bytedanceos.common.ui.widget.AppListView;
import com.bytedanceos.common.ui.widget.FlowLayout;
import com.bytedanceos.common.ui.widget.RefreshLoadListView;
import com.bytedanceos.common.ui.widget.SearchChipsView;
import com.bytedanceos.common.ui.widget.SubButton;
import com.bytedanceos.common.ui.widget.VerticalScrollView;
import com.bytedanceos.common.ui.widget.oui.OUISearchBar;
import com.bytedanceos.common.utils.ReflectTool;
import com.obric.oui.forms.OInputView;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ASearchDetailActivity extends StatusBarActivity implements IView<Integer, Object>, View.OnClickListener, OUISearchBar.OnEditorClickListener, TextView.OnEditorActionListener, TextWatcher, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, Observer, IRelatedClickListener {
    public int A;
    public List B;
    public SupposeAppInfo C;
    public r8.a D;
    public final Handler E;
    public AppGroupView F;
    public AppGroupView G;
    public AppGroupView H;
    public AppGroupView I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public String f9640J;
    public View.OnClickListener K;
    public View.OnClickListener L;
    public InputFilter M;
    public View.OnLongClickListener N;
    public SubButton.OnSubListener O;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f9641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f9643c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f9644d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f9645e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewGroup f9646f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public FlowLayout f9647g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f9648h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public FlowLayout f9649i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f9650j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f9651k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f9652l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f9653m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f9654n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f9655o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public VerticalScrollView f9656p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public RelativeLayout f9657q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public RefreshLoadListView f9658r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public OUISearchBar f9659s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public OInputView f9660t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ListView f9661u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public View f9662v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public RelativeLayout f9663w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public JSONObject f9664x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f9665y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f9666z;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ASearchDetailActivity f9667a;

        public a(ASearchDetailActivity r10) {
            this.f9667a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            ListView r10 = this.f9667a.f9661u;
            if (r10 != null) goto L5;
        L7:
            RefreshLoadListView r11 = this.f9667a.f9658r;
            if (r11 != null) goto L10;
        L12:
            this.f9667a.W();
            return;
        L10:
            if (r11.isShown() == false) goto L12;
            ASearchDetailActivity r12 = this.f9667a;
            r12.updateListView(r12.f9658r);
            return;
        L5:
            if (r10.isShown() == false) goto L7;
            ASearchDetailActivity r13 = this.f9667a;
            r13.updateListView(r13.f9661u);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f9668a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ASearchDetailActivity f9669b;

        public b(ASearchDetailActivity r10, int r11) {
            this.f9669b = r10;
            this.f9668a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            RefreshLoadListView r10 = this.f9669b.f9658r;
            if (r10 == null) goto L6;
            r10.smoothScrollToPosition(this.f9668a + 1);
            return;
        }
    }

    public class c implements AnimationEndCallBack {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f9670a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f9671b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ASearchDetailActivity f9672c;

        public c(ASearchDetailActivity r10, int r11, String r12) {
            this.f9672c = r10;
            this.f9670a = r11;
            this.f9671b = r12;
        }

        @Override // com.bytedanceos.common.AnimationEndCallBack
        public void fetchData(Object... r10) {
            this.f9672c.O(this.f9670a, this.f9671b, 1, null);
        }
    }

    public class d implements InputFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ASearchDetailActivity f9673a;

        public d(ASearchDetailActivity r10) {
            this.f9673a = r10;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence r10, int r11, int r12, Spanned r13, int r14, int r15) {
            int r16 = r13.toString().length();     // Catch: Exception -> L7
            int r17 = r10.toString().length();     // Catch: Exception -> L7
            int r18 = r15 - r14;     // Catch: Exception -> L7
            int r19 = ((r16 + r17) - r18) - 26;     // Catch: Exception -> L7
            if (r19 <= 0) goto L11;
            e0.h(this.f9673a.getString(R$string.search_key_over_length), 0);     // Catch: Exception -> L7
            return r10.subSequence(0, r17 - r19);
        L11:
            if (r10.length() >= 1) goto L14;
            if (r18 < 1) goto L14;
            return "";
        L14:
            return r10;
        L7:
            e = move-exception;
            e.printStackTrace();
            return "";
        }
    }

    public class e implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ASearchDetailActivity f9674a;

        public e(ASearchDetailActivity r10) {
            this.f9674a = r10;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View r10) {
            if (ReflectTool.isSidebarShowing(BaseApplication.c()) == false) goto L19;
            int r11 = R$id.appinfo;
            AppInfo r12 = (AppInfo) r10.getTag(r11);
            if (r12 == null) goto L7;
            String r13 = r12.appDownloadUrl;
        L14:
            if (TextUtils.isEmpty(r13) == true) goto L16;
            this.f9674a.f9662v = r10;
            e0.g("getShortLink");
            return true;
        L16:
            com.bytedanceos.common.toolbox.j.a("The drag download url is null");
            return true;
        L7:
            r10 = (View) r10.getParent();
            if (r10 == null) goto L12;
            AppInfo r14 = (AppInfo) r10.getTag(r11);
            if (r14 == null) goto L12;
            r13 = r14.appDownloadUrl;
        L12:
            r13 = "";
            goto L14
        L19:
            return true;
        }
    }

    public class f implements SubButton.OnSubListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ASearchDetailActivity f9675a;

        public f(ASearchDetailActivity r10) {
            this.f9675a = r10;
        }

        @Override // com.bytedanceos.common.ui.widget.SubButton.OnSubListener
        public boolean onSubClick(SubButton r10, boolean r11) {
            if (r11 == false) goto L5;
            return true;
        L5:
            new ReserveGameDialog(this.f9675a).showAbandonDialog(r10);
            return false;
        }

        @Override // com.bytedanceos.common.ui.widget.SubButton.OnSubListener
        public void onSubFail(SubButton r10, Head r11) {
        }

        @Override // com.bytedanceos.common.ui.widget.SubButton.OnSubListener
        public void onSubSuccess(SubButton r10, boolean r11) {
            if (r11 == false) goto L4;
            new ReserveGameDialog(this.f9675a).showReserveDialog();
        L4:
            Object r12 = r10.getTag(R$id.appinfo);
            if ((r12 instanceof AppInfo) == false) goto L8;
            int r13 = r10.getStatus();
            ((AppInfo) r12).mStatus = r13;
            return;
        }
    }

    public class g implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ASearchDetailActivity f9676a;

        public g(ASearchDetailActivity r10) {
            this.f9676a = r10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r10) {
            l8.a.a(this.f9676a, r10, (AppInfo) r10.getTag(), this.f9676a.getSourcePage());
        }
    }

    public class h implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ASearchDetailActivity f9677a;

        public h(ASearchDetailActivity r10) {
            this.f9677a = r10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r10) {
            com.bytedanceos.common.toolbox.e.e1(this.f9677a, (AppInfo) r10.getTag(R$id.appinfo), 0, this.f9677a.getString(R$string.search));
        }
    }

    public class i implements OUISearchBar.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ASearchDetailActivity f9678a;

        public i(ASearchDetailActivity r10) {
            this.f9678a = r10;
        }

        @Override // com.bytedanceos.common.ui.widget.oui.OUISearchBar.AnimationListener
        public void onAnimationEnd() {
            if (ASearchDetailActivity.u(this.f9678a) == false) goto L6;
            com.bytedanceos.common.toolbox.e.g0(this.f9678a.f9660t);
            this.f9678a.finish();
            return;
        }

        @Override // com.bytedanceos.common.ui.widget.oui.OUISearchBar.AnimationListener
        public void onAnimationStart() {
        }
    }

    public class j implements OInputView.OnTextClearedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ASearchDetailActivity f9679a;

        public j(ASearchDetailActivity r10) {
            this.f9679a = r10;
        }

        @Override // com.obric.oui.forms.OInputView.OnTextClearedListener
        public void afterClear() {
            RefreshLoadListView r10 = this.f9679a.f9658r;
            if (r10 != null) goto L5;
        L7:
            ListView r11 = this.f9679a.f9661u;
            if (r11 != null) goto L10;
            return;
        L10:
            if (r11.getVisibility() != 0) goto L15;
            d9.a.e().G("0071", 2);
            return;
        L15:
            return;
        L5:
            if (r10.getVisibility() != 0) goto L7;
            d9.a.e().G("0071", 3);
        }

        @Override // com.obric.oui.forms.OInputView.OnTextClearedListener
        public void beforeClear(String r10) {
        }
    }

    public class k implements View.OnDragListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ASearchDetailActivity f9680a;

        public k(ASearchDetailActivity r10) {
            this.f9680a = r10;
        }

        @Override // android.view.View.OnDragListener
        public boolean onDrag(View r10, DragEvent r11) {
            return true;
        }
    }

    public class l implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ASearchDetailActivity f9681a;

        public l(ASearchDetailActivity r10) {
            this.f9681a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f9681a.f9659s.getInputView().requestFocus();
            this.f9681a.T();
        }
    }

    public class m implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ASearchDetailActivity f9682a;

        public m(ASearchDetailActivity r10) {
            this.f9682a = r10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r10) {
            Object r11 = r10.getTag();
            if (r11 != null) goto L5;
        L7:
            com.bytedanceos.common.toolbox.j.e("click hot word failed:" + r11);
            return;
        L5:
            if ((r11 instanceof AppInfo) == false) goto L7;
            AppInfo r12 = (AppInfo) r11;
            ASearchDetailActivity.v(this.f9682a, r12.appName, 8, true);
            d9.a.e().K(r12.appName);
        }
    }

    public class n implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ASearchDetailActivity f9683a;

        public n(ASearchDetailActivity r10) {
            this.f9683a = r10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r10) {
            if ((r10 instanceof SearchChipsView) == false) goto L6;
            String r11 = ((SearchChipsView) r10).getText().toString();
            ASearchDetailActivity.v(this.f9683a, r11, 8, true);
            d9.a.e().J(r11);
            return;
        }
    }

    public class o implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ASearchDetailActivity f9684a;

        public o(ASearchDetailActivity r10) {
            this.f9684a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            RefreshLoadListView r10 = this.f9684a.f9658r;
            if (r10 != null) goto L5;
        L7:
            ASearchDetailActivity.w(this.f9684a, true);
        L8:
            ListView r11 = this.f9684a.f9661u;
            if (r11 == null) goto L14;
            if (r11.isShown() == false) goto L14;
            ASearchDetailActivity r12 = this.f9684a;
            r12.updateListView(r12.f9661u);
        L14:
            if (ASearchDetailActivity.x(this.f9684a) == false) goto L17;
            this.f9684a.H();
            ASearchDetailActivity.y(this.f9684a, false);
            return;
        L17:
            return;
        L5:
            if (r10.isShown() == false) goto L7;
            ASearchDetailActivity.w(this.f9684a, false);
            ASearchDetailActivity r13 = this.f9684a;
            r13.updateListView(r13.f9658r);
            goto L8
        }
    }

    public ASearchDetailActivity() {
        this.f9642b = 8;
        this.f9643c = null;
        this.f9644d = false;
        this.f9645e = false;
        this.f9664x = null;
        this.f9665y = 0;
        this.f9666z = 0;
        this.A = 8;
        this.E = new Handler();
        this.K = new g(this);
        this.L = new h(this);
        this.M = new d(this);
        this.N = new e(this);
        this.O = new f(this);
    }

    private void R(boolean r10) {
        this.f9660t.getVInput().setCursorVisible(r10);
        if (r10 == false) goto L5;
        T();
        return;
    L5:
        this.f9660t.getVInput().setSelection(this.f9660t.getText().length());
        C();
    }

    private void initData() {
        this.D = new r8.a(this);
        this.f9641a = getIntent().getStringExtra("original_from");
        int r10 = getIntent().getIntExtra("original_type", 0);
        this.f9642b = r10;
        if (r10 != 0) goto L5;
    L18:
        this.D.k();
        return;
    L5:
        if (r10 != 7) goto L7;
        String r11 = getIntent().getStringExtra("original_extra");
        if (TextUtils.isEmpty(r11) == true) goto L18;
        this.f9660t.setHint(r11);
        goto L18
    L7:
        if (r10 != 8) goto L9;
    L11:
        String r12 = getIntent().getStringExtra("original_extra");
        if (TextUtils.isEmpty(r12) == false) goto L14;
        this.f9642b = 0;
        this.D.k();
        return;
    L14:
        U(r12, this.f9642b, false);
        return;
    L9:
        if (r10 == 9) goto L11;
    }

    public static /* synthetic */ void s(ASearchDetailActivity r10, View r11, int r12, int r13, int r14, int r15) {
        r10.G(r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ void t(ASearchDetailActivity r10, View r11) {
        r10.F(r11);
    }

    public static /* synthetic */ boolean u(ASearchDetailActivity r10) {
        return r10.f9644d;
    }

    public static /* synthetic */ void v(ASearchDetailActivity r10, String r11, int r12, boolean r13) {
        r10.U(r11, r12, r13);
    }

    public static /* synthetic */ void w(ASearchDetailActivity r10, boolean r11) {
        r10.R(r11);
    }

    public static /* synthetic */ boolean x(ASearchDetailActivity r10) {
        return r10.mIsRefresh;
    }

    public static /* synthetic */ boolean y(ASearchDetailActivity r10, boolean r11) {
        r10.mIsRefresh = r11;
        return r11;
    }

    public final void A() {
        this.f9666z = 0;
        b0.n().E("app_download_count", 0, null, this);
    }

    public String B(String r10, AppInfo r11, View r12) {
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return null;
    L6:
        if (r11 != null) goto L8;
    L11:
        TextView r13 = (TextView) r12.findViewById(R$id.appName);
        if (r13 == null) goto L14;
        String r14 = r13.getText().toString();
    L16:
        return getString(R$string.share_text_example, new Object[]{r14, r10 + "&source=share&version=2"});
    L14:
        r14 = AdConstant.Dsp.BYTEDANCE;
        goto L16
    L8:
        if (TextUtils.isEmpty(r11.appName) == true) goto L11;
        r14 = r11.appName;
        goto L16
    }

    public void C() {
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.f9660t.getVInput().getWindowToken(), 2);
    }

    public void D() {
        RefreshLoadListView r10 = this.f9658r;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.getVisibility() == 8) goto L11;
        this.f9658r.setVisibility(8);
        if (this.f9666z <= 0) goto L12;
        d9.a.e().H(this.f9666z);
        A();
        return;
    L12:
        return;
    }

    public abstract void E(String r10);

    public final /* synthetic */ void F(View r10) {
        if (r10.getId() != this.f9659s.getSearchActionCancel().getId()) goto L20;
        this.f9644d = true;
        RefreshLoadListView r11 = this.f9658r;
        if (r11 != null) goto L7;
    L9:
        ListView r12 = this.f9661u;
        if (r12 != null) goto L12;
    L14:
        RelativeLayout r13 = this.f9657q;
        if (r13 != null) goto L17;
        return;
    L17:
        if (r13.getVisibility() != 0) goto L24;
        d9.a.e().G("0070", 1);
        return;
    L24:
        return;
    L12:
        if (r12.getVisibility() != 0) goto L14;
        d9.a.e().G("0070", 2);
        return;
    L7:
        if (r11.getVisibility() != 0) goto L9;
        d9.a.e().G("0070", 3);
        return;
    }

    public final /* synthetic */ void G(View r10, int r11, int r12, int r13, int r14) {
        int r15 = 0;
        if (this.f9656p.getScrollY() == 0) goto L5;
        boolean r16 = true;
    L6:
        View r17 = this.f9651k;
        if (r16 == true) goto L10;
        r15 = 8;
    L10:
        r17.setVisibility(r15);
        return;
    L5:
        r16 = false;
        goto L6
    }

    public void H() {
        String r10 = this.f9660t.getText().toString();
        if (TextUtils.isEmpty(r10) == true) goto L15;
        ListView r11 = this.f9661u;
        if (r11 != null) goto L7;
    L9:
        RefreshLoadListView r12 = this.f9658r;
        if (r12 != null) goto L12;
        return;
    L12:
        if (r12.isShown() == false) goto L18;
        U(r10, this.A, false);
        return;
    L18:
        return;
    L7:
        if (r11.isShown() == false) goto L9;
        S(r10, true);
        return;
    }

    public void I(int r10, Integer r11, Object r12) {
        int r13 = r11.intValue();
        if (r13 != 2) goto L5;
        if (r10 != 1) goto L61;
        this.B = (List) r12;
        return;
    L61:
        return;
    L5:
        if (r13 != 5) goto L7;
    L41:
        if (r10 != 1) goto L59;
        Y((Map) r12);
        return;
    L59:
        return;
    L7:
        if (r13 != 500005) goto L9;
        if (r10 != 1) goto L54;
        if (r12 == null) goto L55;
        SupposeAppInfo r14 = (SupposeAppInfo) r12;
        SupposeAppInfo r15 = this.C;
        if (r15 != null) goto L36;
        return;
    L36:
        if (r15.getSuperInfo() != null) goto L38;
        return;
    L38:
        if (this.C.getSupposeListener() == null) goto L40;
        this.C.getSupposeListener().onOpen(this.C.getSuperPos());
    L40:
        d9.a.e().n("0073");
        r14.setSuperName(this.C.getSuperName());
        this.C.getSuperInfo().setAppExtraInfo(r14);
        c0();
        M(this.C.getSuperPos());
        return;
    L55:
        return;
    L54:
        return;
    L9:
        if (r13 == 1100000) goto L41;
        if (r13 != 12) goto L13;
        X((List) r12);
        List r16 = this.B;
        if (r16 == null) goto L52;
        a0(r16);
        return;
    L52:
        return;
    L13:
        if (r13 == 13) goto L27;
        switch(r13) {
            case 500001: goto L24;
            case 500002: goto L16;
            case 500003: goto L16;
            default: goto L62;
        };
    L16:
        if (r10 == 2) goto L21;
        if (r12 == null) goto L21;
        K((AppList) r12);
        return;
    L21:
        if (AppListView.isFirstPage(this.f9658r) == false) goto L23;
        StateView.showRefreshView(this.f9646f, this);
        return;
    L23:
        K(null);
        return;
    L24:
        hideStateView();
        if (r10 != 1) goto L49;
        D();
        Q(false, (List) r12);
        return;
    L49:
        return;
    L62:
        return;
    L27:
        Z((List) r12);
    }

    public final void J(AppGroupView r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.getVisibility() != 0) goto L8;
        r10.refreshWholeGroupView();
        return;
    }

    public abstract void K(AppList r10);

    public abstract void L(RefreshLoadListView r10);

    public final void M(int r10) {
        this.E.postDelayed(new b(this, r10), 100);
    }

    public void N(int r10, String r11, int r12, String r13, JSONObject r14, String r15) {
        if (com.bytedanceos.common.toolbox.e.A0(this) == false) goto L5;
        SearchParams r16 = new SearchParams();
        r16.mSearchKey = r11;
        r16.mSearchFrom = this.f9641a;
        r16.mPageNo = r12;
        r16.mParams = r14;
        if (r10 != 0) goto L13;
        r10 = 8;
    L13:
        if (TextUtils.isEmpty(r15) == true) goto L16;
        r16.mPackage = r15;
    L16:
        if (TextUtils.isEmpty(r13) == true) goto L18;
        r16.mTraceId = r13;
    L18:
        this.D.j(r10, r11, r16);
        return;
    L5:
        if (AppListView.isFirstPage(this.f9658r) == false) goto L7;
        showRefreshView();
        return;
    L7:
        K(null);
    }

    public void O(int r10, String r11, int r12, JSONObject r13) {
        JSONObject r14 = new JSONObject();     // Catch: Exception -> L4
        r14.put("searchKey", r11);     // Catch: Exception -> L4
        v8.a.a(200000014, r14.toString());     // Catch: Exception -> L4
    L6:
        N(r10, r11, r12, null, r13, null);
        return;
    L4:
        e = move-exception;
        com.bytedanceos.common.toolbox.j.b("MemoryDataEventReport search-event fail:" + e.getMessage());
        e.printStackTrace();
        goto L6
    }

    public abstract void P(ListView r10);

    public abstract void Q(boolean r10, List r11);

    public final void S(String r10, boolean r11) {
        this.f9665y = System.currentTimeMillis();
        D();
        RelativeLayout r12 = this.f9657q;
        if (r12 != null) goto L5;
    L7:
        ListView r13 = this.f9661u;
        if (r13 != null) goto L10;
    L12:
        if (r11 == false) goto L14;
        R(true);
    L14:
        this.D.j(10, r10, null);
        return;
    L10:
        if (r13.getVisibility() != 8) goto L12;
        this.f9661u.setVisibility(0);
        goto L12
    L5:
        if (r12.getVisibility() == 8) goto L7;
        this.f9657q.setVisibility(8);
        goto L7
    }

    public void T() {
        ((InputMethodManager) getSystemService("input_method")).showSoftInput(this.f9660t.getVInput(), 0);
    }

    public final void U(String r10, int r11, boolean r12) {
        RelativeLayout r13 = this.f9657q;
        if (r13 == null) goto L5;
        r13.setVisibility(8);
    L5:
        ListView r14 = this.f9661u;
        if (r14 == null) goto L9;
        r14.setVisibility(8);
    L9:
        if (this.f9658r != null) goto L11;
        E(r10);
        this.f9658r.setOnItemLongClickListener(this);
    L11:
        this.f9665y = System.currentTimeMillis();
        this.f9645e = true;
        this.f9660t.setText(r10);
        R(false);
        this.f9643c = r10;
        L(this.f9658r);
        D();
        StateView.showLoadingView(this.f9646f);
        if (r12 == false) goto L14;
        com.bytedanceos.common.toolbox.e.q1(this.f9661u, this.f9646f, new c(this, r11, r10));
    L15:
        this.D.j(3, r10, null);
        this.D.j(2, null, null);
        this.A = r11;
        return;
    L14:
        O(r11, r10, 1, null);
        goto L15
    }

    public final void V(RecommendAppGroupInfo r10, AppGroupView r11) {
        List<AppInfo> r12 = r10.appInfoList;
        if (r12 != null) goto L5;
        return;
    L5:
        if (r12.size() == 0) goto L10;
        r11.setVisibility(0);
        r11.setGroupTitle(r10.name);
        r11.setOnClickListener(this.K, this.L);
        r11.setMaxItemInOnePage(2);
        r11.setDataList(r10.appInfoList);
        return;
    }

    public void W() {
        J(this.F);
        J(this.G);
        J(this.H);
        J(this.I);
    }

    public void X(List r10) {
        com.bytedanceos.common.toolbox.j.a("appInfoList = " + r10);
        if (r10 != null) goto L5;
    L12:
        this.F.setVisibility(8);
        return;
    L5:
        if (r10.isEmpty() == true) goto L12;
        this.F.setVisibility(0);
        this.F.setType(1);
        this.F.setOnClickListener(this.K, this.L);
        this.F.setDataList(r10);
        if (r10.isEmpty() == false) goto L10;
        this.f9652l.setVisibility(8);
        return;
    L10:
        this.f9652l.setVisibility(0);
    }

    public final void Y(Map r10) {
        if (r10 != null) goto L4;
    L39:
        this.f9647g.setVisibility(8);
        return;
    L4:
        if (r10.isEmpty() == true) goto L39;
        Iterator r11 = r10.entrySet().iterator();
        int r12 = 3;
        if (r11.hasNext() == false) goto L14;
        Map.Entry r13 = (Map.Entry) r11.next();
        int r14 = Integer.parseInt((String) r13.getKey());     // Catch: Exception -> L11
    L13:
        List r15 = (List) r13.getValue();
    L15:
        if (r14 < 0) goto L18;
        r12 = r14;
    L18:
        if (r15 != null) goto L20;
        return;
    L20:
        if (r15.isEmpty() == true) goto L52;
        this.f9647g.setMaxRows(r12);
        this.f9647g.setVisibility(0);
        this.f9647g.resetCurrentChildRow();
        this.f9647g.removeAllViews();
        ViewGroup.MarginLayoutParams r16 = new ViewGroup.MarginLayoutParams(-2, -2);
        Iterator r17 = r15.iterator();
    L24:
        if (r17.hasNext() == false) goto L53;
        SearchHotWords r18 = (SearchHotWords) r17.next();
        if (r18.isSearchHit() == true) goto L28;
        SearchChipsView r19 = new SearchChipsView(this);
        AppInfo r20 = r18.convertToAppInfo();
        r19.setTag(r20);
        r19.setText(r18.getKeyword());
        if (Integer.parseInt(r18.getSort()) <= 0) goto L33;
        r19.setType(0);
    L34:
        r19.setOnClickListener(new m(this));
        r19.measure(0, 0);
        if (this.f9647g.getChildRow(r19.getMeasuredWidth()) > r12) goto L54;
        this.f9647g.addView(r19, r16);
        ((SearchChipsView) this.f9647g.getChildAt(0)).setType(4);
        AdsReportManager.h().k(r20);
        goto L24
    L54:
        return;
    L33:
        r19.setType(SearchChipsView.BROWN);
        goto L34
    L28:
        if (TextUtils.isEmpty(this.f9660t.getVInput().getHint()) == false) goto L24;
        this.f9660t.setHint(r18.getKeyword());
        goto L24
    L53:
        return;
    L52:
        return;
    L11:
        e = move-exception;
        com.bytedanceos.common.toolbox.j.b(e.getMessage());
        r14 = 3;
        goto L13
    L14:
        r15 = null;
        r14 = 3;
        goto L15
    }

    public void Z(List r10) {
        if (r10 != null) goto L5;
    L14:
        this.f9653m.setVisibility(8);
        return;
    L5:
        if (r10.isEmpty() == true) goto L14;
        this.f9654n.setVisibility(8);
        this.f9655o.setVisibility(8);
        V((RecommendAppGroupInfo) r10.get(0), this.G);
        if (r10.size() != 2) goto L11;
        this.f9654n.setVisibility(0);
        V((RecommendAppGroupInfo) r10.get(1), this.H);
        return;
    L11:
        if (r10.size() != 3) goto L17;
        this.f9654n.setVisibility(0);
        this.f9655o.setVisibility(0);
        V((RecommendAppGroupInfo) r10.get(1), this.H);
        V((RecommendAppGroupInfo) r10.get(2), this.I);
        return;
    }

    public final void a0(List r10) {
        if (r10 != null) goto L4;
    L8:
        this.f9648h.setVisibility(8);
        this.f9649i.setVisibility(8);
        this.f9653m.setVisibility(8);
        this.f9650j.setVisibility(8);
        return;
    L4:
        if (r10.isEmpty() == true) goto L8;
        this.f9648h.setVisibility(0);
        this.f9649i.setVisibility(0);
        b0(r10, new n(this));
        this.f9650j.setVisibility(0);
        this.f9653m.setVisibility(0);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable r10) {
    }

    public final void b0(List r10, View.OnClickListener r11) {
        this.f9649i.removeAllViews();
        ViewGroup.MarginLayoutParams r12 = new ViewGroup.MarginLayoutParams(-2, -2);
        Iterator r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        SearchHotWords r14 = (SearchHotWords) r13.next();
        SearchChipsView r15 = new SearchChipsView(this);
        r15.setText(r14.getKeyword());
        r15.setType(SearchChipsView.GRAY);
        r15.setOnClickListener(r11);
        this.f9649i.addView(r15, r12);
        goto L4
    L6:
        ((SearchChipsView) this.f9649i.getChildAt(0)).setType(SearchChipsView.GRAY_ICON);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence r10, int r11, int r12, int r13) {
        if (TextUtils.isEmpty(r10.toString().trim()) == false) goto L6;
        d9.a.e().P("9023");
        return;
    }

    public void c0() {
    }

    @Override // com.bytedanceos.common.ui.StatusBarActivity, android.app.Activity
    public void finish() {
        super.finish();
        if (this.f9641a != null) goto L6;
        overridePendingTransition(R$anim.a_search_fade_in, R$anim.a_search_fade_out);
        return;
    }

    @Override // com.bytedanceos.common.ui.BasicActivity
    public String getSourcePage() {
        return "9007";
    }

    @Override // com.bytedanceos.common.ui.BasicActivity
    public String getSourcePageName() {
        return getString(R$string.search);
    }

    public void hideStateView() {
        StateView.hideStateView(this.f9646f);
    }

    @Override // com.bytedanceos.common.ui.StatusBarActivity
    public View initHeaderView() {
        return findViewById(R$id.main_header);
    }

    public void initView() {
        RelativeLayout r10 = (RelativeLayout) findViewById(R$id.status_container);
        this.f9663w = r10;
        this.f9646f = StateView.getStateView(r10);
        this.f9651k = findViewById(R$id.line);
        OUISearchBar r11 = (OUISearchBar) findViewById(R$id.searchbar_edit_layout);
        this.f9659s = r11;
        r11.setOnCancelClickListener(new com.bytedanceos.common.core.ui.a(this));
        this.f9659s.setOnEditorClickListener(this);
        this.f9659s.setAnimationListener(new i(this));
        this.f9659s.getSearchActionCancel();
        this.f9659s.getInputView().setOnTextClearedListener(new j(this));
        OInputView r12 = this.f9659s.getInputView();
        this.f9660t = r12;
        r12.getVInput().setFilters(new InputFilter[]{this.M});
        this.f9660t.setOnDragListener(new k(this));
        this.f9660t.A(this);
        this.f9660t.getVInput().setOnEditorActionListener(this);
        ListView r13 = (ListView) findViewById(R$id.search_lv);
        this.f9661u = r13;
        r13.setOnItemClickListener(this);
        this.f9661u.setOnItemLongClickListener(this);
        P(this.f9661u);
        VerticalScrollView r14 = (VerticalScrollView) findViewById(R$id.search_main);
        this.f9656p = r14;
        r14.setClipToPadding(false);
        this.f9656p.setClipChildren(false);
        this.f9656p.setOnScrollChangeListener(new com.bytedanceos.common.core.ui.b(this));
        this.f9657q = (RelativeLayout) findViewById(R$id.search_history_ly);
        this.F = (AppGroupView) findViewById(R$id.rv_search_hot_apps);
        this.f9647g = (FlowLayout) findViewById(R$id.flow_pop_layout);
        View r15 = findViewById(R$id.clear_history);
        this.f9648h = r15;
        r15.setOnClickListener(this);
        FlowLayout r16 = (FlowLayout) findViewById(R$id.flow_layout);
        this.f9649i = r16;
        r16.setMaxRows(1);
        this.f9650j = findViewById(R$id.flow_layout_container);
        this.f9652l = findViewById(R$id.div_line_1);
        this.f9653m = findViewById(R$id.div_line_3);
        this.f9654n = findViewById(R$id.div_line_4);
        this.f9655o = findViewById(R$id.div_line_5);
        this.G = (AppGroupView) findViewById(R$id.search_group1);
        this.H = (AppGroupView) findViewById(R$id.search_group2);
        this.I = (AppGroupView) findViewById(R$id.search_group3);
        this.E.postDelayed(new l(this), 50);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        OUISearchBar r10 = this.f9659s;
        if (r10 != null) goto L5;
    L7:
        super.onBackPressed();
        return;
    L5:
        if (r10.isSearchMode() == false) goto L7;
        this.f9659s.callOnCancelClick();
    }

    @Override // android.view.View.OnClickListener, com.bytedanceos.common.ui.widget.oui.OUISearchBar.OnEditorClickListener
    public void onClick(View r10) {
        boolean r11 = true;
        if (r10.getId() != this.f9659s.getInputView().getVInput().getId()) goto L13;
        if ((System.currentTimeMillis() - this.f9665y) >= 300) goto L8;
        com.bytedanceos.common.toolbox.j.e("ignore onclick event.");
        return;
    L8:
        String r12 = this.f9660t.getText().toString();
        if (TextUtils.isEmpty(r12) == true) goto L76;
        S(r12, true);
        return;
    L76:
        return;
    L13:
        if (r10.getId() != R$id.appStatusLay) goto L42;
        AppInfo r13 = (AppInfo) r10.getTag(R$id.appinfo);
        int r14 = BaseApplication.c().b().B(r13.appPackageName);
        Object r15 = r10.getTag(R$id.app_do_not_show_suppose_info);
        if ((r15 instanceof Boolean) == false) goto L17;
        boolean r16 = ((Boolean) r15).booleanValue();
    L18:
        if (r16 == false) goto L20;
    L26:
        r11 = false;
    L27:
        if (r11 == true) goto L29;
    L32:
        String r17 = this.f9660t.getText().toString();
        this.f9643c = r17;
        if (TextUtils.isEmpty(r17) == false) goto L35;
        return;
    L35:
        if ("search_type=keyword".equals(this.f9640J) == false) goto L37;
        return;
    L37:
        if (TextUtils.isEmpty(this.f9640J) == true) goto L79;
        "search_type=search".equals(this.f9640J);
        return;
    L79:
        return;
    L29:
        if (this.C != null) goto L31;
        this.C = new SupposeAppInfo();
    L31:
        this.C.setSupposeListener((ISupposeListener) r10.getTag(R$id.suppose_listener));
        this.C.setSuperPos(((Integer) r10.getTag(R$id.app_row_index)).intValue());
        this.C.setSuperInfo(r13);
        this.C.setSuperName(r13.appName);
        N(17, r13.appName, 1, null, null, r13.appPackageName);
        goto L32
    L20:
        if (r13.appSource.equals("local") == false) goto L26;
        if (r14 == 32) goto L27;
        if (r14 != 64) goto L26;
    L17:
        r16 = com.bytedanceos.common.toolbox.e.N0(r13.mApiUrl, 500001);
        goto L18
    L42:
        if (r10.getId() != R$id.app_list_item) goto L52;
        AppInfo r18 = (AppInfo) r10.getTag(R$id.appinfo);
        com.bytedanceos.common.toolbox.e.e1(this, r18, 0, getString(R$string.search));
        OInputView r19 = this.f9660t;
        if (r19 != null) goto L46;
    L48:
        String r20 = "";
    L49:
        CommonAPIHelper.c0(r20, 3, r18.appName);
        d9.a.e().M(r18.appName, r20, false);
        return;
    L46:
        if (r19.getText() == null) goto L48;
        r20 = this.f9660t.getText().toString();
        goto L49
    L52:
        if (r10.getId() != R$id.clear_history) goto L56;
        this.D.j(4, null, null);
        a0(null);
        return;
    L56:
        if (r10.getId() != R$id.refresh_btn) goto L60;
        StateView.showLoadingView(this.f9646f);
        O(this.f9642b, this.f9643c, 1, null);
        return;
    L60:
        if (r10.getId() != R$id.app_list_sub_item) goto L63;
        AppInfo r110 = (AppInfo) r10.getTag(R$id.appinfo);
        SubAppEntity r21 = new SubAppEntity();
        r21.setId(r110.getId());
        GameSubDetailActivity.start(this, r21);
        return;
    L63:
        Object r22 = r10.getTag(R$id.click_event);
        if (r22 != null) goto L66;
        return;
    L66:
        if ((r22 instanceof Integer) == false) goto L81;
        int r23 = ((Integer) r22).intValue();
        if (r23 != 1) goto L70;
        AppInfo r24 = (AppInfo) r10.getTag(R$id.appinfo);
        return;
    L70:
        if (r23 != 2) goto L82;
        com.bytedanceos.common.toolbox.e.e1(this, (AppInfo) r10.getTag(R$id.appinfo), 0, getString(R$string.search));
        return;
    L82:
        return;
    }

    @Override // com.bytedanceos.common.ui.StatusBarActivity, com.bytedanceos.common.ui.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        setContentView(R$layout.main_search_activity);
        initView();
        initData();
        BaseApplication.c().b().addObserver(this);
        this.f9665y = System.currentTimeMillis();
        EventBus.getDefault().register(this);
    }

    @Override // com.bytedanceos.common.ui.StatusBarActivity, com.bytedanceos.common.ui.BasicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        D();
        BaseApplication.c().b().deleteObserver(this);
        q8.b.c().b(500001);
        r8.a r10 = this.D;
        if (r10 == null) goto L5;
        r10.c();
    L5:
        this.E.removeCallbacksAndMessages(null);
        EventBus.getDefault().unregister(this);
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView r10, int r11, KeyEvent r12) {
        if (r10 != null) goto L5;
    L7:
        String r13 = "";
    L8:
        this.f9640J = "search_type=search";
        if (TextUtils.isEmpty(r13) == true) goto L12;
        U(r13, 8, true);
        d9.a.e().M(r13, r13, true);
        CommonAPIHelper.c0(r13, 1, "");
        return true;
    L12:
        if (r10 != null) goto L14;
    L16:
        String r14 = "";
    L18:
        if (TextUtils.isEmpty(r14) == false) goto L20;
    L23:
        e0.e(R$string.search_invalid_key);
    L24:
        return true;
    L20:
        if (TextUtils.equals(r14, getString(R$string.search)) == true) goto L23;
        U(r14, 7, true);
        d9.a.e().M(r14, r14, true);
        d9.a.e().I(r14);
        CommonAPIHelper.c0(r14, 1, "");
        goto L24
    L14:
        if (r10.getHint() == null) goto L16;
        r14 = r10.getHint().toString().trim();
        goto L18
    L5:
        if (r10.getText() == null) goto L7;
        r13 = r10.getText().toString().trim();
        goto L8
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(OnSubEvent r10) {
        this.mIsRefresh = true;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView r10, View r11, int r12, long r13) {
        Object r14 = r10.getItemAtPosition(r12);
        if ((r10 instanceof ListView) == false) goto L29;
        if (r14 == null) goto L32;
        OInputView r15 = this.f9660t;
        if (r15 != null) goto L9;
    L11:
        String r16 = "";
    L12:
        this.f9640J = "search_type=keyword";
        AppInfo r17 = (AppInfo) r14;
        if (r10.getId() != R$id.search_lv) goto L25;
        String r18 = r17.listShowType;
        if (TextUtils.equals("apps", r18) == false) goto L18;
        com.bytedanceos.common.toolbox.e.e1(this, r17, 0, getString(R$string.search));
        CommonAPIHelper.c0(r16, 3, r17.appName);
        d9.a.e().M(r17.appName, r16, false);
    L23:
        this.f9661u.setAdapter(null);
        P(this.f9661u);
        return;
    L18:
        if (TextUtils.equals(AppInfo.SEARCH_LIST_SHOW_WORDS, r18) == false) goto L21;
        U(r17.appName, 8, true);
        d9.a.e().M(r17.appName, r16, false);
        d9.a.e().P("0069");
        CommonAPIHelper.c0(r16, 2, r17.appName);
        goto L23
    L21:
        if (TextUtils.equals(AppInfo.SEARCH_LIST_SHOW_RESERVATION_APPS, r18) == false) goto L23;
        SubAppEntity r19 = new SubAppEntity();
        r19.setId(r17.getId());
        GameSubDetailActivity.start(this, r19);
        goto L23
    L25:
        if (r10.getId() != R$id.applist_lv) goto L27;
        com.bytedanceos.common.toolbox.e.e1(this, r17, 0, getString(R$string.search));
        return;
    L27:
        e0.g("未知id");
        return;
    L9:
        if (r15.getText() == null) goto L11;
        r16 = this.f9660t.getText().toString();
        goto L12
    L32:
        return;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView r10, View r11, int r12, long r13) {
        if (r13 != (-1)) goto L5;
    L30:
        return true;
    L5:
        if (ReflectTool.isSidebarShowing(BaseApplication.c()) == false) goto L30;
        Object r14 = r10.getItemAtPosition(r12);
        if (r14 != null) goto L10;
        return true;
    L10:
        AppInfo r15 = (AppInfo) r14;
        String r16 = r15.listShowType;
        if (TextUtils.isEmpty(r15.appShareUrl) == false) goto L13;
        String r17 = r15.appDownloadUrl;
    L15:
        if (TextUtils.equals("apps", r16) == false) goto L30;
        if (TextUtils.isEmpty(r17) == true) goto L30;
        Drawable r18 = ((ImageView) r11.findViewById(R$id.appIcon)).getDrawable();
        if (r18 != null) goto L21;
        Bitmap r19 = null;
    L25:
        BaseApplication r20 = BaseApplication.c();
        String r21 = B(r17, r15, r11);
        Bitmap r22 = BitmapFactory.decodeResource(getResources(), R$drawable.storedrag_big);
        if (r19 != null) goto L28;
        Bitmap r23 = BitmapFactory.decodeResource(getResources(), R$drawable.storedrag_default);
    L29:
        ReflectTool.dragLink(r11, r20, r21, r22, r23);
        goto L30
    L28:
        r23 = Bitmap.createScaledBitmap(r19, getResources().getDimensionPixelSize(R$dimen.dragview_width), getResources().getDimensionPixelSize(R$dimen.dragview_height), true);
        goto L29
    L21:
        if ((r18 instanceof TransitionDrawable) == false) goto L23;
        r19 = ((BitmapDrawable) ((TransitionDrawable) r18).getDrawable(1)).getBitmap();
        goto L25
    L23:
        r19 = ((BitmapDrawable) r18).getBitmap();
        goto L25
    L13:
        r17 = r15.appShareUrl;
        goto L15
    }

    @Override // com.bytedanceos.common.ui.listener.IRelatedClickListener
    public void onRelatedClick(RelatedAppInfo r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r10.getName()) == true) goto L8;
        U(r10.getName(), 8, true);
        return;
    }

    @Override // com.bytedanceos.common.core.ui.presenter.IView
    public void onRequestError(Throwable r10) {
    }

    @Override // com.bytedanceos.common.ui.StatusBarActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if ((System.currentTimeMillis() - this.f9665y) <= 300) goto L6;
        this.E.postDelayed(new o(this), 50);
        return;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence r10, int r11, int r12, int r13) {
        OUISearchBar r14 = this.f9659s;
        if (r14 != null) goto L5;
        return;
    L5:
        if (r14.isSearchMode() == false) goto L18;
        String r15 = r10.toString().trim();
        if (r15.length() != 0) goto L12;
        z();
        return;
    L12:
        if (this.f9645e == false) goto L14;
        this.f9645e = false;
        return;
    L14:
        S(r15, false);
        return;
    }

    @Override // com.bytedanceos.common.core.ui.presenter.IView
    public /* bridge */ /* synthetic */ void onUpdateView(int r10, Integer r11, Object r12) {
        I(r10, r11, r12);
    }

    public void showRefreshView() {
        StateView.showRefreshView(this.f9646f, this);
    }

    @Override // java.util.Observer
    public void update(Observable r10, Object r11) {
        runOnUiThread(new a(this));
    }

    public abstract void updateListView(ListView r10);

    public final void z() {
        if (this.f9642b != 8) goto L5;
        this.f9642b = 0;
        this.D.k();
    L6:
        hideStateView();
        if (this.f9661u == null) goto L9;
        Q(true, null);
        this.f9661u.setVisibility(8);
    L9:
        D();
        RelativeLayout r10 = this.f9657q;
        if (r10 == null) goto L12;
        r10.setVisibility(0);
    L12:
        R(true);
        return;
    L5:
        W();
        this.D.b(500003);
        this.D.b(500001);
        this.D.b(500002);
        this.D.b(500005);
        goto L6
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(LoginEvent r10) {
        this.mIsRefresh = true;
    }
}
