package com.stepos.aiengine.algorithm.asr;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.core.dsl.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u000fJ\u0010\u0010\u0012\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u000fJ.\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u000fJ\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010\u000fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001e\u001a\u0004\b \u0010\u000fR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b!\u0010\u000f¨\u0006\""}, d2 = {"Lcom/stepos/aiengine/algorithm/asr/AsrUsage;", "Landroid/os/Parcelable;", "", "audioTokens", "outputTokens", "totalTokens", AppAgent.CONSTRUCT, "(III)V", "Landroid/os/Parcel;", "dest", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "component2", "component3", "copy", "(III)Lcom/stepos/aiengine/algorithm/asr/AsrUsage;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getAudioTokens", "getOutputTokens", "getTotalTokens", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AsrUsage implements Parcelable {
    public static final Parcelable.Creator<AsrUsage> CREATOR = new Creator();
    private final int audioTokens;
    private final int outputTokens;
    private final int totalTokens;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AsrUsage> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AsrUsage createFromParcel(Parcel parcel) {
            k.f(parcel, "parcel");
            return new AsrUsage(parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AsrUsage[] newArray(int i) {
            return new AsrUsage[i];
        }
    }

    public AsrUsage() {
        this(0, 0, 0, 7, null);
    }

    public static /* synthetic */ AsrUsage copy$default(AsrUsage asrUsage, int i, int i6, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i = asrUsage.audioTokens;
        }
        if ((i11 & 2) != 0) {
            i6 = asrUsage.outputTokens;
        }
        if ((i11 & 4) != 0) {
            i10 = asrUsage.totalTokens;
        }
        return asrUsage.copy(i, i6, i10);
    }

    /* renamed from: component1, reason: from getter */
    public final int getAudioTokens() {
        return this.audioTokens;
    }

    /* renamed from: component2, reason: from getter */
    public final int getOutputTokens() {
        return this.outputTokens;
    }

    /* renamed from: component3, reason: from getter */
    public final int getTotalTokens() {
        return this.totalTokens;
    }

    public final AsrUsage copy(int audioTokens, int outputTokens, int totalTokens) {
        return new AsrUsage(audioTokens, outputTokens, totalTokens);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AsrUsage)) {
            return false;
        }
        AsrUsage asrUsage = (AsrUsage) other;
        return this.audioTokens == asrUsage.audioTokens && this.outputTokens == asrUsage.outputTokens && this.totalTokens == asrUsage.totalTokens;
    }

    public final int getAudioTokens() {
        return this.audioTokens;
    }

    public final int getOutputTokens() {
        return this.outputTokens;
    }

    public final int getTotalTokens() {
        return this.totalTokens;
    }

    public int hashCode() {
        return Integer.hashCode(this.totalTokens) + a.a(this.outputTokens, Integer.hashCode(this.audioTokens) * 31, 31);
    }

    public String toString() {
        int i = this.audioTokens;
        int i6 = this.outputTokens;
        return androidx.appfunctions.metadata.a.o(androidx.appfunctions.metadata.a.s(i, "AsrUsage(audioTokens=", i6, ", outputTokens=", ", totalTokens="), ")", this.totalTokens);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        k.f(dest, "dest");
        dest.writeInt(this.audioTokens);
        dest.writeInt(this.outputTokens);
        dest.writeInt(this.totalTokens);
    }

    public AsrUsage(int i, int i6, int i10) {
        this.audioTokens = i;
        this.outputTokens = i6;
        this.totalTokens = i10;
    }

    public /* synthetic */ AsrUsage(int i, int i6, int i10, int i11, e eVar) {
        this((i11 & 1) != 0 ? 0 : i, (i11 & 2) != 0 ? 0 : i6, (i11 & 4) != 0 ? 0 : i10);
    }
}
