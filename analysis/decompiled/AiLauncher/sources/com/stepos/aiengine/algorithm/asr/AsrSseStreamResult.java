package com.stepos.aiengine.algorithm.asr;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0018J\u0010\u0010\u001d\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJL\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\nHÆ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b!\u0010\u0018J\u0010\u0010\"\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\"\u0010\u0015J\u001a\u0010&\u001a\u00020%2\b\u0010$\u001a\u0004\u0018\u00010#HÖ\u0003¢\u0006\u0004\b&\u0010'R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010(\u001a\u0004\b)\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010*\u001a\u0004\b+\u0010\u0018R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010,\u001a\u0004\b-\u0010\u001aR\u0017\u0010\b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010,\u001a\u0004\b.\u0010\u001aR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010*\u001a\u0004\b/\u0010\u0018R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u00100\u001a\u0004\b1\u0010\u001e¨\u00062"}, d2 = {"Lcom/stepos/aiengine/algorithm/asr/AsrSseStreamResult;", "Landroid/os/Parcelable;", "", "index", "", "text", "", "startTime", "endTime", "language", "Lcom/stepos/aiengine/algorithm/asr/AsrUsage;", "usage", "<init>", "(ILjava/lang/String;JJLjava/lang/String;Lcom/stepos/aiengine/algorithm/asr/AsrUsage;)V", "Landroid/os/Parcel;", "dest", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "component2", "()Ljava/lang/String;", "component3", "()J", "component4", "component5", "component6", "()Lcom/stepos/aiengine/algorithm/asr/AsrUsage;", ChatTracker.CLICK_COPY, "(ILjava/lang/String;JJLjava/lang/String;Lcom/stepos/aiengine/algorithm/asr/AsrUsage;)Lcom/stepos/aiengine/algorithm/asr/AsrSseStreamResult;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getIndex", "Ljava/lang/String;", "getText", "J", "getStartTime", "getEndTime", "getLanguage", "Lcom/stepos/aiengine/algorithm/asr/AsrUsage;", "getUsage", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class AsrSseStreamResult implements Parcelable {
    public static final Parcelable.Creator<AsrSseStreamResult> CREATOR = new Creator();
    private final long endTime;
    private final int index;
    private final String language;
    private final long startTime;
    private final String text;
    private final AsrUsage usage;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AsrSseStreamResult> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AsrSseStreamResult createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            return new AsrSseStreamResult(parcel.readInt(), parcel.readString(), parcel.readLong(), parcel.readLong(), parcel.readString(), AsrUsage.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AsrSseStreamResult[] newArray(int i10) {
            return new AsrSseStreamResult[i10];
        }
    }

    public AsrSseStreamResult(int i10, String text, long j10, long j11, String language, AsrUsage usage) {
        p.i(text, "text");
        p.i(language, "language");
        p.i(usage, "usage");
        this.index = i10;
        this.text = text;
        this.startTime = j10;
        this.endTime = j11;
        this.language = language;
        this.usage = usage;
    }

    public static /* synthetic */ AsrSseStreamResult copy$default(AsrSseStreamResult asrSseStreamResult, int i10, String str, long j10, long j11, String str2, AsrUsage asrUsage, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = asrSseStreamResult.index;
        }
        if ((i11 & 2) != 0) {
            str = asrSseStreamResult.text;
        }
        if ((i11 & 4) != 0) {
            j10 = asrSseStreamResult.startTime;
        }
        if ((i11 & 8) != 0) {
            j11 = asrSseStreamResult.endTime;
        }
        if ((i11 & 16) != 0) {
            str2 = asrSseStreamResult.language;
        }
        if ((i11 & 32) != 0) {
            asrUsage = asrSseStreamResult.usage;
        }
        long j12 = j11;
        long j13 = j10;
        return asrSseStreamResult.copy(i10, str, j13, j12, str2, asrUsage);
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
    public final AsrUsage getUsage() {
        return this.usage;
    }

    public final AsrSseStreamResult copy(int index, String text, long startTime, long endTime, String language, AsrUsage usage) {
        p.i(text, "text");
        p.i(language, "language");
        p.i(usage, "usage");
        return new AsrSseStreamResult(index, text, startTime, endTime, language, usage);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AsrSseStreamResult)) {
            return false;
        }
        AsrSseStreamResult asrSseStreamResult = (AsrSseStreamResult) other;
        return this.index == asrSseStreamResult.index && p.d(this.text, asrSseStreamResult.text) && this.startTime == asrSseStreamResult.startTime && this.endTime == asrSseStreamResult.endTime && p.d(this.language, asrSseStreamResult.language) && p.d(this.usage, asrSseStreamResult.usage);
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
        return (((((((((Integer.hashCode(this.index) * 31) + this.text.hashCode()) * 31) + Long.hashCode(this.startTime)) * 31) + Long.hashCode(this.endTime)) * 31) + this.language.hashCode()) * 31) + this.usage.hashCode();
    }

    public String toString() {
        return "AsrSseStreamResult(index=" + this.index + ", text=" + this.text + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", language=" + this.language + ", usage=" + this.usage + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        p.i(dest, "dest");
        dest.writeInt(this.index);
        dest.writeString(this.text);
        dest.writeLong(this.startTime);
        dest.writeLong(this.endTime);
        dest.writeString(this.language);
        this.usage.writeToParcel(dest, flags);
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ AsrSseStreamResult(int r11, java.lang.String r12, long r13, long r15, java.lang.String r17, com.stepos.aiengine.algorithm.asr.AsrUsage r18, int r19, kotlin.jvm.internal.i r20) {
        /*
            r10 = this;
            r0 = r19 & 16
            if (r0 == 0) goto L8
            java.lang.String r0 = ""
            r8 = r0
            goto La
        L8:
            r8 = r17
        La:
            r0 = r19 & 32
            if (r0 == 0) goto L1f
            com.stepos.aiengine.algorithm.asr.AsrUsage r1 = new com.stepos.aiengine.algorithm.asr.AsrUsage
            r5 = 7
            r6 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r1.<init>(r2, r3, r4, r5, r6)
            r9 = r1
            r2 = r11
            r3 = r12
            r4 = r13
            r6 = r15
            r1 = r10
            goto L26
        L1f:
            r9 = r18
            r1 = r10
            r2 = r11
            r3 = r12
            r4 = r13
            r6 = r15
        L26:
            r1.<init>(r2, r3, r4, r6, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.aiengine.algorithm.asr.AsrSseStreamResult.<init>(int, java.lang.String, long, long, java.lang.String, com.stepos.aiengine.algorithm.asr.AsrUsage, int, kotlin.jvm.internal.i):void");
    }
}
