package com.bytedance.android.shopping.yata.biz.popup.behavior;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\n\b\u0000\u0010\u0002*\u0004\u0018\u00010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0003\u000b\f\rB\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0004\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/yata/biz/popup/behavior/SheetBaseBehavior;", "Landroid/view/View;", "V", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", "<init>", "()V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "State", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class SheetBaseBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f187546g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f187547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f187548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f187549c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f187550d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f187551e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f187552f;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/yata/biz/popup/behavior/SheetBaseBehavior$State;", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface State {
    }

    public static final class a {
    }

    public interface b {
        void a(View r100, int r101);

        void b(View r100);
    }

    public static final class c {
        public c() {
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SheetBaseBehavior f187553a;

        public d(SheetBaseBehavior r100) {
            this.f187553a = r100;
        }
    }

    static {
    }

    public void setPeekHeight(int r100) {
    }

    public void setState(int r100) {
    }

    public SheetBaseBehavior() {
        this.f187547a = true;
        this.f187551e = new d(this);
        this.f187552f = new c();
    }

    public final String a(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Resources r101 = r100.getResources();
        if (r100.getId() == (-1)) goto L8;
        if (r101 == null) goto L8;
        String r102 = r101.getResourceEntryName(r100.getId());
        if ((!Intrinsics.areEqual("commerce_design_bottom_sheet", r102)) == false) goto L8;
        return r102;
    L8:
        int r103 = r100.getChildCount();
        int r104 = 0;
    L9:
        if (r104 >= r103) goto L19;
        View r105 = r100.getChildAt(r104);
        if ((r105 instanceof ViewGroup) == true) goto L13;
        if (r105.getId() != (-1)) goto L16;
        r104 = r104 + 1;
        goto L9
    L16:
        Intrinsics.checkNotNull(r101);
        return r101.getResourceEntryName(r105.getId());
    L13:
        return a((ViewGroup) r105);
    L19:
        return "";
    }

    public final View findScrollingChild(View r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (ViewCompat.isNestedScrollingEnabled(r100) == false) goto L8;
        return r100;
    L8:
        int r101 = 0;
        if ((r100 instanceof ViewPager) == false) goto L36;
        ViewPager r102 = (ViewPager) r100;
        int r103 = r102.getCurrentItem();
        int r104 = r102.getChildCount();
    L11:
        if (r101 >= r104) goto L26;
        View r105 = r102.getChildAt(r101);
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        if (r106 == null) goto L25;
        ViewPager.LayoutParams r107 = (ViewPager.LayoutParams) r106;
        Field r108 = r107.getClass().getDeclaredField("position");     // Catch: Throwable -> L44
        r108.setAccessible(true);     // Catch: Throwable -> L44
        Object r109 = r108.get(r107);     // Catch: Throwable -> L44
        if (r107.isDecor == true) goto L23;
        if ((r109 instanceof Integer) == false) goto L23;
        if (r103 != ((Integer) r109).intValue()) goto L23;
    L27:
        if (r105 != null) goto L29;
        return null;
    L29:
        View r110 = findScrollingChild(r105);
        if (r110 != null) goto L32;
        return null;
    L32:
        if (r110.getVisibility() == 0) goto L34;
        return null;
    L34:
        return r110;
    L23:
        r101 = r101 + 1;
        goto L11
    L25:
        throw new NullPointerException("null cannot be cast to non-null type androidx.viewpager.widget.ViewPager.LayoutParams");
    L26:
        r105 = null;
        goto L27
    L36:
        if ((r100 instanceof ViewGroup) == false) goto L43;
        ViewGroup r111 = (ViewGroup) r100;
        int r112 = r111.getChildCount();
    L38:
        if (r101 >= r112) goto L43;
        View r113 = findScrollingChild(r111.getChildAt(r101));
        if (r113 != null) goto L41;
        r101 = r101 + 1;
        goto L38
    L41:
        return r113;
    L43:
        return null;
    }

    public SheetBaseBehavior(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f187547a = true;
        this.f187551e = new d(this);
        this.f187552f = new c();
    }
}
