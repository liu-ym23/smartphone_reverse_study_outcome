package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.LocusId;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.collection.ArraySet;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class NotificationCompatBuilder implements NotificationBuilderWithBuilderAccessor {
    private final List<Bundle> mActionExtrasList;
    private RemoteViews mBigContentView;
    private final Notification.Builder mBuilder;
    private final NotificationCompat.Builder mBuilderCompat;
    private RemoteViews mContentView;
    private final Context mContext;
    private final Bundle mExtras;
    private int mGroupAlertBehavior;
    private RemoteViews mHeadsUpContentView;

    static class Api16Impl {
        private Api16Impl() {
        }

        static Notification.Builder setSubText(Notification.Builder r0, CharSequence r1) {
            return r0.setSubText(r1);
        }

        static Notification.Builder setUsesChronometer(Notification.Builder r0, boolean r1) {
            return r0.setUsesChronometer(r1);
        }

        static Notification.Builder setPriority(Notification.Builder r0, int r1) {
            return r0.setPriority(r1);
        }

        static Notification build(Notification.Builder r0) {
            return r0.build();
        }
    }

    static class Api17Impl {
        private Api17Impl() {
        }

        static Notification.Builder setShowWhen(Notification.Builder r0, boolean r1) {
            return r0.setShowWhen(r1);
        }
    }

    static class Api19Impl {
        private Api19Impl() {
        }

        static Notification.Builder setExtras(Notification.Builder r0, Bundle r1) {
            return r0.setExtras(r1);
        }
    }

    static class Api20Impl {
        private Api20Impl() {
        }

        static Notification.Action.Builder createBuilder(int r1, CharSequence r2, PendingIntent r3) {
            return new Notification.Action.Builder(r1, r2, r3);
        }

        static Notification.Action.Builder addRemoteInput(Notification.Action.Builder r0, android.app.RemoteInput r1) {
            return r0.addRemoteInput(r1);
        }

        static Notification.Action.Builder addExtras(Notification.Action.Builder r0, Bundle r1) {
            return r0.addExtras(r1);
        }

        static Notification.Builder addAction(Notification.Builder r0, Notification.Action r1) {
            return r0.addAction(r1);
        }

        static Notification.Action build(Notification.Action.Builder r0) {
            return r0.build();
        }

        static String getGroup(Notification r0) {
            return r0.getGroup();
        }

        static Notification.Builder setGroup(Notification.Builder r0, String r1) {
            return r0.setGroup(r1);
        }

        static Notification.Builder setGroupSummary(Notification.Builder r0, boolean r1) {
            return r0.setGroupSummary(r1);
        }

        static Notification.Builder setLocalOnly(Notification.Builder r0, boolean r1) {
            return r0.setLocalOnly(r1);
        }

        static Notification.Builder setSortKey(Notification.Builder r0, String r1) {
            return r0.setSortKey(r1);
        }
    }

    static class Api21Impl {
        private Api21Impl() {
        }

        static Notification.Builder addPerson(Notification.Builder r0, String r1) {
            return r0.addPerson(r1);
        }

        static Notification.Builder setCategory(Notification.Builder r0, String r1) {
            return r0.setCategory(r1);
        }

        static Notification.Builder setColor(Notification.Builder r0, int r1) {
            return r0.setColor(r1);
        }

        static Notification.Builder setVisibility(Notification.Builder r0, int r1) {
            return r0.setVisibility(r1);
        }

        static Notification.Builder setPublicVersion(Notification.Builder r0, Notification r1) {
            return r0.setPublicVersion(r1);
        }

        static Notification.Builder setSound(Notification.Builder r0, Uri r1, Object r2) {
            return r0.setSound(r1, (AudioAttributes) r2);
        }
    }

    static class Api23Impl {
        private Api23Impl() {
        }

        static Notification.Action.Builder createBuilder(Icon r1, CharSequence r2, PendingIntent r3) {
            return new Notification.Action.Builder(r1, r2, r3);
        }

        static Notification.Builder setSmallIcon(Notification.Builder r0, Object r1) {
            return r0.setSmallIcon((Icon) r1);
        }
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static Notification.Action.Builder setAllowGeneratedReplies(Notification.Action.Builder r0, boolean r1) {
            return r0.setAllowGeneratedReplies(r1);
        }

        static Notification.Builder setRemoteInputHistory(Notification.Builder r0, CharSequence[] r1) {
            return r0.setRemoteInputHistory(r1);
        }

        static Notification.Builder setCustomContentView(Notification.Builder r0, RemoteViews r1) {
            return r0.setCustomContentView(r1);
        }

        static Notification.Builder setCustomBigContentView(Notification.Builder r0, RemoteViews r1) {
            return r0.setCustomBigContentView(r1);
        }

        static Notification.Builder setCustomHeadsUpContentView(Notification.Builder r0, RemoteViews r1) {
            return r0.setCustomHeadsUpContentView(r1);
        }
    }

    static class Api26Impl {
        private Api26Impl() {
        }

        static Notification.Builder createBuilder(Context r1, String r2) {
            return new Notification.Builder(r1, r2);
        }

        static Notification.Builder setGroupAlertBehavior(Notification.Builder r0, int r1) {
            return r0.setGroupAlertBehavior(r1);
        }

        static Notification.Builder setColorized(Notification.Builder r0, boolean r1) {
            return r0.setColorized(r1);
        }

        static Notification.Builder setBadgeIconType(Notification.Builder r0, int r1) {
            return r0.setBadgeIconType(r1);
        }

        static Notification.Builder setSettingsText(Notification.Builder r0, CharSequence r1) {
            return r0.setSettingsText(r1);
        }

        static Notification.Builder setShortcutId(Notification.Builder r0, String r1) {
            return r0.setShortcutId(r1);
        }

        static Notification.Builder setTimeoutAfter(Notification.Builder r0, long r1) {
            return r0.setTimeoutAfter(r1);
        }
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static Notification.Action.Builder setSemanticAction(Notification.Action.Builder r0, int r1) {
            return r0.setSemanticAction(r1);
        }

        static Notification.Builder addPerson(Notification.Builder r0, android.app.Person r1) {
            return r0.addPerson(r1);
        }
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static Notification.Action.Builder setContextual(Notification.Action.Builder r0, boolean r1) {
            return r0.setContextual(r1);
        }

        static Notification.Builder setLocusId(Notification.Builder r0, Object r1) {
            return r0.setLocusId((LocusId) r1);
        }

        static Notification.Builder setBubbleMetadata(Notification.Builder r0, Notification.BubbleMetadata r1) {
            return r0.setBubbleMetadata(r1);
        }

        static Notification.Builder setAllowSystemGeneratedContextualActions(Notification.Builder r0, boolean r1) {
            return r0.setAllowSystemGeneratedContextualActions(r1);
        }
    }

    static class Api31Impl {
        private Api31Impl() {
        }

        static Notification.Action.Builder setAuthenticationRequired(Notification.Action.Builder r0, boolean r1) {
            return r0.setAuthenticationRequired(r1);
        }

        static Notification.Builder setForegroundServiceBehavior(Notification.Builder r0, int r1) {
            return r0.setForegroundServiceBehavior(r1);
        }
    }

    NotificationCompatBuilder(NotificationCompat.Builder r12) {
        this.mActionExtrasList = new ArrayList();
        this.mExtras = new Bundle();
        this.mBuilderCompat = r12;
        this.mContext = r12.mContext;
        Notification.Builder r0 = Api26Impl.createBuilder(r12.mContext, r12.mChannelId);
        this.mBuilder = r0;
        Notification r1 = r12.mNotification;
        Notification.Builder r2 = r0.setWhen(r1.when).setSmallIcon(r1.icon, r1.iconLevel).setContent(r1.contentView).setTicker(r1.tickerText, r12.mTickerView).setVibrate(r1.vibrate).setLights(r1.ledARGB, r1.ledOnMS, r1.ledOffMS);
        if ((r1.flags & 2) == 0) goto L5;
        boolean r3 = true;
    L6:
        Notification.Builder r4 = r2.setOngoing(r3);
        if ((r1.flags & 8) == 0) goto L9;
        boolean r5 = true;
    L10:
        Notification.Builder r6 = r4.setOnlyAlertOnce(r5);
        if ((r1.flags & 16) == 0) goto L13;
        boolean r7 = true;
    L14:
        Notification.Builder r8 = r6.setAutoCancel(r7).setDefaults(r1.defaults).setContentTitle(r12.mContentTitle).setContentText(r12.mContentText).setContentInfo(r12.mContentInfo).setContentIntent(r12.mContentIntent).setDeleteIntent(r1.deleteIntent);
        PendingIntent r9 = r12.mFullScreenIntent;
        if ((r1.flags & 128) == 0) goto L17;
        boolean r10 = true;
    L18:
        r8.setFullScreenIntent(r9, r10).setLargeIcon(r12.mLargeIcon).setNumber(r12.mNumber).setProgress(r12.mProgressMax, r12.mProgress, r12.mProgressIndeterminate);
        Api16Impl.setPriority(Api16Impl.setUsesChronometer(Api16Impl.setSubText(r0, r12.mSubText), r12.mUseChronometer), r12.mPriority);
        Iterator<NotificationCompat.Action> r11 = r12.mActions.iterator();
    L20:
        if (r11.hasNext() == false) goto L23;
        addAction(r11.next());
        goto L20
    L23:
        if (r12.mExtras == null) goto L25;
        this.mExtras.putAll(r12.mExtras);
    L25:
        this.mContentView = r12.mContentView;
        this.mBigContentView = r12.mBigContentView;
        Api17Impl.setShowWhen(this.mBuilder, r12.mShowWhen);
        Api20Impl.setLocalOnly(this.mBuilder, r12.mLocalOnly);
        Api20Impl.setGroup(this.mBuilder, r12.mGroupKey);
        Api20Impl.setSortKey(this.mBuilder, r12.mSortKey);
        Api20Impl.setGroupSummary(this.mBuilder, r12.mGroupSummary);
        this.mGroupAlertBehavior = r12.mGroupAlertBehavior;
        Api21Impl.setCategory(this.mBuilder, r12.mCategory);
        Api21Impl.setColor(this.mBuilder, r12.mColor);
        Api21Impl.setVisibility(this.mBuilder, r12.mVisibility);
        Api21Impl.setPublicVersion(this.mBuilder, r12.mPublicVersion);
        Api21Impl.setSound(this.mBuilder, r1.sound, r1.audioAttributes);
        ArrayList<String> r13 = r12.mPeople;
        if (r13 != null) goto L28;
    L33:
        this.mHeadsUpContentView = r12.mHeadsUpContentView;
        if (r12.mInvisibleActions.size() <= 0) goto L44;
        Bundle r14 = r12.getExtras().getBundle("android.car.EXTENSIONS");
        if (r14 != null) goto L38;
        r14 = new Bundle();
    L38:
        Bundle r15 = new Bundle(r14);
        Bundle r16 = new Bundle();
        int r17 = 0;
    L40:
        if (r17 >= r12.mInvisibleActions.size()) goto L42;
        r16.putBundle(Integer.toString(r17), NotificationCompatJellybean.getBundleForAction(r12.mInvisibleActions.get(r17)));
        r17 = r17 + 1;
        goto L40
    L42:
        r14.putBundle("invisible_actions", r16);
        r15.putBundle("invisible_actions", r16);
        r12.getExtras().putBundle("android.car.EXTENSIONS", r14);
        this.mExtras.putBundle("android.car.EXTENSIONS", r15);
    L44:
        if (r12.mSmallIcon == null) goto L46;
        Api23Impl.setSmallIcon(this.mBuilder, r12.mSmallIcon);
    L46:
        Api19Impl.setExtras(this.mBuilder, r12.mExtras);
        Api24Impl.setRemoteInputHistory(this.mBuilder, r12.mRemoteInputHistory);
        if (r12.mContentView == null) goto L50;
        Api24Impl.setCustomContentView(this.mBuilder, r12.mContentView);
    L50:
        if (r12.mBigContentView == null) goto L53;
        Api24Impl.setCustomBigContentView(this.mBuilder, r12.mBigContentView);
    L53:
        if (r12.mHeadsUpContentView == null) goto L55;
        Api24Impl.setCustomHeadsUpContentView(this.mBuilder, r12.mHeadsUpContentView);
    L55:
        Api26Impl.setBadgeIconType(this.mBuilder, r12.mBadgeIcon);
        Api26Impl.setSettingsText(this.mBuilder, r12.mSettingsText);
        Api26Impl.setShortcutId(this.mBuilder, r12.mShortcutId);
        Api26Impl.setTimeoutAfter(this.mBuilder, r12.mTimeout);
        Api26Impl.setGroupAlertBehavior(this.mBuilder, r12.mGroupAlertBehavior);
        if (r12.mColorizedSet == false) goto L59;
        Api26Impl.setColorized(this.mBuilder, r12.mColorized);
    L59:
        if (TextUtils.isEmpty(r12.mChannelId) == true) goto L61;
        this.mBuilder.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
    L61:
        Iterator<Person> r18 = r12.mPersonList.iterator();
    L63:
        if (r18.hasNext() == false) goto L65;
        Api28Impl.addPerson(this.mBuilder, r18.next().toAndroidPerson());
        goto L63
    L65:
        Api29Impl.setAllowSystemGeneratedContextualActions(this.mBuilder, r12.mAllowSystemGeneratedContextualActions);
        Api29Impl.setBubbleMetadata(this.mBuilder, NotificationCompat.BubbleMetadata.toPlatform(r12.mBubbleMetadata));
        if (r12.mLocusId == null) goto L69;
        Api29Impl.setLocusId(this.mBuilder, r12.mLocusId.toLocusId());
    L69:
        if (r12.mFgsDeferBehavior == 0) goto L72;
        Api31Impl.setForegroundServiceBehavior(this.mBuilder, r12.mFgsDeferBehavior);
    L72:
        if (r12.mSilent == true) goto L74;
        return;
    L74:
        if (this.mBuilderCompat.mGroupSummary == false) goto L76;
        this.mGroupAlertBehavior = 2;
    L77:
        this.mBuilder.setVibrate(null);
        this.mBuilder.setSound(null);
        r1.defaults &= -2;
        r1.defaults &= -3;
        this.mBuilder.setDefaults(r1.defaults);
        if (TextUtils.isEmpty(this.mBuilderCompat.mGroupKey) == false) goto L80;
        Api20Impl.setGroup(this.mBuilder, NotificationCompat.GROUP_KEY_SILENT);
    L80:
        Api26Impl.setGroupAlertBehavior(this.mBuilder, this.mGroupAlertBehavior);
        return;
    L76:
        this.mGroupAlertBehavior = 1;
        goto L77
    L28:
        if (r13.isEmpty() == true) goto L33;
        Iterator<String> r19 = r13.iterator();
    L31:
        if (r19.hasNext() == false) goto L33;
        Api21Impl.addPerson(this.mBuilder, r19.next());
        goto L31
    L17:
        r10 = false;
        goto L18
    L13:
        r7 = false;
        goto L14
    L9:
        r5 = false;
        goto L10
    L5:
        r3 = false;
        goto L6
    }

    private static List<String> combineLists(List<String> r3, List<String> r4) {
        if (r3 != null) goto L4;
        return r4;
    L4:
        if (r4 != null) goto L6;
        return r3;
    L6:
        ArraySet r0 = new ArraySet(r3.size() + r4.size());
        r0.addAll(r3);
        r0.addAll(r4);
        return new ArrayList(r0);
    }

    private static List<String> getPeople(List<Person> r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        ArrayList r0 = new ArrayList(r2.size());
        Iterator<Person> r3 = r2.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        r0.add(r3.next().resolveToLegacyUri());
        goto L7
    L9:
        return r0;
    }

    @Override // androidx.core.app.NotificationBuilderWithBuilderAccessor
    public Notification.Builder getBuilder() {
        return this.mBuilder;
    }

    Context getContext() {
        return this.mContext;
    }

    public Notification build() {
        NotificationCompat.Style r0 = this.mBuilderCompat.mStyle;
        if (r0 == null) goto L5;
        r0.apply(this);
    L5:
        if (r0 == null) goto L7;
        RemoteViews r1 = r0.makeContentView(this);
    L8:
        Notification r2 = buildInternal();
        if (r1 == null) goto L12;
        r2.contentView = r1;
    L14:
        if (r0 == null) goto L18;
        RemoteViews r3 = r0.makeBigContentView(this);
        if (r3 == null) goto L18;
        r2.bigContentView = r3;
    L18:
        if (r0 == null) goto L22;
        RemoteViews r4 = this.mBuilderCompat.mStyle.makeHeadsUpContentView(this);
        if (r4 == null) goto L22;
        r2.headsUpContentView = r4;
    L22:
        if (r0 == null) goto L26;
        Bundle r5 = NotificationCompat.getExtras(r2);
        if (r5 == null) goto L26;
        r0.addCompatExtras(r5);
    L26:
        return r2;
    L12:
        if (this.mBuilderCompat.mContentView == null) goto L14;
        r2.contentView = this.mBuilderCompat.mContentView;
        goto L14
    L7:
        r1 = null;
        goto L8
    }

    private void addAction(NotificationCompat.Action r6) {
        IconCompat r0 = r6.getIconCompat();
        if (r0 == null) goto L5;
        Icon r1 = r0.toIcon();
    L6:
        Notification.Action.Builder r2 = Api23Impl.createBuilder(r1, r6.getTitle(), r6.getActionIntent());
        if (r6.getRemoteInputs() == null) goto L12;
        android.app.RemoteInput[] r3 = RemoteInput.fromCompat(r6.getRemoteInputs());
        int r4 = r3.length;
        int r5 = 0;
    L9:
        if (r5 >= r4) goto L12;
        Api20Impl.addRemoteInput(r2, r3[r5]);
        r5 = r5 + 1;
    L12:
        if (r6.getExtras() == null) goto L14;
        Bundle r7 = new Bundle(r6.getExtras());
    L15:
        r7.putBoolean("android.support.allowGeneratedReplies", r6.getAllowGeneratedReplies());
        Api24Impl.setAllowGeneratedReplies(r2, r6.getAllowGeneratedReplies());
        r7.putInt("android.support.action.semanticAction", r6.getSemanticAction());
        Api28Impl.setSemanticAction(r2, r6.getSemanticAction());
        Api29Impl.setContextual(r2, r6.isContextual());
        Api31Impl.setAuthenticationRequired(r2, r6.isAuthenticationRequired());
        r7.putBoolean("android.support.action.showsUserInterface", r6.getShowsUserInterface());
        Api20Impl.addExtras(r2, r7);
        Api20Impl.addAction(this.mBuilder, Api20Impl.build(r2));
        return;
    L14:
        r7 = new Bundle();
        goto L15
    L5:
        r1 = null;
        goto L6
    }

    protected Notification buildInternal() {
        return Api16Impl.build(this.mBuilder);
    }

    private void removeSoundAndVibration(Notification r1) {
        r1.sound = null;
        r1.vibrate = null;
        r1.defaults &= -2;
        r1.defaults &= -3;
    }
}
