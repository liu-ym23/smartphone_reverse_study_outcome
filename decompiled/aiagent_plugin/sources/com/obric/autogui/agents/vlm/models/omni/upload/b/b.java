package com.obric.autogui.agents.vlm.models.omni.upload.b;

import com.obric.autogui.agents.vlm.models.omni.a.g;
import com.obric.autogui.agents.vlm.models.omni.a.h;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.io.File;
import java.util.List;

/* JADX INFO: compiled from: OmniUploadViewTreeFileName.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends g<e> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f28610b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f28611c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f28612d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f28613e = null;
    private static final List<String> f = null;

    public String c(File r1) {
        o.e(r1, "file");
        return "application/json";
    }

    private b() {
    }

    @Override // com.obric.autogui.agents.vlm.models.omni.a.g
    public /* synthetic */ h a(File r1, String r2, String r3, String r4, Integer r5, long r6, long r8) {
        return (h) ZeusTransformUtils.preCheckCast(b(r1, r2, r3, r4, r5, r6, r8), h.class, "com.obric.aiagent.plugin");
    }

    static {
        f28610b = new b();
        f28611c = "omni_upload_viewtrees";
        f28612d = "_00_omni_upload_vt_task_";
        f28613e = ".json";
        f = p.a(".json");
    }

    @Override // com.obric.autogui.agents.vlm.models.omni.a.g
    public String a() {
        return f28611c;
    }

    @Override // com.obric.autogui.agents.vlm.models.omni.a.g
    public String b() {
        return f28612d;
    }

    @Override // com.obric.autogui.agents.vlm.models.omni.a.g
    public String c() {
        return f28613e;
    }

    @Override // com.obric.autogui.agents.vlm.models.omni.a.g
    public List<String> d() {
        return f;
    }

    public e b(File r12, String r13, String r14, String r15, Integer r16, long r17, long r19) {
        o.e(r12, "file");
        o.e(r13, DBDefinition.TASK_ID);
        o.e(r14, "toolId");
        o.e(r15, "stepId");
        return new e(r12, r13, r14, r15, r16, r17, r19);
    }
}
