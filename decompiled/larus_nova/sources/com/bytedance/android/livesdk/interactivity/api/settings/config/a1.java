package com.bytedance.android.livesdk.interactivity.api.settings.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import r52.k4;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/settings/config/a1;", "", "", "enable", "Z", "d", "()Z", "setEnable", "(Z)V", "enableLandscapeDrawContour", "getEnableLandscapeDrawContour", "setEnableLandscapeDrawContour", "contourCanDrawEdge", "getContourCanDrawEdge", "setContourCanDrawEdge", "enableDrawDanmakuEdge", "getEnableDrawDanmakuEdge", "setEnableDrawDanmakuEdge", "mockWrds", "getMockWrds", "setMockWrds", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f133760a = 0;

    @SerializedName("landscape_contour_can_draw_edge")
    private boolean contourCanDrawEdge;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("landscape_enable_danmaku_edge")
    private boolean enableDrawDanmakuEdge;

    @SerializedName("enable_landscape_draw_contour")
    private boolean enableLandscapeDrawContour;

    @SerializedName("mock_wrds")
    private boolean mockWrds;

    public static final class a {
        @JvmStatic
        public static a1 a() {
            return k4.f536210a.getValue();
        }
    }

    static {
    }

    public final boolean a() {
        if (this.enable == true) goto L5;
    L7:
        return false;
    L5:
        if (this.contourCanDrawEdge == false) goto L7;
        return true;
    }

    public final boolean b() {
        if (this.enable == true) goto L5;
    L7:
        return false;
    L5:
        if (this.enableDrawDanmakuEdge == false) goto L7;
        return true;
    }

    public final boolean c() {
        if (this.enable == true) goto L5;
    L7:
        return false;
    L5:
        if (this.enableLandscapeDrawContour == false) goto L7;
        return true;
    }

    public a1() {
        this.enable = true;
        this.enableLandscapeDrawContour = true;
        this.contourCanDrawEdge = true;
        this.enableDrawDanmakuEdge = true;
    }

    public final boolean d() {
        return this.enable;
    }
}
