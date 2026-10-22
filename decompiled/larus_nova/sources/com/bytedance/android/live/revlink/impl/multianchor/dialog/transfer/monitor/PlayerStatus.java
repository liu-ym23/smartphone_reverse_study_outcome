package com.bytedance.android.live.revlink.impl.multianchor.dialog.transfer.monitor;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/transfer/monitor/PlayerStatus;", "", "", "toString", "", "code", "I", "getCode", "()I", "description", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "ERROR_CODE_NO_ERROR", "ERROR_CODE_LAYOUT_PARAM_MISMATCH", "ERROR_CODE_LAYOUT_PARAM_INVISIBLE", "ERROR_CODE_TOP_BG_ROOT_DIFF", "ERROR_CODE_BOTTOM_BG_ROOT_DIFF", "ERROR_CODE_TOP_BG_BELOW_RENDER", "ERROR_CODE_BOTTOM_BG_BELOW_RENDER", "ERROR_CODE_RENDER_SEI_DIFF", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum PlayerStatus extends Enum<PlayerStatus> {
    public static final PlayerStatus ERROR_CODE_BOTTOM_BG_BELOW_RENDER = null;
    public static final PlayerStatus ERROR_CODE_BOTTOM_BG_ROOT_DIFF = null;
    public static final PlayerStatus ERROR_CODE_LAYOUT_PARAM_INVISIBLE = null;
    public static final PlayerStatus ERROR_CODE_LAYOUT_PARAM_MISMATCH = null;
    public static final PlayerStatus ERROR_CODE_NO_ERROR = null;
    public static final PlayerStatus ERROR_CODE_RENDER_SEI_DIFF = null;
    public static final PlayerStatus ERROR_CODE_TOP_BG_BELOW_RENDER = null;
    public static final PlayerStatus ERROR_CODE_TOP_BG_ROOT_DIFF = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PlayerStatus[] f93718a = null;
    private final int code;
    private final String description;

    public static PlayerStatus valueOf(String r100) {
        return (PlayerStatus) a.a(PlayerStatus.class, r100);
    }

    public static PlayerStatus[] values() {
        return (PlayerStatus[]) f93718a.clone();
    }

    static {
        PlayerStatus r100 = new PlayerStatus("ERROR_CODE_NO_ERROR", 0, 0, "multiPlayerNoError");
        ERROR_CODE_NO_ERROR = r100;
        PlayerStatus r101 = new PlayerStatus("ERROR_CODE_LAYOUT_PARAM_MISMATCH", 1, 1, "multiPlayerLayoutParamMismatch");
        ERROR_CODE_LAYOUT_PARAM_MISMATCH = r101;
        PlayerStatus r102 = new PlayerStatus("ERROR_CODE_LAYOUT_PARAM_INVISIBLE", 2, 2, "multiPlayerLayoutParamInvisible");
        ERROR_CODE_LAYOUT_PARAM_INVISIBLE = r102;
        PlayerStatus r103 = new PlayerStatus("ERROR_CODE_TOP_BG_ROOT_DIFF", 3, 3, "multiPlayerTopBgRootDiff");
        ERROR_CODE_TOP_BG_ROOT_DIFF = r103;
        PlayerStatus r104 = new PlayerStatus("ERROR_CODE_BOTTOM_BG_ROOT_DIFF", 4, 4, "multiPlayerBottomBgRootDiff");
        ERROR_CODE_BOTTOM_BG_ROOT_DIFF = r104;
        PlayerStatus r105 = new PlayerStatus("ERROR_CODE_TOP_BG_BELOW_RENDER", 5, 5, "multiPlayerTopBgBelowRender");
        ERROR_CODE_TOP_BG_BELOW_RENDER = r105;
        PlayerStatus r106 = new PlayerStatus("ERROR_CODE_BOTTOM_BG_BELOW_RENDER", 6, 6, "multiPlayerBottomBgBelowRender");
        ERROR_CODE_BOTTOM_BG_BELOW_RENDER = r106;
        PlayerStatus r107 = new PlayerStatus("ERROR_CODE_RENDER_SEI_DIFF", 7, 7, "multiPlayerRenderSeiDiff");
        ERROR_CODE_RENDER_SEI_DIFF = r107;
        f93718a = new PlayerStatus[]{r100, r101, r102, r103, r104, r105, r106, r107};
    }

    public final int getCode() {
        return this.code;
    }

    public final String getDescription() {
        return this.description;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.description;
    }

    public PlayerStatus(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.code = r102;
        this.description = r103;
    }
}
