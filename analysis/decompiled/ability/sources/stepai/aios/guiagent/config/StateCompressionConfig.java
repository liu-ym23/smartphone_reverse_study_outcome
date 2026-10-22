package stepai.aios.guiagent.config;

import androidx.constraintlayout.core.dsl.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\u0006\u0010\u0013\u001a\u00020\u0000J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001d"}, d2 = {"Lstepai/aios/guiagent/config/StateCompressionConfig;", "", "enabled", "", "interval", "", "recentWindow", "maxFieldItems", AppAgent.CONSTRUCT, "(ZIII)V", "getEnabled", "()Z", "getInterval", "()I", "getRecentWindow", "getMaxFieldItems", "validationIssues", "", "", "sanitized", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class StateCompressionConfig {
    private final boolean enabled;
    private final int interval;
    private final int maxFieldItems;
    private final int recentWindow;

    public StateCompressionConfig() {
        this(false, 0, 0, 0, 15, null);
    }

    public static /* synthetic */ StateCompressionConfig copy$default(StateCompressionConfig stateCompressionConfig, boolean z10, int i, int i6, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = stateCompressionConfig.enabled;
        }
        if ((i11 & 2) != 0) {
            i = stateCompressionConfig.interval;
        }
        if ((i11 & 4) != 0) {
            i6 = stateCompressionConfig.recentWindow;
        }
        if ((i11 & 8) != 0) {
            i10 = stateCompressionConfig.maxFieldItems;
        }
        return stateCompressionConfig.copy(z10, i, i6, i10);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    /* renamed from: component2, reason: from getter */
    public final int getInterval() {
        return this.interval;
    }

    /* renamed from: component3, reason: from getter */
    public final int getRecentWindow() {
        return this.recentWindow;
    }

    /* renamed from: component4, reason: from getter */
    public final int getMaxFieldItems() {
        return this.maxFieldItems;
    }

    public final StateCompressionConfig copy(boolean enabled, int interval, int recentWindow, int maxFieldItems) {
        return new StateCompressionConfig(enabled, interval, recentWindow, maxFieldItems);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StateCompressionConfig)) {
            return false;
        }
        StateCompressionConfig stateCompressionConfig = (StateCompressionConfig) other;
        return this.enabled == stateCompressionConfig.enabled && this.interval == stateCompressionConfig.interval && this.recentWindow == stateCompressionConfig.recentWindow && this.maxFieldItems == stateCompressionConfig.maxFieldItems;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final int getInterval() {
        return this.interval;
    }

    public final int getMaxFieldItems() {
        return this.maxFieldItems;
    }

    public final int getRecentWindow() {
        return this.recentWindow;
    }

    public int hashCode() {
        return Integer.hashCode(this.maxFieldItems) + a.a(this.recentWindow, a.a(this.interval, Boolean.hashCode(this.enabled) * 31, 31), 31);
    }

    public final StateCompressionConfig sanitized() {
        int i = this.interval;
        int i6 = i < 1 ? 1 : i;
        int i10 = this.recentWindow;
        int i11 = i10 < 1 ? 1 : i10;
        int i12 = this.maxFieldItems;
        return copy$default(this, false, i6, i11, i12 < 1 ? 1 : i12, 1, null);
    }

    public String toString() {
        return "StateCompressionConfig(enabled=" + this.enabled + ", interval=" + this.interval + ", recentWindow=" + this.recentWindow + ", maxFieldItems=" + this.maxFieldItems + ")";
    }

    public final List<String> validationIssues() {
        ArrayList arrayList = new ArrayList();
        if (this.interval <= 0) {
            arrayList.add("interval_must_be_positive");
        }
        if (this.recentWindow <= 0) {
            arrayList.add("recent_window_must_be_positive");
        }
        if (this.maxFieldItems <= 0) {
            arrayList.add("max_field_items_must_be_positive");
        }
        return arrayList;
    }

    public StateCompressionConfig(boolean z10, int i, int i6, int i10) {
        this.enabled = z10;
        this.interval = i;
        this.recentWindow = i6;
        this.maxFieldItems = i10;
    }

    public /* synthetic */ StateCompressionConfig(boolean z10, int i, int i6, int i10, int i11, e eVar) {
        this((i11 & 1) != 0 ? true : z10, (i11 & 2) != 0 ? 10 : i, (i11 & 4) != 0 ? 10 : i6, (i11 & 8) != 0 ? 8 : i10);
    }
}
