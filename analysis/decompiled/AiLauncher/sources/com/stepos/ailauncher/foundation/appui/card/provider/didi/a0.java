package com.stepos.ailauncher.foundation.appui.card.provider.didi;

import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tJ#\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\f\u0010\rJ%\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0011\u0010\u0012J/\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0014\u0010\u0015J-\u0010\u0018\u001a\u0004\u0018\u00010\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0018\u0010\tJ#\u0010\u001b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001b\u0010\rJ\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010 \u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u0019\u0010#\u001a\u0004\u0018\u00010\u000e2\b\u0010\"\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b#\u0010$J!\u0010(\u001a\u0004\u0018\u00010\u00042\b\u0010%\u001a\u0004\u0018\u00010\u00042\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)J\u001d\u0010,\u001a\u0004\u0018\u00010\u00042\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000e0*¢\u0006\u0004\b,\u0010-J\u0015\u0010/\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u001e¢\u0006\u0004\b/\u00100J\u001d\u00103\u001a\u0004\u0018\u00010\u00042\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u000401¢\u0006\u0004\b3\u00104J!\u00106\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u00105\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b6\u0010\rJ\u0017\u00108\u001a\u00020\u00042\b\u00107\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b8\u0010\u001dJ%\u00109\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b9\u0010\rJ-\u0010;\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010:\u001a\u00020\u0004H\u0002¢\u0006\u0004\b;\u0010\tJ\u0017\u0010=\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\u000eH\u0002¢\u0006\u0004\b=\u0010>R\u0014\u0010?\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010A\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\bA\u0010@R\u0014\u0010B\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\bB\u0010@R\u0014\u0010C\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\bC\u0010@R\u0014\u0010E\u001a\u00020D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010F¨\u0006G"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/a0;", "", "<init>", "()V", "", "from", "to", "eta", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", AMapLocationStaticsEntity.FIRST_LOCATE, "second", "o", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "", "amount", "currency", "l", "(Ljava/lang/Double;Ljava/lang/String;)Ljava/lang/String;", "feeText", "r", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;)Ljava/lang/String;", "rawTitle", "fallbackTitle", "e", "distanceText", "durationText", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "f", "(Ljava/lang/String;)Ljava/lang/String;", "", "carTypeCount", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;I)Ljava/lang/String;", "priceText", "q", "(Ljava/lang/String;)Ljava/lang/Double;", "raw", "", "discounted", "k", "(Ljava/lang/String;Z)Ljava/lang/String;", "", "values", "c", "(Ljava/util/Collection;)Ljava/lang/String;", "count", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(I)Ljava/lang/String;", "", "names", Const.INTENT_KEY_APIKEY, "(Ljava/util/List;)Ljava/lang/String;", "toAddress", Const.INTENT_KEY_UMID, "installState", "m", "p", "separator", "n", UxipConstants.f30680s, "s", "(D)Ljava/lang/String;", "ROUTE_ARROW", "Ljava/lang/String;", "DOT", "WIDE_GAP", "COMMA", "Lkotlin/text/Regex;", "DECIMAL_NUMBER", "Lkotlin/text/Regex;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a0 {
    private static final String COMMA = "，";
    private static final String DOT = " · ";
    private static final String ROUTE_ARROW = " → ";
    private static final String WIDE_GAP = "  ";
    public static final a0 INSTANCE = new a0();
    private static final Regex DECIMAL_NUMBER = new Regex("\\d+(?:\\.\\d+)?");

    public static /* synthetic */ String h(a0 a0Var, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str3 = null;
        }
        return a0Var.g(str, str2, str3);
    }

    public final String a(List<String> names) {
        kotlin.jvm.internal.p.i(names, "names");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = names.iterator();
        while (it.hasNext()) {
            String strD = N5.j.INSTANCE.d((String) it.next());
            if (strD != null) {
                arrayList.add(strD);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return "选择 " + Z8.F.A0(arrayList, "、", null, null, 0, null, null, 62, null) + "，确认用车";
    }

    public final String b(String rawTitle, int carTypeCount) {
        String strD = N5.j.INSTANCE.d(rawTitle);
        if (strD != null) {
            return strD;
        }
        if (carTypeCount <= 0) {
            return "车型可选";
        }
        return carTypeCount + " 种车型可选";
    }

    public final String c(Collection<Double> values) {
        kotlin.jvm.internal.p.i(values, "values");
        if (values.isEmpty()) {
            return null;
        }
        Collection<Double> collection = values;
        double dM0 = Z8.F.M0(collection);
        double dH0 = Z8.F.H0(collection);
        if (dM0 == dH0) {
            return s(dM0);
        }
        return s(dM0) + O6.l.DATE_SEPARATOR + s(dH0);
    }

    public final String d(String rawTitle, String toAddress) {
        String str;
        N5.j jVar = N5.j.INSTANCE;
        String strD = jVar.d(rawTitle);
        if (strD != null) {
            return strD;
        }
        String strD2 = jVar.d(toAddress);
        if (strD2 != null) {
            str = "正在前往" + strD2;
        } else {
            str = null;
        }
        return str == null ? "行程中" : str;
    }

    public final String e(String rawTitle, String eta, String fallbackTitle) {
        N5.j jVar = N5.j.INSTANCE;
        String strD = jVar.d(rawTitle);
        if (strD == null) {
            strD = jVar.d(fallbackTitle);
        }
        String strD2 = jVar.d(eta);
        if (strD == null || strD2 == null) {
            return strD == null ? strD2 : strD;
        }
        return strD + " " + strD2;
    }

    public final String f(String eta) {
        String strD = N5.j.INSTANCE.d(eta);
        if (strD == null) {
            return null;
        }
        return "剩余行程 " + strD;
    }

    public final String g(String from, String to, String eta) {
        N5.j jVar = N5.j.INSTANCE;
        String strD = jVar.d(from);
        String strD2 = jVar.d(to);
        if (strD != null && strD2 != null) {
            strD = strD + ROUTE_ARROW + strD2;
        } else if (strD == null) {
            if (strD2 == null) {
                return null;
            }
            strD = strD2;
        }
        String strD3 = jVar.d(eta);
        if (strD3 == null) {
            return strD;
        }
        return strD + DOT + strD3;
    }

    public final String i(int count) {
        return "已选 " + count + " 个车型";
    }

    public final String j(String distanceText, String durationText) {
        String str;
        N5.j jVar = N5.j.INSTANCE;
        String strD = jVar.d(distanceText);
        if (strD != null) {
            str = "全程 " + strD;
        } else {
            str = null;
        }
        return p(str, jVar.d(durationText));
    }

    public final String k(String raw, boolean discounted) {
        String value;
        Double dT;
        StringBuilder sb2;
        String str;
        String strD = N5.j.INSTANCE.d(raw);
        if (strD == null) {
            return null;
        }
        if (La.H.f0(strD, (char) 165, false, 2, null) || La.H.f0(strD, (char) 65509, false, 2, null)) {
            return strD;
        }
        La.m mVarD = Regex.d(DECIMAL_NUMBER, strD, 0, 2, null);
        if (mVarD == null || (value = mVarD.getValue()) == null || (dT = La.B.t(value)) == null) {
            return null;
        }
        String str2 = "¥" + s(dT.doubleValue());
        if (discounted) {
            sb2 = new StringBuilder();
            str = "约 ";
        } else {
            sb2 = new StringBuilder();
            str = "券前约 ";
        }
        sb2.append(str);
        sb2.append(str2);
        return sb2.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String l(java.lang.Double r6, java.lang.String r7) {
        /*
            r5 = this;
            r0 = 0
            if (r6 == 0) goto L7e
            double r1 = r6.doubleValue()
            N5.j r6 = N5.j.INSTANCE
            java.lang.String r6 = r6.d(r7)
            if (r6 == 0) goto L1b
            java.util.Locale r7 = java.util.Locale.ROOT
            java.lang.String r0 = r6.toUpperCase(r7)
            java.lang.String r6 = "toUpperCase(...)"
            kotlin.jvm.internal.p.h(r0, r6)
        L1b:
            java.lang.String r6 = "¥"
            if (r0 == 0) goto L69
            int r7 = r0.hashCode()
            r3 = 36
            java.lang.String r4 = "$"
            if (r7 == r3) goto L60
            r3 = 165(0xa5, float:2.31E-43)
            if (r7 == r3) goto L59
            r3 = 66894(0x1054e, float:9.3738E-41)
            if (r7 == r3) goto L50
            r3 = 81255(0x13d67, float:1.13863E-40)
            if (r7 == r3) goto L47
            r6 = 84326(0x14966, float:1.18166E-40)
            if (r7 == r6) goto L3e
            goto L6a
        L3e:
            java.lang.String r6 = "USD"
            boolean r6 = r0.equals(r6)
            if (r6 != 0) goto L67
            goto L6a
        L47:
            java.lang.String r7 = "RMB"
            boolean r7 = r0.equals(r7)
            if (r7 != 0) goto L69
            goto L6a
        L50:
            java.lang.String r7 = "CNY"
            boolean r7 = r0.equals(r7)
            if (r7 == 0) goto L6a
            goto L69
        L59:
            boolean r7 = r0.equals(r6)
            if (r7 != 0) goto L69
            goto L6a
        L60:
            boolean r6 = r0.equals(r4)
            if (r6 != 0) goto L67
            goto L6a
        L67:
            r0 = r4
            goto L6a
        L69:
            r0 = r6
        L6a:
            java.lang.String r5 = r5.s(r1)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r0)
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            return r5
        L7e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.didi.a0.l(java.lang.Double, java.lang.String):java.lang.String");
    }

    public final String m(String installState) {
        String lowerCase;
        String strD = N5.j.INSTANCE.d(installState);
        if (strD != null) {
            lowerCase = strD.toLowerCase(Locale.ROOT);
            kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
        } else {
            lowerCase = null;
        }
        return kotlin.jvm.internal.p.d(lowerCase, "installing") ? "安装中" : kotlin.jvm.internal.p.d(lowerCase, "installed") ? "打开" : "安装";
    }

    public final String n(String first, String second, String separator) {
        N5.j jVar = N5.j.INSTANCE;
        String strD = jVar.d(first);
        String strD2 = jVar.d(second);
        if (strD == null || strD2 == null) {
            return strD == null ? strD2 : strD;
        }
        return strD + separator + strD2;
    }

    public final String o(String first, String second) {
        return n(first, second, COMMA);
    }

    public final String p(String first, String second) {
        return n(first, second, DOT);
    }

    public final Double q(String priceText) {
        La.m mVarD;
        String value;
        String strD = N5.j.INSTANCE.d(priceText);
        if (strD == null || (mVarD = Regex.d(DECIMAL_NUMBER, strD, 0, 2, null)) == null || (value = mVarD.getValue()) == null) {
            return null;
        }
        return La.B.t(value);
    }

    public final String r(String feeText, Double amount, String currency) {
        String strD = N5.j.INSTANCE.d(feeText);
        return strD == null ? l(amount, currency) : strD;
    }

    public final String s(double value) {
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format(Locale.US, "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(value)}, 1));
        kotlin.jvm.internal.p.h(str, "format(...)");
        return La.H.G1(La.H.G1(str, '0'), '.');
    }
}
