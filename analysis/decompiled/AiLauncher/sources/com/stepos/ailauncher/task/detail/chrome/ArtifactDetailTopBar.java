package com.stepos.ailauncher.task.detail.chrome;

import Y8.t;
import Z8.C1173v;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.ailauncher.contract.model.SessionArtifact;
import com.stepos.ailauncher.task.R$drawable;
import com.stepos.ailauncher.task.R$id;
import com.stepos.ailauncher.task.R$layout;
import com.stepos.ailauncher.task.detail.render.ArtifactRenderKind;
import com.stepos.launcher.assistant.slidepanel.ConstConfig;
import kotlin.C4848b;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import y7.E;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\r¢\u0006\u0004\b\u0019\u0010\u0010J/\u0010\u001e\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010\"\u001a\u00020\n2\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J7\u0010)\u001a\u00020\n2\u0006\u0010!\u001a\u00020 2\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&2\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0013¢\u0006\u0004\b)\u0010*J\r\u0010+\u001a\u00020\n¢\u0006\u0004\b+\u0010\fJ\r\u0010,\u001a\u00020\n¢\u0006\u0004\b,\u0010\fR*\u0010-\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R*\u00103\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010.\u001a\u0004\b4\u00100\"\u0004\b5\u00102R*\u00106\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u0010.\u001a\u0004\b7\u00100\"\u0004\b8\u00102R*\u00109\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010.\u001a\u0004\b:\u00100\"\u0004\b;\u00102R*\u0010<\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010.\u001a\u0004\b=\u00100\"\u0004\b>\u00102R*\u0010?\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010.\u001a\u0004\b@\u00100\"\u0004\bA\u00102R*\u0010B\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010.\u001a\u0004\bC\u00100\"\u0004\bD\u00102R(\u0010E\u001a\b\u0012\u0004\u0012\u00020\r0\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010.\u001a\u0004\bE\u00100\"\u0004\bF\u00102R\u0014\u0010H\u001a\u00020G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0014\u0010K\u001a\u00020J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010M\u001a\u00020J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010LR\u0014\u0010N\u001a\u00020G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010IR\u0014\u0010O\u001a\u00020G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010IR\u0014\u0010P\u001a\u00020G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010IR\u0014\u0010Q\u001a\u00020G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010IR\u0014\u0010R\u001a\u00020G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010IR\u0018\u0010S\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010U\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010TR\u0018\u0010V\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010TR\u0018\u0010W\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u001b\u0010^\u001a\u00020Y8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]¨\u0006_"}, d2 = {"Lcom/stepos/ailauncher/task/detail/chrome/ArtifactDetailTopBar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "LY8/t;", ExifInterface.LONGITUDE_EAST, "()V", "", "immersive", ExifInterface.LATITUDE_SOUTH, "(Z)V", "Landroid/view/View;", "target", "Lkotlin/Function0;", "clearRef", "Ly7/E;", "H", "(Landroid/view/View;Lp9/a;)Ly7/E;", "downloading", "setDownloading", "Lcom/stepos/ailauncher/contract/model/SessionArtifact;", "artifact", "versionIndex", "versionCount", "P", "(Lcom/stepos/ailauncher/contract/model/SessionArtifact;IIZ)V", "", ConstConfig.KEY_VIEW_ALPHA_PROPERTY, "setChromeAlpha", "(F)V", "", "durationMs", "Landroid/animation/TimeInterpolator;", "interpolator", "onEnd", "B", "(FJLandroid/animation/TimeInterpolator;Lp9/a;)V", "I", "O", "onBack", "Lp9/a;", "getOnBack", "()Lp9/a;", "setOnBack", "(Lp9/a;)V", "onPrev", "getOnPrev", "setOnPrev", "onNext", "getOnNext", "setOnNext", "onFullscreen", "getOnFullscreen", "setOnFullscreen", "onDownload", "getOnDownload", "setOnDownload", "onPreview", "getOnPreview", "setOnPreview", "onCode", "getOnCode", "setOnCode", "isCodeSelected", "setCodeSelected", "Landroid/widget/ImageView;", "ivBack", "Landroid/widget/ImageView;", "Landroid/widget/LinearLayout;", "versionGroup", "Landroid/widget/LinearLayout;", "actionGroup", "ivPrev", "ivNext", "ivFullscreen", "ivMore", "ivDownload", "backGlass", "Ly7/E;", "versionGlass", "actionGlass", "fullscreenIconImmersive", "Ljava/lang/Boolean;", "Lcom/stepos/ailauncher/task/detail/r;", "moreMenu$delegate", "LY8/h;", "getMoreMenu", "()Lcom/stepos/ailauncher/task/detail/r;", "moreMenu", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArtifactDetailTopBar extends ConstraintLayout {
    private E actionGlass;
    private final LinearLayout actionGroup;
    private E backGlass;
    private Boolean fullscreenIconImmersive;
    private InterfaceC5063a<Boolean> isCodeSelected;
    private final ImageView ivBack;
    private final ImageView ivDownload;
    private final ImageView ivFullscreen;
    private final ImageView ivMore;
    private final ImageView ivNext;
    private final ImageView ivPrev;

    /* renamed from: moreMenu$delegate, reason: from kotlin metadata */
    private final Y8.h moreMenu;
    private InterfaceC5063a<t> onBack;
    private InterfaceC5063a<t> onCode;
    private InterfaceC5063a<t> onDownload;
    private InterfaceC5063a<t> onFullscreen;
    private InterfaceC5063a<t> onNext;
    private InterfaceC5063a<t> onPrev;
    private InterfaceC5063a<t> onPreview;
    private E versionGlass;
    private final LinearLayout versionGroup;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"com/stepos/ailauncher/task/detail/chrome/ArtifactDetailTopBar$a", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "LY8/t;", "onViewAttachedToWindow", "(Landroid/view/View;)V", "onViewDetachedFromWindow", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements View.OnAttachStateChangeListener {
        final /* synthetic */ InterfaceC5063a<t> $clearRef;
        final /* synthetic */ E $handle;

        public a(E e10, InterfaceC5063a<t> interfaceC5063a) {
            this.$handle = e10;
            this.$clearRef = interfaceC5063a;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v10) {
            kotlin.jvm.internal.p.i(v10, "v");
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v10) {
            kotlin.jvm.internal.p.i(v10, "v");
            v10.removeOnAttachStateChangeListener(this);
            com.stepos.ailauncher.container.glass.h.INSTANCE.F(this.$handle);
            this.$clearRef.invoke();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ArtifactDetailTopBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public static final void A(final ArtifactDetailTopBar artifactDetailTopBar) {
        if (artifactDetailTopBar.backGlass == null) {
            artifactDetailTopBar.backGlass = artifactDetailTopBar.H(artifactDetailTopBar.ivBack, new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.chrome.r
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return ArtifactDetailTopBar.j(this.f28534a);
                }
            });
        }
    }

    public static /* synthetic */ void C(ArtifactDetailTopBar artifactDetailTopBar, float f10, long j10, TimeInterpolator timeInterpolator, InterfaceC5063a interfaceC5063a, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            interfaceC5063a = null;
        }
        artifactDetailTopBar.B(f10, j10, timeInterpolator, interfaceC5063a);
    }

    public static final void D(InterfaceC5063a interfaceC5063a) {
        interfaceC5063a.invoke();
    }

    public static final void F(final ArtifactDetailTopBar artifactDetailTopBar) {
        if (artifactDetailTopBar.actionGlass == null && artifactDetailTopBar.actionGroup.getVisibility() == 0) {
            artifactDetailTopBar.actionGlass = artifactDetailTopBar.H(artifactDetailTopBar.actionGroup, new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.chrome.i
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return ArtifactDetailTopBar.G(this.f28525a);
                }
            });
        }
    }

    public static final t G(ArtifactDetailTopBar artifactDetailTopBar) {
        artifactDetailTopBar.actionGlass = null;
        return t.f7040a;
    }

    public static final boolean J() {
        return false;
    }

    public static final com.stepos.ailauncher.task.detail.r K(final ArtifactDetailTopBar artifactDetailTopBar) {
        return new com.stepos.ailauncher.task.detail.r(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.chrome.b
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ArtifactDetailTopBar.L(this.f28518a);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.chrome.c
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ArtifactDetailTopBar.M(this.f28519a);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.chrome.d
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ArtifactDetailTopBar.N(this.f28520a);
            }
        });
    }

    public static final t L(ArtifactDetailTopBar artifactDetailTopBar) {
        InterfaceC5063a<t> interfaceC5063a = artifactDetailTopBar.onPreview;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        return t.f7040a;
    }

    public static final t M(ArtifactDetailTopBar artifactDetailTopBar) {
        InterfaceC5063a<t> interfaceC5063a = artifactDetailTopBar.onCode;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        return t.f7040a;
    }

    public static final t N(ArtifactDetailTopBar artifactDetailTopBar) {
        InterfaceC5063a<t> interfaceC5063a = artifactDetailTopBar.onDownload;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        return t.f7040a;
    }

    public static final void Q(final ArtifactDetailTopBar artifactDetailTopBar) {
        if (artifactDetailTopBar.versionGlass == null && artifactDetailTopBar.versionGroup.getVisibility() == 0) {
            artifactDetailTopBar.versionGlass = artifactDetailTopBar.H(artifactDetailTopBar.versionGroup, new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.chrome.h
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return ArtifactDetailTopBar.R(this.f28524a);
                }
            });
        }
    }

    public static final t R(ArtifactDetailTopBar artifactDetailTopBar) {
        artifactDetailTopBar.versionGlass = null;
        return t.f7040a;
    }

    private final com.stepos.ailauncher.task.detail.r getMoreMenu() {
        return (com.stepos.ailauncher.task.detail.r) this.moreMenu.getValue();
    }

    public static t j(ArtifactDetailTopBar artifactDetailTopBar) {
        artifactDetailTopBar.backGlass = null;
        return t.f7040a;
    }

    public static final void u(ArtifactDetailTopBar artifactDetailTopBar, View view) {
        InterfaceC5063a<t> interfaceC5063a = artifactDetailTopBar.onBack;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }

    public static final void v(ArtifactDetailTopBar artifactDetailTopBar, View view) {
        InterfaceC5063a<t> interfaceC5063a = artifactDetailTopBar.onPrev;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }

    public static final void w(ArtifactDetailTopBar artifactDetailTopBar, View view) {
        InterfaceC5063a<t> interfaceC5063a = artifactDetailTopBar.onNext;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }

    public static final void x(ArtifactDetailTopBar artifactDetailTopBar, View view) {
        InterfaceC5063a<t> interfaceC5063a = artifactDetailTopBar.onDownload;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }

    public static final void y(ArtifactDetailTopBar artifactDetailTopBar, View view) {
        InterfaceC5063a<t> interfaceC5063a = artifactDetailTopBar.onFullscreen;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }

    public static final void z(ArtifactDetailTopBar artifactDetailTopBar, View view) {
        if (artifactDetailTopBar.getMoreMenu().e()) {
            artifactDetailTopBar.getMoreMenu().d();
        } else {
            artifactDetailTopBar.getMoreMenu().f(artifactDetailTopBar.actionGroup, artifactDetailTopBar.isCodeSelected.invoke().booleanValue());
        }
    }

    public final void B(float alpha, long durationMs, TimeInterpolator interpolator, InterfaceC5063a<t> onEnd) {
        kotlin.jvm.internal.p.i(interpolator, "interpolator");
        for (View view : C1173v.p(this.ivBack, this.versionGroup, this.actionGroup)) {
            view.animate().cancel();
            ViewPropertyAnimator interpolator2 = view.animate().alpha(alpha).setDuration(durationMs).setInterpolator(interpolator);
            Runnable runnable = null;
            final InterfaceC5063a<t> interfaceC5063a = view == this.actionGroup ? onEnd : null;
            if (interfaceC5063a != null) {
                runnable = new Runnable() { // from class: com.stepos.ailauncher.task.detail.chrome.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        ArtifactDetailTopBar.D(interfaceC5063a);
                    }
                };
            }
            interpolator2.withEndAction(runnable).start();
        }
    }

    public final void E() {
        if (this.actionGlass == null && this.actionGroup.getVisibility() == 0) {
            this.actionGroup.post(new Runnable() { // from class: com.stepos.ailauncher.task.detail.chrome.g
                @Override // java.lang.Runnable
                public final void run() {
                    ArtifactDetailTopBar.F(this.f28523a);
                }
            });
        }
    }

    public final E H(View target, InterfaceC5063a<t> clearRef) {
        E eM = com.stepos.ailauncher.container.glass.h.m(com.stepos.ailauncher.container.glass.h.INSTANCE, target, false, Float.valueOf(22.0f), null, false, 24, null);
        if (eM == null) {
            return null;
        }
        target.setBackground(null);
        target.addOnAttachStateChangeListener(new a(eM, clearRef));
        return eM;
    }

    public final void I() {
        this.ivBack.animate().cancel();
        this.versionGroup.animate().cancel();
        this.actionGroup.animate().cancel();
    }

    public final void O() {
        getMoreMenu().d();
        I();
        com.stepos.ailauncher.container.glass.h hVar = com.stepos.ailauncher.container.glass.h.INSTANCE;
        hVar.F(this.backGlass);
        this.backGlass = null;
        hVar.F(this.versionGlass);
        this.versionGlass = null;
        hVar.F(this.actionGlass);
        this.actionGlass = null;
    }

    public final void P(SessionArtifact artifact, int versionIndex, int versionCount, boolean immersive) throws Resources.NotFoundException {
        boolean z10 = true;
        boolean z11 = artifact != null && ArtifactRenderKind.INSTANCE.g(artifact) == ArtifactRenderKind.Kind.HTML;
        boolean z12 = artifact != null && ArtifactRenderKind.INSTANCE.g(artifact) == ArtifactRenderKind.Kind.CODE;
        boolean z13 = versionCount > 1;
        boolean z14 = z13 && versionIndex > 0;
        boolean z15 = z13 && versionIndex < versionCount - 1;
        this.ivPrev.setEnabled(z14);
        this.ivNext.setEnabled(z15);
        this.ivPrev.setAlpha(z14 ? 1.0f : 0.3f);
        this.ivNext.setAlpha(z15 ? 1.0f : 0.3f);
        this.ivFullscreen.setVisibility(artifact != null ? 0 : 8);
        S(immersive);
        this.ivMore.setVisibility(z11 && !immersive ? 0 : 8);
        this.ivDownload.setVisibility(!immersive && artifact != null && ((!z11 && ArtifactRenderKind.INSTANCE.c(artifact) != null) || z12) ? 0 : 8);
        this.ivBack.setVisibility(!immersive ? 0 : 8);
        this.versionGroup.setVisibility(z13 && !immersive ? 0 : 8);
        LinearLayout linearLayout = this.actionGroup;
        if (this.ivFullscreen.getVisibility() != 0 && this.ivMore.getVisibility() != 0 && this.ivDownload.getVisibility() != 0) {
            z10 = false;
        }
        linearLayout.setVisibility(z10 ? 0 : 8);
        s.a(this, immersive);
        if (this.versionGroup.getVisibility() == 0 && this.versionGlass == null) {
            this.versionGroup.post(new Runnable() { // from class: com.stepos.ailauncher.task.detail.chrome.e
                @Override // java.lang.Runnable
                public final void run() {
                    ArtifactDetailTopBar.Q(this.f28521a);
                }
            });
        }
        E();
    }

    public final void S(boolean immersive) {
        if (kotlin.jvm.internal.p.d(this.fullscreenIconImmersive, Boolean.valueOf(immersive))) {
            return;
        }
        this.fullscreenIconImmersive = Boolean.valueOf(immersive);
        this.ivFullscreen.setImageResource(immersive ? R$drawable.ic_task_detail_fullscreen_exit : R$drawable.ic_task_detail_fullscreen);
    }

    public final InterfaceC5063a<t> getOnBack() {
        return this.onBack;
    }

    public final InterfaceC5063a<t> getOnCode() {
        return this.onCode;
    }

    public final InterfaceC5063a<t> getOnDownload() {
        return this.onDownload;
    }

    public final InterfaceC5063a<t> getOnFullscreen() {
        return this.onFullscreen;
    }

    public final InterfaceC5063a<t> getOnNext() {
        return this.onNext;
    }

    public final InterfaceC5063a<t> getOnPrev() {
        return this.onPrev;
    }

    public final InterfaceC5063a<t> getOnPreview() {
        return this.onPreview;
    }

    public final void setChromeAlpha(float alpha) {
        this.ivBack.setAlpha(alpha);
        this.versionGroup.setAlpha(alpha);
        this.actionGroup.setAlpha(alpha);
    }

    public final void setCodeSelected(InterfaceC5063a<Boolean> interfaceC5063a) {
        kotlin.jvm.internal.p.i(interfaceC5063a, "<set-?>");
        this.isCodeSelected = interfaceC5063a;
    }

    public final void setDownloading(boolean downloading) {
        this.ivDownload.setEnabled(!downloading);
        this.ivDownload.setAlpha(downloading ? 0.5f : 1.0f);
    }

    public final void setOnBack(InterfaceC5063a<t> interfaceC5063a) {
        this.onBack = interfaceC5063a;
    }

    public final void setOnCode(InterfaceC5063a<t> interfaceC5063a) {
        this.onCode = interfaceC5063a;
    }

    public final void setOnDownload(InterfaceC5063a<t> interfaceC5063a) {
        this.onDownload = interfaceC5063a;
    }

    public final void setOnFullscreen(InterfaceC5063a<t> interfaceC5063a) {
        this.onFullscreen = interfaceC5063a;
    }

    public final void setOnNext(InterfaceC5063a<t> interfaceC5063a) {
        this.onNext = interfaceC5063a;
    }

    public final void setOnPrev(InterfaceC5063a<t> interfaceC5063a) {
        this.onPrev = interfaceC5063a;
    }

    public final void setOnPreview(InterfaceC5063a<t> interfaceC5063a) {
        this.onPreview = interfaceC5063a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtifactDetailTopBar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        this.isCodeSelected = new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.chrome.a
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Boolean.valueOf(ArtifactDetailTopBar.J());
            }
        };
        this.moreMenu = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.chrome.j
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ArtifactDetailTopBar.K(this.f28526a);
            }
        });
        LayoutInflater.from(context).inflate(R$layout.view_artifact_detail_topbar, (ViewGroup) this, true);
        View viewFindViewById = findViewById(R$id.iv_back);
        kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
        ImageView imageView = (ImageView) viewFindViewById;
        this.ivBack = imageView;
        View viewFindViewById2 = findViewById(R$id.version_btn_group);
        kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
        this.versionGroup = (LinearLayout) viewFindViewById2;
        View viewFindViewById3 = findViewById(R$id.action_btn_group);
        kotlin.jvm.internal.p.h(viewFindViewById3, "findViewById(...)");
        this.actionGroup = (LinearLayout) viewFindViewById3;
        View viewFindViewById4 = findViewById(R$id.ivPartPrev);
        kotlin.jvm.internal.p.h(viewFindViewById4, "findViewById(...)");
        ImageView imageView2 = (ImageView) viewFindViewById4;
        this.ivPrev = imageView2;
        View viewFindViewById5 = findViewById(R$id.ivPartNext);
        kotlin.jvm.internal.p.h(viewFindViewById5, "findViewById(...)");
        ImageView imageView3 = (ImageView) viewFindViewById5;
        this.ivNext = imageView3;
        View viewFindViewById6 = findViewById(R$id.ivFullscreen);
        kotlin.jvm.internal.p.h(viewFindViewById6, "findViewById(...)");
        ImageView imageView4 = (ImageView) viewFindViewById6;
        this.ivFullscreen = imageView4;
        View viewFindViewById7 = findViewById(R$id.ivMore);
        kotlin.jvm.internal.p.h(viewFindViewById7, "findViewById(...)");
        ImageView imageView5 = (ImageView) viewFindViewById7;
        this.ivMore = imageView5;
        View viewFindViewById8 = findViewById(R$id.ivDownload);
        kotlin.jvm.internal.p.h(viewFindViewById8, "findViewById(...)");
        ImageView imageView6 = (ImageView) viewFindViewById8;
        this.ivDownload = imageView6;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.detail.chrome.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArtifactDetailTopBar.u(this.f28527a, view);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.detail.chrome.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArtifactDetailTopBar.v(this.f28528a, view);
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.detail.chrome.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArtifactDetailTopBar.w(this.f28529a, view);
            }
        });
        imageView6.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.detail.chrome.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArtifactDetailTopBar.x(this.f28530a, view);
            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.detail.chrome.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArtifactDetailTopBar.y(this.f28531a, view);
            }
        });
        imageView5.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.detail.chrome.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArtifactDetailTopBar.z(this.f28532a, view);
            }
        });
        setClickable(true);
        imageView.post(new Runnable() { // from class: com.stepos.ailauncher.task.detail.chrome.q
            @Override // java.lang.Runnable
            public final void run() {
                ArtifactDetailTopBar.A(this.f28533a);
            }
        });
    }

    public /* synthetic */ ArtifactDetailTopBar(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
