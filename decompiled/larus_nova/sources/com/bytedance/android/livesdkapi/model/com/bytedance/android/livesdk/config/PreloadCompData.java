package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/PreloadCompData;", "", "()V", "enableComment", "", "getEnableComment", "()Z", "setEnableComment", "(Z)V", "enablePublicScreen", "getEnablePublicScreen", "setEnablePublicScreen", "enableToolbar", "getEnableToolbar", "setEnableToolbar", "toolbarPreloadIds", "", "", "getToolbarPreloadIds", "()Ljava/util/List;", "setToolbarPreloadIds", "(Ljava/util/List;)V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreloadCompData {

    @SerializedName("enable_comment")
    private boolean enableComment;

    @SerializedName("enable_public_screen")
    private boolean enablePublicScreen;

    @SerializedName("enable_toolbar")
    private boolean enableToolbar;

    @SerializedName("toolbar_preload_ids")
    private List<Integer> toolbarPreloadIds;

    public PreloadCompData() {
        this.toolbarPreloadIds = CollectionsKt.listOf(new Integer[]{20, 24});
    }

    public final boolean getEnableComment() {
        return this.enableComment;
    }

    public final boolean getEnablePublicScreen() {
        return this.enablePublicScreen;
    }

    public final boolean getEnableToolbar() {
        return this.enableToolbar;
    }

    public final List<Integer> getToolbarPreloadIds() {
        return this.toolbarPreloadIds;
    }

    public final void setEnableComment(boolean r100) {
        this.enableComment = r100;
    }

    public final void setEnablePublicScreen(boolean r100) {
        this.enablePublicScreen = r100;
    }

    public final void setEnableToolbar(boolean r100) {
        this.enableToolbar = r100;
    }

    public final void setToolbarPreloadIds(List<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.toolbarPreloadIds = r100;
    }
}
