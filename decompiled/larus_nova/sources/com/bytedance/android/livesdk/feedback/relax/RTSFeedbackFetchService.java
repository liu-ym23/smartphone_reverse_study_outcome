package com.bytedance.android.livesdk.feedback.relax;

import com.bytedance.salamander.anniex.a4;
import com.bytedance.salamander.anniex.b4;
import com.bytedance.ugc.glue.monitor.UGCMonitor;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class RTSFeedbackFetchService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f124763a = 0;

    public static final class Companion {
        public Companion() {
        }

        public static void b(RTSRelaxFeedbackLightData r110) {
            int r100 = RTSFeedbackFetchService.f124763a;
            Intrinsics.checkNotNullParameter(r110, "relaxFeedbackLightData");
            Pair[] r101 = new Pair[3];
            int r102 = 0;
            r101[0] = TuplesKt.to("feedback_id", Long.valueOf(r110.f124772g));
            r101[1] = TuplesKt.to("room_id", r110.f124769d);
            if (StringsKt.indexOf$default(r110.f124774i, "outflow", 0, false, 6, null) < 0) goto L5;
            r102 = 1;
        L5:
            r101[2] = TuplesKt.to("flow_type", Integer.valueOf(r102));
            Map r111 = MapsKt.mutableMapOf(r101);
            if (r111 == null) goto L10;
            Map r103 = TypeIntrinsics.asMutableMap(r111);
            a4 r112 = new a4("https://webcast.amemv.com/webcast/distribution/feedback_show/", UGCMonitor.TYPE_POST, r103, r103, null, null, 8176);
            final Function1 r104 = null;
            Function1<b4, Unit> r105 = new RTSFeedbackFetchService$Companion$fetchFeedbackShow$1(r104);
            Intrinsics.checkNotNullParameter(r112, "params");
            Intrinsics.checkNotNullParameter(r105, "callback");
            com.bytedance.salamander.bridge.m.a(r112, r105);
            return;
        L10:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.rts.foundation.Json /* = kotlin.collections.MutableMap<kotlin.String, kotlin.Any> */");
        }

        public static void a(Map r100, final Function1 r110) {
            Intrinsics.checkNotNullParameter(r100, "feedback");
            a4 r101 = new a4("https://webcast.amemv.com/webcast/distribution/feedback/", UGCMonitor.TYPE_POST, r100, r100, null, null, 8176);
            Function1<b4, Unit> r102 = new RTSFeedbackFetchService$Companion$fetchFeedbackDistribution$1(r110);
            Intrinsics.checkNotNullParameter(r101, "params");
            Intrinsics.checkNotNullParameter(r102, "callback");
            com.bytedance.salamander.bridge.m.a(r101, r102);
        }
    }

    static {
        new Companion();
    }
}
