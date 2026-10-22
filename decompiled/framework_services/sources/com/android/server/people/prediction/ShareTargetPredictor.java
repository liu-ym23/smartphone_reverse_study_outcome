package com.android.server.people.prediction;

import android.R;
import android.app.prediction.AppPredictionContext;
import android.app.prediction.AppPredictionManager;
import android.app.prediction.AppPredictor;
import android.app.prediction.AppTarget;
import android.app.prediction.AppTargetEvent;
import android.app.prediction.AppTargetId;
import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.os.UserHandle;
import android.provider.DeviceConfig;
import android.util.Log;
import android.util.Slog;
import com.android.server.people.data.ConversationInfo;
import com.android.server.people.data.DataManager;
import com.android.server.people.data.EventHistory;
import com.android.server.people.data.PackageData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
class ShareTargetPredictor extends AppTargetPredictor {
    private static final boolean DEBUG = false;
    private static final String REMOTE_APP_PREDICTOR_KEY = "remote_app_predictor";
    private static final String TAG = "ShareTargetPredictor";
    private final String mChooserActivity;
    private final IntentFilter mIntentFilter;
    private final AppPredictor mRemoteAppPredictor;

    static class ShareTarget {
        private final AppTarget mAppTarget;
        private final ConversationInfo mConversationInfo;
        private final EventHistory mEventHistory;
        private float mScore;

        ShareTarget(AppTarget appTarget, EventHistory eventHistory, ConversationInfo conversationInfo) {
            this.mAppTarget = appTarget;
            this.mEventHistory = eventHistory;
            this.mConversationInfo = conversationInfo;
            this.mScore = 0.0f;
        }

        AppTarget getAppTarget() {
            return this.mAppTarget;
        }

        EventHistory getEventHistory() {
            return this.mEventHistory;
        }

        ConversationInfo getConversationInfo() {
            return this.mConversationInfo;
        }

        float getScore() {
            return this.mScore;
        }

        void setScore(float score) {
            this.mScore = score;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$M6vo1Nh3_1db-dTvTXDVnHWMD1E, reason: not valid java name */
    public static /* synthetic */ Integer m6564$r8$lambda$M6vo1Nh3_1dbdTvTXDVnHWMD1E(ShareTarget r0) {
        return lambda$predictTargets$0(r0);
    }

    public static /* synthetic */ int $r8$lambda$QDM8jMyYVYSbIITP14sMNooJIyA(ShareTarget r0, ShareTarget r1) {
        return lambda$sortTargets$1(r0, r1);
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
    }

    ShareTargetPredictor(AppPredictionContext predictionContext, Consumer<List<AppTarget>> updatePredictionsMethod, DataManager dataManager, int callingUserId, Context context) {
        super(predictionContext, updatePredictionsMethod, dataManager, callingUserId);
        this.mIntentFilter = (IntentFilter) predictionContext.getExtras().getParcelable("intent_filter", IntentFilter.class);
        String r1 = null;
        if (DeviceConfig.getBoolean("systemui", "dark_launch_remote_prediction_service_enabled", false) == false) goto L5;
        predictionContext.getExtras().putBoolean(REMOTE_APP_PREDICTOR_KEY, true);
        this.mRemoteAppPredictor = ((AppPredictionManager) context.createContextAsUser(UserHandle.of(callingUserId), 0).getSystemService(AppPredictionManager.class)).createAppPredictionSession(predictionContext);
    L6:
        ComponentName component = ComponentName.unflattenFromString(context.getResources().getString(R.string.config_defaultProfcollectReportUploaderAction));
        if (component == null) goto L10;
        r1 = component.getShortClassName();
    L10:
        this.mChooserActivity = r1;
        return;
    L5:
        this.mRemoteAppPredictor = null;
        goto L6
    }

    @Override // com.android.server.people.prediction.AppTargetPredictor
    void reportAppTargetEvent(AppTargetEvent event) {
        if (DEBUG == false) goto L6;
        Slog.d(TAG, "reportAppTargetEvent");
    L6:
        if (this.mIntentFilter == null) goto L9;
        getDataManager().reportShareTargetEvent(event, this.mIntentFilter);
    L9:
        if (this.mRemoteAppPredictor == null) goto L12;
        this.mRemoteAppPredictor.notifyAppTargetEvent(event);
        return;
    }

    @Override // com.android.server.people.prediction.AppTargetPredictor
    void predictTargets() {
        if (DEBUG == false) goto L6;
        Slog.d(TAG, "predictTargets");
    L6:
        if (this.mIntentFilter != null) goto L9;
        updatePredictions(List.of());
        return;
    L9:
        List<ShareTarget> shareTargets = getDirectShareTargets();
        SharesheetModelScorer.computeScore(shareTargets, getShareEventType(this.mIntentFilter), System.currentTimeMillis());
        Collections.sort(shareTargets, Comparator.comparing(new ShareTargetPredictor$$ExternalSyntheticLambda0(), Collections.reverseOrder()).thenComparing(new ShareTargetPredictor$$ExternalSyntheticLambda1()));
        List<AppTarget> res = new ArrayList();
        int i = 0;
    L11:
        if (i >= Math.min(getPredictionContext().getPredictedTargetCount(), shareTargets.size())) goto L13;
        res.add(shareTargets.get(i).getAppTarget());
        i = i + 1;
        goto L11
    L13:
        updatePredictions(res);
    }

    private static /* synthetic */ Integer lambda$predictTargets$0(ShareTarget t) {
        return Integer.valueOf(t.getAppTarget().getRank());
    }

    @Override // com.android.server.people.prediction.AppTargetPredictor
    void sortTargets(List<AppTarget> targets, Consumer<List<AppTarget>> callback) {
        if (DEBUG == false) goto L6;
        Slog.d(TAG, "sortTargets");
    L6:
        if (this.mIntentFilter != null) goto L9;
        callback.accept(targets);
        return;
    L9:
        List<ShareTarget> shareTargets = getAppShareTargets(targets);
        SharesheetModelScorer.computeScoreForAppShare(shareTargets, getShareEventType(this.mIntentFilter), getPredictionContext().getPredictedTargetCount(), System.currentTimeMillis(), getDataManager(), this.mCallingUserId, this.mChooserActivity);
        Collections.sort(shareTargets, new ShareTargetPredictor$$ExternalSyntheticLambda2());
        List<AppTarget> appTargetList = new ArrayList();
        Iterator<ShareTarget> r2 = shareTargets.iterator();
    L11:
        if (r2.hasNext() == false) goto L17;
        ShareTarget shareTarget = r2.next();
        AppTarget appTarget = shareTarget.getAppTarget();
        AppTarget.Builder r5 = new AppTarget.Builder(appTarget.getId(), appTarget.getPackageName(), appTarget.getUser()).setClassName(appTarget.getClassName());
        if (shareTarget.getScore() <= 0.0f) goto L15;
        int r6 = (int) (shareTarget.getScore() * 1000.0f);
    L16:
        appTargetList.add(r5.setRank(r6).build());
        goto L11
    L15:
        r6 = 0;
        goto L16
    L17:
        callback.accept(appTargetList);
    }

    private static /* synthetic */ int lambda$sortTargets$1(ShareTarget t1, ShareTarget t2) {
        return -Float.compare(t1.getScore(), t2.getScore());
    }

    @Override // com.android.server.people.prediction.AppTargetPredictor
    void destroy() {
        if (this.mRemoteAppPredictor == null) goto L6;
        this.mRemoteAppPredictor.destroy();
        return;
    }

    private List<ShareTarget> getDirectShareTargets() {
        List<ShareTarget> shareTargets = new ArrayList();
        List<ShortcutManager.ShareShortcutInfo> shareShortcuts = getDataManager().getShareShortcuts(this.mIntentFilter, this.mCallingUserId);
        Iterator<ShortcutManager.ShareShortcutInfo> r2 = shareShortcuts.iterator();
    L4:
        if (r2.hasNext() == false) goto L11;
        ShortcutManager.ShareShortcutInfo shareShortcut = r2.next();
        ShortcutInfo shortcutInfo = shareShortcut.getShortcutInfo();
        AppTarget appTarget = new AppTarget.Builder(new AppTargetId(shortcutInfo.getId()), shortcutInfo).setClassName(shareShortcut.getTargetComponent().getClassName()).setRank(shortcutInfo.getRank()).build();
        String packageName = shortcutInfo.getPackage();
        int userId = shortcutInfo.getUserId();
        PackageData packageData = getDataManager().getPackage(packageName, userId);
        ConversationInfo conversationInfo = null;
        EventHistory eventHistory = null;
        if (packageData == null) goto L10;
        String shortcutId = shortcutInfo.getId();
        conversationInfo = packageData.getConversationInfo(shortcutId);
        if (conversationInfo == null) goto L10;
        eventHistory = packageData.getEventHistory(shortcutId);
    L10:
        shareTargets.add(new ShareTarget(appTarget, eventHistory, conversationInfo));
        goto L4
    L11:
        return shareTargets;
    }

    private List<ShareTarget> getAppShareTargets(List<AppTarget> targets) {
        List<ShareTarget> shareTargets = new ArrayList();
        Iterator<AppTarget> r1 = targets.iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        AppTarget target = r1.next();
        PackageData packageData = getDataManager().getPackage(target.getPackageName(), target.getUser().getIdentifier());
        if (packageData != null) goto L8;
        EventHistory r6 = null;
    L9:
        shareTargets.add(new ShareTarget(target, r6, null));
        goto L4
    L8:
        r6 = packageData.getClassLevelEventHistory(target.getClassName());
        goto L9
    L10:
        return shareTargets;
    }

    private int getShareEventType(IntentFilter intentFilter) {
        if (intentFilter != null) goto L4;
    L6:
        String mimeType = null;
    L8:
        return getDataManager().mimeTypeToShareEventType(mimeType);
    L4:
        if (intentFilter.countDataTypes() <= 0) goto L6;
        mimeType = intentFilter.getDataType(0);
        goto L8
    }
}
