package com.bytedance.android.livesdk.chatroom.vs_base.util;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VideoResolutionItem;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.model.VideoRef;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f118208a = 0;

    public r() {
    }

    public static q d() {
        ReplayPlayUtil$getVideoEngineFactory$1 r100 = ReplayPlayUtil$getVideoEngineFactory$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r100, "onRemedyAction");
        return new q(r100);
    }

    static {
    }

    public static Resolution a(VideoModel r110) {
        Intrinsics.checkNotNullParameter(r110, "videoModel");
        com.bytedance.android.livesdk.sharedpref.e<VideoResolutionItem> r100 = nq1.d.f520093b;
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.l.c(r100.getValue().getKey()) == false) goto L5;
        com.bytedance.android.livesdk.sharedpref.f.d(r100, nq1.d.f520092a.getValue());
    L5:
        VideoResolutionItem r101 = r100.getValue();
        com.bytedance.android.livesdk.sharedpref.e<VideoResolutionItem> r102 = nq1.d.f520092a;
        r102.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r102, r101);
        Resolution[] r111 = r110.getSupportResolutions();
        if (TextUtils.isEmpty(r101.getKey()) == true) goto L39;
        Resolution r103 = null;
        if (r111 == null) goto L19;
        int r104 = r111.length;
        int r105 = 0;
    L10:
        if (r105 >= r104) goto L15;
        Resolution r106 = r111[r105];
        if (Intrinsics.areEqual(r106.toString(VideoRef.TYPE_VIDEO), r101.getKey()) == true) goto L16;
        r105 = r105 + 1;
    L16:
        if (r106 == null) goto L19;
    L18:
        r103 = r106;
    L36:
        if (r103 == null) goto L45;
        return r103;
    L45:
        return com.bytedance.android.livesdk.chatroom.vs_base.base.util.l.a(r111, jc1.a.b());
    L15:
        r106 = null;
    L19:
        if (r111 == null) goto L36;
        int r107 = r111.length;
        int r108 = 0;
    L21:
        if (r108 >= r107) goto L36;
        r106 = r111[r108];
        String r109 = r106.toString(VideoRef.TYPE_VIDEO);
        String r112 = r101.getKey();
        if (r112 != null) goto L25;
        r112 = "null";
    L25:
        boolean r113 = StringsKt.contains$default(r109, r112, false, 2, null);
        boolean r114 = true;
        if (r113 == true) goto L33;
        String r115 = r101.getKey();
        if (r115 != null) goto L30;
    L32:
        r114 = false;
        goto L33
    L30:
        if (StringsKt.contains$default(r115, r106.toString(VideoRef.TYPE_VIDEO), false, 2, null) != true) goto L32;
    L33:
        if (r114 == true) goto L18;
        r108 = r108 + 1;
        goto L21
    L39:
        return com.bytedance.android.livesdk.chatroom.vs_base.base.util.l.a(r111, jc1.a.b());
    }

    public static VideoModel e(String r100) {
        if (r100 == null) goto L10;
        VideoRef r101 = new VideoRef();
        r101.extractFields(new JSONObject(r100));     // Catch: Throwable -> L6
    L8:
        VideoModel r102 = new VideoModel();
        r102.setVideoRef(r101);
        return r102;
    L6:
        th = move-exception;
        th.printStackTrace();
        goto L8
    L10:
        return null;
    }

    public static /* synthetic */ u c(jq1.c r110, long r111, long r112, int r113) {
        return b(0, r110, -1, r111, r112, r113, 0, true, -1L);
    }

    public static u b(long r210, jq1.c r211, long r212, long r213, long r310, int r311, int r312, boolean r313, Long r314) {
        Intrinsics.checkNotNullParameter(r211, "localProgress");
        if (r210 >= r211.f500021b) goto L7;
        long r100 = r211.f500020a;
        if (r100 == 0) goto L7;
    L8:
        long r110 = r311;
        if (r100 < (r110 - 5000)) goto L13;
        r100 = 0;
    L13:
        if (r310 <= 0) goto L16;
        r100 = r310;
        int r111 = 2;
    L22:
        long r101 = r100 + ((long) r312);
        if (r101 < r110) goto L25;
    L26:
        r101 = 0;
        r111 = 0;
    L27:
        if (r313 == true) goto L39;
        long r112 = -1;
        if (r314 == null) goto L31;
        long r214 = r314.longValue();
    L32:
        long r113 = 0;
        if (r214 <= 0) goto L40;
        if (r314 == null) goto L37;
        r112 = r314.longValue();
    L37:
        if (r101 <= ((r112 - ((long) 2)) * 1000)) goto L40;
        long r114 = 0;
        int r102 = 0;
    L42:
        if (r102 == 1) goto L44;
    L54:
        ALogger.e("ReplayPlayUtil", "getStartTime params(serverTs:" + r210 + " localProgress:" + r211 + " videoStartPosition:" + r212 + " startPosition:" + r213 + " duration:" + r311 + " progressOffset:" + r312 + " hasFullRight:" + r313 + " freeDuration:" + r314 + ") return(progress:" + r114 + " startPositionType:" + r102 + ")");
        return new u(r114, r102);
    L44:
        if (r114 > 10000) goto L46;
    L53:
        r114 = r113;
        r102 = 0;
        goto L54
    L46:
        if (r114 >= r110) goto L53;
        if (r114 < r110) goto L50;
    L52:
        r114 = r114 - 10000;
        goto L54
    L50:
        if (r114 < (r110 - 10000)) goto L52;
    L40:
        r114 = r101;
        r102 = r111;
        goto L42
    L31:
        r214 = -1;
        goto L32
    L39:
        r113 = 0;
        goto L40
    L25:
        if (r101 >= 0) goto L27;
    L16:
        if (r213 <= 0) goto L19;
        r100 = r213;
        r111 = 4;
        goto L22
    L19:
        if (r100 <= 0) goto L21;
        r111 = 1;
        goto L22
    L21:
        r100 = 0;
        r111 = 0;
    L7:
        r100 = r212;
        goto L8
    }
}
