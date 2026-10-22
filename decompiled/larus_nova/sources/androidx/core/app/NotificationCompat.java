package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.LocusId;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RemoteViews;
import android.widget.TextView;
import androidx.annotation.ReplaceWith;
import androidx.core.content.ContextCompat;
import androidx.core.content.LocusIdCompat;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.text.BidiFormatter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes17.dex */
public class NotificationCompat {
    public static final int BADGE_ICON_LARGE = 2;
    public static final int BADGE_ICON_NONE = 0;
    public static final int BADGE_ICON_SMALL = 1;
    public static final String CATEGORY_ALARM = "alarm";
    public static final String CATEGORY_CALL = "call";
    public static final String CATEGORY_EMAIL = "email";
    public static final String CATEGORY_ERROR = "err";
    public static final String CATEGORY_EVENT = "event";
    public static final String CATEGORY_LOCATION_SHARING = "location_sharing";
    public static final String CATEGORY_MESSAGE = "msg";
    public static final String CATEGORY_MISSED_CALL = "missed_call";
    public static final String CATEGORY_NAVIGATION = "navigation";
    public static final String CATEGORY_PROGRESS = "progress";
    public static final String CATEGORY_PROMO = "promo";
    public static final String CATEGORY_RECOMMENDATION = "recommendation";
    public static final String CATEGORY_REMINDER = "reminder";
    public static final String CATEGORY_SERVICE = "service";
    public static final String CATEGORY_SOCIAL = "social";
    public static final String CATEGORY_STATUS = "status";
    public static final String CATEGORY_STOPWATCH = "stopwatch";
    public static final String CATEGORY_SYSTEM = "sys";
    public static final String CATEGORY_TRANSPORT = "transport";
    public static final String CATEGORY_VOICEMAIL = "voicemail";
    public static final String CATEGORY_WORKOUT = "workout";
    public static final int COLOR_DEFAULT = 0;
    public static final int DEFAULT_ALL = -1;
    public static final int DEFAULT_LIGHTS = 4;
    public static final int DEFAULT_SOUND = 1;
    public static final int DEFAULT_VIBRATE = 2;
    public static final String EXTRA_ANSWER_COLOR = "android.answerColor";
    public static final String EXTRA_ANSWER_INTENT = "android.answerIntent";
    public static final String EXTRA_AUDIO_CONTENTS_URI = "android.audioContents";
    public static final String EXTRA_BACKGROUND_IMAGE_URI = "android.backgroundImageUri";
    public static final String EXTRA_BIG_TEXT = "android.bigText";
    public static final String EXTRA_CALL_IS_VIDEO = "android.callIsVideo";
    public static final String EXTRA_CALL_PERSON = "android.callPerson";
    public static final String EXTRA_CALL_PERSON_COMPAT = "android.callPersonCompat";
    public static final String EXTRA_CALL_TYPE = "android.callType";
    public static final String EXTRA_CHANNEL_GROUP_ID = "android.intent.extra.CHANNEL_GROUP_ID";
    public static final String EXTRA_CHANNEL_ID = "android.intent.extra.CHANNEL_ID";
    public static final String EXTRA_CHRONOMETER_COUNT_DOWN = "android.chronometerCountDown";
    public static final String EXTRA_COLORIZED = "android.colorized";
    public static final String EXTRA_COMPACT_ACTIONS = "android.compactActions";
    public static final String EXTRA_COMPAT_TEMPLATE = "androidx.core.app.extra.COMPAT_TEMPLATE";
    public static final String EXTRA_CONVERSATION_TITLE = "android.conversationTitle";
    public static final String EXTRA_DECLINE_COLOR = "android.declineColor";
    public static final String EXTRA_DECLINE_INTENT = "android.declineIntent";
    public static final String EXTRA_HANG_UP_INTENT = "android.hangUpIntent";
    public static final String EXTRA_HIDDEN_CONVERSATION_TITLE = "android.hiddenConversationTitle";
    public static final String EXTRA_HISTORIC_MESSAGES = "android.messages.historic";
    public static final String EXTRA_INFO_TEXT = "android.infoText";
    public static final String EXTRA_IS_GROUP_CONVERSATION = "android.isGroupConversation";
    public static final String EXTRA_LARGE_ICON = "android.largeIcon";
    public static final String EXTRA_LARGE_ICON_BIG = "android.largeIcon.big";
    public static final String EXTRA_MEDIA_SESSION = "android.mediaSession";
    public static final String EXTRA_MESSAGES = "android.messages";
    public static final String EXTRA_MESSAGING_STYLE_USER = "android.messagingStyleUser";
    public static final String EXTRA_NOTIFICATION_ID = "android.intent.extra.NOTIFICATION_ID";
    public static final String EXTRA_NOTIFICATION_TAG = "android.intent.extra.NOTIFICATION_TAG";
    public static final String EXTRA_PEOPLE = "android.people";
    public static final String EXTRA_PEOPLE_LIST = "android.people.list";
    public static final String EXTRA_PICTURE = "android.picture";
    public static final String EXTRA_PICTURE_CONTENT_DESCRIPTION = "android.pictureContentDescription";
    public static final String EXTRA_PICTURE_ICON = "android.pictureIcon";
    public static final String EXTRA_PROGRESS = "android.progress";
    public static final String EXTRA_PROGRESS_INDETERMINATE = "android.progressIndeterminate";
    public static final String EXTRA_PROGRESS_MAX = "android.progressMax";
    public static final String EXTRA_REMOTE_INPUT_HISTORY = "android.remoteInputHistory";
    public static final String EXTRA_SELF_DISPLAY_NAME = "android.selfDisplayName";
    public static final String EXTRA_SHOW_BIG_PICTURE_WHEN_COLLAPSED = "android.showBigPictureWhenCollapsed";
    public static final String EXTRA_SHOW_CHRONOMETER = "android.showChronometer";
    public static final String EXTRA_SHOW_WHEN = "android.showWhen";
    public static final String EXTRA_SMALL_ICON = "android.icon";
    public static final String EXTRA_SUB_TEXT = "android.subText";
    public static final String EXTRA_SUMMARY_TEXT = "android.summaryText";
    public static final String EXTRA_TEMPLATE = "android.template";
    public static final String EXTRA_TEXT = "android.text";
    public static final String EXTRA_TEXT_LINES = "android.textLines";
    public static final String EXTRA_TITLE = "android.title";
    public static final String EXTRA_TITLE_BIG = "android.title.big";
    public static final String EXTRA_VERIFICATION_ICON = "android.verificationIcon";
    public static final String EXTRA_VERIFICATION_ICON_COMPAT = "android.verificationIconCompat";
    public static final String EXTRA_VERIFICATION_TEXT = "android.verificationText";
    public static final int FLAG_AUTO_CANCEL = 16;
    public static final int FLAG_BUBBLE = 4096;
    public static final int FLAG_FOREGROUND_SERVICE = 64;
    public static final int FLAG_GROUP_SUMMARY = 512;
    public static final int FLAG_HIGH_PRIORITY = 128;
    public static final int FLAG_INSISTENT = 4;
    public static final int FLAG_LOCAL_ONLY = 256;
    public static final int FLAG_NO_CLEAR = 32;
    public static final int FLAG_ONGOING_EVENT = 2;
    public static final int FLAG_ONLY_ALERT_ONCE = 8;
    public static final int FLAG_SHOW_LIGHTS = 1;
    public static final int FOREGROUND_SERVICE_DEFAULT = 0;
    public static final int FOREGROUND_SERVICE_DEFERRED = 2;
    public static final int FOREGROUND_SERVICE_IMMEDIATE = 1;
    public static final int GROUP_ALERT_ALL = 0;
    public static final int GROUP_ALERT_CHILDREN = 2;
    public static final int GROUP_ALERT_SUMMARY = 1;
    public static final String GROUP_KEY_SILENT = "silent";
    public static final String INTENT_CATEGORY_NOTIFICATION_PREFERENCES = "android.intent.category.NOTIFICATION_PREFERENCES";
    public static final int MAX_ACTION_BUTTONS = 3;
    public static final int PRIORITY_DEFAULT = 0;
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_LOW = -1;
    public static final int PRIORITY_MAX = 2;
    public static final int PRIORITY_MIN = -2;
    public static final int STREAM_DEFAULT = -1;
    private static final String TAG = "NotifCompat";
    public static final int VISIBILITY_PRIVATE = 0;
    public static final int VISIBILITY_PUBLIC = 1;
    public static final int VISIBILITY_SECRET = -1;

    /* JADX INFO: renamed from: androidx.core.app.NotificationCompat$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Action {
        static final String EXTRA_SEMANTIC_ACTION = "android.support.action.semanticAction";
        static final String EXTRA_SHOWS_USER_INTERFACE = "android.support.action.showsUserInterface";
        public static final int SEMANTIC_ACTION_ARCHIVE = 5;
        public static final int SEMANTIC_ACTION_CALL = 10;
        public static final int SEMANTIC_ACTION_DELETE = 4;
        public static final int SEMANTIC_ACTION_MARK_AS_READ = 2;
        public static final int SEMANTIC_ACTION_MARK_AS_UNREAD = 3;
        public static final int SEMANTIC_ACTION_MUTE = 6;
        public static final int SEMANTIC_ACTION_NONE = 0;
        public static final int SEMANTIC_ACTION_REPLY = 1;
        public static final int SEMANTIC_ACTION_THUMBS_DOWN = 9;
        public static final int SEMANTIC_ACTION_THUMBS_UP = 8;
        public static final int SEMANTIC_ACTION_UNMUTE = 7;
        public PendingIntent actionIntent;
        public int icon;
        private boolean mAllowGeneratedReplies;
        private boolean mAuthenticationRequired;
        private final RemoteInput[] mDataOnlyRemoteInputs;
        final Bundle mExtras;
        private IconCompat mIcon;
        private final boolean mIsContextual;
        private final RemoteInput[] mRemoteInputs;
        private final int mSemanticAction;
        boolean mShowsUserInterface;
        public CharSequence title;

        public static final class Builder {
            private boolean mAllowGeneratedReplies;
            private boolean mAuthenticationRequired;
            private final Bundle mExtras;
            private final IconCompat mIcon;
            private final PendingIntent mIntent;
            private boolean mIsContextual;
            private ArrayList<RemoteInput> mRemoteInputs;
            private int mSemanticAction;
            private boolean mShowsUserInterface;
            private final CharSequence mTitle;

            public static class Api20Impl {
                private Api20Impl() {
                }

                public static Bundle getExtras(Notification.Action r100) {
                    return r100.getExtras();
                }

                public static android.app.RemoteInput[] getRemoteInputs(Notification.Action r100) {
                    return r100.getRemoteInputs();
                }
            }

            public static class Api23Impl {
                private Api23Impl() {
                }

                public static Icon getIcon(Notification.Action r100) {
                    return r100.getIcon();
                }
            }

            public static class Api24Impl {
                private Api24Impl() {
                }

                public static boolean getAllowGeneratedReplies(Notification.Action r100) {
                    return r100.getAllowGeneratedReplies();
                }
            }

            public static class Api28Impl {
                private Api28Impl() {
                }

                public static int getSemanticAction(Notification.Action r100) {
                    return r100.getSemanticAction();
                }
            }

            public static class Api29Impl {
                private Api29Impl() {
                }

                public static boolean isContextual(Notification.Action r100) {
                    return r100.isContextual();
                }
            }

            public static class Api31Impl {
                private Api31Impl() {
                }

                public static boolean isAuthenticationRequired(Notification.Action r100) {
                    return r100.isAuthenticationRequired();
                }
            }

            private void checkContextualActionNullFields() {
                if (this.mIsContextual == true) goto L6;
                return;
            L6:
                if (this.mIntent == null) goto L9;
                return;
            L9:
                throw new NullPointerException("Contextual Actions must contain a valid PendingIntent");
            }

            public Action build() {
                checkContextualActionNullFields();
                ArrayList r100 = new ArrayList();
                ArrayList r101 = new ArrayList();
                ArrayList<RemoteInput> r102 = this.mRemoteInputs;
                if (r102 == null) goto L11;
                Iterator<RemoteInput> r103 = r102.iterator();
            L6:
                if (r103.hasNext() == false) goto L11;
                RemoteInput r104 = r103.next();
                if (r104.isDataOnly() == true) goto L9;
                r101.add(r104);
                goto L6
            L9:
                r100.add(r104);
            L11:
                RemoteInput[] r105 = null;
                if (r100.isEmpty() == false) goto L14;
                RemoteInput[] r110 = null;
            L16:
                if (r101.isEmpty() == true) goto L20;
                r105 = (RemoteInput[]) r101.toArray(new RemoteInput[r101.size()]);
            L20:
                return new Action(this.mIcon, this.mTitle, this.mIntent, this.mExtras, r105, r110, this.mAllowGeneratedReplies, this.mSemanticAction, this.mShowsUserInterface, this.mIsContextual, this.mAuthenticationRequired);
            L14:
                r110 = (RemoteInput[]) r100.toArray(new RemoteInput[r100.size()]);
                goto L16
            }

            public Bundle getExtras() {
                return this.mExtras;
            }

            public Builder(Action r110) {
                this(r110.getIconCompat(), r110.title, r110.actionIntent, new Bundle(r110.mExtras), r110.getRemoteInputs(), r110.getAllowGeneratedReplies(), r110.getSemanticAction(), r110.mShowsUserInterface, r110.isContextual(), r110.isAuthenticationRequired());
            }

            public static Builder fromAndroidAction(Notification.Action r100) {
                if (Build.VERSION.SDK_INT >= 23) goto L5;
            L7:
                Builder r101 = new Builder(r100.icon, r100.title, r100.actionIntent);
            L8:
                android.app.RemoteInput[] r102 = Api20Impl.getRemoteInputs(r100);
                if (r102 != null) goto L11;
            L15:
                int r103 = Build.VERSION.SDK_INT;
                if (r103 < 24) goto L19;
                r101.mAllowGeneratedReplies = Api24Impl.getAllowGeneratedReplies(r100);
            L19:
                if (r103 < 28) goto L22;
                r101.setSemanticAction(Api28Impl.getSemanticAction(r100));
            L22:
                if (r103 < 29) goto L25;
                r101.setContextual(Api29Impl.isContextual(r100));
            L25:
                if (r103 < 31) goto L27;
                r101.setAuthenticationRequired(Api31Impl.isAuthenticationRequired(r100));
            L27:
                r101.addExtras(Api20Impl.getExtras(r100));
                return r101;
            L11:
                if (r102.length == 0) goto L15;
                int r104 = r102.length;
                int r105 = 0;
            L13:
                if (r105 >= r104) goto L15;
                r101.addRemoteInput(RemoteInput.fromPlatform(r102[r105]));
                r105 = r105 + 1;
                goto L13
            L5:
                if (Api23Impl.getIcon(r100) == null) goto L7;
                r101 = new Builder(IconCompat.createFromIconOrNullIfZeroResId(Api23Impl.getIcon(r100)), r100.title, r100.actionIntent);
                goto L8
            }

            public Builder addExtras(Bundle r100) {
                if (r100 == null) goto L4;
                this.mExtras.putAll(r100);
            L4:
                return this;
            }

            public Builder addRemoteInput(RemoteInput r100) {
                if (this.mRemoteInputs != null) goto L5;
                this.mRemoteInputs = new ArrayList();
            L5:
                if (r100 == null) goto L7;
                this.mRemoteInputs.add(r100);
            L7:
                return this;
            }

            public Builder extend(Extender r100) {
                r100.extend(this);
                return this;
            }

            public Builder setAllowGeneratedReplies(boolean r100) {
                this.mAllowGeneratedReplies = r100;
                return this;
            }

            public Builder setAuthenticationRequired(boolean r100) {
                this.mAuthenticationRequired = r100;
                return this;
            }

            public Builder setContextual(boolean r100) {
                this.mIsContextual = r100;
                return this;
            }

            public Builder setSemanticAction(int r100) {
                this.mSemanticAction = r100;
                return this;
            }

            public Builder setShowsUserInterface(boolean r100) {
                this.mShowsUserInterface = r100;
                return this;
            }

            public Builder(int r110, CharSequence r111, PendingIntent r112) {
                IconCompat r100 = null;
                if (r110 == 0) goto L6;
                r100 = IconCompat.createWithResource(null, "", r110);
            L6:
                this(r100, r111, r112, new Bundle(), null, true, 0, true, false, false);
            }

            public Builder(IconCompat r110, CharSequence r111, PendingIntent r112) {
                this(r110, r111, r112, new Bundle(), null, true, 0, true, false, false);
            }

            private Builder(IconCompat r100, CharSequence r101, PendingIntent r102, Bundle r103, RemoteInput[] r104, boolean r105, int r106, boolean r107, boolean r110, boolean r111) {
                this.mAllowGeneratedReplies = true;
                this.mShowsUserInterface = true;
                this.mIcon = r100;
                this.mTitle = Builder.limitCharSequenceLength(r101);
                this.mIntent = r102;
                this.mExtras = r103;
                if (r104 != null) goto L5;
                ArrayList<RemoteInput> r108 = null;
            L6:
                this.mRemoteInputs = r108;
                this.mAllowGeneratedReplies = r105;
                this.mSemanticAction = r106;
                this.mShowsUserInterface = r107;
                this.mIsContextual = r110;
                this.mAuthenticationRequired = r111;
                return;
            L5:
                r108 = new ArrayList(Arrays.asList(r104));
                goto L6
            }
        }

        public interface Extender {
            Builder extend(Builder r100);
        }

        @Retention(RetentionPolicy.SOURCE)
        public @interface SemanticAction {
        }

        public static final class WearableExtender implements Extender {
            private static final int DEFAULT_FLAGS = 1;
            private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
            private static final int FLAG_AVAILABLE_OFFLINE = 1;
            private static final int FLAG_HINT_DISPLAY_INLINE = 4;
            private static final int FLAG_HINT_LAUNCHES_ACTIVITY = 2;
            private static final String KEY_CANCEL_LABEL = "cancelLabel";
            private static final String KEY_CONFIRM_LABEL = "confirmLabel";
            private static final String KEY_FLAGS = "flags";
            private static final String KEY_IN_PROGRESS_LABEL = "inProgressLabel";
            private CharSequence mCancelLabel;
            private CharSequence mConfirmLabel;
            private int mFlags;
            private CharSequence mInProgressLabel;

            public WearableExtender clone() {
                WearableExtender r100 = new WearableExtender();
                r100.mFlags = this.mFlags;
                r100.mInProgressLabel = this.mInProgressLabel;
                r100.mConfirmLabel = this.mConfirmLabel;
                r100.mCancelLabel = this.mCancelLabel;
                return r100;
            }

            public boolean getHintDisplayActionInline() {
                if ((this.mFlags & 4) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean getHintLaunchesActivity() {
                if ((this.mFlags & 2) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean isAvailableOffline() {
                if ((this.mFlags & 1) != 0) goto L7;
                return false;
            L7:
                return true;
            }

            public WearableExtender() {
                this.mFlags = 1;
            }

            public CharSequence getCancelLabel() {
                return this.mCancelLabel;
            }

            public CharSequence getConfirmLabel() {
                return this.mConfirmLabel;
            }

            public CharSequence getInProgressLabel() {
                return this.mInProgressLabel;
            }

            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m7806clone() throws CloneNotSupportedException {
                return clone();
            }

            public WearableExtender(Action r100) {
                this.mFlags = 1;
                Bundle r101 = r100.getExtras().getBundle(EXTRA_WEARABLE_EXTENSIONS);
                if (r101 == null) goto L6;
                this.mFlags = r101.getInt(KEY_FLAGS, 1);
                this.mInProgressLabel = r101.getCharSequence(KEY_IN_PROGRESS_LABEL);
                this.mConfirmLabel = r101.getCharSequence(KEY_CONFIRM_LABEL);
                this.mCancelLabel = r101.getCharSequence(KEY_CANCEL_LABEL);
                return;
            }

            @Override // androidx.core.app.NotificationCompat.Action.Extender
            public Builder extend(Builder r100) {
                Bundle r101 = new Bundle();
                int r102 = this.mFlags;
                if (r102 == 1) goto L5;
                r101.putInt(KEY_FLAGS, r102);
            L5:
                CharSequence r103 = this.mInProgressLabel;
                if (r103 == null) goto L8;
                r101.putCharSequence(KEY_IN_PROGRESS_LABEL, r103);
            L8:
                CharSequence r104 = this.mConfirmLabel;
                if (r104 == null) goto L11;
                r101.putCharSequence(KEY_CONFIRM_LABEL, r104);
            L11:
                CharSequence r105 = this.mCancelLabel;
                if (r105 == null) goto L14;
                r101.putCharSequence(KEY_CANCEL_LABEL, r105);
            L14:
                r100.getExtras().putBundle(EXTRA_WEARABLE_EXTENSIONS, r101);
                return r100;
            }

            public WearableExtender setAvailableOffline(boolean r100) {
                setFlag(1, r100);
                return this;
            }

            public WearableExtender setCancelLabel(CharSequence r100) {
                this.mCancelLabel = r100;
                return this;
            }

            public WearableExtender setConfirmLabel(CharSequence r100) {
                this.mConfirmLabel = r100;
                return this;
            }

            public WearableExtender setHintDisplayActionInline(boolean r100) {
                setFlag(4, r100);
                return this;
            }

            public WearableExtender setHintLaunchesActivity(boolean r100) {
                setFlag(2, r100);
                return this;
            }

            public WearableExtender setInProgressLabel(CharSequence r100) {
                this.mInProgressLabel = r100;
                return this;
            }

            private void setFlag(int r100, boolean r101) {
                if (r101 == false) goto L4;
                this.mFlags = r100 | this.mFlags;
                return;
            L4:
                int r102 = this.mFlags;
                this.mFlags = (~r100) & r102;
            }
        }

        public IconCompat getIconCompat() {
            if (this.mIcon != null) goto L8;
            int r100 = this.icon;
            if (r100 == 0) goto L8;
            this.mIcon = IconCompat.createWithResource(null, "", r100);
        L8:
            return this.mIcon;
        }

        public PendingIntent getActionIntent() {
            return this.actionIntent;
        }

        public boolean getAllowGeneratedReplies() {
            return this.mAllowGeneratedReplies;
        }

        public RemoteInput[] getDataOnlyRemoteInputs() {
            return this.mDataOnlyRemoteInputs;
        }

        public Bundle getExtras() {
            return this.mExtras;
        }

        public int getIcon() {
            return this.icon;
        }

        public RemoteInput[] getRemoteInputs() {
            return this.mRemoteInputs;
        }

        public int getSemanticAction() {
            return this.mSemanticAction;
        }

        public boolean getShowsUserInterface() {
            return this.mShowsUserInterface;
        }

        public CharSequence getTitle() {
            return this.title;
        }

        public boolean isAuthenticationRequired() {
            return this.mAuthenticationRequired;
        }

        public boolean isContextual() {
            return this.mIsContextual;
        }

        public Action(IconCompat r110, CharSequence r111, PendingIntent r112) {
            this(r110, r111, r112, new Bundle(), null, null, true, 0, true, false, false);
        }

        public Action(int r100, CharSequence r101, PendingIntent r102) {
            IconCompat r103 = null;
            if (r100 == 0) goto L6;
            r103 = IconCompat.createWithResource(null, "", r100);
        L6:
            this(r103, r101, r102);
        }

        public Action(IconCompat r100, CharSequence r101, PendingIntent r102, Bundle r103, RemoteInput[] r104, RemoteInput[] r105, boolean r106, int r110, boolean r111, boolean r112, boolean r113) {
            this.mShowsUserInterface = true;
            this.mIcon = r100;
            if (r100 != null) goto L5;
        L7:
            this.title = Builder.limitCharSequenceLength(r101);
            this.actionIntent = r102;
            if (r103 != null) goto L11;
            r103 = new Bundle();
        L11:
            this.mExtras = r103;
            this.mRemoteInputs = r104;
            this.mDataOnlyRemoteInputs = r105;
            this.mAllowGeneratedReplies = r106;
            this.mSemanticAction = r110;
            this.mShowsUserInterface = r111;
            this.mIsContextual = r112;
            this.mAuthenticationRequired = r113;
            return;
        L5:
            if (r100.getType() != 2) goto L7;
            this.icon = r100.getResId();
            goto L7
        }

        public Action(int r110, CharSequence r111, PendingIntent r112, Bundle r113, RemoteInput[] r114, RemoteInput[] r210, boolean r211, int r212, boolean r213, boolean r214, boolean r215) {
            IconCompat r100 = null;
            if (r110 == 0) goto L6;
            r100 = IconCompat.createWithResource(null, "", r110);
        L6:
            this(r100, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215);
        }
    }

    public static class Api20Impl {
        private Api20Impl() {
        }

        public static boolean getAllowFreeFormInput(android.app.RemoteInput r100) {
            return r100.getAllowFreeFormInput();
        }

        public static CharSequence[] getChoices(android.app.RemoteInput r100) {
            return r100.getChoices();
        }

        public static Bundle getExtras(Notification.Action r100) {
            return r100.getExtras();
        }

        public static String getGroup(Notification r100) {
            return r100.getGroup();
        }

        public static CharSequence getLabel(android.app.RemoteInput r100) {
            return r100.getLabel();
        }

        public static android.app.RemoteInput[] getRemoteInputs(Notification.Action r100) {
            return r100.getRemoteInputs();
        }

        public static String getResultKey(android.app.RemoteInput r100) {
            return r100.getResultKey();
        }

        public static String getSortKey(Notification r100) {
            return r100.getSortKey();
        }

        public static Bundle getExtras(android.app.RemoteInput r100) {
            return r100.getExtras();
        }
    }

    public static class Api23Impl {
        private Api23Impl() {
        }

        public static Icon getIcon(Notification.Action r100) {
            return r100.getIcon();
        }
    }

    public static class Api24Impl {
        private Api24Impl() {
        }

        public static boolean getAllowGeneratedReplies(Notification.Action r100) {
            return r100.getAllowGeneratedReplies();
        }
    }

    public static class Api26Impl {
        private Api26Impl() {
        }

        public static int getBadgeIconType(Notification r100) {
            return r100.getBadgeIconType();
        }

        public static String getChannelId(Notification r100) {
            return r100.getChannelId();
        }

        public static int getGroupAlertBehavior(Notification r100) {
            return r100.getGroupAlertBehavior();
        }

        public static CharSequence getSettingsText(Notification r100) {
            return r100.getSettingsText();
        }

        public static String getShortcutId(Notification r100) {
            return r100.getShortcutId();
        }

        public static long getTimeoutAfter(Notification r100) {
            return r100.getTimeoutAfter();
        }
    }

    public static class Api28Impl {
        private Api28Impl() {
        }

        public static int getSemanticAction(Notification.Action r100) {
            return r100.getSemanticAction();
        }
    }

    public static class Api29Impl {
        private Api29Impl() {
        }

        public static boolean getAllowSystemGeneratedContextualActions(Notification r100) {
            return r100.getAllowSystemGeneratedContextualActions();
        }

        public static Notification.BubbleMetadata getBubbleMetadata(Notification r100) {
            return r100.getBubbleMetadata();
        }

        public static int getEditChoicesBeforeSending(android.app.RemoteInput r100) {
            return r100.getEditChoicesBeforeSending();
        }

        public static LocusId getLocusId(Notification r100) {
            return r100.getLocusId();
        }

        public static boolean isContextual(Notification.Action r100) {
            return r100.isContextual();
        }
    }

    public static class Api31Impl {
        private Api31Impl() {
        }

        public static boolean isAuthenticationRequired(Notification.Action r100) {
            return r100.isAuthenticationRequired();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface BadgeIconType {
    }

    public static class BigPictureStyle extends Style {
        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$BigPictureStyle";
        private IconCompat mBigLargeIcon;
        private boolean mBigLargeIconSet;
        private CharSequence mPictureContentDescription;
        private IconCompat mPictureIcon;
        private boolean mShowBigPictureWhenCollapsed;

        public static class Api23Impl {
            private Api23Impl() {
            }

            public static void setBigLargeIcon(Notification.BigPictureStyle r100, Icon r101) {
                r100.bigLargeIcon(r101);
            }
        }

        public static class Api31Impl {
            private Api31Impl() {
            }

            public static void setBigPicture(Notification.BigPictureStyle r100, Icon r101) {
                r100.bigPicture(r101);
            }

            public static void setContentDescription(Notification.BigPictureStyle r100, CharSequence r101) {
                r100.setContentDescription(r101);
            }

            public static void showBigPictureWhenCollapsed(Notification.BigPictureStyle r100, boolean r101) {
                r100.showBigPictureWhenCollapsed(r101);
            }
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public String getClassName() {
            return TEMPLATE_CLASS_NAME;
        }

        public BigPictureStyle() {
        }

        public BigPictureStyle(Builder r100) {
            setBuilder(r100);
        }

        private static IconCompat asIconCompat(Parcelable r100) {
            if (r100 != null) goto L4;
            return null;
        L4:
            if (Build.VERSION.SDK_INT < 23) goto L10;
            if ((r100 instanceof Icon) == false) goto L10;
            return IconCompat.createFromIcon((Icon) r100);
        L10:
            if ((r100 instanceof Bitmap) == true) goto L12;
            return null;
        L12:
            return IconCompat.createWithBitmap((Bitmap) r100);
        }

        public static IconCompat getPictureIcon(Bundle r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            Parcelable r101 = r100.getParcelable(NotificationCompat.EXTRA_PICTURE);
            if (r101 == null) goto L10;
            return asIconCompat(r101);
        L10:
            return asIconCompat(r100.getParcelable(NotificationCompat.EXTRA_PICTURE_ICON));
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void apply(NotificationBuilderWithBuilderAccessor r100) {
            Notification.BigPictureStyle r101 = new Notification.BigPictureStyle(r100.getBuilder()).setBigContentTitle(this.mBigContentTitle);
            IconCompat r102 = this.mPictureIcon;
            Context r103 = null;
            if (r102 == null) goto L15;
            if (Build.VERSION.SDK_INT < 31) goto L12;
            if ((r100 instanceof NotificationCompatBuilder) == false) goto L9;
            Context r104 = ((NotificationCompatBuilder) r100).getContext();
        L10:
            Api31Impl.setBigPicture(r101, this.mPictureIcon.toIcon(r104));
            goto L15
        L9:
            r104 = null;
            goto L10
        L12:
            if (r102.getType() != 1) goto L15;
            r101 = r101.bigPicture(this.mPictureIcon.getBitmap());
        L15:
            if (this.mBigLargeIconSet == false) goto L30;
            IconCompat r105 = this.mBigLargeIcon;
            if (r105 != null) goto L20;
            r101.bigLargeIcon(null);
            goto L30
        L20:
            if (Build.VERSION.SDK_INT < 23) goto L26;
            if ((r100 instanceof NotificationCompatBuilder) == false) goto L24;
            r103 = ((NotificationCompatBuilder) r100).getContext();
        L24:
            Api23Impl.setBigLargeIcon(r101, this.mBigLargeIcon.toIcon(r103));
            goto L30
        L26:
            if (r105.getType() != 1) goto L28;
            r101.bigLargeIcon(this.mBigLargeIcon.getBitmap());
            goto L30
        L28:
            r101.bigLargeIcon(null);
        L30:
            if (this.mSummaryTextSet == false) goto L33;
            r101.setSummaryText(this.mSummaryText);
        L33:
            if (Build.VERSION.SDK_INT < 31) goto L36;
            Api31Impl.showBigPictureWhenCollapsed(r101, this.mShowBigPictureWhenCollapsed);
            Api31Impl.setContentDescription(r101, this.mPictureContentDescription);
            return;
        }

        public BigPictureStyle bigLargeIcon(Bitmap r100) {
            if (r100 != null) goto L4;
            IconCompat r101 = null;
        L5:
            this.mBigLargeIcon = r101;
            this.mBigLargeIconSet = true;
            return this;
        L4:
            r101 = IconCompat.createWithBitmap(r100);
            goto L5
        }

        public BigPictureStyle bigPicture(Bitmap r100) {
            if (r100 != null) goto L4;
            IconCompat r101 = null;
        L5:
            this.mPictureIcon = r101;
            return this;
        L4:
            r101 = IconCompat.createWithBitmap(r100);
            goto L5
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void clearCompatExtraKeys(Bundle r100) {
            super.clearCompatExtraKeys(r100);
            r100.remove(NotificationCompat.EXTRA_LARGE_ICON_BIG);
            r100.remove(NotificationCompat.EXTRA_PICTURE);
            r100.remove(NotificationCompat.EXTRA_PICTURE_ICON);
            r100.remove(NotificationCompat.EXTRA_SHOW_BIG_PICTURE_WHEN_COLLAPSED);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void restoreFromCompatExtras(Bundle r100) {
            super.restoreFromCompatExtras(r100);
            if (r100.containsKey(NotificationCompat.EXTRA_LARGE_ICON_BIG) == false) goto L5;
            this.mBigLargeIcon = asIconCompat(r100.getParcelable(NotificationCompat.EXTRA_LARGE_ICON_BIG));
            this.mBigLargeIconSet = true;
        L5:
            this.mPictureIcon = getPictureIcon(r100);
            this.mShowBigPictureWhenCollapsed = r100.getBoolean(NotificationCompat.EXTRA_SHOW_BIG_PICTURE_WHEN_COLLAPSED);
        }

        public BigPictureStyle setBigContentTitle(CharSequence r100) {
            this.mBigContentTitle = Builder.limitCharSequenceLength(r100);
            return this;
        }

        public BigPictureStyle setContentDescription(CharSequence r100) {
            this.mPictureContentDescription = r100;
            return this;
        }

        public BigPictureStyle setSummaryText(CharSequence r100) {
            this.mSummaryText = Builder.limitCharSequenceLength(r100);
            this.mSummaryTextSet = true;
            return this;
        }

        public BigPictureStyle showBigPictureWhenCollapsed(boolean r100) {
            this.mShowBigPictureWhenCollapsed = r100;
            return this;
        }

        public BigPictureStyle bigLargeIcon(Icon r100) {
            if (r100 != null) goto L4;
            IconCompat r101 = null;
        L5:
            this.mBigLargeIcon = r101;
            this.mBigLargeIconSet = true;
            return this;
        L4:
            r101 = IconCompat.createFromIcon(r100);
            goto L5
        }

        public BigPictureStyle bigPicture(Icon r100) {
            this.mPictureIcon = IconCompat.createFromIcon(r100);
            return this;
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static class BigTextStyle extends Style {
        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$BigTextStyle";
        private CharSequence mBigText;

        @Override // androidx.core.app.NotificationCompat.Style
        public String getClassName() {
            return TEMPLATE_CLASS_NAME;
        }

        public BigTextStyle() {
        }

        public BigTextStyle(Builder r100) {
            setBuilder(r100);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void addCompatExtras(Bundle r100) {
            super.addCompatExtras(r100);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void apply(NotificationBuilderWithBuilderAccessor r100) {
            Notification.BigTextStyle r101 = new Notification.BigTextStyle(r100.getBuilder()).setBigContentTitle(this.mBigContentTitle).bigText(this.mBigText);
            if (this.mSummaryTextSet == false) goto L6;
            r101.setSummaryText(this.mSummaryText);
            return;
        }

        public BigTextStyle bigText(CharSequence r100) {
            this.mBigText = Builder.limitCharSequenceLength(r100);
            return this;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void clearCompatExtraKeys(Bundle r100) {
            super.clearCompatExtraKeys(r100);
            r100.remove(NotificationCompat.EXTRA_BIG_TEXT);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void restoreFromCompatExtras(Bundle r100) {
            super.restoreFromCompatExtras(r100);
            this.mBigText = r100.getCharSequence(NotificationCompat.EXTRA_BIG_TEXT);
        }

        public BigTextStyle setBigContentTitle(CharSequence r100) {
            this.mBigContentTitle = Builder.limitCharSequenceLength(r100);
            return this;
        }

        public BigTextStyle setSummaryText(CharSequence r100) {
            this.mSummaryText = Builder.limitCharSequenceLength(r100);
            this.mSummaryTextSet = true;
            return this;
        }
    }

    public static final class BubbleMetadata {
        private static final int FLAG_AUTO_EXPAND_BUBBLE = 1;
        private static final int FLAG_SUPPRESS_NOTIFICATION = 2;
        private PendingIntent mDeleteIntent;
        private int mDesiredHeight;
        private int mDesiredHeightResId;
        private int mFlags;
        private IconCompat mIcon;
        private PendingIntent mPendingIntent;
        private String mShortcutId;

        public static class Api29Impl {
            private Api29Impl() {
            }

            public static BubbleMetadata fromPlatform(Notification.BubbleMetadata r100) {
                if (r100 != null) goto L6;
                return null;
            L6:
                if (r100.getIntent() != null) goto L8;
                return null;
            L8:
                Builder r101 = new Builder(r100.getIntent(), IconCompat.createFromIcon(r100.getIcon())).setAutoExpandBubble(r100.getAutoExpandBubble()).setDeleteIntent(r100.getDeleteIntent()).setSuppressNotification(r100.isNotificationSuppressed());
                if (r100.getDesiredHeight() == 0) goto L12;
                r101.setDesiredHeight(r100.getDesiredHeight());
            L12:
                if (r100.getDesiredHeightResId() == 0) goto L15;
                r101.setDesiredHeightResId(r100.getDesiredHeightResId());
            L15:
                return r101.build();
            }

            public static Notification.BubbleMetadata toPlatform(BubbleMetadata r100) {
                if (r100 != null) goto L6;
                return null;
            L6:
                if (r100.getIntent() != null) goto L8;
                return null;
            L8:
                Notification.BubbleMetadata.Builder r101 = new Notification.BubbleMetadata.Builder().setIcon(r100.getIcon().toIcon()).setIntent(r100.getIntent()).setDeleteIntent(r100.getDeleteIntent()).setAutoExpandBubble(r100.getAutoExpandBubble()).setSuppressNotification(r100.isNotificationSuppressed());
                if (r100.getDesiredHeight() == 0) goto L12;
                r101.setDesiredHeight(r100.getDesiredHeight());
            L12:
                if (r100.getDesiredHeightResId() == 0) goto L15;
                r101.setDesiredHeightResId(r100.getDesiredHeightResId());
            L15:
                return r101.build();
            }
        }

        public static class Api30Impl {
            private Api30Impl() {
            }

            public static BubbleMetadata fromPlatform(Notification.BubbleMetadata r100) {
                if (r100 != null) goto L6;
                return null;
            L6:
                if (r100.getShortcutId() == null) goto L8;
                Builder r101 = new Builder(r100.getShortcutId());
            L9:
                r101.setAutoExpandBubble(r100.getAutoExpandBubble()).setDeleteIntent(r100.getDeleteIntent()).setSuppressNotification(r100.isNotificationSuppressed());
                if (r100.getDesiredHeight() == 0) goto L13;
                r101.setDesiredHeight(r100.getDesiredHeight());
            L13:
                if (r100.getDesiredHeightResId() == 0) goto L16;
                r101.setDesiredHeightResId(r100.getDesiredHeightResId());
            L16:
                return r101.build();
            L8:
                r101 = new Builder(r100.getIntent(), IconCompat.createFromIcon(r100.getIcon()));
                goto L9
            }

            public static Notification.BubbleMetadata toPlatform(BubbleMetadata r100) {
                if (r100 != null) goto L6;
                return null;
            L6:
                if (r100.getShortcutId() == null) goto L8;
                Notification.BubbleMetadata.Builder r101 = new Notification.BubbleMetadata.Builder(r100.getShortcutId());
            L9:
                r101.setDeleteIntent(r100.getDeleteIntent()).setAutoExpandBubble(r100.getAutoExpandBubble()).setSuppressNotification(r100.isNotificationSuppressed());
                if (r100.getDesiredHeight() == 0) goto L13;
                r101.setDesiredHeight(r100.getDesiredHeight());
            L13:
                if (r100.getDesiredHeightResId() == 0) goto L16;
                r101.setDesiredHeightResId(r100.getDesiredHeightResId());
            L16:
                return r101.build();
            L8:
                r101 = new Notification.BubbleMetadata.Builder(r100.getIntent(), r100.getIcon().toIcon());
                goto L9
            }
        }

        public static final class Builder {
            private PendingIntent mDeleteIntent;
            private int mDesiredHeight;
            private int mDesiredHeightResId;
            private int mFlags;
            private IconCompat mIcon;
            private PendingIntent mPendingIntent;
            private String mShortcutId;

            public BubbleMetadata build() {
                String r100 = this.mShortcutId;
                if (r100 == null) goto L5;
            L9:
                if (r100 == null) goto L11;
            L15:
                BubbleMetadata r101 = new BubbleMetadata(this.mPendingIntent, this.mDeleteIntent, this.mIcon, this.mDesiredHeight, this.mDesiredHeightResId, this.mFlags, r100, null);
                r101.setFlags(this.mFlags);
                return r101;
            L11:
                if (this.mIcon != null) goto L15;
                throw new NullPointerException("Must supply an icon or shortcut for the bubble");
            L5:
                if (this.mPendingIntent != null) goto L9;
                throw new NullPointerException("Must supply pending intent or shortcut to bubble");
            }

            public Builder() {
            }

            public Builder(String r100) {
                if (TextUtils.isEmpty(r100) == true) goto L7;
                this.mShortcutId = r100;
                return;
            L7:
                throw new NullPointerException("Bubble requires a non-null shortcut id");
            }

            public Builder setAutoExpandBubble(boolean r100) {
                setFlag(1, r100);
                return this;
            }

            public Builder setDeleteIntent(PendingIntent r100) {
                this.mDeleteIntent = r100;
                return this;
            }

            public Builder setDesiredHeight(int r100) {
                this.mDesiredHeight = Math.max(r100, 0);
                this.mDesiredHeightResId = 0;
                return this;
            }

            public Builder setDesiredHeightResId(int r100) {
                this.mDesiredHeightResId = r100;
                this.mDesiredHeight = 0;
                return this;
            }

            public Builder setIcon(IconCompat r100) {
                if (this.mShortcutId != null) goto L10;
                if (r100 == null) goto L8;
                this.mIcon = r100;
                return this;
            L8:
                throw new NullPointerException("Bubbles require non-null icon");
            L10:
                throw new IllegalStateException("Created as a shortcut bubble, cannot set an Icon. Consider using BubbleMetadata.Builder(PendingIntent,Icon) instead.");
            }

            public Builder setIntent(PendingIntent r100) {
                if (this.mShortcutId != null) goto L10;
                if (r100 == null) goto L8;
                this.mPendingIntent = r100;
                return this;
            L8:
                throw new NullPointerException("Bubble requires non-null pending intent");
            L10:
                throw new IllegalStateException("Created as a shortcut bubble, cannot set a PendingIntent. Consider using BubbleMetadata.Builder(PendingIntent,Icon) instead.");
            }

            public Builder setSuppressNotification(boolean r100) {
                setFlag(2, r100);
                return this;
            }

            public Builder(PendingIntent r100, IconCompat r101) {
                if (r100 == null) goto L10;
                if (r101 == null) goto L8;
                this.mPendingIntent = r100;
                this.mIcon = r101;
                return;
            L8:
                throw new NullPointerException("Bubbles require non-null icon");
            L10:
                throw new NullPointerException("Bubble requires non-null pending intent");
            }

            private Builder setFlag(int r100, boolean r101) {
                if (r101 == false) goto L4;
                this.mFlags = r100 | this.mFlags;
            L5:
                return this;
            L4:
                int r102 = this.mFlags;
                this.mFlags = (~r100) & r102;
                goto L5
            }
        }

        public boolean getAutoExpandBubble() {
            if ((this.mFlags & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        public boolean isNotificationSuppressed() {
            if ((this.mFlags & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public PendingIntent getDeleteIntent() {
            return this.mDeleteIntent;
        }

        public int getDesiredHeight() {
            return this.mDesiredHeight;
        }

        public int getDesiredHeightResId() {
            return this.mDesiredHeightResId;
        }

        public IconCompat getIcon() {
            return this.mIcon;
        }

        public PendingIntent getIntent() {
            return this.mPendingIntent;
        }

        public String getShortcutId() {
            return this.mShortcutId;
        }

        public static BubbleMetadata fromPlatform(Notification.BubbleMetadata r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            int r101 = Build.VERSION.SDK_INT;
            if (r101 < 30) goto L10;
            return Api30Impl.fromPlatform(r100);
        L10:
            if (r101 == 29) goto L12;
            return null;
        L12:
            return Api29Impl.fromPlatform(r100);
        }

        public static Notification.BubbleMetadata toPlatform(BubbleMetadata r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            int r101 = Build.VERSION.SDK_INT;
            if (r101 < 30) goto L10;
            return Api30Impl.toPlatform(r100);
        L10:
            if (r101 == 29) goto L12;
            return null;
        L12:
            return Api29Impl.toPlatform(r100);
        }

        public void setFlags(int r100) {
            this.mFlags = r100;
        }

        private BubbleMetadata(PendingIntent r100, PendingIntent r101, IconCompat r102, int r103, int r104, int r105, String r106) {
            this.mPendingIntent = r100;
            this.mIcon = r102;
            this.mDesiredHeight = r103;
            this.mDesiredHeightResId = r104;
            this.mDeleteIntent = r101;
            this.mFlags = r105;
            this.mShortcutId = r106;
        }

        public /* synthetic */ BubbleMetadata(PendingIntent r100, PendingIntent r101, IconCompat r102, int r103, int r104, int r105, String r106, AnonymousClass1 r107) {
            this(r100, r101, r102, r103, r104, r105, r106);
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static class Builder {
        private static final int MAX_CHARSEQUENCE_LENGTH = 5120;
        public ArrayList<Action> mActions;
        boolean mAllowSystemGeneratedContextualActions;
        int mBadgeIcon;
        RemoteViews mBigContentView;
        BubbleMetadata mBubbleMetadata;
        String mCategory;
        String mChannelId;
        boolean mChronometerCountDown;
        int mColor;
        boolean mColorized;
        boolean mColorizedSet;
        CharSequence mContentInfo;
        PendingIntent mContentIntent;
        CharSequence mContentText;
        CharSequence mContentTitle;
        RemoteViews mContentView;
        public Context mContext;
        Bundle mExtras;
        int mFgsDeferBehavior;
        PendingIntent mFullScreenIntent;
        int mGroupAlertBehavior;
        String mGroupKey;
        boolean mGroupSummary;
        RemoteViews mHeadsUpContentView;
        ArrayList<Action> mInvisibleActions;
        IconCompat mLargeIcon;
        boolean mLocalOnly;
        LocusIdCompat mLocusId;
        Notification mNotification;
        int mNumber;
        public ArrayList<String> mPeople;
        public ArrayList<Person> mPersonList;
        int mPriority;
        int mProgress;
        boolean mProgressIndeterminate;
        int mProgressMax;
        Notification mPublicVersion;
        CharSequence[] mRemoteInputHistory;
        CharSequence mSettingsText;
        String mShortcutId;
        boolean mShowWhen;
        boolean mSilent;
        Object mSmallIcon;
        String mSortKey;
        Style mStyle;
        CharSequence mSubText;
        RemoteViews mTickerView;
        long mTimeout;
        boolean mUseChronometer;
        int mVisibility;

        /* JADX INFO: loaded from: classes17.dex */
        public static class Api21Impl {
            private Api21Impl() {
            }

            public static AudioAttributes.Builder createBuilder() {
                return new AudioAttributes.Builder();
            }

            public static AudioAttributes build(AudioAttributes.Builder r100) {
                return r100.build();
            }

            public static AudioAttributes.Builder setContentType(AudioAttributes.Builder r100, int r101) {
                return r100.setContentType(r101);
            }

            public static AudioAttributes.Builder setLegacyStreamType(AudioAttributes.Builder r100, int r101) {
                return r100.setLegacyStreamType(r101);
            }

            public static AudioAttributes.Builder setUsage(AudioAttributes.Builder r100, int r101) {
                return r100.setUsage(r101);
            }
        }

        /* JADX INFO: loaded from: classes17.dex */
        public static class Api23Impl {
            private Api23Impl() {
            }

            public static Icon getLargeIcon(Notification r100) {
                return r100.getLargeIcon();
            }

            public static Icon getSmallIcon(Notification r100) {
                return r100.getSmallIcon();
            }
        }

        /* JADX INFO: loaded from: classes17.dex */
        public static class Api24Impl {
            private Api24Impl() {
            }

            public static RemoteViews createBigContentView(Notification.Builder r100) {
                return r100.createHeadsUpContentView();
            }

            public static RemoteViews createContentView(Notification.Builder r100) {
                return r100.createContentView();
            }

            public static RemoteViews createHeadsUpContentView(Notification.Builder r100) {
                return r100.createHeadsUpContentView();
            }

            public static Notification.Builder recoverBuilder(Context r100, Notification r101) {
                return Notification.Builder.recoverBuilder(r100, r101);
            }
        }

        public Builder setNotificationSilent() {
            this.mSilent = true;
            return this;
        }

        private boolean useExistingRemoteView() {
            Style r100 = this.mStyle;
            if (r100 != null) goto L5;
        L8:
            return true;
        L5:
            if (r100.displayCustomViewInline() == false) goto L8;
            return false;
        }

        public Notification build() {
            return new NotificationCompatBuilder(this).build();
        }

        public Builder clearActions() {
            this.mActions.clear();
            return this;
        }

        public Builder clearInvisibleActions() {
            this.mInvisibleActions.clear();
            Bundle r100 = this.mExtras.getBundle("android.car.EXTENSIONS");
            if (r100 == null) goto L5;
            Bundle r101 = new Bundle(r100);
            r101.remove("invisible_actions");
            this.mExtras.putBundle("android.car.EXTENSIONS", r101);
        L5:
            return this;
        }

        public Builder clearPeople() {
            this.mPersonList.clear();
            this.mPeople.clear();
            return this;
        }

        public RemoteViews createBigContentView() {
            if (this.mBigContentView != null) goto L5;
        L8:
            NotificationCompatBuilder r100 = new NotificationCompatBuilder(this);
            Style r101 = this.mStyle;
            if (r101 == null) goto L13;
            RemoteViews r102 = r101.makeBigContentView(r100);
            if (r102 == null) goto L13;
            return r102;
        L13:
            Notification r103 = r100.build();
            if (Build.VERSION.SDK_INT < 24) goto L18;
            return Api24Impl.createBigContentView(Api24Impl.recoverBuilder(this.mContext, r103));
        L18:
            return r103.bigContentView;
        L5:
            if (useExistingRemoteView() == false) goto L8;
            return this.mBigContentView;
        }

        public RemoteViews createContentView() {
            if (this.mContentView != null) goto L5;
        L8:
            NotificationCompatBuilder r100 = new NotificationCompatBuilder(this);
            Style r101 = this.mStyle;
            if (r101 == null) goto L13;
            RemoteViews r102 = r101.makeContentView(r100);
            if (r102 == null) goto L13;
            return r102;
        L13:
            Notification r103 = r100.build();
            if (Build.VERSION.SDK_INT < 24) goto L18;
            return Api24Impl.createContentView(Api24Impl.recoverBuilder(this.mContext, r103));
        L18:
            return r103.contentView;
        L5:
            if (useExistingRemoteView() == false) goto L8;
            return this.mContentView;
        }

        public RemoteViews createHeadsUpContentView() {
            int r100 = Build.VERSION.SDK_INT;
            if (this.mHeadsUpContentView != null) goto L5;
        L8:
            NotificationCompatBuilder r101 = new NotificationCompatBuilder(this);
            Style r102 = this.mStyle;
            if (r102 == null) goto L13;
            RemoteViews r103 = r102.makeHeadsUpContentView(r101);
            if (r103 == null) goto L13;
            return r103;
        L13:
            Notification r104 = r101.build();
            if (r100 < 24) goto L18;
            return Api24Impl.createHeadsUpContentView(Api24Impl.recoverBuilder(this.mContext, r104));
        L18:
            return r104.headsUpContentView;
        L5:
            if (useExistingRemoteView() == false) goto L8;
            return this.mHeadsUpContentView;
        }

        public Bundle getExtras() {
            if (this.mExtras != null) goto L6;
            this.mExtras = new Bundle();
        L6:
            return this.mExtras;
        }

        public long getWhenIfShowing() {
            if (this.mShowWhen == true) goto L7;
            return 0;
        L7:
            return this.mNotification.when;
        }

        public Notification getNotification() {
            return build();
        }

        public RemoteViews getBigContentView() {
            return this.mBigContentView;
        }

        public BubbleMetadata getBubbleMetadata() {
            return this.mBubbleMetadata;
        }

        public int getColor() {
            return this.mColor;
        }

        public RemoteViews getContentView() {
            return this.mContentView;
        }

        public int getForegroundServiceBehavior() {
            return this.mFgsDeferBehavior;
        }

        public RemoteViews getHeadsUpContentView() {
            return this.mHeadsUpContentView;
        }

        public int getPriority() {
            return this.mPriority;
        }

        public Builder(Context r100) {
            this(r100, null);
        }

        public static CharSequence limitCharSequenceLength(CharSequence r100) {
            if (r100 != null) goto L5;
            return r100;
        L5:
            if (r100.length() > 5120) goto L7;
            return r100;
        L7:
            return r100.subSequence(0, 5120);
        }

        public Builder addAction(Action r100) {
            if (r100 == null) goto L4;
            this.mActions.add(r100);
        L4:
            return this;
        }

        public Builder addExtras(Bundle r100) {
            if (r100 == null) goto L7;
            Bundle r101 = this.mExtras;
            if (r101 != null) goto L6;
            this.mExtras = new Bundle(r100);
            goto L7
        L6:
            r101.putAll(r100);
        L7:
            return this;
        }

        public Builder addInvisibleAction(Action r100) {
            if (r100 == null) goto L4;
            this.mInvisibleActions.add(r100);
        L4:
            return this;
        }

        public Builder addPerson(String r100) {
            if (r100 != null) goto L4;
        L6:
            return this;
        L4:
            if (r100.isEmpty() == true) goto L6;
            this.mPeople.add(r100);
            goto L6
        }

        public Builder extend(Extender r100) {
            r100.extend(this);
            return this;
        }

        public Builder setAllowSystemGeneratedContextualActions(boolean r100) {
            this.mAllowSystemGeneratedContextualActions = r100;
            return this;
        }

        public Builder setAutoCancel(boolean r100) {
            setFlag(16, r100);
            return this;
        }

        public Builder setBadgeIconType(int r100) {
            this.mBadgeIcon = r100;
            return this;
        }

        public Builder setBubbleMetadata(BubbleMetadata r100) {
            this.mBubbleMetadata = r100;
            return this;
        }

        public Builder setCategory(String r100) {
            this.mCategory = r100;
            return this;
        }

        public Builder setChannelId(String r100) {
            this.mChannelId = r100;
            return this;
        }

        public Builder setChronometerCountDown(boolean r100) {
            this.mChronometerCountDown = r100;
            getExtras().putBoolean(NotificationCompat.EXTRA_CHRONOMETER_COUNT_DOWN, r100);
            return this;
        }

        public Builder setColor(int r100) {
            this.mColor = r100;
            return this;
        }

        public Builder setColorized(boolean r100) {
            this.mColorized = r100;
            this.mColorizedSet = true;
            return this;
        }

        public Builder setContent(RemoteViews r100) {
            this.mNotification.contentView = r100;
            return this;
        }

        public Builder setContentInfo(CharSequence r100) {
            this.mContentInfo = limitCharSequenceLength(r100);
            return this;
        }

        public Builder setContentIntent(PendingIntent r100) {
            this.mContentIntent = r100;
            return this;
        }

        public Builder setContentText(CharSequence r100) {
            this.mContentText = limitCharSequenceLength(r100);
            return this;
        }

        public Builder setContentTitle(CharSequence r100) {
            this.mContentTitle = limitCharSequenceLength(r100);
            return this;
        }

        public Builder setCustomBigContentView(RemoteViews r100) {
            this.mBigContentView = r100;
            return this;
        }

        public Builder setCustomContentView(RemoteViews r100) {
            this.mContentView = r100;
            return this;
        }

        public Builder setCustomHeadsUpContentView(RemoteViews r100) {
            this.mHeadsUpContentView = r100;
            return this;
        }

        public Builder setDefaults(int r100) {
            Notification r101 = this.mNotification;
            r101.defaults = r100;
            if ((r100 & 4) == 0) goto L5;
            r101.flags |= 1;
        L5:
            return this;
        }

        public Builder setDeleteIntent(PendingIntent r100) {
            this.mNotification.deleteIntent = r100;
            return this;
        }

        public Builder setExtras(Bundle r100) {
            this.mExtras = r100;
            return this;
        }

        public Builder setForegroundServiceBehavior(int r100) {
            this.mFgsDeferBehavior = r100;
            return this;
        }

        public Builder setGroup(String r100) {
            this.mGroupKey = r100;
            return this;
        }

        public Builder setGroupAlertBehavior(int r100) {
            this.mGroupAlertBehavior = r100;
            return this;
        }

        public Builder setGroupSummary(boolean r100) {
            this.mGroupSummary = r100;
            return this;
        }

        public Builder setLargeIcon(Bitmap r100) {
            if (r100 != null) goto L4;
            IconCompat r101 = null;
        L5:
            this.mLargeIcon = r101;
            return this;
        L4:
            r101 = IconCompat.createWithBitmap(NotificationCompat.reduceLargeIconSize(this.mContext, r100));
            goto L5
        }

        public Builder setLocalOnly(boolean r100) {
            this.mLocalOnly = r100;
            return this;
        }

        public Builder setLocusId(LocusIdCompat r100) {
            this.mLocusId = r100;
            return this;
        }

        public Builder setNumber(int r100) {
            this.mNumber = r100;
            return this;
        }

        public Builder setOngoing(boolean r100) {
            setFlag(2, r100);
            return this;
        }

        public Builder setOnlyAlertOnce(boolean r100) {
            setFlag(8, r100);
            return this;
        }

        public Builder setPriority(int r100) {
            this.mPriority = r100;
            return this;
        }

        public Builder setPublicVersion(Notification r100) {
            this.mPublicVersion = r100;
            return this;
        }

        public Builder setRemoteInputHistory(CharSequence[] r100) {
            this.mRemoteInputHistory = r100;
            return this;
        }

        public Builder setSettingsText(CharSequence r100) {
            this.mSettingsText = limitCharSequenceLength(r100);
            return this;
        }

        public Builder setShortcutId(String r100) {
            this.mShortcutId = r100;
            return this;
        }

        public Builder setShortcutInfo(ShortcutInfoCompat r100) {
            if (r100 != null) goto L4;
            return this;
        L4:
            this.mShortcutId = r100.getId();
            if (this.mLocusId != null) goto L13;
            if (r100.getLocusId() == null) goto L10;
            this.mLocusId = r100.getLocusId();
            goto L13
        L10:
            if (r100.getId() == null) goto L13;
            this.mLocusId = new LocusIdCompat(r100.getId());
        L13:
            if (this.mContentTitle != null) goto L15;
            setContentTitle(r100.getShortLabel());
        L15:
            return this;
        }

        public Builder setShowWhen(boolean r100) {
            this.mShowWhen = r100;
            return this;
        }

        public Builder setSilent(boolean r100) {
            this.mSilent = r100;
            return this;
        }

        public Builder setSmallIcon(IconCompat r100) {
            this.mSmallIcon = r100.toIcon(this.mContext);
            return this;
        }

        public Builder setSortKey(String r100) {
            this.mSortKey = r100;
            return this;
        }

        public Builder setSound(Uri r100) {
            Notification r101 = this.mNotification;
            r101.sound = r100;
            r101.audioStreamType = -1;
            AudioAttributes.Builder r102 = Api21Impl.setUsage(Api21Impl.setContentType(Api21Impl.createBuilder(), 4), 5);
            Notification r103 = this.mNotification;
            r103.audioAttributes = Api21Impl.build(r102);
            return this;
        }

        public Builder setStyle(Style r100) {
            if (this.mStyle == r100) goto L7;
            this.mStyle = r100;
            if (r100 == null) goto L7;
            r100.setBuilder(this);
        L7:
            return this;
        }

        public Builder setSubText(CharSequence r100) {
            this.mSubText = limitCharSequenceLength(r100);
            return this;
        }

        public Builder setTicker(CharSequence r100) {
            Notification r101 = this.mNotification;
            r101.tickerText = limitCharSequenceLength(r100);
            return this;
        }

        public Builder setTimeoutAfter(long r100) {
            this.mTimeout = r100;
            return this;
        }

        public Builder setUsesChronometer(boolean r100) {
            this.mUseChronometer = r100;
            return this;
        }

        public Builder setVibrate(long[] r100) {
            this.mNotification.vibrate = r100;
            return this;
        }

        public Builder setVisibility(int r100) {
            this.mVisibility = r100;
            return this;
        }

        public Builder setWhen(long r100) {
            this.mNotification.when = r100;
            return this;
        }

        public Builder addPerson(Person r100) {
            if (r100 == null) goto L4;
            this.mPersonList.add(r100);
        L4:
            return this;
        }

        public Builder setLargeIcon(Icon r100) {
            if (r100 != null) goto L4;
            IconCompat r101 = null;
        L5:
            this.mLargeIcon = r101;
            return this;
        L4:
            r101 = IconCompat.createFromIcon(r100);
            goto L5
        }

        public Builder setSmallIcon(int r100) {
            this.mNotification.icon = r100;
            return this;
        }

        public Builder(Context r100, Notification r101) {
            this(r100, NotificationCompat.getChannelId(r101));
            Bundle r102 = r101.extras;
            Style r103 = Style.extractStyleFromNotification(r101);
            setContentTitle(NotificationCompat.getContentTitle(r101)).setContentText(NotificationCompat.getContentText(r101)).setContentInfo(NotificationCompat.getContentInfo(r101)).setSubText(NotificationCompat.getSubText(r101)).setSettingsText(NotificationCompat.getSettingsText(r101)).setStyle(r103).setGroup(NotificationCompat.getGroup(r101)).setGroupSummary(NotificationCompat.isGroupSummary(r101)).setLocusId(NotificationCompat.getLocusId(r101)).setWhen(r101.when).setShowWhen(NotificationCompat.getShowWhen(r101)).setUsesChronometer(NotificationCompat.getUsesChronometer(r101)).setAutoCancel(NotificationCompat.getAutoCancel(r101)).setOnlyAlertOnce(NotificationCompat.getOnlyAlertOnce(r101)).setOngoing(NotificationCompat.getOngoing(r101)).setLocalOnly(NotificationCompat.getLocalOnly(r101)).setLargeIcon(r101.largeIcon).setBadgeIconType(NotificationCompat.getBadgeIconType(r101)).setCategory(NotificationCompat.getCategory(r101)).setBubbleMetadata(NotificationCompat.getBubbleMetadata(r101)).setNumber(r101.number).setTicker(r101.tickerText).setContentIntent(r101.contentIntent).setDeleteIntent(r101.deleteIntent).setFullScreenIntent(r101.fullScreenIntent, NotificationCompat.getHighPriority(r101)).setSound(r101.sound, r101.audioStreamType).setVibrate(r101.vibrate).setLights(r101.ledARGB, r101.ledOnMS, r101.ledOffMS).setDefaults(r101.defaults).setPriority(r101.priority).setColor(NotificationCompat.getColor(r101)).setVisibility(NotificationCompat.getVisibility(r101)).setPublicVersion(NotificationCompat.getPublicVersion(r101)).setSortKey(NotificationCompat.getSortKey(r101)).setTimeoutAfter(NotificationCompat.getTimeoutAfter(r101)).setShortcutId(NotificationCompat.getShortcutId(r101)).setProgress(r102.getInt(NotificationCompat.EXTRA_PROGRESS_MAX), r102.getInt(NotificationCompat.EXTRA_PROGRESS), r102.getBoolean(NotificationCompat.EXTRA_PROGRESS_INDETERMINATE)).setAllowSystemGeneratedContextualActions(NotificationCompat.getAllowSystemGeneratedContextualActions(r101)).setSmallIcon(r101.icon, r101.iconLevel).addExtras(getExtrasWithoutDuplicateData(r101, r103));
            if (Build.VERSION.SDK_INT < 23) goto L7;
            this.mSmallIcon = Api23Impl.getSmallIcon(r101);
            Icon r104 = Api23Impl.getLargeIcon(r101);
            if (r104 == null) goto L7;
            this.mLargeIcon = IconCompat.createFromIcon(r104);
        L7:
            Notification.Action[] r105 = r101.actions;
            int r106 = 0;
            if (r105 != null) goto L10;
        L14:
            List<Action> r107 = NotificationCompat.getInvisibleActions(r101);
            if (r107.isEmpty() == true) goto L20;
            Iterator<Action> r108 = r107.iterator();
        L18:
            if (r108.hasNext() == false) goto L20;
            addInvisibleAction(r108.next());
        L20:
            String[] r109 = r101.extras.getStringArray(NotificationCompat.EXTRA_PEOPLE);
            if (r109 == null) goto L28;
            if (r109.length == 0) goto L28;
            int r110 = r109.length;
        L25:
            if (r106 >= r110) goto L28;
            addPerson(r109[r106]);
            r106 = r106 + 1;
        L28:
            if (Build.VERSION.SDK_INT < 28) goto L37;
            ArrayList r111 = r101.extras.getParcelableArrayList(NotificationCompat.EXTRA_PEOPLE_LIST);
            if (r111 == null) goto L37;
            if (r111.isEmpty() == true) goto L37;
            Iterator r112 = r111.iterator();
        L35:
            if (r112.hasNext() == false) goto L37;
            addPerson(Person.fromAndroidPerson((android.app.Person) r112.next()));
        L37:
            int r113 = Build.VERSION.SDK_INT;
            if (r113 < 24) goto L43;
            if (r102.containsKey(NotificationCompat.EXTRA_CHRONOMETER_COUNT_DOWN) == false) goto L43;
            setChronometerCountDown(r102.getBoolean(NotificationCompat.EXTRA_CHRONOMETER_COUNT_DOWN));
        L43:
            if (r113 >= 26) goto L45;
            return;
        L45:
            if (r102.containsKey(NotificationCompat.EXTRA_COLORIZED) == false) goto L53;
            setColorized(r102.getBoolean(NotificationCompat.EXTRA_COLORIZED));
            return;
        L53:
            return;
        L10:
            if (r105.length == 0) goto L14;
            int r114 = r105.length;
            int r115 = 0;
        L12:
            if (r115 >= r114) goto L14;
            addAction(Action.Builder.fromAndroidAction(r105[r115]).build());
            r115 = r115 + 1;
            goto L12
        }

        private static Bundle getExtrasWithoutDuplicateData(Notification r100, Style r101) {
            if (r100.extras != null) goto L6;
            return null;
        L6:
            Bundle r102 = new Bundle(r100.extras);
            r102.remove(NotificationCompat.EXTRA_TITLE);
            r102.remove(NotificationCompat.EXTRA_TEXT);
            r102.remove(NotificationCompat.EXTRA_INFO_TEXT);
            r102.remove(NotificationCompat.EXTRA_SUB_TEXT);
            r102.remove(NotificationCompat.EXTRA_CHANNEL_ID);
            r102.remove(NotificationCompat.EXTRA_CHANNEL_GROUP_ID);
            r102.remove(NotificationCompat.EXTRA_SHOW_WHEN);
            r102.remove(NotificationCompat.EXTRA_PROGRESS);
            r102.remove(NotificationCompat.EXTRA_PROGRESS_MAX);
            r102.remove(NotificationCompat.EXTRA_PROGRESS_INDETERMINATE);
            r102.remove(NotificationCompat.EXTRA_CHRONOMETER_COUNT_DOWN);
            r102.remove(NotificationCompat.EXTRA_COLORIZED);
            r102.remove(NotificationCompat.EXTRA_PEOPLE_LIST);
            r102.remove(NotificationCompat.EXTRA_PEOPLE);
            r102.remove(NotificationCompatExtras.EXTRA_SORT_KEY);
            r102.remove(NotificationCompatExtras.EXTRA_GROUP_KEY);
            r102.remove(NotificationCompatExtras.EXTRA_GROUP_SUMMARY);
            r102.remove(NotificationCompatExtras.EXTRA_LOCAL_ONLY);
            r102.remove(NotificationCompatExtras.EXTRA_ACTION_EXTRAS);
            Bundle r103 = r102.getBundle("android.car.EXTENSIONS");
            if (r103 == null) goto L9;
            Bundle r104 = new Bundle(r103);
            r104.remove("invisible_actions");
            r102.putBundle("android.car.EXTENSIONS", r104);
        L9:
            if (r101 == null) goto L11;
            r101.clearCompatExtraKeys(r102);
        L11:
            return r102;
        }

        private void setFlag(int r100, boolean r101) {
            if (r101 == false) goto L4;
            Notification r102 = this.mNotification;
            r102.flags = r100 | r102.flags;
            return;
        L4:
            Notification r103 = this.mNotification;
            int r104 = r103.flags;
            r103.flags = (~r100) & r104;
        }

        public Builder setFullScreenIntent(PendingIntent r100, boolean r101) {
            this.mFullScreenIntent = r100;
            setFlag(128, r101);
            return this;
        }

        public Builder setSmallIcon(int r100, int r101) {
            Notification r102 = this.mNotification;
            r102.icon = r100;
            r102.iconLevel = r101;
            return this;
        }

        public Builder setSound(Uri r100, int r101) {
            Notification r102 = this.mNotification;
            r102.sound = r100;
            r102.audioStreamType = r101;
            AudioAttributes.Builder r103 = Api21Impl.setLegacyStreamType(Api21Impl.setContentType(Api21Impl.createBuilder(), 4), r101);
            Notification r104 = this.mNotification;
            r104.audioAttributes = Api21Impl.build(r103);
            return this;
        }

        public Builder setTicker(CharSequence r100, RemoteViews r101) {
            Notification r102 = this.mNotification;
            r102.tickerText = limitCharSequenceLength(r100);
            this.mTickerView = r101;
            return this;
        }

        public Builder(Context r100, String r101) {
            this.mActions = new ArrayList();
            this.mPersonList = new ArrayList();
            this.mInvisibleActions = new ArrayList();
            this.mShowWhen = true;
            this.mLocalOnly = false;
            this.mColor = 0;
            this.mVisibility = 0;
            this.mBadgeIcon = 0;
            this.mGroupAlertBehavior = 0;
            this.mFgsDeferBehavior = 0;
            Notification r102 = new Notification();
            this.mNotification = r102;
            this.mContext = r100;
            this.mChannelId = r101;
            r102.when = System.currentTimeMillis();
            this.mNotification.audioStreamType = -1;
            this.mPriority = 0;
            this.mPeople = new ArrayList();
            this.mAllowSystemGeneratedContextualActions = true;
        }

        public Builder addAction(int r100, CharSequence r101, PendingIntent r102) {
            this.mActions.add(new Action(r100, r101, r102));
            return this;
        }

        public Builder addInvisibleAction(int r100, CharSequence r101, PendingIntent r102) {
            this.mInvisibleActions.add(new Action(r100, r101, r102));
            return this;
        }

        public Builder setLights(int r100, int r101, int r102) {
            Notification r103 = this.mNotification;
            r103.ledARGB = r100;
            r103.ledOnMS = r101;
            r103.ledOffMS = r102;
            if (r101 == 0) goto L6;
            if (r102 == 0) goto L6;
            int r104 = 1;
        L7:
            r103.flags = r104 | (r103.flags & (-2));
            return this;
        L6:
            r104 = 0;
            goto L7
        }

        public Builder setProgress(int r100, int r101, boolean r102) {
            this.mProgressMax = r100;
            this.mProgress = r101;
            this.mProgressIndeterminate = r102;
            return this;
        }
    }

    public static class CallStyle extends Style {
        public static final int CALL_TYPE_INCOMING = 1;
        public static final int CALL_TYPE_ONGOING = 2;
        public static final int CALL_TYPE_SCREENING = 3;
        public static final int CALL_TYPE_UNKNOWN = 0;
        private static final String KEY_ACTION_PRIORITY = "key_action_priority";
        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$CallStyle";
        private Integer mAnswerButtonColor;
        private PendingIntent mAnswerIntent;
        private int mCallType;
        private Integer mDeclineButtonColor;
        private PendingIntent mDeclineIntent;
        private PendingIntent mHangUpIntent;
        private boolean mIsVideo;
        private Person mPerson;
        private IconCompat mVerificationIcon;
        private CharSequence mVerificationText;

        public static class Api20Impl {
            private Api20Impl() {
            }

            public static Notification.Action build(Notification.Action.Builder r100) {
                return r100.build();
            }

            public static Notification.Action.Builder addExtras(Notification.Action.Builder r100, Bundle r101) {
                return r100.addExtras(r101);
            }

            public static Notification.Action.Builder addRemoteInput(Notification.Action.Builder r100, android.app.RemoteInput r101) {
                return r100.addRemoteInput(r101);
            }

            public static Notification.Action.Builder createActionBuilder(int r100, CharSequence r101, PendingIntent r102) {
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
        }

        public static class Api23Impl {
            public static Parcelable castToParcelable(Icon r100) {
                return r100;
            }

            private Api23Impl() {
            }

            public static void setLargeIcon(Notification.Builder r100, Icon r101) {
                r100.setLargeIcon(r101);
            }

            public static Notification.Action.Builder createActionBuilder(Icon r100, CharSequence r101, PendingIntent r102) {
                return new Notification.Action.Builder(r100, r101, r102);
            }
        }

        public static class Api24Impl {
            private Api24Impl() {
            }

            public static Notification.Action.Builder setAllowGeneratedReplies(Notification.Action.Builder r100, boolean r101) {
                return r100.setAllowGeneratedReplies(r101);
            }
        }

        public static class Api28Impl {
            public static Parcelable castToParcelable(android.app.Person r100) {
                return r100;
            }

            private Api28Impl() {
            }

            public static Notification.Builder addPerson(Notification.Builder r100, android.app.Person r101) {
                return r100.addPerson(r101);
            }
        }

        public static class Api31Impl {
            private Api31Impl() {
            }

            public static Notification.CallStyle forOngoingCall(android.app.Person r100, PendingIntent r101) {
                return Notification.CallStyle.forOngoingCall(r100, r101);
            }

            public static Notification.CallStyle setAnswerButtonColorHint(Notification.CallStyle r100, int r101) {
                return r100.setAnswerButtonColorHint(r101);
            }

            public static Notification.Action.Builder setAuthenticationRequired(Notification.Action.Builder r100, boolean r101) {
                return r100.setAuthenticationRequired(r101);
            }

            public static Notification.CallStyle setDeclineButtonColorHint(Notification.CallStyle r100, int r101) {
                return r100.setDeclineButtonColorHint(r101);
            }

            public static Notification.CallStyle setIsVideo(Notification.CallStyle r100, boolean r101) {
                return r100.setIsVideo(r101);
            }

            public static Notification.CallStyle setVerificationIcon(Notification.CallStyle r100, Icon r101) {
                return r100.setVerificationIcon(r101);
            }

            public static Notification.CallStyle setVerificationText(Notification.CallStyle r100, CharSequence r101) {
                return r100.setVerificationText(r101);
            }

            public static Notification.CallStyle forIncomingCall(android.app.Person r100, PendingIntent r101, PendingIntent r102) {
                return Notification.CallStyle.forIncomingCall(r100, r101, r102);
            }

            public static Notification.CallStyle forScreeningCall(android.app.Person r100, PendingIntent r101, PendingIntent r102) {
                return Notification.CallStyle.forScreeningCall(r100, r101, r102);
            }
        }

        @Retention(RetentionPolicy.SOURCE)
        public @interface CallType {
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public boolean displayCustomViewInline() {
            return true;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public String getClassName() {
            return TEMPLATE_CLASS_NAME;
        }

        private String getDefaultText() {
            int r100 = this.mCallType;
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L13;
            if (r100 == 3) goto L11;
            return null;
        L11:
            return this.mBuilder.mContext.getResources().getString(R.string.call_notification_screening_text);
        L13:
            return this.mBuilder.mContext.getResources().getString(R.string.call_notification_ongoing_text);
        L15:
            return this.mBuilder.mContext.getResources().getString(R.string.call_notification_incoming_text);
        }

        private Action makeAnswerAction() {
            PendingIntent r100 = this.mAnswerIntent;
            if (r100 != null) goto L5;
            return null;
        L5:
            boolean r101 = this.mIsVideo;
            if (r101 == false) goto L8;
            int r102 = R.drawable.ic_call_answer_video;
        L9:
            if (r101 == false) goto L11;
            int r103 = R.string.call_notification_answer_video_action;
        L13:
            return makeAction(r102, r103, this.mAnswerButtonColor, R.color.call_notification_answer_color, r100);
        L11:
            r103 = R.string.call_notification_answer_action;
            goto L13
        L8:
            r102 = R.drawable.ic_call_answer;
            goto L9
        }

        private Action makeNegativeAction() {
            PendingIntent r100 = this.mDeclineIntent;
            if (r100 != null) goto L7;
            return makeAction(R.drawable.ic_call_decline, R.string.call_notification_hang_up_action, this.mDeclineButtonColor, R.color.call_notification_decline_color, this.mHangUpIntent);
        L7:
            return makeAction(R.drawable.ic_call_decline, R.string.call_notification_decline_action, this.mDeclineButtonColor, R.color.call_notification_decline_color, r100);
        }

        public ArrayList<Action> getActionsListWithSystemActions() {
            Action r100 = makeNegativeAction();
            Action r101 = makeAnswerAction();
            ArrayList<Action> r102 = new ArrayList(3);
            r102.add(r100);
            ArrayList<Action> r103 = this.mBuilder.mActions;
            int r104 = 2;
            if (r103 == null) goto L18;
            Iterator<Action> r105 = r103.iterator();
        L6:
            if (r105.hasNext() == false) goto L18;
            Action r106 = r105.next();
            if (r106.isContextual() == false) goto L11;
            r102.add(r106);
        L15:
            if (r101 == null) goto L6;
            if (r104 != 1) goto L6;
            r102.add(r101);
            r104 = r104 - 1;
            goto L6
        L11:
            if (isActionAddedByCallStyle(r106) == true) goto L15;
            if (r104 <= 1) goto L15;
            r102.add(r106);
            r104 = r104 - 1;
        L18:
            if (r101 == null) goto L21;
            if (r104 < 1) goto L21;
            r102.add(r101);
        L21:
            return r102;
        }

        public CallStyle() {
        }

        public CallStyle(Builder r100) {
            setBuilder(r100);
        }

        private boolean isActionAddedByCallStyle(Action r100) {
            if (r100 != null) goto L4;
        L6:
            return false;
        L4:
            if (r100.getExtras().getBoolean(KEY_ACTION_PRIORITY) == false) goto L6;
            return true;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void addCompatExtras(Bundle r100) {
            super.addCompatExtras(r100);
            r100.putInt(NotificationCompat.EXTRA_CALL_TYPE, this.mCallType);
            r100.putBoolean(NotificationCompat.EXTRA_CALL_IS_VIDEO, this.mIsVideo);
            Person r101 = this.mPerson;
            if (r101 != null) goto L5;
        L8:
            IconCompat r102 = this.mVerificationIcon;
            if (r102 != null) goto L11;
        L14:
            r100.putCharSequence(NotificationCompat.EXTRA_VERIFICATION_TEXT, this.mVerificationText);
            r100.putParcelable(NotificationCompat.EXTRA_ANSWER_INTENT, this.mAnswerIntent);
            r100.putParcelable(NotificationCompat.EXTRA_DECLINE_INTENT, this.mDeclineIntent);
            r100.putParcelable(NotificationCompat.EXTRA_HANG_UP_INTENT, this.mHangUpIntent);
            Integer r103 = this.mAnswerButtonColor;
            if (r103 == null) goto L17;
            r100.putInt(NotificationCompat.EXTRA_ANSWER_COLOR, r103.intValue());
        L17:
            Integer r104 = this.mDeclineButtonColor;
            if (r104 == null) goto L21;
            r100.putInt(NotificationCompat.EXTRA_DECLINE_COLOR, r104.intValue());
            return;
        L21:
            return;
        L11:
            if (Build.VERSION.SDK_INT < 23) goto L13;
            r100.putParcelable(NotificationCompat.EXTRA_VERIFICATION_ICON, Api23Impl.castToParcelable(r102.toIcon(this.mBuilder.mContext)));
            goto L14
        L13:
            r100.putParcelable(NotificationCompat.EXTRA_VERIFICATION_ICON_COMPAT, r102.toBundle());
            goto L14
        L5:
            if (Build.VERSION.SDK_INT < 28) goto L7;
            r100.putParcelable(NotificationCompat.EXTRA_CALL_PERSON, Api28Impl.castToParcelable(r101.toAndroidPerson()));
            goto L8
        L7:
            r100.putParcelable(NotificationCompat.EXTRA_CALL_PERSON_COMPAT, r101.toBundle());
            goto L8
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void apply(NotificationBuilderWithBuilderAccessor r100) {
            int r101 = Build.VERSION.SDK_INT;
            CharSequence r102 = null;
            Notification.CallStyle r103 = null;
            r103 = null;
            r102 = null;
            if (r101 < 31) goto L27;
            int r104 = this.mCallType;
            if (r104 != 1) goto L7;
            r103 = Api31Impl.forIncomingCall(this.mPerson.toAndroidPerson(), this.mDeclineIntent, this.mAnswerIntent);
        L16:
            if (r103 == null) goto L51;
            r103.setBuilder(r100.getBuilder());
            Integer r105 = this.mAnswerButtonColor;
            if (r105 == null) goto L20;
            Api31Impl.setAnswerButtonColorHint(r103, r105.intValue());
        L20:
            Integer r106 = this.mDeclineButtonColor;
            if (r106 == null) goto L23;
            Api31Impl.setDeclineButtonColorHint(r103, r106.intValue());
        L23:
            Api31Impl.setVerificationText(r103, this.mVerificationText);
            IconCompat r107 = this.mVerificationIcon;
            if (r107 == null) goto L26;
            Api31Impl.setVerificationIcon(r103, r107.toIcon(this.mBuilder.mContext));
        L26:
            Api31Impl.setIsVideo(r103, this.mIsVideo);
            return;
        L51:
            return;
        L7:
            if (r104 != 2) goto L9;
            r103 = Api31Impl.forOngoingCall(this.mPerson.toAndroidPerson(), this.mHangUpIntent);
            goto L16
        L9:
            if (r104 != 3) goto L11;
            r103 = Api31Impl.forScreeningCall(this.mPerson.toAndroidPerson(), this.mHangUpIntent, this.mAnswerIntent);
            goto L16
        L11:
            if (Log.isLoggable(NotificationCompat.TAG, 3) == false) goto L16;
            String.valueOf(this.mCallType);
            goto L16
        L27:
            Notification.Builder r108 = r100.getBuilder();
            Person r109 = this.mPerson;
            if (r109 == null) goto L30;
            CharSequence r110 = r109.getName();
        L31:
            r108.setContentTitle(r110);
            Bundle r111 = this.mBuilder.mExtras;
            if (r111 != null) goto L34;
        L36:
            if (r102 != null) goto L38;
            r102 = getDefaultText();
        L38:
            r108.setContentText(r102);
            Person r112 = this.mPerson;
            if (r112 != null) goto L41;
        L49:
            Api21Impl.setCategory(r108, NotificationCompat.CATEGORY_CALL);
            return;
        L41:
            if (r101 < 23) goto L46;
            if (r112.getIcon() == null) goto L46;
            Api23Impl.setLargeIcon(r108, this.mPerson.getIcon().toIcon(this.mBuilder.mContext));
        L46:
            if (r101 < 28) goto L48;
            Api28Impl.addPerson(r108, this.mPerson.toAndroidPerson());
            goto L49
        L48:
            Api21Impl.addPerson(r108, this.mPerson.getUri());
            goto L49
        L34:
            if (r111.containsKey(NotificationCompat.EXTRA_TEXT) == false) goto L36;
            r102 = this.mBuilder.mExtras.getCharSequence(NotificationCompat.EXTRA_TEXT);
            goto L36
        L30:
            r110 = null;
            goto L31
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void restoreFromCompatExtras(Bundle r100) {
            super.restoreFromCompatExtras(r100);
            this.mCallType = r100.getInt(NotificationCompat.EXTRA_CALL_TYPE);
            this.mIsVideo = r100.getBoolean(NotificationCompat.EXTRA_CALL_IS_VIDEO);
            int r101 = Build.VERSION.SDK_INT;
            if (r101 < 28) goto L8;
            if (r100.containsKey(NotificationCompat.EXTRA_CALL_PERSON) == false) goto L8;
            this.mPerson = Person.fromAndroidPerson((android.app.Person) r100.getParcelable(NotificationCompat.EXTRA_CALL_PERSON));
        L11:
            if (r101 < 23) goto L16;
            if (r100.containsKey(NotificationCompat.EXTRA_VERIFICATION_ICON) == false) goto L16;
            this.mVerificationIcon = IconCompat.createFromIcon((Icon) r100.getParcelable(NotificationCompat.EXTRA_VERIFICATION_ICON));
        L18:
            this.mVerificationText = r100.getCharSequence(NotificationCompat.EXTRA_VERIFICATION_TEXT);
            this.mAnswerIntent = (PendingIntent) r100.getParcelable(NotificationCompat.EXTRA_ANSWER_INTENT);
            this.mDeclineIntent = (PendingIntent) r100.getParcelable(NotificationCompat.EXTRA_DECLINE_INTENT);
            this.mHangUpIntent = (PendingIntent) r100.getParcelable(NotificationCompat.EXTRA_HANG_UP_INTENT);
            Integer r102 = null;
            if (r100.containsKey(NotificationCompat.EXTRA_ANSWER_COLOR) == false) goto L21;
            Integer r103 = Integer.valueOf(r100.getInt(NotificationCompat.EXTRA_ANSWER_COLOR));
        L22:
            this.mAnswerButtonColor = r103;
            if (r100.containsKey(NotificationCompat.EXTRA_DECLINE_COLOR) == false) goto L25;
            r102 = Integer.valueOf(r100.getInt(NotificationCompat.EXTRA_DECLINE_COLOR));
        L25:
            this.mDeclineButtonColor = r102;
            return;
        L21:
            r103 = null;
        L16:
            if (r100.containsKey(NotificationCompat.EXTRA_VERIFICATION_ICON_COMPAT) == false) goto L18;
            this.mVerificationIcon = IconCompat.createFromBundle(r100.getBundle(NotificationCompat.EXTRA_VERIFICATION_ICON_COMPAT));
        L8:
            if (r100.containsKey(NotificationCompat.EXTRA_CALL_PERSON_COMPAT) == false) goto L11;
            this.mPerson = Person.fromBundle(r100.getBundle(NotificationCompat.EXTRA_CALL_PERSON_COMPAT));
            goto L11
        }

        public CallStyle setAnswerButtonColorHint(int r100) {
            this.mAnswerButtonColor = Integer.valueOf(r100);
            return this;
        }

        public CallStyle setDeclineButtonColorHint(int r100) {
            this.mDeclineButtonColor = Integer.valueOf(r100);
            return this;
        }

        public CallStyle setIsVideo(boolean r100) {
            this.mIsVideo = r100;
            return this;
        }

        public CallStyle setVerificationIcon(Icon r100) {
            if (r100 != null) goto L4;
            IconCompat r101 = null;
        L5:
            this.mVerificationIcon = r101;
            return this;
        L4:
            r101 = IconCompat.createFromIcon(r100);
            goto L5
        }

        public CallStyle setVerificationText(CharSequence r100) {
            this.mVerificationText = r100;
            return this;
        }

        public CallStyle setVerificationIcon(Bitmap r100) {
            this.mVerificationIcon = IconCompat.createWithBitmap(r100);
            return this;
        }

        public static CallStyle forOngoingCall(Person r100, PendingIntent r101) {
            Objects.requireNonNull(r101, "hangUpIntent is required");
            return new CallStyle(2, r100, r101, null, null);
        }

        public static CallStyle forIncomingCall(Person r100, PendingIntent r101, PendingIntent r102) {
            Objects.requireNonNull(r101, "declineIntent is required");
            Objects.requireNonNull(r102, "answerIntent is required");
            return new CallStyle(1, r100, null, r101, r102);
        }

        public static CallStyle forScreeningCall(Person r100, PendingIntent r101, PendingIntent r102) {
            Objects.requireNonNull(r101, "hangUpIntent is required");
            Objects.requireNonNull(r102, "answerIntent is required");
            return new CallStyle(3, r100, r101, null, r102);
        }

        private CallStyle(int r100, Person r101, PendingIntent r102, PendingIntent r103, PendingIntent r104) {
            if (r101 == null) goto L9;
            if (TextUtils.isEmpty(r101.getName()) == true) goto L9;
            this.mCallType = r100;
            this.mPerson = r101;
            this.mAnswerIntent = r104;
            this.mDeclineIntent = r103;
            this.mHangUpIntent = r102;
            return;
        L9:
            throw new IllegalArgumentException("person must have a non-empty a name");
        }

        private Action makeAction(int r100, int r101, Integer r102, int r103, PendingIntent r104) {
            if (r102 != null) goto L4;
            r102 = Integer.valueOf(ContextCompat.getColor(this.mBuilder.mContext, r103));
        L4:
            SpannableStringBuilder r105 = new SpannableStringBuilder();
            r105.append(this.mBuilder.mContext.getResources().getString(r101));
            r105.setSpan(new ForegroundColorSpan(r102.intValue()), 0, r105.length(), 18);
            Action r106 = new Action.Builder(IconCompat.createWithResource(this.mBuilder.mContext, r100), r105, r104).build();
            r106.getExtras().putBoolean(KEY_ACTION_PRIORITY, true);
            return r106;
        }
    }

    public static final class CarExtender implements Extender {
        static final String EXTRA_CAR_EXTENDER = "android.car.EXTENSIONS";
        private static final String EXTRA_COLOR = "app_color";
        private static final String EXTRA_CONVERSATION = "car_conversation";
        static final String EXTRA_INVISIBLE_ACTIONS = "invisible_actions";
        private static final String EXTRA_LARGE_ICON = "large_icon";
        private static final String KEY_AUTHOR = "author";
        private static final String KEY_MESSAGES = "messages";
        private static final String KEY_ON_READ = "on_read";
        private static final String KEY_ON_REPLY = "on_reply";
        private static final String KEY_PARTICIPANTS = "participants";
        private static final String KEY_REMOTE_INPUT = "remote_input";
        private static final String KEY_TEXT = "text";
        private static final String KEY_TIMESTAMP = "timestamp";
        private int mColor;
        private Bitmap mLargeIcon;
        private UnreadConversation mUnreadConversation;

        public static class Api20Impl {
            public static Parcelable castToParcelable(android.app.RemoteInput r100) {
                return r100;
            }

            private Api20Impl() {
            }

            public static android.app.RemoteInput build(android.app.RemoteInput.Builder r100) {
                return r100.build();
            }

            public static android.app.RemoteInput.Builder createBuilder(String r100) {
                return new android.app.RemoteInput.Builder(r100);
            }

            public static boolean getAllowFreeFormInput(android.app.RemoteInput r100) {
                return r100.getAllowFreeFormInput();
            }

            public static CharSequence[] getChoices(android.app.RemoteInput r100) {
                return r100.getChoices();
            }

            public static Bundle getExtras(android.app.RemoteInput r100) {
                return r100.getExtras();
            }

            public static CharSequence getLabel(android.app.RemoteInput r100) {
                return r100.getLabel();
            }

            public static String getResultKey(android.app.RemoteInput r100) {
                return r100.getResultKey();
            }

            public static android.app.RemoteInput.Builder addExtras(android.app.RemoteInput.Builder r100, Bundle r101) {
                return r100.addExtras(r101);
            }

            public static android.app.RemoteInput.Builder setAllowFreeFormInput(android.app.RemoteInput.Builder r100, boolean r101) {
                return r100.setAllowFreeFormInput(r101);
            }

            public static android.app.RemoteInput.Builder setChoices(android.app.RemoteInput.Builder r100, CharSequence[] r101) {
                return r100.setChoices(r101);
            }

            public static android.app.RemoteInput.Builder setLabel(android.app.RemoteInput.Builder r100, CharSequence r101) {
                return r100.setLabel(r101);
            }
        }

        public static class Api29Impl {
            private Api29Impl() {
            }

            public static int getEditChoicesBeforeSending(android.app.RemoteInput r100) {
                return r100.getEditChoicesBeforeSending();
            }
        }

        public static class UnreadConversation {
            private final long mLatestTimestamp;
            private final String[] mMessages;
            private final String[] mParticipants;
            private final PendingIntent mReadPendingIntent;
            private final RemoteInput mRemoteInput;
            private final PendingIntent mReplyPendingIntent;

            public static class Builder {
                private long mLatestTimestamp;
                private final List<String> mMessages;
                private final String mParticipant;
                private PendingIntent mReadPendingIntent;
                private RemoteInput mRemoteInput;
                private PendingIntent mReplyPendingIntent;

                public UnreadConversation build() {
                    List<String> r100 = this.mMessages;
                    return new UnreadConversation((String[]) r100.toArray(new String[r100.size()]), this.mRemoteInput, this.mReplyPendingIntent, this.mReadPendingIntent, new String[]{this.mParticipant}, this.mLatestTimestamp);
                }

                public Builder(String r100) {
                    this.mMessages = new ArrayList();
                    this.mParticipant = r100;
                }

                public Builder addMessage(String r100) {
                    if (r100 == null) goto L4;
                    this.mMessages.add(r100);
                L4:
                    return this;
                }

                public Builder setLatestTimestamp(long r100) {
                    this.mLatestTimestamp = r100;
                    return this;
                }

                public Builder setReadPendingIntent(PendingIntent r100) {
                    this.mReadPendingIntent = r100;
                    return this;
                }

                public Builder setReplyAction(PendingIntent r100, RemoteInput r101) {
                    this.mRemoteInput = r101;
                    this.mReplyPendingIntent = r100;
                    return this;
                }
            }

            public String getParticipant() {
                String[] r100 = this.mParticipants;
                if (r100.length > 0) goto L7;
                return null;
            L7:
                return r100[0];
            }

            public long getLatestTimestamp() {
                return this.mLatestTimestamp;
            }

            public String[] getMessages() {
                return this.mMessages;
            }

            public String[] getParticipants() {
                return this.mParticipants;
            }

            public PendingIntent getReadPendingIntent() {
                return this.mReadPendingIntent;
            }

            public RemoteInput getRemoteInput() {
                return this.mRemoteInput;
            }

            public PendingIntent getReplyPendingIntent() {
                return this.mReplyPendingIntent;
            }

            public UnreadConversation(String[] r100, RemoteInput r101, PendingIntent r102, PendingIntent r103, String[] r104, long r105) {
                this.mMessages = r100;
                this.mRemoteInput = r101;
                this.mReadPendingIntent = r103;
                this.mReplyPendingIntent = r102;
                this.mParticipants = r104;
                this.mLatestTimestamp = r105;
            }
        }

        public CarExtender() {
            this.mColor = 0;
        }

        public int getColor() {
            return this.mColor;
        }

        public Bitmap getLargeIcon() {
            return this.mLargeIcon;
        }

        public UnreadConversation getUnreadConversation() {
            return this.mUnreadConversation;
        }

        public CarExtender(Notification r100) {
            this.mColor = 0;
            if (NotificationCompat.getExtras(r100) != null) goto L5;
            Bundle r101 = null;
        L6:
            if (r101 == null) goto L9;
            this.mLargeIcon = (Bitmap) r101.getParcelable(EXTRA_LARGE_ICON);
            this.mColor = r101.getInt(EXTRA_COLOR, 0);
            this.mUnreadConversation = getUnreadConversationFromBundle(r101.getBundle(EXTRA_CONVERSATION));
            return;
        L9:
            return;
        L5:
            r101 = NotificationCompat.getExtras(r100).getBundle(EXTRA_CAR_EXTENDER);
            goto L6
        }

        private static Bundle getBundleForUnreadConversation(UnreadConversation r100) {
            Bundle r101 = new Bundle();
            int r102 = 0;
            if (r100.getParticipants() != null) goto L5;
        L7:
            String r103 = null;
        L8:
            int r104 = r100.getMessages().length;
            Parcelable[] r105 = new Parcelable[r104];
        L9:
            if (r102 >= r104) goto L11;
            Bundle r106 = new Bundle();
            r106.putString("text", r100.getMessages()[r102]);
            r106.putString(KEY_AUTHOR, r103);
            r105[r102] = r106;
            r102 = r102 + 1;
            goto L9
        L11:
            r101.putParcelableArray(KEY_MESSAGES, r105);
            RemoteInput r107 = r100.getRemoteInput();
            if (r107 == null) goto L14;
            android.app.RemoteInput.Builder r108 = Api20Impl.createBuilder(r107.getResultKey());
            Api20Impl.setLabel(r108, r107.getLabel());
            Api20Impl.setChoices(r108, r107.getChoices());
            Api20Impl.setAllowFreeFormInput(r108, r107.getAllowFreeFormInput());
            Api20Impl.addExtras(r108, r107.getExtras());
            r101.putParcelable(KEY_REMOTE_INPUT, Api20Impl.castToParcelable(Api20Impl.build(r108)));
        L14:
            r101.putParcelable(KEY_ON_REPLY, r100.getReplyPendingIntent());
            r101.putParcelable(KEY_ON_READ, r100.getReadPendingIntent());
            r101.putStringArray(KEY_PARTICIPANTS, r100.getParticipants());
            r101.putLong("timestamp", r100.getLatestTimestamp());
            return r101;
        L5:
            if (r100.getParticipants().length <= 1) goto L7;
            r103 = r100.getParticipants()[0];
            goto L8
        }

        private static UnreadConversation getUnreadConversationFromBundle(Bundle r210) {
            RemoteInput r100 = null;
            if (r210 != null) goto L5;
            return null;
        L5:
            Parcelable[] r101 = r210.getParcelableArray(KEY_MESSAGES);
            if (r101 == null) goto L20;
            int r102 = r101.length;
            String[] r103 = new String[r102];
            int r104 = 0;
        L8:
            if (r104 >= r102) goto L16;
            Parcelable r105 = r101[r104];
            if ((r105 instanceof Bundle) == false) goto L11;
            String r106 = ((Bundle) r105).getString("text");
            r103[r104] = r106;
            if (r106 == null) goto L11;
            r104 = r104 + 1;
        L11:
            boolean r107 = false;
        L17:
            if (r107 == false) goto L19;
            String[] r108 = r103;
        L21:
            PendingIntent r110 = (PendingIntent) r210.getParcelable(KEY_ON_READ);
            PendingIntent r111 = (PendingIntent) r210.getParcelable(KEY_ON_REPLY);
            android.app.RemoteInput r109 = (android.app.RemoteInput) r210.getParcelable(KEY_REMOTE_INPUT);
            String[] r112 = r210.getStringArray(KEY_PARTICIPANTS);
            if (r112 != null) goto L24;
            return null;
        L24:
            if (r112.length != 1) goto L38;
            if (r109 == null) goto L33;
            String r113 = Api20Impl.getResultKey(r109);
            CharSequence r114 = Api20Impl.getLabel(r109);
            CharSequence[] r115 = Api20Impl.getChoices(r109);
            boolean r116 = Api20Impl.getAllowFreeFormInput(r109);
            if (Build.VERSION.SDK_INT < 29) goto L30;
            int r117 = Api29Impl.getEditChoicesBeforeSending(r109);
        L31:
            r100 = new RemoteInput(r113, r114, r115, r116, r117, Api20Impl.getExtras(r109), null);
            goto L33
        L30:
            r117 = 0;
        L33:
            return new UnreadConversation(r108, r100, r111, r110, r112, r210.getLong("timestamp"));
        L38:
            return null;
        L19:
            return null;
        L16:
            r107 = true;
            goto L17
        L20:
            r108 = null;
            goto L21
        }

        @Override // androidx.core.app.NotificationCompat.Extender
        public Builder extend(Builder r100) {
            Bundle r101 = new Bundle();
            Bitmap r102 = this.mLargeIcon;
            if (r102 == null) goto L5;
            r101.putParcelable(EXTRA_LARGE_ICON, r102);
        L5:
            int r103 = this.mColor;
            if (r103 == 0) goto L8;
            r101.putInt(EXTRA_COLOR, r103);
        L8:
            UnreadConversation r104 = this.mUnreadConversation;
            if (r104 == null) goto L11;
            r101.putBundle(EXTRA_CONVERSATION, getBundleForUnreadConversation(r104));
        L11:
            r100.getExtras().putBundle(EXTRA_CAR_EXTENDER, r101);
            return r100;
        }

        public CarExtender setColor(int r100) {
            this.mColor = r100;
            return this;
        }

        public CarExtender setLargeIcon(Bitmap r100) {
            this.mLargeIcon = r100;
            return this;
        }

        public CarExtender setUnreadConversation(UnreadConversation r100) {
            this.mUnreadConversation = r100;
            return this;
        }
    }

    public static class DecoratedCustomViewStyle extends Style {
        private static final int MAX_ACTION_BUTTONS = 3;
        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$DecoratedCustomViewStyle";

        public static class Api24Impl {
            private Api24Impl() {
            }

            public static Notification.Style createDecoratedCustomViewStyle() {
                return new Notification.DecoratedCustomViewStyle();
            }
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public boolean displayCustomViewInline() {
            return true;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public String getClassName() {
            return TEMPLATE_CLASS_NAME;
        }

        public DecoratedCustomViewStyle() {
        }

        private RemoteViews generateActionButton(Action r100) {
            if (r100.actionIntent != null) goto L5;
            boolean r101 = true;
        L6:
            String r102 = this.mBuilder.mContext.getPackageName();
            if (r101 == false) goto L9;
            int r103 = R.layout.notification_action_tombstone;
        L10:
            RemoteViews r104 = new RemoteViews(r102, r103);
            IconCompat r105 = r100.getIconCompat();
            if (r105 == null) goto L13;
            r104.setImageViewBitmap(R.id.action_image, createColoredBitmap(r105, R.color.notification_action_color_filter));
        L13:
            r104.setTextViewText(R.id.action_text, r100.title);
            if (r101 == true) goto L16;
            r104.setOnClickPendingIntent(R.id.action_container, r100.actionIntent);
        L16:
            r104.setContentDescription(R.id.action_container, r100.title);
            return r104;
        L9:
            r103 = R.layout.notification_action;
            goto L10
        L5:
            r101 = false;
            goto L6
        }

        private static List<Action> getNonContextualActions(List<Action> r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            ArrayList r101 = new ArrayList();
            Iterator<Action> r102 = r100.iterator();
        L7:
            if (r102.hasNext() == false) goto L11;
            Action r103 = r102.next();
            if (r103.isContextual() == true) goto L7;
            r101.add(r103);
            goto L7
        L11:
            return r101;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void apply(NotificationBuilderWithBuilderAccessor r100) {
            if (Build.VERSION.SDK_INT < 24) goto L6;
            r100.getBuilder().setStyle(Api24Impl.createDecoratedCustomViewStyle());
            return;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor r100) {
            if (Build.VERSION.SDK_INT < 24) goto L5;
            return null;
        L5:
            RemoteViews r101 = this.mBuilder.getBigContentView();
            if (r101 != null) goto L9;
            r101 = this.mBuilder.getContentView();
        L9:
            if (r101 != null) goto L12;
            return null;
        L12:
            return createRemoteViews(r101, true);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor r100) {
            if (Build.VERSION.SDK_INT < 24) goto L6;
            return null;
        L6:
            if (this.mBuilder.getContentView() != null) goto L9;
            return null;
        L9:
            return createRemoteViews(this.mBuilder.getContentView(), false);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor r100) {
            if (Build.VERSION.SDK_INT < 24) goto L5;
            return null;
        L5:
            RemoteViews r101 = this.mBuilder.getHeadsUpContentView();
            if (r101 == null) goto L8;
            RemoteViews r102 = r101;
        L9:
            if (r101 != null) goto L12;
            return null;
        L12:
            return createRemoteViews(r102, true);
        L8:
            r102 = this.mBuilder.getContentView();
            goto L9
        }

        private RemoteViews createRemoteViews(RemoteViews r100, boolean r101) {
            boolean r102 = true;
            int r103 = 0;
            RemoteViews r104 = applyStandardTemplate(true, R.layout.notification_template_custom_big, false);
            r104.removeAllViews(R.id.actions);
            List<Action> r105 = getNonContextualActions(this.mBuilder.mActions);
            if (r101 == false) goto L10;
            if (r105 == null) goto L10;
            int r106 = Math.min(r105.size(), 3);
            if (r106 <= 0) goto L10;
            int r107 = 0;
        L8:
            if (r107 >= r106) goto L11;
            r104.addView(R.id.actions, generateActionButton((Action) ListProtector.get(r105, r107)));
            r107 = r107 + 1;
        L11:
            if (r102 == true) goto L14;
            r103 = 8;
        L14:
            r104.setViewVisibility(R.id.actions, r103);
            r104.setViewVisibility(R.id.action_divider, r103);
            buildIntoRemoteViews(r104, r100);
            return r104;
        L10:
            r102 = false;
            goto L11
        }

        public static List<CharSequence> getTextsFromContentView(Context r100, Notification r101) {
            String r102 = r101.extras.getString(NotificationCompat.EXTRA_TEMPLATE);
            if (Notification.DecoratedCustomViewStyle.class.getName().equals(r102) == false) goto L5;
            RemoteViews r103 = r101.contentView;
            if (r103 == null) goto L9;
        L14:
            RemoteViews r104 = r101.bigContentView;
            if (r104 == null) goto L17;
            r103 = r104;
        L20:
            String r105 = r103.getPackage();
            Context r106 = r100.createPackageContext(r105, 0);     // Catch: PackageManager.NameNotFoundException -> L24
            r106.setTheme(r100.getPackageManager().getApplicationInfo(r105, 0).theme);
            View r107 = r103.apply(r106, null);
            ArrayList r108 = new ArrayList();
            getTextsFromViewTraversal(r107, r108);
            return r108;
        L24:
            e = move-exception;
            throw new RuntimeException(e);
        L17:
            if (r103 != null) goto L20;
            r103 = r101.headsUpContentView;
            goto L20
        L9:
            if (r101.bigContentView != null) goto L14;
            if (r101.headsUpContentView != null) goto L14;
            return Collections.emptyList();
        L5:
            return Collections.emptyList();
        }

        private static void getTextsFromViewTraversal(View r100, ArrayList<CharSequence> r101) {
            if ((r100 instanceof ViewGroup) == true) goto L5;
            return;
        L5:
            int r102 = 0;
        L6:
            ViewGroup r103 = (ViewGroup) r100;
            if (r102 >= r103.getChildCount()) goto L19;
            View r104 = r103.getChildAt(r102);
            if ((r104 instanceof TextView) == false) goto L16;
            CharSequence r105 = ((TextView) r104).getText();
            if (r105 == null) goto L16;
            if (r105.length() <= 0) goto L16;
            r101.add(r105);
        L16:
            if ((r104 instanceof ViewGroup) == false) goto L18;
            getTextsFromViewTraversal(r104, r101);
        L18:
            r102 = r102 + 1;
            goto L6
        }
    }

    public interface Extender {
        Builder extend(Builder r100);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface GroupAlertBehavior {
    }

    public static class InboxStyle extends Style {
        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$InboxStyle";
        private ArrayList<CharSequence> mTexts;

        @Override // androidx.core.app.NotificationCompat.Style
        public String getClassName() {
            return TEMPLATE_CLASS_NAME;
        }

        public InboxStyle() {
            this.mTexts = new ArrayList();
        }

        public InboxStyle(Builder r100) {
            this.mTexts = new ArrayList();
            setBuilder(r100);
        }

        public InboxStyle addLine(CharSequence r100) {
            if (r100 == null) goto L4;
            this.mTexts.add(Builder.limitCharSequenceLength(r100));
        L4:
            return this;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void apply(NotificationBuilderWithBuilderAccessor r100) {
            Notification.InboxStyle r101 = new Notification.InboxStyle(r100.getBuilder()).setBigContentTitle(this.mBigContentTitle);
            if (this.mSummaryTextSet == false) goto L5;
            r101.setSummaryText(this.mSummaryText);
        L5:
            Iterator<CharSequence> r102 = this.mTexts.iterator();
        L7:
            if (r102.hasNext() == false) goto L9;
            r101.addLine(r102.next());
            goto L7
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void clearCompatExtraKeys(Bundle r100) {
            super.clearCompatExtraKeys(r100);
            r100.remove(NotificationCompat.EXTRA_TEXT_LINES);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void restoreFromCompatExtras(Bundle r100) {
            super.restoreFromCompatExtras(r100);
            this.mTexts.clear();
            if (r100.containsKey(NotificationCompat.EXTRA_TEXT_LINES) == false) goto L6;
            Collections.addAll(this.mTexts, r100.getCharSequenceArray(NotificationCompat.EXTRA_TEXT_LINES));
            return;
        }

        public InboxStyle setBigContentTitle(CharSequence r100) {
            this.mBigContentTitle = Builder.limitCharSequenceLength(r100);
            return this;
        }

        public InboxStyle setSummaryText(CharSequence r100) {
            this.mSummaryText = Builder.limitCharSequenceLength(r100);
            this.mSummaryTextSet = true;
            return this;
        }
    }

    public static class MessagingStyle extends Style {
        public static final int MAXIMUM_RETAINED_MESSAGES = 25;
        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$MessagingStyle";
        private CharSequence mConversationTitle;
        private final List<Message> mHistoricMessages;
        private Boolean mIsGroupConversation;
        private final List<Message> mMessages;
        private Person mUser;

        public static class Api24Impl {
            private Api24Impl() {
            }

            public static Notification.MessagingStyle createMessagingStyle(CharSequence r100) {
                return new Notification.MessagingStyle(r100);
            }

            public static Notification.MessagingStyle addMessage(Notification.MessagingStyle r100, Notification.MessagingStyle.Message r101) {
                return r100.addMessage(r101);
            }

            public static Notification.MessagingStyle setConversationTitle(Notification.MessagingStyle r100, CharSequence r101) {
                return r100.setConversationTitle(r101);
            }
        }

        public static class Api26Impl {
            private Api26Impl() {
            }

            public static Notification.MessagingStyle addHistoricMessage(Notification.MessagingStyle r100, Notification.MessagingStyle.Message r101) {
                return r100.addHistoricMessage(r101);
            }
        }

        public static class Api28Impl {
            private Api28Impl() {
            }

            public static Notification.MessagingStyle createMessagingStyle(android.app.Person r100) {
                return new Notification.MessagingStyle(r100);
            }

            public static Notification.MessagingStyle setGroupConversation(Notification.MessagingStyle r100, boolean r101) {
                return r100.setGroupConversation(r101);
            }
        }

        public static final class Message {
            static final String KEY_DATA_MIME_TYPE = "type";
            static final String KEY_DATA_URI = "uri";
            static final String KEY_EXTRAS_BUNDLE = "extras";
            static final String KEY_NOTIFICATION_PERSON = "sender_person";
            static final String KEY_PERSON = "person";
            static final String KEY_SENDER = "sender";
            static final String KEY_TEXT = "text";
            static final String KEY_TIMESTAMP = "time";
            private String mDataMimeType;
            private Uri mDataUri;
            private Bundle mExtras;
            private final Person mPerson;
            private final CharSequence mText;
            private final long mTimestamp;

            public static class Api24Impl {
                private Api24Impl() {
                }

                public static Notification.MessagingStyle.Message createMessage(CharSequence r100, long r101, CharSequence r102) {
                    return new Notification.MessagingStyle.Message(r100, r101, r102);
                }

                public static Notification.MessagingStyle.Message setData(Notification.MessagingStyle.Message r100, String r101, Uri r102) {
                    return r100.setData(r101, r102);
                }
            }

            public static class Api28Impl {
                public static Parcelable castToParcelable(android.app.Person r100) {
                    return r100;
                }

                private Api28Impl() {
                }

                public static Notification.MessagingStyle.Message createMessage(CharSequence r100, long r101, android.app.Person r102) {
                    return new Notification.MessagingStyle.Message(r100, r101, r102);
                }
            }

            private Bundle toBundle() {
                Bundle r100 = new Bundle();
                CharSequence r101 = this.mText;
                if (r101 == null) goto L5;
                r100.putCharSequence("text", r101);
            L5:
                r100.putLong("time", this.mTimestamp);
                Person r102 = this.mPerson;
                if (r102 == null) goto L11;
                r100.putCharSequence(KEY_SENDER, r102.getName());
                if (Build.VERSION.SDK_INT < 28) goto L10;
                r100.putParcelable(KEY_NOTIFICATION_PERSON, Api28Impl.castToParcelable(this.mPerson.toAndroidPerson()));
                goto L11
            L10:
                r100.putBundle(KEY_PERSON, this.mPerson.toBundle());
            L11:
                String r103 = this.mDataMimeType;
                if (r103 == null) goto L14;
                r100.putString("type", r103);
            L14:
                Uri r104 = this.mDataUri;
                if (r104 == null) goto L17;
                r100.putParcelable("uri", r104);
            L17:
                Bundle r105 = this.mExtras;
                if (r105 == null) goto L20;
                r100.putBundle("extras", r105);
            L20:
                return r100;
            }

            public CharSequence getSender() {
                Person r100 = this.mPerson;
                if (r100 != null) goto L6;
                return null;
            L6:
                return r100.getName();
            }

            public Notification.MessagingStyle.Message toAndroidMessage() {
                Person r100 = getPerson();
                CharSequence r101 = null;
                android.app.Person r102 = null;
                if (Build.VERSION.SDK_INT < 28) goto L9;
                CharSequence r103 = getText();
                long r104 = getTimestamp();
                if (r100 == null) goto L8;
                r102 = r100.toAndroidPerson();
            L8:
                Notification.MessagingStyle.Message r105 = Api28Impl.createMessage(r103, r104, r102);
            L15:
                if (getDataMimeType() == null) goto L17;
                Api24Impl.setData(r105, getDataMimeType(), getDataUri());
            L17:
                return r105;
            L9:
                CharSequence r106 = getText();
                long r107 = getTimestamp();
                if (r100 == null) goto L13;
                r101 = r100.getName();
            L13:
                r105 = Api24Impl.createMessage(r106, r107, r101);
                goto L15
            }

            public String getDataMimeType() {
                return this.mDataMimeType;
            }

            public Uri getDataUri() {
                return this.mDataUri;
            }

            public Bundle getExtras() {
                return this.mExtras;
            }

            public Person getPerson() {
                return this.mPerson;
            }

            public CharSequence getText() {
                return this.mText;
            }

            public long getTimestamp() {
                return this.mTimestamp;
            }

            public static Bundle[] getBundleArrayForMessages(List<Message> r100) {
                Bundle[] r101 = new Bundle[r100.size()];
                int r102 = r100.size();
                int r103 = 0;
            L3:
                if (r103 >= r102) goto L5;
                r101[r103] = ((Message) ListProtector.get(r100, r103)).toBundle();
                r103 = r103 + 1;
                goto L3
            L5:
                return r101;
            }

            public static Message getMessageFromBundle(Bundle r110) {
                if (r110.containsKey("text") == false) goto L29;
                if (r110.containsKey("time") == false) goto L29;
                if (r110.containsKey(KEY_PERSON) == false) goto L12;
                Person r100 = Person.fromBundle(r110.getBundle(KEY_PERSON));     // Catch: ClassCastException -> L30
            L20:
                Message r101 = new Message(r110.getCharSequence("text"), r110.getLong("time"), r100);     // Catch: ClassCastException -> L30
                if (r110.containsKey("type") == false) goto L26;
                if (r110.containsKey("uri") == false) goto L26;
                r101.setData(r110.getString("type"), (Uri) r110.getParcelable("uri"));     // Catch: ClassCastException -> L30
            L26:
                if (r110.containsKey("extras") == false) goto L28;
                r101.getExtras().putAll(r110.getBundle("extras"));     // Catch: ClassCastException -> L30
            L28:
                return r101;
            L12:
                if (r110.containsKey(KEY_NOTIFICATION_PERSON) == false) goto L17;
                if (Build.VERSION.SDK_INT < 28) goto L17;
                r100 = Person.fromAndroidPerson((android.app.Person) r110.getParcelable(KEY_NOTIFICATION_PERSON));     // Catch: ClassCastException -> L30
            L17:
                if (r110.containsKey(KEY_SENDER) == false) goto L19;
                r100 = new Person.Builder().setName(r110.getCharSequence(KEY_SENDER)).build();     // Catch: ClassCastException -> L30
                goto L20
            L19:
                r100 = null;
            L29:
                return null;
            }

            public static List<Message> getMessagesFromBundleArray(Parcelable[] r100) {
                ArrayList r101 = new ArrayList(r100.length);
                int r102 = 0;
            L4:
                if (r102 >= r100.length) goto L11;
                Parcelable r103 = r100[r102];
                if ((r103 instanceof Bundle) == false) goto L10;
                Message r104 = getMessageFromBundle((Bundle) r103);
                if (r104 == null) goto L10;
                r101.add(r104);
            L10:
                r102 = r102 + 1;
                goto L4
            L11:
                return r101;
            }

            public Message setData(String r100, Uri r101) {
                this.mDataMimeType = r100;
                this.mDataUri = r101;
                return this;
            }

            public Message(CharSequence r100, long r101, Person r102) {
                this.mExtras = new Bundle();
                this.mText = r100;
                this.mTimestamp = r101;
                this.mPerson = r102;
            }

            public Message(CharSequence r100, long r101, CharSequence r102) {
                this(r100, r101, new Person.Builder().setName(r102).build());
            }
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public String getClassName() {
            return TEMPLATE_CLASS_NAME;
        }

        private Message findLatestIncomingMessage() {
            int r100 = this.mMessages.size() - 1;
        L3:
            if (r100 < 0) goto L11;
            Message r101 = (Message) ListProtector.get(this.mMessages, r100);
            if (r101.getPerson() == null) goto L9;
            if (TextUtils.isEmpty(r101.getPerson().getName()) == true) goto L9;
            return r101;
        L9:
            r100 = r100 - 1;
            goto L3
        L11:
            if (this.mMessages.isEmpty() == true) goto L14;
            List<Message> r102 = this.mMessages;
            return (Message) ListProtector.get(r102, r102.size() - 1);
        L14:
            return null;
        }

        private boolean hasMessagesWithoutSender() {
            int r100 = this.mMessages.size() - 1;
        L3:
            if (r100 < 0) goto L10;
            Message r101 = (Message) ListProtector.get(this.mMessages, r100);
            if (r101.getPerson() == null) goto L9;
            if (r101.getPerson().getName() != null) goto L9;
            return true;
        L9:
            r100 = r100 - 1;
            goto L3
        L10:
            return false;
        }

        public CharSequence getUserDisplayName() {
            return this.mUser.getName();
        }

        public boolean isGroupConversation() {
            Builder r100 = this.mBuilder;
            if (r100 != null) goto L5;
        L12:
            Boolean r101 = this.mIsGroupConversation;
            if (r101 != null) goto L15;
            return false;
        L15:
            return r101.booleanValue();
        L5:
            if (r100.mContext.getApplicationInfo().targetSdkVersion >= 28) goto L12;
            if (this.mIsGroupConversation != null) goto L12;
            if (this.mConversationTitle == null) goto L16;
            return true;
        L16:
            return false;
        }

        public MessagingStyle() {
            this.mMessages = new ArrayList();
            this.mHistoricMessages = new ArrayList();
        }

        public CharSequence getConversationTitle() {
            return this.mConversationTitle;
        }

        public List<Message> getHistoricMessages() {
            return this.mHistoricMessages;
        }

        public List<Message> getMessages() {
            return this.mMessages;
        }

        public Person getUser() {
            return this.mUser;
        }

        public MessagingStyle(Person r100) {
            this.mMessages = new ArrayList();
            this.mHistoricMessages = new ArrayList();
            if (TextUtils.isEmpty(r100.getName()) == true) goto L7;
            this.mUser = r100;
            return;
        L7:
            throw new IllegalArgumentException("User's name must not be empty.");
        }

        public static MessagingStyle extractMessagingStyleFromNotification(Notification r100) {
            Style r101 = Style.extractStyleFromNotification(r100);
            if ((r101 instanceof MessagingStyle) == true) goto L5;
            return null;
        L5:
            return (MessagingStyle) r101;
        }

        private TextAppearanceSpan makeFontColorSpan(int r100) {
            return new TextAppearanceSpan(null, 0, 0, ColorStateList.valueOf(r100), null);
        }

        private CharSequence makeMessageLine(Message r100) {
            BidiFormatter r101 = BidiFormatter.getInstance();
            SpannableStringBuilder r102 = new SpannableStringBuilder();
            CharSequence r103 = "";
            if (r100.getPerson() != null) goto L5;
            CharSequence r104 = "";
        L6:
            int r105 = -16777216;
            if (TextUtils.isEmpty(r104) == false) goto L11;
            r104 = this.mUser.getName();
            if (this.mBuilder.getColor() == 0) goto L11;
            r105 = this.mBuilder.getColor();
        L11:
            CharSequence r106 = r101.unicodeWrap(r104);
            r102.append(r106);
            r102.setSpan(makeFontColorSpan(r105), r102.length() - r106.length(), r102.length(), 33);
            if (r100.getText() == null) goto L15;
            r103 = r100.getText();
        L15:
            r102.append(tb2.c.DEFAULT_TEXT).append(r101.unicodeWrap(r103));
            return r102;
        L5:
            r104 = r100.getPerson().getName();
            goto L6
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void addCompatExtras(Bundle r100) {
            super.addCompatExtras(r100);
            r100.putCharSequence(NotificationCompat.EXTRA_SELF_DISPLAY_NAME, this.mUser.getName());
            r100.putBundle(NotificationCompat.EXTRA_MESSAGING_STYLE_USER, this.mUser.toBundle());
            r100.putCharSequence(NotificationCompat.EXTRA_HIDDEN_CONVERSATION_TITLE, this.mConversationTitle);
            if (this.mConversationTitle == null) goto L8;
            if (this.mIsGroupConversation.booleanValue() == false) goto L8;
            r100.putCharSequence(NotificationCompat.EXTRA_CONVERSATION_TITLE, this.mConversationTitle);
        L8:
            if (this.mMessages.isEmpty() == true) goto L11;
            r100.putParcelableArray(NotificationCompat.EXTRA_MESSAGES, Message.getBundleArrayForMessages(this.mMessages));
        L11:
            if (this.mHistoricMessages.isEmpty() == true) goto L13;
            r100.putParcelableArray(NotificationCompat.EXTRA_HISTORIC_MESSAGES, Message.getBundleArrayForMessages(this.mHistoricMessages));
        L13:
            Boolean r101 = this.mIsGroupConversation;
            if (r101 == null) goto L17;
            r100.putBoolean(NotificationCompat.EXTRA_IS_GROUP_CONVERSATION, r101.booleanValue());
            return;
        }

        public MessagingStyle addHistoricMessage(Message r100) {
            if (r100 == null) goto L6;
            this.mHistoricMessages.add(r100);
            if (this.mHistoricMessages.size() <= 25) goto L6;
            ListProtector.remove(this.mHistoricMessages, 0);
        L6:
            return this;
        }

        public MessagingStyle addMessage(Message r100) {
            if (r100 == null) goto L6;
            this.mMessages.add(r100);
            if (this.mMessages.size() <= 25) goto L6;
            ListProtector.remove(this.mMessages, 0);
        L6:
            return this;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void apply(NotificationBuilderWithBuilderAccessor r100) {
            setGroupConversation(isGroupConversation());
            int r101 = Build.VERSION.SDK_INT;
            if (r101 >= 24) goto L5;
            Message r102 = findLatestIncomingMessage();
            if (this.mConversationTitle != null) goto L30;
        L32:
            if (r102 == null) goto L36;
            r100.getBuilder().setContentTitle("");
            if (r102.getPerson() == null) goto L36;
            r100.getBuilder().setContentTitle(r102.getPerson().getName());
        L36:
            if (r102 == null) goto L42;
            Notification.Builder r103 = r100.getBuilder();
            if (this.mConversationTitle == null) goto L40;
            CharSequence r104 = makeMessageLine(r102);
        L41:
            r103.setContentText(r104);
            goto L42
        L40:
            r104 = r102.getText();
        L42:
            SpannableStringBuilder r105 = new SpannableStringBuilder();
            if (this.mConversationTitle == null) goto L45;
        L48:
            boolean r106 = true;
        L49:
            int r107 = this.mMessages.size() - 1;
        L50:
            if (r107 < 0) goto L59;
            Message r108 = (Message) ListProtector.get(this.mMessages, r107);
            if (r106 == false) goto L54;
            CharSequence r109 = makeMessageLine(r108);
        L56:
            if (r107 == (this.mMessages.size() - 1)) goto L58;
            r105.insert(0, "\n");
        L58:
            r105.insert(0, r109);
            r107 = r107 - 1;
            goto L50
        L54:
            r109 = r108.getText();
            goto L56
        L59:
            new Notification.BigTextStyle(r100.getBuilder()).setBigContentTitle(null).bigText(r105);
            return;
        L45:
            if (hasMessagesWithoutSender() == true) goto L48;
            r106 = false;
            goto L49
        L30:
            if (this.mIsGroupConversation.booleanValue() == false) goto L32;
            r100.getBuilder().setContentTitle(this.mConversationTitle);
            goto L36
        L5:
            if (r101 < 28) goto L7;
            Notification.MessagingStyle r110 = Api28Impl.createMessagingStyle(this.mUser.toAndroidPerson());
        L8:
            Iterator<Message> r111 = this.mMessages.iterator();
        L10:
            if (r111.hasNext() == false) goto L13;
            Api24Impl.addMessage(r110, r111.next().toAndroidMessage());
            goto L10
        L13:
            if (Build.VERSION.SDK_INT < 26) goto L19;
            Iterator<Message> r112 = this.mHistoricMessages.iterator();
        L16:
            if (r112.hasNext() == false) goto L19;
            Api26Impl.addHistoricMessage(r110, r112.next().toAndroidMessage());
        L19:
            if (this.mIsGroupConversation.booleanValue() == false) goto L21;
        L22:
            Api24Impl.setConversationTitle(r110, this.mConversationTitle);
        L24:
            if (Build.VERSION.SDK_INT < 28) goto L26;
            Api28Impl.setGroupConversation(r110, this.mIsGroupConversation.booleanValue());
        L26:
            r110.setBuilder(r100.getBuilder());
            return;
        L21:
            if (Build.VERSION.SDK_INT < 28) goto L24;
        L7:
            r110 = Api24Impl.createMessagingStyle(this.mUser.getName());
            goto L8
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void clearCompatExtraKeys(Bundle r100) {
            super.clearCompatExtraKeys(r100);
            r100.remove(NotificationCompat.EXTRA_MESSAGING_STYLE_USER);
            r100.remove(NotificationCompat.EXTRA_SELF_DISPLAY_NAME);
            r100.remove(NotificationCompat.EXTRA_CONVERSATION_TITLE);
            r100.remove(NotificationCompat.EXTRA_HIDDEN_CONVERSATION_TITLE);
            r100.remove(NotificationCompat.EXTRA_MESSAGES);
            r100.remove(NotificationCompat.EXTRA_HISTORIC_MESSAGES);
            r100.remove(NotificationCompat.EXTRA_IS_GROUP_CONVERSATION);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void restoreFromCompatExtras(Bundle r100) {
            super.restoreFromCompatExtras(r100);
            this.mMessages.clear();
            if (r100.containsKey(NotificationCompat.EXTRA_MESSAGING_STYLE_USER) == false) goto L5;
            this.mUser = Person.fromBundle(r100.getBundle(NotificationCompat.EXTRA_MESSAGING_STYLE_USER));
        L6:
            CharSequence r101 = r100.getCharSequence(NotificationCompat.EXTRA_CONVERSATION_TITLE);
            this.mConversationTitle = r101;
            if (r101 != null) goto L9;
            this.mConversationTitle = r100.getCharSequence(NotificationCompat.EXTRA_HIDDEN_CONVERSATION_TITLE);
        L9:
            Parcelable[] r102 = r100.getParcelableArray(NotificationCompat.EXTRA_MESSAGES);
            if (r102 == null) goto L12;
            this.mMessages.addAll(Message.getMessagesFromBundleArray(r102));
        L12:
            Parcelable[] r103 = r100.getParcelableArray(NotificationCompat.EXTRA_HISTORIC_MESSAGES);
            if (r103 == null) goto L16;
            this.mHistoricMessages.addAll(Message.getMessagesFromBundleArray(r103));
        L16:
            if (r100.containsKey(NotificationCompat.EXTRA_IS_GROUP_CONVERSATION) == false) goto L19;
            this.mIsGroupConversation = Boolean.valueOf(r100.getBoolean(NotificationCompat.EXTRA_IS_GROUP_CONVERSATION));
            return;
        L19:
            return;
        L5:
            this.mUser = new Person.Builder().setName(r100.getString(NotificationCompat.EXTRA_SELF_DISPLAY_NAME)).build();
            goto L6
        }

        public MessagingStyle setConversationTitle(CharSequence r100) {
            this.mConversationTitle = r100;
            return this;
        }

        public MessagingStyle setGroupConversation(boolean r100) {
            this.mIsGroupConversation = Boolean.valueOf(r100);
            return this;
        }

        public MessagingStyle(CharSequence r100) {
            this.mMessages = new ArrayList();
            this.mHistoricMessages = new ArrayList();
            this.mUser = new Person.Builder().setName(r100).build();
        }

        public MessagingStyle addMessage(CharSequence r100, long r101, CharSequence r102) {
            this.mMessages.add(new Message(r100, r101, new Person.Builder().setName(r102).build()));
            if (this.mMessages.size() <= 25) goto L5;
            ListProtector.remove(this.mMessages, 0);
        L5:
            return this;
        }

        public MessagingStyle addMessage(CharSequence r100, long r101, Person r102) {
            addMessage(new Message(r100, r101, r102));
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface NotificationVisibility {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ServiceNotificationBehavior {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface StreamType {
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static abstract class Style {
        CharSequence mBigContentTitle;
        protected Builder mBuilder;
        CharSequence mSummaryText;
        boolean mSummaryTextSet;

        /* JADX INFO: loaded from: classes17.dex */
        public static class Api24Impl {
            private Api24Impl() {
            }

            public static void setChronometerCountDown(RemoteViews r100, int r101, boolean r102) {
                r100.setChronometerCountDown(r101, r102);
            }
        }

        private static float constrain(float r100, float r101, float r102) {
            if (r100 >= r101) goto L6;
            return r101;
        L6:
            if (r100 > r102) goto L8;
            return r100;
        L8:
            return r102;
        }

        public void apply(NotificationBuilderWithBuilderAccessor r100) {
        }

        public boolean displayCustomViewInline() {
            return false;
        }

        public String getClassName() {
            return null;
        }

        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor r100) {
            return null;
        }

        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor r100) {
            return null;
        }

        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor r100) {
            return null;
        }

        private int calculateTopPadding() {
            Resources r100 = this.mBuilder.mContext.getResources();
            int r101 = r100.getDimensionPixelSize(R.dimen.notification_top_pad);
            int r102 = r100.getDimensionPixelSize(R.dimen.notification_top_pad_large_text);
            float r103 = (constrain(r100.getConfiguration().fontScale, 1.0f, 1.3f) - 1.0f) / 0.29999995f;
            return Math.round(((1.0f - r103) * r101) + (r103 * r102));
        }

        public Notification build() {
            Builder r100 = this.mBuilder;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.build();
        }

        public Style() {
            this.mSummaryTextSet = false;
        }

        public static Style constructCompatStyleByName(String r100) {
            if (r100 == null) goto L44;
            byte r101 = -1;
            switch(r100.hashCode()) {
                case -716705180: goto L27;
                case -171946061: goto L23;
                case 714386739: goto L19;
                case 912942987: goto L15;
                case 919595044: goto L11;
                case 2090799565: goto L7;
                default: goto L30;
            };
        L30:
            switch(r101) {
                case 0: goto L43;
                case 1: goto L41;
                case 2: goto L39;
                case 3: goto L37;
                case 4: goto L35;
                case 5: goto L33;
                default: goto L46;
            };
        L46:
            return null;
        L33:
            return new MessagingStyle();
        L35:
            return new BigTextStyle();
        L37:
            return new InboxStyle();
        L39:
            return new CallStyle();
        L41:
            return new BigPictureStyle();
        L43:
            return new DecoratedCustomViewStyle();
        L7:
            if (r100.equals("androidx.core.app.NotificationCompat$MessagingStyle") == false) goto L30;
            r101 = 5;
            goto L30
        L11:
            if (r100.equals("androidx.core.app.NotificationCompat$BigTextStyle") == false) goto L30;
            r101 = 4;
            goto L30
        L15:
            if (r100.equals("androidx.core.app.NotificationCompat$InboxStyle") == false) goto L30;
            r101 = 3;
            goto L30
        L19:
            if (r100.equals("androidx.core.app.NotificationCompat$CallStyle") == false) goto L30;
            r101 = 2;
            goto L30
        L23:
            if (r100.equals("androidx.core.app.NotificationCompat$BigPictureStyle") == false) goto L30;
            r101 = 1;
            goto L30
        L27:
            if (r100.equals("androidx.core.app.NotificationCompat$DecoratedCustomViewStyle") == false) goto L30;
            r101 = 0;
            goto L30
        L44:
            return null;
        }

        private static Style constructCompatStyleByPlatformName(String r100) {
            if (r100 != null) goto L6;
            return null;
        L6:
            if (r100.equals(Notification.BigPictureStyle.class.getName()) == false) goto L10;
            return new BigPictureStyle();
        L10:
            if (r100.equals(Notification.BigTextStyle.class.getName()) == false) goto L14;
            return new BigTextStyle();
        L14:
            if (r100.equals(Notification.InboxStyle.class.getName()) == false) goto L18;
            return new InboxStyle();
        L18:
            if (Build.VERSION.SDK_INT >= 24) goto L20;
        L27:
            return null;
        L20:
            if (r100.equals(Notification.MessagingStyle.class.getName()) == false) goto L24;
            return new MessagingStyle();
        L24:
            if (r100.equals(Notification.DecoratedCustomViewStyle.class.getName()) == false) goto L27;
            return new DecoratedCustomViewStyle();
        }

        public static Style constructCompatStyleForBundle(Bundle r100) {
            Style r101 = constructCompatStyleByName(r100.getString(NotificationCompat.EXTRA_COMPAT_TEMPLATE));
            if (r101 == null) goto L6;
            return r101;
        L6:
            if (r100.containsKey(NotificationCompat.EXTRA_SELF_DISPLAY_NAME) == true) goto L32;
            if (r100.containsKey(NotificationCompat.EXTRA_MESSAGING_STYLE_USER) == true) goto L32;
            if (r100.containsKey(NotificationCompat.EXTRA_PICTURE) == true) goto L30;
            if (r100.containsKey(NotificationCompat.EXTRA_PICTURE_ICON) == true) goto L30;
            if (r100.containsKey(NotificationCompat.EXTRA_BIG_TEXT) == false) goto L20;
            return new BigTextStyle();
        L20:
            if (r100.containsKey(NotificationCompat.EXTRA_TEXT_LINES) == false) goto L24;
            return new InboxStyle();
        L24:
            if (r100.containsKey(NotificationCompat.EXTRA_CALL_TYPE) == false) goto L28;
            return new CallStyle();
        L28:
            return constructCompatStyleByPlatformName(r100.getString(NotificationCompat.EXTRA_TEMPLATE));
        L30:
            return new BigPictureStyle();
        L32:
            return new MessagingStyle();
        }

        public static Style constructStyleForExtras(Bundle r100) {
            Style r101 = constructCompatStyleForBundle(r100);
            if (r101 != null) goto L8;
            return null;
        L8:
            r101.restoreFromCompatExtras(r100);     // Catch: ClassCastException -> L7
            return r101;
        L7:
            return null;
        }

        public static Style extractStyleFromNotification(Notification r100) {
            Bundle r101 = NotificationCompat.getExtras(r100);
            if (r101 != null) goto L7;
            return null;
        L7:
            return constructStyleForExtras(r101);
        }

        private void hideNormalContent(RemoteViews r100) {
            r100.setViewVisibility(R.id.title, 8);
            r100.setViewVisibility(R.id.text2, 8);
            r100.setViewVisibility(R.id.text, 8);
        }

        public void addCompatExtras(Bundle r100) {
            if (this.mSummaryTextSet == false) goto L5;
            r100.putCharSequence(NotificationCompat.EXTRA_SUMMARY_TEXT, this.mSummaryText);
        L5:
            CharSequence r101 = this.mBigContentTitle;
            if (r101 == null) goto L8;
            r100.putCharSequence(NotificationCompat.EXTRA_TITLE_BIG, r101);
        L8:
            String r102 = getClassName();
            if (r102 == null) goto L12;
            r100.putString(NotificationCompat.EXTRA_COMPAT_TEMPLATE, r102);
            return;
        }

        public void clearCompatExtraKeys(Bundle r100) {
            r100.remove(NotificationCompat.EXTRA_SUMMARY_TEXT);
            r100.remove(NotificationCompat.EXTRA_TITLE_BIG);
            r100.remove(NotificationCompat.EXTRA_COMPAT_TEMPLATE);
        }

        public void restoreFromCompatExtras(Bundle r100) {
            if (r100.containsKey(NotificationCompat.EXTRA_SUMMARY_TEXT) == false) goto L5;
            this.mSummaryText = r100.getCharSequence(NotificationCompat.EXTRA_SUMMARY_TEXT);
            this.mSummaryTextSet = true;
        L5:
            this.mBigContentTitle = r100.getCharSequence(NotificationCompat.EXTRA_TITLE_BIG);
        }

        public void setBuilder(Builder r100) {
            if (this.mBuilder == r100) goto L8;
            this.mBuilder = r100;
            if (r100 == null) goto L9;
            r100.setStyle(this);
            return;
        L9:
            return;
        }

        public void buildIntoRemoteViews(RemoteViews r100, RemoteViews r101) {
            hideNormalContent(r100);
            r100.removeAllViews(R.id.notification_main_column);
            r100.addView(R.id.notification_main_column, r101.clone());
            r100.setViewVisibility(R.id.notification_main_column, 0);
            r100.setViewPadding(R.id.notification_main_column_container, 0, calculateTopPadding(), 0, 0);
        }

        public Bitmap createColoredBitmap(int r100, int r101) {
            return createColoredBitmap(r100, r101, 0);
        }

        public Bitmap createColoredBitmap(IconCompat r100, int r101) {
            return createColoredBitmap(r100, r101, 0);
        }

        private Bitmap createColoredBitmap(IconCompat r100, int r101, int r102) {
            Drawable r103 = r100.loadDrawable(this.mBuilder.mContext);
            if (r102 != 0) goto L5;
            int r104 = r103.getIntrinsicWidth();
        L6:
            if (r102 != 0) goto L8;
            r102 = r103.getIntrinsicHeight();
        L8:
            Bitmap r105 = Bitmap.createBitmap(r104, r102, Bitmap.Config.ARGB_8888);
            r103.setBounds(0, 0, r104, r102);
            if (r101 == 0) goto L11;
            r103.mutate().setColorFilter(new PorterDuffColorFilter(r101, PorterDuff.Mode.SRC_IN));
        L11:
            r103.draw(new Canvas(r105));
            return r105;
        L5:
            r104 = r102;
            goto L6
        }

        public RemoteViews applyStandardTemplate(boolean r110, int r111, boolean r112) {
            Resources r100 = this.mBuilder.mContext.getResources();
            RemoteViews r101 = new RemoteViews(this.mBuilder.mContext.getPackageName(), r111);
            this.mBuilder.getPriority();
            int r113 = Build.VERSION.SDK_INT;
            Builder r102 = this.mBuilder;
            int r103 = 0;
            if (r102.mLargeIcon == null) goto L9;
            r101.setViewVisibility(R.id.icon, 0);
            r101.setImageViewBitmap(R.id.icon, createColoredBitmap(this.mBuilder.mLargeIcon, 0));
            if (r110 == true) goto L7;
        L13:
            CharSequence r114 = this.mBuilder.mContentTitle;
            if (r114 == null) goto L16;
            r101.setTextViewText(R.id.title, r114);
        L16:
            CharSequence r115 = this.mBuilder.mContentText;
            boolean r104 = true;
            if (r115 == null) goto L19;
            r101.setTextViewText(R.id.text, r115);
            boolean r116 = true;
        L20:
            Builder r105 = this.mBuilder;
            CharSequence r106 = r105.mContentInfo;
            if (r106 == null) goto L25;
            r101.setTextViewText(R.id.info, r106);
            r101.setViewVisibility(R.id.info, 0);
        L23:
            r116 = true;
            boolean r117 = true;
        L32:
            CharSequence r107 = this.mBuilder.mSubText;
            if (r107 == null) goto L38;
            r101.setTextViewText(R.id.text, r107);
            CharSequence r108 = this.mBuilder.mContentText;
            if (r108 == null) goto L37;
            r101.setTextViewText(R.id.text2, r108);
            r101.setViewVisibility(R.id.text2, 0);
            boolean r109 = true;
        L39:
            if (r109 == false) goto L44;
            if (r112 == false) goto L42;
            r101.setTextViewTextSize(R.id.text, 0, r100.getDimensionPixelSize(R.dimen.notification_subtext_size));
        L42:
            r101.setViewPadding(R.id.line1, 0, 0, 0, 0);
        L44:
            if (this.mBuilder.getWhenIfShowing() != 0) goto L46;
            r104 = r117;
        L54:
            if (r104 == false) goto L56;
            int r118 = 0;
        L57:
            r101.setViewVisibility(R.id.right_side, r118);
            if (r116 == true) goto L61;
            r103 = 8;
        L61:
            r101.setViewVisibility(R.id.line3, r103);
            return r101;
        L56:
            r118 = 8;
            goto L57
        L46:
            if (this.mBuilder.mUseChronometer == false) goto L52;
            r101.setViewVisibility(R.id.chronometer, 0);
            r101.setLong(R.id.chronometer, "setBase", this.mBuilder.getWhenIfShowing() + (SystemClock.elapsedRealtime() - System.currentTimeMillis()));
            r101.setBoolean(R.id.chronometer, "setStarted", true);
            boolean r119 = this.mBuilder.mChronometerCountDown;
            if (r119 == false) goto L54;
            if (r113 < 24) goto L54;
            Api24Impl.setChronometerCountDown(r101, R.id.chronometer, r119);
            goto L54
        L52:
            r101.setViewVisibility(R.id.time, 0);
            r101.setLong(R.id.time, "setTime", this.mBuilder.getWhenIfShowing());
            goto L54
        L37:
            r101.setViewVisibility(R.id.text2, 8);
        L38:
            r109 = false;
            goto L39
        L25:
            if (r105.mNumber > 0) goto L27;
            r101.setViewVisibility(R.id.info, 8);
            r117 = false;
            goto L32
        L27:
            if (this.mBuilder.mNumber <= r100.getInteger(R.integer.status_bar_notification_info_maxnum)) goto L29;
            r101.setTextViewText(R.id.info, r100.getString(R.string.status_bar_notification_info_overflow));
        L30:
            r101.setViewVisibility(R.id.info, 0);
            goto L23
        L29:
            r101.setTextViewText(R.id.info, NumberFormat.getIntegerInstance().format(this.mBuilder.mNumber));
            goto L30
        L19:
            r116 = false;
            goto L20
        L7:
            if (this.mBuilder.mNotification.icon == 0) goto L13;
            int r120 = r100.getDimensionPixelSize(R.dimen.notification_right_icon_size);
            int r121 = r120 - (r100.getDimensionPixelSize(R.dimen.notification_small_icon_background_padding) * 2);
            Builder r122 = this.mBuilder;
            r101.setImageViewBitmap(R.id.right_icon, createIconWithBackground(r122.mNotification.icon, r120, r121, r122.getColor()));
            r101.setViewVisibility(R.id.right_icon, 0);
            goto L13
        L9:
            if (r110 == false) goto L13;
            if (r102.mNotification.icon == 0) goto L13;
            r101.setViewVisibility(R.id.icon, 0);
            int r123 = r100.getDimensionPixelSize(R.dimen.notification_large_icon_width) - r100.getDimensionPixelSize(R.dimen.notification_big_circle_margin);
            int r124 = r100.getDimensionPixelSize(R.dimen.notification_small_icon_size_as_large);
            Builder r125 = this.mBuilder;
            r101.setImageViewBitmap(R.id.icon, createIconWithBackground(r125.mNotification.icon, r123, r124, r125.getColor()));
            goto L13
        }

        private Bitmap createColoredBitmap(int r100, int r101, int r102) {
            return createColoredBitmap(IconCompat.createWithResource(this.mBuilder.mContext, r100), r101, r102);
        }

        private Bitmap createIconWithBackground(int r100, int r101, int r102, int r103) {
            if (r103 != 0) goto L4;
            r103 = 0;
        L4:
            Bitmap r104 = createColoredBitmap(R.drawable.notification_icon_background, r103, r101);
            Canvas r105 = new Canvas(r104);
            Drawable r106 = this.mBuilder.mContext.getResources().getDrawable(r100).mutate();
            r106.setFilterBitmap(true);
            int r107 = (r101 - r102) / 2;
            int r108 = r102 + r107;
            r106.setBounds(r107, r107, r108, r108);
            r106.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
            r106.draw(r105);
            return r104;
        }
    }

    public static final class TvExtender implements Extender {
        static final String EXTRA_CHANNEL_ID = "channel_id";
        static final String EXTRA_CONTENT_INTENT = "content_intent";
        static final String EXTRA_DELETE_INTENT = "delete_intent";
        private static final String EXTRA_FLAGS = "flags";
        static final String EXTRA_SUPPRESS_SHOW_OVER_APPS = "suppressShowOverApps";
        static final String EXTRA_TV_EXTENDER = "android.tv.EXTENSIONS";
        private static final int FLAG_AVAILABLE_ON_TV = 1;
        private static final String TAG = "TvExtender";
        private String mChannelId;
        private PendingIntent mContentIntent;
        private PendingIntent mDeleteIntent;
        private int mFlags;
        private boolean mSuppressShowOverApps;

        public boolean isAvailableOnTv() {
            if ((this.mFlags & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        public TvExtender() {
            this.mFlags = 1;
        }

        public String getChannelId() {
            return this.mChannelId;
        }

        public PendingIntent getContentIntent() {
            return this.mContentIntent;
        }

        public PendingIntent getDeleteIntent() {
            return this.mDeleteIntent;
        }

        public boolean isSuppressShowOverApps() {
            return this.mSuppressShowOverApps;
        }

        public TvExtender(Notification r100) {
            if (Build.VERSION.SDK_INT >= 26) goto L5;
            return;
        L5:
            Bundle r101 = r100.extras;
            if (r101 != null) goto L8;
            Bundle r102 = null;
        L9:
            if (r102 == null) goto L12;
            this.mFlags = r102.getInt(EXTRA_FLAGS);
            this.mChannelId = r102.getString("channel_id");
            this.mSuppressShowOverApps = r102.getBoolean(EXTRA_SUPPRESS_SHOW_OVER_APPS);
            this.mContentIntent = (PendingIntent) r102.getParcelable(EXTRA_CONTENT_INTENT);
            this.mDeleteIntent = (PendingIntent) r102.getParcelable(EXTRA_DELETE_INTENT);
            return;
        L12:
            return;
        L8:
            r102 = r101.getBundle(EXTRA_TV_EXTENDER);
            goto L9
        }

        @Override // androidx.core.app.NotificationCompat.Extender
        public Builder extend(Builder r100) {
            if (Build.VERSION.SDK_INT >= 26) goto L5;
            return r100;
        L5:
            Bundle r101 = new Bundle();
            r101.putInt(EXTRA_FLAGS, this.mFlags);
            r101.putString("channel_id", this.mChannelId);
            r101.putBoolean(EXTRA_SUPPRESS_SHOW_OVER_APPS, this.mSuppressShowOverApps);
            PendingIntent r102 = this.mContentIntent;
            if (r102 == null) goto L8;
            r101.putParcelable(EXTRA_CONTENT_INTENT, r102);
        L8:
            PendingIntent r103 = this.mDeleteIntent;
            if (r103 == null) goto L11;
            r101.putParcelable(EXTRA_DELETE_INTENT, r103);
        L11:
            r100.getExtras().putBundle(EXTRA_TV_EXTENDER, r101);
            return r100;
        }

        public TvExtender setChannelId(String r100) {
            this.mChannelId = r100;
            return this;
        }

        public TvExtender setContentIntent(PendingIntent r100) {
            this.mContentIntent = r100;
            return this;
        }

        public TvExtender setDeleteIntent(PendingIntent r100) {
            this.mDeleteIntent = r100;
            return this;
        }

        public TvExtender setSuppressShowOverApps(boolean r100) {
            this.mSuppressShowOverApps = r100;
            return this;
        }
    }

    public static final class WearableExtender implements Extender {
        private static final int DEFAULT_CONTENT_ICON_GRAVITY = 8388613;
        private static final int DEFAULT_FLAGS = 1;
        private static final int DEFAULT_GRAVITY = 80;
        private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
        private static final int FLAG_BIG_PICTURE_AMBIENT = 32;
        private static final int FLAG_CONTENT_INTENT_AVAILABLE_OFFLINE = 1;
        private static final int FLAG_HINT_AVOID_BACKGROUND_CLIPPING = 16;
        private static final int FLAG_HINT_CONTENT_INTENT_LAUNCHES_ACTIVITY = 64;
        private static final int FLAG_HINT_HIDE_ICON = 2;
        private static final int FLAG_HINT_SHOW_BACKGROUND_ONLY = 4;
        private static final int FLAG_START_SCROLL_BOTTOM = 8;
        private static final String KEY_ACTIONS = "actions";
        private static final String KEY_BACKGROUND = "background";
        private static final String KEY_BRIDGE_TAG = "bridgeTag";
        private static final String KEY_CONTENT_ACTION_INDEX = "contentActionIndex";
        private static final String KEY_CONTENT_ICON = "contentIcon";
        private static final String KEY_CONTENT_ICON_GRAVITY = "contentIconGravity";
        private static final String KEY_CUSTOM_CONTENT_HEIGHT = "customContentHeight";
        private static final String KEY_CUSTOM_SIZE_PRESET = "customSizePreset";
        private static final String KEY_DISMISSAL_ID = "dismissalId";
        private static final String KEY_DISPLAY_INTENT = "displayIntent";
        private static final String KEY_FLAGS = "flags";
        private static final String KEY_GRAVITY = "gravity";
        private static final String KEY_HINT_SCREEN_TIMEOUT = "hintScreenTimeout";
        private static final String KEY_PAGES = "pages";
        public static final int SCREEN_TIMEOUT_LONG = -1;
        public static final int SCREEN_TIMEOUT_SHORT = 0;
        public static final int SIZE_DEFAULT = 0;
        public static final int SIZE_FULL_SCREEN = 5;
        public static final int SIZE_LARGE = 4;
        public static final int SIZE_MEDIUM = 3;
        public static final int SIZE_SMALL = 2;
        public static final int SIZE_XSMALL = 1;
        public static final int UNSET_ACTION_INDEX = -1;
        private ArrayList<Action> mActions;
        private Bitmap mBackground;
        private String mBridgeTag;
        private int mContentActionIndex;
        private int mContentIcon;
        private int mContentIconGravity;
        private int mCustomContentHeight;
        private int mCustomSizePreset;
        private String mDismissalId;
        private PendingIntent mDisplayIntent;
        private int mFlags;
        private int mGravity;
        private int mHintScreenTimeout;
        private ArrayList<Notification> mPages;

        public static class Api20Impl {
            private Api20Impl() {
            }

            public static Notification.Action build(Notification.Action.Builder r100) {
                return r100.build();
            }

            public static Notification.Action.Builder addExtras(Notification.Action.Builder r100, Bundle r101) {
                return r100.addExtras(r101);
            }

            public static Notification.Action.Builder addRemoteInput(Notification.Action.Builder r100, android.app.RemoteInput r101) {
                return r100.addRemoteInput(r101);
            }

            public static Action getActionCompatFromAction(ArrayList<Parcelable> r100, int r101) {
                return NotificationCompat.getActionCompatFromAction((Notification.Action) ListProtector.get(r100, r101));
            }

            public static Notification.Action.Builder createBuilder(int r100, CharSequence r101, PendingIntent r102) {
                return new Notification.Action.Builder(r100, r101, r102);
            }
        }

        public static class Api23Impl {
            private Api23Impl() {
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
        }

        public static class Api31Impl {
            private Api31Impl() {
            }

            public static Notification.Action.Builder setAuthenticationRequired(Notification.Action.Builder r100, boolean r101) {
                return r100.setAuthenticationRequired(r101);
            }
        }

        public WearableExtender clearActions() {
            this.mActions.clear();
            return this;
        }

        public WearableExtender clearPages() {
            this.mPages.clear();
            return this;
        }

        public WearableExtender clone() {
            WearableExtender r100 = new WearableExtender();
            r100.mActions = new ArrayList(this.mActions);
            r100.mFlags = this.mFlags;
            r100.mDisplayIntent = this.mDisplayIntent;
            r100.mPages = new ArrayList(this.mPages);
            r100.mBackground = this.mBackground;
            r100.mContentIcon = this.mContentIcon;
            r100.mContentIconGravity = this.mContentIconGravity;
            r100.mContentActionIndex = this.mContentActionIndex;
            r100.mCustomSizePreset = this.mCustomSizePreset;
            r100.mCustomContentHeight = this.mCustomContentHeight;
            r100.mGravity = this.mGravity;
            r100.mHintScreenTimeout = this.mHintScreenTimeout;
            r100.mDismissalId = this.mDismissalId;
            r100.mBridgeTag = this.mBridgeTag;
            return r100;
        }

        public boolean getContentIntentAvailableOffline() {
            if ((this.mFlags & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        public boolean getHintAmbientBigPicture() {
            if ((this.mFlags & 32) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean getHintAvoidBackgroundClipping() {
            if ((this.mFlags & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean getHintContentIntentLaunchesActivity() {
            if ((this.mFlags & 64) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean getHintHideIcon() {
            if ((this.mFlags & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean getHintShowBackgroundOnly() {
            if ((this.mFlags & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean getStartScrollBottom() {
            if ((this.mFlags & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public WearableExtender() {
            this.mActions = new ArrayList();
            this.mFlags = 1;
            this.mPages = new ArrayList();
            this.mContentIconGravity = 8388613;
            this.mContentActionIndex = -1;
            this.mCustomSizePreset = 0;
            this.mGravity = 80;
        }

        public List<Action> getActions() {
            return this.mActions;
        }

        public Bitmap getBackground() {
            return this.mBackground;
        }

        public String getBridgeTag() {
            return this.mBridgeTag;
        }

        public int getContentAction() {
            return this.mContentActionIndex;
        }

        public int getContentIcon() {
            return this.mContentIcon;
        }

        public int getContentIconGravity() {
            return this.mContentIconGravity;
        }

        public int getCustomContentHeight() {
            return this.mCustomContentHeight;
        }

        public int getCustomSizePreset() {
            return this.mCustomSizePreset;
        }

        public String getDismissalId() {
            return this.mDismissalId;
        }

        public PendingIntent getDisplayIntent() {
            return this.mDisplayIntent;
        }

        public int getGravity() {
            return this.mGravity;
        }

        public int getHintScreenTimeout() {
            return this.mHintScreenTimeout;
        }

        public List<Notification> getPages() {
            return this.mPages;
        }

        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m7807clone() throws CloneNotSupportedException {
            return clone();
        }

        public WearableExtender(Notification r110) {
            this.mActions = new ArrayList();
            this.mFlags = 1;
            this.mPages = new ArrayList();
            this.mContentIconGravity = 8388613;
            this.mContentActionIndex = -1;
            this.mCustomSizePreset = 0;
            this.mGravity = 80;
            Bundle r111 = NotificationCompat.getExtras(r110);
            if (r111 == null) goto L5;
            Bundle r112 = r111.getBundle(EXTRA_WEARABLE_EXTENSIONS);
        L6:
            if (r112 == null) goto L19;
            ArrayList r100 = r112.getParcelableArrayList("actions");
            if (r100 == null) goto L13;
            int r101 = r100.size();
            Action[] r102 = new Action[r101];
            int r103 = 0;
        L10:
            if (r103 >= r101) goto L12;
            r102[r103] = Api20Impl.getActionCompatFromAction(r100, r103);
            r103 = r103 + 1;
            goto L10
        L12:
            Collections.addAll(this.mActions, r102);
        L13:
            this.mFlags = r112.getInt(KEY_FLAGS, 1);
            this.mDisplayIntent = (PendingIntent) r112.getParcelable(KEY_DISPLAY_INTENT);
            Notification[] r104 = NotificationCompat.getNotificationArrayFromBundle(r112, KEY_PAGES);
            if (r104 == null) goto L16;
            Collections.addAll(this.mPages, r104);
        L16:
            this.mBackground = (Bitmap) r112.getParcelable("background");
            this.mContentIcon = r112.getInt(KEY_CONTENT_ICON);
            this.mContentIconGravity = r112.getInt(KEY_CONTENT_ICON_GRAVITY, 8388613);
            this.mContentActionIndex = r112.getInt(KEY_CONTENT_ACTION_INDEX, -1);
            this.mCustomSizePreset = r112.getInt(KEY_CUSTOM_SIZE_PRESET, 0);
            this.mCustomContentHeight = r112.getInt(KEY_CUSTOM_CONTENT_HEIGHT);
            this.mGravity = r112.getInt("gravity", 80);
            this.mHintScreenTimeout = r112.getInt(KEY_HINT_SCREEN_TIMEOUT);
            this.mDismissalId = r112.getString(KEY_DISMISSAL_ID);
            this.mBridgeTag = r112.getString(KEY_BRIDGE_TAG);
            return;
        L19:
            return;
        L5:
            r112 = null;
            goto L6
        }

        private static Notification.Action getActionFromActionCompat(Action r100) {
            int r101 = Build.VERSION.SDK_INT;
            int r102 = 0;
            if (r101 < 23) goto L9;
            IconCompat r103 = r100.getIconCompat();
            if (r103 != null) goto L7;
            Icon r104 = null;
        L8:
            Notification.Action.Builder r105 = Api23Impl.createBuilder(r104, r100.getTitle(), r100.getActionIntent());
        L17:
            if (r100.getExtras() == null) goto L19;
            Bundle r106 = new Bundle(r100.getExtras());
        L20:
            r106.putBoolean("android.support.allowGeneratedReplies", r100.getAllowGeneratedReplies());
            if (r101 < 24) goto L24;
            Api24Impl.setAllowGeneratedReplies(r105, r100.getAllowGeneratedReplies());
        L24:
            if (r101 < 31) goto L26;
            Api31Impl.setAuthenticationRequired(r105, r100.isAuthenticationRequired());
        L26:
            Api20Impl.addExtras(r105, r106);
            RemoteInput[] r107 = r100.getRemoteInputs();
            if (r107 == null) goto L32;
            android.app.RemoteInput[] r108 = RemoteInput.fromCompat(r107);
            int r109 = r108.length;
        L29:
            if (r102 >= r109) goto L32;
            Api20Impl.addRemoteInput(r105, r108[r102]);
            r102 = r102 + 1;
        L32:
            return Api20Impl.build(r105);
        L19:
            r106 = new Bundle();
            goto L20
        L7:
            r104 = r103.toIcon();
            goto L8
        L9:
            IconCompat r110 = r100.getIconCompat();
            if (r110 != null) goto L12;
        L14:
            int r111 = 0;
        L15:
            r105 = Api20Impl.createBuilder(r111, r100.getTitle(), r100.getActionIntent());
            goto L17
        L12:
            if (r110.getType() != 2) goto L14;
            r111 = r110.getResId();
            goto L15
        }

        public WearableExtender addAction(Action r100) {
            this.mActions.add(r100);
            return this;
        }

        public WearableExtender addActions(List<Action> r100) {
            this.mActions.addAll(r100);
            return this;
        }

        public WearableExtender addPage(Notification r100) {
            this.mPages.add(r100);
            return this;
        }

        public WearableExtender addPages(List<Notification> r100) {
            this.mPages.addAll(r100);
            return this;
        }

        @Override // androidx.core.app.NotificationCompat.Extender
        public Builder extend(Builder r100) {
            Bundle r101 = new Bundle();
            if (this.mActions.isEmpty() == true) goto L9;
            ArrayList<? extends Parcelable> r102 = new ArrayList(this.mActions.size());
            Iterator<Action> r103 = this.mActions.iterator();
        L6:
            if (r103.hasNext() == false) goto L8;
            r102.add(getActionFromActionCompat(r103.next()));
            goto L6
        L8:
            r101.putParcelableArrayList("actions", r102);
        L9:
            int r104 = this.mFlags;
            if (r104 == 1) goto L12;
            r101.putInt(KEY_FLAGS, r104);
        L12:
            PendingIntent r105 = this.mDisplayIntent;
            if (r105 == null) goto L16;
            r101.putParcelable(KEY_DISPLAY_INTENT, r105);
        L16:
            if (this.mPages.isEmpty() == true) goto L18;
            ArrayList<Notification> r106 = this.mPages;
            r101.putParcelableArray(KEY_PAGES, (Parcelable[]) r106.toArray(new Notification[r106.size()]));
        L18:
            Bitmap r107 = this.mBackground;
            if (r107 == null) goto L21;
            r101.putParcelable("background", r107);
        L21:
            int r108 = this.mContentIcon;
            if (r108 == 0) goto L24;
            r101.putInt(KEY_CONTENT_ICON, r108);
        L24:
            int r109 = this.mContentIconGravity;
            if (r109 == 8388613) goto L27;
            r101.putInt(KEY_CONTENT_ICON_GRAVITY, r109);
        L27:
            int r110 = this.mContentActionIndex;
            if (r110 == (-1)) goto L30;
            r101.putInt(KEY_CONTENT_ACTION_INDEX, r110);
        L30:
            int r111 = this.mCustomSizePreset;
            if (r111 == 0) goto L33;
            r101.putInt(KEY_CUSTOM_SIZE_PRESET, r111);
        L33:
            int r112 = this.mCustomContentHeight;
            if (r112 == 0) goto L36;
            r101.putInt(KEY_CUSTOM_CONTENT_HEIGHT, r112);
        L36:
            int r113 = this.mGravity;
            if (r113 == 80) goto L39;
            r101.putInt("gravity", r113);
        L39:
            int r114 = this.mHintScreenTimeout;
            if (r114 == 0) goto L42;
            r101.putInt(KEY_HINT_SCREEN_TIMEOUT, r114);
        L42:
            String r115 = this.mDismissalId;
            if (r115 == null) goto L45;
            r101.putString(KEY_DISMISSAL_ID, r115);
        L45:
            String r116 = this.mBridgeTag;
            if (r116 == null) goto L48;
            r101.putString(KEY_BRIDGE_TAG, r116);
        L48:
            r100.getExtras().putBundle(EXTRA_WEARABLE_EXTENSIONS, r101);
            return r100;
        }

        public WearableExtender setBackground(Bitmap r100) {
            this.mBackground = r100;
            return this;
        }

        public WearableExtender setBridgeTag(String r100) {
            this.mBridgeTag = r100;
            return this;
        }

        public WearableExtender setContentAction(int r100) {
            this.mContentActionIndex = r100;
            return this;
        }

        public WearableExtender setContentIcon(int r100) {
            this.mContentIcon = r100;
            return this;
        }

        public WearableExtender setContentIconGravity(int r100) {
            this.mContentIconGravity = r100;
            return this;
        }

        public WearableExtender setContentIntentAvailableOffline(boolean r100) {
            setFlag(1, r100);
            return this;
        }

        public WearableExtender setCustomContentHeight(int r100) {
            this.mCustomContentHeight = r100;
            return this;
        }

        public WearableExtender setCustomSizePreset(int r100) {
            this.mCustomSizePreset = r100;
            return this;
        }

        public WearableExtender setDismissalId(String r100) {
            this.mDismissalId = r100;
            return this;
        }

        public WearableExtender setDisplayIntent(PendingIntent r100) {
            this.mDisplayIntent = r100;
            return this;
        }

        public WearableExtender setGravity(int r100) {
            this.mGravity = r100;
            return this;
        }

        public WearableExtender setHintAmbientBigPicture(boolean r100) {
            setFlag(32, r100);
            return this;
        }

        public WearableExtender setHintAvoidBackgroundClipping(boolean r100) {
            setFlag(16, r100);
            return this;
        }

        public WearableExtender setHintContentIntentLaunchesActivity(boolean r100) {
            setFlag(64, r100);
            return this;
        }

        public WearableExtender setHintHideIcon(boolean r100) {
            setFlag(2, r100);
            return this;
        }

        public WearableExtender setHintScreenTimeout(int r100) {
            this.mHintScreenTimeout = r100;
            return this;
        }

        public WearableExtender setHintShowBackgroundOnly(boolean r100) {
            setFlag(4, r100);
            return this;
        }

        public WearableExtender setStartScrollBottom(boolean r100) {
            setFlag(8, r100);
            return this;
        }

        private void setFlag(int r100, boolean r101) {
            if (r101 == false) goto L4;
            this.mFlags = r100 | this.mFlags;
            return;
        L4:
            int r102 = this.mFlags;
            this.mFlags = (~r100) & r102;
        }
    }

    public NotificationCompat() {
    }

    public static Action getActionCompatFromAction(Notification.Action r110) {
        android.app.RemoteInput[] r100 = Api20Impl.getRemoteInputs(r110);
        IconCompat r101 = null;
        if (r100 != null) goto L5;
        RemoteInput[] r111 = null;
    L14:
        int r102 = Build.VERSION.SDK_INT;
        if (r102 >= 24) goto L17;
        boolean r103 = Api20Impl.getExtras(r110).getBoolean("android.support.allowGeneratedReplies");
    L24:
        boolean r112 = r103;
        boolean r113 = Api20Impl.getExtras(r110).getBoolean("android.support.action.showsUserInterface", true);
        if (r102 < 28) goto L27;
        int r104 = Api28Impl.getSemanticAction(r110);
    L28:
        int r114 = r104;
        if (r102 < 29) goto L31;
        boolean r115 = Api29Impl.isContextual(r110);
    L33:
        if (r102 < 31) goto L35;
        boolean r116 = Api31Impl.isAuthenticationRequired(r110);
    L37:
        if (r102 < 23) goto L51;
        if (Api23Impl.getIcon(r110) != null) goto L45;
        int r105 = r110.icon;
        if (r105 == 0) goto L45;
        return new Action(r105, r110.title, r110.actionIntent, Api20Impl.getExtras(r110), r111, null, r112, r114, r113, r115, r116);
    L45:
        if (Api23Impl.getIcon(r110) == null) goto L49;
        r101 = IconCompat.createFromIconOrNullIfZeroResId(Api23Impl.getIcon(r110));
    L49:
        return new Action(r101, r110.title, r110.actionIntent, Api20Impl.getExtras(r110), r111, null, r112, r114, r113, r115, r116);
    L51:
        return new Action(r110.icon, r110.title, r110.actionIntent, Api20Impl.getExtras(r110), r111, null, r112, r114, r113, r115, r116);
    L35:
        r116 = false;
        goto L37
    L31:
        r115 = false;
        goto L33
    L27:
        r104 = Api20Impl.getExtras(r110).getInt("android.support.action.semanticAction", 0);
        goto L28
    L17:
        if (Api20Impl.getExtras(r110).getBoolean("android.support.allowGeneratedReplies") == false) goto L19;
    L22:
        r103 = true;
        goto L24
    L19:
        if (Api24Impl.getAllowGeneratedReplies(r110) == true) goto L22;
        r103 = false;
        goto L24
    L5:
        RemoteInput[] r106 = new RemoteInput[r100.length];
        int r107 = 0;
    L7:
        if (r107 >= r100.length) goto L13;
        android.app.RemoteInput r108 = r100[r107];
        String r109 = Api20Impl.getResultKey(r108);
        CharSequence r117 = Api20Impl.getLabel(r108);
        CharSequence[] r118 = Api20Impl.getChoices(r108);
        boolean r119 = Api20Impl.getAllowFreeFormInput(r108);
        if (Build.VERSION.SDK_INT < 29) goto L11;
        int r120 = Api29Impl.getEditChoicesBeforeSending(r108);
    L12:
        r106[r107] = new RemoteInput(r109, r117, r118, r119, r120, Api20Impl.getExtras(r108), null);
        r107 = r107 + 1;
        goto L7
    L11:
        r120 = 0;
        goto L12
    L13:
        r111 = r106;
        goto L14
    }

    public static int getActionCount(Notification r100) {
        Notification.Action[] r101 = r100.actions;
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.length;
    }

    public static boolean getAllowSystemGeneratedContextualActions(Notification r100) {
        if (Build.VERSION.SDK_INT >= 29) goto L5;
        return false;
    L5:
        return Api29Impl.getAllowSystemGeneratedContextualActions(r100);
    }

    public static boolean getAutoCancel(Notification r100) {
        if ((r100.flags & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static int getBadgeIconType(Notification r100) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return 0;
    L5:
        return Api26Impl.getBadgeIconType(r100);
    }

    public static BubbleMetadata getBubbleMetadata(Notification r100) {
        if (Build.VERSION.SDK_INT >= 29) goto L5;
        return null;
    L5:
        return BubbleMetadata.fromPlatform(Api29Impl.getBubbleMetadata(r100));
    }

    public static String getCategory(Notification r100) {
        return r100.category;
    }

    public static String getChannelId(Notification r100) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return null;
    L5:
        return Api26Impl.getChannelId(r100);
    }

    public static int getColor(Notification r100) {
        return r100.color;
    }

    public static CharSequence getContentInfo(Notification r100) {
        return r100.extras.getCharSequence(EXTRA_INFO_TEXT);
    }

    public static CharSequence getContentText(Notification r100) {
        return r100.extras.getCharSequence(EXTRA_TEXT);
    }

    public static CharSequence getContentTitle(Notification r100) {
        return r100.extras.getCharSequence(EXTRA_TITLE);
    }

    @ReplaceWith(expression = "notification.extras")
    public static Bundle getExtras(Notification r100) {
        return r100.extras;
    }

    public static String getGroup(Notification r100) {
        return Api20Impl.getGroup(r100);
    }

    public static int getGroupAlertBehavior(Notification r100) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return 0;
    L5:
        return Api26Impl.getGroupAlertBehavior(r100);
    }

    public static boolean getHighPriority(Notification r100) {
        if ((r100.flags & 128) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static List<Action> getInvisibleActions(Notification r100) {
        ArrayList r101 = new ArrayList();
        Bundle r102 = r100.extras.getBundle("android.car.EXTENSIONS");
        if (r102 != null) goto L5;
        return r101;
    L5:
        Bundle r103 = r102.getBundle("invisible_actions");
        if (r103 == null) goto L11;
        int r104 = 0;
    L9:
        if (r104 >= r103.size()) goto L11;
        r101.add(NotificationCompatJellybean.getActionFromBundle(r103.getBundle(Integer.toString(r104))));
        r104 = r104 + 1;
    L11:
        return r101;
    }

    public static boolean getLocalOnly(Notification r100) {
        if ((r100.flags & 256) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static LocusIdCompat getLocusId(Notification r100) {
        if (Build.VERSION.SDK_INT < 29) goto L9;
        LocusId r101 = Api29Impl.getLocusId(r100);
        if (r101 != null) goto L8;
        return null;
    L8:
        return LocusIdCompat.toLocusIdCompat(r101);
    L9:
        return null;
    }

    public static boolean getOngoing(Notification r100) {
        if ((r100.flags & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean getOnlyAlertOnce(Notification r100) {
        if ((r100.flags & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static List<Person> getPeople(Notification r100) {
        ArrayList r101 = new ArrayList();
        if (Build.VERSION.SDK_INT < 28) goto L12;
        ArrayList r102 = r100.extras.getParcelableArrayList(EXTRA_PEOPLE_LIST);
        if (r102 != null) goto L7;
    L19:
        return r101;
    L7:
        if (r102.isEmpty() == true) goto L19;
        Iterator r103 = r102.iterator();
    L10:
        if (r103.hasNext() == false) goto L19;
        r101.add(Person.fromAndroidPerson((android.app.Person) r103.next()));
        goto L10
    L12:
        String[] r104 = r100.extras.getStringArray(EXTRA_PEOPLE);
        if (r104 == null) goto L19;
        if (r104.length == 0) goto L19;
        int r105 = r104.length;
        int r106 = 0;
    L17:
        if (r106 >= r105) goto L19;
        String r107 = r104[r106];
        r101.add(new Person.Builder().setUri(r107).build());
        r106 = r106 + 1;
        goto L17
    }

    public static Notification getPublicVersion(Notification r100) {
        return r100.publicVersion;
    }

    public static CharSequence getSettingsText(Notification r100) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return null;
    L5:
        return Api26Impl.getSettingsText(r100);
    }

    public static String getShortcutId(Notification r100) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return null;
    L5:
        return Api26Impl.getShortcutId(r100);
    }

    public static boolean getShowWhen(Notification r100) {
        return r100.extras.getBoolean(EXTRA_SHOW_WHEN);
    }

    public static String getSortKey(Notification r100) {
        return Api20Impl.getSortKey(r100);
    }

    public static CharSequence getSubText(Notification r100) {
        return r100.extras.getCharSequence(EXTRA_SUB_TEXT);
    }

    public static long getTimeoutAfter(Notification r100) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return 0;
    L5:
        return Api26Impl.getTimeoutAfter(r100);
    }

    public static boolean getUsesChronometer(Notification r100) {
        return r100.extras.getBoolean(EXTRA_SHOW_CHRONOMETER);
    }

    public static int getVisibility(Notification r100) {
        return r100.visibility;
    }

    public static boolean isGroupSummary(Notification r100) {
        if ((r100.flags & 512) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static Action getAction(Notification r100, int r101) {
        return getActionCompatFromAction(r100.actions[r101]);
    }

    public static Notification[] getNotificationArrayFromBundle(Bundle r100, String r101) {
        Parcelable[] r102 = r100.getParcelableArray(r101);
        if ((r102 instanceof Notification[]) == true) goto L13;
        if (r102 == null) goto L13;
        Notification[] r103 = new Notification[r102.length];
        int r104 = 0;
    L8:
        if (r104 >= r102.length) goto L10;
        r103[r104] = (Notification) r102[r104];
        r104 = r104 + 1;
        goto L8
    L10:
        r100.putParcelableArray(r101, r103);
        return r103;
    L13:
        return (Notification[]) r102;
    }

    public static Bitmap reduceLargeIconSize(Context r100, Bitmap r101) {
        if (r101 != null) goto L4;
    L13:
        return r101;
    L4:
        if (Build.VERSION.SDK_INT >= 27) goto L13;
        Resources r102 = r100.getResources();
        int r103 = r102.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_width);
        int r104 = r102.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_height);
        if (r101.getWidth() <= r103) goto L9;
    L11:
        double r105 = Math.min(((double) r103) / ((double) Math.max(1, r101.getWidth())), ((double) r104) / ((double) Math.max(1, r101.getHeight())));
        return Bitmap.createScaledBitmap(r101, (int) Math.ceil(((double) r101.getWidth()) * r105), (int) Math.ceil(((double) r101.getHeight()) * r105), true);
    L9:
        if (r101.getHeight() > r104) goto L11;
        return r101;
    }
}
