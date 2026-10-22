package androidx.compose.foundation.text;

import androidx.compose.foundation.text.input.internal.CodepointTransformation;
import androidx.compose.runtime.State;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements CodepointTransformation {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1735a;
    public final /* synthetic */ Object b;

    public /* synthetic */ a(Object obj, int i) {
        this.f1735a = i;
        this.b = obj;
    }

    @Override // androidx.compose.foundation.text.input.internal.CodepointTransformation
    public final int transform(int i, int i6) {
        int i10 = this.f1735a;
        Object obj = this.b;
        switch (i10) {
            case 0:
                return BasicSecureTextFieldKt.BasicSecureTextField_Jb9bMDk$lambda$4$lambda$3((State) obj, i, i6);
            default:
                return SecureTextFieldController.codepointTransformation$lambda$0((SecureTextFieldController) obj, i, i6);
        }
    }
}
