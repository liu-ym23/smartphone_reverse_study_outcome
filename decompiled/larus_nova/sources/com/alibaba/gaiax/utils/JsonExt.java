package com.alibaba.gaiax.utils;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\rJ\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\rJ\u000e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\rJ\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\rJ\u0016\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\rJ\u0016\u0010\u0017\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\rJ\u0016\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\rJ\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\rH\u0002J\u0016\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\rJ\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\rJ\u0018\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\rH\u0002J\u0016\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\rJ\u000e\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\rJ \u0010\"\u001a\u0004\u0018\u00010\u00012\u0006\u0010#\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020\u0004J'\u0010&\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00012\u0012\u0010'\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0(\"\u00020\r¢\u0006\u0002\u0010)J\u0016\u0010&\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\rJ\u0018\u0010*\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\rJ\u0010\u0010+\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\rH\u0002J\u0018\u0010,\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010-\u001a\u00020\u0004H\u0002J\u0019\u0010.\u001a\b\u0012\u0004\u0012\u00020\r0(2\u0006\u0010!\u001a\u00020\r¢\u0006\u0002\u0010/J\u001e\u00100\u001a\u0002012\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\r2\u0006\u00102\u001a\u00020\u0001J\u001e\u00103\u001a\u00020\u001d2\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\r2\u0006\u00102\u001a\u00020\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/alibaba/gaiax/utils/JsonExt;", "", "()V", "ARRAY_INDEX_NO", "", "ERROR_RESULT_DOUBLE", "", "ERROR_RESULT_FLOAT", "", "ERROR_RESULT_INT", "ERROR_RESULT_LONG", "", "GXEXTJSON", "", "getAnyExt", "source", "expression", "getArrayIndex", "arrayKey", "getArrayKey", "getBooleanExt", "", "getDoubleExt", "getFloatExt", "getIntExt", "getJSONArray2Ext", "Lorg/json/JSONArray;", "getJSONArrayExt", "getJSONObjectExt", "Lorg/json/JSONObject;", "getJSONObjectExt2", "getLongExt", "getNextKey", "key", "getObjFromArray", "src", "arrayIndexKey", "arrayIndex", "getStringExt", "keyParams", "", "(Ljava/lang/Object;[Ljava/lang/String;)Ljava/lang/String;", "getStringExtCanNull", "isArrayType", "matchArrayIndex", "result", "parserKey", "(Ljava/lang/String;)[Ljava/lang/String;", "setValueExt", "", "value", "setValueToCloneExt", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class JsonExt {
    public static final int ARRAY_INDEX_NO = -1;
    public static final double ERROR_RESULT_DOUBLE = -1.0d;
    public static final float ERROR_RESULT_FLOAT = -1.0f;
    public static final int ERROR_RESULT_INT = -1;
    public static final long ERROR_RESULT_LONG = -1;
    public static final String GXEXTJSON = "GxJsonExt";
    public static final JsonExt INSTANCE = null;

    static {
        INSTANCE = new JsonExt();
    }

    private JsonExt() {
    }

    private final boolean isArrayType(String r100) {
        if (r100.length() <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
    L10:
        return false;
    L8:
        if (StringsKt.contains$default(r100, "[", false, 2, null) == false) goto L10;
        return true;
    L5:
        r101 = false;
        goto L6
    }

    public final int getArrayIndex(String r100) {
        Intrinsics.checkNotNullParameter(r100, "arrayKey");
        if (isArrayType(r100) == true) goto L5;
        return -1;
    L5:
        if (GXExtJsonKt.access$getSArrayPattern$p() != null) goto L8;
        GXExtJsonKt.access$setSArrayPattern$p(PatternProtector.compile("(?<=\\[)(.+?)(?=\\])"));
    L8:
        return matchArrayIndex(r100, -1);
    }

    public final String getArrayKey(String r110) {
        Intrinsics.checkNotNullParameter(r110, "arrayKey");
        if (r110.length() <= 0) goto L5;
        boolean r100 = true;
    L7:
        if (r100 == false) goto L13;
        int r101 = StringsKt.indexOf$default(r110, "[", 0, false, 6, null);
        if (r101 >= 0) goto L12;
        return "";
    L12:
        return r110.substring(0, r101);
    L13:
        return "";
    L5:
        r100 = false;
        goto L7
    }

    public final String getNextKey(String r110) {
        Intrinsics.checkNotNullParameter(r110, "key");
        if (r110.length() <= 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L10;
        String[] r111 = (String[]) StringsKt.split$default(r110, new String[]{"."}, false, 0, 6, null).toArray(new String[0]);
        if (r111.length <= 1) goto L10;
        return r111[1];
    L10:
        return "";
    L5:
        r100 = false;
        goto L6
    }

    public final String[] parserKey(String r110) {
        Intrinsics.checkNotNullParameter(r110, "key");
        String[] r100 = new String[0];
        if (r110.length() <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L16;
        int r102 = StringsKt.indexOf$default(r110, ".", 0, false, 6, null);
        if (r102 == (-1)) goto L17;
        int r103 = r102 + 1;
        if (r103 >= r110.length()) goto L13;
        String[] r104 = {r110.substring(0, r102), r110.substring(r103)};
    L15:
        return r104;
    L13:
        r104 = new String[]{r110.substring(0, r102)};
        goto L15
    L17:
        return new String[]{r110};
    L16:
        return r100;
    L5:
        r101 = false;
        goto L6
    }

    private final JSONArray getJSONArray2Ext(Object r100, String r101) {
        String[] r102 = parserKey(StringsKt.trim(r101).toString());     // Catch: Exception -> L52
        boolean r103 = false;
        if (r102.length != 0) goto L5;
        boolean r104 = true;
    L7:
        if ((!r104) == false) goto L55;
        String r105 = r102[0];     // Catch: Exception -> L52
        if (r102.length < 2) goto L11;
        String r106 = r102[1];     // Catch: Exception -> L52
    L12:
        int r107 = getArrayIndex(r105);     // Catch: Exception -> L52
        if (r106 != null) goto L15;
    L31:
        if (r107 == (-1)) goto L33;
    L38:
        String r108 = getArrayKey(r105);     // Catch: Exception -> L52
        if ((r100 instanceof JSONObject) == false) goto L47;
        if (((JSONObject) r100).has(r108) == false) goto L55;
        JSONArray r109 = ((JSONObject) r100).optJSONArray(r108);     // Catch: Exception -> L52
        if (r109.length() <= r107) goto L55;
        return r109.optJSONArray(r107);
    L47:
        if ((r100 instanceof JSONArray) == false) goto L55;
        if (((JSONArray) r100).length() <= r107) goto L55;
        return ((JSONArray) r100).optJSONArray(r107);
    L33:
        if ((r100 instanceof JSONObject) == false) goto L38;
        if (((JSONObject) r100).has(r105) == false) goto L55;
        return ((JSONObject) r100).optJSONArray(r105);
    L15:
        if (r106.length() <= 0) goto L17;
        r103 = true;
    L17:
        if (r103 == false) goto L31;
        if (r107 != (-1)) goto L25;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type org.json.JSONObject");     // Catch: Exception -> L52
        Object r110 = ((JSONObject) r100).get(r105);     // Catch: Exception -> L52
        if ((r110 instanceof JSONObject) == true) goto L24;
        if ((r110 instanceof JSONArray) == false) goto L55;
    L24:
        return getJSONArray2Ext(r110, r106);
    L25:
        Object r111 = getObjFromArray(r100, r105, r107);     // Catch: Exception -> L52
        if ((r111 instanceof JSONObject) == true) goto L30;
        if ((r111 instanceof JSONArray) == false) goto L55;
    L30:
        return getJSONArray2Ext(r111, r106);
    L11:
        r106 = null;
    L55:
        return new JSONArray();
    L5:
        r104 = false;
    L52:
        e = move-exception;
        e.getMessage();
        goto L55
    }

    private final JSONObject getJSONObjectExt2(Object r100, String r101) {
        String[] r102 = parserKey(StringsKt.trim(r101).toString());     // Catch: Exception -> L52
        boolean r103 = false;
        if (r102.length != 0) goto L5;
        boolean r104 = true;
    L7:
        if ((!r104) == false) goto L55;
        String r105 = r102[0];     // Catch: Exception -> L52
        if (r102.length < 2) goto L11;
        String r106 = r102[1];     // Catch: Exception -> L52
    L12:
        int r107 = getArrayIndex(r105);     // Catch: Exception -> L52
        if (r106 != null) goto L15;
    L31:
        if (r107 == (-1)) goto L33;
    L38:
        String r108 = getArrayKey(r105);     // Catch: Exception -> L52
        if ((r100 instanceof JSONObject) == false) goto L47;
        if (((JSONObject) r100).has(r108) == false) goto L55;
        JSONArray r109 = ((JSONObject) r100).optJSONArray(r108);     // Catch: Exception -> L52
        if (r109.length() <= r107) goto L55;
        return r109.optJSONObject(r107);
    L47:
        if ((r100 instanceof JSONArray) == false) goto L55;
        if (((JSONArray) r100).length() <= r107) goto L55;
        return ((JSONArray) r100).optJSONObject(r107);
    L33:
        if ((r100 instanceof JSONObject) == false) goto L38;
        if (((JSONObject) r100).has(r105) == false) goto L55;
        return ((JSONObject) r100).optJSONObject(r105);
    L15:
        if (r106.length() <= 0) goto L17;
        r103 = true;
    L17:
        if (r103 == false) goto L31;
        if (r107 != (-1)) goto L25;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type org.json.JSONObject");     // Catch: Exception -> L52
        Object r110 = ((JSONObject) r100).get(r105);     // Catch: Exception -> L52
        if ((r110 instanceof JSONObject) == true) goto L24;
        if ((r110 instanceof JSONArray) == false) goto L55;
    L24:
        return getJSONObjectExt2(r110, r106);
    L25:
        Object r111 = getObjFromArray(r100, r105, r107);     // Catch: Exception -> L52
        if ((r111 instanceof JSONObject) == true) goto L30;
        if ((r111 instanceof JSONArray) == false) goto L55;
    L30:
        return getJSONObjectExt2(r111, r106);
    L11:
        r106 = null;
    L55:
        return new JSONObject();
    L5:
        r104 = false;
    L52:
        e = move-exception;
        e.getMessage();
        goto L55
    }

    private final int matchArrayIndex(String r100, int r101) {
        Pattern r102 = GXExtJsonKt.access$getSArrayPattern$p();     // Catch: Exception -> L11
        if (r102 == null) goto L5;
        Matcher r103 = r102.matcher(r100);     // Catch: Exception -> L11
    L6:
        if (r103 != null) goto L8;
        return r101;
    L8:
        if (r103.find() == false) goto L17;
        return CastIntegerProtector.parseInt(r103.group());
    L17:
        return r101;
    L5:
        r103 = null;
    L11:
        e = move-exception;
        e.getMessage();
        return r101;
    }

    public final Object getAnyExt(Object r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "expression");
        String[] r102 = parserKey(StringsKt.trim(r101).toString());     // Catch: Exception -> L53
        boolean r103 = false;
        if (r102.length != 0) goto L6;
        boolean r104 = true;
    L8:
        if ((!r104) == false) goto L55;
        String r105 = r102[0];     // Catch: Exception -> L53
        if (r102.length < 2) goto L12;
        String r106 = r102[1];     // Catch: Exception -> L53
    L13:
        int r107 = getArrayIndex(r105);     // Catch: Exception -> L53
        if (r106 != null) goto L16;
    L32:
        if (r107 == (-1)) goto L34;
    L39:
        String r108 = getArrayKey(r105);     // Catch: Exception -> L53
        if ((r100 instanceof JSONObject) == false) goto L48;
        if (((JSONObject) r100).has(r108) == false) goto L55;
        JSONArray r109 = ((JSONObject) r100).optJSONArray(r108);     // Catch: Exception -> L53
        if (r109.length() <= r107) goto L55;
        return r109.get(r107);
    L48:
        if ((r100 instanceof JSONArray) == false) goto L55;
        if (((JSONArray) r100).length() <= r107) goto L55;
        return ((JSONArray) r100).get(r107);
    L34:
        if ((r100 instanceof JSONObject) == false) goto L39;
        if (((JSONObject) r100).has(r105) == false) goto L55;
        return ((JSONObject) r100).opt(r105);
    L16:
        if (r106.length() <= 0) goto L18;
        r103 = true;
    L18:
        if (r103 == false) goto L32;
        if (r107 != (-1)) goto L26;
        Object r110 = ((JSONObject) r100).get(r105);     // Catch: Exception -> L53
        if ((r110 instanceof JSONObject) == true) goto L25;
        if ((r110 instanceof JSONArray) == false) goto L55;
    L25:
        return getAnyExt(r110, r106);
    L26:
        Object r111 = getObjFromArray(r100, r105, r107);     // Catch: Exception -> L53
        if ((r111 instanceof JSONObject) == true) goto L31;
        if ((r111 instanceof JSONArray) == false) goto L55;
    L31:
        return getAnyExt(r111, r106);
    L12:
        r106 = null;
    L55:
        return null;
    L6:
        r104 = false;
    L53:
        e = move-exception;
        e.getMessage();
        goto L55
    }

    public final boolean getBooleanExt(Object r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "expression");
        return StringsKt.equals("true", getStringExt(r100, r101), true);
    }

    public final double getDoubleExt(Object r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "expression");
        String r102 = getStringExt(r100, r101);
    L10:
        e = move-exception;
        e.getMessage();
        return -1.0d;
    L4:
        if (r102.length() <= 0) goto L6;
        boolean r103 = true;
    L7:
        if (r103 == false) goto L15;
        return CastDoubleProtector.parseDouble(r102);
    L15:
        return -1.0d;
    L6:
        r103 = false;
        goto L7
    }

    public final float getFloatExt(Object r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "expression");
        String r102 = getStringExt(r100, r101);
    L10:
        e = move-exception;
        e.getMessage();
        return -1.0f;
    L4:
        if (r102.length() <= 0) goto L6;
        boolean r103 = true;
    L7:
        if (r103 == false) goto L15;
        return CastFloatProtector.parseFloat(r102);
    L15:
        return -1.0f;
    L6:
        r103 = false;
        goto L7
    }

    public final int getIntExt(Object r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "expression");
        String r102 = getStringExt(r100, r101);
    L10:
        e = move-exception;
        e.getMessage();
        return -1;
    L4:
        if (r102.length() <= 0) goto L6;
        boolean r103 = true;
    L7:
        if (r103 == false) goto L15;
        return CastIntegerProtector.parseInt(r102);
    L15:
        return -1;
    L6:
        r103 = false;
        goto L7
    }

    public final JSONArray getJSONArrayExt(Object r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "expression");
        return getJSONArray2Ext(r100, r101);
    }

    public final JSONObject getJSONObjectExt(Object r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "expression");
        return getJSONObjectExt2(r100, r101);
    }

    public final long getLongExt(Object r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "expression");
        String r102 = getStringExt(r100, r101);
    L10:
        e = move-exception;
        e.getMessage();
        return -1;
    L4:
        if (r102.length() <= 0) goto L6;
        boolean r103 = true;
    L7:
        if (r103 == false) goto L15;
        return CastLongProtector.parseLong(r102);
    L15:
        return -1;
    L6:
        r103 = false;
        goto L7
    }

    public final String getStringExt(Object r100, String... r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "keyParams");
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L10;
        String r104 = r101[r103];
        if (TextUtils.isEmpty(r104) == true) goto L9;
        String r105 = getStringExt(r100, r104);
        if (TextUtils.isEmpty(r105) == true) goto L9;
        return r105;
    L9:
        r103 = r103 + 1;
        goto L3
    L10:
        return "";
    }

    public final String getStringExtCanNull(Object r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "expression");
        String[] r102 = parserKey(StringsKt.trim(r101).toString());     // Catch: Exception -> L53
        boolean r103 = false;
        if (r102.length != 0) goto L6;
        boolean r104 = true;
    L8:
        if ((!r104) == false) goto L55;
        String r105 = r102[0];     // Catch: Exception -> L53
        if (r102.length < 2) goto L12;
        String r106 = r102[1];     // Catch: Exception -> L53
    L13:
        int r107 = getArrayIndex(r105);     // Catch: Exception -> L53
        if (r106 != null) goto L16;
    L32:
        if (r107 == (-1)) goto L34;
    L39:
        String r108 = getArrayKey(r105);     // Catch: Exception -> L53
        if ((r100 instanceof JSONObject) == false) goto L48;
        if (((JSONObject) r100).has(r108) == false) goto L55;
        JSONArray r109 = ((JSONObject) r100).optJSONArray(r108);     // Catch: Exception -> L53
        if (r109.length() <= r107) goto L55;
        return r109.optString(r107, null);
    L48:
        if ((r100 instanceof JSONArray) == false) goto L55;
        if (((JSONArray) r100).length() <= r107) goto L55;
        return ((JSONArray) r100).optString(r107, null);
    L34:
        if ((r100 instanceof JSONObject) == false) goto L39;
        if (((JSONObject) r100).has(r105) == false) goto L55;
        return ((JSONObject) r100).optString(r105, null);
    L16:
        if (r106.length() <= 0) goto L18;
        r103 = true;
    L18:
        if (r103 == false) goto L32;
        if (r107 != (-1)) goto L26;
        Object r110 = ((JSONObject) r100).get(r105);     // Catch: Exception -> L53
        if ((r110 instanceof JSONObject) == true) goto L25;
        if ((r110 instanceof JSONArray) == false) goto L55;
    L25:
        return getStringExtCanNull(r110, r106);
    L26:
        Object r111 = getObjFromArray(r100, r105, r107);     // Catch: Exception -> L53
        if ((r111 instanceof JSONObject) == true) goto L31;
        if ((r111 instanceof JSONArray) == false) goto L55;
    L31:
        return getStringExtCanNull(r111, r106);
    L12:
        r106 = null;
    L55:
        return null;
    L6:
        r104 = false;
    L53:
        e = move-exception;
        e.getMessage();
        goto L55
    }

    public final String getStringExt(Object r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "expression");
        String r102 = getStringExtCanNull(r100, r101);
        if (r102 != null) goto L6;
        return "";
    L6:
        return r102;
    }

    public final Object getObjFromArray(Object r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "src");
        Intrinsics.checkNotNullParameter(r101, "arrayIndexKey");
        String r103 = getArrayKey(r101);
        if ((r100 instanceof JSONObject) == false) goto L10;
        JSONObject r104 = (JSONObject) r100;
        if (r104.has(r103) == false) goto L14;
        JSONArray r105 = r104.optJSONArray(r103);
        if (r105.length() <= r102) goto L14;
        return r105.get(r102);
    L14:
        return null;
    L10:
        if ((r100 instanceof JSONArray) == false) goto L14;
        JSONArray r106 = (JSONArray) r100;
        if (r106.length() <= r102) goto L14;
        return r106.get(r102);
    }

    public final void setValueExt(Object r100, String r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "expression");
        Intrinsics.checkNotNullParameter(r102, "value");
        String[] r103 = parserKey(r101);     // Catch: Exception -> L45
        boolean r104 = false;
        if (r103.length != 0) goto L6;
        boolean r105 = true;
    L8:
        if ((!r105) == false) goto L49;
        String r106 = r103[0];     // Catch: Exception -> L45
        if (r103.length < 2) goto L12;
        String r107 = r103[1];     // Catch: Exception -> L45
    L13:
        int r108 = getArrayIndex(r106);     // Catch: Exception -> L45
        if (r107 != null) goto L16;
    L32:
        if (r108 == (-1)) goto L34;
    L36:
        String r109 = getArrayKey(r106);     // Catch: Exception -> L45
        if ((r100 instanceof JSONObject) == false) goto L42;
        if (((JSONObject) r100).has(r109) == false) goto L56;
        ((JSONObject) r100).optJSONArray(r109).put(r108, r102);     // Catch: Exception -> L45
        return;
    L56:
        return;
    L42:
        if ((r100 instanceof JSONArray) == false) goto L58;
        ((JSONArray) r100).put(r108, r102);     // Catch: Exception -> L45
        return;
    L58:
        return;
    L34:
        if ((r100 instanceof JSONObject) == false) goto L36;
        ((JSONObject) r100).put(r106, r102);     // Catch: Exception -> L45
        return;
    L16:
        if (r107.length() <= 0) goto L18;
        r104 = true;
    L18:
        if (r104 == false) goto L32;
        if (r108 == (-1)) goto L21;
        Object r110 = getObjFromArray(r100, r106, r108);     // Catch: Exception -> L45
        if ((r110 instanceof JSONObject) == false) goto L30;
    L31:
        setValueExt(r110, r107, r102);     // Catch: Exception -> L45
        return;
    L30:
        if ((r110 instanceof JSONArray) == true) goto L31;
        return;
    L21:
        if ((r100 instanceof JSONObject) == false) goto L50;
        Object r111 = ((JSONObject) r100).opt(r106);     // Catch: Exception -> L45
        if ((r111 instanceof JSONObject) == false) goto L25;
    L26:
        setValueExt(r111, r107, r102);     // Catch: Exception -> L45
        return;
    L25:
        if ((r111 instanceof JSONArray) == true) goto L26;
        return;
    L50:
        return;
    L12:
        r107 = null;
        goto L13
    L49:
        return;
    L6:
        r105 = false;
    L45:
        e = move-exception;
        e.getMessage();
    }

    public final JSONObject setValueToCloneExt(Object r100, String r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "expression");
        Intrinsics.checkNotNullParameter(r102, "value");
        JSONObject r103 = new JSONObject(((JSONObject) r100).toString());     // Catch: Exception -> L5
        setValueExt(r103, r101, r102);     // Catch: Exception -> L5
        return r103;
    L5:
        e = move-exception;
        e.getMessage();
        return new JSONObject();
    }
}
