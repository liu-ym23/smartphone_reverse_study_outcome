package com.bytedance.android.livesdk.chatroom.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.JsonReader;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieListener;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.z5;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.gecko.offline.OfflineResourceClient;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import java.io.File;
import java.util.zip.ZipInputStream;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class i2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f114501a = null;

    public static final class a implements com.airbnb.lottie.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Pair f114502a;

        public a(Pair r100) {
            this.f114502a = r100;
        }

        @Override // com.airbnb.lottie.d
        public final Bitmap q(com.airbnb.lottie.h r100) {
            return BitmapFactory.decodeFile(((String) this.f114502a.getFirst()) + '/' + r100.f24781d);
        }
    }

    public static final class b implements OfflineResourceClient.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f114503a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LottieAnimationView f114504b;

        public static final class a<T> implements LottieListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f114505a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Ref.ObjectRef f114506b;

            public a(b r100, Ref.ObjectRef r101) {
                this.f114505a = r100;
                this.f114506b = r101;
            }

            @Override // com.airbnb.lottie.LottieListener
            public final void onResult(Object r100) {
                LottieComposition r101 = (LottieComposition) r100;
                if (r101 == null) goto L5;
                this.f114505a.f114504b.setComposition(r101);
                this.f114505a.f114504b.loop(true);
                this.f114505a.f114504b.playAnimation();
            L5:
                ((ZipInputStream) this.f114506b.element).close();
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.utils.i2$b$b, reason: collision with other inner class name */
        public static final class C1690b<T> implements LottieListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Ref.ObjectRef f114507a;

            public C1690b(Ref.ObjectRef r100) {
                this.f114507a = r100;
            }

            @Override // com.airbnb.lottie.LottieListener
            public final void onResult(Object r100) {
                Throwable r101 = (Throwable) r100;
                ((ZipInputStream) this.f114507a.element).close();
                StringBuilder r102 = new StringBuilder("result:");
                if (r101 == null) goto L5;
                String r103 = r101.getMessage();
            L6:
                r102.append(r103);
                ALogger.d("OfflineImageUtils", r102.toString());
                return;
            L5:
                r103 = null;
                goto L6
            }
        }

        @Override // com.bytedance.android.livesdk.gecko.offline.OfflineResourceClient.a
        public final void onError(Throwable r100) {
            StringBuilder r101 = new StringBuilder("download ");
            r101.append(this.f114503a);
            r101.append(" failed, ");
            if (r100 == null) goto L5;
            String r102 = r100.getMessage();
        L6:
            r101.append(r102);
            ALogger.e("OfflineImageUtils", r101.toString());
            return;
        L5:
            r102 = null;
            goto L6
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v0, types: [T, java.util.zip.ZipInputStream] */
        @Override // com.bytedance.android.livesdk.gecko.offline.OfflineResourceClient.a
        public final void onSuccess(String r100) {
            ALogger.i("OfflineImageUtils", "download " + this.f114503a + " success, filePath = " + r100);
            String r101 = i2.f114501a;
            if (r100 != null) goto L5;
        L8:
            boolean r102 = true;
        L10:
            if ((true ^ r102) == false) goto L22;
            Ref.ObjectRef r103 = new Ref.ObjectRef();
            r103.element = null;
            ?? r104 = new ZipInputStream(new PolarisFileInputStreamWrapper(r100));     // Catch: Exception -> L14
            r103.element = r104;     // Catch: Exception -> L14
            ZipInputStream r105 = (ZipInputStream) r104;     // Catch: Exception -> L14
            LottieCompositionFactory.fromZipStream(r104, null).addListener(new a(this, r103)).addFailureListener(new C1690b(r103));     // Catch: Exception -> L14
            return;
        L14:
            e = move-exception;
            ZipInputStream r106 = (ZipInputStream) r103.element;
            if (r106 == null) goto L18;
            r106.close();
        L18:
            ALogger.d("OfflineImageUtils", "e:" + e.getMessage());
            return;
        L22:
            return;
        L5:
            if (StringsKt.isBlank(r100) == true) goto L8;
            r102 = false;
            goto L10
        }

        public b(String r100, LottieAnimationView r101) {
            this.f114503a = r100;
            this.f114504b = r101;
        }
    }

    static {
        StringBuilder r100 = new StringBuilder("https://");
        IMiddleWareHostContext r101 = (IMiddleWareHostContext) jc1.k.f(IMiddleWareHostContext.class);
        boolean r102 = false;
        if (r101 == null) goto L8;
        if (r101.isBoe() == false) goto L8;
        String r103 = "tosv-boe.byted.org";
    L14:
        r100.append(r103);
        r100.append("/obj/");
        IMiddleWareHostContext r104 = (IMiddleWareHostContext) jc1.k.f(IMiddleWareHostContext.class);
        if (r104 == null) goto L20;
        if (r104.isBoe() == false) goto L20;
        String r105 = "gecko-internal/10893";
    L26:
        r100.append(r105);
        r100.append("/gecko/resource/webcast_native_resource_douyin");
        f114501a = r100.toString();
        return;
    L20:
        if (z5.f65472a.getValue().booleanValue() == true) goto L23;
        r102 = com.bytedance.android.live.core.utils.v.a();
    L23:
        if (r102 == false) goto L25;
        r105 = "gecko-internal/10180";
        goto L26
    L25:
        r105 = "byte-gurd-source/10181";
    L8:
        if (z5.f65472a.getValue().booleanValue() == false) goto L10;
        boolean r106 = false;
    L11:
        if (r106 == false) goto L13;
        r103 = "tosv.byted.org";
        goto L14
    L13:
        r103 = "lf-webcast-sourcecdn-tos.bytegecko.com";
        goto L14
    L10:
        r106 = com.bytedance.android.live.core.utils.v.a();
        goto L11
    }

    public static Pair a(String r100) {
        if (r100 == null) goto L5;
        String r101 = b(r100);
        File r102 = com.bytedance.android.livesdk.gecko.offline.f.a(r101);
        if (r102 == null) goto L13;
        Bitmap r103 = BitmapFactory.decodeFile(r102.getAbsolutePath());
        if (r103 == null) goto L13;
        ALogger.e("OfflineImageUtils", r100.concat("_命中离线资源"));
        return TuplesKt.to(r103, r101);
    L13:
        return TuplesKt.to(null, r101);
    L5:
        return TuplesKt.to(null, null);
    }

    public static String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return f114501a + r100;
    }

    @JvmStatic
    public static final Uri c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        String r101 = b(r100);
        File r102 = com.bytedance.android.livesdk.gecko.offline.f.a(r101);
        if (r102 == null) goto L5;
        Uri r103 = Uri.fromFile(r102);
    L6:
        ALogger.i("OfflineImageUtils", "离线文件地址为" + r103);
        return r103;
    L5:
        r103 = UriProtector.parse(r101);
        goto L6
    }

    @JvmStatic
    public static final Uri d(String r100) {
        Intrinsics.checkNotNullParameter("/drawer/", "geckoPath");
        Intrinsics.checkNotNullParameter(r100, "assetFilePath");
        if (com.bytedance.android.live.core.setting.o.f65370a.getValue().booleanValue() == false) goto L6;
        return c("/drawer/" + StringsKt.substringAfterLast$default(r100, '/', null, 2, null));
    L6:
        return UriProtector.parse(r100);
    }

    public static void e(HSImageView r100, String r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r101 != null) goto L6;
    L9:
        boolean r102 = true;
    L10:
        if (r102 == true) goto L21;
        Pair r103 = a(r101);
        Bitmap r104 = (Bitmap) r103.component1();
        String r105 = (String) r103.component2();
        if (r104 == null) goto L15;
        ALogger.e("OfflineImageUtils", r101 + "_命中离线资源");
        r100.setImageBitmap(r104);
        return;
    L15:
        if (r105 != null) goto L17;
        return;
    L17:
        py.k r106 = (py.k) vh7.f.c(py.k.class);
        r106.setUrls(CollectionsKt.listOf(r105));
        ImageUtil.loadImage(r100, r106, 0);
        return;
    L21:
        return;
    L6:
        if (r101.length() == 0) goto L9;
        r102 = false;
        goto L10
    }

    public static boolean f(LottieAnimationView r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "lottieView");
        Intrinsics.checkNotNullParameter(r101, "key");
        Pair r102 = com.bytedance.android.livesdk.gecko.offline.f.b(b(r101));     // Catch: Throwable -> L9
        if (r102 != null) goto L6;
        return false;
    L6:
        ALogger.e("OfflineImageUtils", r101.concat("_命中离线资源"));     // Catch: Throwable -> L9
        r100.setImageAssetsFolder((String) r102.getFirst());     // Catch: Throwable -> L9
        r100.setAnimation(new JsonReader(new PolarisFileReaderWrapper(((String) r102.getFirst()) + '/' + ((String) r102.getSecond()))), r101);     // Catch: Throwable -> L9
        r100.setImageAssetDelegate(new a(r102));     // Catch: Throwable -> L9
        return true;
    L9:
        th = move-exception;
        ALogger.e("OfflineImageUtils", th);
        return false;
    }

    public static void g(LottieAnimationView r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "lottieView");
        Intrinsics.checkNotNullParameter(r101, "zipKey");
        b r102 = new b(r101, r100);
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "callback");
        boolean r103 = OfflineResourceClient.f125824a;
        OfflineResourceClient.c(b(r101), r102);
    }

    public static void h(HSImageView r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$loadOfflineImg");
        Intrinsics.checkNotNullParameter(r101, "key");
        e(r100, r101);
    }
}
