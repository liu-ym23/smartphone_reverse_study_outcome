package com.google.protobuf;

import com.google.protobuf.GeneratedMessageV3;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.protobuf.e1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0934e1 {

    /* renamed from: a, reason: collision with root package name */
    public final Iterator f2917a;
    public Map.Entry b;

    public C0934e1(GeneratedMessageV3.ExtendableMessage extendableMessage) {
        Iterator itP = extendableMessage.c.p();
        this.f2917a = itP;
        if (itP.hasNext()) {
            this.b = (Map.Entry) itP.next();
        }
    }

    public final void a(int i, C0980q c0980q) {
        while (true) {
            Map.Entry entry = this.b;
            if (entry == null || ((D0) entry.getKey()).b.e >= i) {
                return;
            }
            Y0.w((D0) this.b.getKey(), this.b.getValue(), c0980q);
            Iterator it = this.f2917a;
            if (it.hasNext()) {
                this.b = (Map.Entry) it.next();
            } else {
                this.b = null;
            }
        }
    }
}
