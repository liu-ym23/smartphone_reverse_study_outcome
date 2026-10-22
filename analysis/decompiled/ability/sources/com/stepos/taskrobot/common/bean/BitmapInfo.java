package com.stepos.taskrobot.common.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0018\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/stepos/taskrobot/common/bean/BitmapInfo;", "Landroid/os/Parcelable;", "", "imageBytes", "", "imageUrl", "cozeId", AppAgent.CONSTRUCT, "([BLjava/lang/String;Ljava/lang/String;)V", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "[B", "getImageBytes", "()[B", "Ljava/lang/String;", "getImageUrl", "()Ljava/lang/String;", "getCozeId", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BitmapInfo implements Parcelable {
    public static final Parcelable.Creator<BitmapInfo> CREATOR = new Creator();
    private final String cozeId;
    private final byte[] imageBytes;
    private final String imageUrl;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<BitmapInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BitmapInfo createFromParcel(Parcel parcel) {
            k.f(parcel, "parcel");
            return new BitmapInfo(parcel.createByteArray(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BitmapInfo[] newArray(int i) {
            return new BitmapInfo[i];
        }
    }

    public BitmapInfo(byte[] imageBytes, String imageUrl, String cozeId) {
        k.f(imageBytes, "imageBytes");
        k.f(imageUrl, "imageUrl");
        k.f(cozeId, "cozeId");
        this.imageBytes = imageBytes;
        this.imageUrl = imageUrl;
        this.cozeId = cozeId;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getCozeId() {
        return this.cozeId;
    }

    public final byte[] getImageBytes() {
        return this.imageBytes;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        k.f(dest, "dest");
        dest.writeByteArray(this.imageBytes);
        dest.writeString(this.imageUrl);
        dest.writeString(this.cozeId);
    }
}
