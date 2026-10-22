package org.tensorflow.lite;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: RuntimeFlavor.java */
/* JADX INFO: loaded from: classes5.dex */
public final enum d extends Enum<d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f40589a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f40590b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ d[] f40591c = null;

    private d(String r1, int r2) {
        super(r1, r2);
    }

    public static d valueOf(String r2) {
        return (d) ZeusTransformUtils.preCheckCast(Enum.valueOf(d.class, r2), d.class, "com.obric.aiagent.plugin");
    }

    public static d[] values() {
        return (d[]) ZeusTransformUtils.preCheckCast(f40591c.clone(), d[].class, "com.obric.aiagent.plugin");
    }

    static {
        d r0 = new d("APPLICATION", 0);
        f40589a = r0;
        d r1 = new d("SYSTEM", 1);
        f40590b = r1;
        f40591c = new d[]{r0, r1};
    }
}
