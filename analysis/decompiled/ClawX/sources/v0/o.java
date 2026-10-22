package v0;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5899a;

    /* renamed from: b, reason: collision with root package name */
    public int f5900b;

    /* renamed from: c, reason: collision with root package name */
    public int f5901c;
    public boolean d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f5902e;

    public o(int i8) {
        this.f5899a = i8;
        switch (i8) {
            case 1:
                break;
            default:
                this.f5900b = -1;
                this.f5901c = Integer.MIN_VALUE;
                this.d = false;
                this.f5902e = false;
                break;
        }
    }

    public String toString() {
        switch (this.f5899a) {
            case 0:
                return "AnchorInfo{mPosition=" + this.f5900b + ", mCoordinate=" + this.f5901c + ", mLayoutFromEnd=" + this.d + ", mValid=" + this.f5902e + AbstractJsonLexerKt.END_OBJ;
            default:
                return super.toString();
        }
    }
}
