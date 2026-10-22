package com.stepos.ailauncher.agent.aispace.connect;

import D.H;
import D.i0;
import D2.InterfaceC0792d;
import D2.InterfaceC0793e;
import D2.InterfaceC0794f;
import Ua.C1060i;
import X.c;
import Y4.C1123g;
import Z8.C1173v;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.util.Size;
import android.view.C1398p;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.SurfaceRequest;
import androidx.core.view.a0;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.utils.ReportUtil;
import com.stepos.agentframework.adapter.agentbus.bff.ExternalAgent;
import com.stepos.ailauncher.agent.R$string;
import com.stepos.ailauncher.agent.aispace.connect.ScanQrActivity;
import com.stepos.ailauncher.agent.aispace.market.ConnectedAgentsActivity;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilityContract;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import d.AbstractC3936b;
import d.InterfaceC3935a;
import g3.InterfaceFutureC4095a;
import h8.C4148a;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.C4848b;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import net.sqlcipher.database.SQLiteDatabase;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import t3.C5506b;
import t3.InterfaceC5505a;
import u3.C5573a;
import v9.C5685n;
import x3.C5846a;

@Metadata(d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0002\u0082\u0001\u0018\u0000 \u0088\u00012\u00020\u0001:\u0006\u0089\u0001\u008a\u0001\u008b\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\u0003J\u000f\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u0003J\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b \u0010\u0011J\u0017\u0010\"\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\"\u0010#J\u0019\u0010$\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u000eH\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010*\u001a\u00020\u00062\u0006\u0010)\u001a\u00020(H\u0002¢\u0006\u0004\b*\u0010+J\u0017\u0010-\u001a\u00020\u00062\u0006\u0010)\u001a\u00020,H\u0002¢\u0006\u0004\b-\u0010.J\u0017\u00100\u001a\u00020\u00062\u0006\u0010)\u001a\u00020/H\u0002¢\u0006\u0004\b0\u00101J'\u00106\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u000e2\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u00020\u000eH\u0002¢\u0006\u0004\b6\u00107J!\u00109\u001a\u0004\u0018\u00010\u00122\u0006\u00102\u001a\u00020\u000e2\u0006\u00108\u001a\u00020\u0012H\u0002¢\u0006\u0004\b9\u0010:J\u0017\u0010<\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u0012H\u0002¢\u0006\u0004\b<\u0010=J\u0017\u0010>\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b>\u0010\u0011J\u000f\u0010?\u001a\u00020\u0006H\u0002¢\u0006\u0004\b?\u0010\u0003J'\u0010A\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010@\u001a\u00020!2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\bA\u0010BJ\u0017\u0010C\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000eH\u0002¢\u0006\u0004\bC\u0010%J\u000f\u0010D\u001a\u00020\u0006H\u0002¢\u0006\u0004\bD\u0010\u0003J'\u0010H\u001a\u00020\u00062\u0006\u0010E\u001a\u00020\u000e2\u0006\u0010F\u001a\u00020\u000e2\u0006\u0010G\u001a\u00020\u000eH\u0002¢\u0006\u0004\bH\u0010IJ\u000f\u0010J\u001a\u00020\u0006H\u0002¢\u0006\u0004\bJ\u0010\u0003J\u000f\u0010K\u001a\u00020\u0006H\u0002¢\u0006\u0004\bK\u0010\u0003R\u0016\u0010M\u001a\u00020L8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010P\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010R\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010>R\u0014\u0010T\u001a\u00020S8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010V\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010>R\u0018\u0010W\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010Z\u001a\u00020Y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010\\\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010XR\u0018\u0010]\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010XR\u0014\u0010^\u001a\u00020S8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010UR\u0014\u0010`\u001a\u00020_8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010c\u001a\u00020b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bc\u0010dR\u001b\u0010j\u001a\u00020e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bf\u0010g\u001a\u0004\bh\u0010iR\u0016\u0010k\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010>R\u0016\u0010l\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010>R\u0016\u0010m\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010>R\u0018\u0010o\u001a\u0004\u0018\u00010n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010pR\u0018\u0010r\u001a\u0004\u0018\u00010q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010sR\u0018\u0010u\u001a\u0004\u0018\u00010t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010vR\u0018\u0010w\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010xR\u0018\u0010y\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\by\u0010xR\u0018\u0010{\u001a\u0004\u0018\u00010z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010|R\u0016\u0010}\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010~R\u0016\u0010\u007f\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u007f\u0010>R\u0018\u0010\u0080\u0001\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0080\u0001\u0010>R\u0018\u0010\u0081\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0081\u0001\u0010~R\u0018\u0010\u0083\u0001\u001a\u00030\u0082\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001e\u0010\u0086\u0001\u001a\t\u0012\u0004\u0012\u00020\u000e0\u0085\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001¨\u0006\u008c\u0001"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/connect/ScanQrActivity;", "Landroidx/appcompat/app/d;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onCreate", "(Landroid/os/Bundle;)V", "onResume", "onPause", "onDestroy", "G0", "startCamera", "", "reason", "F0", "(Ljava/lang/String;)V", "", HomeGestureEligibilityContract.EXTRA_GENERATION, "LD/i0$c;", "g0", "(I)LD/i0$c;", "Landroidx/camera/core/SurfaceRequest;", "request", "u0", "(Landroidx/camera/core/SurfaceRequest;I)V", "bufWidth", "bufHeight", "a0", "(II)V", "text", "o0", "", "A0", "(Ljava/lang/String;)Z", "w0", "(Ljava/lang/String;)Ljava/lang/String;", "q0", "()Ljava/lang/String;", "Lcom/stepos/ailauncher/agent/aispace/connect/ScanQrActivity$c;", "pair", "e0", "(Lcom/stepos/ailauncher/agent/aispace/connect/ScanQrActivity$c;)V", "Lcom/stepos/ailauncher/agent/aispace/connect/ScanQrActivity$c$a;", "f0", "(Lcom/stepos/ailauncher/agent/aispace/connect/ScanQrActivity$c$a;)V", "Lcom/stepos/ailauncher/agent/aispace/connect/ScanQrActivity$c$b;", "b0", "(Lcom/stepos/ailauncher/agent/aispace/connect/ScanQrActivity$c$b;)V", "opName", "", "e", "headers", "n0", "(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V", "bizCode", "c0", "(Ljava/lang/String;I)Ljava/lang/Integer;", "msgResId", "B0", "(I)V", "Z", "k0", "ok", "Y", "(Ljava/lang/String;ZLjava/lang/String;)V", "j0", "E0", "deviceId", "agent", "deviceName", "z0", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "l0", "x0", "LY4/g;", "binding", "LY4/g;", "Landroid/animation/ObjectAnimator;", "scanAnimator", "Landroid/animation/ObjectAnimator;", "isCameraHostResumed", "Ljava/lang/Runnable;", "startScanAnimationRunnable", "Ljava/lang/Runnable;", "hasReturned", "lastInvalidText", "Ljava/lang/String;", "", "lastInvalidAtMs", "J", "lastConfirmText", "expiredQrText", "hideMismatchRunnable", "Ljava/text/SimpleDateFormat;", "timeFmt", "Ljava/text/SimpleDateFormat;", "Ljava/util/concurrent/ExecutorService;", "cameraExecutor", "Ljava/util/concurrent/ExecutorService;", "Lt3/a;", "scanner$delegate", "LY8/h;", "m0", "()Lt3/a;", "scanner", "previewSurfaceReady", "permissionGranted", "permissionRequestPending", "La0/n;", "cameraProvider", "La0/n;", "LD/i0;", "cameraPreview", "LD/i0;", "LD/H;", "imageAnalysis", "LD/H;", "activeSurfaceRequest", "Landroidx/camera/core/SurfaceRequest;", "pendingSurfaceRequest", "Landroid/util/Size;", "pendingSurfaceResolution", "Landroid/util/Size;", "pendingSurfaceGeneration", "I", "cameraBound", "cameraStartRequested", "cameraBindGeneration", "com/stepos/ailauncher/agent/aispace/connect/ScanQrActivity$d", "previewSurfaceCallback", "Lcom/stepos/ailauncher/agent/aispace/connect/ScanQrActivity$d;", "Ld/b;", "cameraPermissionLauncher", "Ld/b;", "Companion", Const.INTENT_KEY_PKGNAME, "c", Const.INTENT_KEY_APIKEY, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ScanQrActivity extends androidx.appcompat.app.d {
    private static final float BOTTOM_BAR_HEIGHT_DP = 196.0f;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String EXTRA_AGENT = "extra_agent";
    public static final String EXTRA_ALREADY_CONFIRMED = "extra_already_confirmed";
    public static final String EXTRA_DEVICE_ID = "extra_device_id";
    public static final String EXTRA_DEVICE_NAME = "extra_device_name";
    public static final String EXTRA_DEVICE_TOKEN = "extra_device_token";
    private static final String EXTRA_FALLBACK_AGENT = "extra_fallback_agent";
    public static final String EXTRA_PAIR_ID = "extra_pair_id";
    private static final String EXTRA_RETURN_HOME = "extra_return_home";
    private static final long INVALID_DEDUPE_WINDOW_MS = 2000;
    private static final long MISMATCH_VISIBLE_MS = 5000;
    private static final String TAG = "ScanQrActivity";
    private SurfaceRequest activeSurfaceRequest;
    private C1123g binding;
    private volatile int cameraBindGeneration;
    private boolean cameraBound;
    private ExecutorService cameraExecutor;
    private D.i0 cameraPreview;
    private a0.n cameraProvider;
    private boolean cameraStartRequested;
    private String expiredQrText;
    private boolean hasReturned;
    private D.H imageAnalysis;
    private volatile boolean isCameraHostResumed;
    private String lastConfirmText;
    private long lastInvalidAtMs;
    private String lastInvalidText;
    private int pendingSurfaceGeneration;
    private SurfaceRequest pendingSurfaceRequest;
    private Size pendingSurfaceResolution;
    private volatile boolean permissionGranted;
    private boolean permissionRequestPending;
    private volatile boolean previewSurfaceReady;
    private ObjectAnimator scanAnimator;
    private final Runnable startScanAnimationRunnable = new Runnable() { // from class: com.stepos.ailauncher.agent.aispace.connect.W0
        @Override // java.lang.Runnable
        public final void run() {
            ScanQrActivity.D0(this.f23987a);
        }
    };
    private final Runnable hideMismatchRunnable = new Runnable() { // from class: com.stepos.ailauncher.agent.aispace.connect.X0
        @Override // java.lang.Runnable
        public final void run() {
            ScanQrActivity.p0(this.f23992a);
        }
    };
    private final SimpleDateFormat timeFmt = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());

    /* renamed from: scanner$delegate, reason: from kotlin metadata */
    private final Y8.h scanner = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.connect.Y0
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return ScanQrActivity.y0();
        }
    });
    private final d previewSurfaceCallback = new d();
    private final AbstractC3936b<String> cameraPermissionLauncher = registerForActivityResult(new e.d(), new InterfaceC3935a() { // from class: com.stepos.ailauncher.agent.aispace.connect.Z0
        @Override // d.InterfaceC3935a
        public final void a(Object obj) {
            ScanQrActivity.d0(this.f23997a, ((Boolean) obj).booleanValue());
        }
    });

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0015R\u0014\u0010\u001b\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0015R\u0014\u0010\u001c\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0015R\u0014\u0010\u001d\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0015R\u0014\u0010\u001e\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\u0015R\u0014\u0010\u001f\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001f\u0010\u0015R\u0014\u0010 \u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010\u0015R\u0014\u0010!\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\u0015¨\u0006\""}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/connect/ScanQrActivity$a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "fallbackAgent", "", "returnHome", "Landroid/content/Intent;", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;Ljava/lang/String;Z)Landroid/content/Intent;", "text", "Lcom/stepos/ailauncher/agent/aispace/connect/ScanQrActivity$c;", Const.INTENT_KEY_UMID, "(Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/ailauncher/agent/aispace/connect/ScanQrActivity$c;", "", "BOTTOM_BAR_HEIGHT_DP", "F", "TAG", "Ljava/lang/String;", "", "INVALID_DEDUPE_WINDOW_MS", "J", "MISMATCH_VISIBLE_MS", "EXTRA_DEVICE_TOKEN", "EXTRA_DEVICE_ID", "EXTRA_PAIR_ID", "EXTRA_AGENT", "EXTRA_DEVICE_NAME", "EXTRA_ALREADY_CONFIRMED", "EXTRA_FALLBACK_AGENT", "EXTRA_RETURN_HOME", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.agent.aispace.connect.ScanQrActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public static /* synthetic */ Intent c(Companion companion, Context context, String str, boolean z10, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                str = "";
            }
            if ((i10 & 4) != 0) {
                z10 = true;
            }
            return companion.b(context, str, z10);
        }

        public final Intent b(Context context, String fallbackAgent, boolean returnHome) {
            kotlin.jvm.internal.p.i(context, "context");
            kotlin.jvm.internal.p.i(fallbackAgent, "fallbackAgent");
            Intent intentPutExtra = new Intent(context, (Class<?>) ScanQrActivity.class).putExtra(ScanQrActivity.EXTRA_FALLBACK_AGENT, fallbackAgent).putExtra(ScanQrActivity.EXTRA_RETURN_HOME, returnHome);
            kotlin.jvm.internal.p.h(intentPutExtra, "putExtra(...)");
            return intentPutExtra;
        }

        public final c d(String text, String fallbackAgent) {
            Object objB;
            String lowerCase;
            String str;
            try {
                Result.Companion companion = Result.INSTANCE;
                objB = Result.b(Uri.parse(text));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            if (Result.g(objB)) {
                objB = null;
            }
            Uri uri = (Uri) objB;
            if (uri == null || !La.D.L("pair", uri.getHost(), true)) {
                return null;
            }
            String scheme = uri.getScheme();
            if (scheme != null) {
                lowerCase = scheme.toLowerCase(Locale.ROOT);
                kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
            } else {
                lowerCase = null;
            }
            if (kotlin.jvm.internal.p.d(lowerCase, "clawphone")) {
                String queryParameter = uri.getQueryParameter(Parameters.DEVICE_ID);
                if (queryParameter == null) {
                    queryParameter = "";
                }
                String queryParameter2 = uri.getQueryParameter("pair_id");
                if (queryParameter2 == null) {
                    queryParameter2 = "";
                }
                if (La.H.x0(queryParameter) || La.H.x0(queryParameter2)) {
                    return null;
                }
                String queryParameter3 = uri.getQueryParameter("agent");
                str = queryParameter3 != null ? queryParameter3 : "";
                if (!La.H.x0(str)) {
                    fallbackAgent = str;
                }
                return new c.Clawphone(queryParameter, queryParameter2, fallbackAgent);
            }
            if (!kotlin.jvm.internal.p.d(lowerCase, ConnectedAgentsActivity.FILTER_STEPAI)) {
                return null;
            }
            String queryParameter4 = uri.getQueryParameter("stepai_device_id");
            if (queryParameter4 == null) {
                queryParameter4 = "";
            }
            String queryParameter5 = uri.getQueryParameter("stepai_user_id");
            if (queryParameter5 == null) {
                queryParameter5 = "";
            }
            if (La.H.x0(queryParameter4) || La.H.x0(queryParameter5)) {
                return null;
            }
            String queryParameter6 = uri.getQueryParameter("stepai_device_name");
            str = queryParameter6 != null ? queryParameter6 : "";
            if (La.H.x0(str)) {
                str = queryParameter4;
            }
            return new c.Stepai(queryParameter4, str, queryParameter5);
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/connect/ScanQrActivity$b;", "LD/H$a;", "", HomeGestureEligibilityContract.EXTRA_GENERATION, "<init>", "(Lcom/stepos/ailauncher/agent/aispace/connect/ScanQrActivity;I)V", "Landroidx/camera/core/i;", "imageProxy", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Landroidx/camera/core/i;)V", "I", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class b implements H.a {
        private final int generation;

        public b(int i10) {
            this.generation = i10;
        }

        public static final Y8.t g(ScanQrActivity scanQrActivity, b bVar, List list) {
            Object next;
            if (scanQrActivity.hasReturned || bVar.generation != scanQrActivity.cameraBindGeneration || !scanQrActivity.permissionGranted || !scanQrActivity.isCameraHostResumed) {
                return Y8.t.f7040a;
            }
            kotlin.jvm.internal.p.f(list);
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((C5573a) next).b() == 256) {
                    break;
                }
            }
            C5573a c5573a = (C5573a) next;
            String strC = c5573a != null ? c5573a.c() : null;
            if (strC != null && !La.H.x0(strC)) {
                kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
                String str = String.format("ML Kit decoded: %s", Arrays.copyOf(new Object[]{strC}, 1));
                kotlin.jvm.internal.p.h(str, "format(...)");
                C4148a.d(ScanQrActivity.TAG, str, false, 4, null);
                scanQrActivity.o0(strC);
            }
            return Y8.t.f7040a;
        }

        public static final void h(InterfaceC5074l interfaceC5074l, Object obj) {
            interfaceC5074l.invoke(obj);
        }

        public static final void i(Exception it) {
            kotlin.jvm.internal.p.i(it, "it");
            C4148a.t(ScanQrActivity.TAG, "ML Kit process failed", it, false, 8, null);
        }

        public static final void j(androidx.camera.core.i iVar, D2.i it) {
            kotlin.jvm.internal.p.i(it, "it");
            iVar.close();
        }

        @Override // D.H.a
        public void b(final androidx.camera.core.i imageProxy) {
            kotlin.jvm.internal.p.i(imageProxy, "imageProxy");
            if (ScanQrActivity.this.hasReturned || !ScanQrActivity.this.permissionGranted || this.generation != ScanQrActivity.this.cameraBindGeneration || !ScanQrActivity.this.isCameraHostResumed) {
                imageProxy.close();
                return;
            }
            Image imageG1 = imageProxy.g1();
            if (imageG1 == null) {
                imageProxy.close();
                return;
            }
            C5846a c5846aA = C5846a.a(imageG1, imageProxy.Z0().f());
            kotlin.jvm.internal.p.h(c5846aA, "fromMediaImage(...)");
            D2.i<List<C5573a>> iVarN0 = ScanQrActivity.this.m0().n0(c5846aA);
            final ScanQrActivity scanQrActivity = ScanQrActivity.this;
            final InterfaceC5074l interfaceC5074l = new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.aispace.connect.c1
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return ScanQrActivity.b.g(scanQrActivity, this, (List) obj);
                }
            };
            iVarN0.f(new InterfaceC0794f() { // from class: com.stepos.ailauncher.agent.aispace.connect.d1
                @Override // D2.InterfaceC0794f
                public final void a(Object obj) {
                    ScanQrActivity.b.h(interfaceC5074l, obj);
                }
            }).d(new InterfaceC0793e() { // from class: com.stepos.ailauncher.agent.aispace.connect.e1
                @Override // D2.InterfaceC0793e
                public final void onFailure(Exception exc) {
                    ScanQrActivity.b.i(exc);
                }
            }).b(new InterfaceC0792d() { // from class: com.stepos.ailauncher.agent.aispace.connect.f1
                @Override // D2.InterfaceC0792d
                public final void a(D2.i iVar) {
                    ScanQrActivity.b.j(imageProxy, iVar);
                }
            });
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/connect/ScanQrActivity$c;", "", "<init>", "()V", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "Lcom/stepos/ailauncher/agent/aispace/connect/ScanQrActivity$c$a;", "Lcom/stepos/ailauncher/agent/aispace/connect/ScanQrActivity$c$b;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class c {

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\tR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0014\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0015\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/connect/ScanQrActivity$c$a;", "Lcom/stepos/ailauncher/agent/aispace/connect/ScanQrActivity$c;", "", "deviceId", "pairId", "agent", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "c", Const.INTENT_KEY_APIKEY, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.agent.aispace.connect.ScanQrActivity$c$a, reason: from toString */
        public static final /* data */ class Clawphone extends c {
            private final String agent;
            private final String deviceId;
            private final String pairId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Clawphone(String deviceId, String pairId, String agent) {
                super(null);
                kotlin.jvm.internal.p.i(deviceId, "deviceId");
                kotlin.jvm.internal.p.i(pairId, "pairId");
                kotlin.jvm.internal.p.i(agent, "agent");
                this.deviceId = deviceId;
                this.pairId = pairId;
                this.agent = agent;
            }

            /* renamed from: a, reason: from getter */
            public final String getAgent() {
                return this.agent;
            }

            /* renamed from: b, reason: from getter */
            public final String getDeviceId() {
                return this.deviceId;
            }

            /* renamed from: c, reason: from getter */
            public final String getPairId() {
                return this.pairId;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Clawphone)) {
                    return false;
                }
                Clawphone clawphone = (Clawphone) other;
                return kotlin.jvm.internal.p.d(this.deviceId, clawphone.deviceId) && kotlin.jvm.internal.p.d(this.pairId, clawphone.pairId) && kotlin.jvm.internal.p.d(this.agent, clawphone.agent);
            }

            public int hashCode() {
                return (((this.deviceId.hashCode() * 31) + this.pairId.hashCode()) * 31) + this.agent.hashCode();
            }

            public String toString() {
                return "Clawphone(deviceId=" + this.deviceId + ", pairId=" + this.pairId + ", agent=" + this.agent + ")";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\tR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0014\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0015\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/connect/ScanQrActivity$c$b;", "Lcom/stepos/ailauncher/agent/aispace/connect/ScanQrActivity$c;", "", "deviceId", "deviceName", "userId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "c", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.agent.aispace.connect.ScanQrActivity$c$b, reason: from toString */
        public static final /* data */ class Stepai extends c {
            private final String deviceId;
            private final String deviceName;
            private final String userId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Stepai(String deviceId, String deviceName, String userId) {
                super(null);
                kotlin.jvm.internal.p.i(deviceId, "deviceId");
                kotlin.jvm.internal.p.i(deviceName, "deviceName");
                kotlin.jvm.internal.p.i(userId, "userId");
                this.deviceId = deviceId;
                this.deviceName = deviceName;
                this.userId = userId;
            }

            /* renamed from: a, reason: from getter */
            public final String getDeviceId() {
                return this.deviceId;
            }

            /* renamed from: b, reason: from getter */
            public final String getDeviceName() {
                return this.deviceName;
            }

            /* renamed from: c, reason: from getter */
            public final String getUserId() {
                return this.userId;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Stepai)) {
                    return false;
                }
                Stepai stepai = (Stepai) other;
                return kotlin.jvm.internal.p.d(this.deviceId, stepai.deviceId) && kotlin.jvm.internal.p.d(this.deviceName, stepai.deviceName) && kotlin.jvm.internal.p.d(this.userId, stepai.userId);
            }

            public int hashCode() {
                return (((this.deviceId.hashCode() * 31) + this.deviceName.hashCode()) * 31) + this.userId.hashCode();
            }

            public String toString() {
                return "Stepai(deviceId=" + this.deviceId + ", deviceName=" + this.deviceName + ", userId=" + this.userId + ")";
            }
        }

        public /* synthetic */ c(kotlin.jvm.internal.i iVar) {
            this();
        }

        public c() {
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J/\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0006¨\u0006\u000e"}, d2 = {"com/stepos/ailauncher/agent/aispace/connect/ScanQrActivity$d", "Landroid/view/SurfaceHolder$Callback;", "Landroid/view/SurfaceHolder;", "holder", "LY8/t;", "surfaceCreated", "(Landroid/view/SurfaceHolder;)V", "", "format", "width", "height", "surfaceChanged", "(Landroid/view/SurfaceHolder;III)V", "surfaceDestroyed", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d implements SurfaceHolder.Callback {
        public d() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) throws ExecutionException, InterruptedException {
            kotlin.jvm.internal.p.i(holder, "holder");
            kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
            String str = String.format("surfaceChanged %dx%d", Arrays.copyOf(new Object[]{Integer.valueOf(width), Integer.valueOf(height)}, 2));
            kotlin.jvm.internal.p.h(str, "format(...)");
            C4148a.d(ScanQrActivity.TAG, str, false, 4, null);
            SurfaceRequest surfaceRequest = ScanQrActivity.this.pendingSurfaceRequest;
            Size size = ScanQrActivity.this.pendingSurfaceResolution;
            if (surfaceRequest == null || size == null || width != size.getWidth() || height != size.getHeight()) {
                return;
            }
            ScanQrActivity.this.pendingSurfaceRequest = null;
            ScanQrActivity.this.pendingSurfaceResolution = null;
            ScanQrActivity scanQrActivity = ScanQrActivity.this;
            scanQrActivity.u0(surfaceRequest, scanQrActivity.pendingSurfaceGeneration);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder holder) {
            kotlin.jvm.internal.p.i(holder, "holder");
            C4148a.d(ScanQrActivity.TAG, "surfaceCreated", false, 4, null);
            ScanQrActivity.this.previewSurfaceReady = true;
            com.stepos.ailauncher.common.memory.d.INSTANCE.v("cameraPreview");
            ScanQrActivity.this.G0();
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder holder) {
            kotlin.jvm.internal.p.i(holder, "holder");
            C4148a.d(ScanQrActivity.TAG, "surfaceDestroyed", false, 4, null);
            ScanQrActivity.this.previewSurfaceReady = false;
            com.stepos.ailauncher.common.memory.d.INSTANCE.w("cameraPreview");
            SurfaceRequest surfaceRequest = ScanQrActivity.this.pendingSurfaceRequest;
            if (surfaceRequest != null) {
                surfaceRequest.u();
            }
            ScanQrActivity.this.pendingSurfaceRequest = null;
            ScanQrActivity.this.pendingSurfaceResolution = null;
            SurfaceRequest surfaceRequest2 = ScanQrActivity.this.activeSurfaceRequest;
            if (surfaceRequest2 != null) {
                surfaceRequest2.p();
            }
            ScanQrActivity.this.activeSurfaceRequest = null;
            ScanQrActivity.this.F0("surfaceDestroyed");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void C0(int i10, ScanQrActivity scanQrActivity, InterfaceFutureC4095a interfaceFutureC4095a) {
        Object objB;
        Object objB2;
        if (i10 != scanQrActivity.cameraBindGeneration || !scanQrActivity.permissionGranted || !scanQrActivity.previewSurfaceReady || !scanQrActivity.isCameraHostResumed) {
            C4148a.d(TAG, "startCamera ignored stale generation=" + i10 + " current=" + scanQrActivity.cameraBindGeneration, false, 4, null);
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b((a0.n) interfaceFutureC4095a.get());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            scanQrActivity.cameraStartRequested = false;
            C4148a.g(TAG, "ProcessCameraProvider.get() failed", thE, false, 8, null);
            Toast.makeText(scanQrActivity, "相机初始化失败", 0).show();
            return;
        }
        a0.n nVar = (a0.n) objB;
        X.c cVarA = new c.a().d(X.a.f6805d).a();
        kotlin.jvm.internal.p.h(cVarA, "build(...)");
        D.i0 i0VarE = new i0.a().k(cVarA).e();
        i0VarE.r0(scanQrActivity.g0(i10));
        kotlin.jvm.internal.p.h(i0VarE, "also(...)");
        D.H hE = new H.c().l(cVarA).h(0).e();
        ExecutorService executorService = scanQrActivity.cameraExecutor;
        if (executorService == null) {
            kotlin.jvm.internal.p.A("cameraExecutor");
            executorService = null;
        }
        hE.v0(executorService, scanQrActivity.new b(i10));
        kotlin.jvm.internal.p.h(hE, "also(...)");
        try {
            CameraSelector DEFAULT_BACK_CAMERA = CameraSelector.f11144d;
            kotlin.jvm.internal.p.h(DEFAULT_BACK_CAMERA, "DEFAULT_BACK_CAMERA");
            nVar.c(scanQrActivity, DEFAULT_BACK_CAMERA, i0VarE, hE);
            scanQrActivity.cameraProvider = nVar;
            scanQrActivity.cameraPreview = i0VarE;
            scanQrActivity.imageAnalysis = hE;
            scanQrActivity.cameraBound = true;
            scanQrActivity.cameraStartRequested = false;
            objB2 = Result.b(Integer.valueOf(C4148a.d(TAG, "CameraX bound: preview + analysis", false, 4, null)));
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            objB2 = Result.b(C4849c.a(th2));
        }
        Throwable thE2 = Result.e(objB2);
        if (thE2 != null) {
            hE.l0();
            scanQrActivity.cameraStartRequested = false;
            scanQrActivity.cameraBound = false;
            C4148a.g(TAG, "bindToLifecycle failed", thE2, false, 8, null);
            Toast.makeText(scanQrActivity, "相机绑定失败：" + thE2.getMessage(), 0).show();
        }
    }

    public static final void D0(ScanQrActivity scanQrActivity) {
        if (scanQrActivity.isCameraHostResumed) {
            scanQrActivity.E0();
        }
    }

    public static final void d0(ScanQrActivity scanQrActivity, boolean z10) {
        scanQrActivity.permissionRequestPending = false;
        scanQrActivity.permissionGranted = z10;
        if (z10) {
            scanQrActivity.G0();
            return;
        }
        scanQrActivity.F0("permissionDenied");
        Toast.makeText(scanQrActivity, R$string.scan_qr_camera_permission_denied, 0).show();
        scanQrActivity.finish();
    }

    public static final void h0(final ScanQrActivity scanQrActivity, final int i10, SurfaceRequest request) throws ExecutionException, InterruptedException {
        kotlin.jvm.internal.p.i(request, "request");
        if (!scanQrActivity.permissionGranted || !scanQrActivity.previewSurfaceReady || !scanQrActivity.isCameraHostResumed || i10 != scanQrActivity.cameraBindGeneration) {
            request.u();
            return;
        }
        SurfaceRequest surfaceRequest = scanQrActivity.activeSurfaceRequest;
        if (surfaceRequest != null) {
            surfaceRequest.p();
        }
        scanQrActivity.activeSurfaceRequest = null;
        SurfaceRequest surfaceRequest2 = scanQrActivity.pendingSurfaceRequest;
        if (surfaceRequest2 != null) {
            surfaceRequest2.u();
        }
        scanQrActivity.pendingSurfaceRequest = null;
        scanQrActivity.pendingSurfaceResolution = null;
        C1123g c1123g = scanQrActivity.binding;
        if (c1123g == null) {
            kotlin.jvm.internal.p.A("binding");
            c1123g = null;
        }
        SurfaceHolder holder = c1123g.previewView.getHolder();
        final Size sizeN = request.n();
        kotlin.jvm.internal.p.h(sizeN, "getResolution(...)");
        scanQrActivity.pendingSurfaceRequest = request;
        scanQrActivity.pendingSurfaceResolution = sizeN;
        scanQrActivity.pendingSurfaceGeneration = i10;
        holder.setFixedSize(sizeN.getWidth(), sizeN.getHeight());
        C1123g c1123g2 = scanQrActivity.binding;
        if (c1123g2 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1123g2 = null;
        }
        c1123g2.previewView.post(new Runnable() { // from class: com.stepos.ailauncher.agent.aispace.connect.S0
            @Override // java.lang.Runnable
            public final void run() {
                ScanQrActivity.i0(i10, scanQrActivity, sizeN);
            }
        });
        if (scanQrActivity.pendingSurfaceRequest != request) {
            return;
        }
        Rect surfaceFrame = holder.getSurfaceFrame();
        if (holder.getSurface().isValid() && surfaceFrame.width() == sizeN.getWidth() && surfaceFrame.height() == sizeN.getHeight()) {
            scanQrActivity.pendingSurfaceRequest = null;
            scanQrActivity.pendingSurfaceResolution = null;
            scanQrActivity.u0(request, i10);
            return;
        }
        C4148a.d(TAG, "wait surface resize current=" + surfaceFrame.width() + "x" + surfaceFrame.height() + " required=" + sizeN.getWidth() + "x" + sizeN.getHeight(), false, 4, null);
    }

    public static final void i0(int i10, ScanQrActivity scanQrActivity, Size size) {
        if (i10 == scanQrActivity.cameraBindGeneration && scanQrActivity.previewSurfaceReady) {
            scanQrActivity.a0(size.getWidth(), size.getHeight());
        }
    }

    public static final void p0(ScanQrActivity scanQrActivity) {
        C1123g c1123g = scanQrActivity.binding;
        if (c1123g == null) {
            kotlin.jvm.internal.p.A("binding");
            c1123g = null;
        }
        c1123g.tvScanMismatch.setVisibility(8);
    }

    public static final androidx.core.view.a0 r0(ScanQrActivity scanQrActivity, View v10, androidx.core.view.a0 insets) {
        kotlin.jvm.internal.p.i(v10, "v");
        kotlin.jvm.internal.p.i(insets, "insets");
        t0.e eVarF = insets.f(a0.o.g());
        kotlin.jvm.internal.p.h(eVarF, "getInsets(...)");
        v10.setPadding(v10.getPaddingLeft(), eVarF.f41978b, v10.getPaddingRight(), 0);
        int i10 = (int) (scanQrActivity.getResources().getDisplayMetrics().density * BOTTOM_BAR_HEIGHT_DP);
        C1123g c1123g = scanQrActivity.binding;
        C1123g c1123g2 = null;
        if (c1123g == null) {
            kotlin.jvm.internal.p.A("binding");
            c1123g = null;
        }
        LinearLayout linearLayout = c1123g.bottomBar;
        C1123g c1123g3 = scanQrActivity.binding;
        if (c1123g3 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c1123g2 = c1123g3;
        }
        ViewGroup.LayoutParams layoutParams = c1123g2.bottomBar.getLayoutParams();
        layoutParams.height = i10 + eVarF.f41980d;
        linearLayout.setLayoutParams(layoutParams);
        return insets;
    }

    public static final void s0(ScanQrActivity scanQrActivity, View view) {
        scanQrActivity.finish();
    }

    private final void startCamera() {
        this.cameraStartRequested = true;
        this.cameraBindGeneration++;
        final int i10 = this.cameraBindGeneration;
        C4148a.d(TAG, "startCamera: CameraX bindToLifecycle", false, 4, null);
        final InterfaceFutureC4095a<a0.n> interfaceFutureC4095aC = a0.n.INSTANCE.c(this);
        interfaceFutureC4095aC.a(new Runnable() { // from class: com.stepos.ailauncher.agent.aispace.connect.R0
            @Override // java.lang.Runnable
            public final void run() {
                ScanQrActivity.C0(i10, this, interfaceFutureC4095aC);
            }
        }, androidx.core.content.a.h(this));
    }

    public static final void t0(ScanQrActivity scanQrActivity) {
        float f10 = 12 * scanQrActivity.getResources().getDisplayMetrics().density;
        C1123g c1123g = scanQrActivity.binding;
        C1123g c1123g2 = null;
        if (c1123g == null) {
            kotlin.jvm.internal.p.A("binding");
            c1123g = null;
        }
        TextView textView = c1123g.tvScanMismatch;
        C1123g c1123g3 = scanQrActivity.binding;
        if (c1123g3 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c1123g2 = c1123g3;
        }
        textView.setY(c1123g2.scanFrame.getBottom() + f10);
    }

    public static final void v0(ScanQrActivity scanQrActivity, SurfaceRequest surfaceRequest, SurfaceRequest.f fVar) {
        if (scanQrActivity.activeSurfaceRequest == surfaceRequest) {
            scanQrActivity.activeSurfaceRequest = null;
        }
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("provideSurface result code=%d", Arrays.copyOf(new Object[]{Integer.valueOf(fVar.a())}, 1));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C4148a.d(TAG, str, false, 4, null);
    }

    public static final InterfaceC5505a y0() {
        C5506b c5506bA = new C5506b.a().b(256, new int[0]).a();
        kotlin.jvm.internal.p.h(c5506bA, "build(...)");
        InterfaceC5505a interfaceC5505aA = t3.c.a(c5506bA);
        kotlin.jvm.internal.p.h(interfaceC5505aA, "getClient(...)");
        return interfaceC5505aA;
    }

    public final boolean A0(String text) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (kotlin.jvm.internal.p.d(text, this.lastInvalidText) && jElapsedRealtime - this.lastInvalidAtMs < 2000) {
            return false;
        }
        this.lastInvalidText = text;
        this.lastInvalidAtMs = jElapsedRealtime;
        return true;
    }

    public final void B0(int msgResId) {
        C1123g c1123g = this.binding;
        C1123g c1123g2 = null;
        if (c1123g == null) {
            kotlin.jvm.internal.p.A("binding");
            c1123g = null;
        }
        c1123g.tvScanMismatch.setText(msgResId);
        C1123g c1123g3 = this.binding;
        if (c1123g3 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1123g3 = null;
        }
        c1123g3.tvScanMismatch.setVisibility(0);
        C1123g c1123g4 = this.binding;
        if (c1123g4 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1123g4 = null;
        }
        c1123g4.tvScanMismatch.removeCallbacks(this.hideMismatchRunnable);
        C1123g c1123g5 = this.binding;
        if (c1123g5 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c1123g2 = c1123g5;
        }
        c1123g2.tvScanMismatch.postDelayed(this.hideMismatchRunnable, 5000L);
    }

    public final void E0() {
        C1123g c1123g = this.binding;
        C1123g c1123g2 = null;
        if (c1123g == null) {
            kotlin.jvm.internal.p.A("binding");
            c1123g = null;
        }
        int height = c1123g.scanFrame.getHeight();
        C1123g c1123g3 = this.binding;
        if (c1123g3 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1123g3 = null;
        }
        int iF = C5685n.f((height - c1123g3.scanLine.getHeight()) - 40, 0);
        if (iF <= 0) {
            return;
        }
        ObjectAnimator objectAnimator = this.scanAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        C1123g c1123g4 = this.binding;
        if (c1123g4 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c1123g2 = c1123g4;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(c1123g2.scanLine, "translationY", 0.0f, iF);
        objectAnimatorOfFloat.setDuration(ReportUtil.BIGSHIFT_VALIDTIME);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        objectAnimatorOfFloat.start();
        this.scanAnimator = objectAnimatorOfFloat;
    }

    public final void F0(String reason) {
        Object objB;
        Y8.t tVar;
        this.cameraBindGeneration++;
        this.cameraStartRequested = false;
        this.cameraBound = false;
        SurfaceRequest surfaceRequest = this.pendingSurfaceRequest;
        if (surfaceRequest != null) {
            surfaceRequest.u();
        }
        this.pendingSurfaceRequest = null;
        this.pendingSurfaceResolution = null;
        SurfaceRequest surfaceRequest2 = this.activeSurfaceRequest;
        if (surfaceRequest2 != null) {
            surfaceRequest2.p();
        }
        this.activeSurfaceRequest = null;
        D.i0 i0Var = this.cameraPreview;
        D.H h10 = this.imageAnalysis;
        if (h10 != null) {
            h10.l0();
        }
        this.cameraPreview = null;
        this.imageAnalysis = null;
        try {
            Result.Companion companion = Result.INSTANCE;
            a0.n nVar = this.cameraProvider;
            if (nVar != null) {
                if (i0Var != null && h10 != null) {
                    nVar.e(i0Var, h10);
                } else if (i0Var != null) {
                    nVar.e(i0Var);
                } else if (h10 != null) {
                    nVar.e(h10);
                }
                tVar = Y8.t.f7040a;
            } else {
                tVar = null;
            }
            objB = Result.b(tVar);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "CameraX unbind failed reason=" + reason, thE, false, 8, null);
        }
        this.cameraProvider = null;
        C4148a.d(TAG, "CameraX stopped reason=" + reason, false, 4, null);
    }

    public final void G0() {
        if (this.permissionGranted && this.previewSurfaceReady && this.isCameraHostResumed) {
            if (this.cameraBound || this.cameraStartRequested) {
                return;
            }
            startCamera();
            return;
        }
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("tryStartCamera waiting: perm=%s surface=%s", Arrays.copyOf(new Object[]{Boolean.valueOf(this.permissionGranted), Boolean.valueOf(this.previewSurfaceReady)}, 2));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C4148a.d(TAG, str, false, 4, null);
    }

    public final void Y(String text, boolean ok, String reason) {
        this.timeFmt.format(new Date());
        String str = ok ? "✓ MATCH" : "✗ MISS";
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str2 = String.format("scan %s raw=%s reason=%s", Arrays.copyOf(new Object[]{str, text, reason}, 3));
        kotlin.jvm.internal.p.h(str2, "format(...)");
        C4148a.d(TAG, str2, false, 4, null);
    }

    public final void Z(String text) {
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("debug %s", Arrays.copyOf(new Object[]{text}, 1));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C4148a.d(TAG, str, false, 4, null);
    }

    public final void a0(int bufWidth, int bufHeight) {
        C1123g c1123g = this.binding;
        C1123g c1123g2 = null;
        if (c1123g == null) {
            kotlin.jvm.internal.p.A("binding");
            c1123g = null;
        }
        Object parent = c1123g.previewView.getParent();
        View view = parent instanceof View ? (View) parent : null;
        if (view == null) {
            return;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        if (width == 0 || height == 0 || bufWidth == 0 || bufHeight == 0) {
            return;
        }
        float fMin = Math.min(bufWidth, bufHeight);
        float fMax = Math.max(bufWidth, bufHeight);
        float fMax2 = Math.max(width / fMin, height / fMax);
        C1123g c1123g3 = this.binding;
        if (c1123g3 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1123g3 = null;
        }
        ViewGroup.LayoutParams layoutParams = c1123g3.previewView.getLayoutParams();
        kotlin.jvm.internal.p.g(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.width = (int) (fMin * fMax2);
        layoutParams2.height = (int) (fMax * fMax2);
        layoutParams2.gravity = 17;
        C1123g c1123g4 = this.binding;
        if (c1123g4 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c1123g2 = c1123g4;
        }
        c1123g2.previewView.setLayoutParams(layoutParams2);
    }

    public final void b0(c.Stepai pair) {
        C1060i.d(C1398p.a(this), null, null, new ScanQrActivity$bindStepai$1(this, pair, null), 3, null);
    }

    public final Integer c0(String opName, int bizCode) {
        if (bizCode == 4005) {
            return Integer.valueOf(R$string.scan_qr_expired);
        }
        switch (bizCode) {
            case 4008:
                return Integer.valueOf(kotlin.jvm.internal.p.d(opName, "bind_stepai_device") ? R$string.scan_qr_device_bound_other : R$string.scan_qr_device_occupied);
            case 4009:
                return Integer.valueOf(R$string.scan_qr_expired_ts);
            case 4010:
                return Integer.valueOf(R$string.scan_qr_account_not_linked);
            default:
                return null;
        }
    }

    public final void e0(c pair) {
        if (pair instanceof c.Clawphone) {
            f0((c.Clawphone) pair);
        } else {
            if (!(pair instanceof c.Stepai)) {
                throw new NoWhenBranchMatchedException();
            }
            b0((c.Stepai) pair);
        }
    }

    public final void f0(c.Clawphone pair) {
        C1060i.d(C1398p.a(this), null, null, new ScanQrActivity$confirmClawphone$1(this, pair, null), 3, null);
    }

    public final i0.c g0(final int generation) {
        return new i0.c() { // from class: com.stepos.ailauncher.agent.aispace.connect.b1
            @Override // D.i0.c
            public final void a(SurfaceRequest surfaceRequest) throws ExecutionException, InterruptedException {
                ScanQrActivity.h0(this.f24006a, generation, surfaceRequest);
            }
        };
    }

    public final String j0(String text) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Uri.parse(text));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        String lowerCase = null;
        if (Result.g(objB)) {
            objB = null;
        }
        Uri uri = (Uri) objB;
        if (uri == null) {
            return "URI.parse 失败（不是合法 URI）";
        }
        String scheme = uri.getScheme();
        if (scheme != null) {
            lowerCase = scheme.toLowerCase(Locale.ROOT);
            kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
        }
        StringBuilder sb2 = new StringBuilder("scheme='" + uri.getScheme() + "' host='" + uri.getHost() + "'");
        if (!La.D.L("pair", uri.getHost(), true)) {
            sb2.append(" — 期望 host=pair");
        }
        if (kotlin.jvm.internal.p.d(lowerCase, "clawphone")) {
            for (String str : C1173v.p(Parameters.DEVICE_ID, "pair_id")) {
                String queryParameter = uri.getQueryParameter(str);
                if (queryParameter == null || La.H.x0(queryParameter)) {
                    sb2.append(" — 缺必填 " + str);
                }
            }
        } else if (kotlin.jvm.internal.p.d(lowerCase, ConnectedAgentsActivity.FILTER_STEPAI)) {
            for (String str2 : C1173v.p("stepai_device_id", "stepai_user_id")) {
                String queryParameter2 = uri.getQueryParameter(str2);
                if (queryParameter2 == null || La.H.x0(queryParameter2)) {
                    sb2.append(" — 缺必填 " + str2);
                }
            }
        } else {
            sb2.append(" — 期望 scheme=clawphone 或 stepai");
        }
        String string = sb2.toString();
        kotlin.jvm.internal.p.h(string, "toString(...)");
        return string;
    }

    public final void k0() {
        Z("→ 顺势拉 /GetDeviceAgentList...");
        C1060i.d(C1398p.a(this), null, null, new ScanQrActivity$fetchAndPrintDeviceList$1(this, null), 3, null);
    }

    public final void l0() {
        Intent intent = getIntent();
        if (intent == null || intent.getBooleanExtra(EXTRA_RETURN_HOME, true)) {
            x0();
        } else {
            finish();
        }
    }

    public final InterfaceC5505a m0() {
        return (InterfaceC5505a) this.scanner.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n0(java.lang.String r10, java.lang.Throwable r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.connect.ScanQrActivity.n0(java.lang.String, java.lang.Throwable, java.lang.String):void");
    }

    public final void o0(String text) {
        String str;
        if (this.hasReturned) {
            return;
        }
        c cVarD = INSTANCE.d(text, q0());
        C1123g c1123g = null;
        if (cVarD == null) {
            if (A0(text)) {
                Y(text, false, j0(text));
                Toast.makeText(this, R$string.scan_qr_invalid_qr, 0).show();
                kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
                String str2 = String.format("ignored non-pair qr: %s", Arrays.copyOf(new Object[]{text}, 1));
                kotlin.jvm.internal.p.h(str2, "format(...)");
                C4148a.u(TAG, str2, false, 4, null);
                return;
            }
            return;
        }
        String strW0 = w0(text);
        String strQ0 = q0();
        if (strW0 != null && !La.H.x0(strQ0) && !La.D.L(strW0, strQ0, true)) {
            if (A0(text)) {
                Y(text, false, "agent 不匹配:二维码=" + strW0 + " 入口=" + strQ0);
                B0(R$string.scan_qr_agent_mismatch);
                kotlin.jvm.internal.y yVar2 = kotlin.jvm.internal.y.f34840a;
                String str3 = String.format("agent mismatch qr=%s entry=%s raw=%s", Arrays.copyOf(new Object[]{strW0, strQ0, text}, 3));
                kotlin.jvm.internal.p.h(str3, "format(...)");
                C4148a.u(TAG, str3, false, 4, null);
                return;
            }
            return;
        }
        if (kotlin.jvm.internal.p.d(text, this.expiredQrText)) {
            return;
        }
        C1123g c1123g2 = this.binding;
        if (c1123g2 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1123g2 = null;
        }
        c1123g2.tvScanMismatch.removeCallbacks(this.hideMismatchRunnable);
        C1123g c1123g3 = this.binding;
        if (c1123g3 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c1123g = c1123g3;
        }
        c1123g.tvScanMismatch.setVisibility(8);
        if (cVarD instanceof c.Clawphone) {
            c.Clawphone clawphone = (c.Clawphone) cVarD;
            str = "[clawphone] deviceId=" + clawphone.getDeviceId() + " pairId=" + clawphone.getPairId() + " agent=" + clawphone.getAgent() + " (fallback=" + q0() + ")";
        } else {
            if (!(cVarD instanceof c.Stepai)) {
                throw new NoWhenBranchMatchedException();
            }
            c.Stepai stepai = (c.Stepai) cVarD;
            str = "[stepai] deviceId=" + stepai.getDeviceId() + " deviceName=" + stepai.getDeviceName() + " userId=" + stepai.getUserId();
        }
        Y(text, true, str);
        this.hasReturned = true;
        this.lastConfirmText = text;
        e0(cVarD);
    }

    @Override // androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        C1123g c1123gC = C1123g.c(getLayoutInflater());
        kotlin.jvm.internal.p.h(c1123gC, "inflate(...)");
        this.binding = c1123gC;
        C1123g c1123g = null;
        if (c1123gC == null) {
            kotlin.jvm.internal.p.A("binding");
            c1123gC = null;
        }
        setContentView(c1123gC.b());
        androidx.appcompat.app.a supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.k();
        }
        getWindow().setNavigationBarColor(-16777216);
        getWindow().setNavigationBarContrastEnforced(false);
        C1123g c1123g2 = this.binding;
        if (c1123g2 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1123g2 = null;
        }
        androidx.core.view.N.u0(c1123g2.b(), new androidx.core.view.A() { // from class: com.stepos.ailauncher.agent.aispace.connect.T0
            @Override // androidx.core.view.A
            public final androidx.core.view.a0 a(View view, androidx.core.view.a0 a0Var) {
                return ScanQrActivity.r0(this.f23981a, view, a0Var);
            }
        });
        C1123g c1123g3 = this.binding;
        if (c1123g3 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1123g3 = null;
        }
        c1123g3.btnBack.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.connect.U0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ScanQrActivity.s0(this.f23983a, view);
            }
        });
        if (ExternalAgent.INSTANCE.b(q0()) == ExternalAgent.STEPAI) {
            C1123g c1123g4 = this.binding;
            if (c1123g4 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1123g4 = null;
            }
            c1123g4.tvScanHint.setText(R$string.scan_qr_hint_body_stepai);
        }
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        kotlin.jvm.internal.p.h(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
        this.cameraExecutor = executorServiceNewSingleThreadExecutor;
        C4148a.d(TAG, "onCreate setup done: CameraX + ML Kit barcode (QR_CODE only)", false, 4, null);
        C1123g c1123g5 = this.binding;
        if (c1123g5 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1123g5 = null;
        }
        c1123g5.previewView.getHolder().addCallback(this.previewSurfaceCallback);
        C1123g c1123g6 = this.binding;
        if (c1123g6 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c1123g = c1123g6;
        }
        c1123g.scanFrame.post(new Runnable() { // from class: com.stepos.ailauncher.agent.aispace.connect.V0
            @Override // java.lang.Runnable
            public final void run() {
                ScanQrActivity.t0(this.f23986a);
            }
        });
        if (androidx.core.content.a.a(this, "android.permission.CAMERA") == 0) {
            this.permissionGranted = true;
            G0();
        } else {
            this.permissionRequestPending = true;
            this.cameraPermissionLauncher.a("android.permission.CAMERA");
        }
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.r, android.app.Activity
    public void onDestroy() {
        C1123g c1123g = this.binding;
        ExecutorService executorService = null;
        if (c1123g == null) {
            kotlin.jvm.internal.p.A("binding");
            c1123g = null;
        }
        c1123g.tvScanMismatch.removeCallbacks(this.hideMismatchRunnable);
        C1123g c1123g2 = this.binding;
        if (c1123g2 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1123g2 = null;
        }
        c1123g2.previewView.getHolder().removeCallback(this.previewSurfaceCallback);
        F0("onDestroy");
        ExecutorService executorService2 = this.cameraExecutor;
        if (executorService2 == null) {
            kotlin.jvm.internal.p.A("cameraExecutor");
        } else {
            executorService = executorService2;
        }
        executorService.shutdown();
        try {
            Result.Companion companion = Result.INSTANCE;
            m0().close();
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.r, android.app.Activity
    public void onPause() {
        this.isCameraHostResumed = false;
        C1123g c1123g = this.binding;
        if (c1123g == null) {
            kotlin.jvm.internal.p.A("binding");
            c1123g = null;
        }
        c1123g.scanFrame.removeCallbacks(this.startScanAnimationRunnable);
        ObjectAnimator objectAnimator = this.scanAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        this.scanAnimator = null;
        F0("onPause");
        super.onPause();
    }

    @Override // androidx.fragment.app.r, android.app.Activity
    public void onResume() {
        super.onResume();
        this.isCameraHostResumed = true;
        this.permissionGranted = androidx.core.content.a.a(this, "android.permission.CAMERA") == 0;
        if (!this.permissionGranted) {
            F0("permissionRevoked");
            if (this.permissionRequestPending) {
                return;
            }
            this.permissionRequestPending = true;
            this.cameraPermissionLauncher.a("android.permission.CAMERA");
            return;
        }
        G0();
        C1123g c1123g = this.binding;
        C1123g c1123g2 = null;
        if (c1123g == null) {
            kotlin.jvm.internal.p.A("binding");
            c1123g = null;
        }
        c1123g.scanFrame.removeCallbacks(this.startScanAnimationRunnable);
        C1123g c1123g3 = this.binding;
        if (c1123g3 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c1123g2 = c1123g3;
        }
        c1123g2.scanFrame.post(this.startScanAnimationRunnable);
    }

    public final String q0() {
        Intent intent = getIntent();
        String stringExtra = intent != null ? intent.getStringExtra(EXTRA_FALLBACK_AGENT) : null;
        return stringExtra == null ? "" : stringExtra;
    }

    public final void u0(final SurfaceRequest request, int generation) throws ExecutionException, InterruptedException {
        C1123g c1123g = this.binding;
        if (c1123g == null) {
            kotlin.jvm.internal.p.A("binding");
            c1123g = null;
        }
        SurfaceHolder holder = c1123g.previewView.getHolder();
        if (generation != this.cameraBindGeneration || !this.previewSurfaceReady || !holder.getSurface().isValid()) {
            request.u();
            return;
        }
        this.activeSurfaceRequest = request;
        Surface surface = holder.getSurface();
        kotlin.jvm.internal.p.h(surface, "getSurface(...)");
        request.r(surface, androidx.core.content.a.h(this), new B0.a() { // from class: com.stepos.ailauncher.agent.aispace.connect.a1
            @Override // B0.a
            public final void accept(Object obj) {
                ScanQrActivity.v0(this.f24003a, request, (SurfaceRequest.f) obj);
            }
        });
    }

    public final String w0(String text) {
        Object objB;
        String lowerCase;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Uri.parse(text));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        Uri uri = (Uri) objB;
        if (uri == null) {
            return null;
        }
        String scheme = uri.getScheme();
        if (scheme != null) {
            lowerCase = scheme.toLowerCase(Locale.ROOT);
            kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
        } else {
            lowerCase = null;
        }
        if (!kotlin.jvm.internal.p.d(lowerCase, "clawphone")) {
            if (kotlin.jvm.internal.p.d(lowerCase, ConnectedAgentsActivity.FILTER_STEPAI)) {
                return ExternalAgent.STEPAI.getId();
            }
            return null;
        }
        String queryParameter = uri.getQueryParameter("agent");
        if (queryParameter == null || La.H.x0(queryParameter)) {
            return null;
        }
        return queryParameter;
    }

    public final void x0() {
        com.stepos.ailauncher.agent.aispace.v.INSTANCE.a("agent");
        Log.i(TAG, "returnToAgentTab: requestSelect(agent), starting HOME intent");
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        startActivity(intent);
        finish();
    }

    public final void z0(String deviceId, String agent, String deviceName) {
        Intent intent = new Intent();
        intent.putExtra(EXTRA_ALREADY_CONFIRMED, true);
        intent.putExtra(EXTRA_DEVICE_ID, deviceId);
        intent.putExtra(EXTRA_AGENT, agent);
        intent.putExtra(EXTRA_DEVICE_NAME, deviceName);
        Y8.t tVar = Y8.t.f7040a;
        setResult(-1, intent);
    }
}
