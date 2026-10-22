package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.Toolbar;
import androidx.exifinterface.media.ExifInterface;
import com.alipay.sdk.m.x.d;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.ss.android.lark.language.service.impl.a;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0013\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\nH\u0016J\b\u0010\u0017\u001a\u00020\nH\u0016J\b\u0010\u0018\u001a\u00020\nH\u0016J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J#\u0010\u001c\u001a\u0004\u0018\u0001H\u001d\"\n\b\u0000\u0010\u001d*\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\u001bH\u0016¢\u0006\u0002\u0010 J\u0012\u0010!\u001a\u00020\n2\b\u0010\"\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010!\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u001bH\u0016J\u001c\u0010!\u001a\u00020\n2\b\u0010\"\u001a\u0004\u0018\u00010\u001e2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u001c\u0010&\u001a\u00020\n2\b\u0010\"\u001a\u0004\u0018\u00010\u001e2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0016J\u0012\u0010*\u001a\u00020\n2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010-\u001a\u00020\nH\u0016J\b\u0010.\u001a\u00020\nH\u0016J\n\u0010/\u001a\u0004\u0018\u000100H\u0016J\u0010\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u001bH\u0016J\u0010\u00104\u001a\u0002022\u0006\u00103\u001a\u00020\u001bH\u0016J\u0012\u00105\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u000208H\u0016J\b\u00109\u001a\u00020\nH\u0016J.\u0010:\u001a\u0004\u0018\u00010\u001e2\b\u0010;\u001a\u0004\u0018\u00010\u001e2\b\u0010<\u001a\u0004\u0018\u00010=2\u0006\u0010)\u001a\u00020(2\u0006\u0010>\u001a\u00020?H\u0016J\u0010\u0010@\u001a\u00020\n2\u0006\u0010A\u001a\u000202H\u0016J\b\u0010B\u001a\u000202H\u0016J\u0012\u0010C\u001a\u00020\n2\b\u0010D\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010E\u001a\u000202H\u0016J\u0010\u0010F\u001a\u00020\n2\u0006\u0010G\u001a\u00020\u001bH\u0016J\b\u0010H\u001a\u00020\u001bH\u0016J\u0010\u0010I\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0002J,\u0010J\u001a\u0004\u0018\u00010\u001e2\b\u0010;\u001a\u0004\u0018\u00010\u001e2\u0006\u0010<\u001a\u00020=2\u0006\u0010)\u001a\u00020(2\u0006\u0010>\u001a\u00020?H\u0016J\"\u0010J\u001a\u0004\u0018\u00010\u001e2\u0006\u0010<\u001a\u00020=2\u0006\u0010)\u001a\u00020(2\u0006\u0010>\u001a\u00020?H\u0016R\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Landroidx/appcompat/app/BaseContextWrapperDelegate;", "Landroidx/appcompat/app/AppCompatDelegate;", "Landroid/view/LayoutInflater$Factory2;", "superDelegate", "<init>", "(Landroidx/appcompat/app/AppCompatDelegate;)V", "factory2", "getSupportActionBar", "Landroidx/appcompat/app/ActionBar;", "setSupportActionBar", "", NewBroadcastMonitor.STAGE.TOOLBAR, "Landroidx/appcompat/widget/Toolbar;", "getMenuInflater", "Landroid/view/MenuInflater;", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", "onPostCreate", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", WidgetCostModule.TYPE_ON_START, "onStop", "onPostResume", "setTheme", "themeResId", "", "findViewById", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "id", "(I)Landroid/view/View;", "setContentView", BaseSwitches.V, "resId", "lp", "Landroid/view/ViewGroup$LayoutParams;", "addContentView", "attachBaseContext2", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, d.f25925o, "title", "", "invalidateOptionsMenu", LiveCommonConstants.REASON_ON_DEDTROY, "getDrawerToggleDelegate", "Landroidx/appcompat/app/ActionBarDrawerToggle$Delegate;", "requestWindowFeature", "", "featureId", "hasWindowFeature", "startSupportActionMode", "Landroidx/appcompat/view/ActionMode;", "callback", "Landroidx/appcompat/view/ActionMode$Callback;", "installViewFactory", "createView", "parent", "name", "", "attrs", "Landroid/util/AttributeSet;", "setHandleNativeActionModesEnabled", "enabled", "isHandleNativeActionModesEnabled", "onSaveInstanceState", "outState", "applyDayNight", "setLocalNightMode", "mode", "getLocalNightMode", "wrap", "onCreateView", "language_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BaseContextWrapperDelegate extends AppCompatDelegate implements LayoutInflater.Factory2 {
    private final LayoutInflater.Factory2 factory2;
    private final AppCompatDelegate superDelegate;

    @Override // androidx.appcompat.app.AppCompatDelegate
    public boolean applyDayNight() {
        return this.superDelegate.applyDayNight();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
        return this.superDelegate.getDrawerToggleDelegate();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public int getLocalNightMode() {
        return this.superDelegate.getLocalNightMode();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public MenuInflater getMenuInflater() {
        return this.superDelegate.getMenuInflater();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public ActionBar getSupportActionBar() {
        return this.superDelegate.getSupportActionBar();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void installViewFactory() {
        this.superDelegate.installViewFactory();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void invalidateOptionsMenu() {
        this.superDelegate.invalidateOptionsMenu();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public boolean isHandleNativeActionModesEnabled() {
        return this.superDelegate.isHandleNativeActionModesEnabled();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onDestroy() {
        this.superDelegate.onDestroy();
        AppCompatDelegate.removeActivityDelegate(this);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onPostResume() {
        this.superDelegate.onPostResume();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onStart() {
        this.superDelegate.onStart();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onStop() {
        this.superDelegate.onStop();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BaseContextWrapperDelegate(AppCompatDelegate r100) {
        Intrinsics.checkNotNullParameter(r100, "superDelegate");
        this.superDelegate = r100;
        if ((r100 instanceof LayoutInflater.Factory2) == false) goto L5;
        LayoutInflater.Factory2 r101 = (LayoutInflater.Factory2) r100;
    L6:
        this.factory2 = r101;
        return;
    L5:
        r101 = null;
        goto L6
    }

    private final Context wrap(Context r100) {
        int r101 = a.f431092f;
        return a.b.f431098a.j(r100);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public Context attachBaseContext2(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return wrap(this.superDelegate.attachBaseContext2(super.attachBaseContext2(r100)));
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public <T extends View> T findViewById(int r100) {
        return (T) this.superDelegate.findViewById(r100);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public boolean hasWindowFeature(int r100) {
        return this.superDelegate.hasWindowFeature(r100);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onConfigurationChanged(Configuration r100) {
        this.superDelegate.onConfigurationChanged(r100);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onCreate(Bundle r100) {
        this.superDelegate.onCreate(r100);
        AppCompatDelegate.removeActivityDelegate(this.superDelegate);
        AppCompatDelegate.addActiveDelegate(this);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onPostCreate(Bundle r100) {
        this.superDelegate.onPostCreate(r100);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onSaveInstanceState(Bundle r100) {
        this.superDelegate.onSaveInstanceState(r100);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public boolean requestWindowFeature(int r100) {
        return this.superDelegate.requestWindowFeature(r100);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setContentView(int r100) {
        this.superDelegate.setContentView(r100);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setHandleNativeActionModesEnabled(boolean r100) {
        this.superDelegate.setHandleNativeActionModesEnabled(r100);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setLocalNightMode(int r100) {
        this.superDelegate.setLocalNightMode(r100);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setSupportActionBar(Toolbar r100) {
        this.superDelegate.setSupportActionBar(r100);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setTheme(int r100) {
        this.superDelegate.setTheme(r100);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setTitle(CharSequence r100) {
        this.superDelegate.setTitle(r100);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public ActionMode startSupportActionMode(ActionMode.Callback r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        return this.superDelegate.startSupportActionMode(r100);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setContentView(View r100) {
        this.superDelegate.setContentView(r100);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void addContentView(View r100, ViewGroup.LayoutParams r101) {
        this.superDelegate.addContentView(r100, r101);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setContentView(View r100, ViewGroup.LayoutParams r101) {
        this.superDelegate.setContentView(r100, r101);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String r100, Context r101, AttributeSet r102) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "attrs");
        LayoutInflater.Factory2 r103 = this.factory2;
        if (r103 != null) goto L7;
        return null;
    L7:
        return r103.onCreateView(r100, r101, r102);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public View createView(View r100, String r101, Context r102, AttributeSet r103) {
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "attrs");
        return this.superDelegate.createView(r100, r101, r102, r103);
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View r100, String r101, Context r102, AttributeSet r103) {
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "attrs");
        LayoutInflater.Factory2 r104 = this.factory2;
        if (r104 != null) goto L7;
        return null;
    L7:
        return r104.onCreateView(r100, r101, r102, r103);
    }
}
