package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.LocusId;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.collection.ArraySet;
import androidx.core.content.LocusIdCompat;
import androidx.core.graphics.drawable.IconCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes17.dex */
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

    public static class Api20Impl {
        private Api20Impl() {
        }

        public static Notification.Action build(Notification.Action.Builder r100) {
            return r100.build();
        }

        public static String getGroup(Notification r100) {
            return r100.getGroup();
        }

        public static Notification.Builder addAction(Notification.Builder r100, Notification.Action r101) {
            return r100.addAction(r101);
        }

        public static Notification.Action.Builder addExtras(Notification.Action.Builder r100, Bundle r101) {
            return r100.addExtras(r101);
        }

        public static Notification.Action.Builder addRemoteInput(Notification.Action.Builder r100, android.app.RemoteInput r101) {
            return r100.addRemoteInput(r101);
        }

        public static Notification.Builder setGroup(Notification.Builder r100, String r101) {
            return r100.setGroup(r101);
        }

        public static Notification.Builder setGroupSummary(Notification.Builder r100, boolean r101) {
            return r100.setGroupSummary(r101);
        }

        public static Notification.Builder setLocalOnly(Notification.Builder r100, boolean r101) {
            return r100.setLocalOnly(r101);
        }

        public static Notification.Builder setSortKey(Notification.Builder r100, String r101) {
            return r100.setSortKey(r101);
        }

        public static Notification.Action.Builder createBuilder(int r100, CharSequence r101, PendingIntent r102) {
            return new Notification.Action.Builder(r100, r101, r102);
        }
    }

    public static class Api21Impl {
        private Api21Impl() {
        }

        public static Notification.Builder addPerson(Notification.Builder r100, String r101) {
            return r100.addPerson(r101);
        }

        public static Notification.Builder setCategory(Notification.Builder r100, String r101) {
            return r100.setCategory(r101);
        }

        public static Notification.Builder setColor(Notification.Builder r100, int r101) {
            return r100.setColor(r101);
        }

        public static Notification.Builder setPublicVersion(Notification.Builder r100, Notification r101) {
            return r100.setPublicVersion(r101);
        }

        public static Notification.Builder setVisibility(Notification.Builder r100, int r101) {
            return r100.setVisibility(r101);
        }

        public static Notification.Builder setSound(Notification.Builder r100, Uri r101, Object r102) {
            return r100.setSound(r101, (AudioAttributes) r102);
        }
    }

    public static class Api23Impl {
        private Api23Impl() {
        }

        public static Notification.Builder setLargeIcon(Notification.Builder r100, Icon r101) {
            return r100.setLargeIcon(r101);
        }

        public static Notification.Builder setSmallIcon(Notification.Builder r100, Object r101) {
            return r100.setSmallIcon((Icon) r101);
        }

        public static Notification.Action.Builder createBuilder(Icon r100, CharSequence r101, PendingIntent r102) {
            return new Notification.Action.Builder(r100, r101, r102);
        }
    }

    public static class Api24Impl {
        private Api24Impl() {
        }

        public static Notification.Action.Builder setAllowGeneratedReplies(Notification.Action.Builder r100, boolean r101) {
            return r100.setAllowGeneratedReplies(r101);
        }

        public static Notification.Builder setCustomBigContentView(Notification.Builder r100, RemoteViews r101) {
            return r100.setCustomBigContentView(r101);
        }

        public static Notification.Builder setCustomContentView(Notification.Builder r100, RemoteViews r101) {
            return r100.setCustomContentView(r101);
        }

        public static Notification.Builder setCustomHeadsUpContentView(Notification.Builder r100, RemoteViews r101) {
            return r100.setCustomHeadsUpContentView(r101);
        }

        public static Notification.Builder setRemoteInputHistory(Notification.Builder r100, CharSequence[] r101) {
            return r100.setRemoteInputHistory(r101);
        }
    }

    public static class Api26Impl {
        private Api26Impl() {
        }

        public static Notification.Builder createBuilder(Context r100, String r101) {
            return new Notification.Builder(r100, r101);
        }

        public static Notification.Builder setBadgeIconType(Notification.Builder r100, int r101) {
            return r100.setBadgeIconType(r101);
        }

        public static Notification.Builder setColorized(Notification.Builder r100, boolean r101) {
            return r100.setColorized(r101);
        }

        public static Notification.Builder setGroupAlertBehavior(Notification.Builder r100, int r101) {
            return r100.setGroupAlertBehavior(r101);
        }

        public static Notification.Builder setSettingsText(Notification.Builder r100, CharSequence r101) {
            return r100.setSettingsText(r101);
        }

        public static Notification.Builder setShortcutId(Notification.Builder r100, String r101) {
            return r100.setShortcutId(r101);
        }

        public static Notification.Builder setTimeoutAfter(Notification.Builder r100, long r101) {
            return r100.setTimeoutAfter(r101);
        }
    }

    public static class Api28Impl {
        private Api28Impl() {
        }

        public static Notification.Builder addPerson(Notification.Builder r100, android.app.Person r101) {
            return r100.addPerson(r101);
        }

        public static Notification.Action.Builder setSemanticAction(Notification.Action.Builder r100, int r101) {
            return r100.setSemanticAction(r101);
        }
    }

    public static class Api29Impl {
        private Api29Impl() {
        }

        public static Notification.Builder setAllowSystemGeneratedContextualActions(Notification.Builder r100, boolean r101) {
            return r100.setAllowSystemGeneratedContextualActions(r101);
        }

        public static Notification.Builder setBubbleMetadata(Notification.Builder r100, Notification.BubbleMetadata r101) {
            return r100.setBubbleMetadata(r101);
        }

        public static Notification.Action.Builder setContextual(Notification.Action.Builder r100, boolean r101) {
            return r100.setContextual(r101);
        }

        public static Notification.Builder setLocusId(Notification.Builder r100, Object r101) {
            return r100.setLocusId((LocusId) r101);
        }
    }

    public static class Api31Impl {
        private Api31Impl() {
        }

        public static Notification.Action.Builder setAuthenticationRequired(Notification.Action.Builder r100, boolean r101) {
            return r100.setAuthenticationRequired(r101);
        }

        public static Notification.Builder setForegroundServiceBehavior(Notification.Builder r100, int r101) {
            return r100.setForegroundServiceBehavior(r101);
        }
    }

    public Notification build() {
        NotificationCompat.Style r100 = this.mBuilderCompat.mStyle;
        if (r100 == null) goto L5;
        r100.apply(this);
    L5:
        if (r100 == null) goto L7;
        RemoteViews r101 = r100.makeContentView(this);
    L8:
        Notification r102 = buildInternal();
        if (r101 == null) goto L11;
        r102.contentView = r101;
    L14:
        if (r100 == null) goto L18;
        RemoteViews r103 = r100.makeBigContentView(this);
        if (r103 == null) goto L18;
        r102.bigContentView = r103;
    L18:
        if (r100 == null) goto L22;
        RemoteViews r104 = this.mBuilderCompat.mStyle.makeHeadsUpContentView(this);
        if (r104 == null) goto L22;
        r102.headsUpContentView = r104;
    L22:
        if (r100 == null) goto L26;
        Bundle r105 = NotificationCompat.getExtras(r102);
        if (r105 == null) goto L26;
        r100.addCompatExtras(r105);
    L26:
        return r102;
    L11:
        RemoteViews r106 = this.mBuilderCompat.mContentView;
        if (r106 == null) goto L14;
        r102.contentView = r106;
        goto L14
    L7:
        r101 = null;
        goto L8
    }

    public Notification buildInternal() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 < 26) goto L7;
        return this.mBuilder.build();
    L7:
        if (r100 < 24) goto L25;
        Notification r101 = this.mBuilder.build();
        if (this.mGroupAlertBehavior != 0) goto L11;
    L24:
        return r101;
    L11:
        if (Api20Impl.getGroup(r101) == null) goto L18;
        if ((r101.flags & 512) == 0) goto L18;
        if (this.mGroupAlertBehavior != 2) goto L18;
        removeSoundAndVibration(r101);
    L18:
        if (Api20Impl.getGroup(r101) == null) goto L24;
        if ((r101.flags & 512) != 0) goto L24;
        if (this.mGroupAlertBehavior != 1) goto L24;
        removeSoundAndVibration(r101);
        goto L24
    L25:
        this.mBuilder.setExtras(this.mExtras);
        Notification r102 = this.mBuilder.build();
        RemoteViews r103 = this.mContentView;
        if (r103 == null) goto L28;
        r102.contentView = r103;
    L28:
        RemoteViews r104 = this.mBigContentView;
        if (r104 == null) goto L31;
        r102.bigContentView = r104;
    L31:
        RemoteViews r105 = this.mHeadsUpContentView;
        if (r105 == null) goto L35;
        r102.headsUpContentView = r105;
    L35:
        if (this.mGroupAlertBehavior != 0) goto L37;
    L50:
        return r102;
    L37:
        if (Api20Impl.getGroup(r102) == null) goto L44;
        if ((r102.flags & 512) == 0) goto L44;
        if (this.mGroupAlertBehavior != 2) goto L44;
        removeSoundAndVibration(r102);
    L44:
        if (Api20Impl.getGroup(r102) == null) goto L50;
        if ((r102.flags & 512) != 0) goto L50;
        if (this.mGroupAlertBehavior != 1) goto L50;
        removeSoundAndVibration(r102);
        goto L50
    }

    @Override // androidx.core.app.NotificationBuilderWithBuilderAccessor
    public Notification.Builder getBuilder() {
        return this.mBuilder;
    }

    public Context getContext() {
        return this.mContext;
    }

    public NotificationCompatBuilder(NotificationCompat.Builder r110) {
        this.mActionExtrasList = new ArrayList();
        this.mExtras = new Bundle();
        this.mBuilderCompat = r110;
        Context r100 = r110.mContext;
        this.mContext = r100;
        int r101 = Build.VERSION.SDK_INT;
        if (r101 < 26) goto L5;
        this.mBuilder = Api26Impl.createBuilder(r100, r110.mChannelId);
    L6:
        Notification r102 = r110.mNotification;
        Notification.Builder r103 = this.mBuilder.setWhen(r102.when).setSmallIcon(r102.icon, r102.iconLevel).setContent(r102.contentView).setTicker(r102.tickerText, r110.mTickerView).setVibrate(r102.vibrate).setLights(r102.ledARGB, r102.ledOnMS, r102.ledOffMS);
        if ((r102.flags & 2) == 0) goto L9;
        boolean r104 = true;
    L10:
        Notification.Builder r105 = r103.setOngoing(r104);
        if ((r102.flags & 8) == 0) goto L13;
        boolean r106 = true;
    L14:
        Notification.Builder r107 = r105.setOnlyAlertOnce(r106);
        if ((r102.flags & 16) == 0) goto L17;
        boolean r108 = true;
    L18:
        Notification.Builder r109 = r107.setAutoCancel(r108).setDefaults(r102.defaults).setContentTitle(r110.mContentTitle).setContentText(r110.mContentText).setContentInfo(r110.mContentInfo).setContentIntent(r110.mContentIntent).setDeleteIntent(r102.deleteIntent);
        PendingIntent r111 = r110.mFullScreenIntent;
        if ((r102.flags & 128) == 0) goto L21;
        boolean r112 = true;
    L22:
        r109.setFullScreenIntent(r111, r112).setNumber(r110.mNumber).setProgress(r110.mProgressMax, r110.mProgress, r110.mProgressIndeterminate);
        if (r101 >= 23) goto L29;
        Notification.Builder r113 = this.mBuilder;
        IconCompat r114 = r110.mLargeIcon;
        if (r114 != null) goto L27;
        Bitmap r115 = null;
    L28:
        r113.setLargeIcon(r115);
    L34:
        this.mBuilder.setSubText(r110.mSubText).setUsesChronometer(r110.mUseChronometer).setPriority(r110.mPriority);
        NotificationCompat.Style r116 = r110.mStyle;
        if ((r116 instanceof NotificationCompat.CallStyle) == false) goto L40;
        Iterator<NotificationCompat.Action> r117 = ((NotificationCompat.CallStyle) r116).getActionsListWithSystemActions().iterator();
    L38:
        if (r117.hasNext() == false) goto L44;
        addAction(r117.next());
    L44:
        Bundle r118 = r110.mExtras;
        if (r118 == null) goto L47;
        this.mExtras.putAll(r118);
    L47:
        int r119 = Build.VERSION.SDK_INT;
        this.mContentView = r110.mContentView;
        this.mBigContentView = r110.mBigContentView;
        this.mBuilder.setShowWhen(r110.mShowWhen);
        Api20Impl.setLocalOnly(this.mBuilder, r110.mLocalOnly);
        Api20Impl.setGroup(this.mBuilder, r110.mGroupKey);
        Api20Impl.setSortKey(this.mBuilder, r110.mSortKey);
        Api20Impl.setGroupSummary(this.mBuilder, r110.mGroupSummary);
        this.mGroupAlertBehavior = r110.mGroupAlertBehavior;
        Api21Impl.setCategory(this.mBuilder, r110.mCategory);
        Api21Impl.setColor(this.mBuilder, r110.mColor);
        Api21Impl.setVisibility(this.mBuilder, r110.mVisibility);
        Api21Impl.setPublicVersion(this.mBuilder, r110.mPublicVersion);
        Api21Impl.setSound(this.mBuilder, r102.sound, r102.audioAttributes);
        if (r119 >= 28) goto L50;
        List r120 = combineLists(getPeople(r110.mPersonList), r110.mPeople);
    L51:
        if (r120 != null) goto L53;
    L58:
        this.mHeadsUpContentView = r110.mHeadsUpContentView;
        if (r110.mInvisibleActions.size() <= 0) goto L68;
        Bundle r121 = r110.getExtras().getBundle("android.car.EXTENSIONS");
        if (r121 != null) goto L63;
        r121 = new Bundle();
    L63:
        Bundle r122 = new Bundle(r121);
        Bundle r123 = new Bundle();
        int r124 = 0;
    L65:
        if (r124 >= r110.mInvisibleActions.size()) goto L67;
        r123.putBundle(Integer.toString(r124), NotificationCompatJellybean.getBundleForAction((NotificationCompat.Action) ListProtector.get(r110.mInvisibleActions, r124)));
        r124 = r124 + 1;
        goto L65
    L67:
        r121.putBundle("invisible_actions", r123);
        r122.putBundle("invisible_actions", r123);
        r110.getExtras().putBundle("android.car.EXTENSIONS", r121);
        this.mExtras.putBundle("android.car.EXTENSIONS", r122);
    L68:
        int r125 = Build.VERSION.SDK_INT;
        if (r125 < 23) goto L74;
        Object r126 = r110.mSmallIcon;
        if (r126 == null) goto L74;
        Api23Impl.setSmallIcon(this.mBuilder, r126);
    L74:
        if (r125 < 24) goto L84;
        this.mBuilder.setExtras(r110.mExtras);
        Api24Impl.setRemoteInputHistory(this.mBuilder, r110.mRemoteInputHistory);
        RemoteViews r127 = r110.mContentView;
        if (r127 == null) goto L78;
        Api24Impl.setCustomContentView(this.mBuilder, r127);
    L78:
        RemoteViews r128 = r110.mBigContentView;
        if (r128 == null) goto L81;
        Api24Impl.setCustomBigContentView(this.mBuilder, r128);
    L81:
        RemoteViews r129 = r110.mHeadsUpContentView;
        if (r129 == null) goto L84;
        Api24Impl.setCustomHeadsUpContentView(this.mBuilder, r129);
    L84:
        if (r125 < 26) goto L91;
        Api26Impl.setBadgeIconType(this.mBuilder, r110.mBadgeIcon);
        Api26Impl.setSettingsText(this.mBuilder, r110.mSettingsText);
        Api26Impl.setShortcutId(this.mBuilder, r110.mShortcutId);
        Api26Impl.setTimeoutAfter(this.mBuilder, r110.mTimeout);
        Api26Impl.setGroupAlertBehavior(this.mBuilder, r110.mGroupAlertBehavior);
        if (r110.mColorizedSet == false) goto L89;
        Api26Impl.setColorized(this.mBuilder, r110.mColorized);
    L89:
        if (TextUtils.isEmpty(r110.mChannelId) == true) goto L91;
        this.mBuilder.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
    L91:
        if (r125 < 28) goto L96;
        Iterator<Person> r130 = r110.mPersonList.iterator();
    L94:
        if (r130.hasNext() == false) goto L96;
        Api28Impl.addPerson(this.mBuilder, r130.next().toAndroidPerson());
    L96:
        int r131 = Build.VERSION.SDK_INT;
        if (r131 < 29) goto L102;
        Api29Impl.setAllowSystemGeneratedContextualActions(this.mBuilder, r110.mAllowSystemGeneratedContextualActions);
        Api29Impl.setBubbleMetadata(this.mBuilder, NotificationCompat.BubbleMetadata.toPlatform(r110.mBubbleMetadata));
        LocusIdCompat r132 = r110.mLocusId;
        if (r132 == null) goto L102;
        Api29Impl.setLocusId(this.mBuilder, r132.toLocusId());
    L102:
        if (r131 < 31) goto L107;
        int r133 = r110.mFgsDeferBehavior;
        if (r133 == 0) goto L107;
        Api31Impl.setForegroundServiceBehavior(this.mBuilder, r133);
    L107:
        if (r110.mSilent == true) goto L109;
        return;
    L109:
        if (this.mBuilderCompat.mGroupSummary == false) goto L111;
        this.mGroupAlertBehavior = 2;
    L112:
        this.mBuilder.setVibrate(null);
        this.mBuilder.setSound(null);
        int r134 = (r102.defaults & (-2)) & (-3);
        r102.defaults = r134;
        this.mBuilder.setDefaults(r134);
        if (r131 >= 26) goto L115;
        return;
    L115:
        if (TextUtils.isEmpty(this.mBuilderCompat.mGroupKey) == false) goto L117;
        Api20Impl.setGroup(this.mBuilder, NotificationCompat.GROUP_KEY_SILENT);
    L117:
        Api26Impl.setGroupAlertBehavior(this.mBuilder, this.mGroupAlertBehavior);
        return;
    L111:
        this.mGroupAlertBehavior = 1;
        goto L112
    L53:
        if (r120.isEmpty() == true) goto L58;
        Iterator r135 = r120.iterator();
    L56:
        if (r135.hasNext() == false) goto L58;
        Api21Impl.addPerson(this.mBuilder, (String) r135.next());
        goto L56
    L50:
        r120 = r110.mPeople;
        goto L51
    L40:
        Iterator<NotificationCompat.Action> r136 = r110.mActions.iterator();
    L42:
        if (r136.hasNext() == false) goto L44;
        addAction(r136.next());
        goto L42
    L27:
        r115 = r114.getBitmap();
        goto L28
    L29:
        Notification.Builder r137 = this.mBuilder;
        IconCompat r138 = r110.mLargeIcon;
        if (r138 != null) goto L32;
        Icon r139 = null;
    L33:
        Api23Impl.setLargeIcon(r137, r139);
        goto L34
    L32:
        r139 = r138.toIcon(r100);
        goto L33
    L21:
        r112 = false;
        goto L22
    L17:
        r108 = false;
        goto L18
    L13:
        r106 = false;
        goto L14
    L9:
        r104 = false;
        goto L10
    L5:
        this.mBuilder = new Notification.Builder(r110.mContext);
        goto L6
    }

    private void addAction(NotificationCompat.Action r100) {
        int r101 = Build.VERSION.SDK_INT;
        IconCompat r102 = r100.getIconCompat();
        int r103 = 0;
        if (r101 < 23) goto L8;
        if (r102 == null) goto L6;
        Icon r104 = r102.toIcon();
    L7:
        Notification.Action.Builder r105 = Api23Impl.createBuilder(r104, r100.getTitle(), r100.getActionIntent());
    L13:
        if (r100.getRemoteInputs() == null) goto L18;
        android.app.RemoteInput[] r106 = RemoteInput.fromCompat(r100.getRemoteInputs());
        int r107 = r106.length;
    L15:
        if (r103 >= r107) goto L18;
        Api20Impl.addRemoteInput(r105, r106[r103]);
        r103 = r103 + 1;
    L18:
        if (r100.getExtras() == null) goto L20;
        Bundle r108 = new Bundle(r100.getExtras());
    L21:
        r108.putBoolean("android.support.allowGeneratedReplies", r100.getAllowGeneratedReplies());
        int r109 = Build.VERSION.SDK_INT;
        if (r109 < 24) goto L24;
        Api24Impl.setAllowGeneratedReplies(r105, r100.getAllowGeneratedReplies());
    L24:
        r108.putInt("android.support.action.semanticAction", r100.getSemanticAction());
        if (r109 < 28) goto L28;
        Api28Impl.setSemanticAction(r105, r100.getSemanticAction());
    L28:
        if (r109 < 29) goto L31;
        Api29Impl.setContextual(r105, r100.isContextual());
    L31:
        if (r109 < 31) goto L33;
        Api31Impl.setAuthenticationRequired(r105, r100.isAuthenticationRequired());
    L33:
        r108.putBoolean("android.support.action.showsUserInterface", r100.getShowsUserInterface());
        Api20Impl.addExtras(r105, r108);
        Api20Impl.addAction(this.mBuilder, Api20Impl.build(r105));
        return;
    L20:
        r108 = new Bundle();
        goto L21
    L6:
        r104 = null;
        goto L7
    L8:
        if (r102 == null) goto L10;
        int r110 = r102.getResId();
    L11:
        r105 = Api20Impl.createBuilder(r110, r100.getTitle(), r100.getActionIntent());
        goto L13
    L10:
        r110 = 0;
        goto L11
    }

    private static List<String> getPeople(List<Person> r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        ArrayList r101 = new ArrayList(r100.size());
        Iterator<Person> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        r101.add(r102.next().resolveToLegacyUri());
        goto L7
    L9:
        return r101;
    }

    private void removeSoundAndVibration(Notification r100) {
        r100.sound = null;
        r100.vibrate = null;
        r100.defaults = (r100.defaults & (-2)) & (-3);
    }

    private static List<String> combineLists(List<String> r100, List<String> r101) {
        if (r100 != null) goto L4;
        return r101;
    L4:
        if (r101 != null) goto L6;
        return r100;
    L6:
        ArraySet r102 = new ArraySet(r100.size() + r101.size());
        r102.addAll(r100);
        r102.addAll(r101);
        return new ArrayList(r102);
    }
}
