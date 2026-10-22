package ch.qos.logback.classic.util;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class LoggerNameUtil {
    public static List<String> computeNameParts(String str) {
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        while (true) {
            int separatorIndexOf = getSeparatorIndexOf(str, i4);
            if (separatorIndexOf == -1) {
                arrayList.add(str.substring(i4));
                return arrayList;
            }
            arrayList.add(str.substring(i4, separatorIndexOf));
            i4 = separatorIndexOf + 1;
        }
    }

    public static int getFirstSeparatorIndexOf(String str) {
        return getSeparatorIndexOf(str, 0);
    }

    public static int getSeparatorIndexOf(String str, int i4) {
        int iIndexOf = str.indexOf(46, i4);
        int iIndexOf2 = str.indexOf(36, i4);
        if (iIndexOf == -1 && iIndexOf2 == -1) {
            return -1;
        }
        return iIndexOf == -1 ? iIndexOf2 : (iIndexOf2 != -1 && iIndexOf >= iIndexOf2) ? iIndexOf2 : iIndexOf;
    }
}
