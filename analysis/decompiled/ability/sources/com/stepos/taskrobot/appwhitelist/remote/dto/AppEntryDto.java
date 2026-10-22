package com.stepos.taskrobot.appwhitelist.remote.dto;

import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.taskrobot.appwhitelist.model.AppEntry;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0010\u001a\u00020\u0011J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0003J/\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/stepos/taskrobot/appwhitelist/remote/dto/AppEntryDto;", "", "appName", "", "enabled", "", "recommendations", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;ZLjava/util/List;)V", "getAppName", "()Ljava/lang/String;", "getEnabled", "()Z", "getRecommendations", "()Ljava/util/List;", "toModel", "Lcom/stepos/taskrobot/appwhitelist/model/AppEntry;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "appwhitelist_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AppEntryDto {
    private final String appName;
    private final boolean enabled;
    private final List<String> recommendations;

    public AppEntryDto(String appName, boolean z10, List<String> list) {
        k.f(appName, "appName");
        this.appName = appName;
        this.enabled = z10;
        this.recommendations = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AppEntryDto copy$default(AppEntryDto appEntryDto, String str, boolean z10, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = appEntryDto.appName;
        }
        if ((i & 2) != 0) {
            z10 = appEntryDto.enabled;
        }
        if ((i & 4) != 0) {
            list = appEntryDto.recommendations;
        }
        return appEntryDto.copy(str, z10, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAppName() {
        return this.appName;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    public final List<String> component3() {
        return this.recommendations;
    }

    public final AppEntryDto copy(String appName, boolean enabled, List<String> recommendations) {
        k.f(appName, "appName");
        return new AppEntryDto(appName, enabled, recommendations);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppEntryDto)) {
            return false;
        }
        AppEntryDto appEntryDto = (AppEntryDto) other;
        return k.b(this.appName, appEntryDto.appName) && this.enabled == appEntryDto.enabled && k.b(this.recommendations, appEntryDto.recommendations);
    }

    public final String getAppName() {
        return this.appName;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final List<String> getRecommendations() {
        return this.recommendations;
    }

    public int hashCode() {
        int iD = a.d(this.appName.hashCode() * 31, 31, this.enabled);
        List<String> list = this.recommendations;
        return iD + (list == null ? 0 : list.hashCode());
    }

    public final AppEntry toModel() {
        String str = this.appName;
        boolean z10 = this.enabled;
        List list = this.recommendations;
        if (list == null) {
            list = EmptyList.f4893a;
        }
        return new AppEntry(str, z10, list);
    }

    public String toString() {
        String str = this.appName;
        boolean z10 = this.enabled;
        return a.q(androidx.constraintlayout.core.dsl.a.l("AppEntryDto(appName=", str, ", enabled=", ", recommendations=", z10), this.recommendations, ")");
    }

    public /* synthetic */ AppEntryDto(String str, boolean z10, List list, int i, e eVar) {
        this(str, z10, (i & 4) != 0 ? null : list);
    }
}
