package com.google.android.gms.common.images;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.C1661b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import w2.C5721e;
import w2.i;

/* loaded from: classes2.dex */
public final class ImageManager {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f19724a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final HashSet f19725b = new HashSet();

    @KeepName
    public final class ImageReceiver extends ResultReceiver {
        final /* synthetic */ ImageManager zaa;
        private final Uri zab;
        private final ArrayList zac;

        public ImageReceiver(ImageManager imageManager, Uri uri) {
            super(new i(Looper.getMainLooper()));
            this.zab = uri;
            this.zac = new ArrayList();
        }

        @Override // android.os.ResultReceiver
        public final void onReceiveResult(int i10, Bundle bundle) {
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor");
            ImageManager.i(null).execute(new a(null, this.zab, parcelFileDescriptor));
        }

        public final void zab(c cVar) {
            C1661b.a("ImageReceiver.addImageRequest() must be called in the main thread");
            this.zac.add(cVar);
        }

        public final void zac(c cVar) {
            C1661b.a("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.zac.remove(cVar);
        }

        public final void zad() {
            Intent intent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
            intent.setPackage("com.google.android.gms");
            intent.putExtra("com.google.android.gms.extras.uri", this.zab);
            intent.putExtra("com.google.android.gms.extras.resultReceiver", this);
            intent.putExtra("com.google.android.gms.extras.priority", 3);
            ImageManager.a(null).sendBroadcast(intent);
        }
    }

    public static /* bridge */ /* synthetic */ Context a(ImageManager imageManager) {
        throw null;
    }

    public static /* bridge */ /* synthetic */ Handler b(ImageManager imageManager) {
        throw null;
    }

    public static /* bridge */ /* synthetic */ C5721e c(ImageManager imageManager) {
        throw null;
    }

    public static /* bridge */ /* synthetic */ Map f(ImageManager imageManager) {
        throw null;
    }

    public static /* bridge */ /* synthetic */ Map g(ImageManager imageManager) {
        throw null;
    }

    public static /* bridge */ /* synthetic */ Map h(ImageManager imageManager) {
        throw null;
    }

    public static /* bridge */ /* synthetic */ ExecutorService i(ImageManager imageManager) {
        throw null;
    }
}
