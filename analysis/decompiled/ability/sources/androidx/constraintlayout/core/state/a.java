package androidx.constraintlayout.core.state;

import android.util.Log;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import kotlin.jvm.internal.k;

/* loaded from: classes2.dex */
public final /* synthetic */ class a implements Interpolator, ObjectConstructor, T9.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1910a;
    public final /* synthetic */ String b;

    public /* synthetic */ a(String str, int i) {
        this.f1910a = i;
        this.b = str;
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public Object construct() {
        int i = this.f1910a;
        String str = this.b;
        switch (i) {
            case 1:
                return ConstructorConstructor.lambda$newUnsafeAllocator$20(str);
            case 2:
                return ConstructorConstructor.lambda$newDefaultConstructor$7(str);
            case 3:
                return ConstructorConstructor.lambda$newDefaultConstructor$8(str);
            case 4:
                return ConstructorConstructor.lambda$get$2(str);
            case 5:
                return ConstructorConstructor.lambda$get$3(str);
            default:
                return ConstructorConstructor.lambda$get$4(str);
        }
    }

    @Override // androidx.constraintlayout.core.state.Interpolator
    public float getInterpolation(float f) {
        return Transition.lambda$getInterpolator$0(this.b, f);
    }

    @Override // T9.a
    public void log(String message) {
        k.f(message, "message");
        Log.d(this.b, message);
    }
}
