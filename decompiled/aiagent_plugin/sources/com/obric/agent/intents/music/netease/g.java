package com.obric.agent.intents.music.netease;

import android.util.Base64;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: CloudMusicOpenApiService.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class g {
    public static final /* synthetic */ String a(String r0, String r1) {
        return b(r0, r1);
    }

    public static final /* synthetic */ String a(Map r2) {
        return b((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin"));
    }

    /* JADX INFO: renamed from: lambda$i4X-q98UU-NnMairLLQB5X0O_HM, reason: not valid java name */
    public static /* synthetic */ CharSequence m86lambda$i4Xq98UUNnMairLLQB5X0O_HM(Map r0, String r1) {
        return a(r0, r1);
    }

    private static final String b(Map<String, String> r11) {
        final Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
        ArrayList r0 = new ArrayList((Collection) ZeusTransformUtils.preCheckCast(r12.keySet(), Collection.class, "com.obric.aiagent.plugin"));
        Collections.sort((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"));
        return p.a((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("&", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, new $$Lambda$g$i4Xq98UUNnMairLLQB5X0O_HM(r12), 30, null);
    }

    private static final CharSequence a(Map r3, String r4) {
        return (CharSequence) ZeusTransformUtils.preCheckCast(r4 + '=' + ((String) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin")).get(r4), String.class, "com.obric.aiagent.plugin")), CharSequence.class, "com.obric.aiagent.plugin");
    }

    private static final String b(String r4, String r5) {
        byte[] r6 = Base64.decode(r5, 0);
        o.c(r6, "decode(...)");
        PKCS8EncodedKeySpec r1 = new PKCS8EncodedKeySpec(r6);
        PrivateKey r7 = KeyFactory.getInstance("RSA").generatePrivate((KeySpec) ZeusTransformUtils.preCheckCast(r1, KeySpec.class, "com.obric.aiagent.plugin"));
        Signature r2 = Signature.getInstance("SHA256withRSA");
        r2.initSign(r7);
        Charset r8 = StandardCharsets.UTF_8;
        o.c(r8, "UTF_8");
        byte[] r9 = r4.getBytes(r8);
        o.c(r9, "getBytes(...)");
        r2.update(r9);
        String r10 = Base64.encodeToString(r2.sign(), 0);
        o.c(r10, "encodeToString(...)");
        return r10;
    }
}
