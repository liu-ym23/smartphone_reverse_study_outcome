package com.obric.autogui.agents.vlm.models.omni.upload.a;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import d.h.b.o;

/* JADX INFO: compiled from: OmniUploadReactViewTreeCountStore.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends com.obric.autogui.agents.vlm.models.omni.a.a {
    private static final String TAG = "OmniReactViewTreeCount";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f28543a = null;

    /* JADX INFO: compiled from: OmniUploadReactViewTreeCountStore.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f28543a = new a(null);
    }

    public static /* synthetic */ String lambda$MCtotTYh56whQuhK4Dw0gxyadsI(String r0) {
        return f(r0);
    }

    public c() {
        super("omni_upload_react_view_tree_count_store", "task_react_view_tree_count_", TAG, $$Lambda$c$MCtotTYh56whQuhK4Dw0gxyadsI.INSTANCE, null, 16, null);
    }

    private static final String f(String r1) {
        o.e(r1, "it");
        return d.f28544b.a(r1);
    }

    public final int e(String r2) {
        o.e(r2, DBDefinition.TASK_ID);
        return a(r2);
    }
}
