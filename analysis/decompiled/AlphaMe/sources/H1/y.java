package H1;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.security.PrivilegedAction;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class y implements PrivilegedAction {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Class f773a;

    public y(Class cls) {
        this.f773a = cls;
    }

    @Override // java.security.PrivilegedAction
    public final Object run() throws SecurityException {
        Field[] declaredFields = this.f773a.getDeclaredFields();
        ArrayList arrayList = new ArrayList(declaredFields.length);
        for (Field field : declaredFields) {
            if (field.isEnumConstant()) {
                arrayList.add(field);
            }
        }
        Field[] fieldArr = (Field[]) arrayList.toArray(new Field[0]);
        AccessibleObject.setAccessible(fieldArr, true);
        return fieldArr;
    }
}
