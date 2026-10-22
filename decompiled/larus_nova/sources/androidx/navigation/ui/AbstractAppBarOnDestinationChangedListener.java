package androidx.navigation.ui;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.customview.widget.Openable;
import androidx.navigation.FloatingWindow;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.Set;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\b!\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001cH\u0003J\u001c\u0010\u001d\u001a\u00020\u00132\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0001\u0010 \u001a\u00020\u0011H$J\u0012\u0010!\u001a\u00020\u00132\b\u0010\"\u001a\u0004\u0018\u00010#H$R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Landroidx/navigation/ui/AbstractAppBarOnDestinationChangedListener;", "Landroidx/navigation/NavController$OnDestinationChangedListener;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "configuration", "Landroidx/navigation/ui/AppBarConfiguration;", "(Landroid/content/Context;Landroidx/navigation/ui/AppBarConfiguration;)V", "animator", "Landroid/animation/ValueAnimator;", "arrowDrawable", "Landroidx/appcompat/graphics/drawable/DrawerArrowDrawable;", "openableLayoutWeakReference", "Ljava/lang/ref/WeakReference;", "Landroidx/customview/widget/Openable;", "kotlin.jvm.PlatformType", "topLevelDestinations", "", "", "onDestinationChanged", "", "controller", "Landroidx/navigation/NavController;", com.bytedance.android.ec.core.event.a.KEY_DESTINATION, "Landroidx/navigation/NavDestination;", "arguments", "Landroid/os/Bundle;", "setActionBarUpIndicator", "showAsDrawerIndicator", "", "setNavigationIcon", "icon", "Landroid/graphics/drawable/Drawable;", "contentDescription", com.alipay.sdk.m.x.d.f25925o, "title", "", "navigation-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbstractAppBarOnDestinationChangedListener implements NavController.OnDestinationChangedListener {
    private ValueAnimator animator;
    private DrawerArrowDrawable arrowDrawable;
    private final Context context;
    private final WeakReference<Openable> openableLayoutWeakReference;
    private final Set<Integer> topLevelDestinations;

    public abstract void setNavigationIcon(Drawable r100, int r101);

    public abstract void setTitle(CharSequence r100);

    private final void setActionBarUpIndicator(boolean r100) {
        DrawerArrowDrawable r101 = this.arrowDrawable;
        if (r101 != null) goto L5;
        Pair r102 = null;
    L6:
        if (r102 != null) goto L8;
        DrawerArrowDrawable r103 = new DrawerArrowDrawable(this.context);
        this.arrowDrawable = r103;
        r102 = TuplesKt.to(r103, Boolean.FALSE);
    L8:
        DrawerArrowDrawable r104 = (DrawerArrowDrawable) r102.component1();
        boolean r105 = ((Boolean) r102.component2()).booleanValue();
        if (r100 == false) goto L11;
        int r106 = R.string.nav_app_bar_open_drawer_description;
    L12:
        setNavigationIcon(r104, r106);
        if (r100 == false) goto L15;
        float r107 = 0.0f;
    L16:
        if (r105 == false) goto L26;
        float r108 = r104.getProgress();
        ValueAnimator r109 = this.animator;
        if (r109 == null) goto L21;
        r109.cancel();
    L21:
        ObjectAnimator r110 = ObjectAnimator.ofFloat(r104, "progress", new float[]{r108, r107});
        this.animator = r110;
        if (r110 == null) goto L25;
        r110.start();
        return;
    L25:
        throw new NullPointerException("null cannot be cast to non-null type android.animation.ObjectAnimator");
    L26:
        r104.setProgress(r107);
        return;
    L15:
        r107 = 1.0f;
        goto L16
    L11:
        r106 = R.string.nav_app_bar_navigate_up_description;
        goto L12
    L5:
        r102 = TuplesKt.to(r101, Boolean.TRUE);
        goto L6
    }

    public AbstractAppBarOnDestinationChangedListener(Context r100, AppBarConfiguration r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "configuration");
        this.context = r100;
        this.topLevelDestinations = r101.getTopLevelDestinations();
        Openable r102 = r101.getOpenableLayout();
        if (r102 != null) goto L5;
        WeakReference<Openable> r103 = null;
    L6:
        this.openableLayoutWeakReference = r103;
        return;
    L5:
        r103 = new WeakReference(r102);
        goto L6
    }

    @Override // androidx.navigation.NavController.OnDestinationChangedListener
    public void onDestinationChanged(NavController r100, NavDestination r101, Bundle r110) {
        Intrinsics.checkNotNullParameter(r100, "controller");
        Intrinsics.checkNotNullParameter(r101, com.bytedance.android.ec.core.event.a.KEY_DESTINATION);
        if ((r101 instanceof FloatingWindow) == false) goto L5;
        return;
    L5:
        WeakReference<Openable> r102 = this.openableLayoutWeakReference;
        if (r102 != null) goto L8;
        Openable r103 = null;
    L10:
        if (this.openableLayoutWeakReference == null) goto L14;
        if (r103 != null) goto L14;
        r100.removeOnDestinationChangedListener(this);
        return;
    L14:
        CharSequence r104 = r101.getLabel();
        boolean r105 = true;
        if (r104 == null) goto L27;
        StringBuffer r106 = new StringBuffer();
        Matcher r107 = PatternProtector.compile("\\{(.+?)\\}").matcher(r104);
    L18:
        if (r107.find() == false) goto L26;
        String r108 = r107.group(1);
        if (r110 == null) goto L25;
        if (r110.containsKey(r108) == false) goto L25;
        r107.appendReplacement(r106, "");
        r106.append(String.valueOf(r110.get(r108)));
    L25:
        throw new IllegalArgumentException("Could not find \"" + r108 + "\" in " + r110 + " to fill label \"" + r104 + Typography.quote);
    L26:
        r107.appendTail(r106);
        setTitle(r106);
    L27:
        boolean r109 = NavigationUI.matchDestinations$navigation_ui_release(r101, this.topLevelDestinations);
        if (r103 != null) goto L31;
        if (r109 == false) goto L31;
        setNavigationIcon(null, 0);
        return;
    L31:
        if (r103 == null) goto L34;
        if (r109 == false) goto L34;
    L35:
        setActionBarUpIndicator(r105);
        return;
    L34:
        r105 = false;
        goto L35
    L8:
        r103 = r102.get();
        goto L10
    }
}
