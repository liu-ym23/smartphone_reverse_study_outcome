package com.uxsense;

import S7.k;
import java.util.function.Consumer;

/* loaded from: classes3.dex */
public final /* synthetic */ class b implements Consumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4194a;
    public final /* synthetic */ k b;

    public /* synthetic */ b(k kVar, int i) {
        this.f4194a = i;
        this.b = kVar;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i = this.f4194a;
        k kVar = this.b;
        switch (i) {
            case 0:
                ((a) kVar).invoke(obj);
                break;
            case 1:
                ((a) kVar).invoke(obj);
                break;
            default:
                ((c) kVar).invoke(obj);
                break;
        }
    }
}
