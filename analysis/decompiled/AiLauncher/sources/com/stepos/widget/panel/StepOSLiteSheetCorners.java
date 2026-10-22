package com.stepos.widget.panel;

import Y8.t;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001BM\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0006\u0012\u0016\u0010\n\u001a\u0012\u0012\b\u0012\u00060\bj\u0002`\t\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0012R&\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0013R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0014R$\u0010\n\u001a\u0012\u0012\b\u0012\u00060\bj\u0002`\t\u0012\u0004\u0012\u00020\u00040\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/stepos/widget/panel/StepOSLiteSheetCorners;", "", "Lkotlin/Function2;", "", "LY8/t;", "applyAsymmetric", "Lkotlin/Function1;", "applyUniform", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onFailure", "<init>", "(Lp9/p;Lp9/l;Lp9/l;)V", "top", "bottom", com.stepos.ailauncher.chat.trace.a.BUTTON_UPDATE, "(FF)V", "reset", "()V", "Lp9/p;", "Lp9/l;", "", "asymmetricAvailable", "Z", "uniformAvailable", "appliedTop", "Ljava/lang/Float;", "appliedBottom", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSLiteSheetCorners {
    private Float appliedBottom;
    private Float appliedTop;
    private final p9.p<Float, Float, t> applyAsymmetric;
    private final InterfaceC5074l<Float, t> applyUniform;
    private boolean asymmetricAvailable;
    private final InterfaceC5074l<Exception, t> onFailure;
    private boolean uniformAvailable;

    /* JADX WARN: Multi-variable type inference failed */
    public StepOSLiteSheetCorners(p9.p<? super Float, ? super Float, t> applyAsymmetric, InterfaceC5074l<? super Float, t> applyUniform, InterfaceC5074l<? super Exception, t> onFailure) {
        kotlin.jvm.internal.p.i(applyAsymmetric, "applyAsymmetric");
        kotlin.jvm.internal.p.i(applyUniform, "applyUniform");
        kotlin.jvm.internal.p.i(onFailure, "onFailure");
        this.applyAsymmetric = applyAsymmetric;
        this.applyUniform = applyUniform;
        this.onFailure = onFailure;
        this.asymmetricAvailable = true;
        this.uniformAvailable = true;
    }

    public final void reset() {
        this.asymmetricAvailable = true;
        this.uniformAvailable = true;
        this.appliedTop = null;
        this.appliedBottom = null;
    }

    public final void update(float top, float bottom) {
        if (this.asymmetricAvailable) {
            if (kotlin.jvm.internal.p.b(this.appliedTop, top) && kotlin.jvm.internal.p.b(this.appliedBottom, bottom)) {
                return;
            }
            try {
                this.applyAsymmetric.invoke(Float.valueOf(top), Float.valueOf(bottom));
                this.appliedTop = Float.valueOf(top);
                this.appliedBottom = Float.valueOf(bottom);
                return;
            } catch (Exception e10) {
                this.asymmetricAvailable = false;
                this.appliedTop = null;
                this.appliedBottom = null;
                this.onFailure.invoke(e10);
            }
        }
        if (!this.uniformAvailable || kotlin.jvm.internal.p.b(this.appliedTop, top)) {
            return;
        }
        try {
            this.applyUniform.invoke(Float.valueOf(top));
            this.appliedTop = Float.valueOf(top);
        } catch (Exception e11) {
            this.uniformAvailable = false;
            this.onFailure.invoke(e11);
        }
    }
}
