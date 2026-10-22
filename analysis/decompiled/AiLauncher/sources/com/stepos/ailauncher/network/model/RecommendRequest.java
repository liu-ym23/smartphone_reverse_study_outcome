package com.stepos.ailauncher.network.model;

import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilityContract;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/network/model/RecommendRequest;", "", HomeGestureEligibilityContract.EXTRA_SCENE, "", "count", "", "<init>", "(Ljava/lang/String;I)V", "getScene", "()Ljava/lang/String;", "getCount", "()I", "component1", "component2", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "toString", "network_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class RecommendRequest {

    @SerializedName("count")
    private final int count;

    @SerializedName(HomeGestureEligibilityContract.EXTRA_SCENE)
    private final String scene;

    public RecommendRequest(String scene, int i10) {
        p.i(scene, "scene");
        this.scene = scene;
        this.count = i10;
    }

    public static /* synthetic */ RecommendRequest copy$default(RecommendRequest recommendRequest, String str, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = recommendRequest.scene;
        }
        if ((i11 & 2) != 0) {
            i10 = recommendRequest.count;
        }
        return recommendRequest.copy(str, i10);
    }

    /* renamed from: component1, reason: from getter */
    public final String getScene() {
        return this.scene;
    }

    /* renamed from: component2, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    public final RecommendRequest copy(String scene, int count) {
        p.i(scene, "scene");
        return new RecommendRequest(scene, count);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RecommendRequest)) {
            return false;
        }
        RecommendRequest recommendRequest = (RecommendRequest) other;
        return p.d(this.scene, recommendRequest.scene) && this.count == recommendRequest.count;
    }

    public final int getCount() {
        return this.count;
    }

    public final String getScene() {
        return this.scene;
    }

    public int hashCode() {
        return (this.scene.hashCode() * 31) + Integer.hashCode(this.count);
    }

    public String toString() {
        return "RecommendRequest(scene=" + this.scene + ", count=" + this.count + ")";
    }

    public /* synthetic */ RecommendRequest(String str, int i10, int i11, i iVar) {
        this((i11 & 1) != 0 ? "default" : str, i10);
    }
}
