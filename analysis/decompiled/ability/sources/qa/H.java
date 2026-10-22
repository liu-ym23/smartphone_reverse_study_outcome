package qa;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/* loaded from: classes4.dex */
public final class H extends C1849a {
    public final /* synthetic */ int h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ H(int i) {
        super(7);
        this.h = i;
    }

    @Override // qa.C1849a
    public String c(Method method, int i) {
        switch (this.h) {
            case 1:
                Parameter parameter = method.getParameters()[i];
                if (!parameter.isNamePresent()) {
                    break;
                } else {
                    break;
                }
        }
        return super.c(method, i);
    }

    @Override // qa.C1849a
    public final Object d(Method method, Class cls, Object obj, Object[] objArr) {
        switch (this.h) {
        }
        return U.i(method, cls, obj, objArr);
    }

    @Override // qa.C1849a
    public final boolean e(Method method) {
        switch (this.h) {
        }
        return method.isDefault();
    }
}
