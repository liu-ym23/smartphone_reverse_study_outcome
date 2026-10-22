package com.stepos.ailauncher.chat.model;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J8\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/stepos/ailauncher/chat/model/ActionItem;", "", "title", "", "requiredFlag", "", "components", "", "Lcom/stepos/ailauncher/chat/model/ActionComponent;", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;)V", "getTitle", "()Ljava/lang/String;", "getRequiredFlag", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getComponents", "()Ljava/util/List;", "component1", "component2", "component3", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;)Lcom/stepos/ailauncher/chat/model/ActionItem;", "equals", "other", "hashCode", "", "toString", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ActionItem {
    private final List<ActionComponent> components;
    private final Boolean requiredFlag;
    private final String title;

    public ActionItem() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ActionItem copy$default(ActionItem actionItem, String str, Boolean bool, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = actionItem.title;
        }
        if ((i10 & 2) != 0) {
            bool = actionItem.requiredFlag;
        }
        if ((i10 & 4) != 0) {
            list = actionItem.components;
        }
        return actionItem.copy(str, bool, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component2, reason: from getter */
    public final Boolean getRequiredFlag() {
        return this.requiredFlag;
    }

    public final List<ActionComponent> component3() {
        return this.components;
    }

    public final ActionItem copy(String title, Boolean requiredFlag, List<ActionComponent> components) {
        return new ActionItem(title, requiredFlag, components);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActionItem)) {
            return false;
        }
        ActionItem actionItem = (ActionItem) other;
        return p.d(this.title, actionItem.title) && p.d(this.requiredFlag, actionItem.requiredFlag) && p.d(this.components, actionItem.components);
    }

    public final List<ActionComponent> getComponents() {
        return this.components;
    }

    public final Boolean getRequiredFlag() {
        return this.requiredFlag;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Boolean bool = this.requiredFlag;
        int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        List<ActionComponent> list = this.components;
        return iHashCode2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "ActionItem(title=" + this.title + ", requiredFlag=" + this.requiredFlag + ", components=" + this.components + ")";
    }

    public ActionItem(String str, Boolean bool, List<ActionComponent> list) {
        this.title = str;
        this.requiredFlag = bool;
        this.components = list;
    }

    public /* synthetic */ ActionItem(String str, Boolean bool, List list, int i10, i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : bool, (i10 & 4) != 0 ? null : list);
    }
}
