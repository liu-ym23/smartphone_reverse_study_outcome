package v0;

import v0.k;

/* loaded from: classes.dex */
public abstract class k<CHILD extends k<CHILD, TranscodeType>, TranscodeType> implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private V0.c<? super TranscodeType> f23308a = V0.a.a();

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final CHILD clone() {
        try {
            return (CHILD) super.clone();
        } catch (CloneNotSupportedException e6) {
            throw new RuntimeException(e6);
        }
    }

    final V0.c<? super TranscodeType> d() {
        return this.f23308a;
    }
}
