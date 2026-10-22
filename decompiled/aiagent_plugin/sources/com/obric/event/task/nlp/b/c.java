package com.obric.event.task.nlp.b;

import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.eventkit.task.model.Condition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: DataInfoManager.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {
    private static final String TAG = "DataInfoManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f32953a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, ConcurrentHashMap<String, Condition>> f32954b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ConcurrentHashMap<String, String> f32955c = null;

    private c() {
    }

    static {
        f32953a = new c();
        f32954b = new ConcurrentHashMap();
        f32955c = new ConcurrentHashMap();
    }

    public final String a(String r1, String r2, int r3) {
        o.e(r1, "type");
        o.e(r2, "name");
        return r1 + '_' + r2 + '_' + r3 + '_' + System.currentTimeMillis();
    }

    public final void a(String r4, String r5, Condition r6) {
        Condition r3 = (Condition) ZeusTransformUtils.wrapperContextForParams(r6, Condition.class, "com.obric.aiagent.plugin");
        o.e(r4, "taskStrKey");
        o.e(r5, "itemId");
        o.e(r3, "condition");
        ILogDepend.Companion.i(TAG, "putConditionData taskId = " + r4 + ", itemId = " + r5);
        ConcurrentHashMap<String, ConcurrentHashMap<String, Condition>> r7 = f32954b;
        ConcurrentHashMap r1 = (ConcurrentHashMap) ZeusTransformUtils.preCheckCast(r7.get(r4), ConcurrentHashMap.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
        r1 = new ConcurrentHashMap();
        ((Map) ZeusTransformUtils.preCheckCast(r7, Map.class, "com.obric.aiagent.plugin")).put(r4, r1);
    L5:
        ((Map) ZeusTransformUtils.preCheckCast(r1, Map.class, "com.obric.aiagent.plugin")).put(r5, r3);
    }

    public final Condition a(String r3, String r4) {
        o.e(r3, "taskStrKey");
        o.e(r4, "itemId");
        ILogDepend.Companion.i(TAG, "getConditionData taskId = " + r3 + ", id = " + r4);
        ConcurrentHashMap r2 = (ConcurrentHashMap) ZeusTransformUtils.preCheckCast(f32954b.get(r3), ConcurrentHashMap.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L7;
        return null;
    L7:
        return (Condition) ZeusTransformUtils.preCheckCast(r2.get(r4), Condition.class, "com.obric.aiagent.plugin");
    }

    public final void b(String r3, String r4) {
        o.e(r3, "taskStrKey");
        o.e(r4, "data");
        ILogDepend.Companion.i(TAG, "putData taskStrKey = " + r3);
        ((Map) ZeusTransformUtils.preCheckCast(f32955c, Map.class, "com.obric.aiagent.plugin")).put(r3, r4);
    }

    public final String a(String r3) {
        o.e(r3, "taskStrKey");
        ILogDepend.Companion.i(TAG, "getData taskStrKey = " + r3);
        return (String) ZeusTransformUtils.preCheckCast(f32955c.get(r3), String.class, "com.obric.aiagent.plugin");
    }

    public final void c(String r4, String r5) {
        o.e(r4, "originKey");
        o.e(r5, "curKey");
        ILogDepend.Companion.i(TAG, "modifyDataKey originKey = " + r4 + ", curKey = " + r5);
        boolean r1 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L8;
        return;
    L8:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")).length() == 0) goto L11;
        r1 = false;
    L11:
        if (r1 == false) goto L13;
        return;
    L13:
        if (o.a(r4, r5) == true) goto L25;
        ConcurrentHashMap<String, ConcurrentHashMap<String, Condition>> r6 = f32954b;
        ConcurrentHashMap r2 = (ConcurrentHashMap) ZeusTransformUtils.preCheckCast(r6.remove(r4), ConcurrentHashMap.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L18;
        ((Map) ZeusTransformUtils.preCheckCast(r6, Map.class, "com.obric.aiagent.plugin")).put(r5, r2);
    L18:
        ConcurrentHashMap<String, String> r7 = f32955c;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r7.remove(r4), String.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L24;
        ((Map) ZeusTransformUtils.preCheckCast(r7, Map.class, "com.obric.aiagent.plugin")).put(r5, r8);
        return;
    L24:
        return;
    L25:
        return;
    L5:
        r3 = false;
        goto L6
    }
}
