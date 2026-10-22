package com.stepos.aiengine.algorithm.sla;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ0\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u000fJ\u0010\u0010\u0013\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ\u001a\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\rR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u000f¨\u0006 "}, d2 = {"Lcom/stepos/aiengine/algorithm/sla/SlaExecutability;", "", "", "canExecute", "", "errorCode", "", "reason", "<init>", "(ZILjava/lang/String;)V", "component1", "()Z", "component2", "()I", "component3", "()Ljava/lang/String;", ChatTracker.CLICK_COPY, "(ZILjava/lang/String;)Lcom/stepos/aiengine/algorithm/sla/SlaExecutability;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Z", "getCanExecute", Const.INTENT_KEY_PKGNAME, "I", "getErrorCode", "c", "Ljava/lang/String;", "getReason", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class SlaExecutability {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean canExecute;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final int errorCode;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final String reason;

    public SlaExecutability(boolean z10, int i10, String str) {
        this.canExecute = z10;
        this.errorCode = i10;
        this.reason = str;
    }

    public static /* synthetic */ SlaExecutability copy$default(SlaExecutability slaExecutability, boolean z10, int i10, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = slaExecutability.canExecute;
        }
        if ((i11 & 2) != 0) {
            i10 = slaExecutability.errorCode;
        }
        if ((i11 & 4) != 0) {
            str = slaExecutability.reason;
        }
        return slaExecutability.copy(z10, i10, str);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getCanExecute() {
        return this.canExecute;
    }

    /* renamed from: component2, reason: from getter */
    public final int getErrorCode() {
        return this.errorCode;
    }

    /* renamed from: component3, reason: from getter */
    public final String getReason() {
        return this.reason;
    }

    public final SlaExecutability copy(boolean canExecute, int errorCode, String reason) {
        return new SlaExecutability(canExecute, errorCode, reason);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SlaExecutability)) {
            return false;
        }
        SlaExecutability slaExecutability = (SlaExecutability) other;
        return this.canExecute == slaExecutability.canExecute && this.errorCode == slaExecutability.errorCode && p.d(this.reason, slaExecutability.reason);
    }

    public final boolean getCanExecute() {
        return this.canExecute;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getReason() {
        return this.reason;
    }

    public int hashCode() {
        int iHashCode = ((Boolean.hashCode(this.canExecute) * 31) + Integer.hashCode(this.errorCode)) * 31;
        String str = this.reason;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "SlaExecutability(canExecute=" + this.canExecute + ", errorCode=" + this.errorCode + ", reason=" + this.reason + ")";
    }

    public /* synthetic */ SlaExecutability(boolean z10, int i10, String str, int i11, i iVar) {
        this(z10, (i11 & 2) != 0 ? 0 : i10, (i11 & 4) != 0 ? null : str);
    }
}
