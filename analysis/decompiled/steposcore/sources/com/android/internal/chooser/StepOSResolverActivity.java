package com.android.internal.chooser;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import java.util.List;

/* loaded from: classes.dex */
public class StepOSResolverActivity extends Activity {
    private Runnable mFinishTask = new Runnable() { // from class: com.android.internal.chooser.StepOSResolverActivity.1
        @Override // java.lang.Runnable
        public void run() {
            StepOSResolverActivity.super.finish();
        }
    };
    private StepOSResolverActivityHooker mResolverHooker;

    protected void onCreate(Bundle savedInstanceState, Intent intent, CharSequence title, int defaultTitleRes, Intent[] initialIntents, List<ResolveInfo> rList, boolean alwaysUseOption) {
        super.onCreate(savedInstanceState);
        this.mResolverHooker = new StepOSResolverActivityHooker(this, this.mFinishTask);
        if (this.mResolverHooker.shouldHook()) {
            this.mResolverHooker.onCreate(savedInstanceState, intent, title, defaultTitleRes, initialIntents, rList, alwaysUseOption);
        }
    }

    protected void onCreate(Bundle savedInstanceState, Intent intent, CharSequence title, Intent[] initialIntents, List<ResolveInfo> rList, boolean alwaysUseOption) {
        super.onCreate(savedInstanceState);
        this.mResolverHooker = new StepOSResolverActivityHooker(this, this.mFinishTask);
        if (this.mResolverHooker.shouldHook()) {
            this.mResolverHooker.onCreate(savedInstanceState, intent, title, initialIntents, rList, alwaysUseOption);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mResolverHooker = new StepOSResolverActivityHooker(this, this.mFinishTask);
        if (this.mResolverHooker.shouldHook()) {
            this.mResolverHooker.onCreate(savedInstanceState);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (this.mResolverHooker.shouldHook()) {
            this.mResolverHooker.onStart();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.mResolverHooker.shouldHook()) {
            this.mResolverHooker.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        if (this.mResolverHooker.shouldHook()) {
            this.mResolverHooker.onPause();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        if (this.mResolverHooker.shouldHook()) {
            this.mResolverHooker.onStop();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        if (this.mResolverHooker.shouldHook()) {
            this.mResolverHooker.onRestart();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.mResolverHooker.shouldHook()) {
            this.mResolverHooker.onDestroy();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (this.mResolverHooker.shouldHook()) {
            this.mResolverHooker.onConfigurationChanged(newConfig);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (this.mResolverHooker.shouldHook()) {
            this.mResolverHooker.onSaveInstanceState(outState);
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (this.mResolverHooker.shouldHook()) {
            this.mResolverHooker.onRestoreInstanceState(savedInstanceState);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        if (this.mResolverHooker.shouldHook()) {
            this.mResolverHooker.onBackPressed();
        }
    }

    @Override // android.app.Activity
    public void finish() {
        if (this.mResolverHooker.shouldHook()) {
            this.mResolverHooker.finish();
        } else {
            super.finish();
        }
    }

    private static class StepOSResolverActivityHooker extends ResolverActivityHooker {
        public StepOSResolverActivityHooker(Activity activity, Runnable finishTask) {
            super(activity, finishTask);
        }

        @Override // com.android.internal.chooser.ResolverActivityHooker, com.android.internal.chooser.hook.ResolverHooker
        public boolean shouldHook() {
            return true;
        }
    }
}
