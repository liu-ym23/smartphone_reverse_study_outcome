package com.bytedanceos.appstore.buss.activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.m0;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedanceos.appstore.buss.base.BaseActivity;
import com.bytedanceos.appstore.buss.entity.AppPermissionEntity;
import com.bytedanceos.appstore.buss.network.h;
import com.bytedanceos.appstore.buss.utilities.ImageUtilKt;
import com.bytedanceos.appstore.buss.utilities.j;
import com.bytedanceos.appstore.buss.utilities.n;
import com.bytedanceos.appstore.buss.viewmodels.AppPermissionViewModel;
import com.bytedanceos.common.utils.CompatAppSecurityPermisions;
import com.obric.appstore.R;
import com.tmall.wireless.tangram.eventbus.BusSupport;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.u;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 32\u00020\u00012\u00020\u0002:\u00014B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\t\u0010\u0004J\u0019\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0017\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0019\u0010\u0016R\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001c\u0010\u0016R\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001b\u0010&\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0014\u001a\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0019\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010+8F¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0014\u00102\u001a\u00020/8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b0\u00101¨\u00065"}, d2 = {"Lcom/bytedanceos/appstore/buss/activity/AppPermissionActivity;", "Lcom/bytedanceos/appstore/buss/base/BaseActivity;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "", "J", "initView", "initData", "I", "Landroid/view/View;", "v", BusSupport.EVENT_ON_CLICK, "(Landroid/view/View;)V", "Lcom/bytedanceos/appstore/buss/entity/AppPermissionEntity;", "data", "T", "(Lcom/bytedanceos/appstore/buss/entity/AppPermissionEntity;)V", "", "c", "Lkotlin/Lazy;", "P", "()Ljava/lang/String;", "appPackageName", "d", "R", "versionCode", "e", "O", "appLogo", "Lcom/bytedanceos/appstore/buss/utilities/n;", "f", "Lcom/bytedanceos/appstore/buss/utilities/n;", "statusUtil", "Lcom/bytedanceos/appstore/buss/viewmodels/AppPermissionViewModel;", "g", "S", "()Lcom/bytedanceos/appstore/buss/viewmodels/AppPermissionViewModel;", "viewModel", "", "H", "()I", "layoutId", "Lkotlin/Function0;", "Q", "()Lkotlin/jvm/functions/Function0;", "onRetryListener", "Lx7/a;", "N", "()Lx7/a;", "activityTvAppPermissionBinding", "h", "a", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAppPermissionActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppPermissionActivity.kt\ncom/bytedanceos/appstore/buss/activity/AppPermissionActivity\n+ 2 ActivityViewModelLazy.kt\nandroidx/activity/ActivityViewModelLazyKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 NetSource.kt\ncom/bytedanceos/appstore/buss/network/NetSourceKt\n*L\n1#1,133:1\n75#2,13:134\n37#3,2:147\n50#4,9:149\n*S KotlinDebug\n*F\n+ 1 AppPermissionActivity.kt\ncom/bytedanceos/appstore/buss/activity/AppPermissionActivity\n*L\n46#1:134,13\n122#1:147,2\n67#1:149,9\n*E\n"})
public final class AppPermissionActivity extends BaseActivity implements View.OnClickListener {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f8309h = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f8310c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f8311d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f8312e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public n f8313f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f8314g;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final void a(Context r10, String r11, String r12, String r13) {
            q.g(r10, "context");
            q.g(r11, "appPackageName");
            q.g(r12, "appVersionCode");
            q.g(r13, "appLogo");
            Intent r14 = new Intent(r10, AppPermissionActivity.class);
            r14.putExtra("packageName", r11);
            r14.putExtra("versionCode", r12);
            r14.putExtra("appLogo", r13);
            r10.startActivity(r14);
        }

        public a() {
        }
    }

    static {
        f8309h = new a(null);
    }

    public AppPermissionActivity() {
        this.f8310c = kotlin.b.b(new AppPermissionActivity$appPackageName$2(this));
        this.f8311d = kotlin.b.b(new AppPermissionActivity$versionCode$2(this));
        this.f8312e = kotlin.b.b(new AppPermissionActivity$appLogo$2(this));
        Function0<ViewModelProvider.Factory> r10 = new AppPermissionActivity$viewModel$2(this);
        final Function0 r11 = null;
        this.f8314g = new m0(u.b(AppPermissionViewModel.class), new AppPermissionActivity$special$$inlined$viewModels$default$2(this), r10, new AppPermissionActivity$special$$inlined$viewModels$default$3(r11, this));
    }

    public static /* synthetic */ void K(AppPermissionActivity r10, h r11) {
        U(r10, r11);
    }

    public static final /* synthetic */ String L(AppPermissionActivity r10) {
        return r10.P();
    }

    public static final /* synthetic */ AppPermissionViewModel M(AppPermissionActivity r10) {
        return r10.S();
    }

    private final String P() {
        return (String) this.f8310c.getValue();
    }

    public static final void U(AppPermissionActivity r10, h r11) {
        q.g(r10, "this$0");
        q.d(r11);
        n r12 = null;
        if ((r11 instanceof h.b) == false) goto L10;
        n r13 = r10.f8313f;
        if (r13 != null) goto L7;
        q.y("statusUtil");
    L8:
        r12.f();
        return;
    L7:
        r12 = r13;
        goto L8
    L10:
        if ((r11 instanceof h.c) == false) goto L24;
        h.c r14 = (h.c) r11;
        if (r14.a() != null) goto L18;
        n r15 = r10.f8313f;
        if (r15 != null) goto L16;
        q.y("statusUtil");
        n r16 = null;
    L17:
        n.e(r16, null, null, 0, 7, null);
        return;
    L16:
        r16 = r15;
        goto L17
    L18:
        n r17 = r10.f8313f;
        if (r17 != null) goto L21;
        q.y("statusUtil");
    L22:
        r12.b();
        r10.T((AppPermissionEntity) r14.a());
        return;
    L21:
        r12 = r17;
        goto L22
    L24:
        if ((r11 instanceof h.a) == false) goto L34;
        h.a r18 = (h.a) r11;
        j.f8856a.c(r18.c());
        n r19 = r10.f8313f;
        if (r19 != null) goto L28;
        q.y("statusUtil");
        n r20 = null;
    L29:
        n.h(r20, 0, null, r18.toString(), null, 11, null);
        return;
    L28:
        r20 = r19;
        goto L29
    }

    @Override // com.bytedanceos.appstore.buss.base.BaseActivity
    public int H() {
        return R.layout.activity_tv_app_permission;
    }

    @Override // com.bytedanceos.appstore.buss.base.BaseActivity
    public void I() {
    }

    @Override // com.bytedanceos.appstore.buss.base.BaseActivity
    public void J() {
        S().h().i(this, new c(this));
    }

    public final x7.a N() {
        x7.a r10 = x7.a.a(G());
        q.f(r10, "bind(...)");
        return r10;
    }

    public final String O() {
        return (String) this.f8312e.getValue();
    }

    public final Function0 Q() {
        return new AppPermissionActivity$onRetryListener$1(this);
    }

    public final String R() {
        return (String) this.f8311d.getValue();
    }

    public final AppPermissionViewModel S() {
        return (AppPermissionViewModel) this.f8314g.getValue();
    }

    public final void T(AppPermissionEntity r10) {
        ImageView r11 = N().f25479e;
        q.f(r11, "ivLogo");
        int r12 = 0;
        String r13 = null;
        ImageUtilKt.k(r11, O(), 0, 2, null);
        TextView r14 = N().f25483i;
        if (r10 == null) goto L5;
        r13 = r10.getName();
    L5:
        r14.setText(r13);
        N().f25486l.setText(getString(R.string.version_text, new Object[]{R()}));
        if (r10 == null) goto L15;
        List<String> r15 = r10.getPermission();
        if (r15 == null) goto L16;
        PackageInfo r16 = new PackageInfo();
        r16.packageName = P();
        r16.requestedPermissions = (String[]) r15.toArray(new String[0]);
        int[] r17 = new int[r15.size()];
        int r18 = r15.size();
    L10:
        if (r12 >= r18) goto L12;
        r17[r12] = 1;
        r12 = r12 + 1;
        goto L10
    L12:
        r16.requestedPermissionsFlags = r17;
        N().f25481g.removeAllViews();
        CompatAppSecurityPermisions r19 = new CompatAppSecurityPermisions(this, r16);
        N().f25481g.addView(r19.k());
        return;
    L16:
        return;
    }

    @Override // com.bytedanceos.appstore.buss.base.BaseActivity
    public void initData() {
        ConstraintLayout r10 = N().f25476b;
        q.f(r10, "constraintLayout");
        n r11 = new n(r10);
        this.f8313f = r11;
        r11.c(Q());
        Bundle r12 = new Bundle();
        r12.putString(TraceStatsConsts.PAGE_STATS_KEY_PAGE_NAME, "page_permission");
        f9.b.b("exposure_pages_main", r12);
    }

    @Override // com.bytedanceos.appstore.buss.base.BaseActivity
    public void initView() {
        N().f25478d.setOnClickListener(this);
        N().f25477c.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View r10) {
        if (r10 == null) goto L4;
        Integer r11 = Integer.valueOf(r10.getId());
    L5:
        if (r11 != null) goto L8;
        return;
    L8:
        if (r11.intValue() != R.id.iv_close) goto L11;
        finish();
        return;
    L11:
        return;
    L4:
        r11 = null;
        goto L5
    }
}
