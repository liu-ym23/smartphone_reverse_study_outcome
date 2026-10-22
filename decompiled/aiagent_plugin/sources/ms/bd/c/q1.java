package ms.bd.c;

import android.text.TextUtils;
import android.view.Display;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static q1 f39588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f39589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f39590c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f39591d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f39592e;
    private long f;
    private String g;
    private String h;
    private String i;
    private boolean j;

    private q1() {
        this.f39592e = 1;
    }

    public static Object a(Object r14, String r15) {
        Method r1 = Class.class.getDeclaredMethod((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "4bcd8b", new byte[]{34, 101, 4, 52, 2, 118, 59, 66, 32, 49, 33, 70, 25, 21, 11, 113}), String.class, "com.obric.aiagent.plugin"), new Class[]{String.class});     // Catch: Throwable -> L11
        if (r1 == null) goto L9;
        Field r16 = (Field) ZeusTransformUtils.preCheckCast(r1.invoke(r14.getClass(), new Object[]{r15}), Field.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        if (r16 == null) goto L14;
        r16.setAccessible(true);     // Catch: Throwable -> L11
        return r16.get(r14);
    L14:
        return null;
    L9:
        return null;
    L15:
        return null;
    }

    public static String a(Display[] r18) {
        StringBuilder r2 = new StringBuilder();     // Catch: Exception -> L17
        int r3 = r18.length;     // Catch: Exception -> L17
        int r5 = 0;
    L4:
        if (r5 >= r3) goto L12;
        Object r6 = a(r18[r5], (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "f6f58c", new byte[]{122, 27, 2, 79, 2, 102, 85, 22, 52, 110, 118, 51, 16, 111, 6, 121, 96}), String.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L17
        if (r6 == null) goto L10;
        if (r2.toString().contains(r6.toString()) == true) goto L10;
        r2.append(r6);     // Catch: Exception -> L17
        r2.append((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "21476b", new byte[]{120}), String.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L17
    L10:
        r5 = r5 + 1;     // Catch: Exception -> L17
        goto L4
    L12:
        if (r2.length() <= 0) goto L15;
        return r2.toString();
    L15:
        return null;
    L24:
        return null;
    }

    public static q1 a() {
        if (f39588a != null) goto L6;
        f39588a = new q1();
    L6:
        return f39588a;
    }

    public static String b(Display[] r30) {
        StringBuilder r2 = new StringBuilder();     // Catch: Exception -> L18
        int r3 = r30.length;     // Catch: Exception -> L18
        int r5 = 0;
    L4:
        if (r5 >= r3) goto L13;
        Display r6 = r30[r5];     // Catch: Exception -> L18
        StringBuilder r7 = new StringBuilder();     // Catch: Exception -> L18
        Object r8 = a(r6, (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "fcc31b", new byte[]{122, 69, 25, 84, 30, 121, 100, 91, 27, 109, 113, 110}), String.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L18
        r7.append(a(r8, (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "17ea2b", new byte[]{47, 34, 24, 16, 31, 69, 51, 21, 63, 48, 39, 48, 56, 20, 0, 112}), String.class, "com.obric.aiagent.plugin"))).append((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "603705", new byte[]{107}), String.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L18
        r7.append(a(r8, (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "b9d3a2", new byte[]{117, 55, 22, 64, 77}), String.class, "com.obric.aiagent.plugin"))).append((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "28d2cb", new byte[]{111}), String.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L18
        r7.append(a(r8, (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "56a283", new byte[]{42, 53, 31, 67}), String.class, "com.obric.aiagent.plugin"))).append((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "b60917", new byte[]{63}), String.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L18
        r7.append(a(r8, (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "6a8f9c", new byte[]{51, 122, 91, 23}), String.class, "com.obric.aiagent.plugin")));     // Catch: Exception -> L18
        if (r2.toString().contains(r7.toString()) == true) goto L11;
        if (r2.length() <= 0) goto L10;
        r2.append((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "5cf92f", new byte[]{127}), String.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L18
    L10:
        r2.append(r7);     // Catch: Exception -> L18
    L11:
        r5 = r5 + 1;     // Catch: Exception -> L18
        goto L4
    L13:
        if (r2.length() <= 0) goto L16;
        return r2.toString();
    L16:
        return null;
    L24:
        return null;
    }

    public final void a(int r5) {
        if (this.f39592e == r5) goto L5;
        this.f = System.currentTimeMillis() / 1000;
    L5:
        this.f39592e = r5;
    }

    public final void a(long r7) {
        this.f39589b = r7;
        this.g = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "64fb25", new byte[]{38, 50, 17}), String.class, "com.obric.aiagent.plugin");
    }

    public final void a(String r1) {
        this.h = r1;
    }

    public final void b() {
        this.j = true;
    }

    public final void b(long r7) {
        this.f39590c = r7;
        this.g = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "f809de", new byte[]{101, 63, 78, 66, 77, 119}), String.class, "com.obric.aiagent.plugin");
    }

    public final void b(String r1) {
        this.i = r1;
    }

    public final JSONObject c() {
        JSONObject r2 = new JSONObject();     // Catch: Exception -> L14
        r2.put((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "32be92", new byte[]{35, 36}), String.class, "com.obric.aiagent.plugin"), this.f39589b);     // Catch: Exception -> L14
        r2.put((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "89ee8a", new byte[]{59, 47}), String.class, "com.obric.aiagent.plugin"), this.f39590c);     // Catch: Exception -> L14
        r2.put((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "ac7b72", new byte[]{116, 108}), String.class, "com.obric.aiagent.plugin"), this.f39592e);     // Catch: Exception -> L14
        r2.put((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "1c6282", new byte[]{36, 117}), String.class, "com.obric.aiagent.plugin"), this.f);     // Catch: Exception -> L14
        r2.put((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "1657f9", new byte[]{35, 53, 66}), String.class, "com.obric.aiagent.plugin"), this.j ? 1 : 0);     // Catch: Exception -> L14
        r2.put((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "953a25", new byte[]{37, 51}), String.class, "com.obric.aiagent.plugin"), this.g);     // Catch: Exception -> L14
        if (TextUtils.isEmpty(this.h) == true) goto L7;
        r2.put((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "349689", new byte[]{50, 61}), String.class, "com.obric.aiagent.plugin"), this.h);     // Catch: Exception -> L14
    L7:
        if (TextUtils.isEmpty(this.i) == true) goto L9;
        r2.put((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "60d782", new byte[]{35, 59}), String.class, "com.obric.aiagent.plugin"), this.i);     // Catch: Exception -> L14
    L9:
        this.f39591d = System.currentTimeMillis();     // Catch: Exception -> L14
        r2.put((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "f9b0cb", new byte[]{116, 47}), String.class, "com.obric.aiagent.plugin"), this.f39591d / 1000);     // Catch: Exception -> L14
        if (r2.length() <= 0) goto L12;
        return r2;
    L12:
        return null;
    L17:
        return null;
    }

    public final boolean d() {
        if (this.f39589b <= 0) goto L5;
        return true;
    L5:
        if (this.f39590c <= 0) goto L7;
        return true;
    L7:
        if (this.f > 0) goto L14;
        return false;
    L14:
        return true;
    }
}
