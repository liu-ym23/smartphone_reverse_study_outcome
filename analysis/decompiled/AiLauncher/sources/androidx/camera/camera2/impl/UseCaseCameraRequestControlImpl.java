package androidx.camera.camera2.impl;

import D.C0761b0;
import K.AbstractC0889l;
import K.E0;
import K.o0;
import Ua.C1060i;
import Ua.C1087w;
import Ua.InterfaceC1083u;
import Ua.Q;
import Y8.h;
import Y8.t;
import Z8.F;
import Z8.Y;
import android.hardware.camera2.CaptureRequest;
import android.util.Log;
import androidx.camera.camera2.impl.UseCaseCameraRequestControl;
import androidx.camera.camera2.impl.UseCaseCameraRequestControlImpl;
import androidx.camera.camera2.impl.a;
import androidx.camera.camera2.impl.b;
import androidx.camera.camera2.pipe.t;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.l;
import androidx.camera.core.impl.y;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland;
import e9.InterfaceC4014c;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.CoroutineStart;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import s.J;
import t.C5473b;
import t.InterfaceC5495w;
import t.r0;
import t.y0;
import w.M;
import w.Result3A;

@Metadata(d1 = {"\u0000Ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010%\n\u0002\b\u0003\b\u0007\u0018\u0000 D2\u00020\u0001:\u0002KgBO\b\u0007\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0002\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J3\u0010\u0018\u001a\u00020\u0011*\u00020\u00112\u0016\u0010\u0015\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0013\u0012\u0004\u0012\u00020\u00140\u00122\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001c\u001a\u00020\u0011*\u00020\u00112\u0010\u0010\u001b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00130\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ>\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\u001f\u001a\u00020\u001e2\u0016\u0010\u0015\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0013\u0012\u0004\u0012\u00020\u00140\u00122\u0006\u0010\u0017\u001a\u00020\u0016H\u0082@¢\u0006\u0004\b\"\u0010#J-\u0010)\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010(0 0\u001a2\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b)\u0010*J\u0019\u0010-\u001a\u00020,*\b\u0012\u0004\u0012\u00020+0\u001aH\u0002¢\u0006\u0004\b-\u0010.J\u001f\u0010/\u001a\u00020\u0011*\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00110\u0012H\u0002¢\u0006\u0004\b/\u00100J\u0013\u00102\u001a\u000201*\u00020\u0011H\u0002¢\u0006\u0004\b2\u00103J,\u00107\u001a\b\u0012\u0004\u0012\u00020!0 *\u00020\u00112\u0010\b\u0002\u00106\u001a\n\u0012\u0004\u0012\u000205\u0018\u000104H\u0082@¢\u0006\u0004\b7\u00108J?\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000 \"\u0004\b\u0000\u001092\"\u0010<\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000 0;\u0012\u0006\u0012\u0004\u0018\u00010\u00140:H\u0002¢\u0006\u0004\b=\u0010>JS\u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000 0\u001a\"\u0004\b\u0000\u001092\u0006\u0010?\u001a\u00020$2(\u0010<\u001a$\b\u0001\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000 0\u001a0;\u0012\u0006\u0012\u0004\u0018\u00010\u00140:H\u0002¢\u0006\u0004\b@\u0010AJ=\u0010B\u001a\b\u0012\u0004\u0012\u00020!0 2\u0016\u0010\u0015\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0013\u0012\u0004\u0012\u00020\u00140\u00122\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\bB\u0010CJ=\u0010D\u001a\b\u0012\u0004\u0012\u00020!0 2\u0016\u0010\u0015\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0013\u0012\u0004\u0012\u00020\u00140\u00122\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\bD\u0010CJ/\u0010E\u001a\b\u0012\u0004\u0012\u00020!0 2\u0010\u0010\u001b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00130\u001a2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\bE\u0010FJ+\u0010K\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010G\u001a\u00020,2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020I0HH\u0016¢\u0006\u0004\bK\u0010LJ1\u0010P\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010N\u001a\u00020M2\u0012\u0010O\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00140\u0012H\u0016¢\u0006\u0004\bP\u0010QJ\u0015\u0010S\u001a\b\u0012\u0004\u0012\u00020R0 H\u0016¢\u0006\u0004\bS\u0010TJ\u001d\u0010W\u001a\b\u0012\u0004\u0012\u00020R0 2\u0006\u0010V\u001a\u00020UH\u0016¢\u0006\u0004\bW\u0010XJ\u0015\u0010Y\u001a\b\u0012\u0004\u0012\u00020R0 H\u0016¢\u0006\u0004\bY\u0010TJC\u0010^\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010(0 0\u001a2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020+0\u001a2\u0006\u0010[\u001a\u00020$2\u0006\u0010\\\u001a\u00020$2\u0006\u0010]\u001a\u00020$H\u0016¢\u0006\u0004\b^\u0010_J\u0010\u0010`\u001a\u00020,H\u0096@¢\u0006\u0004\b`\u0010aJ\u000f\u0010b\u001a\u00020!H\u0016¢\u0006\u0004\bb\u0010cJ\u0013\u0010e\u001a\u00020d*\u00020\u000bH\u0000¢\u0006\u0004\be\u0010fR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010hR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010hR\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010jR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bk\u0010hR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010lR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010mR\u0016\u0010o\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010nR#\u0010t\u001a\n p*\u0004\u0018\u00010\u00030\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010q\u001a\u0004\br\u0010sR#\u0010w\u001a\n p*\u0004\u0018\u00010\t0\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u0010q\u001a\u0004\bu\u0010vR#\u0010z\u001a\n p*\u0004\u0018\u00010\u00050\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bW\u0010q\u001a\u0004\bx\u0010yR \u0010}\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00110{8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010|¨\u0006~"}, d2 = {"Landroidx/camera/camera2/impl/UseCaseCameraRequestControlImpl;", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "LX8/a;", "Lt/w;", "capturePipelineProvider", "Landroidx/camera/camera2/impl/UseCaseCameraState;", "useCaseCameraStateProvider", "Ls/J;", "useCaseGraphContext", "Landroidx/camera/camera2/impl/UseCaseSurfaceManager;", "useCaseSurfaceManagerProvider", "Lt/y0;", "threads", "Landroidx/camera/core/f;", "cameraXConfig", "<init>", "(LX8/a;LX8/a;Ls/J;LX8/a;Lt/y0;Landroidx/camera/core/f;)V", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControlImpl$b;", "", "Landroid/hardware/camera2/CaptureRequest$Key;", "", "values", "Landroidx/camera/core/impl/Config$OptionPriority;", "optionPriority", "R", "(Landroidx/camera/camera2/impl/UseCaseCameraRequestControlImpl$b;Ljava/util/Map;Landroidx/camera/core/impl/Config$OptionPriority;)Landroidx/camera/camera2/impl/UseCaseCameraRequestControlImpl$b;", "", "keys", ExifInterface.LATITUDE_SOUTH, "(Landroidx/camera/camera2/impl/UseCaseCameraRequestControlImpl$b;Ljava/util/List;)Landroidx/camera/camera2/impl/UseCaseCameraRequestControlImpl$b;", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl$Type;", "type", "LUa/Q;", "LY8/t;", "L", "(Landroidx/camera/camera2/impl/UseCaseCameraRequestControl$Type;Ljava/util/Map;Landroidx/camera/core/impl/Config$OptionPriority;Le9/c;)Ljava/lang/Object;", "", "count", "", "message", "Ljava/lang/Void;", "D", "(ILjava/lang/String;)Ljava/util/List;", "Landroidx/camera/core/impl/l;", "", "H", "(Ljava/util/List;)Z", "I", "(Ljava/util/Map;)Landroidx/camera/camera2/impl/UseCaseCameraRequestControlImpl$b;", "LK/E0;", "M", "(Landroidx/camera/camera2/impl/UseCaseCameraRequestControlImpl$b;)LK/E0;", "", "Lw/Q;", "streams", "N", "(Landroidx/camera/camera2/impl/UseCaseCameraRequestControlImpl$b;Ljava/util/Set;Le9/c;)Ljava/lang/Object;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function1;", "Le9/c;", "block", "J", "(Lp9/l;)LUa/Q;", ContentDisposition.Parameters.Size, "K", "(ILp9/l;)Ljava/util/List;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/util/Map;Landroidx/camera/camera2/impl/UseCaseCameraRequestControl$Type;Landroidx/camera/core/impl/Config$OptionPriority;)LUa/Q;", "l", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/util/List;Landroidx/camera/camera2/impl/UseCaseCameraRequestControl$Type;)LUa/Q;", "isPrimary", "", "Landroidx/camera/core/UseCase;", "runningUseCases", Const.INTENT_KEY_PKGNAME, "(ZLjava/util/Collection;)LUa/Q;", "Landroidx/camera/core/impl/Config;", "config", "tags", "n", "(Landroidx/camera/core/impl/Config;Ljava/util/Map;)LUa/Q;", "Lw/N;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()LUa/Q;", "Lw/a;", "aeMode", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(I)LUa/Q;", "f", "captureSequence", "captureMode", "flashType", "flashMode", "e", "(Ljava/util/List;III)Ljava/util/List;", "k", "(Le9/c;)Ljava/lang/Object;", "close", "()V", "Lkotlinx/coroutines/CoroutineStart;", "C", "(Lt/y0;)Lkotlinx/coroutines/CoroutineStart;", Const.INTENT_KEY_APIKEY, "LX8/a;", "c", "Ls/J;", Const.INTENT_KEY_UMID, "Lt/y0;", "Landroidx/camera/core/f;", "Z", AlipayXuiIsland.REASON_CLOSED, "kotlin.jvm.PlatformType", "LY8/h;", ExifInterface.LONGITUDE_EAST, "()Lt/w;", "capturePipeline", "G", "()Landroidx/camera/camera2/impl/UseCaseSurfaceManager;", "useCaseSurfaceManager", "F", "()Landroidx/camera/camera2/impl/UseCaseCameraState;", "useCaseCameraState", "", "Ljava/util/Map;", "infoBundleMap", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class UseCaseCameraRequestControlImpl implements UseCaseCameraRequestControl {

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: m, reason: collision with root package name */
    public static final InterfaceC1083u<Result3A> f9910m = C1087w.a(new Result3A(Result3A.a.INSTANCE.d(), null, 2, null));

    /* renamed from: n, reason: collision with root package name */
    public static final InterfaceC1083u<t> f9911n;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final X8.a<InterfaceC5495w> capturePipelineProvider;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final X8.a<UseCaseCameraState> useCaseCameraStateProvider;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final J useCaseGraphContext;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final X8.a<UseCaseSurfaceManager> useCaseSurfaceManagerProvider;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final y0 threads;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final androidx.camera.core.f cameraXConfig;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public volatile boolean closed;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final h capturePipeline;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final h useCaseSurfaceManager;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final h useCaseCameraState;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public final Map<UseCaseCameraRequestControl.Type, InfoBundle> infoBundleMap;

    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b*\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e*\u00020\u00042\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0013\u001a\u00020\u0012*\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0016\u001a\u00020\u0015*\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0019\u001a\u00020\u0005*\u00020\u0018H\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u001e¨\u0006!"}, d2 = {"Landroidx/camera/camera2/impl/UseCaseCameraRequestControlImpl$a;", "", "<init>", "()V", "Landroidx/camera/core/impl/SessionConfig;", "Landroidx/camera/camera2/impl/a$a;", Const.INTENT_KEY_UMID, "(Landroidx/camera/core/impl/SessionConfig;)Landroidx/camera/camera2/impl/a$a;", "", "", "f", "(Landroidx/camera/core/impl/SessionConfig;)Ljava/util/Map;", "Ljava/util/concurrent/Executor;", "callbackExecutor", "", "Landroidx/camera/camera2/pipe/t$a;", "e", "(Landroidx/camera/core/impl/SessionConfig;Ljava/util/concurrent/Executor;)Ljava/util/Set;", "Lw/M;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroidx/camera/core/impl/SessionConfig;)I", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControlImpl$b;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroidx/camera/core/impl/SessionConfig;Ljava/util/concurrent/Executor;)Landroidx/camera/camera2/impl/UseCaseCameraRequestControlImpl$b;", "Landroidx/camera/core/impl/Config;", "c", "(Landroidx/camera/core/impl/Config;)Landroidx/camera/camera2/impl/a$a;", "LUa/u;", "Lw/N;", "submitFailedResult", "LUa/u;", "LY8/t;", "canceledResult", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.impl.UseCaseCameraRequestControlImpl$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final a.C0131a c(Config config) {
            a.C0131a c0131a = new a.C0131a();
            c0131a.e(config);
            return c0131a;
        }

        public final a.C0131a d(SessionConfig sessionConfig) {
            p.i(sessionConfig, "<this>");
            a.C0131a c0131a = new a.C0131a();
            if (!p.d(sessionConfig.e(), y.f11539a)) {
                CaptureRequest.Key CONTROL_AE_TARGET_FPS_RANGE = CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE;
                p.h(CONTROL_AE_TARGET_FPS_RANGE, "CONTROL_AE_TARGET_FPS_RANGE");
                c0131a.g(CONTROL_AE_TARGET_FPS_RANGE, sessionConfig.e());
            }
            Config configG = sessionConfig.g();
            p.h(configG, "getImplementationOptions(...)");
            c0131a.e(configG);
            return c0131a;
        }

        public final Set<t.a> e(SessionConfig sessionConfig, Executor callbackExecutor) {
            p.i(sessionConfig, "<this>");
            p.i(callbackExecutor, "callbackExecutor");
            b.Companion companion = b.INSTANCE;
            List<AbstractC0889l> listK = sessionConfig.k();
            p.h(listK, "getRepeatingCameraCaptureCallbacks(...)");
            return Y.h(companion.a(listK, callbackExecutor));
        }

        public final Map<String, Object> f(SessionConfig sessionConfig) {
            p.i(sessionConfig, "<this>");
            E0 e0I = sessionConfig.l().i();
            p.h(e0I, "getTagBundle(...)");
            return kotlin.collections.a.C(r0.a(e0I));
        }

        public final int g(SessionConfig extractTemplate) {
            p.i(extractTemplate, "$this$extractTemplate");
            return M.b(extractTemplate.q());
        }

        public final InfoBundle h(SessionConfig sessionConfig, Executor executor) {
            return new InfoBundle(d(sessionConfig), f(sessionConfig), e(sessionConfig, executor), M.a(g(sessionConfig)), null);
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0082\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJL\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00042\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR#\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b \u0010\"R$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006("}, d2 = {"Landroidx/camera/camera2/impl/UseCaseCameraRequestControlImpl$b;", "", "Landroidx/camera/camera2/impl/a$a;", "options", "", "", "tags", "", "Landroidx/camera/camera2/pipe/t$a;", "listeners", "Lw/M;", M5.e.FAIL_TEMPLATE, "<init>", "(Landroidx/camera/camera2/impl/a$a;Ljava/util/Map;Ljava/util/Set;Lw/M;Lkotlin/jvm/internal/i;)V", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/camera2/impl/a$a;Ljava/util/Map;Ljava/util/Set;Lw/M;)Landroidx/camera/camera2/impl/UseCaseCameraRequestControlImpl$b;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroidx/camera/camera2/impl/a$a;", Const.INTENT_KEY_UMID, "()Landroidx/camera/camera2/impl/a$a;", Const.INTENT_KEY_PKGNAME, "Ljava/util/Map;", "e", "()Ljava/util/Map;", "c", "Ljava/util/Set;", "()Ljava/util/Set;", "Lw/M;", "f", "()Lw/M;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lw/M;)V", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.impl.UseCaseCameraRequestControlImpl$b, reason: from toString */
    public static final /* data */ class InfoBundle {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final a.C0131a options;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final Map<String, Object> tags;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final Set<t.a> listeners;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        public M template;

        public /* synthetic */ InfoBundle(a.C0131a c0131a, Map map, Set set, M m10, i iVar) {
            this(c0131a, map, set, m10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ InfoBundle b(InfoBundle infoBundle, a.C0131a c0131a, Map map, Set set, M m10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                c0131a = infoBundle.options;
            }
            if ((i10 & 2) != 0) {
                map = infoBundle.tags;
            }
            if ((i10 & 4) != 0) {
                set = infoBundle.listeners;
            }
            if ((i10 & 8) != 0) {
                m10 = infoBundle.template;
            }
            return infoBundle.a(c0131a, map, set, m10);
        }

        public final InfoBundle a(a.C0131a options, Map<String, Object> tags, Set<t.a> listeners, M template) {
            p.i(options, "options");
            p.i(tags, "tags");
            p.i(listeners, "listeners");
            return new InfoBundle(options, tags, listeners, template, null);
        }

        public final Set<t.a> c() {
            return this.listeners;
        }

        /* renamed from: d, reason: from getter */
        public final a.C0131a getOptions() {
            return this.options;
        }

        public final Map<String, Object> e() {
            return this.tags;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InfoBundle)) {
                return false;
            }
            InfoBundle infoBundle = (InfoBundle) other;
            return p.d(this.options, infoBundle.options) && p.d(this.tags, infoBundle.tags) && p.d(this.listeners, infoBundle.listeners) && p.d(this.template, infoBundle.template);
        }

        /* renamed from: f, reason: from getter */
        public final M getTemplate() {
            return this.template;
        }

        public final void g(M m10) {
            this.template = m10;
        }

        public int hashCode() {
            int iHashCode = ((((this.options.hashCode() * 31) + this.tags.hashCode()) * 31) + this.listeners.hashCode()) * 31;
            M m10 = this.template;
            return iHashCode + (m10 == null ? 0 : M.f(m10.getValue()));
        }

        public String toString() {
            return "InfoBundle(options=" + this.options + ", tags=" + this.tags + ", listeners=" + this.listeners + ", template=" + this.template + ')';
        }

        public InfoBundle(a.C0131a options, Map<String, Object> tags, Set<t.a> listeners, M m10) {
            p.i(options, "options");
            p.i(tags, "tags");
            p.i(listeners, "listeners");
            this.options = options;
            this.tags = tags;
            this.listeners = listeners;
            this.template = m10;
        }

        public /* synthetic */ InfoBundle(a.C0131a c0131a, Map map, Set set, M m10, int i10, i iVar) {
            this((i10 & 1) != 0 ? new a.C0131a() : c0131a, (i10 & 2) != 0 ? new LinkedHashMap() : map, (i10 & 4) != 0 ? new LinkedHashSet() : set, (i10 & 8) != 0 ? null : m10, null);
        }
    }

    static {
        InterfaceC1083u<Y8.t> interfaceC1083uC = C1087w.c(null, 1, null);
        kotlinx.coroutines.g.Y0(interfaceC1083uC, null, 1, null);
        f9911n = interfaceC1083uC;
    }

    public UseCaseCameraRequestControlImpl(X8.a<InterfaceC5495w> capturePipelineProvider, X8.a<UseCaseCameraState> useCaseCameraStateProvider, J useCaseGraphContext, X8.a<UseCaseSurfaceManager> useCaseSurfaceManagerProvider, y0 threads, androidx.camera.core.f fVar) {
        p.i(capturePipelineProvider, "capturePipelineProvider");
        p.i(useCaseCameraStateProvider, "useCaseCameraStateProvider");
        p.i(useCaseGraphContext, "useCaseGraphContext");
        p.i(useCaseSurfaceManagerProvider, "useCaseSurfaceManagerProvider");
        p.i(threads, "threads");
        this.capturePipelineProvider = capturePipelineProvider;
        this.useCaseCameraStateProvider = useCaseCameraStateProvider;
        this.useCaseGraphContext = useCaseGraphContext;
        this.useCaseSurfaceManagerProvider = useCaseSurfaceManagerProvider;
        this.threads = threads;
        this.cameraXConfig = fVar;
        C5473b c5473b = C5473b.f41865a;
        if (C0761b0.f("CXCP")) {
            Log.d(C5473b.TRUNCATED_TAG, "Configured " + this);
        }
        this.capturePipeline = C4848b.b(new InterfaceC5063a() { // from class: t.o0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return UseCaseCameraRequestControlImpl.B(this.f41928a);
            }
        });
        this.useCaseSurfaceManager = C4848b.b(new InterfaceC5063a() { // from class: t.p0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return UseCaseCameraRequestControlImpl.Q(this.f41934a);
            }
        });
        this.useCaseCameraState = C4848b.b(new InterfaceC5063a() { // from class: t.q0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return UseCaseCameraRequestControlImpl.P(this.f41938a);
            }
        });
        this.infoBundleMap = new LinkedHashMap();
    }

    public static final InterfaceC5495w B(UseCaseCameraRequestControlImpl useCaseCameraRequestControlImpl) {
        return useCaseCameraRequestControlImpl.capturePipelineProvider.get();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object O(UseCaseCameraRequestControlImpl useCaseCameraRequestControlImpl, InfoBundle infoBundle, Set set, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            set = null;
        }
        return useCaseCameraRequestControlImpl.N(infoBundle, set, interfaceC4014c);
    }

    public static final UseCaseCameraState P(UseCaseCameraRequestControlImpl useCaseCameraRequestControlImpl) {
        return useCaseCameraRequestControlImpl.useCaseCameraStateProvider.get();
    }

    public static final UseCaseSurfaceManager Q(UseCaseCameraRequestControlImpl useCaseCameraRequestControlImpl) {
        return useCaseCameraRequestControlImpl.useCaseSurfaceManagerProvider.get();
    }

    public final CoroutineStart C(y0 y0Var) {
        p.i(y0Var, "<this>");
        return y0Var.g() ? CoroutineStart.UNDISPATCHED : CoroutineStart.DEFAULT;
    }

    public final List<Q<Void>> D(int count, String message) {
        ArrayList arrayList = new ArrayList(count);
        for (int i10 = 0; i10 < count; i10++) {
            InterfaceC1083u interfaceC1083uC = C1087w.c(null, 1, null);
            interfaceC1083uC.e(new ImageCaptureException(2, message, null));
            arrayList.add(interfaceC1083uC);
        }
        return arrayList;
    }

    public final InterfaceC5495w E() {
        return (InterfaceC5495w) this.capturePipeline.getValue();
    }

    public final UseCaseCameraState F() {
        return (UseCaseCameraState) this.useCaseCameraState.getValue();
    }

    public final UseCaseSurfaceManager G() {
        return (UseCaseSurfaceManager) this.useCaseSurfaceManager.getValue();
    }

    public final boolean H(List<l> list) {
        for (l lVar : list) {
            if (lVar.h().isEmpty()) {
                return true;
            }
            List<DeferrableSurface> listH = lVar.h();
            p.h(listH, "getSurfaces(...)");
            Iterator<T> it = listH.iterator();
            while (it.hasNext()) {
                if (this.useCaseGraphContext.h().get((DeferrableSurface) it.next()) == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final InfoBundle I(Map<UseCaseCameraRequestControl.Type, InfoBundle> map) {
        InfoBundle infoBundle = new InfoBundle(null, null, null, M.a(M.b(1)), 7, null);
        Iterator<UseCaseCameraRequestControl.Type> it = UseCaseCameraRequestControl.Type.getEntries().iterator();
        while (it.hasNext()) {
            InfoBundle infoBundle2 = map.get(it.next());
            if (infoBundle2 != null) {
                infoBundle.getOptions().e(infoBundle2.getOptions().a());
                infoBundle.e().putAll(infoBundle2.e());
                infoBundle.c().addAll(infoBundle2.c());
                M template = infoBundle2.getTemplate();
                if (template != null) {
                    infoBundle.g(M.a(template.getValue()));
                }
            }
        }
        return infoBundle;
    }

    public final <T> Q<T> J(InterfaceC5074l<? super InterfaceC4014c<? super Q<? extends T>>, ? extends Object> block) {
        CoroutineStart coroutineStartC = C(this.threads);
        y0 y0Var = this.threads;
        InterfaceC1083u interfaceC1083uC = C1087w.c(null, 1, null);
        C1060i.d(y0Var.getSequentialScope(), null, coroutineStartC, new UseCaseCameraRequestControlImpl$runOnSequential$$inlined$confineDeferredSuspend$1(block, interfaceC1083uC, null), 1, null);
        return interfaceC1083uC;
    }

    public final <T> List<Q<T>> K(int size, InterfaceC5074l<? super InterfaceC4014c<? super List<? extends Q<? extends T>>>, ? extends Object> block) {
        CoroutineStart coroutineStartC = C(this.threads);
        y0 y0Var = this.threads;
        ArrayList arrayList = new ArrayList(size);
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.add(C1087w.c(null, 1, null));
        }
        C1060i.d(y0Var.getSequentialScope(), null, coroutineStartC, new UseCaseCameraRequestControlImpl$runOnSequentialList$$inlined$confineDeferredListSuspend$1(block, arrayList, null), 1, null);
        return arrayList;
    }

    public final Object L(UseCaseCameraRequestControl.Type type, Map<CaptureRequest.Key<?>, ? extends Object> map, Config.OptionPriority optionPriority, InterfaceC4014c<? super Q<Y8.t>> interfaceC4014c) {
        C5473b c5473b = C5473b.f41865a;
        if (C0761b0.f("CXCP")) {
            Log.d(C5473b.TRUNCATED_TAG, "UseCaseCameraRequestControlImpl#setParametersAsync: [" + type + "] values = " + map + ", optionPriority = " + optionPriority);
        }
        Map<UseCaseCameraRequestControl.Type, InfoBundle> map2 = this.infoBundleMap;
        InfoBundle infoBundle = map2.get(type);
        if (infoBundle == null) {
            InfoBundle infoBundle2 = new InfoBundle(null, null, null, null, 15, null);
            map2.put(type, infoBundle2);
            infoBundle = infoBundle2;
        }
        this.infoBundleMap.put(type, R(infoBundle, map, optionPriority));
        return O(this, I(this.infoBundleMap), null, interfaceC4014c, 1, null);
    }

    public final E0 M(InfoBundle infoBundle) {
        o0 o0VarG = o0.g();
        for (Map.Entry<String, Object> entry : infoBundle.e().entrySet()) {
            o0VarG.h(entry.getKey(), entry.getValue());
        }
        p.h(o0VarG, "also(...)");
        return o0VarG;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object N(androidx.camera.camera2.impl.UseCaseCameraRequestControlImpl.InfoBundle r11, java.util.Set<w.Q> r12, e9.InterfaceC4014c<? super Ua.Q<Y8.t>> r13) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r13 instanceof androidx.camera.camera2.impl.UseCaseCameraRequestControlImpl$updateCameraStateAsync$1
            if (r0 == 0) goto L14
            r0 = r13
            androidx.camera.camera2.impl.UseCaseCameraRequestControlImpl$updateCameraStateAsync$1 r0 = (androidx.camera.camera2.impl.UseCaseCameraRequestControlImpl$updateCameraStateAsync$1) r0
            int r1 = r0.f9968c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f9968c = r1
        L12:
            r9 = r0
            goto L1a
        L14:
            androidx.camera.camera2.impl.UseCaseCameraRequestControlImpl$updateCameraStateAsync$1 r0 = new androidx.camera.camera2.impl.UseCaseCameraRequestControlImpl$updateCameraStateAsync$1
            r0.<init>(r10, r13)
            goto L12
        L1a:
            java.lang.Object r13 = r9.f9966a
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r9.f9968c
            r2 = 1
            if (r1 == 0) goto L34
            if (r1 != r2) goto L2c
            kotlin.C4849c.b(r13)
            goto Laf
        L2c:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L34:
            kotlin.C4849c.b(r13)
            boolean r13 = r10.closed
            if (r13 != 0) goto Lb2
            androidx.camera.core.f r13 = r10.cameraXConfig
            if (r13 == 0) goto L58
            v.c r13 = v.C5647d.b(r13)
            if (r13 == 0) goto L58
            androidx.camera.camera2.impl.a$a r1 = r11.getOptions()
            androidx.camera.camera2.impl.a r1 = r1.c()
            java.util.Map r1 = t.C5471a.b(r1)
            java.util.Map r1 = kotlin.collections.a.A(r1)
            v.C5647d.a(r13, r1)
        L58:
            t.w r13 = r10.E()
            w.M r1 = r11.getTemplate()
            kotlin.jvm.internal.p.f(r1)
            int r1 = r1.getValue()
            r3 = -1
            if (r1 == r3) goto L76
            w.M r1 = r11.getTemplate()
            kotlin.jvm.internal.p.f(r1)
            int r1 = r1.getValue()
            goto L77
        L76:
            r1 = r2
        L77:
            r13.b(r1)
            androidx.camera.camera2.impl.UseCaseCameraState r1 = r10.F()
            androidx.camera.camera2.impl.a$a r13 = r11.getOptions()
            androidx.camera.camera2.impl.a r13 = r13.c()
            java.util.Map r13 = t.C5471a.b(r13)
            androidx.camera.camera2.pipe.q$a r3 = t.f0.a()
            K.E0 r10 = r10.M(r11)
            kotlin.Pair r10 = Y8.j.a(r3, r10)
            java.util.Map r4 = Z8.Q.f(r10)
            w.M r7 = r11.getTemplate()
            java.util.Set r8 = r11.c()
            r9.f9968c = r2
            r3 = 0
            r5 = 0
            r6 = r12
            r2 = r13
            java.lang.Object r13 = r1.j(r2, r3, r4, r5, r6, r7, r8, r9)
            if (r13 != r0) goto Laf
            return r0
        Laf:
            Ua.Q r13 = (Ua.Q) r13
            goto Lb3
        Lb2:
            r13 = 0
        Lb3:
            if (r13 != 0) goto Lb8
            Ua.u<Y8.t> r10 = androidx.camera.camera2.impl.UseCaseCameraRequestControlImpl.f9911n
            return r10
        Lb8:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.impl.UseCaseCameraRequestControlImpl.N(androidx.camera.camera2.impl.UseCaseCameraRequestControlImpl$b, java.util.Set, e9.c):java.lang.Object");
    }

    public final InfoBundle R(InfoBundle infoBundle, Map<CaptureRequest.Key<?>, ? extends Object> map, Config.OptionPriority optionPriority) {
        a.C0131a c0131a = new a.C0131a();
        c0131a.e(infoBundle.getOptions().a());
        c0131a.b(map, optionPriority);
        return InfoBundle.b(infoBundle, c0131a, kotlin.collections.a.C(infoBundle.e()), F.q1(infoBundle.c()), null, 8, null);
    }

    public final InfoBundle S(InfoBundle infoBundle, List<? extends CaptureRequest.Key<?>> list) {
        a.C0131a c0131a = new a.C0131a();
        c0131a.e(infoBundle.getOptions().a());
        c0131a.f(list);
        return InfoBundle.b(infoBundle, c0131a, kotlin.collections.a.C(infoBundle.e()), F.q1(infoBundle.c()), null, 8, null);
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraRequestControl
    public Q<Y8.t> b(boolean isPrimary, Collection<? extends UseCase> runningUseCases) {
        p.i(runningUseCases, "runningUseCases");
        Q<Y8.t> qJ = this.closed ? null : J(new UseCaseCameraRequestControlImpl$updateRepeatingRequestAsync$1$1(runningUseCases, isPrimary, this, null));
        return qJ == null ? f9911n : qJ;
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraRequestControl
    public void close() {
        this.closed = true;
        C5473b c5473b = C5473b.f41865a;
        if (C0761b0.f("CXCP")) {
            Log.d(C5473b.TRUNCATED_TAG, "UseCaseCameraRequestControl: closed");
        }
        F().e();
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraRequestControl
    public List<Q<Void>> e(List<l> captureSequence, int captureMode, int flashType, int flashMode) {
        UseCaseCameraRequestControlImpl useCaseCameraRequestControlImpl;
        List<l> list;
        List<Q<Void>> listK;
        p.i(captureSequence, "captureSequence");
        if (this.closed) {
            useCaseCameraRequestControlImpl = this;
            list = captureSequence;
            listK = null;
        } else {
            useCaseCameraRequestControlImpl = this;
            list = captureSequence;
            listK = useCaseCameraRequestControlImpl.K(captureSequence.size(), new UseCaseCameraRequestControlImpl$issueSingleCaptureAsync$1$1(useCaseCameraRequestControlImpl, list, captureMode, flashType, flashMode, null));
        }
        return listK == null ? useCaseCameraRequestControlImpl.D(list.size(), "Capture request is cancelled on closed CameraGraph") : listK;
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraRequestControl
    public Q<Result3A> f() {
        Q<Result3A> qJ = this.closed ? null : J(new UseCaseCameraRequestControlImpl$cancelFocusAndMeteringAsync$1$1(this, null));
        return qJ == null ? f9910m : qJ;
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraRequestControl
    public Q<Result3A> g() {
        Q<Result3A> qJ = this.closed ? null : J(new UseCaseCameraRequestControlImpl$setTorchOnAsync$1$1(this, null));
        return qJ == null ? f9910m : qJ;
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraRequestControl
    public Q<Y8.t> h(Map<CaptureRequest.Key<?>, ? extends Object> values, UseCaseCameraRequestControl.Type type, Config.OptionPriority optionPriority) {
        p.i(values, "values");
        p.i(type, "type");
        p.i(optionPriority, "optionPriority");
        Q<Y8.t> qJ = !this.closed ? J(new UseCaseCameraRequestControlImpl$setParametersAsync$1$1(this, type, values, optionPriority, null)) : null;
        return qJ == null ? f9911n : qJ;
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraRequestControl
    public Q<Y8.t> i(List<? extends CaptureRequest.Key<?>> keys, UseCaseCameraRequestControl.Type type) {
        p.i(keys, "keys");
        p.i(type, "type");
        Q<Y8.t> qJ = this.closed ? null : J(new UseCaseCameraRequestControlImpl$removeParametersAsync$1$1(this, type, keys, null));
        return qJ == null ? f9911n : qJ;
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraRequestControl
    public Q<Result3A> j(int aeMode) {
        Q<Result3A> qJ = this.closed ? null : J(new UseCaseCameraRequestControlImpl$setTorchOffAsync$1$1(this, aeMode, null));
        return qJ == null ? f9910m : qJ;
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraRequestControl
    public Object k(InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return G().k(interfaceC4014c);
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraRequestControl
    public Q<Y8.t> l(Map<CaptureRequest.Key<?>, ? extends Object> values, UseCaseCameraRequestControl.Type type, Config.OptionPriority optionPriority) {
        p.i(values, "values");
        p.i(type, "type");
        p.i(optionPriority, "optionPriority");
        if (this.closed) {
            return f9911n;
        }
        this.threads.c();
        return C1060i.b(this.threads.getSequentialScope(), null, CoroutineStart.UNDISPATCHED, new UseCaseCameraRequestControlImpl$submitParameters$1(this, type, values, optionPriority, null), 1, null);
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraRequestControl
    public Q<Y8.t> n(Config config, Map<String, ? extends Object> tags) {
        p.i(config, "config");
        p.i(tags, "tags");
        Q<Y8.t> qJ = this.closed ? null : J(new UseCaseCameraRequestControlImpl$updateCamera2ConfigAsync$1$1(this, config, tags, null));
        return qJ == null ? f9911n : qJ;
    }
}
