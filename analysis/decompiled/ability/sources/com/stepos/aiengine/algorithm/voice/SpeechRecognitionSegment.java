package com.stepos.aiengine.algorithm.voice;

import B7.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u000e¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u000bJ\u0010\u0010\u0019\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u000bJ8\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0014J\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÖ\u0003¢\u0006\u0004\b \u0010!R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\"\u001a\u0004\b#\u0010\u0016R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\"\u001a\u0004\b$\u0010\u0016R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010%\u001a\u0004\b&\u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010%\u001a\u0004\b'\u0010\u000b¨\u0006("}, d2 = {"Lcom/stepos/aiengine/algorithm/voice/SpeechRecognitionSegment;", "Landroid/os/Parcelable;", "", "start", "end", "", "sentence", "speakerId", AppAgent.CONSTRUCT, "(JJLjava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "dest", "", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()J", "component2", "component3", "component4", "copy", "(JJLjava/lang/String;Ljava/lang/String;)Lcom/stepos/aiengine/algorithm/voice/SpeechRecognitionSegment;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getStart", "getEnd", "Ljava/lang/String;", "getSentence", "getSpeakerId", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SpeechRecognitionSegment implements Parcelable {
    public static final Parcelable.Creator<SpeechRecognitionSegment> CREATOR = new Creator();
    private final long end;
    private final String sentence;
    private final String speakerId;
    private final long start;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SpeechRecognitionSegment> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SpeechRecognitionSegment createFromParcel(Parcel parcel) {
            k.f(parcel, "parcel");
            return new SpeechRecognitionSegment(parcel.readLong(), parcel.readLong(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SpeechRecognitionSegment[] newArray(int i) {
            return new SpeechRecognitionSegment[i];
        }
    }

    public SpeechRecognitionSegment(long j5, long j6, String sentence, String speakerId) {
        k.f(sentence, "sentence");
        k.f(speakerId, "speakerId");
        this.start = j5;
        this.end = j6;
        this.sentence = sentence;
        this.speakerId = speakerId;
    }

    public static /* synthetic */ SpeechRecognitionSegment copy$default(SpeechRecognitionSegment speechRecognitionSegment, long j5, long j6, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            j5 = speechRecognitionSegment.start;
        }
        long j10 = j5;
        if ((i & 2) != 0) {
            j6 = speechRecognitionSegment.end;
        }
        long j11 = j6;
        if ((i & 4) != 0) {
            str = speechRecognitionSegment.sentence;
        }
        String str3 = str;
        if ((i & 8) != 0) {
            str2 = speechRecognitionSegment.speakerId;
        }
        return speechRecognitionSegment.copy(j10, j11, str3, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final long getStart() {
        return this.start;
    }

    /* renamed from: component2, reason: from getter */
    public final long getEnd() {
        return this.end;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSentence() {
        return this.sentence;
    }

    /* renamed from: component4, reason: from getter */
    public final String getSpeakerId() {
        return this.speakerId;
    }

    public final SpeechRecognitionSegment copy(long start, long end, String sentence, String speakerId) {
        k.f(sentence, "sentence");
        k.f(speakerId, "speakerId");
        return new SpeechRecognitionSegment(start, end, sentence, speakerId);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SpeechRecognitionSegment)) {
            return false;
        }
        SpeechRecognitionSegment speechRecognitionSegment = (SpeechRecognitionSegment) other;
        return this.start == speechRecognitionSegment.start && this.end == speechRecognitionSegment.end && k.b(this.sentence, speechRecognitionSegment.sentence) && k.b(this.speakerId, speechRecognitionSegment.speakerId);
    }

    public final long getEnd() {
        return this.end;
    }

    public final String getSentence() {
        return this.sentence;
    }

    public final String getSpeakerId() {
        return this.speakerId;
    }

    public final long getStart() {
        return this.start;
    }

    public int hashCode() {
        return this.speakerId.hashCode() + a.c(androidx.appfunctions.metadata.a.c(Long.hashCode(this.start) * 31, 31, this.end), 31, this.sentence);
    }

    public String toString() {
        long j5 = this.start;
        long j6 = this.end;
        String str = this.speakerId;
        String str2 = this.sentence;
        StringBuilder sb = new StringBuilder("[");
        sb.append(j5);
        sb.append(" --> ");
        sb.append(j6);
        sb.append("](spk=");
        sb.append(str);
        return a.q(sb, "):", str2);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        k.f(dest, "dest");
        dest.writeLong(this.start);
        dest.writeLong(this.end);
        dest.writeString(this.sentence);
        dest.writeString(this.speakerId);
    }

    public /* synthetic */ SpeechRecognitionSegment(long j5, long j6, String str, String str2, int i, e eVar) {
        this(j5, j6, str, (i & 8) != 0 ? "" : str2);
    }
}
