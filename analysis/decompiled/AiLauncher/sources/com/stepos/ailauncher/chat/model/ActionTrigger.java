package com.stepos.ailauncher.chat.model;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/chat/model/ActionTrigger;", "", "type", "", "baseMessage", "modelName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "getBaseMessage", "getModelName", "component1", "component2", "component3", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ActionTrigger {
    private final String baseMessage;
    private final String modelName;
    private final String type;

    public ActionTrigger() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ ActionTrigger copy$default(ActionTrigger actionTrigger, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = actionTrigger.type;
        }
        if ((i10 & 2) != 0) {
            str2 = actionTrigger.baseMessage;
        }
        if ((i10 & 4) != 0) {
            str3 = actionTrigger.modelName;
        }
        return actionTrigger.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final String getBaseMessage() {
        return this.baseMessage;
    }

    /* renamed from: component3, reason: from getter */
    public final String getModelName() {
        return this.modelName;
    }

    public final ActionTrigger copy(String type, String baseMessage, String modelName) {
        return new ActionTrigger(type, baseMessage, modelName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActionTrigger)) {
            return false;
        }
        ActionTrigger actionTrigger = (ActionTrigger) other;
        return p.d(this.type, actionTrigger.type) && p.d(this.baseMessage, actionTrigger.baseMessage) && p.d(this.modelName, actionTrigger.modelName);
    }

    public final String getBaseMessage() {
        return this.baseMessage;
    }

    public final String getModelName() {
        return this.modelName;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.type;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.baseMessage;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.modelName;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "ActionTrigger(type=" + this.type + ", baseMessage=" + this.baseMessage + ", modelName=" + this.modelName + ")";
    }

    public ActionTrigger(String str, String str2, String str3) {
        this.type = str;
        this.baseMessage = str2;
        this.modelName = str3;
    }

    public /* synthetic */ ActionTrigger(String str, String str2, String str3, int i10, i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3);
    }
}
