package com.stepos.ailauncher.task.space;

import Ua.C1056g;
import Ua.C1060i;
import Ua.J;
import Z8.C1173v;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.foundation.account.AccountInfo;
import com.stepos.ailauncher.taskstore.provider.c;
import com.stepos.ame.sdk.SkillStoreKt;
import e9.InterfaceC4014c;
import eb.InterfaceC4021a;
import h8.C4148a;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import o6.C5009a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n¢\u0006\u0004\b\u0017\u0010\u0015J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0086@¢\u0006\u0004\b\u0018\u0010\u0019J7\u0010\u001f\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001b2\u0018\b\u0002\u0010\u001e\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\f\u0018\u00010\u001d¢\u0006\u0004\b\u001f\u0010 J$\u0010\"\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0018\u00010!H\u0086@¢\u0006\u0004\b\"\u0010\u0019J\"\u0010$\u001a\u0004\u0018\u00010\n2\u0006\u0010#\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nH\u0086@¢\u0006\u0004\b$\u0010%J.\u0010'\u001a\u00020\u00072\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\n0\u00102\u0006\u0010#\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nH\u0086@¢\u0006\u0004\b'\u0010(J6\u0010*\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010)2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\n0\u0010H\u0086@¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\nH\u0002¢\u0006\u0004\b,\u0010-J\u0017\u0010/\u001a\u00020\f2\u0006\u0010.\u001a\u00020\u0004H\u0002¢\u0006\u0004\b/\u00100J\u001f\u00103\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u00102\u001a\u000201H\u0002¢\u0006\u0004\b3\u00104J\u0011\u00105\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b5\u0010-J\u001d\u00106\u001a\b\u0012\u0004\u0012\u00020\n0\u00102\u0006\u0010\u000f\u001a\u00020\nH\u0002¢\u0006\u0004\b6\u0010\u0013J\u0017\u00107\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0002¢\u0006\u0004\b7\u0010\u0015J\u0017\u00108\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0002¢\u0006\u0004\b8\u0010\u0015J\u0019\u0010:\u001a\u0004\u0018\u00010\n2\u0006\u00109\u001a\u000201H\u0002¢\u0006\u0004\b:\u0010;J+\u0010>\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\n2\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020<0\u001dH\u0002¢\u0006\u0004\b>\u0010?J'\u0010A\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010@\u001a\u00020\n2\u0006\u0010#\u001a\u00020\nH\u0002¢\u0006\u0004\bA\u0010BJ'\u0010C\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010@\u001a\u00020\n2\u0006\u0010#\u001a\u00020\nH\u0002¢\u0006\u0004\bC\u0010BJ%\u0010D\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\n2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\n0)H\u0002¢\u0006\u0004\bD\u0010EJ\"\u0010F\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001bH\u0082@¢\u0006\u0004\bF\u0010GJ5\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\u0010H\u001a\u0004\u0018\u00010<2\u0006\u0010I\u001a\u00020\n2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\n0\u0010H\u0002¢\u0006\u0004\bK\u0010LR\u0014\u0010M\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\bM\u0010NR\u0014\u0010P\u001a\u00020O8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u0014\u0010R\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\bR\u0010NR\u0014\u0010S\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\bS\u0010NR\u0014\u0010T\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\bT\u0010NR\u0014\u0010V\u001a\u00020U8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u0014\u0010Y\u001a\u00020X8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u0014\u0010\\\u001a\u00020[8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R\u0014\u0010^\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b^\u0010NR\u0014\u0010_\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b_\u0010NR\u0014\u0010`\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b`\u0010NR\u001d\u0010a\u001a\b\u0012\u0004\u0012\u00020\n0\u00108\u0006¢\u0006\f\n\u0004\ba\u0010b\u001a\u0004\bc\u0010dR\u001d\u0010e\u001a\b\u0012\u0004\u0012\u00020\n0\u00108\u0006¢\u0006\f\n\u0004\be\u0010b\u001a\u0004\bf\u0010dR\u001d\u0010g\u001a\b\u0012\u0004\u0012\u00020\n0\u00108\u0006¢\u0006\f\n\u0004\bg\u0010b\u001a\u0004\bh\u0010dR\u001a\u0010i\u001a\b\u0012\u0004\u0012\u00020\n0)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010j¨\u0006k"}, d2 = {"Lcom/stepos/ailauncher/task/space/MemorySettingApi;", "", "<init>", "()V", "Lcom/stepos/ailauncher/task/space/t0;", "J", "()Lcom/stepos/ailauncher/task/space/t0;", "", "R", "()Z", "", "uid", "LY8/t;", "B", "(Ljava/lang/String;)V", "tabType", "", "Lcom/stepos/ailauncher/task/space/h0;", "I", "(Ljava/lang/String;)Ljava/util/List;", "X", "(Ljava/lang/String;)Ljava/lang/String;", "memoryName", ExifInterface.LATITUDE_SOUTH, "L", "(Le9/c;)Ljava/lang/Object;", x5.d.EXTRA_ENABLED, "", "expectedVersion", "Lkotlin/Function1;", "onResult", "G", "(ZILp9/l;)V", "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "s", "(Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "memoryIds", "F", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "", ExifInterface.LONGITUDE_EAST, "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Le9/c;)Ljava/lang/Object;", "H", "()Ljava/lang/String;", VoiceWakeupReceiver.EXTRA_STATE, "y", "(Lcom/stepos/ailauncher/task/space/t0;)V", "Lorg/json/JSONObject;", "card", "x", "(Ljava/lang/String;Lorg/json/JSONObject;)V", "D", "P", "Q", "K", "obj", ExifInterface.LONGITUDE_WEST, "(Lorg/json/JSONObject;)Ljava/lang/String;", "Lorg/json/JSONArray;", "transform", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/lang/String;Lp9/l;)V", "memoryId", "t", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "z", "v", "(Ljava/lang/String;Ljava/util/Set;)V", "Y", "(ZILe9/c;)Ljava/lang/Object;", "array", "prefix", "persistentKeys", "U", "(Lorg/json/JSONArray;Ljava/lang/String;Ljava/util/List;)Ljava/util/List;", "TAG", "Ljava/lang/String;", "Ltb/x;", "JSON_MEDIA_TYPE", "Ltb/x;", "KEY_MEMORY_SHARE_ENABLED", "KEY_MEMORY_SHARE_VERSION", "KEY_MEMORY_CACHE", "Lcom/stepos/ailauncher/task/space/k0;", "memoryQueryGuard", "Lcom/stepos/ailauncher/task/space/k0;", "Leb/a;", "updateMutex", "Leb/a;", "LUa/M;", "processScope", "LUa/M;", "TAB_ABOUT_ME", "TAB_COMMUNICATION", "TAB_MEMO", "PERSISTENT_KEYS_USER", "Ljava/util/List;", "O", "()Ljava/util/List;", "PERSISTENT_KEYS_AGENT", "M", "PERSISTENT_KEYS_FACT", "N", "RESERVED_JSON_KEYS", "Ljava/util/Set;", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MemorySettingApi {
    private static final String KEY_MEMORY_CACHE = "memory_items_cache_";
    private static final String KEY_MEMORY_SHARE_ENABLED = "memory_setting_share_enabled";
    private static final String KEY_MEMORY_SHARE_VERSION = "memory_setting_share_version";
    public static final String TAB_ABOUT_ME = "about_me";
    public static final String TAB_COMMUNICATION = "communication";
    public static final String TAB_MEMO = "memo";
    private static final String TAG = "AILauncher-MemorySetting";
    public static final MemorySettingApi INSTANCE = new MemorySettingApi();
    private static final tb.x JSON_MEDIA_TYPE = tb.x.INSTANCE.a("application/json; charset=utf-8");
    private static final C3636k0 memoryQueryGuard = new C3636k0();
    private static final InterfaceC4021a updateMutex = eb.f.b(false, 1, null);
    private static final Ua.M processScope = kotlinx.coroutines.d.a(Ua.L0.b(null, 1, null).plus(Ua.Y.b()).plus(new a(Ua.J.INSTANCE)));
    private static final List<String> PERSISTENT_KEYS_USER = C1173v.p("中文姓名", "英文姓名", "性别", "年龄", "生日", "家乡", "国籍", "职业", "行业", "专业领域", "技术栈", "常驻地址", "家庭成员", "宠物", "注意事项", "饮食偏好", "旅行偏好", "运动健身", "内容偏好", "沟通偏好", "学习偏好", "User 重要洞察");
    private static final List<String> PERSISTENT_KEYS_AGENT = C1173v.p("详略", "语气", "称呼与人称", "主动程度", "示例偏好", "Agent 重要洞察");
    private static final List<String> PERSISTENT_KEYS_FACT = C1173v.p("明确指令", "临时规则");
    private static final Set<String> RESERVED_JSON_KEYS = Z8.Y.j("置信度", c.a.COL_UPDATED_AT, "memory_id", "memory_ids", "members");

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"com/stepos/ailauncher/task/space/MemorySettingApi$a", "Lkotlin/coroutines/a;", "LUa/J;", "Lkotlin/coroutines/d;", "context", "", "exception", "LY8/t;", "handleException", "(Lkotlin/coroutines/d;Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends kotlin.coroutines.a implements Ua.J {
        public a(J.Companion companion) {
            super(companion);
        }

        @Override // Ua.J
        public void handleException(kotlin.coroutines.d context, Throwable exception) {
            C4148a.g(MemorySettingApi.TAG, "processScope uncaught exception", exception, false, 8, null);
        }
    }

    public static final JSONArray A(String str, String str2, JSONArray array) throws JSONException {
        String strW;
        kotlin.jvm.internal.p.i(array, "array");
        int length = array.length();
        for (int i10 = 0; i10 < length; i10++) {
            JSONObject jSONObjectOptJSONObject = array.optJSONObject(i10);
            if (jSONObjectOptJSONObject != null && C3663r0.a(jSONObjectOptJSONObject).contains(str) && (strW = INSTANCE.W(jSONObjectOptJSONObject)) != null) {
                jSONObjectOptJSONObject.put(strW, str2);
                jSONObjectOptJSONObject.put(c.a.COL_UPDATED_AT, String.valueOf(System.currentTimeMillis()));
                return array;
            }
        }
        return array;
    }

    public static final Y8.t C(String str) {
        INSTANCE.x(str, new JSONObject());
        return Y8.t.f7040a;
    }

    public static final JSONArray u(boolean z10, String str, String str2, String str3, JSONArray array) throws JSONException {
        kotlin.jvm.internal.p.i(array, "array");
        JSONArray jSONArray = new JSONArray();
        int length = array.length();
        for (int i10 = 0; i10 < length; i10++) {
            JSONObject jSONObjectOptJSONObject = array.optJSONObject(i10);
            if (jSONObjectOptJSONObject != null && (!z10 || !kotlin.jvm.internal.p.d(INSTANCE.W(jSONObjectOptJSONObject), str) || !C3663r0.a(jSONObjectOptJSONObject).isEmpty())) {
                jSONArray.put(jSONObjectOptJSONObject);
            }
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(str, str2);
        JSONArray jSONArray2 = new JSONArray();
        if (str3.length() > 0) {
            jSONArray2.put(str3);
        }
        Y8.t tVar = Y8.t.f7040a;
        jSONObject.put("memory_ids", jSONArray2);
        jSONObject.put(c.a.COL_UPDATED_AT, String.valueOf(System.currentTimeMillis()));
        JSONArray jSONArrayPut = jSONArray.put(jSONObject);
        kotlin.jvm.internal.p.h(jSONArrayPut, "put(...)");
        return jSONArrayPut;
    }

    public static final JSONArray w(Set set, JSONArray array) {
        kotlin.jvm.internal.p.i(array, "array");
        JSONArray jSONArray = new JSONArray();
        int length = array.length();
        for (int i10 = 0; i10 < length; i10++) {
            JSONObject jSONObjectOptJSONObject = array.optJSONObject(i10);
            if (jSONObjectOptJSONObject != null) {
                List<String> listA = C3663r0.a(jSONObjectOptJSONObject);
                if ((listA instanceof Collection) && listA.isEmpty()) {
                    jSONArray.put(jSONObjectOptJSONObject);
                } else {
                    Iterator<T> it = listA.iterator();
                    while (it.hasNext()) {
                        if (set.contains((String) it.next())) {
                            break;
                        }
                    }
                    jSONArray.put(jSONObjectOptJSONObject);
                }
            }
        }
        return jSONArray;
    }

    public final void B(final String uid) {
        kotlin.jvm.internal.p.i(uid, "uid");
        if (La.H.x0(uid)) {
            return;
        }
        memoryQueryGuard.c(uid, new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.space.m0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return MemorySettingApi.C(uid);
            }
        });
    }

    public final String D() {
        try {
            com.stepos.ailauncher.foundation.account.f fVar = com.stepos.ailauncher.foundation.account.f.INSTANCE;
            if (fVar.v()) {
                String strK = fVar.k();
                if (strK.length() > 0) {
                    return strK;
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public final Object E(String str, String str2, List<String> list, InterfaceC4014c<? super Set<String>> interfaceC4014c) {
        return C1056g.j(Ua.Y.b(), new MemorySettingApi$deleteMemoryItem$2(str, list, str2, null), interfaceC4014c);
    }

    public final Object F(List<String> list, String str, String str2, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return C1056g.j(Ua.Y.b(), new MemorySettingApi$editMemory$2(list, str2, str, null), interfaceC4014c);
    }

    public final void G(boolean enabled, int expectedVersion, InterfaceC5074l<? super MemorySettingState, Y8.t> onResult) {
        C1060i.d(processScope, null, null, new MemorySettingApi$fireUpdateMemorySetting$1(enabled, expectedVersion, onResult, null), 3, null);
    }

    public final String H() {
        String token;
        AccountInfo accountInfoL = com.stepos.ailauncher.foundation.account.f.INSTANCE.l();
        if (accountInfoL == null || (token = accountInfoL.getToken()) == null) {
            token = "";
        }
        if (token.length() <= 0) {
            return "";
        }
        return "Bearer " + token;
    }

    public final List<MemoryItemParsed> I(String tabType) {
        kotlin.jvm.internal.p.i(tabType, "tabType");
        String strD = D();
        if (strD == null) {
            return null;
        }
        String strT = C5009a.t(C5009a.INSTANCE, KEY_MEMORY_CACHE + strD + "_" + tabType, "", false, 4, null);
        if (strT == null) {
            return null;
        }
        if (strT.length() == 0) {
            C4148a.d(TAG, "getCachedMemoriesForTab: tab=" + tabType + ", cache empty", false, 4, null);
            return null;
        }
        try {
            List<MemoryItemParsed> listU = U(new JSONArray(strT), Q(tabType), P(tabType));
            C4148a.d(TAG, "getCachedMemoriesForTab: tab=" + tabType + ", loaded " + listU.size() + " items from cache", false, 4, null);
            return listU;
        } catch (Exception e10) {
            C4148a.g(TAG, "getCachedMemoriesForTab(" + tabType + ") parse exception", e10, false, 8, null);
            return null;
        }
    }

    public final MemorySettingState J() {
        String strD = D();
        if (strD == null) {
            return null;
        }
        C5009a c5009a = C5009a.INSTANCE;
        if (!C5009a.b(c5009a, KEY_MEMORY_SHARE_ENABLED + strD, false, 2, null)) {
            return null;
        }
        return new MemorySettingState(C5009a.g(c5009a, KEY_MEMORY_SHARE_ENABLED + strD, true, false, 4, null), C5009a.k(c5009a, KEY_MEMORY_SHARE_VERSION + strD, 0, false, 4, null));
    }

    public final String K(String tabType) {
        int iHashCode = tabType.hashCode();
        if (iHashCode == -1035284522) {
            return !tabType.equals("communication") ? "fact_info" : "agent_info";
        }
        if (iHashCode != 3347770) {
            return (iHashCode == 1619363722 && tabType.equals("about_me")) ? "user_info" : "fact_info";
        }
        tabType.equals("memo");
        return "fact_info";
    }

    public final Object L(InterfaceC4014c<? super MemorySettingState> interfaceC4014c) {
        return C1056g.j(Ua.Y.b(), new MemorySettingApi$getMemorySetting$2(null), interfaceC4014c);
    }

    public final List<String> M() {
        return PERSISTENT_KEYS_AGENT;
    }

    public final List<String> N() {
        return PERSISTENT_KEYS_FACT;
    }

    public final List<String> O() {
        return PERSISTENT_KEYS_USER;
    }

    public final List<String> P(String tabType) {
        int iHashCode = tabType.hashCode();
        if (iHashCode != -1035284522) {
            if (iHashCode != 3347770) {
                if (iHashCode == 1619363722 && tabType.equals("about_me")) {
                    return PERSISTENT_KEYS_USER;
                }
            } else if (tabType.equals("memo")) {
                return PERSISTENT_KEYS_FACT;
            }
        } else if (tabType.equals("communication")) {
            return PERSISTENT_KEYS_AGENT;
        }
        return C1173v.m();
    }

    public final String Q(String tabType) {
        int iHashCode = tabType.hashCode();
        if (iHashCode == -1035284522) {
            return !tabType.equals("communication") ? "fact_" : "agent_";
        }
        if (iHashCode != 3347770) {
            return (iHashCode == 1619363722 && tabType.equals("about_me")) ? "user_" : "fact_";
        }
        tabType.equals("memo");
        return "fact_";
    }

    public final boolean R() {
        MemorySettingState memorySettingStateJ = J();
        if (memorySettingStateJ != null) {
            return memorySettingStateJ.getMemoryShareEnabled();
        }
        return true;
    }

    public final String S(String memoryName) {
        kotlin.jvm.internal.p.i(memoryName, "memoryName");
        if (La.D.X(memoryName, "user_", false, 2, null)) {
            return "about_me";
        }
        if (La.D.X(memoryName, "agent_", false, 2, null)) {
            return "communication";
        }
        La.D.X(memoryName, "fact_", false, 2, null);
        return "memo";
    }

    public final void T(String tabType, InterfaceC5074l<? super JSONArray, ? extends JSONArray> transform) {
        String strD = D();
        if (strD == null) {
            return;
        }
        String str = KEY_MEMORY_CACHE + strD + "_" + tabType;
        C5009a c5009a = C5009a.INSTANCE;
        String strT = C5009a.t(c5009a, str, "", false, 4, null);
        if (strT == null || strT.length() == 0) {
            return;
        }
        try {
            JSONArray jSONArrayInvoke = transform.invoke(new JSONArray(strT));
            String string = jSONArrayInvoke.toString();
            kotlin.jvm.internal.p.h(string, "toString(...)");
            C5009a.G(c5009a, str, string, false, 4, null);
            C4148a.d(TAG, "mutateCachedTab: tab=" + tabType + ", items=" + jSONArrayInvoke.length(), false, 4, null);
        } catch (Exception e10) {
            C4148a.g(TAG, "mutateCachedTab(" + tabType + ") exception", e10, false, 8, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.stepos.ailauncher.task.space.MemoryItemParsed> U(org.json.JSONArray r17, java.lang.String r18, java.util.List<java.lang.String> r19) {
        /*
            r16 = this;
            r0 = r17
            if (r0 != 0) goto L9
            java.util.List r0 = Z8.C1173v.m()
            return r0
        L9:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            int r2 = r0.length()
            r3 = 0
            r4 = r3
        L14:
            if (r4 >= r2) goto Lb1
            org.json.JSONObject r5 = r0.optJSONObject(r4)
            if (r5 != 0) goto L22
        L1c:
            r15 = r18
            r5 = r19
            goto Lad
        L22:
            java.util.List r14 = com.stepos.ailauncher.task.space.C3663r0.a(r5)
            java.lang.Object r6 = Z8.F.s0(r14)
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r7 = ""
            if (r6 != 0) goto L32
            r9 = r7
            goto L33
        L32:
            r9 = r6
        L33:
            java.lang.String r6 = "updated_at"
            java.lang.String r8 = "0"
            java.lang.String r6 = r5.optString(r6, r8)
            java.lang.String r8 = "optString(...)"
            kotlin.jvm.internal.p.h(r6, r8)
            java.lang.Long r6 = La.C.y(r6)
            if (r6 == 0) goto L4e
            long r10 = r6.longValue()
        L4c:
            r11 = r10
            goto L51
        L4e:
            r10 = 0
            goto L4c
        L51:
            java.util.Iterator r6 = r5.keys()
        L55:
            boolean r10 = r6.hasNext()
            if (r10 == 0) goto L76
            java.lang.Object r10 = r6.next()
            java.lang.String r10 = (java.lang.String) r10
            java.util.Set<java.lang.String> r13 = com.stepos.ailauncher.task.space.MemorySettingApi.RESERVED_JSON_KEYS
            boolean r13 = r13.contains(r10)
            if (r13 != 0) goto L55
            kotlin.jvm.internal.p.f(r10)
            java.lang.String r7 = r5.optString(r10, r7)
            kotlin.jvm.internal.p.h(r7, r8)
            r8 = r7
            r7 = r10
            goto L77
        L76:
            r8 = r7
        L77:
            int r5 = r7.length()
            if (r5 != 0) goto L7e
            goto L1c
        L7e:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r15 = r18
            r5.append(r15)
            r5.append(r7)
            java.lang.String r10 = r5.toString()
            java.lang.String r5 = "custom"
            boolean r5 = kotlin.jvm.internal.p.d(r7, r5)
            if (r5 != 0) goto La2
            r5 = r19
            boolean r6 = r5.contains(r7)
            if (r6 == 0) goto La4
            r6 = 1
            r13 = r6
            goto La5
        La2:
            r5 = r19
        La4:
            r13 = r3
        La5:
            com.stepos.ailauncher.task.space.h0 r6 = new com.stepos.ailauncher.task.space.h0
            r6.<init>(r7, r8, r9, r10, r11, r13, r14)
            r1.add(r6)
        Lad:
            int r4 = r4 + 1
            goto L14
        Lb1:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.space.MemorySettingApi.U(org.json.JSONArray, java.lang.String, java.util.List):java.util.List");
    }

    public final Object V(InterfaceC4014c<? super Map<String, ? extends List<MemoryItemParsed>>> interfaceC4014c) {
        return C1056g.j(Ua.Y.b(), new MemorySettingApi$queryMemories$2(null), interfaceC4014c);
    }

    public final String W(JSONObject obj) {
        Iterator<String> itKeys = obj.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!RESERVED_JSON_KEYS.contains(next)) {
                return next;
            }
        }
        return null;
    }

    public final String X(String tabType) {
        kotlin.jvm.internal.p.i(tabType, "tabType");
        int iHashCode = tabType.hashCode();
        if (iHashCode == -1035284522) {
            return !tabType.equals("communication") ? "fact_custom" : "agent_custom";
        }
        if (iHashCode != 3347770) {
            return (iHashCode == 1619363722 && tabType.equals("about_me")) ? "user_custom" : "fact_custom";
        }
        tabType.equals("memo");
        return "fact_custom";
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:(1:(1:(8:12|75|13|76|41|(1:43)(1:46)|47|(5:49|50|51|67|68)(8:52|(1:54)(1:(1:56))|57|(1:59)(1:60)|61|51|67|68))(2:20|21))(1:22))(3:23|(1:26)|39)|77|27|(2:79|29)(1:36)|37|(6:40|76|41|(0)(0)|47|(0)(0))|39) */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00ac, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:43:0x010e A[Catch: Exception -> 0x004f, all -> 0x0113, TryCatch #1 {Exception -> 0x004f, blocks: (B:13:0x0046, B:41:0x00f9, B:43:0x010e, B:47:0x0118, B:49:0x0137, B:52:0x0155, B:54:0x015d, B:57:0x0165, B:59:0x016b, B:61:0x0173, B:60:0x0170), top: B:75:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0137 A[Catch: Exception -> 0x004f, all -> 0x0113, TryCatch #1 {Exception -> 0x004f, blocks: (B:13:0x0046, B:41:0x00f9, B:43:0x010e, B:47:0x0118, B:49:0x0137, B:52:0x0155, B:54:0x015d, B:57:0x0165, B:59:0x016b, B:61:0x0173, B:60:0x0170), top: B:75:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0155 A[Catch: Exception -> 0x004f, all -> 0x0113, TryCatch #1 {Exception -> 0x004f, blocks: (B:13:0x0046, B:41:0x00f9, B:43:0x010e, B:47:0x0118, B:49:0x0137, B:52:0x0155, B:54:0x015d, B:57:0x0165, B:59:0x016b, B:61:0x0173, B:60:0x0170), top: B:75:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object Y(boolean r17, int r18, e9.InterfaceC4014c<? super com.stepos.ailauncher.task.space.MemorySettingState> r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 409
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.space.MemorySettingApi.Y(boolean, int, e9.c):java.lang.Object");
    }

    public final Object s(String str, String str2, InterfaceC4014c<? super String> interfaceC4014c) {
        return C1056g.j(Ua.Y.b(), new MemorySettingApi$addMemory$2(str2, str, null), interfaceC4014c);
    }

    public final void t(String memoryName, final String memoryId, final String content) {
        String strS = S(memoryName);
        final String strR0 = La.H.R0(memoryName, Q(strS));
        if (strR0.length() == 0) {
            return;
        }
        final boolean z10 = !kotlin.jvm.internal.p.d(strR0, "custom");
        T(strS, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.space.n0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return MemorySettingApi.u(z10, strR0, content, memoryId, (JSONArray) obj);
            }
        });
    }

    public final void v(String tabType, final Set<String> memoryIds) {
        if (memoryIds.isEmpty()) {
            return;
        }
        T(tabType, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.space.p0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return MemorySettingApi.w(memoryIds, (JSONArray) obj);
            }
        });
    }

    public final void x(String uid, JSONObject card) {
        String string;
        for (String str : C1173v.p("about_me", "communication", "memo")) {
            JSONArray jSONArrayOptJSONArray = card.optJSONArray(K(str));
            if (jSONArrayOptJSONArray == null || (string = jSONArrayOptJSONArray.toString()) == null) {
                string = "[]";
            }
            String str2 = string;
            C5009a.G(C5009a.INSTANCE, KEY_MEMORY_CACHE + uid + "_" + str, str2, false, 4, null);
            int length = jSONArrayOptJSONArray != null ? jSONArrayOptJSONArray.length() : 0;
            C4148a.d(TAG, "cacheMemoriesPerTab: tab=" + str + ", items=" + length + ", size=" + str2.length(), false, 4, null);
        }
    }

    public final void y(MemorySettingState state) {
        String strD = D();
        if (strD == null) {
            return;
        }
        C5009a c5009a = C5009a.INSTANCE;
        C5009a.y(c5009a, KEY_MEMORY_SHARE_ENABLED + strD, state.getMemoryShareEnabled(), false, 4, null);
        C5009a.B(c5009a, KEY_MEMORY_SHARE_VERSION + strD, state.getVersion(), false, 4, null);
    }

    public final void z(String memoryName, final String memoryId, final String content) {
        if (memoryId.length() == 0) {
            return;
        }
        T(S(memoryName), new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.space.o0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return MemorySettingApi.A(memoryId, content, (JSONArray) obj);
            }
        });
    }
}
