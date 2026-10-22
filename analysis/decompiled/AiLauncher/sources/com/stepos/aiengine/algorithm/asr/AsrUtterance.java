package com.stepos.aiengine.algorithm.asr;

import Z8.C1173v;
import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.aiengine.args.SingleFileBundle;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0017J\u0010\u0010\u001b\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0019J\u0010\u0010\u001e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0019J\u0010\u0010\u001f\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u001cJ\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003¢\u0006\u0004\b \u0010!J\\\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00062\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b$\u0010\u001cJ\u0010\u0010%\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b%\u0010\u0017J\u001a\u0010)\u001a\u00020(2\b\u0010'\u001a\u0004\u0018\u00010&HÖ\u0003¢\u0006\u0004\b)\u0010*R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010+\u001a\u0004\b,\u0010\u0019R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010-\u001a\u0004\b.\u0010\u0017R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010/\u001a\u0004\b0\u0010\u001cR\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010+\u001a\u0004\b1\u0010\u0019R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010+\u001a\u0004\b2\u0010\u0019R\u0017\u0010\n\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\n\u0010/\u001a\u0004\b3\u0010\u001cR\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006¢\u0006\f\n\u0004\b\r\u00104\u001a\u0004\b5\u0010!¨\u00066"}, d2 = {"Lcom/stepos/aiengine/algorithm/asr/AsrUtterance;", "Landroid/os/Parcelable;", "", SingleFileBundle.KEY_FILE_DESCRIPTOR, "", "index", "", "text", "startTime", "endTime", "speakerId", "", "Lcom/stepos/aiengine/algorithm/asr/AsrWordInfo;", "words", "<init>", "(JILjava/lang/String;JJLjava/lang/String;Ljava/util/List;)V", "Landroid/os/Parcel;", "dest", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()J", "component2", "component3", "()Ljava/lang/String;", "component4", "component5", "component6", "component7", "()Ljava/util/List;", ChatTracker.CLICK_COPY, "(JILjava/lang/String;JJLjava/lang/String;Ljava/util/List;)Lcom/stepos/aiengine/algorithm/asr/AsrUtterance;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getFd", "I", "getIndex", "Ljava/lang/String;", "getText", "getStartTime", "getEndTime", "getSpeakerId", "Ljava/util/List;", "getWords", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class AsrUtterance implements Parcelable {
    public static final Parcelable.Creator<AsrUtterance> CREATOR = new Creator();
    private final long endTime;
    private final long fd;
    private final int index;
    private final String speakerId;
    private final long startTime;
    private final String text;
    private final List<AsrWordInfo> words;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AsrUtterance> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AsrUtterance createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            long j10 = parcel.readLong();
            int i10 = parcel.readInt();
            String string = parcel.readString();
            long j11 = parcel.readLong();
            long j12 = parcel.readLong();
            String string2 = parcel.readString();
            int i11 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i11);
            for (int i12 = 0; i12 != i11; i12++) {
                arrayList.add(AsrWordInfo.CREATOR.createFromParcel(parcel));
            }
            return new AsrUtterance(j10, i10, string, j11, j12, string2, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AsrUtterance[] newArray(int i10) {
            return new AsrUtterance[i10];
        }
    }

    public AsrUtterance(long j10, int i10, String text, long j11, long j12, String speakerId, List<AsrWordInfo> words) {
        p.i(text, "text");
        p.i(speakerId, "speakerId");
        p.i(words, "words");
        this.fd = j10;
        this.index = i10;
        this.text = text;
        this.startTime = j11;
        this.endTime = j12;
        this.speakerId = speakerId;
        this.words = words;
    }

    public static /* synthetic */ AsrUtterance copy$default(AsrUtterance asrUtterance, long j10, int i10, String str, long j11, long j12, String str2, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            j10 = asrUtterance.fd;
        }
        long j13 = j10;
        if ((i11 & 2) != 0) {
            i10 = asrUtterance.index;
        }
        int i12 = i10;
        if ((i11 & 4) != 0) {
            str = asrUtterance.text;
        }
        return asrUtterance.copy(j13, i12, str, (i11 & 8) != 0 ? asrUtterance.startTime : j11, (i11 & 16) != 0 ? asrUtterance.endTime : j12, (i11 & 32) != 0 ? asrUtterance.speakerId : str2, (i11 & 64) != 0 ? asrUtterance.words : list);
    }

    /* renamed from: component1, reason: from getter */
    public final long getFd() {
        return this.fd;
    }

    /* renamed from: component2, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    /* renamed from: component3, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: component4, reason: from getter */
    public final long getStartTime() {
        return this.startTime;
    }

    /* renamed from: component5, reason: from getter */
    public final long getEndTime() {
        return this.endTime;
    }

    /* renamed from: component6, reason: from getter */
    public final String getSpeakerId() {
        return this.speakerId;
    }

    public final List<AsrWordInfo> component7() {
        return this.words;
    }

    public final AsrUtterance copy(long fd, int index, String text, long startTime, long endTime, String speakerId, List<AsrWordInfo> words) {
        p.i(text, "text");
        p.i(speakerId, "speakerId");
        p.i(words, "words");
        return new AsrUtterance(fd, index, text, startTime, endTime, speakerId, words);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AsrUtterance)) {
            return false;
        }
        AsrUtterance asrUtterance = (AsrUtterance) other;
        return this.fd == asrUtterance.fd && this.index == asrUtterance.index && p.d(this.text, asrUtterance.text) && this.startTime == asrUtterance.startTime && this.endTime == asrUtterance.endTime && p.d(this.speakerId, asrUtterance.speakerId) && p.d(this.words, asrUtterance.words);
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final long getFd() {
        return this.fd;
    }

    public final int getIndex() {
        return this.index;
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

    public final List<AsrWordInfo> getWords() {
        return this.words;
    }

    public int hashCode() {
        return (((((((((((Long.hashCode(this.fd) * 31) + Integer.hashCode(this.index)) * 31) + this.text.hashCode()) * 31) + Long.hashCode(this.startTime)) * 31) + Long.hashCode(this.endTime)) * 31) + this.speakerId.hashCode()) * 31) + this.words.hashCode();
    }

    public String toString() {
        return "AsrUtterance(fd=" + this.fd + ", index=" + this.index + ", text=" + this.text + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", speakerId=" + this.speakerId + ", words=" + this.words + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        p.i(dest, "dest");
        dest.writeLong(this.fd);
        dest.writeInt(this.index);
        dest.writeString(this.text);
        dest.writeLong(this.startTime);
        dest.writeLong(this.endTime);
        dest.writeString(this.speakerId);
        List<AsrWordInfo> list = this.words;
        dest.writeInt(list.size());
        Iterator<AsrWordInfo> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(dest, flags);
        }
    }

    public /* synthetic */ AsrUtterance(long j10, int i10, String str, long j11, long j12, String str2, List list, int i11, i iVar) {
        this((i11 & 1) != 0 ? 0L : j10, i10, str, j11, j12, (i11 & 32) != 0 ? "" : str2, (i11 & 64) != 0 ? C1173v.m() : list);
    }
}
