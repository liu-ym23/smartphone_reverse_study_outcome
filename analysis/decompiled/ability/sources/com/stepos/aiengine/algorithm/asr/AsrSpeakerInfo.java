package com.stepos.aiengine.algorithm.asr;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\r¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\r¢\u0006\u0004\b\u0016\u0010\u000fJ\u0010\u0010\u0017\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ&\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010\u0018R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b!\u0010\u001a¨\u0006\""}, d2 = {"Lcom/stepos/aiengine/algorithm/asr/AsrSpeakerInfo;", "Landroid/os/Parcelable;", "", "id", "", "embedding", AppAgent.CONSTRUCT, "(Ljava/lang/String;[F)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Landroid/os/Parcel;", "dest", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "component1", "()Ljava/lang/String;", "component2", "()[F", "copy", "(Ljava/lang/String;[F)Lcom/stepos/aiengine/algorithm/asr/AsrSpeakerInfo;", "toString", "Ljava/lang/String;", "getId", "[F", "getEmbedding", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AsrSpeakerInfo implements Parcelable {
    public static final Parcelable.Creator<AsrSpeakerInfo> CREATOR = new Creator();
    private final float[] embedding;
    private final String id;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AsrSpeakerInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AsrSpeakerInfo createFromParcel(Parcel parcel) {
            k.f(parcel, "parcel");
            return new AsrSpeakerInfo(parcel.readString(), parcel.createFloatArray());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AsrSpeakerInfo[] newArray(int i) {
            return new AsrSpeakerInfo[i];
        }
    }

    public AsrSpeakerInfo(String id, float[] fArr) {
        k.f(id, "id");
        this.id = id;
        this.embedding = fArr;
    }

    public static /* synthetic */ AsrSpeakerInfo copy$default(AsrSpeakerInfo asrSpeakerInfo, String str, float[] fArr, int i, Object obj) {
        if ((i & 1) != 0) {
            str = asrSpeakerInfo.id;
        }
        if ((i & 2) != 0) {
            fArr = asrSpeakerInfo.embedding;
        }
        return asrSpeakerInfo.copy(str, fArr);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final float[] getEmbedding() {
        return this.embedding;
    }

    public final AsrSpeakerInfo copy(String id, float[] embedding) {
        k.f(id, "id");
        return new AsrSpeakerInfo(id, embedding);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AsrSpeakerInfo)) {
            return false;
        }
        AsrSpeakerInfo asrSpeakerInfo = (AsrSpeakerInfo) other;
        return k.b(this.id, asrSpeakerInfo.id) && Arrays.equals(this.embedding, asrSpeakerInfo.embedding);
    }

    public final float[] getEmbedding() {
        return this.embedding;
    }

    public final String getId() {
        return this.id;
    }

    public int hashCode() {
        int iHashCode = this.id.hashCode() * 31;
        float[] fArr = this.embedding;
        return iHashCode + (fArr != null ? Arrays.hashCode(fArr) : 0);
    }

    public String toString() {
        return a.m("AsrSpeakerInfo(id=", this.id, ", embedding=", Arrays.toString(this.embedding), ")");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        k.f(dest, "dest");
        dest.writeString(this.id);
        dest.writeFloatArray(this.embedding);
    }

    public /* synthetic */ AsrSpeakerInfo(String str, float[] fArr, int i, e eVar) {
        this(str, (i & 2) != 0 ? null : fArr);
    }
}
