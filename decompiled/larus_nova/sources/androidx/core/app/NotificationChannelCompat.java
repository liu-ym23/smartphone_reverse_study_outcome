package androidx.core.app;

import android.app.Notification;
import android.app.NotificationChannel;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes17.dex */
public class NotificationChannelCompat {
    public static final String DEFAULT_CHANNEL_ID = "miscellaneous";
    private static final int DEFAULT_LIGHT_COLOR = 0;
    private static final boolean DEFAULT_SHOW_BADGE = true;
    AudioAttributes mAudioAttributes;
    private boolean mBypassDnd;
    private boolean mCanBubble;
    String mConversationId;
    String mDescription;
    String mGroupId;
    final String mId;
    int mImportance;
    private boolean mImportantConversation;
    int mLightColor;
    boolean mLights;
    private int mLockscreenVisibility;
    CharSequence mName;
    String mParentId;
    boolean mShowBadge;
    Uri mSound;
    boolean mVibrationEnabled;
    long[] mVibrationPattern;

    public static class Api26Impl {
        private Api26Impl() {
        }

        public static boolean canBypassDnd(NotificationChannel r100) {
            return r100.canBypassDnd();
        }

        public static boolean canShowBadge(NotificationChannel r100) {
            return r100.canShowBadge();
        }

        public static AudioAttributes getAudioAttributes(NotificationChannel r100) {
            return r100.getAudioAttributes();
        }

        public static String getDescription(NotificationChannel r100) {
            return r100.getDescription();
        }

        public static String getGroup(NotificationChannel r100) {
            return r100.getGroup();
        }

        public static String getId(NotificationChannel r100) {
            return r100.getId();
        }

        public static int getImportance(NotificationChannel r100) {
            return r100.getImportance();
        }

        public static int getLightColor(NotificationChannel r100) {
            return r100.getLightColor();
        }

        public static int getLockscreenVisibility(NotificationChannel r100) {
            return r100.getLockscreenVisibility();
        }

        public static CharSequence getName(NotificationChannel r100) {
            return r100.getName();
        }

        public static Uri getSound(NotificationChannel r100) {
            return r100.getSound();
        }

        public static long[] getVibrationPattern(NotificationChannel r100) {
            return r100.getVibrationPattern();
        }

        public static boolean shouldShowLights(NotificationChannel r100) {
            return r100.shouldShowLights();
        }

        public static boolean shouldVibrate(NotificationChannel r100) {
            return r100.shouldVibrate();
        }

        public static void enableLights(NotificationChannel r100, boolean r101) {
            r100.enableLights(r101);
        }

        public static void enableVibration(NotificationChannel r100, boolean r101) {
            r100.enableVibration(r101);
        }

        public static void setDescription(NotificationChannel r100, String r101) {
            r100.setDescription(r101);
        }

        public static void setGroup(NotificationChannel r100, String r101) {
            r100.setGroup(r101);
        }

        public static void setLightColor(NotificationChannel r100, int r101) {
            r100.setLightColor(r101);
        }

        public static void setShowBadge(NotificationChannel r100, boolean r101) {
            r100.setShowBadge(r101);
        }

        public static void setVibrationPattern(NotificationChannel r100, long[] r101) {
            r100.setVibrationPattern(r101);
        }

        public static NotificationChannel createNotificationChannel(String r100, CharSequence r101, int r102) {
            return new NotificationChannel(r100, r101, r102);
        }

        public static void setSound(NotificationChannel r100, Uri r101, AudioAttributes r102) {
            r100.setSound(r101, r102);
        }
    }

    public static class Api29Impl {
        private Api29Impl() {
        }

        public static boolean canBubble(NotificationChannel r100) {
            return r100.canBubble();
        }
    }

    public static class Api30Impl {
        private Api30Impl() {
        }

        public static String getConversationId(NotificationChannel r100) {
            return r100.getConversationId();
        }

        public static String getParentChannelId(NotificationChannel r100) {
            return r100.getParentChannelId();
        }

        public static boolean isImportantConversation(NotificationChannel r100) {
            return r100.isImportantConversation();
        }

        public static void setConversationId(NotificationChannel r100, String r101, String r102) {
            r100.setConversationId(r101, r102);
        }
    }

    public static class Builder {
        private final NotificationChannelCompat mChannel;

        public NotificationChannelCompat build() {
            return this.mChannel;
        }

        public Builder setDescription(String r100) {
            this.mChannel.mDescription = r100;
            return this;
        }

        public Builder setGroup(String r100) {
            this.mChannel.mGroupId = r100;
            return this;
        }

        public Builder setImportance(int r100) {
            this.mChannel.mImportance = r100;
            return this;
        }

        public Builder setLightColor(int r100) {
            this.mChannel.mLightColor = r100;
            return this;
        }

        public Builder setLightsEnabled(boolean r100) {
            this.mChannel.mLights = r100;
            return this;
        }

        public Builder setName(CharSequence r100) {
            this.mChannel.mName = r100;
            return this;
        }

        public Builder setShowBadge(boolean r100) {
            this.mChannel.mShowBadge = r100;
            return this;
        }

        public Builder setVibrationEnabled(boolean r100) {
            this.mChannel.mVibrationEnabled = r100;
            return this;
        }

        public Builder setVibrationPattern(long[] r100) {
            NotificationChannelCompat r101 = this.mChannel;
            if (r100 != null) goto L5;
        L7:
            boolean r102 = false;
        L8:
            r101.mVibrationEnabled = r102;
            r101.mVibrationPattern = r100;
            return this;
        L5:
            if (r100.length <= 0) goto L7;
            r102 = true;
            goto L8
        }

        public Builder(String r100, int r101) {
            this.mChannel = new NotificationChannelCompat(r100, r101);
        }

        public Builder setConversationId(String r100, String r101) {
            if (Build.VERSION.SDK_INT < 30) goto L5;
            NotificationChannelCompat r102 = this.mChannel;
            r102.mParentId = r100;
            r102.mConversationId = r101;
        L5:
            return this;
        }

        public Builder setSound(Uri r100, AudioAttributes r101) {
            NotificationChannelCompat r102 = this.mChannel;
            r102.mSound = r100;
            r102.mAudioAttributes = r101;
            return this;
        }
    }

    public NotificationChannel getNotificationChannel() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 >= 26) goto L6;
        return null;
    L6:
        NotificationChannel r101 = Api26Impl.createNotificationChannel(this.mId, this.mName, this.mImportance);
        Api26Impl.setDescription(r101, this.mDescription);
        Api26Impl.setGroup(r101, this.mGroupId);
        Api26Impl.setShowBadge(r101, this.mShowBadge);
        Api26Impl.setSound(r101, this.mSound, this.mAudioAttributes);
        Api26Impl.enableLights(r101, this.mLights);
        Api26Impl.setLightColor(r101, this.mLightColor);
        Api26Impl.setVibrationPattern(r101, this.mVibrationPattern);
        Api26Impl.enableVibration(r101, this.mVibrationEnabled);
        if (r100 < 30) goto L13;
        String r102 = this.mParentId;
        if (r102 == null) goto L13;
        String r103 = this.mConversationId;
        if (r103 == null) goto L13;
        Api30Impl.setConversationId(r101, r102, r103);
    L13:
        return r101;
    }

    public Builder toBuilder() {
        return new Builder(this.mId, this.mImportance).setName(this.mName).setDescription(this.mDescription).setGroup(this.mGroupId).setShowBadge(this.mShowBadge).setSound(this.mSound, this.mAudioAttributes).setLightsEnabled(this.mLights).setLightColor(this.mLightColor).setVibrationEnabled(this.mVibrationEnabled).setVibrationPattern(this.mVibrationPattern).setConversationId(this.mParentId, this.mConversationId);
    }

    public boolean canBubble() {
        return this.mCanBubble;
    }

    public boolean canBypassDnd() {
        return this.mBypassDnd;
    }

    public boolean canShowBadge() {
        return this.mShowBadge;
    }

    public AudioAttributes getAudioAttributes() {
        return this.mAudioAttributes;
    }

    public String getConversationId() {
        return this.mConversationId;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public String getGroup() {
        return this.mGroupId;
    }

    public String getId() {
        return this.mId;
    }

    public int getImportance() {
        return this.mImportance;
    }

    public int getLightColor() {
        return this.mLightColor;
    }

    public int getLockscreenVisibility() {
        return this.mLockscreenVisibility;
    }

    public CharSequence getName() {
        return this.mName;
    }

    public String getParentChannelId() {
        return this.mParentId;
    }

    public Uri getSound() {
        return this.mSound;
    }

    public long[] getVibrationPattern() {
        return this.mVibrationPattern;
    }

    public boolean isImportantConversation() {
        return this.mImportantConversation;
    }

    public boolean shouldShowLights() {
        return this.mLights;
    }

    public boolean shouldVibrate() {
        return this.mVibrationEnabled;
    }

    public NotificationChannelCompat(NotificationChannel r100) {
        this(Api26Impl.getId(r100), Api26Impl.getImportance(r100));
        this.mName = Api26Impl.getName(r100);
        this.mDescription = Api26Impl.getDescription(r100);
        this.mGroupId = Api26Impl.getGroup(r100);
        this.mShowBadge = Api26Impl.canShowBadge(r100);
        this.mSound = Api26Impl.getSound(r100);
        this.mAudioAttributes = Api26Impl.getAudioAttributes(r100);
        this.mLights = Api26Impl.shouldShowLights(r100);
        this.mLightColor = Api26Impl.getLightColor(r100);
        this.mVibrationEnabled = Api26Impl.shouldVibrate(r100);
        this.mVibrationPattern = Api26Impl.getVibrationPattern(r100);
        int r101 = Build.VERSION.SDK_INT;
        if (r101 < 30) goto L5;
        this.mParentId = Api30Impl.getParentChannelId(r100);
        this.mConversationId = Api30Impl.getConversationId(r100);
    L5:
        this.mBypassDnd = Api26Impl.canBypassDnd(r100);
        this.mLockscreenVisibility = Api26Impl.getLockscreenVisibility(r100);
        if (r101 < 29) goto L8;
        this.mCanBubble = Api29Impl.canBubble(r100);
    L8:
        if (r101 < 30) goto L11;
        this.mImportantConversation = Api30Impl.isImportantConversation(r100);
        return;
    }

    public NotificationChannelCompat(String r100, int r101) {
        this.mShowBadge = true;
        this.mSound = Settings.System.DEFAULT_NOTIFICATION_URI;
        this.mLightColor = 0;
        this.mId = (String) Preconditions.checkNotNull(r100);
        this.mImportance = r101;
        this.mAudioAttributes = Notification.AUDIO_ATTRIBUTES_DEFAULT;
    }
}
