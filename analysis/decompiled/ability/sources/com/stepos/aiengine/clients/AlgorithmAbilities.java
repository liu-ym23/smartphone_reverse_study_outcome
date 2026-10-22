package com.stepos.aiengine.clients;

import B7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.args.QueryAlgorithmBundle;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJ\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ8\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u000bJ\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u000bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001a\u001a\u0004\b\u001d\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001f\u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u000f¨\u0006#"}, d2 = {"Lcom/stepos/aiengine/clients/AlgorithmAbilities;", "", "", "algorithmId", QueryAlgorithmBundle.KEY_CATEGORY, "description", "", "supported", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "()Z", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lcom/stepos/aiengine/clients/AlgorithmAbilities;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "getAlgorithmId", "b", "getCategory", "c", "getDescription", "d", "Z", "getSupported", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AlgorithmAbilities {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String algorithmId;

    /* renamed from: b, reason: from kotlin metadata */
    public final String category;

    /* renamed from: c, reason: from kotlin metadata */
    public final String description;

    /* renamed from: d, reason: from kotlin metadata */
    public final boolean supported;

    public AlgorithmAbilities(String algorithmId, String category, String description, boolean z10) {
        k.f(algorithmId, "algorithmId");
        k.f(category, "category");
        k.f(description, "description");
        this.algorithmId = algorithmId;
        this.category = category;
        this.description = description;
        this.supported = z10;
    }

    public static /* synthetic */ AlgorithmAbilities copy$default(AlgorithmAbilities algorithmAbilities, String str, String str2, String str3, boolean z10, int i, Object obj) {
        if ((i & 1) != 0) {
            str = algorithmAbilities.algorithmId;
        }
        if ((i & 2) != 0) {
            str2 = algorithmAbilities.category;
        }
        if ((i & 4) != 0) {
            str3 = algorithmAbilities.description;
        }
        if ((i & 8) != 0) {
            z10 = algorithmAbilities.supported;
        }
        return algorithmAbilities.copy(str, str2, str3, z10);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAlgorithmId() {
        return this.algorithmId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getSupported() {
        return this.supported;
    }

    public final AlgorithmAbilities copy(String algorithmId, String category, String description, boolean supported) {
        k.f(algorithmId, "algorithmId");
        k.f(category, "category");
        k.f(description, "description");
        return new AlgorithmAbilities(algorithmId, category, description, supported);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AlgorithmAbilities)) {
            return false;
        }
        AlgorithmAbilities algorithmAbilities = (AlgorithmAbilities) other;
        return k.b(this.algorithmId, algorithmAbilities.algorithmId) && k.b(this.category, algorithmAbilities.category) && k.b(this.description, algorithmAbilities.description) && this.supported == algorithmAbilities.supported;
    }

    public final String getAlgorithmId() {
        return this.algorithmId;
    }

    public final String getCategory() {
        return this.category;
    }

    public final String getDescription() {
        return this.description;
    }

    public final boolean getSupported() {
        return this.supported;
    }

    public int hashCode() {
        return Boolean.hashCode(this.supported) + a.c(a.c(this.algorithmId.hashCode() * 31, 31, this.category), 31, this.description);
    }

    public String toString() {
        StringBuilder sbW = a.w("AlgorithmAbilities(algorithmId=", this.algorithmId, ", category=", this.category, ", description=");
        sbW.append(this.description);
        sbW.append(", supported=");
        sbW.append(this.supported);
        sbW.append(")");
        return sbW.toString();
    }

    public /* synthetic */ AlgorithmAbilities(String str, String str2, String str3, boolean z10, int i, e eVar) {
        this(str, str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? false : z10);
    }
}
