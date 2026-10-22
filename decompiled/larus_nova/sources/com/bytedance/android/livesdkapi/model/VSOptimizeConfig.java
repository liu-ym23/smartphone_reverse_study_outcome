package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0010\u0006\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR$\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR\u001e\u0010\"\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\b¨\u0006%"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/VSOptimizeConfig;", "", "()V", "enterRoom", "", "getEnterRoom", "()Z", "setEnterRoom", "(Z)V", "interactionLazy", "getInteractionLazy", "setInteractionLazy", "interactionLazyTime", "", "getInteractionLazyTime", "()J", "setInteractionLazyTime", "(J)V", "multiCamera", "getMultiCamera", "setMultiCamera", "multiTabH5", "getMultiTabH5", "setMultiTabH5", "priorityList", "", "", "getPriorityList", "()Ljava/util/List;", "setPriorityList", "(Ljava/util/List;)V", "scope", "getScope", "setScope", "seek", "getSeek", "setSeek", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSOptimizeConfig {

    @SerializedName("enter_room")
    private boolean enterRoom;

    @SerializedName("interaction_lazy")
    private boolean interactionLazy;

    @SerializedName("interaction_lazy_time")
    private long interactionLazyTime;

    @SerializedName("multi_camera")
    private boolean multiCamera;

    @SerializedName("multi_tab_h5")
    private boolean multiTabH5;

    @SerializedName("p3_split_priority_list")
    private List<Double> priorityList;

    @SerializedName("scope")
    private boolean scope;

    @SerializedName("seek")
    private boolean seek;

    public VSOptimizeConfig() {
        this.priorityList = CollectionsKt.listOf(new Double[]{Double.valueOf(4.1d), Double.valueOf(4.2d), Double.valueOf(4.3d), Double.valueOf(4.9d)});
        this.interactionLazyTime = 100;
    }

    public final boolean getEnterRoom() {
        return this.enterRoom;
    }

    public final boolean getInteractionLazy() {
        return this.interactionLazy;
    }

    public final long getInteractionLazyTime() {
        return this.interactionLazyTime;
    }

    public final boolean getMultiCamera() {
        return this.multiCamera;
    }

    public final boolean getMultiTabH5() {
        return this.multiTabH5;
    }

    public final List<Double> getPriorityList() {
        return this.priorityList;
    }

    public final boolean getScope() {
        return this.scope;
    }

    public final boolean getSeek() {
        return this.seek;
    }

    public final void setEnterRoom(boolean r100) {
        this.enterRoom = r100;
    }

    public final void setInteractionLazy(boolean r100) {
        this.interactionLazy = r100;
    }

    public final void setInteractionLazyTime(long r100) {
        this.interactionLazyTime = r100;
    }

    public final void setMultiCamera(boolean r100) {
        this.multiCamera = r100;
    }

    public final void setMultiTabH5(boolean r100) {
        this.multiTabH5 = r100;
    }

    public final void setPriorityList(List<Double> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.priorityList = r100;
    }

    public final void setScope(boolean r100) {
        this.scope = r100;
    }

    public final void setSeek(boolean r100) {
        this.seek = r100;
    }
}
