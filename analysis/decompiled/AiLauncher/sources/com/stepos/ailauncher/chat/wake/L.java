package com.stepos.ailauncher.chat.wake;

import com.autonavi.aps.amapapi.config.Const;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import o6.C5009a;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u000e\u001a\u00020\t2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0007R\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/L;", "", "<init>", "()V", "", "assetId", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Ljava/lang/String;", "name", "LY8/t;", "c", "(Ljava/lang/String;Ljava/lang/String;)V", "", "names", Const.INTENT_KEY_UMID, "(Ljava/util/Map;)V", Const.INTENT_KEY_PKGNAME, "MMKV_ID", "Ljava/lang/String;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class L {
    public static final L INSTANCE = new L();
    private static final String MMKV_ID = "market_agent_names";

    public final String a(String assetId) {
        kotlin.jvm.internal.p.i(assetId, "assetId");
        String strB = b(assetId);
        if (strB.length() == 0) {
            return null;
        }
        String strV = C5009a.v(C5009a.INSTANCE, MMKV_ID, strB, null, 4, null);
        if (strV.length() > 0) {
            return strV;
        }
        return null;
    }

    public final String b(String assetId) {
        String string = La.H.D1(assetId).toString();
        Locale ROOT = Locale.ROOT;
        kotlin.jvm.internal.p.h(ROOT, "ROOT");
        String lowerCase = string.toLowerCase(ROOT);
        kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    public final void c(String assetId, String name) {
        kotlin.jvm.internal.p.i(assetId, "assetId");
        kotlin.jvm.internal.p.i(name, "name");
        String strB = b(assetId);
        String string = La.H.D1(name).toString();
        if (strB.length() == 0 || string.length() == 0) {
            return;
        }
        C5009a.INSTANCE.H(MMKV_ID, strB, string);
    }

    public final void d(Map<String, String> names) {
        kotlin.jvm.internal.p.i(names, "names");
        for (Map.Entry<String, String> entry : names.entrySet()) {
            INSTANCE.c(entry.getKey(), entry.getValue());
        }
    }
}
