package c8;

import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.lynx.jsbridge.Arguments;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableMapKeySetIterator;
import com.lynx.react.bridge.ReadableType;
import com.lynx.react.bridge.WritableArray;
import com.lynx.react.bridge.WritableMap;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: c8.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0412a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f22691a = null;

        static {
            int[] r100 = new int[ReadableType.values().length];
            r100[ReadableType.Boolean.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r100[ReadableType.Long.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r100[ReadableType.Number.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[ReadableType.String.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[ReadableType.Map.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r100[ReadableType.Array.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r100[ReadableType.Null.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            f22691a = r100;
        }
    }

    public static final JSONArray a(ReadableArray r100) throws JSONException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        JSONArray r101 = new JSONArray();
        int r102 = r100.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L18;
        ReadableType r104 = r100.getType(r103);
        if (r104 != null) goto L7;
        int r105 = -1;
    L8:
        switch(r105) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            default: goto L17;
        };
    L10:
        r101.put(JSONObject.NULL);
        goto L17
    L11:
        r101.put(a(r100.getArray(r103)));
        goto L17
    L12:
        r101.put(b(r100.getMap(r103)));
        goto L17
    L13:
        r101.put(r100.getString(r103));
        goto L17
    L14:
        r101.put(r100.getDouble(r103));
        goto L17
    L15:
        r101.put(r100.getLong(r103));
        goto L17
    L16:
        r101.put(r100.getBoolean(r103));
    L17:
        r103 = r103 + 1;
        goto L3
    L7:
        r105 = C0412a.f22691a[r104.ordinal()];
        goto L8
    L18:
        return r101;
    }

    public static final JSONObject b(ReadableMap r100) throws JSONException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        JSONObject r101 = new JSONObject();
        ReadableMapKeySetIterator r102 = r100.keySetIterator();
    L4:
        if (r102.hasNextKey() == false) goto L18;
        String r103 = r102.nextKey();
        ReadableType r104 = r100.getType(r103);
        if (r104 != null) goto L8;
        int r105 = -1;
    L9:
        switch(r105) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            default: goto L4;
        };
    L11:
        r101.put(r103, JSONObject.NULL);
        goto L4
    L12:
        r101.put(r103, a(r100.getArray(r103)));
        goto L4
    L13:
        r101.put(r103, b(r100.getMap(r103)));
        goto L4
    L14:
        r101.put(r103, r100.getString(r103));
        goto L4
    L15:
        r101.put(r103, r100.getDouble(r103));
        goto L4
    L16:
        r101.put(r103, r100.getLong(r103));
        goto L4
    L17:
        r101.put(r103, r100.getBoolean(r103));
        goto L4
    L8:
        r105 = C0412a.f22691a[r104.ordinal()];
        goto L9
    L18:
        return r101;
    }

    public static final WritableArray c(JSONArray r100) throws JSONException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        WritableArray r101 = Arguments.createArray();
        int r102 = r100.length();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L37;
        Object r104 = r100.opt(r103);
        if ((r104 instanceof Float) == false) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == false) goto L11;
        r101.pushDouble(JSONArrayProtectorUtils.getDouble(r100, r103));
    L36:
        r103 = r103 + 1;
        goto L3
    L11:
        if ((r104 instanceof Long) == false) goto L19;
        long r106 = JSONArrayProtectorUtils.getLong(r100, r103);
        if (r106 <= Integer.MAX_VALUE) goto L15;
    L17:
        r101.pushString(String.valueOf(r106));
        goto L36
    L15:
        if (r106 < Integer.MIN_VALUE) goto L17;
        r101.pushInt((int) r106);
        goto L36
    L19:
        if ((r104 instanceof Number) == false) goto L22;
        r101.pushInt(JSONArrayProtectorUtils.getInt(r100, r103));
        goto L36
    L22:
        if ((r104 instanceof String) == false) goto L25;
        r101.pushString(JSONArrayProtectorUtils.getString(r100, r103));
        goto L36
    L25:
        if ((r104 instanceof Boolean) == false) goto L28;
        r101.pushBoolean(JSONArrayProtectorUtils.getBoolean(r100, r103));
        goto L36
    L28:
        if ((r104 instanceof JSONObject) == false) goto L31;
        r101.pushMap(d(JSONArrayProtectorUtils.getJSONObject(r100, r103)));
        goto L36
    L31:
        if ((r104 instanceof JSONArray) == false) goto L34;
        r101.pushArray(c(JSONArrayProtectorUtils.getJSONArray(r100, r103)));
        goto L36
    L34:
        if (Intrinsics.areEqual(r104, JSONObject.NULL) == false) goto L36;
        r101.pushNull();
        goto L36
    L7:
        r105 = r104 instanceof Double;
        goto L8
    L37:
        return r101;
    }

    public static final WritableMap d(JSONObject r100) throws JSONException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        WritableMap r101 = Arguments.createMap();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L37;
        String r103 = r102.next();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.String");
        String r104 = r103;
        Object r105 = r100.opt(r104);
        if ((r105 instanceof Float) == false) goto L8;
        boolean r106 = true;
    L9:
        if (r106 == true) goto L10;
        if ((r105 instanceof Long) == true) goto L13;
        if ((r105 instanceof Number) == true) goto L21;
        if ((r105 instanceof String) == true) goto L24;
        if ((r105 instanceof Boolean) == true) goto L27;
        if ((r105 instanceof JSONObject) == true) goto L30;
        if ((r105 instanceof JSONArray) == true) goto L33;
        if (Intrinsics.areEqual(r105, JSONObject.NULL) == false) goto L4;
        r101.putNull(r104);
        goto L4
    L33:
        r101.putArray(r104, c(JSONObjectProtectorUtils.getJSONArray(r100, r104)));
        goto L4
    L30:
        r101.putMap(r104, d(JSONObjectProtectorUtils.getJSONObject(r100, r104)));
        goto L4
    L27:
        r101.putBoolean(r104, JSONObjectProtectorUtils.getBoolean(r100, r104));
        goto L4
    L24:
        r101.putString(r104, JSONObjectProtectorUtils.getString(r100, r104));
        goto L4
    L21:
        r101.putInt(r104, JSONObjectProtectorUtils.getInt(r100, r104));
        goto L4
    L13:
        long r107 = JSONObjectProtectorUtils.getLong(r100, r104);
        if (r107 > Integer.MAX_VALUE) goto L18;
        if (r107 < Integer.MIN_VALUE) goto L18;
        r101.putInt(r104, (int) r107);
    L18:
        r101.putString(r104, String.valueOf(r107));
        goto L4
    L10:
        r101.putDouble(r104, JSONObjectProtectorUtils.getDouble(r100, r104));
        goto L4
    L8:
        r106 = r105 instanceof Double;
        goto L9
    L37:
        return r101;
    }
}
