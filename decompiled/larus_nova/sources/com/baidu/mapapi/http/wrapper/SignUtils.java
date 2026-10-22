package com.baidu.mapapi.http.wrapper;

import android.text.TextUtils;
import com.baidu.mapapi.http.wrapper.annotation.Properties;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes39.dex */
public class SignUtils {
    public SignUtils() {
    }

    public static String toValue(Object r100, boolean r101) {
        if (r100 != null) goto L5;
        return "";
    L5:
        StringBuilder r102 = new StringBuilder();
        int r103 = 0;
        if (r100.getClass().isArray() == false) goto L14;
        Object[] r104 = (Object[]) r100;
        if (r104.length <= 0) goto L32;
        int r105 = r104.length;
    L10:
        if (r103 >= r105) goto L12;
        r102.append(ParamsUtils.getValue(r104[r103], r101));
        r102.append(",");
        r103 = r103 + 1;
        goto L10
    L12:
        r102.deleteCharAt(r102.length() - 1);
    L32:
        return r102.toString();
    L14:
        if ((r100 instanceof List) == false) goto L22;
        List r106 = (List) r100;
        if (r106.isEmpty() == true) goto L32;
    L18:
        if (r103 >= r106.size()) goto L20;
        r102.append(ParamsUtils.getValue(ListProtector.get(r106, r103), r101));
        r102.append(",");
        r103 = r103 + 1;
        goto L18
    L20:
        r102.deleteCharAt(r102.length() - 1);
        goto L32
    L22:
        if ((r100 instanceof Set) == false) goto L30;
        Set r107 = (Set) r100;
        if (r107.isEmpty() == true) goto L32;
        Iterator r108 = r107.iterator();
    L27:
        if (r108.hasNext() == false) goto L29;
        r102.append(ParamsUtils.getValue(r108.next(), r101));
        r102.append(",");
        goto L27
    L29:
        r102.deleteCharAt(r102.length() - 1);
        goto L32
    L30:
        r102.append(ParamsUtils.getValue(r100, r101));
        goto L32
    }

    public static String signParams(BaseParams r110, Map<String, String> r111, boolean r112) throws IllegalAccessException {
        StringBuilder r100 = new StringBuilder();
        Field[] r101 = r110.getClass().getFields();
        int r102 = r101.length;
        int r103 = 0;
    L4:
        if (r103 >= r102) goto L16;
        Field r104 = r101[r103];
        Properties r105 = (Properties) r104.getAnnotation(Properties.class);
        if (r105 != null) goto L8;
        String r106 = r104.getName();
    L9:
        Object r107 = r104.get(r110);
        if ("sign".equals(r106) == true) goto L15;
        if (r107 == null) goto L15;
        if (TextUtils.isEmpty(String.valueOf(r107)) == true) goto L15;
        r100.append(r106);
        r100.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r100.append(toValue(r107, r112));
        r100.append("&");
    L15:
        r103 = r103 + 1;
        goto L4
    L8:
        r106 = r105.name();
        goto L9
    L16:
        Field[] r108 = r110.getClass().getDeclaredFields();
        int r109 = r108.length;
        int r113 = 0;
    L18:
        if (r113 >= r109) goto L30;
        Field r114 = r108[r113];
        r114.setAccessible(true);
        Properties r115 = (Properties) r114.getAnnotation(Properties.class);
        if (r115 != null) goto L22;
        String r116 = r114.getName();
    L23:
        Object r117 = r114.get(r110);
        if ("sign".equals(r116) == true) goto L29;
        if (r117 == null) goto L29;
        if (TextUtils.isEmpty(String.valueOf(r117)) == true) goto L29;
        r100.append(r116);
        r100.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r100.append(toValue(r117, r112));
        r100.append("&");
    L29:
        r114.setAccessible(false);
        r113 = r113 + 1;
        goto L18
    L22:
        r116 = r115.name();
        goto L23
    L30:
        if (r111 == null) goto L42;
        Iterator<Map.Entry<String, String>> r118 = r111.entrySet().iterator();
    L33:
        if (r118.hasNext() == false) goto L42;
        Map.Entry<String, String> r119 = r118.next();
        if (r119.getKey() == null) goto L33;
        if (r119.getValue() == null) goto L33;
        if (TextUtils.isEmpty(r119.getValue()) == true) goto L33;
        r100.append(r119.getKey());
        r100.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r100.append(toValue(r119.getValue(), r112));
        r100.append("&");
    L42:
        if (r100.length() <= 0) goto L47;
        if (r100.charAt(r100.length() - 1) != '&') goto L47;
        r100.deleteCharAt(r100.length() - 1);
    L47:
        return AppMD5.getSignMD5StringUTF8(r100.toString());
    }
}
