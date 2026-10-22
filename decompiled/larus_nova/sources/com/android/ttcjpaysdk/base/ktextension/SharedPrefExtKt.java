package com.android.ttcjpaysdk.base.ktextension;

import android.content.Context;
import android.content.SharedPreferences;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\u0001\u001a\u0012\u0010\u0006\u001a\u00020\u0007*\u00020\u00012\u0006\u0010\b\u001a\u00020\u0005\u001a#\u0010\t\u001a\u00020\u0007*\u00020\u00012\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\b\r\u001a \u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000f*\u00020\u00012\u0006\u0010\b\u001a\u00020\u0005\u001a\u001a\u0010\u0010\u001a\u00020\u0007*\u00020\u00012\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012\u001a\u001a\u0010\u0013\u001a\u00020\u0007*\u00020\u00012\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0014\u001a&\u0010\u0015\u001a\u00020\u0007*\u00020\u00012\u0006\u0010\b\u001a\u00020\u00052\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000f\u001a\u001a\u0010\u0016\u001a\u00020\u0007*\u00020\u00012\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005\u001a \u0010\u0017\u001a\u00020\u0007*\u00020\u00012\u0006\u0010\b\u001a\u00020\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0018¨\u0006\u0019"}, d2 = {"getSharePref", "Landroid/content/SharedPreferences;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "name", "", "clear", "", "key", "edit", "action", "Lkotlin/Function1;", "Landroid/content/SharedPreferences$Editor;", "Lkotlin/ExtensionFunctionType;", "getMap", "", "putBoolean", "value", "", "putInt", "", "putMap", "putString", "putStringSet", "", "cj-host-service-api_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class SharedPrefExtKt {
    public static final void clear(SharedPreferences r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        edit(r100, AnonymousClass2.INSTANCE);
    }

    public static final void clear(SharedPreferences r100, final String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        edit(r100, new AnonymousClass1(r101));
    }

    public static final void edit(SharedPreferences r100, Function1<? super SharedPreferences.Editor, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "action");
        SharedPreferences.Editor r102 = r100.edit();
        r101.invoke(r102);
        r102.apply();
    }

    public static final Map<String, String> getMap(SharedPreferences r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        String r102 = r100.getString(r101, "");
        if (r102 != null) goto L5;
        return null;
    L5:
        if (r102.length() <= 0) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == true) goto L11;
        r102 = null;
    L11:
        if (r102 == null) goto L26;
        JSONObject r104 = new JSONObject(r102);
        LinkedHashMap r105 = new LinkedHashMap();
        Iterator<String> r106 = r104.keys();     // Catch: Exception -> L20
    L15:
        if (r106.hasNext() == false) goto L19;
        String r107 = r106.next();     // Catch: Exception -> L20
        Object r108 = r104.get(r107);     // Catch: Exception -> L20
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type kotlin.String");     // Catch: Exception -> L20
        r105.put(r107, (String) r108);     // Catch: Exception -> L20
    L19:
        return r105;
    L26:
        return null;
    L7:
        r103 = false;
        goto L8
    }

    public static final SharedPreferences getSharePref(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "name");
        return r100.getSharedPreferences(r101, 0);
    }

    public static final void putBoolean(SharedPreferences r100, final String r101, final boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        edit(r100, new C88711(r101, r102));
    }

    public static final void putInt(SharedPreferences r100, final String r101, final int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        edit(r100, new C88721(r101, r102));
    }

    public static final void putMap(SharedPreferences r100, final String r101, final Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        edit(r100, new C88731(r101, r102));
    }

    public static final void putString(SharedPreferences r100, final String r101, final String r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        edit(r100, new C88741(r101, r102));
    }

    public static final void putStringSet(SharedPreferences r100, final String r101, final Set<String> r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        edit(r100, new C88751(r101, r102));
    }

    public static /* synthetic */ SharedPreferences getSharePref$default(Context r100, String r101, int r102, Object r103) {
        if ((r102 & 2) == 0) goto L6;
        r101 = "cjpay_sdk";
    L6:
        return getSharePref(r100, r101);
    }
}
