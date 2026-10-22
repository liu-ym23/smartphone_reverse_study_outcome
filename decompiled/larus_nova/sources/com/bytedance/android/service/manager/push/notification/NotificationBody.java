package com.bytedance.android.service.manager.push.notification;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.common.model.PushCommonConfiguration;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.push.utils.f;
import com.larus.nova.R;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class NotificationBody {
    public static final int AVATAR_DISPLAY_MODE_NOT_SHOW_HEADER = 0;
    public static final int AVATAR_DISPLAY_MODE_SHOW_HEADER = 1;
    public static final int TYPE_GIF = 8;
    public static final int TYPE_IMAGE_BIG = 1;
    public static final int TYPE_IMAGE_NONE = 0;
    public static final int TYPE_IMAGE_SMALL = 2;
    public static final int TYPE_PERSON = 7;
    public String androidGroup;
    public String appName;
    public int avatarDisplayMode;
    public String bdPushStr;
    public String channelId;
    public int channelImportance;
    public String content;
    public JSONObject eventExtra;
    public boolean forceSameWithIos;
    public int groupFoldNum;
    public String groupId;
    public Bitmap iconBitmap;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public long f164103id;
    public Bitmap imageBitmap;
    public int imageType;
    public String imageUrl;
    public JSONObject msgData;
    public String notificationCategory;
    public String openUrl;
    public int redBadgeNum;
    public boolean showWhen;
    public Uri sound;
    public String title;
    public boolean useLED;
    public boolean useSound;
    public boolean useVibrator;

    public static class Builder {
        private String androidGroup;
        private String appName;
        private int avatarDisplayMode;
        private String bdPushStr;
        private String channelId;
        private int channelImportance;
        private String content;
        private JSONObject eventExtra;
        private boolean forceSameWithIos;
        private int groupFoldNum;
        private String groupId;
        private Bitmap iconBitmap;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private long f164104id;
        private Bitmap imageBitmap;
        private int imageType;
        private String imageUrl;
        private JSONObject msgData;
        private String notificationCategory;
        private String openUrl;
        private int redBadgeNum;
        private boolean showWhen;
        private Uri sound;
        private String title;
        private boolean useLED;
        private boolean useSound;
        private boolean useVibrator;

        public NotificationBody build() {
            if (this.imageType == 0) goto L10;
            if (TextUtils.isEmpty(this.imageUrl) == false) goto L10;
            if (this.imageBitmap != null) goto L10;
            this.imageType = 0;
        L10:
            if (this.iconBitmap != null) goto L23;
            PushCommonConfiguration r100 = PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration();
            f.b("NotificationBody", "try use host icon_bitmap iconBitmap");     // Catch: Throwable -> L14
            this.iconBitmap = BitmapFactory.decodeResource(r100.mApplication.getResources(), r100.mIPushCommonConfiguration.getAppIconResId());     // Catch: Throwable -> L14
        L26:
        L20:
            th = move-exception;
            f.f("NotificationBody", "error when parse status_icon ", th);
            goto L23
        L17:
            if (this.iconBitmap != null) goto L23;
            f.b("NotificationBody", "try use R.drawable.status_icon as  iconBitmap");     // Catch: Throwable -> L20
            this.iconBitmap = BitmapFactory.decodeResource(r100.mApplication.getResources(), R.drawable.status_icon);     // Catch: Throwable -> L20
        L14:
            th = move-exception;
            f.f("NotificationBody", "error when parse status_icon ", th);
        L23:
            return new NotificationBody(this);
        }

        public Builder() {
            this.avatarDisplayMode = 0;
        }

        public static /* synthetic */ JSONObject access$000(Builder r100) {
            return r100.msgData;
        }

        public static /* synthetic */ long access$100(Builder r100) {
            return r100.f164104id;
        }

        public static /* synthetic */ int access$1000(Builder r100) {
            return r100.imageType;
        }

        public static /* synthetic */ boolean access$1100(Builder r100) {
            return r100.useLED;
        }

        public static /* synthetic */ boolean access$1200(Builder r100) {
            return r100.useSound;
        }

        public static /* synthetic */ boolean access$1300(Builder r100) {
            return r100.useVibrator;
        }

        public static /* synthetic */ String access$1400(Builder r100) {
            return r100.androidGroup;
        }

        public static /* synthetic */ int access$1500(Builder r100) {
            return r100.groupFoldNum;
        }

        public static /* synthetic */ Uri access$1600(Builder r100) {
            return r100.sound;
        }

        public static /* synthetic */ String access$1700(Builder r100) {
            return r100.bdPushStr;
        }

        public static /* synthetic */ Bitmap access$1800(Builder r100) {
            return r100.iconBitmap;
        }

        public static /* synthetic */ String access$1900(Builder r100) {
            return r100.appName;
        }

        public static /* synthetic */ boolean access$200(Builder r100) {
            return r100.showWhen;
        }

        public static /* synthetic */ String access$2000(Builder r100) {
            return r100.openUrl;
        }

        public static /* synthetic */ JSONObject access$2100(Builder r100) {
            return r100.eventExtra;
        }

        public static /* synthetic */ int access$2200(Builder r100) {
            return r100.channelImportance;
        }

        public static /* synthetic */ String access$2300(Builder r100) {
            return r100.notificationCategory;
        }

        public static /* synthetic */ int access$2400(Builder r100) {
            return r100.avatarDisplayMode;
        }

        public static /* synthetic */ boolean access$2500(Builder r100) {
            return r100.forceSameWithIos;
        }

        public static /* synthetic */ String access$300(Builder r100) {
            return r100.title;
        }

        public static /* synthetic */ String access$400(Builder r100) {
            return r100.content;
        }

        public static /* synthetic */ String access$500(Builder r100) {
            return r100.groupId;
        }

        public static /* synthetic */ String access$600(Builder r100) {
            return r100.channelId;
        }

        public static /* synthetic */ int access$700(Builder r100) {
            return r100.redBadgeNum;
        }

        public static /* synthetic */ String access$800(Builder r100) {
            return r100.imageUrl;
        }

        public static /* synthetic */ Bitmap access$900(Builder r100) {
            return r100.imageBitmap;
        }

        public Builder androidGroup(String r100) {
            this.androidGroup = r100;
            return this;
        }

        public Builder channelId(String r100) {
            this.channelId = r100;
            return this;
        }

        public Builder content(String r100) {
            this.content = r100;
            return this;
        }

        public Builder groupFoldNum(int r100) {
            this.groupFoldNum = r100;
            return this;
        }

        public Builder groupId(String r100) {
            this.groupId = r100;
            return this;
        }

        public Builder id(long r100) {
            this.f164104id = r100;
            return this;
        }

        public Builder imageType(int r100) {
            this.imageType = r100;
            return this;
        }

        public Builder imageUrl(String r100) {
            this.imageUrl = r100;
            return this;
        }

        public Builder msgData(JSONObject r100) {
            this.msgData = r100;
            return this;
        }

        public Builder redBadgeNum(int r100) {
            this.redBadgeNum = r100;
            return this;
        }

        public Builder setAppName(String r100) {
            this.appName = r100;
            return this;
        }

        public Builder setAvatarDisplayMode(int r100) {
            this.avatarDisplayMode = r100;
            return this;
        }

        public Builder setBdPushStr(String r100) {
            this.bdPushStr = r100;
            return this;
        }

        public Builder setChannelImportance(int r100) {
            this.channelImportance = r100;
            return this;
        }

        public Builder setEventExtra(JSONObject r100) {
            this.eventExtra = r100;
            return this;
        }

        public Builder setForceSameWithIos(boolean r100) {
            this.forceSameWithIos = r100;
            return this;
        }

        public Builder setIconBitmap(Bitmap r100) {
            this.iconBitmap = r100;
            return this;
        }

        public Builder setImageBitmap(Bitmap r100) {
            this.imageBitmap = r100;
            return this;
        }

        public Builder setNotificationCategory(String r100) {
            this.notificationCategory = r100;
            return this;
        }

        public Builder setOpenUrl(String r100) {
            this.openUrl = r100;
            return this;
        }

        public Builder setSound(Uri r100) {
            this.sound = r100;
            return this;
        }

        public Builder showWhen(boolean r100) {
            this.showWhen = r100;
            return this;
        }

        public Builder title(String r100) {
            this.title = r100;
            return this;
        }

        public Builder useLED(boolean r100) {
            this.useLED = r100;
            return this;
        }

        public Builder useSound(boolean r100) {
            this.useSound = r100;
            return this;
        }

        public Builder useVibrator(boolean r100) {
            this.useVibrator = r100;
            return this;
        }
    }

    public @interface ImageType {
    }

    public NotificationBody(Builder r100) {
        this.avatarDisplayMode = 0;
        this.forceSameWithIos = false;
        this.msgData = Builder.access$000(r100);
        this.f164103id = Builder.access$100(r100);
        this.showWhen = Builder.access$200(r100);
        this.title = Builder.access$300(r100);
        this.content = Builder.access$400(r100);
        this.groupId = Builder.access$500(r100);
        this.channelId = Builder.access$600(r100);
        this.redBadgeNum = Builder.access$700(r100);
        this.imageUrl = Builder.access$800(r100);
        this.imageBitmap = Builder.access$900(r100);
        this.imageType = Builder.access$1000(r100);
        this.useLED = Builder.access$1100(r100);
        this.useSound = Builder.access$1200(r100);
        this.useVibrator = Builder.access$1300(r100);
        this.androidGroup = Builder.access$1400(r100);
        this.groupFoldNum = Builder.access$1500(r100);
        this.sound = Builder.access$1600(r100);
        this.bdPushStr = Builder.access$1700(r100);
        this.iconBitmap = Builder.access$1800(r100);
        this.appName = Builder.access$1900(r100);
        this.openUrl = Builder.access$2000(r100);
        this.eventExtra = Builder.access$2100(r100);
        this.channelImportance = Builder.access$2200(r100);
        this.notificationCategory = Builder.access$2300(r100);
        this.avatarDisplayMode = Builder.access$2400(r100);
        this.forceSameWithIos = Builder.access$2500(r100);
    }
}
