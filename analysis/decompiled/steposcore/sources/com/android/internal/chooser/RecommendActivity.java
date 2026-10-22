package com.android.internal.chooser;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.internal.chooser.base.IntentModifier;
import com.android.internal.chooser.bean.DisplayResolveInfo;
import com.android.internal.chooser.hook.ResolverHooker;
import com.android.internal.chooser.recommend.RecommendIntentModifier;
import com.android.internal.chooser.recommend.RecommendItemComparator;
import com.android.internal.chooser.widget.CustomRoundImageView;
import java.util.Comparator;

/* loaded from: classes.dex */
public class RecommendActivity extends Activity {
    private ResolverHooker mResolverHooker;

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mResolverHooker = new RecommendHooker(this, new Runnable() { // from class: com.android.internal.chooser.RecommendActivity.1
            @Override // java.lang.Runnable
            public void run() {
                RecommendActivity.super.finish();
            }
        });
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

    public static class RecommendHooker extends ResolverActivityHooker {
        public RecommendHooker(Activity activity, Runnable finishTask) {
            super(activity, finishTask);
        }

        @Override // com.android.internal.chooser.ResolverActivityHooker, com.android.internal.chooser.hook.ResolverHooker
        public boolean shouldHook() {
            return true;
        }

        @Override // com.android.internal.chooser.ResolverActivityHooker, com.android.internal.chooser.BaseResolverHooker
        protected Intent getQueryIntent() {
            return this.mIntentParser.getExtraIntent();
        }

        @Override // com.android.internal.chooser.ResolverActivityHooker, com.android.internal.chooser.BaseResolverHooker
        protected IntentModifier getIntentModifier() {
            return new RecommendIntentModifier();
        }

        @Override // com.android.internal.chooser.ResolverActivityHooker, com.android.internal.chooser.BaseResolverHooker
        protected void setupCheckBox(CheckBox checkBox) {
            checkBox.setVisibility(8);
        }

        @Override // com.android.internal.chooser.ResolverActivityHooker, com.android.internal.chooser.BaseResolverHooker
        protected void setupOpenFileCheckBox(TextView checkboxTip, CheckBox checkBox) {
            checkboxTip.setVisibility(8);
            checkBox.setVisibility(8);
        }

        @Override // com.android.internal.chooser.ResolverActivityHooker, com.android.internal.chooser.BaseResolverHooker
        protected void setupFileThumbnail(CustomRoundImageView fileThumbnailTv) {
            super.setupFileThumbnail(fileThumbnailTv);
        }

        @Override // com.android.internal.chooser.ResolverActivityHooker, com.android.internal.chooser.BaseResolverHooker
        protected void setupFileName(TextView fileNameTv) {
            super.setupFileName(fileNameTv);
        }

        @Override // com.android.internal.chooser.ResolverActivityHooker, com.android.internal.chooser.BaseResolverHooker
        protected void setupFileType(TextView fileTypeTv) {
            super.setupFileType(fileTypeTv);
        }

        @Override // com.android.internal.chooser.ResolverActivityHooker, com.android.internal.chooser.BaseResolverHooker
        protected void setupFileSize(TextView fileSizeTv) {
            super.setupFileSize(fileSizeTv);
        }

        @Override // com.android.internal.chooser.ResolverActivityHooker, com.android.internal.chooser.BaseResolverHooker
        protected void setupFilePolicy(TextView textView, ImageView imageView) {
            textView.setVisibility(8);
            imageView.setVisibility(8);
        }

        @Override // com.android.internal.chooser.ResolverActivityHooker, com.android.internal.chooser.BaseResolverHooker
        protected void setupTitleLayout(View titleLayout) {
            super.setupTitleLayout(titleLayout);
        }

        @Override // com.android.internal.chooser.ResolverActivityHooker, com.android.internal.chooser.BaseResolverHooker
        protected void setupPreview(FrameLayout parent, View customView) {
            parent.setVisibility(8);
        }

        @Override // com.android.internal.chooser.ResolverActivityHooker, com.android.internal.chooser.BaseResolverHooker
        protected boolean showRecommendTagIfNeed() {
            return false;
        }

        @Override // com.android.internal.chooser.ResolverActivityHooker
        protected boolean isSetLastChosen() {
            return false;
        }

        @Override // com.android.internal.chooser.ResolverActivityHooker
        protected boolean isShowAllApp() {
            return true;
        }

        @Override // com.android.internal.chooser.ResolverActivityHooker
        protected boolean isFilterPriority() {
            return false;
        }

        @Override // com.android.internal.chooser.ResolverActivityHooker
        protected Comparator<DisplayResolveInfo> getComparator() {
            return new RecommendItemComparator();
        }
    }
}
