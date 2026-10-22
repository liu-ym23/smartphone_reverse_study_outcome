package com.obric.appstore.buss.detail;

import android.os.Bundle;
import android.view.Window;
import androidx.fragment.app.Fragment;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.privacy.PrivacyChecker;
import com.bytedanceos.common.privacy.PrivacyUtils;
import com.obric.appstore.base.BaseActivity;
import com.obric.appstore.buss.search.transition.SearchTransition;
import com.tmall.wireless.tangram.structure.card.FixCard;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u000f\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000f\u0010\u0004J\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u001b8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/obric/appstore/buss/detail/AppDetailActivity;", "Lcom/obric/appstore/base/BaseActivity;", "Lcom/bytedanceos/common/privacy/PrivacyChecker$Observer;", "<init>", "()V", "", "z", "Lcom/bytedanceos/common/model/AppInfo;", FixCard.FixStyle.KEY_X, "()Lcom/bytedanceos/common/model/AppInfo;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onPrivacyAgreed", "onDestroy", "Landroidx/fragment/app/Fragment;", "fragment", "w", "(Landroidx/fragment/app/Fragment;)V", "", FixCard.FixStyle.KEY_Y, "()Z", "Lcom/obric/appstore/buss/search/transition/SearchTransition$b;", "e", "Lcom/obric/appstore/buss/search/transition/SearchTransition$b;", "searchScene2", "Ljava/lang/Class;", "v", "()Ljava/lang/Class;", "mFragmentClass", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAppDetailActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppDetailActivity.kt\ncom/obric/appstore/buss/detail/AppDetailActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,68:1\n1#2:69\n*E\n"})
public final class AppDetailActivity extends BaseActivity implements PrivacyChecker.Observer {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SearchTransition.b f10611e;

    public AppDetailActivity() {
        this.f10611e = new SearchTransition.b();
    }

    private final void z() {
        SearchTransition.b r10 = this.f10611e;
        Window r11 = getWindow();
        q.f(r11, "getWindow(...)");
        r10.c(r11);
    }

    @Override // com.obric.appstore.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        PrivacyUtils.h(PrivacyUtils.f9901a, this, this, null, 4, null);
        z();
    }

    @Override // com.obric.appstore.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        com.obric.appstore.util.l.f11084a.h(this);
        super.onDestroy();
    }

    @Override // com.bytedanceos.common.privacy.PrivacyChecker.Observer
    public void onPrivacyAgreed() {
    }

    @Override // com.obric.appstore.base.BaseActivity
    public Class v() {
        return AppDetailFragment.class;
    }

    @Override // com.obric.appstore.base.BaseActivity
    public void w(Fragment r10) {
        q.g(r10, "fragment");
        if ((r10 instanceof AppDetailFragment) == false) goto L5;
        AppDetailFragment r11 = (AppDetailFragment) r10;
    L6:
        if (r11 != null) goto L8;
        return;
    L8:
        AppDetailFragment.a r12 = AppDetailFragment.f10612s;
        AppInfo r13 = x();
        if (r13 != null) goto L11;
        return;
    L11:
        r11.setArguments(r12.a(r13, y()));
        return;
    L5:
        r11 = null;
        goto L6
    }

    public final AppInfo x() {
        Object r10 = null;
        Result.a r11 = Result.Companion;     // Catch: Throwable -> L6
        Serializable r12 = getIntent().getSerializableExtra("original_data");     // Catch: Throwable -> L6
        if ((r12 instanceof AppInfo) == false) goto L8;
        AppInfo r13 = (AppInfo) r12;     // Catch: Throwable -> L6
    L9:
        Object r14 = Result.m35constructorimpl(r13);     // Catch: Throwable -> L6
    L13:
        if (Result.m41isFailureimpl(r14) == true) goto L17;
        r10 = r14;
    L17:
        return (AppInfo) r10;
    L8:
        r13 = null;
    L6:
        th = move-exception;
        Result.a r15 = Result.Companion;
        r14 = Result.m35constructorimpl(kotlin.c.a(th));
        goto L13
    }

    public final boolean y() {
        Result.a r10 = Result.Companion;     // Catch: Throwable -> L5
        Object r11 = Result.m35constructorimpl(Boolean.valueOf(getIntent().getBooleanExtra("original_do_install", false)));     // Catch: Throwable -> L5
    L8:
        if (Result.m41isFailureimpl(r11) == false) goto L10;
        r11 = null;
    L10:
        Boolean r12 = (Boolean) r11;
        if (r12 != null) goto L13;
        return false;
    L13:
        return r12.booleanValue();
    L5:
        th = move-exception;
        Result.a r13 = Result.Companion;
        r11 = Result.m35constructorimpl(kotlin.c.a(th));
        goto L8
    }
}
