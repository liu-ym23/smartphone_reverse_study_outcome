package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.RoomFeedData")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\f\"\u0004\b\u001b\u0010\u000eR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/RoomFeedData;", "", "()V", "cutPosition", "Lcom/bytedance/android/livesdkapi/depend/model/live/StreamCutPosition;", "getCutPosition", "()Lcom/bytedance/android/livesdkapi/depend/model/live/StreamCutPosition;", "setCutPosition", "(Lcom/bytedance/android/livesdkapi/depend/model/live/StreamCutPosition;)V", "distributionSceneId", "", "getDistributionSceneId", "()Ljava/lang/String;", "setDistributionSceneId", "(Ljava/lang/String;)V", "drawerConfig", "Lcom/bytedance/android/livesdkapi/depend/model/live/DrawerConfig;", "getDrawerConfig", "()Lcom/bytedance/android/livesdkapi/depend/model/live/DrawerConfig;", "setDrawerConfig", "(Lcom/bytedance/android/livesdkapi/depend/model/live/DrawerConfig;)V", "followTopAppearance", "Lcom/bytedance/android/livesdkapi/depend/model/live/FollowTopAppearance;", "getFollowTopAppearance", "()Lcom/bytedance/android/livesdkapi/depend/model/live/FollowTopAppearance;", "moduleTitle", "getModuleTitle", "setModuleTitle", "relationLabel", "Lcom/bytedance/android/livesdkapi/depend/model/live/LabelInfo;", "getRelationLabel", "()Lcom/bytedance/android/livesdkapi/depend/model/live/LabelInfo;", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomFeedData implements h {

    @SerializedName("cut_position")
    protected StreamCutPosition cutPosition;

    @SerializedName("distribution_scene_id")
    protected String distributionSceneId;

    @SerializedName("drawer_config")
    protected DrawerConfig drawerConfig;

    @SerializedName("follow_top_appearance")
    protected FollowTopAppearance followTopAppearance;

    @IgnoreProtoFieldCheck
    @SerializedName("module_title")
    protected String moduleTitle;

    @SerializedName("relation_label")
    protected LabelInfo relationLabel;

    public RoomFeedData() {
        this.moduleTitle = "";
    }

    public final StreamCutPosition getCutPosition() {
        return this.cutPosition;
    }

    public final String getDistributionSceneId() {
        return this.distributionSceneId;
    }

    public final DrawerConfig getDrawerConfig() {
        return this.drawerConfig;
    }

    public final FollowTopAppearance getFollowTopAppearance() {
        return this.followTopAppearance;
    }

    public final String getModuleTitle() {
        return this.moduleTitle;
    }

    public final LabelInfo getRelationLabel() {
        return this.relationLabel;
    }

    public RoomFeedData(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L24;
        if (r102 != 1) goto L8;
        this.relationLabel = new LabelInfo(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.followTopAppearance = new FollowTopAppearance(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.cutPosition = new StreamCutPosition(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.drawerConfig = new DrawerConfig(r100);
        goto L3
    L14:
        if (r102 != 7) goto L16;
        this.moduleTitle = am3.h.c(r100);
        goto L3
    L16:
        if (r102 != 9) goto L17;
        this.distributionSceneId = am3.h.c(r100);
        goto L3
    L17:
        am3.h.e(r100);
        goto L3
    L24:
        r100.d(r101);
        if (this.moduleTitle != null) goto L49;
        this.moduleTitle = "";
        return;
    }

    public final void setCutPosition(StreamCutPosition r100) {
        this.cutPosition = r100;
    }

    public final void setDistributionSceneId(String r100) {
        this.distributionSceneId = r100;
    }

    public final void setDrawerConfig(DrawerConfig r100) {
        this.drawerConfig = r100;
    }

    public final void setModuleTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.moduleTitle = r100;
    }
}
