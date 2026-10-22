package com.obric.appstore.base;

import android.R;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedanceos.common.BaseApplication;
import com.obric.appstore.util.q;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\r\u0010\u0003J\u000f\u0010\u000e\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u000e\u0010\u0003J\u000f\u0010\u000f\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0010\u0010\u0003J\u000f\u0010\u0011\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0011\u0010\u0003J\u000f\u0010\u0012\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0003J\u0019\u0010\u0013\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\bR\u001f\u0010\u001a\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00148\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010 \u001a\u00020\u001b8\u0014X\u0094D¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR$\u0010&\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010!8\u0014X\u0094\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001b\u0010,\u001a\u00020'8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0016\u0010/\u001a\u0004\u0018\u00010\t8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.¨\u00060"}, d2 = {"Lcom/obric/appstore/base/BaseActivity;", "Landroidx/fragment/app/FragmentActivity;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroidx/fragment/app/Fragment;", "fragment", "w", "(Landroidx/fragment/app/Fragment;)V", "onStart", "onResume", "onPause", "onStop", "onDestroy", "onBackPressed", "s", "", "kotlin.jvm.PlatformType", "a", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "", "b", "Z", "t", "()Z", "enableEventBus", "Ljava/lang/Class;", "c", "Ljava/lang/Class;", "v", "()Ljava/lang/Class;", "mFragmentClass", "Lcom/obric/appstore/util/u;", "d", "Lkotlin/Lazy;", "getUiController", "()Lcom/obric/appstore/util/u;", "uiController", "u", "()Landroidx/fragment/app/Fragment;", "mFragment", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nBaseActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseActivity.kt\ncom/obric/appstore/base/BaseActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,81:1\n1#2:82\n*E\n"})
public class BaseActivity extends FragmentActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f10534b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Class f10535c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f10536d;

    public BaseActivity() {
        this.f10533a = getClass().getSimpleName();
        this.f10536d = kotlin.b.b(new BaseActivity$uiController$2(this));
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Fragment r10 = u();
        if ((r10 instanceof e) == false) goto L5;
        e r11 = (e) r10;
    L6:
        if (r11 != null) goto L8;
    L10:
        super.onBackPressed();
        return;
    L8:
        if (r11.z() != true) goto L10;
        return;
    L5:
        r11 = null;
        goto L6
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r10) {
        BaseApplication.u(this.f10533a + '_' + hashCode(), false);
        super.onCreate(r10);
        if (t() == false) goto L5;
        EventBus.getDefault().register(this);
    L5:
        q.a(this);
        s(r10);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (t() == false) goto L5;
        EventBus.getDefault().unregister(this);
    L5:
        BaseApplication.u(this.f10533a + '_' + hashCode(), true);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    public final void s(Bundle r10) {
        Class r11 = v();
        if (r11 != null) goto L5;
        return;
    L5:
        if (r10 != null) goto L8;
        Object r12 = r11.newInstance();
        kotlin.jvm.internal.q.e(r12, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        Fragment r13 = (Fragment) r12;
        w(r13);
        getSupportFragmentManager().o().b(R.id.content, r13, this.f10533a).j();
        return;
    }

    public boolean t() {
        return this.f10534b;
    }

    public final Fragment u() {
        if (v() != null) goto L7;
        return null;
    L7:
        return getSupportFragmentManager().i0(this.f10533a);
    }

    public Class v() {
        return this.f10535c;
    }

    public void w(Fragment r10) {
        kotlin.jvm.internal.q.g(r10, "fragment");
    }
}
