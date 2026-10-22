package com.bytedanceos.appstore.buss.activity;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.m0;
import com.bytedanceos.appstore.buss.adapter.onetype.AppFeedBackAdapter;
import com.bytedanceos.appstore.buss.base.BaseActivity;
import com.bytedanceos.appstore.buss.entity.AppFeedBackItemEntity;
import com.bytedanceos.appstore.buss.network.h;
import com.bytedanceos.appstore.buss.utilities.j;
import com.bytedanceos.appstore.buss.utilities.s;
import com.bytedanceos.appstore.buss.viewmodels.AppFeedBackViewModel;
import com.bytedanceos.common.utils.FeedBackUtil;
import com.obric.appstore.R;
import com.tmall.wireless.tangram.dataparser.concrete.Card;
import com.tmall.wireless.tangram.eventbus.BusSupport;
import java.util.ArrayList;
import java.util.Iterator;
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
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u0000 ;2\u00020\u00012\u00020\u0002:\u0001<B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\t\u0010\u0004J\u0019\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cR\u001b\u0010\"\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b$\u0010%R$\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\u0015j\b\u0012\u0004\u0012\u00020\u000e`'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020,0+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u001b\u00104\u001a\u0002008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\u001f\u001a\u0004\b2\u00103R\u001b\u00108\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\u001f\u001a\u0004\b6\u00107R\u0014\u0010:\u001a\u00020\u000e8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b9\u00107¨\u0006="}, d2 = {"Lcom/bytedanceos/appstore/buss/activity/AppFeedBackActivity;", "Lcom/bytedanceos/appstore/buss/base/BaseActivity;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "", "J", "initView", "initData", "I", "Landroid/view/View;", "v", BusSupport.EVENT_ON_CLICK, "(Landroid/view/View;)V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Ljava/util/ArrayList;", "Landroid/net/Uri;", "getImagesUri", "(Landroid/content/Intent;)Ljava/util/ArrayList;", "", "enable", "senSubmitBtnEnable", "(Z)V", "Lcom/bytedanceos/appstore/buss/viewmodels/AppFeedBackViewModel;", "c", "Lkotlin/Lazy;", "P", "()Lcom/bytedanceos/appstore/buss/viewmodels/AppFeedBackViewModel;", "viewModel", "Lcom/bytedanceos/appstore/buss/adapter/onetype/AppFeedBackAdapter;", "d", "Lcom/bytedanceos/appstore/buss/adapter/onetype/AppFeedBackAdapter;", "adapter", "Lkotlin/collections/ArrayList;", "e", "Ljava/util/ArrayList;", "feedbackTypes", "", "Lcom/bytedanceos/appstore/buss/entity/AppFeedBackItemEntity;", "f", "Ljava/util/List;", Card.KEY_ITEMS, "", "g", "N", "()Ljava/lang/String;", "appPackageName", "h", "O", "()I", "appVersionCode", "H", "layoutId", "i", "a", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAppFeedBackActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppFeedBackActivity.kt\ncom/bytedanceos/appstore/buss/activity/AppFeedBackActivity\n+ 2 ActivityViewModelLazy.kt\nandroidx/activity/ActivityViewModelLazyKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 NetSource.kt\ncom/bytedanceos/appstore/buss/network/NetSourceKt\n*L\n1#1,188:1\n75#2,13:189\n1855#3,2:202\n50#4,9:204\n*S KotlinDebug\n*F\n+ 1 AppFeedBackActivity.kt\ncom/bytedanceos/appstore/buss/activity/AppFeedBackActivity\n*L\n35#1:189,13\n120#1:202,2\n74#1:204,9\n*E\n"})
public final class AppFeedBackActivity extends BaseActivity implements View.OnClickListener {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f8298i = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f8299c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AppFeedBackAdapter f8300d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList f8301e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f8302f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f8303g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f8304h;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final void a(Context r10, String r11, String r12) {
            q.g(r10, "context");
            q.g(r11, "appPackageName");
            q.g(r12, "appVersionCode");
            Intent r13 = new Intent(r10, AppFeedBackActivity.class);
            r13.putExtra("appPackageName", r11);
            r13.putExtra("appVersionCode", r12);
            r10.startActivity(r13);
        }

        public a() {
        }
    }

    static {
        f8298i = new a(null);
    }

    public AppFeedBackActivity() {
        Function0<ViewModelProvider.Factory> r10 = new AppFeedBackActivity$viewModel$2(this);
        final Function0 r11 = null;
        this.f8299c = new m0(u.b(AppFeedBackViewModel.class), new AppFeedBackActivity$special$$inlined$viewModels$default$2(this), r10, new AppFeedBackActivity$special$$inlined$viewModels$default$3(r11, this));
        this.f8301e = new ArrayList();
        this.f8302f = new ArrayList();
        this.f8303g = kotlin.b.b(new AppFeedBackActivity$appPackageName$2(this));
        this.f8304h = kotlin.b.b(new AppFeedBackActivity$appVersionCode$2(this));
    }

    public static /* synthetic */ void K(AppFeedBackActivity r10, h r11) {
        Q(r10, r11);
    }

    public static final /* synthetic */ String L(AppFeedBackActivity r10) {
        return r10.N();
    }

    public static final /* synthetic */ int M(AppFeedBackActivity r10) {
        return r10.O();
    }

    public static final void Q(AppFeedBackActivity r10, h r11) {
        q.g(r10, "this$0");
        q.d(r11);
        if ((r11 instanceof h.b) == false) goto L6;
        return;
    L6:
        if ((r11 instanceof h.c) == false) goto L9;
        String r12 = r10.getString(R.string.feedback_success);
        q.f(r12, "getString(...)");
        s.b(r10, r12);
        r10.finish();
        return;
    L9:
        if ((r11 instanceof h.a) == false) goto L16;
        h.a r13 = (h.a) r11;
        j.f8856a.c(r13.c());
        r10.senSubmitBtnEnable(true);
        switch(r13.b()) {
            case 1006008: goto L13;
            case 1006009: goto L13;
            default: goto L12;
        };
    L12:
        String r14 = r10.getString(R.string.feedback_fail);
        q.f(r14, "getString(...)");
        s.b(r10, r14);
        return;
    L13:
        String r15 = r10.getString(R.string.feedback_image_fail);
        q.f(r15, "getString(...)");
        s.b(r10, r15);
        return;
    }

    @Override // com.bytedanceos.appstore.buss.base.BaseActivity
    public int H() {
        return R.layout.activity_tv_app_feedback;
    }

    @Override // com.bytedanceos.appstore.buss.base.BaseActivity
    public void I() {
    }

    @Override // com.bytedanceos.appstore.buss.base.BaseActivity
    public void J() {
        P().i().i(this, new com.bytedanceos.appstore.buss.activity.a(this));
    }

    public final String N() {
        return (String) this.f8303g.getValue();
    }

    public final int O() {
        return ((Number) this.f8304h.getValue()).intValue();
    }

    public final AppFeedBackViewModel P() {
        return (AppFeedBackViewModel) this.f8299c.getValue();
    }

    public final ArrayList getImagesUri(Intent r10) {
        ArrayList r11 = new ArrayList();
        ClipData r12 = r10.getClipData();
        if (r12 == null) goto L15;
        int r13 = r12.getItemCount();
        if (r13 <= 4) goto L7;
        r13 = 4;
    L7:
        int r14 = 0;
    L8:
        if (r14 >= r13) goto L19;
        Uri r15 = r12.getItemAt(r14).getUri();
        if (FeedBackUtil.x(FeedBackUtil.s(r15)) == false) goto L12;
        r11.add(r15);
    L13:
        r14 = r14 + 1;
        goto L8
    L12:
        s.b(this, " 不支持的图片格式或错误的文件");
    L19:
        return r11;
    L15:
        if (r11.isEmpty() == false) goto L19;
        Uri r16 = r10.getData();
        if (r16 == null) goto L19;
        r11.add(r16);
        goto L19
    }

    @Override // com.bytedanceos.appstore.buss.base.BaseActivity
    public void initData() {
    }

    @Override // com.bytedanceos.appstore.buss.base.BaseActivity
    public void initView() {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int r10, int r11, Intent r12) {
        super.onActivityResult(r10, r11, r12);
        if (r10 == 10) goto L5;
        return;
    L5:
        if (r12 != null) goto L7;
        return;
    L7:
        ArrayList r13 = getImagesUri(r12);
        if (r13.isEmpty() == false) goto L11;
        j.f8856a.a("not have pics");
        return;
    L11:
        Iterator r14 = r13.iterator();
    L12:
        AppFeedBackAdapter r15 = null;
        if (r14.hasNext() == false) goto L15;
        Uri r16 = (Uri) r14.next();
        AppFeedBackItemEntity r17 = new AppFeedBackItemEntity(null, null, 3, null);
        r17.setUri(r16);
        r17.setAppPackageName(N());
        List r18 = this.f8302f;
        r18.add(r18.size() - 1, r17);
        goto L12
    L15:
        AppFeedBackAdapter r19 = this.f8300d;
        if (r19 != null) goto L18;
        q.y("adapter");
        r19 = null;
    L18:
        r19.setList(this.f8302f);
        AppFeedBackAdapter r20 = this.f8300d;
        if (r20 != null) goto L21;
        q.y("adapter");
    L22:
        r15.notifyDataSetChanged();
        return;
    L21:
        r15 = r20;
        goto L22
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View r10) {
    }

    public final void senSubmitBtnEnable(boolean r10) {
    }
}
