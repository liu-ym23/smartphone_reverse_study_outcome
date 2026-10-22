package com.stepos.ailauncher.chat.voice.motionkit;

import La.C0953c;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RuntimeShader;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.Log;
import android.view.Choreographer;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voice.motionkit.C3080u;
import com.stepos.launcher.assistant.slidepanel.ConstConfig;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.sequences.SequencesKt___SequencesKt;
import p9.InterfaceC5074l;
import s7.EffectDefinition;
import s7.w;
import v9.C5685n;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 S2\u00020\u0001:\u0002TUB\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\fJ\u0015\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\fJ\u001d\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\b¢\u0006\u0004\b\u0017\u0010\fJ\r\u0010\u0018\u001a\u00020\n¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\n¢\u0006\u0004\b\u001a\u0010\u0019J\r\u0010\u001b\u001a\u00020\n¢\u0006\u0004\b\u001b\u0010\u0019J\u000f\u0010\u001c\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001c\u0010\u0019J\u000f\u0010\u001d\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001d\u0010\u0019J\u000f\u0010\u001e\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001e\u0010\u0019J\u000f\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b \u0010!J\u0019\u0010$\u001a\u00020\b2\b\b\u0002\u0010#\u001a\u00020\"H\u0002¢\u0006\u0004\b$\u0010%J\u001f\u0010(\u001a\u00020\n2\u0006\u0010'\u001a\u00020&2\u0006\u0010\r\u001a\u00020\bH\u0002¢\u0006\u0004\b(\u0010)R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010*R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010+R0\u0010/\u001a\u001e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020-0,j\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020-`.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00101\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0014\u00104\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0014\u00107\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010:\u001a\u0002098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010<\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010>\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010@\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010?R\u0016\u0010A\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010?R\u0016\u0010B\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010D\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010CR\u0014\u0010F\u001a\u00020E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010H\u001a\u00020E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010GR\u001c\u0010K\u001a\n J*\u0004\u0018\u00010I0I8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010N\u001a\u00020M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0014\u0010Q\u001a\u00020P8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010R¨\u0006V"}, d2 = {"Lcom/stepos/ailauncher/chat/voice/motionkit/u;", "", "Landroid/view/View;", "anchorView", "Ls7/e;", "effect", "<init>", "(Landroid/view/View;Ls7/e;)V", "", ConstConfig.KEY_VIEW_SCALE_PROPERTY, "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(F)V", UxipConstants.f30680s, "n", "px", "l", "", "width", "height", "s", "(II)V", "progress", "k", "o", "()V", "f", "e", Const.INTENT_KEY_BACKGROUND_COMMAND, "p", "q", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Z", "", "now", "t", "(J)F", "", "name", "m", "(Ljava/lang/String;F)V", "Landroid/view/View;", "Ls7/e;", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "live", "Ljava/util/LinkedHashMap;", "shaderSource", "Ljava/lang/String;", "Landroid/widget/FrameLayout;", "surfaceParent", "Landroid/widget/FrameLayout;", "Landroid/view/SurfaceView;", "surfaceView", "Landroid/view/SurfaceView;", "Lcom/stepos/ailauncher/chat/voice/motionkit/u$b;", "renderer", "Lcom/stepos/ailauncher/chat/voice/motionkit/u$b;", "visualAtMs", "J", "released", "Z", "clockPosted", "destroyed", "volume", "F", "defaultAmplitude", "", "anchorLocation", "[I", "parentLocation", "Landroid/view/ViewTreeObserver;", "kotlin.jvm.PlatformType", "boundsObserver", "Landroid/view/ViewTreeObserver;", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "boundsListener", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "Landroid/view/Choreographer$FrameCallback;", "sceneClock", "Landroid/view/Choreographer$FrameCallback;", "Companion", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.voice.motionkit.u, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3080u {
    private static final String TAG = "SurfaceInputBarWave";
    private final int[] anchorLocation;
    private final View anchorView;
    private final ViewTreeObserver.OnPreDrawListener boundsListener;
    private final ViewTreeObserver boundsObserver;
    private boolean clockPosted;
    private final float defaultAmplitude;
    private boolean destroyed;
    private final EffectDefinition effect;
    private final LinkedHashMap<String, float[]> live;
    private final int[] parentLocation;
    private boolean released;
    private final b renderer;
    private final Choreographer.FrameCallback sceneClock;
    private final String shaderSource;
    private final FrameLayout surfaceParent;
    private final SurfaceView surfaceView;
    private long visualAtMs;
    private float volume;

    @Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ!\u0010\r\u001a\u00020\f2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\f¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ/\u0010\"\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b$\u0010\u001dJ\u0017\u0010%\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b%\u0010\u0019R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010&R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010'R\u0014\u0010)\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010,\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010/\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00102\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00103R0\u00107\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000705j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007`68\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u001f\u0010;\u001a\r\u0012\t\u0012\u00070\u0004¢\u0006\u0002\b:098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010>\u001a\u00020=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010?R\u0016\u0010A\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010D\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010G\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00020\u0004098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010<R\u0014\u0010K\u001a\u00020J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010M\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010O\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010N¨\u0006P"}, d2 = {"Lcom/stepos/ailauncher/chat/voice/motionkit/u$b;", "Landroid/view/SurfaceHolder$Callback;", "Landroid/view/SurfaceHolder;", "holder", "", "source", "", "", "initialUniforms", "<init>", "(Landroid/view/SurfaceHolder;Ljava/lang/String;Ljava/util/Map;)V", "values", "LY8/t;", Const.INTENT_KEY_UMID, "(Ljava/util/Map;)V", "name", "", UxipConstants.f30680s, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;F)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "(F)V", "", "elapsedMs", "e", "(J)V", "c", "()V", "surfaceCreated", "(Landroid/view/SurfaceHolder;)V", "", "format", "width", "height", "surfaceChanged", "(Landroid/view/SurfaceHolder;III)V", "surfaceDestroyed", Const.INTENT_KEY_PKGNAME, "Landroid/view/SurfaceHolder;", "Ljava/lang/String;", "Landroid/os/HandlerThread;", "renderThread", "Landroid/os/HandlerThread;", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "framePending", "Ljava/util/concurrent/atomic/AtomicBoolean;", "", "lock", "Ljava/lang/Object;", "surfaceLock", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "uniforms", "Ljava/util/LinkedHashMap;", "", "Lkotlin/jvm/internal/EnhancedNullability;", "dirtyUniforms", "Ljava/util/Set;", "", "running", "Z", "surfaceReady", "latestElapsedMs", "J", "Landroid/graphics/RuntimeShader;", "shader", "Landroid/graphics/RuntimeShader;", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Paint;", "invalidUniforms", "Landroid/graphics/ColorMatrix;", "colorMatrix", "Landroid/graphics/ColorMatrix;", "appliedSaturation", "F", "saturation", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.voice.motionkit.u$b */
    public static final class b implements SurfaceHolder.Callback {
        private float appliedSaturation;
        private final ColorMatrix colorMatrix;
        private final Set<String> dirtyUniforms;
        private final AtomicBoolean framePending;
        private final Handler handler;
        private final SurfaceHolder holder;
        private final Set<String> invalidUniforms;
        private volatile long latestElapsedMs;
        private final Object lock;
        private Paint paint;
        private final HandlerThread renderThread;
        private volatile boolean running;
        private volatile float saturation;
        private RuntimeShader shader;
        private final String source;
        private final Object surfaceLock;
        private volatile boolean surfaceReady;
        private final LinkedHashMap<String, float[]> uniforms;

        public b(SurfaceHolder holder, String source, Map<String, float[]> initialUniforms) {
            kotlin.jvm.internal.p.i(holder, "holder");
            kotlin.jvm.internal.p.i(source, "source");
            kotlin.jvm.internal.p.i(initialUniforms, "initialUniforms");
            this.holder = holder;
            this.source = source;
            HandlerThread handlerThread = new HandlerThread("InputBarWaveSurface");
            handlerThread.start();
            this.renderThread = handlerThread;
            this.handler = new Handler(handlerThread.getLooper());
            this.framePending = new AtomicBoolean(false);
            this.lock = new Object();
            this.surfaceLock = new Object();
            LinkedHashMap<String, float[]> linkedHashMap = new LinkedHashMap<>();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(Z8.Q.e(initialUniforms.size()));
            Iterator<T> it = initialUniforms.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Object key = entry.getKey();
                float[] fArr = (float[]) entry.getValue();
                float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
                kotlin.jvm.internal.p.h(fArrCopyOf, "copyOf(...)");
                linkedHashMap2.put(key, fArrCopyOf);
            }
            linkedHashMap.putAll(linkedHashMap2);
            this.uniforms = linkedHashMap;
            Set<String> setKeySet = linkedHashMap.keySet();
            kotlin.jvm.internal.p.h(setKeySet, "<get-keys>(...)");
            this.dirtyUniforms = Z8.F.q1(setKeySet);
            this.running = true;
            this.invalidUniforms = new LinkedHashSet();
            this.colorMatrix = new ColorMatrix();
            this.appliedSaturation = 1.0f;
            this.saturation = 1.0f;
            this.holder.addCallback(this);
        }

        public static final void f(b bVar) {
            long j10 = bVar.latestElapsedMs;
            try {
                synchronized (bVar.surfaceLock) {
                    try {
                        if (bVar.running && bVar.surfaceReady) {
                            bVar.b(j10);
                        }
                        Y8.t tVar = Y8.t.f7040a;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } finally {
                bVar.framePending.set(false);
                if (bVar.running && bVar.surfaceReady && bVar.latestElapsedMs != j10) {
                    bVar.e(bVar.latestElapsedMs);
                }
            }
        }

        public final void b(long elapsedMs) {
            Object objB;
            Object objB2;
            Throwable thE;
            float width;
            float height;
            Paint paint;
            Object objB3;
            Object objB4;
            Object objB5;
            Surface surface = this.holder.getSurface();
            if (surface.isValid()) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    objB = Result.b(surface.lockHardwareCanvas());
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th));
                }
                Throwable thE2 = Result.e(objB);
                if (thE2 != null) {
                    Log.e(C3080u.TAG, "lockHardwareCanvas failed", thE2);
                }
                boolean zG = Result.g(objB);
                ColorMatrixColorFilter colorMatrixColorFilter = null;
                Object obj = objB;
                if (zG) {
                    obj = null;
                }
                Canvas canvas = (Canvas) obj;
                if (canvas == null) {
                    return;
                }
                try {
                    canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                    RuntimeShader runtimeShader = this.shader;
                    if (runtimeShader == null) {
                        runtimeShader = new RuntimeShader(this.source);
                        this.shader = runtimeShader;
                        Paint paint2 = new Paint(1);
                        paint2.setShader(runtimeShader);
                        this.paint = paint2;
                    }
                    RuntimeShader runtimeShader2 = runtimeShader;
                    float f10 = this.saturation;
                    if (this.appliedSaturation != f10) {
                        this.colorMatrix.setSaturation(f10);
                        Paint paint3 = this.paint;
                        if (paint3 != null) {
                            if (f10 != 1.0f) {
                                colorMatrixColorFilter = new ColorMatrixColorFilter(this.colorMatrix);
                            }
                            paint3.setColorFilter(colorMatrixColorFilter);
                        }
                        this.appliedSaturation = f10;
                    }
                    synchronized (this.lock) {
                        try {
                        } catch (Throwable th2) {
                            Result.Companion companion3 = Result.INSTANCE;
                            objB5 = Result.b(C4849c.a(th2));
                        } finally {
                        }
                        for (String str : this.dirtyUniforms) {
                            float[] fArr = (float[]) kotlin.collections.a.j(this.uniforms, str);
                            if (!this.invalidUniforms.contains(str)) {
                                Result.Companion companion4 = Result.INSTANCE;
                                int length = fArr.length;
                                if (length == 1) {
                                    runtimeShader2.setFloatUniform(str, fArr[0]);
                                } else if (length == 2) {
                                    runtimeShader2.setFloatUniform(str, fArr[0], fArr[1]);
                                } else if (length == 3) {
                                    runtimeShader2.setFloatUniform(str, fArr[0], fArr[1], fArr[2]);
                                } else if (length == 4) {
                                    runtimeShader2.setFloatUniform(str, fArr[0], fArr[1], fArr[2], fArr[3]);
                                }
                                objB5 = Result.b(Y8.t.f7040a);
                                if (Result.e(objB5) != null) {
                                    this.invalidUniforms.add(str);
                                }
                            }
                        }
                        this.dirtyUniforms.clear();
                        Y8.t tVar = Y8.t.f7040a;
                    }
                    runtimeShader2.setFloatUniform("iResolution", canvas.getWidth(), canvas.getHeight());
                    runtimeShader2.setFloatUniform("iTime", elapsedMs / 1000.0f);
                    width = canvas.getWidth();
                    height = canvas.getHeight();
                    paint = this.paint;
                } catch (Throwable th3) {
                    try {
                        Log.e(C3080u.TAG, "surface render failed", th3);
                        try {
                            Result.Companion companion5 = Result.INSTANCE;
                            surface.unlockCanvasAndPost(canvas);
                            objB2 = Result.b(Y8.t.f7040a);
                        } catch (Throwable th4) {
                            Result.Companion companion6 = Result.INSTANCE;
                            objB2 = Result.b(C4849c.a(th4));
                        }
                        thE = Result.e(objB2);
                        if (thE == null) {
                            return;
                        }
                    } finally {
                    }
                }
                if (paint == null) {
                    try {
                        Result.Companion companion7 = Result.INSTANCE;
                        surface.unlockCanvasAndPost(canvas);
                        objB3 = Result.b(Y8.t.f7040a);
                    } catch (Throwable th5) {
                        Result.Companion companion8 = Result.INSTANCE;
                        objB3 = Result.b(C4849c.a(th5));
                    }
                    Throwable thE3 = Result.e(objB3);
                    if (thE3 != null) {
                        Log.e(C3080u.TAG, "unlockCanvasAndPost failed", thE3);
                        Y8.t tVar2 = Y8.t.f7040a;
                        return;
                    }
                    return;
                }
                canvas.drawRect(0.0f, 0.0f, width, height, paint);
                try {
                    Result.Companion companion9 = Result.INSTANCE;
                    surface.unlockCanvasAndPost(canvas);
                    objB4 = Result.b(Y8.t.f7040a);
                } catch (Throwable th6) {
                    Result.Companion companion10 = Result.INSTANCE;
                    objB4 = Result.b(C4849c.a(th6));
                }
                thE = Result.e(objB4);
                if (thE == null) {
                    return;
                }
                Log.e(C3080u.TAG, "unlockCanvasAndPost failed", thE);
            }
        }

        public final void c() {
            this.running = false;
            synchronized (this.surfaceLock) {
                this.surfaceReady = false;
                Y8.t tVar = Y8.t.f7040a;
            }
            this.holder.removeCallback(this);
            this.handler.removeCallbacksAndMessages(null);
            this.renderThread.quitSafely();
        }

        public final void d(Map<String, float[]> values) {
            kotlin.jvm.internal.p.i(values, "values");
            synchronized (this.lock) {
                try {
                    this.uniforms.clear();
                    LinkedHashMap<String, float[]> linkedHashMap = this.uniforms;
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap(Z8.Q.e(values.size()));
                    for (Object obj : values.entrySet()) {
                        Object key = ((Map.Entry) obj).getKey();
                        float[] fArr = (float[]) ((Map.Entry) obj).getValue();
                        float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
                        kotlin.jvm.internal.p.h(fArrCopyOf, "copyOf(...)");
                        linkedHashMap2.put(key, fArrCopyOf);
                    }
                    linkedHashMap.putAll(linkedHashMap2);
                    this.dirtyUniforms.addAll(values.keySet());
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final void e(long elapsedMs) {
            this.latestElapsedMs = elapsedMs;
            if (this.running && this.surfaceReady && this.framePending.compareAndSet(false, true)) {
                this.handler.post(new Runnable() { // from class: com.stepos.ailauncher.chat.voice.motionkit.v
                    @Override // java.lang.Runnable
                    public final void run() {
                        C3080u.b.f(this.f26508a);
                    }
                });
            }
        }

        public final void g(float value) {
            this.saturation = value;
        }

        public final void h(String name, float value) {
            kotlin.jvm.internal.p.i(name, "name");
            synchronized (this.lock) {
                try {
                    LinkedHashMap<String, float[]> linkedHashMap = this.uniforms;
                    float[] fArr = linkedHashMap.get(name);
                    if (fArr == null) {
                        fArr = new float[1];
                        linkedHashMap.put(name, fArr);
                    }
                    fArr[0] = value;
                    this.dirtyUniforms.add(name);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            kotlin.jvm.internal.p.i(holder, "holder");
            e(this.latestElapsedMs);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder holder) {
            kotlin.jvm.internal.p.i(holder, "holder");
            if (this.running) {
                this.surfaceReady = true;
                e(this.latestElapsedMs);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder holder) {
            kotlin.jvm.internal.p.i(holder, "holder");
            synchronized (this.surfaceLock) {
                this.surfaceReady = false;
                Y8.t tVar = Y8.t.f7040a;
            }
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.voice.motionkit.u$c */
    public static final class c implements InterfaceC5074l<Object, Boolean> {
        public static final c INSTANCE = new c();

        @Override // p9.InterfaceC5074l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Object obj) {
            return Boolean.valueOf(obj instanceof FrameLayout);
        }
    }

    public C3080u(View anchorView, EffectDefinition effect) throws Exception {
        kotlin.jvm.internal.p.i(anchorView, "anchorView");
        kotlin.jvm.internal.p.i(effect, "effect");
        this.anchorView = anchorView;
        this.effect = effect;
        LinkedHashMap<String, float[]> linkedHashMap = new LinkedHashMap<>();
        Map<String, float[]> mapL = O.l(effect);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(Z8.Q.e(mapL.size()));
        Iterator<T> it = mapL.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            float[] fArr = (float[]) entry.getValue();
            float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
            kotlin.jvm.internal.p.h(fArrCopyOf, "copyOf(...)");
            linkedHashMap2.put(key, fArrCopyOf);
        }
        linkedHashMap.putAll(linkedHashMap2);
        this.live = linkedHashMap;
        String shaderAsset = this.effect.getShaderAsset();
        if (shaderAsset != null) {
            InputStream inputStreamOpen = this.anchorView.getContext().getAssets().open("motionkit/shaders/" + shaderAsset);
            kotlin.jvm.internal.p.h(inputStreamOpen, "open(...)");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen, C0953c.UTF_8), com.stepos.agentframework.chatui.longtext.b.THRESHOLD);
            try {
                String strE = l9.m.e(bufferedReader);
                Object obj = null;
                l9.b.a(bufferedReader, null);
                if (strE != null) {
                    this.shaderSource = strE;
                    Ka.j jVarF = SequencesKt___SequencesKt.F(Ka.t.q(this.anchorView.getParent(), new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.voice.motionkit.r
                        @Override // p9.InterfaceC5074l
                        public final Object invoke(Object obj2) {
                            return C3080u.r((ViewParent) obj2);
                        }
                    }), c.INSTANCE);
                    kotlin.jvm.internal.p.g(jVarF, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
                    Iterator it2 = jVarF.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        Object next = it2.next();
                        if (((FrameLayout) next).getId() == 16908290) {
                            obj = next;
                            break;
                        }
                    }
                    FrameLayout frameLayout = (FrameLayout) obj;
                    if (frameLayout == null) {
                        throw new IllegalStateException("InputBar Surface backend requires Activity content FrameLayout");
                    }
                    this.surfaceParent = frameLayout;
                    SurfaceView surfaceView = new SurfaceView(this.anchorView.getContext());
                    surfaceView.setZOrderOnTop(true);
                    surfaceView.getHolder().setFormat(-3);
                    surfaceView.setBackgroundColor(0);
                    surfaceView.setClickable(false);
                    surfaceView.setFocusable(false);
                    surfaceView.setImportantForAccessibility(4);
                    this.surfaceView = surfaceView;
                    SurfaceHolder holder = surfaceView.getHolder();
                    kotlin.jvm.internal.p.h(holder, "getHolder(...)");
                    this.renderer = new b(holder, this.shaderSource, this.live);
                    this.volume = C3071k.INSTANCE.a();
                    List<s7.w> listI = this.effect.i();
                    ArrayList<w.b> arrayList = new ArrayList();
                    for (Object obj2 : listI) {
                        if (obj2 instanceof w.b) {
                            arrayList.add(obj2);
                        }
                    }
                    for (w.b bVar : arrayList) {
                        if (kotlin.jvm.internal.p.d(bVar.getName(), "uAmp")) {
                            this.defaultAmplitude = bVar.getDefault();
                            this.anchorLocation = new int[2];
                            this.parentLocation = new int[2];
                            ViewTreeObserver viewTreeObserver = this.anchorView.getViewTreeObserver();
                            this.boundsObserver = viewTreeObserver;
                            ViewTreeObserver.OnPreDrawListener onPreDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: com.stepos.ailauncher.chat.voice.motionkit.s
                                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                                public final boolean onPreDraw() {
                                    return C3080u.d(this.f26506a);
                                }
                            };
                            this.boundsListener = onPreDrawListener;
                            this.sceneClock = new Choreographer.FrameCallback() { // from class: com.stepos.ailauncher.chat.voice.motionkit.t
                                @Override // android.view.Choreographer.FrameCallback
                                public final void doFrame(long j10) {
                                    C3080u.i(this.f26507a, j10);
                                }
                            };
                            this.live.put("uWaveTime", new float[]{-1.0f});
                            this.live.put("uReleaseAt", new float[]{-1.0f});
                            this.live.put("uStartAt", new float[]{-1.0f});
                            this.live.put("uExtEnergy", new float[]{1.0f});
                            this.live.put("uEnergyIn", new float[]{this.volume});
                            this.live.put("uPxPerDp", new float[]{this.anchorView.getResources().getDisplayMetrics().density});
                            LinkedHashMap<String, float[]> linkedHashMap3 = this.live;
                            float[] fArr2 = linkedHashMap3.get("uShaderRefract");
                            linkedHashMap3.put("uShaderRefract", fArr2 == null ? new float[]{0.0f} : fArr2);
                            this.renderer.d(this.live);
                            try {
                                this.surfaceParent.addView(this.surfaceView, new FrameLayout.LayoutParams(1, 1));
                                viewTreeObserver.addOnPreDrawListener(onPreDrawListener);
                                return;
                            } catch (Exception e10) {
                                this.renderer.c();
                                this.surfaceParent.removeView(this.surfaceView);
                                throw e10;
                            }
                        }
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }
            } finally {
            }
        }
        throw new IllegalStateException("InputBar Surface backend requires shaderAsset");
    }

    public static final boolean d(C3080u c3080u) {
        boolean z10 = c3080u.anchorView.isShown() && c3080u.anchorView.getWindowVisibility() == 0;
        c3080u.surfaceView.setVisibility(z10 ? 0 : 4);
        c3080u.s(c3080u.anchorView.getWidth(), c3080u.anchorView.getHeight());
        if (z10 && c3080u.visualAtMs > 0) {
            c3080u.p();
        }
        return true;
    }

    public static final void i(C3080u c3080u, long j10) {
        c3080u.clockPosted = false;
        if (c3080u.h()) {
            c3080u.p();
        }
    }

    public static final ViewParent r(ViewParent it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getParent();
    }

    public final void e() {
        if (this.destroyed) {
            return;
        }
        this.destroyed = true;
        q();
        if (this.boundsObserver.isAlive()) {
            this.boundsObserver.removeOnPreDrawListener(this.boundsListener);
        } else {
            this.anchorView.getViewTreeObserver().removeOnPreDrawListener(this.boundsListener);
        }
        this.renderer.c();
        this.surfaceParent.removeView(this.surfaceView);
    }

    public final void f() {
        if (this.destroyed) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j10 = this.visualAtMs;
        if (j10 <= 0 || jElapsedRealtime < j10) {
            g();
        } else {
            if (this.released) {
                return;
            }
            this.released = true;
            m("uReleaseAt", t(jElapsedRealtime));
            p();
        }
    }

    public final void g() {
        this.visualAtMs = 0L;
        this.released = false;
        m("uWaveTime", -1.0f);
        this.renderer.e(SystemClock.elapsedRealtime());
        q();
    }

    public final boolean h() {
        Float fH0;
        Float fH02;
        if (this.visualAtMs <= 0 || !this.anchorView.isShown() || this.anchorView.getWindowVisibility() != 0) {
            return false;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        float fT = t(jElapsedRealtime);
        if (this.released) {
            float[] fArr = this.live.get("uReleaseAt");
            float fFloatValue = (fArr == null || (fH02 = Z8.r.h0(fArr, 0)) == null) ? -1.0f : fH02.floatValue();
            float[] fArr2 = this.live.get("uExitDur");
            if (fT >= fFloatValue + C5685n.e((fArr2 == null || (fH0 = Z8.r.h0(fArr2, 0)) == null) ? 0.433f : fH0.floatValue(), 0.05f)) {
                g();
                return false;
            }
        }
        m("uWaveTime", fT);
        this.renderer.e(jElapsedRealtime);
        return true;
    }

    public final void j(float scale) {
        m("uAmp", this.defaultAmplitude * scale);
    }

    public final void k(float progress) {
        float fM = C5685n.m(progress, 0.0f, 1.0f);
        j(1.0f - (0.5f * fM));
        this.renderer.g(1.0f - fM);
    }

    public final void l(float px) {
        m("uCornerPx", C5685n.e(px, 0.0f));
    }

    public final void m(String name, float value) {
        if (this.destroyed) {
            return;
        }
        float[] fArr = this.live.get(name);
        if (kotlin.jvm.internal.p.b(fArr != null ? Z8.r.h0(fArr, 0) : null, value)) {
            return;
        }
        LinkedHashMap<String, float[]> linkedHashMap = this.live;
        float[] fArr2 = linkedHashMap.get(name);
        if (fArr2 == null) {
            fArr2 = new float[1];
            linkedHashMap.put(name, fArr2);
        }
        fArr2[0] = value;
        this.renderer.h(name, value);
    }

    public final void n(float value) {
        float fM = C5685n.m(value, 0.0f, 1.0f);
        this.volume = fM;
        m("uEnergyIn", fM);
    }

    public final void o() {
        if (this.destroyed) {
            return;
        }
        this.released = false;
        this.visualAtMs = SystemClock.elapsedRealtime();
        m("uReleaseAt", -1.0f);
        m("uWaveTime", 0.0f);
        p();
    }

    public final void p() {
        if (this.destroyed || this.clockPosted) {
            return;
        }
        this.clockPosted = true;
        Choreographer.getInstance().postFrameCallback(this.sceneClock);
    }

    public final void q() {
        if (this.clockPosted) {
            this.clockPosted = false;
            Choreographer.getInstance().removeFrameCallback(this.sceneClock);
        }
    }

    public final void s(int width, int height) {
        if (this.destroyed || width <= 0 || height <= 0) {
            return;
        }
        this.anchorView.getLocationInWindow(this.anchorLocation);
        this.surfaceParent.getLocationInWindow(this.parentLocation);
        int[] iArr = this.anchorLocation;
        int i10 = iArr[0];
        int[] iArr2 = this.parentLocation;
        int i11 = i10 - iArr2[0];
        int i12 = iArr[1] - iArr2[1];
        ViewGroup.LayoutParams layoutParams = this.surfaceView.getLayoutParams();
        kotlin.jvm.internal.p.g(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        if (layoutParams2.width == width && layoutParams2.height == height && layoutParams2.leftMargin == i11 && layoutParams2.topMargin == i12 && layoutParams2.gravity == 51) {
            return;
        }
        SurfaceView surfaceView = this.surfaceView;
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(width, height);
        layoutParams3.gravity = 51;
        layoutParams3.leftMargin = i11;
        layoutParams3.topMargin = i12;
        surfaceView.setLayoutParams(layoutParams3);
    }

    public final float t(long now) {
        long j10 = this.visualAtMs;
        if (j10 <= 0 || now < j10) {
            return -1.0f;
        }
        return (now - j10) / 1000.0f;
    }

    public /* synthetic */ C3080u(View view, EffectDefinition effectDefinition, int i10, kotlin.jvm.internal.i iVar) {
        this(view, (i10 & 2) != 0 ? C3063c.a() : effectDefinition);
    }
}
