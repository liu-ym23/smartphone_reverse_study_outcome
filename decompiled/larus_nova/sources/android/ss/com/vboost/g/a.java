package android.ss.com.vboost.g;

import android.ss.com.vboost.CapabilityType;
import android.ss.com.vboost.utils.LogUtil;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f4609b = "android.ss.com.vboost.g.a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedHashMap<String, String> f4610a;

    private a() {
        this.f4610a = new LinkedHashMap(64);
    }

    public static a b() {
        return new a();
    }

    private Set<CapabilityType> b(String r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        TextUtils.SimpleStringSplitter r101 = new TextUtils.SimpleStringSplitter(',');
        r101.setString(r100);
        HashSet r102 = new HashSet();
        Iterator<String> r103 = r101.iterator();
    L7:
        if (r103.hasNext() == false) goto L10;
        r102.add(CapabilityType.valueOf(CastIntegerProtector.parseInt(r103.next())));
        goto L7
    L10:
        if (r102.size() != 0) goto L12;
        return null;
    L12:
        return r102;
    }

    private void b(String r100, String r101) {
        this.f4610a.remove(r100);
        this.f4610a.put(r100, r101);
    }

    public String a(String r100) {
        return this.f4610a.get(r100);
    }

    public Set<CapabilityType> a() {
        return b(a("support_capability_set"));
    }

    public void a(CapabilityType r100, List<c> r110) {
        String r101 = r100.getName() + "_limit_rule";
        if (r110 != null) goto L6;
        String r111 = "(0:0:0,0:0,0:0)";
    L5:
        a(r101, r111);
        return;
    L6:
        StringBuilder r102 = new StringBuilder();
        int r103 = 0;
    L8:
        if (r103 >= r110.size()) goto L25;
        c r104 = (c) ListProtector.get(r110, r103);
        r102.append("(");
        String r105 = "1";
        if (r104.f4614a == false) goto L12;
        String r106 = "1";
    L13:
        r102.append(r106);
        r102.append(":");
        r102.append(r104.f4615b);
        r102.append(":");
        r102.append(r104.f4616c);
        r102.append(",");
        if (r104.f4617d == false) goto L16;
        String r107 = "1";
    L17:
        r102.append(r107);
        r102.append(":");
        r102.append(r104.f4618e);
        r102.append(",");
        if (r104.f4619f == true) goto L21;
        r105 = "0";
    L21:
        r102.append(r105);
        r102.append(":");
        r102.append(r104.f4620g);
        r102.append(")");
        if (r103 == (r110.size() - 1)) goto L24;
        r102.append(',');
    L24:
        r103 = r103 + 1;
        goto L8
    L16:
        r107 = "0";
        goto L17
    L12:
        r106 = "0";
        goto L13
    L25:
        r111 = r102.toString();
        goto L5
    }

    public void a(b r100) {
        a("cpu_core_limit_by", r100.ordinal());
    }

    public void a(d r100) {
        if (r100 != null) goto L5;
        String r101 = "0,0,0";
    L6:
        a("task_priority_limit_rule", r101);
        return;
    L5:
        r101 = r100.f4621a + "," + r100.f4622b + "," + r100.f4623c;
        goto L6
    }

    public void a(String r100, int r101) {
        b(r100, Integer.toString(r101));
    }

    public void a(String r100, String r101) {
        if (r100.indexOf(61) == (-1)) goto L5;
    L20:
        LogUtil.error(f4609b, "Key \"" + r100 + "\" contains invalid character (= or ; or \\0)");
        return;
    L5:
        if (r100.indexOf(59) != (-1)) goto L20;
        if (r100.indexOf(0) != (-1)) goto L20;
        if (r101.indexOf(61) == (-1)) goto L12;
    L18:
        LogUtil.error(f4609b, "Value \"" + r101 + "\" contains invalid character (= or ; or \\0)");
        return;
    L12:
        if (r101.indexOf(59) != (-1)) goto L18;
        if (r101.indexOf(0) != (-1)) goto L18;
        b(r100, r101);
    }

    public void a(Set<CapabilityType> r100) {
        StringBuilder r101 = new StringBuilder();
        Iterator<CapabilityType> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        r101.append(r102.next().getIndex());
        if (r102.hasNext() == false) goto L4;
        r101.append(",");
        goto L4
    L8:
        a("support_capability_set", r101.toString());
    }
}
