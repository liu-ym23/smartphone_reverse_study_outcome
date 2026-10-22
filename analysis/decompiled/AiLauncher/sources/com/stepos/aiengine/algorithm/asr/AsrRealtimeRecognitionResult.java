package com.stepos.aiengine.algorithm.asr;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u001bJ\u0010\u0010 \u001a\u00020\nHÆ\u0003¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\"\u0010\u001bJ\u0010\u0010#\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b#\u0010$J`\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\rHÆ\u0001¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b'\u0010\u001bJ\u0010\u0010(\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b(\u0010\u0018J\u001a\u0010,\u001a\u00020+2\b\u0010*\u001a\u0004\u0018\u00010)HÖ\u0003¢\u0006\u0004\b,\u0010-R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010.\u001a\u0004\b/\u0010\u0018R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u00100\u001a\u0004\b1\u0010\u001bR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u00102\u001a\u0004\b3\u0010\u001dR\u0017\u0010\b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\b\u00102\u001a\u0004\b4\u0010\u001dR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u00100\u001a\u0004\b5\u0010\u001bR\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u00106\u001a\u0004\b7\u0010!R\u0017\u0010\f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\f\u00100\u001a\u0004\b8\u0010\u001bR\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u00109\u001a\u0004\b:\u0010$¨\u0006;"}, d2 = {"Lcom/stepos/aiengine/algorithm/asr/AsrRealtimeRecognitionResult;", "Landroid/os/Parcelable;", "", "index", "", "text", "", "startTime", "endTime", "language", "", "confidence", "speakerId", "Lcom/stepos/aiengine/algorithm/asr/AsrUsage;", "usage", "<init>", "(ILjava/lang/String;JJLjava/lang/String;FLjava/lang/String;Lcom/stepos/aiengine/algorithm/asr/AsrUsage;)V", "Landroid/os/Parcel;", "dest", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "component2", "()Ljava/lang/String;", "component3", "()J", "component4", "component5", "component6", "()F", "component7", "component8", "()Lcom/stepos/aiengine/algorithm/asr/AsrUsage;", ChatTracker.CLICK_COPY, "(ILjava/lang/String;JJLjava/lang/String;FLjava/lang/String;Lcom/stepos/aiengine/algorithm/asr/AsrUsage;)Lcom/stepos/aiengine/algorithm/asr/AsrRealtimeRecognitionResult;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getIndex", "Ljava/lang/String;", "getText", "J", "getStartTime", "getEndTime", "getLanguage", "F", "getConfidence", "getSpeakerId", "Lcom/stepos/aiengine/algorithm/asr/AsrUsage;", "getUsage", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class AsrRealtimeRecognitionResult implements Parcelable {
    public static final Parcelable.Creator<AsrRealtimeRecognitionResult> CREATOR = new Creator();
    private final float confidence;
    private final long endTime;
    private final int index;
    private final String language;
    private final String speakerId;
    private final long startTime;
    private final String text;
    private final AsrUsage usage;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AsrRealtimeRecognitionResult> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AsrRealtimeRecognitionResult createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            return new AsrRealtimeRecognitionResult(parcel.readInt(), parcel.readString(), parcel.readLong(), parcel.readLong(), parcel.readString(), parcel.readFloat(), parcel.readString(), AsrUsage.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AsrRealtimeRecognitionResult[] newArray(int i10) {
            return new AsrRealtimeRecognitionResult[i10];
        }
    }

    public AsrRealtimeRecognitionResult(int i10, String text, long j10, long j11, String language, float f10, String speakerId, AsrUsage usage) {
        p.i(text, "text");
        p.i(language, "language");
        p.i(speakerId, "speakerId");
        p.i(usage, "usage");
        this.index = i10;
        this.text = text;
        this.startTime = j10;
        this.endTime = j11;
        this.language = language;
        this.confidence = f10;
        this.speakerId = speakerId;
        this.usage = usage;
    }

    public static /* synthetic */ AsrRealtimeRecognitionResult copy$default(AsrRealtimeRecognitionResult asrRealtimeRecognitionResult, int i10, String str, long j10, long j11, String str2, float f10, String str3, AsrUsage asrUsage, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = asrRealtimeRecognitionResult.index;
        }
        if ((i11 & 2) != 0) {
            str = asrRealtimeRecognitionResult.text;
        }
        if ((i11 & 4) != 0) {
            j10 = asrRealtimeRecognitionResult.startTime;
        }
        if ((i11 & 8) != 0) {
            j11 = asrRealtimeRecognitionResult.endTime;
        }
        if ((i11 & 16) != 0) {
            str2 = asrRealtimeRecognitionResult.language;
        }
        if ((i11 & 32) != 0) {
            f10 = asrRealtimeRecognitionResult.confidence;
        }
        if ((i11 & 64) != 0) {
            str3 = asrRealtimeRecognitionResult.speakerId;
        }
        if ((i11 & 128) != 0) {
            asrUsage = asrRealtimeRecognitionResult.usage;
        }
        long j12 = j11;
        long j13 = j10;
        return asrRealtimeRecognitionResult.copy(i10, str, j13, j12, str2, f10, str3, asrUsage);
    }

    /* renamed from: component1, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    /* renamed from: component2, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: component3, reason: from getter */
    public final long getStartTime() {
        return this.startTime;
    }

    /* renamed from: component4, reason: from getter */
    public final long getEndTime() {
        return this.endTime;
    }

    /* renamed from: component5, reason: from getter */
    public final String getLanguage() {
        return this.language;
    }

    /* renamed from: component6, reason: from getter */
    public final float getConfidence() {
        return this.confidence;
    }

    /* renamed from: component7, reason: from getter */
    public final String getSpeakerId() {
        return this.speakerId;
    }

    /* renamed from: component8, reason: from getter */
    public final AsrUsage getUsage() {
        return this.usage;
    }

    public final AsrRealtimeRecognitionResult copy(int index, String text, long startTime, long endTime, String language, float confidence, String speakerId, AsrUsage usage) {
        p.i(text, "text");
        p.i(language, "language");
        p.i(speakerId, "speakerId");
        p.i(usage, "usage");
        return new AsrRealtimeRecognitionResult(index, text, startTime, endTime, language, confidence, speakerId, usage);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AsrRealtimeRecognitionResult)) {
            return false;
        }
        AsrRealtimeRecognitionResult asrRealtimeRecognitionResult = (AsrRealtimeRecognitionResult) other;
        return this.index == asrRealtimeRecognitionResult.index && p.d(this.text, asrRealtimeRecognitionResult.text) && this.startTime == asrRealtimeRecognitionResult.startTime && this.endTime == asrRealtimeRecognitionResult.endTime && p.d(this.language, asrRealtimeRecognitionResult.language) && Float.compare(this.confidence, asrRealtimeRecognitionResult.confidence) == 0 && p.d(this.speakerId, asrRealtimeRecognitionResult.speakerId) && p.d(this.usage, asrRealtimeRecognitionResult.usage);
    }

    public final float getConfidence() {
        return this.confidence;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final int getIndex() {
        return this.index;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final String getSpeakerId() {
        return this.speakerId;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final String getText() {
        return this.text;
    }

    public final AsrUsage getUsage() {
        return this.usage;
    }

    public int hashCode() {
        return (((((((((((((Integer.hashCode(this.index) * 31) + this.text.hashCode()) * 31) + Long.hashCode(this.startTime)) * 31) + Long.hashCode(this.endTime)) * 31) + this.language.hashCode()) * 31) + Float.hashCode(this.confidence)) * 31) + this.speakerId.hashCode()) * 31) + this.usage.hashCode();
    }

    public String toString() {
        return "AsrRealtimeRecognitionResult(index=" + this.index + ", text=" + this.text + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", language=" + this.language + ", confidence=" + this.confidence + ", speakerId=" + this.speakerId + ", usage=" + this.usage + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        p.i(dest, "dest");
        dest.writeInt(this.index);
        dest.writeString(this.text);
        dest.writeLong(this.startTime);
        dest.writeLong(this.endTime);
        dest.writeString(this.language);
        dest.writeFloat(this.confidence);
        dest.writeString(this.speakerId);
        this.usage.writeToParcel(dest, flags);
    }

    public /* synthetic */ AsrRealtimeRecognitionResult(int i10, String str, long j10, long j11, String str2, float f10, String str3, AsrUsage asrUsage, int i11, i iVar) {
        this(i10, str, j10, j11, (i11 & 16) != 0 ? "" : str2, (i11 & 32) != 0 ? 0.0f : f10, (i11 & 64) != 0 ? "" : str3, (i11 & 128) != 0 ? new AsrUsage(0, 0, 0, 7, null) : asrUsage);
    }
}
