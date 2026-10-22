package com.android.server.people.prediction;

import android.app.prediction.AppPredictionContext;
import android.app.prediction.AppTarget;
import android.app.prediction.AppTargetEvent;
import android.app.prediction.AppTargetId;
import android.content.Context;
import com.android.server.people.data.DataManager;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
public class AppTargetPredictor {
    private static final String UI_SURFACE_SHARE = "share";
    private final ExecutorService mCallbackExecutor;
    final int mCallingUserId;
    private final DataManager mDataManager;
    private final AppPredictionContext mPredictionContext;
    private final Consumer<List<AppTarget>> mUpdatePredictionsMethod;

    /* JADX INFO: renamed from: $r8$lambda$37MgudvkyLT1JZairIFld-5QeGQ, reason: not valid java name */
    public static /* synthetic */ void m6563$r8$lambda$37MgudvkyLT1JZairIFld5QeGQ(AppTargetPredictor r0, List r1, Consumer r2) {
        r0.lambda$onSortAppTargets$1(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$hU3NH6A3fXUN4IZ6pl09Jj2hK8I(AppTargetPredictor r0, AppTargetEvent r1) {
        r0.lambda$onAppTargetEvent$0(r1);
    }

    public static AppTargetPredictor create(AppPredictionContext predictionContext, Consumer<List<AppTarget>> updatePredictionsMethod, DataManager dataManager, int callingUserId, Context context) {
        if (UI_SURFACE_SHARE.equals(predictionContext.getUiSurface()) == false) goto L7;
        return new ShareTargetPredictor(predictionContext, updatePredictionsMethod, dataManager, callingUserId, context);
    L7:
        return new AppTargetPredictor(predictionContext, updatePredictionsMethod, dataManager, callingUserId);
    }

    AppTargetPredictor(AppPredictionContext predictionContext, Consumer<List<AppTarget>> updatePredictionsMethod, DataManager dataManager, int callingUserId) {
        this.mPredictionContext = predictionContext;
        this.mUpdatePredictionsMethod = updatePredictionsMethod;
        this.mDataManager = dataManager;
        this.mCallingUserId = callingUserId;
        this.mCallbackExecutor = Executors.newSingleThreadExecutor();
    }

    private /* synthetic */ void lambda$onAppTargetEvent$0(AppTargetEvent event) {
        reportAppTargetEvent(event);
    }

    public void onAppTargetEvent(final AppTargetEvent event) {
        this.mCallbackExecutor.execute(new AppTargetPredictor$$ExternalSyntheticLambda1(this, event));
    }

    public void onLaunchLocationShown(String launchLocation, List<AppTargetId> targetIds) {
    }

    private /* synthetic */ void lambda$onSortAppTargets$1(List targets, Consumer callback) {
        sortTargets(targets, callback);
    }

    public void onSortAppTargets(final List<AppTarget> targets, final Consumer<List<AppTarget>> callback) {
        this.mCallbackExecutor.execute(new AppTargetPredictor$$ExternalSyntheticLambda0(this, targets, callback));
    }

    public void onRequestPredictionUpdate() {
        this.mCallbackExecutor.execute(new AppTargetPredictor$$ExternalSyntheticLambda2(this));
    }

    public Consumer<List<AppTarget>> getUpdatePredictionsMethod() {
        return this.mUpdatePredictionsMethod;
    }

    void reportAppTargetEvent(AppTargetEvent event) {
    }

    void predictTargets() {
    }

    void sortTargets(List<AppTarget> targets, Consumer<List<AppTarget>> callback) {
        callback.accept(targets);
    }

    void destroy() {
    }

    AppPredictionContext getPredictionContext() {
        return this.mPredictionContext;
    }

    DataManager getDataManager() {
        return this.mDataManager;
    }

    void updatePredictions(List<AppTarget> targets) {
        this.mUpdatePredictionsMethod.accept(targets);
    }
}
