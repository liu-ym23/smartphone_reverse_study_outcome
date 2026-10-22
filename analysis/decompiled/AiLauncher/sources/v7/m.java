package v7;

import La.H;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.RuntimeShader;
import android.graphics.Shader;
import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import s7.EffectDefinition;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0003R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0015¨\u0006\u0017"}, d2 = {"Lv7/m;", "Ls7/i;", "<init>", "()V", "Ls7/o;", "host", "Landroid/view/View;", "targetView", "Ls7/c;", "compiled", "Ls7/j;", "config", "Ls7/e;", "definition", "Ls7/k;", Const.INTENT_KEY_APIKEY, "(Ls7/o;Landroid/view/View;Ls7/c;Ls7/j;Ls7/e;)Ls7/k;", "LY8/t;", "release", "", "Lv7/n;", "Ljava/util/List;", "instances", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class m implements s7.i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final List<n> instances = new ArrayList();

    public static final void e(u uVar, View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        uVar.setBounds(0, 0, i12 - i10, i13 - i11);
    }

    public static final Y8.t f(n nVar, long j10, float f10) {
        nVar.b(j10);
        return Y8.t.f7040a;
    }

    public static final Y8.t g(n nVar, m mVar) {
        nVar.a();
        mVar.instances.remove(nVar);
        return Y8.t.f7040a;
    }

    @Override // s7.i
    public s7.k a(s7.o host, View targetView, s7.c compiled, s7.j config, EffectDefinition definition) {
        Bitmap bitmap;
        kotlin.jvm.internal.p.i(host, "host");
        kotlin.jvm.internal.p.i(targetView, "targetView");
        kotlin.jvm.internal.p.i(compiled, "compiled");
        kotlin.jvm.internal.p.i(config, "config");
        kotlin.jvm.internal.p.i(definition, "definition");
        RuntimeShader runtimeShader = compiled.getRuntimeShader();
        if (runtimeShader == null) {
            runtimeShader = new RuntimeShader(compiled.getSource());
        }
        RuntimeShader runtimeShader2 = runtimeShader;
        if (!(H.g0(compiled.getSource(), "uniform shader sksl_background", false, 2, null) || H.g0(compiled.getSource(), "uniform shader iBackground", false, 2, null)) || targetView.getWidth() <= 0 || targetView.getHeight() <= 0) {
            bitmap = null;
        } else {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(targetView.getWidth(), targetView.getHeight(), Bitmap.Config.ARGB_8888);
            targetView.draw(new Canvas(bitmapCreateBitmap));
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            BitmapShader bitmapShader = new BitmapShader(bitmapCreateBitmap, tileMode, tileMode);
            if (H.g0(compiled.getSource(), "uniform shader sksl_background", false, 2, null)) {
                runtimeShader2.setInputShader("sksl_background", bitmapShader);
            }
            if (H.g0(compiled.getSource(), "uniform shader sksl_layer", false, 2, null)) {
                runtimeShader2.setInputShader("sksl_layer", bitmapShader);
            }
            if (H.g0(compiled.getSource(), "uniform shader iBackground", false, 2, null)) {
                runtimeShader2.setInputShader("iBackground", bitmapShader);
            }
            bitmap = bitmapCreateBitmap;
        }
        B7.a aVar = new B7.a(definition);
        aVar.c(compiled.getSource());
        final u uVar = new u(runtimeShader2, aVar);
        targetView.getOverlay().add(uVar);
        uVar.setBounds(0, 0, targetView.getWidth(), targetView.getHeight());
        View.OnLayoutChangeListener onLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: v7.j
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                m.e(uVar, view, i10, i11, i12, i13, i14, i15, i16, i17);
            }
        };
        targetView.addOnLayoutChangeListener(onLayoutChangeListener);
        final n nVar = new n(runtimeShader2, aVar, uVar, targetView, onLayoutChangeListener, bitmap);
        this.instances.add(nVar);
        return new t7.d(System.nanoTime(), new p9.p() { // from class: v7.k
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return m.f(nVar, ((Long) obj).longValue(), ((Float) obj2).floatValue());
            }
        }, new InterfaceC5063a() { // from class: v7.l
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return m.g(nVar, this);
            }
        }, aVar);
    }

    @Override // s7.i
    public void release() {
        Iterator<T> it = this.instances.iterator();
        while (it.hasNext()) {
            ((n) it.next()).a();
        }
        this.instances.clear();
    }
}
