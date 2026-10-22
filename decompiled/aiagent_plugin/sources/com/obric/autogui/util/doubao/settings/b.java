package com.obric.autogui.util.doubao.settings;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import d.x;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: FlowSettingRepoImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements com.obric.autogui.common.a.a.a {
    private static final String TAG = "SettingsRepo-Flow";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f31522a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f31523b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ReentrantReadWriteLock f31524c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map<String, ? extends Object> f31525d;

    /* JADX INFO: compiled from: FlowSettingRepoImpl.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f31522a = new a(null);
    }

    public b(long r1) {
        this.f31523b = r1;
        this.f31524c = new ReentrantReadWriteLock();
        this.f31525d = ao.b();
    }

    @Override // com.obric.autogui.common.a.a.a
    public long getVersion() {
        return this.f31523b;
    }

    public final void a(JsonObject r6) {
        o.e(r6, "configs");
        ReentrantReadWriteLock r0 = this.f31524c;
        ReentrantReadWriteLock.ReadLock r1 = r0.readLock();
        int r3 = 0;
        if (r0.getWriteHoldCount() != 0) goto L5;
        int r2 = r0.getReadHoldCount();
    L6:
        int r4 = 0;
    L7:
        if (r4 >= r2) goto L9;
        r1.unlock();
        r4 = r4 + 1;
        goto L7
    L9:
        ReentrantReadWriteLock.WriteLock r5 = r0.writeLock();
        r5.lock();
        this.f31525d = b(r6);     // Catch: Throwable -> L15
        x r7 = x.f38692a;     // Catch: Throwable -> L15
    L11:
        if (r3 >= r2) goto L13;
        r1.lock();
        r3 = r3 + 1;
        goto L11
    L13:
        r5.unlock();
        return;
    L15:
        th = move-exception;
    L16:
        if (r3 >= r2) goto L18;
        r1.lock();
        r3 = r3 + 1;
        goto L16
    L18:
        r5.unlock();
        throw th;
    L5:
        r2 = 0;
        goto L6
    }

    private final Object a(JsonPrimitive r3) {
        if (r3.isBoolean() == false) goto L6;
        return (Serializable) ZeusTransformUtils.preCheckCast(Boolean.valueOf(r3.getAsBoolean()), Serializable.class, "com.obric.aiagent.plugin");
    L6:
        if (r3.isString() == false) goto L9;
        return (Serializable) ZeusTransformUtils.preCheckCast(r3.getAsString(), Serializable.class, "com.obric.aiagent.plugin");
    L9:
        if (r3.isNumber() == true) goto L15;
        Loog.INSTANCE.e(TAG, "unknown JSON type for primitive: " + r3);
        return null;
    L15:
        return (Serializable) ZeusTransformUtils.preCheckCast(r3.getAsNumber(), Serializable.class, "com.obric.aiagent.plugin");
    }

    private final Map<String, Object> b(JsonObject r8) {
        Map<String, Object> r0 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        a(r0, this, r8, null, 8, null);
        return r0;
    }

    static /* synthetic */ void a(Map r1, b r2, JsonObject r3, String r4, int r5, Object r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r1, Map.class, "com.obric.aiagent.plugin");
        if ((r5 & 8) == 0) goto L5;
        r4 = "";
    L5:
        a(r7, r2, r3, r4);
    }

    private static final void a(Map<String, Object> r6, b r7, JsonObject r8, String r9) {
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        Iterator<Map.Entry<String, JsonElement>> r11 = r8.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L32;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        o.a(r0);
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.aiagent.plugin");
        JsonElement r1 = (JsonElement) ZeusTransformUtils.preCheckCast(r0.getValue(), JsonElement.class, "com.obric.aiagent.plugin");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == true) goto L13;
        r2 = r9 + '.' + r2;
    L13:
        if (r1.isJsonObject() == true) goto L14;
        if (r1.isJsonArray() == false) goto L28;
        JsonArray r4 = r1.getAsJsonArray();     // Catch: Throwable -> L33
        o.a(r4);     // Catch: Throwable -> L33
        JsonElement r5 = (JsonElement) ZeusTransformUtils.preCheckCast(p.f((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin")), JsonElement.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L33
        if (r5 == null) goto L4;
        if (r5.isJsonPrimitive() == false) goto L4;
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L33
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r12, 10)), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L33
        Iterator r14 = r12.iterator();     // Catch: Throwable -> L33
    L23:
        if (r14.hasNext() == false) goto L25;
        JsonPrimitive r15 = ((JsonElement) ZeusTransformUtils.preCheckCast(r14.next(), JsonElement.class, "com.obric.aiagent.plugin")).getAsJsonPrimitive();     // Catch: Throwable -> L33
        o.c(r15, "getAsJsonPrimitive(...)");     // Catch: Throwable -> L33
        r13.add(r7.a(r15));     // Catch: Throwable -> L33
        goto L23
    L25:
        r10.put(r2, (List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L33
        goto L4
    L28:
        if (r1.isJsonPrimitive() == false) goto L4;
        JsonPrimitive r16 = r1.getAsJsonPrimitive();
        o.a(r16);
        Object r17 = r7.a(r16);
        if (r17 == null) goto L4;
        r10.put(r2, r17);
        goto L4
    L14:
        JsonObject r18 = r1.getAsJsonObject();
        o.c(r18, "getAsJsonObject(...)");
        o.a(r2);
        a(r10, r7, r18, r2);
        goto L4
    L8:
        r3 = false;
        goto L9
    }

    @Override // com.obric.autogui.common.a.a.a
    public String getStringCfg(String r3) {
        o.e(r3, "key");
        ReentrantReadWriteLock.ReadLock r0 = this.f31524c.readLock();
        r0.lock();
        Object r2 = this.f31525d.get(r3);     // Catch: Throwable -> L10
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L7;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
    L8:
        r0.unlock();
        return r4;
    L7:
        r4 = null;
    L10:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    @Override // com.obric.autogui.common.a.a.a
    public boolean getBooleanCfg(String r3, boolean r4) {
        o.e(r3, "key");
        ReentrantReadWriteLock.ReadLock r0 = this.f31524c.readLock();
        r0.lock();
        Object r2 = this.f31525d.get(r3);     // Catch: Throwable -> L11
        if (ZeusTransformUtils.instanceOf(r2, Boolean.class) == false) goto L6;
        Boolean r5 = (Boolean) ZeusTransformUtils.preCheckCast(r2, Boolean.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
    L7:
        if (r5 == null) goto L9;
        r4 = r5.booleanValue();     // Catch: Throwable -> L11
    L9:
        r0.unlock();
        return r4;
    L6:
        r5 = null;
    L11:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    @Override // com.obric.autogui.common.a.a.a
    public int getIntCfg(String r3, int r4) {
        o.e(r3, "key");
        ReentrantReadWriteLock.ReadLock r0 = this.f31524c.readLock();
        r0.lock();
        Object r2 = this.f31525d.get(r3);     // Catch: Throwable -> L11
        if (ZeusTransformUtils.instanceOf(r2, Number.class) == false) goto L6;
        Number r5 = (Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
    L7:
        if (r5 == null) goto L9;
        r4 = r5.intValue();     // Catch: Throwable -> L11
    L9:
        r0.unlock();
        return r4;
    L6:
        r5 = null;
    L11:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    @Override // com.obric.autogui.common.a.a.a
    public long getLongCfg(String r3, long r4) {
        o.e(r3, "key");
        ReentrantReadWriteLock.ReadLock r0 = this.f31524c.readLock();
        r0.lock();
        Object r2 = this.f31525d.get(r3);     // Catch: Throwable -> L11
        if (ZeusTransformUtils.instanceOf(r2, Number.class) == false) goto L6;
        Number r5 = (Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
    L7:
        if (r5 == null) goto L9;
        r4 = r5.longValue();     // Catch: Throwable -> L11
    L9:
        r0.unlock();
        return r4;
    L6:
        r5 = null;
    L11:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    @Override // com.obric.autogui.common.a.a.a
    public List<?> getListCfg(String r3) {
        o.e(r3, "key");
        ReentrantReadWriteLock.ReadLock r0 = this.f31524c.readLock();
        r0.lock();
        Object r2 = this.f31525d.get(r3);     // Catch: Throwable -> L10
        if (ZeusTransformUtils.instanceOf(r2, List.class) == false) goto L7;
        List<?> r4 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
    L8:
        r0.unlock();
        return r4;
    L7:
        r4 = null;
    L10:
        th = move-exception;
        r0.unlock();
        throw th;
    }
}
