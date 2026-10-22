package com.stepos.ailauncher.sprite.transport;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u000eJ\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u000eJP\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u000eJ\u0010\u0010\u0019\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0013J\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0013J \u0010$\u001a\u00020#2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b$\u0010%R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010&\u001a\u0004\b'\u0010\u000e\"\u0004\b(\u0010)R\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010&\u001a\u0004\b*\u0010\u000e\"\u0004\b+\u0010)R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010,\u001a\u0004\b-\u0010\u0011\"\u0004\b.\u0010/R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u00100\u001a\u0004\b1\u0010\u0013\"\u0004\b2\u00103R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010&\u001a\u0004\b4\u0010\u000e\"\u0004\b5\u0010)R$\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010&\u001a\u0004\b6\u0010\u000e\"\u0004\b7\u0010)¨\u00068"}, d2 = {"Lcom/stepos/ailauncher/sprite/transport/SpriteStateResult;", "Landroid/os/Parcelable;", "", VoiceWakeupReceiver.EXTRA_STATE, "bubbleTxt", "", "holdMills", "", "priority", "fallbackState", "fallbackTxt", "<init>", "(Ljava/lang/String;Ljava/lang/String;JILjava/lang/String;Ljava/lang/String;)V", "component1", "()Ljava/lang/String;", "component2", "component3", "()J", "component4", "()I", "component5", "component6", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/lang/String;JILjava/lang/String;Ljava/lang/String;)Lcom/stepos/ailauncher/sprite/transport/SpriteStateResult;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getState", "setState", "(Ljava/lang/String;)V", "getBubbleTxt", "setBubbleTxt", "J", "getHoldMills", "setHoldMills", "(J)V", "I", "getPriority", "setPriority", "(I)V", "getFallbackState", "setFallbackState", "getFallbackTxt", "setFallbackTxt", "sprite-transport-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SpriteStateResult implements Parcelable {
    public static final Parcelable.Creator<SpriteStateResult> CREATOR = new Creator();
    private String bubbleTxt;
    private String fallbackState;
    private String fallbackTxt;
    private long holdMills;
    private int priority;
    private String state;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SpriteStateResult> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SpriteStateResult createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            return new SpriteStateResult(parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readInt(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SpriteStateResult[] newArray(int i10) {
            return new SpriteStateResult[i10];
        }
    }

    public SpriteStateResult(String state, String bubbleTxt, long j10, int i10, String str, String str2) {
        p.i(state, "state");
        p.i(bubbleTxt, "bubbleTxt");
        this.state = state;
        this.bubbleTxt = bubbleTxt;
        this.holdMills = j10;
        this.priority = i10;
        this.fallbackState = str;
        this.fallbackTxt = str2;
    }

    public static /* synthetic */ SpriteStateResult copy$default(SpriteStateResult spriteStateResult, String str, String str2, long j10, int i10, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = spriteStateResult.state;
        }
        if ((i11 & 2) != 0) {
            str2 = spriteStateResult.bubbleTxt;
        }
        if ((i11 & 4) != 0) {
            j10 = spriteStateResult.holdMills;
        }
        if ((i11 & 8) != 0) {
            i10 = spriteStateResult.priority;
        }
        if ((i11 & 16) != 0) {
            str3 = spriteStateResult.fallbackState;
        }
        if ((i11 & 32) != 0) {
            str4 = spriteStateResult.fallbackTxt;
        }
        String str5 = str4;
        int i12 = i10;
        long j11 = j10;
        return spriteStateResult.copy(str, str2, j11, i12, str3, str5);
    }

    /* renamed from: component1, reason: from getter */
    public final String getState() {
        return this.state;
    }

    /* renamed from: component2, reason: from getter */
    public final String getBubbleTxt() {
        return this.bubbleTxt;
    }

    /* renamed from: component3, reason: from getter */
    public final long getHoldMills() {
        return this.holdMills;
    }

    /* renamed from: component4, reason: from getter */
    public final int getPriority() {
        return this.priority;
    }

    /* renamed from: component5, reason: from getter */
    public final String getFallbackState() {
        return this.fallbackState;
    }

    /* renamed from: component6, reason: from getter */
    public final String getFallbackTxt() {
        return this.fallbackTxt;
    }

    public final SpriteStateResult copy(String state, String bubbleTxt, long holdMills, int priority, String fallbackState, String fallbackTxt) {
        p.i(state, "state");
        p.i(bubbleTxt, "bubbleTxt");
        return new SpriteStateResult(state, bubbleTxt, holdMills, priority, fallbackState, fallbackTxt);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SpriteStateResult)) {
            return false;
        }
        SpriteStateResult spriteStateResult = (SpriteStateResult) other;
        return p.d(this.state, spriteStateResult.state) && p.d(this.bubbleTxt, spriteStateResult.bubbleTxt) && this.holdMills == spriteStateResult.holdMills && this.priority == spriteStateResult.priority && p.d(this.fallbackState, spriteStateResult.fallbackState) && p.d(this.fallbackTxt, spriteStateResult.fallbackTxt);
    }

    public final String getBubbleTxt() {
        return this.bubbleTxt;
    }

    public final String getFallbackState() {
        return this.fallbackState;
    }

    public final String getFallbackTxt() {
        return this.fallbackTxt;
    }

    public final long getHoldMills() {
        return this.holdMills;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final String getState() {
        return this.state;
    }

    public int hashCode() {
        int iHashCode = ((((((this.state.hashCode() * 31) + this.bubbleTxt.hashCode()) * 31) + Long.hashCode(this.holdMills)) * 31) + Integer.hashCode(this.priority)) * 31;
        String str = this.fallbackState;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.fallbackTxt;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setBubbleTxt(String str) {
        p.i(str, "<set-?>");
        this.bubbleTxt = str;
    }

    public final void setFallbackState(String str) {
        this.fallbackState = str;
    }

    public final void setFallbackTxt(String str) {
        this.fallbackTxt = str;
    }

    public final void setHoldMills(long j10) {
        this.holdMills = j10;
    }

    public final void setPriority(int i10) {
        this.priority = i10;
    }

    public final void setState(String str) {
        p.i(str, "<set-?>");
        this.state = str;
    }

    public String toString() {
        return "SpriteStateResult(state=" + this.state + ", bubbleTxt=" + this.bubbleTxt + ", holdMills=" + this.holdMills + ", priority=" + this.priority + ", fallbackState=" + this.fallbackState + ", fallbackTxt=" + this.fallbackTxt + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        p.i(parcel, "out");
        parcel.writeString(this.state);
        parcel.writeString(this.bubbleTxt);
        parcel.writeLong(this.holdMills);
        parcel.writeInt(this.priority);
        parcel.writeString(this.fallbackState);
        parcel.writeString(this.fallbackTxt);
    }

    public /* synthetic */ SpriteStateResult(String str, String str2, long j10, int i10, String str3, String str4, int i11, i iVar) {
        this(str, (i11 & 2) != 0 ? "" : str2, (i11 & 4) != 0 ? 0L : j10, (i11 & 8) != 0 ? 0 : i10, (i11 & 16) != 0 ? null : str3, (i11 & 32) != 0 ? null : str4);
    }
}
