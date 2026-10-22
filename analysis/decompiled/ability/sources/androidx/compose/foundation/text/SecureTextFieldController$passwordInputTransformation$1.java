package androidx.compose.foundation.text;

import C7.r;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public /* synthetic */ class SecureTextFieldController$passwordInputTransformation$1 extends FunctionReferenceImpl implements S7.a {
    public SecureTextFieldController$passwordInputTransformation$1(Object obj) {
        super(0, obj, SecureTextFieldController.class, "scheduleHide", "scheduleHide()V", 0);
    }

    @Override // S7.a
    public /* bridge */ /* synthetic */ Object invoke() {
        m1084invoke();
        return r.f317a;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m1084invoke() {
        ((SecureTextFieldController) this.receiver).scheduleHide();
    }
}
