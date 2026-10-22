package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.v;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.k;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: ByteBufferGifDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements k<ByteBuffer, GifDrawable> {
    private static final String TAG = "BufferGifDecoder";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final C0097a f3876a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final b f3877b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f3878c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<ImageHeaderParser> f3879d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final b f3880e;
    private final C0097a f;
    private final com.bumptech.glide.load.resource.gif.b g;

    /* JADX INFO: renamed from: com.bumptech.glide.load.resource.gif.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ByteBufferGifDecoder.java */
    static class C0097a {
        C0097a() {
        }

        com.bumptech.glide.b.a a(com.bumptech.glide.b.a.InterfaceC0083a r2, com.bumptech.glide.b.c r3, ByteBuffer r4, int r5) {
            return new com.bumptech.glide.b.e((com.bumptech.glide.b.a.InterfaceC0083a) ZeusTransformUtils.wrapperContextForParams(r2, com.bumptech.glide.b.a.InterfaceC0083a.class, "com.obric.aiagent.plugin"), r3, r4, r5);
        }
    }

    /* JADX INFO: compiled from: ByteBufferGifDecoder.java */
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Queue<com.bumptech.glide.b.d> f3881a;

        b() {
            this.f3881a = com.bumptech.glide.f.k.a(0);
        }

        synchronized com.bumptech.glide.b.d a(ByteBuffer r4) {
            monitor-enter(this);
            com.bumptech.glide.b.d r0 = (com.bumptech.glide.b.d) ZeusTransformUtils.preCheckCast(this.f3881a.poll(), com.bumptech.glide.b.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
            if (r0 != null) goto L6;
            r0 = new com.bumptech.glide.b.d();     // Catch: Throwable -> L9
        L6:
            com.bumptech.glide.b.d r5 = r0.a(r4);     // Catch: Throwable -> L9
            monitor-exit(this);
            return r5;
        L9:
            th = move-exception;
            throw th;
        }

        synchronized void a(com.bumptech.glide.b.d r2) {
            monitor-enter(this);
            r2.a();     // Catch: Throwable -> L6
            this.f3881a.offer(r2);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.k
    public /* synthetic */ v<GifDrawable> a(ByteBuffer r3, int r4, int r5, i r6) {
        return a2((ByteBuffer) ZeusTransformUtils.preCheckCast(r3, ByteBuffer.class, "com.obric.aiagent.plugin"), r4, r5, r6);
    }

    @Override // com.bumptech.glide.load.k
    public /* synthetic */ boolean a(ByteBuffer r3, i r4) {
        return a2((ByteBuffer) ZeusTransformUtils.preCheckCast(r3, ByteBuffer.class, "com.obric.aiagent.plugin"), r4);
    }

    static {
        f3876a = new C0097a();
        f3877b = new b();
    }

    public a(Context r10, List<ImageHeaderParser> r11, com.bumptech.glide.load.engine.a.e r12, com.bumptech.glide.load.engine.a.b r13) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin"), (com.bumptech.glide.load.engine.a.e) ZeusTransformUtils.wrapperContextForParams(r12, com.bumptech.glide.load.engine.a.e.class, "com.obric.aiagent.plugin"), (com.bumptech.glide.load.engine.a.b) ZeusTransformUtils.wrapperContextForParams(r13, com.bumptech.glide.load.engine.a.b.class, "com.obric.aiagent.plugin"), f3877b, f3876a);
    }

    a(Context r3, List<ImageHeaderParser> r4, com.bumptech.glide.load.engine.a.e r5, com.bumptech.glide.load.engine.a.b r6, b r7, C0097a r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        List<ImageHeaderParser> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        com.bumptech.glide.load.engine.a.e r11 = (com.bumptech.glide.load.engine.a.e) ZeusTransformUtils.wrapperContextForParams(r5, com.bumptech.glide.load.engine.a.e.class, "com.obric.aiagent.plugin");
        com.bumptech.glide.load.engine.a.b r12 = (com.bumptech.glide.load.engine.a.b) ZeusTransformUtils.wrapperContextForParams(r6, com.bumptech.glide.load.engine.a.b.class, "com.obric.aiagent.plugin");
        this.f3878c = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.f3879d = r10;
        this.f = r8;
        this.g = new com.bumptech.glide.load.resource.gif.b(r11, r12);
        this.f3880e = r7;
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(ByteBuffer r3, i r4) {
        if (((Boolean) ZeusTransformUtils.preCheckCast(r4.a(g.f3887b), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L5;
    L7:
        return false;
    L5:
        if (com.bumptech.glide.load.f.getType(this.f3879d, r3) != ImageHeaderParser.ImageType.GIF) goto L7;
        return true;
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public d a2(ByteBuffer r8, int r9, int r10, i r11) {
        com.bumptech.glide.b.d r0 = this.f3880e.a(r8);
        d r12 = a(r8, r9, r10, r0, r11);     // Catch: Throwable -> L6
        this.f3880e.a(r0);
        return r12;
    L6:
        th = move-exception;
        this.f3880e.a(r0);
        throw th;
    }

    private d a(ByteBuffer r17, int r18, int r19, com.bumptech.glide.b.d r20, i r21) {
        long r3 = com.bumptech.glide.f.f.a();
        com.bumptech.glide.b.c r6 = r20.b();     // Catch: Throwable -> L27
        if (r6.c() <= 0) goto L24;
        if (r6.d() != 0) goto L24;
        if (r21.a(g.f3886a) != com.bumptech.glide.load.b.f3395b) goto L11;
        Bitmap.Config r7 = Bitmap.Config.RGB_565;     // Catch: Throwable -> L27
    L12:
        com.bumptech.glide.b.a r11 = this.f.a(this.g, r6, r17, a(r6, r18, r19));     // Catch: Throwable -> L27
        r11.a(r7);     // Catch: Throwable -> L27
        r11.b();     // Catch: Throwable -> L27
        Bitmap r15 = r11.i();     // Catch: Throwable -> L27
        if (r15 == null) goto L15;
        d r0 = new d(new GifDrawable(this.f3878c, r11, com.bumptech.glide.load.resource.c.a(), r18, r19, r15));     // Catch: Throwable -> L27
        if (a(TAG, 2) == false) goto L22;
        a(TAG, "Decoded GIF from stream in " + com.bumptech.glide.f.f.a(r3));
    L22:
        return r0;
    L15:
        if (a(TAG, 2) == false) goto L17;
        a(TAG, "Decoded GIF from stream in " + com.bumptech.glide.f.f.a(r3));
    L17:
        return null;
    L11:
        r7 = Bitmap.Config.ARGB_8888;     // Catch: Throwable -> L27
    L24:
        if (a(TAG, 2) == false) goto L26;
        a(TAG, "Decoded GIF from stream in " + com.bumptech.glide.f.f.a(r3));
    L26:
        return null;
    L27:
        th = move-exception;
        if (a(TAG, 2) == false) goto L31;
        a(TAG, "Decoded GIF from stream in " + com.bumptech.glide.f.f.a(r3));
    L31:
        throw th;
    }

    private static int a(com.bumptech.glide.b.c r4, int r5, int r6) {
        int r0 = Math.min(r4.a() / r6, r4.b() / r5);
        if (r0 != 0) goto L5;
        int r1 = 0;
    L6:
        int r2 = Math.max(1, r1);
        if (a(TAG, 2) == false) goto L10;
        if (r2 <= 1) goto L10;
        a(TAG, "Downsampling GIF, sampleSize: " + r2 + ", target dimens: [" + r5 + "x" + r6 + "], actual dimens: [" + r4.b() + "x" + r4.a() + "]");
    L10:
        return r2;
    L5:
        r1 = Integer.highestOneBit(r0);
        goto L6
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static boolean a(String r1, int r2) {
        if (com.obric.aiagent.apm.impl.a.a() == true) goto L7;
        return Log.isLoggable(r1, r2);
    L7:
        if (r2 == 6) goto L9;
    L11:
        return false;
    L9:
        if (Log.isLoggable(r1, r2) == false) goto L11;
        return true;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.v(r1, r2);
    }
}
