package androidx.core.app;

import android.app.Notification;
import android.app.NotificationChannel;
import android.media.AudioAttributes;
import android.net.Uri;
import android.provider.Settings;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
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

    static class Api26Impl {
        private Api26Impl() {
        }

        static NotificationChannel createNotificationChannel(String r1, CharSequence r2, int r3) {
            return new NotificationChannel(r1, r2, r3);
        }

        static String getId(NotificationChannel r0) {
            return r0.getId();
        }

        static int getImportance(NotificationChannel r0) {
            return r0.getImportance();
        }

        static CharSequence getName(NotificationChannel r0) {
            return r0.getName();
        }

        static String getDescription(NotificationChannel r0) {
            return r0.getDescription();
        }

        static void setDescription(NotificationChannel r0, String r1) {
            r0.setDescription(r1);
        }

        static String getGroup(NotificationChannel r0) {
            return r0.getGroup();
        }

        static void setGroup(NotificationChannel r0, String r1) {
            r0.setGroup(r1);
        }

        static boolean canShowBadge(NotificationChannel r0) {
            return r0.canShowBadge();
        }

        static void setShowBadge(NotificationChannel r0, boolean r1) {
            r0.setShowBadge(r1);
        }

        static Uri getSound(NotificationChannel r0) {
            return r0.getSound();
        }

        static void setSound(NotificationChannel r0, Uri r1, AudioAttributes r2) {
            r0.setSound(r1, r2);
        }

        static AudioAttributes getAudioAttributes(NotificationChannel r0) {
            return r0.getAudioAttributes();
        }

        static boolean shouldShowLights(NotificationChannel r0) {
            return r0.shouldShowLights();
        }

        static void enableLights(NotificationChannel r0, boolean r1) {
            r0.enableLights(r1);
        }

        static int getLightColor(NotificationChannel r0) {
            return r0.getLightColor();
        }

        static void setLightColor(NotificationChannel r0, int r1) {
            r0.setLightColor(r1);
        }

        static boolean shouldVibrate(NotificationChannel r0) {
            return r0.shouldVibrate();
        }

        static void enableVibration(NotificationChannel r0, boolean r1) {
            r0.enableVibration(r1);
        }

        static long[] getVibrationPattern(NotificationChannel r0) {
            return r0.getVibrationPattern();
        }

        static void setVibrationPattern(NotificationChannel r0, long[] r1) {
            r0.setVibrationPattern(r1);
        }

        static boolean canBypassDnd(NotificationChannel r0) {
            return r0.canBypassDnd();
        }

        static int getLockscreenVisibility(NotificationChannel r0) {
            return r0.getLockscreenVisibility();
        }
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static boolean canBubble(NotificationChannel r0) {
            return r0.canBubble();
        }
    }

    static class Api30Impl {
        private Api30Impl() {
        }

        static String getParentChannelId(NotificationChannel r0) {
            return r0.getParentChannelId();
        }

        static String getConversationId(NotificationChannel r0) {
            return r0.getConversationId();
        }

        static void setConversationId(NotificationChannel r0, String r1, String r2) {
            r0.setConversationId(r1, r2);
        }

        static boolean isImportantConversation(NotificationChannel r0) {
            return r0.isImportantConversation();
        }
    }

    public static class Builder {
        private final NotificationChannelCompat mChannel;

        public Builder(String r2, int r3) {
            this.mChannel = new NotificationChannelCompat(r2, r3);
        }

        public Builder setName(CharSequence r2) {
            this.mChannel.mName = r2;
            return this;
        }

        public Builder setImportance(int r2) {
            this.mChannel.mImportance = r2;
            return this;
        }

        public Builder setDescription(String r2) {
            this.mChannel.mDescription = r2;
            return this;
        }

        public Builder setGroup(String r2) {
            this.mChannel.mGroupId = r2;
            return this;
        }

        public Builder setShowBadge(boolean r2) {
            this.mChannel.mShowBadge = r2;
            return this;
        }

        public Builder setSound(Uri r2, AudioAttributes r3) {
            this.mChannel.mSound = r2;
            this.mChannel.mAudioAttributes = r3;
            return this;
        }

        public Builder setLightsEnabled(boolean r2) {
            this.mChannel.mLights = r2;
            return this;
        }

        public Builder setLightColor(int r2) {
            this.mChannel.mLightColor = r2;
            return this;
        }

        public Builder setVibrationEnabled(boolean r2) {
            this.mChannel.mVibrationEnabled = r2;
            return this;
        }

        public Builder setVibrationPattern(long[] r3) {
            NotificationChannelCompat r0 = this.mChannel;
            if (r3 != null) goto L5;
        L7:
            boolean r1 = false;
        L8:
            r0.mVibrationEnabled = r1;
            this.mChannel.mVibrationPattern = r3;
            return this;
        L5:
            if (r3.length <= 0) goto L7;
            r1 = true;
            goto L8
        }

        public Builder setConversationId(String r2, String r3) {
            this.mChannel.mParentId = r2;
            this.mChannel.mConversationId = r3;
            return this;
        }

        public NotificationChannelCompat build() {
            return this.mChannel;
        }
    }

    NotificationChannelCompat(String r2, int r3) {
        this.mShowBadge = true;
        this.mSound = Settings.System.DEFAULT_NOTIFICATION_URI;
        this.mLightColor = 0;
        this.mId = (String) Preconditions.checkNotNull(r2);
        this.mImportance = r3;
        this.mAudioAttributes = Notification.AUDIO_ATTRIBUTES_DEFAULT;
    }

    NotificationChannelCompat(NotificationChannel r3) {
        this(Api26Impl.getId(r3), Api26Impl.getImportance(r3));
        this.mName = Api26Impl.getName(r3);
        this.mDescription = Api26Impl.getDescription(r3);
        this.mGroupId = Api26Impl.getGroup(r3);
        this.mShowBadge = Api26Impl.canShowBadge(r3);
        this.mSound = Api26Impl.getSound(r3);
        this.mAudioAttributes = Api26Impl.getAudioAttributes(r3);
        this.mLights = Api26Impl.shouldShowLights(r3);
        this.mLightColor = Api26Impl.getLightColor(r3);
        this.mVibrationEnabled = Api26Impl.shouldVibrate(r3);
        this.mVibrationPattern = Api26Impl.getVibrationPattern(r3);
        this.mParentId = Api30Impl.getParentChannelId(r3);
        this.mConversationId = Api30Impl.getConversationId(r3);
        this.mBypassDnd = Api26Impl.canBypassDnd(r3);
        this.mLockscreenVisibility = Api26Impl.getLockscreenVisibility(r3);
        this.mCanBubble = Api29Impl.canBubble(r3);
        this.mImportantConversation = Api30Impl.isImportantConversation(r3);
    }

    NotificationChannel getNotificationChannel() {
        NotificationChannel r0 = Api26Impl.createNotificationChannel(this.mId, this.mName, this.mImportance);
        Api26Impl.setDescription(r0, this.mDescription);
        Api26Impl.setGroup(r0, this.mGroupId);
        Api26Impl.setShowBadge(r0, this.mShowBadge);
        Api26Impl.setSound(r0, this.mSound, this.mAudioAttributes);
        Api26Impl.enableLights(r0, this.mLights);
        Api26Impl.setLightColor(r0, this.mLightColor);
        Api26Impl.setVibrationPattern(r0, this.mVibrationPattern);
        Api26Impl.enableVibration(r0, this.mVibrationEnabled);
        String r1 = this.mParentId;
        if (r1 == null) goto L7;
        String r3 = this.mConversationId;
        if (r3 == null) goto L7;
        Api30Impl.setConversationId(r0, r1, r3);
    L7:
        return r0;
    }

    public Builder toBuilder() {
        return new Builder(this.mId, this.mImportance).setName(this.mName).setDescription(this.mDescription).setGroup(this.mGroupId).setShowBadge(this.mShowBadge).setSound(this.mSound, this.mAudioAttributes).setLightsEnabled(this.mLights).setLightColor(this.mLightColor).setVibrationEnabled(this.mVibrationEnabled).setVibrationPattern(this.mVibrationPattern).setConversationId(this.mParentId, this.mConversationId);
    }

    public String getId() {
        return this.mId;
    }

    public CharSequence getName() {
        return this.mName;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public int getImportance() {
        return this.mImportance;
    }

    public Uri getSound() {
        return this.mSound;
    }

    public AudioAttributes getAudioAttributes() {
        return this.mAudioAttributes;
    }

    public boolean shouldShowLights() {
        return this.mLights;
    }

    public int getLightColor() {
        return this.mLightColor;
    }

    public boolean shouldVibrate() {
        return this.mVibrationEnabled;
    }

    public long[] getVibrationPattern() {
        return this.mVibrationPattern;
    }

    public boolean canShowBadge() {
        return this.mShowBadge;
    }

    public String getGroup() {
        return this.mGroupId;
    }

    public String getParentChannelId() {
        return this.mParentId;
    }

    public String getConversationId() {
        return this.mConversationId;
    }

    public boolean canBypassDnd() {
        return this.mBypassDnd;
    }

    public int getLockscreenVisibility() {
        return this.mLockscreenVisibility;
    }

    public boolean canBubble() {
        return this.mCanBubble;
    }

    public boolean isImportantConversation() {
        return this.mImportantConversation;
    }
}
