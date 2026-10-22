package com.android.server.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.service.notification.SnoozeCriterion;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class NotificationRecordExtractorData {
    private final boolean mAllowBubble;
    private final NotificationChannel mChannel;
    private final String mGroupKey;
    private final int mImportance;
    private final boolean mIsBubble;
    private final boolean mIsConversation;
    private final ArrayList<String> mOverridePeople;
    private final int mPosition;
    private final int mProposedImportance;
    private final float mRankingScore;
    private final boolean mSensitiveContent;
    private final boolean mShowBadge;
    private final ArrayList<CharSequence> mSmartReplies;
    private final ArrayList<SnoozeCriterion> mSnoozeCriteria;
    private final String mSummarization;
    private final Integer mSuppressVisually;
    private final ArrayList<Notification.Action> mSystemSmartActions;
    private final Integer mUserSentiment;
    private final int mVisibility;

    NotificationRecordExtractorData(int position, int visibility, boolean showBadge, boolean allowBubble, boolean isBubble, NotificationChannel channel, String groupKey, ArrayList<String> overridePeople, ArrayList<SnoozeCriterion> snoozeCriteria, Integer userSentiment, Integer suppressVisually, ArrayList<Notification.Action> systemSmartActions, ArrayList<CharSequence> smartReplies, int importance, float rankingScore, boolean isConversation, int proposedImportance, boolean sensitiveContent, String summarization) {
        this.mPosition = position;
        this.mVisibility = visibility;
        this.mShowBadge = showBadge;
        this.mAllowBubble = allowBubble;
        this.mIsBubble = isBubble;
        this.mChannel = channel;
        this.mGroupKey = groupKey;
        this.mOverridePeople = overridePeople;
        this.mSnoozeCriteria = snoozeCriteria;
        this.mUserSentiment = userSentiment;
        this.mSuppressVisually = suppressVisually;
        this.mSystemSmartActions = systemSmartActions;
        this.mSmartReplies = smartReplies;
        this.mImportance = importance;
        this.mRankingScore = rankingScore;
        this.mIsConversation = isConversation;
        this.mProposedImportance = proposedImportance;
        this.mSensitiveContent = sensitiveContent;
        this.mSummarization = summarization;
    }

    boolean hasDiffForRankingLocked(NotificationRecord r, int newPosition) {
        if (this.mPosition == newPosition) goto L5;
    L38:
        return true;
    L5:
        if (this.mVisibility != r.getPackageVisibilityOverride()) goto L38;
        if (this.mShowBadge != r.canShowBadge()) goto L38;
        if (this.mAllowBubble != r.canBubble()) goto L38;
        if (this.mIsBubble != r.getNotification().isBubbleNotification()) goto L38;
        if (Objects.equals(this.mChannel, r.getChannel()) == false) goto L38;
        if (Objects.equals(this.mGroupKey, r.getGroupKey()) == false) goto L38;
        if (Objects.equals(this.mOverridePeople, r.getPeopleOverride()) == false) goto L38;
        if (Objects.equals(this.mSnoozeCriteria, r.getSnoozeCriteria()) == false) goto L38;
        if (Objects.equals(this.mUserSentiment, Integer.valueOf(r.getUserSentiment())) == false) goto L38;
        if (Objects.equals(this.mSuppressVisually, Integer.valueOf(r.getSuppressedVisualEffects())) == false) goto L38;
        if (Objects.equals(this.mSystemSmartActions, r.getSystemGeneratedSmartActions()) == false) goto L38;
        if (Objects.equals(this.mSmartReplies, r.getSmartReplies()) == false) goto L38;
        if (this.mImportance != r.getImportance()) goto L38;
        if (this.mProposedImportance != r.getProposedImportance()) goto L38;
        if (this.mSensitiveContent != r.hasSensitiveContent()) goto L38;
        if (Objects.equals(this.mSummarization, r.getSummarization()) == false) goto L38;
        return false;
    }

    boolean hasDiffForLoggingLocked(NotificationRecord r, int newPosition) {
        if (this.mPosition == newPosition) goto L5;
    L32:
        return true;
    L5:
        if (Objects.equals(this.mChannel, r.getChannel()) == false) goto L32;
        if (Objects.equals(this.mGroupKey, r.getGroupKey()) == false) goto L32;
        if (Objects.equals(this.mOverridePeople, r.getPeopleOverride()) == false) goto L32;
        if (Objects.equals(this.mSnoozeCriteria, r.getSnoozeCriteria()) == false) goto L32;
        if (Objects.equals(this.mUserSentiment, Integer.valueOf(r.getUserSentiment())) == false) goto L32;
        if (Objects.equals(this.mSystemSmartActions, r.getSystemGeneratedSmartActions()) == false) goto L32;
        if (Objects.equals(this.mSmartReplies, r.getSmartReplies()) == false) goto L32;
        if (this.mImportance != r.getImportance()) goto L32;
        if (r.rankingScoreMatches(this.mRankingScore) == false) goto L32;
        if (this.mIsConversation != r.isConversation()) goto L32;
        if (this.mProposedImportance != r.getProposedImportance()) goto L32;
        if (this.mSensitiveContent != r.hasSensitiveContent()) goto L32;
        if (Objects.equals(this.mSummarization, r.getSummarization()) == false) goto L32;
        return false;
    }
}
