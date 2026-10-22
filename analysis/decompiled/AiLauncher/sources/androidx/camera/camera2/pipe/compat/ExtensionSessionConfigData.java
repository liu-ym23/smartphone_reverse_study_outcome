package androidx.camera.camera2.pipe.compat;

import androidx.camera.camera2.pipe.compat.o;
import androidx.camera.camera2.pipe.compat.q;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import x.w0;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u001f\b\u0080\b\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0012\u0010\r\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0018R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\u001d\u0010&R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\"\u0010'\u001a\u0004\b(\u0010)R\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b*\u0010\u001e\u001a\u0004\b+\u0010\u0018R#\u0010\r\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\f8\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b \u00102R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b$\u00105R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b*\u00108¨\u00069"}, d2 = {"Landroidx/camera/camera2/pipe/compat/t;", "", "", "sessionType", "", "Lx/w0;", "outputConfigurations", "Ljava/util/concurrent/Executor;", "executor", "Landroidx/camera/camera2/pipe/compat/o$a;", "stateCallback", "sessionTemplateId", "", "sessionParameters", "extensionMode", "Landroidx/camera/camera2/pipe/compat/q$a;", "extensionStateCallback", "postviewOutputConfiguration", "<init>", "(ILjava/util/List;Ljava/util/concurrent/Executor;Landroidx/camera/camera2/pipe/compat/o$a;ILjava/util/Map;Ljava/lang/Integer;Landroidx/camera/camera2/pipe/compat/q$a;Lx/w0;)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "I", "getSessionType", Const.INTENT_KEY_PKGNAME, "Ljava/util/List;", Const.INTENT_KEY_UMID, "()Ljava/util/List;", "c", "Ljava/util/concurrent/Executor;", "()Ljava/util/concurrent/Executor;", "Landroidx/camera/camera2/pipe/compat/o$a;", "getStateCallback", "()Landroidx/camera/camera2/pipe/compat/o$a;", "e", "getSessionTemplateId", "f", "Ljava/util/Map;", "getSessionParameters", "()Ljava/util/Map;", Const.INTENT_KEY_BACKGROUND_COMMAND, "Ljava/lang/Integer;", "()Ljava/lang/Integer;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Landroidx/camera/camera2/pipe/compat/q$a;", "()Landroidx/camera/camera2/pipe/compat/q$a;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Lx/w0;", "()Lx/w0;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: androidx.camera.camera2.pipe.compat.t, reason: from toString */
/* loaded from: classes.dex */
public final /* data */ class ExtensionSessionConfigData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final int sessionType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final List<w0> outputConfigurations;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final Executor executor;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final o.a stateCallback;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final int sessionTemplateId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    public final Map<?, Object> sessionParameters;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    public final Integer extensionMode;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    public final q.a extensionStateCallback;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    public final w0 postviewOutputConfiguration;

    /* JADX WARN: Multi-variable type inference failed */
    public ExtensionSessionConfigData(int i10, List<? extends w0> outputConfigurations, Executor executor, o.a stateCallback, int i11, Map<?, ? extends Object> sessionParameters, Integer num, q.a aVar, w0 w0Var) {
        kotlin.jvm.internal.p.i(outputConfigurations, "outputConfigurations");
        kotlin.jvm.internal.p.i(executor, "executor");
        kotlin.jvm.internal.p.i(stateCallback, "stateCallback");
        kotlin.jvm.internal.p.i(sessionParameters, "sessionParameters");
        this.sessionType = i10;
        this.outputConfigurations = outputConfigurations;
        this.executor = executor;
        this.stateCallback = stateCallback;
        this.sessionTemplateId = i11;
        this.sessionParameters = sessionParameters;
        this.extensionMode = num;
        this.extensionStateCallback = aVar;
        this.postviewOutputConfiguration = w0Var;
    }

    /* renamed from: a, reason: from getter */
    public final Executor getExecutor() {
        return this.executor;
    }

    /* renamed from: b, reason: from getter */
    public final Integer getExtensionMode() {
        return this.extensionMode;
    }

    /* renamed from: c, reason: from getter */
    public final q.a getExtensionStateCallback() {
        return this.extensionStateCallback;
    }

    public final List<w0> d() {
        return this.outputConfigurations;
    }

    /* renamed from: e, reason: from getter */
    public final w0 getPostviewOutputConfiguration() {
        return this.postviewOutputConfiguration;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExtensionSessionConfigData)) {
            return false;
        }
        ExtensionSessionConfigData extensionSessionConfigData = (ExtensionSessionConfigData) other;
        return this.sessionType == extensionSessionConfigData.sessionType && kotlin.jvm.internal.p.d(this.outputConfigurations, extensionSessionConfigData.outputConfigurations) && kotlin.jvm.internal.p.d(this.executor, extensionSessionConfigData.executor) && kotlin.jvm.internal.p.d(this.stateCallback, extensionSessionConfigData.stateCallback) && this.sessionTemplateId == extensionSessionConfigData.sessionTemplateId && kotlin.jvm.internal.p.d(this.sessionParameters, extensionSessionConfigData.sessionParameters) && kotlin.jvm.internal.p.d(this.extensionMode, extensionSessionConfigData.extensionMode) && kotlin.jvm.internal.p.d(this.extensionStateCallback, extensionSessionConfigData.extensionStateCallback) && kotlin.jvm.internal.p.d(this.postviewOutputConfiguration, extensionSessionConfigData.postviewOutputConfiguration);
    }

    public int hashCode() {
        int iHashCode = ((((((((((Integer.hashCode(this.sessionType) * 31) + this.outputConfigurations.hashCode()) * 31) + this.executor.hashCode()) * 31) + this.stateCallback.hashCode()) * 31) + Integer.hashCode(this.sessionTemplateId)) * 31) + this.sessionParameters.hashCode()) * 31;
        Integer num = this.extensionMode;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        q.a aVar = this.extensionStateCallback;
        int iHashCode3 = (iHashCode2 + (aVar == null ? 0 : aVar.hashCode())) * 31;
        w0 w0Var = this.postviewOutputConfiguration;
        return iHashCode3 + (w0Var != null ? w0Var.hashCode() : 0);
    }

    public String toString() {
        return "ExtensionSessionConfigData(sessionType=" + this.sessionType + ", outputConfigurations=" + this.outputConfigurations + ", executor=" + this.executor + ", stateCallback=" + this.stateCallback + ", sessionTemplateId=" + this.sessionTemplateId + ", sessionParameters=" + this.sessionParameters + ", extensionMode=" + this.extensionMode + ", extensionStateCallback=" + this.extensionStateCallback + ", postviewOutputConfiguration=" + this.postviewOutputConfiguration + ')';
    }
}
