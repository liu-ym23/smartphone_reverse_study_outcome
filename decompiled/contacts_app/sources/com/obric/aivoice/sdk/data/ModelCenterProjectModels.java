package com.obric.aivoice.sdk.data;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Global.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u0003¢\u0006\u0002\u0010\u0006J\u001b\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u0003HÆ\u0003J%\u0010\u000b\u001a\u00020\u00002\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001R,\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/obric/aivoice/sdk/data/ModelCenterProjectModels;", "", "scenes", "", "", "", "(Ljava/util/Map;)V", "getScenes", "()Ljava/util/Map;", "setScenes", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "voicesdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ModelCenterProjectModels {
    private Map<String, String[]> scenes;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModelCenterProjectModels copy$default(ModelCenterProjectModels r0, Map r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.scenes;
    L6:
        return r0.copy(r1);
    }

    public final Map<String, String[]> component1() {
        return this.scenes;
    }

    public final ModelCenterProjectModels copy(Map<String, String[]> r1) {
        Intrinsics.checkNotNullParameter(r1, "scenes");
        return new ModelCenterProjectModels(r1);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof ModelCenterProjectModels) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.scenes, ((ModelCenterProjectModels) r4).scenes) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.scenes.hashCode();
    }

    public String toString() {
        return "ModelCenterProjectModels(scenes=" + this.scenes + ')';
    }

    public ModelCenterProjectModels(Map<String, String[]> r2) {
        Intrinsics.checkNotNullParameter(r2, "scenes");
        this.scenes = r2;
    }

    public final Map<String, String[]> getScenes() {
        return this.scenes;
    }

    public final void setScenes(Map<String, String[]> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.scenes = r2;
    }
}
