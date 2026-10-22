package com.bytedance.android.livesdk.jsbridge.methods.subscribe;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.util.Base64;
import com.bytedance.android.live.browser.jsbridge.base.SelectMediaResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.model.SimpleMediaInfo;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.functions.Function;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import w20.wd;

/* JADX INFO: loaded from: classes9.dex */
public final class f<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ wd f142196a;

    public f(wd r100) {
        this.f142196a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r110) {
        List r111 = (List) r110;
        Intrinsics.checkNotNullParameter(r111, "it");
        int r100 = d.f142194a;
        boolean r101 = Intrinsics.areEqual(this.f142196a.h(), Boolean.TRUE);
        Intrinsics.checkNotNullParameter(r111, "originList");
        ArrayList r102 = new ArrayList();
        Iterator r112 = r111.iterator();
    L4:
        if (r112.hasNext() == false) goto L43;
        SimpleMediaInfo r103 = (SimpleMediaInfo) r112.next();
        SelectMediaResultModel.b r104 = new SelectMediaResultModel.b();
        r103.getClass();
        r104.c();
        r104.f(r103.f106900a);
        String r105 = r103.f106907h;
        boolean r106 = false;
        if (r105 == null) goto L12;
        String r107 = r105.toLowerCase(Locale.getDefault());
        if (r107 == null) goto L12;
        if (StringsKt.contains$default(r107, "video", false, 2, null) != true) goto L12;
        boolean r108 = true;
    L13:
        if (r108 == false) goto L15;
        String r109 = "video";
    L16:
        r104.h(r109);
        r104.d(r103.f106904e);
        r104.e(Long.valueOf(r103.f106905f));
        r104.g(Integer.valueOf(r103.f106902c));
        r104.j(Integer.valueOf(r103.f106903d));
        String r113 = r103.f106907h;
        if (r113 == null) goto L23;
        String r114 = r113.toLowerCase(Locale.getDefault());
        if (r114 == null) goto L23;
        if (StringsKt.contains$default(r114, "video", false, 2, null) != true) goto L23;
        r106 = true;
    L23:
        if (r106 == false) goto L26;
        SelectMediaResultModel.c r115 = new SelectMediaResultModel.c();
        r115.b(Long.valueOf(r103.f106901b));
        r104.i(r115);
    L26:
        if (Intrinsics.areEqual(r104.a(), "video") == false) goto L42;
        if (r101 == false) goto L42;
        SelectMediaResultModel.c r116 = r104.b();
        if (r116 == null) goto L42;
        String r117 = r103.f106900a;
        if (r117 != null) goto L44;
    L40:
        String r118 = "";
    L41:
        r116.a(r118);
        goto L42
    L44:
        MediaMetadataRetriever r119 = new MediaMetadataRetriever();     // Catch: Throwable -> L38
        r119.setDataSource(s1.getContext(), UriProtector.parse(r117));     // Catch: Throwable -> L38
        Bitmap r120 = r119.getFrameAtTime(0, 3);     // Catch: Throwable -> L38
        if (r120 == null) goto L40;
        ByteArrayOutputStream r121 = new ByteArrayOutputStream();     // Catch: Throwable -> L38
        r120.compress(Bitmap.CompressFormat.JPEG, 30, r121);     // Catch: Throwable -> L38
        r118 = Base64.encodeToString(r121.toByteArray(), 2);     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        ALogger.e("CoverUtils", th);
    L42:
        r102.add(r104);
        goto L4
    L15:
        r109 = "image";
    L12:
        r108 = false;
        goto L13
    L43:
        return r102;
    }
}
