package com.stepos.ailauncher.task.preview;

import Y8.h;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.launcher.preview.ILauncherPreviewCallback;
import h8.C4148a;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 .2\u00020\u0001:\u0002/0B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJQ\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000f\u001a\u00020\u000e2\u0010\u0010\u0011\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0010\u0010\u0013\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J#\u0010\u001c\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ3\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0010\u0010\u0013\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u001f\u0010 J=\u0010!\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0010\u0010\u0013\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u0010H\u0016¢\u0006\u0004\b!\u0010\"J!\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u001eH\u0002¢\u0006\u0004\b&\u0010'R\u001b\u0010-\u001a\u00020(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,¨\u00061"}, d2 = {"Lcom/stepos/ailauncher/task/preview/AiDesktopPreviewProvider;", "Landroid/content/ContentProvider;", "<init>", "()V", "", "onCreate", "()Z", "", "method", "arg", "Landroid/os/Bundle;", "extras", "call", "(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;", "Landroid/net/Uri;", "uri", "", "projection", "selection", "selectionArgs", "sortOrder", "Landroid/database/Cursor;", "query", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "getType", "(Landroid/net/Uri;)Ljava/lang/String;", "Landroid/content/ContentValues;", "values", "insert", "(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;", "", ChatTracker.CLICK_DELETE, "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", com.stepos.ailauncher.chat.trace.a.BUTTON_UPDATE, "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "width", "height", "Landroid/graphics/Bitmap;", "e", "(II)Landroid/graphics/Bitmap;", "Landroid/os/Handler;", "mainHandler$delegate", "LY8/h;", "c", "()Landroid/os/Handler;", "mainHandler", "Companion", "PreviewCallback", Const.INTENT_KEY_APIKEY, "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AiDesktopPreviewProvider extends ContentProvider {
    private static final long RENDER_TIMEOUT_MS = 2000;
    private static final String TAG = "AiDesktopPreviewProvider";

    /* renamed from: mainHandler$delegate, reason: from kotlin metadata */
    private final h mainHandler = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.preview.b
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return AiDesktopPreviewProvider.d();
        }
    });

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/task/preview/AiDesktopPreviewProvider$PreviewCallback;", "Lcom/stepos/launcher/preview/ILauncherPreviewCallback$Stub;", "bitmap", "Landroid/graphics/Bitmap;", "<init>", "(Landroid/graphics/Bitmap;)V", "getRenderPreview", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class PreviewCallback extends ILauncherPreviewCallback.Stub {
        private final Bitmap bitmap;

        public PreviewCallback(Bitmap bitmap) {
            p.i(bitmap, "bitmap");
            this.bitmap = bitmap;
        }

        @Override // com.stepos.launcher.preview.ILauncherPreviewCallback
        /* renamed from: getRenderPreview, reason: from getter */
        public Bitmap getBitmap() {
            return this.bitmap;
        }
    }

    public static final Handler d() {
        return new Handler(Looper.getMainLooper());
    }

    public static final void f(AtomicReference atomicReference, AiDesktopPreviewProvider aiDesktopPreviewProvider, int i10, int i11, CountDownLatch countDownLatch) {
        try {
            Context contextRequireContext = aiDesktopPreviewProvider.requireContext();
            p.h(contextRequireContext, "requireContext(...)");
            atomicReference.set(new d(contextRequireContext).a(i10, i11));
        } catch (Throwable th) {
            try {
                C4148a.g(TAG, "render preview failed", th, false, 8, null);
            } finally {
                countDownLatch.countDown();
            }
        }
    }

    public final Handler c() {
        return (Handler) this.mainHandler.getValue();
    }

    @Override // android.content.ContentProvider
    public Bundle call(String method, String arg, Bundle extras) {
        Bitmap bitmapE;
        p.i(method, "method");
        Context context = getContext();
        if (context == null) {
            return null;
        }
        C5.d.INSTANCE.g(context, "AiDesktopPreviewProvider.call:" + method);
        if (!p.d(method, "get_preview")) {
            return super.call(method, arg, extras);
        }
        Pair pairC = e.c(e.INSTANCE, extras, 0, 2, null);
        if (pairC == null || (bitmapE = e(((Number) pairC.e()).intValue(), ((Number) pairC.f()).intValue())) == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putBinder("preview_binder", new PreviewCallback(bitmapE).asBinder());
        return bundle;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        p.i(uri, "uri");
        return 0;
    }

    public final Bitmap e(final int width, final int height) {
        if (p.d(Looper.myLooper(), Looper.getMainLooper())) {
            Context contextRequireContext = requireContext();
            p.h(contextRequireContext, "requireContext(...)");
            return new d(contextRequireContext).a(width, height);
        }
        final AtomicReference atomicReference = new AtomicReference();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        c().post(new Runnable() { // from class: com.stepos.ailauncher.task.preview.c
            @Override // java.lang.Runnable
            public final void run() {
                AiDesktopPreviewProvider.f(atomicReference, this, width, height, countDownLatch);
            }
        });
        try {
            if (countDownLatch.await(2000L, TimeUnit.MILLISECONDS)) {
                return (Bitmap) atomicReference.get();
            }
            C4148a.u(TAG, "render preview timed out", false, 4, null);
            return null;
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        p.i(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues values) {
        p.i(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        p.i(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        p.i(uri, "uri");
        return 0;
    }
}
