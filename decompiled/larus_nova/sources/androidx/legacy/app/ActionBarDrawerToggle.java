package androidx.legacy.app;

import android.R;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes17.dex */
public class ActionBarDrawerToggle implements DrawerLayout.DrawerListener {
    private static final int ID_HOME = 16908332;
    private static final String TAG = "ActionBarDrawerToggle";
    private static final int[] THEME_ATTRS = null;
    private static final float TOGGLE_DRAWABLE_OFFSET = 0.33333334f;
    final Activity mActivity;
    private final Delegate mActivityImpl;
    private final int mCloseDrawerContentDescRes;
    private Drawable mDrawerImage;
    private final int mDrawerImageResource;
    private boolean mDrawerIndicatorEnabled;
    private final DrawerLayout mDrawerLayout;
    private boolean mHasCustomUpIndicator;
    private Drawable mHomeAsUpIndicator;
    private final int mOpenDrawerContentDescRes;
    private SetIndicatorInfo mSetIndicatorInfo;
    private SlideDrawable mSlider;

    public interface Delegate {
        Drawable getThemeUpIndicator();

        void setActionBarDescription(int r100);

        void setActionBarUpIndicator(Drawable r100, int r101);
    }

    public interface DelegateProvider {
        Delegate getDrawerToggleDelegate();
    }

    public static class SetIndicatorInfo {
        Method mSetHomeActionContentDescription;
        Method mSetHomeAsUpIndicator;
        ImageView mUpIndicatorView;

        public SetIndicatorInfo(Activity r100) {
            this.mSetHomeAsUpIndicator = ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", new Class[]{Drawable.class});     // Catch: NoSuchMethodException -> L5
            this.mSetHomeActionContentDescription = ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", new Class[]{Integer.TYPE});     // Catch: NoSuchMethodException -> L5
            return;
        L5:
            View r101 = r100.findViewById(16908332);
            if (r101 != null) goto L8;
            return;
        L8:
            ViewGroup r102 = (ViewGroup) r101.getParent();
            if (r102.getChildCount() == 2) goto L11;
            return;
        L11:
            View r103 = r102.getChildAt(0);
            View r104 = r102.getChildAt(1);
            if (r103.getId() != 16908332) goto L15;
            r103 = r104;
        L15:
            if ((r103 instanceof ImageView) == false) goto L20;
            this.mUpIndicatorView = (ImageView) r103;
            return;
        }
    }

    public class SlideDrawable extends InsetDrawable implements Drawable.Callback {
        private final boolean mHasMirroring;
        private float mOffset;
        private float mPosition;
        private final Rect mTmpRect;
        final /* synthetic */ ActionBarDrawerToggle this$0;

        public float getPosition() {
            return this.mPosition;
        }

        public static View INVOKEVIRTUAL_androidx_legacy_app_ActionBarDrawerToggle$SlideDrawable_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
            View r101 = r100.getDecorView();
            if (c.f346345e == false) goto L7;
            FLogger.f375446a.i("DecorViewLancet", "getDecorView");
            Thread r102 = ThreadMethodProxy.currentThread();
            if (r102 == c.f346341a) goto L7;
            c.a(r102, "getDecorView");
        L7:
            return r101;
        }

        @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public void draw(Canvas r100) {
            copyBounds(this.mTmpRect);
            r100.save();
            int r101 = 1;
            if (ViewCompat.getLayoutDirection(INVOKEVIRTUAL_androidx_legacy_app_ActionBarDrawerToggle$SlideDrawable_com_larus_home_impl_utils_DecorViewLancet_getDecorView(this.this$0.mActivity.getWindow())) != 1) goto L5;
            boolean r102 = true;
        L6:
            if (r102 == false) goto L8;
            r101 = -1;
        L8:
            float r103 = this.mTmpRect.width();
            r100.translate((((-this.mOffset) * r103) * this.mPosition) * r101, 0.0f);
            if (r102 == true) goto L11;
        L13:
            super.draw(r100);
            r100.restore();
            return;
        L11:
            if (this.mHasMirroring == true) goto L13;
            r100.translate(r103, 0.0f);
            r100.scale(-1.0f, 1.0f);
            goto L13
        L5:
            r102 = false;
            goto L6
        }

        public void setOffset(float r100) {
            this.mOffset = r100;
            invalidateSelf();
        }

        public void setPosition(float r100) {
            this.mPosition = r100;
            invalidateSelf();
        }

        public SlideDrawable(ActionBarDrawerToggle r100, Drawable r101) {
            this.this$0 = r100;
            super(r101, 0);
            this.mHasMirroring = true;
            this.mTmpRect = new Rect();
        }
    }

    static {
        THEME_ATTRS = new int[]{R.attr.homeAsUpIndicator};
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerStateChanged(int r100) {
    }

    private Drawable getThemeUpIndicator() {
        Delegate r100 = this.mActivityImpl;
        if (r100 != null) goto L5;
        ActionBar r101 = this.mActivity.getActionBar();
        if (r101 == null) goto L9;
        Context r102 = r101.getThemedContext();
    L10:
        TypedArray r103 = r102.obtainStyledAttributes(null, THEME_ATTRS, R.attr.actionBarStyle, 0);
        Drawable r104 = r103.getDrawable(0);
        r103.recycle();
        return r104;
    L9:
        r102 = this.mActivity;
        goto L10
    L5:
        return r100.getThemeUpIndicator();
    }

    public void syncState() {
        if (this.mDrawerLayout.isDrawerOpen(GravityCompat.START) == false) goto L5;
        this.mSlider.setPosition(1.0f);
    L7:
        if (this.mDrawerIndicatorEnabled == false) goto L14;
        SlideDrawable r100 = this.mSlider;
        if (this.mDrawerLayout.isDrawerOpen(GravityCompat.START) == false) goto L11;
        int r101 = this.mCloseDrawerContentDescRes;
    L12:
        setActionBarUpIndicator(r100, r101);
        return;
    L11:
        r101 = this.mOpenDrawerContentDescRes;
        goto L12
    L14:
        return;
    L5:
        this.mSlider.setPosition(0.0f);
        goto L7
    }

    public boolean isDrawerIndicatorEnabled() {
        return this.mDrawerIndicatorEnabled;
    }

    private static boolean assumeMaterial(Context r100) {
        if (r100.getApplicationInfo().targetSdkVersion < 21) goto L5;
        return true;
    L5:
        return false;
    }

    private void setActionBarDescription(int r100) {
        Delegate r101 = this.mActivityImpl;
        if (r101 == null) goto L6;
        r101.setActionBarDescription(r100);
        return;
    L6:
        ActionBar r102 = this.mActivity.getActionBar();
        if (r102 == null) goto L10;
        r102.setHomeActionContentDescription(r100);
        return;
    }

    public void onConfigurationChanged(Configuration r100) {
        if (this.mHasCustomUpIndicator == true) goto L5;
        this.mHomeAsUpIndicator = getThemeUpIndicator();
    L5:
        this.mDrawerImage = ContextCompat.getDrawable(this.mActivity, this.mDrawerImageResource);
        syncState();
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerClosed(View r100) {
        this.mSlider.setPosition(0.0f);
        if (this.mDrawerIndicatorEnabled == false) goto L6;
        setActionBarDescription(this.mOpenDrawerContentDescRes);
        return;
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerOpened(View r100) {
        this.mSlider.setPosition(1.0f);
        if (this.mDrawerIndicatorEnabled == false) goto L6;
        setActionBarDescription(this.mCloseDrawerContentDescRes);
        return;
    }

    public boolean onOptionsItemSelected(MenuItem r100) {
        if (r100 != null) goto L4;
        return false;
    L4:
        if (r100.getItemId() == 16908332) goto L6;
        return false;
    L6:
        if (this.mDrawerIndicatorEnabled == true) goto L8;
        return false;
    L8:
        if (this.mDrawerLayout.isDrawerVisible(GravityCompat.START) == false) goto L10;
        this.mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    L10:
        this.mDrawerLayout.openDrawer(GravityCompat.START);
        return true;
    }

    public void setDrawerIndicatorEnabled(boolean r100) {
        if (r100 == this.mDrawerIndicatorEnabled) goto L13;
        if (r100 == false) goto L10;
        SlideDrawable r101 = this.mSlider;
        if (this.mDrawerLayout.isDrawerOpen(GravityCompat.START) == false) goto L8;
        int r102 = this.mCloseDrawerContentDescRes;
    L9:
        setActionBarUpIndicator(r101, r102);
    L11:
        this.mDrawerIndicatorEnabled = r100;
        return;
    L8:
        r102 = this.mOpenDrawerContentDescRes;
        goto L9
    L10:
        setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
        goto L11
    }

    public void setHomeAsUpIndicator(Drawable r100) {
        if (r100 != null) goto L5;
        this.mHomeAsUpIndicator = getThemeUpIndicator();
        this.mHasCustomUpIndicator = false;
    L7:
        if (this.mDrawerIndicatorEnabled == true) goto L10;
        setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
        return;
    L10:
        return;
    L5:
        this.mHomeAsUpIndicator = r100;
        this.mHasCustomUpIndicator = true;
        goto L7
    }

    public void setHomeAsUpIndicator(int r100) {
        if (r100 == 0) goto L4;
        Drawable r101 = ContextCompat.getDrawable(this.mActivity, r100);
    L5:
        setHomeAsUpIndicator(r101);
        return;
    L4:
        r101 = null;
        goto L5
    }

    private void setActionBarUpIndicator(Drawable r100, int r101) {
        Delegate r102 = this.mActivityImpl;
        if (r102 == null) goto L6;
        r102.setActionBarUpIndicator(r100, r101);
        return;
    L6:
        ActionBar r103 = this.mActivity.getActionBar();
        if (r103 == null) goto L10;
        r103.setHomeAsUpIndicator(r100);
        r103.setHomeActionContentDescription(r101);
        return;
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerSlide(View r100, float r101) {
        float r102 = this.mSlider.getPosition();
        if (r101 <= 0.5f) goto L5;
        float r103 = Math.max(r102, Math.max(0.0f, r101 - 0.5f) * 2.0f);
    L6:
        this.mSlider.setPosition(r103);
        return;
    L5:
        r103 = Math.min(r102, r101 * 2.0f);
        goto L6
    }

    public ActionBarDrawerToggle(Activity r100, DrawerLayout r110, int r111, int r112, int r113) {
        this(r100, r110, !assumeMaterial(r100), r111, r112, r113);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ActionBarDrawerToggle(Activity r100, DrawerLayout r101, boolean r102, int r103, int r104, int r105) {
        this.mDrawerIndicatorEnabled = true;
        this.mActivity = r100;
        if ((r100 instanceof DelegateProvider) == false) goto L5;
        this.mActivityImpl = ((DelegateProvider) r100).getDrawerToggleDelegate();
    L6:
        this.mDrawerLayout = r101;
        this.mDrawerImageResource = r103;
        this.mOpenDrawerContentDescRes = r104;
        this.mCloseDrawerContentDescRes = r105;
        this.mHomeAsUpIndicator = getThemeUpIndicator();
        this.mDrawerImage = ContextCompat.getDrawable(r100, r103);
        SlideDrawable r106 = new SlideDrawable(this, this.mDrawerImage);
        this.mSlider = r106;
        if (r102 == false) goto L9;
        float r107 = TOGGLE_DRAWABLE_OFFSET;
    L10:
        r106.setOffset(r107);
        return;
    L9:
        r107 = 0.0f;
        goto L10
    L5:
        this.mActivityImpl = null;
        goto L6
    }
}
