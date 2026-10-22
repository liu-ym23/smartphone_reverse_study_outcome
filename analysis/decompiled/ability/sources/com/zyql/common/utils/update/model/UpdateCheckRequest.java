package com.zyql.common.utils.update.model;

import A9.d;
import B7.a;
import B9.T;
import B9.d0;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import x9.b;
import z9.g;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u0000 *2\u00020\u0001:\u0002+*B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bB7\b\u0010\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0007\u0010\rJ'\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001aJ.\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001aJ\u0010\u0010\u001f\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010#\u001a\u00020\"2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b#\u0010$R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010%\u001a\u0004\b&\u0010\u0018R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010'\u001a\u0004\b(\u0010\u001aR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010'\u001a\u0004\b)\u0010\u001a¨\u0006,"}, d2 = {"Lcom/zyql/common/utils/update/model/UpdateCheckRequest;", "", "", "versionCode", "", "versionName", "packageName", AppAgent.CONSTRUCT, "(JLjava/lang/String;Ljava/lang/String;)V", "", "seen0", "LB9/d0;", "serializationConstructorMarker", "(IJLjava/lang/String;Ljava/lang/String;LB9/d0;)V", "self", "LA9/d;", "output", "Lz9/g;", "serialDesc", "LC7/r;", "write$Self$utils_release", "(Lcom/zyql/common/utils/update/model/UpdateCheckRequest;LA9/d;Lz9/g;)V", "write$Self", "component1", "()J", "component2", "()Ljava/lang/String;", "component3", "copy", "(JLjava/lang/String;Ljava/lang/String;)Lcom/zyql/common/utils/update/model/UpdateCheckRequest;", "toString", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getVersionCode", "Ljava/lang/String;", "getVersionName", "getPackageName", "Companion", "$serializer", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class UpdateCheckRequest {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String packageName;
    private final long versionCode;
    private final String versionName;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/zyql/common/utils/update/model/UpdateCheckRequest$Companion;", "", AppAgent.CONSTRUCT, "()V", "Lx9/b;", "Lcom/zyql/common/utils/update/model/UpdateCheckRequest;", "serializer", "()Lx9/b;", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final b serializer() {
            return UpdateCheckRequest$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(e eVar) {
            this();
        }
    }

    public /* synthetic */ UpdateCheckRequest(int i, long j5, String str, String str2, d0 d0Var) {
        if (7 != (i & 7)) {
            T.g(UpdateCheckRequest$$serializer.INSTANCE.getDescriptor(), i, 7);
            throw null;
        }
        this.versionCode = j5;
        this.versionName = str;
        this.packageName = str2;
    }

    public static /* synthetic */ UpdateCheckRequest copy$default(UpdateCheckRequest updateCheckRequest, long j5, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            j5 = updateCheckRequest.versionCode;
        }
        if ((i & 2) != 0) {
            str = updateCheckRequest.versionName;
        }
        if ((i & 4) != 0) {
            str2 = updateCheckRequest.packageName;
        }
        return updateCheckRequest.copy(j5, str, str2);
    }

    public static final /* synthetic */ void write$Self$utils_release(UpdateCheckRequest self, d output, g serialDesc) {
        output.encodeLongElement(serialDesc, 0, self.versionCode);
        output.encodeStringElement(serialDesc, 1, self.versionName);
        output.encodeStringElement(serialDesc, 2, self.packageName);
    }

    /* renamed from: component1, reason: from getter */
    public final long getVersionCode() {
        return this.versionCode;
    }

    /* renamed from: component2, reason: from getter */
    public final String getVersionName() {
        return this.versionName;
    }

    /* renamed from: component3, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    public final UpdateCheckRequest copy(long versionCode, String versionName, String packageName) {
        k.f(versionName, "versionName");
        k.f(packageName, "packageName");
        return new UpdateCheckRequest(versionCode, versionName, packageName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UpdateCheckRequest)) {
            return false;
        }
        UpdateCheckRequest updateCheckRequest = (UpdateCheckRequest) other;
        return this.versionCode == updateCheckRequest.versionCode && k.b(this.versionName, updateCheckRequest.versionName) && k.b(this.packageName, updateCheckRequest.packageName);
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final long getVersionCode() {
        return this.versionCode;
    }

    public final String getVersionName() {
        return this.versionName;
    }

    public int hashCode() {
        return this.packageName.hashCode() + a.c(Long.hashCode(this.versionCode) * 31, 31, this.versionName);
    }

    public String toString() {
        long j5 = this.versionCode;
        String str = this.versionName;
        String str2 = this.packageName;
        StringBuilder sb = new StringBuilder("UpdateCheckRequest(versionCode=");
        sb.append(j5);
        sb.append(", versionName=");
        sb.append(str);
        return androidx.constraintlayout.core.dsl.a.j(sb, ", packageName=", str2, ")");
    }

    public UpdateCheckRequest(long j5, String versionName, String packageName) {
        k.f(versionName, "versionName");
        k.f(packageName, "packageName");
        this.versionCode = j5;
        this.versionName = versionName;
        this.packageName = packageName;
    }
}
