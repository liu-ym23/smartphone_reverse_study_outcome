package com.stepos.agentframework.adapter.bff;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J5\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/stepos/agentframework/adapter/bff/BffRouter;", "", "bizModule", "", "bizCommand", "aiModule", "aiCommand", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBizModule", "()Ljava/lang/String;", "getBizCommand", "getAiModule", "getAiCommand", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "bff_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class BffRouter {
    private final String aiCommand;
    private final String aiModule;
    private final String bizCommand;
    private final String bizModule;

    public BffRouter(String bizModule, String bizCommand, String str, String str2) {
        k.f(bizModule, "bizModule");
        k.f(bizCommand, "bizCommand");
        this.bizModule = bizModule;
        this.bizCommand = bizCommand;
        this.aiModule = str;
        this.aiCommand = str2;
    }

    public static /* synthetic */ BffRouter copy$default(BffRouter bffRouter, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bffRouter.bizModule;
        }
        if ((i & 2) != 0) {
            str2 = bffRouter.bizCommand;
        }
        if ((i & 4) != 0) {
            str3 = bffRouter.aiModule;
        }
        if ((i & 8) != 0) {
            str4 = bffRouter.aiCommand;
        }
        return bffRouter.copy(str, str2, str3, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getBizModule() {
        return this.bizModule;
    }

    /* renamed from: component2, reason: from getter */
    public final String getBizCommand() {
        return this.bizCommand;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAiModule() {
        return this.aiModule;
    }

    /* renamed from: component4, reason: from getter */
    public final String getAiCommand() {
        return this.aiCommand;
    }

    public final BffRouter copy(String bizModule, String bizCommand, String aiModule, String aiCommand) {
        k.f(bizModule, "bizModule");
        k.f(bizCommand, "bizCommand");
        return new BffRouter(bizModule, bizCommand, aiModule, aiCommand);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BffRouter)) {
            return false;
        }
        BffRouter bffRouter = (BffRouter) other;
        return k.b(this.bizModule, bffRouter.bizModule) && k.b(this.bizCommand, bffRouter.bizCommand) && k.b(this.aiModule, bffRouter.aiModule) && k.b(this.aiCommand, bffRouter.aiCommand);
    }

    public final String getAiCommand() {
        return this.aiCommand;
    }

    public final String getAiModule() {
        return this.aiModule;
    }

    public final String getBizCommand() {
        return this.bizCommand;
    }

    public final String getBizModule() {
        return this.bizModule;
    }

    public int hashCode() {
        int iC = B7.a.c(this.bizModule.hashCode() * 31, 31, this.bizCommand);
        String str = this.aiModule;
        int iHashCode = (iC + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.aiCommand;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        String str = this.bizModule;
        String str2 = this.bizCommand;
        return androidx.appfunctions.metadata.a.p(B7.a.w("BffRouter(bizModule=", str, ", bizCommand=", str2, ", aiModule="), this.aiModule, ", aiCommand=", this.aiCommand, ")");
    }

    public /* synthetic */ BffRouter(String str, String str2, String str3, String str4, int i, e eVar) {
        this(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
    }
}
