package com.stepos.ailauncher.sheet;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\nB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\tJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0018\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/stepos/ailauncher/sheet/g0;", "", "", "stiffness", "dampingRatio", "<init>", "(FF)V", "tempo", "e", "(FF)Lcom/stepos/ailauncher/sheet/g0;", Const.INTENT_KEY_APIKEY, "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "F", Const.INTENT_KEY_UMID, "()F", "c", "Companion", "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.sheet.g0, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class SheetSpring {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final float dampingRatio;
    private final float stiffness;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/stepos/ailauncher/sheet/g0$a;", "", "<init>", "()V", "", "stiffness", "damping", "mass", "Lcom/stepos/ailauncher/sheet/g0;", Const.INTENT_KEY_APIKEY, "(FFF)Lcom/stepos/ailauncher/sheet/g0;", "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.sheet.g0$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public static /* synthetic */ SheetSpring b(Companion companion, float f10, float f11, float f12, int i10, Object obj) {
            if ((i10 & 4) != 0) {
                f12 = 1.0f;
            }
            return companion.a(f10, f11, f12);
        }

        public final SheetSpring a(float stiffness, float damping, float mass) {
            if (stiffness <= 0.0f) {
                throw new IllegalArgumentException("stiffness must be > 0");
            }
            if (damping < 0.0f) {
                throw new IllegalArgumentException("damping must be >= 0");
            }
            if (mass > 0.0f) {
                return new SheetSpring(stiffness, damping / (((float) Math.sqrt(mass * stiffness)) * 2.0f));
            }
            throw new IllegalArgumentException("mass must be > 0");
        }

        public Companion() {
        }
    }

    public SheetSpring(float f10, float f11) {
        this.stiffness = f10;
        this.dampingRatio = f11;
    }

    public static /* synthetic */ SheetSpring b(SheetSpring sheetSpring, float f10, float f11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = sheetSpring.stiffness;
        }
        if ((i10 & 2) != 0) {
            f11 = sheetSpring.dampingRatio;
        }
        return sheetSpring.a(f10, f11);
    }

    public static /* synthetic */ SheetSpring f(SheetSpring sheetSpring, float f10, float f11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            f11 = sheetSpring.dampingRatio;
        }
        return sheetSpring.e(f10, f11);
    }

    public final SheetSpring a(float stiffness, float dampingRatio) {
        return new SheetSpring(stiffness, dampingRatio);
    }

    /* renamed from: c, reason: from getter */
    public final float getDampingRatio() {
        return this.dampingRatio;
    }

    /* renamed from: d, reason: from getter */
    public final float getStiffness() {
        return this.stiffness;
    }

    public final SheetSpring e(float tempo, float dampingRatio) {
        return new SheetSpring(this.stiffness * tempo * tempo, dampingRatio);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SheetSpring)) {
            return false;
        }
        SheetSpring sheetSpring = (SheetSpring) other;
        return Float.compare(this.stiffness, sheetSpring.stiffness) == 0 && Float.compare(this.dampingRatio, sheetSpring.dampingRatio) == 0;
    }

    public int hashCode() {
        return (Float.hashCode(this.stiffness) * 31) + Float.hashCode(this.dampingRatio);
    }

    public String toString() {
        return "SheetSpring(stiffness=" + this.stiffness + ", dampingRatio=" + this.dampingRatio + ")";
    }
}
