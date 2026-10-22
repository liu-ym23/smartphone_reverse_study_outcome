package stepai.aios.guiagent.app;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.model.WindowStateInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.a;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u0017\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007HÆ\u0003J<\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lstepai/aios/guiagent/app/AppLaunchRequest;", "", "appOrPackageName", "", WindowStateInfo.KEY_DISPLAY_ID, "", "metadata", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Map;)V", "getAppOrPackageName", "()Ljava/lang/String;", "getDisplayId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMetadata", "()Ljava/util/Map;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Map;)Lstepai/aios/guiagent/app/AppLaunchRequest;", "equals", "", "other", "hashCode", "toString", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class AppLaunchRequest {
    private final String appOrPackageName;
    private final Integer displayId;
    private final Map<String, Object> metadata;

    public AppLaunchRequest(String appOrPackageName, Integer num, Map<String, ? extends Object> metadata) {
        k.f(appOrPackageName, "appOrPackageName");
        k.f(metadata, "metadata");
        this.appOrPackageName = appOrPackageName;
        this.displayId = num;
        this.metadata = metadata;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AppLaunchRequest copy$default(AppLaunchRequest appLaunchRequest, String str, Integer num, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = appLaunchRequest.appOrPackageName;
        }
        if ((i & 2) != 0) {
            num = appLaunchRequest.displayId;
        }
        if ((i & 4) != 0) {
            map = appLaunchRequest.metadata;
        }
        return appLaunchRequest.copy(str, num, map);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAppOrPackageName() {
        return this.appOrPackageName;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getDisplayId() {
        return this.displayId;
    }

    public final Map<String, Object> component3() {
        return this.metadata;
    }

    public final AppLaunchRequest copy(String appOrPackageName, Integer displayId, Map<String, ? extends Object> metadata) {
        k.f(appOrPackageName, "appOrPackageName");
        k.f(metadata, "metadata");
        return new AppLaunchRequest(appOrPackageName, displayId, metadata);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppLaunchRequest)) {
            return false;
        }
        AppLaunchRequest appLaunchRequest = (AppLaunchRequest) other;
        return k.b(this.appOrPackageName, appLaunchRequest.appOrPackageName) && k.b(this.displayId, appLaunchRequest.displayId) && k.b(this.metadata, appLaunchRequest.metadata);
    }

    public final String getAppOrPackageName() {
        return this.appOrPackageName;
    }

    public final Integer getDisplayId() {
        return this.displayId;
    }

    public final Map<String, Object> getMetadata() {
        return this.metadata;
    }

    public int hashCode() {
        int iHashCode = this.appOrPackageName.hashCode() * 31;
        Integer num = this.displayId;
        return this.metadata.hashCode() + ((iHashCode + (num == null ? 0 : num.hashCode())) * 31);
    }

    public String toString() {
        return "AppLaunchRequest(appOrPackageName=" + this.appOrPackageName + ", displayId=" + this.displayId + ", metadata=" + this.metadata + ")";
    }

    public /* synthetic */ AppLaunchRequest(String str, Integer num, Map map, int i, e eVar) {
        this(str, num, (i & 4) != 0 ? a.M() : map);
    }
}
