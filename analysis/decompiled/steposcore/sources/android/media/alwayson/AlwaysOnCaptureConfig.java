package android.media.alwayson;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class AlwaysOnCaptureConfig implements Parcelable {
    public static final Parcelable.Creator<AlwaysOnCaptureConfig> CREATOR = new Parcelable.Creator<AlwaysOnCaptureConfig>() { // from class: android.media.alwayson.AlwaysOnCaptureConfig.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AlwaysOnCaptureConfig createFromParcel(Parcel in) {
            return new AlwaysOnCaptureConfig(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AlwaysOnCaptureConfig[] newArray(int size) {
            return new AlwaysOnCaptureConfig[size];
        }
    };
    public final int bufferSizeInBytes;
    public final IBinder callerToken;
    public final int captureTrigger;
    public final int channelMask;
    public final int encoding;
    public final String extensionString;
    public final String manualCallerPackage;
    public final String manualCallerTag;
    public final int preRollSeconds;
    public final int sampleRate;
    public final String sceneSubTag;
    public final String sceneTag;
    public final int sessionId;
    public final boolean stopOnCallerExit;
    public final int userId;

    private AlwaysOnCaptureConfig(Builder builder) {
        this.captureTrigger = builder.mCaptureTrigger;
        this.sessionId = builder.mSessionId;
        this.sceneTag = builder.mSceneTag;
        this.sceneSubTag = builder.mSceneSubTag;
        this.extensionString = builder.mExtensionString;
        this.manualCallerPackage = builder.mManualCallerPackage;
        this.manualCallerTag = builder.mManualCallerTag;
        this.stopOnCallerExit = builder.mStopOnCallerExit;
        this.callerToken = builder.mCallerToken;
        this.userId = builder.mUserId;
        this.sampleRate = builder.mSampleRate;
        this.channelMask = builder.mChannelMask;
        this.encoding = builder.mEncoding;
        this.bufferSizeInBytes = builder.mBufferSizeInBytes;
        this.preRollSeconds = builder.mPreRollSeconds;
    }

    private AlwaysOnCaptureConfig(Parcel in) {
        this.captureTrigger = in.readInt();
        this.sessionId = in.readInt();
        this.sceneTag = in.readString();
        this.sceneSubTag = in.readString();
        this.extensionString = in.readString();
        this.manualCallerPackage = in.readString();
        this.manualCallerTag = in.readString();
        this.stopOnCallerExit = in.readBoolean();
        this.callerToken = in.readStrongBinder();
        this.userId = in.readInt();
        this.sampleRate = in.readInt();
        this.channelMask = in.readInt();
        this.encoding = in.readInt();
        this.bufferSizeInBytes = in.readInt();
        this.preRollSeconds = in.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.captureTrigger);
        dest.writeInt(this.sessionId);
        dest.writeString(this.sceneTag);
        dest.writeString(this.sceneSubTag);
        dest.writeString(this.extensionString);
        dest.writeString(this.manualCallerPackage);
        dest.writeString(this.manualCallerTag);
        dest.writeBoolean(this.stopOnCallerExit);
        dest.writeStrongBinder(this.callerToken);
        dest.writeInt(this.userId);
        dest.writeInt(this.sampleRate);
        dest.writeInt(this.channelMask);
        dest.writeInt(this.encoding);
        dest.writeInt(this.bufferSizeInBytes);
        dest.writeInt(this.preRollSeconds);
    }

    public static final class Builder {
        private int mBufferSizeInBytes;
        private IBinder mCallerToken;
        private String mExtensionString;
        private String mManualCallerPackage;
        private String mManualCallerTag;
        private int mPreRollSeconds;
        private String mSceneSubTag;
        private String mSceneTag;
        private int mSessionId;
        private int mUserId;
        private int mCaptureTrigger = 1;
        private boolean mStopOnCallerExit = true;
        private int mSampleRate = 16000;
        private int mChannelMask = 16;
        private int mEncoding = 2;

        public Builder setCaptureTrigger(int captureTrigger) {
            this.mCaptureTrigger = captureTrigger;
            return this;
        }

        public Builder setSessionId(int sessionId) {
            this.mSessionId = sessionId;
            return this;
        }

        public Builder setSceneTag(String sceneTag) {
            this.mSceneTag = sceneTag;
            return this;
        }

        public Builder setSceneSubTag(String sceneSubTag) {
            this.mSceneSubTag = sceneSubTag;
            return this;
        }

        public Builder setExtensionString(String extensionString) {
            this.mExtensionString = extensionString;
            return this;
        }

        public Builder setManualCallerPackage(String manualCallerPackage) {
            this.mManualCallerPackage = manualCallerPackage;
            return this;
        }

        public Builder setManualCallerTag(String manualCallerTag) {
            this.mManualCallerTag = manualCallerTag;
            return this;
        }

        public Builder setStopOnCallerExit(boolean stopOnCallerExit) {
            this.mStopOnCallerExit = stopOnCallerExit;
            return this;
        }

        public Builder setCallerToken(IBinder callerToken) {
            this.mCallerToken = callerToken;
            return this;
        }

        public Builder setUserId(int userId) {
            this.mUserId = userId;
            return this;
        }

        public Builder setSampleRate(int sampleRate) {
            this.mSampleRate = sampleRate;
            return this;
        }

        public Builder setChannelMask(int channelMask) {
            this.mChannelMask = channelMask;
            return this;
        }

        public Builder setEncoding(int encoding) {
            this.mEncoding = encoding;
            return this;
        }

        public Builder setBufferSizeInBytes(int bufferSizeInBytes) {
            this.mBufferSizeInBytes = bufferSizeInBytes;
            return this;
        }

        public Builder setPreRollSeconds(int preRollSeconds) {
            this.mPreRollSeconds = preRollSeconds;
            return this;
        }

        public AlwaysOnCaptureConfig build() {
            return new AlwaysOnCaptureConfig(this);
        }
    }
}
