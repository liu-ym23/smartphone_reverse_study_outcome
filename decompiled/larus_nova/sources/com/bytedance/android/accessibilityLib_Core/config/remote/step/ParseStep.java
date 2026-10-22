package com.bytedance.android.accessibilityLib_Core.config.remote.step;

import android.content.Context;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.android.accessibilityLib_Core.config.remote.dsl.ClassType;
import com.bytedance.android.accessibilityLib_Core.config.remote.dsl.ConfigType;
import com.bytedance.android.accessibilityLib_Core.config.remote.dsl.EventTextType;
import com.bytedance.android.accessibilityLib_Core.config.remote.dsl.EventType;
import com.bytedance.android.accessibilityLib_Core.config.remote.dsl.LabelMode;
import com.bytedance.android.accessibilityLib_Core.config.remote.dsl.SelectMode;
import com.bytedance.android.accessibilityLib_Core.config.remote.dsl.d;
import com.bytedance.android.accessibilityLib_Core.config.remote.dsl.e;
import com.bytedance.android.accessibilityLib_Core.config.remote.dsl.f;
import com.bytedance.android.accessibilityLib_Core.config.remote.dsl.g;
import com.bytedance.android.accessibilityLib_Core.config.remote.dsl.h;
import com.bytedance.android.accessibilityLib_Core.config.remote.repo.ConfigFileProviderMode;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.ButtonColorBean;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class ParseStep extends a<Boolean, List<? extends f>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<f> f38216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f38217b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f38218c;

    public ParseStep(b r100) {
        this.f38218c = r100;
    }

    public static h b(String r100) {
        if (r100 == null) goto L43;
        List r101 = StringsKt.split$default(StringsKt.trim(r100).toString(), new String[]{"-"}, false, 0, 6, null);
        int r102 = -1;
        if ((!r101.isEmpty()) == false) goto L11;
        String r103 = (String) ListProtector.get(r101, 0);
        if (r103 == null) goto L10;
        int r104 = CastIntegerProtector.parseInt(StringsKt.trim(r103).toString());
    L13:
        if (r101.size() <= 1) goto L19;
        String r105 = (String) ListProtector.get(r101, 1);
        if (r105 == null) goto L18;
        r102 = CastIntegerProtector.parseInt(StringsKt.trim(r105).toString());
        goto L19
    L18:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    L19:
        String r106 = "";
        if (r101.size() <= 2) goto L26;
        String r107 = (String) ListProtector.get(r101, 2);
        if (r107 == null) goto L25;
        String r108 = StringsKt.trim(r107).toString();
    L28:
        if (r101.size() <= 3) goto L44;
        String r109 = (String) ListProtector.get(r101, 3);
        if (r109 == null) goto L33;
        r106 = StringsKt.trim(r109).toString();
        goto L44
    L33:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    L44:
        return new h(r104, r102, r108, r106);
    L36:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L40;
        Context r110 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L40:
        return null;
    L25:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    L26:
        r108 = "";
        goto L28
    L10:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    L11:
        r104 = -1;
        goto L13
    L43:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    public static List c(JSONObject r110) {
    L44:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L49;
        Context r100 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L49:
        if (("parseEventConfigDsl error = " + e + ".message") == null) goto L51;
        Context r111 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L51:
        return null;
    L4:
        if (r110.has("event") == true) goto L6;
        return null;
    L6:
        JSONArray r112 = JSONObjectProtectorUtils.getJSONArray(r110, "event");     // Catch: Exception -> L44
        ArrayList r101 = new ArrayList();     // Catch: Exception -> L44
        int r102 = r112.length();     // Catch: Exception -> L44
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L43;
        JSONObject r104 = JSONArrayProtectorUtils.getJSONObject(r112, r103);     // Catch: Exception -> L44
        String r105 = JSONObjectProtectorUtils.getString(r104, "type");     // Catch: Exception -> L44
        EventType r106 = EventType.CLICK;     // Catch: Exception -> L44
        if (Intrinsics.areEqual(r105, r106.getValue()) == true) goto L22;
        r106 = EventType.CHECK;     // Catch: Exception -> L44
        if (Intrinsics.areEqual(r105, r106.getValue()) == true) goto L22;
        r106 = EventType.UNCHECK;     // Catch: Exception -> L44
        if (Intrinsics.areEqual(r105, r106.getValue()) == true) goto L22;
        r106 = EventType.MAP;     // Catch: Exception -> L44
        if (Intrinsics.areEqual(r105, r106.getValue()) == true) goto L22;
        r106 = EventType.UNKNOWN;     // Catch: Exception -> L44
    L22:
        if (r106 == EventType.UNKNOWN) goto L42;
        d r107 = e(r104);     // Catch: Exception -> L44
        if (r106 != EventType.MAP) goto L40;
        JSONObject r108 = JSONObjectProtectorUtils.getJSONObject(r104, "map");     // Catch: Exception -> L44
        Iterator<String> r109 = r108.keys();     // Catch: Exception -> L44
        LinkedHashMap r113 = new LinkedHashMap();     // Catch: Exception -> L44
    L28:
        if (r109.hasNext() == false) goto L41;
        String r114 = r109.next();     // Catch: Exception -> L44
        if (Intrinsics.areEqual(r114, EventTextType.NUMBER.getValue()) == true) goto L31;
        EventTextType r115 = EventTextType.DEFAULT;     // Catch: Exception -> L44
        if (Intrinsics.areEqual(r114, r115.getValue()) == false) goto L28;
        if (r108.has(r115.getValue()) == false) goto L28;
        JSONArray r116 = JSONObjectProtectorUtils.getJSONArray(r108, r115.getValue());     // Catch: Exception -> L44
        int r117 = r116.length();     // Catch: Exception -> L44
        int r118 = 0;
    L38:
        if (r118 >= r117) goto L28;
        JSONObject r119 = JSONArrayProtectorUtils.getJSONObject(r116, r118);     // Catch: Exception -> L44
        r113.put(JSONObjectProtectorUtils.getString(r119, "text"), e(r119));     // Catch: Exception -> L44
        r118 = r118 + 1;     // Catch: Exception -> L44
        goto L38
    L31:
        r113.put(r114, e(JSONObjectProtectorUtils.getJSONObject(r108, r114)));     // Catch: Exception -> L44
    L41:
        r101.add(new com.bytedance.android.accessibilityLib_Core.config.remote.dsl.b(r106, r107, r113));     // Catch: Exception -> L44
        goto L42
    L40:
        r113 = null;
    L42:
        r103 = r103 + 1;
        goto L7
    L43:
        return r101;
    }

    public static h[] d(JSONObject r100) {
    L21:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L25;
        Context r101 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L25:
        return null;
    L4:
        if (r100.has("hide_exclude") == true) goto L6;
        return null;
    L6:
        JSONArray r102 = JSONObjectProtectorUtils.getJSONArray(r100, "hide_exclude");     // Catch: Exception -> L21
        ArrayList r103 = new ArrayList();     // Catch: Exception -> L21
        int r104 = r102.length();     // Catch: Exception -> L21
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L13;
        h r106 = b(JSONArrayProtectorUtils.getString(r102, r105));     // Catch: Exception -> L21
        if (com.bytedance.android.accessibilityLib_Core.config.remote.dsl.a.b(r106) == false) goto L11;
        r103.add(r106);     // Catch: Exception -> L21
    L11:
        r105 = r105 + 1;     // Catch: Exception -> L21
        goto L7
    L13:
        if ((!r103.isEmpty()) == false) goto L20;
        Object[] r107 = r103.toArray(new h[0]);     // Catch: Exception -> L21
        if (r107 == null) goto L18;
        return (h[]) r107;
    L18:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Exception -> L21
    L20:
        return new h[0];
    }

    public static d e(JSONObject r110) {
        if (r110.has("label") == false) goto L5;
        JSONArray r111 = JSONObjectProtectorUtils.getJSONArray(r110, "label");
        ArrayList r100 = new ArrayList();
        int r101 = r111.length();
        int r102 = 0;
    L7:
        if (r102 >= r101) goto L31;
        JSONObject r103 = JSONArrayProtectorUtils.getJSONObject(r111, r102);
        ArrayList r104 = new ArrayList();
        if (r103.has("list") == false) goto L21;
        JSONArray r105 = JSONObjectProtectorUtils.getJSONArray(r103, "list");
        int r106 = r105.length();
        int r107 = 0;
    L11:
        if (r107 >= r106) goto L21;
        JSONObject r112 = JSONArrayProtectorUtils.getJSONObject(r105, r107);
        e r113 = null;
        if (r112.has("value") == false) goto L16;
        r113 = new e(JSONObjectProtectorUtils.getString(r112, "value"), true, null);
    L18:
        if (r113 == null) goto L20;
        r104.add(r113);
    L20:
        r107 = r107 + 1;
        goto L11
    L16:
        if (r112.has("aid") == false) goto L18;
        String r114 = JSONObjectProtectorUtils.getString(r112, "aid");
        r113 = new e(r114, false, b(r114));
    L21:
        ArrayList r108 = new ArrayList();
        if (r103.has("terms") == false) goto L29;
        JSONArray r109 = JSONObjectProtectorUtils.getJSONArray(r103, "terms");
        int r115 = r109.length();
        int r116 = 0;
    L24:
        if (r116 >= r115) goto L29;
        h r117 = f(JSONArrayProtectorUtils.getJSONObject(r109, r116), "aid");
        if (com.bytedance.android.accessibilityLib_Core.config.remote.dsl.a.b(r117) == false) goto L28;
        r108.add(r117);
    L28:
        r116 = r116 + 1;
    L29:
        r100.add(new com.bytedance.android.accessibilityLib_Core.config.remote.dsl.c(r104, r108));
        r102 = r102 + 1;
        goto L7
    L31:
        return new d(r100);
    L5:
        return new d(0);
    }

    public static h f(JSONObject r100, String r101) {
    L8:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L12;
        Context r102 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L12:
        return null;
    L4:
        if (r100.has(r101) == true) goto L6;
        return null;
    L6:
        return b(JSONObjectProtectorUtils.getString(r100, r101));
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public final Object a(Boolean r410, Continuation<? super List<f>> r411) {
        if ((r411 instanceof ParseStep$excute$1) == false) goto L7;
        ParseStep$excute$1 r100 = (ParseStep$excute$1) r411;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        int r105 = 0;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ParseStep r106 = (ParseStep) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L27:
        j6.b r107 = (j6.b) r102;
        if (r107 == null) goto L216;
        String r108 = r107.f497477a;
        r106.getClass();
        String r109 = "selectMode";
        String r110 = "label_mode";
        String r111 = SocialConstants.PARAM_APP_DESC;
        if (r108 == null) goto L216;
        JSONArray r112 = new JSONArray(r108);     // Catch: Exception -> L208
        if (("original jsonObject = " + r112) == null) goto L34;
        Context r113 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;     // Catch: Exception -> L208
    L34:
        ArrayList r114 = new ArrayList();     // Catch: Exception -> L208
        int r115 = r112.length();     // Catch: Exception -> L208
    L35:
        if (r105 >= r115) goto L207;
        JSONObject r116 = JSONArrayProtectorUtils.getJSONObject(r112, r105);     // Catch: Exception -> L208
        String r117 = JSONObjectProtectorUtils.getString(r116, "activity_id");     // Catch: Exception -> L208
        int r412 = r115;
        JSONArray r118 = JSONObjectProtectorUtils.getJSONArray(r116, "rules");     // Catch: Exception -> L208
        JSONArray r119 = r112;
        ArrayList r120 = new ArrayList();     // Catch: Exception -> L208
        ParseStep r121 = r106;
        int r122 = r118.length();     // Catch: Exception -> L205
        int r123 = r105;
        int r124 = 0;
    L39:
        if (r124 >= r122) goto L203;
        int r125 = r122;
        JSONObject r126 = JSONArrayProtectorUtils.getJSONObject(r118, r124);     // Catch: Exception -> L205
        h r210 = f(r126, "aid");     // Catch: Exception -> L205
    L47:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L52;
        Context r127 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;     // Catch: Exception -> L205
    L52:
        String r128 = "";
    L241:
    L59:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L64;
        Context r129 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;     // Catch: Exception -> L205
    L64:
        String r211 = "";
    L245:
    L71:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L75;
        Context r130 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;     // Catch: Exception -> L205
    L75:
        String r131 = "";
    L77:
        String r413 = r110;
        boolean r212 = r126.optBoolean("overwrite", false);     // Catch: Exception -> L80
    L243:
        if (r126.has(r109) == false) goto L91;
        String r132 = JSONObjectProtectorUtils.getString(r126, r109);     // Catch: Exception -> L110
    L92:
        if (r132 != null) goto L94;
        String r414 = r109;
    L247:
        SelectMode r133 = SelectMode.Default;     // Catch: Exception -> L108
    L107:
        SelectMode r213 = r133;
        boolean r214 = r126.optBoolean("disableClick", false);     // Catch: Exception -> L119
    L124:
        if (r131 != null) goto L127;
    L132:
        LabelMode r134 = LabelMode.Append;     // Catch: Exception -> L205
    L133:
        LabelMode r215 = r134;
        if (Intrinsics.areEqual(r126.optString("type", ""), "dialog") == false) goto L137;
        ConfigType r135 = ConfigType.Dialog;     // Catch: Exception -> L139
    L138:
        ConfigType r216 = r135;
        String r217 = r126.optString("panelTitle", "");     // Catch: Exception -> L147
    L249:
        boolean r310 = r126.optBoolean("verify", false);     // Catch: Exception -> L156
    L227:
    L170:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L174;
        Context r136 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;     // Catch: Exception -> L205
    L174:
        String r311 = "";
    L237:
        if (r126.has("classType") == false) goto L183;
        ClassType r137 = ClassType.Default;     // Catch: Exception -> L185
        String r138 = r126.optString("classType", r137.getValue());     // Catch: Exception -> L185
        ClassType r139 = ClassType.Button;     // Catch: Exception -> L185
        if (Intrinsics.areEqual(r138, r139.getValue()) == true) goto L182;
        r139 = ClassType.EditText;     // Catch: Exception -> L185
        if (Intrinsics.areEqual(r138, r139.getValue()) == true) goto L182;
    L190:
        ClassType r312 = r137;
    L191:
        boolean r140 = StringsKt.equals("disable", r128, true);     // Catch: Exception -> L205
        h r313 = f(r126, "before");     // Catch: Exception -> L205
        h r314 = f(r126, TeaEventTrack.ACTION_DRAMA_NEXT);     // Catch: Exception -> L205
        h[] r315 = d(r126);     // Catch: Exception -> L205
        d r316 = e(r126);     // Catch: Exception -> L205
        List r317 = c(r126);     // Catch: Exception -> L205
        if (com.bytedance.android.accessibilityLib_Core.config.remote.dsl.a.b(r210) == true) goto L194;
        Context r141 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;     // Catch: Exception -> L205
    L202:
        r124 = r124 + 1;     // Catch: Exception -> L205
        r122 = r125;
        r118 = r118;
        r111 = r111;
        r110 = r413;
        r109 = r414;
        goto L39
    L194:
        if (r140 == true) goto L196;
        boolean r218 = true;
    L197:
        g r142 = new g(r211, r210, r218, r212, r213, r214, r215, r216, r217, r315, r316, r313, r314, r317, r310, r311, r312);     // Catch: Exception -> L205
        if (("had paresd >>> viewConfigDsl = " + r142) == null) goto L200;
        Context r143 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;     // Catch: Exception -> L205
    L200:
        r120.add(r142);     // Catch: Exception -> L205
        goto L202
    L196:
        r218 = false;
    L182:
        r312 = r139;
        goto L191
    L183:
        r137 = ClassType.Default;     // Catch: Exception -> L185
        goto L190
    L185:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L189;
        Context r144 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;     // Catch: Exception -> L205
    L189:
        r137 = ClassType.Default;     // Catch: Exception -> L205
        goto L190
    L165:
        if (r126.has("onlyAppMode") == false) goto L168;
        String r145 = r126.optString("onlyAppMode", "");     // Catch: Exception -> L170
    L169:
        r311 = r145;
        goto L237
    L168:
        r145 = "";
    L156:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L163;
        Context r146 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;     // Catch: Exception -> L205
    L163:
        r310 = false;
        goto L227
    L147:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L151;
        Context r147 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;     // Catch: Exception -> L205
    L151:
        r217 = "";
        goto L249
    L137:
        r135 = ConfigType.Normal;     // Catch: Exception -> L139
        goto L138
    L139:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L143;
        Context r148 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;     // Catch: Exception -> L205
    L143:
        r135 = ConfigType.Normal;     // Catch: Exception -> L205
        goto L138
    L127:
        if (r131.hashCode() != 1094496948) goto L132;
        if (r131.equals("replace") == false) goto L132;
        r134 = LabelMode.Replace;     // Catch: Exception -> L205
        goto L133
    L119:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L123;
        Context r149 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;     // Catch: Exception -> L205
    L123:
        r214 = false;
    L108:
        e = e;
    L113:
        if (("Try exception occur " + e.getMessage()) == null) goto L115;
        Context r150 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;     // Catch: Exception -> L205
    L115:
        r133 = SelectMode.Default;     // Catch: Exception -> L205
        goto L107
    L94:
        int r151 = r132.hashCode();     // Catch: Exception -> L110
        r414 = r109;
        if (r151 == (-1298848381)) goto L104;
        if (r151 != 1671308008) goto L247;
        if (r132.equals("disable") == false) goto L247;
        r133 = SelectMode.Disable;     // Catch: Exception -> L108
        goto L107
    L104:
        if (r132.equals("enable") == false) goto L247;
        r133 = SelectMode.Enable;     // Catch: Exception -> L108
        goto L107
    L91:
        r132 = "";
    L110:
        e = e;
        r414 = r109;
    L80:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L87;
        Context r152 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;     // Catch: Exception -> L205
    L87:
        r212 = false;
        goto L243
    L66:
        if (r126.has(r110) == false) goto L69;
        String r153 = JSONObjectProtectorUtils.getString(r126, r110);     // Catch: Exception -> L71
    L70:
        r131 = r153;
        goto L77
    L69:
        r153 = "";
        goto L70
    L54:
        if (r126.has(r111) == false) goto L57;
        String r154 = r126.optString(r111, "");     // Catch: Exception -> L59
    L58:
        r211 = r154;
        goto L245
    L57:
        r154 = "";
        goto L58
    L42:
        if (r126.has(ButtonColorBean.StateFocus) == false) goto L45;
        String r155 = JSONObjectProtectorUtils.getString(r126, ButtonColorBean.StateFocus);     // Catch: Exception -> L47
    L46:
        r128 = r155;
        goto L241
    L45:
        r155 = "";
        goto L46
    L203:
        String r415 = r109;
        String r416 = r110;
        String r318 = r111;
        r114.add(new f(r117, r120));     // Catch: Exception -> L205
        r105 = r123 + 1;
        r115 = r412;
        r112 = r119;
        r106 = r121;
        r111 = r318;
        r110 = r416;
        r109 = r415;
    L205:
        e = e;
    L211:
        if (("Try exception occur " + e.getMessage()) == null) goto L214;
        Context r156 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L214:
        if (("parse config error , " + e.getMessage()) == null) goto L217;
        Context r157 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L217:
        r114 = null;
        ParseStep r158 = r121;
    L218:
        r158.f38216a = r114;
        if (("ParseStep excute parsedConfig = " + r158.f38216a) == null) goto L221;
        Context r159 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L221:
        r158.f38217b = true;
        return r158.f38216a;
    L207:
        r158 = r106;
    L208:
        e = e;
        r121 = r106;
    L216:
        r121 = r106;
        goto L217
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        if (this.f38217b == true) goto L17;
    L20:
        Context r160 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
        b r161 = this.f38218c;
        Boolean r162 = Boxing.boxBoolean(false);
        r100.L$0 = this;
        r100.label = 1;
        r161.getClass();
        j6.a r163 = r161.f38225a;
        if (r162 == null) goto L23;
        r162.booleanValue();
    L23:
        ConfigFileProviderMode r164 = ConfigFileProviderMode.LOCAL;
        r102 = r163.a();
        if (r102 != r103) goto L26;
        return r103;
    L26:
        r106 = this;
        goto L27
    L17:
        if (Intrinsics.areEqual(r410, Boxing.boxBoolean(false)) == false) goto L20;
        return this.f38216a;
    L7:
        r100 = new ParseStep$excute$1(this, r411);
        goto L8
    }
}
