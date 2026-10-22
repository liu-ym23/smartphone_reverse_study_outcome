package com.bytedance.applet.impl.moa;

import com.android.ttcjpaysdk.base.ui.dialog.CJPayLynxStandardKeepActivity;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f191984a = 0;

    static {
    }

    public static e a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "schemaPayload");
        JSONObject r101 = g.b(r100);
        String r102 = null;
        if (r101 != null) goto L5;
        return null;
    L5:
        Object r103 = r101.opt("client_option");
        if ((r103 instanceof JSONObject) == false) goto L8;
        JSONObject r104 = (JSONObject) r103;
    L9:
        if (r104 != null) goto L11;
        return null;
    L11:
        Object r105 = r104.opt("params");
        if ((r105 instanceof JSONObject) == false) goto L14;
        JSONObject r106 = (JSONObject) r105;
    L15:
        if (r106 != null) goto L17;
        return null;
    L17:
        Object r107 = r101.opt("server_option");
        if ((r107 instanceof JSONObject) == false) goto L20;
        JSONObject r108 = (JSONObject) r107;
    L21:
        if (r108 != null) goto L23;
        return null;
    L23:
        String r109 = g.a(r106, "authorization_id");
        if (r109 != null) goto L27;
        return null;
    L27:
        if (g.a(r108, CJPayLynxStandardKeepActivity.INTENT_CALLBACK_ID) != null) goto L29;
        return null;
    L29:
        String r110 = g.a(r106, "ext");
        if (r110 == null) goto L35;
        JSONObject r111 = g.b(r110);
        if (r111 == null) goto L35;
        r102 = g.a(r111, "doubaoAppletKey");
    L35:
        return new e(r102, r109, r110, g.d(r108));
    L20:
        r108 = null;
        goto L21
    L14:
        r106 = null;
        goto L15
    L8:
        r104 = null;
        goto L9
    }
}
