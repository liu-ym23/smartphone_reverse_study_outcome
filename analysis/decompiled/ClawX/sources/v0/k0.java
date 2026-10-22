package v0;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class k0 {

    /* renamed from: a, reason: collision with root package name */
    public int f5865a;

    /* renamed from: b, reason: collision with root package name */
    public int f5866b;

    /* renamed from: c, reason: collision with root package name */
    public int f5867c;
    public boolean d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f5868e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f5869f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f5870g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f5871h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f5872i;

    public final int a() {
        return this.f5868e ? this.f5865a - this.f5866b : this.f5867c;
    }

    public final String toString() {
        return "State{mTargetPosition=-1, mData=null, mItemCount=" + this.f5867c + ", mIsMeasuring=" + this.f5870g + ", mPreviousLayoutItemCount=" + this.f5865a + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f5866b + ", mStructureChanged=" + this.d + ", mInPreLayout=" + this.f5868e + ", mRunSimpleAnimations=" + this.f5871h + ", mRunPredictiveAnimations=" + this.f5872i + AbstractJsonLexerKt.END_OBJ;
    }
}
