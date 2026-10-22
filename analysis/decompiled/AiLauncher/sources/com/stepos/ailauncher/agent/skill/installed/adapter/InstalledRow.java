package com.stepos.ailauncher.agent.skill.installed.adapter;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.skill.SkillItem;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0018\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/installed/adapter/a;", "", "Lcom/stepos/ailauncher/agent/skill/SkillItem;", "item", "", "isToggling", "isUninstalling", "<init>", "(Lcom/stepos/ailauncher/agent/skill/SkillItem;ZZ)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ailauncher/agent/skill/SkillItem;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/agent/skill/SkillItem;", "Z", Const.INTENT_KEY_PKGNAME, "()Z", "c", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.skill.installed.adapter.a, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class InstalledRow {
    private final boolean isToggling;
    private final boolean isUninstalling;
    private final SkillItem item;

    public InstalledRow(SkillItem item, boolean z10, boolean z11) {
        p.i(item, "item");
        this.item = item;
        this.isToggling = z10;
        this.isUninstalling = z11;
    }

    /* renamed from: a, reason: from getter */
    public final SkillItem getItem() {
        return this.item;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getIsToggling() {
        return this.isToggling;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getIsUninstalling() {
        return this.isUninstalling;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InstalledRow)) {
            return false;
        }
        InstalledRow installedRow = (InstalledRow) other;
        return p.d(this.item, installedRow.item) && this.isToggling == installedRow.isToggling && this.isUninstalling == installedRow.isUninstalling;
    }

    public int hashCode() {
        return (((this.item.hashCode() * 31) + Boolean.hashCode(this.isToggling)) * 31) + Boolean.hashCode(this.isUninstalling);
    }

    public String toString() {
        return "InstalledRow(item=" + this.item + ", isToggling=" + this.isToggling + ", isUninstalling=" + this.isUninstalling + ")";
    }
}
