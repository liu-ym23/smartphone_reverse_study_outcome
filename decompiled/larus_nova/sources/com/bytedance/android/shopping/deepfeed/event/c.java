package com.bytedance.android.shopping.deepfeed.event;

/* JADX INFO: loaded from: classes13.dex */
public final class c extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f173348a;

    public static final class a {
    }

    static {
    }

    public c() {
        super("deep_feed_load_more");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        Integer r100 = this.f173348a;
        if (r100 == null) goto L5;
        String r101 = String.valueOf(r100.intValue());
    L6:
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        appendParam("state", r101, com.bytedance.android.ec.core.event.a.b.C0794a.f44003a);
        return;
    L5:
        r101 = null;
        goto L6
    }
}
