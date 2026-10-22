package N4;

import L4.p;
import Y8.t;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.SystemClock;
import android.os.Trace;
import android.util.Log;
import android.view.Choreographer;
import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentsprite.SceneLayerSpec;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u0000k\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b*\u00010\b\u0000\u0018\u0000 :2\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u000eJ\r\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u000eJ\u0017\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\nH\u0014¢\u0006\u0004\b\u0015\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010!\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u001eR\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010+R\u0016\u0010/\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010.R\u0014\u00102\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u00101R\"\u00109\u001a\u0002038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108¨\u0006;"}, d2 = {"LN4/o;", "Landroid/view/View;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Lcom/stepos/agentsprite/SceneLayerSpec$k;", "spec", "Landroid/content/res/Resources;", "resources", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lcom/stepos/agentsprite/SceneLayerSpec$k;Landroid/content/res/Resources;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()V", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "onDetachedFromWindow", Const.INTENT_KEY_APIKEY, "Lcom/stepos/agentsprite/SceneLayerSpec$k;", "Landroid/graphics/Bitmap;", Const.INTENT_KEY_PKGNAME, "Landroid/graphics/Bitmap;", "bitmap", "Landroid/graphics/Rect;", "c", "Landroid/graphics/Rect;", "src", Const.INTENT_KEY_UMID, "dst", "Landroid/graphics/Paint;", "e", "Landroid/graphics/Paint;", "paint", "", "f", "J", "startTimeMs", "", "Z", "running", "", "I", "lastDrawnIdx", "N4/o$b", "LN4/o$b;", "callback", "", "Ljava/lang/String;", "getDiagLabel", "()Ljava/lang/String;", "setDiagLabel", "(Ljava/lang/String;)V", "diagLabel", "k", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class o extends View {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public SceneLayerSpec.SpriteSheet spec;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public Bitmap bitmap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Rect src;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Rect dst;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Paint paint;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public long startTimeMs;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public boolean running;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public int lastDrawnIdx;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final b callback;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public String diagLabel;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"N4/o$b", "Landroid/view/Choreographer$FrameCallback;", "", "frameTimeNanos", "LY8/t;", "doFrame", "(J)V", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b implements Choreographer.FrameCallback {
        public b() {
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long frameTimeNanos) {
            if (o.this.running) {
                M4.d dVar = M4.d.f4544a;
                o oVar = o.this;
                Trace.beginSection("AgentSpriteSDK#Sprite");
                try {
                    SceneLayerSpec.SpriteSheet spriteSheet = oVar.spec;
                    Bitmap bitmap = oVar.bitmap;
                    if (spriteSheet != null && bitmap != null) {
                        int iA = p.a(SystemClock.uptimeMillis() - oVar.startTimeMs, spriteSheet.getFps() > 0 ? 1000 / spriteSheet.getFps() : 41L, spriteSheet.getFrameCount(), spriteSheet.getLoop());
                        if (iA != oVar.lastDrawnIdx) {
                            oVar.lastDrawnIdx = iA;
                            oVar.invalidate();
                        }
                    }
                    Choreographer.getInstance().postFrameCallback(this);
                    t tVar = t.f7040a;
                } finally {
                    Trace.endSection();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(Context context) {
        super(context);
        kotlin.jvm.internal.p.i(context, "context");
        this.src = new Rect();
        this.dst = new Rect();
        Paint paint = new Paint(1);
        paint.setFilterBitmap(false);
        this.paint = paint;
        this.lastDrawnIdx = -1;
        this.callback = new b();
        this.diagLabel = "";
    }

    public final void g() {
        if (this.bitmap == null) {
            return;
        }
        j();
        this.startTimeMs = SystemClock.uptimeMillis();
        this.lastDrawnIdx = -1;
        invalidate();
        i();
    }

    public final String getDiagLabel() {
        return this.diagLabel;
    }

    public final void h(SceneLayerSpec.SpriteSheet spec, Resources resources) {
        Object objB;
        kotlin.jvm.internal.p.i(spec, "spec");
        kotlin.jvm.internal.p.i(resources, "resources");
        j();
        this.spec = spec;
        Bitmap bitmap = this.bitmap;
        if (bitmap != null) {
            bitmap.recycle();
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(BitmapFactory.decodeResource(resources, spec.getResId()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Bitmap bitmap2 = null;
        if (Result.g(objB)) {
            objB = null;
        }
        Bitmap bitmap3 = (Bitmap) objB;
        if (bitmap3 == null || !M4.h.a(bitmap3.getWidth(), bitmap3.getHeight(), spec.getColumns(), spec.getRows())) {
            if (bitmap3 != null) {
                bitmap3.recycle();
            }
            if (bitmap3 != null) {
                Log.w("SpriteSheetView", "sprite_sheet resId=" + spec.getResId() + ": bitmap " + bitmap3.getWidth() + "x" + bitmap3.getHeight() + " not divisible by " + spec.getColumns() + "x" + spec.getRows());
            }
        } else {
            bitmap2 = bitmap3;
        }
        this.bitmap = bitmap2;
        this.lastDrawnIdx = -1;
        this.startTimeMs = SystemClock.uptimeMillis();
        if (this.bitmap != null) {
            i();
        }
    }

    public final void i() {
        if (this.running) {
            return;
        }
        this.running = true;
        M4.d dVar = M4.d.f4544a;
        String str = this.diagLabel;
        SceneLayerSpec.SpriteSheet spriteSheet = this.spec;
        Integer numValueOf = spriteSheet != null ? Integer.valueOf(spriteSheet.getFps()) : null;
        SceneLayerSpec.SpriteSheet spriteSheet2 = this.spec;
        dVar.a(str + "Sprite.start fps=" + numValueOf + " loop=" + (spriteSheet2 != null ? Integer.valueOf(spriteSheet2.getLoop()) : null));
        Choreographer.getInstance().postFrameCallback(this.callback);
    }

    public final void j() {
        if (this.running) {
            M4.d.f4544a.a(this.diagLabel + "Sprite.stop");
        }
        this.running = false;
        Choreographer.getInstance().removeFrameCallback(this.callback);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        j();
        Bitmap bitmap = this.bitmap;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.bitmap = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Bitmap bitmap;
        kotlin.jvm.internal.p.i(canvas, "canvas");
        SceneLayerSpec.SpriteSheet spriteSheet = this.spec;
        if (spriteSheet == null || (bitmap = this.bitmap) == null) {
            return;
        }
        int width = bitmap.getWidth() / spriteSheet.getColumns();
        int height = bitmap.getHeight() / spriteSheet.getRows();
        int iA = p.a(SystemClock.uptimeMillis() - this.startTimeMs, spriteSheet.getFps() > 0 ? 1000 / spriteSheet.getFps() : 41L, spriteSheet.getFrameCount(), spriteSheet.getLoop());
        int columns = iA % spriteSheet.getColumns();
        int columns2 = iA / spriteSheet.getColumns();
        this.src.set(columns * width, columns2 * height, (columns + 1) * width, (columns2 + 1) * height);
        this.dst.set(0, 0, getWidth(), getHeight());
        canvas.drawBitmap(bitmap, this.src, this.dst, this.paint);
    }

    public final void setDiagLabel(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        this.diagLabel = str;
    }
}
