package com.stepos.agentframework.util;

import android.util.Base64;
import com.autonavi.aps.amapapi.config.Const;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/stepos/agentframework/util/b;", "", "<init>", "()V", "", "str", "", "urlSafe", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Z)Ljava/lang/String;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.util.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2153b {
    public static final C2153b INSTANCE = new C2153b();

    public static /* synthetic */ String b(C2153b c2153b, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return c2153b.a(str, z10);
    }

    public final String a(String str, boolean urlSafe) {
        kotlin.jvm.internal.p.i(str, "str");
        Charset UTF_8 = StandardCharsets.UTF_8;
        kotlin.jvm.internal.p.h(UTF_8, "UTF_8");
        byte[] bytes = str.getBytes(UTF_8);
        kotlin.jvm.internal.p.h(bytes, "getBytes(...)");
        String strEncodeToString = Base64.encodeToString(bytes, urlSafe ? 10 : 2);
        kotlin.jvm.internal.p.h(strEncodeToString, "encodeToString(...)");
        return strEncodeToString;
    }
}
