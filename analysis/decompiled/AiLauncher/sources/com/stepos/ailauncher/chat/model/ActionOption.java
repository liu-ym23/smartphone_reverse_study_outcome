package com.stepos.ailauncher.chat.model;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/stepos/ailauncher/chat/model/ActionOption;", "", "label", "", "values", "", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getLabel", "()Ljava/lang/String;", "getValues", "()Ljava/util/List;", "component1", "component2", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ActionOption {
    private final String label;
    private final List<String> values;

    /* JADX WARN: Multi-variable type inference failed */
    public ActionOption() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ActionOption copy$default(ActionOption actionOption, String str, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = actionOption.label;
        }
        if ((i10 & 2) != 0) {
            list = actionOption.values;
        }
        return actionOption.copy(str, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    public final List<String> component2() {
        return this.values;
    }

    public final ActionOption copy(String label, List<String> values) {
        return new ActionOption(label, values);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActionOption)) {
            return false;
        }
        ActionOption actionOption = (ActionOption) other;
        return p.d(this.label, actionOption.label) && p.d(this.values, actionOption.values);
    }

    public final String getLabel() {
        return this.label;
    }

    public final List<String> getValues() {
        return this.values;
    }

    public int hashCode() {
        String str = this.label;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<String> list = this.values;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "ActionOption(label=" + this.label + ", values=" + this.values + ")";
    }

    public ActionOption(String str, List<String> list) {
        this.label = str;
        this.values = list;
    }

    public /* synthetic */ ActionOption(String str, List list, int i10, i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : list);
    }
}
