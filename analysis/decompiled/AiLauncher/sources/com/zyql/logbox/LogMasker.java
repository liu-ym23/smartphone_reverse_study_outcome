package com.zyql.logbox;

import La.D;
import La.K;
import La.m;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.zyql.logbox.LogMasker;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0011\n\u0002\b\t\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bJ3\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\t2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0007J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0007J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0007R\u0014\u0010\u0017\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0016R\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010!\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u0016R\u0014\u0010#\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u0016R\u0014\u0010$\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0016¨\u0006%"}, d2 = {"Lcom/zyql/logbox/LogMasker;", "", "<init>", "()V", "", "msg", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;)Ljava/lang/String;", "keyPattern", "Lkotlin/text/Regex;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;)Lkotlin/text/Regex;", "regex", "Lkotlin/Function1;", "transform", "o", "(Ljava/lang/String;Lkotlin/text/Regex;Lp9/l;)Ljava/lang/String;", UxipConstants.f30680s, "n", "q", "m", Const.INTENT_KEY_PKGNAME, "Lkotlin/text/Regex;", "PHONE", "c", "SECRET_KEY", Const.INTENT_KEY_UMID, "CREDENTIAL", "", "e", "[Ljava/lang/String;", "NON_SECRET_LITERALS", "f", "AUTHORIZATION", Const.INTENT_KEY_BACKGROUND_COMMAND, "DEVICE_ID", "THIRD_UID", "logbox_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LogMasker {

    /* renamed from: a, reason: collision with root package name */
    public static final LogMasker f32018a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Regex PHONE;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Regex SECRET_KEY;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Regex CREDENTIAL;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final String[] NON_SECRET_LITERALS;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final Regex AUTHORIZATION;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public static final Regex DEVICE_ID;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public static final Regex THIRD_UID;

    static {
        LogMasker logMasker = new LogMasker();
        f32018a = logMasker;
        PHONE = new Regex("(?<!\\d)1[3-9]\\d{9}(?!\\d)");
        SECRET_KEY = logMasker.h("secretkey");
        CREDENTIAL = logMasker.h("token|secret|(?:api|app)[-_]?key|password|passwd|pwd|credential");
        NON_SECRET_LITERALS = new String[]{"null", "true", "false"};
        AUTHORIZATION = new Regex("(\"?authorization\"?\\s*[:=]\\s*)(\"[^\"]*\"|'[^']*'|[^\\r\\n,}\\]]*)", RegexOption.IGNORE_CASE);
        DEVICE_ID = logMasker.h("(?:zy[-_])?device[-_]?id");
        THIRD_UID = logMasker.h("third[-_]?uid");
    }

    public static final String j(String it) {
        p.i(it, "it");
        return "[REDACTED]";
    }

    public static final String k(String it) {
        p.i(it, "it");
        return "[REDACTED]";
    }

    public static final CharSequence l(m m10) {
        p.i(m10, "m");
        String value = m10.getValue();
        String strP = D.P("*", value.length() - 6);
        String strSubstring = value.substring(0, 3);
        p.h(strSubstring, "substring(...)");
        String strSubstring2 = value.substring(value.length() - 3);
        p.h(strSubstring2, "substring(...)");
        return strSubstring + strP + strSubstring2;
    }

    public static final CharSequence p(InterfaceC5074l interfaceC5074l, m m10) {
        p.i(m10, "m");
        String str = m10.c().get(1);
        String strSubstring = m10.c().get(2);
        String str2 = (strSubstring.length() >= 2 && K.N1(strSubstring) == '\"' && K.P1(strSubstring) == '\"') ? "\"" : (strSubstring.length() >= 2 && K.N1(strSubstring) == '\'' && K.P1(strSubstring) == '\'') ? "'" : "";
        if (str2.length() > 0) {
            strSubstring = strSubstring.substring(1, strSubstring.length() - 1);
            p.h(strSubstring, "substring(...)");
        }
        if (strSubstring.length() != 0) {
            strSubstring = (String) interfaceC5074l.invoke(strSubstring);
        }
        return str + str2 + strSubstring + str2;
    }

    public final Regex h(String keyPattern) {
        return new Regex("(\"?(?:" + keyPattern + ")\"?\\s*[:=]\\s*)(\"[^\"]*\"|'[^']*'|[^\\s,}\\]&]*)", RegexOption.IGNORE_CASE);
    }

    public final String i(String msg) {
        p.i(msg, "msg");
        return PHONE.m(o(o(o(o(o(msg, SECRET_KEY, new InterfaceC5074l() { // from class: h8.b
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return LogMasker.j((String) obj);
            }
        }), CREDENTIAL, new LogMasker$mask$1(this)), AUTHORIZATION, new InterfaceC5074l() { // from class: h8.c
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return LogMasker.k((String) obj);
            }
        }), DEVICE_ID, new LogMasker$mask$3(this)), THIRD_UID, new LogMasker$mask$4(this)), new InterfaceC5074l() { // from class: h8.d
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return LogMasker.l((m) obj);
            }
        });
    }

    public final String m(String value) {
        for (String str : NON_SECRET_LITERALS) {
            if (D.L(value, str, true)) {
                return value;
            }
        }
        return "[REDACTED]";
    }

    public final String n(String value) {
        if (value.length() <= 4) {
            return value;
        }
        String strSubstring = value.substring(value.length() - 4);
        p.h(strSubstring, "substring(...)");
        return "****" + strSubstring;
    }

    public final String o(String msg, Regex regex, final InterfaceC5074l<? super String, String> transform) {
        return regex.m(msg, new InterfaceC5074l() { // from class: h8.e
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return LogMasker.p(transform, (m) obj);
            }
        });
    }

    public final String q(String value) {
        if (value.length() <= 4) {
            return value;
        }
        String strSubstring = value.substring(value.length() - 4);
        p.h(strSubstring, "substring(...)");
        return "****" + strSubstring;
    }
}
