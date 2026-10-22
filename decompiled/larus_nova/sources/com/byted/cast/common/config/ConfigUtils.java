package com.byted.cast.common.config;

import android.os.Build;
import android.text.TextUtils;
import com.byted.cast.common.BuildConfig;
import com.byted.cast.common.Logger;
import com.byted.cast.common.StringUtil;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.miui.easygo.constant.EasyGoConstant;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes39.dex */
public class ConfigUtils {
    private static final String TAG = "ConfigUtils";

    public ConfigUtils() {
    }

    public static String getBuildVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public static float getOSVersionF() {
        String[] r100 = Build.VERSION.RELEASE.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        StringBuilder r101 = new StringBuilder();
        int r102 = 0;
        int r103 = 0;
    L4:
        if (r102 >= r100.length) goto L13;
        if (StringUtil.isNumeric(r100[r102]) == false) goto L12;
        r101.append(r100[r102]);
        if (r103 != 0) goto L11;
        r101.append(".");
    L11:
        r103 = r103 + 1;
    L12:
        r102 = r102 + 1;
        goto L4
    L13:
        int r104 = r101.length() - 1;
        if (r104 >= 0) goto L16;
    L18:
        Logger.i(TAG, "getOSVersionF, newVersion:" + r101);
        if (r101.length() != 0) goto L26;
        Logger.w(TAG, "getOSVersionF, parse Build.VERSION.RELEASE error, use default version 8.0");
        return 8.0f;
    L26:
        return CastFloatProtector.parseFloat(r101.toString());
    L24:
        Logger.w(TAG, "getOSVersionF, parse float error, use default version 8.0");
        return 8.0f;
    L16:
        if ('.' != r101.charAt(r104)) goto L18;
        r101.deleteCharAt(r104);
        goto L18
    }

    public static String getLastId(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return "0";
    L7:
        return r100.substring(r100.length() - 1);
    }

    public static String is2String(InputStream r100) throws IOException {
        BufferedReader r101 = new BufferedReader(new InputStreamReader(r100, XML.CHARSET_UTF8));
        StringBuilder r102 = new StringBuilder();
    L3:
        String r103 = r101.readLine();
        if (r103 == null) goto L7;
        r102.append(r103);
        goto L3
    L7:
        return r102.toString().trim();
    }

    public static <T> List<T> castList(Object r100, Class<T> r101) {
        ArrayList r102 = new ArrayList();
        if ((r100 instanceof List) == false) goto L8;
        Iterator r103 = ((List) r100).iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        r102.add(r101.cast(r103.next()));
    L8:
        return r102;
    }

    public static <K, V> Map<K, V> castMap(Object r100, Class<K> r101, Class<V> r102) {
        HashMap r103 = new HashMap();
        if ((r100 instanceof Map) == false) goto L8;
        Iterator<Map.Entry<K, V>> r104 = ((Map) r100).entrySet().iterator();
    L6:
        if (r104.hasNext() == false) goto L8;
        Map.Entry<K, V> r105 = r104.next();
        r103.put(r101.cast(r105.getKey()), r102.cast(r105.getValue()));
    L8:
        return r103;
    }
}
