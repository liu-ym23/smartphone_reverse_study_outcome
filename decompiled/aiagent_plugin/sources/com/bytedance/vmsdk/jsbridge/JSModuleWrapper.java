package com.bytedance.vmsdk.jsbridge;

import android.util.Log;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyArray;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public class JSModuleWrapper {
    private static final String TAG = "VmsdkModuleWrapper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JSModule f11745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList<MethodDescriptor> f11746b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayList<AttributeDescriptor> f11747c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f11748d;

    public JSModuleWrapper(String r1, JSModule r2) {
        this.f11748d = r1;
        this.f11745a = r2;
        this.f11746b = new ArrayList();
        this.f11747c = new ArrayList();
    }

    public JSModule getModule() {
        return this.f11745a;
    }

    public String getName() {
        return this.f11748d;
    }

    private void a() {
        HashSet r0 = new HashSet();
        Method[] r1 = this.f11745a.getClass().getDeclaredMethods();
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L12;
        Method r4 = r1[r3];
        if (((b) ZeusTransformUtils.preCheckCast(r4.getAnnotation(b.class), b.class, "com.obric.aiagent.plugin")) == null) goto L11;
        String r5 = r4.getName();
        if (r0.contains(r5) == true) goto L10;
        r0.add(r5);
        MethodDescriptor r6 = new MethodDescriptor();
        c r7 = new c(r4);
        r6.f11751c = r5;
        r6.f11750b = r7.a();
        r6.f11749a = r4;
        this.f11746b.add(r6);
        goto L11
    L10:
        throw new IllegalArgumentException("Java Module " + getName() + " method name already registered: " + r5);
    L11:
        r3 = r3 + 1;
        goto L3
    }

    private void b() {
        HashSet r0 = new HashSet();
        Field[] r1 = this.f11745a.getClass().getDeclaredFields();
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L17;
        Field r4 = r1[r3];
        if (((a) ZeusTransformUtils.preCheckCast(r4.getAnnotation(a.class), a.class, "com.obric.aiagent.plugin")) == null) goto L16;
        String r5 = r4.getName();
        if (r0.contains(r5) == true) goto L15;
        r0.add(r5);
        AttributeDescriptor r6 = new AttributeDescriptor();
        r6.f11740a = r5;
        r6.f11741b = new JavaOnlyArray();
        r6.f11741b.add(r4.get(this.f11745a));     // Catch: IllegalAccessException -> L11
    L13:
        this.f11747c.add(r6);
    L11:
        e = move-exception;
        a(TAG, e.toString());
        goto L13
    L15:
        throw new IllegalArgumentException("Java Module " + getName() + " attribute name already registered: " + r5);
    L16:
        r3 = r3 + 1;
        goto L3
    }

    public Collection<MethodDescriptor> getMethodDescriptors() {
        if (this.f11746b.isEmpty() == false) goto L9;
        a();     // Catch: RuntimeException -> L6
    L6:
        e = move-exception;
        a(TAG, e.toString());
    L9:
        return this.f11746b;
    }

    public Collection<AttributeDescriptor> getAttributeDescriptor() {
        if (this.f11747c.isEmpty() == false) goto L9;
        b();     // Catch: RuntimeException -> L6
    L6:
        e = move-exception;
        a(TAG, e.toString());
    L9:
        return this.f11747c;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
