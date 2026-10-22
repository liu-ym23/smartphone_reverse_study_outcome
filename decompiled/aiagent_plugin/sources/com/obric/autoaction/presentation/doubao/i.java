package com.obric.autoaction.presentation.doubao;

import android.content.Context;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ColorUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f24892a = null;

    /* JADX INFO: compiled from: ColorUtils.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f24893a = null;

        static {
            int[] r0 = new int[h.values().length];
            r0[h.f24887a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r0[h.f24888b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r0[h.f24889c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[h.f24890d.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r0[h.f24891e.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r0[h.f.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r0[h.g.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r0[h.h.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            f24893a = r0;
        }
    }

    static {
        f24892a = new i();
    }

    private i() {
    }

    public final int a(Context r2, h r3, boolean r4) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        o.e(r3, "type");
        switch(a.f24893a[r3.ordinal()]) {
            case 1: goto L34;
            case 2: goto L30;
            case 3: goto L26;
            case 4: goto L22;
            case 5: goto L18;
            case 6: goto L14;
            case 7: goto L10;
            case 8: goto L6;
            default: goto L5;
        };
    L6:
        if (r4 == false) goto L9;
        return r1.getColor(ZeusTransformUtils.mapRes(R.color.assistant_card_ai_gradient_middle_color_night_mode, "color", "assistant_card_ai_gradient_middle_color_night_mode"));
    L9:
        return r1.getColor(ZeusTransformUtils.mapRes(R.color.assistant_card_ai_gradient_middle_color_light_mode, "color", "assistant_card_ai_gradient_middle_color_light_mode"));
    L10:
        if (r4 == false) goto L13;
        return r1.getColor(ZeusTransformUtils.mapRes(R.color.assistant_card_danger_50_night_mode, "color", "assistant_card_danger_50_night_mode"));
    L13:
        return r1.getColor(ZeusTransformUtils.mapRes(R.color.assistant_card_danger_50_light_mode, "color", "assistant_card_danger_50_light_mode"));
    L14:
        if (r4 == false) goto L17;
        return r1.getColor(ZeusTransformUtils.mapRes(R.color.assistant_card_oui_basic_text_1_night_mode, "color", "assistant_card_oui_basic_text_1_night_mode"));
    L17:
        return r1.getColor(ZeusTransformUtils.mapRes(R.color.assistant_card_oui_basic_text_1_light_mode, "color", "assistant_card_oui_basic_text_1_light_mode"));
    L18:
        if (r4 == false) goto L21;
        return r1.getColor(ZeusTransformUtils.mapRes(R.color.assistant_card_oui_basic_text_3_night_mode, "color", "assistant_card_oui_basic_text_3_night_mode"));
    L21:
        return r1.getColor(ZeusTransformUtils.mapRes(R.color.assistant_card_oui_basic_text_3_light_mode, "color", "assistant_card_oui_basic_text_3_light_mode"));
    L22:
        if (r4 == false) goto L25;
        return r1.getColor(ZeusTransformUtils.mapRes(R.color.assistant_card_conditional_success_50_night_mode, "color", "assistant_card_conditional_success_50_night_mode"));
    L25:
        return r1.getColor(ZeusTransformUtils.mapRes(R.color.assistant_card_conditional_success_50_light_mode, "color", "assistant_card_conditional_success_50_light_mode"));
    L26:
        if (r4 == false) goto L29;
        return r1.getColor(ZeusTransformUtils.mapRes(R.color.assistant_card_oui_ai_a_color3_6_night_mode, "color", "assistant_card_oui_ai_a_color3_6_night_mode"));
    L29:
        return r1.getColor(ZeusTransformUtils.mapRes(R.color.assistant_card_oui_ai_a_color3_6_light_mode, "color", "assistant_card_oui_ai_a_color3_6_light_mode"));
    L30:
        if (r4 == false) goto L33;
        return r1.getColor(ZeusTransformUtils.mapRes(R.color.assistant_card_neutral_100_night_mode, "color", "assistant_card_neutral_100_night_mode"));
    L33:
        return r1.getColor(ZeusTransformUtils.mapRes(R.color.assistant_card_neutral_100_light_mode, "color", "assistant_card_neutral_100_light_mode"));
    L34:
        if (r4 == false) goto L37;
        return r1.getColor(ZeusTransformUtils.mapRes(R.color.assistant_card_ai_b_6_night_mode, "color", "assistant_card_ai_b_6_night_mode"));
    L37:
        return r1.getColor(ZeusTransformUtils.mapRes(R.color.assistant_card_ai_b_6_light_mode, "color", "assistant_card_ai_b_6_light_mode"));
    L5:
        throw new d.k();
    }
}
