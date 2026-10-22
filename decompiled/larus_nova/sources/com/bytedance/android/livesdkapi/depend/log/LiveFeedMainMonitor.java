package com.bytedance.android.livesdkapi.depend.log;

import android.text.TextUtils;
import com.bytedance.android.livesdk.utils.LiveLoggerUtil;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import om0.c;
import pm0.b;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JD\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0007J2\u0010\u0010\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0002JD\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/log/LiveFeedMainMonitor;", "", "()V", "LIVE_SCENE_FEED", "", "LIVE_SCENE_INNER_DRAW", "LIVE_SCENE_ROOM", "TAG", "errorFeedLog", "", "scene", "methodName", "roomId", "anchorName", "uniqueId", "extra", "handleCommonInfo", "printFeedLog", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveFeedMainMonitor {
    public static final LiveFeedMainMonitor INSTANCE = null;
    public static final String LIVE_SCENE_FEED = "feed";
    public static final String LIVE_SCENE_INNER_DRAW = "inder_draw";
    public static final String LIVE_SCENE_ROOM = "room";
    public static final String TAG = "LiveFeedLog";

    private LiveFeedMainMonitor() {
    }

    static {
        INSTANCE = new LiveFeedMainMonitor();
    }

    private final String handleCommonInfo(String r100, String r101, String r102, String r103) {
        StringBuilder r104 = new StringBuilder();
        if (TextUtils.isEmpty(r100) == true) goto L6;
        r104.append("roomId=" + r100);
    L6:
        if (TextUtils.isEmpty(r101) == true) goto L9;
        r104.append(",");
        r104.append("anchorName=" + r101);
    L9:
        if (TextUtils.isEmpty(r102) == true) goto L12;
        r104.append(",");
        r104.append("uniqueId=" + r102);
    L12:
        if (TextUtils.isEmpty(r103) == true) goto L15;
        r104.append(",");
        r104.append("extra=" + r103);
    L15:
        return r104.toString();
    }

    @JvmStatic
    public static final void errorFeedLog(String r100, String r101, String r102, String r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        LiveLoggerUtil r106 = LiveLoggerUtil.f158753b;
        String r107 = r100 + "->" + r101 + ", [" + INSTANCE.handleCommonInfo(r102, r103, r104, r105) + ']';
        r106.getClass();
        Intrinsics.checkNotNullParameter(TAG, "tag");
        b r108 = c.f();
        if (r108 == null) goto L6;
        r108.e(TAG, r107);
        return;
    }

    @JvmStatic
    public static final void printFeedLog(String r100, String r101, String r102, String r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        LiveLoggerUtil r106 = LiveLoggerUtil.f158753b;
        String r107 = r100 + "->" + r101 + ", [" + INSTANCE.handleCommonInfo(r102, r103, r104, r105) + ']';
        r106.getClass();
        Intrinsics.checkNotNullParameter(TAG, "tag");
        b r108 = c.f();
        if (r108 == null) goto L6;
        r108.i(TAG, r107);
        return;
    }

    public static /* synthetic */ String handleCommonInfo$default(LiveFeedMainMonitor r100, String r101, String r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 8) == 0) goto L6;
        r104 = "";
    L6:
        return r100.handleCommonInfo(r101, r102, r103, r104);
    }

    public static /* synthetic */ void errorFeedLog$default(String r100, String r101, String r102, String r103, String r110, String r111, int r112, Object r113) {
        if ((r112 & 32) == 0) goto L5;
        r111 = "";
    L5:
        errorFeedLog(r100, r101, r102, r103, r110, r111);
    }

    public static /* synthetic */ void printFeedLog$default(String r100, String r101, String r102, String r103, String r110, String r111, int r112, Object r113) {
        if ((r112 & 32) == 0) goto L5;
        r111 = "";
    L5:
        printFeedLog(r100, r101, r102, r103, r110, r111);
    }
}
