package com.uxsense;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.uxsense.core.utils.Logger;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J/\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/uxsense/ApexConfig;", "", "useAndroidLog", "", "logger", "Lcom/uxsense/core/utils/Logger;", "watchPackages", "", "", AppAgent.CONSTRUCT, "(ZLcom/uxsense/core/utils/Logger;Ljava/util/List;)V", "getUseAndroidLog", "()Z", "getLogger", "()Lcom/uxsense/core/utils/Logger;", "getWatchPackages", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ApexConfig {
    public static final ApexConfig DEFAULT = new ApexConfig(false, null, null, 7, null);
    private final Logger logger;
    private final boolean useAndroidLog;
    private final List<String> watchPackages;

    public ApexConfig() {
        this(false, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ApexConfig copy$default(ApexConfig apexConfig, boolean z10, Logger logger, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z10 = apexConfig.useAndroidLog;
        }
        if ((i & 2) != 0) {
            logger = apexConfig.logger;
        }
        if ((i & 4) != 0) {
            list = apexConfig.watchPackages;
        }
        return apexConfig.copy(z10, logger, list);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getUseAndroidLog() {
        return this.useAndroidLog;
    }

    /* renamed from: component2, reason: from getter */
    public final Logger getLogger() {
        return this.logger;
    }

    public final List<String> component3() {
        return this.watchPackages;
    }

    public final ApexConfig copy(boolean useAndroidLog, Logger logger, List<String> watchPackages) {
        k.f(watchPackages, "watchPackages");
        return new ApexConfig(useAndroidLog, logger, watchPackages);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApexConfig)) {
            return false;
        }
        ApexConfig apexConfig = (ApexConfig) other;
        return this.useAndroidLog == apexConfig.useAndroidLog && k.b(this.logger, apexConfig.logger) && k.b(this.watchPackages, apexConfig.watchPackages);
    }

    public final Logger getLogger() {
        return this.logger;
    }

    public final boolean getUseAndroidLog() {
        return this.useAndroidLog;
    }

    public final List<String> getWatchPackages() {
        return this.watchPackages;
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.useAndroidLog) * 31;
        Logger logger = this.logger;
        return this.watchPackages.hashCode() + ((iHashCode + (logger == null ? 0 : logger.hashCode())) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ApexConfig(useAndroidLog=");
        sb.append(this.useAndroidLog);
        sb.append(", logger=");
        sb.append(this.logger);
        sb.append(", watchPackages=");
        return B7.a.r(sb, this.watchPackages, ')');
    }

    public ApexConfig(boolean z10, Logger logger, List<String> watchPackages) {
        k.f(watchPackages, "watchPackages");
        this.useAndroidLog = z10;
        this.logger = logger;
        this.watchPackages = watchPackages;
    }

    public ApexConfig(boolean z10, Logger logger, List list, int i, kotlin.jvm.internal.e eVar) {
        this((i & 1) != 0 ? true : z10, (i & 2) != 0 ? null : logger, (i & 4) != 0 ? EmptyList.f4893a : list);
    }
}
