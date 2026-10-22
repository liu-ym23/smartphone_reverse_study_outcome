package androidx.core.view;

import android.graphics.Rect;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import androidx.core.graphics.Insets;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class WindowInsetsCompat {
    public static final WindowInsetsCompat CONSUMED = null;
    private static final String TAG = "WindowInsetsCompat";
    private final Impl mImpl;

    static class Api21ReflectionHolder {
        private static Field sContentInsets;
        private static boolean sReflectionSucceeded;
        private static Field sStableInsets;
        private static Field sViewAttachInfoField;

        private Api21ReflectionHolder() {
        }

        static {
            Field r0 = View.class.getDeclaredField("mAttachInfo");     // Catch: ReflectiveOperationException -> L4
            sViewAttachInfoField = r0;     // Catch: ReflectiveOperationException -> L4
            r0.setAccessible(true);     // Catch: ReflectiveOperationException -> L4
            Class<?> r1 = Class.forName("android.view.View$AttachInfo");     // Catch: ReflectiveOperationException -> L4
            Field r2 = r1.getDeclaredField("mStableInsets");     // Catch: ReflectiveOperationException -> L4
            sStableInsets = r2;     // Catch: ReflectiveOperationException -> L4
            r2.setAccessible(true);     // Catch: ReflectiveOperationException -> L4
            Field r3 = r1.getDeclaredField("mContentInsets");     // Catch: ReflectiveOperationException -> L4
            sContentInsets = r3;     // Catch: ReflectiveOperationException -> L4
            r3.setAccessible(true);     // Catch: ReflectiveOperationException -> L4
            sReflectionSucceeded = true;     // Catch: ReflectiveOperationException -> L4
            return;
        L4:
            e = move-exception;
            Log.w(WindowInsetsCompat.TAG, "Failed to get visible insets from AttachInfo " + e.getMessage(), e);
        }

        public static WindowInsetsCompat getRootWindowInsets(View r4) {
            if (sReflectionSucceeded == true) goto L5;
        L17:
            return null;
        L5:
            if (r4.isAttachedToWindow() == false) goto L17;
            Object r0 = sViewAttachInfoField.get(r4.getRootView());     // Catch: IllegalAccessException -> L15
            if (r0 == null) goto L17;
            Rect r2 = (Rect) sStableInsets.get(r0);     // Catch: IllegalAccessException -> L15
            Rect r1 = (Rect) sContentInsets.get(r0);     // Catch: IllegalAccessException -> L15
            if (r2 == null) goto L17;
            if (r1 == null) goto L17;
            WindowInsetsCompat r3 = new Builder().setStableInsets(Insets.of(r2)).setSystemWindowInsets(Insets.of(r1)).build();     // Catch: IllegalAccessException -> L15
            r3.setRootWindowInsets(r3);     // Catch: IllegalAccessException -> L15
            r3.copyRootViewBounds(r4.getRootView());     // Catch: IllegalAccessException -> L15
            return r3;
        L15:
            e = move-exception;
            Log.w(WindowInsetsCompat.TAG, "Failed to get insets from AttachInfo. " + e.getMessage(), e);
            goto L17
        }
    }

    public static final class Builder {
        private final BuilderImpl mImpl;

        public Builder() {
            this.mImpl = new BuilderImpl30();
        }

        public Builder(WindowInsetsCompat r2) {
            this.mImpl = new BuilderImpl30(r2);
        }

        @Deprecated
        public Builder setSystemWindowInsets(Insets r2) {
            this.mImpl.setSystemWindowInsets(r2);
            return this;
        }

        @Deprecated
        public Builder setSystemGestureInsets(Insets r2) {
            this.mImpl.setSystemGestureInsets(r2);
            return this;
        }

        @Deprecated
        public Builder setMandatorySystemGestureInsets(Insets r2) {
            this.mImpl.setMandatorySystemGestureInsets(r2);
            return this;
        }

        @Deprecated
        public Builder setTappableElementInsets(Insets r2) {
            this.mImpl.setTappableElementInsets(r2);
            return this;
        }

        public Builder setInsets(int r2, Insets r3) {
            this.mImpl.setInsets(r2, r3);
            return this;
        }

        public Builder setInsetsIgnoringVisibility(int r2, Insets r3) {
            this.mImpl.setInsetsIgnoringVisibility(r2, r3);
            return this;
        }

        public Builder setVisible(int r2, boolean r3) {
            this.mImpl.setVisible(r2, r3);
            return this;
        }

        @Deprecated
        public Builder setStableInsets(Insets r2) {
            this.mImpl.setStableInsets(r2);
            return this;
        }

        public Builder setDisplayCutout(DisplayCutoutCompat r2) {
            this.mImpl.setDisplayCutout(r2);
            return this;
        }

        public WindowInsetsCompat build() {
            return this.mImpl.build();
        }
    }

    private static class BuilderImpl {
        private final WindowInsetsCompat mInsets;
        Insets[] mInsetsTypeMask;

        void setDisplayCutout(DisplayCutoutCompat r1) {
        }

        void setMandatorySystemGestureInsets(Insets r1) {
        }

        void setStableInsets(Insets r1) {
        }

        void setSystemGestureInsets(Insets r1) {
        }

        void setSystemWindowInsets(Insets r1) {
        }

        void setTappableElementInsets(Insets r1) {
        }

        void setVisible(int r1, boolean r2) {
        }

        BuilderImpl() {
            WindowInsetsCompat r2 = (WindowInsetsCompat) null;
            this(new WindowInsetsCompat(null));
        }

        BuilderImpl(WindowInsetsCompat r1) {
            this.mInsets = r1;
        }

        void setInsets(int r4, Insets r5) {
            if (this.mInsetsTypeMask != null) goto L5;
            this.mInsetsTypeMask = new Insets[9];
        L5:
            int r0 = 1;
        L7:
            if (r0 > 256) goto L13;
            if ((r4 & r0) == 0) goto L12;
            this.mInsetsTypeMask[Type.indexOf(r0)] = r5;
        L12:
            r0 = r0 << 1;
            goto L7
        }

        void setInsetsIgnoringVisibility(int r1, Insets r2) {
            if (r1 == 8) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("Ignoring visibility inset not available for IME");
        }

        protected final void applyInsetTypes() {
            Insets[] r0 = this.mInsetsTypeMask;
            if (r0 == null) goto L19;
            Insets r1 = r0[Type.indexOf(1)];
            Insets r2 = this.mInsetsTypeMask[Type.indexOf(2)];
            if (r2 != null) goto L7;
            r2 = this.mInsets.getInsets(2);
        L7:
            if (r1 != null) goto L9;
            r1 = this.mInsets.getInsets(1);
        L9:
            setSystemWindowInsets(Insets.max(r1, r2));
            Insets r3 = this.mInsetsTypeMask[Type.indexOf(16)];
            if (r3 == null) goto L12;
            setSystemGestureInsets(r3);
        L12:
            Insets r4 = this.mInsetsTypeMask[Type.indexOf(32)];
            if (r4 == null) goto L15;
            setMandatorySystemGestureInsets(r4);
        L15:
            Insets r5 = this.mInsetsTypeMask[Type.indexOf(64)];
            if (r5 == null) goto L20;
            setTappableElementInsets(r5);
            return;
        L20:
            return;
        }

        WindowInsetsCompat build() {
            applyInsetTypes();
            return this.mInsets;
        }
    }

    private static class BuilderImpl20 extends BuilderImpl {
        private static Constructor<WindowInsets> sConstructor = null;
        private static boolean sConstructorFetched = false;
        private static Field sConsumedField = null;
        private static boolean sConsumedFieldFetched = false;
        private WindowInsets mPlatformInsets;
        private Insets mStableInsets;

        static {
        }

        BuilderImpl20() {
            this.mPlatformInsets = createWindowInsetsInstance();
        }

        BuilderImpl20(WindowInsetsCompat r1) {
            super(r1);
            this.mPlatformInsets = r1.toWindowInsets();
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void setSystemWindowInsets(Insets r5) {
            WindowInsets r0 = this.mPlatformInsets;
            if (r0 == null) goto L6;
            this.mPlatformInsets = r0.replaceSystemWindowInsets(r5.left, r5.top, r5.right, r5.bottom);
            return;
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void setStableInsets(Insets r1) {
            this.mStableInsets = r1;
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        WindowInsetsCompat build() {
            applyInsetTypes();
            WindowInsetsCompat r0 = WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets);
            r0.setOverriddenInsets(this.mInsetsTypeMask);
            r0.setStableInsets(this.mStableInsets);
            return r0;
        }

        private static WindowInsets createWindowInsetsInstance() {
            if (sConsumedFieldFetched == false) goto L33;
        L9:
            Field r0 = sConsumedField;
            if (r0 == null) goto L18;
            WindowInsets r1 = (WindowInsets) r0.get(null);     // Catch: ReflectiveOperationException -> L15
            if (r1 == null) goto L18;
            return new WindowInsets(r1);
        L15:
            e = move-exception;
            Log.i(WindowInsetsCompat.TAG, "Could not get value from WindowInsets.CONSUMED field", e);
        L18:
            if (sConstructorFetched == false) goto L37;
        L24:
            Constructor<WindowInsets> r2 = sConstructor;
            if (r2 != null) goto L31;
        L30:
            return null;
        L31:
            return r2.newInstance(new Object[]{new Rect()});
        L28:
            e = move-exception;
            Log.i(WindowInsetsCompat.TAG, "Could not invoke WindowInsets(Rect) constructor", e);
            goto L30
        L37:
            sConstructor = WindowInsets.class.getConstructor(new Class[]{Rect.class});     // Catch: ReflectiveOperationException -> L21
        L23:
            sConstructorFetched = true;
        L21:
            e = move-exception;
            Log.i(WindowInsetsCompat.TAG, "Could not retrieve WindowInsets(Rect) constructor", e);
            goto L23
        L33:
            sConsumedField = WindowInsets.class.getDeclaredField("CONSUMED");     // Catch: ReflectiveOperationException -> L6
        L8:
            sConsumedFieldFetched = true;
        L6:
            e = move-exception;
            Log.i(WindowInsetsCompat.TAG, "Could not retrieve WindowInsets.CONSUMED field", e);
            goto L8
        }
    }

    private static class BuilderImpl29 extends BuilderImpl {
        final WindowInsets.Builder mPlatBuilder;

        BuilderImpl29() {
            this.mPlatBuilder = new WindowInsets.Builder();
        }

        BuilderImpl29(WindowInsetsCompat r2) {
            super(r2);
            WindowInsets r3 = r2.toWindowInsets();
            if (r3 == null) goto L5;
            WindowInsets.Builder r0 = new WindowInsets.Builder(r3);
        L6:
            this.mPlatBuilder = r0;
            return;
        L5:
            r0 = new WindowInsets.Builder();
            goto L6
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void setSystemWindowInsets(Insets r1) {
            this.mPlatBuilder.setSystemWindowInsets(r1.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void setSystemGestureInsets(Insets r1) {
            this.mPlatBuilder.setSystemGestureInsets(r1.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void setMandatorySystemGestureInsets(Insets r1) {
            this.mPlatBuilder.setMandatorySystemGestureInsets(r1.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void setTappableElementInsets(Insets r1) {
            this.mPlatBuilder.setTappableElementInsets(r1.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void setStableInsets(Insets r1) {
            this.mPlatBuilder.setStableInsets(r1.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void setDisplayCutout(DisplayCutoutCompat r1) {
            WindowInsets.Builder r0 = this.mPlatBuilder;
            if (r1 == null) goto L5;
            DisplayCutout r2 = r1.unwrap();
        L6:
            r0.setDisplayCutout(r2);
            return;
        L5:
            r2 = null;
            goto L6
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        WindowInsetsCompat build() {
            applyInsetTypes();
            WindowInsetsCompat r0 = WindowInsetsCompat.toWindowInsetsCompat(this.mPlatBuilder.build());
            r0.setOverriddenInsets(this.mInsetsTypeMask);
            return r0;
        }
    }

    private static class BuilderImpl30 extends BuilderImpl29 {
        BuilderImpl30() {
        }

        BuilderImpl30(WindowInsetsCompat r1) {
            super(r1);
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void setInsets(int r1, Insets r2) {
            this.mPlatBuilder.setInsets(TypeImpl30.toPlatformType(r1), r2.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void setInsetsIgnoringVisibility(int r1, Insets r2) {
            this.mPlatBuilder.setInsetsIgnoringVisibility(TypeImpl30.toPlatformType(r1), r2.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void setVisible(int r1, boolean r2) {
            this.mPlatBuilder.setVisible(TypeImpl30.toPlatformType(r1), r2);
        }
    }

    private static class Impl {
        static final WindowInsetsCompat CONSUMED = null;
        final WindowInsetsCompat mHost;

        void copyRootViewBounds(View r1) {
        }

        void copyWindowDataInto(WindowInsetsCompat r1) {
        }

        DisplayCutoutCompat getDisplayCutout() {
            return null;
        }

        boolean isConsumed() {
            return false;
        }

        boolean isRound() {
            return false;
        }

        boolean isVisible(int r1) {
            return true;
        }

        public void setOverriddenInsets(Insets[] r1) {
        }

        void setRootViewData(Insets r1) {
        }

        void setRootWindowInsets(WindowInsetsCompat r1) {
        }

        public void setStableInsets(Insets r1) {
        }

        static {
            CONSUMED = new Builder().build().consumeDisplayCutout().consumeStableInsets().consumeSystemWindowInsets();
        }

        Impl(WindowInsetsCompat r1) {
            this.mHost = r1;
        }

        WindowInsetsCompat consumeSystemWindowInsets() {
            return this.mHost;
        }

        WindowInsetsCompat consumeStableInsets() {
            return this.mHost;
        }

        WindowInsetsCompat consumeDisplayCutout() {
            return this.mHost;
        }

        Insets getSystemWindowInsets() {
            return Insets.NONE;
        }

        Insets getStableInsets() {
            return Insets.NONE;
        }

        Insets getSystemGestureInsets() {
            return getSystemWindowInsets();
        }

        Insets getMandatorySystemGestureInsets() {
            return getSystemWindowInsets();
        }

        Insets getTappableElementInsets() {
            return getSystemWindowInsets();
        }

        WindowInsetsCompat inset(int r1, int r2, int r3, int r4) {
            return CONSUMED;
        }

        Insets getInsets(int r1) {
            return Insets.NONE;
        }

        Insets getInsetsIgnoringVisibility(int r1) {
            if ((r1 & 8) != 0) goto L7;
            return Insets.NONE;
        L7:
            throw new IllegalArgumentException("Unable to query the maximum insets for IME");
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof Impl) == true) goto L8;
            return false;
        L8:
            Impl r6 = (Impl) r5;
            if (isRound() != r6.isRound()) goto L20;
            if (isConsumed() != r6.isConsumed()) goto L20;
            if (ObjectsCompat.equals(getSystemWindowInsets(), r6.getSystemWindowInsets()) == false) goto L20;
            if (ObjectsCompat.equals(getStableInsets(), r6.getStableInsets()) == false) goto L20;
            if (ObjectsCompat.equals(getDisplayCutout(), r6.getDisplayCutout()) == false) goto L20;
            return true;
        L20:
            return false;
        }

        public int hashCode() {
            return ObjectsCompat.hash(new Object[]{Boolean.valueOf(isRound()), Boolean.valueOf(isConsumed()), getSystemWindowInsets(), getStableInsets(), getDisplayCutout()});
        }
    }

    private static class Impl20 extends Impl {
        private static Class<?> sAttachInfoClass = null;
        private static Field sAttachInfoField = null;
        private static Method sGetViewRootImplMethod = null;
        private static Field sVisibleInsetsField = null;
        private static boolean sVisibleRectReflectionFetched = false;
        private Insets[] mOverriddenInsets;
        final WindowInsets mPlatformInsets;
        Insets mRootViewVisibleInsets;
        private WindowInsetsCompat mRootWindowInsets;
        private Insets mSystemWindowInsets;

        static {
        }

        Impl20(WindowInsetsCompat r1, WindowInsets r2) {
            super(r1);
            this.mSystemWindowInsets = null;
            this.mPlatformInsets = r2;
        }

        Impl20(WindowInsetsCompat r2, Impl20 r3) {
            this(r2, new WindowInsets(r3.mPlatformInsets));
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        boolean isRound() {
            return this.mPlatformInsets.isRound();
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public Insets getInsets(int r2) {
            return getInsets(r2, false);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public Insets getInsetsIgnoringVisibility(int r2) {
            return getInsets(r2, true);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        boolean isVisible(int r4) {
            int r1 = 1;
        L4:
            if (r1 > 256) goto L13;
            if ((r4 & r1) == 0) goto L12;
            if (isTypeVisible(r1) == true) goto L12;
            return false;
        L12:
            r1 = r1 << 1;
            goto L4
        L13:
            return true;
        }

        private Insets getInsets(int r4, boolean r5) {
            Insets r0 = Insets.NONE;
            int r1 = 1;
        L4:
            if (r1 > 256) goto L10;
            if ((r4 & r1) == 0) goto L9;
            r0 = Insets.max(r0, getInsetsForType(r1, r5));
        L9:
            r1 = r1 << 1;
            goto L4
        L10:
            return r0;
        }

        protected Insets getInsetsForType(int r4, boolean r5) {
            if (r4 == 1) goto L63;
            Insets r2 = null;
            if (r4 != 2) goto L7;
            if (r5 == false) goto L55;
            Insets r6 = getRootStableInsets();
            Insets r3 = getStableInsets();
            return Insets.of(Math.max(r6.left, r3.left), 0, Math.max(r6.right, r3.right), Math.max(r6.bottom, r3.bottom));
        L55:
            Insets r7 = getSystemWindowInsets();
            WindowInsetsCompat r8 = this.mRootWindowInsets;
            if (r8 == null) goto L58;
            r2 = r8.getStableInsets();
        L58:
            int r9 = r7.bottom;
            if (r2 == null) goto L62;
            r9 = Math.min(r9, r2.bottom);
        L62:
            return Insets.of(r7.left, 0, r7.right, r9);
        L7:
            if (r4 != 8) goto L9;
            Insets[] r10 = this.mOverriddenInsets;
            if (r10 == null) goto L36;
            r2 = r10[Type.indexOf(8)];
        L36:
            if (r2 == null) goto L38;
            return r2;
        L38:
            Insets r11 = getSystemWindowInsets();
            Insets r12 = getRootStableInsets();
            if (r11.bottom > r12.bottom) goto L41;
            Insets r13 = this.mRootViewVisibleInsets;
            if (r13 == null) goto L51;
            if (r13.equals(Insets.NONE) == true) goto L51;
            if (this.mRootViewVisibleInsets.bottom <= r12.bottom) goto L51;
            return Insets.of(0, 0, 0, this.mRootViewVisibleInsets.bottom);
        L51:
            return Insets.NONE;
        L41:
            return Insets.of(0, 0, 0, r11.bottom);
        L9:
            if (r4 == 16) goto L32;
            if (r4 == 32) goto L30;
            if (r4 == 64) goto L28;
            if (r4 != 128) goto L17;
            WindowInsetsCompat r14 = this.mRootWindowInsets;
            if (r14 == null) goto L21;
            DisplayCutoutCompat r15 = r14.getDisplayCutout();
        L22:
            if (r15 == null) goto L26;
            return Insets.of(r15.getSafeInsetLeft(), r15.getSafeInsetTop(), r15.getSafeInsetRight(), r15.getSafeInsetBottom());
        L26:
            return Insets.NONE;
        L21:
            r15 = getDisplayCutout();
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
            if (r5 == false) goto L67;
            return Insets.of(0, Math.max(getRootStableInsets().top, getSystemWindowInsets().top), 0, 0);
        L67:
            return Insets.of(0, getSystemWindowInsets().top, 0, 0);
        }

        protected boolean isTypeVisible(int r4) {
            if (r4 == 1) goto L15;
            if (r4 == 2) goto L15;
            if (r4 != 4) goto L9;
            return false;
        L9:
            if (r4 == 8) goto L15;
            if (r4 == 128) goto L15;
            return true;
        L15:
            return !getInsetsForType(r4, false).equals(Insets.NONE);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        final Insets getSystemWindowInsets() {
            if (this.mSystemWindowInsets != null) goto L6;
            this.mSystemWindowInsets = Insets.of(this.mPlatformInsets.getSystemWindowInsetLeft(), this.mPlatformInsets.getSystemWindowInsetTop(), this.mPlatformInsets.getSystemWindowInsetRight(), this.mPlatformInsets.getSystemWindowInsetBottom());
        L6:
            return this.mSystemWindowInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        WindowInsetsCompat inset(int r3, int r4, int r5, int r6) {
            Builder r0 = new Builder(WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets));
            r0.setSystemWindowInsets(WindowInsetsCompat.insetInsets(getSystemWindowInsets(), r3, r4, r5, r6));
            r0.setStableInsets(WindowInsetsCompat.insetInsets(getStableInsets(), r3, r4, r5, r6));
            return r0.build();
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        void copyWindowDataInto(WindowInsetsCompat r2) {
            r2.setRootWindowInsets(this.mRootWindowInsets);
            r2.setRootViewData(this.mRootViewVisibleInsets);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        void setRootWindowInsets(WindowInsetsCompat r1) {
            this.mRootWindowInsets = r1;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        void setRootViewData(Insets r1) {
            this.mRootViewVisibleInsets = r1;
        }

        private Insets getRootStableInsets() {
            WindowInsetsCompat r0 = this.mRootWindowInsets;
            if (r0 == null) goto L7;
            return r0.getStableInsets();
        L7:
            return Insets.NONE;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        void copyRootViewBounds(View r1) {
            Insets r2 = getVisibleInsets(r1);
            if (r2 != null) goto L5;
            r2 = Insets.NONE;
        L5:
            setRootViewData(r2);
        }

        private Insets getVisibleInsets(View r1) {
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public void setOverriddenInsets(Insets[] r1) {
            this.mOverriddenInsets = r1;
        }

        private static void loadReflectionField() {
            sGetViewRootImplMethod = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);     // Catch: ReflectiveOperationException -> L5
            Class<?> r1 = Class.forName("android.view.View$AttachInfo");     // Catch: ReflectiveOperationException -> L5
            sAttachInfoClass = r1;     // Catch: ReflectiveOperationException -> L5
            sVisibleInsetsField = r1.getDeclaredField("mVisibleInsets");     // Catch: ReflectiveOperationException -> L5
            sAttachInfoField = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");     // Catch: ReflectiveOperationException -> L5
            sVisibleInsetsField.setAccessible(true);     // Catch: ReflectiveOperationException -> L5
            sAttachInfoField.setAccessible(true);     // Catch: ReflectiveOperationException -> L5
        L7:
            sVisibleRectReflectionFetched = true;
            return;
        L5:
            e = move-exception;
            Log.e(WindowInsetsCompat.TAG, "Failed to get visible insets. (Reflection error). " + e.getMessage(), e);
            goto L7
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public boolean equals(Object r2) {
            if (super.equals(r2) == true) goto L7;
            return false;
        L7:
            return Objects.equals(this.mRootViewVisibleInsets, ((Impl20) r2).mRootViewVisibleInsets);
        }
    }

    private static class Impl21 extends Impl20 {
        private Insets mStableInsets;

        Impl21(WindowInsetsCompat r1, WindowInsets r2) {
            super(r1, r2);
            this.mStableInsets = null;
        }

        Impl21(WindowInsetsCompat r1, Impl21 r2) {
            super(r1, r2);
            this.mStableInsets = null;
            this.mStableInsets = r2.mStableInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        boolean isConsumed() {
            return this.mPlatformInsets.isConsumed();
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        WindowInsetsCompat consumeStableInsets() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeStableInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        WindowInsetsCompat consumeSystemWindowInsets() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeSystemWindowInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        final Insets getStableInsets() {
            if (this.mStableInsets != null) goto L6;
            this.mStableInsets = Insets.of(this.mPlatformInsets.getStableInsetLeft(), this.mPlatformInsets.getStableInsetTop(), this.mPlatformInsets.getStableInsetRight(), this.mPlatformInsets.getStableInsetBottom());
        L6:
            return this.mStableInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public void setStableInsets(Insets r1) {
            this.mStableInsets = r1;
        }
    }

    private static class Impl28 extends Impl21 {
        Impl28(WindowInsetsCompat r1, WindowInsets r2) {
            super(r1, r2);
        }

        Impl28(WindowInsetsCompat r1, Impl28 r2) {
            super(r1, r2);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        DisplayCutoutCompat getDisplayCutout() {
            return DisplayCutoutCompat.wrap(this.mPlatformInsets.getDisplayCutout());
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        WindowInsetsCompat consumeDisplayCutout() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeDisplayCutout());
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof Impl28) == true) goto L8;
            return false;
        L8:
            Impl28 r6 = (Impl28) r5;
            if (Objects.equals(this.mPlatformInsets, r6.mPlatformInsets) == false) goto L14;
            if (Objects.equals(this.mRootViewVisibleInsets, r6.mRootViewVisibleInsets) == false) goto L14;
            return true;
        L14:
            return false;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public int hashCode() {
            return this.mPlatformInsets.hashCode();
        }
    }

    private static class Impl29 extends Impl28 {
        private Insets mMandatorySystemGestureInsets;
        private Insets mSystemGestureInsets;
        private Insets mTappableElementInsets;

        @Override // androidx.core.view.WindowInsetsCompat.Impl21, androidx.core.view.WindowInsetsCompat.Impl
        public void setStableInsets(Insets r1) {
        }

        Impl29(WindowInsetsCompat r1, WindowInsets r2) {
            super(r1, r2);
            this.mSystemGestureInsets = null;
            this.mMandatorySystemGestureInsets = null;
            this.mTappableElementInsets = null;
        }

        Impl29(WindowInsetsCompat r1, Impl29 r2) {
            super(r1, r2);
            this.mSystemGestureInsets = null;
            this.mMandatorySystemGestureInsets = null;
            this.mTappableElementInsets = null;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        Insets getSystemGestureInsets() {
            if (this.mSystemGestureInsets != null) goto L6;
            this.mSystemGestureInsets = Insets.toCompatInsets(this.mPlatformInsets.getSystemGestureInsets());
        L6:
            return this.mSystemGestureInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        Insets getMandatorySystemGestureInsets() {
            if (this.mMandatorySystemGestureInsets != null) goto L6;
            this.mMandatorySystemGestureInsets = Insets.toCompatInsets(this.mPlatformInsets.getMandatorySystemGestureInsets());
        L6:
            return this.mMandatorySystemGestureInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        Insets getTappableElementInsets() {
            if (this.mTappableElementInsets != null) goto L6;
            this.mTappableElementInsets = Insets.toCompatInsets(this.mPlatformInsets.getTappableElementInsets());
        L6:
            return this.mTappableElementInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        WindowInsetsCompat inset(int r1, int r2, int r3, int r4) {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.inset(r1, r2, r3, r4));
        }
    }

    private static class Impl30 extends Impl29 {
        static final WindowInsetsCompat CONSUMED = null;

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        final void copyRootViewBounds(View r1) {
        }

        static {
            CONSUMED = WindowInsetsCompat.toWindowInsetsCompat(WindowInsets.CONSUMED);
        }

        Impl30(WindowInsetsCompat r1, WindowInsets r2) {
            super(r1, r2);
        }

        Impl30(WindowInsetsCompat r1, Impl30 r2) {
            super(r1, r2);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        public Insets getInsets(int r1) {
            return Insets.toCompatInsets(this.mPlatformInsets.getInsets(TypeImpl30.toPlatformType(r1)));
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        public Insets getInsetsIgnoringVisibility(int r1) {
            return Insets.toCompatInsets(this.mPlatformInsets.getInsetsIgnoringVisibility(TypeImpl30.toPlatformType(r1)));
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        public boolean isVisible(int r1) {
            return this.mPlatformInsets.isVisible(TypeImpl30.toPlatformType(r1));
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

        static int all() {
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

        private Type() {
        }

        static int indexOf(int r3) {
            if (r3 != 1) goto L5;
            return 0;
        L5:
            if (r3 != 2) goto L7;
            return 1;
        L7:
            if (r3 != 4) goto L9;
            return 2;
        L9:
            if (r3 != 8) goto L11;
            return 3;
        L11:
            if (r3 != 16) goto L13;
            return 4;
        L13:
            if (r3 != 32) goto L15;
            return 5;
        L15:
            if (r3 != 64) goto L17;
            return 6;
        L17:
            if (r3 != 128) goto L19;
            return 7;
        L19:
            if (r3 != 256) goto L22;
            return 8;
        L22:
            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + r3);
        }
    }

    private static final class TypeImpl30 {
        private TypeImpl30() {
        }

        static int toPlatformType(int r4) {
            int r0 = 0;
            int r2 = 1;
        L4:
            if (r2 > 256) goto L33;
            if ((r4 & r2) == 0) goto L32;
            if (r2 != 1) goto L9;
            int r3 = WindowInsets.Type.statusBars();
        L31:
            r0 = r0 | r3;
            goto L32
        L9:
            if (r2 != 2) goto L11;
            r3 = WindowInsets.Type.navigationBars();
            goto L31
        L11:
            if (r2 != 4) goto L13;
            r3 = WindowInsets.Type.captionBar();
            goto L31
        L13:
            if (r2 != 8) goto L15;
            r3 = WindowInsets.Type.ime();
            goto L31
        L15:
            if (r2 != 16) goto L17;
            r3 = WindowInsets.Type.systemGestures();
            goto L31
        L17:
            if (r2 != 32) goto L19;
            r3 = WindowInsets.Type.mandatorySystemGestures();
            goto L31
        L19:
            if (r2 != 64) goto L21;
            r3 = WindowInsets.Type.tappableElement();
            goto L31
        L21:
            if (r2 != 128) goto L32;
            r3 = WindowInsets.Type.displayCutout();
        L32:
            r2 = r2 << 1;
            goto L4
        L33:
            return r0;
        }
    }

    static {
        CONSUMED = Impl30.CONSUMED;
    }

    private WindowInsetsCompat(WindowInsets r2) {
        this.mImpl = new Impl30(this, r2);
    }

    public WindowInsetsCompat(WindowInsetsCompat r3) {
        if (r3 == null) goto L21;
        Impl r4 = r3.mImpl;
        if ((r4 instanceof Impl30) == false) goto L8;
        this.mImpl = new Impl30(this, (Impl30) r4);
    L20:
        r4.copyWindowDataInto(this);
        return;
    L8:
        if ((r4 instanceof Impl29) == false) goto L11;
        this.mImpl = new Impl29(this, (Impl29) r4);
        goto L20
    L11:
        if ((r4 instanceof Impl28) == false) goto L14;
        this.mImpl = new Impl28(this, (Impl28) r4);
        goto L20
    L14:
        if ((r4 instanceof Impl21) == false) goto L17;
        this.mImpl = new Impl21(this, (Impl21) r4);
        goto L20
    L17:
        if ((r4 instanceof Impl20) == false) goto L19;
        this.mImpl = new Impl20(this, (Impl20) r4);
        goto L20
    L19:
        this.mImpl = new Impl(this);
        goto L20
    L21:
        this.mImpl = new Impl(this);
    }

    public static WindowInsetsCompat toWindowInsetsCompat(WindowInsets r1) {
        return toWindowInsetsCompat(r1, null);
    }

    public static WindowInsetsCompat toWindowInsetsCompat(WindowInsets r1, View r2) {
        WindowInsetsCompat r0 = new WindowInsetsCompat((WindowInsets) Preconditions.checkNotNull(r1));
        if (r2 != null) goto L5;
    L7:
        return r0;
    L5:
        if (ViewCompat.isAttachedToWindow(r2) == false) goto L7;
        r0.setRootWindowInsets(ViewCompat.getRootWindowInsets(r2));
        r0.copyRootViewBounds(r2.getRootView());
        goto L7
    }

    @Deprecated
    public int getSystemWindowInsetLeft() {
        return this.mImpl.getSystemWindowInsets().left;
    }

    @Deprecated
    public int getSystemWindowInsetTop() {
        return this.mImpl.getSystemWindowInsets().top;
    }

    @Deprecated
    public int getSystemWindowInsetRight() {
        return this.mImpl.getSystemWindowInsets().right;
    }

    @Deprecated
    public int getSystemWindowInsetBottom() {
        return this.mImpl.getSystemWindowInsets().bottom;
    }

    @Deprecated
    public boolean hasSystemWindowInsets() {
        return !this.mImpl.getSystemWindowInsets().equals(Insets.NONE);
    }

    public boolean hasInsets() {
        if (getInsets(Type.all()).equals(Insets.NONE) == true) goto L5;
    L10:
        return true;
    L5:
        if (getInsetsIgnoringVisibility(Type.all() ^ Type.ime()).equals(Insets.NONE) == false) goto L10;
        if (getDisplayCutout() != null) goto L10;
        return false;
    }

    public boolean isConsumed() {
        return this.mImpl.isConsumed();
    }

    public boolean isRound() {
        return this.mImpl.isRound();
    }

    @Deprecated
    public WindowInsetsCompat consumeSystemWindowInsets() {
        return this.mImpl.consumeSystemWindowInsets();
    }

    @Deprecated
    public WindowInsetsCompat replaceSystemWindowInsets(int r2, int r3, int r4, int r5) {
        return new Builder(this).setSystemWindowInsets(Insets.of(r2, r3, r4, r5)).build();
    }

    @Deprecated
    public WindowInsetsCompat replaceSystemWindowInsets(Rect r2) {
        return new Builder(this).setSystemWindowInsets(Insets.of(r2)).build();
    }

    @Deprecated
    public int getStableInsetTop() {
        return this.mImpl.getStableInsets().top;
    }

    @Deprecated
    public int getStableInsetLeft() {
        return this.mImpl.getStableInsets().left;
    }

    @Deprecated
    public int getStableInsetRight() {
        return this.mImpl.getStableInsets().right;
    }

    @Deprecated
    public int getStableInsetBottom() {
        return this.mImpl.getStableInsets().bottom;
    }

    @Deprecated
    public boolean hasStableInsets() {
        return !this.mImpl.getStableInsets().equals(Insets.NONE);
    }

    @Deprecated
    public WindowInsetsCompat consumeStableInsets() {
        return this.mImpl.consumeStableInsets();
    }

    public DisplayCutoutCompat getDisplayCutout() {
        return this.mImpl.getDisplayCutout();
    }

    @Deprecated
    public WindowInsetsCompat consumeDisplayCutout() {
        return this.mImpl.consumeDisplayCutout();
    }

    @Deprecated
    public Insets getSystemWindowInsets() {
        return this.mImpl.getSystemWindowInsets();
    }

    @Deprecated
    public Insets getStableInsets() {
        return this.mImpl.getStableInsets();
    }

    @Deprecated
    public Insets getMandatorySystemGestureInsets() {
        return this.mImpl.getMandatorySystemGestureInsets();
    }

    @Deprecated
    public Insets getTappableElementInsets() {
        return this.mImpl.getTappableElementInsets();
    }

    @Deprecated
    public Insets getSystemGestureInsets() {
        return this.mImpl.getSystemGestureInsets();
    }

    public WindowInsetsCompat inset(Insets r4) {
        return inset(r4.left, r4.top, r4.right, r4.bottom);
    }

    public WindowInsetsCompat inset(int r1, int r2, int r3, int r4) {
        return this.mImpl.inset(r1, r2, r3, r4);
    }

    public Insets getInsets(int r1) {
        return this.mImpl.getInsets(r1);
    }

    public Insets getInsetsIgnoringVisibility(int r1) {
        return this.mImpl.getInsetsIgnoringVisibility(r1);
    }

    public boolean isVisible(int r1) {
        return this.mImpl.isVisible(r1);
    }

    public boolean equals(Object r2) {
        if (this != r2) goto L6;
        return true;
    L6:
        if ((r2 instanceof WindowInsetsCompat) == true) goto L10;
        return false;
    L10:
        return ObjectsCompat.equals(this.mImpl, ((WindowInsetsCompat) r2).mImpl);
    }

    public int hashCode() {
        Impl r0 = this.mImpl;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public WindowInsets toWindowInsets() {
        Impl r1 = this.mImpl;
        if ((r1 instanceof Impl20) == true) goto L7;
        return null;
    L7:
        return ((Impl20) r1).mPlatformInsets;
    }

    static Insets insetInsets(Insets r5, int r6, int r7, int r8, int r9) {
        int r0 = Math.max(0, r5.left - r6);
        int r2 = Math.max(0, r5.top - r7);
        int r3 = Math.max(0, r5.right - r8);
        int r1 = Math.max(0, r5.bottom - r9);
        if (r0 != r6) goto L9;
        if (r2 != r7) goto L9;
        if (r3 != r8) goto L9;
        if (r1 != r9) goto L9;
        return r5;
    L9:
        return Insets.of(r0, r2, r3, r1);
    }

    void setOverriddenInsets(Insets[] r1) {
        this.mImpl.setOverriddenInsets(r1);
    }

    void setStableInsets(Insets r1) {
        this.mImpl.setStableInsets(r1);
    }

    void setRootWindowInsets(WindowInsetsCompat r1) {
        this.mImpl.setRootWindowInsets(r1);
    }

    void setRootViewData(Insets r1) {
        this.mImpl.setRootViewData(r1);
    }

    void copyRootViewBounds(View r1) {
        this.mImpl.copyRootViewBounds(r1);
    }
}
