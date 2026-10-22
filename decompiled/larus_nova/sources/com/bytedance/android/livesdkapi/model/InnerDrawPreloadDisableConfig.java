package com.bytedance.android.livesdkapi.model;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/InnerDrawPreloadDisableConfig;", "", "seiVer", "", "subScene", "(II)V", "getSeiVer", "()I", "setSeiVer", "(I)V", "getSubScene", "setSubScene", "Companion", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InnerDrawPreloadDisableConfig {
    public static final Companion Companion = null;

    @SerializedName("ver")
    private int seiVer;

    @SerializedName(BdpAppEventConstant.PARAMS_SUB_SCENE)
    private int subScene;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/InnerDrawPreloadDisableConfig$Companion;", "", "()V", "defaultDisableList", "", "Lcom/bytedance/android/livesdkapi/model/InnerDrawPreloadDisableConfig;", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public final List<InnerDrawPreloadDisableConfig> defaultDisableList() {
            return CollectionsKt.listOf(new InnerDrawPreloadDisableConfig(3, 9));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public InnerDrawPreloadDisableConfig() {
        int r100 = 0;
        this(r100, r100, 3, null);
    }

    public final int getSeiVer() {
        return this.seiVer;
    }

    public final int getSubScene() {
        return this.subScene;
    }

    public final void setSeiVer(int r100) {
        this.seiVer = r100;
    }

    public final void setSubScene(int r100) {
        this.subScene = r100;
    }

    public InnerDrawPreloadDisableConfig(int r100, int r101) {
        this.seiVer = r100;
        this.subScene = r101;
    }

    public /* synthetic */ InnerDrawPreloadDisableConfig(int r100, int r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = -1;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = -1;
    L8:
        this(r100, r101);
    }
}
