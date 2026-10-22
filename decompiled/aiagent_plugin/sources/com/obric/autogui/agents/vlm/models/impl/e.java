package com.obric.autogui.agents.vlm.models.impl;

import android.graphics.PointF;
import android.os.Bundle;
import com.google.gson.JsonObject;
import com.obric.autoaction.presentation.SurfaceCardActivity;
import com.obric.autogui.common.api.AODeviceSpecificTools;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: StandardModelActionedStep.kt */
/* JADX INFO: loaded from: classes3.dex */
public class e extends g implements com.obric.autogui.agents.vlm.models.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f27797a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f27798c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f27799d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f27800e;
    private String g;
    private long h;
    private List<PointF> i;

    /* JADX INFO: compiled from: StandardModelActionedStep.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f27797a = new a(null);
    }

    public static /* synthetic */ String lambda$YpcLBU9qYkqZ2QCnP4l7MeWI4_M(e r0) {
        return b(r0);
    }

    public static /* synthetic */ String lambda$a2kdXF8FMisOgqV_i7227puuQtY(e r0) {
        return a(r0);
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.g
    public Object a(com.obric.autogui.session.a r3, d.c.d<? super com.obric.autogui.operator.g> r4) {
        return a(this, r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.g, com.obric.autogui.agents.vlm.models.a.d
    public boolean h() {
        return true;
    }

    public e() {
        this.f27798c = "";
        this.f27800e = "";
        this.g = "";
        this.i = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
    }

    public final void a(String r2) {
        d.h.b.o.e(r2, "<set-?>");
        this.f27798c = r2;
    }

    public final void b(String r1) {
        this.f27799d = r1;
    }

    public final void c(String r2) {
        d.h.b.o.e(r2, "<set-?>");
        this.f27800e = r2;
    }

    public final void d(String r2) {
        d.h.b.o.e(r2, "<set-?>");
        this.g = r2;
    }

    public final void a(long r1) {
        this.h = r1;
    }

    public final List<PointF> a() {
        return this.i;
    }

    static /* synthetic */ Object a(final e r4, com.obric.autogui.session.a r5, d.c.d<? super com.obric.autogui.operator.g> r6) {
        d.c.d<? super com.obric.autogui.operator.g> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.dp("M-Std-Step/A", new $$Lambda$e$a2kdXF8FMisOgqV_i7227puuQtY(r4), new $$Lambda$e$YpcLBU9qYkqZ2QCnP4l7MeWI4_M(r4));
        return super.a(r5, r7);
    }

    private static final String a(e r2) {
        return "[exec step]; act= (" + r2.f27800e + ") / " + r2.f27798c + ", grd=" + r2.g;
    }

    private static final String b(e r2) {
        return "[exec step]; act= (" + r2.f27800e + ").";
    }

    public Collection<PointF> b() {
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(this.i, Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L9;
        PointF r2 = (PointF) ZeusTransformUtils.preCheckCast(r6.next(), PointF.class, "com.obric.aiagent.plugin");
        PointF r3 = AODeviceSpecificTools.INSTANCE.denormaliseOperatingSpacePosition(r2, true);
        if (r3 == null) goto L4;
        r0.add(r3);
        goto L4
    L9:
        return (Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.g
    public JsonObject c() {
        JsonObject r0 = super.c();
        if (r0 == null) goto L5;
        r0.addProperty("action", this.f27798c);
        r0.addProperty("action_grounding", this.g);
        return r0;
    L5:
        return null;
    }

    @Override // com.obric.autogui.agents.vlm.models.a.b
    public String d() {
        return this.f27798c;
    }

    @Override // com.obric.autogui.agents.vlm.models.a.b
    public String e() {
        String r0 = this.f27799d;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this.f27798c;
    }

    @Override // com.obric.autogui.agents.vlm.models.a.b
    public String f() {
        return this.f27800e;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.g, com.obric.autogui.agents.vlm.models.a.d
    public Bundle g() {
        Bundle r0 = super.g();
        if (r0 != null) goto L5;
        r0 = new Bundle();
    L5:
        a(r0);
        com.obric.autogui.common.d<List<d.m<com.obric.autogui.operator.e.C0780e, com.obric.autogui.operator.b>>> r6 = Y();
        if (r6.g() == false) goto L32;
        List r7 = (List) ZeusTransformUtils.preCheckCast(r6.a(), List.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L28;
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin");
        boolean r4 = false;
        if (ZeusTransformUtils.instanceOf(r8, Collection.class) == true) goto L12;
    L14:
        Iterator r9 = r8.iterator();
    L16:
        if (r9.hasNext() == false) goto L27;
        com.obric.autogui.operator.a.c.b r3 = ((com.obric.autogui.operator.b) ZeusTransformUtils.preCheckCast(((d.m) ZeusTransformUtils.preCheckCast(r9.next(), d.m.class, "com.obric.aiagent.plugin")).d(), com.obric.autogui.operator.b.class, "com.obric.aiagent.plugin")).a();
        if (r3 == null) goto L24;
        com.obric.autogui.operator.c r5 = r3.a();
        if (r5 == null) goto L24;
        if (r5.a() != true) goto L24;
        boolean r10 = true;
    L25:
        if (r10 == false) goto L16;
        r4 = true;
    L24:
        r10 = false;
    L27:
        Boolean r11 = Boolean.valueOf(r4);
    L30:
        if (d.h.b.o.a(r11, true) == false) goto L32;
        r0.putBoolean("skip_ui_operating", true);
        goto L32
    L12:
        if (((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L14;
    L28:
        r11 = null;
    L32:
        return r0;
    }

    private final void a(Bundle r9) {
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(this.i, Iterable.class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        PointF r3 = AODeviceSpecificTools.INSTANCE.denormaliseOperatingSpacePosition((PointF) ZeusTransformUtils.preCheckCast(r2.next(), PointF.class, "com.obric.aiagent.plugin"), true);
        if (r3 == null) goto L4;
        r1.add(r3);
        goto L4
    L8:
        List r4 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin");
        int r5 = r4.size();
        if (r5 == 1) goto L13;
        if (r5 != 2) goto L21;
        Loog.INSTANCE.i("M-Std-Step/A", "[exec step]; swipe");
        r9.putFloatArray(SurfaceCardActivity.SWIPE_POS_KEY, new float[]{((PointF) ZeusTransformUtils.preCheckCast(r4.get(0), PointF.class, "com.obric.aiagent.plugin")).x, ((PointF) ZeusTransformUtils.preCheckCast(r4.get(0), PointF.class, "com.obric.aiagent.plugin")).y, ((PointF) ZeusTransformUtils.preCheckCast(r4.get(1), PointF.class, "com.obric.aiagent.plugin")).x, ((PointF) ZeusTransformUtils.preCheckCast(r4.get(1), PointF.class, "com.obric.aiagent.plugin")).y});
        r9.putLong(SurfaceCardActivity.SWIPE_DURATION_KEY, this.h);
        return;
    L21:
        return;
    L13:
        Loog.INSTANCE.i("M-Std-Step/A", "[exec step]; click");
        PointF r8 = (PointF) ZeusTransformUtils.preCheckCast(d.a.p.k(r4), PointF.class, "com.obric.aiagent.plugin");
        r9.putFloatArray("clicked_pos", new float[]{r8.x, r8.y});
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.g, com.obric.autogui.operator.e
    public void a(JSONObject r3) {
        d.h.b.o.e(r3, "metricsForUpload");
        super.a(r3);
        r3.put("action_type", this.f27800e);
        r3.put("action", this.f27798c);
    }

    public String toString() {
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(this.f27800e, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L7;
        return "InheritedActionedStep(" + getClass().getSimpleName() + '/' + hashCode() + ')';
    L7:
        return "ActionedStep(" + this.f27800e + '/' + hashCode() + ')';
    }
}
