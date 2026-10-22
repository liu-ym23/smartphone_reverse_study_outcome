package android.support.v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alipay.sdk.m.u.i;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
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

        public PlaybackStateCompat build() {
            return new PlaybackStateCompat(this.mState, this.mPosition, this.mBufferedPosition, this.mRate, this.mActions, this.mErrorCode, this.mErrorMessage, this.mUpdateTime, this.mCustomActions, this.mActiveItemId, this.mExtras);
        }

        public Builder() {
            this.mCustomActions = new ArrayList();
            this.mActiveItemId = -1;
        }

        public Builder(PlaybackStateCompat r100) {
            ArrayList r101 = new ArrayList();
            this.mCustomActions = r101;
            this.mActiveItemId = -1;
            this.mState = r100.mState;
            this.mPosition = r100.mPosition;
            this.mRate = r100.mSpeed;
            this.mUpdateTime = r100.mUpdateTime;
            this.mBufferedPosition = r100.mBufferedPosition;
            this.mActions = r100.mActions;
            this.mErrorCode = r100.mErrorCode;
            this.mErrorMessage = r100.mErrorMessage;
            List<CustomAction> r102 = r100.mCustomActions;
            if (r102 == null) goto L5;
            r101.addAll(r102);
        L5:
            this.mActiveItemId = r100.mActiveItemId;
            this.mExtras = r100.mExtras;
        }

        public Builder addCustomAction(CustomAction r100) {
            if (r100 == null) goto L6;
            this.mCustomActions.add(r100);
            return this;
        L6:
            throw new IllegalArgumentException("You may not add a null CustomAction to PlaybackStateCompat.");
        }

        public Builder setActions(long r100) {
            this.mActions = r100;
            return this;
        }

        public Builder setActiveQueueItemId(long r100) {
            this.mActiveItemId = r100;
            return this;
        }

        public Builder setBufferedPosition(long r100) {
            this.mBufferedPosition = r100;
            return this;
        }

        public Builder setErrorMessage(CharSequence r100) {
            this.mErrorMessage = r100;
            return this;
        }

        public Builder setExtras(Bundle r100) {
            this.mExtras = r100;
            return this;
        }

        public Builder setErrorMessage(int r100, CharSequence r101) {
            this.mErrorCode = r100;
            this.mErrorMessage = r101;
            return this;
        }

        public Builder addCustomAction(String r100, String r101, int r102) {
            return addCustomAction(new CustomAction(r100, r101, r102, null));
        }

        public Builder setState(int r100, long r101, float r110) {
            return setState(r100, r101, r110, SystemClock.elapsedRealtime());
        }

        public Builder setState(int r100, long r101, float r102, long r103) {
            this.mState = r100;
            this.mPosition = r101;
            this.mUpdateTime = r103;
            this.mRate = r102;
            return this;
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

            public CustomAction build() {
                return new CustomAction(this.mAction, this.mName, this.mIcon, this.mExtras);
            }

            public Builder setExtras(Bundle r100) {
                this.mExtras = r100;
                return this;
            }

            public Builder(String r100, CharSequence r101, int r102) {
                if (TextUtils.isEmpty(r100) == true) goto L14;
                if (TextUtils.isEmpty(r101) == true) goto L12;
                if (r102 == 0) goto L10;
                this.mAction = r100;
                this.mName = r101;
                this.mIcon = r102;
                return;
            L10:
                throw new IllegalArgumentException("You must specify an icon resource id to build a CustomAction.");
            L12:
                throw new IllegalArgumentException("You must specify a name to build a CustomAction.");
            L14:
                throw new IllegalArgumentException("You must specify an action to build a CustomAction.");
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        public Object getCustomAction() {
            Object r100 = this.mCustomActionObj;
            if (r100 != null) goto L6;
            Object r101 = PlaybackStateCompatApi21.CustomAction.newInstance(this.mAction, this.mName, this.mIcon, this.mExtras);
            this.mCustomActionObj = r101;
            return r101;
        L6:
            return r100;
        }

        public String toString() {
            return "Action:mName='" + this.mName + ", mIcon=" + this.mIcon + ", mExtras=" + this.mExtras;
        }

        public String getAction() {
            return this.mAction;
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

        public CustomAction(Parcel r100) {
            this.mAction = r100.readString();
            this.mName = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r100);
            this.mIcon = r100.readInt();
            this.mExtras = r100.readBundle(MediaSessionCompat.class.getClassLoader());
        }

        public static CustomAction fromCustomAction(Object r100) {
            if (r100 == null) goto L5;
            CustomAction r101 = new CustomAction(PlaybackStateCompatApi21.CustomAction.getAction(r100), PlaybackStateCompatApi21.CustomAction.getName(r100), PlaybackStateCompatApi21.CustomAction.getIcon(r100), PlaybackStateCompatApi21.CustomAction.getExtras(r100));
            r101.mCustomActionObj = r100;
            return r101;
        L5:
            return null;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            r100.writeString(this.mAction);
            TextUtils.writeToParcel(this.mName, r100, r101);
            r100.writeInt(this.mIcon);
            r100.writeBundle(this.mExtras);
        }

        public CustomAction(String r100, CharSequence r101, int r102, Bundle r103) {
            this.mAction = r100;
            this.mName = r101;
            this.mIcon = r102;
            this.mExtras = r103;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ErrorCode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MediaKeyAction {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RepeatMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ShuffleMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    public static int toKeyCode(long r100) {
        if (r100 != 4) goto L7;
        return 126;
    L7:
        if (r100 != 2) goto L11;
        return 127;
    L11:
        if (r100 != 32) goto L15;
        return 87;
    L15:
        if (r100 != 16) goto L19;
        return 88;
    L19:
        if (r100 != 1) goto L23;
        return 86;
    L23:
        if (r100 != 64) goto L27;
        return 90;
    L27:
        if (r100 != 8) goto L31;
        return 89;
    L31:
        if (r100 != 512) goto L34;
        return 85;
    L34:
        return 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public Object getPlaybackState() {
        if (this.mStateObj != null) goto L16;
        if (this.mCustomActions == null) goto L10;
        ArrayList r100 = new ArrayList(this.mCustomActions.size());
        Iterator<CustomAction> r101 = this.mCustomActions.iterator();
    L8:
        if (r101.hasNext() == false) goto L11;
        r100.add(r101.next().getCustomAction());
    L11:
        ArrayList r110 = r100;
        if (Build.VERSION.SDK_INT < 22) goto L14;
        this.mStateObj = PlaybackStateCompatApi22.newInstance(this.mState, this.mPosition, this.mBufferedPosition, this.mSpeed, this.mActions, this.mErrorMessage, this.mUpdateTime, r110, this.mActiveItemId, this.mExtras);
        goto L16
    L14:
        this.mStateObj = PlaybackStateCompatApi21.newInstance(this.mState, this.mPosition, this.mBufferedPosition, this.mSpeed, this.mActions, this.mErrorMessage, this.mUpdateTime, r110, this.mActiveItemId);
        goto L16
    L10:
        r100 = null;
    L16:
        return this.mStateObj;
    }

    public String toString() {
        return "PlaybackState {state=" + this.mState + ", position=" + this.mPosition + ", buffered position=" + this.mBufferedPosition + ", speed=" + this.mSpeed + ", updated=" + this.mUpdateTime + ", actions=" + this.mActions + ", error code=" + this.mErrorCode + ", error message=" + this.mErrorMessage + ", custom actions=" + this.mCustomActions + ", active item id=" + this.mActiveItemId + i.f25855d;
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

    public List<CustomAction> getCustomActions() {
        return this.mCustomActions;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public CharSequence getErrorMessage() {
        return this.mErrorMessage;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public long getLastPositionUpdateTime() {
        return this.mUpdateTime;
    }

    public float getPlaybackSpeed() {
        return this.mSpeed;
    }

    public long getPosition() {
        return this.mPosition;
    }

    public int getState() {
        return this.mState;
    }

    public PlaybackStateCompat(Parcel r100) {
        this.mState = r100.readInt();
        this.mPosition = r100.readLong();
        this.mSpeed = r100.readFloat();
        this.mUpdateTime = r100.readLong();
        this.mBufferedPosition = r100.readLong();
        this.mActions = r100.readLong();
        this.mErrorMessage = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r100);
        this.mCustomActions = r100.createTypedArrayList(CustomAction.CREATOR);
        this.mActiveItemId = r100.readLong();
        this.mExtras = r100.readBundle(MediaSessionCompat.class.getClassLoader());
        this.mErrorCode = r100.readInt();
    }

    public static PlaybackStateCompat fromPlaybackState(Object r210) {
        Bundle r100 = null;
        if (r210 == null) goto L18;
        List<Object> r101 = PlaybackStateCompatApi21.getCustomActions(r210);
        if (r101 == null) goto L11;
        ArrayList r102 = new ArrayList(r101.size());
        Iterator<Object> r103 = r101.iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        r102.add(CustomAction.fromCustomAction(r103.next()));
        goto L8
    L10:
        ArrayList r110 = r102;
    L13:
        if (Build.VERSION.SDK_INT < 22) goto L15;
        r100 = PlaybackStateCompatApi22.getExtras(r210);
    L15:
        PlaybackStateCompat r104 = new PlaybackStateCompat(PlaybackStateCompatApi21.getState(r210), PlaybackStateCompatApi21.getPosition(r210), PlaybackStateCompatApi21.getBufferedPosition(r210), PlaybackStateCompatApi21.getPlaybackSpeed(r210), PlaybackStateCompatApi21.getActions(r210), 0, PlaybackStateCompatApi21.getErrorMessage(r210), PlaybackStateCompatApi21.getLastPositionUpdateTime(r210), r110, PlaybackStateCompatApi21.getActiveQueueItemId(r210), r100);
        r104.mStateObj = r210;
        return r104;
    L11:
        r110 = null;
        goto L13
    L18:
        return null;
    }

    public long getCurrentPosition(Long r100) {
        long r101 = this.mPosition;
        float r102 = this.mSpeed;
        if (r100 == null) goto L5;
        long r103 = r100.longValue();
    L7:
        return Math.max(0, r101 + ((long) (r102 * r103)));
    L5:
        r103 = SystemClock.elapsedRealtime() - this.mUpdateTime;
        goto L7
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.mState);
        r100.writeLong(this.mPosition);
        r100.writeFloat(this.mSpeed);
        r100.writeLong(this.mUpdateTime);
        r100.writeLong(this.mBufferedPosition);
        r100.writeLong(this.mActions);
        TextUtils.writeToParcel(this.mErrorMessage, r100, r101);
        r100.writeTypedList(this.mCustomActions);
        r100.writeLong(this.mActiveItemId);
        r100.writeBundle(this.mExtras);
        r100.writeInt(this.mErrorCode);
    }

    public PlaybackStateCompat(int r100, long r101, long r102, float r103, long r110, int r111, CharSequence r112, long r113, List<CustomAction> r114, long r115, Bundle r116) {
        this.mState = r100;
        this.mPosition = r101;
        this.mBufferedPosition = r102;
        this.mSpeed = r103;
        this.mActions = r110;
        this.mErrorCode = r111;
        this.mErrorMessage = r112;
        this.mUpdateTime = r113;
        this.mCustomActions = new ArrayList(r114);
        this.mActiveItemId = r115;
        this.mExtras = r116;
    }
}
