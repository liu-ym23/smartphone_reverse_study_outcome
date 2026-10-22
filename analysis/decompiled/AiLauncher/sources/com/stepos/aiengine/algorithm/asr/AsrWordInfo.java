package com.stepos.aiengine.algorithm.asr;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0015J.\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0013J\u0010\u0010\u001a\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0011J\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\u0013R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\"\u001a\u0004\b#\u0010\u0015R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\"\u001a\u0004\b$\u0010\u0015¨\u0006%"}, d2 = {"Lcom/stepos/aiengine/algorithm/asr/AsrWordInfo;", "Landroid/os/Parcelable;", "", "text", "", "startTime", "endTime", "<init>", "(Ljava/lang/String;JJ)V", "Landroid/os/Parcel;", "dest", "", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", "component2", "()J", "component3", ChatTracker.CLICK_COPY, "(Ljava/lang/String;JJ)Lcom/stepos/aiengine/algorithm/asr/AsrWordInfo;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getText", "J", "getStartTime", "getEndTime", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class AsrWordInfo implements Parcelable {
    public static final Parcelable.Creator<AsrWordInfo> CREATOR = new Creator();
    private final long endTime;
    private final long startTime;
    private final String text;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AsrWordInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AsrWordInfo createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            return new AsrWordInfo(parcel.readString(), parcel.readLong(), parcel.readLong());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AsrWordInfo[] newArray(int i10) {
            return new AsrWordInfo[i10];
        }
    }

    public AsrWordInfo(String text, long j10, long j11) {
        p.i(text, "text");
        this.text = text;
        this.startTime = j10;
        this.endTime = j11;
    }

    public static /* synthetic */ AsrWordInfo copy$default(AsrWordInfo asrWordInfo, String str, long j10, long j11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = asrWordInfo.text;
        }
        if ((i10 & 2) != 0) {
            j10 = asrWordInfo.startTime;
        }
        if ((i10 & 4) != 0) {
            j11 = asrWordInfo.endTime;
        }
        return asrWordInfo.copy(str, j10, j11);
    }

    /* renamed from: component1, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: component2, reason: from getter */
    public final long getStartTime() {
        return this.startTime;
    }

    /* renamed from: component3, reason: from getter */
    public final long getEndTime() {
        return this.endTime;
    }

    public final AsrWordInfo copy(String text, long startTime, long endTime) {
        p.i(text, "text");
        return new AsrWordInfo(text, startTime, endTime);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AsrWordInfo)) {
            return false;
        }
        AsrWordInfo asrWordInfo = (AsrWordInfo) other;
        return p.d(this.text, asrWordInfo.text) && this.startTime == asrWordInfo.startTime && this.endTime == asrWordInfo.endTime;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        return (((this.text.hashCode() * 31) + Long.hashCode(this.startTime)) * 31) + Long.hashCode(this.endTime);
    }

    public String toString() {
        return "AsrWordInfo(text=" + this.text + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        p.i(dest, "dest");
        dest.writeString(this.text);
        dest.writeLong(this.startTime);
        dest.writeLong(this.endTime);
    }
}
