package com.bytedance.android.ec.core.anchorv3;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0017R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0014\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R\u001a\u0010\u0016\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\u001a\u0010\u0018\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0011R\u001a\u0010\u001a\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006R\u001a\u0010\u001c\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001d\u0010\u0011R\u001a\u0010\u001e\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006R\u001a\u0010 \u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006R\u001a\u0010#\u001a\u00020\"8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lcom/bytedance/android/ec/core/anchorv3/n;", "", "", "optImage", "Z", ce.f26391f, "()Z", "optMainThread", RXScreenCaptureService.KEY_INDEX, "optPreloadLayout", ce.f26395j, "optDelayTopNavEvent", "e", "", "headImagePreloadNum", "I", "d", "()I", "detailImagePreloadNum", "b", "detailImagePreloadStrategy", "c", "detailImagePreloadAsync", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "optResponseParse", ce.f26396k, "optEnterPerf25Q3", "f", "optEnterPerf25Q4", "getOptEnterPerf25Q4", "optImageFlicker", "h", "optWireframeBitmap", "l", "", "delayInitDuration", "J", "getDelayInitDuration", "()J", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class n {

    @SerializedName("delay_init_duration")
    private final long delayInitDuration;

    @SerializedName("detail_image_preload_async")
    private final boolean detailImagePreloadAsync;

    @SerializedName("detail_image_preload_num")
    private final int detailImagePreloadNum;

    @SerializedName("detail_image_preload_strategy")
    private final int detailImagePreloadStrategy;

    @SerializedName("head_image_preload_num")
    private final int headImagePreloadNum;

    @SerializedName("opt_delay_top_nav_event")
    private final boolean optDelayTopNavEvent;

    @SerializedName("opt_enter_perf_25_q3")
    private final boolean optEnterPerf25Q3;

    @SerializedName("opt_enter_perf_25_q4")
    private final int optEnterPerf25Q4;

    @SerializedName("opt_image")
    private final boolean optImage;

    @SerializedName("opt_image_flicker")
    private final boolean optImageFlicker;

    @SerializedName("opt_main_thread_v2")
    private final boolean optMainThread;

    @SerializedName("opt_preload_layout")
    private final boolean optPreloadLayout;

    @SerializedName("opt_response_parse")
    private final int optResponseParse;

    @SerializedName("opt_wireframe_bitmap")
    private final boolean optWireframeBitmap;

    public static final class a {
    }

    static {
    }

    public n() {
        this(false, false, false, 0, 0, false, 0, false, 0, 16383);
    }

    public final boolean a() {
        return this.detailImagePreloadAsync;
    }

    public final int b() {
        return this.detailImagePreloadNum;
    }

    public final int c() {
        return this.detailImagePreloadStrategy;
    }

    public final int d() {
        return this.headImagePreloadNum;
    }

    public final boolean e() {
        return this.optDelayTopNavEvent;
    }

    public final boolean f() {
        return this.optEnterPerf25Q3;
    }

    public final boolean g() {
        return this.optImage;
    }

    public final boolean h() {
        return this.optImageFlicker;
    }

    public final boolean i() {
        return this.optMainThread;
    }

    public final boolean j() {
        return this.optPreloadLayout;
    }

    public final int k() {
        return this.optResponseParse;
    }

    public final boolean l() {
        return this.optWireframeBitmap;
    }

    public final boolean m(int r100) {
        if ((this.optEnterPerf25Q4 & r100) != r100) goto L5;
        return true;
    L5:
        return false;
    }

    public n(boolean r210, boolean r211, boolean r212, int r213, int r214, boolean r215, int r216, boolean r217, int r218, int r219) {
        if ((r219 & 1) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r219 & 2) == 0) goto L9;
        boolean r101 = false;
    L11:
        if ((r219 & 4) == 0) goto L13;
        boolean r102 = false;
    L14:
        boolean r103 = true;
        if ((r219 & 8) == 0) goto L17;
        boolean r104 = true;
    L19:
        if ((r219 & 16) == 0) goto L21;
        int r105 = 0;
    L23:
        if ((r219 & 32) == 0) goto L25;
        int r106 = 0;
    L27:
        if ((r219 & 128) == 0) goto L29;
        boolean r110 = false;
    L31:
        if ((r219 & 256) == 0) goto L33;
        int r111 = 0;
    L35:
        if ((r219 & 512) == 0) goto L37;
        boolean r112 = false;
    L39:
        if ((r219 & 1024) == 0) goto L41;
        int r113 = 0;
    L43:
        if ((r219 & 2048) == 0) goto L45;
        boolean r114 = true;
    L47:
        if ((r219 & 4096) != 0) goto L51;
        r103 = false;
    L51:
        if ((r219 & 8192) == 0) goto L53;
        long r115 = 5000;
    L54:
        this.optImage = r100;
        this.optMainThread = r101;
        this.optPreloadLayout = r102;
        this.optDelayTopNavEvent = r104;
        this.headImagePreloadNum = r105;
        this.detailImagePreloadNum = r106;
        this.detailImagePreloadStrategy = 0;
        this.detailImagePreloadAsync = r110;
        this.optResponseParse = r111;
        this.optEnterPerf25Q3 = r112;
        this.optEnterPerf25Q4 = r113;
        this.optImageFlicker = r114;
        this.optWireframeBitmap = r103;
        this.delayInitDuration = r115;
        return;
    L53:
        r115 = 0;
        goto L54
    L45:
        r114 = false;
        goto L47
    L41:
        r113 = r218;
        goto L43
    L37:
        r112 = r217;
        goto L39
    L33:
        r111 = r216;
        goto L35
    L29:
        r110 = r215;
        goto L31
    L25:
        r106 = r214;
        goto L27
    L21:
        r105 = r213;
        goto L23
    L17:
        r104 = false;
        goto L19
    L13:
        r102 = r212;
        goto L14
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
