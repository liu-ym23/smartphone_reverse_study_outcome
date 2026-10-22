package v9;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0018¨\u0006\u001b"}, d2 = {"Lv9/e;", "Lv9/f;", "", "start", "endInclusive", "<init>", "(FF)V", UxipConstants.f30680s, "", Const.INTENT_KEY_PKGNAME, "(F)Z", "c", "()Z", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "F", "_start", "_endInclusive", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: v9.e, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C5676e implements InterfaceC5677f<Float> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final float _start;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final float _endInclusive;

    public C5676e(float f10, float f11) {
        this._start = f10;
        this._endInclusive = f11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // v9.InterfaceC5677f
    public /* bridge */ /* synthetic */ boolean a(Comparable comparable) {
        return b(((Number) comparable).floatValue());
    }

    public boolean b(float value) {
        return value >= this._start && value <= this._endInclusive;
    }

    public boolean c() {
        return this._start > this._endInclusive;
    }

    public boolean equals(Object other) {
        if (!(other instanceof C5676e)) {
            return false;
        }
        if (c() && ((C5676e) other).c()) {
            return true;
        }
        C5676e c5676e = (C5676e) other;
        return this._start == c5676e._start && this._endInclusive == c5676e._endInclusive;
    }

    public int hashCode() {
        if (c()) {
            return -1;
        }
        return (Float.hashCode(this._start) * 31) + Float.hashCode(this._endInclusive);
    }

    public String toString() {
        return this._start + ".." + this._endInclusive;
    }
}
