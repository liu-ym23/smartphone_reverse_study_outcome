package com.bytedance.android.shopping.deepfeed.slice.view.lottie;

import android.content.Context;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.t;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.inv.export.router.InvRouter;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class DeepFeedCouponLottieCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DeepFeedCouponLottieCache f173621a = null;

    public static final class a implements Runnable {
    }

    public DeepFeedCouponLottieCache() {
    }

    static {
        f173621a = new DeepFeedCouponLottieCache();
    }

    public static PolarisFileWrapper b(String r110) {
        Context r100 = ECAppInfoService.f48114e.getApplicationContext();
        String r101 = null;
        if (r100 != null) goto L24;
        return null;
    L24:
        byte[] r102 = r110.getBytes();     // Catch: Exception -> L15
        MessageDigest r103 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L12
        r103.update(r102);     // Catch: Exception -> L12
        byte[] r104 = r103.digest();     // Catch: Exception -> L12
        char[] r105 = new char[32];     // Catch: Exception -> L12
        int r106 = 0;
        int r107 = 0;
    L8:
        if (r106 >= 16) goto L10;
        byte r108 = r104[r106];     // Catch: Exception -> L12
        int r109 = r107 + 1;     // Catch: Exception -> L12
        char[] r111 = t.f45719a;     // Catch: Exception -> L12
        r105[r107] = r111[(r108 >>> 4) & 15];     // Catch: Exception -> L12
        r107 = r109 + 1;     // Catch: Exception -> L12
        r105[r109] = r111[r108 & 15];     // Catch: Exception -> L12
        r106 = r106 + 1;     // Catch: Exception -> L12
        goto L8
    L10:
        r101 = new String(r105);     // Catch: Exception -> L12
    L17:
        if (r101 != null) goto L20;
        r101 = "";
    L20:
        if (StringsKt.isBlank(r101) == false) goto L23;
        r101 = String.valueOf(r110.hashCode());
    L23:
        return new PolarisFileWrapper(r100.getCacheDir(), "deep_feed_coupon_lottie/" + r101 + InvRouter.FLOW_SUFFIX);
    L12:
        e = move-exception;
        ECExceptionMonitor.e(e);     // Catch: Exception -> L15
    L15:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L17
    }

    public static void c(List r100) {
        Intrinsics.checkNotNullParameter(r100, "urls");
        Iterator r101 = SequencesKt.distinct(SequencesKt.filter(SequencesKt.map(CollectionsKt.asSequence(r100), DeepFeedCouponLottieCache$deleteCachedFiles$1.INSTANCE), DeepFeedCouponLottieCache$deleteCachedFiles$2.INSTANCE)).iterator();
    L4:
        if (r101.hasNext() == false) goto L20;
        String r102 = (String) r101.next();
        DeepFeedCouponLottieCache r103 = f173621a;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L18
        r103.getClass();     // Catch: Throwable -> L18
        int r105 = ed3.b.f472197a;     // Catch: Throwable -> L18
        Intrinsics.checkNotNullParameter(r102, "key");     // Catch: Throwable -> L18
        Intrinsics.checkNotNullParameter("", "default");     // Catch: Throwable -> L18
        PolarisFileWrapper r106 = null;
        if (StringsKt.isBlank("") == false) goto L9;
        PolarisFileWrapper r107 = null;
    L10:
        if (r107 != null) goto L12;
    L16:
        Intrinsics.checkNotNullParameter(r102, "key");     // Catch: Throwable -> L18
        Intrinsics.checkNotNullParameter("", "value");     // Catch: Throwable -> L18
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L18
        goto L4
    L12:
        if (r107.exists() == false) goto L14;
        r106 = r107;
    L14:
        if (r106 == null) goto L16;
        r106.delete();     // Catch: Throwable -> L18
        goto L16
    L9:
        r107 = new PolarisFileWrapper("");     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L4
    }

    public static void d(List r100) {
        Intrinsics.checkNotNullParameter(r100, "urls");
        Iterator r101 = SequencesKt.distinct(SequencesKt.filter(SequencesKt.map(CollectionsKt.asSequence(r100), DeepFeedCouponLottieCache$preload$1.INSTANCE), DeepFeedCouponLottieCache$preload$2.INSTANCE)).iterator();
    L4:
        if (r101.hasNext() == false) goto L14;
        final String r102 = (String) r101.next();
        f173621a.getClass();
        int r103 = ed3.b.f472197a;
        Intrinsics.checkNotNullParameter(r102, "key");
        Intrinsics.checkNotNullParameter("", "default");
        if (StringsKt.isBlank("") == false) goto L8;
        PolarisFileWrapper r104 = null;
    L9:
        if (r104 == null) goto L13;
        if (r104.exists() == true) goto L4;
    L13:
        int r105 = DeepFeedLottieUrlLoader.f173622a;
        DeepFeedLottieUrlLoader.b(r102, new DeepFeedCouponLottieCache$preload$3$1(r102), DeepFeedCouponLottieCache$preload$3$2.INSTANCE);
        goto L4
    L8:
        r104 = new PolarisFileWrapper("");
        goto L9
    }

    public static final void a(DeepFeedCouponLottieCache r100, String r101, String r102) {
        r100.getClass();
        if (StringsKt.isBlank(r102) == true) goto L19;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L13
        PolarisFileWrapper r104 = b(r101);     // Catch: Throwable -> L13
        if (r104 == null) goto L18;
        File r105 = r104.getParentFile();     // Catch: Throwable -> L13
        if (r105 == null) goto L11;
        r105.mkdirs();     // Catch: Throwable -> L13
    L11:
        FilesKt.writeText(r104, r102, StandardCharsets.UTF_8);     // Catch: Throwable -> L13
        int r106 = ed3.b.f472197a;     // Catch: Throwable -> L13
        String r107 = r104.getAbsolutePath();     // Catch: Throwable -> L13
        Intrinsics.checkNotNullParameter(r101, "key");     // Catch: Throwable -> L13
        Intrinsics.checkNotNullParameter(r107, "value");     // Catch: Throwable -> L13
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L13
        return;
    L18:
        return;
    L13:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    }
}
