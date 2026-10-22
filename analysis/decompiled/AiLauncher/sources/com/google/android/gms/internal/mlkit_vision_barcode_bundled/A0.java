package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.A0;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0;

/* loaded from: classes2.dex */
public class A0<MessageType extends F0<MessageType, BuilderType>, BuilderType extends A0<MessageType, BuilderType>> extends S<MessageType, BuilderType> {

    /* renamed from: a, reason: collision with root package name */
    public final F0 f20006a;

    /* renamed from: b, reason: collision with root package name */
    public F0 f20007b;

    public A0(MessageType messagetype) {
        this.f20006a = messagetype;
        if (messagetype.C()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.f20007b = messagetype.o();
    }

    public static void k(Object obj, Object obj2) {
        C1752p1.a().b(obj.getClass()).e(obj, obj2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1724i1
    public final boolean h() {
        return F0.B(this.f20007b, false);
    }

    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public final A0 clone() {
        A0 a02 = (A0) this.f20006a.F(5, null, null);
        a02.f20007b = G();
        return a02;
    }

    public final A0 o(F0 f02) {
        if (!this.f20006a.equals(f02)) {
            if (!this.f20007b.C()) {
                s();
            }
            k(this.f20007b, f02);
        }
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1716g1
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public final MessageType zzj() {
        MessageType messagetype = (MessageType) G();
        if (F0.B(messagetype, true)) {
            return messagetype;
        }
        throw new zzgr(messagetype);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1716g1
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public MessageType G() {
        if (!this.f20007b.C()) {
            return (MessageType) this.f20007b;
        }
        this.f20007b.x();
        return (MessageType) this.f20007b;
    }

    public final void r() {
        if (this.f20007b.C()) {
            return;
        }
        s();
    }

    public void s() {
        F0 f0O = this.f20006a.o();
        k(f0O, this.f20007b);
        this.f20007b = f0O;
    }
}
