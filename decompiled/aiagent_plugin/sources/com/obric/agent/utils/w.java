package com.obric.agent.utils;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.oui.texteffects.OProtocolTextEffectTextView;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: compiled from: ClientPhoneEnvInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
final class w extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f16078a = null;

    static {
        f16078a = new w();
    }

    private w() {
        super("system_network", WsConstants.EXIT_DELAY_TIME);
    }

    @Override // com.obric.agent.utils.c
    public void a(JSONObject r8, long r9) {
        d.h.b.o.e(r8, "env");
        ConnectivityManager r10 = a.f15990a.a();
        if (r10 != null) goto L5;
        return;
    L5:
        JSONObject r11 = new JSONObject();
        boolean r5 = true;
        if (Build.VERSION.SDK_INT < 23) goto L27;
        Network r0 = r10.getActiveNetwork();
        if (r0 == null) goto L10;
        NetworkCapabilities r12 = r10.getNetworkCapabilities(r0);
    L11:
        if (r0 == null) goto L13;
        boolean r1 = true;
    L14:
        r11.put("type", a(r12, r1));
        if (r12 != null) goto L17;
    L19:
        boolean r7 = false;
    L20:
        r11.put("vpn", r7);
        if (r12 != null) goto L23;
    L25:
        r5 = false;
    L26:
        r11.put("reachable", r5);
    L41:
        r8.put("network", r11);
        return;
    L23:
        if (r12.hasCapability(16) != true) goto L25;
    L17:
        if (r12.hasTransport(4) != true) goto L19;
        r7 = true;
        goto L20
    L13:
        r1 = false;
        goto L14
    L10:
        r12 = null;
        goto L11
    L27:
        NetworkInfo r13 = r10.getActiveNetworkInfo();
        if (r13 == null) goto L33;
        String r14 = r13.getTypeName();
        if (r14 == null) goto L33;
        Locale r2 = Locale.US;
        d.h.b.o.c(r2, "US");
        String r15 = r14.toLowerCase(r2);
        d.h.b.o.c(r15, "toLowerCase(...)");
        if (r15 == null) goto L33;
    L34:
        r11.put("type", r15);
        r11.put("vpn", false);
        if (r13 != null) goto L37;
    L39:
        r5 = false;
    L40:
        r11.put("reachable", r5);
        goto L41
    L37:
        if (r13.isConnected() != true) goto L39;
    L33:
        r15 = OProtocolTextEffectTextView.EffectNameNone;
        goto L34
    }

    private final String a(NetworkCapabilities r1, boolean r2) {
        if (r2 == true) goto L5;
        return OProtocolTextEffectTextView.EffectNameNone;
    L5:
        if (r1 != null) goto L9;
        return SensitiveType.UNKNOWN;
    L9:
        if (r1.hasTransport(1) == false) goto L12;
        return "wifi";
    L12:
        if (r1.hasTransport(0) == false) goto L15;
        return "cellular";
    L15:
        if (r1.hasTransport(3) == false) goto L18;
        return "ethernet";
    L18:
        if (r1.hasTransport(4) == false) goto L21;
        return "vpn";
    L21:
        if (r1.hasTransport(2) == false) goto L23;
        return "bluetooth";
    L23:
        return "other";
    }
}
