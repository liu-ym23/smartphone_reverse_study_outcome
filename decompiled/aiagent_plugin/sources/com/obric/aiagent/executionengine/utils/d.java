package com.obric.aiagent.executionengine.utils;

import android.content.Context;
import com.obric.aiagent.executionengine.utils.pkms.PackageInfoCache;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.o.k;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: SystemApiUtil.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d {
    private static final String TAG = "SystemApiUtil";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f18567a = null;

    static {
        f18567a = new d();
    }

    private d() {
    }

    public final PackageInfoCache.a a(Context r3, String r4) {
        o.e((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "context");
        o.e(r4, "packageName");
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(PackageInfoCache.f18569a.b(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r5 = r2.next();
        if (o.a(((PackageInfoCache.a) ZeusTransformUtils.preCheckCast(r5, PackageInfoCache.a.class, "com.obric.aiagent.plugin")).a().packageName, r4) == false) goto L4;
    L10:
        return (PackageInfoCache.a) ZeusTransformUtils.preCheckCast(r5, PackageInfoCache.a.class, "com.obric.aiagent.plugin");
    L8:
        r5 = null;
        goto L10
    }

    public final PackageInfoCache.a b(Context r23, String r24) {
        String r3 = "com.obric.aiagent.plugin";
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r23, Context.class, "com.obric.aiagent.plugin");
        o.e(r2, "context");
        o.e(r24, "name");
        String r5 = null;
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r24, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L5;
        return null;
    L5:
        List<PackageInfoCache.a> r4 = PackageInfoCache.f18569a.b();
        k r6 = new k("[ :\\-_.()!\u3000：－＿．（）！·]");
        String r8 = "";
        String r7 = r6.a((CharSequence) ZeusTransformUtils.preCheckCast(r24, CharSequence.class, "com.obric.aiagent.plugin"), "");
        Locale r9 = Locale.ROOT;
        o.c(r9, "ROOT");
        String r10 = r7.toLowerCase(r9);
        String r11 = "toLowerCase(...)";
        o.c(r10, "toLowerCase(...)");
        Iterator<PackageInfoCache.a> r12 = r4.iterator();
        PackageInfoCache.a r13 = null;
    L7:
        if (r12.hasNext() == false) goto L40;
        PackageInfoCache.a r14 = (PackageInfoCache.a) ZeusTransformUtils.preCheckCast(r12.next(), PackageInfoCache.a.class, r3);
        CharSequence r15 = r14.b();
        if (r15 == null) goto L15;
        String r16 = r15.toString();
        if (r16 == null) goto L15;
        String r17 = r6.a((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, r3), r8);
        if (r17 == null) goto L15;
        Locale r18 = Locale.ROOT;
        o.c(r18, "ROOT");
        String r19 = r17.toLowerCase(r18);
        o.c(r19, r11);
    L16:
        Iterator<PackageInfoCache.a> r110 = r12;
        k r111 = r6;
        if (o.a(r19, r10) == false) goto L24;
        String r112 = r14.a().packageName;
        o.c(r112, "packageName");
        if (c(r2, r112) == true) goto L20;
        ILogDepend.Companion.d(TAG, "Found exact match without launcher activity for '" + r24 + "'. App: " + r14.b() + ", Package: " + r14.a().packageName);
        goto L24
    L20:
        ILogDepend.Companion.d(TAG, "Found exact match with launcher activity for '" + r24 + "'. App: " + r14.b() + ", Package: " + r14.a().packageName);
        return r14;
    L24:
        if (r13 != null) goto L37;
        boolean r20 = true;
        if (r19 == null) goto L30;
        CharSequence r113 = (CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, r3);
        CharSequence r114 = (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, r3);
        String r21 = r3;
        String r22 = r10;
        String r25 = null;
        if (d.o.o.c(r113, r114, false, 2, null) == true) goto L32;
    L31:
        r20 = false;
    L32:
        if (r20 == false) goto L38;
        String r26 = r14.a().packageName;
        o.c(r26, "packageName");
        if (c(r2, r26) == false) goto L36;
        ILogDepend.Companion.d(TAG, "Found contains match with launcher activity for '" + r24 + "'. App: " + r14.b() + ", Package: " + r14.a().packageName);
        r5 = r25;
        r13 = r14;
    L39:
        r12 = r110;
        r6 = r111;
        r8 = r8;
        r11 = r11;
        r3 = r21;
        r10 = r22;
        goto L7
    L36:
        ILogDepend.Companion.d(TAG, "Found contains match without launcher activity for '" + r24 + "'. App: " + r14.b() + ", Package: " + r14.a().packageName);
    L38:
        r5 = r25;
        goto L39
    L30:
        r21 = r3;
        r22 = r10;
        r25 = null;
        goto L31
    L37:
        r21 = r3;
        r22 = r10;
        r25 = null;
    L15:
        r19 = r5;
        goto L16
    L40:
        return r13;
    }

    private final boolean c(Context r2, String r3) {
        if (((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).getPackageManager().getLaunchIntentForPackage(r3) == null) goto L5;
        return true;
    L5:
        return false;
    }
}
