package com.stepos.core.ota.data;

import android.content.Context;
import androidx.datastore.preferences.protobuf.b1;
import com.google.gson.internal.LinkedTreeMap;
import d5.o;
import d5.q;
import d5.r;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.c;
import kotlin.collections.b;
import kotlin.jvm.internal.g;
import mb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class UpdateInfoI18nKt {
    private static final String I18N_UPDATE_INFO_KEY = "updateInfo";
    private static final Set<String> TRADITIONAL_ZH_REGIONS = l.s0(new String[]{"TW", "HK", "MO"});

    /* JADX WARN: Removed duplicated region for block: B:17:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.util.List<java.lang.String> i18nKeyCandidates(java.util.Locale r7, java.util.Set<java.lang.String> r8) {
        /*
            java.lang.String r0 = "locale"
            kotlin.jvm.internal.g.f(r7, r0)
            java.lang.String r0 = "available"
            kotlin.jvm.internal.g.f(r8, r0)
            java.lang.String r0 = r7.getLanguage()
            java.lang.String r1 = "getLanguage(...)"
            kotlin.jvm.internal.g.e(r0, r1)
            java.util.Locale r1 = java.util.Locale.ROOT
            java.lang.String r2 = "ROOT"
            kotlin.jvm.internal.g.e(r1, r2)
            java.lang.String r0 = r0.toLowerCase(r1)
            java.lang.String r2 = "toLowerCase(...)"
            kotlin.jvm.internal.g.e(r0, r2)
            boolean r2 = gc.q.t0(r0)
            if (r2 == 0) goto L2c
            kotlin.collections.EmptyList r7 = kotlin.collections.EmptyList.f10001a
            return r7
        L2c:
            java.lang.String r2 = r7.getCountry()
            java.lang.String r3 = "getCountry(...)"
            kotlin.jvm.internal.g.e(r2, r3)
            java.lang.String r1 = r2.toUpperCase(r1)
            java.lang.String r2 = "toUpperCase(...)"
            kotlin.jvm.internal.g.e(r1, r2)
            java.util.LinkedHashSet r2 = new java.util.LinkedHashSet
            r2.<init>()
            boolean r3 = gc.q.t0(r1)
            java.lang.String r4 = "_"
            if (r3 != 0) goto L60
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            r3.append(r4)
            r3.append(r1)
            java.lang.String r3 = r3.toString()
            r2.add(r3)
        L60:
            java.lang.String r3 = "zh"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto Lb2
            java.lang.String r8 = r7.getScript()
            java.lang.String r0 = "Hant"
            boolean r8 = gc.o.f0(r8, r0)
            if (r8 != 0) goto L8b
            java.lang.String r7 = r7.getScript()
            java.lang.String r8 = "getScript(...)"
            kotlin.jvm.internal.g.e(r7, r8)
            boolean r7 = gc.q.t0(r7)
            if (r7 == 0) goto Lad
            java.util.Set<java.lang.String> r7 = com.stepos.core.ota.data.UpdateInfoI18nKt.TRADITIONAL_ZH_REGIONS
            boolean r7 = r7.contains(r1)
            if (r7 == 0) goto Lad
        L8b:
            java.lang.String r7 = "HK"
            boolean r7 = r1.equals(r7)
            java.lang.String r8 = "zh_HK"
            java.lang.String r0 = "zh_TW"
            if (r7 != 0) goto La7
            java.lang.String r7 = "MO"
            boolean r7 = r1.equals(r7)
            if (r7 == 0) goto La0
            goto La7
        La0:
            r2.add(r0)
            r2.add(r8)
            goto Lad
        La7:
            r2.add(r8)
            r2.add(r0)
        Lad:
            java.util.List r7 = kotlin.collections.a.O0(r2)
            return r7
        Lb2:
            r2.add(r0)
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.Iterator r8 = r8.iterator()
        Lc0:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto Ldc
            java.lang.Object r1 = r8.next()
            r3 = r1
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r5 = r0.concat(r4)
            r6 = 0
            boolean r3 = gc.o.k0(r3, r5, r6)
            if (r3 == 0) goto Lc0
            r7.add(r1)
            goto Lc0
        Ldc:
            java.util.List r7 = kotlin.collections.a.H0(r7)
            java.util.Iterator r7 = r7.iterator()
        Le4:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto Lf4
            java.lang.Object r8 = r7.next()
            java.lang.String r8 = (java.lang.String) r8
            r2.add(r8)
            goto Le4
        Lf4:
            java.util.List r7 = kotlin.collections.a.O0(r2)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.data.UpdateInfoI18nKt.i18nKeyCandidates(java.util.Locale, java.util.Set):java.util.List");
    }

    public static final String localizedUpdateInfo(OtaRemoteModel otaRemoteModel, Context context) {
        g.f(otaRemoteModel, "<this>");
        g.f(context, "context");
        String i18n = otaRemoteModel.getI18n();
        String update_info = otaRemoteModel.getUpdate_info();
        Locale locale = context.getResources().getConfiguration().getLocales().get(0);
        if (locale == null) {
            locale = Locale.getDefault();
        }
        g.c(locale);
        return resolveLocalizedUpdateInfo(i18n, update_info, locale);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.Result$Failure] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.HashMap] */
    private static final Map<String, String> parseI18nUpdateInfo(String str) {
        ?? A;
        o oVarU;
        o oVarH;
        String strF;
        try {
            oVarU = b1.U(str);
        } catch (Throwable th) {
            A = c.a(th);
        }
        if (!(oVarU instanceof q)) {
            return b.d0();
        }
        A = new HashMap();
        Iterator it = ((LinkedTreeMap.b) oVarU.c().f8383a.entrySet()).iterator();
        while (((LinkedTreeMap.d) it).hasNext()) {
            Map.Entry entryA = ((LinkedTreeMap.b.a) it).a();
            String str2 = (String) entryA.getKey();
            o oVar = (o) entryA.getValue();
            if (oVar != null) {
                if (!(oVar instanceof q)) {
                    oVar = null;
                }
                if (oVar != null && (oVarH = oVar.c().h("updateInfo")) != null) {
                    o oVar2 = oVarH instanceof r ? oVarH : null;
                    if (oVar2 != null && (strF = oVar2.f()) != null) {
                        A.put(str2, strF);
                    }
                }
            }
        }
        Map<String, String> mapD0 = b.d0();
        boolean z = A instanceof Result.Failure;
        Map<String, String> map = A;
        if (z) {
            map = mapD0;
        }
        return map;
    }

    public static final String resolveLocalizedUpdateInfo(String i18nJson, String defaultInfo, Locale locale) {
        g.f(i18nJson, "i18nJson");
        g.f(defaultInfo, "defaultInfo");
        g.f(locale, "locale");
        if (!gc.q.t0(i18nJson)) {
            Map<String, String> i18nUpdateInfo = parseI18nUpdateInfo(i18nJson);
            if (!i18nUpdateInfo.isEmpty()) {
                Iterator<String> it = i18nKeyCandidates(locale, i18nUpdateInfo.keySet()).iterator();
                while (it.hasNext()) {
                    String str = i18nUpdateInfo.get(it.next());
                    if (str != null) {
                        if (gc.q.t0(str)) {
                            str = null;
                        }
                        if (str != null) {
                            return str;
                        }
                    }
                }
            }
        }
        return defaultInfo;
    }
}
