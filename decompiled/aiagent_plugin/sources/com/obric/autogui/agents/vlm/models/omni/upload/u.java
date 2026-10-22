package com.obric.autogui.agents.vlm.models.omni.upload;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: compiled from: OmniUploadImageStore.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class u extends com.obric.autogui.agents.vlm.models.omni.a.k<t> {
    private static final String TAG = "OmniUploadImageStore";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f28854a = null;

    /* JADX INFO: compiled from: OmniUploadImageStore.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f28854a = new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public u() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: renamed from: lambda$l9F0CARA99w9UYO-b0f2s9VZL4Y, reason: not valid java name */
    public static /* synthetic */ File m790lambda$l9F0CARA99w9UYOb0f2s9VZL4Y() {
        return b();
    }

    public /* synthetic */ u(d.h.a.a r2, int r3, d.h.b.h r4) {
        d.h.a.a r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = $$Lambda$u$l9F0CARA99w9UYOb0f2s9VZL4Y.INSTANCE;
    L5:
        this(r5);
    }

    private static final File b() {
        return com.obric.autogui.session.a.c.f30720a.a();
    }

    public u(d.h.a.a<? extends File> r4) {
        d.h.a.a r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "journalRootProvider");
        super((com.obric.autogui.agents.vlm.models.omni.a.g) ZeusTransformUtils.preCheckCast(r.f28823b, com.obric.autogui.agents.vlm.models.omni.a.g.class, "com.obric.aiagent.plugin"), TAG, r5);
    }
}
