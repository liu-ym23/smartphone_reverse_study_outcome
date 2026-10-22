package com.stepos.ailauncher.chat.model;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\nHÆ\u0003JK\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/stepos/ailauncher/chat/model/ActionBar;", "", "name", "", "label", "icon", DidiCardProvider.KEY_ITEMS, "", "Lcom/stepos/ailauncher/chat/model/ActionItem;", "trigger", "Lcom/stepos/ailauncher/chat/model/ActionTrigger;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/stepos/ailauncher/chat/model/ActionTrigger;)V", "getName", "()Ljava/lang/String;", "getLabel", "getIcon", "getItems", "()Ljava/util/List;", "getTrigger", "()Lcom/stepos/ailauncher/chat/model/ActionTrigger;", "component1", "component2", "component3", "component4", "component5", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ActionBar {
    private final String icon;
    private final List<ActionItem> items;
    private final String label;
    private final String name;
    private final ActionTrigger trigger;

    public ActionBar() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ ActionBar copy$default(ActionBar actionBar, String str, String str2, String str3, List list, ActionTrigger actionTrigger, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = actionBar.name;
        }
        if ((i10 & 2) != 0) {
            str2 = actionBar.label;
        }
        if ((i10 & 4) != 0) {
            str3 = actionBar.icon;
        }
        if ((i10 & 8) != 0) {
            list = actionBar.items;
        }
        if ((i10 & 16) != 0) {
            actionTrigger = actionBar.trigger;
        }
        ActionTrigger actionTrigger2 = actionTrigger;
        String str4 = str3;
        return actionBar.copy(str, str2, str4, list, actionTrigger2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* renamed from: component3, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    public final List<ActionItem> component4() {
        return this.items;
    }

    /* renamed from: component5, reason: from getter */
    public final ActionTrigger getTrigger() {
        return this.trigger;
    }

    public final ActionBar copy(String name, String label, String icon, List<ActionItem> items, ActionTrigger trigger) {
        return new ActionBar(name, label, icon, items, trigger);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActionBar)) {
            return false;
        }
        ActionBar actionBar = (ActionBar) other;
        return p.d(this.name, actionBar.name) && p.d(this.label, actionBar.label) && p.d(this.icon, actionBar.icon) && p.d(this.items, actionBar.items) && p.d(this.trigger, actionBar.trigger);
    }

    public final String getIcon() {
        return this.icon;
    }

    public final List<ActionItem> getItems() {
        return this.items;
    }

    public final String getLabel() {
        return this.label;
    }

    public final String getName() {
        return this.name;
    }

    public final ActionTrigger getTrigger() {
        return this.trigger;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.label;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.icon;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<ActionItem> list = this.items;
        int iHashCode4 = (iHashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        ActionTrigger actionTrigger = this.trigger;
        return iHashCode4 + (actionTrigger != null ? actionTrigger.hashCode() : 0);
    }

    public String toString() {
        return "ActionBar(name=" + this.name + ", label=" + this.label + ", icon=" + this.icon + ", items=" + this.items + ", trigger=" + this.trigger + ")";
    }

    public ActionBar(String str, String str2, String str3, List<ActionItem> list, ActionTrigger actionTrigger) {
        this.name = str;
        this.label = str2;
        this.icon = str3;
        this.items = list;
        this.trigger = actionTrigger;
    }

    public /* synthetic */ ActionBar(String str, String str2, String str3, List list, ActionTrigger actionTrigger, int i10, i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : list, (i10 & 16) != 0 ? null : actionTrigger);
    }
}
