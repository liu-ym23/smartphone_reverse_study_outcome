package androidx.camera.camera2.impl;

import D.C0761b0;
import J.InterfaceC0857l;
import K.InterfaceC0891n;
import Ua.C1060i;
import Ua.C1087w;
import Ua.InterfaceC1083u;
import Y8.h;
import Z8.C1172u;
import Z8.C1173v;
import android.util.Log;
import android.view.Surface;
import androidx.camera.camera2.impl.CapturePipelineImpl;
import androidx.camera.camera2.pipe.q;
import androidx.camera.camera2.pipe.t;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.l;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import e9.InterfaceC4014c;
import g3.InterfaceFutureC4095a;
import g9.C4109a;
import g9.InterfaceC4112d;
import h9.InterfaceC4149a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import o.C4984p;
import o.C4985q;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import r.C5192j;
import r.K;
import s.J;
import t.C5473b;
import t.InterfaceC5494v;
import t.InterfaceC5495w;
import t.N;
import t.y0;
import t.z0;
import w.L;
import w.M;
import w.Q;
import w.w;
import w.x;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000Ï\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\b\u0006*\u0001\u007f\b\u0007\u0018\u00002\u00020\u0001:\u0003\u0083\u0001)B_\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018JT\u0010&\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010%0$0\u00192\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020 H\u0096@¢\u0006\u0004\b&\u0010'J(\u0010)\u001a\u00020(2\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020 2\u0006\u0010\"\u001a\u00020 H\u0096@¢\u0006\u0004\b)\u0010*J\u0018\u0010,\u001a\u00020+2\u0006\u0010!\u001a\u00020 H\u0087@¢\u0006\u0004\b,\u0010-J\u0018\u0010.\u001a\u00020+2\u0006\u0010!\u001a\u00020 H\u0087@¢\u0006\u0004\b.\u0010-J\u0012\u00100\u001a\u0004\u0018\u00010/H\u0082@¢\u0006\u0004\b0\u00101JN\u00106\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010%0$0\u00192\f\u00103\u001a\b\u0012\u0004\u0012\u0002020\u00192\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020 2\u0006\u0010\"\u001a\u00020 2\b\u00105\u001a\u0004\u0018\u000104H\u0082@¢\u0006\u0004\b6\u00107JF\u00108\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010%0$0\u00192\b\u00105\u001a\u0004\u0018\u0001042\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020 2\f\u00103\u001a\b\u0012\u0004\u0012\u0002020\u0019H\u0082@¢\u0006\u0004\b8\u00109JF\u0010:\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010%0$0\u00192\b\u00105\u001a\u0004\u0018\u0001042\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020 2\f\u00103\u001a\b\u0012\u0004\u0012\u0002020\u0019H\u0082@¢\u0006\u0004\b:\u00109J>\u0010;\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010%0$0\u00192\b\u00105\u001a\u0004\u0018\u0001042\u0006\u0010!\u001a\u00020 2\f\u00103\u001a\b\u0012\u0004\u0012\u0002020\u0019H\u0082@¢\u0006\u0004\b;\u0010<JN\u0010A\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010%0$0\u00192\b\u00105\u001a\u0004\u0018\u0001042\u0006\u0010!\u001a\u00020 2\u0006\u0010>\u001a\u00020=2\f\u00103\u001a\b\u0012\u0004\u0012\u0002020\u00192\u0006\u0010@\u001a\u00020?H\u0082@¢\u0006\u0004\bA\u0010BJF\u0010C\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010%0$0\u00192\b\u00105\u001a\u0004\u0018\u0001042\u0006\u0010>\u001a\u00020=2\u0006\u0010!\u001a\u00020 2\f\u00103\u001a\b\u0012\u0004\u0012\u0002020\u0019H\u0082@¢\u0006\u0004\bC\u0010DJ>\u0010E\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010%0$0\u00192\b\u00105\u001a\u0004\u0018\u0001042\u0006\u0010!\u001a\u00020 2\f\u00103\u001a\b\u0012\u0004\u0012\u0002020\u0019H\u0082@¢\u0006\u0004\bE\u0010<J \u0010I\u001a\u00020H2\u0006\u0010F\u001a\u00020=2\u0006\u0010G\u001a\u00020?H\u0082@¢\u0006\u0004\bI\u0010JJ#\u0010L\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020?0K2\u0006\u0010G\u001a\u00020?H\u0002¢\u0006\u0004\bL\u0010MJ\u0013\u0010O\u001a\u00020N*\u00020/H\u0002¢\u0006\u0004\bO\u0010PJ\u0018\u0010Q\u001a\u00020H2\u0006\u0010>\u001a\u00020=H\u0082@¢\u0006\u0004\bQ\u0010RJ%\u0010T\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010%0$0\u00192\u0006\u0010S\u001a\u000204H\u0002¢\u0006\u0004\bT\u0010UJ\u0018\u0010V\u001a\u00020?2\u0006\u0010#\u001a\u00020 H\u0082@¢\u0006\u0004\bV\u0010-J0\u0010Z\u001a\u0004\u0018\u00010X2\u0006\u0010W\u001a\u00020=2\u0014\b\u0002\u0010Y\u001a\u000e\u0012\u0004\u0012\u00020X\u0012\u0004\u0012\u00020?0KH\u0082@¢\u0006\u0004\bZ\u0010[J\u0018\u0010\\\u001a\u00020?2\u0006\u0010\"\u001a\u00020 H\u0082@¢\u0006\u0004\b\\\u0010-R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010]R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010_R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010`R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010dR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\be\u0010fR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010hR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010jR\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bk\u0010lR\u001b\u0010q\u001a\u00020?8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bm\u0010n\u001a\u0004\bo\u0010pR#\u0010v\u001a\n r*\u0004\u0018\u00010\u00130\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bs\u0010n\u001a\u0004\bt\u0010uR\"\u0010{\u001a\u00020 8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bw\u0010x\u001a\u0004\bx\u0010y\"\u0004\b^\u0010zR\u0018\u0010~\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010}R\u0017\u0010\u0082\u0001\u001a\u00020\u007f8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001¨\u0006\u0084\u0001"}, d2 = {"Landroidx/camera/camera2/impl/CapturePipelineImpl;", "Lt/w;", "Lo/p;", "configAdapter", "Landroidx/camera/camera2/impl/FlashControl;", "flashControl", "Landroidx/camera/camera2/impl/f;", "torchControl", "Lt/z0;", "videoUsageControl", "Lt/y0;", "threads", "Lt/N;", "requestListener", "Lr/K;", "useTorchAsFlash", "Lt/v;", "cameraProperties", "LX8/a;", "Landroidx/camera/camera2/impl/UseCaseCameraState;", "useCaseCameraStateProvider", "Ls/J;", "useCaseGraphContext", "<init>", "(Lo/p;Landroidx/camera/camera2/impl/FlashControl;Landroidx/camera/camera2/impl/f;Lt/z0;Lt/y0;Lt/N;Lr/K;Lt/v;LX8/a;Ls/J;)V", "", "Landroidx/camera/core/impl/l;", "configs", "Lw/M;", "requestTemplate", "Landroidx/camera/core/impl/Config;", "sessionConfigOptions", "", "captureMode", "flashType", "flashMode", "LUa/Q;", "Ljava/lang/Void;", "c", "(Ljava/util/List;ILandroidx/camera/core/impl/Config;IIILe9/c;)Ljava/lang/Object;", "LJ/l;", Const.INTENT_KEY_APIKEY, "(IIILe9/c;)Ljava/lang/Object;", "LY8/t;", "N", "(ILe9/c;)Ljava/lang/Object;", "M", "Lw/x;", "G", "(Le9/c;)Ljava/lang/Object;", "Landroidx/camera/camera2/impl/CapturePipelineImpl$PipelineTask;", "pipelineTasks", "Landroidx/camera/camera2/impl/CapturePipelineImpl$a;", "mainCaptureParams", "L", "(Ljava/util/List;IIILandroidx/camera/camera2/impl/CapturePipelineImpl$a;Le9/c;)Ljava/lang/Object;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Landroidx/camera/camera2/impl/CapturePipelineImpl$a;IILjava/util/List;Le9/c;)Ljava/lang/Object;", "C", "D", "(Landroidx/camera/camera2/impl/CapturePipelineImpl$a;ILjava/util/List;Le9/c;)Ljava/lang/Object;", "", "timeLimitNs", "", "triggerAePreCapture", "U", "(Landroidx/camera/camera2/impl/CapturePipelineImpl$a;IJLjava/util/List;ZLe9/c;)Ljava/lang/Object;", "B", "(Landroidx/camera/camera2/impl/CapturePipelineImpl$a;JILjava/util/List;Le9/c;)Ljava/lang/Object;", "R", "convergedTimeLimitNs", "isTorchAsFlash", "Lw/N;", "Q", "(JZLe9/c;)Ljava/lang/Object;", "Lkotlin/Function1;", ExifInterface.LONGITUDE_EAST, "(Z)Lp9/l;", "LK/n;", ExifInterface.GPS_DIRECTION_TRUE, "(Lw/x;)LK/n;", ExifInterface.LONGITUDE_WEST, "(JLe9/c;)Ljava/lang/Object;", "params", ExifInterface.LATITUDE_SOUTH, "(Landroidx/camera/camera2/impl/CapturePipelineImpl$a;)Ljava/util/List;", "O", "waitTimeoutNanos", "Lw/w;", "checker", "Y", "(JLp9/l;Le9/c;)Ljava/lang/Object;", "P", "Lo/p;", Const.INTENT_KEY_PKGNAME, "Landroidx/camera/camera2/impl/FlashControl;", "Landroidx/camera/camera2/impl/f;", Const.INTENT_KEY_UMID, "Lt/z0;", "e", "Lt/y0;", "f", "Lt/N;", Const.INTENT_KEY_BACKGROUND_COMMAND, "Lr/K;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "LX8/a;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Ls/J;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "LY8/h;", "H", "()Z", "hasFlashUnit", "kotlin.jvm.PlatformType", "k", "J", "()Landroidx/camera/camera2/impl/UseCaseCameraState;", "useCaseCameraState", "l", "I", "()I", "(I)V", M5.e.FAIL_TEMPLATE, "m", "Lw/x;", "frameMetadata", "androidx/camera/camera2/impl/CapturePipelineImpl$b", "n", "Landroidx/camera/camera2/impl/CapturePipelineImpl$b;", "emptyRequestMetadata", "PipelineTask", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CapturePipelineImpl implements InterfaceC5495w {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final C4984p configAdapter;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final FlashControl flashControl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final f torchControl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final z0 videoUsageControl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final y0 threads;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final N requestListener;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final K useTorchAsFlash;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final X8.a<UseCaseCameraState> useCaseCameraStateProvider;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final J useCaseGraphContext;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final h hasFlashUnit;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public final h useCaseCameraState;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public int template;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public x frameMetadata;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public final b emptyRequestMetadata;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/camera/camera2/impl/CapturePipelineImpl$PipelineTask;", "", "<init>", "(Ljava/lang/String;I)V", "PRE_CAPTURE", "MAIN_CAPTURE", "POST_CAPTURE", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PipelineTask {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ PipelineTask[] $VALUES;
        public static final PipelineTask PRE_CAPTURE = new PipelineTask("PRE_CAPTURE", 0);
        public static final PipelineTask MAIN_CAPTURE = new PipelineTask("MAIN_CAPTURE", 1);
        public static final PipelineTask POST_CAPTURE = new PipelineTask("POST_CAPTURE", 2);

        private static final /* synthetic */ PipelineTask[] $values() {
            return new PipelineTask[]{PRE_CAPTURE, MAIN_CAPTURE, POST_CAPTURE};
        }

        static {
            PipelineTask[] pipelineTaskArr$values = $values();
            $VALUES = pipelineTaskArr$values;
            $ENTRIES = kotlin.enums.a.a(pipelineTaskArr$values);
        }

        private PipelineTask(String str, int i10) {
        }

        public static InterfaceC4149a<PipelineTask> getEntries() {
            return $ENTRIES;
        }

        public static PipelineTask valueOf(String str) {
            return (PipelineTask) Enum.valueOf(PipelineTask.class, str);
        }

        public static PipelineTask[] values() {
            return (PipelineTask[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0082\b\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u0010R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001a\u0010\u001c¨\u0006\u001d"}, d2 = {"Landroidx/camera/camera2/impl/CapturePipelineImpl$a;", "", "", "Landroidx/camera/core/impl/l;", "configs", "Lw/M;", "requestTemplate", "Landroidx/camera/core/impl/Config;", "sessionConfigOptions", "<init>", "(Ljava/util/List;ILandroidx/camera/core/impl/Config;Lkotlin/jvm/internal/i;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/util/List;", "()Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "I", "c", "Landroidx/camera/core/impl/Config;", "()Landroidx/camera/core/impl/Config;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.impl.CapturePipelineImpl$a, reason: from toString */
    public static final /* data */ class MainCaptureParams {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final List<l> configs;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final int requestTemplate;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final Config sessionConfigOptions;

        public /* synthetic */ MainCaptureParams(List list, int i10, Config config, i iVar) {
            this(list, i10, config);
        }

        public final List<l> a() {
            return this.configs;
        }

        /* renamed from: b, reason: from getter */
        public final int getRequestTemplate() {
            return this.requestTemplate;
        }

        /* renamed from: c, reason: from getter */
        public final Config getSessionConfigOptions() {
            return this.sessionConfigOptions;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MainCaptureParams)) {
                return false;
            }
            MainCaptureParams mainCaptureParams = (MainCaptureParams) other;
            return p.d(this.configs, mainCaptureParams.configs) && M.d(this.requestTemplate, mainCaptureParams.requestTemplate) && p.d(this.sessionConfigOptions, mainCaptureParams.sessionConfigOptions);
        }

        public int hashCode() {
            return (((this.configs.hashCode() * 31) + M.f(this.requestTemplate)) * 31) + this.sessionConfigOptions.hashCode();
        }

        public String toString() {
            return "MainCaptureParams(configs=" + this.configs + ", requestTemplate=" + ((Object) M.g(this.requestTemplate)) + ", sessionConfigOptions=" + this.sessionConfigOptions + ')';
        }

        public MainCaptureParams(List<l> configs, int i10, Config sessionConfigOptions) {
            p.i(configs, "configs");
            p.i(sessionConfigOptions, "sessionConfigOptions");
            this.configs = configs;
            this.requestTemplate = i10;
            this.sessionConfigOptions = sessionConfigOptions;
        }
    }

    @Metadata(d1 = {"\u0000O\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\b\u0010\tJ)\u0010\r\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0002*\u00020\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0013\u001a\u00020\u000f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R&\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00148\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010 \u001a\u00020\u001c8\u0016X\u0096D¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010%\u001a\u00020!8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010\"\u001a\u0004\b#\u0010$R\u001a\u0010+\u001a\u00020&8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*¨\u0006,"}, d2 = {"androidx/camera/camera2/impl/CapturePipelineImpl$b", "Lw/K;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/camera/camera2/pipe/q$a;", "key", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/camera2/pipe/q$a;)Ljava/lang/Object;", "default", "c", "(Landroidx/camera/camera2/pipe/q$a;Ljava/lang/Object;)Ljava/lang/Object;", "", "Lw9/d;", "type", "R0", "(Lw9/d;)Ljava/lang/Object;", "Lw/M;", "I", "getTemplate-fGx8uWA", "()I", M5.e.FAIL_TEMPLATE, "", "Lw/Q;", "Landroid/view/Surface;", Const.INTENT_KEY_PKGNAME, "Ljava/util/Map;", Const.INTENT_KEY_UMID, "()Ljava/util/Map;", "streams", "", "Z", "l", "()Z", "repeating", "Landroidx/camera/camera2/pipe/t;", "Landroidx/camera/camera2/pipe/t;", "getRequest", "()Landroidx/camera/camera2/pipe/t;", "request", "Lw/L;", "e", "J", "k0", "()J", "requestNumber", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b implements w.K {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final int template = M.b(0);

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final Map<Q, Surface> streams = kotlin.collections.a.i();

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final boolean repeating = true;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public final t request = new t(C1173v.m(), null, null, null, null, null, 62, null);

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public final long requestNumber = L.b(0);

        @Override // w.U
        public <T> T R0(InterfaceC5745d<T> type) {
            p.i(type, "type");
            return null;
        }

        @Override // androidx.camera.camera2.pipe.q
        public <T> T a(q.a<T> key) {
            p.i(key, "key");
            return null;
        }

        @Override // androidx.camera.camera2.pipe.q
        public <T> T c(q.a<T> key, T t10) {
            p.i(key, "key");
            return t10;
        }

        @Override // w.K
        public Map<Q, Surface> d() {
            return this.streams;
        }

        @Override // w.K
        public t getRequest() {
            return this.request;
        }

        @Override // w.K
        /* renamed from: k0, reason: from getter */
        public long getRequestNumber() {
            return this.requestNumber;
        }

        @Override // w.K
        /* renamed from: l, reason: from getter */
        public boolean getRepeating() {
            return this.repeating;
        }
    }

    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"androidx/camera/camera2/impl/CapturePipelineImpl$c", "Landroidx/camera/camera2/pipe/t$a;", "Landroidx/camera/camera2/pipe/t;", "request", "LY8/t;", "G", "(Landroidx/camera/camera2/pipe/t;)V", "Lw/K;", "requestMetadata", "Lw/y;", "frameNumber", "Lw/w;", "totalCaptureResult", "N0", "(Lw/K;JLw/w;)V", "Lw/J;", "requestFailure", "Y", "(Lw/K;JLw/J;)V", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c implements t.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC1083u<Void> f9610a;

        public c(InterfaceC1083u<Void> interfaceC1083u) {
            this.f9610a = interfaceC1083u;
        }

        @Override // androidx.camera.camera2.pipe.t.a
        public void G(t request) {
            p.i(request, "request");
            this.f9610a.e(new ImageCaptureException(3, "Capture request is cancelled because camera is closed", null));
        }

        @Override // androidx.camera.camera2.pipe.t.a
        public void N0(w.K requestMetadata, long frameNumber, w totalCaptureResult) {
            p.i(requestMetadata, "requestMetadata");
            p.i(totalCaptureResult, "totalCaptureResult");
            this.f9610a.complete(null);
        }

        @Override // androidx.camera.camera2.pipe.t.a
        public void Y(w.K requestMetadata, long frameNumber, w.J requestFailure) {
            p.i(requestMetadata, "requestMetadata");
            p.i(requestFailure, "requestFailure");
            this.f9610a.e(new ImageCaptureException(2, "Capture request failed with reason " + requestFailure.getReason(), null));
        }
    }

    @Metadata(d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\u0006\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001a\u0010\u000f\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\u00108\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u001b\u001a\u00020\u00168\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010!\u001a\u00020\u001c8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"androidx/camera/camera2/impl/CapturePipelineImpl$d", "Lw/w;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lw9/d;", "type", "R0", "(Lw9/d;)Ljava/lang/Object;", "Lw/x;", Const.INTENT_KEY_APIKEY, "Lw/x;", "frameMetadata", Const.INTENT_KEY_PKGNAME, "getMetadata", "()Lw/x;", "metadata", "Lw/n;", "c", "Ljava/lang/String;", "getCamera-Dz_R5H8", "()Ljava/lang/String;", C3081a.CAMERA_FOCUS, "Lw/y;", Const.INTENT_KEY_UMID, "J", "getFrameNumber-Ugla2oM", "()J", "frameNumber", "Lw/K;", "e", "Lw/K;", "getRequestMetadata", "()Lw/K;", "requestMetadata", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class d implements w {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final x frameMetadata;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final x metadata;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final String camera;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public final long frameNumber;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public final w.K requestMetadata;

        public d(x xVar, CapturePipelineImpl capturePipelineImpl) {
            this.frameMetadata = xVar;
            this.metadata = xVar;
            this.camera = xVar.getCamera();
            this.frameNumber = xVar.m1();
            this.requestMetadata = capturePipelineImpl.emptyRequestMetadata;
        }

        @Override // w.U
        public <T> T R0(InterfaceC5745d<T> type) {
            p.i(type, "type");
            return null;
        }

        @Override // w.w
        public x getMetadata() {
            return this.metadata;
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class e implements InterfaceC5074l<w, Boolean> {
        public e() {
        }

        @Override // p9.InterfaceC5074l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(w it) {
            p.i(it, "it");
            return Boolean.valueOf(K.Q.a(CapturePipelineImpl.this.T(it.getMetadata()), true));
        }
    }

    public CapturePipelineImpl(C4984p configAdapter, FlashControl flashControl, f torchControl, z0 videoUsageControl, y0 threads, N requestListener, K useTorchAsFlash, final InterfaceC5494v cameraProperties, X8.a<UseCaseCameraState> useCaseCameraStateProvider, J useCaseGraphContext) {
        p.i(configAdapter, "configAdapter");
        p.i(flashControl, "flashControl");
        p.i(torchControl, "torchControl");
        p.i(videoUsageControl, "videoUsageControl");
        p.i(threads, "threads");
        p.i(requestListener, "requestListener");
        p.i(useTorchAsFlash, "useTorchAsFlash");
        p.i(cameraProperties, "cameraProperties");
        p.i(useCaseCameraStateProvider, "useCaseCameraStateProvider");
        p.i(useCaseGraphContext, "useCaseGraphContext");
        this.configAdapter = configAdapter;
        this.flashControl = flashControl;
        this.torchControl = torchControl;
        this.videoUsageControl = videoUsageControl;
        this.threads = threads;
        this.requestListener = requestListener;
        this.useTorchAsFlash = useTorchAsFlash;
        this.useCaseCameraStateProvider = useCaseCameraStateProvider;
        this.useCaseGraphContext = useCaseGraphContext;
        this.hasFlashUnit = C4848b.b(new InterfaceC5063a() { // from class: t.y
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Boolean.valueOf(CapturePipelineImpl.K(cameraProperties));
            }
        });
        this.useCaseCameraState = C4848b.b(new InterfaceC5063a() { // from class: t.z
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return CapturePipelineImpl.X(this.f41971a);
            }
        });
        this.template = 1;
        this.emptyRequestMetadata = new b();
    }

    public static final boolean F(CapturePipelineImpl capturePipelineImpl, boolean z10, x frameMetadata) {
        p.i(frameMetadata, "frameMetadata");
        return K.Q.a(capturePipelineImpl.T(frameMetadata), z10);
    }

    public static final boolean K(InterfaceC5494v interfaceC5494v) {
        return C5192j.b(interfaceC5494v, false, 1, null);
    }

    public static final UseCaseCameraState X(CapturePipelineImpl capturePipelineImpl) {
        return capturePipelineImpl.useCaseCameraStateProvider.get();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object Z(CapturePipelineImpl capturePipelineImpl, long j10, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: t.x
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return Boolean.valueOf(CapturePipelineImpl.a0((w.w) obj2));
                }
            };
        }
        return capturePipelineImpl.Y(j10, interfaceC5074l, interfaceC4014c);
    }

    public static final boolean a0(w wVar) {
        p.i(wVar, "<unused var>");
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0186 A[Catch: all -> 0x004c, TryCatch #3 {all -> 0x004c, blocks: (B:15:0x0047, B:68:0x017e, B:70:0x0186, B:71:0x018f), top: B:108:0x0047 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object B(androidx.camera.camera2.impl.CapturePipelineImpl.MainCaptureParams r22, long r23, int r25, java.util.List<? extends androidx.camera.camera2.impl.CapturePipelineImpl.PipelineTask> r26, e9.InterfaceC4014c<? super java.util.List<? extends Ua.Q<java.lang.Void>>> r27) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 544
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.impl.CapturePipelineImpl.B(androidx.camera.camera2.impl.CapturePipelineImpl$a, long, int, java.util.List, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object C(androidx.camera.camera2.impl.CapturePipelineImpl.MainCaptureParams r9, int r10, int r11, java.util.List<? extends androidx.camera.camera2.impl.CapturePipelineImpl.PipelineTask> r12, e9.InterfaceC4014c<? super java.util.List<? extends Ua.Q<java.lang.Void>>> r13) throws java.lang.Exception {
        /*
            r8 = this;
            boolean r0 = r13 instanceof androidx.camera.camera2.impl.CapturePipelineImpl$defaultCapture$1
            if (r0 == 0) goto L14
            r0 = r13
            androidx.camera.camera2.impl.CapturePipelineImpl$defaultCapture$1 r0 = (androidx.camera.camera2.impl.CapturePipelineImpl$defaultCapture$1) r0
            int r1 = r0.f9621f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f9621f = r1
        L12:
            r7 = r0
            goto L1a
        L14:
            androidx.camera.camera2.impl.CapturePipelineImpl$defaultCapture$1 r0 = new androidx.camera.camera2.impl.CapturePipelineImpl$defaultCapture$1
            r0.<init>(r8, r13)
            goto L12
        L1a:
            java.lang.Object r13 = r7.f9619d
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r7.f9621f
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L56
            if (r1 == r5) goto L44
            if (r1 == r4) goto L40
            if (r1 == r3) goto L3c
            if (r1 != r2) goto L34
            kotlin.C4849c.b(r13)
            return r13
        L34:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3c:
            kotlin.C4849c.b(r13)
            return r13
        L40:
            kotlin.C4849c.b(r13)
            return r13
        L44:
            int r10 = r7.f9618c
            java.lang.Object r9 = r7.f9617b
            r12 = r9
            java.util.List r12 = (java.util.List) r12
            java.lang.Object r9 = r7.f9616a
            androidx.camera.camera2.impl.CapturePipelineImpl$a r9 = (androidx.camera.camera2.impl.CapturePipelineImpl.MainCaptureParams) r9
            kotlin.C4849c.b(r13)
        L52:
            r2 = r9
            r5 = r10
            r6 = r12
            goto L6e
        L56:
            kotlin.C4849c.b(r13)
            boolean r13 = r8.H()
            if (r13 == 0) goto La3
            r7.f9616a = r9
            r7.f9617b = r12
            r7.f9618c = r10
            r7.f9621f = r5
            java.lang.Object r13 = r8.O(r11, r7)
            if (r13 != r0) goto L52
            goto Lac
        L6e:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r9 = r13.booleanValue()
            if (r9 == 0) goto L7b
            long r10 = t.C5467B.b()
            goto L7f
        L7b:
            long r10 = t.C5467B.a()
        L7f:
            r12 = 0
            if (r9 != 0) goto L93
            if (r5 != 0) goto L85
            goto L93
        L85:
            r7.f9616a = r12
            r7.f9617b = r12
            r7.f9621f = r3
            java.lang.Object r8 = r8.D(r2, r5, r6, r7)
            if (r8 != r0) goto L92
            goto Lac
        L92:
            return r8
        L93:
            r7.f9616a = r12
            r7.f9617b = r12
            r7.f9621f = r4
            r1 = r8
            r3 = r10
            java.lang.Object r8 = r1.B(r2, r3, r5, r6, r7)
            if (r8 != r0) goto La2
            goto Lac
        La2:
            return r8
        La3:
            r1 = r8
            r7.f9621f = r2
            java.lang.Object r8 = r1.D(r9, r10, r12, r7)
            if (r8 != r0) goto Lad
        Lac:
            return r0
        Lad:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.impl.CapturePipelineImpl.C(androidx.camera.camera2.impl.CapturePipelineImpl$a, int, int, java.util.List, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object D(androidx.camera.camera2.impl.CapturePipelineImpl.MainCaptureParams r17, int r18, java.util.List<? extends androidx.camera.camera2.impl.CapturePipelineImpl.PipelineTask> r19, e9.InterfaceC4014c<? super java.util.List<? extends Ua.Q<java.lang.Void>>> r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 329
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.impl.CapturePipelineImpl.D(androidx.camera.camera2.impl.CapturePipelineImpl$a, int, java.util.List, e9.c):java.lang.Object");
    }

    public final InterfaceC5074l<x, Boolean> E(final boolean isTorchAsFlash) {
        return new InterfaceC5074l() { // from class: t.A
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(CapturePipelineImpl.F(this.f41787a, isTorchAsFlash, (w.x) obj));
            }
        };
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object G(e9.InterfaceC4014c<? super w.x> r10) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r10 instanceof androidx.camera.camera2.impl.CapturePipelineImpl$getFrameMetadata$1
            if (r0 == 0) goto L14
            r0 = r10
            androidx.camera.camera2.impl.CapturePipelineImpl$getFrameMetadata$1 r0 = (androidx.camera.camera2.impl.CapturePipelineImpl$getFrameMetadata$1) r0
            int r1 = r0.f9637d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f9637d = r1
        L12:
            r5 = r0
            goto L1a
        L14:
            androidx.camera.camera2.impl.CapturePipelineImpl$getFrameMetadata$1 r0 = new androidx.camera.camera2.impl.CapturePipelineImpl$getFrameMetadata$1
            r0.<init>(r9, r10)
            goto L12
        L1a:
            java.lang.Object r10 = r5.f9635b
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r5.f9637d
            java.lang.String r8 = "CXCP"
            r2 = 1
            if (r1 == 0) goto L3a
            if (r1 != r2) goto L32
            java.lang.Object r0 = r5.f9634a
            androidx.camera.camera2.impl.CapturePipelineImpl r0 = (androidx.camera.camera2.impl.CapturePipelineImpl) r0
            kotlin.C4849c.b(r10)
            r1 = r9
            goto L67
        L32:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3a:
            kotlin.C4849c.b(r10)
            w.x r10 = r9.frameMetadata
            if (r10 != 0) goto L74
            t.b r10 = t.C5473b.f41865a
            boolean r10 = D.C0761b0.f(r8)
            if (r10 == 0) goto L52
            java.lang.String r10 = t.C5473b.a()
            java.lang.String r1 = "getFrameMetadata: waiting for result"
            android.util.Log.d(r10, r1)
        L52:
            r10 = r2
            long r2 = t.C5467B.d()
            r5.f9634a = r9
            r5.f9637d = r10
            r4 = 0
            r6 = 2
            r7 = 0
            r1 = r9
            java.lang.Object r10 = Z(r1, r2, r4, r5, r6, r7)
            if (r10 != r0) goto L66
            return r0
        L66:
            r0 = r1
        L67:
            w.w r10 = (w.w) r10
            if (r10 == 0) goto L70
            w.x r9 = r10.getMetadata()
            goto L71
        L70:
            r9 = 0
        L71:
            r0.frameMetadata = r9
            goto L75
        L74:
            r1 = r9
        L75:
            t.b r9 = t.C5473b.f41865a
            boolean r9 = D.C0761b0.f(r8)
            if (r9 == 0) goto L99
            java.lang.String r9 = t.C5473b.a()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = "getFrameMetadata: frameMetadata = "
            r10.append(r0)
            w.x r0 = m(r1)
            r10.append(r0)
            java.lang.String r10 = r10.toString()
            android.util.Log.d(r9, r10)
        L99:
            w.x r9 = r1.frameMetadata
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.impl.CapturePipelineImpl.G(e9.c):java.lang.Object");
    }

    public final boolean H() {
        return ((Boolean) this.hasFlashUnit.getValue()).booleanValue();
    }

    /* renamed from: I, reason: from getter */
    public int getTemplate() {
        return this.template;
    }

    public final UseCaseCameraState J() {
        return (UseCaseCameraState) this.useCaseCameraState.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object L(java.util.List<? extends androidx.camera.camera2.impl.CapturePipelineImpl.PipelineTask> r10, int r11, int r12, int r13, androidx.camera.camera2.impl.CapturePipelineImpl.MainCaptureParams r14, e9.InterfaceC4014c<? super java.util.List<? extends Ua.Q<java.lang.Void>>> r15) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.impl.CapturePipelineImpl.L(java.util.List, int, int, int, androidx.camera.camera2.impl.CapturePipelineImpl$a, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x008e A[Catch: all -> 0x0098, TryCatch #1 {all -> 0x0098, blocks: (B:33:0x0083, B:35:0x008e, B:41:0x00a1), top: B:57:0x0083 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b5 A[Catch: all -> 0x0036, TryCatch #0 {all -> 0x0036, blocks: (B:14:0x0031, B:45:0x00ad, B:47:0x00b5, B:48:0x00be), top: B:55:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object M(int r9, e9.InterfaceC4014c<? super Y8.t> r10) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 205
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.impl.CapturePipelineImpl.M(int, e9.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00bf, code lost:
    
        if (r15 != r0) goto L51;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008c A[Catch: all -> 0x0096, TryCatch #0 {all -> 0x0096, blocks: (B:35:0x0081, B:37:0x008c, B:40:0x009c, B:44:0x00a4), top: B:61:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v11, types: [java.lang.AutoCloseable] */
    /* JADX WARN: Type inference failed for: r13v19 */
    /* JADX WARN: Type inference failed for: r13v20 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object N(int r14, e9.InterfaceC4014c<? super Y8.t> r15) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.impl.CapturePipelineImpl.N(int, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object O(int r6, e9.InterfaceC4014c<? super java.lang.Boolean> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof androidx.camera.camera2.impl.CapturePipelineImpl$isPhysicalFlashRequired$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.camera.camera2.impl.CapturePipelineImpl$isPhysicalFlashRequired$1 r0 = (androidx.camera.camera2.impl.CapturePipelineImpl$isPhysicalFlashRequired$1) r0
            int r1 = r0.f9657c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f9657c = r1
            goto L18
        L13:
            androidx.camera.camera2.impl.CapturePipelineImpl$isPhysicalFlashRequired$1 r0 = new androidx.camera.camera2.impl.CapturePipelineImpl$isPhysicalFlashRequired$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f9655a
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f9657c
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L32
            if (r2 != r4) goto L2a
            kotlin.C4849c.b(r7)
            goto L51
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlin.C4849c.b(r7)
            if (r6 == 0) goto L48
            if (r6 == r4) goto L46
            r5 = 2
            if (r6 == r5) goto L6d
            r5 = 3
            if (r6 != r5) goto L40
            goto L6d
        L40:
            java.lang.AssertionError r5 = new java.lang.AssertionError
            r5.<init>(r6)
            throw r5
        L46:
            r3 = r4
            goto L6d
        L48:
            r0.f9657c = r4
            java.lang.Object r7 = r5.G(r0)
            if (r7 != r1) goto L51
            return r1
        L51:
            w.x r7 = (w.x) r7
            if (r7 == 0) goto L6d
            android.hardware.camera2.CaptureResult$Key r5 = android.hardware.camera2.CaptureResult.CONTROL_AE_STATE
            java.lang.String r6 = "CONTROL_AE_STATE"
            kotlin.jvm.internal.p.h(r5, r6)
            java.lang.Object r5 = r7.U(r5)
            java.lang.Integer r5 = (java.lang.Integer) r5
            if (r5 != 0) goto L65
            goto L6d
        L65:
            int r5 = r5.intValue()
            r6 = 4
            if (r5 != r6) goto L6d
            goto L46
        L6d:
            java.lang.Boolean r5 = g9.C4109a.a(r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.impl.CapturePipelineImpl.O(int, e9.c):java.lang.Object");
    }

    public final Object P(int i10, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return (getTemplate() == 3 || i10 == 1) ? C4109a.a(true) : this.useTorchAsFlash.b(new CapturePipelineImpl$isTorchAsFlash$2(this, null), interfaceC4014c);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00d2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object Q(long r26, boolean r28, e9.InterfaceC4014c<? super w.Result3A> r29) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 225
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.impl.CapturePipelineImpl.Q(long, boolean, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object R(androidx.camera.camera2.impl.CapturePipelineImpl.MainCaptureParams r9, int r10, java.util.List<? extends androidx.camera.camera2.impl.CapturePipelineImpl.PipelineTask> r11, e9.InterfaceC4014c<? super java.util.List<? extends Ua.Q<java.lang.Void>>> r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.impl.CapturePipelineImpl.R(androidx.camera.camera2.impl.CapturePipelineImpl$a, int, java.util.List, e9.c):java.lang.Object");
    }

    public final List<Ua.Q<Void>> S(MainCaptureParams params) {
        C5473b c5473b = C5473b.f41865a;
        if (C0761b0.f("CXCP")) {
            Log.d(C5473b.TRUNCATED_TAG, "CapturePipeline#submitRequestInternal; Submitting " + params.a() + " with CameraPipe");
        }
        ArrayList arrayList = new ArrayList();
        List<l> listA = params.a();
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = listA.iterator();
        while (true) {
            t tVarD = null;
            if (!it.hasNext()) {
                break;
            }
            l lVar = (l) it.next();
            InterfaceC1083u interfaceC1083uC = C1087w.c(null, 1, null);
            arrayList.add(interfaceC1083uC);
            try {
                tVarD = this.configAdapter.d(lVar, params.getRequestTemplate(), params.getSessionConfigOptions(), C1172u.e(new c(interfaceC1083uC)));
            } catch (IllegalStateException e10) {
                C5473b c5473b2 = C5473b.f41865a;
                if (C0761b0.h("CXCP")) {
                    Log.i(C5473b.TRUNCATED_TAG, "CapturePipeline#submitRequestInternal: configAdapter.mapToRequest failed!", e10);
                }
                interfaceC1083uC.e(new ImageCaptureException(2, "Capture request failed with reason " + e10.getMessage(), e10));
            }
            if (tVarD != null) {
                arrayList2.add(tVarD);
            }
        }
        if (arrayList2.isEmpty()) {
            return arrayList;
        }
        C1060i.d(this.threads.getSequentialScope(), null, null, new CapturePipelineImpl$submitRequestInternal$$inlined$confineLaunch$1(null, this, arrayList, arrayList2), 3, null);
        return arrayList;
    }

    public final InterfaceC0891n T(x xVar) {
        return new C4985q(this.emptyRequestMetadata, xVar.m1(), new d(xVar, this), null);
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x036f  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02b4  */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v35, types: [java.lang.AutoCloseable] */
    /* JADX WARN: Type inference failed for: r7v49 */
    /* JADX WARN: Type inference failed for: r7v50 */
    /* JADX WARN: Type inference failed for: r7v51 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object U(androidx.camera.camera2.impl.CapturePipelineImpl.MainCaptureParams r26, int r27, long r28, java.util.List<? extends androidx.camera.camera2.impl.CapturePipelineImpl.PipelineTask> r30, boolean r31, e9.InterfaceC4014c<? super java.util.List<? extends Ua.Q<java.lang.Void>>> r32) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 1002
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.impl.CapturePipelineImpl.U(androidx.camera.camera2.impl.CapturePipelineImpl$a, int, long, java.util.List, boolean, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00bc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00bd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object V(androidx.camera.camera2.impl.CapturePipelineImpl.MainCaptureParams r10, int r11, int r12, java.util.List<? extends androidx.camera.camera2.impl.CapturePipelineImpl.PipelineTask> r13, e9.InterfaceC4014c<? super java.util.List<? extends Ua.Q<java.lang.Void>>> r14) throws java.lang.Exception {
        /*
            r9 = this;
            boolean r0 = r14 instanceof androidx.camera.camera2.impl.CapturePipelineImpl$torchAsFlashCapture$1
            if (r0 == 0) goto L14
            r0 = r14
            androidx.camera.camera2.impl.CapturePipelineImpl$torchAsFlashCapture$1 r0 = (androidx.camera.camera2.impl.CapturePipelineImpl$torchAsFlashCapture$1) r0
            int r1 = r0.f9690f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f9690f = r1
        L12:
            r8 = r0
            goto L1a
        L14:
            androidx.camera.camera2.impl.CapturePipelineImpl$torchAsFlashCapture$1 r0 = new androidx.camera.camera2.impl.CapturePipelineImpl$torchAsFlashCapture$1
            r0.<init>(r9, r14)
            goto L12
        L1a:
            java.lang.Object r14 = r8.f9688d
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r8.f9690f
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L4e
            if (r1 == r4) goto L3e
            if (r1 == r3) goto L3a
            if (r1 != r2) goto L32
            kotlin.C4849c.b(r14)
            return r14
        L32:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3a:
            kotlin.C4849c.b(r14)
            return r14
        L3e:
            int r11 = r8.f9687c
            java.lang.Object r10 = r8.f9686b
            r13 = r10
            java.util.List r13 = (java.util.List) r13
            java.lang.Object r10 = r8.f9685a
            androidx.camera.camera2.impl.CapturePipelineImpl$a r10 = (androidx.camera.camera2.impl.CapturePipelineImpl.MainCaptureParams) r10
            kotlin.C4849c.b(r14)
        L4c:
            r6 = r13
            goto L79
        L4e:
            kotlin.C4849c.b(r14)
            t.b r14 = t.C5473b.f41865a
            java.lang.String r14 = "CXCP"
            boolean r14 = D.C0761b0.f(r14)
            if (r14 == 0) goto L64
            java.lang.String r14 = t.C5473b.a()
            java.lang.String r1 = "CapturePipeline#torchAsFlashCapture"
            android.util.Log.d(r14, r1)
        L64:
            boolean r14 = r9.H()
            if (r14 == 0) goto Lae
            r8.f9685a = r10
            r8.f9686b = r13
            r8.f9687c = r11
            r8.f9690f = r4
            java.lang.Object r14 = r9.O(r12, r8)
            if (r14 != r0) goto L4c
            goto Lbc
        L79:
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            boolean r12 = r14.booleanValue()
            if (r12 == 0) goto Lac
            r12 = r4
            r14 = r5
            long r4 = t.C5467B.b()
            r.K r13 = r9.useTorchAsFlash
            boolean r13 = r13.a()
            if (r13 != 0) goto L99
            t.z0 r13 = r9.videoUsageControl
            boolean r13 = r13.a()
            if (r13 != 0) goto L99
        L97:
            r7 = r12
            goto L9b
        L99:
            r12 = 0
            goto L97
        L9b:
            r8.f9685a = r14
            r8.f9686b = r14
            r8.f9690f = r3
            r1 = r9
            r2 = r10
            r3 = r11
            java.lang.Object r9 = r1.U(r2, r3, r4, r6, r7, r8)
            if (r9 != r0) goto Lab
            goto Lbc
        Lab:
            return r9
        Lac:
            r3 = r11
            r13 = r6
        Lae:
            r1 = r9
            r14 = r5
            r8.f9685a = r14
            r8.f9686b = r14
            r8.f9690f = r2
            java.lang.Object r9 = r1.D(r10, r11, r13, r8)
            if (r9 != r0) goto Lbd
        Lbc:
            return r0
        Lbd:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.impl.CapturePipelineImpl.V(androidx.camera.camera2.impl.CapturePipelineImpl$a, int, int, java.util.List, e9.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /* JADX WARN: Type inference failed for: r14v0, types: [androidx.camera.camera2.impl.CapturePipelineImpl] */
    /* JADX WARN: Type inference failed for: r14v1, types: [java.lang.AutoCloseable] */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v6, types: [java.lang.AutoCloseable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object W(long r15, e9.InterfaceC4014c<? super w.Result3A> r17) throws java.lang.Exception {
        /*
            r14 = this;
            r0 = r17
            boolean r1 = r0 instanceof androidx.camera.camera2.impl.CapturePipelineImpl$unlockAf$1
            if (r1 == 0) goto L16
            r1 = r0
            androidx.camera.camera2.impl.CapturePipelineImpl$unlockAf$1 r1 = (androidx.camera.camera2.impl.CapturePipelineImpl$unlockAf$1) r1
            int r2 = r1.f9695e
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L16
            int r2 = r2 - r3
            r1.f9695e = r2
        L14:
            r10 = r1
            goto L1c
        L16:
            androidx.camera.camera2.impl.CapturePipelineImpl$unlockAf$1 r1 = new androidx.camera.camera2.impl.CapturePipelineImpl$unlockAf$1
            r1.<init>(r14, r0)
            goto L14
        L1c:
            java.lang.Object r0 = r10.f9693c
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r10.f9695e
            r13 = 3
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4d
            if (r2 == r4) goto L46
            if (r2 == r3) goto L3b
            if (r2 != r13) goto L33
            kotlin.C4849c.b(r0)
            return r0
        L33:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L3b:
            java.lang.Object r14 = r10.f9692b
            java.lang.AutoCloseable r14 = (java.lang.AutoCloseable) r14
            kotlin.C4849c.b(r0)     // Catch: java.lang.Throwable -> L43
            goto L7e
        L43:
            r0 = move-exception
            r1 = r0
            goto L90
        L46:
            long r5 = r10.f9691a
            kotlin.C4849c.b(r0)
        L4b:
            r8 = r5
            goto L62
        L4d:
            kotlin.C4849c.b(r0)
            s.J r14 = r14.useCaseGraphContext
            androidx.camera.camera2.pipe.CameraGraph r14 = r14.f()
            r5 = r15
            r10.f9691a = r5
            r10.f9695e = r4
            java.lang.Object r0 = r14.A0(r10)
            if (r0 != r1) goto L4b
            goto L8e
        L62:
            r14 = r0
            java.lang.AutoCloseable r14 = (java.lang.AutoCloseable) r14
            r2 = r14
            androidx.camera.camera2.pipe.CameraGraph$f r2 = (androidx.camera.camera2.pipe.CameraGraph.f) r2     // Catch: java.lang.Throwable -> L43
            java.lang.Boolean r4 = g9.C4109a.a(r4)     // Catch: java.lang.Throwable -> L43
            r10.f9692b = r14     // Catch: java.lang.Throwable -> L43
            r10.f9695e = r3     // Catch: java.lang.Throwable -> L43
            r3 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r11 = 29
            r12 = 0
            java.lang.Object r0 = androidx.camera.camera2.pipe.CameraGraph.f.Q0(r2, r3, r4, r5, r6, r7, r8, r10, r11, r12)     // Catch: java.lang.Throwable -> L43
            if (r0 != r1) goto L7e
            goto L8e
        L7e:
            Ua.Q r0 = (Ua.Q) r0     // Catch: java.lang.Throwable -> L43
            r2 = 0
            n9.C4946a.a(r14, r2)
            r10.f9692b = r2
            r10.f9695e = r13
            java.lang.Object r14 = r0.a1(r10)
            if (r14 != r1) goto L8f
        L8e:
            return r1
        L8f:
            return r14
        L90:
            throw r1     // Catch: java.lang.Throwable -> L91
        L91:
            r0 = move-exception
            n9.C4946a.a(r14, r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.impl.CapturePipelineImpl.W(long, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object Y(long r12, p9.InterfaceC5074l<? super w.w, java.lang.Boolean> r14, e9.InterfaceC4014c<? super w.w> r15) throws java.lang.Throwable {
        /*
            r11 = this;
            boolean r0 = r15 instanceof androidx.camera.camera2.impl.CapturePipelineImpl$waitForResult$1
            if (r0 == 0) goto L13
            r0 = r15
            androidx.camera.camera2.impl.CapturePipelineImpl$waitForResult$1 r0 = (androidx.camera.camera2.impl.CapturePipelineImpl$waitForResult$1) r0
            int r1 = r0.f9699d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f9699d = r1
            goto L18
        L13:
            androidx.camera.camera2.impl.CapturePipelineImpl$waitForResult$1 r0 = new androidx.camera.camera2.impl.CapturePipelineImpl$waitForResult$1
            r0.<init>(r11, r15)
        L18:
            java.lang.Object r15 = r0.f9697b
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f9699d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r12 = r0.f9696a
            t.b0 r12 = (t.C5474b0) r12
            kotlin.C4849c.b(r15)
            goto L74
        L2d:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L35:
            kotlin.C4849c.b(r15)
            t.b0 r15 = new t.b0
            r15.<init>(r12, r14)
            t.N r14 = r11.requestListener
            t.y0 r2 = r11.threads
            java.util.concurrent.Executor r2 = r2.getSequentialExecutor()
            r14.s(r15, r2)
            t.y0 r14 = r11.threads
            Ua.M r4 = r14.getSequentialScope()
            androidx.camera.camera2.impl.CapturePipelineImpl$waitForResult$resultListener$1$1 r7 = new androidx.camera.camera2.impl.CapturePipelineImpl$waitForResult$resultListener$1$1
            r14 = 0
            r7.<init>(r15, r11, r14)
            r8 = 3
            r9 = 0
            r5 = 0
            r6 = 0
            Ua.C1056g.d(r4, r5, r6, r7, r8, r9)
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r12 = r2.toMillis(r12)
            androidx.camera.camera2.impl.CapturePipelineImpl$waitForResult$3 r2 = new androidx.camera.camera2.impl.CapturePipelineImpl$waitForResult$3
            r2.<init>(r15, r14)
            r0.f9696a = r15
            r0.f9699d = r3
            java.lang.Object r12 = kotlinx.coroutines.TimeoutKt.e(r12, r2, r0)
            if (r12 != r1) goto L71
            return r1
        L71:
            r10 = r15
            r15 = r12
            r12 = r10
        L74:
            r13 = r15
            w.w r13 = (w.w) r13
            if (r13 != 0) goto L7e
            t.N r11 = r11.requestListener
            r11.F(r12)
        L7e:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.impl.CapturePipelineImpl.Y(long, p9.l, e9.c):java.lang.Object");
    }

    @Override // t.InterfaceC5495w
    public Object a(final int i10, final int i11, final int i12, InterfaceC4014c<? super InterfaceC0857l> interfaceC4014c) {
        return new InterfaceC0857l() { // from class: androidx.camera.camera2.impl.CapturePipelineImpl$getCameraCapturePipeline$2
            @Override // J.InterfaceC0857l
            public InterfaceFutureC4095a<Void> a() {
                final Ua.M scope = this.f9630a.threads.getScope();
                final CapturePipelineImpl capturePipelineImpl = this.f9630a;
                final int i13 = i10;
                final int i14 = i11;
                final int i15 = i12;
                InterfaceFutureC4095a<Void> interfaceFutureC4095aA = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: androidx.camera.camera2.impl.CapturePipelineImpl$getCameraCapturePipeline$2$invokePreCapture$$inlined$future$1

                    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
                    @InterfaceC4112d(c = "androidx.camera.camera2.impl.CapturePipelineImpl$getCameraCapturePipeline$2$invokePreCapture$$inlined$future$1$1", f = "CapturePipeline.kt", l = {104, 111}, m = "invokeSuspend", v = 1)
                    /* renamed from: androidx.camera.camera2.impl.CapturePipelineImpl$getCameraCapturePipeline$2$invokePreCapture$$inlined$future$1$1, reason: invalid class name */
                    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {

                        /* renamed from: a, reason: collision with root package name */
                        public Object f9569a;

                        /* renamed from: b, reason: collision with root package name */
                        public int f9570b;

                        /* renamed from: c, reason: collision with root package name */
                        public final /* synthetic */ CallbackToFutureAdapter.a f9571c;

                        /* renamed from: d, reason: collision with root package name */
                        public final /* synthetic */ CapturePipelineImpl f9572d;

                        /* renamed from: e, reason: collision with root package name */
                        public final /* synthetic */ int f9573e;

                        /* renamed from: f, reason: collision with root package name */
                        public final /* synthetic */ int f9574f;

                        /* renamed from: g, reason: collision with root package name */
                        public final /* synthetic */ int f9575g;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public AnonymousClass1(CallbackToFutureAdapter.a aVar, InterfaceC4014c interfaceC4014c, CapturePipelineImpl capturePipelineImpl, int i10, int i11, int i12) {
                            super(2, interfaceC4014c);
                            this.f9571c = aVar;
                            this.f9572d = capturePipelineImpl;
                            this.f9573e = i10;
                            this.f9574f = i11;
                            this.f9575g = i12;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
                            return new AnonymousClass1(this.f9571c, interfaceC4014c, this.f9572d, this.f9573e, this.f9574f, this.f9575g);
                        }

                        @Override // p9.p
                        public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:15:0x0055, code lost:
                        
                            if (kotlinx.coroutines.AwaitKt.b((java.util.Collection) r13, r10) == r0) goto L16;
                         */
                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Exception {
                            /*
                                r12 = this;
                                java.lang.Object r0 = f9.C4063a.g()
                                int r1 = r12.f9570b
                                r2 = 2
                                r3 = 1
                                if (r1 == 0) goto L28
                                if (r1 == r3) goto L1e
                                if (r1 != r2) goto L16
                                java.lang.Object r12 = r12.f9569a
                                androidx.concurrent.futures.CallbackToFutureAdapter$a r12 = (androidx.concurrent.futures.CallbackToFutureAdapter.a) r12
                                kotlin.C4849c.b(r13)
                                goto L58
                            L16:
                                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                                java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
                                r12.<init>(r13)
                                throw r12
                            L1e:
                                java.lang.Object r1 = r12.f9569a
                                androidx.concurrent.futures.CallbackToFutureAdapter$a r1 = (androidx.concurrent.futures.CallbackToFutureAdapter.a) r1
                                kotlin.C4849c.b(r13)
                                r10 = r12
                                r12 = r1
                                goto L4b
                            L28:
                                kotlin.C4849c.b(r13)
                                androidx.concurrent.futures.CallbackToFutureAdapter$a r13 = r12.f9571c
                                androidx.camera.camera2.impl.CapturePipelineImpl r4 = r12.f9572d
                                androidx.camera.camera2.impl.CapturePipelineImpl$PipelineTask r1 = androidx.camera.camera2.impl.CapturePipelineImpl.PipelineTask.PRE_CAPTURE
                                java.util.List r5 = Z8.C1172u.e(r1)
                                int r6 = r12.f9573e
                                int r7 = r12.f9574f
                                int r8 = r12.f9575g
                                r12.f9569a = r13
                                r12.f9570b = r3
                                r9 = 0
                                r10 = r12
                                java.lang.Object r12 = androidx.camera.camera2.impl.CapturePipelineImpl.s(r4, r5, r6, r7, r8, r9, r10)
                                if (r12 != r0) goto L48
                                goto L57
                            L48:
                                r11 = r13
                                r13 = r12
                                r12 = r11
                            L4b:
                                java.util.Collection r13 = (java.util.Collection) r13
                                r10.f9569a = r12
                                r10.f9570b = r2
                                java.lang.Object r13 = kotlinx.coroutines.AwaitKt.b(r13, r10)
                                if (r13 != r0) goto L58
                            L57:
                                return r0
                            L58:
                                r13 = 0
                                r12.c(r13)
                                Y8.t r12 = Y8.t.f7040a
                                return r12
                            */
                            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.impl.CapturePipelineImpl$getCameraCapturePipeline$2$invokePreCapture$$inlined$future$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
                        }
                    }

                    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
                    public final Object a(CallbackToFutureAdapter.a<T> completer) {
                        p.i(completer, "completer");
                        return C1060i.d(scope, null, null, new AnonymousClass1(completer, null, capturePipelineImpl, i13, i14, i15), 3, null);
                    }
                });
                p.h(interfaceFutureC4095aA, "getFuture(...)");
                return interfaceFutureC4095aA;
            }

            @Override // J.InterfaceC0857l
            public InterfaceFutureC4095a<Void> b() {
                final Ua.M scope = this.f9630a.threads.getScope();
                final CapturePipelineImpl capturePipelineImpl = this.f9630a;
                final int i13 = i10;
                final int i14 = i11;
                final int i15 = i12;
                InterfaceFutureC4095a<Void> interfaceFutureC4095aA = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: androidx.camera.camera2.impl.CapturePipelineImpl$getCameraCapturePipeline$2$invokePostCapture$$inlined$future$1

                    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
                    @InterfaceC4112d(c = "androidx.camera.camera2.impl.CapturePipelineImpl$getCameraCapturePipeline$2$invokePostCapture$$inlined$future$1$1", f = "CapturePipeline.kt", l = {104, 111}, m = "invokeSuspend", v = 1)
                    /* renamed from: androidx.camera.camera2.impl.CapturePipelineImpl$getCameraCapturePipeline$2$invokePostCapture$$inlined$future$1$1, reason: invalid class name */
                    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {

                        /* renamed from: a, reason: collision with root package name */
                        public Object f9557a;

                        /* renamed from: b, reason: collision with root package name */
                        public int f9558b;

                        /* renamed from: c, reason: collision with root package name */
                        public final /* synthetic */ CallbackToFutureAdapter.a f9559c;

                        /* renamed from: d, reason: collision with root package name */
                        public final /* synthetic */ CapturePipelineImpl f9560d;

                        /* renamed from: e, reason: collision with root package name */
                        public final /* synthetic */ int f9561e;

                        /* renamed from: f, reason: collision with root package name */
                        public final /* synthetic */ int f9562f;

                        /* renamed from: g, reason: collision with root package name */
                        public final /* synthetic */ int f9563g;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public AnonymousClass1(CallbackToFutureAdapter.a aVar, InterfaceC4014c interfaceC4014c, CapturePipelineImpl capturePipelineImpl, int i10, int i11, int i12) {
                            super(2, interfaceC4014c);
                            this.f9559c = aVar;
                            this.f9560d = capturePipelineImpl;
                            this.f9561e = i10;
                            this.f9562f = i11;
                            this.f9563g = i12;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
                            return new AnonymousClass1(this.f9559c, interfaceC4014c, this.f9560d, this.f9561e, this.f9562f, this.f9563g);
                        }

                        @Override // p9.p
                        public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:15:0x0055, code lost:
                        
                            if (kotlinx.coroutines.AwaitKt.b((java.util.Collection) r13, r10) == r0) goto L16;
                         */
                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Exception {
                            /*
                                r12 = this;
                                java.lang.Object r0 = f9.C4063a.g()
                                int r1 = r12.f9558b
                                r2 = 2
                                r3 = 1
                                if (r1 == 0) goto L28
                                if (r1 == r3) goto L1e
                                if (r1 != r2) goto L16
                                java.lang.Object r12 = r12.f9557a
                                androidx.concurrent.futures.CallbackToFutureAdapter$a r12 = (androidx.concurrent.futures.CallbackToFutureAdapter.a) r12
                                kotlin.C4849c.b(r13)
                                goto L58
                            L16:
                                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                                java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
                                r12.<init>(r13)
                                throw r12
                            L1e:
                                java.lang.Object r1 = r12.f9557a
                                androidx.concurrent.futures.CallbackToFutureAdapter$a r1 = (androidx.concurrent.futures.CallbackToFutureAdapter.a) r1
                                kotlin.C4849c.b(r13)
                                r10 = r12
                                r12 = r1
                                goto L4b
                            L28:
                                kotlin.C4849c.b(r13)
                                androidx.concurrent.futures.CallbackToFutureAdapter$a r13 = r12.f9559c
                                androidx.camera.camera2.impl.CapturePipelineImpl r4 = r12.f9560d
                                androidx.camera.camera2.impl.CapturePipelineImpl$PipelineTask r1 = androidx.camera.camera2.impl.CapturePipelineImpl.PipelineTask.POST_CAPTURE
                                java.util.List r5 = Z8.C1172u.e(r1)
                                int r6 = r12.f9561e
                                int r7 = r12.f9562f
                                int r8 = r12.f9563g
                                r12.f9557a = r13
                                r12.f9558b = r3
                                r9 = 0
                                r10 = r12
                                java.lang.Object r12 = androidx.camera.camera2.impl.CapturePipelineImpl.s(r4, r5, r6, r7, r8, r9, r10)
                                if (r12 != r0) goto L48
                                goto L57
                            L48:
                                r11 = r13
                                r13 = r12
                                r12 = r11
                            L4b:
                                java.util.Collection r13 = (java.util.Collection) r13
                                r10.f9557a = r12
                                r10.f9558b = r2
                                java.lang.Object r13 = kotlinx.coroutines.AwaitKt.b(r13, r10)
                                if (r13 != r0) goto L58
                            L57:
                                return r0
                            L58:
                                r13 = 0
                                r12.c(r13)
                                Y8.t r12 = Y8.t.f7040a
                                return r12
                            */
                            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.impl.CapturePipelineImpl$getCameraCapturePipeline$2$invokePostCapture$$inlined$future$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
                        }
                    }

                    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
                    public final Object a(CallbackToFutureAdapter.a<T> completer) {
                        p.i(completer, "completer");
                        return C1060i.d(scope, null, null, new AnonymousClass1(completer, null, capturePipelineImpl, i13, i14, i15), 3, null);
                    }
                });
                p.h(interfaceFutureC4095aA, "getFuture(...)");
                return interfaceFutureC4095aA;
            }
        };
    }

    @Override // t.InterfaceC5495w
    public void b(int i10) {
        this.template = i10;
    }

    @Override // t.InterfaceC5495w
    public Object c(List<l> list, int i10, Config config, int i11, int i12, int i13, InterfaceC4014c<? super List<? extends Ua.Q<Void>>> interfaceC4014c) {
        return L(C1173v.p(PipelineTask.PRE_CAPTURE, PipelineTask.MAIN_CAPTURE, PipelineTask.POST_CAPTURE), i11, i13, i12, new MainCaptureParams(list, i10, config, null), interfaceC4014c);
    }
}
