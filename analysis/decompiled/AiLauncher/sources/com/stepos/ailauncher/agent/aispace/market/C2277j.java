package com.stepos.ailauncher.agent.aispace.market;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.taskstore.provider.c;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u0003J\u0019\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R \u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00160\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R#\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00160\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/market/j;", "", "<init>", "()V", "", c.a.COL_SUMMARY, "body", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;)V", "c", "raw", "e", "(Ljava/lang/String;)Ljava/lang/String;", "", "MAX_ENTRIES", "I", "JSON_INDENT", "Ljava/text/SimpleDateFormat;", "timeFmt", "Ljava/text/SimpleDateFormat;", "LXa/k;", "", "_log", "LXa/k;", "LXa/t;", com.stepos.statsapp.v3.lib.plugin.events.b.f30786f, "LXa/t;", Const.INTENT_KEY_UMID, "()LXa/t;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.market.j, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2277j {
    private static final int JSON_INDENT = 2;
    private static final int MAX_ENTRIES = 100;
    private static final Xa.k<List<String>> _log;
    private static final Xa.t<List<String>> log;
    public static final C2277j INSTANCE = new C2277j();
    private static final SimpleDateFormat timeFmt = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());

    static {
        Xa.k<List<String>> kVarA = Xa.u.a(C1173v.m());
        _log = kVarA;
        log = Xa.d.c(kVarA);
    }

    public static /* synthetic */ void b(C2277j c2277j, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        c2277j.a(str, str2);
    }

    public final void a(String summary, String body) {
        String str;
        kotlin.jvm.internal.p.i(summary, "summary");
        String str2 = timeFmt.format(new Date());
        String strE = body != null ? INSTANCE.e(body) : null;
        if (strE != null) {
            str = "[" + str2 + "] " + summary + "\n" + strE;
        } else if (body == null || body.length() == 0) {
            str = "[" + str2 + "] " + summary;
        } else {
            str = "[" + str2 + "] " + summary + "\n" + body;
        }
        Xa.k<List<String>> kVar = _log;
        List<String> value = kVar.getValue();
        kVar.setValue(value.size() >= 100 ? Z8.F.T0(Z8.F.h0(value, value.size() - 99), str) : Z8.F.T0(value, str));
    }

    public final void c() {
        _log.setValue(C1173v.m());
    }

    public final Xa.t<List<String>> d() {
        return log;
    }

    public final String e(String raw) {
        String string = La.H.D1(raw).toString();
        if (string.length() == 0) {
            return null;
        }
        try {
            char cN1 = La.K.N1(string);
            if (cN1 == '[') {
                return new JSONArray(string).toString(2);
            }
            if (cN1 != '{') {
                return null;
            }
            return new JSONObject(string).toString(2);
        } catch (Throwable unused) {
            return null;
        }
    }
}
