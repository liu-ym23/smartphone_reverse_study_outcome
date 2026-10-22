package com.stepos.ailauncher.sheet.internal;

import androidx.dynamicanimation.animation.e;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$BooleanRef;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J}\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/stepos/ailauncher/sheet/internal/f;", "", "<init>", "()V", "", "startOffset", "endOffset", "offsetStiffness", "offsetDampingRatio", "startScaleX", "endScaleX", "scaleStiffness", "scaleDampingRatio", "", "completeOnOffsetOnly", "Lkotlin/Function2;", "LY8/t;", "onFrame", "Lkotlin/Function0;", "onEnd", "Lcom/stepos/ailauncher/sheet/internal/f$a;", "e", "(FFFFFFFFZLp9/p;Lp9/a;)Lcom/stepos/ailauncher/sheet/internal/f$a;", Const.INTENT_KEY_APIKEY, "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.sheet.internal.f, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3447f {
    public static final C3447f INSTANCE = new C3447f();

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\fR\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\fR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/ailauncher/sheet/internal/f$a;", "", "Landroidx/dynamicanimation/animation/i;", "offsetAnim", "scaleAnim", "Lcom/stepos/ailauncher/sheet/internal/M;", "frames", "<init>", "(Landroidx/dynamicanimation/animation/i;Landroidx/dynamicanimation/animation/i;Lcom/stepos/ailauncher/sheet/internal/M;)V", "LY8/t;", Const.INTENT_KEY_APIKEY, "()V", "Landroidx/dynamicanimation/animation/i;", "Lcom/stepos/ailauncher/sheet/internal/M;", "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.sheet.internal.f$a */
    public static final class a {
        private final M frames;
        private final androidx.dynamicanimation.animation.i offsetAnim;
        private final androidx.dynamicanimation.animation.i scaleAnim;

        public a(androidx.dynamicanimation.animation.i offsetAnim, androidx.dynamicanimation.animation.i scaleAnim, M frames) {
            kotlin.jvm.internal.p.i(offsetAnim, "offsetAnim");
            kotlin.jvm.internal.p.i(scaleAnim, "scaleAnim");
            kotlin.jvm.internal.p.i(frames, "frames");
            this.offsetAnim = offsetAnim;
            this.scaleAnim = scaleAnim;
            this.frames = frames;
        }

        public final void a() {
            this.frames.a();
            this.offsetAnim.d();
            this.scaleAnim.d();
        }
    }

    public static final void f(M m10, androidx.dynamicanimation.animation.e eVar, float f10, float f11) {
        m10.f(f10);
    }

    public static final void g(M m10, androidx.dynamicanimation.animation.e eVar, float f10, float f11) {
        m10.g(f10);
    }

    public static final void h(Ref$BooleanRef ref$BooleanRef, M m10, Ref$BooleanRef ref$BooleanRef2, boolean z10, Ref$BooleanRef ref$BooleanRef3, androidx.dynamicanimation.animation.i iVar, InterfaceC5063a interfaceC5063a, androidx.dynamicanimation.animation.e eVar, boolean z11, float f10, float f11) {
        if (z11) {
            return;
        }
        ref$BooleanRef.f34815a = true;
        m10.c();
        j(ref$BooleanRef2, ref$BooleanRef, z10, ref$BooleanRef3, m10, iVar, interfaceC5063a);
    }

    public static final void i(Ref$BooleanRef ref$BooleanRef, M m10, Ref$BooleanRef ref$BooleanRef2, Ref$BooleanRef ref$BooleanRef3, boolean z10, androidx.dynamicanimation.animation.i iVar, InterfaceC5063a interfaceC5063a, androidx.dynamicanimation.animation.e eVar, boolean z11, float f10, float f11) {
        if (z11) {
            return;
        }
        ref$BooleanRef.f34815a = true;
        m10.d();
        j(ref$BooleanRef2, ref$BooleanRef3, z10, ref$BooleanRef, m10, iVar, interfaceC5063a);
    }

    public static final void j(Ref$BooleanRef ref$BooleanRef, Ref$BooleanRef ref$BooleanRef2, boolean z10, Ref$BooleanRef ref$BooleanRef3, M m10, androidx.dynamicanimation.animation.i iVar, InterfaceC5063a<Y8.t> interfaceC5063a) {
        if (!ref$BooleanRef.f34815a && ref$BooleanRef2.f34815a) {
            if (z10 || ref$BooleanRef3.f34815a) {
                ref$BooleanRef.f34815a = true;
                m10.e();
                if (!ref$BooleanRef3.f34815a) {
                    iVar.d();
                }
                m10.a();
                interfaceC5063a.invoke();
            }
        }
    }

    public final a e(float startOffset, float endOffset, float offsetStiffness, float offsetDampingRatio, float startScaleX, float endScaleX, float scaleStiffness, float scaleDampingRatio, final boolean completeOnOffsetOnly, p9.p<? super Float, ? super Float, Y8.t> onFrame, final InterfaceC5063a<Y8.t> onEnd) {
        kotlin.jvm.internal.p.i(onFrame, "onFrame");
        kotlin.jvm.internal.p.i(onEnd, "onEnd");
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        final Ref$BooleanRef ref$BooleanRef2 = new Ref$BooleanRef();
        final Ref$BooleanRef ref$BooleanRef3 = new Ref$BooleanRef();
        final M m10 = new M(startOffset, startScaleX, onFrame);
        androidx.dynamicanimation.animation.i iVar = new androidx.dynamicanimation.animation.i(new androidx.dynamicanimation.animation.g(startOffset));
        iVar.B(new androidx.dynamicanimation.animation.j(endOffset).h(offsetStiffness).f(offsetDampingRatio));
        iVar.c(new e.r() { // from class: com.stepos.ailauncher.sheet.internal.b
            @Override // androidx.dynamicanimation.animation.e.r
            public final void b(androidx.dynamicanimation.animation.e eVar, float f10, float f11) {
                C3447f.f(m10, eVar, f10, f11);
            }
        });
        final androidx.dynamicanimation.animation.i iVar2 = new androidx.dynamicanimation.animation.i(new androidx.dynamicanimation.animation.g(startScaleX));
        iVar2.o(0.002f);
        iVar2.B(new androidx.dynamicanimation.animation.j(endScaleX).h(scaleStiffness).f(scaleDampingRatio));
        iVar2.c(new e.r() { // from class: com.stepos.ailauncher.sheet.internal.c
            @Override // androidx.dynamicanimation.animation.e.r
            public final void b(androidx.dynamicanimation.animation.e eVar, float f10, float f11) {
                C3447f.g(m10, eVar, f10, f11);
            }
        });
        iVar.b(new e.q() { // from class: com.stepos.ailauncher.sheet.internal.d
            @Override // androidx.dynamicanimation.animation.e.q
            public final void a(androidx.dynamicanimation.animation.e eVar, boolean z10, float f10, float f11) {
                C3447f.h(ref$BooleanRef, m10, ref$BooleanRef3, completeOnOffsetOnly, ref$BooleanRef2, iVar2, onEnd, eVar, z10, f10, f11);
            }
        });
        iVar2.b(new e.q() { // from class: com.stepos.ailauncher.sheet.internal.e
            @Override // androidx.dynamicanimation.animation.e.q
            public final void a(androidx.dynamicanimation.animation.e eVar, boolean z10, float f10, float f11) {
                C3447f.i(ref$BooleanRef2, m10, ref$BooleanRef3, ref$BooleanRef, completeOnOffsetOnly, iVar2, onEnd, eVar, z10, f10, f11);
            }
        });
        iVar.t();
        iVar2.t();
        return new a(iVar, iVar2, m10);
    }
}
