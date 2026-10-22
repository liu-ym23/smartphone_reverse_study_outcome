package com.stepos.ability.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u000e\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000e¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u001f\u0010\u001eJ\u0010\u0010 \u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b \u0010\u001bJV\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b#\u0010\u001bJ\u0010\u0010$\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b$\u0010\u0010J\u001a\u0010'\u001a\u00020\u00022\b\u0010&\u001a\u0004\u0018\u00010%HÖ\u0003¢\u0006\u0004\b'\u0010(R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010)\u001a\u0004\b*\u0010\u0018R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010)\u001a\u0004\b+\u0010\u0018R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010,\u001a\u0004\b-\u0010\u001bR\u0017\u0010\u0007\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010,\u001a\u0004\b.\u0010\u001bR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010/\u001a\u0004\b0\u0010\u001eR\u0017\u0010\n\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\n\u0010/\u001a\u0004\b1\u0010\u001eR\u0017\u0010\u000b\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u000b\u0010,\u001a\u0004\b2\u0010\u001b¨\u00063"}, d2 = {"Lcom/stepos/ability/bean/MainDisplayTopAppHistory;", "Landroid/os/Parcelable;", "", "watching", "changed", "", "baselinePackage", "currentPackage", "", "baselineAt", "lastChangeAt", "chatSessionId", "<init>", "(ZZLjava/lang/String;Ljava/lang/String;JJLjava/lang/String;)V", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "component1", "()Z", "component2", "component3", "()Ljava/lang/String;", "component4", "component5", "()J", "component6", "component7", ChatTracker.CLICK_COPY, "(ZZLjava/lang/String;Ljava/lang/String;JJLjava/lang/String;)Lcom/stepos/ability/bean/MainDisplayTopAppHistory;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getWatching", "getChanged", "Ljava/lang/String;", "getBaselinePackage", "getCurrentPackage", "J", "getBaselineAt", "getLastChangeAt", "getChatSessionId", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class MainDisplayTopAppHistory implements Parcelable {
    public static final Parcelable.Creator<MainDisplayTopAppHistory> CREATOR = new a();
    private final long baselineAt;
    private final String baselinePackage;
    private final boolean changed;
    private final String chatSessionId;
    private final String currentPackage;
    private final long lastChangeAt;
    private final boolean watching;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<MainDisplayTopAppHistory> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MainDisplayTopAppHistory createFromParcel(Parcel parcel) {
            boolean z10;
            p.i(parcel, "parcel");
            boolean z11 = false;
            if (parcel.readInt() != 0) {
                z10 = false;
                z11 = true;
            } else {
                z10 = false;
            }
            return new MainDisplayTopAppHistory(z11, parcel.readInt() == 0 ? z10 : true, parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readLong(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final MainDisplayTopAppHistory[] newArray(int i10) {
            return new MainDisplayTopAppHistory[i10];
        }
    }

    public MainDisplayTopAppHistory(boolean z10, boolean z11, String baselinePackage, String currentPackage, long j10, long j11, String chatSessionId) {
        p.i(baselinePackage, "baselinePackage");
        p.i(currentPackage, "currentPackage");
        p.i(chatSessionId, "chatSessionId");
        this.watching = z10;
        this.changed = z11;
        this.baselinePackage = baselinePackage;
        this.currentPackage = currentPackage;
        this.baselineAt = j10;
        this.lastChangeAt = j11;
        this.chatSessionId = chatSessionId;
    }

    public static /* synthetic */ MainDisplayTopAppHistory copy$default(MainDisplayTopAppHistory mainDisplayTopAppHistory, boolean z10, boolean z11, String str, String str2, long j10, long j11, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = mainDisplayTopAppHistory.watching;
        }
        if ((i10 & 2) != 0) {
            z11 = mainDisplayTopAppHistory.changed;
        }
        if ((i10 & 4) != 0) {
            str = mainDisplayTopAppHistory.baselinePackage;
        }
        if ((i10 & 8) != 0) {
            str2 = mainDisplayTopAppHistory.currentPackage;
        }
        if ((i10 & 16) != 0) {
            j10 = mainDisplayTopAppHistory.baselineAt;
        }
        if ((i10 & 32) != 0) {
            j11 = mainDisplayTopAppHistory.lastChangeAt;
        }
        if ((i10 & 64) != 0) {
            str3 = mainDisplayTopAppHistory.chatSessionId;
        }
        String str4 = str3;
        long j12 = j11;
        long j13 = j10;
        return mainDisplayTopAppHistory.copy(z10, z11, str, str2, j13, j12, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getWatching() {
        return this.watching;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getChanged() {
        return this.changed;
    }

    /* renamed from: component3, reason: from getter */
    public final String getBaselinePackage() {
        return this.baselinePackage;
    }

    /* renamed from: component4, reason: from getter */
    public final String getCurrentPackage() {
        return this.currentPackage;
    }

    /* renamed from: component5, reason: from getter */
    public final long getBaselineAt() {
        return this.baselineAt;
    }

    /* renamed from: component6, reason: from getter */
    public final long getLastChangeAt() {
        return this.lastChangeAt;
    }

    /* renamed from: component7, reason: from getter */
    public final String getChatSessionId() {
        return this.chatSessionId;
    }

    public final MainDisplayTopAppHistory copy(boolean watching, boolean changed, String baselinePackage, String currentPackage, long baselineAt, long lastChangeAt, String chatSessionId) {
        p.i(baselinePackage, "baselinePackage");
        p.i(currentPackage, "currentPackage");
        p.i(chatSessionId, "chatSessionId");
        return new MainDisplayTopAppHistory(watching, changed, baselinePackage, currentPackage, baselineAt, lastChangeAt, chatSessionId);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MainDisplayTopAppHistory)) {
            return false;
        }
        MainDisplayTopAppHistory mainDisplayTopAppHistory = (MainDisplayTopAppHistory) other;
        return this.watching == mainDisplayTopAppHistory.watching && this.changed == mainDisplayTopAppHistory.changed && p.d(this.baselinePackage, mainDisplayTopAppHistory.baselinePackage) && p.d(this.currentPackage, mainDisplayTopAppHistory.currentPackage) && this.baselineAt == mainDisplayTopAppHistory.baselineAt && this.lastChangeAt == mainDisplayTopAppHistory.lastChangeAt && p.d(this.chatSessionId, mainDisplayTopAppHistory.chatSessionId);
    }

    public final long getBaselineAt() {
        return this.baselineAt;
    }

    public final String getBaselinePackage() {
        return this.baselinePackage;
    }

    public final boolean getChanged() {
        return this.changed;
    }

    public final String getChatSessionId() {
        return this.chatSessionId;
    }

    public final String getCurrentPackage() {
        return this.currentPackage;
    }

    public final long getLastChangeAt() {
        return this.lastChangeAt;
    }

    public final boolean getWatching() {
        return this.watching;
    }

    public int hashCode() {
        return (((((((((((Boolean.hashCode(this.watching) * 31) + Boolean.hashCode(this.changed)) * 31) + this.baselinePackage.hashCode()) * 31) + this.currentPackage.hashCode()) * 31) + Long.hashCode(this.baselineAt)) * 31) + Long.hashCode(this.lastChangeAt)) * 31) + this.chatSessionId.hashCode();
    }

    public String toString() {
        return "MainDisplayTopAppHistory(watching=" + this.watching + ", changed=" + this.changed + ", baselinePackage=" + this.baselinePackage + ", currentPackage=" + this.currentPackage + ", baselineAt=" + this.baselineAt + ", lastChangeAt=" + this.lastChangeAt + ", chatSessionId=" + this.chatSessionId + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        p.i(dest, "dest");
        dest.writeInt(this.watching ? 1 : 0);
        dest.writeInt(this.changed ? 1 : 0);
        dest.writeString(this.baselinePackage);
        dest.writeString(this.currentPackage);
        dest.writeLong(this.baselineAt);
        dest.writeLong(this.lastChangeAt);
        dest.writeString(this.chatSessionId);
    }

    public /* synthetic */ MainDisplayTopAppHistory(boolean z10, boolean z11, String str, String str2, long j10, long j11, String str3, int i10, i iVar) {
        this(z10, z11, str, str2, j10, j11, (i10 & 64) != 0 ? "" : str3);
    }
}
