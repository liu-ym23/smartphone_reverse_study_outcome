package com.android.internal.chooser;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import com.android.internal.chooser.hook.ResolverHooker;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public class StepOSResolverActivityExtImpl implements IStepOSResolverActivityExt {
    private ResolverHooker mResolverHooker;

    public void onAttach(Activity target) {
    }

    public void init(final Activity activity, Runnable superFinish) {
        Runnable finishTask;
        if (superFinish != null) {
            finishTask = superFinish;
        } else {
            Objects.requireNonNull(activity);
            finishTask = new Runnable() { // from class: com.android.internal.chooser.StepOSResolverActivityExtImpl$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    activity.finish();
                }
            };
        }
        this.mResolverHooker = getResolverHooker(activity, finishTask);
    }

    private static ResolverHooker getResolverHooker(Activity activity, Runnable finishTask) {
        return new ResolverActivityHooker(activity, finishTask);
    }

    public boolean delegateOnCreate(Activity activity, Bundle savedInstanceState) {
        if (this.mResolverHooker != null && this.mResolverHooker.shouldHook()) {
            this.mResolverHooker.onCreate(savedInstanceState);
            return true;
        }
        return false;
    }

    public boolean delegateOnCreate(Activity activity, Bundle savedInstanceState, Intent intent, CharSequence title, int defaultTitleRes, Intent[] initialIntents, List<ResolveInfo> rList, boolean supportsAlwaysUseOption) throws IllegalAccessException, NoSuchFieldException, Resources.NotFoundException, IllegalArgumentException {
        if ((this.mResolverHooker instanceof ResolverActivityHooker) && this.mResolverHooker.shouldHook()) {
            ((ResolverActivityHooker) this.mResolverHooker).onCreate(savedInstanceState, intent, title, defaultTitleRes, initialIntents, rList, supportsAlwaysUseOption);
            return true;
        }
        return false;
    }

    public boolean delegateOnStart(Activity activity) {
        if (this.mResolverHooker != null && this.mResolverHooker.shouldHook()) {
            this.mResolverHooker.onStart();
            return true;
        }
        return false;
    }

    public void delegateOnResume(Activity activity) {
        if (this.mResolverHooker != null && this.mResolverHooker.shouldHook()) {
            this.mResolverHooker.onResume();
        }
    }

    public void delegateOnPause(Activity activity) {
        if (this.mResolverHooker != null && this.mResolverHooker.shouldHook()) {
            this.mResolverHooker.onPause();
        }
    }

    public boolean delegateOnStop(Activity activity) {
        if (this.mResolverHooker != null && this.mResolverHooker.shouldHook()) {
            this.mResolverHooker.onStop();
            return true;
        }
        return false;
    }

    public boolean delegateOnRestart(Activity activity) {
        if (this.mResolverHooker != null && this.mResolverHooker.shouldHook()) {
            this.mResolverHooker.onRestart();
            return true;
        }
        return false;
    }

    public boolean delegateOnDestroy(Activity activity) {
        if (this.mResolverHooker != null && this.mResolverHooker.shouldHook()) {
            this.mResolverHooker.onDestroy();
            return true;
        }
        return false;
    }

    public boolean delegateOnConfigurationChanged(Activity activity, Configuration newConfig) {
        if (this.mResolverHooker != null && this.mResolverHooker.shouldHook()) {
            this.mResolverHooker.onConfigurationChanged(newConfig);
            return true;
        }
        return false;
    }

    public boolean delegateOnSaveInstanceState(Activity activity, Bundle outState) {
        if (this.mResolverHooker != null && this.mResolverHooker.shouldHook()) {
            this.mResolverHooker.onSaveInstanceState(outState);
            return true;
        }
        return false;
    }

    public boolean delegateOnRestoreInstanceState(Activity activity, Bundle savedInstanceState) {
        if (this.mResolverHooker != null && this.mResolverHooker.shouldHook()) {
            this.mResolverHooker.onRestoreInstanceState(savedInstanceState);
            return true;
        }
        return false;
    }

    public void delegateOnBackPressed(Activity activity) {
        if (this.mResolverHooker != null && this.mResolverHooker.shouldHook()) {
            this.mResolverHooker.onBackPressed();
        }
    }

    public boolean delegateFinish(Activity activity) {
        if (this.mResolverHooker != null && this.mResolverHooker.shouldHook()) {
            this.mResolverHooker.finish();
            return true;
        }
        return false;
    }

    public void delegateOnActivityResult(Activity activity, int requestCode, int resultCode, Intent data) {
        if (this.mResolverHooker != null && this.mResolverHooker.shouldHook()) {
            this.mResolverHooker.onActivityResult(requestCode, resultCode, data);
        }
    }
}
