package com.stepos.aiengine.algorithm.asr;

import B7.a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.foundation.b;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u001bJ\u0010\u0010 \u001a\u00020\nHÆ\u0003¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\"\u0010\u001bJ\u0010\u0010#\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b#\u0010$J`\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\rHÆ\u0001¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b'\u0010\u001bJ\u0010\u0010(\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b(\u0010\u0018J\u001a\u0010,\u001a\u00020+2\b\u0010*\u001a\u0004\u0018\u00010)HÖ\u0003¢\u0006\u0004\b,\u0010-R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010.\u001a\u0004\b/\u0010\u0018R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u00100\u001a\u0004\b1\u0010\u001bR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u00102\u001a\u0004\b3\u0010\u001dR\u0017\u0010\b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\b\u00102\u001a\u0004\b4\u0010\u001dR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u00100\u001a\u0004\b5\u0010\u001bR\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u00106\u001a\u0004\b7\u0010!R\u0017\u0010\f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\f\u00100\u001a\u0004\b8\u0010\u001bR\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u00109\u001a\u0004\b:\u0010$¨\u0006;"}, d2 = {"Lcom/stepos/aiengine/algorithm/asr/AsrRecognitionResult;", "Landroid/os/Parcelable;", "", "index", "", "text", "", "startTime", "endTime", "language", "", "confidence", "speakerId", "Lcom/stepos/aiengine/algorithm/asr/AsrUsage;", "usage", AppAgent.CONSTRUCT, "(ILjava/lang/String;JJLjava/lang/String;FLjava/lang/String;Lcom/stepos/aiengine/algorithm/asr/AsrUsage;)V", "Landroid/os/Parcel;", "dest", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "component2", "()Ljava/lang/String;", "component3", "()J", "component4", "component5", "component6", "()F", "component7", "component8", "()Lcom/stepos/aiengine/algorithm/asr/AsrUsage;", "copy", "(ILjava/lang/String;JJLjava/lang/String;FLjava/lang/String;Lcom/stepos/aiengine/algorithm/asr/AsrUsage;)Lcom/stepos/aiengine/algorithm/asr/AsrRecognitionResult;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getIndex", "Ljava/lang/String;", "getText", "J", "getStartTime", "getEndTime", "getLanguage", "F", "getConfidence", "getSpeakerId", "Lcom/stepos/aiengine/algorithm/asr/AsrUsage;", "getUsage", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AsrRecognitionResult implements Parcelable {
    public static final Parcelable.Creator<AsrRecognitionResult> CREATOR = new Creator();
    private final float confidence;
    private final long endTime;
    private final int index;
    private final String language;
    private final String speakerId;
    private final long startTime;
    private final String text;
    private final AsrUsage usage;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AsrRecognitionResult> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AsrRecognitionResult createFromParcel(Parcel parcel) {
            k.f(parcel, "parcel");
            return new AsrRecognitionResult(parcel.readInt(), parcel.readString(), parcel.readLong(), parcel.readLong(), parcel.readString(), parcel.readFloat(), parcel.readString(), AsrUsage.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AsrRecognitionResult[] newArray(int i) {
            return new AsrRecognitionResult[i];
        }
    }

    public AsrRecognitionResult(int i, String text, long j5, long j6, String language, float f, String speakerId, AsrUsage usage) {
        k.f(text, "text");
        k.f(language, "language");
        k.f(speakerId, "speakerId");
        k.f(usage, "usage");
        this.index = i;
        this.text = text;
        this.startTime = j5;
        this.endTime = j6;
        this.language = language;
        this.confidence = f;
        this.speakerId = speakerId;
        this.usage = usage;
    }

    public static /* synthetic */ AsrRecognitionResult copy$default(AsrRecognitionResult asrRecognitionResult, int i, String str, long j5, long j6, String str2, float f, String str3, AsrUsage asrUsage, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = asrRecognitionResult.index;
        }
        if ((i6 & 2) != 0) {
            str = asrRecognitionResult.text;
        }
        if ((i6 & 4) != 0) {
            j5 = asrRecognitionResult.startTime;
        }
        if ((i6 & 8) != 0) {
            j6 = asrRecognitionResult.endTime;
        }
        if ((i6 & 16) != 0) {
            str2 = asrRecognitionResult.language;
        }
        if ((i6 & 32) != 0) {
            f = asrRecognitionResult.confidence;
        }
        if ((i6 & 64) != 0) {
            str3 = asrRecognitionResult.speakerId;
        }
        if ((i6 & 128) != 0) {
            asrUsage = asrRecognitionResult.usage;
        }
        long j10 = j6;
        long j11 = j5;
        return asrRecognitionResult.copy(i, str, j11, j10, str2, f, str3, asrUsage);
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

    public final AsrRecognitionResult copy(int index, String text, long startTime, long endTime, String language, float confidence, String speakerId, AsrUsage usage) {
        k.f(text, "text");
        k.f(language, "language");
        k.f(speakerId, "speakerId");
        k.f(usage, "usage");
        return new AsrRecognitionResult(index, text, startTime, endTime, language, confidence, speakerId, usage);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AsrRecognitionResult)) {
            return false;
        }
        AsrRecognitionResult asrRecognitionResult = (AsrRecognitionResult) other;
        return this.index == asrRecognitionResult.index && k.b(this.text, asrRecognitionResult.text) && this.startTime == asrRecognitionResult.startTime && this.endTime == asrRecognitionResult.endTime && k.b(this.language, asrRecognitionResult.language) && Float.compare(this.confidence, asrRecognitionResult.confidence) == 0 && k.b(this.speakerId, asrRecognitionResult.speakerId) && k.b(this.usage, asrRecognitionResult.usage);
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
        return this.usage.hashCode() + a.c(androidx.appfunctions.metadata.a.b(this.confidence, a.c(androidx.appfunctions.metadata.a.c(androidx.appfunctions.metadata.a.c(a.c(Integer.hashCode(this.index) * 31, 31, this.text), 31, this.startTime), 31, this.endTime), 31, this.language), 31), 31, this.speakerId);
    }

    public String toString() {
        int i = this.index;
        String str = this.text;
        long j5 = this.startTime;
        long j6 = this.endTime;
        String str2 = this.language;
        float f = this.confidence;
        String str3 = this.speakerId;
        AsrUsage asrUsage = this.usage;
        StringBuilder sbK = androidx.constraintlayout.core.dsl.a.k(i, "AsrRecognitionResult(index=", ", text=", str, ", startTime=");
        sbK.append(j5);
        b.y(j6, ", endTime=", ", language=", sbK);
        sbK.append(str2);
        sbK.append(", confidence=");
        sbK.append(f);
        sbK.append(", speakerId=");
        sbK.append(str3);
        sbK.append(", usage=");
        sbK.append(asrUsage);
        sbK.append(")");
        return sbK.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        k.f(dest, "dest");
        dest.writeInt(this.index);
        dest.writeString(this.text);
        dest.writeLong(this.startTime);
        dest.writeLong(this.endTime);
        dest.writeString(this.language);
        dest.writeFloat(this.confidence);
        dest.writeString(this.speakerId);
        this.usage.writeToParcel(dest, flags);
    }

    public /* synthetic */ AsrRecognitionResult(int i, String str, long j5, long j6, String str2, float f, String str3, AsrUsage asrUsage, int i6, e eVar) {
        this(i, str, j5, j6, (i6 & 16) != 0 ? "" : str2, (i6 & 32) != 0 ? 0.0f : f, (i6 & 64) != 0 ? "" : str3, (i6 & 128) != 0 ? new AsrUsage(0, 0, 0, 7, null) : asrUsage);
    }
}
