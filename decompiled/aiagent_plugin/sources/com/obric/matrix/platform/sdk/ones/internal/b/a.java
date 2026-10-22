package com.obric.matrix.platform.sdk.ones.internal.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: KtExt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f33683a = null;

    static {
        f33683a = new a();
    }

    private a() {
    }

    public final JSONObject a(String r2) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == true) goto L17;
        return new JSONObject(r2);
    L14:
        return new JSONObject();
    L17:
        return new JSONObject();
    L5:
        if (r1.length() == 0) goto L8;
        r3 = false;
        goto L9
    }
}
