package com.bytedanceos.appstore.ui.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.HeaderViewListAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedanceos.appstore.model.Developer;
import com.bytedanceos.appstore.ui.MainActivity;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.ad.param.AdReportParam;
import com.bytedanceos.common.model.AppComments;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.AppList;
import com.bytedanceos.common.model.CommentInfo;
import com.bytedanceos.common.model.GiftPackInfo;
import com.bytedanceos.common.model.Topic;
import com.bytedanceos.common.network.FetchDataCallBack;
import com.bytedanceos.common.network.api.CommonAPIHelper;
import com.bytedanceos.common.network.widget.NetworkImageView;
import com.bytedanceos.common.toolbox.ServerElements;
import com.bytedanceos.common.toolbox.c0;
import com.bytedanceos.common.toolbox.cache.AccountDataCache;
import com.bytedanceos.common.toolbox.e0;
import com.bytedanceos.common.tracker.TrackerElement;
import com.bytedanceos.common.ui.CommonConfirmDialog;
import com.bytedanceos.common.ui.ConfirmDialog;
import com.bytedanceos.common.ui.ConfirmLoginInfoActivity;
import com.bytedanceos.common.ui.adapter.AppListAdapter;
import com.bytedanceos.common.ui.adapter.GameGiftAdapter;
import com.bytedanceos.common.ui.dialog.AddCommentDialog;
import com.bytedanceos.common.ui.fragment.AppCommentsView;
import com.bytedanceos.common.ui.fragment.BasicFragment;
import com.bytedanceos.common.ui.fragment.StateView;
import com.bytedanceos.common.ui.utils.ViewPagerRecycledPool;
import com.bytedanceos.common.ui.widget.AppListView;
import com.bytedanceos.common.ui.widget.ParentView;
import com.bytedanceos.common.ui.widget.RefreshLoadListView;
import com.bytedanceos.common.utils.AppStoreCommonError;
import com.bytedanceos.common.utils.ReflectTool;
import com.obric.appstore.R;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Observable;
import java.util.Observer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseFragment extends BasicFragment implements FetchDataCallBack, View.OnClickListener, AdapterView.OnItemClickListener, Observer {
    public m8.a A;
    public AccountDataCache B;
    public ConfirmDialog C;
    public Handler D;
    public AlertDialog E;
    public com.bytedanceos.appstore.ui.fragment.a F;
    public boolean G;
    public String H;
    public String I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public View.OnClickListener f9443J;
    public View.OnClickListener K;
    public View.OnLongClickListener L;
    public LinkedHashMap M;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9445b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9446c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ViewGroup f9447d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f9448e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewGroup f9449f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ViewGroup f9450g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ViewGroup f9451h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ParentView f9452i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public RefreshLoadListView f9453j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f9454k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f9455l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f9456m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f9457n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f9458o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f9459p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f9460q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f9461r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f9462s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f9463t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f9464u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f9465v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f9466w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f9467x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f9468y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public View f9469z;

    public interface AnimationEndCallBack {
        void fetchData(Object... r10);
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f9470a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BaseFragment f9471b;

        public a(BaseFragment r10, Object r11) {
            this.f9471b = r10;
            this.f9470a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object r10 = this.f9470a;
            if (r10 != null) goto L5;
        L15:
            this.f9471b.T0();
            return;
        L5:
            if ((r10 instanceof Bundle) == false) goto L15;
            Bundle r11 = (Bundle) r10;
            AppStoreCommonError r12 = (AppStoreCommonError) r11.getSerializable("error");
            String r13 = r11.getString("key");
            if (TextUtils.isEmpty(r13) == true) goto L15;
            if (r12 != null) goto L15;
            if (TrackerElement.ISLOGIN.equals(r13) == false) goto L12;
        L13:
            com.bytedanceos.common.toolbox.j.a("account change:" + this.f9471b.N());
            this.f9471b.s0();
            return;
        L12:
            if ("logout".equals(r13) == false) goto L15;
            goto L13
        }
    }

    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseFragment f9472a;

        public b(BaseFragment r10) {
            this.f9472a = r10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r10) {
            AppInfo r11 = this.f9472a.L(r10);
            if (r11 != null) goto L5;
            return;
        L5:
            RefreshLoadListView r12 = this.f9472a.f9453j;
            if (r12 == null) goto L8;
            r12.stopLoadMore();
        L8:
            r11.mPageTitle = this.f9472a.O();
            this.f9472a.k0(r11);
        }
    }

    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseFragment f9473a;

        public c(BaseFragment r10) {
            this.f9473a = r10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r10) {
            AppInfo r11 = (AppInfo) r10.getTag();
            if (r11 != null) goto L5;
            return;
        L5:
            com.bytedanceos.appstore.ui.fragment.a r12 = this.f9473a.F;
            if (r12 == null) goto L8;
            AppInfo r13 = (AppInfo) r12.k().getTag();
            r11.mPageTitle = r13.mPageTitle;
            r11.mSourcePkgName = r13.mSourcePkgName;
        L8:
            BaseFragment r14 = this.f9473a;
            r14.G = true;
            if (r14.f9446c != 5) goto L11;
            String r15 = ((AppInfo) r14.f9449f.getTag()).appName;
        L13:
            if (BaseFragment.v(this.f9473a) != 1) goto L15;
            this.f9473a.x0(8);
        L15:
            BaseFragment r16 = this.f9473a;
            r16.E0(r16.f9447d, r15, 1, r11);
            return;
        L11:
            r15 = ((AppInfo) r14.f9447d.getTag()).appName;
            goto L13
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ListView f9474a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f9475b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BaseFragment f9476c;

        public d(BaseFragment r10, ListView r11, boolean r12) {
            this.f9476c = r10;
            this.f9474a = r11;
            this.f9475b = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            int r10 = AppListView.getPage(this.f9474a);
            if (r10 != 2) goto L7;
            if (this.f9475b == false) goto L7;
        L8:
            this.f9474a.setSelection(0);
        L9:
            this.f9474a.setVisibility(0);
            return;
        L7:
            if (r10 != 1) goto L9;
            goto L8
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f9477a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f9478b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f9479c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f9480d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ BaseFragment f9481e;

        public e(BaseFragment r10, int r11, String r12, Object r13, String r14) {
            this.f9481e = r10;
            this.f9477a = r11;
            this.f9478b = r12;
            this.f9479c = r13;
            this.f9480d = r14;
        }

        @Override // java.lang.Runnable
        public void run() {
            int r10 = this.f9477a;
            switch(r10) {
                case 100001: goto L18;
                case 200001: goto L18;
                case 200002: goto L18;
                case 200003: goto L18;
                case 200004: goto L17;
                case 300001: goto L18;
                case 300002: goto L18;
                case 300003: goto L18;
                case 400001: goto L18;
                case 400002: goto L18;
                case 400003: goto L18;
                case 500001: goto L18;
                case 500002: goto L18;
                case 500003: goto L18;
                case 600001: goto L18;
                case 600002: goto L18;
                case 600003: goto L18;
                case 600006: goto L18;
                case 700001: goto L16;
                case 700002: goto L16;
                case 700003: goto L16;
                case 700004: goto L15;
                case 700007: goto L14;
                case 700008: goto L13;
                case 700009: goto L12;
                case 700010: goto L11;
                case 700011: goto L10;
                case 700012: goto L9;
                case 1000004: goto L8;
                case 1000005: goto L7;
                case 1000007: goto L7;
                case 1100000: goto L18;
                case 1100001: goto L6;
                case 1400001: goto L18;
                case 1400002: goto L18;
                case 1400004: goto L5;
                case 1600000: goto L18;
                case 2000001: goto L18;
                case 2000002: goto L18;
                case 2000003: goto L18;
                default: goto L33;
            };
        L5:
            this.f9481e.Q(this.f9478b, this.f9479c);
            return;
        L6:
            com.bytedanceos.common.toolbox.e.h1(this.f9481e.f9469z, this.f9478b);
            return;
        L7:
            BaseFragment.n(this.f9481e, this.f9478b);
            return;
        L8:
            BaseFragment.m(this.f9481e, this.f9478b);
            return;
        L9:
            BaseFragment.C(this.f9481e, this.f9478b, this.f9479c);
            return;
        L10:
            this.f9481e.O0(this.f9478b, this.f9480d);
            return;
        L11:
            BaseFragment.B(this.f9481e, this.f9478b, this.f9479c);
            return;
        L12:
            BaseFragment.x(this.f9481e, this.f9478b);
            return;
        L13:
            BaseFragment.z(this.f9481e, this.f9478b);
            return;
        L14:
            BaseFragment.A(this.f9481e, this.f9478b);
            return;
        L15:
            BaseFragment.y(this.f9481e, this.f9478b, this.f9479c);
            return;
        L16:
            BaseFragment.w(this.f9481e, this.f9478b, true, this.f9479c);
            return;
        L17:
            BaseFragment.o(this.f9481e, this.f9478b, this.f9480d);
            return;
        L18:
            this.f9481e.t0(r10, this.f9478b, this.f9480d);
            return;
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Throwable f9482a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f9483b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f9484c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Object f9485d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ BaseFragment f9486e;

        public f(BaseFragment r10, Throwable r11, String r12, int r13, Object r14) {
            this.f9486e = r10;
            this.f9482a = r11;
            this.f9483b = r12;
            this.f9484c = r13;
            this.f9485d = r14;
        }

        @Override // java.lang.Runnable
        public void run() {
            AppStoreCommonError r10 = com.bytedanceos.common.utils.n.a(BaseApplication.c(), this.f9482a, this.f9483b);
            if (this.f9486e.i0(this.f9484c, this.f9482a, this.f9483b, r10) == false) goto L5;
            return;
        L5:
            int r11 = this.f9484c;
            switch(r11) {
                case 100001: goto L18;
                case 200001: goto L18;
                case 200002: goto L18;
                case 200003: goto L18;
                case 200004: goto L17;
                case 300001: goto L18;
                case 300002: goto L18;
                case 300003: goto L18;
                case 400001: goto L16;
                case 400002: goto L18;
                case 400003: goto L18;
                case 500002: goto L18;
                case 500003: goto L18;
                case 600001: goto L16;
                case 600002: goto L16;
                case 600003: goto L16;
                case 600006: goto L16;
                case 700001: goto L15;
                case 700002: goto L15;
                case 700003: goto L15;
                case 700004: goto L14;
                case 700007: goto L13;
                case 700008: goto L12;
                case 700010: goto L11;
                case 700011: goto L10;
                case 700012: goto L9;
                case 1100001: goto L8;
                case 1400001: goto L18;
                case 1400002: goto L18;
                case 1600000: goto L18;
                case 2000001: goto L18;
                case 2000002: goto L18;
                case 2000003: goto L18;
                default: goto L30;
            };
        L8:
            com.bytedanceos.common.toolbox.e.g1(this.f9486e.f9469z);
            return;
        L9:
            BaseFragment.t(this.f9486e, r10, this.f9483b, this.f9485d);
            return;
        L10:
            this.f9486e.O0(this.f9483b, null);
            return;
        L11:
            BaseFragment.s(this.f9486e, r10, this.f9483b, this.f9485d);
            return;
        L12:
            BaseFragment.q(this.f9486e, r10, this.f9483b);
            return;
        L13:
            BaseFragment.r(this.f9486e, r10, this.f9483b);
            return;
        L14:
            BaseFragment.p(this.f9486e, r10);
            return;
        L15:
            BaseFragment.w(this.f9486e, this.f9483b, false, this.f9485d);
            return;
        L16:
            com.bytedanceos.common.toolbox.j.a("showRefreshView: " + this.f9486e.getCurrentTag() + ": onFetchDataSuccess: api: " + this.f9484c);
            this.f9486e.showRefreshView();
            return;
        L17:
            BaseFragment.o(this.f9486e, this.f9483b, null);
            return;
        L18:
            this.f9486e.u0(r11, r10);
            return;
        }
    }

    public class g implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseFragment f9487a;

        public g(BaseFragment r10) {
            this.f9487a = r10;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View r10) {
            if (ReflectTool.isSidebarShowing(BaseApplication.c()) == false) goto L19;
            AppInfo r11 = (AppInfo) r10.getTag(R.id.appinfo);
            if (r11 == null) goto L7;
            String r12 = r11.appDownloadUrl;
        L14:
            if (TextUtils.isEmpty(r12) == true) goto L16;
            BaseFragment r13 = this.f9487a;
            r13.f9469z = r10;
            CommonAPIHelper.P(r12, r13);
            return true;
        L16:
            com.bytedanceos.common.toolbox.j.a("The drag download url is null");
            return true;
        L7:
            r10 = (View) r10.getParent();
            if (r10 == null) goto L12;
            AppInfo r14 = (AppInfo) r10.getTag(R.id.appinfo);
            if (r14 == null) goto L12;
            r12 = r14.appDownloadUrl;
        L12:
            r12 = "";
            goto L14
        L19:
            return true;
        }
    }

    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppInfo f9488a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BaseFragment f9489b;

        public h(BaseFragment r10, AppInfo r11) {
            this.f9489b = r10;
            this.f9488a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedanceos.common.toolbox.e.v1(this.f9489b.getActivity(), this.f9488a);
        }
    }

    public class i implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseFragment f9490a;

        public i(BaseFragment r10) {
            this.f9490a = r10;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r10, int r11) {
            Intent r12 = new Intent();
            r12.setClassName("com.bytedanceos.updater", "com.bytedanceos.updater.UpdatesCheck");
            r12.setAction("android.intent.action.MAIN");
            this.f9490a.startActivity(r12);
            this.f9490a.getActivity().finish();
        }
    }

    public class j implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseFragment f9491a;

        public j(BaseFragment r10) {
            this.f9491a = r10;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r10, int r11) {
            r10.cancel();
            this.f9491a.getActivity().finish();
        }
    }

    public class k implements AnimationEndCallBack {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f9492a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AppInfo f9493b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f9494c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ BaseFragment f9495d;

        public k(BaseFragment r10, int r11, AppInfo r12, Object r13) {
            this.f9495d = r10;
            this.f9492a = r11;
            this.f9493b = r12;
            this.f9494c = r13;
        }

        @Override // com.bytedanceos.appstore.ui.fragment.BaseFragment.AnimationEndCallBack
        public void fetchData(Object... r10) {
            BaseFragment r11 = this.f9495d;
            int r12 = r11.f9446c;
            if (r12 != 3) goto L5;
        L19:
            int r13 = this.f9492a;
            if (r13 == 0) goto L26;
            if (r13 != 1) goto L23;
        L25:
            CommonAPIHelper.s(r11.f9445b, r11.f9457n, r11);
            return;
        L23:
            if (r13 == 2) goto L25;
            return;
        L26:
            CommonAPIHelper.I(r11.f9445b, r11.f9457n, r11);
            return;
        L5:
            if (r12 == 4) goto L19;
            if (r12 != 5) goto L11;
            CommonAPIHelper.s(r11.f9445b, this.f9493b.appPackageName, r11);
            return;
        L11:
            if (r12 != 6) goto L14;
            CommonAPIHelper.q(r11.f9445b, this.f9494c, 1, r11);
            return;
        L14:
            if (r12 == 9) goto L16;
            return;
        L16:
            if (this.f9493b != null) goto L18;
            AppListView.setState(r11.f9453j, 1);
            CommonAPIHelper.H(1, this.f9495d);
            return;
        L18:
            AppListView.setState(r11.f9453j, 1);
            BaseFragment r14 = this.f9495d;
            int r15 = r14.f9445b;
            AppInfo r16 = this.f9493b;
            CommonAPIHelper.z(r15, r16.appDeveloper, r16.appDeveloperId, 1, r14);
        }
    }

    public class l implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f9496a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AnimationEndCallBack f9497b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f9498c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ BaseFragment f9499d;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ l f9500a;

            public a(l r10) {
                this.f9500a = r10;
            }

            @Override // java.lang.Runnable
            public void run() {
                BaseFragment r10 = this.f9500a.f9499d;
                r10.mIsAnimating = false;
                ParentView r11 = r10.f9452i;
                if (r11 == null) goto L6;
                r11.beBusy(false);
                return;
            }
        }

        public l(BaseFragment r10, boolean r11, AnimationEndCallBack r12, ViewGroup r13) {
            this.f9499d = r10;
            this.f9496a = r11;
            this.f9497b = r12;
            this.f9498c = r13;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation r10) {
            if (this.f9496a == true) goto L9;
            AnimationEndCallBack r11 = this.f9497b;
            if (r11 == null) goto L7;
            r11.fetchData(new Object[0]);
        L7:
            this.f9498c.post(new a(this));
            return;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation r10) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation r10) {
        }
    }

    public class m implements DialogInterface.OnCancelListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseFragment f9501a;

        public m(BaseFragment r10) {
            this.f9501a = r10;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface r10) {
        }
    }

    public class n implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CheckBox f9502a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AppInfo f9503b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BaseFragment f9504c;

        public n(BaseFragment r10, CheckBox r11, AppInfo r12) {
            this.f9504c = r10;
            this.f9502a = r11;
            this.f9503b = r12;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r10, int r11) {
            r10.dismiss();
            com.bytedanceos.appstore.utils.a.z(false, this.f9502a.isChecked());
            BaseFragment.k(this.f9504c, this.f9503b, true);
        }
    }

    public class o implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CheckBox f9505a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AppInfo f9506b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BaseFragment f9507c;

        public o(BaseFragment r10, CheckBox r11, AppInfo r12) {
            this.f9507c = r10;
            this.f9505a = r11;
            this.f9506b = r12;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r10, int r11) {
            r10.dismiss();
            com.bytedanceos.appstore.utils.a.z(true, this.f9505a.isChecked());
            if (2 != com.bytedanceos.common.toolbox.e.A()) goto L5;
            BaseFragment.k(this.f9507c, this.f9506b, true);
            return;
        L5:
            BaseFragment.l(this.f9507c, this.f9506b);
        }
    }

    public BaseFragment() {
        this.f9444a = 0;
        if (com.bytedanceos.appstore.utils.d.a() == false) goto L5;
        int r10 = 2;
    L6:
        this.f9445b = r10;
        this.f9446c = 0;
        this.f9448e = 0;
        this.f9463t = true;
        this.f9464u = true;
        this.f9465v = false;
        this.H = AdReportParam.ClickPosType.SKIP;
        this.I = null;
        this.f9443J = new b(this);
        this.K = new c(this);
        this.L = new g(this);
        final int r11 = 5;
        this.M = new AnonymousClass19(this, r11);
        return;
    L5:
        r10 = 3;
        goto L6
    }

    public static /* synthetic */ void A(BaseFragment r10, String r11) {
        r10.R(r11);
    }

    public static /* synthetic */ void B(BaseFragment r10, String r11, Object r12) {
        r10.b0(r11, r12);
    }

    public static /* synthetic */ void C(BaseFragment r10, String r11, Object r12) {
        r10.e0(r11, r12);
    }

    public static /* synthetic */ void k(BaseFragment r10, AppInfo r11, boolean r12) {
        r10.m0(r11, r12);
    }

    public static /* synthetic */ void l(BaseFragment r10, AppInfo r11) {
        r10.U0(r11);
    }

    public static /* synthetic */ void m(BaseFragment r10, String r11) {
        r10.T(r11);
    }

    public static /* synthetic */ void n(BaseFragment r10, String r11) {
        r10.a0(r11);
    }

    public static /* synthetic */ void o(BaseFragment r10, String r11, String r12) {
        r10.R0(r11, r12);
    }

    public static /* synthetic */ void p(BaseFragment r10, AppStoreCommonError r11) {
        r10.U(r11);
    }

    public static /* synthetic */ void q(BaseFragment r10, AppStoreCommonError r11, String r12) {
        r10.Z(r11, r12);
    }

    public static /* synthetic */ void r(BaseFragment r10, AppStoreCommonError r11, String r12) {
        r10.S(r11, r12);
    }

    public static /* synthetic */ void s(BaseFragment r10, AppStoreCommonError r11, String r12, Object r13) {
        r10.c0(r11, r12, r13);
    }

    public static /* synthetic */ void t(BaseFragment r10, AppStoreCommonError r11, String r12, Object r13) {
        r10.d0(r11, r12, r13);
    }

    public static /* synthetic */ void u(BaseFragment r10, com.bytedanceos.appstore.ui.fragment.a r11, com.bytedanceos.appstore.ui.fragment.a r12) {
        r10.M0(r11, r12);
    }

    public static /* synthetic */ int v(BaseFragment r10) {
        return r10.f9444a;
    }

    public static /* synthetic */ void w(BaseFragment r10, String r11, boolean r12, Object r13) {
        r10.W(r11, r12, r13);
    }

    public static /* synthetic */ void x(BaseFragment r10, String r11) {
        r10.X(r11);
    }

    public static /* synthetic */ void y(BaseFragment r10, String r11, Object r12) {
        r10.V(r11, r12);
    }

    public static /* synthetic */ void z(BaseFragment r10, String r11) {
        r10.Y(r11);
    }

    public void A0(int r10, boolean r11) {
        this.f9446c = r10;
    }

    public void B0(View r10, String r11) {
        TextView r12 = (TextView) r10.findViewById(R.id.topic_banner_desc);
        r12.setText(r11);
        if (com.bytedanceos.common.toolbox.e.o0() == true) goto L5;
        r12.setVisibility(0);
        return;
    L5:
        r12.setVisibility(8);
    }

    public void C0(ViewGroup r10, int r11, boolean r12, AnimationEndCallBack r13) {
        if (r12 == true) goto L4;
        this.mIsAnimating = true;
        this.f9452i.beBusy(true);
    L4:
        Animation r14 = AnimationUtils.loadAnimation(BaseApplication.c(), r11);
        r14.setAnimationListener(new l(this, r12, r13, r10));
        r10.clearAnimation();     // Catch: Exception -> L7
    L9:
        r10.startAnimation(r14);
        return;
    L7:
        e = move-exception;
        e.getStackTrace();
        goto L9
    }

    public String D(String r10, String r11, String r12) {
        return d9.a.a(r10, r11, r12);
    }

    public final void D0(String r10, String r11) {
        if (this.mAddCommentDialog != null) goto L5;
        this.mAddCommentDialog = new AddCommentDialog(getActivity(), R.style.dialog_comment, null);
    L5:
        String r12 = this.f9457n;
        int r13 = this.f9446c;
        if (r13 != 5) goto L8;
    L11:
        r12 = this.f9462s;
    L12:
        this.mAddCommentDialog.setPackageName(r12);
        this.mAddCommentDialog.setData(r10, r11);
        this.mAddCommentDialog.getWindow().setSoftInputMode(5);
        this.mAddCommentDialog.show();
        return;
    L8:
        if (r13 != 6) goto L12;
        if (this.f9448e != 3) goto L12;
        goto L11
    }

    public void E(ViewGroup r10, ViewGroup r11, AnimationEndCallBack r12) {
        if (r10 == null) goto L4;
        r10.setVisibility(8);
        C0(r10, R.anim.slide_out_to_right, true, null);
    L5:
        if (r11 == null) goto L7;
        r11.setVisibility(0);
        C0(r11, R.anim.slide_in_from_left, false, r12);
        return;
    L7:
        com.bytedanceos.common.toolbox.j.a("inView is null.");
        return;
    L4:
        com.bytedanceos.common.toolbox.j.a("viewOut is null.");
        goto L5
    }

    public void E0(ViewGroup r10, String r11, int r12, AppInfo r13) {
        com.bytedanceos.common.toolbox.e.e1(getActivity(), r13, 0, r11);
    }

    public void F() {
        ViewGroup r10 = this.f9449f;
        RefreshLoadListView r11 = this.f9453j;
        G(r10, r11, 9, r11.getTag(R.id.app_list_key).toString(), this.f9456m, new int[]{R.id.left_action_back});
        Q0(this.f9453j);
    }

    public void F0() {
    }

    public void G(ViewGroup r10, ViewGroup r11, int r12, String r13, String r14, int... r15) {
        H(r10, r11, null, r12, r13, r14, r15);
    }

    public void G0(ListView r10, boolean r11) {
        int r12 = AppListView.getState(r10);
        if (r12 != 1) goto L5;
        r10.setVisibility(8);
        showLoadingView();
        return;
    L5:
        if (r12 != 3) goto L7;
        r10.setVisibility(8);
        F0();
        return;
    L7:
        if (r12 != 4) goto L9;
        r10.setVisibility(8);
        showRefreshView();
        return;
    L9:
        if (r12 != 5) goto L11;
        r10.setVisibility(8);
        showLoginView();
        return;
    L11:
        if (r12 == 6) goto L14;
        return;
    L14:
        if (isStateViewVisible() == false) goto L16;
        hideStateView();
    L16:
        r10.post(new d(this, r10, r11));
        if (r11 == false) goto L24;
        Q0(r10);
        return;
    }

    public void H(ViewGroup r10, ViewGroup r11, AnimationEndCallBack r12, int r13, String r14, String r15, int... r16) {
        com.bytedanceos.appstore.ui.fragment.a r17 = this.F;
        if (r17 == null) goto L5;
        r17.E(r13);
    L5:
        z0(r13);
        E(r10, r11, r12);
        T0();
    }

    public final void H0() {
        if (getActivity() != null) goto L6;
        com.bytedanceos.common.toolbox.j.e("activity is null.");
        return;
    L6:
        AlertDialog r10 = new AlertDialog.Builder(new ContextThemeWrapper(getActivity(), R.style.AppStoreDialogTheme)).setTitle(R.string.client_need_update_title).setMessage(R.string.client_need_update_desp).setNegativeButton(android.R.string.cancel, new j(this)).setPositiveButton(R.string.client_update, new i(this)).create();
        r10.setCancelable(false);
        r10.show();
    }

    public void I() {
        this.M.clear();
        this.F = null;
    }

    public final void I0(String r10, boolean r11) {
    }

    public View J(int r10, int r11) {
        View r12 = LayoutInflater.from(getActivity()).inflate(r10, null);
        ((NetworkImageView) r12.findViewById(R.id.topic_banner)).setDefaultImageResId(r11);
        return r12;
    }

    public void J0() {
        String r10 = getString(R.string.app_no_offer_msg);
        StateView.showEmptyView(this.mStateView, r10, "", new int[]{R.drawable.app_no_offer});
    }

    public void K(AppInfo r10, boolean r11) {
        if (com.bytedanceos.appstore.datacache.a.N0().X(r10.appPackageName) == false) goto L6;
        com.bytedanceos.common.toolbox.j.a("downloading:" + r10.appPackageName);
        return;
    L6:
        if (com.bytedanceos.appstore.datacache.a.N0().c0(r10.appPackageName) == false) goto L9;
        com.bytedanceos.common.utils.j.c(BaseApplication.c(), r10, r11);
        return;
    L9:
        if (com.bytedanceos.appstore.utils.a.c(r10.appDownloadUrl) == false) goto L11;
        com.bytedanceos.common.utils.j.a(getActivity(), r10, false);
        return;
    L11:
        e0.e(R.string.download_error_url);
    }

    public void K0(ViewGroup r10, int r11, AppInfo r12, Object r13) {
        L0(r10, this.mStateView, new k(this, r11, r12, r13));
    }

    public AppInfo L(View r10) {
        if (this.mIsAnimating == false) goto L6;
        return null;
    L6:
        if (r10.getTag(R.id.appinfo) != null) goto L9;
        return null;
    L9:
        return (AppInfo) r10.getTag(R.id.appinfo);
    }

    public void L0(ViewGroup r10, ViewGroup r11, AnimationEndCallBack r12) {
        if (r10 == null) goto L7;
        if (r11 == null) goto L8;
        r10.setVisibility(8);
        r11.setVisibility(0);
        C0(r10, R.anim.slide_out_to_left, true, null);
        C0(r11, R.anim.slide_in_from_right, false, r12);
        return;
    L8:
        return;
    }

    public String M(AppInfo r10) {
        if (this.f9446c != 5) goto L7;
        return com.bytedanceos.common.toolbox.e.x(r10, "9021", getSourcePageName());
    L7:
        if (this.G == false) goto L11;
        return com.bytedanceos.common.toolbox.e.x(r10, "9014", getSourcePageName());
    L11:
        return com.bytedanceos.common.toolbox.e.x(r10, getPageSource(), getSourcePageName());
    }

    public final void M0(com.bytedanceos.appstore.ui.fragment.a r10, com.bytedanceos.appstore.ui.fragment.a r11) {
        int r12 = r10.getState();
        if (r12 == 3) goto L7;
        if (r12 == 4) goto L7;
        r12 = r10.p();
    L7:
        if (r11.getState() != 3) goto L9;
    L12:
        r11.E(r12);
        return;
    L9:
        if (r11.getState() == 4) goto L12;
        r11.C(r12);
    }

    public abstract String N();

    public void N0() {
    }

    public String O() {
        FragmentActivity r10 = getActivity();
        if (r10 != null) goto L5;
        return "";
    L5:
        TextView r11 = (TextView) r10.findViewById(R.id.toolbar_title);
        if (r11 != null) goto L8;
        return "";
    L8:
        if (r11.getText() != null) goto L10;
        return "";
    L10:
        return r11.getText().toString();
    }

    public void O0(String r10, String r11) {
        if (this.f9446c == 9) goto L5;
        return;
    L5:
        Developer r12 = com.bytedanceos.appstore.utils.b.c0(r10);
        if (r12 != null) goto L8;
        this.f9453j.removeHeaderView(this.f9454k);
    L28:
        this.f9453j.removeHeaderView(this.f9455l);
        AppList r13 = c9.a.r(r10, r11);
        q0(this.f9453j, r13);
        G0(this.f9453j, true);
        return;
    L8:
        if (this.f9454k != null) goto L10;
        View r14 = LayoutInflater.from(getActivity()).inflate(R.layout.develop_header_banner, null);
        this.f9454k = r14;
        r14.setOnClickListener(null);
    L10:
        TextView r15 = (TextView) this.f9454k.findViewById(R.id.dev_title);
        TextView r16 = (TextView) this.f9454k.findViewById(R.id.dev_des);
        NetworkImageView r17 = (NetworkImageView) this.f9454k.findViewById(R.id.dev_banner);
        r17.setDefaultImageResId(R.drawable.topic_banner_default_bg);
        if (TextUtils.isEmpty(r12.getDevName()) == false) goto L13;
        r15.setVisibility(8);
    L15:
        if (TextUtils.isEmpty(r12.getDevInfo()) == false) goto L17;
        r16.setVisibility(8);
    L19:
        if (TextUtils.isEmpty(r12.getDevBanner()) == false) goto L22;
        r17.setVisibility(8);
    L26:
        this.f9453j.removeHeaderView(this.f9454k);
        this.f9453j.addHeaderView(this.f9454k);
        goto L28
    L22:
        if (com.bytedanceos.appstore.utils.a.r(BaseApplication.c()) == false) goto L24;
        r17.setImageUrl(r12.getDevBanner());
    L25:
        r17.setVisibility(0);
        goto L26
    L24:
        r17.setImageUrl(null);
        goto L25
    L17:
        r16.setText(r12.getDevInfo());
        r16.setVisibility(0);
        goto L19
    L13:
        r15.setText(r12.getDevName());
        r15.setVisibility(0);
        goto L15
    }

    public final TransitionDrawable P(int r10) {
        Bitmap r11 = BitmapFactory.decodeResource(getResources(), r10);
        return new TransitionDrawable(new Drawable[]{new ColorDrawable(getResources().getColor(android.R.color.transparent)), new BitmapDrawable(getResources(), r11)});
    }

    public void P0(ListView r10, View r11, boolean r12, String r13) {
        if (r12 == false) goto L8;
        if (r10.getFooterViewsCount() <= 0) goto L6;
        r10.removeFooterView(r11);
    L6:
        r11.setVisibility(8);
        return;
    L8:
        if (TextUtils.isEmpty(r13) == false) goto L10;
        r10.removeFooterView(r11);
        return;
    L10:
        if (r10.getFooterViewsCount() != 1) goto L12;
        r10.addFooterView(r11);
    L12:
        r11.setVisibility(0);
        l0((NetworkImageView) r11.findViewById(R.id.topic_banner), r13);
        B0(r11, "  " + getString(R.string.topic_history));
    }

    public void Q(String r10, Object r11) {
        if (r11 != null) goto L4;
    L22:
        com.bytedanceos.common.toolbox.j.a("params error");
        return;
    L4:
        if ((r11 instanceof GiftPackInfo) == false) goto L22;
        GiftPackInfo r12 = (GiftPackInfo) r11;
        AppInfo r13 = c9.a.p(r10, getActivity(), r12.mId);
        if (r13 != null) goto L11;
        e0.g(getString(R.string.gift_over));
        return;
    L11:
        if (com.bytedanceos.appstore.utils.a.q(this) == false) goto L20;
        ConfirmDialog.newInstance(21, true, r13).show(getActivity().getFragmentManager(), "GET_GIFT_SUCCESS");
        r12.mCount--;
        r12.isReceived = true;
        r12.mGiftPackCode = r13.mGiftPackCode;
        r12.fileMd5 = r13.fileMd5;
        if (this.f9446c != 12) goto L15;
    L15:
        ViewGroup r14 = this.F.w();
        if (r14 == null) goto L20;
        ListView r15 = (ListView) r14.findViewById(R.id.game_gift_pack_content);
        if (r15 == null) goto L20;
        ((GameGiftAdapter) r15.getAdapter()).addGiftPack(r12);
    L20:
        d9.a.e().i("0038", com.bytedanceos.appstore.datacache.a.N0().b0(r13.appPackageName));
    }

    public void Q0(ListView r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.getAdapter() != null) goto L7;
        return;
    L7:
        if ((r10.getAdapter() instanceof HeaderViewListAdapter) == false) goto L9;
        AppListAdapter r11 = (AppListAdapter) ((HeaderViewListAdapter) r10.getAdapter()).getWrappedAdapter();
    L10:
        if (r11 == null) goto L14;
        r11.onUpdate();
        return;
    L14:
        return;
    L9:
        r11 = (AppListAdapter) r10.getAdapter();
        goto L10
    }

    public final void R(String r10) {
        e0.e(R.string.add_comment_success);
        int r11 = this.f9446c;
        if (r11 != 6) goto L9;
        ViewGroup r12 = this.f9450g;
        if (r12 == null) goto L7;
        r12.setTag(R.id.app_comments_page, 1);
    L7:
        CommonAPIHelper.q(this.f9445b, this.mAddCommentDialog.getPackageName(), 1, this);
    L16:
        if (this.mAddCommentDialog.isShowing() == false) goto L19;
        this.mAddCommentDialog.dismiss();
        return;
    L19:
        return;
    L9:
        if (r11 != 3) goto L11;
    L14:
        CommonAPIHelper.t(this.f9445b, this.mAddCommentDialog.getPackageName(), c0.b("20"), 1, this);
        goto L16
    L11:
        if (r11 == 5) goto L14;
        if (r11 != 4) goto L16;
        goto L14
    }

    public final void R0(String r10, String r11) {
        if (this.f9446c == 9) goto L6;
        return;
    L6:
        if (this.f9455l != null) goto L8;
        this.f9455l = J(R.layout.topic_header_banner, R.drawable.topic_banner_default);
    L8:
        this.f9453j.removeHeaderView(this.f9454k);
        this.f9453j.removeHeaderView(this.f9455l);
        this.f9453j.addHeaderView(this.f9455l);
        r0(this.f9453j, this.f9455l, null, r10, r11);
    }

    public final void S(AppStoreCommonError r10, String r11) {
        if (this.mAddCommentDialog.isShowing() == false) goto L6;
        this.mAddCommentDialog.resetCommitState(false);
        return;
    }

    public void S0() {
    }

    public final void T(String r10) {
        y0(null);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public void T0() {
        int r10 = this.f9446c;
        if (r10 != 0) goto L5;
        S0();
        return;
    L5:
        if (r10 == 2) goto L10;
        switch(r10) {
            case 8: goto L10;
            case 9: goto L9;
            case 10: goto L10;
            default: goto L7;
        };
    L7:
        switch(r10) {
            case 14: goto L10;
            case 15: goto L10;
            case 16: goto L10;
            default: goto L15;
        };
    L15:
        return;
    L9:
        Q0(this.f9453j);
        return;
    L10:
        N0();
    }

    public final void U(AppStoreCommonError r10) {
        h0();
        if (this.f9446c == 6) goto L5;
        return;
    L5:
        if (AppCommentsView.getPage(this.f9450g) == 1) goto L7;
        this.f9464u = true;
        return;
    L7:
        if (this.f9450g.getVisibility() != 0) goto L9;
        this.f9450g.setVisibility(8);
    L9:
        com.bytedanceos.common.toolbox.j.a("showRefreshView: " + getCurrentTag() + ": handleMsgGetAppCommentsFailed: mState" + this.f9446c);
        showRefreshView();
    }

    public final void U0(AppInfo r10) {
        AppInfo r11 = com.bytedanceos.appstore.datacache.a.N0().t(r10.appPackageName);
        if (r11 == null) goto L8;
        long r12 = r11.pauseCode;
        if (r12 != 3) goto L7;
    L9:
        e0.e(R.string.wifi_auto_download);
        return;
    L7:
        if (r12 == 2) goto L9;
    L8:
        com.bytedanceos.appstore.datacache.a.N0().h(r10);
        T0();
        goto L9
    }

    public final void V(String r10, Object r11) {
        h0();
        AppComments r12 = com.bytedanceos.appstore.utils.b.k(r10);
        if (this.f9446c == 6) goto L5;
        return;
    L5:
        if (Integer.parseInt(String.valueOf(r11)) == AppCommentsView.getPage(this.f9450g)) goto L8;
        return;
    L8:
        if (isStateViewVisible() == false) goto L11;
        hideStateView();
    L11:
        if (this.f9450g.getVisibility() == 0) goto L13;
        this.f9450g.setVisibility(0);
    L13:
        AppCommentsView.updateAppCommentsView(this.f9450g, r12);
        this.f9464u = true;
    }

    public final void W(String r10, boolean r11, Object r12) {
        h0();
        int r13 = this.f9446c;
        if (r13 == 3) goto L7;
        if (r13 == 4) goto L7;
        if (r13 == 5) goto L7;
        return;
    L7:
        com.bytedanceos.appstore.ui.fragment.a r14 = this.F;
        if (r14 == null) goto L10;
        this.f9447d = r14.j();
        this.f9449f = this.F.m();
        this.f9460q = this.F.l();
        this.f9459p = this.F.q();
        this.f9466w = this.F.t();
        this.f9467x = this.F.o();
        this.f9468y = this.F.u();
    L10:
        String r15 = String.valueOf(r12);
        com.bytedanceos.common.toolbox.j.a("handleMsgGetAppInfo   mState " + this.f9446c + "   mNormalAppPkgName = " + this.f9457n + "  mDevAppPkgName = " + this.f9462s + "cookie:" + r15);
        int r16 = this.f9446c;
        if (r16 == 3) goto L19;
        if (r16 == 4) goto L19;
        if (r16 != 5) goto L22;
        if (TextUtils.equals(this.f9462s, r15) == true) goto L22;
        return;
    L22:
        if (this.f9446c != 5) goto L24;
        ViewGroup r17 = this.f9449f;
    L25:
        if (r17 != null) goto L28;
        com.bytedanceos.common.toolbox.j.a("appinfoview is null.");
        return;
    L28:
        AppInfo r18 = c9.a.o(r10, BaseApplication.c());
        if (r18 != null) goto L35;
        if (r11 == false) goto L32;
        J0();
    L33:
        r17.setVisibility(8);
        com.bytedanceos.common.toolbox.j.a("showRefreshView: " + getCurrentTag() + ": handleMsgGetAppInfo: mState: " + this.f9446c);
        return;
    L32:
        showRefreshView();
        goto L33
    L35:
        if (this.f9446c != 5) goto L37;
        r18.mApiUrl = this.f9460q;
        r18.mPageTitle = this.f9467x;
    L38:
        r18.mSourcePkgName = this.f9468y;
        hideStateView();
        AppInfo r19 = com.bytedanceos.appstore.datacache.a.N0().D(r18.appPackageName);
        if (r19 != null) goto L41;
    L43:
        com.bytedanceos.appstore.ui.fragment.a r20 = this.F;
        if (r20 != null) goto L63;
    L48:
        Object r21 = r17.getTag(R.id.report_params_sstj);
        if (r21 != null) goto L51;
    L53:
        Object r22 = r17.getTag(R.id.report_params_ads);
        if (r22 != null) goto L56;
    L58:
        r17.setVisibility(0);
        com.bytedanceos.appstore.ui.fragment.b.g(r17, r18);
        if (TextUtils.equals(r18.appSource, "local") == false) goto L61;
        com.bytedanceos.appstore.datacache.a.N0().V0(r18);
    L61:
        n0(1, r18);
        return;
    L56:
        if ((r22 instanceof String) == false) goto L58;
        r18.mJsonData = (String) r22;
        goto L58
    L51:
        if ((r21 instanceof String) == false) goto L53;
        r18.mSSTJ = (String) r21;
        goto L53
    L63:
        r18.mNumber = c0.b(r20.v());     // Catch: NumberFormatException -> L47
    L47:
        r18.mLocation = this.F.v();
        goto L48
    L41:
        if (r18.appVersionCode <= r19.appVersionCode) goto L43;
        com.bytedanceos.appstore.datacache.a.N0().g(r18, r19);
        goto L43
    L37:
        r18.mApiUrl = this.f9459p;
        r18.mPageTitle = this.f9466w;
        goto L38
    L24:
        r17 = this.f9447d;
    L19:
        if (TextUtils.equals(this.f9457n, r15) == true) goto L22;
    }

    public final void X(String r10) {
        AppComments r11 = c9.a.v(r10);
        if (this.f9446c == 6) goto L5;
        return;
    L5:
        if (isStateViewVisible() == false) goto L8;
        hideStateView();
    L8:
        if (this.f9450g.getVisibility() == 0) goto L10;
        this.f9450g.setVisibility(0);
    L10:
        AppCommentsView.updateAppCommentsView(this.f9450g, r11);
        this.f9464u = true;
    }

    public final void Y(String r10) {
        if (this.f9446c != 5) goto L5;
        ViewGroup r11 = this.f9449f;
    L6:
        if (r11 != null) goto L8;
        return;
    L8:
        h0();
        CommentInfo r12 = c9.a.j(r10);
        D0(r12.content, String.valueOf(r12.score));
        return;
    L5:
        r11 = this.f9447d;
        goto L6
    }

    public final void Z(AppStoreCommonError r10, String r11) {
        if (this.f9446c != 5) goto L5;
        ViewGroup r12 = this.f9449f;
    L6:
        if (r12 != null) goto L8;
        return;
    L8:
        h0();
        D0("", "");
        return;
    L5:
        r12 = this.f9447d;
        goto L6
    }

    public final void a0(String r10) {
        if (this.f9446c != 5) goto L5;
        ViewGroup r11 = this.f9449f;
    L6:
        if (r11 != null) goto L13;
        return;
    L13:
        r11.findViewById(R.id.addComment).callOnClick();     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        return;
    L5:
        r11 = this.f9447d;
        goto L6
    }

    public final void b0(String r10, Object r11) {
        f0(r10, null, r11);
    }

    public final void c0(AppStoreCommonError r10, String r11, Object r12) {
        f0(r11, r10, r12);
    }

    public final void d0(AppStoreCommonError r10, String r11, Object r12) {
        g0(r11, r10, r12);
    }

    public final void e0(String r10, Object r11) {
        g0(r10, null, r11);
    }

    public final void f0(String r11, AppStoreCommonError r12, Object r13) {
        if (r13 != null) goto L5;
        return;
    L5:
        if ((r13 instanceof View) == false) goto L51;
        View r14 = (View) r13;
        JSONObject r10 = new JSONObject(r11);     // Catch: Throwable -> L28 Exception -> L30
        if (r10.isNull(ServerElements.BODY) == false) goto L10;
    L41:
        update(null, null);
        return;
    L10:
        if (r10.getJSONObject(ServerElements.BODY).length() != 0) goto L16;
        TransitionDrawable r15 = P(R.drawable.comment_support);
        ((ImageView) r14.findViewById(R.id.comment_item_support_icon)).setImageDrawable(r15);
        r15.startTransition(50);
        CommentInfo r16 = (CommentInfo) r14.getTag(R.id.support_comment_info);
        if (r16 == null) goto L14;
        r16.isSupporting = false;
        r16.isLike = false;
    L14:
        update(null, null);
        return;
    L16:
        int r17 = r10.getJSONObject(ServerElements.BODY).optInt("app_id", 0);     // Catch: Throwable -> L28 Exception -> L30
        int r18 = r10.getJSONObject(ServerElements.BODY).optInt("comment_id", 0);     // Catch: Throwable -> L28 Exception -> L30
        TextView r19 = (TextView) r14.findViewById(R.id.comment_item_support_times);     // Catch: Throwable -> L28 Exception -> L30
        CommentInfo r20 = (CommentInfo) r14.getTag(R.id.support_comment_info);     // Catch: Throwable -> L28 Exception -> L30
        r20.isSupporting = false;     // Catch: Throwable -> L28 Exception -> L30
        if (r20.app_id == r17) goto L19;
    L39:
        update(null, null);
        return;
    L19:
        if (r20.comment_id != r18) goto L39;
        if (r12 == null) goto L33;
        if (r12.getErrorCode() == 1008005) goto L33;
        TransitionDrawable r110 = P(R.drawable.comment_support);
        ((ImageView) r14.findViewById(R.id.comment_item_support_icon)).setImageDrawable(r110);
        r110.startTransition(50);
        CommentInfo r111 = (CommentInfo) r14.getTag(R.id.support_comment_info);
        if (r111 == null) goto L41;
    L27:
        r111.isSupporting = false;
        r111.isLike = false;
    L33:
        r20.isLike = true;     // Catch: Throwable -> L28 Exception -> L30
        r20.commentSupportTimes++;     // Catch: Throwable -> L28 Exception -> L30
        r19.setVisibility(0);     // Catch: Throwable -> L28 Exception -> L30
        int r112 = r20.commentSupportTimes;     // Catch: Throwable -> L28 Exception -> L30
        if (r112 <= 9999) goto L36;
        String r113 = "9999+";
    L37:
        r19.setText(r113);     // Catch: Throwable -> L28 Exception -> L30
    L36:
        r113 = String.valueOf(r112);     // Catch: Throwable -> L28 Exception -> L30
    L28:
        th = move-exception;
        update(null, null);
        throw th;
    L30:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L28
        TransitionDrawable r114 = P(R.drawable.comment_support);
        ((ImageView) r14.findViewById(R.id.comment_item_support_icon)).setImageDrawable(r114);
        r114.startTransition(50);
        r111 = (CommentInfo) r14.getTag(R.id.support_comment_info);
        if (r111 == null) goto L41;
    }

    public final void g0(String r12, AppStoreCommonError r13, Object r14) {
        if (r14 != null) goto L5;
        return;
    L5:
        if ((r14 instanceof View) == false) goto L52;
        View r15 = (View) r14;
        JSONObject r10 = new JSONObject(r12);     // Catch: Throwable -> L28 Exception -> L30
        if (r10.isNull(ServerElements.BODY) == false) goto L10;
    L43:
        update(null, null);
        return;
    L10:
        if (r10.getJSONObject(ServerElements.BODY).length() != 0) goto L16;
        TransitionDrawable r16 = P(R.drawable.comment_support_done);
        ((ImageView) r15.findViewById(R.id.comment_item_support_icon)).setImageDrawable(r16);
        r16.startTransition(50);
        CommentInfo r17 = (CommentInfo) r15.getTag(R.id.support_comment_info);
        if (r17 == null) goto L14;
        r17.isSupporting = false;
        r17.isLike = true;
    L14:
        update(null, null);
        return;
    L16:
        int r18 = r10.getJSONObject(ServerElements.BODY).optInt("app_id", 0);     // Catch: Throwable -> L28 Exception -> L30
        int r11 = r10.getJSONObject(ServerElements.BODY).optInt("comment_id", 0);     // Catch: Throwable -> L28 Exception -> L30
        TextView r19 = (TextView) r15.findViewById(R.id.comment_item_support_times);     // Catch: Throwable -> L28 Exception -> L30
        CommentInfo r20 = (CommentInfo) r15.getTag(R.id.support_comment_info);     // Catch: Throwable -> L28 Exception -> L30
        r20.isSupporting = false;     // Catch: Throwable -> L28 Exception -> L30
        if (r20.app_id == r18) goto L19;
    L41:
        update(null, null);
        return;
    L19:
        if (r20.comment_id != r11) goto L41;
        if (r13 != null) goto L23;
    L32:
        r20.isLike = false;     // Catch: Throwable -> L28 Exception -> L30
        int r110 = r20.commentSupportTimes - 1;     // Catch: Throwable -> L28 Exception -> L30
        r20.commentSupportTimes = r110;     // Catch: Throwable -> L28 Exception -> L30
        if (r110 > 0) goto L35;
        r19.setVisibility(4);     // Catch: Throwable -> L28 Exception -> L30
        goto L43
    L35:
        r19.setVisibility(0);     // Catch: Throwable -> L28 Exception -> L30
        int r111 = r20.commentSupportTimes;     // Catch: Throwable -> L28 Exception -> L30
        if (r111 <= 9999) goto L38;
        String r112 = "9999+";
    L39:
        r19.setText(r112);     // Catch: Throwable -> L28 Exception -> L30
        goto L43
    L38:
        r112 = String.valueOf(r111);     // Catch: Throwable -> L28 Exception -> L30
        goto L39
    L23:
        if (r13.getErrorCode() == 1008007) goto L32;
        TransitionDrawable r113 = P(R.drawable.comment_support_done);
        ((ImageView) r15.findViewById(R.id.comment_item_support_icon)).setImageDrawable(r113);
        r113.startTransition(50);
        CommentInfo r114 = (CommentInfo) r15.getTag(R.id.support_comment_info);
        if (r114 == null) goto L43;
    L27:
        r114.isSupporting = false;
        r114.isLike = true;
    L28:
        th = move-exception;
        update(null, null);
        throw th;
    L30:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L28
        TransitionDrawable r115 = P(R.drawable.comment_support_done);
        ((ImageView) r15.findViewById(R.id.comment_item_support_icon)).setImageDrawable(r115);
        r115.startTransition(50);
        r114 = (CommentInfo) r15.getTag(R.id.support_comment_info);
        if (r114 == null) goto L43;
    }

    @Override // com.bytedanceos.common.ui.fragment.BasicFragment
    public abstract String getCurrentTag();

    @Override // com.bytedanceos.common.ui.fragment.BasicFragment
    public String getPageSource() {
        return this.H;
    }

    @Override // com.bytedanceos.common.ui.fragment.BasicFragment
    public String getSourcePageName() {
        FragmentActivity r10 = getActivity();
        if (r10 != null) goto L5;
        return "";
    L5:
        int r11 = this.f9446c;
        if (r11 != 3) goto L8;
    L13:
        int r12 = R.id.left_action_back;
    L14:
        TextView r13 = (TextView) r10.findViewById(r12);
        if (r13 != null) goto L17;
    L20:
        return "";
    L17:
        if (r13.getText() == null) goto L20;
        return r13.getText().toString();
    L8:
        if (r11 == 4) goto L13;
        if (r11 == 5) goto L13;
        r12 = R.id.toolbar_title;
        goto L14
    }

    @Override // com.bytedanceos.common.ui.fragment.BasicFragment
    public int getState() {
        return this.f9446c;
    }

    @Override // com.bytedanceos.common.ui.fragment.BasicFragment
    public ViewGroup getStateVisibleView(ViewGroup r10) {
        if (r10 == null) goto L7;
        if (r10.getVisibility() != 0) goto L7;
        return r10;
    L7:
        return this.mStateView;
    }

    public void h0() {
        Handler r10 = this.D;
        if (r10 == null) goto L6;
        r10.removeCallbacksAndMessages(null);
        return;
    }

    @Override // com.bytedanceos.common.ui.fragment.BasicFragment
    public void hideStateView() {
        if (isStateViewVisible() == false) goto L6;
        this.mStateView.setVisibility(8);
        return;
    }

    public boolean i(Object r10) {
        return true;
    }

    public boolean i0(int r10, Throwable r11, String r12, AppStoreCommonError r13) {
        if (r10 != 1100001) goto L7;
        com.bytedanceos.common.toolbox.e.g1(this.f9469z);
        return true;
    L7:
        if (r10 == 1100000) goto L9;
        boolean r14 = true;
    L10:
        int r15 = r13.getErrorCode();
        if (r15 != 800) goto L15;
        H0();
        return true;
    L15:
        if (r15 == 1000004) goto L27;
        if (r15 == 1601) goto L27;
        if (r15 == 1602) goto L27;
        if (r15 != 1106) goto L38;
        this.A.e();
        if (com.bytedanceos.appstore.utils.a.q(this) == false) goto L38;
        showNoLoginAlertDialog(R.string.ERROR_TICKET_INVALID);
    L38:
        if (TextUtils.isEmpty(r13.getErrorMsg()) == true) goto L43;
        if (r14 == false) goto L43;
        if (isVisible() == false) goto L43;
        e0.g(r13.getErrorMsg());
    L43:
        return false;
    L27:
        if (com.bytedanceos.appstore.utils.a.q(this) == false) goto L35;
        h0();
        ((MainActivity) getActivity()).y();
        AddCommentDialog r16 = this.mAddCommentDialog;
        if (r16 != null) goto L31;
    L33:
        return true;
    L31:
        if (r16.isShowing() == false) goto L33;
        this.mAddCommentDialog.dismiss();
        goto L33
    L35:
        if (isVisible() == false) goto L38;
        e0.g(r13.getErrorMsg());
        goto L38
    L9:
        r14 = false;
        goto L10
    }

    @Override // com.bytedanceos.common.ui.fragment.BasicFragment
    public boolean isStateViewVisible() {
        ViewGroup r10 = this.mStateView;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.getVisibility() != 0) goto L7;
        return true;
    }

    public boolean j(Object r10) {
        if (getActivity() != null) goto L5;
    L12:
        return false;
    L5:
        if (this.f9465v == true) goto L12;
        if (i(r10) == true) goto L10;
        return false;
    L10:
        return true;
    }

    public boolean j0() {
        if (getActivity() != null) goto L5;
    L11:
        return false;
    L5:
        if (getActivity().isFinishing() == true) goto L11;
        if (getView() == null) goto L11;
        if (this.f9465v == true) goto L11;
        return true;
    }

    public void k0(AppInfo r10) {
        this.f9461r = r10.appName;
        this.f9462s = r10.appPackageName;
        this.f9460q = r10.mApiUrl;
        z0(5);
        this.f9449f = this.F.i(this, false);
        this.F.E(5);
        this.F.A(this.f9461r);
        this.F.z(r10.mApiUrl);
        this.F.B(r10.mPageTitle);
        v0(r10);
        showLoadingView();
        K0(this.f9453j, -1, r10, null);
    }

    public void l0(NetworkImageView r10, String r11) {
    }

    public final void m0(AppInfo r10, boolean r11) {
        if (com.bytedanceos.appstore.datacache.a.N0().Y(r10.appPackageName) == false) goto L5;
        com.bytedanceos.common.utils.j.c(BaseApplication.c(), r10, true);
    L13:
        if (r11 == false) goto L16;
        com.bytedanceos.appstore.datacache.a.N0().t0(r10);
        return;
    L16:
        return;
    L5:
        if (com.bytedanceos.appstore.utils.a.c(r10.appDownloadUrl) == true) goto L7;
        e0.e(R.string.download_error_url);
        goto L13
    L7:
        if (com.bytedanceos.appstore.datacache.a.N0().U(r10.appPackageName) == false) goto L9;
        r10.appState = 64;
    L10:
        com.bytedanceos.common.utils.j.a(getActivity(), r10, true);
        goto L13
    L9:
        r10.appState = 32;
        goto L10
    }

    public void n0(int r10, Object r11) {
    }

    public void o0(AppInfo r10) {
        int r11 = com.bytedanceos.common.toolbox.e.A();
        if (r11 != 0) goto L6;
        e0.e(R.string.retry_connection);
        return;
    L6:
        if (r11 != 2) goto L9;
        K(r10, false);
        return;
    L9:
        if (r11 == 1) goto L11;
        return;
    L11:
        if (com.bytedanceos.common.toolbox.e.G(0) == true) goto L13;
        long r12 = r10.appBytes;
        if (com.bytedanceos.appstore.datacache.a.N0().c0(r10.appPackageName) == true) goto L23;
    L25:
        View r13 = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_mobile_tip, null);
        CheckBox r14 = (CheckBox) r13.findViewById(R.id.check_record);
        AlertDialog r15 = new AlertDialog.Builder(new ContextThemeWrapper(getActivity(), R.style.AppStoreDialogTheme)).setTitle(R.string.alert_dataflow_title).setView(r13).setNegativeButton(R.string.alert_wifi_continue, new o(this, r14, r10)).setPositiveButton(R.string.alert_dataflow_continue, new n(this, r14, r10)).setOnCancelListener(new m(this)).create();
        this.E = r15;
        r15.show();
        return;
    L23:
        if (com.bytedanceos.appstore.datacache.a.N0().s(r10.appPackageName) != null) goto L25;
        new AppInfo();
        goto L25
    L13:
        if (com.bytedanceos.common.toolbox.e.G(1) == true) goto L15;
        m0(r10, true);
        return;
    L15:
        if (com.bytedanceos.appstore.datacache.a.N0().f9566h.f9576a.containsKey(r10.appPackageName) == false) goto L17;
        m0(r10, false);
        return;
    L17:
        U0(r10);
    }

    @Override // com.bytedanceos.common.ui.fragment.BasicFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r10) {
        super.onActivityCreated(r10);
        I();
        com.bytedanceos.appstore.datacache.a.N0().addObserver(this);
        this.A.addObserver(this);
        ParentView r11 = this.f9452i;
        if (r11 == null) goto L6;
        this.mStateView = StateView.getStateView(r11);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r10, int r11, Intent r12) {
        com.bytedanceos.common.toolbox.j.e("onActivityResult,resultCode: " + r11 + ",requestCode: " + r10);
        if (r10 != 100) goto L5;
        a0(null);
        return;
    L5:
        if (r10 != 200) goto L17;
        if (r12 == null) goto L9;
        String r13 = r12.getStringExtra(ServerElements.NICKNAME);
    L10:
        com.bytedanceos.common.toolbox.j.e("onActivityResult,nickName: " + r13);
        if (TextUtils.isEmpty(r13) == true) goto L16;
        this.B.s(r13);
        this.B.w(r13);
        a0(null);
        return;
    L16:
        return;
    L9:
        r13 = "";
        goto L10
    }

    @Override // com.bytedanceos.common.ui.fragment.BasicFragment
    public boolean onBackPressed(boolean... r10) {
        com.bytedanceos.appstore.ui.fragment.a r11 = this.F;
        if (r11 == null) goto L5;
        this.f9456m = r11.r();
        this.f9458o = this.F.s();
        this.f9461r = this.F.n();
    L5:
        int r12 = this.f9446c;
        if (r12 != 5) goto L8;
        F();
    L14:
        return false;
    L8:
        if (r12 != 13) goto L14;
        com.bytedanceos.appstore.ui.fragment.a r13 = this.F;
        if (r13 == null) goto L14;
        String r14 = r13.x(0);
        String r15 = this.F.x(1);
        ViewGroup r16 = this.F.w();
        int r17 = this.F.getState();
        G(this.f9451h, r16, r17, r14, r15, new int[]{R.id.left_action_back, R.id.toolbar_share});
        this.f9452i.removeView(this.f9451h);
        goto L14
    }

    @Override // com.bytedanceos.common.ui.fragment.BasicFragment
    public void onButtonClick(int r10, int r11, boolean r12, Bundle r13) {
        AppInfo r14 = (AppInfo) r13.getSerializable(CommonConfirmDialog.ARGS_DIALOG_APP);
        if (r10 != 21) goto L5;
        if (r11 == (-1)) goto L30;
        if (r11 != (-2)) goto L49;
        d9.a.e().i("0040", com.bytedanceos.appstore.datacache.a.N0().b0(r14.appPackageName));
        return;
    L49:
        return;
    L30:
        if (com.bytedanceos.appstore.datacache.a.N0().b0(r14.appPackageName) == false) goto L32;
        com.bytedanceos.common.toolbox.e.v1(getActivity(), r14);
        d9.a.e().i("0039", true);
        return;
    L32:
        o0(r14);
        e0.e(R.string.auto_download_toast);
        d9.a.e().i("0039", false);
        return;
    L5:
        if (r10 != 26) goto L7;
        if (r11 != (-1)) goto L24;
        ConfirmDialog r15 = this.C;
        if (r15 == null) goto L22;
        r15.dismiss();
    L22:
        if (getArguments() == null) goto L42;
        com.bytedanceos.common.toolbox.e.J0(getActivity(), null, getArguments().getBoolean(CommonConfirmDialog.ARGS_DIALOG_USE_OAUTH));
        return;
    L42:
        return;
    L24:
        if (r11 != (-2)) goto L44;
        ConfirmDialog r16 = this.C;
        if (r16 == null) goto L45;
        r16.dismiss();
        return;
    L45:
        return;
    L44:
        return;
    L7:
        if (r10 != 23) goto L9;
        if (r11 != (-1)) goto L15;
        new Handler().postDelayed(new h(this, r14), 100);
        return;
    L15:
        if (r11 != (-2)) goto L40;
        com.bytedanceos.common.toolbox.j.a("cancel use gift");
        return;
    L40:
        return;
    L9:
        if (r10 == 24) goto L11;
        com.bytedanceos.common.toolbox.j.a("dialogType:" + r10 + "  which:" + r11);
        return;
    L11:
        if (r11 != (-1)) goto L37;
        o0(r14);
        e0.e(R.string.auto_download_toast);
        return;
    }

    @Override // com.bytedanceos.common.ui.fragment.BasicFragment, android.view.View.OnClickListener
    public void onClick(View r10) {
    }

    @Override // com.bytedanceos.common.ui.fragment.BasicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        this.B = AccountDataCache.b();
        this.A = m8.a.i();
    }

    @Override // com.bytedanceos.common.ui.fragment.BasicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        this.f9465v = true;
        this.B = null;
        m8.a r10 = this.A;
        if (r10 == null) goto L5;
        r10.deleteObserver(this);
        this.A = null;
    L5:
        com.bytedanceos.appstore.datacache.a.N0().deleteObserver(this);
        Handler r11 = this.D;
        if (r11 == null) goto L8;
        r11.removeCallbacksAndMessages(null);
    L8:
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        com.bytedanceos.appstore.utils.a.d();
    }

    @Override // com.bytedanceos.common.network.FetchDataCallBack
    public void onFetchDataFailed(int r10, Throwable r11, String r12, Object r13) {
        if (j(r13) == true) goto L5;
        return;
    L5:
        getActivity().runOnUiThread(new f(this, r11, r12, r10, r13));
    }

    @Override // com.bytedanceos.common.network.FetchDataCallBack
    public void onFetchDataSuccess(int r10, int r11, String r12, Object r13, String r14) {
        if (j(r13) == true) goto L5;
        return;
    L5:
        getActivity().runOnUiThread(new e(this, r10, r12, r13, r14));
    }

    @Override // com.bytedanceos.common.ui.fragment.BasicFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean r10) {
        super.onHiddenChanged(r10);
        if (r10 == true) goto L6;
        T0();
        return;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView r10, View r11, int r12, long r13) {
    }

    @Override // com.bytedanceos.common.ui.fragment.BasicFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ViewPagerRecycledPool.getInstance().clear();
    }

    @Override // com.bytedanceos.common.ui.fragment.BasicFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        T0();
        w0();
    }

    public void p0(int r10, Object r11) {
        int r12 = this.f9446c;
        if (r12 != 3) goto L5;
    L6:
        if (r10 != 0) goto L8;
        CommonAPIHelper.I(this.f9445b, r11, this);
        return;
    L8:
        if (r10 != 1) goto L15;
        CommonAPIHelper.s(this.f9445b, r11, this);
        return;
    L15:
        return;
    L5:
        if (r12 == 4) goto L6;
    }

    public void q0(RefreshLoadListView r10, AppList r11) {
        if (r10 != null) goto L5;
        com.bytedanceos.common.toolbox.j.a("listView is null");
        return;
    L5:
        int r12 = AppListView.getPage(r10);
        if (r11 != null) goto L10;
        if (r12 != 1) goto L10;
        AppListView.setState(r10, 4);
        return;
    L10:
        if (r11 != null) goto L12;
    L16:
        AppListView.onLoad(r10);
        if (r11 != null) goto L19;
    L21:
        r10.setPullLoadEnable(false);
        com.bytedanceos.common.toolbox.j.a("appList is null:" + r11);
        return;
    L19:
        if (r11.isEmpty() == true) goto L21;
        AppListView.updateListView(r10, r11);
        return;
    L12:
        if (r11.isEmpty() == false) goto L16;
        if (r12 != 1) goto L16;
        AppListView.setState(r10, 3);
    }

    public void r0(RefreshLoadListView r10, View r11, View r12, String r13, String r14) {
        if (TextUtils.isEmpty(r13) == true) goto L34;
        AppList r15 = c9.a.r(r13, r14);
        if (r12 == null) goto L14;
        if (r15 == null) goto L14;
        if (r15.isEmpty() == true) goto L14;
        Topic r16 = com.bytedanceos.appstore.utils.b.f0(r13);
        boolean r17 = r15.hasMore();
        if (r16 != null) goto L12;
        String r18 = "";
    L13:
        P0(r10, r12, r17, r18);
        goto L14
    L12:
        r18 = r16.getImageResUrl();
    L14:
        Topic r19 = com.bytedanceos.appstore.utils.b.N(r13);
        if (AppListView.getPage(r10) != 1) goto L35;
        if (r19 != null) goto L18;
        r10.removeHeaderView(r11);
        goto L35
    L18:
        if (TextUtils.isEmpty(r19.getImageResUrl()) == false) goto L23;
        if (TextUtils.isEmpty(r19.getDescription()) == false) goto L23;
        r10.removeHeaderView(r11);
    L23:
        if (r10.getHeaderViewsCount() > 1) goto L25;
        r10.addHeaderView(r11);
    L25:
        NetworkImageView r20 = (NetworkImageView) r11.findViewById(R.id.topic_banner);
        if (TextUtils.isEmpty(r19.getImageResUrl()) == true) goto L28;
        r20.setVisibility(0);
        l0(r20, r19.getImageResUrl());
    L29:
        B0(r11, "  " + r19.getTitle());
        TextView r21 = (TextView) r11.findViewById(R.id.head_info);
        if (TextUtils.isEmpty(r19.getDescription()) == true) goto L32;
        r21.setText(r19.getDescription());
        r21.setVisibility(0);
        goto L35
    L32:
        r21.setVisibility(8);
        goto L35
    L28:
        r20.setVisibility(8);
    L35:
        q0(r10, r15);
        G0(r10, true);
        return;
    L34:
        r15 = null;
        goto L35
    }

    public void s0() {
        int r10 = this.f9446c;
        if (r10 != 0) goto L5;
        S0();
        return;
    L5:
        if (r10 != 2) goto L7;
    L32:
        N0();
        return;
    L7:
        if (r10 == 3) goto L29;
        if (r10 == 4) goto L29;
        if (r10 == 5) goto L25;
        if (r10 == 6) goto L21;
        if (r10 == 8) goto L32;
        if (r10 != 9) goto L40;
        Q0(this.f9453j);
        return;
    L40:
        return;
    L21:
        if (isVisible() == false) goto L23;
        I0(getString(R.string.add_comment_loading), true);
    L23:
        CommonAPIHelper.q(this.f9445b, this.f9450g.getTag(), AppCommentsView.getPage(this.f9450g), this);
        return;
    L25:
        if (isVisible() == false) goto L27;
        I0(getString(R.string.add_comment_loading), true);
    L27:
        CommonAPIHelper.s(this.f9445b, this.f9462s, this);
        return;
    L29:
        if (isVisible() == false) goto L31;
        I0(getString(R.string.add_comment_loading), true);
    L31:
        boolean r11 = this.f9463t;
        String r12 = this.f9457n;
        p0(r11 ? 1 : 0, r12);
    }

    @Override // com.bytedanceos.common.ui.fragment.BasicFragment
    public void showLoadingView() {
        StateView.showLoadingView(this.mStateView);
    }

    @Override // com.bytedanceos.common.ui.fragment.BasicFragment
    public void showLoginView() {
    }

    @Override // com.bytedanceos.common.ui.fragment.BasicFragment
    public void showNoLoginAlertDialog(int r10) {
        showNoLoginAlertDialog(r10, true);
    }

    @Override // com.bytedanceos.common.ui.fragment.BasicFragment
    public void showRefreshView() {
        StateView.showRefreshView(this.mStateView, this);
    }

    public void t0(int r10, String r11, String r12) {
    }

    public void u0(int r10, AppStoreCommonError r11) {
    }

    @Override // java.util.Observer
    public void update(Observable r10, Object r11) {
        if (j0() == true) goto L6;
        com.bytedanceos.common.toolbox.j.a("can not update." + N());
        return;
    L6:
        getActivity().runOnUiThread(new a(this, r11));
    }

    public void v0(AppInfo r10) {
        String r11 = M(r10);
        if (BaseApplication.f9540m == false) goto L5;
        String r12 = "1";
    L6:
        String r13 = D(r11, ServerElements.TEST, r12);
        d9.a.e().Q("9014", r13);
        return;
    L5:
        r12 = AdReportParam.ClickPosType.SKIP;
        goto L6
    }

    public final void w0() {
        if (this.f9446c != 3) goto L30;
        ViewGroup r10 = this.f9447d;
        if (r10 != null) goto L7;
        return;
    L7:
        if (r10.getTag() == null) goto L37;
        AppInfo r11 = (AppInfo) this.f9447d.getTag();
        ArrayList r12 = new ArrayList();
        String r13 = r11.mAppVideoImage;
        if (r13 != null) goto L11;
        r13 = "";
    L11:
        r12.add(r13);
        r12.addAll(r11.appScreenSnaps);
        int r14 = 0;
    L13:
        if (r14 >= r12.size()) goto L38;
        if (r14 == 0) goto L16;
    L18:
        int[] r15 = com.bytedanceos.appstore.ui.fragment.b.f9528a;
        if (r14 >= r15.length) goto L39;
        View r16 = this.f9447d.findViewById(r15[r14]);
        if (r16 == null) goto L23;
        NetworkImageView r17 = (NetworkImageView) r16;
        if (TextUtils.equals(r11.appSource, AppInfo.SEARCH_SOURCE_EXTENAL) == false) goto L27;
        String r18 = (String) r12.get(r14);
    L28:
        r17.setImageUrl(r18);
    L29:
        r14 = r14 + 1;
        goto L13
    L27:
        r18 = com.bytedanceos.common.toolbox.e.B((String) r12.get(r14), r17.getWidth());
        goto L28
    L23:
        return;
    L39:
        return;
    L16:
        if (TextUtils.isEmpty((CharSequence) r12.get(r14)) == false) goto L18;
    L38:
        return;
    L37:
        return;
    }

    public void x0(int r10) {
        this.f9444a = r10;
    }

    public final void y0(String r10) {
        Intent r11 = new Intent(getActivity(), ConfirmLoginInfoActivity.class);
        r11.putExtra("type", 2);
        startActivity(r11);
        startActivityForResult(r11, 100);
        getActivity().overridePendingTransition(R.anim.pop_up_in, R.anim.fake_anim);
    }

    public void z0(int r10) {
        A0(r10, false);
    }

    @Override // com.bytedanceos.common.ui.fragment.BasicFragment
    public void showNoLoginAlertDialog(int r10, boolean r11) {
        ConfirmDialog r12 = this.C;
        if (r12 == null) goto L5;
        r12.dismiss();
        this.C = null;
    L5:
        ConfirmDialog r13 = ConfirmDialog.newInstance(26, true, null, r11, getString(r10));
        this.C = r13;
        r13.show(getActivity().getFragmentManager(), "NO_LOGIN_DIALOG");
    }
}
