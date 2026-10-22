package com.smt.obric.appstore.domain.oapplet;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.os.c;
import com.bytedanceos.common.toolbox.j;
import com.google.gson.Gson;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.collections.t;
import kotlin.coroutines.Continuation;
import kotlin.d;
import kotlin.jvm.internal.q;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.o;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: classes4.dex */
public final class OAppletUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OAppletUtil f18065a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f18066b = null;

    static {
        f18065a = new OAppletUtil();
        f18066b = kotlin.b.b(OAppletUtil$gson$2.INSTANCE);
    }

    public OAppletUtil() {
    }

    public final String a(String r10) {
        q.g(r10, "packageName");
        return "apkfile://com.obric.appstore.oapplet/" + r10;
    }

    public final Object b(Context r10, String r11) {
        q.g(r10, "context");
        q.g(r11, "packageName");
        Result.a r12 = Result.Companion;     // Catch: Throwable -> L6
        j.n("[OApplet] OAppletUtil installOAppletBlocking: call installApplet, packageName = " + r11);     // Catch: Throwable -> L6
        ContentResolver r13 = r10.getContentResolver();     // Catch: Throwable -> L6
        Uri r14 = Uri.parse("content://com.obric.appletapp.SystemAppletProvider");     // Catch: Throwable -> L6
        q.f(r14, "parse(this)");     // Catch: Throwable -> L6
        Bundle r15 = r13.call(r14, "installApplet", null, c.a(new Pair[]{d.a("packageName", r11)}));     // Catch: Throwable -> L6
        j.n("[OApplet] OAppletUtil installOAppletBlocking: call installApplet, packageName = " + r11 + " return " + r15);     // Catch: Throwable -> L6
        boolean r16 = false;
        if (r15 != null) goto L8;
        j.s("[OApplet] OAppletUtil installOAppletBlocking: call installApplet return null, packageName = " + r11);     // Catch: Throwable -> L6
    L9:
        Object r17 = Result.m35constructorimpl(Boolean.valueOf(r16));     // Catch: Throwable -> L6
    L12:
        Throwable r18 = Result.m38exceptionOrNullimpl(r17);
        if (r18 == null) goto L15;
        j.q("[OApplet] OAppletUtil installOAppletBlocking: call installApplet err, packageName = " + r11, r18);
    L15:
        return r17;
    L8:
        r16 = r15.getBoolean("accepted", false);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        Result.a r19 = Result.Companion;
        r17 = Result.m35constructorimpl(kotlin.c.a(th));
        goto L12
    }

    public final String c(Bundle r10) {
        if (r10.getBoolean("accepted", false) == true) goto L7;
        return null;
    L7:
        return r10.getString("result");
    }

    public final Object d(Context r10) {
        q.g(r10, "context");
        Result.a r11 = Result.Companion;     // Catch: Throwable -> L6
        j.n("[OApplet] OAppletUtil getAllOAppletsBlocking: call getAppletList");     // Catch: Throwable -> L6
        ContentResolver r12 = r10.getContentResolver();     // Catch: Throwable -> L6
        Uri r13 = Uri.parse("content://com.obric.appletapp.SystemAppletProvider");     // Catch: Throwable -> L6
        q.f(r13, "parse(this)");     // Catch: Throwable -> L6
        String r14 = null;
        Bundle r15 = r12.call(r13, "getAppletList", null, null);     // Catch: Throwable -> L6
        StringBuilder r16 = new StringBuilder();     // Catch: Throwable -> L6
        r16.append("[OApplet] OAppletUtil getAllOAppletsBlocking: call getAppletList return ");     // Catch: Throwable -> L6
        if (r15 == null) goto L8;
        r14 = r15.getString("data");     // Catch: Throwable -> L6
    L8:
        r16.append(r14);     // Catch: Throwable -> L6
        j.n(r16.toString());     // Catch: Throwable -> L6
        if (r15 != null) goto L11;
        j.s("[OApplet] OAppletUtil getAllOAppletsBlocking: call getAppletList return null");     // Catch: Throwable -> L6
        List r17 = t.i();     // Catch: Throwable -> L6
    L25:
        Object r18 = Result.m35constructorimpl(r17);     // Catch: Throwable -> L6
    L28:
        Throwable r19 = Result.m38exceptionOrNullimpl(r18);
        if (r19 == null) goto L31;
        j.q("[OApplet] OAppletUtil getAllOAppletsBlocking: call getAppletList err", r19);
    L31:
        return r18;
    L11:
        String r20 = c(r15);     // Catch: Throwable -> L6
        q.d(r20);     // Catch: Throwable -> L6
        r17 = (List) e().fromJson(StringsKt__StringsKt.z0(r20).toString(), new OAppletUtil$getAllOAppletsBlocking$1$list$1$listType$1().getType());     // Catch: Throwable -> L6
        q.d(r17);     // Catch: Throwable -> L6
        int r21 = 0;
        if (r17 != null) goto L14;
    L16:
        Iterator r22 = r17.iterator();     // Catch: Throwable -> L6
    L18:
        if (r22.hasNext() == false) goto L24;
        if (((OAppletInfo) r22.next()).getInstalled() == false) goto L18;
        r21 = r21 + 1;     // Catch: Throwable -> L6
        if (r21 >= 0) goto L18;
        t.p();     // Catch: Throwable -> L6
    L24:
        j.n("[OApplet] OAppletUtil getAllOAppletsBlocking: call getAppletList return " + r17.size() + " items, " + r21 + " installed");     // Catch: Throwable -> L6
        goto L25
    L14:
        if (r17.isEmpty() == false) goto L16;
    L6:
        th = move-exception;
        Result.a r23 = Result.Companion;
        r18 = Result.m35constructorimpl(kotlin.c.a(th));
        goto L28
    }

    public final Gson e() {
        return (Gson) f18066b.getValue();
    }

    public final Object f(Context r10, String r11, Continuation r12) {
        if ((r12 instanceof OAppletUtil$installOApplet$1) == false) goto L7;
        OAppletUtil$installOApplet$1 r13 = (OAppletUtil$installOApplet$1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = kotlin.coroutines.intrinsics.a.d();
        int r17 = r13.label;
        if (r17 == 0) goto L17;
        if (r17 != 1) goto L16;
        kotlin.c.b(r15);     // Catch: Throwable -> L13
    L21:
        return Result.m35constructorimpl(tf.a.a(true));
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        kotlin.c.b(r15);
        Result.a r18 = Result.Companion;     // Catch: Throwable -> L13
        OAppletUtil$installOApplet$2$1 r19 = new OAppletUtil$installOApplet$2$1(r10, r11, this, null);     // Catch: Throwable -> L13
        r13.label = 1;     // Catch: Throwable -> L13
        if (TimeoutKt.c(20000, r19, r13) != r16) goto L21;
        return r16;
    L13:
        th = move-exception;
        Result.a r20 = Result.Companion;
        return Result.m35constructorimpl(kotlin.c.a(th));
    L7:
        r13 = new OAppletUtil$installOApplet$1(this, r12);
        goto L8
    }

    public final boolean g(String r10) {
        q.g(r10, "packageName");
        return o.B(r10, "ns_oapplet:", false, 2, null);
    }

    public final void h(Context r10, OAppletInfo r11) {
        q.g(r10, "context");
        q.g(r11, "oAppletInfo");
        j.n("[OApplet] OAppletUtil openOApplet: call startOApplet, action: " + r11.getAction());
        Uri r12 = Uri.parse(r11.getAction());
        q.f(r12, "parse(this)");
        Intent r13 = new Intent("android.intent.action.VIEW", r12);
        r13.addFlags(268435456);
        r10.startActivity(r13);
    }

    public final String i(String r10) {
        q.g(r10, "packageName");
        if (o.B(r10, "ns_oapplet:", false, 2, null) == true) goto L5;
        return r10;
    L5:
        return StringsKt__StringsKt.f0(r10, "ns_oapplet:");
    }

    public final String j(String r10) {
        q.g(r10, "packageName");
        if (o.B(r10, "ns_oapplet:", false, 2, null) == false) goto L6;
        return r10;
    L6:
        return "ns_oapplet:" + r10;
    }
}
