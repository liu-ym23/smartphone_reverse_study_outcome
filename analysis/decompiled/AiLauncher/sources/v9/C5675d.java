package v9;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0018¨\u0006\u001b"}, d2 = {"Lv9/d;", "Lv9/f;", "", "start", "endInclusive", "<init>", "(DD)V", UxipConstants.f30680s, "", Const.INTENT_KEY_PKGNAME, "(D)Z", "c", "()Z", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "D", "_start", "_endInclusive", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: v9.d, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C5675d implements InterfaceC5677f<Double> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final double _start;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final double _endInclusive;

    public C5675d(double d10, double d11) {
        this._start = d10;
        this._endInclusive = d11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // v9.InterfaceC5677f
    public /* bridge */ /* synthetic */ boolean a(Comparable comparable) {
        return b(((Number) comparable).doubleValue());
    }

    public boolean b(double value) {
        return value >= this._start && value <= this._endInclusive;
    }

    public boolean c() {
        return this._start > this._endInclusive;
    }

    public boolean equals(Object other) {
        if (!(other instanceof C5675d)) {
            return false;
        }
        if (c() && ((C5675d) other).c()) {
            return true;
        }
        C5675d c5675d = (C5675d) other;
        return this._start == c5675d._start && this._endInclusive == c5675d._endInclusive;
    }

    public int hashCode() {
        if (c()) {
            return -1;
        }
        return (Double.hashCode(this._start) * 31) + Double.hashCode(this._endInclusive);
    }

    public String toString() {
        return this._start + ".." + this._endInclusive;
    }
}
