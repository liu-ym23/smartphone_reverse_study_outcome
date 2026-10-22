package N4;

import Y8.t;
import Z8.C1173v;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.os.Trace;
import android.view.Choreographer;
import android.widget.ImageView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentsprite.SceneLayerSpec;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilityContract;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland;
import io.ktor.http.LinkHeader;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000}\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b*\u0001W\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u000eJ\r\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u000eJ\r\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b\u0011\u0010\u000eJ\u000f\u0010\u0012\u001a\u00020\nH\u0014¢\u0006\u0004\b\u0012\u0010\u000eJ\u000f\u0010\u0013\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0013\u0010\u000eJ\u000f\u0010\u0014\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0014\u0010\u000eJ\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u001e\u0010\u001cJ\u000f\u0010\u001f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001f\u0010\u000eJ\u0017\u0010!\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u0015H\u0002¢\u0006\u0004\b!\u0010\u001cR\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00150\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010(\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010*R\u0016\u00100\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010/R0\u00104\u001a\u001e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u001701j\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0017`28\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u00103R\u0014\u00105\u001a\u00020\u00158\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0013\u0010*R\u0016\u00108\u001a\u0002068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u00107R\u0016\u00109\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010/R\u0016\u0010;\u001a\u0002068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u00107R\u0016\u0010=\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010*R\u0016\u0010>\u001a\u0002068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u00107R\u0016\u0010?\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010*R*\u0010F\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010@8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER*\u0010I\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010@8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010A\u001a\u0004\bG\u0010C\"\u0004\bH\u0010ER*\u0010L\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010@8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010A\u001a\u0004\bJ\u0010C\"\u0004\bK\u0010ER\u0016\u0010M\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010*R\u0018\u0010P\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010OR\u0018\u0010T\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u0014\u0010V\u001a\u00020Q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010SR\u0014\u0010Z\u001a\u00020W8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\"\u0010b\u001a\u00020[8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010a¨\u0006c"}, d2 = {"LN4/j;", "Landroid/widget/ImageView;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Lcom/stepos/agentsprite/SceneLayerSpec$b;", "spec", "Landroid/content/res/Resources;", "resources", "LY8/t;", "n", "(Lcom/stepos/agentsprite/SceneLayerSpec$b;Landroid/content/res/Resources;)V", "p", "()V", "l", "q", "o", "onDetachedFromWindow", Const.INTENT_KEY_BACKGROUND_COMMAND, "r", "", "idx", "Landroid/graphics/Bitmap;", "f", "(I)Landroid/graphics/Bitmap;", "from", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(I)V", "current", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "e", "keepIdx", "m", "", Const.INTENT_KEY_APIKEY, "Ljava/util/List;", "resIds", Const.INTENT_KEY_PKGNAME, "Landroid/content/res/Resources;", "res", "c", "I", "fps", Const.INTENT_KEY_UMID, "loop", "", "J", "periodMs", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "cache", LinkHeader.Rel.Prefetch, "", "Z", "lazy", "startTimeMs", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "running", "k", "currentIdx", AlipayXuiIsland.REASON_ENDED, "lastLoopFired", "Lkotlin/Function0;", "Lp9/a;", "getOnLoad", "()Lp9/a;", "setOnLoad", "(Lp9/a;)V", "onLoad", "getOnEnd", "setOnEnd", "onEnd", "getOnRepeat", "setOnRepeat", "onRepeat", HomeGestureEligibilityContract.EXTRA_GENERATION, "Landroid/os/HandlerThread;", "Landroid/os/HandlerThread;", "decodeThread", "Landroid/os/Handler;", "s", "Landroid/os/Handler;", "decodeHandler", "t", "mainHandler", "N4/j$a", "u", "LN4/j$a;", "callback", "", "v", "Ljava/lang/String;", "getDiagLabel", "()Ljava/lang/String;", "setDiagLabel", "(Ljava/lang/String;)V", "diagLabel", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class j extends ImageView {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public List<Integer> resIds;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public Resources res;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public int fps;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public int loop;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public long periodMs;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final HashMap<Integer, Bitmap> cache;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final int prefetch;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public boolean lazy;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public long startTimeMs;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public boolean running;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public int currentIdx;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public boolean ended;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public int lastLoopFired;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public InterfaceC5063a<t> onLoad;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    public InterfaceC5063a<t> onEnd;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    public InterfaceC5063a<t> onRepeat;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    public volatile int generation;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    public HandlerThread decodeThread;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    public Handler decodeHandler;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    public final Handler mainHandler;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    public final a callback;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    public String diagLabel;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"N4/j$a", "Landroid/view/Choreographer$FrameCallback;", "", "frameTimeNanos", "LY8/t;", "doFrame", "(J)V", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a implements Choreographer.FrameCallback {
        public a() {
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long frameTimeNanos) {
            if (j.this.running) {
                M4.d dVar = M4.d.f4544a;
                j jVar = j.this;
                Trace.beginSection("AgentSpriteSDK#Frames");
                try {
                    jVar.r();
                    Choreographer.getInstance().postFrameCallback(this);
                    t tVar = t.f7040a;
                } finally {
                    Trace.endSection();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(Context context) {
        super(context);
        p.i(context, "context");
        setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.resIds = C1173v.m();
        this.fps = 24;
        this.loop = -1;
        this.periodMs = 41L;
        this.cache = new HashMap<>();
        this.prefetch = 3;
        this.lazy = true;
        this.currentIdx = -1;
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.callback = new a();
        this.diagLabel = "";
    }

    public static final void j(final int i10, final j jVar, Resources resources, int i11, final int i12) {
        Object objB;
        if (i10 != jVar.generation) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(BitmapFactory.decodeResource(resources, i11));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        final Bitmap bitmap = (Bitmap) objB;
        if (bitmap == null) {
            return;
        }
        jVar.mainHandler.post(new Runnable() { // from class: N4.i
            @Override // java.lang.Runnable
            public final void run() {
                j.k(i10, jVar, i12, bitmap);
            }
        });
    }

    public static final void k(int i10, j jVar, int i11, Bitmap bitmap) {
        if (i10 != jVar.generation || jVar.cache.containsKey(Integer.valueOf(i11))) {
            bitmap.recycle();
        } else {
            jVar.cache.put(Integer.valueOf(i11), bitmap);
        }
    }

    public final void e() {
        this.generation++;
        Collection<Bitmap> collectionValues = this.cache.values();
        p.h(collectionValues, "<get-values>(...)");
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            ((Bitmap) it.next()).recycle();
        }
        this.cache.clear();
    }

    public final Bitmap f(int idx) {
        Object objB;
        Resources resources = this.res;
        if (resources == null || idx < 0 || idx >= this.resIds.size()) {
            return null;
        }
        Bitmap bitmap = this.cache.get(Integer.valueOf(idx));
        if (bitmap != null) {
            return bitmap;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(BitmapFactory.decodeResource(resources, this.resIds.get(idx).intValue()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        Bitmap bitmap2 = (Bitmap) objB;
        if (bitmap2 == null) {
            return null;
        }
        this.cache.put(Integer.valueOf(idx), bitmap2);
        return bitmap2;
    }

    public final void g() {
        HandlerThread handlerThread = this.decodeThread;
        if (handlerThread == null || !handlerThread.isAlive()) {
            HandlerThread handlerThread2 = new HandlerThread("frame-decode");
            handlerThread2.start();
            this.decodeThread = handlerThread2;
            HandlerThread handlerThread3 = this.decodeThread;
            p.f(handlerThread3);
            this.decodeHandler = new Handler(handlerThread3.getLooper());
        }
    }

    public final String getDiagLabel() {
        return this.diagLabel;
    }

    public final InterfaceC5063a<t> getOnEnd() {
        return this.onEnd;
    }

    public final InterfaceC5063a<t> getOnLoad() {
        return this.onLoad;
    }

    public final InterfaceC5063a<t> getOnRepeat() {
        return this.onRepeat;
    }

    public final void h(int current) {
        int size = this.resIds.size();
        if (size == 0) {
            return;
        }
        HashSet hashSet = new HashSet();
        int i10 = this.prefetch;
        int i11 = -1;
        if (-1 <= i10) {
            while (true) {
                hashSet.add(Integer.valueOf((((current + i11) % size) + size) % size));
                if (i11 == i10) {
                    break;
                } else {
                    i11++;
                }
            }
        }
        Iterator<Map.Entry<Integer, Bitmap>> it = this.cache.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Bitmap> next = it.next();
            int iIntValue = next.getKey().intValue();
            Bitmap value = next.getValue();
            if (!hashSet.contains(Integer.valueOf(iIntValue))) {
                value.recycle();
                it.remove();
            }
        }
    }

    public final void i(int from) {
        int size;
        Handler handler;
        final j jVar;
        final Resources resources = this.res;
        if (resources == null || (size = this.resIds.size()) == 0 || (handler = this.decodeHandler) == null) {
            return;
        }
        final int i10 = this.generation;
        int i11 = this.lazy ? this.prefetch : size - 1;
        if (i11 < 0) {
            return;
        }
        int i12 = 0;
        while (true) {
            int i13 = from + i12;
            if (this.loop < 0) {
                i13 %= size;
            }
            final int i14 = i13;
            if (i14 < 0 || i14 >= this.resIds.size() || this.cache.containsKey(Integer.valueOf(i14))) {
                jVar = this;
            } else {
                final int iIntValue = this.resIds.get(i14).intValue();
                jVar = this;
                handler.post(new Runnable() { // from class: N4.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        j.j(i10, jVar, resources, iIntValue, i14);
                    }
                });
            }
            if (i12 == i11) {
                return;
            }
            i12++;
            this = jVar;
        }
    }

    public final void l() {
        if (this.resIds.isEmpty()) {
            return;
        }
        q();
        setImageDrawable(null);
        e();
        g();
        this.startTimeMs = SystemClock.uptimeMillis();
        this.currentIdx = -1;
        this.ended = false;
        this.lastLoopFired = 0;
        Bitmap bitmapF = f(0);
        if (bitmapF != null) {
            this.currentIdx = 0;
            setImageBitmap(bitmapF);
        }
        i(1);
        p();
    }

    public final void m(int keepIdx) {
        this.generation++;
        Iterator<Map.Entry<Integer, Bitmap>> it = this.cache.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Bitmap> next = it.next();
            int iIntValue = next.getKey().intValue();
            Bitmap value = next.getValue();
            if (iIntValue != keepIdx) {
                value.recycle();
                it.remove();
            }
        }
    }

    public final void n(SceneLayerSpec.Frames spec, Resources resources) {
        p.i(spec, "spec");
        p.i(resources, "resources");
        if (this.running && this.res == resources && p.d(this.resIds, spec.c())) {
            return;
        }
        q();
        setImageDrawable(null);
        e();
        g();
        this.resIds = spec.c();
        this.res = resources;
        int fps = spec.getFps() > 0 ? spec.getFps() : 24;
        this.fps = fps;
        this.periodMs = 1000 / fps;
        int loop = spec.getLoop();
        this.loop = loop;
        this.lazy = loop >= 0;
        this.startTimeMs = SystemClock.uptimeMillis();
        this.currentIdx = -1;
        this.ended = false;
        this.lastLoopFired = 0;
        Bitmap bitmapF = f(0);
        if (bitmapF != null) {
            this.currentIdx = 0;
            setImageBitmap(bitmapF);
            InterfaceC5063a<t> interfaceC5063a = this.onLoad;
            if (interfaceC5063a != null) {
                interfaceC5063a.invoke();
            }
        }
        i(1);
        p();
    }

    public final void o() {
        q();
        if (this.resIds.isEmpty()) {
            return;
        }
        int size = this.resIds.size() - 1;
        Bitmap bitmapF = this.cache.get(Integer.valueOf(size));
        if (bitmapF == null) {
            bitmapF = f(size);
        }
        if (bitmapF != null) {
            this.currentIdx = size;
            this.ended = true;
            setImageBitmap(bitmapF);
            m(size);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        q();
        setImageDrawable(null);
        e();
        HandlerThread handlerThread = this.decodeThread;
        if (handlerThread != null) {
            handlerThread.quitSafely();
        }
        this.decodeThread = null;
        this.decodeHandler = null;
    }

    public final void p() {
        if (this.running || this.resIds.isEmpty() || this.ended) {
            return;
        }
        this.running = true;
        M4.d.f4544a.a(this.diagLabel + "Frames.start size=" + this.resIds.size() + " fps=" + this.fps + " loop=" + this.loop);
        Choreographer.getInstance().postFrameCallback(this.callback);
    }

    public final void q() {
        if (this.running) {
            M4.d.f4544a.a(this.diagLabel + "Frames.stop");
        }
        this.running = false;
        Choreographer.getInstance().removeFrameCallback(this.callback);
    }

    public final void r() {
        int i10;
        int size = this.resIds.size();
        if (size == 0) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis() - this.startTimeMs;
        int i11 = (int) (jUptimeMillis / this.periodMs);
        int i12 = this.loop;
        if (i12 >= 0 && i11 >= i12 * size) {
            if (!this.ended) {
                this.ended = true;
                int i13 = size - 1;
                Bitmap bitmapF = this.cache.get(Integer.valueOf(i13));
                if (bitmapF == null) {
                    bitmapF = f(i13);
                }
                if (bitmapF != null) {
                    this.currentIdx = i13;
                    setImageBitmap(bitmapF);
                    m(i13);
                }
                InterfaceC5063a<t> interfaceC5063a = this.onEnd;
                if (interfaceC5063a != null) {
                    interfaceC5063a.invoke();
                }
            }
            q();
            return;
        }
        if (i12 >= 1 && (i10 = i11 / size) > this.lastLoopFired) {
            this.lastLoopFired = i10;
            InterfaceC5063a<t> interfaceC5063a2 = this.onRepeat;
            if (interfaceC5063a2 != null) {
                interfaceC5063a2.invoke();
            }
        }
        int iA = L4.p.a(jUptimeMillis, this.periodMs, size, this.loop);
        if (iA == this.currentIdx) {
            return;
        }
        Bitmap bitmap = this.cache.get(Integer.valueOf(iA));
        if (bitmap == null) {
            i(iA);
            return;
        }
        this.currentIdx = iA;
        setImageBitmap(bitmap);
        i(iA + 1);
        if (this.lazy) {
            h(iA);
        }
    }

    public final void setDiagLabel(String str) {
        p.i(str, "<set-?>");
        this.diagLabel = str;
    }

    public final void setOnEnd(InterfaceC5063a<t> interfaceC5063a) {
        this.onEnd = interfaceC5063a;
    }

    public final void setOnLoad(InterfaceC5063a<t> interfaceC5063a) {
        this.onLoad = interfaceC5063a;
    }

    public final void setOnRepeat(InterfaceC5063a<t> interfaceC5063a) {
        this.onRepeat = interfaceC5063a;
    }
}
