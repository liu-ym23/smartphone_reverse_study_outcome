package com.obric.autogui.agents.vlm.models.omni.upload.b;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: OmniUploadViewTreeCountStore.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.obric.autogui.agents.vlm.models.omni.a.a {
    private static final String TAG = "OmniUploadVTCountStore";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0715a f28609a = null;

    /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.models.omni.upload.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: OmniUploadViewTreeCountStore.kt */
    public static final class C0715a {
        public /* synthetic */ C0715a(h r1) {
            this();
        }

        private C0715a() {
        }
    }

    static {
        f28609a = new C0715a(null);
    }

    public static /* synthetic */ String lambda$thAASeYAdOsR1Ohqn_OJY4tu1gM(String r0) {
        return f(r0);
    }

    public a() {
        $$Lambda$a$thAASeYAdOsR1Ohqn_OJY4tu1gM r4 = $$Lambda$a$thAASeYAdOsR1Ohqn_OJY4tu1gM.INSTANCE;
        super("omni_upload_viewtree_count_store", "task_viewtree_count_", TAG, r4, null, 16, null);
    }

    private static final String f(String r1) {
        o.e(r1, "it");
        return b.f28610b.a(r1);
    }

    public final int e(String r2) {
        o.e(r2, DBDefinition.TASK_ID);
        return a(r2);
    }
}
