package com.stepos.agentframework.chatui.appui.taskrobot;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntUnaryOperator;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0002*+B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J/\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u001b\u0010\u0017J\u000f\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\rH\u0014¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\rH\u0014¢\u0006\u0004\b!\u0010 R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082D¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010%\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010'\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006,"}, d2 = {"Lcom/stepos/agentframework/chatui/appui/taskrobot/b;", "Landroid/view/SurfaceView;", "Landroid/view/SurfaceHolder$Callback;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "width", "height", "LY8/t;", "c", "(II)V", "Lcom/stepos/agentframework/chatui/appui/taskrobot/b$b;", "callback", "setSurfaceCallback", "(Lcom/stepos/agentframework/chatui/appui/taskrobot/b$b;)V", "Landroid/view/SurfaceHolder;", "holder", "surfaceCreated", "(Landroid/view/SurfaceHolder;)V", "format", "surfaceChanged", "(Landroid/view/SurfaceHolder;III)V", "surfaceDestroyed", "Landroid/view/Surface;", "getSurface", "()Landroid/view/Surface;", "onAttachedToWindow", "()V", "onDetachedFromWindow", "", "TAG", "Ljava/lang/String;", "surfaceHolder", "Landroid/view/SurfaceHolder;", "surfaceCallback", "Lcom/stepos/agentframework/chatui/appui/taskrobot/b$b;", "Companion", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class b extends SurfaceView implements SurfaceHolder.Callback {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final AtomicInteger liveSurfaces = new AtomicInteger(0);
    private final String TAG;
    private InterfaceC0251b surfaceCallback;
    private SurfaceHolder surfaceHolder;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/stepos/agentframework/chatui/appui/taskrobot/b$a;", "", "<init>", "()V", "Ljava/util/concurrent/atomic/AtomicInteger;", "liveSurfaces", "Ljava/util/concurrent/atomic/AtomicInteger;", Const.INTENT_KEY_APIKEY, "()Ljava/util/concurrent/atomic/AtomicInteger;", "getLiveSurfaces$annotations", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.appui.taskrobot.b$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final AtomicInteger a() {
            return b.liveSurfaces;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/chatui/appui/taskrobot/b$b;", "", "Landroid/view/Surface;", "surface", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Landroid/view/Surface;)V", Const.INTENT_KEY_APIKEY, "()V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.appui.taskrobot.b$b, reason: collision with other inner class name */
    public interface InterfaceC0251b {
        void a();

        void b(Surface surface);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        this.TAG = "CustomSurfaceView";
        getHolder().addCallback(this);
        getHolder().setFormat(1);
        setKeepScreenOn(true);
    }

    public static final int d(int i10) {
        if (i10 > 0) {
            return i10 - 1;
        }
        return 0;
    }

    public static final AtomicInteger getLiveSurfaces() {
        return INSTANCE.a();
    }

    public final void c(int width, int height) {
        getHolder().setFixedSize(width, height);
    }

    public final Surface getSurface() {
        SurfaceHolder surfaceHolder = this.surfaceHolder;
        if (surfaceHolder != null) {
            return surfaceHolder.getSurface();
        }
        return null;
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        C4148a.k(this.TAG, "onAttachedToWindow", false, 4, null);
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C4148a.k(this.TAG, "onDetachedFromWindow", false, 4, null);
    }

    public final void setSurfaceCallback(InterfaceC0251b callback) {
        kotlin.jvm.internal.p.i(callback, "callback");
        this.surfaceCallback = callback;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        kotlin.jvm.internal.p.i(holder, "holder");
        C4148a.d("DebugSurface", "==============start===============", false, 4, null);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int i10 = displayMetrics.widthPixels;
        int i11 = displayMetrics.heightPixels;
        float f10 = width / height;
        float f11 = i10 / i11;
        C4148a.d("DebugSurface", "=============================", false, 4, null);
        C4148a.d("DebugSurface", "Surface Size: " + width + " x " + height, false, 4, null);
        C4148a.d("DebugSurface", "Main Screen : " + i10 + " x " + i11, false, 4, null);
        y yVar = y.f34840a;
        String str = String.format("%.4f", Arrays.copyOf(new Object[]{Float.valueOf(f10)}, 1));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C4148a.d("DebugSurface", "Surface Ratio: " + str, false, 4, null);
        String str2 = String.format("%.4f", Arrays.copyOf(new Object[]{Float.valueOf(f11)}, 1));
        kotlin.jvm.internal.p.h(str2, "format(...)");
        C4148a.d("DebugScreen", "Main Ratio   : " + str2, false, 4, null);
        float f12 = f10 - f11;
        if (Math.abs(f12) < 0.01f) {
            C4148a.d("DebugSurface", "✅ 比例匹配！理论上无黑边。", false, 4, null);
        } else {
            C4148a.d("DebugSurface", "❌ 比例不匹配！差值: " + Math.abs(f12), false, 4, null);
            C4148a.d("DebugSurface", "💡 建议：检查 LayoutParams 或手动计算高度以保持比例。", false, 4, null);
        }
        C4148a.d("DebugSurface", "=============================", false, 4, null);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder holder) {
        kotlin.jvm.internal.p.i(holder, "holder");
        C4148a.d(this.TAG, "Surface已创建，holder: " + holder, false, 4, null);
        this.surfaceHolder = holder;
        liveSurfaces.incrementAndGet();
        InterfaceC0251b interfaceC0251b = this.surfaceCallback;
        if (interfaceC0251b != null) {
            Surface surface = holder.getSurface();
            kotlin.jvm.internal.p.h(surface, "getSurface(...)");
            interfaceC0251b.b(surface);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder holder) {
        kotlin.jvm.internal.p.i(holder, "holder");
        C4148a.d(this.TAG, "Surface已销毁", false, 4, null);
        this.surfaceHolder = null;
        liveSurfaces.updateAndGet(new IntUnaryOperator() { // from class: com.stepos.agentframework.chatui.appui.taskrobot.a
            @Override // java.util.function.IntUnaryOperator
            public final int applyAsInt(int i10) {
                return b.d(i10);
            }
        });
        InterfaceC0251b interfaceC0251b = this.surfaceCallback;
        if (interfaceC0251b != null) {
            interfaceC0251b.a();
        }
    }

    public /* synthetic */ b(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
