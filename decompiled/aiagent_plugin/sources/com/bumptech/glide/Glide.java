package com.bumptech.glide;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.f.j;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.b.s;
import com.bumptech.glide.load.b.t;
import com.bumptech.glide.load.b.u;
import com.bumptech.glide.load.b.w;
import com.bumptech.glide.load.engine.k;
import com.bumptech.glide.load.resource.bitmap.aa;
import com.bumptech.glide.load.resource.bitmap.ab;
import com.bumptech.glide.load.resource.bitmap.m;
import com.bumptech.glide.load.resource.bitmap.p;
import com.bumptech.glide.load.resource.bitmap.v;
import com.bumptech.glide.load.resource.bitmap.x;
import com.bumptech.glide.load.resource.bitmap.y;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.request.target.i;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public class Glide implements ComponentCallbacks2 {
    private static final String DEFAULT_DISK_CACHE_DIR = "image_manager_disk_cache";
    private static final String TAG = "Glide";
    private static volatile Glide glide;
    private static volatile boolean isInitializing;
    private final com.bumptech.glide.load.engine.a.b arrayPool;
    private final com.bumptech.glide.load.engine.a.e bitmapPool;
    private com.bumptech.glide.load.engine.d.b bitmapPreFiller;
    private final com.bumptech.glide.manager.d connectivityMonitorFactory;
    private final a defaultRequestOptionsFactory;
    private final k engine;
    private final GlideContext glideContext;
    private final List<RequestManager> managers;
    private final com.bumptech.glide.load.engine.b.h memoryCache;
    private d memoryCategory;
    private final f registry;
    private final RequestManagerRetriever requestManagerRetriever;

    public interface a {
        com.bumptech.glide.request.h a();
    }

    public static /* synthetic */ boolean access$000(String r0, int r1) {
        return Log.isLoggable(r0, r1);
    }

    public static /* synthetic */ int access$001(String r0, String r1) {
        return Log.e(r0, r1);
    }

    public static /* synthetic */ int access$002(String r0, String r1) {
        return Log.d(r0, r1);
    }

    public static /* synthetic */ int access$003(String r0, String r1) {
        return Log.w(r0, r1);
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r1) {
    }

    public static File getPhotoCacheDir(Context r2) {
        return getPhotoCacheDir((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), DEFAULT_DISK_CACHE_DIR);
    }

    public static File getPhotoCacheDir(Context r2, String r3) {
        File r4 = ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).getCacheDir();
        if (r4 == null) goto L13;
        File r1 = new File(r4, r3);
        if (r1.mkdirs() == false) goto L7;
    L11:
        return r1;
    L7:
        if (r1.exists() == true) goto L9;
    L10:
        return null;
    L9:
        if (r1.isDirectory() == true) goto L11;
    L13:
        if (INVOKESTATIC_com_bumptech_glide_Glide_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_isLoggable(TAG, 6) == false) goto L15;
        INVOKESTATIC_com_bumptech_glide_Glide_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "default disk cache dir is null");
    L15:
        return null;
    }

    public static Glide get(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (glide != null) goto L15;
        GeneratedAppGlideModule r0 = getAnnotationGeneratedGlideModules((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        monitor-enter(Glide.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (glide != null) goto L9;
        checkAndInitializeGlide(r4, r0);     // Catch: Throwable -> L11
    L9:
        monitor-exit(Glide.class);     // Catch: Throwable -> L11
    L15:
        return glide;
    }

    private static void checkAndInitializeGlide(Context r2, GeneratedAppGlideModule r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (isInitializing == true) goto L7;
        isInitializing = true;
        initializeGlide(r4, r3);
        isInitializing = false;
        return;
    L7:
        throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
    }

    @Deprecated
    public static synchronized void init(Glide r2) {
        monitor-enter(Glide.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (glide == null) goto L7;
        tearDown();     // Catch: Throwable -> L10
    L7:
        glide = r2;     // Catch: Throwable -> L10
        monitor-exit(Glide.class);
    }

    public static void init(Context r3, c r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        GeneratedAppGlideModule r0 = getAnnotationGeneratedGlideModules(r5);
        monitor-enter(Glide.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (glide == null) goto L7;
        tearDown();     // Catch: Throwable -> L10
    L7:
        initializeGlide(r5, r4, r0);     // Catch: Throwable -> L10
        monitor-exit(Glide.class);     // Catch: Throwable -> L10
    }

    public static synchronized void tearDown() {
        monitor-enter(Glide.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (glide == null) goto L7;
        ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(glide.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).unregisterComponentCallbacks(glide);     // Catch: Throwable -> L10
        glide.engine.b();     // Catch: Throwable -> L10
    L7:
        glide = null;     // Catch: Throwable -> L10
        monitor-exit(Glide.class);
    }

    private static void initializeGlide(Context r2, GeneratedAppGlideModule r3) {
        initializeGlide((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), new c(), r3);
    }

    private static void initializeGlide(Context r9, c r10, GeneratedAppGlideModule r11) {
        Context r12 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin")).getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        List<com.bumptech.glide.c.c> r0 = Collections.emptyList();
        if (r11 != null) goto L5;
    L6:
        r0 = new com.bumptech.glide.c.e(r12).a();
    L8:
        if (r11 == null) goto L22;
        if (r11.a().isEmpty() == true) goto L22;
        Set<Class<?>> r4 = r11.a();
        Iterator<com.bumptech.glide.c.c> r5 = r0.iterator();
    L13:
        if (r5.hasNext() == false) goto L22;
        com.bumptech.glide.c.c r6 = (com.bumptech.glide.c.c) ZeusTransformUtils.preCheckCast(r5.next(), com.bumptech.glide.c.c.class, "com.obric.aiagent.plugin");
        if (r4.contains(r6.getClass()) == false) goto L13;
        if (INVOKESTATIC_com_bumptech_glide_Glide_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_isLoggable(TAG, 3) == false) goto L20;
        INVOKESTATIC_com_bumptech_glide_Glide_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(TAG, "AppGlideModule excludes manifest GlideModule: " + r6);
    L20:
        r5.remove();
    L22:
        if (INVOKESTATIC_com_bumptech_glide_Glide_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_isLoggable(TAG, 3) == false) goto L27;
        Iterator<com.bumptech.glide.c.c> r2 = r0.iterator();
    L25:
        if (r2.hasNext() == false) goto L27;
        INVOKESTATIC_com_bumptech_glide_Glide_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(TAG, "Discovered GlideModule from manifest: " + ((com.bumptech.glide.c.c) ZeusTransformUtils.preCheckCast(r2.next(), com.bumptech.glide.c.c.class, "com.obric.aiagent.plugin")).getClass());
    L27:
        if (r11 == null) goto L29;
        RequestManagerRetriever.a r3 = r11.b();
    L30:
        r10.a(r3);
        Iterator<com.bumptech.glide.c.c> r7 = r0.iterator();
    L32:
        if (r7.hasNext() == false) goto L34;
        ((com.bumptech.glide.c.c) ZeusTransformUtils.preCheckCast(r7.next(), com.bumptech.glide.c.c.class, "com.obric.aiagent.plugin")).a(r12, r10);
        goto L32
    L34:
        if (r11 == null) goto L36;
        r11.a(r12, r10);
    L36:
        Glide r13 = r10.a(r12);
        Iterator<com.bumptech.glide.c.c> r1 = r0.iterator();
    L38:
        if (r1.hasNext() == false) goto L45;
        com.bumptech.glide.c.c r8 = (com.bumptech.glide.c.c) ZeusTransformUtils.preCheckCast(r1.next(), com.bumptech.glide.c.c.class, "com.obric.aiagent.plugin");
        r8.a(r12, r13, r13.registry);     // Catch: AbstractMethodError -> L42
    L42:
        e = move-exception;
        throw new IllegalStateException("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: " + r8.getClass().getName(), e);
    L45:
        if (r11 == null) goto L47;
        r11.a(r12, r13, r13.registry);
    L47:
        r12.registerComponentCallbacks(r13);
        glide = r13;
        return;
    L29:
        r3 = null;
        goto L30
    L5:
        if (r11.c() == false) goto L8;
        goto L6
    }

    private static GeneratedAppGlideModule getAnnotationGeneratedGlideModules(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        goto L14
    L20:
        return (GeneratedAppGlideModule) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl", "com.obric.aiagent.plugin").getDeclaredConstructor(new Class[]{Context.class}).newInstance(new Object[]{(Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")}), GeneratedAppGlideModule.class, "com.obric.aiagent.plugin");
    L9:
        e = move-exception;
        throwIncorrectGlideModule(e);
    L16:
        return null;
    L11:
        e = move-exception;
        throwIncorrectGlideModule(e);
    L7:
        e = move-exception;
        throwIncorrectGlideModule(e);
    L5:
        e = move-exception;
        throwIncorrectGlideModule(e);
    L14:
        if (INVOKESTATIC_com_bumptech_glide_Glide_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_isLoggable(TAG, 5) == false) goto L16;
        INVOKESTATIC_com_bumptech_glide_Glide_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
        goto L16
    }

    private static void throwIncorrectGlideModule(Exception r2) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", r2);
    }

    Glide(Context r19, k r20, com.bumptech.glide.load.engine.b.h r21, com.bumptech.glide.load.engine.a.e r22, com.bumptech.glide.load.engine.a.b r23, RequestManagerRetriever r24, com.bumptech.glide.manager.d r25, int r26, a r27, Map<Class<?>, h<?, ?>> r28, List<com.bumptech.glide.request.g<Object>> r29, boolean r30, boolean r31) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r19, Context.class, "com.obric.aiagent.plugin");
        com.bumptech.glide.load.engine.b.h r2 = (com.bumptech.glide.load.engine.b.h) ZeusTransformUtils.wrapperContextForParams(r21, com.bumptech.glide.load.engine.b.h.class, "com.obric.aiagent.plugin");
        com.bumptech.glide.load.engine.a.e r4 = (com.bumptech.glide.load.engine.a.e) ZeusTransformUtils.wrapperContextForParams(r22, com.bumptech.glide.load.engine.a.e.class, "com.obric.aiagent.plugin");
        com.bumptech.glide.load.engine.a.b r6 = (com.bumptech.glide.load.engine.a.b) ZeusTransformUtils.wrapperContextForParams(r23, com.bumptech.glide.load.engine.a.b.class, "com.obric.aiagent.plugin");
        com.bumptech.glide.manager.d r7 = (com.bumptech.glide.manager.d) ZeusTransformUtils.wrapperContextForParams(r25, com.bumptech.glide.manager.d.class, "com.obric.aiagent.plugin");
        a r9 = (a) ZeusTransformUtils.wrapperContextForParams(r27, a.class, "com.obric.aiagent.plugin");
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r28, Map.class, "com.obric.aiagent.plugin");
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r29, List.class, "com.obric.aiagent.plugin");
        this.managers = new ArrayList();
        this.memoryCategory = d.f3273b;
        this.engine = r20;
        this.bitmapPool = r4;
        this.arrayPool = r6;
        this.memoryCache = r2;
        this.requestManagerRetriever = r24;
        this.connectivityMonitorFactory = r7;
        this.defaultRequestOptionsFactory = r9;
        Resources r3 = ZeusTransformUtils.getResources(r5, "com.obric.aiagent.plugin");
        f r8 = new f();
        this.registry = r8;
        r8.a(new com.bumptech.glide.load.resource.bitmap.k());
        if (Build.VERSION.SDK_INT < 27) goto L5;
        r8.a(new p());
    L5:
        List<ImageHeaderParser> r12 = r8.a();
        com.bumptech.glide.load.resource.gif.a r13 = new com.bumptech.glide.load.resource.gif.a(r5, r12, r4, r6);
        com.bumptech.glide.load.k<ParcelFileDescriptor, Bitmap> r14 = ab.b(r4);
        m r15 = new m(r8.a(), r3.getDisplayMetrics(), r4, r6);
        if (r31 == true) goto L8;
    L10:
        com.bumptech.glide.load.k r16 = new com.bumptech.glide.load.resource.bitmap.g(r15);
        com.bumptech.glide.load.k r17 = new y(r15, r6);
    L11:
        com.bumptech.glide.load.resource.b.d r0 = new com.bumptech.glide.load.resource.b.d(r5);
        s.c r18 = new s.c(r3);
        s.d r110 = new s.d(r3);
        s.b r32 = new s.b(r3);
        s.a r1 = new s.a(r3);
        com.bumptech.glide.load.resource.bitmap.c r33 = new com.bumptech.glide.load.resource.bitmap.c(r6);
        com.bumptech.glide.load.resource.d.a r111 = new com.bumptech.glide.load.resource.d.a();
        com.bumptech.glide.load.resource.d.d r112 = new com.bumptech.glide.load.resource.d.d();
        ContentResolver r113 = r5.getContentResolver();
        r8.a(ByteBuffer.class, new com.bumptech.glide.load.b.c()).a(InputStream.class, new t(r6)).a("Bitmap", ByteBuffer.class, Bitmap.class, r16).a("Bitmap", InputStream.class, Bitmap.class, r17);
        if (com.bumptech.glide.load.a.m.c() == false) goto L14;
        r8.a("Bitmap", ParcelFileDescriptor.class, Bitmap.class, new v(r15));
    L14:
        r8.a("Bitmap", ParcelFileDescriptor.class, Bitmap.class, r14).a("Bitmap", AssetFileDescriptor.class, Bitmap.class, ab.a(r4)).a(Bitmap.class, Bitmap.class, com.bumptech.glide.load.b.v.a.a()).a("Bitmap", Bitmap.class, Bitmap.class, new aa()).a(Bitmap.class, r33).a("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a(r3, r16)).a("BitmapDrawable", InputStream.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a(r3, r17)).a("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a(r3, r14)).a(BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.b(r4, r33)).a("Gif", InputStream.class, GifDrawable.class, new com.bumptech.glide.load.resource.gif.h(r12, r13, r6)).a("Gif", ByteBuffer.class, GifDrawable.class, r13).a(GifDrawable.class, new com.bumptech.glide.load.resource.gif.c()).a(com.bumptech.glide.b.a.class, com.bumptech.glide.b.a.class, com.bumptech.glide.load.b.v.a.a()).a("Bitmap", com.bumptech.glide.b.a.class, Bitmap.class, new com.bumptech.glide.load.resource.gif.f(r4)).a(Uri.class, Drawable.class, r0).a(Uri.class, Bitmap.class, new x(r0, r4)).a(new com.bumptech.glide.load.resource.a.a.C0096a()).a(File.class, ByteBuffer.class, new com.bumptech.glide.load.b.d.b()).a(File.class, InputStream.class, new com.bumptech.glide.load.b.f.e()).a(File.class, File.class, new com.bumptech.glide.load.resource.c.a()).a(File.class, ParcelFileDescriptor.class, new com.bumptech.glide.load.b.f.b()).a(File.class, File.class, com.bumptech.glide.load.b.v.a.a()).a(new com.bumptech.glide.load.a.k.a(r6));
        if (com.bumptech.glide.load.a.m.c() == false) goto L17;
        r8.a(new com.bumptech.glide.load.a.m.a());
    L17:
        r8.a(Integer.TYPE, InputStream.class, r18).a(Integer.TYPE, ParcelFileDescriptor.class, r32).a(Integer.class, InputStream.class, r18).a(Integer.class, ParcelFileDescriptor.class, r32).a(Integer.class, Uri.class, r110).a(Integer.TYPE, AssetFileDescriptor.class, r1).a(Integer.class, AssetFileDescriptor.class, r1).a(Integer.TYPE, Uri.class, r110).a(String.class, InputStream.class, new com.bumptech.glide.load.b.e.c()).a(Uri.class, InputStream.class, new com.bumptech.glide.load.b.e.c()).a(String.class, InputStream.class, new u.c()).a(String.class, ParcelFileDescriptor.class, new u.b()).a(String.class, AssetFileDescriptor.class, new u.a()).a(Uri.class, InputStream.class, new com.bumptech.glide.load.b.a.b.a()).a(Uri.class, InputStream.class, new com.bumptech.glide.load.b.a.c(r5.getAssets())).a(Uri.class, ParcelFileDescriptor.class, new com.bumptech.glide.load.b.a.b(r5.getAssets())).a(Uri.class, InputStream.class, new com.bumptech.glide.load.b.a.c.a(r5)).a(Uri.class, InputStream.class, new com.bumptech.glide.load.b.a.d.a(r5));
        if (Build.VERSION.SDK_INT < 29) goto L20;
        r8.a(Uri.class, InputStream.class, new com.bumptech.glide.load.b.a.e.c(r5));
        r8.a(Uri.class, ParcelFileDescriptor.class, new com.bumptech.glide.load.b.a.e.b(r5));
    L20:
        r8.a(Uri.class, InputStream.class, new w.d(r113)).a(Uri.class, ParcelFileDescriptor.class, new w.b(r113)).a(Uri.class, AssetFileDescriptor.class, new w.a(r113)).a(Uri.class, InputStream.class, new com.bumptech.glide.load.b.x.a()).a(URL.class, InputStream.class, new com.bumptech.glide.load.b.a.f.a()).a(Uri.class, File.class, new com.bumptech.glide.load.b.k.a(r5)).a(com.bumptech.glide.load.b.g.class, InputStream.class, new com.bumptech.glide.load.b.a.a.C0088a()).a(byte[].class, ByteBuffer.class, new com.bumptech.glide.load.b.b.a()).a(byte[].class, InputStream.class, new com.bumptech.glide.load.b.b.d()).a(Uri.class, Uri.class, com.bumptech.glide.load.b.v.a.a()).a(Drawable.class, Drawable.class, com.bumptech.glide.load.b.v.a.a()).a(Drawable.class, Drawable.class, new com.bumptech.glide.load.resource.b.e()).a(Bitmap.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.d.b(r3)).a(Bitmap.class, byte[].class, r111).a(Drawable.class, byte[].class, new com.bumptech.glide.load.resource.d.c(r4, r111, r112)).a(GifDrawable.class, byte[].class, r112);
        if (Build.VERSION.SDK_INT < 23) goto L23;
        com.bumptech.glide.load.k<ByteBuffer, Bitmap> r34 = ab.c(r4);
        r8.a(ByteBuffer.class, Bitmap.class, r34);
        r8.a(ByteBuffer.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a(r3, r34));
    L23:
        this.glideContext = new GlideContext(r5, r6, r8, new com.bumptech.glide.request.target.f(), r9, r10, r11, r20, r30, r26);
        return;
    L8:
        if (Build.VERSION.SDK_INT < 28) goto L10;
        r17 = new com.bumptech.glide.load.resource.bitmap.t();
        r16 = new com.bumptech.glide.load.resource.bitmap.h();
        goto L11
    }

    public com.bumptech.glide.load.engine.a.e getBitmapPool() {
        return this.bitmapPool;
    }

    public com.bumptech.glide.load.engine.a.b getArrayPool() {
        return this.arrayPool;
    }

    public Context getContext() {
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.glideContext.getBaseContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    }

    com.bumptech.glide.manager.d getConnectivityMonitorFactory() {
        return this.connectivityMonitorFactory;
    }

    GlideContext getGlideContext() {
        return this.glideContext;
    }

    public synchronized void preFillBitmapPool(com.bumptech.glide.load.engine.d.d.a... r5) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.bitmapPreFiller != null) goto L6;
        com.bumptech.glide.load.b r0 = (com.bumptech.glide.load.b) ZeusTransformUtils.preCheckCast(this.defaultRequestOptionsFactory.a().o().a(m.f3815a), com.bumptech.glide.load.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        this.bitmapPreFiller = new com.bumptech.glide.load.engine.d.b(this.memoryCache, this.bitmapPool, r0);     // Catch: Throwable -> L9
    L6:
        this.bitmapPreFiller.a(r5);     // Catch: Throwable -> L9
        monitor-exit(this);
    }

    public void clearMemory() {
        com.bumptech.glide.f.k.a();
        this.memoryCache.c();
        this.bitmapPool.b();
        this.arrayPool.a();
    }

    public void trimMemory(int r5) {
        com.bumptech.glide.f.k.a();
        Iterator<RequestManager> r0 = this.managers.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((RequestManager) ZeusTransformUtils.preCheckCast(r0.next(), RequestManager.class, "com.obric.aiagent.plugin")).onTrimMemory(r5);
        goto L4
    L6:
        this.memoryCache.a(r5);
        this.bitmapPool.a(r5);
        this.arrayPool.a(r5);
    }

    public void clearDiskCache() {
        com.bumptech.glide.f.k.b();
        this.engine.a();
    }

    public RequestManagerRetriever getRequestManagerRetriever() {
        return this.requestManagerRetriever;
    }

    public d setMemoryCategory(d r3) {
        com.bumptech.glide.f.k.a();
        this.memoryCache.a(r3.a());
        this.bitmapPool.a(r3.a());
        d r0 = this.memoryCategory;
        this.memoryCategory = r3;
        return r0;
    }

    private static RequestManagerRetriever getRetriever(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        j.a(r3, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return get(r3).getRequestManagerRetriever();
    }

    public static RequestManager with(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        return getRetriever(r3).get(r3);
    }

    public static RequestManager with(Activity r2) {
        Activity r3 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
        return getRetriever(r3).get(r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.content.Context, androidx.fragment.app.FragmentActivity] */
    public static RequestManager with(FragmentActivity r2) {
        ?? r3 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r2, FragmentActivity.class, "com.obric.aiagent.plugin");
        return getRetriever(r3).get(r3);
    }

    public static RequestManager with(Fragment r3) {
        return getRetriever((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).get(r3);
    }

    @Deprecated
    public static RequestManager with(android.app.Fragment r1) {
        return getRetriever(ZeusTransformUtils.getActivity(r1, "com.obric.aiagent.plugin")).get(r1);
    }

    public static RequestManager with(View r3) {
        return getRetriever((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).get(r3);
    }

    public f getRegistry() {
        return this.registry;
    }

    boolean removeFromManagers(i<?> r5) {
        i<?> r6 = (i) ZeusTransformUtils.wrapperContextForParams(r5, i.class, "com.obric.aiagent.plugin");
        List<RequestManager> r0 = this.managers;
        monitor-enter(r0);
        Iterator<RequestManager> r4 = this.managers.iterator();     // Catch: Throwable -> L15
    L6:
        if (r4.hasNext() == false) goto L12;
        if (((RequestManager) ZeusTransformUtils.preCheckCast(r4.next(), RequestManager.class, "com.obric.aiagent.plugin")).untrack(r6) == false) goto L6;
        monitor-exit(r0);     // Catch: Throwable -> L15
        return true;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return false;
    L15:
        th = move-exception;
        throw th;
    }

    void registerRequestManager(RequestManager r3) {
        List<RequestManager> r0 = this.managers;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.managers.contains(r3) == true) goto L10;
        this.managers.add(r3);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IllegalStateException("Cannot register already registered manager");     // Catch: Throwable -> L11
    }

    void unregisterRequestManager(RequestManager r3) {
        List<RequestManager> r0 = this.managers;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.managers.contains(r3) == false) goto L10;
        this.managers.remove(r3);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IllegalStateException("Cannot unregister not yet registered manager");     // Catch: Throwable -> L11
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int r1) {
        trimMemory(r1);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        clearMemory();
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static boolean INVOKESTATIC_com_bumptech_glide_Glide_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_isLoggable(String r1, int r2) {
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
    public static int INVOKESTATIC_com_bumptech_glide_Glide_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_bumptech_glide_Glide_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_bumptech_glide_Glide_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
