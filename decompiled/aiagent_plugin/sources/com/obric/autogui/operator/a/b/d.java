package com.obric.autogui.operator.a.b;

import android.content.Context;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.memorydata.sdk.entity.search.oauto.OAutoGlobalSearch;
import com.obric.memorydata.sdk.entity.search.oauto.OAutoSearchResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: OpGetMemoryAction.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends com.obric.autogui.operator.a.b {
    private static final String TAG = "Op-GetMemoryAct";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f29649b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b f29650c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.obric.autogui.operator.e f29651d;

    /* JADX INFO: compiled from: OpGetMemoryAction.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: OpGetMemoryAction.kt */
    public static final class b implements com.obric.autogui.operator.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f29652a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f29653b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f29652a, r6.f29652a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f29653b, r6.f29653b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f29652a.hashCode() * 31) + this.f29653b.hashCode();
        }

        public String toString() {
            return "Input(searchQuery=" + this.f29652a + ", searchJson=" + this.f29653b + ')';
        }

        public b(String r2, String r3) {
            o.e(r2, "searchQuery");
            o.e(r3, "searchJson");
            this.f29652a = r2;
            this.f29653b = r3;
        }

        public final String a() {
            return this.f29653b;
        }
    }

    static {
        f29649b = new a(null);
    }

    public d() {
    }

    @Override // com.obric.autogui.operator.d
    public boolean b(com.obric.autogui.operator.b.a r3) {
        com.obric.autogui.operator.b.a r4 = (com.obric.autogui.operator.b.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autogui.operator.b.a.class, "com.obric.aiagent.plugin");
        o.e(r4, "input");
        if (ZeusTransformUtils.instanceOf(r4, b.class) == true) goto L6;
        return false;
    L6:
        this.f29650c = (b) ZeusTransformUtils.preCheckCast(r4, b.class, "com.obric.aiagent.plugin");
        return true;
    }

    @Override // com.obric.autogui.operator.a.b
    public Object c(Context r6, d.c.d<? super com.obric.autogui.common.e> r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        b r10 = this.f29650c;
        if (r10 == null) goto L5;
        Loog.INSTANCE.d(TAG, "Starting personal profile search operation");     // Catch: Exception -> L26
        OAutoSearchResult r11 = OAutoGlobalSearch.INSTANCE.searchByQUResult(r8, r10.a(), false);     // Catch: Exception -> L26
        if (r11.isSuccess() == false) goto L16;
        Loog.INSTANCE.d(TAG, "Personal profile search completed successfully");     // Catch: Exception -> L26
        com.obric.autogui.operator.e r5 = this.f29651d;     // Catch: Exception -> L26
        if (r5 == null) goto L14;
        if (ZeusTransformUtils.instanceOf(r5, com.obric.autogui.agents.vlm.models.impl.g.class) == false) goto L14;
        ((com.obric.autogui.agents.vlm.models.impl.g) ZeusTransformUtils.preCheckCast(r5, com.obric.autogui.agents.vlm.models.impl.g.class, "com.obric.aiagent.plugin")).i(String.valueOf(r11.getEntitiesJson()));     // Catch: Exception -> L26
    L14:
        return com.obric.autogui.common.e.f29014b.a("Personal profile search completed successfully");
    L16:
        switch(r11.getErrorCode()) {
            case 400: goto L22;
            case 401: goto L21;
            case 402: goto L20;
            case 403: goto L19;
            case 404: goto L18;
            default: goto L23;
        };     // Catch: Exception -> L26
    L18:
        String r12 = "Personal profile service not ready, IPC call failed";
    L24:
        Loog.INSTANCE.e(TAG, "Personal profile search failed, error code: " + r11.getErrorCode());     // Catch: Exception -> L26
        return com.obric.autogui.common.e.f29014b.b("Personal profile search failed: " + r12);
    L19:
        r12 = "Personal profile feature is disabled";
        goto L24
    L20:
        r12 = "No permission to access personal profile service";
        goto L24
    L21:
        r12 = "Unsupported API, SDK version may be incompatible";
        goto L24
    L22:
        r12 = "Personal profile service internal error";
        goto L24
    L23:
        r12 = "Unknown error, error code: " + r11.getErrorCode();     // Catch: Exception -> L26
    L26:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "Exception occurred during personal profile search: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return com.obric.autogui.common.e.f29014b.b("Exception occurred during personal profile search: " + e.getMessage());
    L5:
        return com.obric.autogui.common.e.f29014b.b("no input provided");
    }

    @Override // com.obric.autogui.operator.b
    public void a(com.obric.autogui.operator.e r2) {
        o.e(r2, "step");
        super.a(r2);
        this.f29651d = r2;
    }

    @Override // com.obric.autogui.operator.b
    public void b(com.obric.autogui.operator.e r2) {
        o.e(r2, "step");
        super.b(r2);
        this.f29651d = null;
    }
}
