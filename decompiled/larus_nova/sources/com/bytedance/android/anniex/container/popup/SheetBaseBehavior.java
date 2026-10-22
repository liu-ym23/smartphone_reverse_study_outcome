package com.bytedance.android.anniex.container.popup;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MotionEvent;
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

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u0000*\n\b\u0000\u0010\u0002*\u0004\u0018\u00010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0003\u000b\f\rB\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0004\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/anniex/container/popup/SheetBaseBehavior;", "Landroid/view/View;", "V", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", "<init>", "()V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "State", "anniex_release"}, k = 1, mv = {1, 4, 3})
public abstract class SheetBaseBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f40484f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f40485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f40486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f40487c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e f40488d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.android.anniex.container.popup.d f40489e;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/anniex/container/popup/SheetBaseBehavior$State;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface State {
    }

    public static final class a {
    }

    public interface b {
        void a(View r100, int r101);

        void b(View r100, float r101);
    }

    public static final class c implements com.bytedance.android.anniex.container.popup.d {
        public c() {
        }

        @Override // com.bytedance.android.anniex.container.popup.d
        public final boolean a() {
            return true;
        }

        @Override // com.bytedance.android.anniex.container.popup.d
        public final boolean b() {
            return false;
        }

        @Override // com.bytedance.android.anniex.container.popup.d
        public final boolean c() {
            return true;
        }

        @Override // com.bytedance.android.anniex.container.popup.d
        public final boolean d() {
            return true;
        }

        @Override // com.bytedance.android.anniex.container.popup.d
        public final boolean e() {
            return false;
        }

        @Override // com.bytedance.android.anniex.container.popup.d
        public final boolean f(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            return false;
        }
    }

    public static final class d implements e {
        public d() {
        }

        @Override // com.bytedance.android.anniex.container.popup.e
        public final boolean disableDragDown() {
            return false;
        }

        @Override // com.bytedance.android.anniex.container.popup.e
        public final boolean shouldInterceptSlide(int r100) {
            return true;
        }

        @Override // com.bytedance.android.anniex.container.popup.e
        public final boolean a(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            return false;
        }
    }

    static {
    }

    public void setPeekHeight(int r100) {
    }

    public void setState(int r100) {
    }

    public SheetBaseBehavior() {
        this.f40488d = new d();
        this.f40489e = new c();
    }

    public final String a(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Resources r101 = r100.getResources();
        if (r100.getId() == (-1)) goto L8;
        if (r101 == null) goto L8;
        String r102 = r101.getResourceEntryName(r100.getId());
        if (Intrinsics.areEqual("annie_x_bottom_sheet", r102) == true) goto L8;
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
        if ((r100 instanceof ViewPager) == false) goto L32;
        ViewPager r102 = (ViewPager) r100;
        int r103 = r102.getCurrentItem();
        int r104 = r102.getChildCount();
    L11:
        if (r101 >= r104) goto L22;
        View r105 = r102.getChildAt(r101);
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type androidx.viewpager.widget.ViewPager.LayoutParams");
        ViewPager.LayoutParams r107 = (ViewPager.LayoutParams) r106;
        Field r108 = r107.getClass().getDeclaredField("position");     // Catch: Throwable -> L40
        r108.setAccessible(true);     // Catch: Throwable -> L40
        Object r109 = r108.get(r107);     // Catch: Throwable -> L40
        if (r107.isDecor == true) goto L21;
        if ((r109 instanceof Integer) == false) goto L21;
        if (r103 != ((Number) r109).intValue()) goto L21;
    L23:
        if (r105 != null) goto L25;
        return null;
    L25:
        View r110 = findScrollingChild(r105);
        if (r110 != null) goto L28;
        return null;
    L28:
        if (r110.getVisibility() == 0) goto L30;
        return null;
    L30:
        return r110;
    L21:
        r101 = r101 + 1;
    L22:
        r105 = null;
        goto L23
    L32:
        if ((r100 instanceof ViewGroup) == false) goto L39;
        ViewGroup r111 = (ViewGroup) r100;
        int r112 = r111.getChildCount();
    L34:
        if (r101 >= r112) goto L39;
        View r113 = findScrollingChild(r111.getChildAt(r101));
        if (r113 != null) goto L37;
        r101 = r101 + 1;
        goto L34
    L37:
        return r113;
    L39:
        return null;
    }

    public SheetBaseBehavior(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f40488d = new d();
        this.f40489e = new c();
    }
}
