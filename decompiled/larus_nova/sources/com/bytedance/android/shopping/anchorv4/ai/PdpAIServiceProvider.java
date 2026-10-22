package com.bytedance.android.shopping.anchorv4.ai;

import com.bytedance.android.shopping.anchorv4.params.PdpAIConversationContext;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes12.dex */
public final class PdpAIServiceProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f165635a = null;

    public static final class a {
        public a() {
        }
    }

    static {
        new a();
        f165635a = LazyKt.lazy(PdpAIServiceProvider$Companion$gateway$2.INSTANCE);
    }

    public static boolean b() {
        boolean r100 = ((p0) f165635a.getValue()).isEnabled();
        l0.a("isAIChatEnabled called, result=" + r100);
        l0.a("isMcpScene called, result=" + r100);
        return r100;
    }

    public static PdpAIConversationContext a(String r100) {
        PdpAIConversationContext r101 = ((p0) f165635a.getValue()).e(r100);
        StringBuilder r102 = new StringBuilder("buildConversationContext called, schemaEmpty=");
        if (r100 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        r102.append(r103);
        r102.append(", conversationId=");
        String r104 = null;
        if (r101 == null) goto L12;
        String r105 = r101.getConversationId();
    L13:
        r102.append(r105);
        r102.append(", originMessageId=");
        if (r101 == null) goto L16;
        String r106 = r101.getOriginMessageId();
    L17:
        r102.append(r106);
        r102.append(", originBcmId=");
        if (r101 == null) goto L20;
        r104 = r101.getOriginBcmId();
    L20:
        r102.append(r104);
        l0.a(r102.toString());
        return r101;
    L16:
        r106 = null;
        goto L17
    L12:
        r105 = null;
        goto L13
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r103 = false;
        goto L9
    }
}
