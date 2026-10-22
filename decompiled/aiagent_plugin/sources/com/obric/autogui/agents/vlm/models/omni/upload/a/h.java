package com.obric.autogui.agents.vlm.models.omni.upload.a;

import com.obric.autogui.agents.vlm.models.omni.a.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.io.File;

/* JADX INFO: compiled from: OmniUploadReactViewTreeStore.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h extends k<g> {
    private static final String TAG = "OmniReactViewTreeStore";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f28575a = null;

    /* JADX INFO: compiled from: OmniUploadReactViewTreeStore.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f28575a = new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ File lambda$LMnmyGVl0gFpIJf0vfOJUW5dZSQ() {
        return b();
    }

    public /* synthetic */ h(d.h.a.a r2, int r3, d.h.b.h r4) {
        d.h.a.a r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = $$Lambda$h$LMnmyGVl0gFpIJf0vfOJUW5dZSQ.INSTANCE;
    L5:
        this(r5);
    }

    private static final File b() {
        return com.obric.autogui.session.a.c.f30720a.a();
    }

    public h(d.h.a.a<? extends File> r4) {
        d.h.a.a r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r5, "journalRootProvider");
        super((com.obric.autogui.agents.vlm.models.omni.a.g) ZeusTransformUtils.preCheckCast(d.f28544b, com.obric.autogui.agents.vlm.models.omni.a.g.class, "com.obric.aiagent.plugin"), TAG, r5);
    }
}
