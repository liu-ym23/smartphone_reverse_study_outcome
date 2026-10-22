package com.stepos.ailauncher.common.imageloader;

import La.H;
import Y8.j;
import Y8.t;
import Z8.C1172u;
import Z8.F;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.MemoryCategory;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.stepos.aiengine.args.QueryAlgorithmBundle;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import com.stepos.ailauncher.common.imageloader.g;
import h8.C4148a;
import io.ktor.http.ContentType;
import io.ktor.sse.ServerSentEventKt;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0003\n\u0002\b\u0004*\u0002cf\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010\"\u001a\u00020\u001d2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001d0 H\u0002¢\u0006\u0004\b\"\u0010#J3\u0010+\u001a\u00020\u001d2\b\u0010%\u001a\u0004\u0018\u00010$2\b\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010(\u001a\u00020\r2\u0006\u0010*\u001a\u00020)H\u0002¢\u0006\u0004\b+\u0010,J\u001f\u0010-\u001a\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b-\u0010.J\u0013\u00100\u001a\u00020)*\u00020/H\u0002¢\u0006\u0004\b0\u00101J\u0019\u00103\u001a\u00020\r2\b\u00102\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b3\u00104J\u001c\u00106\u001a\u0004\u0018\u0001052\b\u00102\u001a\u0004\u0018\u00010\u0019H\u0082\u0010¢\u0006\u0004\b6\u00107J\u0017\u0010:\u001a\u00020\u001d2\u0006\u00109\u001a\u000208H\u0007¢\u0006\u0004\b:\u0010;Jg\u0010C\u001a\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010<\u001a\u0004\u0018\u00010\u00012\b\b\u0003\u0010=\u001a\u00020\t2\b\b\u0003\u0010>\u001a\u00020\t2\b\b\u0002\u0010?\u001a\u00020\t2\b\b\u0002\u0010@\u001a\u00020\r2\b\b\u0002\u0010A\u001a\u00020\t2\b\b\u0002\u0010B\u001a\u00020\t2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$¢\u0006\u0004\bC\u0010DJA\u0010F\u001a\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\bF\u0010GJ\u0015\u0010H\u001a\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\bH\u0010IJ\u0015\u0010J\u001a\u00020\u001d2\u0006\u00102\u001a\u00020\u0019¢\u0006\u0004\bJ\u0010KJ\u001d\u0010M\u001a\u00020\u001d2\u0006\u00102\u001a\u00020\u00192\u0006\u0010L\u001a\u00020\t¢\u0006\u0004\bM\u0010NJ\u0015\u0010O\u001a\u00020\u001d2\u0006\u00102\u001a\u00020\u0019¢\u0006\u0004\bO\u0010KR\u0014\u0010Q\u001a\u00020P8\u0002X\u0082T¢\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010S\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\bS\u0010TR\u0014\u0010V\u001a\u00020U8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u0014\u0010Y\u001a\u00020X8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u001c\u0010\\\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001080[8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010^\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010`\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010b\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010TR\u0014\u0010d\u001a\u00020c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bd\u0010eR\u0014\u0010g\u001a\u00020f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010h¨\u0006i"}, d2 = {"Lcom/stepos/ailauncher/common/imageloader/g;", "", "<init>", "()V", "Landroid/widget/ImageView;", "target", "Lcom/stepos/ailauncher/common/imageloader/i;", "request", "Lkotlin/Pair;", "", "v", "(Landroid/widget/ImageView;Lcom/stepos/ailauncher/common/imageloader/i;)Lkotlin/Pair;", "view", "", "horizontal", "w", "(Landroid/widget/ImageView;Z)I", "Landroid/util/DisplayMetrics;", "dm", "D", "(Landroid/util/DisplayMetrics;)I", "ow", "oh", "C", "(IILcom/stepos/ailauncher/common/imageloader/i;)Z", "Landroid/content/Context;", "appCtx", "Lcom/bumptech/glide/MemoryCategory;", QueryAlgorithmBundle.KEY_CATEGORY, "LY8/t;", "B", "(Landroid/content/Context;Lcom/bumptech/glide/MemoryCategory;)V", "Lkotlin/Function0;", "block", "z", "(Lp9/a;)V", "Lcom/stepos/ailauncher/common/imageloader/a;", "callback", "Lcom/stepos/ailauncher/common/imageloader/b;", "detailCallback", "success", "Lcom/stepos/ailauncher/common/imageloader/ImageDataSource;", "source", "u", "(Lcom/stepos/ailauncher/common/imageloader/a;Lcom/stepos/ailauncher/common/imageloader/b;ZLcom/stepos/ailauncher/common/imageloader/ImageDataSource;)V", "k", "(Landroid/widget/ImageView;Lcom/stepos/ailauncher/common/imageloader/i;)V", "Lcom/bumptech/glide/load/DataSource;", ExifInterface.LONGITUDE_EAST, "(Lcom/bumptech/glide/load/DataSource;)Lcom/stepos/ailauncher/common/imageloader/ImageDataSource;", "context", "p", "(Landroid/content/Context;)Z", "Landroid/app/Activity;", "H", "(Landroid/content/Context;)Landroid/app/Activity;", "Landroid/app/Application;", ContentType.Application.TYPE, "o", "(Landroid/app/Application;)V", AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, "placeholderResId", "errorResId", "cornerRadiusDp", "centerCrop", "overrideWidth", "overrideHeight", "r", "(Landroid/widget/ImageView;Ljava/lang/Object;IIIZIILcom/stepos/ailauncher/common/imageloader/a;)V", "glideContext", "q", "(Landroid/widget/ImageView;Lcom/stepos/ailauncher/common/imageloader/i;Lcom/stepos/ailauncher/common/imageloader/a;Lcom/stepos/ailauncher/common/imageloader/b;Landroid/content/Context;)V", "l", "(Landroid/widget/ImageView;)V", "m", "(Landroid/content/Context;)V", "level", "F", "(Landroid/content/Context;I)V", "x", "", "TAG", "Ljava/lang/String;", "TIMEOUT_MS", "I", "Ljava/util/concurrent/atomic/AtomicBoolean;", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "Ljava/util/concurrent/atomic/AtomicReference;", "applicationRef", "Ljava/util/concurrent/atomic/AtomicReference;", "memoryCategory", "Lcom/bumptech/glide/MemoryCategory;", "uiHiddenTrimmed", "Z", "startedActivityCount", "com/stepos/ailauncher/common/imageloader/g$d", "memoryCallbacks", "Lcom/stepos/ailauncher/common/imageloader/g$d;", "com/stepos/ailauncher/common/imageloader/g$b", "activityCallbacks", "Lcom/stepos/ailauncher/common/imageloader/g$b;", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class g {
    private static final String TAG = "ImageLoader";
    private static final int TIMEOUT_MS = 15000;
    private static volatile int startedActivityCount;
    private static volatile boolean uiHiddenTrimmed;
    public static final g INSTANCE = new g();
    private static final AtomicBoolean initialized = new AtomicBoolean(false);
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());
    private static final AtomicReference<Application> applicationRef = new AtomicReference<>(null);
    private static volatile MemoryCategory memoryCategory = MemoryCategory.NORMAL;
    private static final d memoryCallbacks = new d();
    private static final b activityCallbacks = new b();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[DiskCache.values().length];
            try {
                iArr[DiskCache.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DiskCache.NONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DiskCache.AUTOMATIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[DataSource.values().length];
            try {
                iArr2[DataSource.MEMORY_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[DataSource.RESOURCE_DISK_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[DataSource.DATA_DISK_CACHE.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[DataSource.REMOTE.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[DataSource.LOCAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J!\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0006J\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0006J\u001f\u0010\u000f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000f\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0006¨\u0006\u0011"}, d2 = {"com/stepos/ailauncher/common/imageloader/g$b", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Landroid/app/Activity;", "activity", "LY8/t;", "onActivityStarted", "(Landroid/app/Activity;)V", "onActivityStopped", Const.INTENT_KEY_APIKEY, "Landroid/os/Bundle;", Const.INTENT_KEY_PKGNAME, "onActivityCreated", "(Landroid/app/Activity;Landroid/os/Bundle;)V", "onActivityResumed", "onActivityPaused", "onActivitySaveInstanceState", "onActivityDestroyed", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements Application.ActivityLifecycleCallbacks {
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity a10, Bundle b10) {
            p.i(a10, "a");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity a10) {
            p.i(a10, "a");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity a10) {
            p.i(a10, "a");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity a10) {
            p.i(a10, "a");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity a10, Bundle b10) {
            p.i(a10, "a");
            p.i(b10, "b");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            p.i(activity, "activity");
            g.startedActivityCount++;
            if (g.startedActivityCount == 1) {
                g.INSTANCE.x(activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            p.i(activity, "activity");
            g.startedActivityCount--;
            if (g.startedActivityCount <= 0) {
                g.startedActivityCount = 0;
                g gVar = g.INSTANCE;
                Context applicationContext = activity.getApplicationContext();
                p.h(applicationContext, "getApplicationContext(...)");
                gVar.B(applicationContext, MemoryCategory.LOW);
            }
        }
    }

    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J9\u0010\u000b\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ?\u0010\u0010\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"com/stepos/ailauncher/common/imageloader/g$c", "Lcom/bumptech/glide/request/RequestListener;", "Landroid/graphics/drawable/Drawable;", "Lcom/bumptech/glide/load/engine/GlideException;", "e", "", AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, "Lcom/bumptech/glide/request/target/Target;", "target", "", "isFirstResource", "onLoadFailed", "(Lcom/bumptech/glide/load/engine/GlideException;Ljava/lang/Object;Lcom/bumptech/glide/request/target/Target;Z)Z", "resource", "Lcom/bumptech/glide/load/DataSource;", "dataSource", "c", "(Landroid/graphics/drawable/Drawable;Ljava/lang/Object;Lcom/bumptech/glide/request/target/Target;Lcom/bumptech/glide/load/DataSource;Z)Z", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c implements RequestListener<Drawable> {
        final /* synthetic */ com.stepos.ailauncher.common.imageloader.a $callback;
        final /* synthetic */ com.stepos.ailauncher.common.imageloader.b $detailCallback;

        public c(com.stepos.ailauncher.common.imageloader.a aVar, com.stepos.ailauncher.common.imageloader.b bVar) {
            this.$callback = aVar;
            this.$detailCallback = bVar;
        }

        public static final CharSequence b(Throwable th) {
            return th.getClass().getSimpleName() + ServerSentEventKt.COLON + th.getMessage();
        }

        @Override // com.bumptech.glide.request.RequestListener
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
            p.i(resource, "resource");
            p.i(model, "model");
            p.i(dataSource, "dataSource");
            g gVar = g.INSTANCE;
            gVar.u(this.$callback, this.$detailCallback, true, gVar.E(dataSource));
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(GlideException e10, Object model, Target<Drawable> target, boolean isFirstResource) {
            List<Throwable> rootCauses;
            p.i(target, "target");
            C4148a.h(g.TAG, "load failed target=" + target.hashCode() + " modelHash=" + (model != null ? Integer.valueOf(model.hashCode()) : null) + " message=" + (e10 != null ? e10.getMessage() : null) + " causes=" + ((e10 == null || (rootCauses = e10.getRootCauses()) == null) ? null : F.A0(rootCauses, null, null, null, 0, null, new InterfaceC5074l() { // from class: com.stepos.ailauncher.common.imageloader.h
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return g.c.b((Throwable) obj);
                }
            }, 31, null)), false, 4, null);
            g.INSTANCE.u(this.$callback, this.$detailCallback, false, ImageDataSource.UNKNOWN);
            return false;
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"com/stepos/ailauncher/common/imageloader/g$d", "Landroid/content/ComponentCallbacks2;", "Landroid/content/res/Configuration;", "newConfig", "LY8/t;", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "onLowMemory", "()V", "", "level", "onTrimMemory", "(I)V", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d implements ComponentCallbacks2 {
        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration newConfig) {
            p.i(newConfig, "newConfig");
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
            Application application = (Application) g.applicationRef.get();
            if (application == null) {
                return;
            }
            C4148a.u(g.TAG, "onLowMemory → clearMemory", false, 4, null);
            g.INSTANCE.m(application);
        }

        @Override // android.content.ComponentCallbacks2
        public void onTrimMemory(int level) {
            Application application = (Application) g.applicationRef.get();
            if (application == null) {
                return;
            }
            g.INSTANCE.F(application, level);
        }
    }

    public static final void A(InterfaceC5063a interfaceC5063a) {
        interfaceC5063a.invoke();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005e A[Catch: all -> 0x008d, TryCatch #0 {all -> 0x008d, blocks: (B:3:0x0002, B:16:0x0028, B:19:0x0089, B:17:0x0032, B:18:0x005e), top: B:25:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final Y8.t G(android.content.Context r7, int r8) {
        /*
            com.stepos.ailauncher.common.imageloader.g r0 = com.stepos.ailauncher.common.imageloader.g.INSTANCE
            kotlin.Result$a r1 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L8d
            android.content.Context r7 = r7.getApplicationContext()     // Catch: java.lang.Throwable -> L8d
            r1 = 10
            r2 = 0
            r3 = 4
            r4 = 0
            java.lang.String r5 = "trimMemory level="
            java.lang.String r6 = "ImageLoader"
            if (r8 == r1) goto L5e
            r1 = 15
            if (r8 == r1) goto L5e
            r1 = 20
            if (r8 == r1) goto L32
            r1 = 40
            if (r8 == r1) goto L5e
            r1 = 60
            if (r8 == r1) goto L5e
            r1 = 80
            if (r8 == r1) goto L5e
            com.bumptech.glide.Glide r7 = com.bumptech.glide.Glide.get(r7)     // Catch: java.lang.Throwable -> L8d
            r7.trimMemory(r8)     // Catch: java.lang.Throwable -> L8d
            Y8.t r7 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L8d
            goto L89
        L32:
            com.bumptech.glide.Glide r1 = com.bumptech.glide.Glide.get(r7)     // Catch: java.lang.Throwable -> L8d
            r1.trimMemory(r8)     // Catch: java.lang.Throwable -> L8d
            kotlin.jvm.internal.p.f(r7)     // Catch: java.lang.Throwable -> L8d
            com.bumptech.glide.MemoryCategory r1 = com.bumptech.glide.MemoryCategory.LOW     // Catch: java.lang.Throwable -> L8d
            r0.B(r7, r1)     // Catch: java.lang.Throwable -> L8d
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8d
            r7.<init>()     // Catch: java.lang.Throwable -> L8d
            r7.append(r5)     // Catch: java.lang.Throwable -> L8d
            r7.append(r8)     // Catch: java.lang.Throwable -> L8d
            java.lang.String r8 = " → trim + LOW"
            r7.append(r8)     // Catch: java.lang.Throwable -> L8d
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L8d
            int r7 = h8.C4148a.d(r6, r7, r4, r3, r2)     // Catch: java.lang.Throwable -> L8d
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Throwable -> L8d
            goto L89
        L5e:
            com.bumptech.glide.Glide r1 = com.bumptech.glide.Glide.get(r7)     // Catch: java.lang.Throwable -> L8d
            r1.clearMemory()     // Catch: java.lang.Throwable -> L8d
            kotlin.jvm.internal.p.f(r7)     // Catch: java.lang.Throwable -> L8d
            com.bumptech.glide.MemoryCategory r1 = com.bumptech.glide.MemoryCategory.LOW     // Catch: java.lang.Throwable -> L8d
            r0.B(r7, r1)     // Catch: java.lang.Throwable -> L8d
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8d
            r7.<init>()     // Catch: java.lang.Throwable -> L8d
            r7.append(r5)     // Catch: java.lang.Throwable -> L8d
            r7.append(r8)     // Catch: java.lang.Throwable -> L8d
            java.lang.String r8 = " → clearMemory + LOW"
            r7.append(r8)     // Catch: java.lang.Throwable -> L8d
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L8d
            int r7 = h8.C4148a.k(r6, r7, r4, r3, r2)     // Catch: java.lang.Throwable -> L8d
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Throwable -> L8d
        L89:
            kotlin.Result.b(r7)     // Catch: java.lang.Throwable -> L8d
            goto L97
        L8d:
            r7 = move-exception
            kotlin.Result$a r8 = kotlin.Result.INSTANCE
            java.lang.Object r7 = kotlin.C4849c.a(r7)
            kotlin.Result.b(r7)
        L97:
            Y8.t r7 = Y8.t.f7040a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.common.imageloader.g.G(android.content.Context, int):Y8.t");
    }

    public static final t n(Context context) {
        try {
            Result.Companion companion = Result.INSTANCE;
            Glide.get(context.getApplicationContext()).clearMemory();
            Result.b(Integer.valueOf(C4148a.d(TAG, "clearMemory", false, 4, null)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        return t.f7040a;
    }

    public static /* synthetic */ void s(g gVar, ImageView imageView, ImageRequest imageRequest, com.stepos.ailauncher.common.imageloader.a aVar, com.stepos.ailauncher.common.imageloader.b bVar, Context context, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            aVar = null;
        }
        if ((i10 & 8) != 0) {
            bVar = null;
        }
        if ((i10 & 16) != 0) {
            context = null;
        }
        gVar.q(imageView, imageRequest, aVar, bVar, context);
    }

    public static /* synthetic */ void t(g gVar, ImageView imageView, Object obj, int i10, int i11, int i12, boolean z10, int i13, int i14, com.stepos.ailauncher.common.imageloader.a aVar, int i15, Object obj2) {
        if ((i15 & 4) != 0) {
            i10 = 0;
        }
        if ((i15 & 8) != 0) {
            i11 = 0;
        }
        if ((i15 & 16) != 0) {
            i12 = 0;
        }
        if ((i15 & 32) != 0) {
            z10 = false;
        }
        if ((i15 & 64) != 0) {
            i13 = 0;
        }
        if ((i15 & 128) != 0) {
            i14 = 0;
        }
        if ((i15 & 256) != 0) {
            aVar = null;
        }
        gVar.r(imageView, obj, i10, i11, i12, z10, i13, i14, aVar);
    }

    public static final t y(Context context) {
        g gVar = INSTANCE;
        Context applicationContext = context.getApplicationContext();
        p.h(applicationContext, "getApplicationContext(...)");
        gVar.B(applicationContext, MemoryCategory.NORMAL);
        return t.f7040a;
    }

    public final void B(Context appCtx, MemoryCategory category) {
        if (memoryCategory == category) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            Glide.get(appCtx).setMemoryCategory(category);
            memoryCategory = category;
            Result.b(Integer.valueOf(C4148a.d(TAG, "MemoryCategory → " + category, false, 4, null)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
    }

    public final boolean C(int ow, int oh, ImageRequest request) {
        if (request.getPreferRgb565()) {
            return true;
        }
        if (request.getForceArgb8888()) {
            return false;
        }
        return ((ow <= 0 || oh <= 0) ? ow > 0 ? ow * ow : 0 : ow * oh) >= 25600;
    }

    public final int D(DisplayMetrics dm) {
        return Math.min(Math.max(dm.widthPixels, dm.heightPixels), 1080);
    }

    public final ImageDataSource E(DataSource dataSource) {
        int i10 = a.$EnumSwitchMapping$1[dataSource.ordinal()];
        if (i10 == 1) {
            return ImageDataSource.MEMORY_CACHE;
        }
        if (i10 == 2) {
            return ImageDataSource.RESOURCE_DISK_CACHE;
        }
        if (i10 == 3) {
            return ImageDataSource.DATA_DISK_CACHE;
        }
        if (i10 == 4) {
            return ImageDataSource.REMOTE;
        }
        if (i10 == 5) {
            return ImageDataSource.LOCAL;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void F(final Context context, final int level) {
        p.i(context, "context");
        if (level >= 20) {
            uiHiddenTrimmed = true;
        }
        z(new InterfaceC5063a() { // from class: com.stepos.ailauncher.common.imageloader.d
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return g.G(context, level);
            }
        });
    }

    public final Activity H(Context context) {
        while (context != null) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            if (!(context instanceof ContextWrapper)) {
                return null;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    public final void k(ImageView target, ImageRequest request) {
        if (request.getPlaceholderDrawable() != null) {
            target.setImageDrawable(request.getPlaceholderDrawable());
            return;
        }
        if (request.getPlaceholderResId() != 0) {
            target.setImageResource(request.getPlaceholderResId());
            return;
        }
        if (request.getErrorDrawable() != null) {
            target.setImageDrawable(request.getErrorDrawable());
        } else if (request.getErrorResId() != 0) {
            target.setImageResource(request.getErrorResId());
        } else {
            target.setImageDrawable(null);
        }
    }

    public final void l(ImageView target) {
        p.i(target, "target");
        Context context = target.getContext();
        if (p(context)) {
            try {
                Result.Companion companion = Result.INSTANCE;
                Glide.with(context).clear(target);
                Result.b(t.f7040a);
                return;
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
                return;
            }
        }
        try {
            Result.Companion companion3 = Result.INSTANCE;
            Glide.with(context.getApplicationContext()).clear(target);
            Result.b(t.f7040a);
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            Result.b(C4849c.a(th2));
        }
    }

    public final void m(final Context context) {
        p.i(context, "context");
        z(new InterfaceC5063a() { // from class: com.stepos.ailauncher.common.imageloader.e
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return g.n(context);
            }
        });
    }

    public final void o(Application application) {
        p.i(application, "application");
        if (initialized.compareAndSet(false, true)) {
            applicationRef.set(application);
            try {
                MemorySizeCalculator memorySizeCalculatorBuild = new MemorySizeCalculator.Builder(application).setMemoryCacheScreens(1.0f).setBitmapPoolScreens(1.5f).build();
                GlideBuilder defaultRequestOptions = new GlideBuilder().setMemorySizeCalculator(memorySizeCalculatorBuild).setDiskCache(new InternalCacheDiskCacheFactory(application, 83886080L)).setDefaultRequestOptions(new RequestOptions().disallowHardwareConfig().diskCacheStrategy(DiskCacheStrategy.AUTOMATIC).downsample(DownsampleStrategy.AT_MOST));
                p.h(defaultRequestOptions, "setDefaultRequestOptions(...)");
                Glide.init(application, defaultRequestOptions);
                C4148a.k(TAG, "init memoryCache=" + (memorySizeCalculatorBuild.getMemoryCacheSize() / 1024) + "KB bitmapPool=" + (memorySizeCalculatorBuild.getBitmapPoolSize() / 1024) + "KB diskMax=80MB", false, 4, null);
            } catch (IllegalArgumentException e10) {
                C4148a.u(TAG, "Glide already initialized, skip GlideBuilder: " + e10.getMessage(), false, 4, null);
            } catch (Exception e11) {
                C4148a.g(TAG, "ImageLoader.init failed", e11, false, 8, null);
            }
            application.registerComponentCallbacks(memoryCallbacks);
            application.registerActivityLifecycleCallbacks(activityCallbacks);
        }
    }

    public final boolean p(Context context) {
        if (context == null) {
            return false;
        }
        Activity activityH = H(context);
        if (activityH == null) {
            return true;
        }
        return (activityH.isDestroyed() || activityH.isFinishing()) ? false : true;
    }

    public final void q(ImageView target, ImageRequest request, com.stepos.ailauncher.common.imageloader.a callback, com.stepos.ailauncher.common.imageloader.b detailCallback, Context glideContext) {
        DiskCacheStrategy diskCacheStrategy;
        Integer crossFadeMs;
        p.i(target, "target");
        p.i(request, "request");
        uiHiddenTrimmed = false;
        Object model = request.getModel();
        if (model == null || ((model instanceof CharSequence) && H.x0((CharSequence) model))) {
            k(target, request);
            u(callback, detailCallback, false, ImageDataSource.UNKNOWN);
            return;
        }
        Context context = glideContext == null ? target.getContext() : glideContext;
        if (glideContext == null && !p(context)) {
            u(callback, detailCallback, false, ImageDataSource.UNKNOWN);
            return;
        }
        RequestBuilder requestBuilderTimeout = Glide.with(context).load(model).disallowHardwareConfig().timeout(TIMEOUT_MS);
        p.h(requestBuilderTimeout, "timeout(...)");
        RequestBuilder requestBuilder = requestBuilderTimeout;
        if (request.getPlaceholderDrawable() != null) {
            Cloneable cloneablePlaceholder = requestBuilder.placeholder(request.getPlaceholderDrawable());
            p.h(cloneablePlaceholder, "placeholder(...)");
            requestBuilder = (RequestBuilder) cloneablePlaceholder;
        } else if (request.getPlaceholderResId() != 0) {
            Cloneable cloneablePlaceholder2 = requestBuilder.placeholder(request.getPlaceholderResId());
            p.h(cloneablePlaceholder2, "placeholder(...)");
            requestBuilder = (RequestBuilder) cloneablePlaceholder2;
        }
        if (request.getErrorDrawable() != null) {
            Cloneable cloneableError = requestBuilder.error(request.getErrorDrawable());
            p.h(cloneableError, "error(...)");
            requestBuilder = (RequestBuilder) cloneableError;
        } else if (request.getErrorResId() != 0) {
            Cloneable cloneableError2 = requestBuilder.error(request.getErrorResId());
            p.h(cloneableError2, "error(...)");
            requestBuilder = (RequestBuilder) cloneableError2;
        }
        int i10 = a.$EnumSwitchMapping$0[request.getDiskCache().ordinal()];
        if (i10 == 1) {
            diskCacheStrategy = DiskCacheStrategy.ALL;
        } else if (i10 == 2) {
            diskCacheStrategy = DiskCacheStrategy.NONE;
        } else {
            if (i10 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            diskCacheStrategy = DiskCacheStrategy.AUTOMATIC;
        }
        RequestBuilder requestBuilderDiskCacheStrategy = requestBuilder.diskCacheStrategy(diskCacheStrategy);
        p.h(requestBuilderDiskCacheStrategy, "diskCacheStrategy(...)");
        RequestBuilder requestBuilderListener = requestBuilderDiskCacheStrategy;
        if (request.getSkipMemoryCache()) {
            Cloneable cloneableSkipMemoryCache = requestBuilderListener.skipMemoryCache(true);
            p.h(cloneableSkipMemoryCache, "skipMemoryCache(...)");
            requestBuilderListener = (RequestBuilder) cloneableSkipMemoryCache;
        }
        Pair<Integer, Integer> pairV = v(target, request);
        int iIntValue = pairV.a().intValue();
        int iIntValue2 = pairV.b().intValue();
        if (iIntValue > 0 && iIntValue2 > 0) {
            Cloneable cloneableOverride = requestBuilderListener.override(iIntValue, iIntValue2);
            p.h(cloneableOverride, "override(...)");
            requestBuilderListener = (RequestBuilder) cloneableOverride;
        } else if (iIntValue > 0) {
            Cloneable cloneableOverride2 = requestBuilderListener.override(iIntValue);
            p.h(cloneableOverride2, "override(...)");
            requestBuilderListener = (RequestBuilder) cloneableOverride2;
        }
        boolean z10 = request.getPreferRgb565() || C(iIntValue, iIntValue2, request);
        if (z10) {
            Cloneable cloneable = requestBuilderListener.format(DecodeFormat.PREFER_RGB_565);
            p.h(cloneable, "format(...)");
            requestBuilderListener = (RequestBuilder) cloneable;
        }
        List listC = C1172u.c();
        if (request.getTopCornerRadiusDp() > 0) {
            listC.add(new CenterCrop());
            float f10 = C5685n.f((int) ((request.getTopCornerRadiusDp() * target.getResources().getDisplayMetrics().density) + 0.5f), 1);
            listC.add(new GranularRoundedCorners(f10, f10, 0.0f, 0.0f));
        } else if (request.getCornerRadiusDp() > 0) {
            listC.add(new CenterCrop());
            listC.add(new RoundedCorners(C5685n.f((int) ((request.getCornerRadiusDp() * target.getResources().getDisplayMetrics().density) + 0.5f), 1)));
        }
        List listA = C1172u.a(listC);
        if (!listA.isEmpty()) {
            BitmapTransformation[] bitmapTransformationArr = (BitmapTransformation[]) listA.toArray(new BitmapTransformation[0]);
            Cloneable cloneableTransform = requestBuilderListener.transform((Transformation<Bitmap>[]) Arrays.copyOf(bitmapTransformationArr, bitmapTransformationArr.length));
            p.h(cloneableTransform, "transform(...)");
            requestBuilderListener = (RequestBuilder) cloneableTransform;
        } else if (request.getCenterCrop()) {
            Cloneable cloneableCenterCrop = requestBuilderListener.centerCrop();
            p.h(cloneableCenterCrop, "centerCrop(...)");
            requestBuilderListener = (RequestBuilder) cloneableCenterCrop;
        }
        if (request.getDontAnimate() || ((crossFadeMs = request.getCrossFadeMs()) != null && crossFadeMs.intValue() == 0)) {
            RequestBuilder requestBuilderDontAnimate = requestBuilderListener.dontAnimate();
            p.h(requestBuilderDontAnimate, "dontAnimate(...)");
            requestBuilderListener = requestBuilderDontAnimate;
        } else if (request.getCrossFadeMs() != null && request.getCrossFadeMs().intValue() > 0) {
            requestBuilderListener = requestBuilderListener.transition(DrawableTransitionOptions.withCrossFade(request.getCrossFadeMs().intValue()));
            p.h(requestBuilderListener, "transition(...)");
        }
        if (request.getThumbnailSizeMultiplier() > 0.0f) {
            RequestBuilder requestBuilderSizeMultiplier = Glide.with(context).load(model).disallowHardwareConfig().sizeMultiplier(request.getThumbnailSizeMultiplier());
            p.h(requestBuilderSizeMultiplier, "sizeMultiplier(...)");
            RequestBuilder requestBuilder2 = requestBuilderSizeMultiplier;
            if (z10) {
                Cloneable cloneable2 = requestBuilder2.format(DecodeFormat.PREFER_RGB_565);
                p.h(cloneable2, "format(...)");
                requestBuilder2 = (RequestBuilder) cloneable2;
            }
            requestBuilderListener = requestBuilderListener.thumbnail(requestBuilder2);
            p.h(requestBuilderListener, "thumbnail(...)");
        }
        if (callback != null || detailCallback != null) {
            requestBuilderListener = requestBuilderListener.listener(new c(callback, detailCallback));
            p.h(requestBuilderListener, "listener(...)");
        }
        requestBuilderListener.into(target);
    }

    public final void r(ImageView target, Object model, int placeholderResId, int errorResId, int cornerRadiusDp, boolean centerCrop, int overrideWidth, int overrideHeight, com.stepos.ailauncher.common.imageloader.a callback) {
        p.i(target, "target");
        s(this, target, new ImageRequest(model, placeholderResId, errorResId, null, null, cornerRadiusDp, 0, overrideWidth, overrideHeight, centerCrop, null, false, false, false, false, null, 0.0f, false, 261208, null), callback, null, null, 24, null);
    }

    public final void u(com.stepos.ailauncher.common.imageloader.a callback, com.stepos.ailauncher.common.imageloader.b detailCallback, boolean success, ImageDataSource source) {
        if (callback != null) {
            callback.a(success);
        }
        if (detailCallback != null) {
            detailCallback.a(success, source);
        }
    }

    public final Pair<Integer, Integer> v(ImageView target, ImageRequest request) {
        if (request.getOverrideWidth() > 0 && request.getOverrideHeight() > 0) {
            return j.a(Integer.valueOf(request.getOverrideWidth()), Integer.valueOf(request.getOverrideHeight()));
        }
        if (request.getOverrideWidth() > 0) {
            return j.a(Integer.valueOf(request.getOverrideWidth()), 0);
        }
        if (!request.getSizeSoftCap()) {
            return j.a(0, 0);
        }
        int iW = w(target, true);
        int iW2 = w(target, false);
        if (iW <= 0 || iW2 <= 0) {
            return j.a(0, 0);
        }
        DisplayMetrics displayMetrics = target.getResources().getDisplayMetrics();
        p.h(displayMetrics, "getDisplayMetrics(...)");
        int iD = D(displayMetrics);
        return j.a(Integer.valueOf(Math.min(iW, iD)), Integer.valueOf(Math.min(iW2, iD)));
    }

    public final int w(ImageView view, boolean horizontal) {
        int width = horizontal ? view.getWidth() : view.getHeight();
        if (width > 0) {
            return width;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            return 0;
        }
        int i10 = horizontal ? layoutParams.width : layoutParams.height;
        if (i10 > 0) {
            return i10;
        }
        return 0;
    }

    public final void x(final Context context) {
        p.i(context, "context");
        if (uiHiddenTrimmed) {
            return;
        }
        z(new InterfaceC5063a() { // from class: com.stepos.ailauncher.common.imageloader.c
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return g.y(context);
            }
        });
    }

    public final void z(final InterfaceC5063a<t> block) {
        if (p.d(Looper.myLooper(), Looper.getMainLooper())) {
            block.invoke();
        } else {
            mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.common.imageloader.f
                @Override // java.lang.Runnable
                public final void run() {
                    g.A(block);
                }
            });
        }
    }
}
