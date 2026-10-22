package cn4;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.appsetting.m;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<m> f24508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f24509b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<C0469a, Object> f24510c;

    /* JADX INFO: renamed from: cn4.a$a, reason: collision with other inner class name */
    public static class C0469a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f24511a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Class<?> f24512b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f24513c;

        public final int hashCode() {
            String r100 = this.f24511a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            Class<?> r104 = this.f24512b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return ((r103 + r101) * 31) + (this.f24513c ? 1 : 0);
        L5:
            r102 = 0;
            goto L6
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C0469a) == true) goto L8;
            return false;
        L8:
            C0469a r101 = (C0469a) r100;
            if (this.f24513c == r101.f24513c) goto L12;
            return false;
        L12:
            if (Objects.equals(this.f24511a, r101.f24511a) == true) goto L15;
            return false;
        L15:
            return Objects.equals(this.f24512b, r101.f24512b);
        }

        public C0469a(String r100, Class<?> r101, boolean r102) {
            this.f24511a = r100;
            this.f24512b = r101;
            this.f24513c = r102;
        }
    }

    public a(Set<m> r100) {
        this.f24509b = new ConcurrentHashMap();
        this.f24510c = new ConcurrentHashMap();
        this.f24508a = r100;
    }

    public static Object b(String r100, Object r101) throws NumberFormatException {
        if ((r101 instanceof String) == false) goto L9;
        if (TextUtils.isEmpty(r100) == true) goto L7;
        return r100;
    L7:
        return r101;
    L9:
        if ((r101 instanceof Boolean) == false) goto L13;
        return Boolean.valueOf(r100);
    L13:
        if ((r101 instanceof Integer) == false) goto L17;
        return CastIntegerProtector.valueOf(r100);
    L17:
        if ((r101 instanceof Long) == false) goto L21;
        return CastLongProtector.valueOf(r100);
    L21:
        if ((r101 instanceof Double) == false) goto L25;
        return CastDoubleProtector.valueOf(r100);
    L25:
        if ((r101 instanceof Float) == true) goto L27;
        tt5.a.d("AppSettingDataManager", "parseString, unSupportType");
        return r101;
    L27:
        return CastFloatProtector.valueOf(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1, types: [V, java.lang.Object] */
    public final <V> V a(String r100, V r101, boolean r102, boolean r103) {
        if (r103 == false) goto L4;
        Object r104 = ((ConcurrentHashMap) this.f24509b).get(r100);
    L6:
        if (r104 != null) goto L8;
        Iterator<m> r105 = this.f24508a.iterator();
    L17:
        if (r105.hasNext() == false) goto L27;
        m r106 = r105.next();
        if (r106.a(r100, r101.getClass()) == false) goto L17;
        if ((r101 instanceof Boolean) == false) goto L35;
        Object r107 = Boolean.valueOf(r106.b(r100, ((Boolean) r101).booleanValue(), r102));
    L29:
        if (r107 == null) goto L32;
        r101 = (V) r107;
    L32:
        if (r103 == false) goto L34;
        ((ConcurrentHashMap) this.f24509b).put(r100, (Object) r101);
    L34:
        return (V) r101;
    L35:
        r107 = b(r106.getString(r100), r101);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        tt5.a.e("AppSettingDataManager", "getStoredValue, parseString fail", th, false);
    L28:
        r107 = r101;
        goto L29
    L27:
        tt5.a.d("AppSettingDataManager", "getStoredValue error, no match repository. key = " + r100 + ", repository size = " + this.f24508a.size());
        goto L28
    L8:
        if (r104.getClass().equals(r101.getClass()) == true) goto L42;
        return (V) JSON.parseObject(JSON.toJSONString(r104), r101.getClass());
    L12:
        th = move-exception;
        tt5.a.e("AppSettingDataManager", "getCachedValue, parseObject fail", th, false);
        return r101;
    L42:
        return (V) r104;
    L4:
        r104 = null;
        goto L6
    }
}
