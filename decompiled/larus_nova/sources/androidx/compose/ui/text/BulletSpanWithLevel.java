package androidx.compose.ui.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/text/BulletSpanWithLevel;", "", "bullet", "Landroidx/compose/ui/text/Bullet;", "indentationLevel", "", "start", "<init>", "(Landroidx/compose/ui/text/Bullet;II)V", "getBullet", "()Landroidx/compose/ui/text/Bullet;", "getIndentationLevel", "()I", "getStart", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BulletSpanWithLevel {
    public static final int $stable = 8;
    private final Bullet bullet;
    private final int indentationLevel;
    private final int start;

    public static /* synthetic */ BulletSpanWithLevel copy$default(BulletSpanWithLevel r100, Bullet r101, int r102, int r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.bullet;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.indentationLevel;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.start;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final Bullet component1() {
        return this.bullet;
    }

    public final int component2() {
        return this.indentationLevel;
    }

    public final int component3() {
        return this.start;
    }

    public final BulletSpanWithLevel copy(Bullet r100, int r101, int r102) {
        return new BulletSpanWithLevel(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BulletSpanWithLevel) == true) goto L8;
        return false;
    L8:
        BulletSpanWithLevel r101 = (BulletSpanWithLevel) r100;
        if (Intrinsics.areEqual(this.bullet, r101.bullet) == true) goto L12;
        return false;
    L12:
        if (this.indentationLevel == r101.indentationLevel) goto L15;
        return false;
    L15:
        if (this.start == r101.start) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.bullet.hashCode() * 31) + this.indentationLevel) * 31) + this.start;
    }

    public String toString() {
        return "BulletSpanWithLevel(bullet=" + this.bullet + ", indentationLevel=" + this.indentationLevel + ", start=" + this.start + ')';
    }

    public final Bullet getBullet() {
        return this.bullet;
    }

    public final int getIndentationLevel() {
        return this.indentationLevel;
    }

    public final int getStart() {
        return this.start;
    }

    public BulletSpanWithLevel(Bullet r100, int r101, int r102) {
        this.bullet = r100;
        this.indentationLevel = r101;
        this.start = r102;
    }
}
