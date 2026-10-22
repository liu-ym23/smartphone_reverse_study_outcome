package com.bytedance.reparo.core;

import android.app.Application;
import android.os.Build;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ClassWand.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends WandTrick {
    public b() {
    }

    @Override // com.bytedance.reparo.core.WandTrick
    public WandTrick.a a(Application r17, final boolean r18, Map<Class, f> r19, List<String> r20, List<String> r21, List<Object> r22, final com.bytedance.reparo.core.h.b r23, final com.bytedance.reparo.core.h.d r24) {
        final Application r5 = (Application) ZeusTransformUtils.wrapperContextForParams(r17, Application.class, "com.obric.aiagent.plugin");
        final Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r19, Map.class, "com.obric.aiagent.plugin");
        final List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.aiagent.plugin");
        final List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.aiagent.plugin");
        final List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.aiagent.plugin");
        r23.a("read_patch_dex");
        final byte[][] r12 = new byte[r7.size()][];
        int r3 = r7.size();
        final Class[] r11 = new Class[r3];
        Iterator r6 = r7.keySet().iterator();
        int r14 = 0;
    L4:
        if (r6.hasNext() == false) goto L26;
        Class r13 = (Class) ZeusTransformUtils.preCheckCast(r6.next(), Class.class, "com.obric.aiagent.plugin");
        Iterator r25 = r6;
        f r10 = (f) ZeusTransformUtils.preCheckCast(r7.get(r13), f.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        if (r10 == null) goto L9;
        String r15 = r10.a();     // Catch: Throwable -> L19
    L11:
        if (TextUtils.isEmpty(r15) == true) goto L17;
        FileInputStream r16 = new FileInputStream(r15);     // Catch: Throwable -> L19
        byte[] r26 = new byte[r16.available()];     // Catch: Throwable -> L15
        r16.read(r26);     // Catch: Throwable -> L15
        r12[r14] = r26;     // Catch: Throwable -> L15
        r11[r14] = r13;     // Catch: Throwable -> L15
        r14 = r14 + 1;
    L18:
        l.a(r16);
        r6 = r25;
    L15:
        th = th;
    L52:
    L23:
        th = move-exception;
        l.a(r16);
        throw th;
    L22:
        throw new Exception("Failed to read dex: " + r13.getName(), th);     // Catch: Throwable -> L23
    L17:
        r16 = null;
        goto L18
    L9:
        r15 = null;
    L19:
        th = th;
        r16 = null;
        goto L52
    L26:
        final ArrayList r110 = new ArrayList();
        int r27 = 0;
    L27:
        if (r27 >= r3) goto L32;
        Class r111 = r11[r27];
        Constructor r112 = getClinitMethod(r111);
        if (r112 == null) goto L31;
        r110.add(r112);
    L31:
        r110.addAll(a(r111));
        r110.addAll(b(r111));
        r27 = r27 + 1;
        goto L27
    L32:
        final ArrayList r113 = new ArrayList();
        if (Build.VERSION.SDK_INT >= 28) goto L50;
        Field r2 = ZeusTransformUtils.forName("java.lang.reflect.Executable", "com.obric.aiagent.plugin").getDeclaredField("accessFlags");
        r2.setAccessible(true);
        Iterator r28 = r110.iterator();
    L36:
        if (r28.hasNext() == false) goto L50;
        Object r29 = r28.next();
        int r114 = r2.getInt(r29);
        Field r115 = r2;
        if (Build.VERSION.SDK_INT != 26) goto L45;
        if ((r114 & 1024) == 0) goto L42;
    L43:
        r113.add(r29);
    L49:
        r2 = r115;
        goto L36
    L42:
        if ((8388608 & r114) == 0) goto L49;
    L45:
        if ((r114 & 1024) == 0) goto L47;
    L48:
        r113.add(r29);
        goto L49
    L47:
        if ((16777216 & r114) == 0) goto L49;
    L50:
        r23.b("read_patch_dex");
        return new AnonymousClass1(this, r24, r4, r5, r18, r7, r8, r9, r23, r11, r12, r110, r113);
    }
}
