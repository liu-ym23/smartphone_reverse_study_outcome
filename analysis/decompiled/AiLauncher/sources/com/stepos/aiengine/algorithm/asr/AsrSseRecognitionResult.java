package com.stepos.aiengine.algorithm.asr;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J$\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0012J\u0010\u0010\u0018\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0010J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010\u0012R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b!\u0010\u0014¨\u0006\""}, d2 = {"Lcom/stepos/aiengine/algorithm/asr/AsrSseRecognitionResult;", "Landroid/os/Parcelable;", "", "text", "Lcom/stepos/aiengine/algorithm/asr/AsrUsage;", "usage", "<init>", "(Ljava/lang/String;Lcom/stepos/aiengine/algorithm/asr/AsrUsage;)V", "Landroid/os/Parcel;", "dest", "", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", "component2", "()Lcom/stepos/aiengine/algorithm/asr/AsrUsage;", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Lcom/stepos/aiengine/algorithm/asr/AsrUsage;)Lcom/stepos/aiengine/algorithm/asr/AsrSseRecognitionResult;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getText", "Lcom/stepos/aiengine/algorithm/asr/AsrUsage;", "getUsage", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class AsrSseRecognitionResult implements Parcelable {
    public static final Parcelable.Creator<AsrSseRecognitionResult> CREATOR = new Creator();
    private final String text;
    private final AsrUsage usage;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AsrSseRecognitionResult> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AsrSseRecognitionResult createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            return new AsrSseRecognitionResult(parcel.readString(), AsrUsage.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AsrSseRecognitionResult[] newArray(int i10) {
            return new AsrSseRecognitionResult[i10];
        }
    }

    public AsrSseRecognitionResult(String text, AsrUsage usage) {
        p.i(text, "text");
        p.i(usage, "usage");
        this.text = text;
        this.usage = usage;
    }

    public static /* synthetic */ AsrSseRecognitionResult copy$default(AsrSseRecognitionResult asrSseRecognitionResult, String str, AsrUsage asrUsage, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = asrSseRecognitionResult.text;
        }
        if ((i10 & 2) != 0) {
            asrUsage = asrSseRecognitionResult.usage;
        }
        return asrSseRecognitionResult.copy(str, asrUsage);
    }

    /* renamed from: component1, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: component2, reason: from getter */
    public final AsrUsage getUsage() {
        return this.usage;
    }

    public final AsrSseRecognitionResult copy(String text, AsrUsage usage) {
        p.i(text, "text");
        p.i(usage, "usage");
        return new AsrSseRecognitionResult(text, usage);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AsrSseRecognitionResult)) {
            return false;
        }
        AsrSseRecognitionResult asrSseRecognitionResult = (AsrSseRecognitionResult) other;
        return p.d(this.text, asrSseRecognitionResult.text) && p.d(this.usage, asrSseRecognitionResult.usage);
    }

    public final String getText() {
        return this.text;
    }

    public final AsrUsage getUsage() {
        return this.usage;
    }

    public int hashCode() {
        return (this.text.hashCode() * 31) + this.usage.hashCode();
    }

    public String toString() {
        return "AsrSseRecognitionResult(text=" + this.text + ", usage=" + this.usage + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        p.i(dest, "dest");
        dest.writeString(this.text);
        this.usage.writeToParcel(dest, flags);
    }

    public /* synthetic */ AsrSseRecognitionResult(String str, AsrUsage asrUsage, int i10, i iVar) {
        this(str, (i10 & 2) != 0 ? new AsrUsage(0, 0, 0, 7, null) : asrUsage);
    }
}
