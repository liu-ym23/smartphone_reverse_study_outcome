package androidx.compose.ui.graphics;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerImpl;
import androidx.compose.ui.graphics.layer.GraphicsLayerV23;
import androidx.compose.ui.graphics.layer.GraphicsLayerV29;
import androidx.compose.ui.graphics.layer.GraphicsViewLayer;
import androidx.compose.ui.graphics.layer.view.DrawChildContainer;
import androidx.compose.ui.graphics.layer.view.ViewLayerContainer;
import androidx.compose.ui.graphics.shadow.AndroidShadowContext_androidKt;
import androidx.compose.ui.graphics.shadow.ShadowContext;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000 \"2\u00020\u0001:\u0002\"#B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0017H\u0016J\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006$"}, d2 = {"Landroidx/compose/ui/graphics/AndroidGraphicsContext;", "Landroidx/compose/ui/graphics/GraphicsContext;", "ownerView", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "lock", "", "viewLayerContainer", "Landroidx/compose/ui/graphics/layer/view/DrawChildContainer;", "componentCallbackRegistered", "", "shadowCache", "Landroidx/compose/ui/graphics/shadow/ShadowContext;", "componentCallback", "Landroid/content/ComponentCallbacks2;", "clearShadowCache", "", "registerComponentCallback", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "unregisterComponentCallback", "createGraphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "shadowContext", "getShadowContext", "()Landroidx/compose/ui/graphics/shadow/ShadowContext;", "releaseGraphicsLayer", GXTemplateKey.GAIAX_LAYER, "obtainViewLayerContainer", "getUniqueDrawingId", "", "view", "Landroid/view/View;", "Companion", "UniqueDrawingIdApi29", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class AndroidGraphicsContext implements GraphicsContext {
    public static final Companion Companion = null;
    private static boolean isRenderNodeCompatible;
    private final ComponentCallbacks2 componentCallback;
    private boolean componentCallbackRegistered;
    private final Object lock;
    private final ViewGroup ownerView;
    private ShadowContext shadowCache;
    private DrawChildContainer viewLayerContainer;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/ui/graphics/AndroidGraphicsContext$Companion;", "", "<init>", "()V", "isRenderNodeCompatible", "", "()Z", "setRenderNodeCompatible", "(Z)V", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final boolean isRenderNodeCompatible() {
            return AndroidGraphicsContext.access$isRenderNodeCompatible$cp();
        }

        public final void setRenderNodeCompatible(boolean r100) {
            AndroidGraphicsContext.access$setRenderNodeCompatible$cp(r100);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/graphics/AndroidGraphicsContext$UniqueDrawingIdApi29;", "", "<init>", "()V", "getUniqueDrawingId", "", "view", "Landroid/view/View;", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class UniqueDrawingIdApi29 {
        public static final UniqueDrawingIdApi29 INSTANCE = null;

        static {
            INSTANCE = new UniqueDrawingIdApi29();
        }

        private UniqueDrawingIdApi29() {
        }

        @JvmStatic
        public static final long getUniqueDrawingId(View r100) {
            return r100.getUniqueDrawingId();
        }
    }

    static {
        Companion = new Companion(null);
        isRenderNodeCompatible = true;
    }

    private final void clearShadowCache() {
        ShadowContext r100 = this.shadowCache;
        if (r100 == null) goto L5;
        r100.clearCache();
    L5:
        this.shadowCache = null;
    }

    @Override // androidx.compose.ui.graphics.GraphicsContext
    public GraphicsLayer createGraphicsLayer() {
        Object r100 = this.lock;
        monitor-enter(r100);
        long r110 = getUniqueDrawingId(this.ownerView);     // Catch: Throwable -> L19
        int r101 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L19
        if (r101 < 29) goto L8;
        GraphicsLayerImpl r102 = new GraphicsLayerV29(r110, null, null, 6, null);     // Catch: Throwable -> L19
    L16:
        GraphicsLayer r103 = new GraphicsLayer(r102);     // Catch: Throwable -> L19
        monitor-exit(r100);
        return r103;
    L8:
        if (isRenderNodeCompatible == true) goto L10;
    L15:
        r102 = new GraphicsViewLayer(obtainViewLayerContainer(this.ownerView), r110, null, null, 12, null);     // Catch: Throwable -> L19
        goto L16
    L10:
        if (r101 < 23) goto L15;
        r102 = new GraphicsLayerV23(this.ownerView, r110, null, null, 12, null);     // Catch: Throwable -> L13
    L14:
        isRenderNodeCompatible = false;     // Catch: Throwable -> L19
        r102 = new GraphicsViewLayer(obtainViewLayerContainer(this.ownerView), r110, null, null, 12, null);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    @Override // androidx.compose.ui.graphics.GraphicsContext
    public ShadowContext getShadowContext() {
        ShadowContext r100 = this.shadowCache;
        if (r100 != null) goto L6;
        ShadowContext r101 = AndroidShadowContext_androidKt.ShadowContext();
        this.shadowCache = r101;
        return r101;
    L6:
        return r100;
    }

    public static final /* synthetic */ boolean access$isRenderNodeCompatible$cp() {
        return isRenderNodeCompatible;
    }

    public AndroidGraphicsContext(ViewGroup r100) {
        this.ownerView = r100;
        this.lock = new Object();
        this.componentCallback = new AnonymousClass1(this);
        if (r100.isAttachedToWindow() == false) goto L5;
        registerComponentCallback(r100.getContext());
    L5:
        r100.addOnAttachStateChangeListener(new AnonymousClass2(this));
    }

    public static final /* synthetic */ void access$clearShadowCache(AndroidGraphicsContext r100) {
        r100.clearShadowCache();
    }

    public static final /* synthetic */ void access$setRenderNodeCompatible$cp(boolean r100) {
        isRenderNodeCompatible = r100;
    }

    private final long getUniqueDrawingId(View r100) {
        if (Build.VERSION.SDK_INT >= 29) goto L7;
        return -1;
    L7:
        return UniqueDrawingIdApi29.getUniqueDrawingId(r100);
    }

    private final DrawChildContainer obtainViewLayerContainer(ViewGroup r100) {
        DrawChildContainer r101 = this.viewLayerContainer;
        if (r101 != null) goto L6;
        ViewLayerContainer r102 = new ViewLayerContainer(r100.getContext());
        r100.addView(r102);
        this.viewLayerContainer = r102;
        return r102;
    L6:
        return r101;
    }

    private final void registerComponentCallback(Context r100) {
        if (this.componentCallbackRegistered == true) goto L6;
        r100.getApplicationContext().registerComponentCallbacks(this.componentCallback);
        this.componentCallbackRegistered = true;
        return;
    }

    private final void unregisterComponentCallback(Context r100) {
        if (this.componentCallbackRegistered == false) goto L6;
        r100.getApplicationContext().unregisterComponentCallbacks(this.componentCallback);
        this.componentCallbackRegistered = false;
        return;
    }

    @Override // androidx.compose.ui.graphics.GraphicsContext
    public void releaseGraphicsLayer(GraphicsLayer r100) {
        Object r101 = this.lock;
        monitor-enter(r101);
        r100.release$ui_graphics_release();     // Catch: Throwable -> L7
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static final /* synthetic */ void access$registerComponentCallback(AndroidGraphicsContext r100, Context r101) {
        r100.registerComponentCallback(r101);
    }

    public static final /* synthetic */ void access$unregisterComponentCallback(AndroidGraphicsContext r100, Context r101) {
        r100.unregisterComponentCallback(r101);
    }
}
