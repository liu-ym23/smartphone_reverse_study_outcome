package com.bytedance.android.livesdk.dsl.util;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f122805a = 0;

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002(\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004`\u00050\u0001¨\u0006\u0006"}, d2 = {"com/bytedance/android/livesdk/dsl/util/c$a", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "dslservice-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a extends TypeToken<HashMap<String, Object>> {
        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002(\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003`\u00040\u0001¨\u0006\u0005"}, d2 = {"com/bytedance/android/livesdk/dsl/util/c$b", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "dslservice-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b extends TypeToken<HashMap<String, String>> {
        public b() {
        }
    }

    static {
    }

    public static HashMap g(String r100) {
        return (HashMap) GsonProtectorUtils.fromJson(GsonHelper.getDefault(), r100, new a().getType());
    }

    public static HashMap h(String r100) {
        return (HashMap) GsonProtectorUtils.fromJson(GsonHelper.getDefault(), r100, new b().getType());
    }

    public static Map a(Map r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Object r102 = null;
        if (r100 == null) goto L12;
        Object r103 = r100.get(r101);
        if (r103 != null) goto L7;
        return null;
    L7:
        if ((r103 instanceof Map) == false) goto L11;
        r102 = r103;
    L11:
        return (Map) r102;
    L12:
        return null;
    }

    public static boolean b(Map r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r100 == null) goto L7;
        Object r102 = r100.get(r101);
        if (r102 == null) goto L7;
        return com.bytedance.android.ecom.arch.slice.render.util.b.a(r102);
    L7:
        return false;
    }

    public static String c(Map r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        List r102 = StringsKt.split$default(r101, new String[]{"."}, false, 0, 6, null);
        if (r100 == null) goto L7;
        if (r100.isEmpty() != true) goto L7;
    L8:
        return null;
    L7:
        if (r102.isEmpty() == true) goto L8;
        if (r102.size() == 1) goto L12;
        Iterator r103 = r102.iterator();
        int r104 = 0;
        Map r105 = null;
    L15:
        if (r103.hasNext() == false) goto L30;
        Object r106 = r103.next();
        int r107 = r104 + 1;
        if (r104 >= 0) goto L19;
        CollectionsKt.throwIndexOverflow();
    L19:
        String r108 = (String) r106;
        if (r104 != 0) goto L24;
        Map r109 = a(r100, r108);
    L22:
        r105 = r109;
        r104 = r107;
        goto L15
    L24:
        if (r104 == (r102.size() - 1)) goto L25;
        r109 = a(r105, r108);
        goto L22
    L25:
        if (r105 != null) goto L27;
        return null;
    L27:
        return d(r105, r108);
    L30:
        return null;
    L12:
        return d(r100, (String) CollectionsKt.first(r102));
    }

    public static String d(Map r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r100 == null) goto L7;
        Object r102 = r100.get(r101);
        if (r102 == null) goto L7;
        return com.bytedance.android.ecom.arch.slice.render.util.b.r(r102);
    L7:
        return null;
    }

    public static Map e(Map r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Object r102 = null;
        if (r100 == null) goto L5;
        Object r103 = r100.get(r101);
    L7:
        if ((r103 instanceof Map) == false) goto L11;
        r102 = r103;
    L11:
        return (Map) r102;
    L5:
        r103 = null;
        goto L7
    }

    public static Object f(List r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$safeGet");
        int r102 = r100.size();
        if (r101 < 0) goto L7;
        if (r102 <= r101) goto L7;
        return ListProtector.get(r100, r101);
    L7:
        return null;
    }
}
