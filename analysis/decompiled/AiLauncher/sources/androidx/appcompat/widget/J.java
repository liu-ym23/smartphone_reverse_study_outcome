package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import androidx.appcompat.resources.R$drawable;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import u0.C5566a;

/* loaded from: classes.dex */
public final class J {

    /* renamed from: i, reason: collision with root package name */
    public static J f8952i;

    /* renamed from: a, reason: collision with root package name */
    public WeakHashMap<Context, androidx.collection.u<ColorStateList>> f8954a;

    /* renamed from: b, reason: collision with root package name */
    public androidx.collection.t<String, b> f8955b;

    /* renamed from: c, reason: collision with root package name */
    public androidx.collection.u<String> f8956c;

    /* renamed from: d, reason: collision with root package name */
    public final WeakHashMap<Context, androidx.collection.j<WeakReference<Drawable.ConstantState>>> f8957d = new WeakHashMap<>(0);

    /* renamed from: e, reason: collision with root package name */
    public TypedValue f8958e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f8959f;

    /* renamed from: g, reason: collision with root package name */
    public c f8960g;

    /* renamed from: h, reason: collision with root package name */
    public static final PorterDuff.Mode f8951h = PorterDuff.Mode.SRC_IN;

    /* renamed from: j, reason: collision with root package name */
    public static final a f8953j = new a(6);

    public static class a extends androidx.collection.l<Integer, PorterDuffColorFilter> {
        public a(int i10) {
            super(i10);
        }

        public static int a(int i10, PorterDuff.Mode mode) {
            return ((i10 + 31) * 31) + mode.hashCode();
        }

        public PorterDuffColorFilter b(int i10, PorterDuff.Mode mode) {
            return get(Integer.valueOf(a(i10, mode)));
        }

        public PorterDuffColorFilter c(int i10, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return put(Integer.valueOf(a(i10, mode)), porterDuffColorFilter);
        }
    }

    public interface b {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    public interface c {
        Drawable a(J j10, Context context, int i10);

        ColorStateList b(Context context, int i10);

        boolean c(Context context, int i10, Drawable drawable);

        PorterDuff.Mode d(int i10);

        boolean e(Context context, int i10, Drawable drawable);
    }

    public static long d(TypedValue typedValue) {
        return (typedValue.assetCookie << 32) | typedValue.data;
    }

    public static PorterDuffColorFilter f(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return k(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static synchronized J g() {
        try {
            if (f8952i == null) {
                J j10 = new J();
                f8952i = j10;
                o(j10);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f8952i;
    }

    public static synchronized PorterDuffColorFilter k(int i10, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilterB;
        a aVar = f8953j;
        porterDuffColorFilterB = aVar.b(i10, mode);
        if (porterDuffColorFilterB == null) {
            porterDuffColorFilterB = new PorterDuffColorFilter(i10, mode);
            aVar.c(i10, mode, porterDuffColorFilterB);
        }
        return porterDuffColorFilterB;
    }

    public static void o(J j10) {
    }

    public static boolean p(Drawable drawable) {
        return (drawable instanceof q1.f) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    public static void v(Drawable drawable, S s10, int[] iArr) {
        int[] state = drawable.getState();
        if (drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
            drawable.setState(new int[0]);
            drawable.setState(state);
        }
        boolean z10 = s10.f9026d;
        if (z10 || s10.f9025c) {
            drawable.setColorFilter(f(z10 ? s10.f9023a : null, s10.f9025c ? s10.f9024b : f8951h, iArr));
        } else {
            drawable.clearColorFilter();
        }
    }

    public final synchronized boolean a(Context context, long j10, Drawable drawable) {
        try {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState == null) {
                return false;
            }
            androidx.collection.j<WeakReference<Drawable.ConstantState>> jVar = this.f8957d.get(context);
            if (jVar == null) {
                jVar = new androidx.collection.j<>();
                this.f8957d.put(context, jVar);
            }
            jVar.n(j10, new WeakReference<>(constantState));
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void b(Context context, int i10, ColorStateList colorStateList) {
        if (this.f8954a == null) {
            this.f8954a = new WeakHashMap<>();
        }
        androidx.collection.u<ColorStateList> uVar = this.f8954a.get(context);
        if (uVar == null) {
            uVar = new androidx.collection.u<>();
            this.f8954a.put(context, uVar);
        }
        uVar.a(i10, colorStateList);
    }

    public final void c(Context context) {
        if (this.f8959f) {
            return;
        }
        this.f8959f = true;
        Drawable drawableI = i(context, R$drawable.abc_vector_test);
        if (drawableI == null || !p(drawableI)) {
            this.f8959f = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
    }

    public final Drawable e(Context context, int i10) throws Resources.NotFoundException {
        if (this.f8958e == null) {
            this.f8958e = new TypedValue();
        }
        TypedValue typedValue = this.f8958e;
        context.getResources().getValue(i10, typedValue, true);
        long jD = d(typedValue);
        Drawable drawableH = h(context, jD);
        if (drawableH != null) {
            return drawableH;
        }
        c cVar = this.f8960g;
        Drawable drawableA = cVar == null ? null : cVar.a(this, context, i10);
        if (drawableA != null) {
            drawableA.setChangingConfigurations(typedValue.changingConfigurations);
            a(context, jD, drawableA);
        }
        return drawableA;
    }

    public final synchronized Drawable h(Context context, long j10) {
        androidx.collection.j<WeakReference<Drawable.ConstantState>> jVar = this.f8957d.get(context);
        if (jVar == null) {
            return null;
        }
        WeakReference<Drawable.ConstantState> weakReferenceH = jVar.h(j10);
        if (weakReferenceH != null) {
            Drawable.ConstantState constantState = weakReferenceH.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            jVar.o(j10);
        }
        return null;
    }

    public synchronized Drawable i(Context context, int i10) {
        return j(context, i10, false);
    }

    public synchronized Drawable j(Context context, int i10, boolean z10) {
        Drawable drawableQ;
        try {
            c(context);
            drawableQ = q(context, i10);
            if (drawableQ == null) {
                drawableQ = e(context, i10);
            }
            if (drawableQ == null) {
                drawableQ = androidx.core.content.a.e(context, i10);
            }
            if (drawableQ != null) {
                drawableQ = u(context, i10, z10, drawableQ);
            }
            if (drawableQ != null) {
                B.b(drawableQ);
            }
        } catch (Throwable th) {
            throw th;
        }
        return drawableQ;
    }

    public synchronized ColorStateList l(Context context, int i10) {
        ColorStateList colorStateListM;
        colorStateListM = m(context, i10);
        if (colorStateListM == null) {
            c cVar = this.f8960g;
            colorStateListM = cVar == null ? null : cVar.b(context, i10);
            if (colorStateListM != null) {
                b(context, i10, colorStateListM);
            }
        }
        return colorStateListM;
    }

    public final ColorStateList m(Context context, int i10) {
        androidx.collection.u<ColorStateList> uVar;
        WeakHashMap<Context, androidx.collection.u<ColorStateList>> weakHashMap = this.f8954a;
        if (weakHashMap == null || (uVar = weakHashMap.get(context)) == null) {
            return null;
        }
        return uVar.g(i10);
    }

    public PorterDuff.Mode n(int i10) {
        c cVar = this.f8960g;
        if (cVar == null) {
            return null;
        }
        return cVar.d(i10);
    }

    public final Drawable q(Context context, int i10) throws XmlPullParserException, Resources.NotFoundException, IOException {
        int next;
        androidx.collection.t<String, b> tVar = this.f8955b;
        if (tVar == null || tVar.isEmpty()) {
            return null;
        }
        androidx.collection.u<String> uVar = this.f8956c;
        if (uVar != null) {
            String strG = uVar.g(i10);
            if ("appcompat_skip_skip".equals(strG) || (strG != null && this.f8955b.get(strG) == null)) {
                return null;
            }
        } else {
            this.f8956c = new androidx.collection.u<>();
        }
        if (this.f8958e == null) {
            this.f8958e = new TypedValue();
        }
        TypedValue typedValue = this.f8958e;
        Resources resources = context.getResources();
        resources.getValue(i10, typedValue, true);
        long jD = d(typedValue);
        Drawable drawableH = h(context, jD);
        if (drawableH != null) {
            return drawableH;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i10);
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                String name = xml.getName();
                this.f8956c.a(i10, name);
                b bVar = this.f8955b.get(name);
                if (bVar != null) {
                    drawableH = bVar.a(context, xml, attributeSetAsAttributeSet, context.getTheme());
                }
                if (drawableH != null) {
                    drawableH.setChangingConfigurations(typedValue.changingConfigurations);
                    a(context, jD, drawableH);
                }
            } catch (Exception e10) {
                Log.e("ResourceManagerInternal", "Exception while inflating drawable", e10);
            }
        }
        if (drawableH == null) {
            this.f8956c.a(i10, "appcompat_skip_skip");
        }
        return drawableH;
    }

    public synchronized void r(Context context) {
        androidx.collection.j<WeakReference<Drawable.ConstantState>> jVar = this.f8957d.get(context);
        if (jVar != null) {
            jVar.a();
        }
    }

    public synchronized Drawable s(Context context, a0 a0Var, int i10) {
        try {
            Drawable drawableQ = q(context, i10);
            if (drawableQ == null) {
                drawableQ = a0Var.a(i10);
            }
            if (drawableQ == null) {
                return null;
            }
            return u(context, i10, false, drawableQ);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void t(c cVar) {
        this.f8960g = cVar;
    }

    public final Drawable u(Context context, int i10, boolean z10, Drawable drawable) {
        ColorStateList colorStateListL = l(context, i10);
        if (colorStateListL != null) {
            Drawable drawableR = C5566a.r(drawable.mutate());
            C5566a.o(drawableR, colorStateListL);
            PorterDuff.Mode modeN = n(i10);
            if (modeN != null) {
                C5566a.p(drawableR, modeN);
            }
            return drawableR;
        }
        c cVar = this.f8960g;
        if ((cVar == null || !cVar.e(context, i10, drawable)) && !w(context, i10, drawable) && z10) {
            return null;
        }
        return drawable;
    }

    public boolean w(Context context, int i10, Drawable drawable) {
        c cVar = this.f8960g;
        return cVar != null && cVar.c(context, i10, drawable);
    }
}
