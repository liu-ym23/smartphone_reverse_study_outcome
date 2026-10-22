package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.C0200f0;
import androidx.appcompat.widget.C0226t;
import androidx.appcompat.widget.C0230v;
import androidx.appcompat.widget.C0232w;
import java.lang.reflect.Constructor;

/* loaded from: classes.dex */
public class I {

    /* renamed from: b, reason: collision with root package name */
    public static final Class[] f2539b = {Context.class, AttributeSet.class};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f2540c = {R.attr.onClick};

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f2541d = {"android.widget.", "android.view.", "android.webkit."};

    /* renamed from: e, reason: collision with root package name */
    public static final q.l f2542e = new q.l(0);

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f2543a = new Object[2];

    public C0226t a(Context context, AttributeSet attributeSet) {
        return new C0226t(context, attributeSet);
    }

    public C0230v b(Context context, AttributeSet attributeSet) {
        return new C0230v(context, attributeSet, com.stepos.alphame.R.attr.buttonStyle);
    }

    public C0232w c(Context context, AttributeSet attributeSet) {
        return new C0232w(context, attributeSet, com.stepos.alphame.R.attr.checkboxStyle);
    }

    public androidx.appcompat.widget.K d(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.K(context, attributeSet);
    }

    public C0200f0 e(Context context, AttributeSet attributeSet) {
        return new C0200f0(context, attributeSet);
    }

    public final View f(Context context, String str, String str2) throws NoSuchMethodException, SecurityException {
        String strConcat;
        q.l lVar = f2542e;
        Constructor constructor = (Constructor) lVar.get(str);
        if (constructor == null) {
            if (str2 != null) {
                try {
                    strConcat = str2.concat(str);
                } catch (Exception unused) {
                    return null;
                }
            } else {
                strConcat = str;
            }
            constructor = Class.forName(strConcat, false, context.getClassLoader()).asSubclass(View.class).getConstructor(f2539b);
            lVar.put(str, constructor);
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.f2543a);
    }
}
