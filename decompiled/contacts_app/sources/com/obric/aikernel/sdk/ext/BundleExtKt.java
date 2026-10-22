package com.obric.aikernel.sdk.ext;

import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.constant.ReportProtocal;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.tracing.internal.TracingConstants;
import com.obric.aikernel.AIKListener;
import com.obric.aikernel.core.DataHolder;
import com.obric.aikernel.core.data.IdlErrors;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.sdk.AIKernelConfig;
import com.obric.aikernel.sdk.data.PackageResource;
import com.obric.aikernel.sdk.response.Response;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: BundleExt.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001\u001a\u0018\u0010\t\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b\u001a&\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b\u001ae\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00112\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u000b¢\u0006\u0002\u0010\u001d\u001a\u001c\u0010\u001e\u001a\u00020\r*\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u0011\u001a\n\u0010#\u001a\u00020\u0011*\u00020\u0001\u001a\n\u0010$\u001a\u00020\u0011*\u00020\u0001\u001a\f\u0010%\u001a\u00020!*\u0004\u0018\u00010\u0001\u001a\f\u0010&\u001a\u00020\u0011*\u0004\u0018\u00010\u0001\u001a\u0018\u0010'\u001a\u0004\u0018\u00010\u0011\"\u0004\b\u0000\u0010(*\b\u0012\u0004\u0012\u0002H(0)\u001a\f\u0010*\u001a\u0004\u0018\u00010\u0011*\u00020\u0001\u001a\f\u0010+\u001a\u0004\u0018\u00010\u0011*\u00020\u0001\u001a\u0012\u0010,\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010-*\u00020\u0001\u001a\n\u0010/\u001a\u00020\u0011*\u00020\u0001\u001a\n\u00100\u001a\u000201*\u00020\u0001\u001a\n\u00102\u001a\u000201*\u00020\u0001\u001a\u0018\u00103\u001a\u0004\u0018\u00010\u0011\"\u0004\b\u0000\u0010(*\b\u0012\u0004\u0012\u0002H(0)\u001a\n\u00104\u001a\u00020\u000b*\u00020\u0001\u001a\n\u00105\u001a\u00020\u000b*\u00020\u0001\u001a\n\u00106\u001a\u00020\u000b*\u00020\u0001\u001a\n\u00107\u001a\u00020\u000b*\u00020\u0001\u001a\n\u00108\u001a\u00020\u000b*\u00020\u0001\u001a\n\u00109\u001a\u00020\u000b*\u00020\u0001\u001a\n\u0010:\u001a\u00020\u000b*\u00020\u0001\u001a\n\u0010;\u001a\u00020\u000b*\u00020\u0001\u001a\n\u0010<\u001a\u00020\u000b*\u00020\u0001\u001a\n\u0010=\u001a\u00020\u000b*\u00020\u0001\u001a\u0014\u0010>\u001a\u00020\u000b*\u00020\u001f2\b\b\u0002\u0010?\u001a\u00020\u0001\u001a\n\u0010@\u001a\u00020\u0001*\u00020\u0001\u001a3\u0010A\u001a\u00020\u0001\"\u0004\b\u0000\u0010(*\u00020\u00012\u0006\u0010B\u001a\u0002H(2\b\b\u0002\u0010C\u001a\u00020!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010D\u001a\"\u0010E\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0011\u001a(\u0010F\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010:\u001a\u00020\u000b\u001a\u001e\u0010F\u001a\u00020\u0001*\u00020\u00012\u0006\u0010C\u001a\u00020!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0011\u001a\"\u0010G\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0011\u001a\u0014\u0010H\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\"\u001a\u00020\u0011\u001a\u0012\u0010I\u001a\u00020\u0001*\u00020\u00012\u0006\u0010J\u001a\u00020\u0011\u001a\u001e\u0010K\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010C\u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u0011\u001a(\u0010L\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010C\u001a\u00020!2\u0012\u0010M\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\r0N\u001a\u0012\u0010O\u001a\u00020\u0001*\u00020\u00012\u0006\u0010P\u001a\u000201\u001a\u0016\u0010Q\u001a\b\u0012\u0004\u0012\u0002H(0)\"\u0004\b\u0000\u0010(*\u00020\u0001\u001a\n\u0010R\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010S\u001a\u00020\u0007*\u00020\u0001\u001a\u0010\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00070)*\u00020\u0001\u001a0\u0010U\u001a\b\u0012\u0004\u0012\u0002H(0)\"\u0004\b\u0000\u0010(*\u00020\u00012\u0018\u0010M\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u0002H(0V\u001a0\u0010W\u001a\b\u0012\u0004\u0012\u0002H(0)\"\u0004\b\u0000\u0010(*\u00020\u00012\u0018\u0010M\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u0002H(0V\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003¨\u0006X"}, d2 = {"FAIL", "Landroid/os/Bundle;", "getFAIL", "()Landroid/os/Bundle;", "OK", "getOK", "bundle2json", "Lorg/json/JSONObject;", "args", "json2Bundle", "compressFloat", "", "saveArr", "", "arr", "Lorg/json/JSONArray;", "key", "", "bundle", "commonParams", "bizName", "methodName", "callType", "sceneName", "apiDomain", "apiEntrance", "packageArr", "", "skipSource", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Z)Landroid/os/Bundle;", NotificationCompat.CATEGORY_ERROR, "Lcom/obric/aikernel/AIKListener;", "errCode", "", "errInfo", "getAIKTraceId", "getBizName", "getErrorCode", "getErrorMsg", "getLogId", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/obric/aikernel/sdk/response/Response;", "getMethod", "getModelName", "getPackageInfos", "", "Lcom/obric/aikernel/sdk/data/PackageResource;", "getPackageName", "getSdkVer", "", "getTaskId", "getTraceId", "isCallBiz", "isCallGlobal", "isCallGlobalBiz", "isCallModel", "isCallScene", "isError", "isFinish", "isGetModel", "isSuccess", "isTaskId", "safeOnResult", ApmTrafficStats.TTNET_RESPONSE, "safeUnparcel", "setBasicTypeRes", "data", "code", "(Landroid/os/Bundle;Ljava/lang/Object;ILjava/lang/String;)Landroid/os/Bundle;", "setBizCall", "setErr", "setGlobalCall", "setInvalidArg", "setMethod", "name", "setOK", "setResApply", "block", "Lkotlin/Function1;", "setTaskIdRes", "taskId", "toBasicTypeResponse", "toE2EDurationResponse", "toExtraResponse", "toJsonResult", "toNetResponse", "Lkotlin/Function2;", "toUserResponse", "sdk_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
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
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.putInt("_EC", r2);
        r1.putString("_EI", r3);
        r1.putBoolean("_IF", true);
        return r1;
    }

    public static final void saveArr(JSONArray r5, String r6, Bundle r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r5, "arr");
        Intrinsics.checkNotNullParameter(r6, "key");
        Intrinsics.checkNotNullParameter(r7, "bundle");
        if (r5.length() != 0) goto L5;
        return;
    L5:
        Object r1 = r5.opt(0);
        if (r1 != null) goto L8;
        return;
    L8:
        IntRange r2 = new IntRange(0, r5.length() - 1);
        if ((r1 instanceof String) == false) goto L16;
        IntRange r3 = r2;
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<Integer> r4 = r3.iterator();
    L12:
        if (r4.hasNext() == false) goto L14;
        r9.add(r5.getString(((IntIterator) r4).nextInt()));
        goto L12
    L14:
        r7.putStringArray(r6, (String[]) r9.toArray(new String[0]));
        return;
    L16:
        if ((r1 instanceof Integer) == false) goto L23;
        IntRange r10 = r2;
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator<Integer> r0 = r10.iterator();
    L19:
        if (r0.hasNext() == false) goto L21;
        r11.add(Integer.valueOf(r5.getInt(((IntIterator) r0).nextInt())));
        goto L19
    L21:
        r7.putIntArray(r6, CollectionsKt.toIntArray(r11));
        return;
    L23:
        if ((r1 instanceof Long) == false) goto L30;
        IntRange r12 = r2;
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator<Integer> r14 = r12.iterator();
    L26:
        if (r14.hasNext() == false) goto L28;
        r13.add(Long.valueOf(r5.getLong(((IntIterator) r14).nextInt())));
        goto L26
    L28:
        r7.putLongArray(r6, CollectionsKt.toLongArray(r13));
        return;
    L30:
        if ((r1 instanceof Boolean) == false) goto L37;
        IntRange r15 = r2;
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator<Integer> r17 = r15.iterator();
    L33:
        if (r17.hasNext() == false) goto L35;
        r16.add(Boolean.valueOf(r5.getBoolean(((IntIterator) r17).nextInt())));
        goto L33
    L35:
        r7.putBooleanArray(r6, CollectionsKt.toBooleanArray(r16));
        return;
    L37:
        if ((r1 instanceof Float) == false) goto L44;
        IntRange r18 = r2;
        ArrayList r19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10));
        Iterator<Integer> r20 = r18.iterator();
    L40:
        if (r20.hasNext() == false) goto L42;
        r19.add(Float.valueOf((float) r5.getDouble(((IntIterator) r20).nextInt())));
        goto L40
    L42:
        r7.putFloatArray(r6, CollectionsKt.toFloatArray(r19));
        return;
    L44:
        if ((r1 instanceof Double) == false) goto L57;
        if (r8 == false) goto L51;
        IntRange r21 = r2;
        ArrayList r22 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r21, 10));
        Iterator<Integer> r23 = r21.iterator();
    L48:
        if (r23.hasNext() == false) goto L50;
        r22.add(Float.valueOf((float) r5.getDouble(((IntIterator) r23).nextInt())));
        goto L48
    L50:
        r7.putFloatArray(r6, CollectionsKt.toFloatArray(r22));
        return;
    L51:
        IntRange r24 = r2;
        ArrayList r25 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r24, 10));
        Iterator<Integer> r26 = r24.iterator();
    L53:
        if (r26.hasNext() == false) goto L55;
        r25.add(Double.valueOf(r5.getDouble(((IntIterator) r26).nextInt())));
        goto L53
    L55:
        r7.putDoubleArray(r6, CollectionsKt.toDoubleArray(r25));
        return;
    L57:
        if ((r1 instanceof JSONObject) == false) goto L63;
        IntRange r27 = r2;
        ArrayList r28 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r27, 10));
        Iterator<Integer> r29 = r27.iterator();
    L60:
        if (r29.hasNext() == false) goto L62;
        JSONObject r30 = r5.getJSONObject(((IntIterator) r29).nextInt());
        Intrinsics.checkNotNullExpressionValue(r30, "arr.getJSONObject(it)");
        r28.add(json2Bundle(r30, r8));
        goto L60
    L62:
        r7.putParcelableArray(r6, (Parcelable[]) r28.toArray(new Bundle[0]));
        return;
    L63:
        boolean r31 = r1 instanceof JSONArray;
    }

    public static /* synthetic */ Bundle json2Bundle$default(JSONObject r0, boolean r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L6;
        r1 = true;
    L6:
        return json2Bundle(r0, r1);
    }

    public static final Bundle json2Bundle(JSONObject r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "args");
        Bundle r0 = new Bundle();
        Iterator<String> r1 = r5.keys();
        Intrinsics.checkNotNullExpressionValue(r1, "args.keys()");
    L4:
        if (r1.hasNext() == false) goto L31;
        String r2 = r1.next();
        Object r3 = r5.get(r2);
        if ((r3 instanceof String) == true) goto L7;
        if ((r3 instanceof Integer) == true) goto L10;
        if ((r3 instanceof Long) == true) goto L13;
        if ((r3 instanceof Boolean) == true) goto L16;
        if ((r3 instanceof Float) == true) goto L19;
        if ((r3 instanceof Double) == true) goto L22;
        if ((r3 instanceof JSONArray) == true) goto L27;
        if ((r3 instanceof JSONObject) == false) goto L4;
        r0.putBundle(r2, json2Bundle((JSONObject) r3, r6));
        goto L4
    L27:
        Intrinsics.checkNotNullExpressionValue(r2, "key");
        saveArr((JSONArray) r3, r2, r0, r6);
        goto L4
    L22:
        if (r6 == true) goto L23;
        r0.putDouble(r2, ((Number) r3).doubleValue());
        goto L4
    L23:
        r0.putFloat(r2, (float) ((Number) r3).doubleValue());
        goto L4
    L19:
        r0.putFloat(r2, ((Number) r3).floatValue());
        goto L4
    L16:
        r0.putBoolean(r2, ((Boolean) r3).booleanValue());
        goto L4
    L13:
        r0.putLong(r2, ((Number) r3).longValue());
        goto L4
    L10:
        r0.putInt(r2, ((Number) r3).intValue());
        goto L4
    L7:
        r0.putString(r2, (String) r3);
        goto L4
    L31:
        return r0;
    }

    public static final JSONObject bundle2json(Bundle r9) {
        Intrinsics.checkNotNullParameter(r9, "args");
        JSONObject r0 = new JSONObject();
        Iterator<String> r1 = r9.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L79;
        String r2 = r1.next();
        Object r3 = r9.get(r2);
        if ((r3 instanceof Integer) == true) goto L7;
        if ((r3 instanceof int[]) == true) goto L10;
        if ((r3 instanceof Long) == true) goto L17;
        if ((r3 instanceof long[]) == true) goto L20;
        if ((r3 instanceof Boolean) == true) goto L27;
        if ((r3 instanceof boolean[]) == true) goto L30;
        if ((r3 instanceof Double) == true) goto L37;
        if ((r3 instanceof double[]) == true) goto L40;
        if ((r3 instanceof Float) == true) goto L47;
        if ((r3 instanceof float[]) == true) goto L50;
        if ((r3 instanceof String) == true) goto L57;
        if ((r3 instanceof Bundle) == true) goto L60;
        if ((r3 instanceof Object[]) == true) goto L63;
        AIKLog.INSTANCE.w("bundle2json", "unknown type " + r3);
        goto L4
    L63:
        Object[] r4 = (Object[]) r3;
        if (r4.length <= 0) goto L4;
        if ((r4[0] instanceof Bundle) == true) goto L68;
        JSONArray r5 = new JSONArray();
        Iterator<Integer> r6 = RangesKt.until(0, r4.length).iterator();
    L75:
        if (r6.hasNext() == false) goto L77;
        int r7 = ((IntIterator) r6).nextInt();
        r5.put(r7, r4[r7]);
        goto L75
    L77:
        Unit r8 = Unit.INSTANCE;
        r0.put(r2, r5);
        goto L4
    L68:
        JSONArray r10 = new JSONArray();
        Iterator<Integer> r11 = RangesKt.until(0, r4.length).iterator();
    L70:
        if (r11.hasNext() == false) goto L72;
        int r12 = ((IntIterator) r11).nextInt();
        Object r13 = r4[r12];
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type android.os.Bundle");
        r10.put(r12, bundle2json((Bundle) r13));
        goto L70
    L72:
        Unit r14 = Unit.INSTANCE;
        r0.put(r2, r10);
        goto L4
    L60:
        r0.put(r2, bundle2json((Bundle) r3));
        goto L4
    L57:
        r0.put(r2, r3);
        goto L4
    L50:
        JSONArray r15 = new JSONArray();
        float[] r16 = (float[]) r3;
        Iterator<Integer> r17 = RangesKt.until(0, r16.length).iterator();
    L52:
        if (r17.hasNext() == false) goto L54;
        int r18 = ((IntIterator) r17).nextInt();
        r15.put(r18, Float.valueOf(r16[r18]));
        goto L52
    L54:
        Unit r19 = Unit.INSTANCE;
        r0.put(r2, r15);
        goto L4
    L47:
        r0.put(r2, r3);
        goto L4
    L40:
        JSONArray r20 = new JSONArray();
        double[] r21 = (double[]) r3;
        Iterator<Integer> r22 = RangesKt.until(0, r21.length).iterator();
    L42:
        if (r22.hasNext() == false) goto L44;
        int r23 = ((IntIterator) r22).nextInt();
        r20.put(r23, r21[r23]);
        goto L42
    L44:
        Unit r24 = Unit.INSTANCE;
        r0.put(r2, r20);
        goto L4
    L37:
        r0.put(r2, ((Number) r3).doubleValue());
        goto L4
    L30:
        JSONArray r25 = new JSONArray();
        boolean[] r26 = (boolean[]) r3;
        Iterator<Integer> r27 = RangesKt.until(0, r26.length).iterator();
    L32:
        if (r27.hasNext() == false) goto L34;
        int r28 = ((IntIterator) r27).nextInt();
        r25.put(r28, r26[r28]);
        goto L32
    L34:
        Unit r29 = Unit.INSTANCE;
        r0.put(r2, r25);
        goto L4
    L27:
        r0.put(r2, ((Boolean) r3).booleanValue());
        goto L4
    L20:
        JSONArray r30 = new JSONArray();
        long[] r31 = (long[]) r3;
        Iterator<Integer> r32 = RangesKt.until(0, r31.length).iterator();
    L22:
        if (r32.hasNext() == false) goto L24;
        int r33 = ((IntIterator) r32).nextInt();
        r30.put(r33, r31[r33]);
        goto L22
    L24:
        Unit r34 = Unit.INSTANCE;
        r0.put(r2, r30);
        goto L4
    L17:
        r0.put(r2, ((Number) r3).longValue());
        goto L4
    L10:
        JSONArray r35 = new JSONArray();
        int[] r36 = (int[]) r3;
        Iterator<Integer> r37 = RangesKt.until(0, r36.length).iterator();
    L12:
        if (r37.hasNext() == false) goto L14;
        int r38 = ((IntIterator) r37).nextInt();
        r35.put(r38, r36[r38]);
        goto L12
    L14:
        Unit r39 = Unit.INSTANCE;
        r0.put(r2, r35);
        goto L4
    L7:
        r0.put(r2, ((Number) r3).intValue());
        goto L4
    L79:
        return r0;
    }

    public static final Bundle setGlobalCall(Bundle r12, String r13, String r14, String r15) {
        Intrinsics.checkNotNullParameter(r12, "<this>");
        Intrinsics.checkNotNullParameter(r13, "methodName");
        Intrinsics.checkNotNullParameter(r14, "apiDomain");
        Intrinsics.checkNotNullParameter(r15, "apiEntrance");
        return commonParams$default(r12, "", r13, "_CallGlobalBiz", null, r14, r15, null, false, 200, null);
    }

    public static final Bundle setBizCall(Bundle r12, String r13, String r14, String r15) {
        Intrinsics.checkNotNullParameter(r12, "<this>");
        Intrinsics.checkNotNullParameter(r13, "bizName");
        Intrinsics.checkNotNullParameter(r14, "apiDomain");
        Intrinsics.checkNotNullParameter(r15, "apiEntrance");
        return commonParams$default(r12, r13, "_RunBiz", "_CallBiz", null, r14, r15, null, false, 200, null);
    }

    public static final boolean isTaskId(Bundle r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.getBoolean("_IT");
    }

    public static final long getTaskId(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return r2.getLong("_R");
    }

    public static final String getModelName(Bundle r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.getString("_ModelName");
    }

    public static final boolean isSuccess(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        int r3 = r2.getInt("_EC", 0);
        if (r3 == 0) goto L6;
        if (r3 == 1) goto L6;
        return false;
    L6:
        return true;
    }

    public static final boolean isError(Bundle r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return !isSuccess(r1);
    }

    public static final boolean isFinish(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return r2.getBoolean("_IF", true);
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
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r3, "methodName");
        Intrinsics.checkNotNullParameter(r4, "callType");
        Intrinsics.checkNotNullParameter(r6, "apiDomain");
        Intrinsics.checkNotNullParameter(r7, "apiEntrance");
        r1.putString("_BizName", r2);
        r1.putString("_CT", r4);
        r1.putString("_M", r3);
        r1.putString(IdlKeys.Args_SCENE, r5);
        r1.putString(IdlKeys.Args_ApiEntrance, r7);
        r1.putString(IdlKeys.Args_ApiDomain, r6);
        r1.putStringArray(IdlKeys.Args_PACKAGE_ARR, r8);
        if (r1.containsKey(IdlKeys.Args_TraceId) == true) goto L5;
        r1.putString(IdlKeys.Args_TraceId, UUID.randomUUID().toString());
    L5:
        if (r9 == true) goto L9;
        r1.putString(IdlKeys.Args_SdkVer, DataHolder.INSTANCE.getSdkVersion());
        r1.putLong(IdlKeys.Args_ReqTime, SystemClock.elapsedRealtime());
        AIKernelConfig r10 = DataHolder.INSTANCE.getConfig();
        if (r10 == null) goto L9;
        r1.putLong("_AppId", r10.getAppId());
        r1.putString("_PackageName", r10.getPackageName());
    L9:
        return r1;
    }

    public static final <T> Response<T> toBasicTypeResponse(Bundle r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new Response(r10.getInt("_EC", 0), r10.getString("_EI"), r10.get("_R"), r10.getBoolean("_IF", true), r10.getBoolean("_IT", false), toExtraResponse(r10), r10);
    }

    public static final <T> Response<T> toUserResponse(Bundle r10, Function2<? super Bundle, ? super String, ? extends T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "block");
        int r3 = r10.getInt("_EC", 0);
        String r4 = r10.getString("_EI");
        boolean r6 = r10.getBoolean("_IF", true);
        boolean r7 = r10.getBoolean("_IT", false);
        return new Response(r3, r4, r11.invoke(r10, "_R"), r6, r7, toExtraResponse(r10), r10);
    }

    public static final <T> Response<T> toNetResponse(Bundle r10, Function2<? super Bundle, ? super String, ? extends T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "block");
        int r3 = r10.getInt("_EC", 0);
        String r4 = r10.getString("_EI");
        boolean r6 = r10.getBoolean("_IF", true);
        boolean r7 = r10.getBoolean("_IT", false);
        return new Response(r3, r4, r11.invoke(r10, "_R"), r6, r7, toExtraResponse(r10), r10);
    }

    public static final JSONObject toExtraResponse(Bundle r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        JSONObject r0 = new JSONObject();
        r0.put(IdlKeys.Args_TraceId, r5.getString(IdlKeys.Args_TraceId, ""));
        r0.put(IdlKeys.Args_TraceEventKey, r5.getString(IdlKeys.Args_TraceEventKey, ""));
        r0.put(IdlKeys.Args_TraceEventArgs, r5.getString(IdlKeys.Args_TraceEventArgs, ""));
        r0.put("_UseCloud", r5.getBoolean("_UseCloud"));
        r0.put("_timeout", r5.getLong("_timeout"));
        long r1 = r5.getLong(IdlKeys.Args_ReqTime, -1);
        if (r1 <= 0) goto L5;
        r0.put(IdlKeys.Args_End2EndCost, SystemClock.elapsedRealtime() - r1);
    L5:
        return r0;
    }

    public static final Bundle toE2EDurationResponse(Bundle r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        long r0 = r4.getLong(IdlKeys.Args_ReqTime, -1);
        if (r0 <= 0) goto L5;
        r4.putLong(IdlKeys.Args_End2EndCost, SystemClock.elapsedRealtime() - r0);
    L5:
        return r4;
    }

    public static final Response<JSONObject> toJsonResult(Bundle r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r3 = r10.getInt("_EC", 0);
        String r4 = r10.getString("_EI");
        Bundle r0 = r10.getBundle("_R");
        if (r0 != null) goto L5;
        r0 = new Bundle();
    L5:
        Intrinsics.checkNotNullExpressionValue(r0, "getBundle(IdlKeys.Result)?: Bundle()");
        return new Response(r3, r4, bundle2json(r0), r10.getBoolean("_IF", true), r10.getBoolean("_IT", false), toExtraResponse(r10), r10);
    }

    public static final List<PackageResource> getPackageInfos(Bundle r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        r5.setClassLoader(PackageResource.class.getClassLoader());
        Parcelable[] r6 = r5.getParcelableArray(IdlKeys.Args_Pkgs);
        if (r6 == null) goto L11;
        ArrayList r0 = new ArrayList();
        int r1 = r6.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L16;
        Parcelable r3 = r6[r2];
        if ((r3 instanceof PackageResource) == false) goto L9;
        r0.add(r3);
    L9:
        r2 = r2 + 1;
        goto L5
    L16:
        return r0;
    L11:
        return null;
    }

    public static final int getErrorCode(Bundle r2) {
        if (r2 != null) goto L6;
        return 108;
    L6:
        return r2.getInt("_EC", 0);
    }

    public static final String getErrorMsg(Bundle r1) {
        if (r1 == null) goto L4;
        String r2 = r1.getString("_EI");
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
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (Intrinsics.areEqual(r2.getString("_CT"), "_CallGlobal") == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r2.getString("_M"), "_GetModel") == false) goto L7;
        return true;
    }

    public static final boolean isCallModel(Bundle r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return Intrinsics.areEqual(r1.getString("_CT"), "_CallModel");
    }

    public static final boolean isCallScene(Bundle r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return Intrinsics.areEqual(r1.getString("_CT"), "_CallScene");
    }

    public static final boolean isCallGlobal(Bundle r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return Intrinsics.areEqual(r1.getString("_CT"), "_CallGlobal");
    }

    public static final boolean isCallGlobalBiz(Bundle r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return Intrinsics.areEqual(r1.getString("_CT"), "_CallGlobalBiz");
    }

    public static final boolean isCallBiz(Bundle r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return Intrinsics.areEqual(r1.getString("_CT"), "_CallBiz");
    }

    public static final String getPackageName(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        String r3 = r2.getString("_PackageName", null);
        if (r3 != null) goto L6;
        return "";
    L6:
        return r3;
    }

    public static final String getAIKTraceId(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        String r3 = r2.getString(IdlKeys.Args_TraceId, "");
        Intrinsics.checkNotNullExpressionValue(r3, "this.getString(IdlKeys.Args_TraceId, \"\")");
        return r3;
    }

    public static final String getBizName(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        String r3 = r2.getString("_BizName", null);
        if (r3 != null) goto L6;
        return "";
    L6:
        return r3;
    }

    public static final long getSdkVer(Bundle r15) {
        Intrinsics.checkNotNullParameter(r15, "<this>");
        String r16 = r15.getString(IdlKeys.Args_SdkVer, "");
        Intrinsics.checkNotNullExpressionValue(r16, "sdkVer");
        String r17 = r16;
        List r0 = StringsKt.split$default(r17, new String[]{"-"}, false, 0, 6, null);
        if (r0.size() <= 1) goto L5;
        List r18 = CollectionsKt.toMutableList(StringsKt.split$default((CharSequence) r0.get(0), new String[]{LibrarianImpl.Constants.DOT}, false, 0, 6, null));
    L7:
        if (r18.size() == 3) goto L9;
        return -1;
    L9:
        Integer r1 = StringsKt.toIntOrNull((String) r18.get(0));
        Integer r2 = StringsKt.toIntOrNull((String) r18.get(1));
        Integer r19 = StringsKt.toIntOrNull((String) r18.get(2));
        if (r1 == null) goto L22;
        if (r2 == null) goto L23;
        if (r19 != null) goto L14;
        return -1;
    L14:
        if (new IntRange(0, 1000).contains(r1.intValue()) == true) goto L16;
        return -1;
    L16:
        if (new IntRange(0, 1000).contains(r2.intValue()) == true) goto L18;
        return -1;
    L18:
        if (new IntRange(0, 1000).contains(r19.intValue()) == true) goto L21;
        return -1;
    L21:
        return ((((long) r1.intValue()) * 1000000) + (((long) r2.intValue()) * 1000)) + ((long) r19.intValue());
    L23:
        return -1;
    L22:
        return -1;
    L5:
        r18 = StringsKt.split$default(r17, new String[]{LibrarianImpl.Constants.DOT}, false, 0, 6, null);
        goto L7
    }

    public static final Bundle setTaskIdRes(Bundle r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        r2.putInt("_EC", 1);
        r2.putBoolean("_IT", true);
        r2.putLong("_R", r3);
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

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Bundle setBasicTypeRes(Bundle r2, T r3, int r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        r2.putInt("_EC", r4);
        r2.putString("_EI", r5);
        boolean r0 = true;
        if (r4 != 1) goto L6;
        r0 = false;
    L6:
        r2.putBoolean("_IF", r0);
        if ((r3 instanceof Integer) == false) goto L10;
        r2.putInt("_R", ((Number) r3).intValue());
    L42:
        return r2;
    L10:
        if ((r3 instanceof int[]) == false) goto L13;
        r2.putIntArray("_R", (int[]) r3);
        goto L42
    L13:
        if ((r3 instanceof Float) == false) goto L16;
        r2.putFloat("_R", ((Number) r3).floatValue());
        goto L42
    L16:
        if ((r3 instanceof float[]) == false) goto L19;
        r2.putFloatArray("_R", (float[]) r3);
        goto L42
    L19:
        if ((r3 instanceof String) == false) goto L22;
        r2.putString("_R", (String) r3);
        goto L42
    L22:
        if ((r3 instanceof Byte) == false) goto L25;
        r2.putByte("_R", ((Number) r3).byteValue());
        goto L42
    L25:
        if ((r3 instanceof byte[]) == false) goto L28;
        r2.putByteArray("_R", (byte[]) r3);
        goto L42
    L28:
        if ((r3 instanceof Character) == false) goto L31;
        r2.putChar("_R", ((Character) r3).charValue());
        goto L42
    L31:
        if ((r3 instanceof char[]) == false) goto L34;
        r2.putCharArray("_R", (char[]) r3);
        goto L42
    L34:
        if ((r3 instanceof Boolean) == false) goto L37;
        r2.putBoolean("_R", ((Boolean) r3).booleanValue());
        goto L42
    L37:
        if ((r3 instanceof boolean[]) == false) goto L40;
        r2.putBooleanArray("_R", (boolean[]) r3);
        goto L42
    L40:
        if ((r3 instanceof JSONObject) == false) goto L42;
        r2.putBundle("_R", json2Bundle$default((JSONObject) r3, false, 2, null));
        goto L42
    }

    public static /* synthetic */ Bundle setResApply$default(Bundle r0, int r1, Function1 r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        return setResApply(r0, r1, r2);
    }

    public static final Bundle setResApply(Bundle r2, int r3, Function1<? super Bundle, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r4, "block");
        r2.putInt("_EC", r3);
        r2.putString("_EI", null);
        boolean r0 = true;
        if (r3 != 1) goto L6;
        r0 = false;
    L6:
        r2.putBoolean("_IF", r0);
        r4.invoke(r2);
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
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r3, "errInfo");
        r1.putInt("_EC", r2);
        r1.putString("_EI", r3);
        r1.putBoolean("_IF", r4);
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
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r3, "errInfo");
        r1.putInt("_EC", r2);
        r1.putString("_EI", r3);
        boolean r4 = true;
        if (r2 != 1) goto L6;
        r4 = false;
    L6:
        r1.putBoolean("_IF", r4);
        return r1;
    }

    public static /* synthetic */ Bundle setInvalidArg$default(Bundle r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = "invalid arguments.";
    L6:
        return setInvalidArg(r0, r1);
    }

    public static final Bundle setInvalidArg(Bundle r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "errInfo");
        setErr$default(r7, 101, r8, false, 4, null);
        return r7;
    }

    public static final Bundle setMethod(Bundle r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "name");
        r1.putString("_M", r2);
        return r1;
    }

    public static final String getMethod(Bundle r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.getString("_M");
    }

    public static /* synthetic */ boolean safeOnResult$default(AIKListener r0, Bundle r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = OK;
    L6:
        return safeOnResult(r0, r1);
    }

    public static final boolean safeOnResult(AIKListener r1, Bundle r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, ApmTrafficStats.TTNET_RESPONSE);
        r1.onResult(r2);     // Catch: Throwable -> L6
        return true;
    L6:
        th = move-exception;
        AIKLog.INSTANCE.e("TaskOnResult", String.valueOf(th.getMessage()));
        return false;
    }

    public static /* synthetic */ void err$default(AIKListener r0, int r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = IdlErrors.INSTANCE.toString(r1);
    L5:
        err(r0, r1, r2);
    }

    public static final void err(AIKListener r7, int r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r9, "errInfo");
        safeOnResult(r7, setErr$default(new Bundle(), r8, r9, false, 4, null));
    }

    public static final <T> String getLogId(Response<T> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Bundle r2 = r1.getSrc();
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.getString(ReportProtocal.KEY_LOG_ID);
    }

    public static final <T> String getTraceId(Response<T> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Bundle r2 = r1.getSrc();
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.getString(TracingConstants.KEY_TRACE_ID);
    }

    public static final Bundle safeUnparcel(Bundle r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r1 = Result.m803constructorimpl(Integer.valueOf(getErrorCode(r4)));     // Catch: Throwable -> L5
    L7:
        Throwable r2 = Result.m806exceptionOrNullimpl(r1);
        if (r2 == null) goto L10;
        AIKLog.INSTANCE.w("AIK-SDK-DataParser", "safeUnparcel exception: " + r2);
    L10:
        return r4;
    L5:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.m803constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
