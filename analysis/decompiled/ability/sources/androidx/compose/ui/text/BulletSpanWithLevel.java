package androidx.compose.ui.text;

import androidx.compose.runtime.internal.StabilityInferred;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/text/BulletSpanWithLevel;", "", "bullet", "Landroidx/compose/ui/text/Bullet;", "indentationLevel", "", "start", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/text/Bullet;II)V", "getBullet", "()Landroidx/compose/ui/text/Bullet;", "getIndentationLevel", "()I", "getStart", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class BulletSpanWithLevel {
    public static final int $stable = 8;
    private final Bullet bullet;
    private final int indentationLevel;
    private final int start;

    public BulletSpanWithLevel(Bullet bullet, int i, int i6) {
        this.bullet = bullet;
        this.indentationLevel = i;
        this.start = i6;
    }

    public static /* synthetic */ BulletSpanWithLevel copy$default(BulletSpanWithLevel bulletSpanWithLevel, Bullet bullet, int i, int i6, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            bullet = bulletSpanWithLevel.bullet;
        }
        if ((i10 & 2) != 0) {
            i = bulletSpanWithLevel.indentationLevel;
        }
        if ((i10 & 4) != 0) {
            i6 = bulletSpanWithLevel.start;
        }
        return bulletSpanWithLevel.copy(bullet, i, i6);
    }

    /* renamed from: component1, reason: from getter */
    public final Bullet getBullet() {
        return this.bullet;
    }

    /* renamed from: component2, reason: from getter */
    public final int getIndentationLevel() {
        return this.indentationLevel;
    }

    /* renamed from: component3, reason: from getter */
    public final int getStart() {
        return this.start;
    }

    public final BulletSpanWithLevel copy(Bullet bullet, int indentationLevel, int start) {
        return new BulletSpanWithLevel(bullet, indentationLevel, start);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BulletSpanWithLevel)) {
            return false;
        }
        BulletSpanWithLevel bulletSpanWithLevel = (BulletSpanWithLevel) other;
        return k.b(this.bullet, bulletSpanWithLevel.bullet) && this.indentationLevel == bulletSpanWithLevel.indentationLevel && this.start == bulletSpanWithLevel.start;
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

    public int hashCode() {
        return Integer.hashCode(this.start) + androidx.constraintlayout.core.dsl.a.a(this.indentationLevel, this.bullet.hashCode() * 31, 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("BulletSpanWithLevel(bullet=");
        sb.append(this.bullet);
        sb.append(", indentationLevel=");
        sb.append(this.indentationLevel);
        sb.append(", start=");
        return B7.a.o(sb, this.start, ')');
    }
}
