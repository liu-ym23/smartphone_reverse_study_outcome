package com.bytedance.android.live.emoji.online;

import android.text.TextUtils;
import com.bytedance.android.live.core.utils.LiveResUtil;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.FilenameFilter;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f68926a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f68927b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f68928c = null;

    public static final class a implements FilenameFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String[] f68929a;

        public a(String[] r100) {
            this.f68929a = r100;
        }

        @Override // java.io.FilenameFilter
        public final boolean accept(File r100, String r101) {
            return !ArraysKt.contains(this.f68929a, StringsKt.removeSuffix(r101, ".zip"));
        }
    }

    public c() {
    }

    static {
        f68928c = new c();
        f68926a = ("/data/data/" + jc1.a.b().getApplicationContext().getPackageName() + '/') + "small_emoji_res/";
        f68927b = LiveResUtil.dp2Px(32.0f);
    }

    public static String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "md5");
        return f68926a + r100 + File.separator;
    }

    public static void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.exists() == true) goto L8;
        return;
    L8:
        if (r101.isDirectory() == false) goto L25;
        File[] r102 = r101.listFiles();
        if (r102 != null) goto L12;
        return;
    L12:
        int r103 = r102.length;
        int r104 = 0;
    L13:
        if (r104 >= r103) goto L19;
        File r105 = r102[r104];
        if (r105.isDirectory() == false) goto L17;
        c(r105.getPath());
    L18:
        r104 = r104 + 1;
        goto L13
    L17:
        r105.delete();
        goto L18
    L19:
        r101.delete();
        return;
    }

    public final synchronized void a(String... r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "whiteMd5");     // Catch: Throwable -> L19
        PolarisFileWrapper r101 = new PolarisFileWrapper(f68926a);     // Catch: Throwable -> L19
        if (r101.exists() == true) goto L6;
    L17:
        monitor-exit(this);
        return;
    L6:
        if (r101.isDirectory() == false) goto L17;
        File[] r102 = r101.listFiles(new a(r100));     // Catch: Throwable -> L19
        int r103 = r102.length;     // Catch: Throwable -> L19
        int r104 = 0;
    L9:
        if (r104 >= r103) goto L15;
        File r105 = r102[r104];     // Catch: Throwable -> L19
        if (r105.isDirectory() == false) goto L13;
        c(r105.getAbsolutePath());     // Catch: Throwable -> L19
    L14:
        r104 = r104 + 1;
        goto L9
    L13:
        r105.delete();     // Catch: Throwable -> L19
        goto L14
    L15:
        monitor-exit(this);
        return;
    L19:
        th = move-exception;
        throw th;
    }
}
