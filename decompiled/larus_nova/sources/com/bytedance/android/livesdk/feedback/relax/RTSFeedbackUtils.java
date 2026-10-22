package com.bytedance.android.livesdk.feedback.relax;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.rts.foundation.v;
import com.bytedance.salamander.anniex.y3;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class RTSFeedbackUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, String> f124764a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f124765b = null;

    public static final class Companion {
        public Companion() {
        }

        public static void d(final Map r100) {
            Intrinsics.checkNotNullParameter(r100, "params");
            RTSFeedbackUtils.f124765b.getClass();
            com.bytedance.rts.foundation.m.d(RTSFeedbackUtils.f124764a, new RTSFeedbackUtils$Companion$liveFeedbackCardClick$1(r100));
            y3 r101 = new y3("livesdk_live_feedback_card_click", r100);
            RTSFeedbackUtils$Companion$liveFeedbackCardClick$2 r102 = RTSFeedbackUtils$Companion$liveFeedbackCardClick$2.INSTANCE;
            Intrinsics.checkNotNullParameter(r101, "params");
            Intrinsics.checkNotNullParameter(r102, "callback");
            com.bytedance.salamander.bridge.k.a(r101, r102);
        }

        public static void e(final Map r100) {
            Intrinsics.checkNotNullParameter(r100, "params");
            RTSFeedbackUtils.f124765b.getClass();
            com.bytedance.rts.foundation.m.d(RTSFeedbackUtils.f124764a, new RTSFeedbackUtils$Companion$liveFeedbackCardShow$1(r100));
            y3 r101 = new y3("livesdk_live_feedback_card_show", r100);
            RTSFeedbackUtils$Companion$liveFeedbackCardShow$2 r102 = RTSFeedbackUtils$Companion$liveFeedbackCardShow$2.INSTANCE;
            Intrinsics.checkNotNullParameter(r101, "params");
            Intrinsics.checkNotNullParameter(r102, "callback");
            com.bytedance.salamander.bridge.k.a(r101, r102);
        }

        public static void f(RTSRelaxFeedbackLightData r100) {
            Intrinsics.checkNotNullParameter(r100, "lightData");
            RTSFeedbackUtils.f124765b.getClass();
            Map<String, String> r101 = RTSFeedbackUtils.f124764a;
            com.bytedance.rts.foundation.m.e(r101, "enter_from_merge", r100.f124766a);
            com.bytedance.rts.foundation.m.e(r101, "enter_method", r100.f124767b);
            com.bytedance.rts.foundation.m.e(r101, "room_id", r100.f124769d);
            com.bytedance.rts.foundation.m.e(r101, "anchor_id", r100.f124770e);
            com.bytedance.rts.foundation.m.e(r101, "request_id", r100.f124771f);
            com.bytedance.rts.foundation.m.e(r101, ILiveRoomPlayFragmentConstant.ORDER_CENTER_DRAW_INDEX, r100.f124773h);
            Long r102 = Long.valueOf(r100.f124772g);
            Intrinsics.checkNotNullParameter(r102, "x");
            com.bytedance.rts.foundation.m.e(r101, "feedback_id", r102.toString());
            com.bytedance.rts.foundation.m.e(r101, "flow_type", r100.f124774i);
            com.bytedance.rts.foundation.m.e(r101, com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE, r100.f124775j);
            com.bytedance.rts.foundation.m.e(r101, "pk_id", r100.f124777l);
            com.bytedance.rts.foundation.m.e(r101, "question_type", r100.f124776k);
            com.bytedance.rts.foundation.m.e(r101, "action_type", r100.f124768c);
        }

        public static int a(Object r100, int r101) {
            int r102 = v.f267594a;
            if ((r100 instanceof Long) == false) goto L11;
            int r103 = com.bytedance.rts.foundation.e.f267578a;
            if (r100 == null) goto L9;
            return (int) ((Long) r100).longValue();
        L9:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
        L11:
            if ((r100 instanceof Integer) == false) goto L18;
            int r104 = com.bytedance.rts.foundation.d.f267577a;
            if (r100 == null) goto L17;
            return ((Integer) r100).intValue();
        L17:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        L18:
            return r101;
        }

        public static Map b(Map r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "key");
            Object r102 = null;
            if (r100 == null) goto L15;
            Object r103 = r100.get("data");
            if (TypeIntrinsics.isMutableMap(r103) == true) goto L7;
            r103 = null;
        L7:
            Map r104 = (Map) r103;
            if (r104 == null) goto L16;
            Object r105 = r104.get(r101);
            if (TypeIntrinsics.isMutableMap(r105) == false) goto L14;
            r102 = r105;
        L14:
            return (Map) r102;
        L16:
            return null;
        L15:
            return null;
        }

        public static int c(String r100, Map r101) {
            Intrinsics.checkNotNullParameter(r100, "position");
            if (r101 != null) goto L6;
            return 30;
        L6:
            switch(r100.hashCode()) {
                case -1730219439: goto L21;
                case -207318108: goto L17;
                case 1198803481: goto L13;
                case 1804255104: goto L9;
                default: goto L24;
            };
        L24:
            return 30;
        L9:
            if (r100.equals("preview_bottom_component") == false) goto L24;
            Companion r102 = RTSFeedbackUtils.f124765b;
            Object r103 = r101.get("preview_bottom_component_show_duration");
            r102.getClass();
            return a(r103, 30);
        L13:
            if (r100.equals("public_screen_show_duration") == false) goto L24;
            Companion r104 = RTSFeedbackUtils.f124765b;
            Object r105 = r101.get("public_screen_show_duration");
            r104.getClass();
            return a(r105, 30);
        L17:
            if (r100.equals("room_bottombar") == false) goto L24;
            Companion r106 = RTSFeedbackUtils.f124765b;
            Object r107 = r101.get("room_bottom_show_duration");
            r106.getClass();
            return a(r107, 30);
        L21:
            if (r100.equals("preview_bottombar") == false) goto L24;
            Companion r108 = RTSFeedbackUtils.f124765b;
            Object r109 = r101.get("preview_bottom_bar_show_duration");
            r108.getClass();
            return a(r109, 30);
        }
    }

    static {
        f124765b = new Companion();
        f124764a = new LinkedHashMap();
    }
}
