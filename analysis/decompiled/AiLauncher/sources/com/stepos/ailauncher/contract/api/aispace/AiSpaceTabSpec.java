package com.stepos.ailauncher.contract.api.aispace;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import x5.d;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013¨\u0006!"}, d2 = {"Lcom/stepos/ailauncher/contract/api/aispace/AiSpaceTabSpec;", "", "tabId", "", "title", DidiCardProvider.KEY_ORDER, "", "defaultSelected", "", "visible", d.EXTRA_ENABLED, "<init>", "(Ljava/lang/String;Ljava/lang/String;IZZZ)V", "getTabId", "()Ljava/lang/String;", "getTitle", "getOrder", "()I", "getDefaultSelected", "()Z", "getVisible", "getEnabled", "component1", "component2", "component3", "component4", "component5", "component6", ChatTracker.CLICK_COPY, "equals", "other", "hashCode", "toString", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AiSpaceTabSpec {
    private final boolean defaultSelected;
    private final boolean enabled;
    private final int order;
    private final String tabId;
    private final String title;
    private final boolean visible;

    public AiSpaceTabSpec(String tabId, String title, int i10, boolean z10, boolean z11, boolean z12) {
        p.i(tabId, "tabId");
        p.i(title, "title");
        this.tabId = tabId;
        this.title = title;
        this.order = i10;
        this.defaultSelected = z10;
        this.visible = z11;
        this.enabled = z12;
    }

    public static /* synthetic */ AiSpaceTabSpec copy$default(AiSpaceTabSpec aiSpaceTabSpec, String str, String str2, int i10, boolean z10, boolean z11, boolean z12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = aiSpaceTabSpec.tabId;
        }
        if ((i11 & 2) != 0) {
            str2 = aiSpaceTabSpec.title;
        }
        if ((i11 & 4) != 0) {
            i10 = aiSpaceTabSpec.order;
        }
        if ((i11 & 8) != 0) {
            z10 = aiSpaceTabSpec.defaultSelected;
        }
        if ((i11 & 16) != 0) {
            z11 = aiSpaceTabSpec.visible;
        }
        if ((i11 & 32) != 0) {
            z12 = aiSpaceTabSpec.enabled;
        }
        boolean z13 = z11;
        boolean z14 = z12;
        return aiSpaceTabSpec.copy(str, str2, i10, z10, z13, z14);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTabId() {
        return this.tabId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component3, reason: from getter */
    public final int getOrder() {
        return this.order;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getDefaultSelected() {
        return this.defaultSelected;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getVisible() {
        return this.visible;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    public final AiSpaceTabSpec copy(String tabId, String title, int order, boolean defaultSelected, boolean visible, boolean enabled) {
        p.i(tabId, "tabId");
        p.i(title, "title");
        return new AiSpaceTabSpec(tabId, title, order, defaultSelected, visible, enabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AiSpaceTabSpec)) {
            return false;
        }
        AiSpaceTabSpec aiSpaceTabSpec = (AiSpaceTabSpec) other;
        return p.d(this.tabId, aiSpaceTabSpec.tabId) && p.d(this.title, aiSpaceTabSpec.title) && this.order == aiSpaceTabSpec.order && this.defaultSelected == aiSpaceTabSpec.defaultSelected && this.visible == aiSpaceTabSpec.visible && this.enabled == aiSpaceTabSpec.enabled;
    }

    public final boolean getDefaultSelected() {
        return this.defaultSelected;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final int getOrder() {
        return this.order;
    }

    public final String getTabId() {
        return this.tabId;
    }

    public final String getTitle() {
        return this.title;
    }

    public final boolean getVisible() {
        return this.visible;
    }

    public int hashCode() {
        return (((((((((this.tabId.hashCode() * 31) + this.title.hashCode()) * 31) + Integer.hashCode(this.order)) * 31) + Boolean.hashCode(this.defaultSelected)) * 31) + Boolean.hashCode(this.visible)) * 31) + Boolean.hashCode(this.enabled);
    }

    public String toString() {
        return "AiSpaceTabSpec(tabId=" + this.tabId + ", title=" + this.title + ", order=" + this.order + ", defaultSelected=" + this.defaultSelected + ", visible=" + this.visible + ", enabled=" + this.enabled + ")";
    }

    public /* synthetic */ AiSpaceTabSpec(String str, String str2, int i10, boolean z10, boolean z11, boolean z12, int i11, i iVar) {
        this(str, str2, i10, (i11 & 8) != 0 ? false : z10, (i11 & 16) != 0 ? true : z11, (i11 & 32) != 0 ? true : z12);
    }
}
