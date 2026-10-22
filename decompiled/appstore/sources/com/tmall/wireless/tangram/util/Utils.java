package com.tmall.wireless.tangram.util;

import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import androidx.collection.ArrayMap;
import com.bytedanceos.common.toolbox.i;
import com.tmall.wireless.tangram.TangramBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class Utils {
    private static final Pattern REGEX_1 = null;
    private static final Pattern REGEX_2 = null;
    private static SparseIntArray cardColumnCountTableTable;
    private static SparseBooleanArray supportHeaderFooterTable;

    static {
        SparseBooleanArray r10 = new SparseBooleanArray();
        supportHeaderFooterTable = r10;
        r10.put(1, true);
        supportHeaderFooterTable.put(2, true);
        supportHeaderFooterTable.put(3, true);
        supportHeaderFooterTable.put(4, true);
        supportHeaderFooterTable.put(9, true);
        supportHeaderFooterTable.put(10, true);
        SparseIntArray r11 = new SparseIntArray();
        cardColumnCountTableTable = r11;
        r11.put(1, 1);
        cardColumnCountTableTable.put(2, 2);
        cardColumnCountTableTable.put(3, 3);
        cardColumnCountTableTable.put(4, 4);
        cardColumnCountTableTable.put(9, 5);
        REGEX_1 = Pattern.compile("(\\d+)x(\\d+)(_?q\\d+)?(\\.[jpg|png|gif])");
        REGEX_2 = Pattern.compile("(\\d+)-(\\d+)(_?q\\d+)?(\\.[jpg|png|gif])");
    }

    public Utils() {
    }

    public static int cardizeCell(int r10) {
        return (-r10) - 100;
    }

    public static int cellizeCard(int r10) {
        return (-100) - r10;
    }

    public static int getCardColumnCount(int r10) {
        return cardColumnCountTableTable.get(r10, 0);
    }

    public static float getImageRatio(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L39;
        return Float.NaN;
    L39:
        Matcher r11 = REGEX_1.matcher(r10);     // Catch: Exception -> L20
        if (r11.find() == true) goto L8;
        Matcher r12 = REGEX_2.matcher(r10);     // Catch: Exception -> L20
        if (r12.find() == true) goto L25;
    L38:
        return Float.NaN;
    L25:
        if (r12.groupCount() < 2) goto L38;
        String r13 = r12.group(1);     // Catch: Exception -> L20
        String r14 = r12.group(2);     // Catch: Exception -> L20
        if (r13.length() >= 5) goto L38;
        if (r14.length() >= 5) goto L38;
        int r15 = Integer.parseInt(r13);     // Catch: Exception -> L20
        int r16 = Integer.parseInt(r14);     // Catch: Exception -> L20
        if (r15 == 0) goto L36;
        if (r16 == 0) goto L36;
        return r15 / r16;
    L36:
        return 1.0f;
    L8:
        if (r11.groupCount() < 2) goto L38;
        String r17 = r11.group(1);     // Catch: Exception -> L20
        String r18 = r11.group(2);     // Catch: Exception -> L20
        if (r17.length() >= 5) goto L38;
        if (r18.length() >= 5) goto L38;
        int r19 = Integer.parseInt(r17);     // Catch: Exception -> L20
        int r20 = Integer.parseInt(r18);     // Catch: Exception -> L20
        if (r19 == 0) goto L19;
        if (r20 == 0) goto L19;
        return r19 / r20;
    L19:
        return 1.0f;
    L20:
        e = move-exception;
        e.printStackTrace();
        goto L38
    }

    public static Pair<Integer, Integer> getImageSize(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L29;
        return null;
    L29:
        Matcher r11 = REGEX_1.matcher(r10);     // Catch: Exception -> L15
        if (r11.find() == true) goto L8;
        Matcher r12 = REGEX_2.matcher(r10);     // Catch: Exception -> L15
        if (r12.find() == true) goto L20;
    L28:
        return null;
    L20:
        if (r12.groupCount() < 2) goto L28;
        String r13 = r12.group(1);     // Catch: Exception -> L15
        String r14 = r12.group(2);     // Catch: Exception -> L15
        if (r13.length() >= 5) goto L28;
        if (r14.length() >= 5) goto L28;
        int r15 = Integer.parseInt(r13);     // Catch: Exception -> L15
        int r16 = Integer.parseInt(r14);     // Catch: Exception -> L15
        return new Pair(Integer.valueOf(r15), Integer.valueOf(r16));
    L8:
        if (r11.groupCount() < 2) goto L28;
        String r17 = r11.group(1);     // Catch: Exception -> L15
        String r18 = r11.group(2);     // Catch: Exception -> L15
        if (r17.length() >= 5) goto L28;
        if (r18.length() >= 5) goto L28;
        int r19 = Integer.parseInt(r17);     // Catch: Exception -> L15
        int r20 = Integer.parseInt(r18);     // Catch: Exception -> L15
        return new Pair(Integer.valueOf(r19), Integer.valueOf(r20));
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L28
    }

    public static boolean isCellizedCard(JSONObject r10) {
        if (r10 == null) goto L4;
        String r11 = r10.optString("kind");
    L6:
        return "row".equalsIgnoreCase(r11);
    L4:
        r11 = "";
        goto L6
    }

    public static boolean isPcCastMode() {
        return false;
    }

    public static boolean isSupportHeaderFooter(int r10) {
        return supportHeaderFooterTable.get(r10, false);
    }

    public static <T> List<T> newArrayList() {
        return new ArrayList();
    }

    public static <T> T newInstance(Class<T> r10) {
        if (r10 == null) goto L18;
        return r10.newInstance();
    L6:
        e = move-exception;
        if (TangramBuilder.isPrintLog() == false) goto L19;
        i.c("ClassResolver", e.getMessage(), e);
        return null;
    L19:
        return null;
    L10:
        e = move-exception;
        if (TangramBuilder.isPrintLog() == false) goto L21;
        i.c("ClassResolver", e.getMessage(), e);
        return null;
    L21:
        return null;
    L18:
        return null;
    }

    public static <K, V> Map<K, V> newMap(K r10, V r11, K r12, V r13) {
        ArrayMap r14 = new ArrayMap();
        r14.put(r10, r11);
        r14.put(r12, r13);
        return r14;
    }

    public static <K, V> Map<K, V> newMap(K r10, V r11, K r12, V r13, K r14, V r15) {
        Map<K, V> r16 = newMap(r10, r11, r12, r13);
        r16.put(r14, r15);
        return r16;
    }

    public static <K, V> Map<K, V> newMap(K r10, V r11, K r12, V r13, K r14, V r15, K r16, V r17) {
        Map<K, V> r18 = newMap(r10, r11, r12, r13, r14, r15);
        r18.put(r16, r17);
        return r18;
    }
}
