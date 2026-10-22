package com.github.lcdsmao.springx;

import com.obric.oui.animation.easy.SpringAnimationConfig;
import com.obric.oui.animation.engine.SpringAnimation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SpringAnimationHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0007\u001a\u00020\u0003HÂ\u0003J\t\u0010\b\u001a\u00020\u0005HÂ\u0003J\u001d\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/github/lcdsmao/springx/SpringAnimationHolder;", "", "animation", "Lcom/obric/oui/animation/engine/SpringAnimation;", "config", "Lcom/obric/oui/animation/easy/SpringAnimationConfig;", "(Lcom/obric/oui/animation/engine/SpringAnimation;Lcom/obric/oui/animation/easy/SpringAnimationConfig;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "start", "", "toString", "", "OUIAnimation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SpringAnimationHolder {
    private final SpringAnimation animation;
    private final SpringAnimationConfig config;

    private final SpringAnimation component1() {
        return this.animation;
    }

    private final SpringAnimationConfig component2() {
        return this.config;
    }

    public static /* synthetic */ SpringAnimationHolder copy$default(SpringAnimationHolder r0, SpringAnimation r1, SpringAnimationConfig r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.animation;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.config;
    L9:
        return r0.copy(r1, r2);
    }

    public final SpringAnimationHolder copy(SpringAnimation r1, SpringAnimationConfig r2) {
        Intrinsics.checkNotNullParameter(r1, "animation");
        Intrinsics.checkNotNullParameter(r2, "config");
        return new SpringAnimationHolder(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SpringAnimationHolder) == true) goto L8;
        return false;
    L8:
        SpringAnimationHolder r6 = (SpringAnimationHolder) r5;
        if (Intrinsics.areEqual(this.animation, r6.animation) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.config, r6.config) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.animation.hashCode() * 31) + this.config.hashCode();
    }

    public String toString() {
        return "SpringAnimationHolder(animation=" + this.animation + ", config=" + this.config + ')';
    }

    public SpringAnimationHolder(SpringAnimation r2, SpringAnimationConfig r3) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        Intrinsics.checkNotNullParameter(r3, "config");
        this.animation = r2;
        this.config = r3;
    }

    public final void start() {
        this.config.applyTo$OUIAnimation_release(this.animation);
        this.animation.start();
    }
}
