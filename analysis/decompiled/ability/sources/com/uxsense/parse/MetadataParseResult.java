package com.uxsense.parse;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\tHÆ\u0003JA\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcom/uxsense/parse/MetadataParseResult;", "", "type", "Lcom/uxsense/parse/MetadataType;", "totalCount", "", "successCount", "errorCount", SettingsConfig.KEY_DATA, "", AppAgent.CONSTRUCT, "(Lcom/uxsense/parse/MetadataType;IIILjava/util/List;)V", "getType", "()Lcom/uxsense/parse/MetadataType;", "getTotalCount", "()I", "getSuccessCount", "getErrorCount", "getData", "()Ljava/util/List;", "successRate", "", "getSuccessRate", "()F", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class MetadataParseResult {
    private final List<Object> data;
    private final int errorCount;
    private final int successCount;
    private final int totalCount;
    private final MetadataType type;

    public MetadataParseResult(MetadataType type, int i, int i6, int i10, List<? extends Object> data) {
        k.f(type, "type");
        k.f(data, "data");
        this.type = type;
        this.totalCount = i;
        this.successCount = i6;
        this.errorCount = i10;
        this.data = data;
    }

    public static /* synthetic */ MetadataParseResult copy$default(MetadataParseResult metadataParseResult, MetadataType metadataType, int i, int i6, int i10, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            metadataType = metadataParseResult.type;
        }
        if ((i11 & 2) != 0) {
            i = metadataParseResult.totalCount;
        }
        if ((i11 & 4) != 0) {
            i6 = metadataParseResult.successCount;
        }
        if ((i11 & 8) != 0) {
            i10 = metadataParseResult.errorCount;
        }
        if ((i11 & 16) != 0) {
            list = metadataParseResult.data;
        }
        List list2 = list;
        int i12 = i6;
        return metadataParseResult.copy(metadataType, i, i12, i10, list2);
    }

    /* renamed from: component1, reason: from getter */
    public final MetadataType getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final int getTotalCount() {
        return this.totalCount;
    }

    /* renamed from: component3, reason: from getter */
    public final int getSuccessCount() {
        return this.successCount;
    }

    /* renamed from: component4, reason: from getter */
    public final int getErrorCount() {
        return this.errorCount;
    }

    public final List<Object> component5() {
        return this.data;
    }

    public final MetadataParseResult copy(MetadataType type, int totalCount, int successCount, int errorCount, List<? extends Object> data) {
        k.f(type, "type");
        k.f(data, "data");
        return new MetadataParseResult(type, totalCount, successCount, errorCount, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MetadataParseResult)) {
            return false;
        }
        MetadataParseResult metadataParseResult = (MetadataParseResult) other;
        return this.type == metadataParseResult.type && this.totalCount == metadataParseResult.totalCount && this.successCount == metadataParseResult.successCount && this.errorCount == metadataParseResult.errorCount && k.b(this.data, metadataParseResult.data);
    }

    public final List<Object> getData() {
        return this.data;
    }

    public final int getErrorCount() {
        return this.errorCount;
    }

    public final int getSuccessCount() {
        return this.successCount;
    }

    public final float getSuccessRate() {
        int i = this.totalCount;
        if (i > 0) {
            return this.successCount / i;
        }
        return 0.0f;
    }

    public final int getTotalCount() {
        return this.totalCount;
    }

    public final MetadataType getType() {
        return this.type;
    }

    public int hashCode() {
        return this.data.hashCode() + androidx.constraintlayout.core.dsl.a.a(this.errorCount, androidx.constraintlayout.core.dsl.a.a(this.successCount, androidx.constraintlayout.core.dsl.a.a(this.totalCount, this.type.hashCode() * 31, 31), 31), 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("MetadataParseResult(type=");
        sb.append(this.type);
        sb.append(", totalCount=");
        sb.append(this.totalCount);
        sb.append(", successCount=");
        sb.append(this.successCount);
        sb.append(", errorCount=");
        sb.append(this.errorCount);
        sb.append(", data=");
        return B7.a.r(sb, this.data, ')');
    }
}
