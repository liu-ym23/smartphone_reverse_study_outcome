package ms.bd.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class w1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f39673a = 0;

    static {
        String r0 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "0b5b1d", new byte[]{26, 60, 7, 72, 51}), String.class, "com.obric.aiagent.plugin");
    }

    public static String a(String r2) {
        if (r2 != null) goto L4;
        return "";
    L4:
        if (r2.length() > 0) goto L7;
        return "";
    L7:
        return r2.trim().replace('\'', ' ').replace('\"', ' ').replace('\r', ' ').replace('\n', ' ');
    }
}
