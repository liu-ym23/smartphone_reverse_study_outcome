package com.zyql.common.utils.update.model;

import A9.d;
import B9.L;
import B9.T;
import B9.d0;
import B9.h0;
import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import x9.b;
import z9.g;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b$\b\u0087\b\u0018\u0000 ;2\u00020\u0001:\u0002<;Ba\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\r\u0010\u000eBg\b\u0010\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\r\u0010\u0013J'\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0012\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b!\u0010\"J\u0012\u0010#\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b#\u0010\"J\u0010\u0010$\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b$\u0010\u001eJ\u0012\u0010%\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b%\u0010\"J\u0012\u0010&\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b&\u0010 J\u0012\u0010'\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b'\u0010\"Jl\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b*\u0010\"J\u0010\u0010+\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b+\u0010,J\u001a\u0010.\u001a\u00020\u00022\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b.\u0010/R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00100\u001a\u0004\b1\u0010\u001eR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u00102\u001a\u0004\b3\u0010 R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u00104\u001a\u0004\b5\u0010\"R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\b\u00104\u001a\u0004\b6\u0010\"R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u00100\u001a\u0004\b7\u0010\u001eR\u0019\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\n\u00104\u001a\u0004\b8\u0010\"R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u00102\u001a\u0004\b9\u0010 R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\f\u00104\u001a\u0004\b:\u0010\"¨\u0006="}, d2 = {"Lcom/zyql/common/utils/update/model/UpdateCheckResponse;", "", "", "hasUpdate", "", "newVersionCode", "", "newVersionName", "updateDescription", "forceUpdate", "downloadUrl", "apkSize", "md5", AppAgent.CONSTRUCT, "(ZLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "", "seen0", "LB9/d0;", "serializationConstructorMarker", "(IZLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Long;Ljava/lang/String;LB9/d0;)V", "self", "LA9/d;", "output", "Lz9/g;", "serialDesc", "LC7/r;", "write$Self$utils_release", "(Lcom/zyql/common/utils/update/model/UpdateCheckResponse;LA9/d;Lz9/g;)V", "write$Self", "component1", "()Z", "component2", "()Ljava/lang/Long;", "component3", "()Ljava/lang/String;", "component4", "component5", "component6", "component7", "component8", "copy", "(ZLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Lcom/zyql/common/utils/update/model/UpdateCheckResponse;", "toString", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getHasUpdate", "Ljava/lang/Long;", "getNewVersionCode", "Ljava/lang/String;", "getNewVersionName", "getUpdateDescription", "getForceUpdate", "getDownloadUrl", "getApkSize", "getMd5", "Companion", "$serializer", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class UpdateCheckResponse {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Long apkSize;
    private final String downloadUrl;
    private final boolean forceUpdate;
    private final boolean hasUpdate;
    private final String md5;
    private final Long newVersionCode;
    private final String newVersionName;
    private final String updateDescription;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/zyql/common/utils/update/model/UpdateCheckResponse$Companion;", "", AppAgent.CONSTRUCT, "()V", "Lx9/b;", "Lcom/zyql/common/utils/update/model/UpdateCheckResponse;", "serializer", "()Lx9/b;", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final b serializer() {
            return UpdateCheckResponse$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(e eVar) {
            this();
        }
    }

    public /* synthetic */ UpdateCheckResponse(int i, boolean z10, Long l, String str, String str2, boolean z11, String str3, Long l5, String str4, d0 d0Var) {
        if (1 != (i & 1)) {
            T.g(UpdateCheckResponse$$serializer.INSTANCE.getDescriptor(), i, 1);
            throw null;
        }
        this.hasUpdate = z10;
        if ((i & 2) == 0) {
            this.newVersionCode = null;
        } else {
            this.newVersionCode = l;
        }
        if ((i & 4) == 0) {
            this.newVersionName = null;
        } else {
            this.newVersionName = str;
        }
        if ((i & 8) == 0) {
            this.updateDescription = null;
        } else {
            this.updateDescription = str2;
        }
        if ((i & 16) == 0) {
            this.forceUpdate = false;
        } else {
            this.forceUpdate = z11;
        }
        if ((i & 32) == 0) {
            this.downloadUrl = null;
        } else {
            this.downloadUrl = str3;
        }
        if ((i & 64) == 0) {
            this.apkSize = null;
        } else {
            this.apkSize = l5;
        }
        if ((i & 128) == 0) {
            this.md5 = null;
        } else {
            this.md5 = str4;
        }
    }

    public static /* synthetic */ UpdateCheckResponse copy$default(UpdateCheckResponse updateCheckResponse, boolean z10, Long l, String str, String str2, boolean z11, String str3, Long l5, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            z10 = updateCheckResponse.hasUpdate;
        }
        if ((i & 2) != 0) {
            l = updateCheckResponse.newVersionCode;
        }
        if ((i & 4) != 0) {
            str = updateCheckResponse.newVersionName;
        }
        if ((i & 8) != 0) {
            str2 = updateCheckResponse.updateDescription;
        }
        if ((i & 16) != 0) {
            z11 = updateCheckResponse.forceUpdate;
        }
        if ((i & 32) != 0) {
            str3 = updateCheckResponse.downloadUrl;
        }
        if ((i & 64) != 0) {
            l5 = updateCheckResponse.apkSize;
        }
        if ((i & 128) != 0) {
            str4 = updateCheckResponse.md5;
        }
        Long l9 = l5;
        String str5 = str4;
        boolean z12 = z11;
        String str6 = str3;
        return updateCheckResponse.copy(z10, l, str, str2, z12, str6, l9, str5);
    }

    public static final /* synthetic */ void write$Self$utils_release(UpdateCheckResponse self, d output, g serialDesc) {
        output.encodeBooleanElement(serialDesc, 0, self.hasUpdate);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.newVersionCode != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, L.f223a, self.newVersionCode);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.newVersionName != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, h0.f242a, self.newVersionName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.updateDescription != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, h0.f242a, self.updateDescription);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.forceUpdate) {
            output.encodeBooleanElement(serialDesc, 4, self.forceUpdate);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.downloadUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, h0.f242a, self.downloadUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.apkSize != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, L.f223a, self.apkSize);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 7) && self.md5 == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 7, h0.f242a, self.md5);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getHasUpdate() {
        return this.hasUpdate;
    }

    /* renamed from: component2, reason: from getter */
    public final Long getNewVersionCode() {
        return this.newVersionCode;
    }

    /* renamed from: component3, reason: from getter */
    public final String getNewVersionName() {
        return this.newVersionName;
    }

    /* renamed from: component4, reason: from getter */
    public final String getUpdateDescription() {
        return this.updateDescription;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getForceUpdate() {
        return this.forceUpdate;
    }

    /* renamed from: component6, reason: from getter */
    public final String getDownloadUrl() {
        return this.downloadUrl;
    }

    /* renamed from: component7, reason: from getter */
    public final Long getApkSize() {
        return this.apkSize;
    }

    /* renamed from: component8, reason: from getter */
    public final String getMd5() {
        return this.md5;
    }

    public final UpdateCheckResponse copy(boolean hasUpdate, Long newVersionCode, String newVersionName, String updateDescription, boolean forceUpdate, String downloadUrl, Long apkSize, String md5) {
        return new UpdateCheckResponse(hasUpdate, newVersionCode, newVersionName, updateDescription, forceUpdate, downloadUrl, apkSize, md5);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UpdateCheckResponse)) {
            return false;
        }
        UpdateCheckResponse updateCheckResponse = (UpdateCheckResponse) other;
        return this.hasUpdate == updateCheckResponse.hasUpdate && k.b(this.newVersionCode, updateCheckResponse.newVersionCode) && k.b(this.newVersionName, updateCheckResponse.newVersionName) && k.b(this.updateDescription, updateCheckResponse.updateDescription) && this.forceUpdate == updateCheckResponse.forceUpdate && k.b(this.downloadUrl, updateCheckResponse.downloadUrl) && k.b(this.apkSize, updateCheckResponse.apkSize) && k.b(this.md5, updateCheckResponse.md5);
    }

    public final Long getApkSize() {
        return this.apkSize;
    }

    public final String getDownloadUrl() {
        return this.downloadUrl;
    }

    public final boolean getForceUpdate() {
        return this.forceUpdate;
    }

    public final boolean getHasUpdate() {
        return this.hasUpdate;
    }

    public final String getMd5() {
        return this.md5;
    }

    public final Long getNewVersionCode() {
        return this.newVersionCode;
    }

    public final String getNewVersionName() {
        return this.newVersionName;
    }

    public final String getUpdateDescription() {
        return this.updateDescription;
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.hasUpdate) * 31;
        Long l = this.newVersionCode;
        int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str = this.newVersionName;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.updateDescription;
        int iD = a.d((iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31, 31, this.forceUpdate);
        String str3 = this.downloadUrl;
        int iHashCode4 = (iD + (str3 == null ? 0 : str3.hashCode())) * 31;
        Long l5 = this.apkSize;
        int iHashCode5 = (iHashCode4 + (l5 == null ? 0 : l5.hashCode())) * 31;
        String str4 = this.md5;
        return iHashCode5 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        boolean z10 = this.hasUpdate;
        Long l = this.newVersionCode;
        String str = this.newVersionName;
        String str2 = this.updateDescription;
        boolean z11 = this.forceUpdate;
        String str3 = this.downloadUrl;
        Long l5 = this.apkSize;
        String str4 = this.md5;
        StringBuilder sb = new StringBuilder("UpdateCheckResponse(hasUpdate=");
        sb.append(z10);
        sb.append(", newVersionCode=");
        sb.append(l);
        sb.append(", newVersionName=");
        androidx.constraintlayout.core.dsl.a.A(sb, str, ", updateDescription=", str2, ", forceUpdate=");
        sb.append(z11);
        sb.append(", downloadUrl=");
        sb.append(str3);
        sb.append(", apkSize=");
        sb.append(l5);
        sb.append(", md5=");
        sb.append(str4);
        sb.append(")");
        return sb.toString();
    }

    public UpdateCheckResponse(boolean z10, Long l, String str, String str2, boolean z11, String str3, Long l5, String str4) {
        this.hasUpdate = z10;
        this.newVersionCode = l;
        this.newVersionName = str;
        this.updateDescription = str2;
        this.forceUpdate = z11;
        this.downloadUrl = str3;
        this.apkSize = l5;
        this.md5 = str4;
    }

    public /* synthetic */ UpdateCheckResponse(boolean z10, Long l, String str, String str2, boolean z11, String str3, Long l5, String str4, int i, e eVar) {
        this(z10, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? false : z11, (i & 32) != 0 ? null : str3, (i & 64) != 0 ? null : l5, (i & 128) != 0 ? null : str4);
    }
}
