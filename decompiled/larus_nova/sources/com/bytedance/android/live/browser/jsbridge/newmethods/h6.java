package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.File;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class h6 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f63419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w20.ua f63420b;

    public h6(String r100, w20.ua r101) {
        this.f63419a = r100;
        this.f63420b = r101;
    }

    public final void a() {
        PolarisFileWrapper r100 = new PolarisFileWrapper(this.f63419a);
        ArrayList r101 = new ArrayList();
        File[] r102 = r100.listFiles();
        boolean r103 = false;
        long r104 = 0;
        if (r102 == null) goto L11;
        int r105 = r102.length;
        int r106 = 0;
    L5:
        if (r106 >= r105) goto L11;
        File r110 = r102[r106];
        r104 = r104 + (r110.length() / ((long) 1048576));
        String r111 = r110.getName();
        int r112 = StringsKt.indexOf$default(r111, "_", 0, false, 6, null);
        if (r111 == null) goto L10;
        r101.add(Long.valueOf(CastLongProtector.parseLong(r111.substring(0, r112))));
        r106 = r106 + 1;
        goto L5
    L10:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L11:
        CollectionsKt.sort(r101);
        Integer r107 = this.f63420b.a();
        if (r107 == null) goto L14;
        long r108 = r107.intValue();
    L15:
        ALogger.i("LiveHighlightTranscodingMethod", "current size = " + r104 + ", maxSize = " + r108);
        int r109 = 0;
    L17:
        if (r104 < r108) goto L36;
        if (r109 >= r101.size()) goto L46;
        String r113 = String.valueOf(((Number) ListProtector.get(r101, r109)).longValue());
        File[] r114 = r100.listFiles();
        if (r114 == null) goto L34;
        int r115 = r114.length;
        int r116 = 0;
    L23:
        if (r116 >= r115) goto L33;
        File r117 = r114[r116];
        PolarisFileWrapper r118 = r100;
        if (StringsKt.contains$default(r117.getName(), r113, r103, 2, null) == false) goto L30;
        long r119 = r104;
        long r120 = r117.length() / ((long) 1048576);
        if (r117.delete() == false) goto L29;
        r104 = r119 - r120;
        ALogger.i("LiveHighlightTranscodingMethod", "delete file path: " + r117.getPath() + ", current size = " + r104);
    L32:
        r116 = r116 + 1;
        r100 = r118;
        r103 = false;
        goto L23
    L29:
        ALogger.e("LiveHighlightTranscodingMethod", "delete failed, file path is " + r117.getPath());
    L31:
        r104 = r119;
        goto L32
    L30:
        r119 = r104;
        goto L31
    L33:
        PolarisFileWrapper r121 = r100;
    L35:
        r109 = r109 + 1;
        r100 = r121;
        r103 = false;
        goto L17
    L34:
        r121 = r100;
        goto L35
    L46:
        return;
    L36:
        return;
    L14:
        r108 = 500;
        goto L15
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
