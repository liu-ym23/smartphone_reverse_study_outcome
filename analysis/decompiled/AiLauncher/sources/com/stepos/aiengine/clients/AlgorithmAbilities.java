package com.stepos.aiengine.clients;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.args.QueryAlgorithmBundle;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJ\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ8\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u000bJ\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u000bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001a\u001a\u0004\b\u001d\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001f\u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u000f¨\u0006#"}, d2 = {"Lcom/stepos/aiengine/clients/AlgorithmAbilities;", "", "", "algorithmId", QueryAlgorithmBundle.KEY_CATEGORY, "description", "", "supported", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "()Z", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lcom/stepos/aiengine/clients/AlgorithmAbilities;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "getAlgorithmId", Const.INTENT_KEY_PKGNAME, "getCategory", "c", "getDescription", Const.INTENT_KEY_UMID, "Z", "getSupported", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class AlgorithmAbilities {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String algorithmId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String category;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final String description;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean supported;

    public AlgorithmAbilities(String algorithmId, String category, String description, boolean z10) {
        p.i(algorithmId, "algorithmId");
        p.i(category, "category");
        p.i(description, "description");
        this.algorithmId = algorithmId;
        this.category = category;
        this.description = description;
        this.supported = z10;
    }

    public static /* synthetic */ AlgorithmAbilities copy$default(AlgorithmAbilities algorithmAbilities, String str, String str2, String str3, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = algorithmAbilities.algorithmId;
        }
        if ((i10 & 2) != 0) {
            str2 = algorithmAbilities.category;
        }
        if ((i10 & 4) != 0) {
            str3 = algorithmAbilities.description;
        }
        if ((i10 & 8) != 0) {
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
        p.i(algorithmId, "algorithmId");
        p.i(category, "category");
        p.i(description, "description");
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
        return p.d(this.algorithmId, algorithmAbilities.algorithmId) && p.d(this.category, algorithmAbilities.category) && p.d(this.description, algorithmAbilities.description) && this.supported == algorithmAbilities.supported;
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
        return (((((this.algorithmId.hashCode() * 31) + this.category.hashCode()) * 31) + this.description.hashCode()) * 31) + Boolean.hashCode(this.supported);
    }

    public String toString() {
        return "AlgorithmAbilities(algorithmId=" + this.algorithmId + ", category=" + this.category + ", description=" + this.description + ", supported=" + this.supported + ")";
    }

    public /* synthetic */ AlgorithmAbilities(String str, String str2, String str3, boolean z10, int i10, i iVar) {
        this(str, str2, (i10 & 4) != 0 ? "" : str3, (i10 & 8) != 0 ? false : z10);
    }
}
