package com.obric.autogui.agents.vlm.models.omni.d;

import android.content.ComponentName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.o.o;
import org.json.JSONObject;

/* JADX INFO: compiled from: OmniPreActionPageStateTrackingReporter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static final /* synthetic */ void a(JSONObject r0, String r1, String r2) {
        b(r0, r1, r2);
    }

    private static final void b(JSONObject r2, String r3, String r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if ((!o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L7;
        r4 = null;
    L7:
        if (r4 == null) goto L11;
        r2.put(r3, r4);
        return;
    }

    public static final void a(JSONObject r5, String r6, com.obric.autogui.agents.vlm.models.impl.c.b r7, String r8) {
        d.h.b.o.e(r5, "<this>");
        d.h.b.o.e(r6, "prefix");
        d.h.b.o.e(r8, "salt");
        if (r7 != null) goto L6;
        return;
    L6:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r7.l(), CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        return;
    L11:
        r5.put(r6 + "_digest_created", true);
        if (r7.k() == false) goto L14;
        r5.put(r6 + "_page_state_available", true);
    L14:
        r5.put(r6 + "_evidence_source", r7.b());
        ComponentName r1 = r7.getActivity();
        if (r1 == null) goto L17;
        r5.put(r6 + "_activity_available", true);
        r5.put(r6 + "_activity_package", r1.getPackageName());
        r5.put(r6 + "_activity_class", r1.getClassName());
    L17:
        String r2 = r7.a(r8);
        if (r2 == null) goto L20;
        r5.put(r6 + "_viewtree_available", true);
        r5.put(r6 + "_viewtree_fingerprint", r2);
        r5.put(r6 + "_viewtree_window_count", r7.d());
        r5.put(r6 + "_viewtree_node_count", r7.e());
    L20:
        String r9 = r7.b(r8);
        if (r9 == null) goto L28;
        r5.put(r6 + "_image_available", true);
        r5.put(r6 + "_image_fingerprint", r9);
        Integer r10 = r7.h();
        if (r10 == null) goto L25;
        r5.put(r6 + "_image_fingerprint_width", ((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.aiagent.plugin")).intValue());
    L25:
        Integer r11 = r7.i();
        if (r11 == null) goto L28;
        r5.put(r6 + "_image_fingerprint_height", ((Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.aiagent.plugin")).intValue());
    L28:
        Boolean r12 = r7.j();
        if (r12 == null) goto L32;
        boolean r13 = r12.booleanValue();
        r5.put(r6 + "_secure_available", true);
        r5.put(r6 + "_secure", r13);
        return;
    L32:
        return;
    L8:
        r0 = false;
        goto L9
    }

    public static final void a(JSONObject r4, com.obric.autogui.agents.vlm.models.impl.c.a r5) {
        d.h.b.o.e(r4, "<this>");
        d.h.b.o.e(r5, "comparison");
        if (r5.h() == true) goto L5;
        return;
    L5:
        r4.put("page_state_comparison_available", true);
        r4.put("page_state_changed", r5.i());
        String r0 = r5.j();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == true) goto L12;
        r0 = null;
    L12:
        if (r0 == null) goto L15;
        r4.put("changed_dimensions", r0);
    L15:
        if (r5.a() == false) goto L18;
        r4.put("activity_comparison_available", true);
        r4.put("activity_changed", r5.b());
    L18:
        if (r5.c() == false) goto L21;
        r4.put("viewtree_comparison_available", true);
        r4.put("viewtree_changed", r5.d());
    L21:
        if (r5.e() == false) goto L26;
        r4.put("image_comparison_available", true);
        r4.put("image_changed", r5.f());
        Integer r6 = r5.g();
        if (r6 == null) goto L27;
        r4.put("image_hamming_distance", ((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.aiagent.plugin")).intValue());
        return;
    L27:
        return;
    L26:
        return;
    L8:
        r2 = false;
        goto L9
    }
}
