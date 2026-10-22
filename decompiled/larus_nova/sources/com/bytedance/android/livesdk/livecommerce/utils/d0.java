package com.bytedance.android.livesdk.livecommerce.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.io.File;
import java.util.Comparator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class d0<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f0 f153072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f153073b;

    public static final class a<T> implements Comparator<T> {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Long.valueOf(((File) r101).lastModified()), Long.valueOf(((File) r100).lastModified()));
        }
    }

    public d0(f0 r100, String r101) {
        this.f153072a = r100;
        this.f153073b = r101;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<String> r110) {
        Intrinsics.checkNotNullParameter(r110, "emitter");
        File[] r100 = new PolarisFileWrapper(this.f153073b).listFiles();     // Catch: Exception -> L43
        if (r100 == null) goto L6;
        List r101 = ArraysKt.sortedWith(r100, new a());     // Catch: Exception -> L43
    L7:
        if (r101 == null) goto L42;
        if ((!r101.isEmpty()) == false) goto L42;
        if (((File) ListProtector.get(r101, 0)).isFile() == false) goto L42;
        String r102 = ((File) ListProtector.get(r101, 0)).getPath();     // Catch: Exception -> L43
        int r103 = g0.f153082a;     // Catch: Exception -> L43
        long r104 = new PolarisFileWrapper(r102).length();     // Catch: Exception -> L43
        long r105 = System.currentTimeMillis();     // Catch: Exception -> L43
    L13:
        Thread.sleep(300);     // Catch: Exception -> L43
        long r106 = new PolarisFileWrapper(r102).length();     // Catch: Exception -> L43
        if (r104 == r106) goto L18;
        if ((System.currentTimeMillis() - r105) > 15000) goto L18;
        r104 = r106;
    L18:
        System.currentTimeMillis();     // Catch: Exception -> L43
        Bitmap r107 = BitmapFactory.decodeFile(r102);     // Catch: Exception -> L43
        int r108 = g0.f153082a;     // Catch: Exception -> L43
        int r109 = r107.getWidth() - 1;     // Catch: Exception -> L43
        if (r109 <= 0) goto L36;
        int r111 = r107.getWidth();     // Catch: Exception -> L43
        int r112 = r107.getHeight();     // Catch: Exception -> L43
        if (r111 <= r109) goto L37;
        if (r112 <= r109) goto L37;
        int r113 = (Math.max(r111, r112) * r109) / Math.min(r111, r112);     // Catch: Exception -> L43
        if (r111 <= r112) goto L27;
        int r114 = r113;
    L28:
        if (r111 <= r112) goto L47;
        r113 = r109;
    L47:
        Bitmap r115 = Bitmap.createScaledBitmap(r107, r114, r113, true);     // Catch: Exception -> L35
        Bitmap r116 = Bitmap.createBitmap(r115, (r114 - r109) / 2, (r113 - r109) / 2, r109, r109);     // Catch: Exception -> L35
        r115.recycle();     // Catch: Exception -> L35
        r107 = r116;
        goto L37
    L27:
        r114 = r109;
    L37:
        if (r107 == null) goto L39;
        g0.a(r102, r107);     // Catch: Exception -> L43
    L39:
        r110.onNext(r102);     // Catch: Exception -> L43
        return;
    L36:
        r107 = null;
    L42:
        throw new RuntimeException("folder has no image , path：" + this.f153073b);     // Catch: Exception -> L43
    L6:
        r101 = null;
    L43:
        e = move-exception;
        ECExceptionMonitor.e(e);
        this.f153072a.f153080b.invoke(null, "folder has no image");
    }
}
