package com.bytedance.android.livesdk.jsbridge.methods;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import com.bytedance.android.live.browser.jsbridge.base.OpenMultiSelectPhotoLibraryResultModel;
import com.bytedance.android.livesdkapi.model.LinkMediaModel;
import com.bytedance.bpea.cert.token.TokenCert;
import com.ss.android.ttvecamera.TECameraUtils;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class y2<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w2 f142252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f142253b;

    public y2(w2 r100, List r101) {
        this.f142252a = r100;
        this.f142253b = r101;
    }

    @Override // java.util.concurrent.Callable
    public final List<OpenMultiSelectPhotoLibraryResultModel.b> call() {
        w2 r100 = this.f142252a;
        List r101 = this.f142253b;
        TokenCert r102 = w2.f142233c;
        r100.getClass();
        ArrayList r103 = new ArrayList();
        if (r101 == null) goto L24;
        Iterator r104 = r101.iterator();
    L6:
        if (r104.hasNext() == false) goto L24;
        LinkMediaModel r105 = (LinkMediaModel) r104.next();
        String r106 = r105.getFileLocalUriPath();
        if (r106 == null) goto L6;
        int r107 = com.bytedance.android.livesdk.utils.h2.f158969a;
        long r108 = r105.getFileSize();
        long r109 = r100.f142234a;
        Intrinsics.checkNotNullParameter(r106, "imageFilePath");
        BitmapFactory.Options r110 = new BitmapFactory.Options();
        int r111 = 1;
        r110.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(r106, r110);
        int r112 = r110.outWidth;
        int r113 = r110.outHeight;
        if (r112 > 1080) goto L12;
        if (r113 > 1920) goto L12;
    L13:
        r110.inSampleSize = r111;
        r110.inJustDecodeBounds = false;
        Bitmap r114 = BitmapFactory.decodeFile(r106, r110);
        ByteArrayOutputStream r115 = new ByteArrayOutputStream();
        long r116 = r109 * ((long) 1024);
        if (r108 <= 20971520) goto L17;
        int r117 = 60;
    L23:
        r114.compress(Bitmap.CompressFormat.JPEG, r117, r115);
        byte[] r118 = r115.toByteArray();
        int r119 = r118.length;
        String r120 = Base64.encodeToString(r118, 2);
        OpenMultiSelectPhotoLibraryResultModel.b r121 = new OpenMultiSelectPhotoLibraryResultModel.b();
        r121.b(r120);
        r121.c(r120);
        Unit r122 = Unit.INSTANCE;
        r103.add(r121);
        goto L6
    L17:
        if (r108 <= 15728640) goto L20;
        r117 = 70;
        goto L23
    L20:
        if (r108 <= r116) goto L22;
        r117 = 80;
        goto L23
    L22:
        r117 = 85;
    L12:
        r111 = Math.min(Math.round(r112 / 1080), Math.round(r113 / TECameraUtils.CAPTURE_NORMAL));
    L24:
        return r103;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
