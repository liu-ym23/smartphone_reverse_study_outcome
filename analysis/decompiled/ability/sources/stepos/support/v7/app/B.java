package stepos.support.v7.app;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.collection.ArrayMap;
import java.lang.reflect.Constructor;

/* loaded from: classes4.dex */
public final class B {
    public static final Class[] b = {Context.class, AttributeSet.class};
    public static final int[] c = {R.attr.onClick};
    public static final String[] d = {"android.widget.", "android.view.", "android.webkit."};
    public static final ArrayMap e = new ArrayMap();

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f6213a = new Object[2];

    /* JADX WARN: Multi-variable type inference failed */
    public final View a(Context context, String str, String str2) throws NoSuchMethodException, SecurityException {
        ArrayMap arrayMap = e;
        Constructor constructor = (Constructor) arrayMap.get(str);
        if (constructor == null) {
            try {
                constructor = context.getClassLoader().loadClass(str2 != null ? str2.concat(str) : str).asSubclass(View.class).getConstructor(b);
                arrayMap.put(str, constructor);
            } catch (Exception unused) {
                return null;
            }
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.f6213a);
    }
}
