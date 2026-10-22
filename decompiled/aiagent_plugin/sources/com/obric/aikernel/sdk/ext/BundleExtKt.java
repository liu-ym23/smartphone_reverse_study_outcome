package com.obric.aikernel.sdk.ext;

import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import com.obric.aikernel.AIKListener;
import com.obric.aikernel.core.a;
import com.obric.aikernel.core.data.IdlErrors;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.sdk.AIKernelConfig;
import com.obric.aikernel.sdk.data.PackageResource;
import com.obric.aikernel.sdk.response.Response;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.al;
import d.a.p;
import d.h.a.b;
import d.h.a.m;
import d.h.b.o;
import d.l.j;
import d.l.n;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: BundleExt.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class BundleExtKt {
    private static final Bundle FAIL = null;
    private static final Bundle OK = null;

    static {
        OK = setOK$default(new Bundle(), 0, null, 3, null);
        FAIL = setErr$default(new Bundle(), 0, null, false, 7, null);
    }

    public static final Bundle getOK() {
        return OK;
    }

    public static final Bundle getFAIL() {
        return FAIL;
    }

    public static /* synthetic */ Bundle setErr$default(Bundle r0, int r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = IdlErrors.INSTANCE.toString(r1);
    L6:
        return setErr(r0, r1, r2);
    }

    public static final Bundle setErr(Bundle r1, int r2, String r3) {
        o.e(r1, "<this>");
        r1.putInt(IdlKeys.ErrorCode, r2);
        r1.putString(IdlKeys.ErrorInfo, r3);
        r1.putBoolean(IdlKeys.IsFinish, true);
        return r1;
    }

    public static final void saveArr(JSONArray r6, String r7, Bundle r8, boolean r9) {
        o.e(r6, "arr");
        o.e(r7, "key");
        o.e(r8, "bundle");
        if (r6.length() != 0) goto L5;
        return;
    L5:
        Object r1 = r6.opt(0);
        if (r1 != null) goto L8;
        return;
    L8:
        j r2 = new j(0, r6.length() - 1);
        if (ZeusTransformUtils.instanceOf(r1, String.class) == false) goto L16;
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r10, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r11 = r10.iterator();
    L12:
        if (r11.hasNext() == false) goto L14;
        r3.add(r6.getString(((al) ZeusTransformUtils.preCheckCast(r11, al.class, "com.obric.aiagent.plugin")).a()));
        goto L12
    L14:
        r8.putStringArray(r7, (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin")).toArray(new String[0]), String[].class, "com.obric.aiagent.plugin"));
        return;
    L16:
        if (ZeusTransformUtils.instanceOf(r1, Integer.class) == false) goto L23;
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r12, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r13 = r12.iterator();
    L19:
        if (r13.hasNext() == false) goto L21;
        r0.add(Integer.valueOf(r6.getInt(((al) ZeusTransformUtils.preCheckCast(r13, al.class, "com.obric.aiagent.plugin")).a())));
        goto L19
    L21:
        r8.putIntArray(r7, p.e((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin")));
        return;
    L23:
        if (ZeusTransformUtils.instanceOf(r1, Long.class) == false) goto L30;
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r14, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r15 = r14.iterator();
    L26:
        if (r15.hasNext() == false) goto L28;
        r4.add(Long.valueOf(r6.getLong(((al) ZeusTransformUtils.preCheckCast(r15, al.class, "com.obric.aiagent.plugin")).a())));
        goto L26
    L28:
        r8.putLongArray(r7, p.f((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin")));
        return;
    L30:
        if (ZeusTransformUtils.instanceOf(r1, Boolean.class) == false) goto L37;
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r16, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r17 = r16.iterator();
    L33:
        if (r17.hasNext() == false) goto L35;
        r5.add(Boolean.valueOf(r6.getBoolean(((al) ZeusTransformUtils.preCheckCast(r17, al.class, "com.obric.aiagent.plugin")).a())));
        goto L33
    L35:
        r8.putBooleanArray(r7, p.b((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin")));
        return;
    L37:
        if (ZeusTransformUtils.instanceOf(r1, Float.class) == false) goto L44;
        Iterable r18 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin");
        Collection r19 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r18, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r20 = r18.iterator();
    L40:
        if (r20.hasNext() == false) goto L42;
        r19.add(Float.valueOf((float) r6.getDouble(((al) ZeusTransformUtils.preCheckCast(r20, al.class, "com.obric.aiagent.plugin")).a())));
        goto L40
    L42:
        r8.putFloatArray(r7, p.d((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r19, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin")));
        return;
    L44:
        if (ZeusTransformUtils.instanceOf(r1, Double.class) == false) goto L57;
        if (r9 == false) goto L51;
        Iterable r21 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin");
        Collection r22 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r21, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r23 = r21.iterator();
    L48:
        if (r23.hasNext() == false) goto L50;
        r22.add(Float.valueOf((float) r6.getDouble(((al) ZeusTransformUtils.preCheckCast(r23, al.class, "com.obric.aiagent.plugin")).a())));
        goto L48
    L50:
        r8.putFloatArray(r7, p.d((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r22, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin")));
        return;
    L51:
        Iterable r24 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin");
        Collection r25 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r24, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r26 = r24.iterator();
    L53:
        if (r26.hasNext() == false) goto L55;
        r25.add(Double.valueOf(r6.getDouble(((al) ZeusTransformUtils.preCheckCast(r26, al.class, "com.obric.aiagent.plugin")).a())));
        goto L53
    L55:
        r8.putDoubleArray(r7, p.c((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r25, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin")));
        return;
    L57:
        if (ZeusTransformUtils.instanceOf(r1, JSONObject.class) == false) goto L63;
        Iterable r27 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin");
        Collection r28 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r27, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r29 = r27.iterator();
    L60:
        if (r29.hasNext() == false) goto L62;
        JSONObject r30 = r6.getJSONObject(((al) ZeusTransformUtils.preCheckCast(r29, al.class, "com.obric.aiagent.plugin")).a());
        o.c(r30, "arr.getJSONObject(it)");
        r28.add(json2Bundle(r30, r9));
        goto L60
    L62:
        r8.putParcelableArray(r7, (Parcelable[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r28, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin")).toArray(new Bundle[0]), Parcelable[].class, "com.obric.aiagent.plugin"));
        return;
    L63:
        ZeusTransformUtils.instanceOf(r1, JSONArray.class);
    }

    public static /* synthetic */ Bundle json2Bundle$default(JSONObject r0, boolean r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L6;
        r1 = true;
    L6:
        return json2Bundle(r0, r1);
    }

    public static final Bundle json2Bundle(JSONObject r6, boolean r7) {
        o.e(r6, "args");
        Bundle r0 = new Bundle();
        Iterator<String> r1 = r6.keys();
        o.c(r1, "args.keys()");
    L4:
        if (r1.hasNext() == false) goto L31;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.aiagent.plugin");
        Object r3 = r6.get(r2);
        if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
        if (ZeusTransformUtils.instanceOf(r3, Integer.class) == true) goto L10;
        if (ZeusTransformUtils.instanceOf(r3, Long.class) == true) goto L13;
        if (ZeusTransformUtils.instanceOf(r3, Boolean.class) == true) goto L16;
        if (ZeusTransformUtils.instanceOf(r3, Float.class) == true) goto L19;
        if (ZeusTransformUtils.instanceOf(r3, Double.class) == true) goto L22;
        if (ZeusTransformUtils.instanceOf(r3, JSONArray.class) == true) goto L27;
        if (ZeusTransformUtils.instanceOf(r3, JSONObject.class) == false) goto L4;
        r0.putBundle(r2, json2Bundle((JSONObject) ZeusTransformUtils.preCheckCast(r3, JSONObject.class, "com.obric.aiagent.plugin"), r7));
        goto L4
    L27:
        JSONArray r4 = (JSONArray) ZeusTransformUtils.preCheckCast(r3, JSONArray.class, "com.obric.aiagent.plugin");
        o.c(r2, "key");
        saveArr(r4, r2, r0, r7);
        goto L4
    L22:
        if (r7 == true) goto L23;
        r0.putDouble(r2, ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).doubleValue());
        goto L4
    L23:
        r0.putFloat(r2, (float) ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).doubleValue());
        goto L4
    L19:
        r0.putFloat(r2, ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).floatValue());
        goto L4
    L16:
        r0.putBoolean(r2, ((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        goto L4
    L13:
        r0.putLong(r2, ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).longValue());
        goto L4
    L10:
        r0.putInt(r2, ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).intValue());
        goto L4
    L7:
        r0.putString(r2, (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        goto L4
    L31:
        return r0;
    }

    public static final JSONObject bundle2json(Bundle r15) {
        o.e(r15, "args");
        JSONObject r5 = new JSONObject();
        Iterator<String> r6 = r15.keySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L79;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.aiagent.plugin");
        Object r8 = r15.get(r7);
        if (ZeusTransformUtils.instanceOf(r8, Integer.class) == true) goto L7;
        if ((r8 instanceof int[]) == true) goto L10;
        if (ZeusTransformUtils.instanceOf(r8, Long.class) == true) goto L17;
        if ((r8 instanceof long[]) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r8, Boolean.class) == true) goto L27;
        if ((r8 instanceof boolean[]) == true) goto L30;
        if (ZeusTransformUtils.instanceOf(r8, Double.class) == true) goto L37;
        if ((r8 instanceof double[]) == true) goto L40;
        if (ZeusTransformUtils.instanceOf(r8, Float.class) == true) goto L47;
        if ((r8 instanceof float[]) == true) goto L50;
        if (ZeusTransformUtils.instanceOf(r8, String.class) == true) goto L57;
        if (ZeusTransformUtils.instanceOf(r8, Bundle.class) == true) goto L60;
        if ((r8 instanceof Object[]) == true) goto L64;
        AIKLog.INSTANCE.w("bundle2json", "unknown type " + r8);
        goto L4
    L64:
        if (((Object[]) ZeusTransformUtils.preCheckCast(r8, Object[].class, "com.obric.aiagent.plugin")).length <= 0) goto L4;
        if (ZeusTransformUtils.instanceOf(((Object[]) ZeusTransformUtils.preCheckCast(r8, Object[].class, "com.obric.aiagent.plugin"))[0], Bundle.class) == true) goto L68;
        JSONArray r10 = new JSONArray();
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(n.b(0, ((Object[]) ZeusTransformUtils.preCheckCast(r8, Object[].class, "com.obric.aiagent.plugin")).length), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L75:
        if (r11.hasNext() == false) goto L77;
        int r12 = ((al) ZeusTransformUtils.preCheckCast(r11, al.class, "com.obric.aiagent.plugin")).a();
        r10.put(r12, ((Object[]) ZeusTransformUtils.preCheckCast(r8, Object[].class, "com.obric.aiagent.plugin"))[r12]);
        goto L75
    L77:
        x r9 = x.f38692a;
        r5.put(r7, r10);
        goto L4
    L68:
        JSONArray r13 = new JSONArray();
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(n.b(0, ((Object[]) ZeusTransformUtils.preCheckCast(r8, Object[].class, "com.obric.aiagent.plugin")).length), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L70:
        if (r14.hasNext() == false) goto L72;
        int r16 = ((al) ZeusTransformUtils.preCheckCast(r14, al.class, "com.obric.aiagent.plugin")).a();
        Object r17 = ((Object[]) ZeusTransformUtils.preCheckCast(r8, Object[].class, "com.obric.aiagent.plugin"))[r16];
        o.a(r17, "null cannot be cast to non-null type android.os.Bundle");
        r13.put(r16, bundle2json((Bundle) ZeusTransformUtils.preCheckCast(r17, Bundle.class, "com.obric.aiagent.plugin")));
        goto L70
    L72:
        x r18 = x.f38692a;
        r5.put(r7, r13);
        goto L4
    L60:
        r5.put(r7, bundle2json((Bundle) ZeusTransformUtils.preCheckCast(r8, Bundle.class, "com.obric.aiagent.plugin")));
        goto L4
    L57:
        r5.put(r7, r8);
        goto L4
    L50:
        JSONArray r19 = new JSONArray();
        Iterator r110 = ((Iterable) ZeusTransformUtils.preCheckCast(n.b(0, ((float[]) ZeusTransformUtils.preCheckCast(r8, float[].class, "com.obric.aiagent.plugin")).length), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L52:
        if (r110.hasNext() == false) goto L54;
        int r111 = ((al) ZeusTransformUtils.preCheckCast(r110, al.class, "com.obric.aiagent.plugin")).a();
        r19.put(r111, Float.valueOf(((float[]) ZeusTransformUtils.preCheckCast(r8, float[].class, "com.obric.aiagent.plugin"))[r111]));
        goto L52
    L54:
        x r20 = x.f38692a;
        r5.put(r7, r19);
        goto L4
    L47:
        r5.put(r7, r8);
        goto L4
    L40:
        JSONArray r112 = new JSONArray();
        Iterator r113 = ((Iterable) ZeusTransformUtils.preCheckCast(n.b(0, ((double[]) ZeusTransformUtils.preCheckCast(r8, double[].class, "com.obric.aiagent.plugin")).length), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L42:
        if (r113.hasNext() == false) goto L44;
        int r114 = ((al) ZeusTransformUtils.preCheckCast(r113, al.class, "com.obric.aiagent.plugin")).a();
        r112.put(r114, ((double[]) ZeusTransformUtils.preCheckCast(r8, double[].class, "com.obric.aiagent.plugin"))[r114]);
        goto L42
    L44:
        x r21 = x.f38692a;
        r5.put(r7, r112);
        goto L4
    L37:
        r5.put(r7, ((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.aiagent.plugin")).doubleValue());
        goto L4
    L30:
        JSONArray r115 = new JSONArray();
        Iterator r116 = ((Iterable) ZeusTransformUtils.preCheckCast(n.b(0, ((boolean[]) ZeusTransformUtils.preCheckCast(r8, boolean[].class, "com.obric.aiagent.plugin")).length), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L32:
        if (r116.hasNext() == false) goto L34;
        int r117 = ((al) ZeusTransformUtils.preCheckCast(r116, al.class, "com.obric.aiagent.plugin")).a();
        r115.put(r117, ((boolean[]) ZeusTransformUtils.preCheckCast(r8, boolean[].class, "com.obric.aiagent.plugin"))[r117]);
        goto L32
    L34:
        x r22 = x.f38692a;
        r5.put(r7, r115);
        goto L4
    L27:
        r5.put(r7, ((Boolean) ZeusTransformUtils.preCheckCast(r8, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        goto L4
    L20:
        JSONArray r118 = new JSONArray();
        Iterator r119 = ((Iterable) ZeusTransformUtils.preCheckCast(n.b(0, ((long[]) ZeusTransformUtils.preCheckCast(r8, long[].class, "com.obric.aiagent.plugin")).length), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L22:
        if (r119.hasNext() == false) goto L24;
        int r120 = ((al) ZeusTransformUtils.preCheckCast(r119, al.class, "com.obric.aiagent.plugin")).a();
        r118.put(r120, ((long[]) ZeusTransformUtils.preCheckCast(r8, long[].class, "com.obric.aiagent.plugin"))[r120]);
        goto L22
    L24:
        x r23 = x.f38692a;
        r5.put(r7, r118);
        goto L4
    L17:
        r5.put(r7, ((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.aiagent.plugin")).longValue());
        goto L4
    L10:
        JSONArray r121 = new JSONArray();
        Iterator r122 = ((Iterable) ZeusTransformUtils.preCheckCast(n.b(0, ((int[]) ZeusTransformUtils.preCheckCast(r8, int[].class, "com.obric.aiagent.plugin")).length), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L12:
        if (r122.hasNext() == false) goto L14;
        int r123 = ((al) ZeusTransformUtils.preCheckCast(r122, al.class, "com.obric.aiagent.plugin")).a();
        r121.put(r123, ((int[]) ZeusTransformUtils.preCheckCast(r8, int[].class, "com.obric.aiagent.plugin"))[r123]);
        goto L12
    L14:
        x r24 = x.f38692a;
        r5.put(r7, r121);
        goto L4
    L7:
        r5.put(r7, ((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.aiagent.plugin")).intValue());
        goto L4
    L79:
        return r5;
    }

    public static final Bundle setGlobalCall(Bundle r12, String r13, String r14, String r15) {
        o.e(r12, "<this>");
        o.e(r13, "methodName");
        o.e(r14, "apiDomain");
        o.e(r15, "apiEntrance");
        return commonParams$default(r12, "", r13, IdlKeys.Call_Type_CallGlobalBiz, null, r14, r15, null, false, 200, null);
    }

    public static final Bundle setBizCall(Bundle r12, String r13, String r14, String r15) {
        o.e(r12, "<this>");
        o.e(r13, "bizName");
        o.e(r14, "apiDomain");
        o.e(r15, "apiEntrance");
        return commonParams$default(r12, r13, IdlKeys.Method_RunBiz, IdlKeys.Call_Type_CallBiz, null, r14, r15, null, false, 200, null);
    }

    public static final boolean isTaskId(Bundle r1) {
        o.e(r1, "<this>");
        return r1.getBoolean(IdlKeys.IsTaskId);
    }

    public static final long getTaskId(Bundle r2) {
        o.e(r2, "<this>");
        return r2.getLong(IdlKeys.Result);
    }

    public static final String getModelName(Bundle r1) {
        o.e(r1, "<this>");
        return r1.getString(IdlKeys.Args_ModelName);
    }

    public static final boolean isSuccess(Bundle r2) {
        o.e(r2, "<this>");
        int r3 = r2.getInt(IdlKeys.ErrorCode, 0);
        if (r3 == 0) goto L6;
        if (r3 == 1) goto L6;
        return false;
    L6:
        return true;
    }

    public static final boolean isError(Bundle r1) {
        o.e(r1, "<this>");
        return !isSuccess(r1);
    }

    public static final boolean isFinish(Bundle r2) {
        o.e(r2, "<this>");
        return r2.getBoolean(IdlKeys.IsFinish, true);
    }

    public static /* synthetic */ Bundle commonParams$default(Bundle r12, String r13, String r14, String r15, String r16, String r17, String r18, String[] r19, boolean r20, int r21, Object r22) {
        if ((r21 & 1) == 0) goto L5;
        String r4 = "";
    L7:
        if ((r21 & 2) == 0) goto L9;
        String r5 = "";
    L11:
        if ((r21 & 8) == 0) goto L13;
        String r7 = "";
    L15:
        if ((r21 & 64) == 0) goto L17;
        String[] r10 = new String[0];
    L19:
        if ((r21 & 128) == 0) goto L21;
        boolean r11 = false;
    L23:
        return commonParams(r12, r4, r5, r15, r7, r17, r18, r10, r11);
    L21:
        r11 = r20;
        goto L23
    L17:
        r10 = r19;
        goto L19
    L13:
        r7 = r16;
        goto L15
    L9:
        r5 = r14;
        goto L11
    L5:
        r4 = r13;
        goto L7
    }

    public static final Bundle commonParams(Bundle r1, String r2, String r3, String r4, String r5, String r6, String r7, String[] r8, boolean r9) {
        o.e(r1, "<this>");
        o.e(r3, "methodName");
        o.e(r4, "callType");
        o.e(r6, "apiDomain");
        o.e(r7, "apiEntrance");
        r1.putString(IdlKeys.Args_BizName, r2);
        r1.putString(IdlKeys.Call_Type, r4);
        r1.putString(IdlKeys.MethodName, r3);
        r1.putString(IdlKeys.Args_SCENE, r5);
        r1.putString(IdlKeys.Args_ApiEntrance, r7);
        r1.putString(IdlKeys.Args_ApiDomain, r6);
        r1.putStringArray(IdlKeys.Args_PACKAGE_ARR, r8);
        if (r1.containsKey(IdlKeys.Args_TraceId) == true) goto L5;
        r1.putString(IdlKeys.Args_TraceId, UUID.randomUUID().toString());
    L5:
        if (r9 == true) goto L9;
        r1.putString(IdlKeys.Args_SdkVer, a.f22349a.b());
        r1.putLong(IdlKeys.Args_ReqTime, SystemClock.elapsedRealtime());
        AIKernelConfig r10 = a.f22349a.a();
        if (r10 == null) goto L9;
        r1.putLong(IdlKeys.Args_AppId, r10.getAppId());
        r1.putString(IdlKeys.Args_PackageName, r10.getPackageName());
    L9:
        return r1;
    }

    public static final <T> Response<T> toBasicTypeResponse(Bundle r10) {
        o.e(r10, "<this>");
        return new Response(r10.getInt(IdlKeys.ErrorCode, 0), r10.getString(IdlKeys.ErrorInfo), r10.get(IdlKeys.Result), r10.getBoolean(IdlKeys.IsFinish, true), r10.getBoolean(IdlKeys.IsTaskId, false), toExtraResponse(r10), r10);
    }

    public static final <T> Response<T> toUserResponse(Bundle r10, m<? super Bundle, ? super String, ? extends T> r11) {
        m r12 = (m) ZeusTransformUtils.wrapperContextForParams(r11, m.class, "com.obric.aiagent.plugin");
        o.e(r10, "<this>");
        o.e(r12, "block");
        int r3 = r10.getInt(IdlKeys.ErrorCode, 0);
        String r4 = r10.getString(IdlKeys.ErrorInfo);
        boolean r6 = r10.getBoolean(IdlKeys.IsFinish, true);
        boolean r7 = r10.getBoolean(IdlKeys.IsTaskId, false);
        return new Response(r3, r4, r12.invoke(r10, IdlKeys.Result), r6, r7, toExtraResponse(r10), r10);
    }

    public static final <T> Response<T> toNetResponse(Bundle r10, m<? super Bundle, ? super String, ? extends T> r11) {
        m r12 = (m) ZeusTransformUtils.wrapperContextForParams(r11, m.class, "com.obric.aiagent.plugin");
        o.e(r10, "<this>");
        o.e(r12, "block");
        int r3 = r10.getInt(IdlKeys.ErrorCode, 0);
        String r4 = r10.getString(IdlKeys.ErrorInfo);
        boolean r6 = r10.getBoolean(IdlKeys.IsFinish, true);
        boolean r7 = r10.getBoolean(IdlKeys.IsTaskId, false);
        return new Response(r3, r4, r12.invoke(r10, IdlKeys.Result), r6, r7, toExtraResponse(r10), r10);
    }

    public static final JSONObject toExtraResponse(Bundle r5) {
        o.e(r5, "<this>");
        JSONObject r0 = new JSONObject();
        r0.put(IdlKeys.Args_TraceId, r5.getString(IdlKeys.Args_TraceId, ""));
        r0.put(IdlKeys.Args_TraceEventKey, r5.getString(IdlKeys.Args_TraceEventKey, ""));
        r0.put(IdlKeys.Args_TraceEventArgs, r5.getString(IdlKeys.Args_TraceEventArgs, ""));
        r0.put(IdlKeys.Args_UseCloud, r5.getBoolean(IdlKeys.Args_UseCloud));
        r0.put(IdlKeys.Args_Timeout, r5.getLong(IdlKeys.Args_Timeout));
        long r1 = r5.getLong(IdlKeys.Args_ReqTime, -1);
        if (r1 <= 0) goto L5;
        r0.put(IdlKeys.Args_End2EndCost, SystemClock.elapsedRealtime() - r1);
    L5:
        return r0;
    }

    public static final Bundle toE2EDurationResponse(Bundle r4) {
        o.e(r4, "<this>");
        long r0 = r4.getLong(IdlKeys.Args_ReqTime, -1);
        if (r0 <= 0) goto L5;
        r4.putLong(IdlKeys.Args_End2EndCost, SystemClock.elapsedRealtime() - r0);
    L5:
        return r4;
    }

    public static final Response<JSONObject> toJsonResult(Bundle r10) {
        o.e(r10, "<this>");
        int r3 = r10.getInt(IdlKeys.ErrorCode, 0);
        String r4 = r10.getString(IdlKeys.ErrorInfo);
        Bundle r0 = r10.getBundle(IdlKeys.Result);
        if (r0 != null) goto L5;
        r0 = new Bundle();
    L5:
        o.c(r0, "getBundle(IdlKeys.Result)?: Bundle()");
        return new Response(r3, r4, bundle2json(r0), r10.getBoolean(IdlKeys.IsFinish, true), r10.getBoolean(IdlKeys.IsTaskId, false), toExtraResponse(r10), r10);
    }

    public static final List<PackageResource> getPackageInfos(Bundle r6) {
        o.e(r6, "<this>");
        r6.setClassLoader(PackageResource.class.getClassLoader());
        Parcelable[] r7 = r6.getParcelableArray(IdlKeys.Args_Pkgs);
        if (r7 == null) goto L11;
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        int r1 = 0;
        int r3 = r7.length;
    L5:
        if (r1 >= r3) goto L16;
        Parcelable r4 = r7[r1];
        if (ZeusTransformUtils.instanceOf(r4, PackageResource.class) == false) goto L9;
        r0.add(r4);
    L9:
        r1 = r1 + 1;
        goto L5
    L16:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
    L11:
        return null;
    }

    public static final int getErrorCode(Bundle r2) {
        if (r2 != null) goto L6;
        return 108;
    L6:
        return r2.getInt(IdlKeys.ErrorCode, 0);
    }

    public static final String getErrorMsg(Bundle r1) {
        if (r1 == null) goto L4;
        String r2 = r1.getString(IdlKeys.ErrorInfo);
    L5:
        if (r2 != null) goto L8;
        return "";
    L8:
        return r2;
    L4:
        r2 = null;
        goto L5
    }

    public static final boolean isGetModel(Bundle r2) {
        o.e(r2, "<this>");
        if (o.a(r2.getString(IdlKeys.Call_Type), IdlKeys.Call_Type_CallGlobal) == true) goto L5;
    L7:
        return false;
    L5:
        if (o.a(r2.getString(IdlKeys.MethodName), IdlKeys.Method_GetModel) == false) goto L7;
        return true;
    }

    public static final boolean isCallModel(Bundle r1) {
        o.e(r1, "<this>");
        return o.a(r1.getString(IdlKeys.Call_Type), IdlKeys.Call_Type_CallModel);
    }

    public static final boolean isCallScene(Bundle r1) {
        o.e(r1, "<this>");
        return o.a(r1.getString(IdlKeys.Call_Type), IdlKeys.Call_Type_CallScene);
    }

    public static final boolean isCallGlobal(Bundle r1) {
        o.e(r1, "<this>");
        return o.a(r1.getString(IdlKeys.Call_Type), IdlKeys.Call_Type_CallGlobal);
    }

    public static final boolean isCallGlobalBiz(Bundle r1) {
        o.e(r1, "<this>");
        return o.a(r1.getString(IdlKeys.Call_Type), IdlKeys.Call_Type_CallGlobalBiz);
    }

    public static final boolean isCallBiz(Bundle r1) {
        o.e(r1, "<this>");
        return o.a(r1.getString(IdlKeys.Call_Type), IdlKeys.Call_Type_CallBiz);
    }

    public static final String getPackageName(Bundle r2) {
        o.e(r2, "<this>");
        String r3 = r2.getString(IdlKeys.Args_PackageName, null);
        if (r3 != null) goto L6;
        return "";
    L6:
        return r3;
    }

    public static final String getAIKTraceId(Bundle r2) {
        o.e(r2, "<this>");
        String r3 = r2.getString(IdlKeys.Args_TraceId, "");
        o.c(r3, "this.getString(IdlKeys.Args_TraceId, \"\")");
        return r3;
    }

    public static final String getBizName(Bundle r2) {
        o.e(r2, "<this>");
        String r3 = r2.getString(IdlKeys.Args_BizName, null);
        if (r3 != null) goto L6;
        return "";
    L6:
        return r3;
    }

    public static final long getSdkVer(Bundle r12) {
        o.e(r12, "<this>");
        String r13 = r12.getString(IdlKeys.Args_SdkVer, "");
        o.c(r13, "sdkVer");
        List r0 = d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin"), new String[]{"-"}, false, 0, 6, null);
        if (r0.size() <= 1) goto L5;
        List r14 = p.g((Collection) ZeusTransformUtils.preCheckCast(d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r0.get(0), CharSequence.class, "com.obric.aiagent.plugin"), new String[]{"."}, false, 0, 6, null), Collection.class, "com.obric.aiagent.plugin"));
    L7:
        if (r14.size() == 3) goto L9;
        return -1;
    L9:
        Integer r1 = d.o.o.d((String) ZeusTransformUtils.preCheckCast(r14.get(0), String.class, "com.obric.aiagent.plugin"));
        Integer r2 = d.o.o.d((String) ZeusTransformUtils.preCheckCast(r14.get(1), String.class, "com.obric.aiagent.plugin"));
        Integer r15 = d.o.o.d((String) ZeusTransformUtils.preCheckCast(r14.get(2), String.class, "com.obric.aiagent.plugin"));
        if (r1 == null) goto L22;
        if (r2 == null) goto L22;
        if (r15 == null) goto L22;
        if (new j(0, 1000).a(r1.intValue()) == false) goto L22;
        if (new j(0, 1000).a(r2.intValue()) == false) goto L22;
        if (new j(0, 1000).a(r15.intValue()) == false) goto L22;
        return ((((long) r1.intValue()) * 1000000) + (((long) r2.intValue()) * 1000)) + ((long) r15.intValue());
    L22:
        return -1;
    L5:
        r14 = d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin"), new String[]{"."}, false, 0, 6, null);
        goto L7
    }

    public static final Bundle setTaskIdRes(Bundle r2, long r3) {
        o.e(r2, "<this>");
        r2.putInt(IdlKeys.ErrorCode, 1);
        r2.putBoolean(IdlKeys.IsTaskId, true);
        r2.putLong(IdlKeys.Result, r3);
        return r2;
    }

    public static /* synthetic */ Bundle setBasicTypeRes$default(Bundle r0, Object r1, int r2, String r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = null;
    L9:
        return setBasicTypeRes(r0, r1, r2, r3);
    }

    public static final <T> Bundle setBasicTypeRes(Bundle r2, T r3, int r4, String r5) {
        o.e(r2, "<this>");
        r2.putInt(IdlKeys.ErrorCode, r4);
        r2.putString(IdlKeys.ErrorInfo, r5);
        boolean r0 = true;
        if (r4 != 1) goto L6;
        r0 = false;
    L6:
        r2.putBoolean(IdlKeys.IsFinish, r0);
        if (ZeusTransformUtils.instanceOf(r3, Integer.class) == false) goto L10;
        r2.putInt(IdlKeys.Result, ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).intValue());
    L42:
        return r2;
    L10:
        if ((r3 instanceof int[]) == false) goto L13;
        r2.putIntArray(IdlKeys.Result, (int[]) ZeusTransformUtils.preCheckCast(r3, int[].class, "com.obric.aiagent.plugin"));
        goto L42
    L13:
        if (ZeusTransformUtils.instanceOf(r3, Float.class) == false) goto L16;
        r2.putFloat(IdlKeys.Result, ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).floatValue());
        goto L42
    L16:
        if ((r3 instanceof float[]) == false) goto L19;
        r2.putFloatArray(IdlKeys.Result, (float[]) ZeusTransformUtils.preCheckCast(r3, float[].class, "com.obric.aiagent.plugin"));
        goto L42
    L19:
        if (ZeusTransformUtils.instanceOf(r3, String.class) == false) goto L22;
        r2.putString(IdlKeys.Result, (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        goto L42
    L22:
        if (ZeusTransformUtils.instanceOf(r3, Byte.class) == false) goto L25;
        r2.putByte(IdlKeys.Result, ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).byteValue());
        goto L42
    L25:
        if ((r3 instanceof byte[]) == false) goto L28;
        r2.putByteArray(IdlKeys.Result, (byte[]) ZeusTransformUtils.preCheckCast(r3, byte[].class, "com.obric.aiagent.plugin"));
        goto L42
    L28:
        if (ZeusTransformUtils.instanceOf(r3, Character.class) == false) goto L31;
        r2.putChar(IdlKeys.Result, ((Character) ZeusTransformUtils.preCheckCast(r3, Character.class, "com.obric.aiagent.plugin")).charValue());
        goto L42
    L31:
        if ((r3 instanceof char[]) == false) goto L34;
        r2.putCharArray(IdlKeys.Result, (char[]) ZeusTransformUtils.preCheckCast(r3, char[].class, "com.obric.aiagent.plugin"));
        goto L42
    L34:
        if (ZeusTransformUtils.instanceOf(r3, Boolean.class) == false) goto L37;
        r2.putBoolean(IdlKeys.Result, ((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        goto L42
    L37:
        if ((r3 instanceof boolean[]) == false) goto L40;
        r2.putBooleanArray(IdlKeys.Result, (boolean[]) ZeusTransformUtils.preCheckCast(r3, boolean[].class, "com.obric.aiagent.plugin"));
        goto L42
    L40:
        if (ZeusTransformUtils.instanceOf(r3, JSONObject.class) == false) goto L42;
        r2.putBundle(IdlKeys.Result, json2Bundle$default((JSONObject) ZeusTransformUtils.preCheckCast(r3, JSONObject.class, "com.obric.aiagent.plugin"), false, 2, null));
        goto L42
    }

    public static /* synthetic */ Bundle setResApply$default(Bundle r1, int r2, b r3, int r4, Object r5) {
        b r6 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        return setResApply(r1, r2, r6);
    }

    public static final Bundle setResApply(Bundle r2, int r3, b<? super Bundle, x> r4) {
        b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.aiagent.plugin");
        o.e(r2, "<this>");
        o.e(r5, "block");
        r2.putInt(IdlKeys.ErrorCode, r3);
        r2.putString(IdlKeys.ErrorInfo, null);
        boolean r0 = true;
        if (r3 != 1) goto L6;
        r0 = false;
    L6:
        r2.putBoolean(IdlKeys.IsFinish, r0);
        r5.invoke(r2);
        return r2;
    }

    public static /* synthetic */ Bundle setErr$default(Bundle r0, int r1, String r2, boolean r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = 108;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = IdlErrors.INSTANCE.toString(r1);
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = true;
    L12:
        return setErr(r0, r1, r2, r3);
    }

    public static final Bundle setErr(Bundle r1, int r2, String r3, boolean r4) {
        o.e(r1, "<this>");
        o.e(r3, "errInfo");
        r1.putInt(IdlKeys.ErrorCode, r2);
        r1.putString(IdlKeys.ErrorInfo, r3);
        r1.putBoolean(IdlKeys.IsFinish, r4);
        return r1;
    }

    public static /* synthetic */ Bundle setOK$default(Bundle r0, int r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = "";
    L9:
        return setOK(r0, r1, r2);
    }

    public static final Bundle setOK(Bundle r1, int r2, String r3) {
        o.e(r1, "<this>");
        o.e(r3, "errInfo");
        r1.putInt(IdlKeys.ErrorCode, r2);
        r1.putString(IdlKeys.ErrorInfo, r3);
        boolean r4 = true;
        if (r2 != 1) goto L6;
        r4 = false;
    L6:
        r1.putBoolean(IdlKeys.IsFinish, r4);
        return r1;
    }

    public static /* synthetic */ Bundle setInvalidArg$default(Bundle r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = "invalid arguments.";
    L6:
        return setInvalidArg(r0, r1);
    }

    public static final Bundle setInvalidArg(Bundle r7, String r8) {
        o.e(r7, "<this>");
        o.e(r8, "errInfo");
        setErr$default(r7, 101, r8, false, 4, null);
        return r7;
    }

    public static final Bundle setMethod(Bundle r1, String r2) {
        o.e(r1, "<this>");
        o.e(r2, "name");
        r1.putString(IdlKeys.MethodName, r2);
        return r1;
    }

    public static final String getMethod(Bundle r1) {
        o.e(r1, "<this>");
        return r1.getString(IdlKeys.MethodName);
    }

    public static /* synthetic */ boolean safeOnResult$default(AIKListener r1, Bundle r2, int r3, Object r4) {
        AIKListener r5 = (AIKListener) ZeusTransformUtils.wrapperContextForParams(r1, AIKListener.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L6;
        r2 = OK;
    L6:
        return safeOnResult(r5, r2);
    }

    public static final boolean safeOnResult(AIKListener r2, Bundle r3) {
        AIKListener r4 = (AIKListener) ZeusTransformUtils.wrapperContextForParams(r2, AIKListener.class, "com.obric.aiagent.plugin");
        o.e(r4, "<this>");
        o.e(r3, "response");
        r4.onResult(r3);     // Catch: Throwable -> L6
        return true;
    L6:
        th = move-exception;
        AIKLog.INSTANCE.e("TaskOnResult", String.valueOf(th.getMessage()));
        return false;
    }

    public static /* synthetic */ void err$default(AIKListener r1, int r2, String r3, int r4, Object r5) {
        AIKListener r6 = (AIKListener) ZeusTransformUtils.wrapperContextForParams(r1, AIKListener.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r3 = IdlErrors.INSTANCE.toString(r2);
    L5:
        err(r6, r2, r3);
    }

    public static final void err(AIKListener r7, int r8, String r9) {
        AIKListener r10 = (AIKListener) ZeusTransformUtils.wrapperContextForParams(r7, AIKListener.class, "com.obric.aiagent.plugin");
        o.e(r10, "<this>");
        o.e(r9, "errInfo");
        safeOnResult(r10, setErr$default(new Bundle(), r8, r9, false, 4, null));
    }

    public static final <T> String getLogId(Response<T> r1) {
        o.e(r1, "<this>");
        Bundle r2 = r1.getSrc();
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.getString("log_id");
    }

    public static final <T> String getTraceId(Response<T> r1) {
        o.e(r1, "<this>");
        Bundle r2 = r1.getSrc();
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.getString("trace_id");
    }

    public static final Bundle safeUnparcel(Bundle r4) {
        o.e(r4, "<this>");
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L5
        Object r1 = d.n.f(Integer.valueOf(getErrorCode(r4)));     // Catch: Throwable -> L5
    L7:
        Throwable r2 = d.n.c(r1);
        if (r2 == null) goto L10;
        AIKLog.INSTANCE.w("AIK-SDK-DataParser", "safeUnparcel exception: " + r2);
    L10:
        return r4;
    L5:
        th = move-exception;
        d.n.a r3 = d.n.f38560a;
        r1 = d.n.f(d.o.a(th));
        goto L7
    }
}
