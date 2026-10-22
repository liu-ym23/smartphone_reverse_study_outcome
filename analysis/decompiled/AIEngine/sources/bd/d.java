package bd;

import gc.i;
import gc.o;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.text.Regex;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final Regex f3219a = new Regex("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* renamed from: b, reason: collision with root package name */
    public static final Regex f3220b = new Regex(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    public static final ad.l a(String str) {
        kotlin.jvm.internal.g.f(str, "<this>");
        byte[] bArr = i.f3230a;
        Regex regex = f3219a;
        kotlin.jvm.internal.g.f(regex, "<this>");
        gc.i iVarB = regex.b(str, 0);
        if (iVarB == null || iVarB.b().f8451a != 0) {
            iVarB = null;
        }
        if (iVarB == null) {
            throw new IllegalArgumentException("No subtype found for: \"" + str + '\"');
        }
        String str2 = (String) ((i.a) iVarB.a()).get(1);
        Locale locale = Locale.ROOT;
        String lowerCase = str2.toLowerCase(locale);
        kotlin.jvm.internal.g.e(lowerCase, "toLowerCase(...)");
        String lowerCase2 = ((String) ((i.a) iVarB.a()).get(2)).toLowerCase(locale);
        kotlin.jvm.internal.g.e(lowerCase2, "toLowerCase(...)");
        ArrayList arrayList = new ArrayList();
        int i10 = iVarB.b().f8452b;
        while (true) {
            int i11 = i10 + 1;
            if (i11 >= str.length()) {
                return new ad.l(str, lowerCase, lowerCase2, (String[]) arrayList.toArray(new String[0]));
            }
            Regex regex2 = f3220b;
            kotlin.jvm.internal.g.f(regex2, "<this>");
            gc.i iVarB2 = regex2.b(str, i11);
            if (iVarB2 == null || iVarB2.b().f8451a != i11) {
                iVarB2 = null;
            }
            if (iVarB2 == null) {
                StringBuilder sb2 = new StringBuilder("Parameter is not formatted correctly: \"");
                String strSubstring = str.substring(i11);
                kotlin.jvm.internal.g.e(strSubstring, "substring(...)");
                sb2.append(strSubstring);
                sb2.append("\" for: \"");
                throw new IllegalArgumentException(ai.onnxruntime.a.n(sb2, str, '\"').toString());
            }
            i.b bVar = iVarB2.f9138c;
            gc.g gVarB = bVar.b(1);
            String str3 = gVarB != null ? gVarB.f9134a : null;
            if (str3 == null) {
                i10 = iVarB2.b().f8452b;
            } else {
                gc.g gVarB2 = bVar.b(2);
                String strSubstring2 = gVarB2 != null ? gVarB2.f9134a : null;
                if (strSubstring2 == null) {
                    gc.g gVarB3 = bVar.b(3);
                    kotlin.jvm.internal.g.c(gVarB3);
                    strSubstring2 = gVarB3.f9134a;
                } else if (o.k0(strSubstring2, "'", false) && o.e0(strSubstring2, "'", false) && strSubstring2.length() > 2) {
                    strSubstring2 = strSubstring2.substring(1, strSubstring2.length() - 1);
                    kotlin.jvm.internal.g.e(strSubstring2, "substring(...)");
                }
                arrayList.add(str3);
                arrayList.add(strSubstring2);
                i10 = iVarB2.b().f8452b;
            }
        }
    }
}
