package com.obric.autogui.agents.vlm.models.omni.upload.b;

import com.obric.autogui.agents.vlm.models.omni.a.g;
import com.obric.autogui.agents.vlm.models.omni.a.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.io.File;

/* JADX INFO: compiled from: OmniUploadViewTreeStore.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends k<e> {
    private static final String TAG = "OmniUploadVTStore";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f28636a = null;

    /* JADX INFO: compiled from: OmniUploadViewTreeStore.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f28636a = new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ File lambda$Sjm6dm84c9OMhcd4Q9IGDuMw7Z8() {
        return b();
    }

    public /* synthetic */ f(d.h.a.a r2, int r3, h r4) {
        d.h.a.a r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = $$Lambda$f$Sjm6dm84c9OMhcd4Q9IGDuMw7Z8.INSTANCE;
    L5:
        this(r5);
    }

    private static final File b() {
        return com.obric.autogui.session.a.c.f30720a.a();
    }

    public f(d.h.a.a<? extends File> r4) {
        d.h.a.a r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r5, "journalRootProvider");
        super((g) ZeusTransformUtils.preCheckCast(b.f28610b, g.class, "com.obric.aiagent.plugin"), TAG, r5);
    }
}
