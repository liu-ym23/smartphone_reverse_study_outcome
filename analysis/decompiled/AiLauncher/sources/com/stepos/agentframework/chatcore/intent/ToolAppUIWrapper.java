package com.stepos.agentframework.chatcore.intent;

import androidx.annotation.Keep;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/stepos/agentframework/chatcore/intent/ToolAppUIWrapper;", "", "appUI", "Lcom/stepos/agentframework/chatcore/intent/ToolAppUI;", "<init>", "(Lcom/stepos/agentframework/chatcore/intent/ToolAppUI;)V", "getAppUI", "()Lcom/stepos/agentframework/chatcore/intent/ToolAppUI;", "component1", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class ToolAppUIWrapper {
    private final ToolAppUI appUI;

    public ToolAppUIWrapper(ToolAppUI toolAppUI) {
        this.appUI = toolAppUI;
    }

    public static /* synthetic */ ToolAppUIWrapper copy$default(ToolAppUIWrapper toolAppUIWrapper, ToolAppUI toolAppUI, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            toolAppUI = toolAppUIWrapper.appUI;
        }
        return toolAppUIWrapper.copy(toolAppUI);
    }

    /* renamed from: component1, reason: from getter */
    public final ToolAppUI getAppUI() {
        return this.appUI;
    }

    public final ToolAppUIWrapper copy(ToolAppUI appUI) {
        return new ToolAppUIWrapper(appUI);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ToolAppUIWrapper) && kotlin.jvm.internal.p.d(this.appUI, ((ToolAppUIWrapper) other).appUI);
    }

    public final ToolAppUI getAppUI() {
        return this.appUI;
    }

    public int hashCode() {
        ToolAppUI toolAppUI = this.appUI;
        if (toolAppUI == null) {
            return 0;
        }
        return toolAppUI.hashCode();
    }

    public String toString() {
        return "ToolAppUIWrapper(appUI=" + this.appUI + ")";
    }
}
