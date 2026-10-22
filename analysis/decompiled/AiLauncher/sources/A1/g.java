package A1;

import A1.Parameters;
import B1.Size;
import E1.b;
import Ua.I;
import Z8.C1173v;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.drawable.Drawable;
import android.view.Lifecycle;
import android.view.View;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import coil.decode.c;
import coil.fetch.f;
import coil.memory.MemoryCache;
import coil.request.CachePolicy;
import coil.size.Precision;
import coil.size.Scale;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.launcher.assistant.slidepanel.ConstConfig;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import tb.u;

@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\bh\u0018\u00002\u00020\u0001:\u0002SOB÷\u0002\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u001c\u0010\u0016\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0015\u0018\u00010\u0013\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010#\u001a\u00020\"\u0012\u0006\u0010$\u001a\u00020\"\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010&\u001a\u00020\"\u0012\u0006\u0010(\u001a\u00020'\u0012\u0006\u0010)\u001a\u00020'\u0012\u0006\u0010*\u001a\u00020'\u0012\u0006\u0010,\u001a\u00020+\u0012\u0006\u0010-\u001a\u00020+\u0012\u0006\u0010.\u001a\u00020+\u0012\u0006\u0010/\u001a\u00020+\u0012\u0006\u00101\u001a\u000200\u0012\u0006\u00103\u001a\u000202\u0012\u0006\u00105\u001a\u000204\u0012\u0006\u00107\u001a\u000206\u0012\b\u00108\u001a\u0004\u0018\u00010\t\u0012\b\u0010:\u001a\u0004\u0018\u000109\u0012\b\u0010<\u001a\u0004\u0018\u00010;\u0012\b\u0010=\u001a\u0004\u0018\u000109\u0012\b\u0010>\u001a\u0004\u0018\u00010;\u0012\b\u0010?\u001a\u0004\u0018\u000109\u0012\b\u0010@\u001a\u0004\u0018\u00010;\u0012\u0006\u0010B\u001a\u00020A\u0012\u0006\u0010D\u001a\u00020C¢\u0006\u0004\bE\u0010FJ\u0019\u0010H\u001a\u00020G2\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\bH\u0010IJ\u001a\u0010K\u001a\u00020\"2\b\u0010J\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\bK\u0010LJ\u000f\u0010M\u001a\u000209H\u0016¢\u0006\u0004\bM\u0010NR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR\u0017\u0010\u0004\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010VR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010ZR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b_\u0010`\u001a\u0004\ba\u0010bR\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\bc\u0010d\u001a\u0004\be\u0010fR\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\bg\u0010h\u001a\u0004\bi\u0010jR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006¢\u0006\f\n\u0004\bk\u0010l\u001a\u0004\bm\u0010nR\u0017\u0010\u0012\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\bo\u0010p\u001a\u0004\bq\u0010rR-\u0010\u0016\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0015\u0018\u00010\u00138\u0006¢\u0006\f\n\u0004\bi\u0010s\u001a\u0004\bt\u0010uR\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006¢\u0006\f\n\u0004\bm\u0010v\u001a\u0004\bw\u0010xR\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0006¢\u0006\f\n\u0004\bQ\u0010y\u001a\u0004\bz\u0010{R\u0017\u0010\u001d\u001a\u00020\u001c8\u0006¢\u0006\f\n\u0004\bU\u0010|\u001a\u0004\b}\u0010~R\u001a\u0010\u001f\u001a\u00020\u001e8\u0006¢\u0006\u000f\n\u0005\b\u007f\u0010\u0080\u0001\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001a\u0010!\u001a\u00020 8\u0006¢\u0006\u000f\n\u0005\bw\u0010\u0083\u0001\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001R\u001a\u0010#\u001a\u00020\"8\u0006¢\u0006\u000f\n\u0006\b\u0086\u0001\u0010\u0087\u0001\u001a\u0005\bg\u0010\u0088\u0001R\u001a\u0010$\u001a\u00020\"8\u0006¢\u0006\u000f\n\u0006\b\u0089\u0001\u0010\u0087\u0001\u001a\u0005\bk\u0010\u0088\u0001R\u0019\u0010%\u001a\u00020\"8\u0006¢\u0006\u000e\n\u0005\be\u0010\u0087\u0001\u001a\u0005\bo\u0010\u0088\u0001R\u001b\u0010&\u001a\u00020\"8\u0006¢\u0006\u0010\n\u0006\b\u008a\u0001\u0010\u0087\u0001\u001a\u0006\b\u008b\u0001\u0010\u0088\u0001R\u001b\u0010(\u001a\u00020'8\u0006¢\u0006\u0010\n\u0006\b\u008c\u0001\u0010\u008d\u0001\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001R\u001b\u0010)\u001a\u00020'8\u0006¢\u0006\u0010\n\u0006\b\u0090\u0001\u0010\u008d\u0001\u001a\u0006\b\u008a\u0001\u0010\u008f\u0001R\u001b\u0010*\u001a\u00020'8\u0006¢\u0006\u0010\n\u0006\b\u0091\u0001\u0010\u008d\u0001\u001a\u0006\b\u0092\u0001\u0010\u008f\u0001R\u001a\u0010,\u001a\u00020+8\u0006¢\u0006\u000f\n\u0005\bt\u0010\u0093\u0001\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001R\u001b\u0010-\u001a\u00020+8\u0006¢\u0006\u0010\n\u0006\b\u0081\u0001\u0010\u0093\u0001\u001a\u0006\b\u0091\u0001\u0010\u0095\u0001R\u001a\u0010.\u001a\u00020+8\u0006¢\u0006\u000f\n\u0006\b\u0094\u0001\u0010\u0093\u0001\u001a\u0005\b\u007f\u0010\u0095\u0001R\u001b\u0010/\u001a\u00020+8\u0006¢\u0006\u0010\n\u0006\b\u0096\u0001\u0010\u0093\u0001\u001a\u0006\b\u0097\u0001\u0010\u0095\u0001R\u001a\u00101\u001a\u0002008\u0006¢\u0006\u000f\n\u0005\b]\u0010\u0098\u0001\u001a\u0006\b\u0096\u0001\u0010\u0099\u0001R\u001a\u00103\u001a\u0002028\u0006¢\u0006\u000f\n\u0005\ba\u0010\u009a\u0001\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001R\u001b\u00105\u001a\u0002048\u0006¢\u0006\u0010\n\u0006\b\u008e\u0001\u0010\u009d\u0001\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001R\u001b\u00107\u001a\u0002068\u0006¢\u0006\u0010\n\u0006\b\u0092\u0001\u0010 \u0001\u001a\u0006\b¡\u0001\u0010¢\u0001R\u001b\u00108\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\u000e\n\u0005\b¡\u0001\u0010`\u001a\u0005\b£\u0001\u0010bR\u0018\u0010:\u001a\u0004\u0018\u0001098\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¤\u0001\u0010¥\u0001R\u0018\u0010<\u001a\u0004\u0018\u00010;8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b£\u0001\u0010¦\u0001R\u0017\u0010=\u001a\u0004\u0018\u0001098\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bq\u0010¥\u0001R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008b\u0001\u0010¦\u0001R\u0018\u0010?\u001a\u0004\u0018\u0001098\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009e\u0001\u0010¥\u0001R\u0018\u0010@\u001a\u0004\u0018\u00010;8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009b\u0001\u0010¦\u0001R\u001b\u0010B\u001a\u00020A8\u0006¢\u0006\u0010\n\u0006\b\u0084\u0001\u0010§\u0001\u001a\u0006\b\u0089\u0001\u0010¨\u0001R\u001a\u0010D\u001a\u00020C8\u0006¢\u0006\u000f\n\u0005\bY\u0010©\u0001\u001a\u0006\b\u0086\u0001\u0010ª\u0001R\u0016\u0010¬\u0001\u001a\u0004\u0018\u00010;8F¢\u0006\b\u001a\u0006\b¤\u0001\u0010«\u0001R\u0016\u0010\u00ad\u0001\u001a\u0004\u0018\u00010;8F¢\u0006\b\u001a\u0006\b\u008c\u0001\u0010«\u0001R\u0016\u0010®\u0001\u001a\u0004\u0018\u00010;8F¢\u0006\b\u001a\u0006\b\u0090\u0001\u0010«\u0001¨\u0006¯\u0001"}, d2 = {"LA1/g;", "", "Landroid/content/Context;", "context", "data", "LC1/c;", "target", "LA1/g$b;", "listener", "Lcoil/memory/MemoryCache$Key;", "memoryCacheKey", "", "diskCacheKey", "Landroid/graphics/Bitmap$Config;", "bitmapConfig", "Landroid/graphics/ColorSpace;", "colorSpace", "Lcoil/size/Precision;", "precision", "Lkotlin/Pair;", "Lcoil/fetch/f$a;", "Ljava/lang/Class;", "fetcherFactory", "Lcoil/decode/c$a;", "decoderFactory", "", "LD1/b;", "transformations", "LE1/b$a;", "transitionFactory", "Ltb/u;", "headers", "LA1/q;", "tags", "", "allowConversionToBitmap", "allowHardware", "allowRgb565", "premultipliedAlpha", "Lcoil/request/CachePolicy;", "memoryCachePolicy", "diskCachePolicy", "networkCachePolicy", "LUa/I;", "interceptorDispatcher", "fetcherDispatcher", "decoderDispatcher", "transformationDispatcher", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "LB1/h;", "sizeResolver", "Lcoil/size/Scale;", ConstConfig.KEY_VIEW_SCALE_PROPERTY, "LA1/l;", "parameters", "placeholderMemoryCacheKey", "", "placeholderResId", "Landroid/graphics/drawable/Drawable;", "placeholderDrawable", "errorResId", "errorDrawable", "fallbackResId", "fallbackDrawable", "LA1/c;", "defined", "LA1/b;", "defaults", "<init>", "(Landroid/content/Context;Ljava/lang/Object;LC1/c;LA1/g$b;Lcoil/memory/MemoryCache$Key;Ljava/lang/String;Landroid/graphics/Bitmap$Config;Landroid/graphics/ColorSpace;Lcoil/size/Precision;Lkotlin/Pair;Lcoil/decode/c$a;Ljava/util/List;LE1/b$a;Ltb/u;LA1/q;ZZZZLcoil/request/CachePolicy;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;LUa/I;LUa/I;LUa/I;LUa/I;Landroidx/lifecycle/Lifecycle;LB1/h;Lcoil/size/Scale;LA1/l;Lcoil/memory/MemoryCache$Key;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;LA1/c;LA1/b;)V", "LA1/g$a;", "Q", "(Landroid/content/Context;)LA1/g$a;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", Const.INTENT_KEY_APIKEY, "Landroid/content/Context;", "l", "()Landroid/content/Context;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/Object;", "m", "()Ljava/lang/Object;", "c", "LC1/c;", "M", "()LC1/c;", Const.INTENT_KEY_UMID, "LA1/g$b;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()LA1/g$b;", "e", "Lcoil/memory/MemoryCache$Key;", "B", "()Lcoil/memory/MemoryCache$Key;", "f", "Ljava/lang/String;", "r", "()Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_COMMAND, "Landroid/graphics/Bitmap$Config;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Landroid/graphics/Bitmap$Config;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Landroid/graphics/ColorSpace;", "k", "()Landroid/graphics/ColorSpace;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Lcoil/size/Precision;", "H", "()Lcoil/size/Precision;", "Lkotlin/Pair;", "w", "()Lkotlin/Pair;", "Lcoil/decode/c$a;", "o", "()Lcoil/decode/c$a;", "Ljava/util/List;", "O", "()Ljava/util/List;", "LE1/b$a;", "P", "()LE1/b$a;", "n", "Ltb/u;", "x", "()Ltb/u;", "LA1/q;", "L", "()LA1/q;", "p", "Z", "()Z", "q", "s", "I", "t", "Lcoil/request/CachePolicy;", "C", "()Lcoil/request/CachePolicy;", "u", "v", "D", "LUa/I;", "y", "()LUa/I;", "z", "N", "Landroidx/lifecycle/Lifecycle;", "()Landroidx/lifecycle/Lifecycle;", "LB1/h;", "K", "()LB1/h;", "Lcoil/size/Scale;", "J", "()Lcoil/size/Scale;", "LA1/l;", ExifInterface.LONGITUDE_EAST, "()LA1/l;", "G", "F", "Ljava/lang/Integer;", "Landroid/graphics/drawable/Drawable;", "LA1/c;", "()LA1/c;", "LA1/b;", "()LA1/b;", "()Landroid/graphics/drawable/Drawable;", "placeholder", "error", "fallback", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class g {

    /* renamed from: A, reason: collision with root package name and from kotlin metadata */
    public final Lifecycle lifecycle;

    /* renamed from: B, reason: collision with root package name and from kotlin metadata */
    public final B1.h sizeResolver;

    /* renamed from: C, reason: collision with root package name and from kotlin metadata */
    public final Scale scale;

    /* renamed from: D, reason: collision with root package name and from kotlin metadata */
    public final Parameters parameters;

    /* renamed from: E, reason: collision with root package name and from kotlin metadata */
    public final MemoryCache.Key placeholderMemoryCacheKey;

    /* renamed from: F, reason: collision with root package name and from kotlin metadata */
    public final Integer placeholderResId;

    /* renamed from: G, reason: collision with root package name and from kotlin metadata */
    public final Drawable placeholderDrawable;

    /* renamed from: H, reason: collision with root package name and from kotlin metadata */
    public final Integer errorResId;

    /* renamed from: I, reason: collision with root package name and from kotlin metadata */
    public final Drawable errorDrawable;

    /* renamed from: J, reason: collision with root package name and from kotlin metadata */
    public final Integer fallbackResId;

    /* renamed from: K, reason: collision with root package name and from kotlin metadata */
    public final Drawable fallbackDrawable;

    /* renamed from: L, reason: collision with root package name and from kotlin metadata */
    public final c defined;

    /* renamed from: M, reason: collision with root package name and from kotlin metadata */
    public final A1.b defaults;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Object data;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final C1.c target;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final b listener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final MemoryCache.Key memoryCacheKey;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final String diskCacheKey;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final Bitmap.Config bitmapConfig;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final ColorSpace colorSpace;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final Precision precision;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final Pair<f.a<?>, Class<?>> fetcherFactory;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public final c.a decoderFactory;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public final List<D1.b> transformations;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public final b.a transitionFactory;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public final u headers;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    public final Tags tags;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    public final boolean allowConversionToBitmap;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    public final boolean allowHardware;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    public final boolean allowRgb565;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    public final boolean premultipliedAlpha;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    public final CachePolicy memoryCachePolicy;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    public final CachePolicy diskCachePolicy;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    public final CachePolicy networkCachePolicy;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    public final I interceptorDispatcher;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    public final I fetcherDispatcher;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    public final I decoderDispatcher;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    public final I transformationDispatcher;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0007\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0017¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\fH\u0017¢\u0006\u0004\b\r\u0010\u000eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"LA1/g$b;", "", "LA1/g;", "request", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(LA1/g;)V", Const.INTENT_KEY_APIKEY, "LA1/e;", "result", Const.INTENT_KEY_UMID, "(LA1/g;LA1/e;)V", "LA1/o;", "c", "(LA1/g;LA1/o;)V", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface b {
        default void a(g request) {
        }

        default void b(g request) {
        }

        default void c(g request, o result) {
        }

        default void d(g request, e result) {
        }
    }

    public /* synthetic */ g(Context context, Object obj, C1.c cVar, b bVar, MemoryCache.Key key, String str, Bitmap.Config config, ColorSpace colorSpace, Precision precision, Pair pair, c.a aVar, List list, b.a aVar2, u uVar, Tags tags, boolean z10, boolean z11, boolean z12, boolean z13, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, I i10, I i11, I i12, I i13, Lifecycle lifecycle, B1.h hVar, Scale scale, Parameters parameters, MemoryCache.Key key2, Integer num, Drawable drawable, Integer num2, Drawable drawable2, Integer num3, Drawable drawable3, c cVar2, A1.b bVar2, kotlin.jvm.internal.i iVar) {
        this(context, obj, cVar, bVar, key, str, config, colorSpace, precision, pair, aVar, list, aVar2, uVar, tags, z10, z11, z12, z13, cachePolicy, cachePolicy2, cachePolicy3, i10, i11, i12, i13, lifecycle, hVar, scale, parameters, key2, num, drawable, num2, drawable2, num3, drawable3, cVar2, bVar2);
    }

    public static /* synthetic */ a R(g gVar, Context context, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            context = gVar.context;
        }
        return gVar.Q(context);
    }

    /* renamed from: A, reason: from getter */
    public final b getListener() {
        return this.listener;
    }

    /* renamed from: B, reason: from getter */
    public final MemoryCache.Key getMemoryCacheKey() {
        return this.memoryCacheKey;
    }

    /* renamed from: C, reason: from getter */
    public final CachePolicy getMemoryCachePolicy() {
        return this.memoryCachePolicy;
    }

    /* renamed from: D, reason: from getter */
    public final CachePolicy getNetworkCachePolicy() {
        return this.networkCachePolicy;
    }

    /* renamed from: E, reason: from getter */
    public final Parameters getParameters() {
        return this.parameters;
    }

    public final Drawable F() {
        return F1.h.c(this, this.placeholderDrawable, this.placeholderResId, this.defaults.getPlaceholder());
    }

    /* renamed from: G, reason: from getter */
    public final MemoryCache.Key getPlaceholderMemoryCacheKey() {
        return this.placeholderMemoryCacheKey;
    }

    /* renamed from: H, reason: from getter */
    public final Precision getPrecision() {
        return this.precision;
    }

    /* renamed from: I, reason: from getter */
    public final boolean getPremultipliedAlpha() {
        return this.premultipliedAlpha;
    }

    /* renamed from: J, reason: from getter */
    public final Scale getScale() {
        return this.scale;
    }

    /* renamed from: K, reason: from getter */
    public final B1.h getSizeResolver() {
        return this.sizeResolver;
    }

    /* renamed from: L, reason: from getter */
    public final Tags getTags() {
        return this.tags;
    }

    /* renamed from: M, reason: from getter */
    public final C1.c getTarget() {
        return this.target;
    }

    /* renamed from: N, reason: from getter */
    public final I getTransformationDispatcher() {
        return this.transformationDispatcher;
    }

    public final List<D1.b> O() {
        return this.transformations;
    }

    /* renamed from: P, reason: from getter */
    public final b.a getTransitionFactory() {
        return this.transitionFactory;
    }

    public final a Q(Context context) {
        return new a(this, context);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof g)) {
            return false;
        }
        g gVar = (g) other;
        return kotlin.jvm.internal.p.d(this.context, gVar.context) && kotlin.jvm.internal.p.d(this.data, gVar.data) && kotlin.jvm.internal.p.d(this.target, gVar.target) && kotlin.jvm.internal.p.d(this.listener, gVar.listener) && kotlin.jvm.internal.p.d(this.memoryCacheKey, gVar.memoryCacheKey) && kotlin.jvm.internal.p.d(this.diskCacheKey, gVar.diskCacheKey) && this.bitmapConfig == gVar.bitmapConfig && kotlin.jvm.internal.p.d(this.colorSpace, gVar.colorSpace) && this.precision == gVar.precision && kotlin.jvm.internal.p.d(this.fetcherFactory, gVar.fetcherFactory) && kotlin.jvm.internal.p.d(this.decoderFactory, gVar.decoderFactory) && kotlin.jvm.internal.p.d(this.transformations, gVar.transformations) && kotlin.jvm.internal.p.d(this.transitionFactory, gVar.transitionFactory) && kotlin.jvm.internal.p.d(this.headers, gVar.headers) && kotlin.jvm.internal.p.d(this.tags, gVar.tags) && this.allowConversionToBitmap == gVar.allowConversionToBitmap && this.allowHardware == gVar.allowHardware && this.allowRgb565 == gVar.allowRgb565 && this.premultipliedAlpha == gVar.premultipliedAlpha && this.memoryCachePolicy == gVar.memoryCachePolicy && this.diskCachePolicy == gVar.diskCachePolicy && this.networkCachePolicy == gVar.networkCachePolicy && kotlin.jvm.internal.p.d(this.interceptorDispatcher, gVar.interceptorDispatcher) && kotlin.jvm.internal.p.d(this.fetcherDispatcher, gVar.fetcherDispatcher) && kotlin.jvm.internal.p.d(this.decoderDispatcher, gVar.decoderDispatcher) && kotlin.jvm.internal.p.d(this.transformationDispatcher, gVar.transformationDispatcher) && kotlin.jvm.internal.p.d(this.placeholderMemoryCacheKey, gVar.placeholderMemoryCacheKey) && kotlin.jvm.internal.p.d(this.placeholderResId, gVar.placeholderResId) && kotlin.jvm.internal.p.d(this.placeholderDrawable, gVar.placeholderDrawable) && kotlin.jvm.internal.p.d(this.errorResId, gVar.errorResId) && kotlin.jvm.internal.p.d(this.errorDrawable, gVar.errorDrawable) && kotlin.jvm.internal.p.d(this.fallbackResId, gVar.fallbackResId) && kotlin.jvm.internal.p.d(this.fallbackDrawable, gVar.fallbackDrawable) && kotlin.jvm.internal.p.d(this.lifecycle, gVar.lifecycle) && kotlin.jvm.internal.p.d(this.sizeResolver, gVar.sizeResolver) && this.scale == gVar.scale && kotlin.jvm.internal.p.d(this.parameters, gVar.parameters) && kotlin.jvm.internal.p.d(this.defined, gVar.defined) && kotlin.jvm.internal.p.d(this.defaults, gVar.defaults);
    }

    /* renamed from: g, reason: from getter */
    public final boolean getAllowConversionToBitmap() {
        return this.allowConversionToBitmap;
    }

    /* renamed from: h, reason: from getter */
    public final boolean getAllowHardware() {
        return this.allowHardware;
    }

    public int hashCode() {
        int iHashCode = ((this.context.hashCode() * 31) + this.data.hashCode()) * 31;
        C1.c cVar = this.target;
        int iHashCode2 = (iHashCode + (cVar != null ? cVar.hashCode() : 0)) * 31;
        b bVar = this.listener;
        int iHashCode3 = (iHashCode2 + (bVar != null ? bVar.hashCode() : 0)) * 31;
        MemoryCache.Key key = this.memoryCacheKey;
        int iHashCode4 = (iHashCode3 + (key != null ? key.hashCode() : 0)) * 31;
        String str = this.diskCacheKey;
        int iHashCode5 = (((iHashCode4 + (str != null ? str.hashCode() : 0)) * 31) + this.bitmapConfig.hashCode()) * 31;
        ColorSpace colorSpace = this.colorSpace;
        int iHashCode6 = (((iHashCode5 + (colorSpace != null ? colorSpace.hashCode() : 0)) * 31) + this.precision.hashCode()) * 31;
        Pair<f.a<?>, Class<?>> pair = this.fetcherFactory;
        int iHashCode7 = (iHashCode6 + (pair != null ? pair.hashCode() : 0)) * 31;
        c.a aVar = this.decoderFactory;
        int iHashCode8 = (((((((((((((((((((((((((((((((((((((((iHashCode7 + (aVar != null ? aVar.hashCode() : 0)) * 31) + this.transformations.hashCode()) * 31) + this.transitionFactory.hashCode()) * 31) + this.headers.hashCode()) * 31) + this.tags.hashCode()) * 31) + Boolean.hashCode(this.allowConversionToBitmap)) * 31) + Boolean.hashCode(this.allowHardware)) * 31) + Boolean.hashCode(this.allowRgb565)) * 31) + Boolean.hashCode(this.premultipliedAlpha)) * 31) + this.memoryCachePolicy.hashCode()) * 31) + this.diskCachePolicy.hashCode()) * 31) + this.networkCachePolicy.hashCode()) * 31) + this.interceptorDispatcher.hashCode()) * 31) + this.fetcherDispatcher.hashCode()) * 31) + this.decoderDispatcher.hashCode()) * 31) + this.transformationDispatcher.hashCode()) * 31) + this.lifecycle.hashCode()) * 31) + this.sizeResolver.hashCode()) * 31) + this.scale.hashCode()) * 31) + this.parameters.hashCode()) * 31;
        MemoryCache.Key key2 = this.placeholderMemoryCacheKey;
        int iHashCode9 = (iHashCode8 + (key2 != null ? key2.hashCode() : 0)) * 31;
        Integer num = this.placeholderResId;
        int iHashCode10 = (iHashCode9 + (num != null ? num.hashCode() : 0)) * 31;
        Drawable drawable = this.placeholderDrawable;
        int iHashCode11 = (iHashCode10 + (drawable != null ? drawable.hashCode() : 0)) * 31;
        Integer num2 = this.errorResId;
        int iHashCode12 = (iHashCode11 + (num2 != null ? num2.hashCode() : 0)) * 31;
        Drawable drawable2 = this.errorDrawable;
        int iHashCode13 = (iHashCode12 + (drawable2 != null ? drawable2.hashCode() : 0)) * 31;
        Integer num3 = this.fallbackResId;
        int iHashCode14 = (iHashCode13 + (num3 != null ? num3.hashCode() : 0)) * 31;
        Drawable drawable3 = this.fallbackDrawable;
        return ((((iHashCode14 + (drawable3 != null ? drawable3.hashCode() : 0)) * 31) + this.defined.hashCode()) * 31) + this.defaults.hashCode();
    }

    /* renamed from: i, reason: from getter */
    public final boolean getAllowRgb565() {
        return this.allowRgb565;
    }

    /* renamed from: j, reason: from getter */
    public final Bitmap.Config getBitmapConfig() {
        return this.bitmapConfig;
    }

    /* renamed from: k, reason: from getter */
    public final ColorSpace getColorSpace() {
        return this.colorSpace;
    }

    /* renamed from: l, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    /* renamed from: m, reason: from getter */
    public final Object getData() {
        return this.data;
    }

    /* renamed from: n, reason: from getter */
    public final I getDecoderDispatcher() {
        return this.decoderDispatcher;
    }

    /* renamed from: o, reason: from getter */
    public final c.a getDecoderFactory() {
        return this.decoderFactory;
    }

    /* renamed from: p, reason: from getter */
    public final A1.b getDefaults() {
        return this.defaults;
    }

    /* renamed from: q, reason: from getter */
    public final c getDefined() {
        return this.defined;
    }

    /* renamed from: r, reason: from getter */
    public final String getDiskCacheKey() {
        return this.diskCacheKey;
    }

    /* renamed from: s, reason: from getter */
    public final CachePolicy getDiskCachePolicy() {
        return this.diskCachePolicy;
    }

    public final Drawable t() {
        return F1.h.c(this, this.errorDrawable, this.errorResId, this.defaults.getError());
    }

    public final Drawable u() {
        return F1.h.c(this, this.fallbackDrawable, this.fallbackResId, this.defaults.getFallback());
    }

    /* renamed from: v, reason: from getter */
    public final I getFetcherDispatcher() {
        return this.fetcherDispatcher;
    }

    public final Pair<f.a<?>, Class<?>> w() {
        return this.fetcherFactory;
    }

    /* renamed from: x, reason: from getter */
    public final u getHeaders() {
        return this.headers;
    }

    /* renamed from: y, reason: from getter */
    public final I getInterceptorDispatcher() {
        return this.interceptorDispatcher;
    }

    /* renamed from: z, reason: from getter */
    public final Lifecycle getLifecycle() {
        return this.lifecycle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(Context context, Object obj, C1.c cVar, b bVar, MemoryCache.Key key, String str, Bitmap.Config config, ColorSpace colorSpace, Precision precision, Pair<? extends f.a<?>, ? extends Class<?>> pair, c.a aVar, List<? extends D1.b> list, b.a aVar2, u uVar, Tags tags, boolean z10, boolean z11, boolean z12, boolean z13, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, I i10, I i11, I i12, I i13, Lifecycle lifecycle, B1.h hVar, Scale scale, Parameters parameters, MemoryCache.Key key2, Integer num, Drawable drawable, Integer num2, Drawable drawable2, Integer num3, Drawable drawable3, c cVar2, A1.b bVar2) {
        this.context = context;
        this.data = obj;
        this.target = cVar;
        this.listener = bVar;
        this.memoryCacheKey = key;
        this.diskCacheKey = str;
        this.bitmapConfig = config;
        this.colorSpace = colorSpace;
        this.precision = precision;
        this.fetcherFactory = pair;
        this.decoderFactory = aVar;
        this.transformations = list;
        this.transitionFactory = aVar2;
        this.headers = uVar;
        this.tags = tags;
        this.allowConversionToBitmap = z10;
        this.allowHardware = z11;
        this.allowRgb565 = z12;
        this.premultipliedAlpha = z13;
        this.memoryCachePolicy = cachePolicy;
        this.diskCachePolicy = cachePolicy2;
        this.networkCachePolicy = cachePolicy3;
        this.interceptorDispatcher = i10;
        this.fetcherDispatcher = i11;
        this.decoderDispatcher = i12;
        this.transformationDispatcher = i13;
        this.lifecycle = lifecycle;
        this.sizeResolver = hVar;
        this.scale = scale;
        this.parameters = parameters;
        this.placeholderMemoryCacheKey = key2;
        this.placeholderResId = num;
        this.placeholderDrawable = drawable;
        this.errorResId = num2;
        this.errorDrawable = drawable2;
        this.fallbackResId = num3;
        this.fallbackDrawable = drawable3;
        this.defined = cVar2;
        this.defaults = bVar2;
    }

    @Metadata(d1 = {"\u0000ô\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b \u0010\u001cJ\u0017\u0010#\u001a\u00020\u00002\b\u0010\"\u001a\u0004\u0018\u00010!¢\u0006\u0004\b#\u0010$J!\u0010(\u001a\u00020\u00002\u0012\u0010'\u001a\n\u0012\u0006\b\u0001\u0012\u00020&0%\"\u00020&¢\u0006\u0004\b(\u0010)J\u001b\u0010+\u001a\u00020\u00002\f\u0010'\u001a\b\u0012\u0004\u0012\u00020&0*¢\u0006\u0004\b+\u0010,J\u0015\u0010/\u001a\u00020\u00002\u0006\u0010.\u001a\u00020-¢\u0006\u0004\b/\u00100J\u0015\u00103\u001a\u00020\u00002\u0006\u00102\u001a\u000201¢\u0006\u0004\b3\u00104J\u0017\u00107\u001a\u00020\u00002\b\b\u0001\u00106\u001a\u000205¢\u0006\u0004\b7\u00108J\u0017\u00109\u001a\u00020\u00002\b\b\u0001\u00106\u001a\u000205¢\u0006\u0004\b9\u00108J\u0015\u0010<\u001a\u00020\u00002\u0006\u0010;\u001a\u00020:¢\u0006\u0004\b<\u0010=J\u0017\u0010@\u001a\u00020\u00002\b\u0010?\u001a\u0004\u0018\u00010>¢\u0006\u0004\b@\u0010AJ\u0015\u0010D\u001a\u00020\u00002\u0006\u0010C\u001a\u00020B¢\u0006\u0004\bD\u0010EJ\r\u0010F\u001a\u00020\u0006¢\u0006\u0004\bF\u0010GR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u0010HR\u0016\u0010C\u001a\u00020B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010IR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010JR\u0018\u0010?\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010KR\u0018\u0010\"\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010LR\u0018\u0010N\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010MR\u0018\u0010P\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010OR\u0018\u0010R\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010QR\u0018\u0010U\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010TR\u0018\u0010X\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010WR,\u0010]\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030Z\u0012\b\u0012\u0006\u0012\u0002\b\u00030[\u0018\u00010Y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u0010\\R\u0018\u0010`\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010_R\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020&0*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010aR\u0018\u0010d\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010cR\u0018\u0010g\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010fR(\u0010j\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030[\u0012\u0004\u0012\u00020\u0001\u0018\u00010h8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010iR\u0016\u0010l\u001a\u0002018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010kR\u0018\u0010n\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010mR\u0018\u0010o\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010mR\u0016\u0010p\u001a\u0002018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010kR\u0018\u0010t\u001a\u0004\u0018\u00010q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010sR\u0018\u0010v\u001a\u0004\u0018\u00010q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010sR\u0018\u0010x\u001a\u0004\u0018\u00010q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010sR\u0018\u0010|\u001a\u0004\u0018\u00010y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010{R\u0018\u0010~\u001a\u0004\u0018\u00010y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010{R\u0019\u0010\u0080\u0001\u001a\u0004\u0018\u00010y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u007f\u0010{R\u001a\u0010\u0082\u0001\u001a\u0004\u0018\u00010y8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0081\u0001\u0010{R\u001c\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0083\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R\u001a\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0087\u0001\u0010MR\u001b\u0010\u008b\u0001\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R\u001c\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u008c\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R\u001b\u0010\u0091\u0001\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b\u0090\u0001\u0010\u008a\u0001R\u001c\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u008c\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0092\u0001\u0010\u008e\u0001R\u001b\u0010\u0095\u0001\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b\u0094\u0001\u0010\u008a\u0001R\u001c\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u008c\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0096\u0001\u0010\u008e\u0001R\u001b\u0010\u009a\u0001\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0098\u0001\u0010\u0099\u0001R\u001b\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001R\u001b\u0010 \u0001\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009e\u0001\u0010\u009f\u0001R\u001b\u0010¢\u0001\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¡\u0001\u0010\u0099\u0001R\u001b\u0010¤\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b£\u0001\u0010\u009c\u0001R\u001b\u0010¦\u0001\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¥\u0001\u0010\u009f\u0001¨\u0006§\u0001"}, d2 = {"LA1/g$a;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "LA1/g;", "request", "(LA1/g;Landroid/content/Context;)V", "LY8/t;", "m", "()V", "l", "Landroidx/lifecycle/Lifecycle;", "n", "()Landroidx/lifecycle/Lifecycle;", "LB1/h;", "p", "()LB1/h;", "Lcoil/size/Scale;", "o", "()Lcoil/size/Scale;", "data", Const.INTENT_KEY_UMID, "(Ljava/lang/Object;)LA1/g$a;", "", "key", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;)LA1/g$a;", "Lcoil/memory/MemoryCache$Key;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lcoil/memory/MemoryCache$Key;)LA1/g$a;", "f", "LA1/g$b;", "listener", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(LA1/g$b;)LA1/g$a;", "", "LD1/b;", "transformations", "t", "([LD1/b;)LA1/g$a;", "", "s", "(Ljava/util/List;)LA1/g$a;", "Landroid/graphics/Bitmap$Config;", "config", Const.INTENT_KEY_PKGNAME, "(Landroid/graphics/Bitmap$Config;)LA1/g$a;", "", "enable", Const.INTENT_KEY_APIKEY, "(Z)LA1/g$a;", "", "drawableResId", "k", "(I)LA1/g$a;", Const.INTENT_KEY_BACKGROUND_COMMAND, "Landroid/widget/ImageView;", "imageView", "r", "(Landroid/widget/ImageView;)LA1/g$a;", "LC1/c;", "target", "q", "(LC1/c;)LA1/g$a;", "LA1/b;", "defaults", "e", "(LA1/b;)LA1/g$a;", "c", "()LA1/g;", "Landroid/content/Context;", "LA1/b;", "Ljava/lang/Object;", "LC1/c;", "LA1/g$b;", "Lcoil/memory/MemoryCache$Key;", "memoryCacheKey", "Ljava/lang/String;", "diskCacheKey", "Landroid/graphics/Bitmap$Config;", "bitmapConfig", "Landroid/graphics/ColorSpace;", "Landroid/graphics/ColorSpace;", "colorSpace", "Lcoil/size/Precision;", "Lcoil/size/Precision;", "precision", "Lkotlin/Pair;", "Lcoil/fetch/f$a;", "Ljava/lang/Class;", "Lkotlin/Pair;", "fetcherFactory", "Lcoil/decode/c$a;", "Lcoil/decode/c$a;", "decoderFactory", "Ljava/util/List;", "LE1/b$a;", "LE1/b$a;", "transitionFactory", "Ltb/u$a;", "Ltb/u$a;", "headers", "", "Ljava/util/Map;", "tags", "Z", "allowConversionToBitmap", "Ljava/lang/Boolean;", "allowHardware", "allowRgb565", "premultipliedAlpha", "Lcoil/request/CachePolicy;", "u", "Lcoil/request/CachePolicy;", "memoryCachePolicy", "v", "diskCachePolicy", "w", "networkCachePolicy", "LUa/I;", "x", "LUa/I;", "interceptorDispatcher", "y", "fetcherDispatcher", "z", "decoderDispatcher", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "transformationDispatcher", "LA1/l$a;", "B", "LA1/l$a;", "parameters", "C", "placeholderMemoryCacheKey", "D", "Ljava/lang/Integer;", "placeholderResId", "Landroid/graphics/drawable/Drawable;", ExifInterface.LONGITUDE_EAST, "Landroid/graphics/drawable/Drawable;", "placeholderDrawable", "F", "errorResId", "G", "errorDrawable", "H", "fallbackResId", "I", "fallbackDrawable", "J", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "K", "LB1/h;", "sizeResolver", "L", "Lcoil/size/Scale;", ConstConfig.KEY_VIEW_SCALE_PROPERTY, "M", "resolvedLifecycle", "N", "resolvedSizeResolver", "O", "resolvedScale", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* renamed from: A, reason: collision with root package name and from kotlin metadata */
        public I transformationDispatcher;

        /* renamed from: B, reason: collision with root package name and from kotlin metadata */
        public Parameters.a parameters;

        /* renamed from: C, reason: collision with root package name and from kotlin metadata */
        public MemoryCache.Key placeholderMemoryCacheKey;

        /* renamed from: D, reason: collision with root package name and from kotlin metadata */
        public Integer placeholderResId;

        /* renamed from: E, reason: collision with root package name and from kotlin metadata */
        public Drawable placeholderDrawable;

        /* renamed from: F, reason: collision with root package name and from kotlin metadata */
        public Integer errorResId;

        /* renamed from: G, reason: collision with root package name and from kotlin metadata */
        public Drawable errorDrawable;

        /* renamed from: H, reason: collision with root package name and from kotlin metadata */
        public Integer fallbackResId;

        /* renamed from: I, reason: collision with root package name and from kotlin metadata */
        public Drawable fallbackDrawable;

        /* renamed from: J, reason: collision with root package name and from kotlin metadata */
        public Lifecycle lifecycle;

        /* renamed from: K, reason: collision with root package name and from kotlin metadata */
        public B1.h sizeResolver;

        /* renamed from: L, reason: collision with root package name and from kotlin metadata */
        public Scale scale;

        /* renamed from: M, reason: collision with root package name and from kotlin metadata */
        public Lifecycle resolvedLifecycle;

        /* renamed from: N, reason: collision with root package name and from kotlin metadata */
        public B1.h resolvedSizeResolver;

        /* renamed from: O, reason: collision with root package name and from kotlin metadata */
        public Scale resolvedScale;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final Context context;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public A1.b defaults;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public Object data;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public C1.c target;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public b listener;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        public MemoryCache.Key memoryCacheKey;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        public String diskCacheKey;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        public Bitmap.Config bitmapConfig;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        public ColorSpace colorSpace;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        public Precision precision;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        public Pair<? extends f.a<?>, ? extends Class<?>> fetcherFactory;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        public c.a decoderFactory;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        public List<? extends D1.b> transformations;

        /* renamed from: n, reason: collision with root package name and from kotlin metadata */
        public b.a transitionFactory;

        /* renamed from: o, reason: collision with root package name and from kotlin metadata */
        public u.a headers;

        /* renamed from: p, reason: collision with root package name and from kotlin metadata */
        public Map<Class<?>, Object> tags;

        /* renamed from: q, reason: collision with root package name and from kotlin metadata */
        public boolean allowConversionToBitmap;

        /* renamed from: r, reason: collision with root package name and from kotlin metadata */
        public Boolean allowHardware;

        /* renamed from: s, reason: collision with root package name and from kotlin metadata */
        public Boolean allowRgb565;

        /* renamed from: t, reason: collision with root package name and from kotlin metadata */
        public boolean premultipliedAlpha;

        /* renamed from: u, reason: collision with root package name and from kotlin metadata */
        public CachePolicy memoryCachePolicy;

        /* renamed from: v, reason: collision with root package name and from kotlin metadata */
        public CachePolicy diskCachePolicy;

        /* renamed from: w, reason: collision with root package name and from kotlin metadata */
        public CachePolicy networkCachePolicy;

        /* renamed from: x, reason: collision with root package name and from kotlin metadata */
        public I interceptorDispatcher;

        /* renamed from: y, reason: collision with root package name and from kotlin metadata */
        public I fetcherDispatcher;

        /* renamed from: z, reason: collision with root package name and from kotlin metadata */
        public I decoderDispatcher;

        public a(Context context) {
            this.context = context;
            this.defaults = F1.h.b();
            this.data = null;
            this.target = null;
            this.listener = null;
            this.memoryCacheKey = null;
            this.diskCacheKey = null;
            this.bitmapConfig = null;
            this.colorSpace = null;
            this.precision = null;
            this.fetcherFactory = null;
            this.decoderFactory = null;
            this.transformations = C1173v.m();
            this.transitionFactory = null;
            this.headers = null;
            this.tags = null;
            this.allowConversionToBitmap = true;
            this.allowHardware = null;
            this.allowRgb565 = null;
            this.premultipliedAlpha = true;
            this.memoryCachePolicy = null;
            this.diskCachePolicy = null;
            this.networkCachePolicy = null;
            this.interceptorDispatcher = null;
            this.fetcherDispatcher = null;
            this.decoderDispatcher = null;
            this.transformationDispatcher = null;
            this.parameters = null;
            this.placeholderMemoryCacheKey = null;
            this.placeholderResId = null;
            this.placeholderDrawable = null;
            this.errorResId = null;
            this.errorDrawable = null;
            this.fallbackResId = null;
            this.fallbackDrawable = null;
            this.lifecycle = null;
            this.sizeResolver = null;
            this.scale = null;
            this.resolvedLifecycle = null;
            this.resolvedSizeResolver = null;
            this.resolvedScale = null;
        }

        public final a a(boolean enable) {
            this.allowHardware = Boolean.valueOf(enable);
            return this;
        }

        public final a b(Bitmap.Config config) {
            this.bitmapConfig = config;
            return this;
        }

        public final g c() {
            Context context = this.context;
            Object obj = this.data;
            if (obj == null) {
                obj = i.f222a;
            }
            C1.c cVar = this.target;
            b bVar = this.listener;
            MemoryCache.Key key = this.memoryCacheKey;
            String str = this.diskCacheKey;
            Bitmap.Config configE = this.bitmapConfig;
            if (configE == null) {
                configE = this.defaults.getBitmapConfig();
            }
            ColorSpace colorSpace = this.colorSpace;
            Precision precisionO = this.precision;
            if (precisionO == null) {
                precisionO = this.defaults.getPrecision();
            }
            Pair<? extends f.a<?>, ? extends Class<?>> pair = this.fetcherFactory;
            c.a aVar = this.decoderFactory;
            List<? extends D1.b> list = this.transformations;
            b.a aVarQ = this.transitionFactory;
            if (aVarQ == null) {
                aVarQ = this.defaults.getTransitionFactory();
            }
            u.a aVar2 = this.headers;
            u uVarX = F1.j.x(aVar2 != null ? aVar2.f() : null);
            Map<Class<?>, ? extends Object> map = this.tags;
            Tags tagsW = F1.j.w(map != null ? Tags.INSTANCE.a(map) : null);
            boolean z10 = this.allowConversionToBitmap;
            Boolean bool = this.allowHardware;
            boolean zBooleanValue = bool != null ? bool.booleanValue() : this.defaults.getAllowHardware();
            Boolean bool2 = this.allowRgb565;
            boolean zBooleanValue2 = bool2 != null ? bool2.booleanValue() : this.defaults.getAllowRgb565();
            boolean z11 = this.premultipliedAlpha;
            CachePolicy cachePolicyL = this.memoryCachePolicy;
            if (cachePolicyL == null) {
                cachePolicyL = this.defaults.getMemoryCachePolicy();
            }
            CachePolicy cachePolicy = cachePolicyL;
            CachePolicy cachePolicyG = this.diskCachePolicy;
            if (cachePolicyG == null) {
                cachePolicyG = this.defaults.getDiskCachePolicy();
            }
            CachePolicy cachePolicy2 = cachePolicyG;
            CachePolicy cachePolicyM = this.networkCachePolicy;
            if (cachePolicyM == null) {
                cachePolicyM = this.defaults.getNetworkCachePolicy();
            }
            CachePolicy cachePolicy3 = cachePolicyM;
            I iK = this.interceptorDispatcher;
            if (iK == null) {
                iK = this.defaults.getInterceptorDispatcher();
            }
            I i10 = iK;
            I iJ = this.fetcherDispatcher;
            if (iJ == null) {
                iJ = this.defaults.getFetcherDispatcher();
            }
            I i11 = iJ;
            I iF = this.decoderDispatcher;
            if (iF == null) {
                iF = this.defaults.getDecoderDispatcher();
            }
            I i12 = iF;
            I iP = this.transformationDispatcher;
            if (iP == null) {
                iP = this.defaults.getTransformationDispatcher();
            }
            I i13 = iP;
            Lifecycle lifecycleN = this.lifecycle;
            if (lifecycleN == null && (lifecycleN = this.resolvedLifecycle) == null) {
                lifecycleN = n();
            }
            Lifecycle lifecycle = lifecycleN;
            B1.h hVarP = this.sizeResolver;
            if (hVarP == null && (hVarP = this.resolvedSizeResolver) == null) {
                hVarP = p();
            }
            B1.h hVar = hVarP;
            Scale scaleO = this.scale;
            if (scaleO == null && (scaleO = this.resolvedScale) == null) {
                scaleO = o();
            }
            Scale scale = scaleO;
            Parameters.a aVar3 = this.parameters;
            return new g(context, obj, cVar, bVar, key, str, configE, colorSpace, precisionO, pair, aVar, list, aVarQ, uVarX, tagsW, z10, zBooleanValue, zBooleanValue2, z11, cachePolicy, cachePolicy2, cachePolicy3, i10, i11, i12, i13, lifecycle, hVar, scale, F1.j.v(aVar3 != null ? aVar3.a() : null), this.placeholderMemoryCacheKey, this.placeholderResId, this.placeholderDrawable, this.errorResId, this.errorDrawable, this.fallbackResId, this.fallbackDrawable, new c(this.lifecycle, this.sizeResolver, this.scale, this.interceptorDispatcher, this.fetcherDispatcher, this.decoderDispatcher, this.transformationDispatcher, this.transitionFactory, this.precision, this.bitmapConfig, this.allowHardware, this.allowRgb565, this.memoryCachePolicy, this.diskCachePolicy, this.networkCachePolicy), this.defaults, null);
        }

        public final a d(Object data) {
            this.data = data;
            return this;
        }

        public final a e(A1.b defaults) {
            this.defaults = defaults;
            l();
            return this;
        }

        public final a f(String key) {
            this.diskCacheKey = key;
            return this;
        }

        public final a g(int drawableResId) {
            this.errorResId = Integer.valueOf(drawableResId);
            this.errorDrawable = null;
            return this;
        }

        public final a h(b listener) {
            this.listener = listener;
            return this;
        }

        public final a i(MemoryCache.Key key) {
            this.memoryCacheKey = key;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final a j(String key) {
            MemoryCache.Key key2 = null;
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            if (key != null) {
                key2 = new MemoryCache.Key(key, objArr2 == true ? 1 : 0, 2, objArr == true ? 1 : 0);
            }
            return i(key2);
        }

        public final a k(int drawableResId) {
            this.placeholderResId = Integer.valueOf(drawableResId);
            this.placeholderDrawable = null;
            return this;
        }

        public final void l() {
            this.resolvedScale = null;
        }

        public final void m() {
            this.resolvedLifecycle = null;
            this.resolvedSizeResolver = null;
            this.resolvedScale = null;
        }

        public final Lifecycle n() {
            C1.c cVar = this.target;
            Lifecycle lifecycleC = F1.d.c(cVar instanceof C1.d ? ((C1.d) cVar).getView().getContext() : this.context);
            return lifecycleC == null ? f.f140b : lifecycleC;
        }

        public final Scale o() {
            View view;
            B1.h hVar = this.sizeResolver;
            View view2 = null;
            B1.j jVar = hVar instanceof B1.j ? (B1.j) hVar : null;
            if (jVar == null || (view = jVar.getView()) == null) {
                C1.c cVar = this.target;
                C1.d dVar = cVar instanceof C1.d ? (C1.d) cVar : null;
                if (dVar != null) {
                    view2 = dVar.getView();
                }
            } else {
                view2 = view;
            }
            return view2 instanceof ImageView ? F1.j.n((ImageView) view2) : Scale.FIT;
        }

        public final B1.h p() {
            ImageView.ScaleType scaleType;
            C1.c cVar = this.target;
            if (!(cVar instanceof C1.d)) {
                return new B1.d(this.context);
            }
            View view = ((C1.d) cVar).getView();
            return ((view instanceof ImageView) && ((scaleType = ((ImageView) view).getScaleType()) == ImageView.ScaleType.CENTER || scaleType == ImageView.ScaleType.MATRIX)) ? B1.i.a(Size.f1423d) : B1.k.b(view, false, 2, null);
        }

        public final a q(C1.c target) {
            this.target = target;
            m();
            return this;
        }

        public final a r(ImageView imageView) {
            return q(new C1.b(imageView));
        }

        public final a s(List<? extends D1.b> transformations) {
            this.transformations = F1.c.a(transformations);
            return this;
        }

        public final a t(D1.b... transformations) {
            return s(Z8.r.T0(transformations));
        }

        public a(g gVar, Context context) {
            this.context = context;
            this.defaults = gVar.getDefaults();
            this.data = gVar.getData();
            this.target = gVar.getTarget();
            this.listener = gVar.getListener();
            this.memoryCacheKey = gVar.getMemoryCacheKey();
            this.diskCacheKey = gVar.getDiskCacheKey();
            this.bitmapConfig = gVar.getDefined().getBitmapConfig();
            this.colorSpace = gVar.getColorSpace();
            this.precision = gVar.getDefined().getPrecision();
            this.fetcherFactory = gVar.w();
            this.decoderFactory = gVar.getDecoderFactory();
            this.transformations = gVar.O();
            this.transitionFactory = gVar.getDefined().getTransitionFactory();
            this.headers = gVar.getHeaders().i();
            this.tags = kotlin.collections.a.C(gVar.getTags().a());
            this.allowConversionToBitmap = gVar.getAllowConversionToBitmap();
            this.allowHardware = gVar.getDefined().getAllowHardware();
            this.allowRgb565 = gVar.getDefined().getAllowRgb565();
            this.premultipliedAlpha = gVar.getPremultipliedAlpha();
            this.memoryCachePolicy = gVar.getDefined().getMemoryCachePolicy();
            this.diskCachePolicy = gVar.getDefined().getDiskCachePolicy();
            this.networkCachePolicy = gVar.getDefined().getNetworkCachePolicy();
            this.interceptorDispatcher = gVar.getDefined().getInterceptorDispatcher();
            this.fetcherDispatcher = gVar.getDefined().getFetcherDispatcher();
            this.decoderDispatcher = gVar.getDefined().getDecoderDispatcher();
            this.transformationDispatcher = gVar.getDefined().getTransformationDispatcher();
            this.parameters = gVar.getParameters().e();
            this.placeholderMemoryCacheKey = gVar.getPlaceholderMemoryCacheKey();
            this.placeholderResId = gVar.placeholderResId;
            this.placeholderDrawable = gVar.placeholderDrawable;
            this.errorResId = gVar.errorResId;
            this.errorDrawable = gVar.errorDrawable;
            this.fallbackResId = gVar.fallbackResId;
            this.fallbackDrawable = gVar.fallbackDrawable;
            this.lifecycle = gVar.getDefined().getLifecycle();
            this.sizeResolver = gVar.getDefined().getSizeResolver();
            this.scale = gVar.getDefined().getCom.stepos.launcher.assistant.slidepanel.ConstConfig.KEY_VIEW_SCALE_PROPERTY java.lang.String();
            if (gVar.getContext() == context) {
                this.resolvedLifecycle = gVar.getLifecycle();
                this.resolvedSizeResolver = gVar.getSizeResolver();
                this.resolvedScale = gVar.getScale();
            } else {
                this.resolvedLifecycle = null;
                this.resolvedSizeResolver = null;
                this.resolvedScale = null;
            }
        }
    }
}
