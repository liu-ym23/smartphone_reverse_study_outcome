package v7;

import android.R;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.motionkit.SurfacePresentation;
import com.stepos.motionkit.SurfaceRendererType;
import com.stepos.motionkit.fx.backend.SurfaceRenderer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import p9.InterfaceC5063a;
import s7.EffectDefinition;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0003J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0019¨\u0006\u001b"}, d2 = {"Lv7/z;", "Ls7/i;", "<init>", "()V", "Ls7/o;", "host", "Landroid/view/View;", "targetView", "Ls7/c;", "compiled", "Ls7/j;", "config", "Ls7/e;", "definition", "Ls7/k;", Const.INTENT_KEY_APIKEY, "(Ls7/o;Landroid/view/View;Ls7/c;Ls7/j;Ls7/e;)Ls7/k;", "LY8/t;", "release", "view", "Landroid/view/ViewGroup;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Landroid/view/View;)Landroid/view/ViewGroup;", "", "Lv7/B;", "Ljava/util/List;", "instances", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class z implements s7.i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final List<C5663B> instances = new ArrayList();

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f42788a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f42789b;

        static {
            int[] iArr = new int[SurfacePresentation.values().length];
            try {
                iArr[SurfacePresentation.TEXTURE_VIEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SurfacePresentation.SURFACE_VIEW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f42788a = iArr;
            int[] iArr2 = new int[SurfaceRendererType.values().length];
            try {
                iArr2[SurfaceRendererType.AGSL.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[SurfaceRendererType.GLES.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[SurfaceRendererType.VULKAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            f42789b = iArr2;
        }
    }

    public static final Y8.t f(C5663B c5663b) {
        c5663b.b();
        return Y8.t.f7040a;
    }

    public static final void g(InterfaceC5666c interfaceC5666c, ViewGroup viewGroup) {
        interfaceC5666c.a(viewGroup);
        interfaceC5666c.setRenderScale(0.5f);
    }

    public static final Y8.t h(C5663B c5663b, long j10, float f10) {
        c5663b.e(j10);
        return Y8.t.f7040a;
    }

    public static final Y8.t i(C5663B c5663b, z zVar) {
        c5663b.c();
        zVar.instances.remove(c5663b);
        return Y8.t.f7040a;
    }

    @Override // s7.i
    public s7.k a(s7.o host, View targetView, s7.c compiled, s7.j config, EffectDefinition definition) {
        InterfaceC5666c d10;
        SurfaceRenderer surfaceRenderer;
        kotlin.jvm.internal.p.i(host, "host");
        kotlin.jvm.internal.p.i(targetView, "targetView");
        kotlin.jvm.internal.p.i(compiled, "compiled");
        kotlin.jvm.internal.p.i(config, "config");
        kotlin.jvm.internal.p.i(definition, "definition");
        final ViewGroup viewGroupJ = j(targetView);
        int i10 = a.f42788a[config.getSurfacePresentation().ordinal()];
        if (i10 == 1) {
            Context context = targetView.getContext();
            kotlin.jvm.internal.p.h(context, "getContext(...)");
            d10 = new D(context);
        } else {
            if (i10 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            Context context2 = targetView.getContext();
            kotlin.jvm.internal.p.h(context2, "getContext(...)");
            d10 = new C(context2);
        }
        B7.a aVar = new B7.a(definition);
        int i11 = a.f42789b[config.getSurfaceRenderer().ordinal()];
        if (i11 == 1) {
            surfaceRenderer = SurfaceRenderer.AGSL;
        } else if (i11 == 2) {
            surfaceRenderer = SurfaceRenderer.GLES;
        } else {
            if (i11 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            surfaceRenderer = SurfaceRenderer.VULKAN;
        }
        final InterfaceC5666c interfaceC5666c = d10;
        final C5663B c5663b = new C5663B(interfaceC5666c, aVar, compiled.getSource(), surfaceRenderer, viewGroupJ);
        interfaceC5666c.setOnReady(new InterfaceC5063a() { // from class: v7.v
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return z.f(c5663b);
            }
        });
        this.instances.add(c5663b);
        viewGroupJ.post(new Runnable() { // from class: v7.w
            @Override // java.lang.Runnable
            public final void run() {
                z.g(interfaceC5666c, viewGroupJ);
            }
        });
        return new t7.d(System.nanoTime(), new p9.p() { // from class: v7.x
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return z.h(c5663b, ((Long) obj).longValue(), ((Float) obj2).floatValue());
            }
        }, new InterfaceC5063a() { // from class: v7.y
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return z.i(c5663b, this);
            }
        }, aVar);
    }

    public final ViewGroup j(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getRootView().findViewById(R.id.content);
        if (viewGroup != null) {
            return viewGroup;
        }
        while (view.getParent() instanceof View) {
            Object parent = view.getParent();
            kotlin.jvm.internal.p.g(parent, "null cannot be cast to non-null type android.view.View");
            view = (View) parent;
        }
        ViewGroup viewGroup2 = view instanceof ViewGroup ? (ViewGroup) view : null;
        if (viewGroup2 != null) {
            return viewGroup2;
        }
        throw new IllegalArgumentException("SurfaceBackend: cannot find a ViewGroup to attach");
    }

    @Override // s7.i
    public void release() {
        Iterator<T> it = this.instances.iterator();
        while (it.hasNext()) {
            ((C5663B) it.next()).c();
        }
        this.instances.clear();
    }
}
