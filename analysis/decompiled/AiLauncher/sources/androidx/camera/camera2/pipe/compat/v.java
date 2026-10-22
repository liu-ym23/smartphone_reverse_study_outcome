package androidx.camera.camera2.pipe.compat;

import androidx.camera.camera2.pipe.compat.o;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import w.C5701g;
import x.InputConfigData;
import x.w0;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0080\b\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0018R\u001f\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b \u0010\"R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048\u0006¢\u0006\f\n\u0004\b#\u0010!\u001a\u0004\b#\u0010\"R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\u001d\u0010&R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0017\u0010\r\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b+\u0010\u001e\u001a\u0004\b+\u0010\u0018R#\u0010\u000f\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u001f\u0010,\u001a\u0004\b'\u0010-R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b)\u0010.\u001a\u0004\b$\u0010\u0016¨\u0006/"}, d2 = {"Landroidx/camera/camera2/pipe/compat/v;", "", "", "sessionType", "", "Lx/u0;", "inputConfiguration", "Lx/w0;", "outputConfigurations", "Ljava/util/concurrent/Executor;", "executor", "Landroidx/camera/camera2/pipe/compat/o$a;", "stateCallback", "sessionTemplateId", "", "sessionParameters", "Lw/g;", "sessionColorSpace", "<init>", "(ILjava/util/List;Ljava/util/List;Ljava/util/concurrent/Executor;Landroidx/camera/camera2/pipe/compat/o$a;ILjava/util/Map;Ljava/lang/String;Lkotlin/jvm/internal/i;)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "I", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_PKGNAME, "Ljava/util/List;", "()Ljava/util/List;", "c", Const.INTENT_KEY_UMID, "Ljava/util/concurrent/Executor;", "()Ljava/util/concurrent/Executor;", "e", "Landroidx/camera/camera2/pipe/compat/o$a;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Landroidx/camera/camera2/pipe/compat/o$a;", "f", "Ljava/util/Map;", "()Ljava/util/Map;", "Ljava/lang/String;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class v {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final int sessionType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final List<InputConfigData> inputConfiguration;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final List<w0> outputConfigurations;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Executor executor;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final o.a stateCallback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final int sessionTemplateId;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final Map<?, Object> sessionParameters;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final String sessionColorSpace;

    public /* synthetic */ v(int i10, List list, List list2, Executor executor, o.a aVar, int i11, Map map, String str, kotlin.jvm.internal.i iVar) {
        this(i10, list, list2, executor, aVar, i11, map, str);
    }

    /* renamed from: a, reason: from getter */
    public final Executor getExecutor() {
        return this.executor;
    }

    public final List<InputConfigData> b() {
        return this.inputConfiguration;
    }

    public final List<w0> c() {
        return this.outputConfigurations;
    }

    /* renamed from: d, reason: from getter */
    public final String getSessionColorSpace() {
        return this.sessionColorSpace;
    }

    public final Map<?, Object> e() {
        return this.sessionParameters;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r4 != r5) goto L4
            return r0
        L4:
            boolean r1 = r5 instanceof androidx.camera.camera2.pipe.compat.v
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            androidx.camera.camera2.pipe.compat.v r5 = (androidx.camera.camera2.pipe.compat.v) r5
            int r1 = r4.sessionType
            int r3 = r5.sessionType
            if (r1 == r3) goto L13
            return r2
        L13:
            java.util.List<x.u0> r1 = r4.inputConfiguration
            java.util.List<x.u0> r3 = r5.inputConfiguration
            boolean r1 = kotlin.jvm.internal.p.d(r1, r3)
            if (r1 != 0) goto L1e
            return r2
        L1e:
            java.util.List<x.w0> r1 = r4.outputConfigurations
            java.util.List<x.w0> r3 = r5.outputConfigurations
            boolean r1 = kotlin.jvm.internal.p.d(r1, r3)
            if (r1 != 0) goto L29
            return r2
        L29:
            java.util.concurrent.Executor r1 = r4.executor
            java.util.concurrent.Executor r3 = r5.executor
            boolean r1 = kotlin.jvm.internal.p.d(r1, r3)
            if (r1 != 0) goto L34
            return r2
        L34:
            androidx.camera.camera2.pipe.compat.o$a r1 = r4.stateCallback
            androidx.camera.camera2.pipe.compat.o$a r3 = r5.stateCallback
            boolean r1 = kotlin.jvm.internal.p.d(r1, r3)
            if (r1 != 0) goto L3f
            return r2
        L3f:
            int r1 = r4.sessionTemplateId
            int r3 = r5.sessionTemplateId
            if (r1 == r3) goto L46
            return r2
        L46:
            java.util.Map<?, java.lang.Object> r1 = r4.sessionParameters
            java.util.Map<?, java.lang.Object> r3 = r5.sessionParameters
            boolean r1 = kotlin.jvm.internal.p.d(r1, r3)
            if (r1 != 0) goto L51
            return r2
        L51:
            java.lang.String r4 = r4.sessionColorSpace
            java.lang.String r5 = r5.sessionColorSpace
            if (r4 != 0) goto L5d
            if (r5 != 0) goto L5b
            r4 = r0
            goto L64
        L5b:
            r4 = r2
            goto L64
        L5d:
            if (r5 != 0) goto L60
            goto L5b
        L60:
            boolean r4 = w.C5701g.b(r4, r5)
        L64:
            if (r4 != 0) goto L67
            return r2
        L67:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.compat.v.equals(java.lang.Object):boolean");
    }

    /* renamed from: f, reason: from getter */
    public final int getSessionTemplateId() {
        return this.sessionTemplateId;
    }

    /* renamed from: g, reason: from getter */
    public final int getSessionType() {
        return this.sessionType;
    }

    /* renamed from: h, reason: from getter */
    public final o.a getStateCallback() {
        return this.stateCallback;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.sessionType) * 31;
        List<InputConfigData> list = this.inputConfiguration;
        int iHashCode2 = (((((((((((iHashCode + (list == null ? 0 : list.hashCode())) * 31) + this.outputConfigurations.hashCode()) * 31) + this.executor.hashCode()) * 31) + this.stateCallback.hashCode()) * 31) + Integer.hashCode(this.sessionTemplateId)) * 31) + this.sessionParameters.hashCode()) * 31;
        String str = this.sessionColorSpace;
        return iHashCode2 + (str != null ? C5701g.c(str) : 0);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SessionConfigData(sessionType=");
        sb2.append(this.sessionType);
        sb2.append(", inputConfiguration=");
        sb2.append(this.inputConfiguration);
        sb2.append(", outputConfigurations=");
        sb2.append(this.outputConfigurations);
        sb2.append(", executor=");
        sb2.append(this.executor);
        sb2.append(", stateCallback=");
        sb2.append(this.stateCallback);
        sb2.append(", sessionTemplateId=");
        sb2.append(this.sessionTemplateId);
        sb2.append(", sessionParameters=");
        sb2.append(this.sessionParameters);
        sb2.append(", sessionColorSpace=");
        String str = this.sessionColorSpace;
        sb2.append((Object) (str == null ? "null" : C5701g.e(str)));
        sb2.append(')');
        return sb2.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public v(int i10, List<InputConfigData> list, List<? extends w0> outputConfigurations, Executor executor, o.a stateCallback, int i11, Map<?, ? extends Object> sessionParameters, String str) {
        kotlin.jvm.internal.p.i(outputConfigurations, "outputConfigurations");
        kotlin.jvm.internal.p.i(executor, "executor");
        kotlin.jvm.internal.p.i(stateCallback, "stateCallback");
        kotlin.jvm.internal.p.i(sessionParameters, "sessionParameters");
        this.sessionType = i10;
        this.inputConfiguration = list;
        this.outputConfigurations = outputConfigurations;
        this.executor = executor;
        this.stateCallback = stateCallback;
        this.sessionTemplateId = i11;
        this.sessionParameters = sessionParameters;
        this.sessionColorSpace = str;
    }
}
