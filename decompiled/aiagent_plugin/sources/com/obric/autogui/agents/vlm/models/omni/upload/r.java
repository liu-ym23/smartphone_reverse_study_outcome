package com.obric.autogui.agents.vlm.models.omni.upload;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.List;

/* JADX INFO: compiled from: OmniUploadImageFileName.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class r extends com.obric.autogui.agents.vlm.models.omni.a.g<t> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final r f28823b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f28824c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f28825d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f28826e = null;
    private static final List<String> f = null;

    private r() {
    }

    @Override // com.obric.autogui.agents.vlm.models.omni.a.g
    public /* synthetic */ com.obric.autogui.agents.vlm.models.omni.a.h a(File r1, String r2, String r3, String r4, Integer r5, long r6, long r8) {
        return (com.obric.autogui.agents.vlm.models.omni.a.h) ZeusTransformUtils.preCheckCast(b(r1, r2, r3, r4, r5, r6, r8), com.obric.autogui.agents.vlm.models.omni.a.h.class, "com.obric.aiagent.plugin");
    }

    static {
        f28823b = new r();
        f28824c = "omni_upload_images";
        f28825d = "_00_omni_upload_task_";
        f28826e = ".jpg";
        f = d.a.p.b(new String[]{".jpg", ".png", ".heic", ".heif"});
    }

    @Override // com.obric.autogui.agents.vlm.models.omni.a.g
    public String a() {
        return f28824c;
    }

    @Override // com.obric.autogui.agents.vlm.models.omni.a.g
    public String b() {
        return f28825d;
    }

    @Override // com.obric.autogui.agents.vlm.models.omni.a.g
    public String c() {
        return f28826e;
    }

    @Override // com.obric.autogui.agents.vlm.models.omni.a.g
    public List<String> d() {
        return f;
    }

    public t b(File r12, String r13, String r14, String r15, Integer r16, long r17, long r19) {
        d.h.b.o.e(r12, "file");
        d.h.b.o.e(r13, DBDefinition.TASK_ID);
        d.h.b.o.e(r14, "toolId");
        d.h.b.o.e(r15, "stepId");
        return new t(r12, r13, r14, r15, r16, r17, r19);
    }

    public String c(File r2) {
        d.h.b.o.e(r2, "file");
        String r1 = r2.getName();
        d.h.b.o.a(r1);
        if (d.o.o.c(r1, ".png", true) == false) goto L6;
        return "image/png";
    L6:
        if (d.o.o.c(r1, ".heic", true) == false) goto L9;
        return "image/heic";
    L9:
        if (d.o.o.c(r1, ".heif", true) == false) goto L11;
        return "image/heif";
    L11:
        return "image/jpeg";
    }
}
