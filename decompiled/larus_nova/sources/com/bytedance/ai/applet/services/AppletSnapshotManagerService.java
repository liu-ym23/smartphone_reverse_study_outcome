package com.bytedance.ai.applet.services;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.larus.nova.R;
import com.ss.android.downloadlib.constants.MimeType;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.bduploader.BDVideoUploaderBase;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes43.dex */
public final class AppletSnapshotManagerService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AppletSnapshotManagerService f35190a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f35191b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LinkedHashMap<String, b> f35192c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Handler f35193d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f35194e = null;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/applet/services/AppletSnapshotManagerService$SnapshotTooLargeException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "message", "", "<init>", "(Ljava/lang/String;)V", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SnapshotTooLargeException extends RuntimeException {
        public SnapshotTooLargeException(String r100) {
            Intrinsics.checkNotNullParameter(r100, "message");
            super(r100);
        }
    }

    public static final class a extends ByteArrayOutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f35195a;

        public a() {
            this.f35195a = 8388608;
        }

        public final void a(int r100) {
            if ((((long) ((ByteArrayOutputStream) this).count) + ((long) r100)) > this.f35195a) goto L6;
            return;
        L6:
            throw new SnapshotTooLargeException("compressed snapshot exceeds " + this.f35195a + " bytes");
        }

        @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
        public final void write(int r100) {
            a(1);
            super.write(r100);
        }

        @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
        public final void write(byte[] r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "buffer");
            a(r102);
            super.write(r100, r101, r102);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f35196a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f35197b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f35198c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f35199d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f35200e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f35201f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long f35202g;

        public b(String r100, String r101, String r102, String r103, int r104, int r105, long r106) {
            Intrinsics.checkNotNullParameter(r100, "snapshotId");
            Intrinsics.checkNotNullParameter(r102, "imageBase64");
            Intrinsics.checkNotNullParameter(r103, DBDefinition.MIME_TYPE);
            this.f35196a = r100;
            this.f35197b = r101;
            this.f35198c = r102;
            this.f35199d = r103;
            this.f35200e = r104;
            this.f35201f = r105;
            this.f35202g = r106;
        }
    }

    public AppletSnapshotManagerService() {
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.bytedance.ai.applet.services.c] */
    static {
        f35190a = new AppletSnapshotManagerService();
        f35191b = new Object();
        f35192c = new LinkedHashMap();
        f35193d = new Handler(Looper.getMainLooper());
        f35194e = new c();
    }

    public static void h() {
        f35193d.removeCallbacks(f35194e);
        Iterator<T> r100 = f35192c.values().iterator();
        if (r100.hasNext() == true) goto L5;
        Long r101 = null;
    L12:
        if (r101 == null) goto L20;
        long r102 = r101.longValue();
        com.bytedance.ai.applet.base.log.b r103 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.c("AppletSnapshotManagerService", "scheduleNextExpirationLocked: earliestExpireAtMillis=" + r102);
        f35193d.postAtTime(f35194e, r102);
        return;
    L20:
        return;
    L5:
        Long r104 = Long.valueOf(((b) r100.next()).f35202g + 30000);
    L7:
        if (r100.hasNext() == false) goto L11;
        Long r105 = Long.valueOf(((b) r100.next()).f35202g + 30000);
        if (r104.compareTo(r105) <= 0) goto L7;
        r104 = r105;
        goto L7
    L11:
        r101 = r104;
        goto L12
    }

    public static void g() {
        long r100 = SystemClock.uptimeMillis();
        Iterator<Map.Entry<String, b>> r101 = f35192c.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        b r102 = r101.next().getValue();
        if ((r100 - r102.f35202g) < 30000) goto L4;
        com.bytedance.ai.applet.base.log.b r103 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.c("AppletSnapshotManagerService", "removeExpiredLocked: snapshotId=" + r102.f35196a + ", createdAtMillis=" + r102.f35202g);
        r101.remove();
        goto L4
    }

    public static void f(b r100) {
        Object r101 = f35191b;
        monitor-enter(r101);
        g();     // Catch: Throwable -> L20
        f35192c.remove(r100.f35196a);     // Catch: Throwable -> L20
    L5:
        LinkedHashMap<String, b> r102 = f35192c;     // Catch: Throwable -> L20
        if (r102.size() < 10) goto L8;
        r102.remove((String) ((Map.Entry) CollectionsKt.first(r102.entrySet())).getKey());     // Catch: Throwable -> L20
    L8:
        LinkedHashMap<String, b> r103 = f35192c;     // Catch: Throwable -> L20
        if ((!r103.isEmpty()) == false) goto L17;
        Iterator<T> r104 = r103.values().iterator();     // Catch: Throwable -> L20
        long r105 = 0;
    L12:
        if (r104.hasNext() == false) goto L15;
        r105 = r105 + (((long) ((b) r104.next()).f35198c.length()) * 2);     // Catch: Throwable -> L20
        goto L12
    L15:
        if ((r105 + (((long) r100.f35198c.length()) * 2)) <= 25165824) goto L17;
        LinkedHashMap<String, b> r106 = f35192c;     // Catch: Throwable -> L20
        r106.remove((String) ((Map.Entry) CollectionsKt.first(r106.entrySet())).getKey());     // Catch: Throwable -> L20
    L17:
        f35192c.put(r100.f35196a, r100);     // Catch: Throwable -> L20
        h();     // Catch: Throwable -> L20
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r101);
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public static boolean a(String r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "snapshotId");
        Intrinsics.checkNotNullParameter(r111, "messageId");
        if (StringsKt.isBlank(r110) == false) goto L7;
        com.bytedance.ai.applet.base.log.a.b("AppletSnapshotManagerService", "associate failed: snapshotId is blank", null);
        return false;
    L7:
        if (StringsKt.isBlank(r111) == false) goto L10;
        com.bytedance.ai.applet.base.log.a.b("AppletSnapshotManagerService", "associate failed: messageId is blank", null);
        return false;
    L10:
        com.bytedance.ai.applet.base.log.b r100 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.c("AppletSnapshotManagerService", "associate: snapshotId=" + r110 + ", messageId=" + r111);
        Object r101 = f35191b;
        monitor-enter(r101);
        g();     // Catch: Throwable -> L21
        LinkedHashMap<String, b> r102 = f35192c;     // Catch: Throwable -> L21
        b r103 = r102.get(r110);     // Catch: Throwable -> L21
        if (r103 != null) goto L17;
        h();     // Catch: Throwable -> L21
        monitor-exit(r101);
        return false;
    L17:
        Intrinsics.checkNotNullParameter(r111, "messageId");     // Catch: Throwable -> L21
        r102.put(r110, new b(r103.f35196a, r111, r103.f35198c, r103.f35199d, r103.f35200e, r103.f35201f, r103.f35202g));     // Catch: Throwable -> L21
        h();     // Catch: Throwable -> L21
        monitor-exit(r101);
        return true;
    L21:
        th = move-exception;
        throw th;
    }

    public static d b(View r210, String r211) {
        Intrinsics.checkNotNullParameter(r210, "view");
        Intrinsics.checkNotNullParameter(r211, "snapshotId");
        if (StringsKt.isBlank(r211) == false) goto L7;
        com.bytedance.ai.applet.base.log.a.b("AppletSnapshotManagerService", "capture failed: snapshotId is blank", null);
        return null;
    L7:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L10;
        com.bytedance.ai.applet.base.log.a.b("AppletSnapshotManagerService", "capture failed: must be called on the main thread", null);
        return null;
    L10:
        com.bytedance.ai.applet.base.log.b r100 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.c("AppletSnapshotManagerService", "capture: snapshotId=" + r211);
        Bitmap r110 = e(r210, r211);     // Catch: Throwable -> L27
        if (r110 != null) goto L41;
        StringBuilder r101 = new StringBuilder("capture: finish, snapshotId=");
    L21:
        r101.append(r211);
        com.bytedance.ai.applet.base.log.a.c("AppletSnapshotManagerService", r101.toString());
        return null;
    L41:
        byte[] r102 = d(r110, r211);     // Catch: Throwable -> L23
        if (r102 != null) goto L18;
        r110.recycle();
        r101 = new StringBuilder("capture: finish, snapshotId=");
        goto L21
    L18:
        if (r102.length <= 8388608) goto L25;
        com.bytedance.ai.applet.base.log.a.d("AppletSnapshotManagerService", "capture skipped: snapshot is too large, snapshotId=" + r211 + ", bytes=" + r102.length, null);     // Catch: Throwable -> L23
        r110.recycle();
        r101 = new StringBuilder("capture: finish, snapshotId=");
        goto L21
    L25:
        b r103 = new b(r211, null, Base64.encodeToString(r102, 2), MimeType.WEBP, r110.getWidth(), r110.getHeight(), SystemClock.uptimeMillis());     // Catch: Throwable -> L23
        f(r103);     // Catch: Throwable -> L23
        d r104 = new d(r103.f35196a, r103.f35199d, r103.f35198c, r103.f35200e, r103.f35201f);     // Catch: Throwable -> L23
        r110.recycle();
        com.bytedance.ai.applet.base.log.a.c("AppletSnapshotManagerService", "capture: finish, snapshotId=".concat(r211));
        return r104;
    L23:
        th = th;
    L42:
        com.bytedance.ai.applet.base.log.b r105 = com.bytedance.ai.applet.base.log.a.f34518a;     // Catch: Throwable -> L34
        com.bytedance.ai.applet.base.log.a.b("AppletSnapshotManagerService", "capture failed, snapshotId=" + r211, th);     // Catch: Throwable -> L34
        if (r110 == null) goto L32;
        r110.recycle();
    L32:
        com.bytedance.ai.applet.base.log.a.c("AppletSnapshotManagerService", "capture: finish, snapshotId=" + r211);
        return null;
    L34:
        th = move-exception;
        if (r110 == null) goto L37;
        r110.recycle();
    L37:
        com.bytedance.ai.applet.base.log.b r106 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.c("AppletSnapshotManagerService", "capture: finish, snapshotId=" + r211);
        throw th;
    L27:
        th = th;
        r110 = null;
        goto L42
    }

    public static void c(View r100, List r101) {
        if (r100.getVisibility() == 0) goto L5;
        return;
    L5:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (Intrinsics.areEqual(r100.getTag(R.id.applet_snapshot_excluded), Boolean.TRUE) == false) goto L10;
        ((ArrayList) r101).add(r100);
        return;
    L10:
        if ((r100 instanceof ViewGroup) == false) goto L14;
        ViewGroup r102 = (ViewGroup) r100;
        int r103 = r102.getChildCount();
        int r104 = 0;
    L12:
        if (r104 >= r103) goto L16;
        c(r102.getChildAt(r104), r101);
        r104 = r104 + 1;
        goto L12
    L16:
        return;
    }

    public static byte[] d(Bitmap r100, String r101) {
        if (Build.VERSION.SDK_INT < 30) goto L5;
        Bitmap.CompressFormat r102 = Bitmap.CompressFormat.WEBP_LOSSLESS;
    L6:
        a r103 = new a();
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CloseableKt.closeFinally(r103, th);
        throw th;
    L8:
        if (r100.compress(r102, 100, r103) == true) goto L12;
        com.bytedance.ai.applet.base.log.b r104 = com.bytedance.ai.applet.base.log.a.f34518a;     // Catch: Throwable -> L15
        com.bytedance.ai.applet.base.log.a.b("AppletSnapshotManagerService", "capture failed: failed to compress lossless WebP, snapshotId=" + r101, null);     // Catch: Throwable -> L15
        CloseableKt.closeFinally(r103, null);
        return null;
    L12:
        byte[] r105 = r103.toByteArray();     // Catch: Throwable -> L15
        CloseableKt.closeFinally(r103, null);
        return r105;
    L5:
        r102 = Bitmap.CompressFormat.WEBP;
        goto L6
    }

    public static Bitmap e(View r100, String r101) {
        int r102 = r100.getWidth();
        int r103 = r100.getHeight();
        if (r102 <= 0) goto L36;
        if (r103 <= 0) goto L36;
        Integer r104 = Integer.valueOf(BDVideoUploaderBase.KeyIsDynamicSliceLowSize);
        if (r102 > r103) goto L9;
        Pair r105 = TuplesKt.to(r104, Integer.valueOf(RangesKt.coerceAtLeast(MathKt.roundToInt((((double) r103) * 448.0d) / ((double) r102)), 1)));
    L10:
        int r106 = ((Number) r105.component1()).intValue();
        int r107 = ((Number) r105.component2()).intValue();
        Bitmap r108 = Bitmap.createBitmap(r106, r107, Bitmap.Config.ARGB_8888);
        Canvas r109 = new Canvas(r108);
        r109.scale(r106 / r102, r107 / r103);
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (Intrinsics.areEqual(r100.getTag(R.id.applet_snapshot_excluded), Boolean.TRUE) == true) goto L29;
        ArrayList r110 = new ArrayList();
        c(r100, r110);
        if (r110.isEmpty() == false) goto L16;
        r100.draw(r109);
        goto L29
    L16:
        ArrayList r111 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10));
        Iterator r112 = r110.iterator();
    L18:
        if (r112.hasNext() == false) goto L38;
        View r113 = (View) r112.next();
        r111.add(TuplesKt.to(r113, Float.valueOf(r113.getAlpha())));
        goto L18
    L38:
        Iterator r114 = r110.iterator();     // Catch: Throwable -> L30
    L22:
        if (r114.hasNext() == false) goto L24;
        ((View) r114.next()).setAlpha(0.0f);     // Catch: Throwable -> L30
        goto L22
    L24:
        r100.draw(r109);     // Catch: Throwable -> L30
        Iterator r115 = r111.iterator();
    L27:
        if (r115.hasNext() == false) goto L29;
        Pair r116 = (Pair) r115.next();
        ((View) r116.component1()).setAlpha(((Number) r116.component2()).floatValue());
    L30:
        th = move-exception;
        Iterator r117 = r111.iterator();
    L33:
        if (r117.hasNext() == false) goto L35;
        Pair r118 = (Pair) r117.next();
        ((View) r118.component1()).setAlpha(((Number) r118.component2()).floatValue());
        goto L33
    L35:
        throw th;
    L29:
        return r108;
    L9:
        r105 = TuplesKt.to(Integer.valueOf(RangesKt.coerceAtLeast(MathKt.roundToInt((((double) r102) * 448.0d) / ((double) r103)), 1)), r104);
    L36:
        com.bytedance.ai.applet.base.log.b r119 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.b("AppletSnapshotManagerService", "capture failed: view is not laid out, snapshotId=" + r101 + ", size=" + r102 + Permission.EXECUTE + r103, null);
        return null;
    }

    public final Object i(String r100, Continuation<? super Result<e>> r101) {
        if ((r101 instanceof AppletSnapshotManagerService$upload$1) == false) goto L7;
        AppletSnapshotManagerService$upload$1 r102 = (AppletSnapshotManagerService$upload$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L18:
        return ((Result) r104).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        CoroutineDispatcher r107 = Dispatchers.getIO();
        AppletSnapshotManagerService$upload$2 r108 = new AppletSnapshotManagerService$upload$2(r100, null);
        r102.label = 1;
        r104 = BuildersKt.withContext(r107, r108, r102);
        if (r104 != r105) goto L18;
        return r105;
    L7:
        r102 = new AppletSnapshotManagerService$upload$1(this, r101);
        goto L8
    }
}
