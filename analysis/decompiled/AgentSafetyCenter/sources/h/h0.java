package h;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import java.lang.reflect.Constructor;
import m.v0;
import p.p0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class h0 {

    /* renamed from: b, reason: collision with root package name */
    public static final Class[] f4836b = {Context.class, AttributeSet.class};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f4837c = {R.attr.onClick};

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f4838d = {"android.widget.", "android.view.", "android.webkit."};

    /* renamed from: e, reason: collision with root package name */
    public static final p0 f4839e = new p0(0);

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f4840a = new Object[2];

    public m.o a(Context context, AttributeSet attributeSet) {
        return new m.o(context, attributeSet, com.stepos.agentsafetycenter.R.attr.autoCompleteTextViewStyle);
    }

    public m.p b(Context context, AttributeSet attributeSet) {
        return new m.p(context, attributeSet, com.stepos.agentsafetycenter.R.attr.buttonStyle);
    }

    public m.q c(Context context, AttributeSet attributeSet) {
        return new m.q(context, attributeSet);
    }

    public m.b0 d(Context context, AttributeSet attributeSet) {
        return new m.b0(context, attributeSet);
    }

    public v0 e(Context context, AttributeSet attributeSet) {
        return new v0(context, attributeSet);
    }

    public final View f(Context context, String str, String str2) throws NoSuchMethodException, SecurityException {
        String strConcat;
        p0 p0Var = f4839e;
        Constructor constructor = (Constructor) p0Var.get(str);
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
            constructor = Class.forName(strConcat, false, context.getClassLoader()).asSubclass(View.class).getConstructor(f4836b);
            p0Var.put(str, constructor);
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.f4840a);
    }
}
