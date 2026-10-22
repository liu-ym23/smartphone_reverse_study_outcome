package com.bytedance.reparo.c;

/* JADX INFO: compiled from: EventReporterImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements com.bytedance.reparo.core.i.a {
    private static final String TAG = "EventReporterImpl";

    public d() {
    }

    @Override // com.bytedance.reparo.core.i.a
    public void a(final com.bytedance.reparo.core.a.a.a r3) {
        com.bytedance.reparo.core.i.c.a().execute(new AnonymousClass1(this, r3));
        if ("patch_load".equals(r3.a()) == false) goto L6;
        h.a(String.valueOf(r3.m().get("patch_id")));
        return;
    }
}
