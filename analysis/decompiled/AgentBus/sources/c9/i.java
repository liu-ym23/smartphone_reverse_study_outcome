package c9;

import f9.p;

/* loaded from: classes.dex */
public enum i implements p {
    NONE(0),
    INTERNAL_TO_CLASS_ID(1),
    DESC_TO_CLASS_ID(2);


    /* renamed from: f, reason: collision with root package name */
    public final int f2139f;

    i(int i2) {
        this.f2139f = i2;
    }

    @Override // f9.p
    public final int getNumber() {
        return this.f2139f;
    }
}
