package ce6;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.lynx.canvas.KryptonApp;
import com.lynx.canvas.KryptonLLog;
import com.lynx.canvas.KryptonLoaderService;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.core.n;
import com.lynx.tasm.service.LynxResourceServiceRequestParams;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.SimpleTarget;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import com.ss.android.lark.vfs.VFSFiles;
import d8a.h;
import d8a.i;
import i8a.e;
import i8a.g;
import i8a.m;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes19.dex */
public final class b extends KryptonLoaderService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f23455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference<LynxContext> f23456b;

    public class a extends SimpleTarget<Bitmap> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KryptonLoaderService.ImageResolver f23457a;

        public a(KryptonLoaderService.ImageResolver r100) {
            this.f23457a = r100;
        }

        @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
        public final void onLoadFailed(Drawable r100) {
            super.onLoadFailed(r100);
            this.f23457a.reject("load failed");
        }

        @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
        public final void onResourceReady(Object r100) {
            Bitmap r101 = (Bitmap) r100;
            super.onResourceReady(r101);
            this.f23457a.resolve(r101);
        }
    }

    /* JADX INFO: renamed from: ce6.b$b, reason: collision with other inner class name */
    public class C0437b extends m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f23458a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f23459b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f23460c;

        @Override // i8a.m
        public final void onResponse(g r100) {
            r100.a();
            KryptonLLog.e("KryptonCanvasLoaderService", "request by LynxResourceService failed. " + r100.c());
            b r101 = this.f23460c;
            String r102 = this.f23459b;
            c r103 = this.f23458a;
            r101.getClass();
            n.a().b(new h(r102, null), new ce6.c(r101, r103));
        }

        public C0437b(b r100, c r101, String r102) {
            this.f23460c = r100;
            this.f23458a = r101;
            this.f23459b = r102;
        }
    }

    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public KryptonLoaderService.DataResolver f23461a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public KryptonLoaderService.StreamDelegate f23462b;

        public c() {
            this.f23461a = null;
            this.f23462b = null;
        }

        public final void a(String r100) {
            KryptonLoaderService.StreamDelegate r101 = this.f23462b;
            if (r101 == null) goto L5;
            r101.onError(r100);
            return;
        L5:
            KryptonLoaderService.DataResolver r102 = this.f23461a;
            if (r102 == null) goto L10;
            r102.reject(r100);
            return;
        }

        public final void b(byte[] r100) {
            KryptonLoaderService.StreamDelegate r101 = this.f23462b;
            if (r101 == null) goto L5;
            r101.onStart(r100.length);
            this.f23462b.onData(r100, 0, r100.length);
            this.f23462b.onEnd();
            return;
        L5:
            KryptonLoaderService.DataResolver r102 = this.f23461a;
            if (r102 == null) goto L10;
            r102.resolve(r100, 0, r100.length);
            return;
        }
    }

    public b() {
    }

    public static byte[] b(String r100) {
        int r101 = r100.indexOf("base64,");
        if (r101 != (-1)) goto L12;
        KryptonLLog.e("KryptonCanvasLoaderService", "data url decode not base64");
        return null;
    L12:
        return Base64.decode(r100.substring(r101 + 7), 0);
    L9:
        e = move-exception;
        KryptonLLog.e("KryptonCanvasLoaderService", "data url decode throw exception " + e);
        return null;
    }

    @Override // com.lynx.canvas.KryptonService
    public final void onBootstrap(KryptonApp r100) {
        this.f23455a = r100.getContext();
    }

    @Override // com.lynx.canvas.KryptonLoaderService
    public final String redirectUrl(String r100) {
        LynxContext r101 = null;
        if (r100 != null) goto L27;
        KryptonLLog.i("KryptonCanvasLoaderService", "redirect url null");
        return null;
    L27:
    L24:
        e = move-exception;
        KryptonLLog.e("KryptonCanvasLoaderService", "redirect url exception: " + e.toString());
    L26:
        return r100;
    L8:
        if (r100.startsWith("assets:///") == false) goto L11;
        r100 = r100.replace("assets:///", "asset:///");     // Catch: Exception -> L24
    L13:
        WeakReference<LynxContext> r102 = this.f23456b;     // Catch: Exception -> L24
        if (r102 == null) goto L16;
        r101 = r102.get();     // Catch: Exception -> L24
    L16:
        if (r101 != null) goto L19;
        KryptonLLog.e("KryptonCanvasLoaderService", "lynx context null");     // Catch: Exception -> L24
        return r100;
    L19:
        String r103 = d7a.a.b(r101, r100, false);     // Catch: Exception -> L24
        if (TextUtils.equals(r100, r103) == true) goto L22;
        KryptonLLog.i("KryptonCanvasLoaderService", "redirect url: " + r100 + " to " + r103);     // Catch: Exception -> L24
    L22:
        if (r103 == null) goto L26;
        return r103;
    L11:
        if (r100.startsWith("assets://") == false) goto L13;
        r100 = r100.replace("assets://", "asset:///");     // Catch: Exception -> L24
        goto L13
    }

    public static int a(b r100, i r101) {
        r100.getClass();
        Map<String, List<String>> r102 = r101.f467443c;     // Catch: Throwable -> L9
        if (r102 == null) goto L14;
        List<String> r103 = r102.get("content-length");     // Catch: Throwable -> L9
        if (CollectionUtils.isNotEmpty(r103) == false) goto L15;
        return CastIntegerProtector.valueOf((String) ListProtector.get(r103, 0)).intValue();
    L15:
        return 0;
    L14:
        return 0;
    L9:
        th = move-exception;
        KryptonLLog.e("KryptonCanvasLoaderService", th.toString());
        return 0;
    }

    public final void c(String r100, c r110) {
        if (this.f23455a != null) goto L33;
        KryptonLLog.e("KryptonCanvasLoaderService", "Local Loader setup failed for mContext == null.");
        r110.a("Local Loader setup failed");
        return;
    L33:
    L30:
        e = move-exception;
        KryptonLLog.e("KryptonCanvasLoaderService", "load path exception: " + e.toString());
        r110.a(e.getMessage());
        return;
    L28:
        e = move-exception;
        KryptonLLog.e("KryptonCanvasLoaderService", "load path out of memory");
        r110.a(e.getMessage());
        return;
    L8:
        if (r100.startsWith("asset:///") == false) goto L11;
        KryptonLLog.i("KryptonCanvasLoaderService", "load path: " + r100 + " from assert.");     // Catch: OutOfMemoryError -> L28 Exception -> L30
        e(this.f23455a.getResources().getAssets().open(r100.substring(9)), r110, 0);     // Catch: OutOfMemoryError -> L28 Exception -> L30
        return;
    L11:
        if (r100.startsWith("res:///") == false) goto L14;
        KryptonLLog.i("KryptonCanvasLoaderService", "load path: " + r100 + " from resource.");     // Catch: OutOfMemoryError -> L28 Exception -> L30
        e(this.f23455a.getResources().openRawResource(this.f23455a.getResources().getIdentifier(r100.substring(7), "drawable", this.f23455a.getPackageCodePath())), r110, 0);     // Catch: OutOfMemoryError -> L28 Exception -> L30
        return;
    L14:
        if (r100.startsWith(MSkiaImageRegionDecoder.FILE_PREFIX) == false) goto L21;
        KryptonLLog.i("KryptonCanvasLoaderService", "load path: " + r100 + " from file.");     // Catch: OutOfMemoryError -> L28 Exception -> L30
        String r101 = r100.substring(7);     // Catch: OutOfMemoryError -> L28 Exception -> L30
        if (r101.startsWith(HTTP.URL_DEFAULT) == true) goto L19;
        r101 = HTTP.URL_DEFAULT.concat(r101);     // Catch: OutOfMemoryError -> L28 Exception -> L30
    L19:
        VFSFiles r102 = VFSFiles.f444819b;     // Catch: OutOfMemoryError -> L28 Exception -> L30
        e(r102.j(r102.i(r101)), r110, 0);     // Catch: OutOfMemoryError -> L28 Exception -> L30
        return;
    L21:
        if (r100.startsWith(fyb.a.KEY_DATA) == false) goto L26;
        KryptonLLog.i("KryptonCanvasLoaderService", "load path: " + r100 + " from data url.");     // Catch: OutOfMemoryError -> L28 Exception -> L30
        byte[] r103 = b(r100);     // Catch: OutOfMemoryError -> L28 Exception -> L30
        if (r103 == null) goto L25;
        r110.b(r103);     // Catch: OutOfMemoryError -> L28 Exception -> L30
        return;
    L25:
        r110.a("invalid data url!");     // Catch: OutOfMemoryError -> L28 Exception -> L30
        return;
    L26:
        KryptonLLog.e("KryptonCanvasLoaderService", "load invalid path: ".concat(r100));     // Catch: OutOfMemoryError -> L28 Exception -> L30
        r110.a("invalid path".concat(r100));     // Catch: OutOfMemoryError -> L28 Exception -> L30
    }

    public final void d(String r100, c r101) {
        LynxResourceServiceRequestParams r102 = new LynxResourceServiceRequestParams();
        e r103 = (e) i8a.n.c().a(e.class);
        if (r103 == null) goto L5;
        r103.fetchResourceAsync(r100, r102, new C0437b(this, r101, r100));
        return;
    L5:
        h r104 = new h(r100, null);
        n.a().b(r104, new ce6.c(this, r101));
    }

    @Override // com.lynx.canvas.KryptonLoaderService
    public final void loadUrlWithDataResolver(String r100, KryptonLoaderService.DataResolver r101) {
        if (r101 != null) goto L5;
        KryptonLLog.e("KryptonCanvasLoaderService", "loadUrlWithDataResolver resolver null");
        return;
    L5:
        String r102 = redirectUrl(r100);
        c r103 = new c();
        r103.f23461a = r101;
        if (r102 != null) goto L8;
    L12:
        boolean r104 = false;
    L13:
        if (r104 == false) goto L15;
        d(r102, r103);
        return;
    L15:
        c(r102, r103);
        return;
    L8:
        if (r102.startsWith("http://") == false) goto L10;
    L11:
        r104 = true;
        goto L13
    L10:
        if (r102.startsWith("https://") == false) goto L12;
        goto L11
    }

    @Override // com.lynx.canvas.KryptonLoaderService
    public final void loadUrlWithImageResolver(String r100, KryptonLoaderService.ImageResolver r101) {
        if (r101 != null) goto L6;
        KryptonLLog.e("KryptonCanvasLoaderService", "loadUrlWithImageResolver resolver null");
        return;
    L6:
        String r102 = redirectUrl(r100);
        Bitmap r103 = null;
        if (r102 != null) goto L9;
    L21:
        if (r103 == null) goto L24;
        r101.resolve(r103);
        return;
    L24:
        ImageLoader.with(this.f23455a).load(r102).asBitmap().into(new a(r101));
        return;
    L9:
        if (r102.startsWith(fyb.a.KEY_DATA) == false) goto L21;
        byte[] r104 = b(r102);
        if (r104 == null) goto L21;
        Bitmap r105 = BitmapFactory.decodeByteArray(r104, 0, r104.length);     // Catch: Exception -> L16
    L18:
        if (r105 != null) goto L20;
        KryptonLLog.e("KryptonCanvasLoaderService", "decode data url failed, bitmap = null ");
        goto L21
    L20:
        r103 = r105;
    L16:
        e = move-exception;
        KryptonLLog.e("KryptonCanvasLoaderService", "decode data url failed, throw exception " + e);
        r105 = null;
        goto L18
    }

    @Override // com.lynx.canvas.KryptonLoaderService
    public final void loadUrlWithStreamDelegate(String r100, KryptonLoaderService.StreamDelegate r101) {
        if (r101 != null) goto L5;
        KryptonLLog.e("KryptonCanvasLoaderService", "loadUrlWithStreamDelegate delegate null");
        return;
    L5:
        String r102 = redirectUrl(r100);
        c r103 = new c();
        r103.f23462b = r101;
        if (r102 != null) goto L8;
    L12:
        boolean r104 = false;
    L13:
        if (r104 == false) goto L15;
        d(r102, r103);
        return;
    L15:
        c(r102, r103);
        return;
    L8:
        if (r102.startsWith("http://") == false) goto L10;
    L11:
        r104 = true;
        goto L13
    L10:
        if (r102.startsWith("https://") == false) goto L12;
        goto L11
    }

    public static void e(InputStream r100, c r110, int r111) throws Exception {
        int r101 = r100.available();
        if (r101 > 0) goto L7;
        KryptonLLog.i("KryptonCanvasLoaderService", "no length from stream, responseContentLength = " + r111);
        if (r111 <= 0) goto L7;
    L8:
        if (r111 > 0) goto L10;
    L13:
        int r102 = 1024;
    L14:
        byte[] r103 = new byte[r102];
        KryptonLoaderService.StreamDelegate r104 = r110.f23462b;
        if (r104 == null) goto L22;
        r104.onStart(r111);
    L17:
        int r112 = r100.read(r103);
        if (r112 == (-1)) goto L21;
        if (r112 <= 0) goto L17;
        r110.f23462b.onData(r103, 0, r112);
        goto L17
    L21:
        r110.f23462b.onEnd();
    L36:
        r100.close();
        return;
    L22:
        byte[] r113 = new byte[0];
    L23:
        int r105 = r100.read(r103);
        if (r105 == (-1)) goto L35;
        byte[] r106 = new byte[r105];
        System.arraycopy(r103, 0, r106, 0, r105);
        byte[][] r107 = {r113, r106};
        int r114 = 0;
        int r108 = 0;
    L26:
        if (r114 >= 2) goto L28;
        r108 = r108 + r107[r114].length;
        r114 = r114 + 1;
        goto L26
    L28:
        r113 = new byte[r108];
        int r109 = 0;
        int r115 = 0;
    L29:
        if (r109 >= 2) goto L23;
        byte[] r116 = r107[r109];
        int r117 = r116.length;
        if (r117 == 0) goto L34;
        System.arraycopy(r116, 0, r113, r115, r117);
        r115 = r115 + r117;
    L34:
        r109 = r109 + 1;
        goto L29
    L35:
        r110.f23461a.resolve(r113, 0, r113.length);
        goto L36
    L10:
        if (r110.f23462b != null) goto L13;
        r102 = r111;
    L7:
        r111 = r101;
        goto L8
    }
}
