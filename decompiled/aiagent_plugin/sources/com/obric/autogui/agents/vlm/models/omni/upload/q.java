package com.obric.autogui.agents.vlm.models.omni.upload;

import com.ss.android.socialbase.downloader.constants.DBDefinition;

/* JADX INFO: compiled from: OmniUploadImageCountStore.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class q extends com.obric.autogui.agents.vlm.models.omni.a.a {
    private static final String TAG = "OmniUploadImageCountStore";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f28822a = null;

    /* JADX INFO: compiled from: OmniUploadImageCountStore.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f28822a = new a(null);
    }

    /* JADX INFO: renamed from: lambda$YN49lpYgvtPDlvMf-Chd8V9hyiw, reason: not valid java name */
    public static /* synthetic */ String m789lambda$YN49lpYgvtPDlvMfChd8V9hyiw(String r0) {
        return f(r0);
    }

    public q() {
        super("omni_upload_image_count_store", "task_image_count_", TAG, $$Lambda$q$YN49lpYgvtPDlvMfChd8V9hyiw.INSTANCE, null, 16, null);
    }

    private static final String f(String r1) {
        d.h.b.o.e(r1, "it");
        return r.f28823b.a(r1);
    }

    public final int e(String r2) {
        d.h.b.o.e(r2, DBDefinition.TASK_ID);
        return a(r2);
    }
}
