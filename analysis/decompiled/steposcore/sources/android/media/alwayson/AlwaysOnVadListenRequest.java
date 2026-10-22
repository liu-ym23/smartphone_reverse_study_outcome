package android.media.alwayson;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* loaded from: classes.dex */
public final class AlwaysOnVadListenRequest implements Parcelable {
    public static final Parcelable.Creator<AlwaysOnVadListenRequest> CREATOR = new Parcelable.Creator<AlwaysOnVadListenRequest>() { // from class: android.media.alwayson.AlwaysOnVadListenRequest.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AlwaysOnVadListenRequest createFromParcel(Parcel in) {
            return new AlwaysOnVadListenRequest(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AlwaysOnVadListenRequest[] newArray(int size) {
            return new AlwaysOnVadListenRequest[size];
        }
    };
    public final String callerTag;
    public final IBinder callerToken;
    public final AlwaysOnCaptureConfig config;
    public final boolean stopOnCallerExit;

    private AlwaysOnVadListenRequest(Builder builder) {
        this.callerTag = (String) Objects.requireNonNull(builder.mCallerTag, "callerTag");
        this.config = (AlwaysOnCaptureConfig) Objects.requireNonNull(builder.mConfig, "config");
        this.stopOnCallerExit = builder.mStopOnCallerExit;
        this.callerToken = builder.mCallerToken;
    }

    private AlwaysOnVadListenRequest(Parcel in) {
        this.callerTag = (String) Objects.requireNonNull(in.readString());
        this.config = (AlwaysOnCaptureConfig) Objects.requireNonNull((AlwaysOnCaptureConfig) in.readTypedObject(AlwaysOnCaptureConfig.CREATOR));
        this.stopOnCallerExit = in.readBoolean();
        this.callerToken = in.readStrongBinder();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.callerTag);
        dest.writeTypedObject(this.config, flags);
        dest.writeBoolean(this.stopOnCallerExit);
        dest.writeStrongBinder(this.callerToken);
    }

    public static final class Builder {
        private String mCallerTag;
        private IBinder mCallerToken;
        private AlwaysOnCaptureConfig mConfig;
        private boolean mStopOnCallerExit = true;

        public Builder setCallerTag(String callerTag) {
            this.mCallerTag = callerTag;
            return this;
        }

        public Builder setConfig(AlwaysOnCaptureConfig config) {
            this.mConfig = config;
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

        public AlwaysOnVadListenRequest build() {
            return new AlwaysOnVadListenRequest(this);
        }
    }
}
