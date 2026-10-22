package com.bytedance.android.shopping.store.mall.follows.apidata;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.Gson;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f185541a;

    public static final class a {
    }

    static {
    }

    public b(Context r100) {
        if (r100 == null) goto L5;
        SharedPreferences r101 = r100.getSharedPreferences("xbridge-storage", 0);
    L6:
        this.f185541a = r101;
        return;
    L5:
        r101 = null;
        goto L6
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Object a(String r100) {
        SharedPreferences r101 = this.f185541a;
        if (r101 != null) goto L6;
        return null;
    L6:
        if (r101.contains(r100) == true) goto L8;
        return null;
    L8:
        String r102 = r101.getString(r100, "");
        if (r102 != null) goto L11;
    L14:
        boolean r103 = true;
    L15:
        if (r103 == false) goto L57;
        return null;
    L57:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L51
        int r105 = t0.f45720a;     // Catch: Throwable -> L51
        Gson r106 = t0.a.f45721a;     // Catch: Throwable -> L51
        StorageValue r107 = (StorageValue) r106.fromJson(r102, StorageValue.class);     // Catch: Throwable -> L51
        Long r108 = r107.getExpiredTime();     // Catch: Throwable -> L51
        long r109 = System.currentTimeMillis();     // Catch: Throwable -> L51
        if (r108 != null) goto L20;
    L35:
        String r110 = r107.getValue();     // Catch: Throwable -> L51
        if (r110 == null) goto L63;
        String r111 = r107.getType();     // Catch: Throwable -> L51
        if (r111 == null) goto L64;
        Object r112 = r110;
        switch(c.f185542a[XReadableType.valueOf(r111).ordinal()]) {
            case 1: goto L71;
            case 2: goto L70;
            case 3: goto L69;
            case 4: goto L68;
            case 5: goto L56;
            case 6: goto L67;
            case 7: goto L66;
            default: goto L65;
        };     // Catch: Throwable -> L51
    L65:
        return null;
    L66:
        return r106.fromJson(r110, Map.class);
    L67:
        return r106.fromJson(r110, List.class);
    L68:
        return Double.valueOf(CastDoubleProtector.parseDouble(r110));
    L69:
        return Long.valueOf(CastLongProtector.parseLong(r110));
    L70:
        return Integer.valueOf(CastIntegerProtector.parseInt(r110));
    L71:
        return Boolean.valueOf(Boolean.parseBoolean(r110));
    L56:
        return r112;
    L64:
        return null;
    L63:
        return null;
    L20:
        if (r109 <= r108.longValue()) goto L35;
        SharedPreferences r113 = this.f185541a;     // Catch: Throwable -> L51
        if (r113 != null) goto L25;
        return null;
    L25:
        if (r113.contains(r100) == false) goto L59;
        SharedPreferences r114 = this.f185541a;     // Catch: Throwable -> L51
        if (r114 == null) goto L30;
        SharedPreferences.Editor r115 = r114.edit();     // Catch: Throwable -> L51
    L31:
        if (r115 == null) goto L60;
        SharedPreferences.Editor r116 = r115.remove(r100);     // Catch: Throwable -> L51
        if (r116 == null) goto L61;
        r116.apply();     // Catch: Throwable -> L51
        return null;
    L61:
        return null;
    L60:
        return null;
    L30:
        r115 = null;
        goto L31
    L59:
        return null;
    L51:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        Object r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        boolean r119 = Result.m9455isFailureimpl(r118);
        r112 = r118;
        if (r119 == false) goto L56;
        return null;
    L11:
        if (StringsKt.isBlank(r102) == true) goto L14;
        r103 = false;
        goto L15
    }
}
