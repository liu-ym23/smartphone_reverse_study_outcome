package com.bytedance.android.gamecp.common.track;

import com.bytedance.android.gamecp.common.track.filter.GameInfoFilter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/gamecp/common/track/GPCommonFilterName;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "BIZ_INFO", "CONTENT_INFO", "TRAFFIC_INFO", "GAME_INFO", "USER_INFO", "VIEW_TRACK_INFO", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum GPCommonFilterName extends Enum<GPCommonFilterName> {
    public static final GPCommonFilterName BIZ_INFO = null;
    public static final GPCommonFilterName CONTENT_INFO = null;
    public static final a Companion = null;
    public static final GPCommonFilterName GAME_INFO = null;
    public static final GPCommonFilterName TRAFFIC_INFO = null;
    public static final GPCommonFilterName USER_INFO = null;
    public static final GPCommonFilterName VIEW_TRACK_INFO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GPCommonFilterName[] f56754a = null;
    private final String value;

    public static final class a {
        public a() {
        }

        public static HashMap b(HashMap r100) {
            Intrinsics.checkNotNullParameter(r100, "paramsMap");
            HashMap r101 = new HashMap();
            Iterator r102 = r100.entrySet().iterator();
        L4:
            if (r102.hasNext() == false) goto L10;
            Map.Entry r103 = (Map.Entry) r102.next();
            GPCommonFilterName r104 = (GPCommonFilterName) r103.getKey();
            Map r105 = (Map) r103.getValue();
            Intrinsics.checkNotNullParameter(r105, "paramMap");
            Intrinsics.checkNotNullParameter(r101, "filterParamMap");
            if (r104 == null) goto L4;
            GPCommonFilterName.Companion.getClass();
            com.bytedance.android.gamecp.common.track.filter.a r106 = a(r104, r105);
            if (r106 == null) goto L4;
            r101.put(r104, r106);
            goto L4
        L10:
            return r101;
        }

        public static HashMap c(Map r110) {
            Intrinsics.checkNotNullParameter(r110, "paramsMap");
            HashMap r100 = new HashMap();
            Iterator r111 = r110.entrySet().iterator();
        L4:
            if (r111.hasNext() == false) goto L17;
            Map.Entry r101 = (Map.Entry) r111.next();
            String r102 = (String) r101.getKey();
            Map r103 = (Map) r101.getValue();
            Intrinsics.checkNotNullParameter(r102, "paramFilterName");
            Intrinsics.checkNotNullParameter(r103, "paramMap");
            Intrinsics.checkNotNullParameter(r100, "filterParamMap");
            GPCommonFilterName[] r104 = GPCommonFilterName.values();
            int r105 = r104.length;
            int r106 = 0;
        L6:
            if (r106 >= r105) goto L11;
            GPCommonFilterName r107 = r104[r106];
            if (Intrinsics.areEqual(r107.getValue(), r102) == true) goto L12;
            r106 = r106 + 1;
        L12:
            Intrinsics.checkNotNullParameter(r103, "paramMap");
            Intrinsics.checkNotNullParameter(r100, "filterParamMap");
            if (r107 == null) goto L4;
            GPCommonFilterName.Companion.getClass();
            com.bytedance.android.gamecp.common.track.filter.a r108 = a(r107, r103);
            if (r108 == null) goto L4;
            r100.put(r107, r108);
            goto L4
        L11:
            r107 = null;
            goto L12
        L17:
            return r100;
        }

        public static com.bytedance.android.gamecp.common.track.filter.a a(GPCommonFilterName r100, Map r101) {
            Intrinsics.checkNotNullParameter(r100, "paramFilterName");
            Intrinsics.checkNotNullParameter(r101, "paramMap");
            if (r100 == null) goto L15;
            int r102 = com.bytedance.android.gamecp.common.track.a.f56774a[r100.ordinal()];
            if (r102 != 1) goto L8;
            com.bytedance.android.gamecp.common.track.filter.a r103 = new GameInfoFilter();
        L21:
            if (r103 == null) goto L23;
            HashMap r104 = new HashMap(r101);
            Intrinsics.checkNotNullParameter(r104, "map");
            r103.f56801a.putAll(r104);
        L23:
            return r103;
        L8:
            if (r102 != 2) goto L10;
            r103 = new com.bytedance.android.gamecp.common.track.filter.b();
            goto L21
        L10:
            if (r102 != 3) goto L12;
            r103 = new com.bytedance.android.gamecp.common.track.filter.c();
            goto L21
        L12:
            if (r102 != 4) goto L14;
            r103 = new com.bytedance.android.gamecp.common.track.filter.e();
            goto L21
        L14:
            if (r102 != 5) goto L15;
            r103 = new com.bytedance.android.gamecp.common.track.filter.f();
        L15:
            r103 = null;
            goto L21
        }
    }

    static {
        GPCommonFilterName r100 = new GPCommonFilterName("BIZ_INFO", 0, "BizInfo");
        BIZ_INFO = r100;
        GPCommonFilterName r101 = new GPCommonFilterName("CONTENT_INFO", 1, "ContentInfo");
        CONTENT_INFO = r101;
        GPCommonFilterName r102 = new GPCommonFilterName("TRAFFIC_INFO", 2, "TrafficInfo");
        TRAFFIC_INFO = r102;
        GPCommonFilterName r103 = new GPCommonFilterName("GAME_INFO", 3, "GameInfo");
        GAME_INFO = r103;
        GPCommonFilterName r104 = new GPCommonFilterName("USER_INFO", 4, "UserInfo");
        USER_INFO = r104;
        GPCommonFilterName r105 = new GPCommonFilterName("VIEW_TRACK_INFO", 5, "ViewTrackInfo");
        VIEW_TRACK_INFO = r105;
        f56754a = new GPCommonFilterName[]{r100, r101, r102, r103, r104, r105};
        Companion = new a();
    }

    public static GPCommonFilterName valueOf(String r100) {
        return (GPCommonFilterName) r27.a.a(GPCommonFilterName.class, r100);
    }

    public static GPCommonFilterName[] values() {
        return (GPCommonFilterName[]) f56754a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public GPCommonFilterName(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
