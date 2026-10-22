package z7;

import Y8.t;
import Z8.C1173v;
import Z8.F;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.util.Log;
import android.view.Display;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import stepos.view.effects.StepOSGlassMaterial;
import z7.C6375j;

@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\bÀ\u0002\u0018\u00002\u00020\u0001:\u0003\\\u001a7B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0011\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0014\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000e¢\u0006\u0004\b\u0014\u0010\u0012J\u001f\u0010\u0017\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001d\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ'\u0010!\u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b!\u0010\"JU\u0010+\u001a\u00020\u00102\n\u0010$\u001a\u0006\u0012\u0002\b\u00030#2\u0006\u0010%\u001a\u00020\u00012\u0006\u0010'\u001a\u00020&2\u0010\u0010)\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030#0(2\u0016\u0010*\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010(\"\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b+\u0010,J\u001f\u0010/\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020\u001bH\u0002¢\u0006\u0004\b/\u00100J\u0017\u00101\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002¢\u0006\u0004\b1\u00102J\u0017\u00103\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002¢\u0006\u0004\b3\u00102J\u0017\u00104\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002¢\u0006\u0004\b4\u00102J\u0017\u00105\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002¢\u0006\u0004\b5\u00102R\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u001a\u0010;\u001a\b\u0012\u0002\b\u0003\u0018\u00010#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010:R\u001a\u0010=\u001a\b\u0012\u0002\b\u0003\u0018\u00010#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010:R\u0016\u0010A\u001a\u0004\u0018\u00010>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010C\u001a\u0004\u0018\u00010>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010@R \u0010G\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00150D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010I\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010HR\u001a\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00150J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR4\u0010R\u001a\"\u0012\u0004\u0012\u00020&\u0012\u0006\u0012\u0004\u0018\u00010>0Nj\u0010\u0012\u0004\u0012\u00020&\u0012\u0006\u0012\u0004\u0018\u00010>`O8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010H\u001a\u0006\u0012\u0002\b\u00030#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010:R\u0018\u0010U\u001a\u0006\u0012\u0002\b\u00030#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010:R\u0018\u0010V\u001a\u0006\u0012\u0002\b\u00030#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010:R\u0018\u0010W\u001a\u0006\u0012\u0002\b\u00030#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u0010:R\u0011\u0010Y\u001a\u0002068F¢\u0006\u0006\u001a\u0004\b\u0013\u0010XR\u0014\u0010[\u001a\u0002068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bZ\u0010X¨\u0006]"}, d2 = {"Lz7/j;", "", "<init>", "()V", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function0;", "body", "o", "(Lp9/a;)Ljava/lang/Object;", "Landroid/view/View;", "view", "Lz7/j$c;", "m", "(Landroid/view/View;)Lz7/j$c;", "", "px", "LY8/t;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Landroid/view/View;F)V", "v", "C", "Lz7/j$b;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "x", "(Landroid/view/View;Lz7/j$b;)V", "Lz7/j$a;", "c", "", "effCgMode", "r", "(Lz7/j$a;I)Ljava/lang/Object;", "Landroid/graphics/RenderEffect;", "blur", "q", "(Lz7/j$a;Landroid/graphics/RenderEffect;I)Landroid/graphics/RenderEffect;", "Ljava/lang/Class;", "cls", "target", "", "name", "", "types", "args", "s", "(Ljava/lang/Class;Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)V", "mode", "rotation", "z", "(II)I", "n", "(I)F", "w", "u", "p", "", Const.INTENT_KEY_PKGNAME, "Z", "sdkAvailable", "Ljava/lang/Class;", "builderClass", Const.INTENT_KEY_UMID, "materialParamsClass", "Ljava/lang/reflect/Method;", "e", "Ljava/lang/reflect/Method;", "createGlassEffect", "f", "createStepOSBlurEffect", "Ljava/util/WeakHashMap;", Const.INTENT_KEY_BACKGROUND_COMMAND, "Ljava/util/WeakHashMap;", "holders", "I", "batchDepth", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Ljava/util/Set;", "dirtyHolders", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "Ljava/util/HashMap;", "methodCache", "k", "l", "F", "B", "IA", "()Z", "isAvailable", "t", "reflectAvailable", Const.INTENT_KEY_APIKEY, "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: z7.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C6375j {

    /* renamed from: a, reason: collision with root package name */
    public static final C6375j f45214a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final boolean sdkAvailable;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Class<?> builderClass;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Class<?> materialParamsClass;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Method createGlassEffect;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final Method createStepOSBlurEffect;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public static final WeakHashMap<View, b> holders;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public static int batchDepth;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public static final Set<b> dirtyHolders;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public static final HashMap<String, Method> methodCache;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public static final Class<?> I;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public static final Class<?> F;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public static final Class<?> B;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public static final Class<?> IA;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\bT\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR\"\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u0011\u0010\b\"\u0004\b\u0012\u0010\nR\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001e\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\"\u0010!\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0006\u001a\u0004\b\u0015\u0010\b\"\u0004\b \u0010\nR\"\u0010%\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0006\u001a\u0004\b#\u0010\b\"\u0004\b$\u0010\nR4\u0010-\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140'0&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b\u001f\u0010*\"\u0004\b+\u0010,R\"\u00100\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010\u0016\u001a\u0004\b\"\u0010\u0018\"\u0004\b/\u0010\u001aR\"\u00103\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010\u0006\u001a\u0004\b(\u0010\b\"\u0004\b2\u0010\nR\"\u00107\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u0010\u0016\u001a\u0004\b5\u0010\u0018\"\u0004\b6\u0010\u001aR\"\u0010:\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u0010\u0016\u001a\u0004\b1\u0010\u0018\"\u0004\b9\u0010\u001aR\"\u0010<\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u0010\u0016\u001a\u0004\b.\u0010\u0018\"\u0004\b;\u0010\u001aR\"\u0010>\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b4\u0010\b\"\u0004\b=\u0010\nR\"\u0010@\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0016\u001a\u0004\b8\u0010\u0018\"\u0004\b?\u0010\u001aR\"\u0010G\u001a\u00020A8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010;\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010K\u001a\u00020A8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010;\u001a\u0004\bI\u0010D\"\u0004\bJ\u0010FR\"\u0010O\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010\u0006\u001a\u0004\bM\u0010\b\"\u0004\bN\u0010\nR\"\u0010S\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bP\u0010\u0006\u001a\u0004\bQ\u0010\b\"\u0004\bR\u0010\nR\"\u0010W\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bT\u0010\u0006\u001a\u0004\bU\u0010\b\"\u0004\bV\u0010\nR\"\u0010[\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bX\u0010\u0006\u001a\u0004\bY\u0010\b\"\u0004\bZ\u0010\nR\"\u0010^\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0016\u001a\u0004\b\\\u0010\u0018\"\u0004\b]\u0010\u001aR\"\u0010b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b_\u0010\u0006\u001a\u0004\b`\u0010\b\"\u0004\ba\u0010\nR\"\u0010f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bc\u0010\u0006\u001a\u0004\bd\u0010\b\"\u0004\be\u0010\nR\"\u0010j\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bg\u0010\u0006\u001a\u0004\bh\u0010\b\"\u0004\bi\u0010\nR\"\u0010m\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bk\u0010\u0006\u001a\u0004\b\u0006\u0010\b\"\u0004\bl\u0010\nR\"\u0010p\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bn\u0010\u0006\u001a\u0004\b\u0005\u0010\b\"\u0004\bo\u0010\nR\"\u0010s\u001a\u00020A8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bq\u0010;\u001a\u0004\b\f\u0010D\"\u0004\br\u0010FR\"\u0010u\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b`\u0010\u0016\u001a\u0004\bT\u0010\u0018\"\u0004\bt\u0010\u001aR\"\u0010w\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bd\u0010\u0016\u001a\u0004\bB\u0010\u0018\"\u0004\bv\u0010\u001aR\"\u0010y\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bh\u0010\u0006\u001a\u0004\bH\u0010\b\"\u0004\bx\u0010\nR\"\u0010{\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0006\u001a\u0004\bX\u0010\b\"\u0004\bz\u0010\nR\"\u0010}\u001a\u00020A8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010;\u001a\u0004\bc\u0010D\"\u0004\b|\u0010FR#\u0010\u0080\u0001\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b~\u0010\u0016\u001a\u0004\b_\u0010\u0018\"\u0004\b\u007f\u0010\u001aR$\u0010\u0082\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0013\n\u0004\b\u0016\u0010\u0006\u001a\u0004\bq\u0010\b\"\u0005\b\u0081\u0001\u0010\nR%\u0010\u0085\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0005\b\u0083\u0001\u0010\u0006\u001a\u0004\bk\u0010\b\"\u0005\b\u0084\u0001\u0010\nR$\u0010\u0087\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0013\n\u0004\b\\\u0010\u0006\u001a\u0004\bn\u0010\b\"\u0005\b\u0086\u0001\u0010\nR$\u0010\u0089\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0013\n\u0004\bI\u0010\u0006\u001a\u0004\bg\u0010\b\"\u0005\b\u0088\u0001\u0010\nR$\u0010\u008b\u0001\u001a\u00020A8\u0006@\u0006X\u0086\u000e¢\u0006\u0013\n\u0004\bU\u0010;\u001a\u0004\b~\u0010D\"\u0005\b\u008a\u0001\u0010FR$\u0010\u008d\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0013\n\u0004\bQ\u0010\u0006\u001a\u0004\b\u0016\u0010\b\"\u0005\b\u008c\u0001\u0010\nR%\u0010\u008f\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\bY\u0010\u0006\u001a\u0005\b\u0083\u0001\u0010\b\"\u0005\b\u008e\u0001\u0010\nR$\u0010\u0091\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0013\n\u0004\bM\u0010\u0006\u001a\u0004\bP\u0010\b\"\u0005\b\u0090\u0001\u0010\nR$\u0010\u0093\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0013\n\u0004\b\u0017\u0010\u0006\u001a\u0004\bL\u0010\b\"\u0005\b\u0092\u0001\u0010\nR\u0012\u0010\u0094\u0001\u001a\u00020A8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010D¨\u0006\u0095\u0001"}, d2 = {"Lz7/j$a;", "", "<init>", "()V", "", Const.INTENT_KEY_APIKEY, "F", "G", "()F", "x0", "(F)V", "radius", Const.INTENT_KEY_PKGNAME, "n", "e0", "cornerRadius", "c", "o", "f0", "cornerSmoothness", "", Const.INTENT_KEY_UMID, "I", "Q", "()I", "H0", "(I)V", "tintColor", "e", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "blendMode", "f", "U", "blendColor", Const.INTENT_KEY_BACKGROUND_COMMAND, "v", "m0", "frost", "", "Lkotlin/Pair;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Ljava/util/List;", "()Ljava/util/List;", ExifInterface.LONGITUDE_WEST, "(Ljava/util/List;)V", "blendStages", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "X", "blurMode", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "Y", "blurScale", "k", "m", "d0", "cgStart", "l", "a0", "cgMiddle", "Z", "cgEnd", "b0", "cgMidpoint", "c0", "cgMode", "", "p", "R", "()Z", "I0", "(Z)V", "useAospBlur", "q", "L", "C0", "strokeEnabled", "r", "P", "G0", "strokeWidth", "s", "N", "E0", "strokeSoftness", "t", "M", "D0", "strokeIntensity", "u", "O", "F0", "strokeSpread", "K", "B0", "strokeColor", "w", "C", "t0", "light0X", "x", "D", "u0", "light0Y", "y", ExifInterface.LONGITUDE_EAST, "v0", "light1X", "z", "w0", "light1Y", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, ExifInterface.LATITUDE_SOUTH, "ambient", "B", ExifInterface.GPS_DIRECTION_TRUE, "anisoRim", "k0", "edgeColor", "g0", "darkColor", "h0", "darkWidth", "l0", "edgeWidth", "o0", "innerEnabled", "H", "n0", "innerColor", "s0", "innerRadius", "J", "q0", "innerOffsetX", "r0", "innerOffsetY", "p0", "innerIntensity", "y0", "refractEnabled", "z0", "refractStrength", "A0", "refractWidth", "j0", "dispersion", "i0", "depthEffect", "anyGlass", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: z7.j$a */
    public static final class a {

        /* renamed from: A, reason: collision with root package name and from kotlin metadata */
        public float ambient;

        /* renamed from: B, reason: collision with root package name and from kotlin metadata */
        public boolean anisoRim;

        /* renamed from: G, reason: collision with root package name and from kotlin metadata */
        public boolean innerEnabled;

        /* renamed from: J, reason: collision with root package name and from kotlin metadata */
        public float innerOffsetX;

        /* renamed from: K, reason: collision with root package name and from kotlin metadata */
        public float innerOffsetY;

        /* renamed from: M, reason: collision with root package name and from kotlin metadata */
        public boolean refractEnabled;

        /* renamed from: P, reason: collision with root package name and from kotlin metadata */
        public float dispersion;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public float radius;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public float cornerRadius;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public float cornerSmoothness;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        public float frost;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        public int blurMode;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        public float blurScale;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        public int cgStart;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        public int cgMiddle;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        public int cgEnd;

        /* renamed from: o, reason: collision with root package name and from kotlin metadata */
        public int cgMode;

        /* renamed from: p, reason: collision with root package name and from kotlin metadata */
        public boolean useAospBlur;

        /* renamed from: q, reason: collision with root package name and from kotlin metadata */
        public boolean strokeEnabled;

        /* renamed from: w, reason: collision with root package name and from kotlin metadata */
        public float light0X;

        /* renamed from: y, reason: collision with root package name and from kotlin metadata */
        public float light1X;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public int tintColor = 16777215;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public int blendMode = 2;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        public float blendColor = 0.1f;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        public List<Pair<Integer, Integer>> blendStages = C1173v.m();

        /* renamed from: n, reason: collision with root package name and from kotlin metadata */
        public float cgMidpoint = 0.5f;

        /* renamed from: r, reason: collision with root package name and from kotlin metadata */
        public float strokeWidth = 2.0f;

        /* renamed from: s, reason: collision with root package name and from kotlin metadata */
        public float strokeSoftness = 2.0f;

        /* renamed from: t, reason: collision with root package name and from kotlin metadata */
        public float strokeIntensity = 1.0f;

        /* renamed from: u, reason: collision with root package name and from kotlin metadata */
        public float strokeSpread = 2.0f;

        /* renamed from: v, reason: collision with root package name and from kotlin metadata */
        public int strokeColor = -1;

        /* renamed from: x, reason: collision with root package name and from kotlin metadata */
        public float light0Y = -1.0f;

        /* renamed from: z, reason: collision with root package name and from kotlin metadata */
        public float light1Y = 1.0f;

        /* renamed from: C, reason: collision with root package name and from kotlin metadata */
        public int edgeColor = -3355444;

        /* renamed from: D, reason: collision with root package name and from kotlin metadata */
        public int darkColor = -3092272;

        /* renamed from: E, reason: collision with root package name and from kotlin metadata */
        public float darkWidth = 1.0f;

        /* renamed from: F, reason: collision with root package name and from kotlin metadata */
        public float edgeWidth = 1.0f;

        /* renamed from: H, reason: collision with root package name and from kotlin metadata */
        public int innerColor = 1711276032;

        /* renamed from: I, reason: collision with root package name and from kotlin metadata */
        public float innerRadius = 14.0f;

        /* renamed from: L, reason: collision with root package name and from kotlin metadata */
        public float innerIntensity = 1.0f;

        /* renamed from: N, reason: collision with root package name and from kotlin metadata */
        public float refractStrength = 20.0f;

        /* renamed from: O, reason: collision with root package name and from kotlin metadata */
        public float refractWidth = 40.0f;

        /* renamed from: Q, reason: collision with root package name and from kotlin metadata */
        public float depthEffect = 0.4f;

        /* renamed from: A, reason: from getter */
        public final float getInnerOffsetY() {
            return this.innerOffsetY;
        }

        public final void A0(float f10) {
            this.refractWidth = f10;
        }

        /* renamed from: B, reason: from getter */
        public final float getInnerRadius() {
            return this.innerRadius;
        }

        public final void B0(int i10) {
            this.strokeColor = i10;
        }

        /* renamed from: C, reason: from getter */
        public final float getLight0X() {
            return this.light0X;
        }

        public final void C0(boolean z10) {
            this.strokeEnabled = z10;
        }

        /* renamed from: D, reason: from getter */
        public final float getLight0Y() {
            return this.light0Y;
        }

        public final void D0(float f10) {
            this.strokeIntensity = f10;
        }

        /* renamed from: E, reason: from getter */
        public final float getLight1X() {
            return this.light1X;
        }

        public final void E0(float f10) {
            this.strokeSoftness = f10;
        }

        /* renamed from: F, reason: from getter */
        public final float getLight1Y() {
            return this.light1Y;
        }

        public final void F0(float f10) {
            this.strokeSpread = f10;
        }

        /* renamed from: G, reason: from getter */
        public final float getRadius() {
            return this.radius;
        }

        public final void G0(float f10) {
            this.strokeWidth = f10;
        }

        /* renamed from: H, reason: from getter */
        public final boolean getRefractEnabled() {
            return this.refractEnabled;
        }

        public final void H0(int i10) {
            this.tintColor = i10;
        }

        /* renamed from: I, reason: from getter */
        public final float getRefractStrength() {
            return this.refractStrength;
        }

        public final void I0(boolean z10) {
            this.useAospBlur = z10;
        }

        /* renamed from: J, reason: from getter */
        public final float getRefractWidth() {
            return this.refractWidth;
        }

        /* renamed from: K, reason: from getter */
        public final int getStrokeColor() {
            return this.strokeColor;
        }

        /* renamed from: L, reason: from getter */
        public final boolean getStrokeEnabled() {
            return this.strokeEnabled;
        }

        /* renamed from: M, reason: from getter */
        public final float getStrokeIntensity() {
            return this.strokeIntensity;
        }

        /* renamed from: N, reason: from getter */
        public final float getStrokeSoftness() {
            return this.strokeSoftness;
        }

        /* renamed from: O, reason: from getter */
        public final float getStrokeSpread() {
            return this.strokeSpread;
        }

        /* renamed from: P, reason: from getter */
        public final float getStrokeWidth() {
            return this.strokeWidth;
        }

        /* renamed from: Q, reason: from getter */
        public final int getTintColor() {
            return this.tintColor;
        }

        /* renamed from: R, reason: from getter */
        public final boolean getUseAospBlur() {
            return this.useAospBlur;
        }

        public final void S(float f10) {
            this.ambient = f10;
        }

        public final void T(boolean z10) {
            this.anisoRim = z10;
        }

        public final void U(float f10) {
            this.blendColor = f10;
        }

        public final void V(int i10) {
            this.blendMode = i10;
        }

        public final void W(List<Pair<Integer, Integer>> list) {
            p.i(list, "<set-?>");
            this.blendStages = list;
        }

        public final void X(int i10) {
            this.blurMode = i10;
        }

        public final void Y(float f10) {
            this.blurScale = f10;
        }

        public final void Z(int i10) {
            this.cgEnd = i10;
        }

        /* renamed from: a, reason: from getter */
        public final float getAmbient() {
            return this.ambient;
        }

        public final void a0(int i10) {
            this.cgMiddle = i10;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getAnisoRim() {
            return this.anisoRim;
        }

        public final void b0(float f10) {
            this.cgMidpoint = f10;
        }

        public final boolean c() {
            return this.strokeEnabled || this.innerEnabled || this.refractEnabled || this.dispersion > 0.0f || this.cgMode != 0;
        }

        public final void c0(int i10) {
            this.cgMode = i10;
        }

        /* renamed from: d, reason: from getter */
        public final float getBlendColor() {
            return this.blendColor;
        }

        public final void d0(int i10) {
            this.cgStart = i10;
        }

        /* renamed from: e, reason: from getter */
        public final int getBlendMode() {
            return this.blendMode;
        }

        public final void e0(float f10) {
            this.cornerRadius = f10;
        }

        public final List<Pair<Integer, Integer>> f() {
            return this.blendStages;
        }

        public final void f0(float f10) {
            this.cornerSmoothness = f10;
        }

        /* renamed from: g, reason: from getter */
        public final int getBlurMode() {
            return this.blurMode;
        }

        public final void g0(int i10) {
            this.darkColor = i10;
        }

        /* renamed from: h, reason: from getter */
        public final float getBlurScale() {
            return this.blurScale;
        }

        public final void h0(float f10) {
            this.darkWidth = f10;
        }

        /* renamed from: i, reason: from getter */
        public final int getCgEnd() {
            return this.cgEnd;
        }

        public final void i0(float f10) {
            this.depthEffect = f10;
        }

        /* renamed from: j, reason: from getter */
        public final int getCgMiddle() {
            return this.cgMiddle;
        }

        public final void j0(float f10) {
            this.dispersion = f10;
        }

        /* renamed from: k, reason: from getter */
        public final float getCgMidpoint() {
            return this.cgMidpoint;
        }

        public final void k0(int i10) {
            this.edgeColor = i10;
        }

        /* renamed from: l, reason: from getter */
        public final int getCgMode() {
            return this.cgMode;
        }

        public final void l0(float f10) {
            this.edgeWidth = f10;
        }

        /* renamed from: m, reason: from getter */
        public final int getCgStart() {
            return this.cgStart;
        }

        public final void m0(float f10) {
            this.frost = f10;
        }

        /* renamed from: n, reason: from getter */
        public final float getCornerRadius() {
            return this.cornerRadius;
        }

        public final void n0(int i10) {
            this.innerColor = i10;
        }

        /* renamed from: o, reason: from getter */
        public final float getCornerSmoothness() {
            return this.cornerSmoothness;
        }

        public final void o0(boolean z10) {
            this.innerEnabled = z10;
        }

        /* renamed from: p, reason: from getter */
        public final int getDarkColor() {
            return this.darkColor;
        }

        public final void p0(float f10) {
            this.innerIntensity = f10;
        }

        /* renamed from: q, reason: from getter */
        public final float getDarkWidth() {
            return this.darkWidth;
        }

        public final void q0(float f10) {
            this.innerOffsetX = f10;
        }

        /* renamed from: r, reason: from getter */
        public final float getDepthEffect() {
            return this.depthEffect;
        }

        public final void r0(float f10) {
            this.innerOffsetY = f10;
        }

        /* renamed from: s, reason: from getter */
        public final float getDispersion() {
            return this.dispersion;
        }

        public final void s0(float f10) {
            this.innerRadius = f10;
        }

        /* renamed from: t, reason: from getter */
        public final int getEdgeColor() {
            return this.edgeColor;
        }

        public final void t0(float f10) {
            this.light0X = f10;
        }

        /* renamed from: u, reason: from getter */
        public final float getEdgeWidth() {
            return this.edgeWidth;
        }

        public final void u0(float f10) {
            this.light0Y = f10;
        }

        /* renamed from: v, reason: from getter */
        public final float getFrost() {
            return this.frost;
        }

        public final void v0(float f10) {
            this.light1X = f10;
        }

        /* renamed from: w, reason: from getter */
        public final int getInnerColor() {
            return this.innerColor;
        }

        public final void w0(float f10) {
            this.light1Y = f10;
        }

        /* renamed from: x, reason: from getter */
        public final boolean getInnerEnabled() {
            return this.innerEnabled;
        }

        public final void x0(float f10) {
            this.radius = f10;
        }

        /* renamed from: y, reason: from getter */
        public final float getInnerIntensity() {
            return this.innerIntensity;
        }

        public final void y0(boolean z10) {
            this.refractEnabled = z10;
        }

        /* renamed from: z, reason: from getter */
        public final float getInnerOffsetX() {
            return this.innerOffsetX;
        }

        public final void z0(float f10) {
            this.refractStrength = f10;
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\n\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\rJ!\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0016\u001a\u0010\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00020\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0015R\"\u0010\u001d\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u001e¨\u0006 "}, d2 = {"Lz7/j$b;", "", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "Lkotlin/Function1;", "Lz7/j$a;", "LY8/t;", "action", "c", "(Lp9/l;)V", "e", "()V", Const.INTENT_KEY_PKGNAME, "Landroid/graphics/RenderEffect;", "effect", Const.INTENT_KEY_APIKEY, "(Landroid/view/View;Landroid/graphics/RenderEffect;)V", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "Ljava/lang/ref/WeakReference;", "viewRef", "", "I", Const.INTENT_KEY_UMID, "()I", "f", "(I)V", "refCount", "Lz7/j$a;", "cfg", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: z7.j$b */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final WeakReference<View> viewRef;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public int refCount;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final a cfg;

        public b(View view) {
            p.i(view, "view");
            this.viewRef = new WeakReference<>(view);
            this.cfg = new a();
        }

        public final void a(View view, RenderEffect effect) {
            C6366a.f45183a.b(view, effect);
            Object parent = view.getParent();
            View view2 = parent instanceof View ? (View) parent : null;
            if (view2 != null) {
                view2.invalidate();
            }
        }

        public final void b() {
            View view = this.viewRef.get();
            if (view == null) {
                return;
            }
            C6366a.f45183a.b(view, null);
        }

        public final void c(InterfaceC5074l<? super a, t> action) {
            p.i(action, "action");
            action.invoke(this.cfg);
            if (C6375j.batchDepth > 0) {
                C6375j.dirtyHolders.add(this);
            } else {
                e();
            }
        }

        /* renamed from: d, reason: from getter */
        public final int getRefCount() {
            return this.refCount;
        }

        public final void e() {
            RenderEffect renderEffectCreateStepOSBlurEffect;
            RenderEffect renderEffectCreateBlurEffect;
            View view = this.viewRef.get();
            if (view == null) {
                return;
            }
            try {
                if (this.cfg.getRadius() <= 0.0f && !this.cfg.c()) {
                    Log.d("MotionKitInWindowMaterial", "rebuild: radius<=0 且无玻璃 → clear effect");
                    a(view, null);
                    return;
                }
                float radius = this.cfg.getRadius() > 0.0f ? this.cfg.getRadius() : 0.1f;
                boolean z10 = true;
                boolean z11 = C6375j.sdkAvailable || C6375j.createStepOSBlurEffect != null;
                if ((this.cfg.getBlurMode() != 0 || !this.cfg.getUseAospBlur()) && z11) {
                    z10 = false;
                }
                Display display = view.getDisplay();
                int rotation = display != null ? display.getRotation() : 0;
                if (z10) {
                    renderEffectCreateBlurEffect = RenderEffect.createBlurEffect(radius, radius, Shader.TileMode.CLAMP);
                    p.f(renderEffectCreateBlurEffect);
                } else {
                    int iZ = C6375j.f45214a.z(this.cfg.getBlurMode(), rotation);
                    if (C6375j.sdkAvailable) {
                        renderEffectCreateStepOSBlurEffect = StepOSGlassMaterial.createStepOSBlurEffect(radius, iZ, this.cfg.getBlurScale());
                    } else {
                        Method method = C6375j.createStepOSBlurEffect;
                        p.f(method);
                        Object objInvoke = method.invoke(null, Float.valueOf(radius), Integer.valueOf(iZ), Float.valueOf(this.cfg.getBlurScale()));
                        renderEffectCreateStepOSBlurEffect = objInvoke instanceof RenderEffect ? (RenderEffect) objInvoke : null;
                    }
                    if (renderEffectCreateStepOSBlurEffect == null) {
                        renderEffectCreateBlurEffect = RenderEffect.createBlurEffect(radius, radius, Shader.TileMode.CLAMP);
                        p.h(renderEffectCreateBlurEffect, "createBlurEffect(...)");
                    } else {
                        renderEffectCreateBlurEffect = renderEffectCreateStepOSBlurEffect;
                    }
                }
                C6375j c6375j = C6375j.f45214a;
                int iZ2 = c6375j.z(this.cfg.getCgMode(), rotation);
                if (this.cfg.c()) {
                    if (C6375j.sdkAvailable) {
                        renderEffectCreateBlurEffect = c6375j.q(this.cfg, renderEffectCreateBlurEffect, iZ2);
                    } else {
                        Object objR = c6375j.r(this.cfg, iZ2);
                        if (objR != null) {
                            Method method2 = C6375j.createGlassEffect;
                            p.f(method2);
                            Object objInvoke2 = method2.invoke(null, objR, Integer.valueOf(this.cfg.getTintColor()), renderEffectCreateBlurEffect);
                            p.g(objInvoke2, "null cannot be cast to non-null type android.graphics.RenderEffect");
                            renderEffectCreateBlurEffect = (RenderEffect) objInvoke2;
                        }
                    }
                }
                Log.d("MotionKitInWindowMaterial", "rebuild: r=" + this.cfg.getRadius() + " anyGlass=" + this.cfg.c() + " stroke=" + this.cfg.getStrokeEnabled() + " inner=" + this.cfg.getInnerEnabled() + " refract=" + this.cfg.getRefractEnabled() + " effect=" + System.identityHashCode(renderEffectCreateBlurEffect) + " view=" + System.identityHashCode(view));
                a(view, renderEffectCreateBlurEffect);
            } catch (Throwable th) {
                th = th;
                Throwable cause = th.getCause();
                if (cause != null) {
                    th = cause;
                }
                Log.e("MotionKitInWindowMaterial", "rebuild failed: " + th.getClass().getSimpleName() + ": " + th.getMessage(), th);
            }
        }

        public final void f(int i10) {
            this.refCount = i10;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\f\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0004\b\f\u0010\rJ#\u0010\u000f\u001a\u00020\n2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0004\b\u000f\u0010\rR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\"\u0010\u0015\u001a\u0010\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00020\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0014¨\u0006\u0016"}, d2 = {"Lz7/j$c;", "", "Landroid/view/View;", "view", "Lz7/j$b;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "<init>", "(Landroid/view/View;Lz7/j$b;)V", "Lkotlin/Function1;", "Lz7/j$a;", "LY8/t;", "action", Const.INTENT_KEY_PKGNAME, "(Lp9/l;)V", "reset", "c", Const.INTENT_KEY_APIKEY, "Lz7/j$b;", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "Ljava/lang/ref/WeakReference;", "viewRef", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: z7.j$c */
    public static final class c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final b h;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final WeakReference<View> viewRef;

        public c(View view, b h10) {
            p.i(view, "view");
            p.i(h10, "h");
            this.h = h10;
            this.viewRef = new WeakReference<>(view);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void d(c cVar, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                interfaceC5074l = new InterfaceC5074l() { // from class: z7.k
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj2) {
                        return C6375j.c.e((C6375j.a) obj2);
                    }
                };
            }
            cVar.c(interfaceC5074l);
        }

        public static final t e(a it) {
            p.i(it, "it");
            return t.f7040a;
        }

        public final void b(InterfaceC5074l<? super a, t> action) {
            p.i(action, "action");
            this.h.c(action);
        }

        public final void c(InterfaceC5074l<? super a, t> reset) {
            p.i(reset, "reset");
            this.h.c(reset);
            View view = this.viewRef.get();
            if (view == null) {
                return;
            }
            C6375j.f45214a.x(view, this.h);
        }
    }

    static {
        boolean z10;
        Class<?> cls;
        Class<?> cls2;
        Method method;
        Class<?> cls3 = Float.TYPE;
        f45214a = new C6375j();
        try {
            Class.forName("stepos.view.effects.StepOSGlassMaterial");
            z10 = true;
        } catch (Throwable th) {
            Log.i("MotionKitInWindowMaterial", "StepOSGlassMaterial 不可用，将尝试反射 BackdropMaterialParams/createGlassMaterialEffect: " + th.getClass().getSimpleName() + ": " + th.getMessage());
            z10 = false;
        }
        sdkAvailable = z10;
        Method method2 = null;
        try {
            cls = Class.forName("android.graphics.BackdropMaterialParams$Builder");
        } catch (Throwable th2) {
            Log.e("MotionKitInWindowMaterial", "BackdropMaterialParams.Builder unavailable: " + th2.getClass().getSimpleName() + ": " + th2.getMessage());
            cls = null;
        }
        builderClass = cls;
        try {
            cls2 = Class.forName("android.graphics.BackdropMaterialParams");
        } catch (Throwable unused) {
            cls2 = null;
        }
        materialParamsClass = cls2;
        Class<?> cls4 = Integer.TYPE;
        if (cls2 != null) {
            try {
                method = RenderEffect.class.getMethod("createGlassMaterialEffect", cls2, cls4, RenderEffect.class);
                method.setAccessible(true);
            } catch (Throwable th3) {
                Log.e("MotionKitInWindowMaterial", "createGlassMaterialEffect unavailable: " + th3.getClass().getSimpleName() + ": " + th3.getMessage());
            }
        } else {
            method = null;
        }
        createGlassEffect = method;
        try {
            Method method3 = RenderEffect.class.getMethod("createStepOSBlurEffect", cls3, cls4, cls3);
            method3.setAccessible(true);
            method2 = method3;
        } catch (Throwable th4) {
            Log.w("MotionKitInWindowMaterial", "createStepOSBlurEffect(3-arg) unavailable: " + th4.getClass().getSimpleName() + ": " + th4.getMessage());
        }
        createStepOSBlurEffect = method2;
        holders = new WeakHashMap<>();
        dirtyHolders = new LinkedHashSet();
        methodCache = new HashMap<>();
        p.f(cls4);
        I = cls4;
        p.f(cls3);
        F = cls3;
        Class<?> cls5 = Boolean.TYPE;
        p.f(cls5);
        B = cls5;
        IA = int[].class;
    }

    public static final t B(float f10, a it) {
        p.i(it, "it");
        it.e0(f10);
        return t.f7040a;
    }

    public static final t D(float f10, a it) {
        p.i(it, "it");
        it.f0(f10);
        return t.f7040a;
    }

    public static final void y(b bVar, View view) {
        synchronized (f45214a) {
            try {
                if (bVar.getRefCount() <= 0) {
                    bVar.b();
                    holders.remove(view);
                }
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized void A(View view, final float px) {
        p.i(view, "view");
        b bVar = holders.get(view);
        if (bVar == null) {
            return;
        }
        bVar.c(new InterfaceC5074l() { // from class: z7.g
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C6375j.B(px, (C6375j.a) obj);
            }
        });
    }

    public final synchronized void C(View view, final float v10) {
        p.i(view, "view");
        b bVar = holders.get(view);
        if (bVar == null) {
            return;
        }
        bVar.c(new InterfaceC5074l() { // from class: z7.h
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C6375j.D(v10, (C6375j.a) obj);
            }
        });
    }

    public final synchronized c m(View view) {
        p.i(view, "view");
        boolean z10 = true;
        if (!v()) {
            boolean z11 = builderClass != null;
            boolean z12 = materialParamsClass != null;
            if (createGlassEffect == null) {
                z10 = false;
            }
            Log.w("MotionKitInWindowMaterial", "acquire: isAvailable=false (builder=" + z11 + " mp=" + z12 + " glassFx=" + z10 + " setBackdrop=" + C6366a.f45183a.a() + ")");
            return null;
        }
        WeakHashMap<View, b> weakHashMap = holders;
        b bVar = weakHashMap.get(view);
        if (bVar == null) {
            bVar = new b(view);
            weakHashMap.put(view, bVar);
        }
        b bVar2 = bVar;
        bVar2.f(bVar2.getRefCount() + 1);
        Log.d("MotionKitInWindowMaterial", "acquire: holder=" + System.identityHashCode(bVar2) + " refCount=" + bVar2.getRefCount() + " view=" + System.identityHashCode(view));
        return new c(view, bVar2);
    }

    public final float n(int c10) {
        return ((c10 >>> 24) & 255) / 255.0f;
    }

    public final synchronized <T> T o(InterfaceC5063a<? extends T> body) {
        T tInvoke;
        p.i(body, "body");
        batchDepth++;
        try {
            tInvoke = body.invoke();
            int i10 = batchDepth - 1;
            batchDepth = i10;
            if (i10 == 0) {
                Set<b> set = dirtyHolders;
                List listM1 = F.m1(set);
                set.clear();
                Iterator<T> it = listM1.iterator();
                while (it.hasNext()) {
                    ((b) it.next()).e();
                }
            }
        } catch (Throwable th) {
            batchDepth--;
            if (batchDepth == 0) {
                Set<b> set2 = dirtyHolders;
                List listM12 = F.m1(set2);
                set2.clear();
                Iterator<T> it2 = listM12.iterator();
                while (it2.hasNext()) {
                    ((b) it2.next()).e();
                }
            }
            throw th;
        }
        return tInvoke;
    }

    public final float p(int c10) {
        return (c10 & 255) / 255.0f;
    }

    public final RenderEffect q(a c10, RenderEffect blur, int effCgMode) {
        Object objNewGlassMaterialBuilder = StepOSGlassMaterial.newGlassMaterialBuilder();
        if (objNewGlassMaterialBuilder == null) {
            return blur;
        }
        StepOSGlassMaterial.gmSetGeometry(objNewGlassMaterialBuilder, 0.0f, 0.0f, c10.getCornerRadius(), c10.getCornerRadius(), c10.getCornerRadius(), c10.getCornerRadius());
        StepOSGlassMaterial.gmSetCornerSmoothness(objNewGlassMaterialBuilder, c10.getCornerSmoothness());
        StepOSGlassMaterial.gmSetBlend(objNewGlassMaterialBuilder, c10.getBlendMode(), c10.getBlendColor(), n(c10.getTintColor()));
        List listF1 = F.f1(c10.f(), 4);
        if (!listF1.isEmpty()) {
            int size = listF1.size();
            int[] iArr = new int[size];
            for (int i10 = 0; i10 < size; i10++) {
                iArr[i10] = ((Number) ((Pair) listF1.get(i10)).e()).intValue();
            }
            int size2 = listF1.size();
            int[] iArr2 = new int[size2];
            for (int i11 = 0; i11 < size2; i11++) {
                iArr2[i11] = ((Number) ((Pair) listF1.get(i11)).f()).intValue();
            }
            StepOSGlassMaterial.gmSetBlendArray(objNewGlassMaterialBuilder, iArr, iArr2);
        }
        StepOSGlassMaterial.gmSetFrost(objNewGlassMaterialBuilder, c10.getFrost());
        StepOSGlassMaterial.gmSetStroke(objNewGlassMaterialBuilder, c10.getStrokeEnabled(), c10.getStrokeWidth(), c10.getStrokeSoftness(), c10.getStrokeIntensity(), w(c10.getStrokeColor()), u(c10.getStrokeColor()), p(c10.getStrokeColor()), n(c10.getStrokeColor()));
        StepOSGlassMaterial.gmSetStrokeSpread(objNewGlassMaterialBuilder, c10.getStrokeSpread());
        StepOSGlassMaterial.gmSetLightDirs(objNewGlassMaterialBuilder, c10.getLight0X(), c10.getLight0Y(), c10.getLight1X(), c10.getLight1Y());
        StepOSGlassMaterial.gmSetAmbient(objNewGlassMaterialBuilder, c10.getAmbient());
        StepOSGlassMaterial.gmSetAnisoRim(objNewGlassMaterialBuilder, c10.getAnisoRim());
        StepOSGlassMaterial.gmSetEdgeColor(objNewGlassMaterialBuilder, c10.getEdgeColor());
        StepOSGlassMaterial.gmSetDarkColor(objNewGlassMaterialBuilder, c10.getDarkColor());
        StepOSGlassMaterial.gmSetDarkWidth(objNewGlassMaterialBuilder, c10.getDarkWidth());
        StepOSGlassMaterial.gmSetEdgeWidth(objNewGlassMaterialBuilder, c10.getEdgeWidth());
        StepOSGlassMaterial.gmSetInnerShadow(objNewGlassMaterialBuilder, c10.getInnerEnabled(), w(c10.getInnerColor()), u(c10.getInnerColor()), p(c10.getInnerColor()), n(c10.getInnerColor()), c10.getInnerRadius(), c10.getInnerOffsetX(), c10.getInnerOffsetY(), c10.getInnerIntensity());
        StepOSGlassMaterial.gmSetRefraction(objNewGlassMaterialBuilder, c10.getRefractEnabled(), c10.getRefractStrength(), c10.getRefractWidth());
        StepOSGlassMaterial.gmSetDepthEffect(objNewGlassMaterialBuilder, c10.getDepthEffect());
        StepOSGlassMaterial.gmSetDispersion(objNewGlassMaterialBuilder, c10.getDispersion());
        StepOSGlassMaterial.gmSetUseShapeAlpha(objNewGlassMaterialBuilder, c10.getStrokeEnabled() || c10.getInnerEnabled());
        StepOSGlassMaterial.gmSetColorGradient(objNewGlassMaterialBuilder, c10.getCgStart(), c10.getCgMiddle(), c10.getCgEnd(), c10.getCgMidpoint(), effCgMode);
        RenderEffect renderEffectBuildGlassMaterialEffect = StepOSGlassMaterial.buildGlassMaterialEffect(objNewGlassMaterialBuilder, c10.getTintColor(), blur);
        p.h(renderEffectBuildGlassMaterialEffect, "buildGlassMaterialEffect(...)");
        return renderEffectBuildGlassMaterialEffect;
    }

    public final Object r(a c10, int effCgMode) {
        Float fValueOf = Float.valueOf(0.0f);
        Class<?> cls = builderClass;
        if (cls == null) {
            return null;
        }
        try {
            Object objNewInstance = cls.getConstructor(null).newInstance(null);
            p.f(objNewInstance);
            Class<?> cls2 = F;
            s(cls, objNewInstance, "setGeometry", new Class[]{cls2, cls2, cls2, cls2, cls2, cls2}, fValueOf, fValueOf, Float.valueOf(c10.getCornerRadius()), Float.valueOf(c10.getCornerRadius()), Float.valueOf(c10.getCornerRadius()), Float.valueOf(c10.getCornerRadius()));
            s(cls, objNewInstance, "setCornerSmoothness", new Class[]{cls2}, Float.valueOf(c10.getCornerSmoothness()));
            s(cls, objNewInstance, "setBlend", new Class[]{I, cls2, cls2}, Integer.valueOf(c10.getBlendMode()), Float.valueOf(c10.getBlendColor()), Float.valueOf(n(c10.getTintColor())));
            List listF1 = F.f1(c10.f(), 4);
            if (!listF1.isEmpty()) {
                int size = listF1.size();
                int[] iArr = new int[size];
                for (int i10 = 0; i10 < size; i10++) {
                    iArr[i10] = ((Number) ((Pair) listF1.get(i10)).e()).intValue();
                }
                int size2 = listF1.size();
                int[] iArr2 = new int[size2];
                for (int i11 = 0; i11 < size2; i11++) {
                    iArr2[i11] = ((Number) ((Pair) listF1.get(i11)).f()).intValue();
                }
                Class<?> cls3 = IA;
                s(cls, objNewInstance, "setBlendArray", new Class[]{cls3, cls3}, iArr, iArr2);
            }
            Class<?> cls4 = F;
            s(cls, objNewInstance, "setFrost", new Class[]{cls4}, Float.valueOf(c10.getFrost()));
            Class<?> cls5 = B;
            s(cls, objNewInstance, "setStroke", new Class[]{cls5, cls4, cls4, cls4, cls4, cls4, cls4, cls4}, Boolean.valueOf(c10.getStrokeEnabled()), Float.valueOf(c10.getStrokeWidth()), Float.valueOf(c10.getStrokeSoftness()), Float.valueOf(c10.getStrokeIntensity()), Float.valueOf(w(c10.getStrokeColor())), Float.valueOf(u(c10.getStrokeColor())), Float.valueOf(p(c10.getStrokeColor())), Float.valueOf(n(c10.getStrokeColor())));
            s(cls, objNewInstance, "setStrokeSpread", new Class[]{cls4}, Float.valueOf(c10.getStrokeSpread()));
            s(cls, objNewInstance, "setLightDirs", new Class[]{cls4, cls4, cls4, cls4}, Float.valueOf(c10.getLight0X()), Float.valueOf(c10.getLight0Y()), Float.valueOf(c10.getLight1X()), Float.valueOf(c10.getLight1Y()));
            s(cls, objNewInstance, "setAmbient", new Class[]{cls4}, Float.valueOf(c10.getAmbient()));
            s(cls, objNewInstance, "setAnisoRim", new Class[]{cls5}, Boolean.valueOf(c10.getAnisoRim()));
            Class<?> cls6 = I;
            s(cls, objNewInstance, "setEdgeColor", new Class[]{cls6}, Integer.valueOf(c10.getEdgeColor()));
            s(cls, objNewInstance, "setDarkColor", new Class[]{cls6}, Integer.valueOf(c10.getDarkColor()));
            s(cls, objNewInstance, "setDarkWidth", new Class[]{cls4}, Float.valueOf(c10.getDarkWidth()));
            s(cls, objNewInstance, "setEdgeWidth", new Class[]{cls4}, Float.valueOf(c10.getEdgeWidth()));
            s(cls, objNewInstance, "setInnerShadow", new Class[]{cls5, cls4, cls4, cls4, cls4, cls4, cls4, cls4, cls4}, Boolean.valueOf(c10.getInnerEnabled()), Float.valueOf(w(c10.getInnerColor())), Float.valueOf(u(c10.getInnerColor())), Float.valueOf(p(c10.getInnerColor())), Float.valueOf(n(c10.getInnerColor())), Float.valueOf(c10.getInnerRadius()), Float.valueOf(c10.getInnerOffsetX()), Float.valueOf(c10.getInnerOffsetY()), Float.valueOf(c10.getInnerIntensity()));
            s(cls, objNewInstance, "setRefraction", new Class[]{cls5, cls4, cls4}, Boolean.valueOf(c10.getRefractEnabled()), Float.valueOf(c10.getRefractStrength()), Float.valueOf(c10.getRefractWidth()));
            s(cls, objNewInstance, "setDepthEffect", new Class[]{cls4}, Float.valueOf(c10.getDepthEffect()));
            s(cls, objNewInstance, "setDispersion", new Class[]{cls4}, Float.valueOf(c10.getDispersion()));
            s(cls, objNewInstance, "setUseShapeAlpha", new Class[]{cls5}, Boolean.valueOf(c10.getStrokeEnabled() || c10.getInnerEnabled()));
            s(cls, objNewInstance, "setColorGradient", new Class[]{cls6, cls6, cls6, cls4, cls6}, Integer.valueOf(c10.getCgStart()), Integer.valueOf(c10.getCgMiddle()), Integer.valueOf(c10.getCgEnd()), Float.valueOf(c10.getCgMidpoint()), Integer.valueOf(effCgMode));
            return cls.getMethod(JsonPOJOBuilder.DEFAULT_BUILD_METHOD, null).invoke(objNewInstance, null);
        } catch (Throwable th) {
            th = th;
            Throwable cause = th.getCause();
            if (cause != null) {
                th = cause;
            }
            Log.e("MotionKitInWindowMaterial", "buildMaterial failed: " + th.getClass().getSimpleName() + ": " + th.getMessage());
            return null;
        }
    }

    public final void s(Class<?> cls, Object target, String name, Class<?>[] types, Object... args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method;
        String str = name + types.length;
        HashMap<String, Method> map = methodCache;
        Method method2 = map.get(str);
        if (method2 == null) {
            try {
                method = cls.getMethod(name, (Class[]) Arrays.copyOf(types, types.length));
            } catch (Throwable th) {
                Log.e("MotionKitInWindowMaterial", name + " reflection failed: " + th.getClass().getSimpleName() + ": " + th.getMessage());
                method = null;
            }
            method2 = method;
            map.put(str, method2);
        }
        Method method3 = method2;
        if (method3 == null) {
            return;
        }
        method3.invoke(target, Arrays.copyOf(args, args.length));
    }

    public final boolean t() {
        return (builderClass == null || materialParamsClass == null || createGlassEffect == null) ? false : true;
    }

    public final float u(int c10) {
        return ((c10 >>> 8) & 255) / 255.0f;
    }

    public final boolean v() {
        return (sdkAvailable || t()) && C6366a.f45183a.a();
    }

    public final float w(int c10) {
        return ((c10 >>> 16) & 255) / 255.0f;
    }

    public final synchronized void x(final View view, final b h10) {
        try {
            h10.f(h10.getRefCount() - 1);
            if (h10.getRefCount() <= 0) {
                if (view.isAttachedToWindow()) {
                    view.post(new Runnable() { // from class: z7.i
                        @Override // java.lang.Runnable
                        public final void run() {
                            C6375j.y(h10, view);
                        }
                    });
                } else {
                    h10.b();
                    holders.remove(view);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final int z(int mode, int rotation) {
        int i10 = 0;
        if (mode == 0) {
            return 0;
        }
        int i11 = mode != 3 ? mode != 4 ? 0 : -1 : 1;
        int i12 = mode != 1 ? mode != 2 ? 0 : -1 : 1;
        while (i10 < ((rotation % 4) + 4) % 4) {
            int i13 = -i12;
            i10++;
            i12 = i11;
            i11 = i13;
        }
        if (i11 == 0 && i12 == 1) {
            return 1;
        }
        if (i11 == 0 && i12 == -1) {
            return 2;
        }
        if (i11 == 1 && i12 == 0) {
            return 3;
        }
        if (i11 == -1 && i12 == 0) {
            return 4;
        }
        return mode;
    }
}
