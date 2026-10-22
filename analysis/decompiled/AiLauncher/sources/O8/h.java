package O8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public final O8.e f5272a;

    public interface a {
        List<f> a();

        String name();
    }

    public interface b {
        int d();

        boolean e();
    }

    public interface c {
        String a();

        boolean c();

        a d();

        Pattern e();

        boolean f();
    }

    public interface d extends b {
        String a();

        List<? extends b> b();

        boolean c();

        String type();
    }

    public interface e extends b {
        String f();
    }

    public interface f {
        List<c> a();

        String name();
    }

    public h(O8.e eVar) {
        this.f5272a = eVar;
    }

    public static a b(String str, List<f> list) {
        return new O8.d(str, list);
    }

    public static a c(String str, f... fVarArr) {
        return new O8.d(str, O8.b.a(fVarArr));
    }

    public static boolean d(b bVar) {
        return bVar.e() && ((d) bVar).c();
    }

    public static boolean e(b bVar) {
        return bVar.e();
    }

    public static c g(Pattern pattern) {
        return new g(pattern, false, false, null, null);
    }

    public static c h(Pattern pattern, boolean z10) {
        return new g(pattern, z10, false, null, null);
    }

    public static c i(Pattern pattern, boolean z10, boolean z11) {
        return new g(pattern, z10, z11, null, null);
    }

    public static c j(Pattern pattern, boolean z10, boolean z11, String str) {
        return new g(pattern, z10, z11, str, null);
    }

    public static c k(Pattern pattern, boolean z10, boolean z11, String str, a aVar) {
        return new g(pattern, z10, z11, str, aVar);
    }

    public static f l(String str, c... cVarArr) {
        return new l(str, O8.b.a(cVarArr));
    }

    public a a(String str) {
        return this.f5272a.a(this, str);
    }

    public final void f(String str, List<b> list, a aVar, int i10, int i11, boolean z10, f fVar) {
        f next;
        int i12;
        f fVar2;
        String strSubstring;
        int i13;
        boolean z11;
        Matcher matcher;
        int i14;
        int length;
        Pattern pattern;
        int i15;
        int i16;
        List<b> listSingletonList;
        int i17;
        int i18;
        int length2 = str.length();
        Iterator<f> it = aVar.a().iterator();
        while (it.hasNext() && (next = it.next()) != fVar) {
            for (c cVar : next.a()) {
                boolean zF = cVar.f();
                boolean zC = cVar.c();
                Pattern patternE = cVar.e();
                int i19 = 0;
                int i20 = i10;
                int length3 = i11;
                int i21 = 0;
                while (i20 < list.size()) {
                    if (list.size() > length2) {
                        throw new RuntimeException("Prism4j internal error. Number of entry nodes is greater that the text length.\nNodes: " + list + "\nText: " + str);
                    }
                    b bVar = list.get(i20);
                    int i22 = i21;
                    if (e(bVar)) {
                        pattern = patternE;
                        i17 = i19;
                        i12 = length2;
                        i21 = i22;
                    } else {
                        String strF = ((e) bVar).f();
                        if (!zC || i20 == list.size() - 1) {
                            fVar2 = next;
                            i12 = length2;
                            strSubstring = strF;
                            i13 = 0;
                            z11 = false;
                            matcher = patternE.matcher(strF);
                            i14 = 1;
                        } else {
                            matcher = patternE.matcher(str);
                            matcher.region(length3, length2);
                            if (!matcher.find()) {
                                break;
                            }
                            int iStart = matcher.start();
                            if (zF) {
                                iStart += matcher.group(1).length();
                            }
                            int iStart2 = matcher.start() + matcher.group(i19).length();
                            int size = list.size();
                            fVar2 = next;
                            i12 = length2;
                            int iD = length3;
                            int i23 = iD;
                            int i24 = i20;
                            while (i20 < size) {
                                if (iD >= iStart2) {
                                    if (e(list.get(i20))) {
                                        break;
                                    }
                                    i18 = iStart2;
                                    if (d(list.get(i20 - 1))) {
                                        break;
                                    }
                                } else {
                                    i18 = iStart2;
                                }
                                iD += list.get(i20).d();
                                if (iStart >= iD) {
                                    i24++;
                                    i23 = iD;
                                }
                                i20++;
                                iStart2 = i18;
                            }
                            if (e(list.get(i24))) {
                                pattern = patternE;
                                i20 = i24;
                                length3 = i23;
                                i21 = i22;
                                next = fVar2;
                                i17 = 0;
                            } else {
                                i14 = i20 - i24;
                                i13 = -i23;
                                strSubstring = str.substring(i23, iD);
                                i20 = i24;
                                length3 = i23;
                                z11 = true;
                            }
                        }
                        if (z11 || matcher.find()) {
                            if (zF) {
                                String strGroup = matcher.group(1);
                                length = strGroup != null ? strGroup.length() : 0;
                            } else {
                                length = i22;
                            }
                            int iStart3 = matcher.start() + i13 + length;
                            String strSubstring2 = length > 0 ? matcher.group().substring(length) : matcher.group();
                            int length4 = strSubstring2.length() + iStart3;
                            pattern = patternE;
                            for (int i25 = 0; i25 < i14; i25++) {
                                list.remove(i20);
                            }
                            if (iStart3 != 0) {
                                String strSubstring3 = strSubstring.substring(0, iStart3);
                                length3 += strSubstring3.length();
                                list.add(i20, new j(strSubstring3));
                                i15 = i20 + 1;
                                i20 = i15;
                            } else {
                                i15 = i20;
                            }
                            a aVarD = cVar.d();
                            boolean z12 = aVarD != null;
                            if (z12) {
                                i16 = i15;
                                listSingletonList = m(strSubstring2, aVarD);
                            } else {
                                i16 = i15;
                                listSingletonList = Collections.singletonList(new j(strSubstring2));
                            }
                            List<b> list2 = listSingletonList;
                            int i26 = i20 + 1;
                            list.add(i20, new i(fVar2.name(), list2, cVar.a(), strSubstring2, zC, z12));
                            if (length4 < strSubstring.length()) {
                                list.add(i26, new j(strSubstring.substring(length4)));
                            }
                            if (i14 != 1) {
                                next = fVar2;
                                i17 = 0;
                                f(str, list, aVar, i16, length3, true, next);
                            } else {
                                next = fVar2;
                                i17 = 0;
                            }
                            if (z10) {
                                break;
                            }
                            i21 = length;
                            i20 = i16;
                        } else {
                            if (z10) {
                                next = fVar2;
                                break;
                            }
                            pattern = patternE;
                            i21 = i22;
                            next = fVar2;
                            i17 = 0;
                        }
                    }
                    length3 += list.get(i20).d();
                    i20++;
                    i19 = i17;
                    length2 = i12;
                    patternE = pattern;
                }
                i12 = length2;
                length2 = i12;
            }
        }
    }

    public List<b> m(String str, a aVar) {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(new j(str));
        f(str, arrayList, aVar, 0, 0, false, null);
        return arrayList;
    }
}
