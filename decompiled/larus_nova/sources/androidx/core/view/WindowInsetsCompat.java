package androidx.core.view;

import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import androidx.core.graphics.Insets;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes17.dex */
public class WindowInsetsCompat {
    public static final WindowInsetsCompat CONSUMED = null;
    private static final String TAG = "WindowInsetsCompat";
    private final Impl mImpl;

    public static class Api21ReflectionHolder {
        private static Field sContentInsets;
        private static boolean sReflectionSucceeded;
        private static Field sStableInsets;
        private static Field sViewAttachInfoField;

        public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
            return Class.forName(r100);
        }

        static {
            Field r100 = View.class.getDeclaredField("mAttachInfo");     // Catch: ReflectiveOperationException -> L4
            sViewAttachInfoField = r100;     // Catch: ReflectiveOperationException -> L4
            r100.setAccessible(true);     // Catch: ReflectiveOperationException -> L4
            Class r101 = INVOKESTATIC_androidx_core_view_WindowInsetsCompat$Api21ReflectionHolder_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.view.View$AttachInfo");     // Catch: ReflectiveOperationException -> L4
            Field r102 = r101.getDeclaredField("mStableInsets");     // Catch: ReflectiveOperationException -> L4
            sStableInsets = r102;     // Catch: ReflectiveOperationException -> L4
            r102.setAccessible(true);     // Catch: ReflectiveOperationException -> L4
            Field r103 = r101.getDeclaredField("mContentInsets");     // Catch: ReflectiveOperationException -> L4
            sContentInsets = r103;     // Catch: ReflectiveOperationException -> L4
            r103.setAccessible(true);     // Catch: ReflectiveOperationException -> L4
            sReflectionSucceeded = true;     // Catch: ReflectiveOperationException -> L4
            return;
        L4:
            e = move-exception;
            e.getMessage();
        }

        private Api21ReflectionHolder() {
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKESTATIC_androidx_core_view_WindowInsetsCompat$Api21ReflectionHolder_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class r103 = access$000(r100);     // Catch: Throwable -> L8
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
        L7:
            return r103;
        L8:
            th = move-exception;
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b(r100);
        L12:
            throw th;
        L34:
            Class r104 = access$000(r100);     // Catch: Throwable -> L17
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
        L16:
            return r104;
        L17:
            th = move-exception;
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b(r100);
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName(r100);
        }

        public static WindowInsetsCompat getRootWindowInsets(View r100) {
            if (sReflectionSucceeded == true) goto L5;
        L17:
            return null;
        L5:
            if (r100.isAttachedToWindow() == false) goto L17;
            View r101 = r100.getRootView();
            Object r102 = sViewAttachInfoField.get(r101);     // Catch: IllegalAccessException -> L15
            if (r102 == null) goto L17;
            Rect r103 = (Rect) sStableInsets.get(r102);     // Catch: IllegalAccessException -> L15
            Rect r104 = (Rect) sContentInsets.get(r102);     // Catch: IllegalAccessException -> L15
            if (r103 == null) goto L17;
            if (r104 == null) goto L17;
            WindowInsetsCompat r105 = new Builder().setStableInsets(Insets.of(r103)).setSystemWindowInsets(Insets.of(r104)).build();     // Catch: IllegalAccessException -> L15
            r105.setRootWindowInsets(r105);     // Catch: IllegalAccessException -> L15
            r105.copyRootViewBounds(r100.getRootView());     // Catch: IllegalAccessException -> L15
            return r105;
        L15:
            e = move-exception;
            e.getMessage();
            goto L17
        }
    }

    public static final class Builder {
        private final BuilderImpl mImpl;

        public WindowInsetsCompat build() {
            return this.mImpl.build();
        }

        public Builder() {
            int r100 = Build.VERSION.SDK_INT;
            if (r100 < 30) goto L6;
            this.mImpl = new BuilderImpl30();
            return;
        L6:
            if (r100 < 29) goto L8;
            this.mImpl = new BuilderImpl29();
            return;
        L8:
            this.mImpl = new BuilderImpl20();
        }

        public Builder(WindowInsetsCompat r100) {
            int r101 = Build.VERSION.SDK_INT;
            if (r101 < 30) goto L6;
            this.mImpl = new BuilderImpl30(r100);
            return;
        L6:
            if (r101 < 29) goto L8;
            this.mImpl = new BuilderImpl29(r100);
            return;
        L8:
            this.mImpl = new BuilderImpl20(r100);
        }

        public Builder setDisplayCutout(DisplayCutoutCompat r100) {
            this.mImpl.setDisplayCutout(r100);
            return this;
        }

        public Builder setMandatorySystemGestureInsets(Insets r100) {
            this.mImpl.setMandatorySystemGestureInsets(r100);
            return this;
        }

        public Builder setStableInsets(Insets r100) {
            this.mImpl.setStableInsets(r100);
            return this;
        }

        public Builder setSystemGestureInsets(Insets r100) {
            this.mImpl.setSystemGestureInsets(r100);
            return this;
        }

        public Builder setSystemWindowInsets(Insets r100) {
            this.mImpl.setSystemWindowInsets(r100);
            return this;
        }

        public Builder setTappableElementInsets(Insets r100) {
            this.mImpl.setTappableElementInsets(r100);
            return this;
        }

        public Builder setInsets(int r100, Insets r101) {
            this.mImpl.setInsets(r100, r101);
            return this;
        }

        public Builder setInsetsIgnoringVisibility(int r100, Insets r101) {
            this.mImpl.setInsetsIgnoringVisibility(r100, r101);
            return this;
        }

        public Builder setVisible(int r100, boolean r101) {
            this.mImpl.setVisible(r100, r101);
            return this;
        }
    }

    public static class BuilderImpl {
        private final WindowInsetsCompat mInsets;
        Insets[] mInsetsTypeMask;

        public void setDisplayCutout(DisplayCutoutCompat r100) {
        }

        public void setMandatorySystemGestureInsets(Insets r100) {
        }

        public void setStableInsets(Insets r100) {
        }

        public void setSystemGestureInsets(Insets r100) {
        }

        public void setSystemWindowInsets(Insets r100) {
        }

        public void setTappableElementInsets(Insets r100) {
        }

        public void setVisible(int r100, boolean r101) {
        }

        public BuilderImpl() {
            this(new WindowInsetsCompat(null));
        }

        public final void applyInsetTypes() {
            Insets[] r100 = this.mInsetsTypeMask;
            if (r100 == null) goto L19;
            Insets r101 = r100[Type.indexOf(1)];
            Insets r102 = this.mInsetsTypeMask[Type.indexOf(2)];
            if (r102 != null) goto L7;
            r102 = this.mInsets.getInsets(2);
        L7:
            if (r101 != null) goto L9;
            r101 = this.mInsets.getInsets(1);
        L9:
            setSystemWindowInsets(Insets.max(r101, r102));
            Insets r103 = this.mInsetsTypeMask[Type.indexOf(16)];
            if (r103 == null) goto L12;
            setSystemGestureInsets(r103);
        L12:
            Insets r104 = this.mInsetsTypeMask[Type.indexOf(32)];
            if (r104 == null) goto L15;
            setMandatorySystemGestureInsets(r104);
        L15:
            Insets r105 = this.mInsetsTypeMask[Type.indexOf(64)];
            if (r105 == null) goto L20;
            setTappableElementInsets(r105);
            return;
        L20:
            return;
        }

        public WindowInsetsCompat build() {
            applyInsetTypes();
            return this.mInsets;
        }

        public BuilderImpl(WindowInsetsCompat r100) {
            this.mInsets = r100;
        }

        public void setInsets(int r100, Insets r101) {
            if (this.mInsetsTypeMask != null) goto L5;
            this.mInsetsTypeMask = new Insets[9];
        L5:
            int r102 = 1;
        L7:
            if (r102 > 256) goto L13;
            if ((r100 & r102) == 0) goto L12;
            this.mInsetsTypeMask[Type.indexOf(r102)] = r101;
        L12:
            r102 = r102 << 1;
            goto L7
        }

        public void setInsetsIgnoringVisibility(int r100, Insets r101) {
            if (r100 == 8) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("Ignoring visibility inset not available for IME");
        }
    }

    public static class BuilderImpl20 extends BuilderImpl {
        private static Constructor<WindowInsets> sConstructor;
        private static boolean sConstructorFetched;
        private static Field sConsumedField;
        private static boolean sConsumedFieldFetched;
        private WindowInsets mPlatformInsets;
        private Insets mStableInsets;

        private static WindowInsets createWindowInsetsInstance() {
            if (sConsumedFieldFetched == false) goto L27;
        L6:
            Field r100 = sConsumedField;
            if (r100 == null) goto L14;
            WindowInsets r101 = (WindowInsets) r100.get(null);     // Catch: ReflectiveOperationException -> L12
            if (r101 == null) goto L14;
            return new WindowInsets(r101);
        L14:
            if (sConstructorFetched == false) goto L31;
        L17:
            Constructor<WindowInsets> r102 = sConstructor;
            if (r102 != null) goto L29;
        L21:
            return null;
        L29:
            return r102.newInstance(new Object[]{new Rect()});
        L31:
            sConstructor = WindowInsets.class.getConstructor(new Class[]{Rect.class});     // Catch: ReflectiveOperationException -> L23
        L16:
            sConstructorFetched = true;
            goto L17
        L27:
            sConsumedField = WindowInsets.class.getDeclaredField("CONSUMED");     // Catch: ReflectiveOperationException -> L24
        L5:
            sConsumedFieldFetched = true;
            goto L6
        }

        public BuilderImpl20() {
            this.mPlatformInsets = createWindowInsetsInstance();
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public WindowInsetsCompat build() {
            applyInsetTypes();
            WindowInsetsCompat r100 = WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets);
            r100.setOverriddenInsets(this.mInsetsTypeMask);
            r100.setStableInsets(this.mStableInsets);
            return r100;
        }

        public BuilderImpl20(WindowInsetsCompat r100) {
            super(r100);
            this.mPlatformInsets = r100.toWindowInsets();
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setStableInsets(Insets r100) {
            this.mStableInsets = r100;
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setSystemWindowInsets(Insets r100) {
            WindowInsets r101 = this.mPlatformInsets;
            if (r101 == null) goto L6;
            this.mPlatformInsets = r101.replaceSystemWindowInsets(r100.left, r100.top, r100.right, r100.bottom);
            return;
        }
    }

    public static class BuilderImpl29 extends BuilderImpl {
        final WindowInsets.Builder mPlatBuilder;

        public BuilderImpl29() {
            this.mPlatBuilder = new WindowInsets.Builder();
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public WindowInsetsCompat build() {
            applyInsetTypes();
            WindowInsetsCompat r100 = WindowInsetsCompat.toWindowInsetsCompat(this.mPlatBuilder.build());
            r100.setOverriddenInsets(this.mInsetsTypeMask);
            return r100;
        }

        public BuilderImpl29(WindowInsetsCompat r100) {
            super(r100);
            WindowInsets r101 = r100.toWindowInsets();
            if (r101 == null) goto L5;
            WindowInsets.Builder r102 = new WindowInsets.Builder(r101);
        L6:
            this.mPlatBuilder = r102;
            return;
        L5:
            r102 = new WindowInsets.Builder();
            goto L6
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setDisplayCutout(DisplayCutoutCompat r100) {
            WindowInsets.Builder r101 = this.mPlatBuilder;
            if (r100 == null) goto L5;
            DisplayCutout r102 = r100.unwrap();
        L6:
            r101.setDisplayCutout(r102);
            return;
        L5:
            r102 = null;
            goto L6
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setMandatorySystemGestureInsets(Insets r100) {
            this.mPlatBuilder.setMandatorySystemGestureInsets(r100.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setStableInsets(Insets r100) {
            this.mPlatBuilder.setStableInsets(r100.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setSystemGestureInsets(Insets r100) {
            this.mPlatBuilder.setSystemGestureInsets(r100.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setSystemWindowInsets(Insets r100) {
            this.mPlatBuilder.setSystemWindowInsets(r100.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setTappableElementInsets(Insets r100) {
            this.mPlatBuilder.setTappableElementInsets(r100.toPlatformInsets());
        }
    }

    public static class BuilderImpl30 extends BuilderImpl29 {
        public BuilderImpl30() {
        }

        public BuilderImpl30(WindowInsetsCompat r100) {
            super(r100);
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setInsets(int r100, Insets r101) {
            this.mPlatBuilder.setInsets(TypeImpl30.toPlatformType(r100), r101.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setInsetsIgnoringVisibility(int r100, Insets r101) {
            this.mPlatBuilder.setInsetsIgnoringVisibility(TypeImpl30.toPlatformType(r100), r101.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setVisible(int r100, boolean r101) {
            this.mPlatBuilder.setVisible(TypeImpl30.toPlatformType(r100), r101);
        }
    }

    public static class Impl {
        static final WindowInsetsCompat CONSUMED = null;
        final WindowInsetsCompat mHost;

        public void copyRootViewBounds(View r100) {
        }

        public void copyWindowDataInto(WindowInsetsCompat r100) {
        }

        public DisplayCutoutCompat getDisplayCutout() {
            return null;
        }

        public int hashCode() {
            return ObjectsCompat.hash(new Object[]{Boolean.valueOf(isRound()), Boolean.valueOf(isConsumed()), getSystemWindowInsets(), getStableInsets(), getDisplayCutout()});
        }

        public boolean isConsumed() {
            return false;
        }

        public boolean isRound() {
            return false;
        }

        public boolean isVisible(int r100) {
            return true;
        }

        public void setOverriddenInsets(Insets[] r100) {
        }

        public void setRootViewData(Insets r100) {
        }

        public void setRootWindowInsets(WindowInsetsCompat r100) {
        }

        public void setStableInsets(Insets r100) {
        }

        static {
            CONSUMED = new Builder().build().consumeDisplayCutout().consumeStableInsets().consumeSystemWindowInsets();
        }

        public Insets getMandatorySystemGestureInsets() {
            return getSystemWindowInsets();
        }

        public Insets getSystemGestureInsets() {
            return getSystemWindowInsets();
        }

        public Insets getTappableElementInsets() {
            return getSystemWindowInsets();
        }

        public WindowInsetsCompat consumeDisplayCutout() {
            return this.mHost;
        }

        public WindowInsetsCompat consumeStableInsets() {
            return this.mHost;
        }

        public WindowInsetsCompat consumeSystemWindowInsets() {
            return this.mHost;
        }

        public Insets getStableInsets() {
            return Insets.NONE;
        }

        public Insets getSystemWindowInsets() {
            return Insets.NONE;
        }

        public Impl(WindowInsetsCompat r100) {
            this.mHost = r100;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Impl) == true) goto L8;
            return false;
        L8:
            Impl r101 = (Impl) r100;
            if (isRound() == r101.isRound()) goto L11;
        L19:
            return false;
        L11:
            if (isConsumed() != r101.isConsumed()) goto L19;
            if (ObjectsCompat.equals(getSystemWindowInsets(), r101.getSystemWindowInsets()) == false) goto L19;
            if (ObjectsCompat.equals(getStableInsets(), r101.getStableInsets()) == false) goto L19;
            if (ObjectsCompat.equals(getDisplayCutout(), r101.getDisplayCutout()) == false) goto L19;
            return true;
        }

        public Insets getInsets(int r100) {
            return Insets.NONE;
        }

        public Insets getInsetsIgnoringVisibility(int r100) {
            if ((r100 & 8) != 0) goto L7;
            return Insets.NONE;
        L7:
            throw new IllegalArgumentException("Unable to query the maximum insets for IME");
        }

        public WindowInsetsCompat inset(int r100, int r101, int r102, int r103) {
            return CONSUMED;
        }
    }

    public static class Impl20 extends Impl {
        private static Class<?> sAttachInfoClass;
        private static Field sAttachInfoField;
        private static Method sGetViewRootImplMethod;
        private static Field sVisibleInsetsField;
        private static boolean sVisibleRectReflectionFetched;
        private Insets[] mOverriddenInsets;
        final WindowInsets mPlatformInsets;
        Insets mRootViewVisibleInsets;
        private WindowInsetsCompat mRootWindowInsets;
        private Insets mSystemWindowInsets;

        public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
            return Class.forName(r100);
        }

        private static void loadReflectionField() {
            sGetViewRootImplMethod = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);     // Catch: ReflectiveOperationException -> L5
            Class<?> r100 = INVOKESTATIC_androidx_core_view_WindowInsetsCompat$Impl20_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.view.View$AttachInfo");     // Catch: ReflectiveOperationException -> L5
            sAttachInfoClass = r100;     // Catch: ReflectiveOperationException -> L5
            sVisibleInsetsField = r100.getDeclaredField("mVisibleInsets");     // Catch: ReflectiveOperationException -> L5
            sAttachInfoField = INVOKESTATIC_androidx_core_view_WindowInsetsCompat$Impl20_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");     // Catch: ReflectiveOperationException -> L5
            sVisibleInsetsField.setAccessible(true);     // Catch: ReflectiveOperationException -> L5
            sAttachInfoField.setAccessible(true);     // Catch: ReflectiveOperationException -> L5
        L7:
            sVisibleRectReflectionFetched = true;
            return;
        L5:
            e = move-exception;
            e.getMessage();
            goto L7
        }

        private Insets getRootStableInsets() {
            WindowInsetsCompat r100 = this.mRootWindowInsets;
            if (r100 == null) goto L7;
            return r100.getStableInsets();
        L7:
            return Insets.NONE;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public final Insets getSystemWindowInsets() {
            if (this.mSystemWindowInsets != null) goto L6;
            this.mSystemWindowInsets = Insets.of(this.mPlatformInsets.getSystemWindowInsetLeft(), this.mPlatformInsets.getSystemWindowInsetTop(), this.mPlatformInsets.getSystemWindowInsetRight(), this.mPlatformInsets.getSystemWindowInsetBottom());
        L6:
            return this.mSystemWindowInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public boolean isRound() {
            return this.mPlatformInsets.isRound();
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKESTATIC_androidx_core_view_WindowInsetsCompat$Impl20_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class r103 = access$000(r100);     // Catch: Throwable -> L8
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
        L7:
            return r103;
        L8:
            th = move-exception;
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b(r100);
        L12:
            throw th;
        L34:
            Class r104 = access$000(r100);     // Catch: Throwable -> L17
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
        L16:
            return r104;
        L17:
            th = move-exception;
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b(r100);
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName(r100);
        }

        private Insets getVisibleInsets(View r100) {
            if (Build.VERSION.SDK_INT >= 30) goto L27;
            if (sVisibleRectReflectionFetched == true) goto L7;
            loadReflectionField();
        L7:
            Method r101 = sGetViewRootImplMethod;
            if (r101 != null) goto L10;
        L25:
            return null;
        L10:
            if (sAttachInfoClass == null) goto L25;
            if (sVisibleInsetsField == null) goto L25;
            Object r102 = r101.invoke(r100, new Object[0]);     // Catch: ReflectiveOperationException -> L23
            if (r102 == null) goto L18;
            Object r103 = sAttachInfoField.get(r102);     // Catch: ReflectiveOperationException -> L23
            Rect r104 = (Rect) sVisibleInsetsField.get(r103);     // Catch: ReflectiveOperationException -> L23
            if (r104 != null) goto L22;
            return null;
        L22:
            return Insets.of(r104);
        L18:
            return null;
        L23:
            e = move-exception;
            e.getMessage();
            goto L25
        L27:
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public void copyRootViewBounds(View r100) {
            Insets r101 = getVisibleInsets(r100);
            if (r101 != null) goto L5;
            r101 = Insets.NONE;
        L5:
            setRootViewData(r101);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public void copyWindowDataInto(WindowInsetsCompat r100) {
            r100.setRootWindowInsets(this.mRootWindowInsets);
            r100.setRootViewData(this.mRootViewVisibleInsets);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public boolean equals(Object r100) {
            if (super.equals(r100) == true) goto L7;
            return false;
        L7:
            return Objects.equals(this.mRootViewVisibleInsets, ((Impl20) r100).mRootViewVisibleInsets);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public Insets getInsets(int r100) {
            return getInsets(r100, false);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public Insets getInsetsIgnoringVisibility(int r100) {
            return getInsets(r100, true);
        }

        public boolean isTypeVisible(int r100) {
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L15;
            if (r100 != 4) goto L9;
            return false;
        L9:
            if (r100 == 8) goto L15;
            if (r100 == 128) goto L15;
            return true;
        L15:
            return !getInsetsForType(r100, false).equals(Insets.NONE);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public boolean isVisible(int r100) {
            int r101 = 1;
        L4:
            if (r101 > 256) goto L13;
            if ((r100 & r101) == 0) goto L12;
            if (isTypeVisible(r101) == true) goto L12;
            return false;
        L12:
            r101 = r101 << 1;
            goto L4
        L13:
            return true;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public void setOverriddenInsets(Insets[] r100) {
            this.mOverriddenInsets = r100;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public void setRootViewData(Insets r100) {
            this.mRootViewVisibleInsets = r100;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public void setRootWindowInsets(WindowInsetsCompat r100) {
            this.mRootWindowInsets = r100;
        }

        public Impl20(WindowInsetsCompat r100, Impl20 r101) {
            this(r100, new WindowInsets(r101.mPlatformInsets));
        }

        private Insets getInsets(int r100, boolean r101) {
            Insets r102 = Insets.NONE;
            int r103 = 1;
        L4:
            if (r103 > 256) goto L10;
            if ((r100 & r103) == 0) goto L9;
            r102 = Insets.max(r102, getInsetsForType(r103, r101));
        L9:
            r103 = r103 << 1;
            goto L4
        L10:
            return r102;
        }

        public Insets getInsetsForType(int r100, boolean r101) {
            if (r100 == 1) goto L63;
            Insets r102 = null;
            if (r100 != 2) goto L7;
            if (r101 == false) goto L55;
            Insets r103 = getRootStableInsets();
            Insets r104 = getStableInsets();
            return Insets.of(Math.max(r103.left, r104.left), 0, Math.max(r103.right, r104.right), Math.max(r103.bottom, r104.bottom));
        L55:
            Insets r105 = getSystemWindowInsets();
            WindowInsetsCompat r106 = this.mRootWindowInsets;
            if (r106 == null) goto L58;
            r102 = r106.getStableInsets();
        L58:
            int r107 = r105.bottom;
            if (r102 == null) goto L62;
            r107 = Math.min(r107, r102.bottom);
        L62:
            return Insets.of(r105.left, 0, r105.right, r107);
        L7:
            if (r100 != 8) goto L9;
            Insets[] r108 = this.mOverriddenInsets;
            if (r108 == null) goto L36;
            r102 = r108[Type.indexOf(8)];
        L36:
            if (r102 == null) goto L38;
            return r102;
        L38:
            Insets r109 = getSystemWindowInsets();
            Insets r110 = getRootStableInsets();
            int r111 = r109.bottom;
            if (r111 > r110.bottom) goto L41;
            Insets r112 = this.mRootViewVisibleInsets;
            if (r112 == null) goto L51;
            if (r112.equals(Insets.NONE) == true) goto L51;
            int r113 = this.mRootViewVisibleInsets.bottom;
            if (r113 <= r110.bottom) goto L51;
            return Insets.of(0, 0, 0, r113);
        L51:
            return Insets.NONE;
        L41:
            return Insets.of(0, 0, 0, r111);
        L9:
            if (r100 == 16) goto L32;
            if (r100 == 32) goto L30;
            if (r100 == 64) goto L28;
            if (r100 != 128) goto L17;
            WindowInsetsCompat r114 = this.mRootWindowInsets;
            if (r114 == null) goto L21;
            DisplayCutoutCompat r115 = r114.getDisplayCutout();
        L22:
            if (r115 == null) goto L26;
            return Insets.of(r115.getSafeInsetLeft(), r115.getSafeInsetTop(), r115.getSafeInsetRight(), r115.getSafeInsetBottom());
        L26:
            return Insets.NONE;
        L21:
            r115 = getDisplayCutout();
            goto L22
        L17:
            return Insets.NONE;
        L28:
            return getTappableElementInsets();
        L30:
            return getMandatorySystemGestureInsets();
        L32:
            return getSystemGestureInsets();
        L63:
            if (r101 == false) goto L67;
            return Insets.of(0, Math.max(getRootStableInsets().top, getSystemWindowInsets().top), 0, 0);
        L67:
            return Insets.of(0, getSystemWindowInsets().top, 0, 0);
        }

        public Impl20(WindowInsetsCompat r100, WindowInsets r101) {
            super(r100);
            this.mSystemWindowInsets = null;
            this.mPlatformInsets = r101;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public WindowInsetsCompat inset(int r100, int r101, int r102, int r103) {
            Builder r104 = new Builder(WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets));
            r104.setSystemWindowInsets(WindowInsetsCompat.insetInsets(getSystemWindowInsets(), r100, r101, r102, r103));
            r104.setStableInsets(WindowInsetsCompat.insetInsets(getStableInsets(), r100, r101, r102, r103));
            return r104.build();
        }
    }

    public static class Impl21 extends Impl20 {
        private Insets mStableInsets;

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public WindowInsetsCompat consumeStableInsets() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeStableInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public WindowInsetsCompat consumeSystemWindowInsets() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeSystemWindowInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public final Insets getStableInsets() {
            if (this.mStableInsets != null) goto L6;
            this.mStableInsets = Insets.of(this.mPlatformInsets.getStableInsetLeft(), this.mPlatformInsets.getStableInsetTop(), this.mPlatformInsets.getStableInsetRight(), this.mPlatformInsets.getStableInsetBottom());
        L6:
            return this.mStableInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public boolean isConsumed() {
            return this.mPlatformInsets.isConsumed();
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public void setStableInsets(Insets r100) {
            this.mStableInsets = r100;
        }

        public Impl21(WindowInsetsCompat r100, Impl21 r101) {
            super(r100, r101);
            this.mStableInsets = null;
            this.mStableInsets = r101.mStableInsets;
        }

        public Impl21(WindowInsetsCompat r100, WindowInsets r101) {
            super(r100, r101);
            this.mStableInsets = null;
        }
    }

    public static class Impl28 extends Impl21 {
        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public WindowInsetsCompat consumeDisplayCutout() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeDisplayCutout());
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public DisplayCutoutCompat getDisplayCutout() {
            return DisplayCutoutCompat.wrap(this.mPlatformInsets.getDisplayCutout());
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public int hashCode() {
            return this.mPlatformInsets.hashCode();
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Impl28) == true) goto L8;
            return false;
        L8:
            Impl28 r101 = (Impl28) r100;
            if (Objects.equals(this.mPlatformInsets, r101.mPlatformInsets) == true) goto L11;
        L13:
            return false;
        L11:
            if (Objects.equals(this.mRootViewVisibleInsets, r101.mRootViewVisibleInsets) == false) goto L13;
            return true;
        }

        public Impl28(WindowInsetsCompat r100, WindowInsets r101) {
            super(r100, r101);
        }

        public Impl28(WindowInsetsCompat r100, Impl28 r101) {
            super(r100, r101);
        }
    }

    public static class Impl29 extends Impl28 {
        private Insets mMandatorySystemGestureInsets;
        private Insets mSystemGestureInsets;
        private Insets mTappableElementInsets;

        @Override // androidx.core.view.WindowInsetsCompat.Impl21, androidx.core.view.WindowInsetsCompat.Impl
        public void setStableInsets(Insets r100) {
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public Insets getMandatorySystemGestureInsets() {
            if (this.mMandatorySystemGestureInsets != null) goto L6;
            this.mMandatorySystemGestureInsets = Insets.toCompatInsets(this.mPlatformInsets.getMandatorySystemGestureInsets());
        L6:
            return this.mMandatorySystemGestureInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public Insets getSystemGestureInsets() {
            if (this.mSystemGestureInsets != null) goto L6;
            this.mSystemGestureInsets = Insets.toCompatInsets(this.mPlatformInsets.getSystemGestureInsets());
        L6:
            return this.mSystemGestureInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public Insets getTappableElementInsets() {
            if (this.mTappableElementInsets != null) goto L6;
            this.mTappableElementInsets = Insets.toCompatInsets(this.mPlatformInsets.getTappableElementInsets());
        L6:
            return this.mTappableElementInsets;
        }

        public Impl29(WindowInsetsCompat r100, WindowInsets r101) {
            super(r100, r101);
            this.mSystemGestureInsets = null;
            this.mMandatorySystemGestureInsets = null;
            this.mTappableElementInsets = null;
        }

        public Impl29(WindowInsetsCompat r100, Impl29 r101) {
            super(r100, r101);
            this.mSystemGestureInsets = null;
            this.mMandatorySystemGestureInsets = null;
            this.mTappableElementInsets = null;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        public WindowInsetsCompat inset(int r100, int r101, int r102, int r103) {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.inset(r100, r101, r102, r103));
        }
    }

    public static class Impl30 extends Impl29 {
        static final WindowInsetsCompat CONSUMED = null;

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        public final void copyRootViewBounds(View r100) {
        }

        static {
            CONSUMED = WindowInsetsCompat.toWindowInsetsCompat(WindowInsets.CONSUMED);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        public Insets getInsets(int r100) {
            return Insets.toCompatInsets(this.mPlatformInsets.getInsets(TypeImpl30.toPlatformType(r100)));
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        public Insets getInsetsIgnoringVisibility(int r100) {
            return Insets.toCompatInsets(this.mPlatformInsets.getInsetsIgnoringVisibility(TypeImpl30.toPlatformType(r100)));
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        public boolean isVisible(int r100) {
            return this.mPlatformInsets.isVisible(TypeImpl30.toPlatformType(r100));
        }

        public Impl30(WindowInsetsCompat r100, WindowInsets r101) {
            super(r100, r101);
        }

        public Impl30(WindowInsetsCompat r100, Impl30 r101) {
            super(r100, r101);
        }
    }

    public static final class Type {
        static final int CAPTION_BAR = 4;
        static final int DISPLAY_CUTOUT = 128;
        static final int FIRST = 1;
        static final int IME = 8;
        static final int LAST = 256;
        static final int MANDATORY_SYSTEM_GESTURES = 32;
        static final int NAVIGATION_BARS = 2;
        static final int SIZE = 9;
        static final int STATUS_BARS = 1;
        static final int SYSTEM_GESTURES = 16;
        static final int TAPPABLE_ELEMENT = 64;
        static final int WINDOW_DECOR = 256;

        @Retention(RetentionPolicy.SOURCE)
        public @interface InsetsType {
        }

        private Type() {
        }

        public static int all() {
            return -1;
        }

        public static int captionBar() {
            return 4;
        }

        public static int displayCutout() {
            return 128;
        }

        public static int ime() {
            return 8;
        }

        public static int mandatorySystemGestures() {
            return 32;
        }

        public static int navigationBars() {
            return 2;
        }

        public static int statusBars() {
            return 1;
        }

        public static int systemBars() {
            return 7;
        }

        public static int systemGestures() {
            return 16;
        }

        public static int tappableElement() {
            return 64;
        }

        public static int indexOf(int r100) {
            if (r100 != 1) goto L5;
            return 0;
        L5:
            if (r100 != 2) goto L7;
            return 1;
        L7:
            if (r100 != 4) goto L9;
            return 2;
        L9:
            if (r100 != 8) goto L11;
            return 3;
        L11:
            if (r100 != 16) goto L13;
            return 4;
        L13:
            if (r100 != 32) goto L15;
            return 5;
        L15:
            if (r100 != 64) goto L17;
            return 6;
        L17:
            if (r100 != 128) goto L19;
            return 7;
        L19:
            if (r100 != 256) goto L22;
            return 8;
        L22:
            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + r100);
        }
    }

    public static final class TypeImpl30 {
        private TypeImpl30() {
        }

        public static int toPlatformType(int r100) {
            int r101 = 0;
            int r102 = 1;
        L4:
            if (r102 > 256) goto L33;
            if ((r100 & r102) == 0) goto L32;
            if (r102 != 1) goto L9;
            int r103 = WindowInsets.Type.statusBars();
        L31:
            r101 = r101 | r103;
            goto L32
        L9:
            if (r102 != 2) goto L11;
            r103 = WindowInsets.Type.navigationBars();
            goto L31
        L11:
            if (r102 != 4) goto L13;
            r103 = WindowInsets.Type.captionBar();
            goto L31
        L13:
            if (r102 != 8) goto L15;
            r103 = WindowInsets.Type.ime();
            goto L31
        L15:
            if (r102 != 16) goto L17;
            r103 = WindowInsets.Type.systemGestures();
            goto L31
        L17:
            if (r102 != 32) goto L19;
            r103 = WindowInsets.Type.mandatorySystemGestures();
            goto L31
        L19:
            if (r102 != 64) goto L21;
            r103 = WindowInsets.Type.tappableElement();
            goto L31
        L21:
            if (r102 != 128) goto L32;
            r103 = WindowInsets.Type.displayCutout();
        L32:
            r102 = r102 << 1;
            goto L4
        L33:
            return r101;
        }
    }

    static {
        if (Build.VERSION.SDK_INT < 30) goto L5;
        CONSUMED = Impl30.CONSUMED;
        return;
    L5:
        CONSUMED = Impl.CONSUMED;
    }

    public WindowInsetsCompat consumeDisplayCutout() {
        return this.mImpl.consumeDisplayCutout();
    }

    public WindowInsetsCompat consumeStableInsets() {
        return this.mImpl.consumeStableInsets();
    }

    public WindowInsetsCompat consumeSystemWindowInsets() {
        return this.mImpl.consumeSystemWindowInsets();
    }

    public DisplayCutoutCompat getDisplayCutout() {
        return this.mImpl.getDisplayCutout();
    }

    public Insets getMandatorySystemGestureInsets() {
        return this.mImpl.getMandatorySystemGestureInsets();
    }

    public int getStableInsetBottom() {
        return this.mImpl.getStableInsets().bottom;
    }

    public int getStableInsetLeft() {
        return this.mImpl.getStableInsets().left;
    }

    public int getStableInsetRight() {
        return this.mImpl.getStableInsets().right;
    }

    public int getStableInsetTop() {
        return this.mImpl.getStableInsets().top;
    }

    public Insets getStableInsets() {
        return this.mImpl.getStableInsets();
    }

    public Insets getSystemGestureInsets() {
        return this.mImpl.getSystemGestureInsets();
    }

    public int getSystemWindowInsetBottom() {
        return this.mImpl.getSystemWindowInsets().bottom;
    }

    public int getSystemWindowInsetLeft() {
        return this.mImpl.getSystemWindowInsets().left;
    }

    public int getSystemWindowInsetRight() {
        return this.mImpl.getSystemWindowInsets().right;
    }

    public int getSystemWindowInsetTop() {
        return this.mImpl.getSystemWindowInsets().top;
    }

    public Insets getSystemWindowInsets() {
        return this.mImpl.getSystemWindowInsets();
    }

    public Insets getTappableElementInsets() {
        return this.mImpl.getTappableElementInsets();
    }

    public boolean hasStableInsets() {
        return !this.mImpl.getStableInsets().equals(Insets.NONE);
    }

    public boolean hasSystemWindowInsets() {
        return !this.mImpl.getSystemWindowInsets().equals(Insets.NONE);
    }

    public int hashCode() {
        Impl r100 = this.mImpl;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public boolean isConsumed() {
        return this.mImpl.isConsumed();
    }

    public boolean isRound() {
        return this.mImpl.isRound();
    }

    public WindowInsets toWindowInsets() {
        Impl r100 = this.mImpl;
        if ((r100 instanceof Impl20) == true) goto L7;
        return null;
    L7:
        return ((Impl20) r100).mPlatformInsets;
    }

    public boolean hasInsets() {
        Insets r100 = getInsets(Type.all());
        Insets r101 = Insets.NONE;
        if (r100.equals(r101) == true) goto L5;
    L10:
        return true;
    L5:
        if (getInsetsIgnoringVisibility(Type.all() ^ Type.ime()).equals(r101) == false) goto L10;
        if (getDisplayCutout() != null) goto L10;
        return false;
    }

    public WindowInsetsCompat(WindowInsetsCompat r100) {
        if (r100 == null) goto L27;
        Impl r101 = r100.mImpl;
        int r102 = Build.VERSION.SDK_INT;
        if (r102 < 30) goto L10;
        if ((r101 instanceof Impl30) == false) goto L10;
        this.mImpl = new Impl30(this, (Impl30) r101);
    L26:
        r101.copyWindowDataInto(this);
        return;
    L10:
        if (r102 < 29) goto L15;
        if ((r101 instanceof Impl29) == false) goto L15;
        this.mImpl = new Impl29(this, (Impl29) r101);
    L15:
        if (r102 < 28) goto L20;
        if ((r101 instanceof Impl28) == false) goto L20;
        this.mImpl = new Impl28(this, (Impl28) r101);
    L20:
        if ((r101 instanceof Impl21) == false) goto L23;
        this.mImpl = new Impl21(this, (Impl21) r101);
        goto L26
    L23:
        if ((r101 instanceof Impl20) == false) goto L25;
        this.mImpl = new Impl20(this, (Impl20) r101);
        goto L26
    L25:
        this.mImpl = new Impl(this);
        goto L26
    L27:
        this.mImpl = new Impl(this);
    }

    public static WindowInsetsCompat toWindowInsetsCompat(WindowInsets r100) {
        return toWindowInsetsCompat(r100, null);
    }

    public void copyRootViewBounds(View r100) {
        this.mImpl.copyRootViewBounds(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof WindowInsetsCompat) == true) goto L10;
        return false;
    L10:
        return ObjectsCompat.equals(this.mImpl, ((WindowInsetsCompat) r100).mImpl);
    }

    public Insets getInsets(int r100) {
        return this.mImpl.getInsets(r100);
    }

    public Insets getInsetsIgnoringVisibility(int r100) {
        return this.mImpl.getInsetsIgnoringVisibility(r100);
    }

    public WindowInsetsCompat inset(Insets r100) {
        return inset(r100.left, r100.top, r100.right, r100.bottom);
    }

    public boolean isVisible(int r100) {
        return this.mImpl.isVisible(r100);
    }

    public WindowInsetsCompat replaceSystemWindowInsets(Rect r100) {
        return new Builder(this).setSystemWindowInsets(Insets.of(r100)).build();
    }

    public void setOverriddenInsets(Insets[] r100) {
        this.mImpl.setOverriddenInsets(r100);
    }

    public void setRootViewData(Insets r100) {
        this.mImpl.setRootViewData(r100);
    }

    public void setRootWindowInsets(WindowInsetsCompat r100) {
        this.mImpl.setRootWindowInsets(r100);
    }

    public void setStableInsets(Insets r100) {
        this.mImpl.setStableInsets(r100);
    }

    private WindowInsetsCompat(WindowInsets r100) {
        int r101 = Build.VERSION.SDK_INT;
        if (r101 < 30) goto L6;
        this.mImpl = new Impl30(this, r100);
        return;
    L6:
        if (r101 < 29) goto L9;
        this.mImpl = new Impl29(this, r100);
        return;
    L9:
        if (r101 < 28) goto L11;
        this.mImpl = new Impl28(this, r100);
        return;
    L11:
        this.mImpl = new Impl21(this, r100);
    }

    public static WindowInsetsCompat toWindowInsetsCompat(WindowInsets r100, View r101) {
        WindowInsetsCompat r102 = new WindowInsetsCompat((WindowInsets) Preconditions.checkNotNull(r100));
        if (r101 != null) goto L5;
    L7:
        return r102;
    L5:
        if (r101.isAttachedToWindow() == false) goto L7;
        r102.setRootWindowInsets(ViewCompat.getRootWindowInsets(r101));
        r102.copyRootViewBounds(r101.getRootView());
        goto L7
    }

    public WindowInsetsCompat inset(int r100, int r101, int r102, int r103) {
        return this.mImpl.inset(r100, r101, r102, r103);
    }

    public WindowInsetsCompat replaceSystemWindowInsets(int r100, int r101, int r102, int r103) {
        return new Builder(this).setSystemWindowInsets(Insets.of(r100, r101, r102, r103)).build();
    }

    public static Insets insetInsets(Insets r100, int r101, int r102, int r103, int r104) {
        int r105 = Math.max(0, r100.left - r101);
        int r106 = Math.max(0, r100.top - r102);
        int r107 = Math.max(0, r100.right - r103);
        int r108 = Math.max(0, r100.bottom - r104);
        if (r105 != r101) goto L9;
        if (r106 != r102) goto L9;
        if (r107 != r103) goto L9;
        if (r108 != r104) goto L9;
        return r100;
    L9:
        return Insets.of(r105, r106, r107, r108);
    }
}
