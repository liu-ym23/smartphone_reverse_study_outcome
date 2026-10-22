package xc;

import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import xc.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f13778a = new String[0];

    public static String[] a(char c9, vd.a aVar) {
        char cCharAt;
        yc.b bVar;
        a aVar2 = a.C0170a.f13777a;
        aVar2.getClass();
        zc.a aVar3 = aVar2.f13776a.f14306a.get(Integer.toHexString(c9).toUpperCase());
        String str = aVar3 != null ? aVar3.f14307b : null;
        if (str == null || str.equals("(none0)") || !str.startsWith("(") || !str.endsWith(")")) {
            str = null;
        }
        String[] strArrSplit = str != null ? str.substring(str.indexOf("(") + 1, str.lastIndexOf(")")).split(",") : null;
        if (strArrSplit == null) {
            return f13778a;
        }
        for (int i10 = 0; i10 < strArrSplit.length; i10++) {
            String lowerCase = strArrSplit[i10];
            yc.a aVar4 = yc.a.f14205d;
            yc.a aVar5 = (yc.a) aVar.f13524c;
            yc.b bVar2 = yc.b.f14207b;
            if (aVar4 == aVar5 && (bVar2 == (bVar = (yc.b) aVar.f13522a) || yc.b.f14206a == bVar)) {
                throw new BadHanyuPinyinOutputFormatCombination("tone marks cannot be added to v or u:");
            }
            if (yc.a.f14204c == aVar5) {
                lowerCase = lowerCase.replaceAll("[1-5]", "");
            } else if (aVar4 == aVar5) {
                lowerCase = lowerCase.replaceAll("u:", "v").toLowerCase();
                if (lowerCase.matches("[a-z]*[1-5]?")) {
                    if (lowerCase.matches("[a-z]*[1-5]")) {
                        int numericValue = Character.getNumericValue(lowerCase.charAt(lowerCase.length() - 1));
                        int iIndexOf = lowerCase.indexOf(97);
                        int iIndexOf2 = lowerCase.indexOf(101);
                        int iIndexOf3 = lowerCase.indexOf("ou");
                        if (-1 != iIndexOf) {
                            iIndexOf3 = iIndexOf;
                            cCharAt = 'a';
                        } else if (-1 != iIndexOf2) {
                            iIndexOf3 = iIndexOf2;
                            cCharAt = 'e';
                        } else if (-1 == iIndexOf3) {
                            int length = lowerCase.length() - 1;
                            while (true) {
                                if (length < 0) {
                                    cCharAt = '$';
                                    iIndexOf3 = -1;
                                    break;
                                }
                                if (String.valueOf(lowerCase.charAt(length)).matches("[aeiouv]")) {
                                    iIndexOf3 = length;
                                    cCharAt = lowerCase.charAt(length);
                                    break;
                                }
                                length--;
                            }
                        } else {
                            cCharAt = "ou".charAt(0);
                        }
                        if ('$' != cCharAt && -1 != iIndexOf3) {
                            lowerCase = lowerCase.substring(0, iIndexOf3).replaceAll("v", "ü") + "āáăàaēéĕèeīíĭìiōóŏòoūúŭùuǖǘǚǜü".charAt(("aeiouv".indexOf(cCharAt) * 5) + (numericValue - 1)) + lowerCase.substring(iIndexOf3 + 1, lowerCase.length() - 1).replaceAll("v", "ü");
                        }
                    } else {
                        lowerCase = lowerCase.replaceAll("v", "ü");
                    }
                }
            }
            yc.b bVar3 = (yc.b) aVar.f13522a;
            if (bVar2 == bVar3) {
                lowerCase = lowerCase.replaceAll("u:", "v");
            } else if (yc.b.f14208c == bVar3) {
                lowerCase = lowerCase.replaceAll("u:", "ü");
            }
            if (yc.a.f14202a == ((yc.a) aVar.f13523b)) {
                lowerCase = lowerCase.toUpperCase();
            }
            strArrSplit[i10] = lowerCase;
        }
        return strArrSplit;
    }
}
