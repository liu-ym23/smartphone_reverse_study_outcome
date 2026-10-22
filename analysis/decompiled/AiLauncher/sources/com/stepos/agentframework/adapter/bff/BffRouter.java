package com.stepos.agentframework.adapter.bff;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\nR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0014\u0010\nR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0015\u0010\nR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0016\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/stepos/agentframework/adapter/bff/k;", "", "", "bizModule", "bizCommand", "aiModule", "aiCommand", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_UMID, "c", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "protocol_bff_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.adapter.bff.k, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class BffRouter {
    private final String aiCommand;
    private final String aiModule;
    private final String bizCommand;
    private final String bizModule;

    public BffRouter(String bizModule, String bizCommand, String str, String str2) {
        kotlin.jvm.internal.p.i(bizModule, "bizModule");
        kotlin.jvm.internal.p.i(bizCommand, "bizCommand");
        this.bizModule = bizModule;
        this.bizCommand = bizCommand;
        this.aiModule = str;
        this.aiCommand = str2;
    }

    /* renamed from: a, reason: from getter */
    public final String getAiCommand() {
        return this.aiCommand;
    }

    /* renamed from: b, reason: from getter */
    public final String getAiModule() {
        return this.aiModule;
    }

    /* renamed from: c, reason: from getter */
    public final String getBizCommand() {
        return this.bizCommand;
    }

    /* renamed from: d, reason: from getter */
    public final String getBizModule() {
        return this.bizModule;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BffRouter)) {
            return false;
        }
        BffRouter bffRouter = (BffRouter) other;
        return kotlin.jvm.internal.p.d(this.bizModule, bffRouter.bizModule) && kotlin.jvm.internal.p.d(this.bizCommand, bffRouter.bizCommand) && kotlin.jvm.internal.p.d(this.aiModule, bffRouter.aiModule) && kotlin.jvm.internal.p.d(this.aiCommand, bffRouter.aiCommand);
    }

    public int hashCode() {
        int iHashCode = ((this.bizModule.hashCode() * 31) + this.bizCommand.hashCode()) * 31;
        String str = this.aiModule;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.aiCommand;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "BffRouter(bizModule=" + this.bizModule + ", bizCommand=" + this.bizCommand + ", aiModule=" + this.aiModule + ", aiCommand=" + this.aiCommand + ")";
    }

    public /* synthetic */ BffRouter(String str, String str2, String str3, String str4, int i10, kotlin.jvm.internal.i iVar) {
        this(str, str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4);
    }
}
