package com.stepos.ailauncher.sheet;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/stepos/ailauncher/sheet/e0;", "", "Lcom/stepos/ailauncher/sheet/g0;", "offset", "", "travelWidthFraction", "<init>", "(Lcom/stepos/ailauncher/sheet/g0;F)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ailauncher/sheet/g0;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/sheet/g0;", "F", Const.INTENT_KEY_PKGNAME, "()F", "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.sheet.e0, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class SheetOffsetMotion {
    private final SheetSpring offset;
    private final float travelWidthFraction;

    public SheetOffsetMotion(SheetSpring offset, float f10) {
        kotlin.jvm.internal.p.i(offset, "offset");
        this.offset = offset;
        this.travelWidthFraction = f10;
    }

    /* renamed from: a, reason: from getter */
    public final SheetSpring getOffset() {
        return this.offset;
    }

    /* renamed from: b, reason: from getter */
    public final float getTravelWidthFraction() {
        return this.travelWidthFraction;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SheetOffsetMotion)) {
            return false;
        }
        SheetOffsetMotion sheetOffsetMotion = (SheetOffsetMotion) other;
        return kotlin.jvm.internal.p.d(this.offset, sheetOffsetMotion.offset) && Float.compare(this.travelWidthFraction, sheetOffsetMotion.travelWidthFraction) == 0;
    }

    public int hashCode() {
        return (this.offset.hashCode() * 31) + Float.hashCode(this.travelWidthFraction);
    }

    public String toString() {
        return "SheetOffsetMotion(offset=" + this.offset + ", travelWidthFraction=" + this.travelWidthFraction + ")";
    }
}
