package com.stepos.alphame.ocr;

import T0.e;
import T0.f;
import T0.g;
import T0.h;
import T0.i;
import U0.b;
import Z2.G;
import Z2.Q;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.IBinder;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.activity.d;
import androidx.room.AbstractC0351g;
import ch.qos.logback.core.joran.action.Action;
import com.baidu.mapapi.http.wrapper.annotation.BodyData;
import com.equationl.paddleocr4android.Util.paddle.OCRPredictorNative;
import com.stepos.activeview.graphicsanim.renderable.ParticleSystem;
import com.stepos.alphame.NotProguard;
import com.stepos.alphame.common.utils.BaseApplication;
import com.stepos.alphame.engine.EngineBase;
import com.stepos.alphame.engine.EngineFunc;
import com.stepos.alphame.ocr.decoder.OcrDecoder;
import com.stepos.alphame.ocr.decoder.OcrDecoderBinder;
import com.stepos.alphame.ocr.decoder.OcrDecoderBounds;
import com.stepos.alphame.ocr.decoder.OcrDecoderBytes;
import com.stepos.alphame.ocr.decoder.OcrDecoderPath;
import com.stepos.alphame.ocr.decoder.OcrDecoderUri;
import com.stepos.alphame.ocr.task.OcrTaskBound;
import com.stepos.alphame.ocr.task.OcrTaskDetail;
import com.stepos.alphame.utils.AlphaMeLogger;
import com.stepos.alphame.utils.LocalConsts;
import com.stepos.alphame.utils.SystemProperty;
import com.stepos.alphame.utils.pool.PoolManager;
import f3.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t0.J;

@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 v2\u00020\u0001:\u0018vwxyz{|}~\u007f\u0080\u0001\u0081\u0001\u0082\u0001\u0083\u0001\u0084\u0001\u0085\u0001\u0086\u0001B\u0007¢\u0006\u0004\bu\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\r\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\b\u0010\u0004J\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u000b\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\tH\u0007¢\u0006\u0004\b\u0016\u0010\fJ!\u0010\u0018\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u0011H\u0007¢\u0006\u0004\b!\u0010\"J\u0019\u0010%\u001a\u00020$2\b\u0010#\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0004\b%\u0010&J\u001b\u0010'\u001a\u0004\u0018\u00010\t2\b\u0010#\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0004\b'\u0010(J\u0019\u0010)\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0007¢\u0006\u0004\b)\u0010\u001fJ\u0017\u0010*\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u0011H\u0007¢\u0006\u0004\b*\u0010\"J#\u0010,\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010+\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0004\b,\u0010-J\u001b\u0010.\u001a\u0004\u0018\u00010\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0007¢\u0006\u0004\b.\u0010/J\u001f\u00105\u001a\u0002042\u0006\u00101\u001a\u0002002\u0006\u00103\u001a\u000202H\u0002¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020\u0002H\u0002¢\u0006\u0004\b7\u0010\u0004J\u000f\u00108\u001a\u00020\u0002H\u0002¢\u0006\u0004\b8\u0010\u0004J\u000f\u00109\u001a\u000200H\u0002¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u000202H\u0002¢\u0006\u0004\b;\u0010<J\u001d\u0010?\u001a\u00020$2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00020=H\u0002¢\u0006\u0004\b?\u0010@J\u000f\u0010A\u001a\u00020\u0002H\u0002¢\u0006\u0004\bA\u0010\u0004J\u000f\u0010B\u001a\u00020\u0002H\u0002¢\u0006\u0004\bB\u0010\u0004J\u0017\u0010D\u001a\u00020\u00022\u0006\u0010C\u001a\u00020\tH\u0002¢\u0006\u0004\bD\u0010\fJ\u001f\u0010I\u001a\u00020\u00022\u0006\u0010F\u001a\u00020E2\u0006\u0010H\u001a\u00020GH\u0002¢\u0006\u0004\bI\u0010JJ%\u0010L\u001a\b\u0018\u00010KR\u00020\u00002\u0006\u0010F\u001a\u00020E2\u0006\u0010H\u001a\u00020GH\u0002¢\u0006\u0004\bL\u0010MJ\u001b\u0010O\u001a\u00020\u00022\n\u0010N\u001a\u00060KR\u00020\u0000H\u0002¢\u0006\u0004\bO\u0010PJ\u001b\u0010Q\u001a\u00020\u00022\n\u0010N\u001a\u00060KR\u00020\u0000H\u0002¢\u0006\u0004\bQ\u0010PJ#\u0010S\u001a\u00020\u00022\n\u0010N\u001a\u00060KR\u00020\u00002\u0006\u0010R\u001a\u00020\tH\u0002¢\u0006\u0004\bS\u0010TJ+\u0010W\u001a\u00020\u00022\n\u0010N\u001a\u00060KR\u00020\u00002\u0006\u0010U\u001a\u0002022\u0006\u0010V\u001a\u00020\tH\u0002¢\u0006\u0004\bW\u0010XR\u0016\u0010Z\u001a\u00020Y8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010\\\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\u001c\u0010`\u001a\n _*\u0004\u0018\u00010^0^8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010aR\u0014\u0010c\u001a\u00020b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010dR\u001e\u0010f\u001a\f\u0012\b\u0012\u00060KR\u00020\u00000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010gR\u0014\u0010h\u001a\u00020b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bh\u0010dR\u0018\u0010i\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010jR\u0016\u0010k\u001a\u0002028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010lR\u0016\u0010m\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010]R\u0014\u0010n\u001a\u00020b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bn\u0010dR\u001c\u0010p\u001a\b\u0012\u0002\b\u0003\u0018\u00010o8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010qR\u0014\u0010s\u001a\u00020r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bs\u0010t¨\u0006\u0087\u0001"}, d2 = {"Lcom/stepos/alphame/ocr/OcrEngine;", "Lcom/stepos/alphame/engine/EngineBase;", "", "onStart", "()V", "onStop", "trimMemory", LocalConsts.FUNC_OCR_INIT, LocalConsts.FUNC_OCR_RELEASE, "", ParticleSystem.ATTR_BITMAP_PATH, LocalConsts.FUNC_RECOGNIZE_OCR_PATH, "(Ljava/lang/String;)V", "bitmapType", "", "contentVersion", "(Ljava/lang/String;Ljava/lang/String;J)V", "Landroid/os/IBinder;", "clientBinder", LocalConsts.FUNC_RECOGNIZE_OCR_PATH_EXT, "(Ljava/lang/String;Landroid/os/IBinder;)V", "bitmapUri", LocalConsts.FUNC_RECOGNIZE_OCR_URI, "bitmapBinder", LocalConsts.FUNC_RECOGNIZE_OCR_BINDER_WITH_VERSION, "(Landroid/os/IBinder;J)V", LocalConsts.FUNC_RECOGNIZE_OCR_URI_WITH_VERSION, "(Ljava/lang/String;J)V", "", "bitmapByte", LocalConsts.FUNC_RECOGNIZE_OCR_BYTE, "([B)V", "iBinder", LocalConsts.FUNC_RECOGNIZE_OCR_BINDER, "(Landroid/os/IBinder;)V", "filePath", "", LocalConsts.FUNC_DETECT_OCR_BY_PATH, "(Ljava/lang/String;)Z", LocalConsts.FUNC_DETECT_OCR_BOUNDS_BY_PATH, "(Ljava/lang/String;)Ljava/lang/String;", LocalConsts.FUNC_DETECT_OCR_POINT_BYTE, LocalConsts.FUNC_DETECT_OCR_POINT_BINDER, "pointResultJson", LocalConsts.FUNC_RECOGNIZE_OCR_POINT_BYTE, "([BLjava/lang/String;)V", LocalConsts.FUNC_DETECT_OCR_BYTE_SYNC, "([B)Ljava/lang/String;", "LT0/a;", "power", "", "threads", "LT0/i;", "buildConfig", "(LT0/a;I)LT0/i;", "refreshTraceSwitch", "applyConfigIfChanged", "resolvePowerMode", "()LT0/a;", "resolveThreadNum", "()I", "Lkotlin/Function0;", "onReloaded", "ensureModelReady", "(Lkotlin/jvm/functions/Function0;)Z", "cancelIdleRelease", "scheduleIdleReleaseIfQuiet", "reason", "releaseModelIfQuiet", "Lcom/stepos/alphame/ocr/task/OcrTaskDetail;", "task", "Lcom/stepos/alphame/ocr/OcrTrace;", "trace", "runRecognizeWithTask", "(Lcom/stepos/alphame/ocr/task/OcrTaskDetail;Lcom/stepos/alphame/ocr/OcrTrace;)V", "Lcom/stepos/alphame/ocr/OcrEngine$PendingOcr;", "enqueueOrMerge", "(Lcom/stepos/alphame/ocr/task/OcrTaskDetail;Lcom/stepos/alphame/ocr/OcrTrace;)Lcom/stepos/alphame/ocr/OcrEngine$PendingOcr;", "job", "runPending", "(Lcom/stepos/alphame/ocr/OcrEngine$PendingOcr;)V", "dequeue", BodyData.TYPE_JSON, "succeedJob", "(Lcom/stepos/alphame/ocr/OcrEngine$PendingOcr;Ljava/lang/String;)V", "errorCode", "tag", "failJob", "(Lcom/stepos/alphame/ocr/OcrEngine$PendingOcr;ILjava/lang/String;)V", "LT0/h;", "ocr", "LT0/h;", "isOcrReady", "Z", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "ocrExecutor", "Ljava/util/concurrent/ExecutorService;", "", "pendingLock", "Ljava/lang/Object;", "Ljava/util/LinkedList;", "pending", "Ljava/util/LinkedList;", "configLock", "appliedPower", "LT0/a;", "appliedThreads", "I", "isModelReleased", "idleLock", "Ljava/util/concurrent/ScheduledFuture;", "idleRelease", "Ljava/util/concurrent/ScheduledFuture;", "Ljava/util/concurrent/ScheduledExecutorService;", "idleScheduler", "Ljava/util/concurrent/ScheduledExecutorService;", "<init>", "Companion", "DetectOCRBoundsByPath", "DetectOCRByPath", "DetectOCRPointByBinder", "DetectOCRPointByByte", "DetectOCRPointByByteSync", "OCRInit", "OCRRelease", "PendingOcr", "RecognizeOCRByBinder", "RecognizeOCRByBinderWithVersion", "RecognizeOCRByByte", "RecognizeOCRByPath", "RecognizeOCRByPathExt", "RecognizeOCRByPointByte", "RecognizeOCRByUri", "RecognizeOCRByUriWithVersion", "app_release"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nOcrEngine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OcrEngine.kt\ncom/stepos/alphame/ocr/OcrEngine\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 OcrEngine.kt\ncom/stepos/alphame/ocr/OcrEngine$PendingOcr\n*L\n1#1,1157:1\n1#2:1158\n1855#3,2:1159\n288#3,2:1161\n1855#3,2:1164\n1855#3,2:1168\n1855#3,2:1172\n1855#3,2:1176\n1855#3,2:1180\n1855#3,2:1184\n683#4:1163\n684#4:1166\n683#4:1167\n684#4:1170\n683#4:1171\n684#4:1174\n683#4:1175\n684#4:1178\n679#4:1179\n680#4:1182\n679#4:1183\n680#4:1186\n*S KotlinDebug\n*F\n+ 1 OcrEngine.kt\ncom/stepos/alphame/ocr/OcrEngine\n*L\n210#1:1159,2\n526#1:1161,2\n591#1:1164,2\n593#1:1168,2\n603#1:1172,2\n614#1:1176,2\n639#1:1180,2\n652#1:1184,2\n591#1:1163\n591#1:1166\n593#1:1167\n593#1:1170\n603#1:1171\n603#1:1174\n614#1:1175\n614#1:1178\n639#1:1179\n639#1:1182\n652#1:1183\n652#1:1186\n*E\n"})
/* loaded from: classes.dex */
public final class OcrEngine extends EngineBase {
    private static final long DEFAULT_IDLE_RELEASE_MS = 30000;
    private static final int DEFAULT_OCR_THREADS = 4;
    private static final int MAX_PENDING = 3;

    @NotNull
    private static final String PROP_OCR_IDLE_MS = "debug.alphame.ocr.idle_ms";

    @NotNull
    private static final String PROP_OCR_POWER = "debug.alphame.ocr.power";

    @NotNull
    private static final String PROP_OCR_THREADS = "debug.alphame.ocr.threads";

    @NotNull
    private static final String PROP_OCR_TRACE = "debug.alphame.ocr.trace";

    @NotNull
    public static final String TAG = "OcrEngine";
    private static final int UNSET_IDLE_MS = -1;

    @Nullable
    private volatile T0.a appliedPower;
    private volatile int appliedThreads;

    @Nullable
    private ScheduledFuture<?> idleRelease;

    @NotNull
    private final ScheduledExecutorService idleScheduler;
    private volatile boolean isModelReleased;
    private volatile boolean isOcrReady;
    private h ocr;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Lazy<OcrEngine> INSTANCE$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<OcrEngine>() { // from class: com.stepos.alphame.ocr.OcrEngine$Companion$INSTANCE$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final OcrEngine invoke() {
            return new OcrEngine();
        }
    });
    private final ExecutorService ocrExecutor = Executors.newSingleThreadExecutor(new com.stepos.alphame.dailyusage.a(2));

    @NotNull
    private final Object pendingLock = new Object();

    @NotNull
    private final LinkedList<PendingOcr> pending = new LinkedList<>();

    @NotNull
    private final Object configLock = new Object();

    @NotNull
    private final Object idleLock = new Object();

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/stepos/alphame/ocr/OcrEngine$Companion;", "", "()V", "DEFAULT_IDLE_RELEASE_MS", "", "DEFAULT_OCR_THREADS", "", "INSTANCE", "Lcom/stepos/alphame/ocr/OcrEngine;", "getINSTANCE", "()Lcom/stepos/alphame/ocr/OcrEngine;", "INSTANCE$delegate", "Lkotlin/Lazy;", "MAX_PENDING", "PROP_OCR_IDLE_MS", "", "PROP_OCR_POWER", "PROP_OCR_THREADS", "PROP_OCR_TRACE", "TAG", "UNSET_IDLE_MS", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final OcrEngine getINSTANCE() {
            return (OcrEngine) OcrEngine.INSTANCE$delegate.getValue();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/alphame/ocr/OcrEngine$DetectOCRBoundsByPath;", "Lcom/stepos/alphame/engine/EngineFunc;", "_owner", "Lcom/stepos/alphame/engine/EngineBase;", "(Lcom/stepos/alphame/engine/EngineBase;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class DetectOCRBoundsByPath extends EngineFunc {
        public DetectOCRBoundsByPath(@Nullable EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_DETECT_OCR_BOUNDS_BY_PATH;
            this.argsType = new byte[]{6};
            this.argsName = new String[]{"filePath"};
            this.returnType = (byte) 6;
            this.annotation = new String[]{"根据图片的路径识别其内节点的坐标信息", "@author lyl", "@param 图片路径", "@return return String points json"};
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/alphame/ocr/OcrEngine$DetectOCRByPath;", "Lcom/stepos/alphame/engine/EngineFunc;", "_owner", "Lcom/stepos/alphame/engine/EngineBase;", "(Lcom/stepos/alphame/engine/EngineBase;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class DetectOCRByPath extends EngineFunc {
        public DetectOCRByPath(@Nullable EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_DETECT_OCR_BY_PATH;
            this.argsType = new byte[]{6};
            this.argsName = new String[]{"filePath"};
            this.returnType = (byte) 2;
            this.annotation = new String[]{"根据图片的路径识别其内节点的坐标信息，并通过ACTION_OCR_DETECT广播返回", "@author lyl", "@param 图片路径", "@return return true if detect ocr"};
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/alphame/ocr/OcrEngine$DetectOCRPointByBinder;", "Lcom/stepos/alphame/engine/EngineFunc;", "_owner", "Lcom/stepos/alphame/engine/EngineBase;", "(Lcom/stepos/alphame/engine/EngineBase;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class DetectOCRPointByBinder extends EngineFunc {
        public DetectOCRPointByBinder(@Nullable EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_DETECT_OCR_POINT_BINDER;
            this.argsType = new byte[]{7};
            this.argsName = new String[]{"iBinder"};
            this.returnType = (byte) 0;
            this.annotation = new String[]{"把共享内存中的bitmap放到binder传过来，识别其内节点的坐标信息，并通过ACTION_OCR_DETECT广播返回", "@author lyl", "@param iBinder", "@return void"};
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/alphame/ocr/OcrEngine$DetectOCRPointByByte;", "Lcom/stepos/alphame/engine/EngineFunc;", "_owner", "Lcom/stepos/alphame/engine/EngineBase;", "(Lcom/stepos/alphame/engine/EngineBase;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class DetectOCRPointByByte extends EngineFunc {
        public DetectOCRPointByByte(@Nullable EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_DETECT_OCR_POINT_BYTE;
            this.argsType = new byte[]{8};
            this.argsName = new String[]{"bitmapByte"};
            this.returnType = (byte) 6;
            this.annotation = new String[]{"根据图片的字节数组byte[]识别其内节点的坐标信息，并通过ACTION_OCR_DETECT广播返回", "@author lyl", "@param 图片的文件字节数组byte[]", "@return void"};
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/alphame/ocr/OcrEngine$DetectOCRPointByByteSync;", "Lcom/stepos/alphame/engine/EngineFunc;", "_owner", "Lcom/stepos/alphame/engine/EngineBase;", "(Lcom/stepos/alphame/engine/EngineBase;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class DetectOCRPointByByteSync extends EngineFunc {
        public DetectOCRPointByByteSync(@Nullable EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_DETECT_OCR_BYTE_SYNC;
            this.argsType = new byte[]{8};
            this.argsName = new String[]{"bitmapByte"};
            this.returnType = (byte) 6;
            this.annotation = new String[]{"根据图片的字节数组byte[]识别其内节点的坐标信息", "@author lyl", "@param 图片的文件字节数组byte[]", "@return string"};
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/alphame/ocr/OcrEngine$OCRInit;", "Lcom/stepos/alphame/engine/EngineFunc;", "_owner", "Lcom/stepos/alphame/engine/EngineBase;", "(Lcom/stepos/alphame/engine/EngineBase;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class OCRInit extends EngineFunc {
        public OCRInit(@Nullable EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_OCR_INIT;
            this.argsType = new byte[]{0};
            this.argsName = new String[]{""};
            this.returnType = (byte) 2;
            this.annotation = new String[]{"OCR 初始化", "@author lyj", "@return true 初始化成功， false 初始化失败"};
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/alphame/ocr/OcrEngine$OCRRelease;", "Lcom/stepos/alphame/engine/EngineFunc;", "_owner", "Lcom/stepos/alphame/engine/EngineBase;", "(Lcom/stepos/alphame/engine/EngineBase;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class OCRRelease extends EngineFunc {
        public OCRRelease(@Nullable EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_OCR_RELEASE;
            this.argsType = new byte[]{0};
            this.argsName = new String[]{""};
            this.returnType = (byte) 0;
            this.annotation = new String[]{"OCR 释放", "@author lyj"};
        }
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ&\u0010\u0019\u001a\u00020\u001a2\u0018\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001a0\u001cH\u0086\bø\u0001\u0000J \u0010\u001d\u001a\u00020\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001a0\u001eH\u0086\bø\u0001\u0000J\u001a\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u000f0 H\u0002R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR9\u0010\r\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u000f0\u000ej\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u000f`\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006!"}, d2 = {"Lcom/stepos/alphame/ocr/OcrEngine$PendingOcr;", "", Action.KEY_ATTRIBUTE, "", "head", "Lcom/stepos/alphame/ocr/task/OcrTaskDetail;", "trace", "Lcom/stepos/alphame/ocr/OcrTrace;", "(Lcom/stepos/alphame/ocr/OcrEngine;Ljava/lang/String;Lcom/stepos/alphame/ocr/task/OcrTaskDetail;Lcom/stepos/alphame/ocr/OcrTrace;)V", "done", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getDone", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "followers", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "Lkotlin/collections/ArrayList;", "getFollowers", "()Ljava/util/ArrayList;", "getHead", "()Lcom/stepos/alphame/ocr/task/OcrTaskDetail;", "getKey", "()Ljava/lang/String;", "getTrace", "()Lcom/stepos/alphame/ocr/OcrTrace;", "forEach", "", "action", "Lkotlin/Function2;", "forEachTrace", "Lkotlin/Function1;", "snapshot", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nOcrEngine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OcrEngine.kt\ncom/stepos/alphame/ocr/OcrEngine$PendingOcr\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1157:1\n1#2:1158\n1855#3,2:1159\n1855#3,2:1161\n*S KotlinDebug\n*F\n+ 1 OcrEngine.kt\ncom/stepos/alphame/ocr/OcrEngine$PendingOcr\n*L\n679#1:1159,2\n683#1:1161,2\n*E\n"})
    public final class PendingOcr {

        @NotNull
        private final AtomicBoolean done;

        @NotNull
        private final ArrayList<Pair<OcrTaskDetail, OcrTrace>> followers;

        @NotNull
        private final OcrTaskDetail head;

        @NotNull
        private final String key;
        final /* synthetic */ OcrEngine this$0;

        @NotNull
        private final OcrTrace trace;

        public PendingOcr(@NotNull OcrEngine ocrEngine, @NotNull String key, @NotNull OcrTaskDetail head, OcrTrace trace) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(head, "head");
            Intrinsics.checkNotNullParameter(trace, "trace");
            this.this$0 = ocrEngine;
            this.key = key;
            this.head = head;
            this.trace = trace;
            this.followers = new ArrayList<>(2);
            this.done = new AtomicBoolean(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<Pair<OcrTaskDetail, OcrTrace>> snapshot() {
            List<Pair<OcrTaskDetail, OcrTrace>> listPlus;
            synchronized (this.this$0.pendingLock) {
                listPlus = CollectionsKt.plus((Collection) CollectionsKt.listOf(TuplesKt.to(this.head, this.trace)), (Iterable) this.followers);
            }
            return listPlus;
        }

        public final void forEach(@NotNull Function2<? super OcrTaskDetail, ? super OcrTrace, Unit> action) {
            Intrinsics.checkNotNullParameter(action, "action");
            for (Pair pair : snapshot()) {
                action.invoke((OcrTaskDetail) pair.component1(), (OcrTrace) pair.component2());
            }
        }

        public final void forEachTrace(@NotNull Function1<? super OcrTrace, Unit> action) {
            Intrinsics.checkNotNullParameter(action, "action");
            Iterator it = snapshot().iterator();
            while (it.hasNext()) {
                action.invoke((OcrTrace) ((Pair) it.next()).component2());
            }
        }

        @NotNull
        public final AtomicBoolean getDone() {
            return this.done;
        }

        @NotNull
        public final ArrayList<Pair<OcrTaskDetail, OcrTrace>> getFollowers() {
            return this.followers;
        }

        @NotNull
        public final OcrTaskDetail getHead() {
            return this.head;
        }

        @NotNull
        public final String getKey() {
            return this.key;
        }

        @NotNull
        public final OcrTrace getTrace() {
            return this.trace;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/alphame/ocr/OcrEngine$RecognizeOCRByBinder;", "Lcom/stepos/alphame/engine/EngineFunc;", "_owner", "Lcom/stepos/alphame/engine/EngineBase;", "(Lcom/stepos/alphame/engine/EngineBase;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RecognizeOCRByBinder extends EngineFunc {
        public RecognizeOCRByBinder(@Nullable EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_RECOGNIZE_OCR_BINDER;
            this.argsType = new byte[]{7};
            this.argsName = new String[]{"iBinder"};
            this.returnType = (byte) 0;
            this.annotation = new String[]{"把共享内存中的bitmap放到binder传过来，识别其内信息，并通过ACTION_OCR_DETECT广播返回", "@author lyl", "@param iBinder", "@return void"};
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/alphame/ocr/OcrEngine$RecognizeOCRByBinderWithVersion;", "Lcom/stepos/alphame/engine/EngineFunc;", "_owner", "Lcom/stepos/alphame/engine/EngineBase;", "(Lcom/stepos/alphame/engine/EngineBase;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RecognizeOCRByBinderWithVersion extends EngineFunc {
        public RecognizeOCRByBinderWithVersion(@Nullable EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_RECOGNIZE_OCR_BINDER_WITH_VERSION;
            this.argsType = new byte[]{7, 5};
            this.argsName = new String[]{"bitmapBinder", "contentVersion"};
            this.returnType = (byte) 0;
            this.annotation = new String[]{"把共享内存中的bitmap放到binder传过来，识别其内节点的坐标信息，并通过ACTION_OCR_DETECT广播返回", "@author liukun", "@param 图片文件的Binder，当次事务ID", "@return void"};
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/alphame/ocr/OcrEngine$RecognizeOCRByByte;", "Lcom/stepos/alphame/engine/EngineFunc;", "_owner", "Lcom/stepos/alphame/engine/EngineBase;", "(Lcom/stepos/alphame/engine/EngineBase;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RecognizeOCRByByte extends EngineFunc {
        public RecognizeOCRByByte(@Nullable EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_RECOGNIZE_OCR_BYTE;
            this.argsType = new byte[]{8};
            this.argsName = new String[]{"bitmapByte"};
            this.returnType = (byte) 6;
            this.annotation = new String[]{"根据图片的字节数组byte[]识别其内信息，并通过ACTION_OCR_DETECT广播返回", "@author lyl", "@param 图片的文件字节数组byte[]", "@return void"};
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/alphame/ocr/OcrEngine$RecognizeOCRByPath;", "Lcom/stepos/alphame/engine/EngineFunc;", "_owner", "Lcom/stepos/alphame/engine/EngineBase;", "(Lcom/stepos/alphame/engine/EngineBase;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RecognizeOCRByPath extends EngineFunc {
        public RecognizeOCRByPath(@Nullable EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_RECOGNIZE_OCR_PATH;
            this.argsType = new byte[]{6};
            this.argsName = new String[]{ParticleSystem.ATTR_BITMAP_PATH};
            this.returnType = (byte) 6;
            this.annotation = new String[]{"根据bitmap路径识别其内信息，并通过ACTION_OCR_DETECT广播返回", "@author lyl", "@param 图片文件的path", "@return void"};
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/alphame/ocr/OcrEngine$RecognizeOCRByPathExt;", "Lcom/stepos/alphame/engine/EngineFunc;", "_owner", "Lcom/stepos/alphame/engine/EngineBase;", "(Lcom/stepos/alphame/engine/EngineBase;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RecognizeOCRByPathExt extends EngineFunc {
        public RecognizeOCRByPathExt(@Nullable EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_RECOGNIZE_OCR_PATH_EXT;
            this.argsType = new byte[]{6, 7};
            this.argsName = new String[]{ParticleSystem.ATTR_BITMAP_PATH, "clientBinder"};
            this.returnType = (byte) 6;
            this.annotation = new String[]{"根据bitmap路径识别其内信息，并通过ACTION_OCR_DETECT广播返回", "@author lyl", "@param 图片文件的path", "@return String result json"};
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/alphame/ocr/OcrEngine$RecognizeOCRByPointByte;", "Lcom/stepos/alphame/engine/EngineFunc;", "_owner", "Lcom/stepos/alphame/engine/EngineBase;", "(Lcom/stepos/alphame/engine/EngineBase;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RecognizeOCRByPointByte extends EngineFunc {
        public RecognizeOCRByPointByte(@Nullable EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_RECOGNIZE_OCR_POINT_BYTE;
            this.argsType = new byte[]{8, 6};
            this.argsName = new String[]{"bitmapByte", "pointResultJson"};
            this.returnType = (byte) 6;
            this.annotation = new String[]{"根据图片的字节数组byte[]和PointResult的json字串（来自detectOCRPointByByte接口的返回数据）识别其内信息，并通过ACTION_OCR_DETECT广播返回", "@author lyl", "@param 图片的文件字节数组byte[], PointResult的json字串String", "@return void"};
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/alphame/ocr/OcrEngine$RecognizeOCRByUri;", "Lcom/stepos/alphame/engine/EngineFunc;", "_owner", "Lcom/stepos/alphame/engine/EngineBase;", "(Lcom/stepos/alphame/engine/EngineBase;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RecognizeOCRByUri extends EngineFunc {
        public RecognizeOCRByUri(@Nullable EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_RECOGNIZE_OCR_URI;
            this.argsType = new byte[]{6};
            this.argsName = new String[]{"bitmapUri"};
            this.isPublic = true;
            this.returnType = (byte) 6;
            this.annotation = new String[]{"根据bitmapUri识别其内信息，并通过ACTION_OCR_DETECT广播返回", "@author lyl", "@param 图片文件的Uri", "@return void"};
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/alphame/ocr/OcrEngine$RecognizeOCRByUriWithVersion;", "Lcom/stepos/alphame/engine/EngineFunc;", "_owner", "Lcom/stepos/alphame/engine/EngineBase;", "(Lcom/stepos/alphame/engine/EngineBase;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RecognizeOCRByUriWithVersion extends EngineFunc {
        public RecognizeOCRByUriWithVersion(@Nullable EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_RECOGNIZE_OCR_URI_WITH_VERSION;
            this.argsType = new byte[]{6, 5};
            this.argsName = new String[]{"bitmapUri", "contentVersion"};
            this.returnType = (byte) 0;
            this.annotation = new String[]{"根据bitmapUri识别其内信息，并通过ACTION_OCR_DETECT广播返回", "@author liukun", "@param 图片文件的Uri，当次事务ID", "@return void"};
        }
    }

    public OcrEngine() {
        ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new com.stepos.alphame.dailyusage.a(3));
        Intrinsics.checkNotNullExpressionValue(scheduledExecutorServiceNewSingleThreadScheduledExecutor, "newSingleThreadScheduledExecutor(...)");
        this.idleScheduler = scheduledExecutorServiceNewSingleThreadScheduledExecutor;
    }

    private final void applyConfigIfChanged() {
        boolean zBooleanValue;
        T0.a aVarResolvePowerMode = resolvePowerMode();
        int iResolveThreadNum = resolveThreadNum();
        synchronized (this.configLock) {
            if (aVarResolvePowerMode == this.appliedPower && iResolveThreadNum == this.appliedThreads) {
                return;
            }
            Log.i(OcrTrace.TAG, "config changed power=" + this.appliedPower + "->" + aVarResolvePowerMode + " threads=" + this.appliedThreads + "->" + iResolveThreadNum + ", reinit");
            this.isOcrReady = false;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            try {
                h hVar = this.ocr;
                if (hVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ocr");
                    hVar = null;
                }
                i iVarBuildConfig = buildConfig(aVarResolvePowerMode, iResolveThreadNum);
                hVar.getClass();
                Object objM31unboximpl = ((Result) J.M(new e(hVar, iVarBuildConfig, null))).getValue();
                Boolean bool = Boolean.FALSE;
                if (Result.m28isFailureimpl(objM31unboximpl)) {
                    objM31unboximpl = bool;
                }
                zBooleanValue = ((Boolean) objM31unboximpl).booleanValue();
            } catch (Throwable th) {
                Log.e(OcrTrace.TAG, "reinit failed", th);
                zBooleanValue = false;
            }
            this.isOcrReady = zBooleanValue;
            if (zBooleanValue) {
                this.isModelReleased = false;
            }
            this.appliedPower = aVarResolvePowerMode;
            this.appliedThreads = iResolveThreadNum;
            Log.i(OcrTrace.TAG, "reinit done ok=" + zBooleanValue + " power=" + aVarResolvePowerMode + " threads=" + iResolveThreadNum + " cost=" + (SystemClock.elapsedRealtime() - jElapsedRealtime) + "ms");
        }
    }

    private final i buildConfig(T0.a power, int threads) {
        T0.a cpuPowerMode = T0.a.f1792a;
        Intrinsics.checkNotNullParameter("models/ocr_v2_for_cpu", "modelPath");
        Intrinsics.checkNotNullParameter(cpuPowerMode, "cpuPowerMode");
        Intrinsics.checkNotNullParameter("ch_ppocr_mobile_v2.0_det_opt.nb", "detModelFilename");
        Intrinsics.checkNotNullParameter("ch_ppocr_mobile_v2.0_rec_opt.nb", "recModelFilename");
        Intrinsics.checkNotNullParameter("ch_ppocr_mobile_v2.0_cls_opt.nb", "clsModelFilename");
        i iVar = new i();
        iVar.f1840a = "models/ocr_v2_for_cpu";
        iVar.f1841b = "labels/ppocr_keys_v1.txt";
        iVar.f1842c = 4;
        iVar.f1843d = cpuPowerMode;
        iVar.f1844e = 0.1f;
        iVar.f1845f = 960;
        iVar.f1846g = "ch_ppocr_mobile_v2.0_det_opt.nb";
        iVar.f1847h = "ch_ppocr_mobile_v2.0_rec_opt.nb";
        iVar.f1848i = "ch_ppocr_mobile_v2.0_cls_opt.nb";
        iVar.f1849j = true;
        iVar.f1850k = true;
        iVar.f1851l = true;
        iVar.f1852m = false;
        iVar.f1853n = false;
        Intrinsics.checkNotNullParameter("models/ch_PP-OCRv4", "<set-?>");
        iVar.f1840a = "models/ch_PP-OCRv4";
        Intrinsics.checkNotNullParameter("cls.nb", "<set-?>");
        iVar.f1848i = "cls.nb";
        Intrinsics.checkNotNullParameter("det.nb", "<set-?>");
        iVar.f1846g = "det.nb";
        Intrinsics.checkNotNullParameter("rec.nb", "<set-?>");
        iVar.f1847h = "rec.nb";
        iVar.f1849j = true;
        iVar.f1850k = true;
        iVar.f1851l = true;
        Intrinsics.checkNotNullParameter(power, "<set-?>");
        iVar.f1843d = power;
        iVar.f1842c = threads;
        iVar.f1853n = false;
        return iVar;
    }

    private final void cancelIdleRelease() {
        synchronized (this.idleLock) {
            try {
                ScheduledFuture<?> scheduledFuture = this.idleRelease;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
                this.idleRelease = null;
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void dequeue(PendingOcr job) {
        synchronized (this.pendingLock) {
            this.pending.remove(job);
        }
    }

    private final PendingOcr enqueueOrMerge(OcrTaskDetail task, OcrTrace trace) {
        PendingOcr pendingOcrRemove;
        Object next;
        String strRequestKey = task.requestKey();
        synchronized (this.pendingLock) {
            try {
                Iterator<T> it = this.pending.iterator();
                while (true) {
                    pendingOcrRemove = null;
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    PendingOcr pendingOcr = (PendingOcr) next;
                    if (Intrinsics.areEqual(pendingOcr.getKey(), strRequestKey) && !pendingOcr.getDone().get()) {
                        break;
                    }
                }
                PendingOcr pendingOcr2 = (PendingOcr) next;
                if (pendingOcr2 != null) {
                    pendingOcr2.getFollowers().add(TuplesKt.to(task, trace));
                    AlphaMeLogger.debugLog("ocr merged into in-flight key=" + strRequestKey);
                    Intrinsics.checkNotNull(strRequestKey);
                    trace.markQueued(strRequestKey, this.pending.size(), true);
                    trace.markGatePassed();
                    return null;
                }
                if (this.pending.size() >= 3 && this.pending.size() > 1) {
                    pendingOcrRemove = this.pending.remove(1);
                }
                Intrinsics.checkNotNull(strRequestKey);
                PendingOcr pendingOcr3 = new PendingOcr(this, strRequestKey, task, trace);
                this.pending.addLast(pendingOcr3);
                trace.markQueued(strRequestKey, this.pending.size(), false);
                Unit unit = Unit.INSTANCE;
                PendingOcr pendingOcr4 = pendingOcrRemove;
                if (pendingOcr4 != null) {
                    AlphaMeLogger.debugLog("ocr queue full, evicted oldest waiter key=" + pendingOcr4.getKey());
                    failJob(pendingOcr4, -11, "BUSY");
                }
                return pendingOcr3;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final boolean ensureModelReady(Function0<Unit> onReloaded) {
        boolean zBooleanValue;
        if (this.isOcrReady) {
            return true;
        }
        synchronized (this.configLock) {
            try {
                if (this.isOcrReady) {
                    return true;
                }
                if (!this.isModelReleased) {
                    return false;
                }
                T0.a aVarResolvePowerMode = this.appliedPower;
                if (aVarResolvePowerMode == null) {
                    aVarResolvePowerMode = resolvePowerMode();
                }
                int i4 = this.appliedThreads;
                int iResolveThreadNum = (1 > i4 || i4 >= 17) ? resolveThreadNum() : this.appliedThreads;
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                try {
                    h hVar = this.ocr;
                    if (hVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("ocr");
                        hVar = null;
                    }
                    i iVarBuildConfig = buildConfig(aVarResolvePowerMode, iResolveThreadNum);
                    hVar.getClass();
                    Object objM31unboximpl = ((Result) J.M(new e(hVar, iVarBuildConfig, null))).getValue();
                    Boolean bool = Boolean.FALSE;
                    if (Result.m28isFailureimpl(objM31unboximpl)) {
                        objM31unboximpl = bool;
                    }
                    zBooleanValue = ((Boolean) objM31unboximpl).booleanValue();
                } catch (Throwable th) {
                    Log.e(OcrTrace.TAG, "reinit after release failed", th);
                    zBooleanValue = false;
                }
                this.isOcrReady = zBooleanValue;
                if (zBooleanValue) {
                    this.isModelReleased = false;
                }
                Log.i(OcrTrace.TAG, "reinit after release ok=" + zBooleanValue + " power=" + aVarResolvePowerMode + " threads=" + iResolveThreadNum + " cost=" + (SystemClock.elapsedRealtime() - jElapsedRealtime) + "ms");
                onReloaded.invoke();
                return zBooleanValue;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private final void failJob(PendingOcr job, int errorCode, String tag) {
        if (job.getDone().compareAndSet(false, true)) {
            for (Pair pair : job.snapshot()) {
                OcrTaskDetail ocrTaskDetail = (OcrTaskDetail) pair.component1();
                OcrTrace ocrTrace = (OcrTrace) pair.component2();
                try {
                    ocrTaskDetail.onFail(errorCode);
                    ocrTrace.dump(tag);
                } catch (Throwable th) {
                    AlphaMeLogger.debugLog("failJob notify fail=" + th);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread idleScheduler$lambda$3(Runnable runnable) {
        Thread thread = new Thread(runnable, "alphame-ocr-idle");
        thread.setDaemon(true);
        return thread;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread ocrExecutor$lambda$1(Runnable runnable) {
        Thread thread = new Thread(runnable, "alphame-ocr");
        thread.setDaemon(true);
        return thread;
    }

    private final void refreshTraceSwitch() {
        boolean z4 = SystemProperty.getBoolean(PROP_OCR_TRACE, false);
        OcrTrace.INSTANCE.setEnabled(z4);
        b.f1891s = z4;
    }

    private final void releaseModelIfQuiet(String reason) {
        try {
            this.ocrExecutor.execute(new a(this, reason, 1));
        } catch (RejectedExecutionException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void releaseModelIfQuiet$lambda$16(OcrEngine this$0, String reason) {
        boolean z4;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(reason, "$reason");
        synchronized (this$0.pendingLock) {
            z4 = !this$0.pending.isEmpty();
        }
        if (z4) {
            return;
        }
        synchronized (this$0.configLock) {
            try {
                h hVar = null;
                if (this$0.isModelReleased && !this$0.isOcrReady) {
                    h hVar2 = this$0.ocr;
                    if (hVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("ocr");
                    } else {
                        hVar = hVar2;
                    }
                    hVar.getClass();
                    OCRPredictorNative.a();
                    return;
                }
                this$0.isOcrReady = false;
                this$0.isModelReleased = true;
                try {
                    h hVar3 = this$0.ocr;
                    if (hVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("ocr");
                        hVar3 = null;
                    }
                    hVar3.getClass();
                    J.M(new f(hVar3, null));
                    OCRPredictorNative.a();
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    Log.w(OcrTrace.TAG, "releaseModel failed reason=" + reason, th);
                }
                Log.i(OcrTrace.TAG, "released OCR model, reason=" + reason);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final T0.a resolvePowerMode() {
        String str = SystemProperty.get(PROP_OCR_POWER, "");
        String upperCase = StringsKt.trim((CharSequence) (str != null ? str : "")).toString().toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        switch (upperCase.hashCode()) {
            case -1437680645:
                if (upperCase.equals("NO_BIND")) {
                    return T0.a.f1795d;
                }
                break;
            case 75572:
                if (upperCase.equals("LOW")) {
                    return T0.a.f1793b;
                }
                break;
            case 2169487:
                if (upperCase.equals("FULL")) {
                    return T0.a.f1794c;
                }
                break;
            case 2217378:
                if (upperCase.equals("HIGH")) {
                    return T0.a.f1792a;
                }
                break;
            case 1033502746:
                if (upperCase.equals("RAND_LOW")) {
                    return T0.a.f1797f;
                }
                break;
            case 1973688700:
                if (upperCase.equals("RAND_HIGH")) {
                    return T0.a.f1796e;
                }
                break;
        }
        return T0.a.f1792a;
    }

    private final int resolveThreadNum() {
        int i4 = SystemProperty.getInt(PROP_OCR_THREADS, 4);
        if (1 > i4 || i4 >= 17) {
            return 4;
        }
        return i4;
    }

    private final void runPending(final PendingOcr job) throws Throwable {
        Bitmap bitmap;
        Object objM22constructorimpl;
        h hVar;
        if (job.getDone().get()) {
            dequeue(job);
            scheduleIdleReleaseIfQuiet();
            return;
        }
        job.getTrace().markGatePassed();
        OcrDecoder decoder = job.getHead().getDecoder();
        Bitmap bitmap2 = null;
        try {
            if (!ensureModelReady(new Function0<Unit>() { // from class: com.stepos.alphame.ocr.OcrEngine$runPending$reloaded$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Iterator it = job.snapshot().iterator();
                    while (it.hasNext()) {
                        ((OcrTrace) ((Pair) it.next()).component2()).markReinit();
                    }
                }
            })) {
                Log.w(OcrTrace.TAG, "runPending model not ready key=" + job.getKey());
                failJob(job, -10, "NOT_READY");
                try {
                    decoder.release(null);
                } catch (Throwable th) {
                    AlphaMeLogger.debugLog("runPending release bitmap fail=" + th);
                }
                dequeue(job);
                scheduleIdleReleaseIfQuiet();
                return;
            }
            try {
                bitmap = decoder.decode();
            } catch (Throwable th2) {
                Log.w(OcrTrace.TAG, "runPending decode threw for key=" + job.getKey(), th2);
                bitmap = null;
            }
            try {
                if (bitmap == null) {
                    Log.w(OcrTrace.TAG, "runPending decode returned null key=" + job.getKey());
                    failJob(job, -12, "DECODE_FAIL");
                    try {
                        decoder.release(bitmap);
                    } catch (Throwable th3) {
                        AlphaMeLogger.debugLog("runPending release bitmap fail=" + th3);
                    }
                    dequeue(job);
                    scheduleIdleReleaseIfQuiet();
                    return;
                }
                Iterator it = job.snapshot().iterator();
                while (it.hasNext()) {
                    ((OcrTrace) ((Pair) it.next()).component2()).markDecoded(bitmap.getWidth(), bitmap.getHeight());
                }
                Iterator it2 = job.snapshot().iterator();
                while (it2.hasNext()) {
                    ((OcrTrace) ((Pair) it2.next()).component2()).markNativeSubmit();
                }
                try {
                    h hVar2 = this.ocr;
                    if (hVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("ocr");
                        hVar = null;
                    } else {
                        hVar = hVar2;
                    }
                    hVar.getClass();
                    Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                    objM22constructorimpl = ((Result) J.M(new g(hVar, SystemClock.elapsedRealtime(), bitmap, null))).getValue();
                } catch (Throwable th4) {
                    AlphaMeLogger.debugLog("runPending runSync fail=" + th4);
                    Result.Companion companion = Result.INSTANCE;
                    objM22constructorimpl = Result.m22constructorimpl(ResultKt.createFailure(th4));
                }
                Throwable thM25exceptionOrNullimpl = Result.m25exceptionOrNullimpl(objM22constructorimpl);
                if (thM25exceptionOrNullimpl == null) {
                    V0.a aVar = (V0.a) objM22constructorimpl;
                    Iterator it3 = job.snapshot().iterator();
                    while (it3.hasNext()) {
                        ((OcrTrace) ((Pair) it3.next()).component2()).markNativeDone(aVar.f1931d.size());
                    }
                    try {
                        succeedJob(job, OcrPaddleMapper.INSTANCE.toOcrResultJson(aVar, bitmap, job.getHead()));
                    } catch (Throwable th5) {
                        AlphaMeLogger.debugLog("runPending map fail=" + th5);
                        failJob(job, -14, "MAP_FAIL");
                    }
                } else {
                    Iterator it4 = job.snapshot().iterator();
                    while (it4.hasNext()) {
                        ((OcrTrace) ((Pair) it4.next()).component2()).markNativeDone(-1);
                    }
                    AlphaMeLogger.debugLog("runPending ocr fail=" + thM25exceptionOrNullimpl);
                    failJob(job, -13, "RUN_FAIL");
                }
                try {
                    decoder.release(bitmap);
                } catch (Throwable th6) {
                    AlphaMeLogger.debugLog("runPending release bitmap fail=" + th6);
                }
                dequeue(job);
                scheduleIdleReleaseIfQuiet();
            } catch (Throwable th7) {
                th = th7;
                bitmap2 = bitmap;
                try {
                    decoder.release(bitmap2);
                } catch (Throwable th8) {
                    AlphaMeLogger.debugLog("runPending release bitmap fail=" + th8);
                }
                dequeue(job);
                scheduleIdleReleaseIfQuiet();
                throw th;
            }
        } catch (Throwable th9) {
            th = th9;
            decoder.release(bitmap2);
            dequeue(job);
            scheduleIdleReleaseIfQuiet();
            throw th;
        }
    }

    private final void runRecognizeWithTask(OcrTaskDetail task, OcrTrace trace) {
        cancelIdleRelease();
        refreshTraceSwitch();
        applyConfigIfChanged();
        if (!this.isOcrReady && !this.isModelReleased) {
            task.onFail(-10);
            AlphaMeLogger.debugLog("runRecognizeWithTask rejected: OCR_NOT_READY");
            trace.dump("NOT_READY");
            scheduleIdleReleaseIfQuiet();
            return;
        }
        String strPreflightError = task.getDecoder().preflightError();
        if (strPreflightError != null) {
            Log.w(OcrTrace.TAG, "ocr preflight reject: ".concat(strPreflightError));
            task.onFail(-12);
            trace.dump("PREFLIGHT_FAIL");
            scheduleIdleReleaseIfQuiet();
            return;
        }
        PendingOcr pendingOcrEnqueueOrMerge = enqueueOrMerge(task, trace);
        if (pendingOcrEnqueueOrMerge == null) {
            return;
        }
        this.ocrExecutor.execute(new a(this, pendingOcrEnqueueOrMerge, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runRecognizeWithTask$lambda$17(OcrEngine this$0, PendingOcr job) throws Throwable {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(job, "$job");
        this$0.runPending(job);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void scheduleIdleReleaseIfQuiet() {
        boolean z4;
        ScheduledFuture<?> scheduledFutureSchedule;
        synchronized (this.pendingLock) {
            z4 = !this.pending.isEmpty();
        }
        if (z4) {
            return;
        }
        int i4 = SystemProperty.getInt(PROP_OCR_IDLE_MS, -1);
        long j4 = i4 == -1 ? DEFAULT_IDLE_RELEASE_MS : i4;
        if (j4 <= 0) {
            return;
        }
        synchronized (this.idleLock) {
            ScheduledFuture<?> scheduledFuture = this.idleRelease;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            try {
                scheduledFutureSchedule = this.idleScheduler.schedule(new d(17, this), j4, TimeUnit.MILLISECONDS);
            } catch (RejectedExecutionException unused) {
                scheduledFutureSchedule = null;
            }
            this.idleRelease = scheduledFutureSchedule;
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void scheduleIdleReleaseIfQuiet$lambda$13$lambda$12(OcrEngine this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.releaseModelIfQuiet("idle");
    }

    private final void succeedJob(PendingOcr job, String json) {
        if (job.getDone().compareAndSet(false, true)) {
            for (Pair pair : job.snapshot()) {
                OcrTaskDetail ocrTaskDetail = (OcrTaskDetail) pair.component1();
                OcrTrace ocrTrace = (OcrTrace) pair.component2();
                try {
                    ocrTrace.markMapped(json.length());
                    ocrTaskDetail.onFutureDone(json);
                    ocrTrace.dump("OK");
                } catch (Throwable th) {
                    AlphaMeLogger.debugLog("succeedJob notify fail=" + th);
                }
            }
        }
    }

    @NotProguard
    @Nullable
    public final String detectOCRBoundsByPath(@Nullable String filePath) {
        if (TextUtils.isEmpty(filePath)) {
            return null;
        }
        AlphaMeLogger.debugLog("detectOCRBoundsByPath not implemented, filePath=" + filePath);
        new OcrTaskBound(new OcrDecoderBounds(filePath)).onFail(-16);
        return "";
    }

    @NotProguard
    @Nullable
    public final String detectOCRByByteSync(@Nullable byte[] bitmapByte) {
        AlphaMeLogger.debugLog("detectOCRByByteSync not implemented : " + bitmapByte);
        if (bitmapByte == null) {
            return "";
        }
        new OcrTaskDetail(new OcrDecoderBytes(bitmapByte)).onFail(-16);
        return "";
    }

    @NotProguard
    public final boolean detectOCRByPath(@Nullable String filePath) {
        if (TextUtils.isEmpty(filePath)) {
            return false;
        }
        return !TextUtils.isEmpty(detectOCRBoundsByPath(filePath));
    }

    @NotProguard
    public final void detectOCRPointByBinder(@NotNull IBinder iBinder) {
        Intrinsics.checkNotNullParameter(iBinder, "iBinder");
        AlphaMeLogger.debugLog("detectOCRPointByBinder not implemented : " + iBinder);
        new OcrTaskBound(new OcrDecoderBinder(iBinder, OcrDecoderBinder.CAMERA_CODE), true).onFail(-16);
    }

    @NotProguard
    public final void detectOCRPointByByte(@Nullable byte[] bitmapByte) {
        AlphaMeLogger.debugLog("detectOCRPointByByte not implemented : " + bitmapByte);
        if (bitmapByte != null) {
            new OcrTaskBound(new OcrDecoderBytes(bitmapByte), true).onFail(-16);
        }
    }

    public final void ocrInit() {
        AlphaMeLogger.debugLog("ocr ocrInit");
    }

    @NotProguard
    public final void ocrRelease() {
        AlphaMeLogger.debugLog("ocr release");
    }

    @Override // com.stepos.alphame.engine.EngineBase
    public void onStart() {
        super.onStart();
        this.ocr = new h(BaseApplication.INSTANCE.getAppContext());
        this.isOcrReady = false;
        this.isModelReleased = false;
        Log.i(TAG, "+++++++++++++++onStart+++++++++++++++++++");
        AlphaMeLogger.debugLog("onStart");
        AlphaMeLogger.debugLog("ocr init");
        refreshTraceSwitch();
        T0.a aVarResolvePowerMode = resolvePowerMode();
        int iResolveThreadNum = resolveThreadNum();
        i iVarBuildConfig = buildConfig(aVarResolvePowerMode, iResolveThreadNum);
        Log.i(OcrTrace.TAG, "ocr config power=" + aVarResolvePowerMode + " threads=" + iResolveThreadNum);
        this.appliedPower = aVarResolvePowerMode;
        this.appliedThreads = iResolveThreadNum;
        h hVar = this.ocr;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ocr");
            hVar = null;
        }
        h hVar2 = hVar;
        W0.a callback = new W0.a() { // from class: com.stepos.alphame.ocr.OcrEngine.onStart.1
            @Override // W0.a
            public void onFail(@NotNull Throwable e4) {
                Intrinsics.checkNotNullParameter(e4, "e");
                OcrEngine.this.isOcrReady = false;
                AlphaMeLogger.debugLog("onFail: 初始化失败");
                Log.e(OcrEngine.TAG, "onFail: 初始化失败", e4);
            }

            @Override // W0.a
            public void onSuccess() {
                OcrEngine.this.isOcrReady = true;
                OcrEngine.this.scheduleIdleReleaseIfQuiet();
                AlphaMeLogger.debugLog("onSuccess: 初始化成功");
                Log.i(OcrEngine.TAG, "onSuccess: 初始化成功");
            }
        };
        hVar2.getClass();
        Intrinsics.checkNotNullParameter(callback, "callback");
        c cVar = Q.f2190b;
        d3.f fVarA = G.a(cVar);
        J.y(fVarA, cVar, new T0.d(hVar2, iVarBuildConfig, fVarA, callback, null), 2);
        EngineBase.addFunc(new OCRInit(this));
        EngineBase.addFunc(new OCRRelease(this));
        EngineBase.addFunc(new RecognizeOCRByPath(this));
        EngineBase.addFunc(new RecognizeOCRByUri(this));
        EngineBase.addFunc(new RecognizeOCRByByte(this));
        EngineBase.addFunc(new RecognizeOCRByBinder(this));
        EngineBase.addFunc(new RecognizeOCRByUriWithVersion(this));
        EngineBase.addFunc(new RecognizeOCRByBinderWithVersion(this));
        EngineBase.addFunc(new DetectOCRByPath(this));
        EngineBase.addFunc(new RecognizeOCRByPathExt(this));
        EngineBase.addFunc(new DetectOCRBoundsByPath(this));
        EngineBase.addFunc(new DetectOCRPointByByte(this));
        EngineBase.addFunc(new DetectOCRPointByBinder(this));
        EngineBase.addFunc(new RecognizeOCRByPointByte(this));
        EngineBase.addFunc(new DetectOCRPointByByteSync(this));
    }

    @Override // com.stepos.alphame.engine.EngineBase
    public void onStop() {
        ArrayList arrayList;
        super.onStop();
        AlphaMeLogger.debugLog("onStop");
        cancelIdleRelease();
        this.isOcrReady = false;
        this.isModelReleased = true;
        synchronized (this.pendingLock) {
            arrayList = new ArrayList(this.pending);
            this.pending.clear();
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            PendingOcr pendingOcr = (PendingOcr) it.next();
            Intrinsics.checkNotNull(pendingOcr);
            failJob(pendingOcr, -10, "NOT_READY");
        }
        h hVar = this.ocr;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ocr");
            hVar = null;
        }
        hVar.getClass();
        J.M(new f(hVar, null));
        OCRPredictorNative.a();
    }

    @NotProguard
    public final void recognizeOCRByBinder(@NotNull IBinder iBinder) {
        Intrinsics.checkNotNullParameter(iBinder, "iBinder");
        AlphaMeLogger.debugLog("recognizeOCRByBinder : " + iBinder);
        OcrTrace ocrTrace = new OcrTrace("byBinder");
        OcrDecoderBinder ocrDecoderBinder = new OcrDecoderBinder(iBinder, OcrDecoderBinder.CAMERA_CODE);
        ocrTrace.markDecoderReady();
        runRecognizeWithTask(new OcrTaskDetail(ocrDecoderBinder), ocrTrace);
    }

    @NotProguard
    public final void recognizeOCRByBinderWithVersion(@Nullable IBinder bitmapBinder, long contentVersion) {
        AlphaMeLogger.debugLog("recognizeOCRByBinder contentVersion: " + contentVersion);
        OcrTrace ocrTrace = new OcrTrace("byBinderVer");
        OcrDecoderBinder ocrDecoderBinder = new OcrDecoderBinder(bitmapBinder, OcrDecoderBinder.CODE);
        ocrTrace.markDecoderReady();
        runRecognizeWithTask(new OcrTaskDetail(ocrDecoderBinder, "BitmapBinder", contentVersion), ocrTrace);
    }

    @NotProguard
    public final void recognizeOCRByByte(@NotNull byte[] bitmapByte) {
        Intrinsics.checkNotNullParameter(bitmapByte, "bitmapByte");
        AlphaMeLogger.debugLog("recognizeOCRByByte : " + bitmapByte);
        OcrTrace ocrTrace = new OcrTrace("byByte");
        OcrDecoderBytes ocrDecoderBytes = new OcrDecoderBytes(bitmapByte);
        ocrTrace.markDecoderReady();
        runRecognizeWithTask(new OcrTaskDetail(ocrDecoderBytes), ocrTrace);
    }

    @NotProguard
    public final void recognizeOCRByPath(@NotNull String bitmapPath) {
        Intrinsics.checkNotNullParameter(bitmapPath, "bitmapPath");
        AlphaMeLogger.debugLog("recognizeOCRByPath bitmapPath: " + bitmapPath);
        OcrTrace ocrTrace = new OcrTrace("byPath");
        OcrDecoderPath ocrDecoderPath = new OcrDecoderPath(bitmapPath);
        ocrTrace.markDecoderReady();
        runRecognizeWithTask(new OcrTaskDetail(ocrDecoderPath, bitmapPath), ocrTrace);
    }

    @NotProguard
    public final void recognizeOCRByPathExt(@NotNull String bitmapPath, @NotNull IBinder clientBinder) {
        Intrinsics.checkNotNullParameter(bitmapPath, "bitmapPath");
        Intrinsics.checkNotNullParameter(clientBinder, "clientBinder");
        AlphaMeLogger.debugLog("recognizeOCRByPath bitmapPath: " + bitmapPath);
        OcrTrace ocrTrace = new OcrTrace("byPathExt");
        OcrDecoderPath ocrDecoderPath = new OcrDecoderPath(bitmapPath);
        ocrTrace.markDecoderReady();
        runRecognizeWithTask(new OcrTaskDetail(ocrDecoderPath, bitmapPath, clientBinder), ocrTrace);
    }

    @NotProguard
    public final void recognizeOCRByPointByte(@Nullable byte[] bitmapByte, @Nullable String pointResultJson) {
        AlphaMeLogger.debugLog("recognizeOCRByPointByte not implemented : " + bitmapByte + " , " + pointResultJson);
        if (bitmapByte == null || pointResultJson == null) {
            return;
        }
        new OcrTaskDetail(new OcrDecoderBytes(bitmapByte)).onFail(-16);
    }

    @NotProguard
    public final void recognizeOCRByUri(@NotNull String bitmapUri) {
        Intrinsics.checkNotNullParameter(bitmapUri, "bitmapUri");
        Log.e(TAG, "recognizeOCRByUri bitmapUri: " + bitmapUri);
        AlphaMeLogger.debugLog("recognizeOCRByUri bitmapUri: " + bitmapUri);
        OcrTrace ocrTrace = new OcrTrace("byUri");
        OcrDecoderUri ocrDecoderUri = new OcrDecoderUri(Uri.parse(bitmapUri));
        ocrTrace.markDecoderReady();
        OcrTaskDetail ocrTaskDetail = new OcrTaskDetail(ocrDecoderUri);
        AlphaMeLogger.debugLog("recognizeOCRByUri task: " + ocrTaskDetail);
        runRecognizeWithTask(ocrTaskDetail, ocrTrace);
    }

    @NotProguard
    public final void recognizeOCRByUriWithVersion(@NotNull String bitmapUri, long contentVersion) {
        Intrinsics.checkNotNullParameter(bitmapUri, "bitmapUri");
        AlphaMeLogger.debugLog("recognizeOCRByUriWithVersion contentVersion: " + contentVersion + " bitmapUri: " + bitmapUri);
        OcrTrace ocrTrace = new OcrTrace("byUriVer");
        OcrDecoderUri ocrDecoderUri = new OcrDecoderUri(Uri.parse(bitmapUri));
        ocrTrace.markDecoderReady();
        runRecognizeWithTask(new OcrTaskDetail(ocrDecoderUri, bitmapUri, contentVersion), ocrTrace);
    }

    @Override // com.stepos.alphame.engine.EngineBase
    public void trimMemory() {
        PoolManager.trimMemory(15);
        releaseModelIfQuiet("trimMemory");
    }

    @NotProguard
    public final void recognizeOCRByPath(@NotNull String bitmapPath, @NotNull String bitmapType, long contentVersion) {
        Intrinsics.checkNotNullParameter(bitmapPath, "bitmapPath");
        Intrinsics.checkNotNullParameter(bitmapType, "bitmapType");
        StringBuilder sb = new StringBuilder("recognizeOCRByPath bitmapPath: ");
        AbstractC0351g.C(sb, bitmapPath, " bitmapType: ", bitmapType, " contentVersion: ");
        sb.append(contentVersion);
        AlphaMeLogger.debugLog(sb.toString());
        OcrTrace ocrTrace = new OcrTrace("byPathVer");
        OcrDecoderPath ocrDecoderPath = new OcrDecoderPath(bitmapPath);
        ocrTrace.markDecoderReady();
        runRecognizeWithTask(new OcrTaskDetail(ocrDecoderPath, bitmapPath, bitmapType, contentVersion), ocrTrace);
    }
}
