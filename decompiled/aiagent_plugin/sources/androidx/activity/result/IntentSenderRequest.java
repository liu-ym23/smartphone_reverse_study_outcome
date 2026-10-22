package androidx.activity.result;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class IntentSenderRequest implements Parcelable {
    public static final Parcelable.Creator<IntentSenderRequest> CREATOR = null;
    private final Intent mFillInIntent;
    private final int mFlagsMask;
    private final int mFlagsValues;
    private final IntentSender mIntentSender;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private IntentSender f159a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Intent f160b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f161c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f162d;

        public a(IntentSender r1) {
            this.f159a = r1;
        }

        public a a(Intent r1) {
            this.f160b = r1;
            return this;
        }

        public a a(int r1, int r2) {
            this.f162d = r1;
            this.f161c = r2;
            return this;
        }

        public IntentSenderRequest a() {
            return new IntentSenderRequest(this.f159a, this.f160b, this.f161c, this.f162d);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    IntentSenderRequest(IntentSender r1, Intent r2, int r3, int r4) {
        this.mIntentSender = r1;
        this.mFillInIntent = r2;
        this.mFlagsMask = r3;
        this.mFlagsValues = r4;
    }

    public IntentSender getIntentSender() {
        return this.mIntentSender;
    }

    public Intent getFillInIntent() {
        return this.mFillInIntent;
    }

    public int getFlagsMask() {
        return this.mFlagsMask;
    }

    public int getFlagsValues() {
        return this.mFlagsValues;
    }

    IntentSenderRequest(Parcel r4) {
        this.mIntentSender = (IntentSender) ZeusTransformUtils.preCheckCast(r4.readParcelable(IntentSender.class.getClassLoader()), IntentSender.class, "com.obric.aiagent.plugin");
        this.mFillInIntent = (Intent) ZeusTransformUtils.preCheckCast(r4.readParcelable(Intent.class.getClassLoader()), Intent.class, "com.obric.aiagent.plugin");
        this.mFlagsMask = r4.readInt();
        this.mFlagsValues = r4.readInt();
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeParcelable(this.mIntentSender, r3);
        r2.writeParcelable(this.mFillInIntent, r3);
        r2.writeInt(this.mFlagsMask);
        r2.writeInt(this.mFlagsValues);
    }
}
