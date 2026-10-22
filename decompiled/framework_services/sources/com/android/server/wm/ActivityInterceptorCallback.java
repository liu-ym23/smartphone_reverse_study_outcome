package com.android.server.wm;

import android.annotation.SystemApi;
import android.app.ActivityOptions;
import android.app.TaskInfo;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
@SystemApi(client = SystemApi.Client.SYSTEM_SERVER)
public interface ActivityInterceptorCallback {
    public static final int DREAM_MANAGER_ORDERED_ID = 4;
    public static final int MAINLINE_FIRST_ORDERED_ID = 1000;
    public static final int MAINLINE_LAST_ORDERED_ID = 1001;
    public static final int MAINLINE_SDK_SANDBOX_ORDER_ID = 1001;
    public static final int PERMISSION_POLICY_ORDERED_ID = 1;
    public static final int PRODUCT_ORDERED_ID = 5;
    public static final int SYSTEM_FIRST_ORDERED_ID = 0;
    public static final int SYSTEM_LAST_ORDERED_ID = 5;
    public static final int VIRTUAL_DEVICE_SERVICE_ORDERED_ID = 3;

    @SystemApi(client = SystemApi.Client.SYSTEM_SERVER)
    public static final class ActivityInterceptResult {
        private final ActivityOptions mActivityOptions;
        private final boolean mActivityResolved;
        private final Intent mIntent;

        public ActivityInterceptResult(Intent intent, ActivityOptions activityOptions) {
            this(intent, activityOptions, false);
        }

        public ActivityInterceptResult(Intent intent, ActivityOptions activityOptions, boolean activityResolved) {
            this.mIntent = intent;
            this.mActivityOptions = activityOptions;
            this.mActivityResolved = activityResolved;
        }

        public Intent getIntent() {
            return this.mIntent;
        }

        public ActivityOptions getActivityOptions() {
            return this.mActivityOptions;
        }

        public boolean isActivityResolved() {
            return this.mActivityResolved;
        }
    }

    @SystemApi(client = SystemApi.Client.SYSTEM_SERVER)
    public static final class ActivityInterceptorInfo {
        private final ActivityInfo mActivityInfo;
        private final String mCallingFeatureId;
        private final String mCallingPackage;
        private final int mCallingPid;
        private final int mCallingUid;
        private final ActivityOptions mCheckedOptions;
        private final Runnable mClearOptionsAnimation;
        private final Intent mIntent;
        private final int mRealCallingPid;
        private final int mRealCallingUid;
        private final ResolveInfo mResolveInfo;
        private final String mResolvedType;
        private final int mUserId;

        public static final class Builder {
            private final ActivityInfo mActivityInfo;
            private String mCallingFeatureId;
            private String mCallingPackage;
            private final int mCallingPid;
            private final int mCallingUid;
            private ActivityOptions mCheckedOptions;
            private Runnable mClearOptionsAnimation;
            private final Intent mIntent;
            private final int mRealCallingPid;
            private final int mRealCallingUid;
            private final ResolveInfo mResolveInfo;
            private String mResolvedType;
            private final int mUserId;

            /* JADX INFO: renamed from: -$$Nest$fgetmActivityInfo, reason: not valid java name */
            static /* bridge */ /* synthetic */ ActivityInfo m9607$$Nest$fgetmActivityInfo(Builder r0) {
                return r0.mActivityInfo;
            }

            /* JADX INFO: renamed from: -$$Nest$fgetmCallingFeatureId, reason: not valid java name */
            static /* bridge */ /* synthetic */ String m9608$$Nest$fgetmCallingFeatureId(Builder r0) {
                return r0.mCallingFeatureId;
            }

            /* JADX INFO: renamed from: -$$Nest$fgetmCallingPackage, reason: not valid java name */
            static /* bridge */ /* synthetic */ String m9609$$Nest$fgetmCallingPackage(Builder r0) {
                return r0.mCallingPackage;
            }

            /* JADX INFO: renamed from: -$$Nest$fgetmCallingPid, reason: not valid java name */
            static /* bridge */ /* synthetic */ int m9610$$Nest$fgetmCallingPid(Builder r0) {
                return r0.mCallingPid;
            }

            /* JADX INFO: renamed from: -$$Nest$fgetmCallingUid, reason: not valid java name */
            static /* bridge */ /* synthetic */ int m9611$$Nest$fgetmCallingUid(Builder r0) {
                return r0.mCallingUid;
            }

            /* JADX INFO: renamed from: -$$Nest$fgetmCheckedOptions, reason: not valid java name */
            static /* bridge */ /* synthetic */ ActivityOptions m9612$$Nest$fgetmCheckedOptions(Builder r0) {
                return r0.mCheckedOptions;
            }

            /* JADX INFO: renamed from: -$$Nest$fgetmClearOptionsAnimation, reason: not valid java name */
            static /* bridge */ /* synthetic */ Runnable m9613$$Nest$fgetmClearOptionsAnimation(Builder r0) {
                return r0.mClearOptionsAnimation;
            }

            /* JADX INFO: renamed from: -$$Nest$fgetmIntent, reason: not valid java name */
            static /* bridge */ /* synthetic */ Intent m9614$$Nest$fgetmIntent(Builder r0) {
                return r0.mIntent;
            }

            /* JADX INFO: renamed from: -$$Nest$fgetmRealCallingPid, reason: not valid java name */
            static /* bridge */ /* synthetic */ int m9615$$Nest$fgetmRealCallingPid(Builder r0) {
                return r0.mRealCallingPid;
            }

            /* JADX INFO: renamed from: -$$Nest$fgetmRealCallingUid, reason: not valid java name */
            static /* bridge */ /* synthetic */ int m9616$$Nest$fgetmRealCallingUid(Builder r0) {
                return r0.mRealCallingUid;
            }

            /* JADX INFO: renamed from: -$$Nest$fgetmResolveInfo, reason: not valid java name */
            static /* bridge */ /* synthetic */ ResolveInfo m9617$$Nest$fgetmResolveInfo(Builder r0) {
                return r0.mResolveInfo;
            }

            /* JADX INFO: renamed from: -$$Nest$fgetmResolvedType, reason: not valid java name */
            static /* bridge */ /* synthetic */ String m9618$$Nest$fgetmResolvedType(Builder r0) {
                return r0.mResolvedType;
            }

            /* JADX INFO: renamed from: -$$Nest$fgetmUserId, reason: not valid java name */
            static /* bridge */ /* synthetic */ int m9619$$Nest$fgetmUserId(Builder r0) {
                return r0.mUserId;
            }

            public Builder(int callingUid, int callingPid, int realCallingUid, int realCallingPid, int userId, Intent intent, ResolveInfo rInfo, ActivityInfo aInfo) {
                this.mCallingPackage = null;
                this.mCallingFeatureId = null;
                this.mCheckedOptions = null;
                this.mClearOptionsAnimation = null;
                this.mCallingUid = callingUid;
                this.mCallingPid = callingPid;
                this.mRealCallingUid = realCallingUid;
                this.mRealCallingPid = realCallingPid;
                this.mUserId = userId;
                this.mIntent = intent;
                this.mResolveInfo = rInfo;
                this.mActivityInfo = aInfo;
            }

            public ActivityInterceptorInfo build() {
                return new ActivityInterceptorInfo(this);
            }

            public Builder setResolvedType(String resolvedType) {
                this.mResolvedType = resolvedType;
                return this;
            }

            public Builder setCallingPackage(String callingPackage) {
                this.mCallingPackage = callingPackage;
                return this;
            }

            public Builder setCallingFeatureId(String callingFeatureId) {
                this.mCallingFeatureId = callingFeatureId;
                return this;
            }

            public Builder setCheckedOptions(ActivityOptions checkedOptions) {
                this.mCheckedOptions = checkedOptions;
                return this;
            }

            public Builder setClearOptionsAnimationRunnable(Runnable clearOptionsAnimationRunnable) {
                this.mClearOptionsAnimation = clearOptionsAnimationRunnable;
                return this;
            }
        }

        public ActivityInterceptorInfo(Builder builder) {
            this.mCallingUid = Builder.m9611$$Nest$fgetmCallingUid(builder);
            this.mCallingPid = Builder.m9610$$Nest$fgetmCallingPid(builder);
            this.mRealCallingUid = Builder.m9616$$Nest$fgetmRealCallingUid(builder);
            this.mRealCallingPid = Builder.m9615$$Nest$fgetmRealCallingPid(builder);
            this.mUserId = Builder.m9619$$Nest$fgetmUserId(builder);
            this.mIntent = Builder.m9614$$Nest$fgetmIntent(builder);
            this.mResolveInfo = Builder.m9617$$Nest$fgetmResolveInfo(builder);
            this.mActivityInfo = Builder.m9607$$Nest$fgetmActivityInfo(builder);
            this.mResolvedType = Builder.m9618$$Nest$fgetmResolvedType(builder);
            this.mCallingPackage = Builder.m9609$$Nest$fgetmCallingPackage(builder);
            this.mCallingFeatureId = Builder.m9608$$Nest$fgetmCallingFeatureId(builder);
            this.mCheckedOptions = Builder.m9612$$Nest$fgetmCheckedOptions(builder);
            this.mClearOptionsAnimation = Builder.m9613$$Nest$fgetmClearOptionsAnimation(builder);
        }

        public int getCallingUid() {
            return this.mCallingUid;
        }

        public int getCallingPid() {
            return this.mCallingPid;
        }

        public int getRealCallingUid() {
            return this.mRealCallingUid;
        }

        public int getRealCallingPid() {
            return this.mRealCallingPid;
        }

        public int getUserId() {
            return this.mUserId;
        }

        public Intent getIntent() {
            return this.mIntent;
        }

        public ResolveInfo getResolveInfo() {
            return this.mResolveInfo;
        }

        public ActivityInfo getActivityInfo() {
            return this.mActivityInfo;
        }

        public String getResolvedType() {
            return this.mResolvedType;
        }

        public String getCallingPackage() {
            return this.mCallingPackage;
        }

        public String getCallingFeatureId() {
            return this.mCallingFeatureId;
        }

        public ActivityOptions getCheckedOptions() {
            return this.mCheckedOptions;
        }

        public Runnable getClearOptionsAnimationRunnable() {
            return this.mClearOptionsAnimation;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface OrderedId {
    }

    ActivityInterceptResult onInterceptActivityLaunch(ActivityInterceptorInfo r1);

    default void onActivityLaunched(TaskInfo taskInfo, ActivityInfo activityInfo, ActivityInterceptorInfo info) {
    }

    static boolean isValidOrderId(int id) {
        if (isValidMainlineOrderId(id) == true) goto L9;
        if (id >= 0) goto L6;
    L8:
        return false;
    L6:
        if (id > 5) goto L8;
    L9:
        return true;
    }

    static boolean isValidMainlineOrderId(int id) {
        if (id >= 1000) goto L5;
    L7:
        return false;
    L5:
        if (id > 1001) goto L7;
        return true;
    }
}
