package kotlin.jvm.internal;

import w9.InterfaceC5745d;
import w9.InterfaceC5747f;

/* loaded from: classes4.dex */
public class FunctionReferenceImpl extends FunctionReference {
    public FunctionReferenceImpl(int i10, InterfaceC5747f interfaceC5747f, String str, String str2) {
        super(i10, CallableReference.NO_RECEIVER, ((f) interfaceC5747f).m(), str, str2, !(interfaceC5747f instanceof InterfaceC5745d) ? 1 : 0);
    }

    public FunctionReferenceImpl(int i10, Class cls, String str, String str2, int i11) {
        super(i10, CallableReference.NO_RECEIVER, cls, str, str2, i11);
    }

    public FunctionReferenceImpl(int i10, Object obj, Class cls, String str, String str2, int i11) {
        super(i10, obj, cls, str, str2, i11);
    }
}
