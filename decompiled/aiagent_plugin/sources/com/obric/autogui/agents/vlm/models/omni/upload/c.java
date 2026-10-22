package com.obric.autogui.agents.vlm.models.omni.upload;

import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.keva.KevaImpl;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.autoaction.app.launcherpage.knowledge.KnowledgeActivity;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.logging.OmniDataFeedbackLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bd;
import org.json.JSONObject;

/* JADX INFO: compiled from: OmniDataFeedbackDebugArchive.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    private static final String TAG = "OmniDataFeedbackArchive";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f28637a = null;

    /* JADX INFO: compiled from: OmniDataFeedbackDebugArchive.kt */
    @d.c.b.a.f(b = "OmniDataFeedbackDebugArchive.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.omni.upload.OmniDataFeedbackDebugArchive$archive$2")
    static final class a extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.n<? extends d.x>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f28638a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ h f28639b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.autogui.agents.vlm.models.omni.a.c f28640c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f28641d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private /* synthetic */ Object f28642e;

        a(h r3, com.obric.autogui.agents.vlm.models.omni.a.c r4, String r5, d.c.d<? super a> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28639b = r3;
            this.f28640c = r4;
            this.f28641d = r5;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super d.n<d.x>> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r5, d.c.d<?> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            a r0 = new a(this.f28639b, this.f28640c, this.f28641d, r7);
            r0.f28642e = r5;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.n<? extends d.x>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            d.c.a.b.a();
            if (this.f28638a != 0) goto L17;
            d.o.a(r5);
            am r6 = (am) ZeusTransformUtils.preCheckCast(this.f28642e, am.class, "com.obric.aiagent.plugin");
            h r7 = this.f28639b;
            com.obric.autogui.agents.vlm.models.omni.a.c r0 = this.f28640c;
            String r1 = this.f28641d;
            d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L7
            c.a(c.f28637a, r7, r0, r1);     // Catch: Throwable -> L7
            Object r8 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L7
        L9:
            h r4 = this.f28639b;
            Throwable r3 = d.n.c(r8);
            if (r3 == null) goto L15;
            if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L15;
            Loog.INSTANCE.w(c.TAG, "archive failed, files=" + r4.n() + ", reason=" + r3.getMessage());
        L15:
            return d.n.g(r8);
        L7:
            th = move-exception;
            d.n.a r9 = d.n.f38560a;
            r8 = d.n.f(d.o.a(th));
            goto L9
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        f28637a = new c();
    }

    private c() {
    }

    public static final /* synthetic */ void a(c r0, h r1, com.obric.autogui.agents.vlm.models.omni.a.c r2, String r3) {
        r0.a(r1, r2, r3);
    }

    public final Object a(h r4, com.obric.autogui.agents.vlm.models.omni.a.c r5, String r6, d.c.d<? super d.x> r7) {
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L5;
        Object r8 = kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(r4, r5, r6, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r3);
        if (r8 != d.c.a.b.a()) goto L10;
        return r8;
    L10:
        return d.x.f38692a;
    L5:
        return d.x.f38692a;
    }

    private final void a(h r8, com.obric.autogui.agents.vlm.models.omni.a.c r9, String r10) {
        File r0 = a(r8.a());
        File r1 = new File(r0, a(r8));
        if (r1.exists() == false) goto L5;
        d.f.k.h(r1);
    L5:
        r1.mkdirs();
        JSONObject r2 = new JSONObject();
        t r3 = r8.e();
        if (r3 == null) goto L10;
        File r4 = r3.a();
        if (r4 == null) goto L10;
        c r5 = f28637a;
        r2.put("image", r5.a(r4, new File(r1, r5.a(r4)), r.f28823b.c(r4)));
    L10:
        com.obric.autogui.agents.vlm.models.omni.upload.b.e r6 = r8.f();
        if (r6 == null) goto L15;
        File r7 = r6.a();
        if (r7 == null) goto L15;
        r2.put("view_tree", f28637a.a(r7, new File(r1, "view_tree.json"), com.obric.autogui.agents.vlm.models.omni.upload.b.b.f28610b.c(r7)));
    L15:
        com.obric.autogui.agents.vlm.models.omni.upload.a.g r11 = r8.g();
        if (r11 == null) goto L20;
        File r12 = r11.a();
        if (r12 == null) goto L20;
        r2.put("react_view_tree", f28637a.a(r12, new File(r1, "react_view_tree.json"), com.obric.autogui.agents.vlm.models.omni.upload.a.d.f28544b.c(r12)));
    L20:
        File r13 = d.f.k.a(r1, "meta.json");
        String r14 = new JSONObject().put(KnowledgeActivity.KEY_TASK_ID, r8.a()).put("tool_id", r8.b()).put("step_id", r8.c()).put("step_index", r8.d()).put("trigger", r9.a().name()).put(DBHelper.BATTERY_COL_SOURCE, r9.g().a()).put("data_count", r9.h()).put("upload_result", r10).put("created_at_millis", r8.h()).put("archived_at_millis", System.currentTimeMillis()).put(KevaImpl.PrivateConstants.FILES_DIR_NAME, r2).toString(2);
        d.h.b.o.c(r14, "toString(...)");
        d.f.k.a(r13, r14, null, 2, null);
        a(r8, r0);
    }

    private final File a(String r6) {
        File r0 = new File(com.obric.autogui.session.a.c.f30720a.a(), "omni_data_feedback_archive");
        r0.mkdirs();
        String r5 = "id_" + b(r6);
        File[] r7 = r0.listFiles();
        if (r7 == null) goto L10;
        int r1 = 0;
        int r2 = r7.length;
    L5:
        if (r1 >= r2) goto L10;
        File r3 = r7[r1];
        if (d.h.b.o.a(r3.getName(), r5) == true) goto L9;
        d.h.b.o.a(r3);
        d.f.k.h(r3);
    L9:
        r1 = r1 + 1;
    L10:
        File r8 = new File(r0, r5);
        r8.mkdirs();
        return r8;
    }

    private final String a(h r4) {
        Integer r0 = r4.d();
        if (r0 == null) goto L8;
        String r1 = r0.toString();
        if (r1 == null) goto L8;
        String r2 = d.o.o.a(r1, 3, '0');
        if (r2 == null) goto L8;
    L10:
        return r2 + '_' + b(r4.b());
    L8:
        r2 = SensitiveType.UNKNOWN;
        goto L10
    }

    private final JSONObject a(File r7, File r8, String r9) {
        File r6 = r8.getParentFile();
        if (r6 == null) goto L5;
        r6.mkdirs();
    L5:
        d.f.k.a(r7, r8, true, 0, 4, null);
        JSONObject r10 = new JSONObject().put("source_name", r7.getName()).put("archive_name", r8.getName()).put("mime_type", r9).put("size_bytes", r8.length());
        d.h.b.o.c(r10, "put(...)");
        return r10;
    }

    private final void a(h r8, File r9) {
        File r7 = (File) ZeusTransformUtils.preCheckCast(d.a.p.l(r8.j()), File.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L23;
        File r10 = r7.getParentFile();
        if (r10 == null) goto L27;
        File r11 = r10.getParentFile();
        if (r11 == null) goto L29;
        File r12 = com.obric.autogui.session.a.c.f30720a.a(r11);
        if (r12.isDirectory() == true) goto L12;
        return;
    L12:
        File r13 = new File(r9, "omni_upload_logs_snapshot");
        if (r13.exists() == false) goto L15;
        d.f.k.h(r13);
    L15:
        r13.mkdirs();
        File[] r14 = r12.listFiles();
        if (r14 == null) goto L28;
        int r15 = 0;
        int r0 = r14.length;
    L18:
        if (r15 >= r0) goto L30;
        File r1 = r14[r15];
        if (r1.isFile() == false) goto L22;
        d.h.b.o.a(r1);
        d.f.k.a(r1, new File(r13, r1.getName()), true, 0, 4, null);
    L22:
        r15 = r15 + 1;
        goto L18
    L30:
        return;
    L28:
        return;
    L29:
        return;
    L27:
        return;
    }

    private final String a(File r2) {
        String r1 = r2.getName();
        d.h.b.o.c(r1, "getName(...)");
        if (d.o.o.c(r1, ".png", true) == false) goto L5;
        return "image.png";
    L5:
        return "image.jpg";
    }

    private final String b(String r1) {
        return r.f28823b.a(r1);
    }
}
