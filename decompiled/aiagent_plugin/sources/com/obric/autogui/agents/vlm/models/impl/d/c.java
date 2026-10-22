package com.obric.autogui.agents.vlm.models.impl.d;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: MultiActionsStepParser.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements b {
    private static final String TAG = "M-Std/SParse/Multi";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f27778a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f27779b;

    /* JADX INFO: compiled from: MultiActionsStepParser.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f27778a = new a(null);
    }

    public static /* synthetic */ String lambda$qW95X9UioCB5wUarwxXcnqsEy7c(int r0, Collection r1) {
        return b(r0, r1);
    }

    public c(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        o.e(r4, "baseStepParser");
        this.f27779b = r4;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.d.b
    public b.a a(com.obric.autogui.agents.vlm.models.impl.d.C0690d r13, JsonObject r14) {
        o.e(r13, "inferenceContext");
        o.e(r14, "response");
        JsonElement r0 = r14.remove("action_list");
        if (r0 != null) goto L5;
    L30:
        Loog.INSTANCE.d(TAG, "[MultiAction] resp w/o action_list; running fall-back.");
        return b(r13, r14);
    L5:
        if (ZeusTransformUtils.instanceOf(r0, JsonArray.class) == false) goto L30;
        JsonObject r15 = r14.deepCopy();
        int r7 = ((JsonArray) ZeusTransformUtils.preCheckCast(r0, JsonArray.class, "com.obric.aiagent.plugin")).size();
        ArrayList r2 = new ArrayList(r7);
        Iterator<JsonElement> r1 = ((JsonArray) ZeusTransformUtils.preCheckCast(r0, JsonArray.class, "com.obric.aiagent.plugin")).iterator();
        o.c(r1, "iterator(...)");
        int r4 = 0;
        boolean r5 = false;
    L9:
        if (r1.hasNext() == false) goto L25;
        JsonElement r6 = (JsonElement) ZeusTransformUtils.preCheckCast(r1.next(), JsonElement.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, JsonObject.class) == false) goto L12;
        o.a(r15);
        b.a r8 = b(r13, d.a(r15, (JsonObject) ZeusTransformUtils.preCheckCast(r6, JsonObject.class, "com.obric.aiagent.plugin")));
        if (r8.a() == false) goto L15;
        r4 = r4 + 1;
        Iterator<com.obric.autogui.agents.vlm.models.impl.g> r9 = r8.d().a();
    L18:
        if (r9.hasNext() == false) goto L22;
        com.obric.autogui.agents.vlm.models.impl.g r10 = (com.obric.autogui.agents.vlm.models.impl.g) ZeusTransformUtils.preCheckCast(r9.next(), com.obric.autogui.agents.vlm.models.impl.g.class, "com.obric.aiagent.plugin");
        r2.add(r10);
        if ((r10.u() & 1) == 0) goto L18;
        Loog.INSTANCE.w(TAG, "Adjusted step in multi-action step (at=" + r4 + ").");
        r5 = true;
    L22:
        if (r5 == false) goto L9;
        Loog.INSTANCE.w(TAG, "Fail-fast strategy for adjusted step in multi-action step.");
        goto L25
    L15:
        Loog.INSTANCE.w(TAG, "Failed to parse action in multi-action step (at=" + r4 + ").");
        goto L25
    L12:
        Loog.INSTANCE.w(TAG, "Invalid action in multi-action step.");
    L25:
        if (r2.isEmpty() == true) goto L27;
        a(r7, (Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.aiagent.plugin"));
        return (b.a) ZeusTransformUtils.preCheckCast(new f.c(true, null, r7, p.y((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin")), 2, null), b.a.class, "com.obric.aiagent.plugin");
    L27:
        return (b.a) ZeusTransformUtils.preCheckCast(new f.c(false, "nothing parsed", r7, null, 8, null), b.a.class, "com.obric.aiagent.plugin");
    }

    private final void a(final int r2, Collection<? extends com.obric.autogui.agents.vlm.models.impl.g> r3) {
        final Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.dp(TAG, new $$Lambda$c$qW95X9UioCB5wUarwxXcnqsEy7c(r2, r1));
    }

    private static final String b(int r11, Collection r12) {
        Collection r13 = (Collection) ZeusTransformUtils.wrapperContextForParams(r12, Collection.class, "com.obric.aiagent.plugin");
        return "[MultiAction][ParsedSteps] Steps(" + r11 + ',' + r13.size() + "): " + p.a((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null);
    }

    private final b.a b(com.obric.autogui.agents.vlm.models.impl.d.C0690d r1, JsonObject r2) {
        return this.f27779b.a(r1, r2);
    }
}
