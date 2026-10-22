package com.bytedance.android.ec.hybrid.list.entity;

import android.content.Context;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.keva.Keva;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class ECHybridItemDataShrinkHelper {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f47014d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f47015e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Keva f47016f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile boolean f47017g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f47018h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f47019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Keva f47020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ECHybridItemDataShrinkConfig.b f47021c;

    public static final class a {
        public a() {
        }

        public static ECHybridItemDataShrinkConfig c() {
            return (ECHybridItemDataShrinkConfig) ECHybridItemDataShrinkHelper.f47014d.getValue();
        }

        public static boolean d(String r100) {
            Intrinsics.checkNotNullParameter(r100, "filedName");
            Map<String, String> r101 = c().getLookupMap();
            if (r101 != null) goto L5;
        L8:
            boolean r102 = true;
        L9:
            if (r102 == true) goto L19;
            Map<String, ECHybridItemDataShrinkConfig.b> r103 = c().getStrategyMap();
            if (r103 != null) goto L13;
        L16:
            boolean r104 = true;
        L17:
            if (r104 == true) goto L19;
            boolean r105 = true;
        L20:
            if (r105 == true) goto L22;
            return false;
        L22:
            if (ArraysKt.contains(c().getFiledNames(), r100) == false) goto L26;
            return true;
        L26:
            return false;
        L13:
            if (r103.isEmpty() == true) goto L16;
            r104 = false;
        L19:
            r105 = false;
            goto L20
        L5:
            if (r101.isEmpty() == true) goto L8;
            r102 = false;
            goto L9
        }

        public static ECHybridItemDataShrinkHelper b(String r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "pageName");
            kk.d.c(ECHybridItemDataShrinkHelper$Companion$deleteInvalidRepoIfNeedOnce$1.INSTANCE);
            ECHybridItemDataShrinkConfig.b r102 = c().strategyOf(r100);
            if (r102 != null) goto L7;
            return null;
        L7:
            return new ECHybridItemDataShrinkHelper("ec_hybrid_item_data_repo_of_" + r100 + '@' + r101, r102);
        }

        public static final void a(a r100, Set r101, Function2 r110) {
            r100.getClass();
            Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L21
            if (r101.isEmpty() == true) goto L19;
            Context r103 = HybridAppInfoService.f47545p.getApplicationContext();     // Catch: Throwable -> L21
            if (r103 != null) goto L9;
            r110.invoke("NULL", Boolean.FALSE);     // Catch: Throwable -> L21
            goto L19
        L9:
            File[] r104 = new PolarisFileWrapper(r103.getFilesDir().getAbsolutePath() + StringsKt.replace$default(c().getRepoPath(), ECHybridItemDataShrinkConfig.PLACEHOLDER_FILE_SEPARATOR, File.separator, false, 4, null)).listFiles(new d(r101, r110));     // Catch: Throwable -> L21
            if (r104 == null) goto L18;
            int r105 = r104.length;     // Catch: Throwable -> L21
            int r106 = 0;
        L12:
            if (r106 >= r105) goto L19;
            File r107 = r104[r106];     // Catch: Throwable -> L21
            if (r107.exists() == false) goto L16;
            r110.invoke(r107.getName(), Boolean.valueOf(FilesKt.deleteRecursively(r107)));     // Catch: Throwable -> L21
        L17:
            r106 = r106 + 1;     // Catch: Throwable -> L21
            goto L12
        L16:
            r110.invoke(r107.getName(), Boolean.TRUE);     // Catch: Throwable -> L21
            goto L17
        L18:
            r110.invoke("NULL", Boolean.FALSE);     // Catch: Throwable -> L21
        L19:
            Object r108 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L21
        L24:
            if (Result.m9452exceptionOrNullimpl(r108) == null) goto L32;
            r110.invoke("NULL", Boolean.FALSE);
            return;
        L32:
            return;
        L21:
            th = move-exception;
            Result.Companion r109 = Result.Companion;
            r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L24
        }
    }

    static {
        f47018h = new a();
        f47014d = LazyKt.lazy(ECHybridItemDataShrinkHelper$Companion$shrinkConfig$2.INSTANCE);
        f47015e = System.currentTimeMillis();
        f47016f = Keva.getRepo("ec_hybrid_item_data_repo_generate_timestamp", 0);
    }

    public ECHybridItemDataShrinkHelper(String r100, ECHybridItemDataShrinkConfig.b r101) {
        this.f47021c = r101;
        f47016f.storeLong(r100, System.currentTimeMillis());
        this.f47019a = LazyKt.lazy(ECHybridItemDataShrinkHelper$gson$2.INSTANCE);
        this.f47020b = Keva.getRepo(r100, 0);
    }

    public final List<Pair<Integer, Integer>> a(Pair<Integer, Integer> r100, Pair<Integer, Integer> r101) {
        Intrinsics.checkNotNullParameter(r100, "current");
        if (r101 == null) goto L17;
        if (this.f47021c.g() == false) goto L17;
        ArrayList r102 = new ArrayList();
        int r103 = Math.min(r100.getFirst().intValue(), r100.getSecond().intValue());
        int r104 = Math.max(r100.getFirst().intValue(), r100.getSecond().intValue());
        int r105 = Math.min(r101.getFirst().intValue(), r101.getSecond().intValue());
        int r106 = Math.max(r101.getFirst().intValue(), r101.getSecond().intValue());
        int r107 = Math.max(r103, r105);
        int r108 = Math.min(r104, r106);
        if (r107 <= r108) goto L11;
        r102.add(new Pair(Integer.valueOf(r103), Integer.valueOf(r104)));
        return r102;
    L11:
        if (r103 >= r107) goto L13;
        r102.add(new Pair(Integer.valueOf(r103), Integer.valueOf(r107 - 1)));
    L13:
        if (r104 <= r108) goto L15;
        r102.add(new Pair(Integer.valueOf(r108 + 1), Integer.valueOf(r104)));
    L15:
        return r102;
    L17:
        return CollectionsKt.listOf(r100);
    }
}
