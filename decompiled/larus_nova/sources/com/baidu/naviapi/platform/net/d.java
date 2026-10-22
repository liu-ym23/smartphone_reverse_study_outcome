package com.baidu.naviapi.platform.net;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.naviapi.okhttp.HttpConfig;
import com.baidu.naviapi.okhttp.RequestEntity;
import com.baidu.naviapi.open.RoutePlanParam;
import com.huawei.hms.framework.common.ContainerUtils;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes39.dex */
public abstract class d {

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f32682a = null;

        static {
            int[] r100 = new int[RoutePlanParam.RoutePlanType.values().length];
            f32682a = r100;
            r100[RoutePlanParam.RoutePlanType.WALKING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f32682a[RoutePlanParam.RoutePlanType.RIDING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public abstract com.baidu.naviapi.platform.net.a b();

    public abstract RequestEntity.HttpMethod c();

    public abstract Map<String, String> d();

    public abstract RoutePlanParam.RoutePlanType e();

    public String f() {
        int r100 = a.f32682a[e().ordinal()];
        if (r100 != 1) goto L5;
        return HttpConfig.WALKING_URL;
    L5:
        if (r100 == 2) goto L7;
        return HttpConfig.CAR_URL;
    L7:
        return HttpConfig.RIDING_URL;
    }

    public RequestEntity a() {
        Map<String, String> r100 = d();
        r100.put("sign", a(r100));
        StringBuilder r101 = new StringBuilder(f());
        if (RequestEntity.HttpMethod.GET.equals(c()) == false) goto L11;
        r101.append("?");
        Iterator<String> r102 = r100.keySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L11;
        String r103 = r102.next();
        if (r100.get(r103) == null) goto L6;
        r101.append(r103);
        r101.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r101.append(Uri.encode(r100.get(r103)));
        r101.append("&");
    L11:
        return new RequestEntity.Builder(r101.substring(0, r101.length() - 1)).method(c()).params(r100).build();
    }

    public d() {
    }

    public final String a(Map<String, String> r100) {
        Object[] r101 = r100.keySet().toArray();
        Arrays.sort(r101);
        StringBuilder r102 = new StringBuilder();
        int r103 = 0;
    L4:
        if (r103 >= r101.length) goto L14;
        String r104 = (String) r101[r103];
        if (TextUtils.isEmpty(r100.get(r104)) == true) goto L13;
        if (TextUtils.equals("null", r100.get(r104)) == true) goto L13;
        r102.append(r104);
        r102.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r102.append(Uri.encode(r100.get(r104)));
        if (r103 == (r101.length - 1)) goto L13;
        r102.append("&");
    L13:
        r103 = r103 + 1;
        goto L4
    L14:
        r102.append("99754106633f94d350db34d548d6091a");
        byte[] r105 = MessageDigest.getInstance("MD5").digest(r102.toString().getBytes(StandardCharsets.UTF_8));     // Catch: NoSuchAlgorithmException -> L20
        StringBuilder r106 = new StringBuilder();     // Catch: NoSuchAlgorithmException -> L20
        int r107 = r105.length;     // Catch: NoSuchAlgorithmException -> L20
        int r108 = 0;
    L16:
        if (r108 >= r107) goto L18;
        r106.append(String.format("%02x", new Object[]{Byte.valueOf(r105[r108])}));     // Catch: NoSuchAlgorithmException -> L20
        r108 = r108 + 1;     // Catch: NoSuchAlgorithmException -> L20
        goto L16
    L18:
        return r106.toString();
    L20:
        return "";
    }
}
