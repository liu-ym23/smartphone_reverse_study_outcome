package com.stepos.ailauncher.foundation.sprite.bean;

import L4.l;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b.\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0011J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0013J\u0010\u0010\u001a\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJZ\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\r\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0013J\u0010\u0010\u001f\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0017J\u001a\u0010!\u001a\u00020\f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b!\u0010\"R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010#\u001a\u0004\b$\u0010\u0011\"\u0004\b%\u0010&R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010'\u001a\u0004\b(\u0010\u0013\"\u0004\b)\u0010*R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010+\u001a\u0004\b,\u0010\u0015\"\u0004\b-\u0010.R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010/\u001a\u0004\b0\u0010\u0017\"\u0004\b1\u00102R$\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010#\u001a\u0004\b3\u0010\u0011\"\u0004\b4\u0010&R$\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010'\u001a\u0004\b5\u0010\u0013\"\u0004\b6\u0010*R\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u00107\u001a\u0004\b\r\u0010\u001b\"\u0004\b8\u00109¨\u0006:"}, d2 = {"Lcom/stepos/ailauncher/foundation/sprite/bean/SpriteStateResult;", "", "LL4/l;", VoiceWakeupReceiver.EXTRA_STATE, "", "bubble", "", "holdMills", "", "priority", "fallbackState", "fallbackBubbleTxt", "", "isIdleTxt", "<init>", "(LL4/l;Ljava/lang/String;JILL4/l;Ljava/lang/String;Z)V", "component1", "()LL4/l;", "component2", "()Ljava/lang/String;", "component3", "()J", "component4", "()I", "component5", "component6", "component7", "()Z", ChatTracker.CLICK_COPY, "(LL4/l;Ljava/lang/String;JILL4/l;Ljava/lang/String;Z)Lcom/stepos/ailauncher/foundation/sprite/bean/SpriteStateResult;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "LL4/l;", "getState", "setState", "(LL4/l;)V", "Ljava/lang/String;", "getBubble", "setBubble", "(Ljava/lang/String;)V", "J", "getHoldMills", "setHoldMills", "(J)V", "I", "getPriority", "setPriority", "(I)V", "getFallbackState", "setFallbackState", "getFallbackBubbleTxt", "setFallbackBubbleTxt", "Z", "setIdleTxt", "(Z)V", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SpriteStateResult {
    private String bubble;
    private String fallbackBubbleTxt;
    private l fallbackState;
    private long holdMills;
    private boolean isIdleTxt;
    private int priority;
    private l state;

    public SpriteStateResult(l state, String bubble, long j10, int i10, l lVar, String str, boolean z10) {
        p.i(state, "state");
        p.i(bubble, "bubble");
        this.state = state;
        this.bubble = bubble;
        this.holdMills = j10;
        this.priority = i10;
        this.fallbackState = lVar;
        this.fallbackBubbleTxt = str;
        this.isIdleTxt = z10;
    }

    public static /* synthetic */ SpriteStateResult copy$default(SpriteStateResult spriteStateResult, l lVar, String str, long j10, int i10, l lVar2, String str2, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            lVar = spriteStateResult.state;
        }
        if ((i11 & 2) != 0) {
            str = spriteStateResult.bubble;
        }
        if ((i11 & 4) != 0) {
            j10 = spriteStateResult.holdMills;
        }
        if ((i11 & 8) != 0) {
            i10 = spriteStateResult.priority;
        }
        if ((i11 & 16) != 0) {
            lVar2 = spriteStateResult.fallbackState;
        }
        if ((i11 & 32) != 0) {
            str2 = spriteStateResult.fallbackBubbleTxt;
        }
        if ((i11 & 64) != 0) {
            z10 = spriteStateResult.isIdleTxt;
        }
        long j11 = j10;
        return spriteStateResult.copy(lVar, str, j11, i10, lVar2, str2, z10);
    }

    /* renamed from: component1, reason: from getter */
    public final l getState() {
        return this.state;
    }

    /* renamed from: component2, reason: from getter */
    public final String getBubble() {
        return this.bubble;
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
    public final l getFallbackState() {
        return this.fallbackState;
    }

    /* renamed from: component6, reason: from getter */
    public final String getFallbackBubbleTxt() {
        return this.fallbackBubbleTxt;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getIsIdleTxt() {
        return this.isIdleTxt;
    }

    public final SpriteStateResult copy(l state, String bubble, long holdMills, int priority, l fallbackState, String fallbackBubbleTxt, boolean isIdleTxt) {
        p.i(state, "state");
        p.i(bubble, "bubble");
        return new SpriteStateResult(state, bubble, holdMills, priority, fallbackState, fallbackBubbleTxt, isIdleTxt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SpriteStateResult)) {
            return false;
        }
        SpriteStateResult spriteStateResult = (SpriteStateResult) other;
        return p.d(this.state, spriteStateResult.state) && p.d(this.bubble, spriteStateResult.bubble) && this.holdMills == spriteStateResult.holdMills && this.priority == spriteStateResult.priority && p.d(this.fallbackState, spriteStateResult.fallbackState) && p.d(this.fallbackBubbleTxt, spriteStateResult.fallbackBubbleTxt) && this.isIdleTxt == spriteStateResult.isIdleTxt;
    }

    public final String getBubble() {
        return this.bubble;
    }

    public final String getFallbackBubbleTxt() {
        return this.fallbackBubbleTxt;
    }

    public final l getFallbackState() {
        return this.fallbackState;
    }

    public final long getHoldMills() {
        return this.holdMills;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final l getState() {
        return this.state;
    }

    public int hashCode() {
        int iHashCode = ((((((this.state.hashCode() * 31) + this.bubble.hashCode()) * 31) + Long.hashCode(this.holdMills)) * 31) + Integer.hashCode(this.priority)) * 31;
        l lVar = this.fallbackState;
        int iHashCode2 = (iHashCode + (lVar == null ? 0 : lVar.hashCode())) * 31;
        String str = this.fallbackBubbleTxt;
        return ((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31) + Boolean.hashCode(this.isIdleTxt);
    }

    public final boolean isIdleTxt() {
        return this.isIdleTxt;
    }

    public final void setBubble(String str) {
        p.i(str, "<set-?>");
        this.bubble = str;
    }

    public final void setFallbackBubbleTxt(String str) {
        this.fallbackBubbleTxt = str;
    }

    public final void setFallbackState(l lVar) {
        this.fallbackState = lVar;
    }

    public final void setHoldMills(long j10) {
        this.holdMills = j10;
    }

    public final void setIdleTxt(boolean z10) {
        this.isIdleTxt = z10;
    }

    public final void setPriority(int i10) {
        this.priority = i10;
    }

    public final void setState(l lVar) {
        p.i(lVar, "<set-?>");
        this.state = lVar;
    }

    public String toString() {
        return "SpriteStateResult(state=" + this.state + ", bubble=" + this.bubble + ", holdMills=" + this.holdMills + ", priority=" + this.priority + ", fallbackState=" + this.fallbackState + ", fallbackBubbleTxt=" + this.fallbackBubbleTxt + ", isIdleTxt=" + this.isIdleTxt + ")";
    }

    public /* synthetic */ SpriteStateResult(l lVar, String str, long j10, int i10, l lVar2, String str2, boolean z10, int i11, i iVar) {
        this(lVar, (i11 & 2) != 0 ? "" : str, (i11 & 4) != 0 ? 0L : j10, (i11 & 8) != 0 ? 0 : i10, (i11 & 16) != 0 ? null : lVar2, (i11 & 32) == 0 ? str2 : null, (i11 & 64) != 0 ? false : z10);
    }
}
