package com.android.ttcjpaysdk.base.ktextension;

import android.graphics.Color;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.live.liveinteract.feedv2.feedview.MultiLinkCommonVoiceFeedPreview$nextDrawListeners$1;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ml.process.bl.MLConfigModel;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010%\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001aM\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u0001H\u00022\b\u0010\u0006\u001a\u0004\u0018\u0001H\u00042\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\u0010\t\u001ag\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003\"\b\b\u0002\u0010\n*\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u0001H\u00022\b\u0010\u0006\u001a\u0004\u0018\u0001H\u00042\b\u0010\u000b\u001a\u0004\u0018\u0001H\n2\u001e\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\u0010\r\u001aE\u0010\u000e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u000f\"\u0004\b\u0001\u0010\u00102\b\u0010\u0011\u001a\u0004\u0018\u0001H\u000f2\b\u0010\u0012\u001a\u0004\u0018\u0001H\u00102\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\u0010\t\u001a+\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u00152\u0012\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00190\u0018\"\u00020\u0019¢\u0006\u0002\u0010\u001a\u001a\u000e\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0016\u001a\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u00192\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0015\u001a\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u0016\u001a\u0010\u0010 \u001a\u00020\u00192\b\u0010!\u001a\u0004\u0018\u00010\u0016\u001a\u001c\u0010\"\u001a\u00020\u001f\"\u0004\b\u0000\u0010\u00022\u000e\u0010#\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010$\u001a\u0010\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00190$*\u00020\u0019\u001a\u001e\u0010&\u001a\u00020\u0001*\u00020\u001f2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010(\u001a\u0018\u0010)\u001a\u00020**\u00020*2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010+\u001a&\u0010,\u001a\u00020\u0001*\u0004\u0018\u00010\u00162\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010(H\u0086\bø\u0001\u0000\u001a/\u0010-\u001a\u0002H\u0002\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0004\u0018\u0001H\u00022\f\u0010.\u001a\b\u0012\u0004\u0012\u0002H\u00020+H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010/\u001a\u001a\u00100\u001a\u00020\u0016*\u0004\u0018\u00010\u00162\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00160+\u001a\u0014\u00102\u001a\u00020\u0016*\u0004\u0018\u00010\u00162\u0006\u00103\u001a\u00020\u0016\u001a\u0018\u00104\u001a\u00020**\u00020*2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010+\u001a\u0016\u00105\u001a\u00020\u0016*\u0004\u0018\u00010\u00162\b\b\u0002\u00106\u001a\u00020\u0016\u001a*\u00107\u001a\u00020\u0001*\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0003082\u0006\u0010\u0017\u001a\u00020\u00192\b\b\u0002\u00109\u001a\u00020*\u001a\u001a\u0010:\u001a\u00020\u0016*\u00020\u00192\u0006\u0010;\u001a\u00020\u00162\u0006\u0010.\u001a\u00020\u0016\u001a\u001e\u0010<\u001a\u00020\u0001*\u00020\u00192\b\u0010;\u001a\u0004\u0018\u00010\u00162\b\u0010=\u001a\u0004\u0018\u00010\u0003\u001a\u0014\u0010>\u001a\u00020\u0001*\u00020\u00192\b\u0010=\u001a\u0004\u0018\u00010\u0019\u001a\u0012\u0010?\u001a\u00020\u0019*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0015\u001a\n\u0010@\u001a\u00020A*\u00020A\u001a/\u0010B\u001a\b\u0012\u0004\u0012\u0002H\u00040C\"\u0004\b\u0000\u0010\u0004*\u0002H\u00042\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020*0(¢\u0006\u0002\u0010E\u001a1\u0010B\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u0004*\u00020*2\f\u0010F\u001a\b\u0012\u0004\u0012\u0002H\u00040+2\f\u0010G\u001a\b\u0012\u0004\u0012\u0002H\u00040+¢\u0006\u0002\u0010H\u001a%\u0010B\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u0004*\u00020*2\u0006\u0010I\u001a\u0002H\u00042\u0006\u0010J\u001a\u0002H\u0004¢\u0006\u0002\u0010K\u001a\u0016\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00030\u0015*\u00020\u0019\u001a\n\u0010M\u001a\u00020N*\u00020\u0016\u001a-\u0010O\u001a\u0016\u0012\u0004\u0012\u0002H\u0002\u0018\u00010Pj\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`Q\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u001fH\u0086\b\u001a\u0016\u0010R\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u0015*\u00020\u0019\u001a\n\u0010S\u001a\u00020T*\u00020\u0016\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006U"}, d2 = {"ifAllNotNull", "", ExifInterface.GPS_DIRECTION_TRUE, "", "R", "p1", "p2", "block", "Lkotlin/Function2;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", ExifInterface.LATITUDE_SOUTH, "p3", "Lkotlin/Function3;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)V", "ifNotNull", "T1", "T2", "value1", "value2", "bothNotNull", "merge", "", "", "jsonObject", "", "Lorg/json/JSONObject;", "([Lorg/json/JSONObject;)Ljava/util/Map;", "safeCreate", "jsonStr", "map", "safeCreateJsonArray", "Lorg/json/JSONArray;", "safeInstance", "string", "toJsonArray", "data", "", "findJsonObjectList", "forEach", "action", "Lkotlin/Function1;", "ifFalse", "", "Lkotlin/Function0;", "ifNotBlank", "ifNull", "defaultValue", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ifNullOrBlank", "fallback", "ifNullOrEmpty", "fallbackString", "ifTrue", SRStrategy.KEY_ORIGIN_RESOLUTION, "defaultStr", "putJson", "", "cover", "safeOptNonEmptyString", "key", "safePut", "value", "safePutAll", "safeToJson", "secondsToMilliseconds", "", MLConfigModel.MODEL_TYPE_TF, "Lcom/android/ttcjpaysdk/base/ktextension/CJBoolResult;", "predicate", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lcom/android/ttcjpaysdk/base/ktextension/CJBoolResult;", "trueBlock", "falseBlock", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "trueValue", "falseValue", "(ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "toAnyMap", "toColorInt", "Lcom/android/ttcjpaysdk/base/ktextension/ColorResult;", "toList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "toMap", "validJsonResult", "Lcom/android/ttcjpaysdk/base/ktextension/CJJsonValidResult;", "cj-host-service-api_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class KtSafeMethodExtensionKt {
    public static final long secondsToMilliseconds(long r100) {
        return r100 * ((long) 1000);
    }

    public static final <R> R tf(boolean r100, R r101, R r102) {
        if (r100 == false) goto L5;
        return r101;
    L5:
        return r102;
    }

    public static final List<JSONObject> findJsonObjectList(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ArrayList r101 = new ArrayList();
        Iterator<String> r102 = r100.keys();     // Catch: Exception -> L11
    L5:
        if (r102.hasNext() == false) goto L10;
        JSONObject r103 = r100.optJSONObject(r102.next());     // Catch: Exception -> L11
        if (r103 == null) goto L5;
        r101.add(r103);     // Catch: Exception -> L11
    L10:
        return r101;
    }

    public static final Map<String, String> merge(JSONObject... r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        List r101 = CollectionsKt.listOf(Arrays.copyOf(r100, r100.length));
        LinkedHashMap r102 = new LinkedHashMap();
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r102.putAll(toMap((JSONObject) r103.next()));
        goto L4
    L6:
        return r102;
    }

    public static final JSONObject safeCreate(String r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonStr");
        return new JSONObject(r100);
    L6:
        return new JSONObject();
    }

    public static final JSONArray safeCreateJsonArray(String r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonStr");
        return new JSONArray(r100);
    L6:
        return new JSONArray();
    }

    public static final JSONObject safeInstance(String r100) {
        return new JSONObject(r100);
    L5:
        return new JSONObject();
    }

    public static final JSONObject safeToJson(Map<?, ?> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new JSONObject(r100);
    L6:
        return new JSONObject();
    }

    public static final Map<String, Object> toAnyMap(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        LinkedHashMap r101 = new LinkedHashMap();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L11
        Iterator<String> r103 = r100.keys();     // Catch: Throwable -> L11
    L5:
        if (r103.hasNext() == false) goto L9;
        String r104 = r103.next();     // Catch: Throwable -> L11
        Object r105 = r100.opt(r104);     // Catch: Throwable -> L11
        if (r105 == null) goto L5;
        r101.put(r104, r105);     // Catch: Throwable -> L11
        goto L5
    L9:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        return r101;
    L11:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    public static final ColorResult toColorInt(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L12
        if (r100.length() <= 0) goto L6;
        boolean r102 = true;
    L7:
        if (r102 == false) goto L9;
        Integer r103 = Integer.valueOf(Color.parseColor(r100));     // Catch: Throwable -> L12
    L10:
        Object r104 = Result.m9449constructorimpl(new ColorResult(r103));     // Catch: Throwable -> L12
    L15:
        if (Result.m9452exceptionOrNullimpl(r104) == null) goto L19;
        r104 = new ColorResult(null);
    L19:
        return (ColorResult) r104;
    L9:
        r103 = null;
        goto L10
    L6:
        r102 = false;
    L12:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    public static final <T> JSONArray toJsonArray(List<? extends T> r100) {
        if (r100 == null) goto L4;
        JSONArray r101 = new JSONArray();
        int r102 = r100.size();     // Catch: Exception -> L11
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L10;
        r101.put(ListProtector.get(r100, r103));     // Catch: Exception -> L11
        r103 = r103 + 1;
        goto L7
    L10:
        return r101;
    L12:
        return new JSONArray();
    L4:
        return new JSONArray();
    }

    public static final /* synthetic */ <T> ArrayList<T> toList(JSONArray r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        MultiLinkCommonVoiceFeedPreview$nextDrawListeners$1 r101 = (ArrayList<T>) new ArrayList();
        int r102 = r100.length();     // Catch: Exception -> L10
        int r103 = 0;
    L4:
        if (r103 >= r102) goto L9;
        Object r104 = r100.opt(r103);     // Catch: Exception -> L10
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);     // Catch: Exception -> L10
        if ((r104 instanceof Object) == false) goto L8;
        r101.add(r104);     // Catch: Exception -> L10
    L8:
        r103 = r103 + 1;
        goto L4
    L9:
        return r101;
    L10:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static final Map<String, String> toMap(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<String> r102 = r100.keys();     // Catch: Exception -> L9
    L5:
        if (r102.hasNext() == false) goto L8;
        String r103 = r102.next();     // Catch: Exception -> L9
        r101.put(r103, r100.optString(r103));     // Catch: Exception -> L9
    L8:
        return r101;
    }

    public static final CJJsonValidResult validJsonResult(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        JSONObject r101 = new JSONObject();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L8
        JSONObject r103 = new JSONObject(r100);     // Catch: Throwable -> L8
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L6
        JSONObject r105 = r103;
    L10:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r104);
        if (r106 == null) goto L15;
        return new CJJsonValidResult(false, new JSONObject(), r106);
    L15:
        return new CJJsonValidResult(true, r105, null, 4, null);
    L6:
        th = th;
        r101 = r103;
    L9:
        Result.Companion r107 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        r105 = r101;
    L8:
        th = th;
        goto L9
    }

    public static final JSONObject safeCreate(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        return new JSONObject(r100);
    L5:
        return null;
    }

    public static final void forEach(JSONArray r100, Function1<? super String, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "action");
        int r102 = r100.length();     // Catch: Exception -> L7
        int r103 = 0;
    L4:
        if (r103 >= r102) goto L13;
        r101.invoke(r100.optString(r103));     // Catch: Exception -> L7
        r103 = r103 + 1;
        goto L4
    L13:
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    public static final boolean ifFalse(boolean r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "block");
        if (r100 == true) goto L5;
        r101.invoke();
    L5:
        return r100;
    }

    public static final void ifNotBlank(String r100, Function1<? super String, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "action");
        if (r100 != null) goto L5;
        return;
    L5:
        if ((!StringsKt.isBlank(r100)) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L12;
        r101.invoke(r100);
        return;
    }

    public static final <T> T ifNull(T r100, Function0<? extends T> r101) {
        Intrinsics.checkNotNullParameter(r101, "defaultValue");
        if (r100 == null) goto L5;
        return r100;
    L5:
        return r101.invoke();
    }

    public static final String ifNullOrBlank(String r100, Function0<String> r101) {
        Intrinsics.checkNotNullParameter(r101, "fallback");
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
        return r100;
    L11:
        return r101.invoke();
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r102 = false;
        goto L9
    }

    public static final String ifNullOrEmpty(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "fallbackString");
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
        return r100;
    L11:
        return r101;
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public static final boolean ifTrue(boolean r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "block");
        if (r100 == false) goto L5;
        r101.invoke();
    L5:
        return r100;
    }

    public static final String or(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "defaultStr");
        boolean r102 = false;
        if (r100 != null) goto L5;
    L7:
        if (r102 == true) goto L11;
        if (r100 == null) goto L11;
        return r100;
    L11:
        return r101;
    L5:
        if (StringsKt.isBlank(r100) != true) goto L7;
        r102 = true;
        goto L7
    }

    public static final void safePutAll(JSONObject r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 == null) goto L16;
        Iterator<String> r102 = r101.keys();     // Catch: Exception -> L9
    L6:
        if (r102.hasNext() == false) goto L17;
        String r103 = r102.next();     // Catch: Exception -> L9
        r100.put(r103, r101.opt(r103));     // Catch: Exception -> L9
        goto L6
    L17:
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static final <R> CJBoolResult<R> tf(R r100, Function1<? super R, Boolean> r101) {
        Intrinsics.checkNotNullParameter(r101, "predicate");
        return new CJBoolResult(r100, r101.invoke(r100).booleanValue());
    }

    public static final <T, R> void ifAllNotNull(T r100, R r101, Function2<? super T, ? super R, Unit> r102) {
        Intrinsics.checkNotNullParameter(r102, "block");
        if (r100 == null) goto L12;
        if (r101 == null) goto L13;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L7
        r102.invoke(r100, r101);     // Catch: Throwable -> L7
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L13:
        return;
    }

    public static final <T1, T2> void ifNotNull(T1 r100, T2 r101, Function2<? super T1, ? super T2, Unit> r102) {
        Intrinsics.checkNotNullParameter(r102, "bothNotNull");
        if (r100 == null) goto L7;
        if (r101 == null) goto L8;
        r102.invoke(r100, r101);
        return;
    L8:
        return;
    }

    public static final void putJson(Map<String, Object> r100, JSONObject r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "jsonObject");
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L13
        Iterator<String> r104 = r101.keys();     // Catch: Throwable -> L13
    L5:
        if (r104.hasNext() == false) goto L11;
        String r105 = r104.next();     // Catch: Throwable -> L13
        if (r102 == true) goto L10;
        if (r100.get(r105) != null) goto L5;
    L10:
        r100.put(r105, r101.opt(r105));     // Catch: Throwable -> L13
        goto L5
    L11:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public static final String safeOptNonEmptyString(JSONObject r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "defaultValue");
        String r103 = r100.optString(r101);     // Catch: Exception -> L14
        if (r103.length() <= 0) goto L6;
        boolean r104 = true;
    L7:
        if (r104 == true) goto L10;
        r103 = null;
    L10:
        if (r103 != null) goto L13;
        return r102;
    L13:
        return r103;
    L6:
        r104 = false;
    L18:
        return r102;
    }

    public static final void safePut(JSONObject r100, String r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 == null) goto L11;
        r100.put(r101, r102);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static final <R> R tf(boolean r100, Function0<? extends R> r101, Function0<? extends R> r102) {
        Intrinsics.checkNotNullParameter(r101, "trueBlock");
        Intrinsics.checkNotNullParameter(r102, "falseBlock");
        if (r100 == false) goto L6;
        return r101.invoke();
    L6:
        return r102.invoke();
    }

    public static final <T, R, S> void ifAllNotNull(T r100, R r101, S r102, Function3<? super T, ? super R, ? super S, Unit> r103) {
        Intrinsics.checkNotNullParameter(r103, "block");
        if (r100 == null) goto L13;
        if (r101 == null) goto L14;
        if (r102 == null) goto L15;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L8
        r103.invoke(r100, r101, r102);     // Catch: Throwable -> L8
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L15:
        return;
    L14:
        return;
    }

    public static /* synthetic */ String or$default(String r100, String r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = "";
    L6:
        return or(r100, r101);
    }

    public static /* synthetic */ void putJson$default(Map r100, JSONObject r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = true;
    L5:
        putJson(r100, r101, r102);
    }
}
