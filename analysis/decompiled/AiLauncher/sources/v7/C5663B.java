package v7;

import android.view.ViewGroup;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.motionkit.fx.backend.SurfaceRenderer;
import com.stepos.motionkit.fx.backend.VulkanRenderer;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u000e¢\u0006\u0004\b\u0015\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0018R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0019R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006)"}, d2 = {"Lv7/B;", "", "Lv7/c;", "renderSurface", "LB7/a;", "binder", "", "shaderSource", "Lcom/stepos/motionkit/fx/backend/SurfaceRenderer;", "rendererType", "Landroid/view/ViewGroup;", "parent", "<init>", "(Lv7/c;LB7/a;Ljava/lang/String;Lcom/stepos/motionkit/fx/backend/SurfaceRenderer;Landroid/view/ViewGroup;)V", "LY8/t;", Const.INTENT_KEY_PKGNAME, "()V", "", "elapsedMs", "e", "(J)V", "c", Const.INTENT_KEY_APIKEY, "Lv7/c;", "LB7/a;", "Ljava/lang/String;", Const.INTENT_KEY_UMID, "Lcom/stepos/motionkit/fx/backend/SurfaceRenderer;", "Landroid/view/ViewGroup;", "Lv7/b;", "f", "Lv7/b;", "agslRenderer", "Lv7/h;", Const.INTENT_KEY_BACKGROUND_COMMAND, "Lv7/h;", "glesRenderer", "Lcom/stepos/motionkit/fx/backend/VulkanRenderer;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Lcom/stepos/motionkit/fx/backend/VulkanRenderer;", "vulkanRenderer", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: v7.B, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5663B {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5666c renderSurface;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final B7.a binder;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final String shaderSource;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final SurfaceRenderer rendererType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final ViewGroup parent;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public C5665b agslRenderer;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public h glesRenderer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public VulkanRenderer vulkanRenderer;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* renamed from: v7.B$a */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f42706a;

        static {
            int[] iArr = new int[SurfaceRenderer.values().length];
            try {
                iArr[SurfaceRenderer.AGSL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SurfaceRenderer.GLES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SurfaceRenderer.VULKAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f42706a = iArr;
        }
    }

    public C5663B(InterfaceC5666c renderSurface, B7.a binder, String shaderSource, SurfaceRenderer rendererType, ViewGroup parent) {
        kotlin.jvm.internal.p.i(renderSurface, "renderSurface");
        kotlin.jvm.internal.p.i(binder, "binder");
        kotlin.jvm.internal.p.i(shaderSource, "shaderSource");
        kotlin.jvm.internal.p.i(rendererType, "rendererType");
        kotlin.jvm.internal.p.i(parent, "parent");
        this.renderSurface = renderSurface;
        this.binder = binder;
        this.shaderSource = shaderSource;
        this.rendererType = rendererType;
        this.parent = parent;
    }

    public static final void d(C5663B c5663b) {
        c5663b.parent.removeView(c5663b.renderSurface.b());
    }

    public final void b() {
        try {
            int i10 = a.f42706a[this.rendererType.ordinal()];
            if (i10 == 1) {
                C5665b c5665b = new C5665b(this.shaderSource, this.binder, this.renderSurface);
                c5665b.d();
                this.agslRenderer = c5665b;
            } else if (i10 == 2) {
                h hVar = new h(this.shaderSource, this.binder, this.renderSurface);
                hVar.k();
                this.glesRenderer = hVar;
            } else {
                if (i10 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                VulkanRenderer vulkanRenderer = new VulkanRenderer(this.shaderSource, this.binder, this.renderSurface);
                vulkanRenderer.g();
                this.vulkanRenderer = vulkanRenderer;
            }
        } catch (Exception e10) {
            s7.m.f40102a.b("Surface", "SurfaceBackend initRenderer failed: " + e10.getMessage(), e10);
        }
    }

    public final void c() {
        C5665b c5665b = this.agslRenderer;
        if (c5665b != null) {
            c5665b.e();
        }
        h hVar = this.glesRenderer;
        if (hVar != null) {
            hVar.m();
        }
        VulkanRenderer vulkanRenderer = this.vulkanRenderer;
        if (vulkanRenderer != null) {
            vulkanRenderer.i();
        }
        this.parent.post(new Runnable() { // from class: v7.A
            @Override // java.lang.Runnable
            public final void run() {
                C5663B.d(this.f42697a);
            }
        });
    }

    public final void e(long elapsedMs) {
        C5665b c5665b = this.agslRenderer;
        if (c5665b != null) {
            c5665b.b(elapsedMs);
        }
        h hVar = this.glesRenderer;
        if (hVar != null) {
            hVar.h(elapsedMs);
        }
        VulkanRenderer vulkanRenderer = this.vulkanRenderer;
        if (vulkanRenderer != null) {
            vulkanRenderer.e(elapsedMs);
        }
    }
}
