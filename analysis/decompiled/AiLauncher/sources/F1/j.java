package F1;

import A1.Parameters;
import A1.Tags;
import B1.c;
import La.C;
import La.H;
import Z8.F;
import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.net.Uri;
import android.os.Looper;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import coil.base.R$id;
import coil.decode.DataSource;
import coil.disk.a;
import coil.intercept.RealInterceptorChain;
import coil.intercept.a;
import coil.request.ViewTargetRequestManager;
import coil.size.Scale;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.JsonPointer;
import com.stepos.launcher.assistant.slidepanel.ConstConfig;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import tb.AbstractC5531D;
import tb.C5530C;
import tb.u;

@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001f\u0010\u0007\u001a\u0004\u0018\u00010\u0005*\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u0015\u0010\n\u001a\u00020\t*\u0004\u0018\u00010\tH\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u0015\u0010\r\u001a\u00020\f*\u0004\u0018\u00010\fH\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u0015\u0010\u0010\u001a\u00020\u000f*\u0004\u0018\u00010\u000fH\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u000f\u0010\u0013\u001a\u00020\u0012H\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001b\u0010\u0017\u001a\u00020\u0015*\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0013\u0010\u001a\u001a\u00020\u0001*\u00020\u0019H\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0013\u0010\u001c\u001a\u00020\u0012*\u00020\u0015H\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001b\u0010!\u001a\u00020\u0015*\u00020\u001e2\u0006\u0010 \u001a\u00020\u001fH\u0000¢\u0006\u0004\b!\u0010\"\u001a\u0017\u0010%\u001a\u00020\u00122\u0006\u0010$\u001a\u00020#H\u0000¢\u0006\u0004\b%\u0010&\u001a\u001b\u0010)\u001a\u00020'*\u00020'2\u0006\u0010(\u001a\u00020\u0005H\u0000¢\u0006\u0004\b)\u0010*\u001a\u0013\u0010-\u001a\u00020,*\u00020+H\u0000¢\u0006\u0004\b-\u0010.\u001a\u0017\u00102\u001a\u0002012\u0006\u00100\u001a\u00020/H\u0000¢\u0006\u0004\b2\u00103\u001a\u001f\u00105\u001a\u00020\u00152\u0006\u00100\u001a\u00020/2\u0006\u00104\u001a\u000201H\u0000¢\u0006\u0004\b5\u00106\" \u0010<\u001a\b\u0012\u0004\u0012\u000208078\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001a\u00109\u001a\u0004\b:\u0010;\"\u001a\u0010@\u001a\u0002088\u0000X\u0080\u0004¢\u0006\f\n\u0004\b)\u0010=\u001a\u0004\b>\u0010?\"\u001a\u0010D\u001a\u00020\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b5\u0010A\u001a\u0004\bB\u0010C\"\u0018\u0010I\u001a\u00020F*\u00020E8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bG\u0010H\"\u0018\u0010M\u001a\u00020\u0015*\u00020J8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bK\u0010L\"\u0018\u0010O\u001a\u00020\u0015*\u00020J8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bN\u0010L\"\u0018\u0010R\u001a\u00020\u0012*\u00020J8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bP\u0010Q\"\u0018\u0010 \u001a\u00020\u001f*\u00020S8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bT\u0010U\"\u001a\u0010X\u001a\u0004\u0018\u00010\u0005*\u00020#8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bV\u0010W\"\u0018\u0010\\\u001a\u00020\u0015*\u00020Y8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bZ\u0010[\"\u0018\u0010`\u001a\u00020]*\u00020/8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b^\u0010_\"\u0018\u0010d\u001a\u00020\u0012*\u00020a8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bb\u0010c\"\u0018\u0010h\u001a\u00020e*\u00020a8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bf\u0010g¨\u0006i"}, d2 = {"Ljava/io/Closeable;", "LY8/t;", Const.INTENT_KEY_UMID, "(Ljava/io/Closeable;)V", "Landroid/webkit/MimeTypeMap;", "", "url", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Landroid/webkit/MimeTypeMap;Ljava/lang/String;)Ljava/lang/String;", "Ltb/u;", "x", "(Ltb/u;)Ltb/u;", "LA1/q;", "w", "(LA1/q;)LA1/q;", "LA1/l;", "v", "(LA1/l;)LA1/l;", "", "r", "()Z", "", "defaultValue", "z", "(Ljava/lang/String;I)I", "Lcoil/disk/a$b;", Const.INTENT_KEY_APIKEY, "(Lcoil/disk/a$b;)V", "s", "(I)Z", "LB1/c;", "Lcoil/size/Scale;", ConstConfig.KEY_VIEW_SCALE_PROPERTY, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(LB1/c;Lcoil/size/Scale;)I", "Landroid/net/Uri;", "uri", "q", "(Landroid/net/Uri;)Z", "Ltb/u$a;", "line", Const.INTENT_KEY_PKGNAME, "(Ltb/u$a;Ljava/lang/String;)Ltb/u$a;", "Ltb/C;", "Ltb/D;", "y", "(Ltb/C;)Ltb/D;", "Landroid/content/Context;", "context", "", "e", "(Landroid/content/Context;)D", "percent", "c", "(Landroid/content/Context;D)I", "", "Landroid/graphics/Bitmap$Config;", "[Landroid/graphics/Bitmap$Config;", "o", "()[Landroid/graphics/Bitmap$Config;", "VALID_TRANSFORMATION_CONFIGS", "Landroid/graphics/Bitmap$Config;", "f", "()Landroid/graphics/Bitmap$Config;", "DEFAULT_BITMAP_CONFIG", "Ltb/u;", "getEMPTY_HEADERS", "()Ltb/u;", "EMPTY_HEADERS", "Landroid/view/View;", "Lcoil/request/ViewTargetRequestManager;", "l", "(Landroid/view/View;)Lcoil/request/ViewTargetRequestManager;", "requestManager", "Landroid/graphics/drawable/Drawable;", "p", "(Landroid/graphics/drawable/Drawable;)I", "width", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "height", "u", "(Landroid/graphics/drawable/Drawable;)Z", "isVector", "Landroid/widget/ImageView;", "n", "(Landroid/widget/ImageView;)Lcoil/size/Scale;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroid/net/Uri;)Ljava/lang/String;", "firstPathSegment", "Landroid/content/res/Configuration;", "k", "(Landroid/content/res/Configuration;)I", "nightMode", "Ljava/io/File;", "m", "(Landroid/content/Context;)Ljava/io/File;", "safeCacheDir", "Lcoil/intercept/a$a;", "t", "(Lcoil/intercept/a$a;)Z", "isPlaceholderCached", "Lcoil/b;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lcoil/intercept/a$a;)Lcoil/b;", "eventListener", "coil-base_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final Bitmap.Config[] f2549a = {Bitmap.Config.ARGB_8888, Bitmap.Config.RGBA_F16};

    /* renamed from: b, reason: collision with root package name */
    public static final Bitmap.Config f2550b = Bitmap.Config.HARDWARE;

    /* renamed from: c, reason: collision with root package name */
    public static final u f2551c = new u.a().f();

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2552a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f2553b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f2554c;

        static {
            int[] iArr = new int[DataSource.values().length];
            try {
                iArr[DataSource.MEMORY_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DataSource.MEMORY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DataSource.DISK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DataSource.NETWORK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f2552a = iArr;
            int[] iArr2 = new int[ImageView.ScaleType.values().length];
            try {
                iArr2[ImageView.ScaleType.FIT_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[ImageView.ScaleType.FIT_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            f2553b = iArr2;
            int[] iArr3 = new int[Scale.values().length];
            try {
                iArr3[Scale.FILL.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[Scale.FIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            f2554c = iArr3;
        }
    }

    public static final int A(B1.c cVar, Scale scale) {
        if (cVar instanceof c.a) {
            return ((c.a) cVar).px;
        }
        int i10 = a.f2554c[scale.ordinal()];
        if (i10 == 1) {
            return Integer.MIN_VALUE;
        }
        if (i10 == 2) {
            return Integer.MAX_VALUE;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final void a(a.b bVar) {
        try {
            bVar.b();
        } catch (Exception unused) {
        }
    }

    public static final u.a b(u.a aVar, String str) {
        int iT0 = H.t0(str, ':', 0, false, 6, null);
        if (iT0 == -1) {
            throw new IllegalArgumentException(("Unexpected header: " + str).toString());
        }
        String strSubstring = str.substring(0, iT0);
        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        String string = H.D1(strSubstring).toString();
        String strSubstring2 = str.substring(iT0 + 1);
        kotlin.jvm.internal.p.h(strSubstring2, "substring(...)");
        aVar.e(string, strSubstring2);
        return aVar;
    }

    public static final int c(Context context, double d10) {
        int largeMemoryClass;
        try {
            Object objI = androidx.core.content.a.i(context, ActivityManager.class);
            kotlin.jvm.internal.p.f(objI);
            ActivityManager activityManager = (ActivityManager) objI;
            largeMemoryClass = (context.getApplicationInfo().flags & 1048576) != 0 ? activityManager.getLargeMemoryClass() : activityManager.getMemoryClass();
        } catch (Exception unused) {
            largeMemoryClass = 256;
        }
        double d11 = 1024;
        return (int) (d10 * largeMemoryClass * d11 * d11);
    }

    public static final void d(Closeable closeable) throws IOException {
        try {
            closeable.close();
        } catch (RuntimeException e10) {
            throw e10;
        } catch (Exception unused) {
        }
    }

    public static final double e(Context context) {
        try {
            Object objI = androidx.core.content.a.i(context, ActivityManager.class);
            kotlin.jvm.internal.p.f(objI);
            return ((ActivityManager) objI).isLowRamDevice() ? 0.15d : 0.2d;
        } catch (Exception unused) {
            return 0.2d;
        }
    }

    public static final Bitmap.Config f() {
        return f2550b;
    }

    public static final coil.b g(a.InterfaceC0199a interfaceC0199a) {
        return interfaceC0199a instanceof RealInterceptorChain ? ((RealInterceptorChain) interfaceC0199a).getEventListener() : coil.b.f15557b;
    }

    public static final String h(Uri uri) {
        return (String) F.s0(uri.getPathSegments());
    }

    public static final int i(Drawable drawable) {
        Bitmap bitmap;
        BitmapDrawable bitmapDrawable = drawable instanceof BitmapDrawable ? (BitmapDrawable) drawable : null;
        return (bitmapDrawable == null || (bitmap = bitmapDrawable.getBitmap()) == null) ? drawable.getIntrinsicHeight() : bitmap.getHeight();
    }

    public static final String j(MimeTypeMap mimeTypeMap, String str) {
        if (str == null || H.x0(str)) {
            return null;
        }
        return mimeTypeMap.getMimeTypeFromExtension(H.q1(H.s1(H.A1(H.A1(str, '#', null, 2, null), '?', null, 2, null), JsonPointer.SEPARATOR, null, 2, null), '.', ""));
    }

    public static final int k(Configuration configuration) {
        return configuration.uiMode & 48;
    }

    public static final ViewTargetRequestManager l(View view) {
        ViewTargetRequestManager viewTargetRequestManager;
        int i10 = R$id.coil_request_manager;
        Object tag = view.getTag(i10);
        ViewTargetRequestManager viewTargetRequestManager2 = tag instanceof ViewTargetRequestManager ? (ViewTargetRequestManager) tag : null;
        if (viewTargetRequestManager2 != null) {
            return viewTargetRequestManager2;
        }
        synchronized (view) {
            try {
                Object tag2 = view.getTag(i10);
                viewTargetRequestManager = tag2 instanceof ViewTargetRequestManager ? (ViewTargetRequestManager) tag2 : null;
                if (viewTargetRequestManager == null) {
                    viewTargetRequestManager = new ViewTargetRequestManager(view);
                    view.addOnAttachStateChangeListener(viewTargetRequestManager);
                    view.setTag(i10, viewTargetRequestManager);
                }
            } finally {
            }
        }
        return viewTargetRequestManager;
    }

    public static final File m(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            throw new IllegalStateException("cacheDir == null");
        }
        cacheDir.mkdirs();
        return cacheDir;
    }

    public static final Scale n(ImageView imageView) {
        ImageView.ScaleType scaleType = imageView.getScaleType();
        int i10 = scaleType == null ? -1 : a.f2553b[scaleType.ordinal()];
        return (i10 == 1 || i10 == 2 || i10 == 3 || i10 == 4) ? Scale.FIT : Scale.FILL;
    }

    public static final Bitmap.Config[] o() {
        return f2549a;
    }

    public static final int p(Drawable drawable) {
        Bitmap bitmap;
        BitmapDrawable bitmapDrawable = drawable instanceof BitmapDrawable ? (BitmapDrawable) drawable : null;
        return (bitmapDrawable == null || (bitmap = bitmapDrawable.getBitmap()) == null) ? drawable.getIntrinsicWidth() : bitmap.getWidth();
    }

    public static final boolean q(Uri uri) {
        return kotlin.jvm.internal.p.d(uri.getScheme(), Const.STR_FILE) && kotlin.jvm.internal.p.d(h(uri), "android_asset");
    }

    public static final boolean r() {
        return kotlin.jvm.internal.p.d(Looper.myLooper(), Looper.getMainLooper());
    }

    public static final boolean s(int i10) {
        return i10 == Integer.MIN_VALUE || i10 == Integer.MAX_VALUE;
    }

    public static final boolean t(a.InterfaceC0199a interfaceC0199a) {
        return (interfaceC0199a instanceof RealInterceptorChain) && ((RealInterceptorChain) interfaceC0199a).getIsPlaceholderCached();
    }

    public static final boolean u(Drawable drawable) {
        return (drawable instanceof VectorDrawable) || (drawable instanceof q1.f);
    }

    public static final Parameters v(Parameters parameters) {
        return parameters == null ? Parameters.f240c : parameters;
    }

    public static final Tags w(Tags tags) {
        return tags == null ? Tags.f256c : tags;
    }

    public static final u x(u uVar) {
        return uVar == null ? f2551c : uVar;
    }

    public static final AbstractC5531D y(C5530C c5530c) {
        AbstractC5531D body = c5530c.getBody();
        if (body != null) {
            return body;
        }
        throw new IllegalStateException("response body == null");
    }

    public static final int z(String str, int i10) {
        Long lY = C.y(str);
        if (lY == null) {
            return i10;
        }
        long jLongValue = lY.longValue();
        if (jLongValue > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (jLongValue < 0) {
            return 0;
        }
        return (int) jLongValue;
    }
}
