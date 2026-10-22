package androidx.core.app;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes17.dex */
public class ActivityOptionsCompat {
    public static final String EXTRA_USAGE_TIME_REPORT = "android.activity.usage_time";
    public static final String EXTRA_USAGE_TIME_REPORT_PACKAGES = "android.usage_time_packages";

    public static class ActivityOptionsCompatImpl extends ActivityOptionsCompat {
        private final ActivityOptions mActivityOptions;

        @Override // androidx.core.app.ActivityOptionsCompat
        public Rect getLaunchBounds() {
            if (Build.VERSION.SDK_INT >= 24) goto L7;
            return null;
        L7:
            return Api24Impl.getLaunchBounds(this.mActivityOptions);
        }

        @Override // androidx.core.app.ActivityOptionsCompat
        public Bundle toBundle() {
            return this.mActivityOptions.toBundle();
        }

        public ActivityOptionsCompatImpl(ActivityOptions r100) {
            this.mActivityOptions = r100;
        }

        @Override // androidx.core.app.ActivityOptionsCompat
        public void requestUsageTimeReport(PendingIntent r100) {
            if (Build.VERSION.SDK_INT < 23) goto L6;
            Api23Impl.requestUsageTimeReport(this.mActivityOptions, r100);
            return;
        }

        @Override // androidx.core.app.ActivityOptionsCompat
        public ActivityOptionsCompat setLaunchBounds(Rect r100) {
            if (Build.VERSION.SDK_INT >= 24) goto L6;
            return this;
        L6:
            return new ActivityOptionsCompatImpl(Api24Impl.setLaunchBounds(this.mActivityOptions, r100));
        }

        @Override // androidx.core.app.ActivityOptionsCompat
        public ActivityOptionsCompat setPendingIntentBackgroundActivityStartMode(int r100) {
            int r101 = Build.VERSION.SDK_INT;
            if (r101 < 34) goto L6;
            Api34Impl.setPendingIntentBackgroundActivityStartMode(this.mActivityOptions, r100);
        L12:
            return this;
        L6:
            if (r101 < 33) goto L12;
            if (r100 == 2) goto L10;
            boolean r102 = true;
        L11:
            Api33Impl.setPendingIntentBackgroundActivityLaunchAllowed(this.mActivityOptions, r102);
            goto L12
        L10:
            r102 = false;
            goto L11
        }

        @Override // androidx.core.app.ActivityOptionsCompat
        public ActivityOptionsCompat setShareIdentityEnabled(boolean r100) {
            if (Build.VERSION.SDK_INT >= 34) goto L6;
            return this;
        L6:
            return new ActivityOptionsCompatImpl(Api34Impl.setShareIdentityEnabled(this.mActivityOptions, r100));
        }

        @Override // androidx.core.app.ActivityOptionsCompat
        public void update(ActivityOptionsCompat r100) {
            if ((r100 instanceof ActivityOptionsCompatImpl) == false) goto L6;
            this.mActivityOptions.update(((ActivityOptionsCompatImpl) r100).mActivityOptions);
            return;
        }
    }

    public static class Api21Impl {
        public static ActivityOptions makeTaskLaunchBehind() {
            return ActivityOptions.makeTaskLaunchBehind();
        }

        private Api21Impl() {
        }

        @SafeVarargs
        public static ActivityOptions makeSceneTransitionAnimation(Activity r100, Pair<View, String>... r101) {
            return ActivityOptions.makeSceneTransitionAnimation(r100, r101);
        }

        public static ActivityOptions makeSceneTransitionAnimation(Activity r100, View r101, String r102) {
            return ActivityOptions.makeSceneTransitionAnimation(r100, r101, r102);
        }
    }

    public static class Api23Impl {
        public static ActivityOptions makeBasic() {
            return ActivityOptions.makeBasic();
        }

        private Api23Impl() {
        }

        public static void requestUsageTimeReport(ActivityOptions r100, PendingIntent r101) {
            r100.requestUsageTimeReport(r101);
        }

        public static ActivityOptions makeClipRevealAnimation(View r100, int r101, int r102, int r103, int r104) {
            return ActivityOptions.makeClipRevealAnimation(r100, r101, r102, r103, r104);
        }
    }

    public static class Api24Impl {
        private Api24Impl() {
        }

        public static Rect getLaunchBounds(ActivityOptions r100) {
            return r100.getLaunchBounds();
        }

        public static ActivityOptions setLaunchBounds(ActivityOptions r100, Rect r101) {
            return r100.setLaunchBounds(r101);
        }
    }

    public static class Api33Impl {
        private Api33Impl() {
        }

        public static void setPendingIntentBackgroundActivityLaunchAllowed(ActivityOptions r100, boolean r101) {
            r100.setPendingIntentBackgroundActivityLaunchAllowed(r101);
        }
    }

    public static class Api34Impl {
        private Api34Impl() {
        }

        public static ActivityOptions setPendingIntentBackgroundActivityStartMode(ActivityOptions r100, int r101) {
            return r100.setPendingIntentBackgroundActivityStartMode(r101);
        }

        public static ActivityOptions setShareIdentityEnabled(ActivityOptions r100, boolean r101) {
            return r100.setShareIdentityEnabled(r101);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface BackgroundActivityStartMode {
    }

    public Rect getLaunchBounds() {
        return null;
    }

    public void requestUsageTimeReport(PendingIntent r100) {
    }

    public ActivityOptionsCompat setLaunchBounds(Rect r100) {
        return this;
    }

    public ActivityOptionsCompat setPendingIntentBackgroundActivityStartMode(int r100) {
        return this;
    }

    public ActivityOptionsCompat setShareIdentityEnabled(boolean r100) {
        return this;
    }

    public Bundle toBundle() {
        return null;
    }

    public void update(ActivityOptionsCompat r100) {
    }

    public static ActivityOptionsCompat makeBasic() {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return new ActivityOptionsCompatImpl(Api23Impl.makeBasic());
    L7:
        return new ActivityOptionsCompat();
    }

    public static ActivityOptionsCompat makeTaskLaunchBehind() {
        return new ActivityOptionsCompatImpl(Api21Impl.makeTaskLaunchBehind());
    }

    public ActivityOptionsCompat() {
    }

    public static ActivityOptionsCompat makeSceneTransitionAnimation(Activity r100, androidx.core.util.Pair<View, String>... r101) {
        if (r101 == null) goto L7;
        Pair[] r102 = new Pair[r101.length];
        int r103 = 0;
    L5:
        if (r103 >= r101.length) goto L9;
        androidx.core.util.Pair<View, String> r104 = r101[r103];
        r102[r103] = Pair.create(r104.first, r104.second);
        r103 = r103 + 1;
    L9:
        return new ActivityOptionsCompatImpl(Api21Impl.makeSceneTransitionAnimation(r100, r102));
    L7:
        r102 = null;
        goto L9
    }

    public static ActivityOptionsCompat makeCustomAnimation(Context r100, int r101, int r102) {
        return new ActivityOptionsCompatImpl(ActivityOptions.makeCustomAnimation(r100, r101, r102));
    }

    public static ActivityOptionsCompat makeSceneTransitionAnimation(Activity r100, View r101, String r102) {
        return new ActivityOptionsCompatImpl(Api21Impl.makeSceneTransitionAnimation(r100, r101, r102));
    }

    public static ActivityOptionsCompat makeThumbnailScaleUpAnimation(View r100, Bitmap r101, int r102, int r103) {
        return new ActivityOptionsCompatImpl(ActivityOptions.makeThumbnailScaleUpAnimation(r100, r101, r102, r103));
    }

    public static ActivityOptionsCompat makeClipRevealAnimation(View r100, int r101, int r102, int r103, int r104) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return new ActivityOptionsCompatImpl(Api23Impl.makeClipRevealAnimation(r100, r101, r102, r103, r104));
    L7:
        return new ActivityOptionsCompat();
    }

    public static ActivityOptionsCompat makeScaleUpAnimation(View r100, int r101, int r102, int r103, int r104) {
        return new ActivityOptionsCompatImpl(ActivityOptions.makeScaleUpAnimation(r100, r101, r102, r103, r104));
    }
}
