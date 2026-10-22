package com.bytedanceos.appstore.buss;

import android.content.Intent;
import android.content.res.Configuration;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.m0;
import com.bytedanceos.appstore.buss.base.BaseActivity;
import com.bytedanceos.appstore.buss.beta.adapter.BetaTvMainNavAdapter;
import com.bytedanceos.appstore.buss.beta.entity.BetaNavEntityWrap;
import com.bytedanceos.appstore.buss.beta.entity.BetaNavTitleEntity;
import com.bytedanceos.appstore.buss.beta.fragment.container.ContainerJumpFragment;
import com.bytedanceos.appstore.buss.beta.fragment.container.ContainerPrimaryFragment;
import com.bytedanceos.appstore.buss.beta.fragment.container.ContainerSearchFragment;
import com.bytedanceos.appstore.buss.viewmodels.MainViewModel;
import com.bytedanceos.appstore.buss.viewmodels.cache.CacheMyAppsRepository;
import com.bytedanceos.appstore.utils.d;
import com.bytedanceos.common.eventbus.AddUpdateEvent;
import com.bytedanceos.common.eventbus.LoginEvent;
import com.bytedanceos.common.toolbox.cache.AccountDataCache;
import com.bytedanceos.common.toolbox.g0;
import com.obric.appstore.R;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.tmall.wireless.tangram.eventbus.BusSupport;
import f9.b;
import h7.c;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.u;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 j2\u00020\u00012\u00020\u0002:\u0001kB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJA\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0018\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001a\u0010\u0004J\u0017\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001c\u0010\u0016J\u0017\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001dH\u0007¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0007H\u0014¢\u0006\u0004\b%\u0010\u0004J\u000f\u0010&\u001a\u00020\u0007H\u0014¢\u0006\u0004\b&\u0010\u0004J\u000f\u0010'\u001a\u00020\u0007H\u0014¢\u0006\u0004\b'\u0010\u0004J\u000f\u0010(\u001a\u00020\u0007H\u0014¢\u0006\u0004\b(\u0010\u0004J\r\u0010)\u001a\u00020\u0007¢\u0006\u0004\b)\u0010\u0004J\r\u0010*\u001a\u00020\u0007¢\u0006\u0004\b*\u0010\u0004J\u0017\u0010,\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020+H\u0007¢\u0006\u0004\b,\u0010-J\u0017\u0010/\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020.H\u0007¢\u0006\u0004\b/\u00100J\u0017\u00102\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u000201H\u0007¢\u0006\u0004\b2\u00103J\u0017\u00104\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b4\u0010\tJ\u0019\u00107\u001a\u00020\u00072\b\u00106\u001a\u0004\u0018\u000105H\u0016¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\u0007H\u0014¢\u0006\u0004\b9\u0010\u0004R\u001b\u0010?\u001a\u00020:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u0018\u0010C\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR'\u0010K\u001a\u0012\u0012\u0004\u0012\u00020E0Dj\b\u0012\u0004\u0012\u00020E`F8\u0006¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010JR3\u0010S\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020M0Lj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020M`N8\u0006¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR3\u0010W\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020T0Lj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020T`N8\u0006¢\u0006\f\n\u0004\bU\u0010P\u001a\u0004\bV\u0010RR\u0018\u0010Z\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR$\u0010b\u001a\u0004\u0018\u00010[8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR$\u0010f\u001a\u0004\u0018\u00010[8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bc\u0010]\u001a\u0004\bd\u0010_\"\u0004\be\u0010aR\u0014\u0010i\u001a\u00020\n8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\bg\u0010h¨\u0006l"}, d2 = {"Lcom/bytedanceos/appstore/buss/AppStoreActivity;", "Lcom/bytedanceos/appstore/buss/base/BaseActivity;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "Landroid/content/Intent;", MemorySourceLinkType.INTENT, "", "O", "(Landroid/content/Intent;)V", "", "type", "", "str", "autoDownload", "", "updateAll", "pageSource", "S", "(ILjava/lang/String;IZLjava/lang/String;)V", "flip", "Q", "(Z)V", "resultSearchText", "U", "(Ljava/lang/String;)V", "V", "visible", "P", "Lcom/bytedanceos/common/eventbus/LoginEvent;", "event", "onEvent", "(Lcom/bytedanceos/common/eventbus/LoginEvent;)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "J", "initView", "initData", "I", "K", "N", "Lc7/b;", "onSearchEvent", "(Lc7/b;)V", "Lcom/bytedanceos/common/eventbus/AddUpdateEvent;", "updateAppsEvent", "(Lcom/bytedanceos/common/eventbus/AddUpdateEvent;)V", "Lp7/a;", "onSearchResultEvent", "(Lp7/a;)V", "onNewIntent", "Landroid/view/View;", "v", BusSupport.EVENT_ON_CLICK, "(Landroid/view/View;)V", "onDestroy", "Lcom/bytedanceos/appstore/buss/viewmodels/MainViewModel;", "c", "Lkotlin/Lazy;", "getMainViewModel", "()Lcom/bytedanceos/appstore/buss/viewmodels/MainViewModel;", "mainViewModel", "Lcom/bytedanceos/appstore/buss/beta/adapter/BetaTvMainNavAdapter;", "d", "Lcom/bytedanceos/appstore/buss/beta/adapter/BetaTvMainNavAdapter;", "navAdapter", "Ljava/util/ArrayList;", "Lcom/bytedanceos/appstore/buss/entity/SearchBannerEntity;", "Lkotlin/collections/ArrayList;", "e", "Ljava/util/ArrayList;", "getUninstallList", "()Ljava/util/ArrayList;", "uninstallList", "Ljava/util/HashMap;", "Lcom/bytedanceos/appstore/buss/beta/entity/BetaNavEntityWrap;", "Lkotlin/collections/HashMap;", "f", "Ljava/util/HashMap;", "getNavHeadMap", "()Ljava/util/HashMap;", "navHeadMap", "Lcom/bytedanceos/appstore/buss/beta/entity/BetaNavTitleEntity;", "g", "M", "navTitleMap", "h", "Lcom/bytedanceos/appstore/buss/beta/entity/BetaNavTitleEntity;", "currentNavEntity", "Landroidx/fragment/app/Fragment;", "i", "Landroidx/fragment/app/Fragment;", "L", "()Landroidx/fragment/app/Fragment;", "setCurrentFragment", "(Landroidx/fragment/app/Fragment;)V", "currentFragment", "j", "getTopFragment", "R", "topFragment", "H", "()I", "layoutId", "k", "a", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAppStoreActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppStoreActivity.kt\ncom/bytedanceos/appstore/buss/AppStoreActivity\n+ 2 ActivityViewModelLazy.kt\nandroidx/activity/ActivityViewModelLazyKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,537:1\n75#2,13:538\n1#3:551\n*S KotlinDebug\n*F\n+ 1 AppStoreActivity.kt\ncom/bytedanceos/appstore/buss/AppStoreActivity\n*L\n82#1:538,13\n*E\n"})
public final class AppStoreActivity extends BaseActivity implements View.OnClickListener {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f8289k = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f8290c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BetaTvMainNavAdapter f8291d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList f8292e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap f8293f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashMap f8294g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public BetaNavTitleEntity f8295h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Fragment f8296i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Fragment f8297j;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f8289k = new a(null);
    }

    public AppStoreActivity() {
        Function0<ViewModelProvider.Factory> r10 = new AppStoreActivity$special$$inlined$viewModels$default$1(this);
        final Function0 r11 = null;
        this.f8290c = new m0(u.b(MainViewModel.class), new AppStoreActivity$special$$inlined$viewModels$default$2(this), r10, new AppStoreActivity$special$$inlined$viewModels$default$3(r11, this));
        this.f8292e = new ArrayList();
        this.f8293f = new HashMap();
        this.f8294g = new HashMap();
    }

    public static /* synthetic */ void T(AppStoreActivity r10, int r11, String r12, int r13, boolean r14, String r15, int r16, Object r17) {
        if ((r16 & 2) == 0) goto L5;
        String r18 = "";
    L7:
        if ((r16 & 4) == 0) goto L9;
        int r19 = 0;
    L11:
        if ((r16 & 8) == 0) goto L13;
        boolean r20 = false;
    L15:
        if ((r16 & 16) == 0) goto L17;
        String r21 = "";
    L18:
        r10.S(r11, r18, r19, r20, r21);
        return;
    L17:
        r21 = r15;
        goto L18
    L13:
        r20 = r14;
        goto L15
    L9:
        r19 = r13;
        goto L11
    L5:
        r18 = r12;
        goto L7
    }

    @Override // com.bytedanceos.appstore.buss.base.BaseActivity
    public int H() {
        return R.layout.activity_tv_main;
    }

    @Override // com.bytedanceos.appstore.buss.base.BaseActivity
    public void I() {
    }

    @Override // com.bytedanceos.appstore.buss.base.BaseActivity
    public void J() {
    }

    public final void K() {
        b.b("click_search_cancel", null);
        P(false);
        Q(true);
        T(this, 3, null, 0, false, null, 30, null);
    }

    public final Fragment L() {
        return this.f8296i;
    }

    public final HashMap M() {
        return this.f8294g;
    }

    public final void N() {
    }

    public final void O(Intent r10) {
    }

    public final void P(boolean r10) {
    }

    public final void Q(boolean r10) {
    }

    public final void R(Fragment r10) {
        this.f8297j = r10;
    }

    public final void S(int r10, String r11, int r12, boolean r13, String r14) {
        FragmentTransaction r15 = getSupportFragmentManager().o();
        q.f(r15, "beginTransaction(...)");
        Fragment r16 = getSupportFragmentManager().i0("viewPager");
        Fragment r17 = getSupportFragmentManager().i0("jump");
        Fragment r18 = getSupportFragmentManager().i0("search");
        switch(r10) {
            case 1: goto L65;
            case 2: goto L52;
            case 3: goto L35;
            case 4: goto L5;
            case 5: goto L5;
            case 6: goto L5;
            default: goto L91;
        };
    L5:
        if (r18 == null) goto L7;
        r15.t(r18);
    L7:
        if (r16 == null) goto L9;
        r15.r(r16);
    L9:
        if (r17 == null) goto L12;
        r15.t(r17);
    L12:
        if (r10 != 4) goto L14;
        Fragment r19 = ContainerJumpFragment.f8409g.c(r11);
    L30:
        this.f8296i = r19;
        this.f8297j = null;
        q.d(r19);
        r15.b(R.id.fl_container, r19, "jump");
        r15.j();     // Catch: IllegalStateException -> L33
        return;
    L33:
        e = move-exception;
        e.printStackTrace();
        return;
    L14:
        if (r10 == 5) goto L16;
        r19 = ContainerJumpFragment.f8409g.b(true, r13);
        goto L30
    L16:
        BetaTvMainNavAdapter r110 = this.f8291d;
        if (r110 == null) goto L19;
        int r111 = r110.getItemPosition(this.f8295h);
    L20:
        BetaNavTitleEntity r20 = this.f8295h;
        if (r20 == null) goto L24;
        r20.setSelected(false);
    L24:
        if (r111 == (-1)) goto L28;
        BetaTvMainNavAdapter r112 = this.f8291d;
        if (r112 == null) goto L28;
        r112.notifyItemChanged(r111);
    L28:
        r19 = ContainerJumpFragment.f8409g.a(r11, r12, r14);
        goto L30
    L19:
        r111 = -1;
        goto L20
    L35:
        if (r17 != null) goto L38;
        if (r16 != null) goto L38;
        finish();
        return;
    L38:
        if (r18 == null) goto L40;
        r15.t(r18);
    L40:
        if (r17 == null) goto L44;
        this.f8296i = r17;
        q.d(r17);
        r15.A(r17);
        if (r16 == null) goto L46;
        r15.r(r16);
    L46:
        this.f8297j = null;
        r15.j();     // Catch: IllegalStateException -> L49
        return;
    L49:
        e = move-exception;
        e.printStackTrace();
        return;
    L44:
        if (r16 == null) goto L46;
        this.f8296i = r16;
        q.d(r16);
        r15.A(r16);
        goto L46
    L65:
        if (r17 == null) goto L67;
        r15.t(r17);
    L67:
        if (r18 == null) goto L69;
        r15.t(r18);
    L69:
        if (r16 != null) goto L71;
        ContainerPrimaryFragment r113 = new ContainerPrimaryFragment();
        this.f8296i = r113;
        q.d(r113);
        r15.b(R.id.fl_container, r113, "viewPager");
    L72:
        this.f8297j = null;
        r15.j();     // Catch: IllegalStateException -> L75
        return;
    L75:
        e = move-exception;
        e.printStackTrace();
        return;
    L71:
        this.f8296i = r16;
        q.d(r16);
        r15.A(r16);
        goto L72
    L91:
        return;
    L52:
        if ((this.f8296i instanceof ContainerSearchFragment) == true) goto L89;
        if (r16 == null) goto L55;
        r15.r(r16);
    L55:
        if (r17 == null) goto L57;
        r15.r(r17);
    L57:
        if (r18 != null) goto L59;
        ContainerSearchFragment r114 = new ContainerSearchFragment();
        this.f8296i = r114;
        q.d(r114);
        r15.b(R.id.fl_container, r114, "search");
    L60:
        this.f8297j = null;
        r15.j();     // Catch: IllegalStateException -> L63
        return;
    L63:
        e = move-exception;
        e.printStackTrace();
        return;
    L59:
        this.f8296i = r18;
        q.d(r18);
        r15.A(r18);
        goto L60
    }

    public final void U(String r10) {
    }

    public final void V() {
        boolean r10 = g0.a().d();
        int r11 = com.bytedanceos.appstore.datacache.a.N0().v("UPDATE").size();
        if (r10 == false) goto L6;
        if (r11 <= 0) goto L6;
        boolean r12 = true;
    L7:
        BetaNavTitleEntity r13 = (BetaNavTitleEntity) this.f8294g.get(1036);
        if (r13 != null) goto L10;
        return;
    L10:
        r13.setCountNum(r11);
        r13.setShowCount(r12);
        BetaNavEntityWrap r14 = (BetaNavEntityWrap) this.f8293f.get(Integer.valueOf(r13.getGroup_id()));
        if (r14 == null) goto L14;
        r14.setCountNum(r11);
    L14:
        if (r14 == null) goto L17;
        r14.setShowCount(r12);
    L17:
        BetaTvMainNavAdapter r15 = this.f8291d;
        if (r15 == null) goto L24;
        int r16 = r15.getItemPosition(r14);
        if (r16 == (-1)) goto L24;
        BetaTvMainNavAdapter r17 = this.f8291d;
        if (r17 == null) goto L24;
        r17.notifyItemChanged(r16);
    L24:
        BetaTvMainNavAdapter r18 = this.f8291d;
        if (r18 == null) goto L32;
        int r19 = r18.getItemPosition(r13);
        if (r19 == (-1)) goto L33;
        BetaTvMainNavAdapter r20 = this.f8291d;
        if (r20 == null) goto L34;
        r20.notifyItemChanged(r19);
        return;
    L34:
        return;
    L33:
        return;
    L32:
        return;
    L6:
        r12 = false;
        goto L7
    }

    @Override // com.bytedanceos.appstore.buss.base.BaseActivity
    public void initData() {
        Intent r10 = new Intent();
        if (d.a() == false) goto L5;
        r10.setAction("com.bytedanceos.appstore.sync.update.apps");
    L6:
        sendBroadcast(r10);
        return;
    L5:
        r10.setAction("com.bytedanceos.gamestore.sync.update.apps");
        goto L6
    }

    @Override // com.bytedanceos.appstore.buss.base.BaseActivity
    public void initView() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View r10) {
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r10) {
        q.g(r10, "newConfig");
        super.onConfigurationChanged(r10);
        Fragment r11 = this.f8297j;
        if (r11 == null) goto L5;
        q.e(r11, "null cannot be cast to non-null type com.bytedanceos.appstore.buss.base.BaseFragment");
        ((c) r11).F();
        return;
    L5:
        Fragment r12 = this.f8296i;
        if (r12 == null) goto L10;
        q.e(r12, "null cannot be cast to non-null type com.bytedanceos.appstore.buss.base.BaseFragment");
        ((c) r12).F();
        return;
    }

    @Override // com.bytedanceos.appstore.buss.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        com.bytedanceos.appstore.buss.utilities.c.f8836a.a(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull LoginEvent r10) {
        q.g(r10, "event");
        CacheMyAppsRepository.a r11 = CacheMyAppsRepository.f8997f;
        r11.a().l();
        r11.a().n(true);
        if (AccountDataCache.b().n() == false) goto L5;
        EventBus.getDefault().post(new p7.c(true));
        return;
    L5:
        AccountDataCache.b().a();
        AccountDataCache.b().r(false);
        EventBus.getDefault().post(new p7.c(false));
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent r10) {
        q.g(r10, MemorySourceLinkType.INTENT);
        super.onNewIntent(r10);
        O(r10);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onSearchEvent(@NotNull c7.b r10) {
        q.g(r10, "event");
        U(r10.a());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onSearchResultEvent(@NotNull p7.a r10) {
        q.g(r10, "event");
        P(false);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void updateAppsEvent(@NotNull AddUpdateEvent r10) {
        q.g(r10, "event");
        V();
    }
}
