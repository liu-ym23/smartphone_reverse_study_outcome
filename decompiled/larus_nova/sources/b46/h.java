package b46;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static d f17535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static f f17536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f17537c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final CopyOnWriteArrayList<WeakReference<e>> f17538d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicBoolean f17539e = null;

    static {
        f17537c = new AtomicBoolean(false);
        f17538d = new CopyOnWriteArrayList();
        f17539e = new AtomicBoolean(true);
    }

    public static void c(boolean r100) {
        f17539e.set(r100);
    }

    public static void a(Context r100, e r101) {
        Intrinsics.checkNotNullParameter(r100, "appContext");
        if (r101 != null) goto L6;
        return;
    L6:
        if (f17537c.get() == false) goto L9;
    L33:
        Iterator<WeakReference<e>> r102 = f17538d.iterator();
    L35:
        if (r102.hasNext() == false) goto L39;
        if (Intrinsics.areEqual(r102.next().get(), r101) == false) goto L35;
        return;
    L39:
        f17538d.add(new WeakReference(r101));
        return;
    L9:
        if (f17535a != null) goto L12;
        f17535a = new d(MediaStore.Images.Media.INTERNAL_CONTENT_URI, r100);
    L12:
        if (f17536b != null) goto L15;
        f17536b = new f(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, r100);
    L15:
        if (Build.VERSION.SDK_INT <= 28) goto L17;
        boolean r103 = true;
    L41:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L27
        ContentResolver r105 = r100.getContentResolver();     // Catch: Throwable -> L27
        Uri r106 = MediaStore.Images.Media.INTERNAL_CONTENT_URI;     // Catch: Throwable -> L27
        d r107 = f17535a;     // Catch: Throwable -> L27
        f r108 = null;
        if (r107 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("internalObserver");     // Catch: Throwable -> L27
        r107 = null;
    L21:
        r105.registerContentObserver(r106, r103, r107);     // Catch: Throwable -> L27
        ContentResolver r109 = r100.getContentResolver();     // Catch: Throwable -> L27
        Uri r110 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;     // Catch: Throwable -> L27
        f r111 = f17536b;     // Catch: Throwable -> L27
        if (r111 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("externalObserver");     // Catch: Throwable -> L27
    L25:
        r109.registerContentObserver(r110, r103, r108);     // Catch: Throwable -> L27
        Object r112 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L27
    L29:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r112);
        if (r113 == null) goto L32;
        r113.printStackTrace();
    L32:
        f17537c.set(true);
        goto L33
    L24:
        r108 = r111;
    L27:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L29
    L17:
        r103 = false;
        goto L41
    }

    public static void b(Context r100, e r101) {
        Intrinsics.checkNotNullParameter(r100, "appContext");
        if (r101 != null) goto L5;
        return;
    L5:
        Iterator<WeakReference<e>> r102 = f17538d.iterator();
    L7:
        if (r102.hasNext() == false) goto L14;
        WeakReference<e> r103 = r102.next();
        if (Intrinsics.areEqual(r103.get(), r101) == true) goto L12;
        if (r103.get() != null) goto L7;
    L12:
        f17538d.remove(r103);
        goto L7
    L14:
        if (f17538d.size() == 0) goto L16;
        return;
    L16:
        if (f17537c.get() == false) goto L40;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L27
        ContentResolver r105 = r100.getContentResolver();     // Catch: Throwable -> L27
        d r106 = f17535a;     // Catch: Throwable -> L27
        f r107 = null;
        if (r106 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("internalObserver");     // Catch: Throwable -> L27
        r106 = null;
    L21:
        r105.unregisterContentObserver(r106);     // Catch: Throwable -> L27
        ContentResolver r108 = r100.getContentResolver();     // Catch: Throwable -> L27
        f r109 = f17536b;     // Catch: Throwable -> L27
        if (r109 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("externalObserver");     // Catch: Throwable -> L27
    L25:
        r108.unregisterContentObserver(r107);     // Catch: Throwable -> L27
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L27
    L29:
        f17537c.set(false);
        return;
    L24:
        r107 = r109;
    L27:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L29
    }
}
