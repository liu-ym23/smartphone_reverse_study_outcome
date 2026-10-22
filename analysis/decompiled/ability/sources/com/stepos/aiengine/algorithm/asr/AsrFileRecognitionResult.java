package com.stepos.aiengine.algorithm.asr;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appfunctions.metadata.a;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.args.SingleFileBundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\u0013¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0004\b \u0010!J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0\bHÆ\u0003¢\u0006\u0004\b\"\u0010!J\u0010\u0010#\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b#\u0010$JX\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\b2\b\b\u0002\u0010\u000e\u001a\u00020\rHÆ\u0001¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b'\u0010\u001fJ\u0010\u0010(\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b(\u0010\u0019J\u001a\u0010,\u001a\u00020+2\b\u0010*\u001a\u0004\u0018\u00010)HÖ\u0003¢\u0006\u0004\b,\u0010-R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010.\u001a\u0004\b/\u0010\u001bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u00100\u001a\u0004\b1\u0010\u001dR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u00102\u001a\u0004\b3\u0010\u001fR\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006¢\u0006\f\n\u0004\b\n\u00104\u001a\u0004\b5\u0010!R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\b8\u0006¢\u0006\f\n\u0004\b\f\u00104\u001a\u0004\b6\u0010!R\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u00107\u001a\u0004\b8\u0010$¨\u00069"}, d2 = {"Lcom/stepos/aiengine/algorithm/asr/AsrFileRecognitionResult;", "Landroid/os/Parcelable;", "", SingleFileBundle.KEY_FILE_DESCRIPTOR, "", TypedValues.TransitionType.S_DURATION, "", "text", "", "Lcom/stepos/aiengine/algorithm/asr/AsrUtterance;", "utterances", "Lcom/stepos/aiengine/algorithm/asr/AsrSpeakerInfo;", "speakers", "Lcom/stepos/aiengine/algorithm/asr/AsrUsage;", "usage", AppAgent.CONSTRUCT, "(JFLjava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/stepos/aiengine/algorithm/asr/AsrUsage;)V", "Landroid/os/Parcel;", "dest", "", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()J", "component2", "()F", "component3", "()Ljava/lang/String;", "component4", "()Ljava/util/List;", "component5", "component6", "()Lcom/stepos/aiengine/algorithm/asr/AsrUsage;", "copy", "(JFLjava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/stepos/aiengine/algorithm/asr/AsrUsage;)Lcom/stepos/aiengine/algorithm/asr/AsrFileRecognitionResult;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getFd", "F", "getDuration", "Ljava/lang/String;", "getText", "Ljava/util/List;", "getUtterances", "getSpeakers", "Lcom/stepos/aiengine/algorithm/asr/AsrUsage;", "getUsage", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AsrFileRecognitionResult implements Parcelable {
    public static final Parcelable.Creator<AsrFileRecognitionResult> CREATOR = new Creator();
    private final float duration;
    private final long fd;
    private final List<AsrSpeakerInfo> speakers;
    private final String text;
    private final AsrUsage usage;
    private final List<AsrUtterance> utterances;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AsrFileRecognitionResult> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AsrFileRecognitionResult createFromParcel(Parcel parcel) {
            k.f(parcel, "parcel");
            long j5 = parcel.readLong();
            float f = parcel.readFloat();
            String string = parcel.readString();
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i6 = 0; i6 != i; i6++) {
                arrayList.add(AsrUtterance.CREATOR.createFromParcel(parcel));
            }
            int i10 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(i10);
            for (int i11 = 0; i11 != i10; i11++) {
                arrayList2.add(AsrSpeakerInfo.CREATOR.createFromParcel(parcel));
            }
            return new AsrFileRecognitionResult(j5, f, string, arrayList, arrayList2, AsrUsage.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AsrFileRecognitionResult[] newArray(int i) {
            return new AsrFileRecognitionResult[i];
        }
    }

    public AsrFileRecognitionResult(long j5, float f, String text, List<AsrUtterance> utterances, List<AsrSpeakerInfo> speakers, AsrUsage usage) {
        k.f(text, "text");
        k.f(utterances, "utterances");
        k.f(speakers, "speakers");
        k.f(usage, "usage");
        this.fd = j5;
        this.duration = f;
        this.text = text;
        this.utterances = utterances;
        this.speakers = speakers;
        this.usage = usage;
    }

    public static /* synthetic */ AsrFileRecognitionResult copy$default(AsrFileRecognitionResult asrFileRecognitionResult, long j5, float f, String str, List list, List list2, AsrUsage asrUsage, int i, Object obj) {
        if ((i & 1) != 0) {
            j5 = asrFileRecognitionResult.fd;
        }
        long j6 = j5;
        if ((i & 2) != 0) {
            f = asrFileRecognitionResult.duration;
        }
        float f7 = f;
        if ((i & 4) != 0) {
            str = asrFileRecognitionResult.text;
        }
        String str2 = str;
        if ((i & 8) != 0) {
            list = asrFileRecognitionResult.utterances;
        }
        List list3 = list;
        if ((i & 16) != 0) {
            list2 = asrFileRecognitionResult.speakers;
        }
        List list4 = list2;
        if ((i & 32) != 0) {
            asrUsage = asrFileRecognitionResult.usage;
        }
        return asrFileRecognitionResult.copy(j6, f7, str2, list3, list4, asrUsage);
    }

    /* renamed from: component1, reason: from getter */
    public final long getFd() {
        return this.fd;
    }

    /* renamed from: component2, reason: from getter */
    public final float getDuration() {
        return this.duration;
    }

    /* renamed from: component3, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public final List<AsrUtterance> component4() {
        return this.utterances;
    }

    public final List<AsrSpeakerInfo> component5() {
        return this.speakers;
    }

    /* renamed from: component6, reason: from getter */
    public final AsrUsage getUsage() {
        return this.usage;
    }

    public final AsrFileRecognitionResult copy(long fd, float duration, String text, List<AsrUtterance> utterances, List<AsrSpeakerInfo> speakers, AsrUsage usage) {
        k.f(text, "text");
        k.f(utterances, "utterances");
        k.f(speakers, "speakers");
        k.f(usage, "usage");
        return new AsrFileRecognitionResult(fd, duration, text, utterances, speakers, usage);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AsrFileRecognitionResult)) {
            return false;
        }
        AsrFileRecognitionResult asrFileRecognitionResult = (AsrFileRecognitionResult) other;
        return this.fd == asrFileRecognitionResult.fd && Float.compare(this.duration, asrFileRecognitionResult.duration) == 0 && k.b(this.text, asrFileRecognitionResult.text) && k.b(this.utterances, asrFileRecognitionResult.utterances) && k.b(this.speakers, asrFileRecognitionResult.speakers) && k.b(this.usage, asrFileRecognitionResult.usage);
    }

    public final float getDuration() {
        return this.duration;
    }

    public final long getFd() {
        return this.fd;
    }

    public final List<AsrSpeakerInfo> getSpeakers() {
        return this.speakers;
    }

    public final String getText() {
        return this.text;
    }

    public final AsrUsage getUsage() {
        return this.usage;
    }

    public final List<AsrUtterance> getUtterances() {
        return this.utterances;
    }

    public int hashCode() {
        return this.usage.hashCode() + a.e(this.speakers, a.e(this.utterances, B7.a.c(a.b(this.duration, Long.hashCode(this.fd) * 31, 31), 31, this.text), 31), 31);
    }

    public String toString() {
        return "AsrFileRecognitionResult(fd=" + this.fd + ", duration=" + this.duration + ", text=" + this.text + ", utterances=" + this.utterances + ", speakers=" + this.speakers + ", usage=" + this.usage + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        k.f(dest, "dest");
        dest.writeLong(this.fd);
        dest.writeFloat(this.duration);
        dest.writeString(this.text);
        List<AsrUtterance> list = this.utterances;
        dest.writeInt(list.size());
        Iterator<AsrUtterance> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(dest, flags);
        }
        List<AsrSpeakerInfo> list2 = this.speakers;
        dest.writeInt(list2.size());
        Iterator<AsrSpeakerInfo> it2 = list2.iterator();
        while (it2.hasNext()) {
            it2.next().writeToParcel(dest, flags);
        }
        this.usage.writeToParcel(dest, flags);
    }

    public AsrFileRecognitionResult(long j5, float f, String str, List list, List list2, AsrUsage asrUsage, int i, e eVar) {
        this(j5, (i & 2) != 0 ? 0.0f : f, str, (i & 8) != 0 ? EmptyList.f4893a : list, (i & 16) != 0 ? EmptyList.f4893a : list2, (i & 32) != 0 ? new AsrUsage(0, 0, 0, 7, null) : asrUsage);
    }
}
