package com.bytedance.retrofit2.e;

import com.bytedance.frameworks.encryptor.EncryptorUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: FormUrlEncodedTypedOutput.java */
/* JADX INFO: loaded from: classes.dex */
public final class c extends com.bytedance.retrofit2.e.a {
    private static AtomicReference<a> f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    ByteArrayOutputStream f9511e;
    private final boolean g;
    private a h;
    private Map<String, List<String>> i;

    /* JADX INFO: compiled from: FormUrlEncodedTypedOutput.java */
    public interface a {
        a a();

        Map<String, List<String>> a(com.bytedance.retrofit2.b.c r1);
    }

    @Override // com.bytedance.retrofit2.e.a, com.bytedance.retrofit2.e.j
    public String a() {
        return null;
    }

    @Override // com.bytedance.retrofit2.e.a, com.bytedance.retrofit2.e.j
    public String b() {
        return "application/x-www-form-urlencoded; charset=UTF-8";
    }

    static {
        f = new AtomicReference();
    }

    public c() {
        this.f9511e = new ByteArrayOutputStream();
        this.i = new HashMap();
        this.g = false;
        a r0 = (a) ZeusTransformUtils.preCheckCast(f.get(), a.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        a r1 = r0.a();
    L6:
        this.h = r1;
        return;
    L5:
        r1 = null;
        goto L6
    }

    public c(boolean r3) {
        this.f9511e = new ByteArrayOutputStream();
        this.i = new HashMap();
        this.g = r3;
        a r4 = (a) ZeusTransformUtils.preCheckCast(f.get(), a.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L5;
        a r5 = r4.a();
    L6:
        this.h = r5;
        return;
    L5:
        r5 = null;
        goto L6
    }

    public void a(String r2, String r3) {
        a(r2, true, r3, true);
    }

    public void a(String r4, boolean r5, String r6, boolean r7) {
        Objects.requireNonNull(r4, "name");
        Objects.requireNonNull(r6, "value");
        if (this.g == true) goto L7;
        if (this.h != null) goto L7;
    L11:
        if (this.h == null) goto L18;
        return;
    L18:
        b(r4, r5, r6, r7);     // Catch: IOException -> L14
        return;
    L14:
        e = move-exception;
        throw new RuntimeException(e);
    L7:
        if (this.i.containsKey(r4) == false) goto L9;
        ((List) ZeusTransformUtils.preCheckCast(this.i.get(r4), List.class, "com.obric.aiagent.plugin")).add(r6);
        goto L11
    L9:
        ArrayList r0 = new ArrayList();
        r0.add(r6);
        this.i.put(r4, r0);
        goto L11
    }

    public void a(com.bytedance.retrofit2.b.c r7) {
        a r0 = this.h;
        if (r0 != null) goto L5;
        return;
    L5:
        Map<String, List<String>> r8 = r0.a(r7);
        this.i = r8;
        if (r8 != null) goto L8;
        return;
    L8:
        if (r8.isEmpty() == true) goto L29;
        Iterator<Map.Entry<String, List<String>>> r9 = this.i.entrySet().iterator();
    L12:
        if (r9.hasNext() == false) goto L30;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        Iterator r2 = ((List) ZeusTransformUtils.preCheckCast(r1.getValue(), List.class, "com.obric.aiagent.plugin")).iterator();
    L15:
        if (r2.hasNext() == false) goto L12;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.aiagent.plugin");
        b((String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.aiagent.plugin"), true, r3, true);     // Catch: Exception -> L19
    L19:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L30:
        return;
    }

    private void b(String r3, boolean r4, String r5, boolean r6) {
        if (this.f9511e.size() <= 0) goto L6;
        this.f9511e.write(38);
    L6:
        if (r4 == false) goto L8;
        r3 = URLEncoder.encode(r3, "UTF-8");
    L8:
        if (r6 == false) goto L10;
        r5 = URLEncoder.encode(r5, "UTF-8");
    L10:
        this.f9511e.write(r3.getBytes("UTF-8"));
        this.f9511e.write(61);
        this.f9511e.write(r5.getBytes("UTF-8"));
    }

    @Override // com.bytedance.retrofit2.e.a, com.bytedance.retrofit2.e.j
    public long c() {
        return this.f9511e.size();
    }

    @Override // com.bytedance.retrofit2.e.a, com.bytedance.retrofit2.e.j
    public void a(OutputStream r1) {
        r1.write(this.f9511e.toByteArray());
    }

    @Override // com.bytedance.retrofit2.e.a, com.bytedance.retrofit2.e.j
    public String d() {
        this.f9508c = b.a(this.f9511e.toByteArray());
        return this.f9508c;
    }

    @Override // com.bytedance.retrofit2.e.a
    public boolean e() {
        byte[] r0 = this.f9511e.toByteArray();
        if (r0 != null) goto L5;
    L12:
        return false;
    L5:
        if (r0.length > 102400) goto L12;
        byte[] r1 = EncryptorUtil.a(r0, r0.length);
        if (r1 != null) goto L10;
        return false;
    L10:
        ByteArrayOutputStream r2 = new ByteArrayOutputStream(r1.length);
        this.f9511e = r2;
        r2.write(r1, 0, r1.length);
        this.f9506a = true;
        return true;
    }

    @Override // com.bytedance.retrofit2.e.a
    public f.b a(String r3, String r4, boolean r5) {
        byte[] r0 = this.f9511e.toByteArray();
        if (r0 != null) goto L6;
        return null;
    L6:
        f.b r6 = f.a(r0, r0.length, r3, r4, r5);
        if (r6 != null) goto L9;
    L12:
        return r6;
    L9:
        if (r6.f9527a == null) goto L12;
        this.f9509d = r0.length;
        ByteArrayOutputStream r7 = new ByteArrayOutputStream(r6.f9527a.length);
        this.f9511e = r7;
        r7.write(r6.f9527a, 0, r6.f9527a.length);
        this.f9507b = r6.f9529c;
        goto L12
    }
}
