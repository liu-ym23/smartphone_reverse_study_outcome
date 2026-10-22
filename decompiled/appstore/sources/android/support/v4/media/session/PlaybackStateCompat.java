package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class PlaybackStateCompat implements Parcelable {
    public static final long ACTION_FAST_FORWARD = 64;
    public static final long ACTION_PAUSE = 2;
    public static final long ACTION_PLAY = 4;
    public static final long ACTION_PLAY_FROM_MEDIA_ID = 1024;
    public static final long ACTION_PLAY_FROM_SEARCH = 2048;
    public static final long ACTION_PLAY_FROM_URI = 8192;
    public static final long ACTION_PLAY_PAUSE = 512;
    public static final long ACTION_PREPARE = 16384;
    public static final long ACTION_PREPARE_FROM_MEDIA_ID = 32768;
    public static final long ACTION_PREPARE_FROM_SEARCH = 65536;
    public static final long ACTION_PREPARE_FROM_URI = 131072;
    public static final long ACTION_REWIND = 8;
    public static final long ACTION_SEEK_TO = 256;
    public static final long ACTION_SET_CAPTIONING_ENABLED = 1048576;
    public static final long ACTION_SET_RATING = 128;
    public static final long ACTION_SET_REPEAT_MODE = 262144;
    public static final long ACTION_SET_SHUFFLE_MODE = 2097152;

    @Deprecated
    public static final long ACTION_SET_SHUFFLE_MODE_ENABLED = 524288;
    public static final long ACTION_SKIP_TO_NEXT = 32;
    public static final long ACTION_SKIP_TO_PREVIOUS = 16;
    public static final long ACTION_SKIP_TO_QUEUE_ITEM = 4096;
    public static final long ACTION_STOP = 1;
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = null;
    public static final int ERROR_CODE_ACTION_ABORTED = 10;
    public static final int ERROR_CODE_APP_ERROR = 1;
    public static final int ERROR_CODE_AUTHENTICATION_EXPIRED = 3;
    public static final int ERROR_CODE_CONCURRENT_STREAM_LIMIT = 5;
    public static final int ERROR_CODE_CONTENT_ALREADY_PLAYING = 8;
    public static final int ERROR_CODE_END_OF_QUEUE = 11;
    public static final int ERROR_CODE_NOT_AVAILABLE_IN_REGION = 7;
    public static final int ERROR_CODE_NOT_SUPPORTED = 2;
    public static final int ERROR_CODE_PARENTAL_CONTROL_RESTRICTED = 6;
    public static final int ERROR_CODE_PREMIUM_ACCOUNT_REQUIRED = 4;
    public static final int ERROR_CODE_SKIP_LIMIT_REACHED = 9;
    public static final int ERROR_CODE_UNKNOWN_ERROR = 0;
    private static final int KEYCODE_MEDIA_PAUSE = 127;
    private static final int KEYCODE_MEDIA_PLAY = 126;
    public static final long PLAYBACK_POSITION_UNKNOWN = -1;
    public static final int REPEAT_MODE_ALL = 2;
    public static final int REPEAT_MODE_GROUP = 3;
    public static final int REPEAT_MODE_INVALID = -1;
    public static final int REPEAT_MODE_NONE = 0;
    public static final int REPEAT_MODE_ONE = 1;
    public static final int SHUFFLE_MODE_ALL = 1;
    public static final int SHUFFLE_MODE_GROUP = 2;
    public static final int SHUFFLE_MODE_INVALID = -1;
    public static final int SHUFFLE_MODE_NONE = 0;
    public static final int STATE_BUFFERING = 6;
    public static final int STATE_CONNECTING = 8;
    public static final int STATE_ERROR = 7;
    public static final int STATE_FAST_FORWARDING = 4;
    public static final int STATE_NONE = 0;
    public static final int STATE_PAUSED = 2;
    public static final int STATE_PLAYING = 3;
    public static final int STATE_REWINDING = 5;
    public static final int STATE_SKIPPING_TO_NEXT = 10;
    public static final int STATE_SKIPPING_TO_PREVIOUS = 9;
    public static final int STATE_SKIPPING_TO_QUEUE_ITEM = 11;
    public static final int STATE_STOPPED = 1;
    final long mActions;
    final long mActiveItemId;
    final long mBufferedPosition;
    List<CustomAction> mCustomActions;
    final int mErrorCode;
    final CharSequence mErrorMessage;
    final Bundle mExtras;
    final long mPosition;
    final float mSpeed;
    final int mState;
    private Object mStateObj;
    final long mUpdateTime;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface Actions {
    }

    public static final class Builder {
        private long mActions;
        private long mActiveItemId;
        private long mBufferedPosition;
        private final List<CustomAction> mCustomActions;
        private int mErrorCode;
        private CharSequence mErrorMessage;
        private Bundle mExtras;
        private long mPosition;
        private float mRate;
        private int mState;
        private long mUpdateTime;

        public Builder() {
            this.mCustomActions = new ArrayList();
            this.mActiveItemId = -1;
        }

        public Builder addCustomAction(String r10, String r11, int r12) {
            return addCustomAction(new CustomAction(r10, r11, r12, null));
        }

        public PlaybackStateCompat build() {
            return new PlaybackStateCompat(this.mState, this.mPosition, this.mBufferedPosition, this.mRate, this.mActions, this.mErrorCode, this.mErrorMessage, this.mUpdateTime, this.mCustomActions, this.mActiveItemId, this.mExtras);
        }

        public Builder setActions(long r10) {
            this.mActions = r10;
            return this;
        }

        public Builder setActiveQueueItemId(long r10) {
            this.mActiveItemId = r10;
            return this;
        }

        public Builder setBufferedPosition(long r10) {
            this.mBufferedPosition = r10;
            return this;
        }

        public Builder setErrorMessage(CharSequence r10) {
            this.mErrorMessage = r10;
            return this;
        }

        public Builder setExtras(Bundle r10) {
            this.mExtras = r10;
            return this;
        }

        public Builder setState(int r10, long r11, float r12) {
            return setState(r10, r11, r12, SystemClock.elapsedRealtime());
        }

        public Builder addCustomAction(CustomAction r10) {
            if (r10 == null) goto L6;
            this.mCustomActions.add(r10);
            return this;
        L6:
            throw new IllegalArgumentException("You may not add a null CustomAction to PlaybackStateCompat.");
        }

        public Builder setErrorMessage(int r10, CharSequence r11) {
            this.mErrorCode = r10;
            this.mErrorMessage = r11;
            return this;
        }

        public Builder setState(int r10, long r11, float r12, long r13) {
            this.mState = r10;
            this.mPosition = r11;
            this.mUpdateTime = r13;
            this.mRate = r12;
            return this;
        }

        public Builder(PlaybackStateCompat r10) {
            ArrayList r11 = new ArrayList();
            this.mCustomActions = r11;
            this.mActiveItemId = -1;
            this.mState = r10.mState;
            this.mPosition = r10.mPosition;
            this.mRate = r10.mSpeed;
            this.mUpdateTime = r10.mUpdateTime;
            this.mBufferedPosition = r10.mBufferedPosition;
            this.mActions = r10.mActions;
            this.mErrorCode = r10.mErrorCode;
            this.mErrorMessage = r10.mErrorMessage;
            List<CustomAction> r12 = r10.mCustomActions;
            if (r12 == null) goto L5;
            r11.addAll(r12);
        L5:
            this.mActiveItemId = r10.mActiveItemId;
            this.mExtras = r10.mExtras;
        }
    }

    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = null;
        private final String mAction;
        private Object mCustomActionObj;
        private final Bundle mExtras;
        private final int mIcon;
        private final CharSequence mName;

        public static final class Builder {
            private final String mAction;
            private Bundle mExtras;
            private final int mIcon;
            private final CharSequence mName;

            public Builder(String r10, CharSequence r11, int r12) {
                if (TextUtils.isEmpty(r10) == true) goto L14;
                if (TextUtils.isEmpty(r11) == true) goto L12;
                if (r12 == 0) goto L10;
                this.mAction = r10;
                this.mName = r11;
                this.mIcon = r12;
                return;
            L10:
                throw new IllegalArgumentException("You must specify an icon resource id to build a CustomAction.");
            L12:
                throw new IllegalArgumentException("You must specify a name to build a CustomAction.");
            L14:
                throw new IllegalArgumentException("You must specify an action to build a CustomAction.");
            }

            public CustomAction build() {
                return new CustomAction(this.mAction, this.mName, this.mIcon, this.mExtras);
            }

            public Builder setExtras(Bundle r10) {
                this.mExtras = r10;
                return this;
            }
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        public CustomAction(String r10, CharSequence r11, int r12, Bundle r13) {
            this.mAction = r10;
            this.mName = r11;
            this.mIcon = r12;
            this.mExtras = r13;
        }

        public static CustomAction fromCustomAction(Object r10) {
            if (r10 == null) goto L5;
            CustomAction r11 = new CustomAction(PlaybackStateCompatApi21.CustomAction.getAction(r10), PlaybackStateCompatApi21.CustomAction.getName(r10), PlaybackStateCompatApi21.CustomAction.getIcon(r10), PlaybackStateCompatApi21.CustomAction.getExtras(r10));
            r11.mCustomActionObj = r10;
            return r11;
        L5:
            return null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getAction() {
            return this.mAction;
        }

        public Object getCustomAction() {
            Object r10 = this.mCustomActionObj;
            if (r10 != null) goto L6;
            Object r11 = PlaybackStateCompatApi21.CustomAction.newInstance(this.mAction, this.mName, this.mIcon, this.mExtras);
            this.mCustomActionObj = r11;
            return r11;
        L6:
            return r10;
        }

        public Bundle getExtras() {
            return this.mExtras;
        }

        public int getIcon() {
            return this.mIcon;
        }

        public CharSequence getName() {
            return this.mName;
        }

        public String toString() {
            return "Action:mName='" + this.mName + ", mIcon=" + this.mIcon + ", mExtras=" + this.mExtras;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r10, int r11) {
            r10.writeString(this.mAction);
            TextUtils.writeToParcel(this.mName, r10, r11);
            r10.writeInt(this.mIcon);
            r10.writeBundle(this.mExtras);
        }

        public CustomAction(Parcel r10) {
            this.mAction = r10.readString();
            this.mName = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r10);
            this.mIcon = r10.readInt();
            this.mExtras = r10.readBundle(MediaSessionCompat.class.getClassLoader());
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface ErrorCode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface MediaKeyAction {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface RepeatMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface ShuffleMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface State {
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public PlaybackStateCompat(int r10, long r11, long r12, float r13, long r14, int r15, CharSequence r16, long r17, List<CustomAction> r18, long r19, Bundle r110) {
        this.mState = r10;
        this.mPosition = r11;
        this.mBufferedPosition = r12;
        this.mSpeed = r13;
        this.mActions = r14;
        this.mErrorCode = r15;
        this.mErrorMessage = r16;
        this.mUpdateTime = r17;
        this.mCustomActions = new ArrayList(r18);
        this.mActiveItemId = r19;
        this.mExtras = r110;
    }

    public static PlaybackStateCompat fromPlaybackState(Object r21) {
        ArrayList r10 = null;
        if (r21 == null) goto L13;
        List<Object> r11 = PlaybackStateCompatApi21.getCustomActions(r21);
        if (r11 == null) goto L10;
        r10 = new ArrayList(r11.size());
        Iterator<Object> r12 = r11.iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        r10.add(CustomAction.fromCustomAction(r12.next()));
    L10:
        Bundle r20 = PlaybackStateCompatApi22.getExtras(r21);
        int r13 = PlaybackStateCompatApi21.getState(r21);
        long r14 = PlaybackStateCompatApi21.getPosition(r21);
        long r15 = PlaybackStateCompatApi21.getBufferedPosition(r21);
        float r16 = PlaybackStateCompatApi21.getPlaybackSpeed(r21);
        long r17 = PlaybackStateCompatApi21.getActions(r21);
        CharSequence r18 = PlaybackStateCompatApi21.getErrorMessage(r21);
        long r19 = PlaybackStateCompatApi21.getLastPositionUpdateTime(r21);
        PlaybackStateCompat r22 = new PlaybackStateCompat(r13, r14, r15, r16, r17, 0, r18, r19, r10, PlaybackStateCompatApi21.getActiveQueueItemId(r21), r20);
        r22.mStateObj = r21;
        return r22;
    L13:
        return null;
    }

    public static int toKeyCode(long r10) {
        if (r10 != 4) goto L7;
        return 126;
    L7:
        if (r10 != 2) goto L11;
        return KEYCODE_MEDIA_PAUSE;
    L11:
        if (r10 != 32) goto L15;
        return 87;
    L15:
        if (r10 != 16) goto L19;
        return 88;
    L19:
        if (r10 != 1) goto L23;
        return 86;
    L23:
        if (r10 != 64) goto L27;
        return 90;
    L27:
        if (r10 != 8) goto L31;
        return 89;
    L31:
        if (r10 != 512) goto L34;
        return 85;
    L34:
        return 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getActions() {
        return this.mActions;
    }

    public long getActiveQueueItemId() {
        return this.mActiveItemId;
    }

    public long getBufferedPosition() {
        return this.mBufferedPosition;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public long getCurrentPosition(Long r10) {
        long r11 = this.mPosition;
        float r12 = this.mSpeed;
        if (r10 == null) goto L5;
        long r13 = r10.longValue();
    L7:
        return Math.max(0, r11 + ((long) (r12 * r13)));
    L5:
        r13 = SystemClock.elapsedRealtime() - this.mUpdateTime;
        goto L7
    }

    public List<CustomAction> getCustomActions() {
        return this.mCustomActions;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public CharSequence getErrorMessage() {
        return this.mErrorMessage;
    }

    @Nullable
    public Bundle getExtras() {
        return this.mExtras;
    }

    public long getLastPositionUpdateTime() {
        return this.mUpdateTime;
    }

    public float getPlaybackSpeed() {
        return this.mSpeed;
    }

    public Object getPlaybackState() {
        if (this.mStateObj != null) goto L14;
        if (this.mCustomActions == null) goto L11;
        ArrayList r10 = new ArrayList(this.mCustomActions.size());
        Iterator<CustomAction> r11 = this.mCustomActions.iterator();
    L8:
        if (r11.hasNext() == false) goto L10;
        r10.add(r11.next().getCustomAction());
    L10:
        ArrayList r13 = r10;
        this.mStateObj = PlaybackStateCompatApi22.newInstance(this.mState, this.mPosition, this.mBufferedPosition, this.mSpeed, this.mActions, this.mErrorMessage, this.mUpdateTime, r13, this.mActiveItemId, this.mExtras);
        goto L14
    L11:
        r10 = null;
    L14:
        return this.mStateObj;
    }

    public long getPosition() {
        return this.mPosition;
    }

    public int getState() {
        return this.mState;
    }

    public String toString() {
        return "PlaybackState {state=" + this.mState + ", position=" + this.mPosition + ", buffered position=" + this.mBufferedPosition + ", speed=" + this.mSpeed + ", updated=" + this.mUpdateTime + ", actions=" + this.mActions + ", error code=" + this.mErrorCode + ", error message=" + this.mErrorMessage + ", custom actions=" + this.mCustomActions + ", active item id=" + this.mActiveItemId + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        r10.writeInt(this.mState);
        r10.writeLong(this.mPosition);
        r10.writeFloat(this.mSpeed);
        r10.writeLong(this.mUpdateTime);
        r10.writeLong(this.mBufferedPosition);
        r10.writeLong(this.mActions);
        TextUtils.writeToParcel(this.mErrorMessage, r10, r11);
        r10.writeTypedList(this.mCustomActions);
        r10.writeLong(this.mActiveItemId);
        r10.writeBundle(this.mExtras);
        r10.writeInt(this.mErrorCode);
    }

    public PlaybackStateCompat(Parcel r10) {
        this.mState = r10.readInt();
        this.mPosition = r10.readLong();
        this.mSpeed = r10.readFloat();
        this.mUpdateTime = r10.readLong();
        this.mBufferedPosition = r10.readLong();
        this.mActions = r10.readLong();
        this.mErrorMessage = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r10);
        this.mCustomActions = r10.createTypedArrayList(CustomAction.CREATOR);
        this.mActiveItemId = r10.readLong();
        this.mExtras = r10.readBundle(MediaSessionCompat.class.getClassLoader());
        this.mErrorCode = r10.readInt();
    }
}
