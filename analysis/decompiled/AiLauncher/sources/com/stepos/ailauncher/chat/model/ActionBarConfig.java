package com.stepos.ailauncher.chat.model;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/chat/model/ActionBarConfig;", "", "version", "", "bars", "", "Lcom/stepos/ailauncher/chat/model/ActionBar;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getVersion", "()Ljava/lang/String;", "getBars", "()Ljava/util/List;", "component1", "component2", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ActionBarConfig {
    private final List<ActionBar> bars;
    private final String version;

    /* JADX WARN: Multi-variable type inference failed */
    public ActionBarConfig() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ActionBarConfig copy$default(ActionBarConfig actionBarConfig, String str, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = actionBarConfig.version;
        }
        if ((i10 & 2) != 0) {
            list = actionBarConfig.bars;
        }
        return actionBarConfig.copy(str, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    public final List<ActionBar> component2() {
        return this.bars;
    }

    public final ActionBarConfig copy(String version, List<ActionBar> bars) {
        return new ActionBarConfig(version, bars);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActionBarConfig)) {
            return false;
        }
        ActionBarConfig actionBarConfig = (ActionBarConfig) other;
        return p.d(this.version, actionBarConfig.version) && p.d(this.bars, actionBarConfig.bars);
    }

    public final List<ActionBar> getBars() {
        return this.bars;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        String str = this.version;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<ActionBar> list = this.bars;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "ActionBarConfig(version=" + this.version + ", bars=" + this.bars + ")";
    }

    public ActionBarConfig(String str, List<ActionBar> list) {
        this.version = str;
        this.bars = list;
    }

    public /* synthetic */ ActionBarConfig(String str, List list, int i10, i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : list);
    }
}
