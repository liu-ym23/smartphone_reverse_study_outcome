package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u000b\"\u0004\b\u0012\u0010\rR\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PlayerSurfaceRenderConfig;", "", "enableClick", "", "hasSurfaceRender", "enableFeed", "isCheckAbnormalCase", "isCheckAbnormalCaseAdd", "surfaceScrollRefactor", "(ZZZZZZ)V", "getEnableClick", "()Z", "setEnableClick", "(Z)V", "getEnableFeed", "setEnableFeed", "getHasSurfaceRender", "setHasSurfaceRender", "setCheckAbnormalCase", "setCheckAbnormalCaseAdd", "getSurfaceScrollRefactor", "setSurfaceScrollRefactor", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerSurfaceRenderConfig {

    @SerializedName("surface_render_click")
    private boolean enableClick;

    @SerializedName("surface_render_feed")
    private boolean enableFeed;

    @SerializedName("has_surface_render")
    private boolean hasSurfaceRender;

    @SerializedName("check_abnormal_case")
    private boolean isCheckAbnormalCase;

    @SerializedName("check_abnormal_case_add")
    private boolean isCheckAbnormalCaseAdd;

    @SerializedName("surface_scroll_refactor")
    private boolean surfaceScrollRefactor;

    public PlayerSurfaceRenderConfig() {
        this(false, false, false, false, false, false, 63, null);
    }

    public final boolean getEnableClick() {
        return this.enableClick;
    }

    public final boolean getEnableFeed() {
        return this.enableFeed;
    }

    public final boolean getHasSurfaceRender() {
        return this.hasSurfaceRender;
    }

    public final boolean getSurfaceScrollRefactor() {
        return this.surfaceScrollRefactor;
    }

    public final boolean isCheckAbnormalCase() {
        return this.isCheckAbnormalCase;
    }

    public final boolean isCheckAbnormalCaseAdd() {
        return this.isCheckAbnormalCaseAdd;
    }

    public final void setCheckAbnormalCase(boolean r100) {
        this.isCheckAbnormalCase = r100;
    }

    public final void setCheckAbnormalCaseAdd(boolean r100) {
        this.isCheckAbnormalCaseAdd = r100;
    }

    public final void setEnableClick(boolean r100) {
        this.enableClick = r100;
    }

    public final void setEnableFeed(boolean r100) {
        this.enableFeed = r100;
    }

    public final void setHasSurfaceRender(boolean r100) {
        this.hasSurfaceRender = r100;
    }

    public final void setSurfaceScrollRefactor(boolean r100) {
        this.surfaceScrollRefactor = r100;
    }

    public PlayerSurfaceRenderConfig(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105) {
        this.enableClick = r100;
        this.hasSurfaceRender = r101;
        this.enableFeed = r102;
        this.isCheckAbnormalCase = r103;
        this.isCheckAbnormalCaseAdd = r104;
        this.surfaceScrollRefactor = r105;
    }

    public /* synthetic */ PlayerSurfaceRenderConfig(boolean r100, boolean r101, boolean r102, boolean r103, boolean r110, boolean r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        boolean r114 = false;
    L7:
        if ((r112 & 2) == 0) goto L9;
        boolean r104 = false;
    L11:
        if ((r112 & 4) == 0) goto L13;
        boolean r105 = false;
    L15:
        if ((r112 & 8) == 0) goto L17;
        boolean r106 = false;
    L19:
        if ((r112 & 16) == 0) goto L21;
        boolean r107 = false;
    L23:
        if ((r112 & 32) == 0) goto L25;
        boolean r115 = false;
    L26:
        this(r114, r104, r105, r106, r107, r115);
        return;
    L25:
        r115 = r111;
        goto L26
    L21:
        r107 = r110;
        goto L23
    L17:
        r106 = r103;
        goto L19
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L7
    }
}
