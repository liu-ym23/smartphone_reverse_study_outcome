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
import j.C0775a;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class P {

    /* renamed from: i, reason: collision with root package name */
    private static P f8234i;

    /* renamed from: a, reason: collision with root package name */
    private WeakHashMap<Context, q.j<ColorStateList>> f8236a;

    /* renamed from: b, reason: collision with root package name */
    private q.i<String, b> f8237b;

    /* renamed from: c, reason: collision with root package name */
    private q.j<String> f8238c;

    /* renamed from: d, reason: collision with root package name */
    private final WeakHashMap<Context, q.f<WeakReference<Drawable.ConstantState>>> f8239d = new WeakHashMap<>(0);

    /* renamed from: e, reason: collision with root package name */
    private TypedValue f8240e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f8241f;

    /* renamed from: g, reason: collision with root package name */
    private c f8242g;

    /* renamed from: h, reason: collision with root package name */
    private static final PorterDuff.Mode f8233h = PorterDuff.Mode.SRC_IN;

    /* renamed from: j, reason: collision with root package name */
    private static final a f8235j = new a(6);

    private static class a extends q.h<Integer, PorterDuffColorFilter> {
        public a(int i5) {
            super(i5);
        }

        private static int h(int i5, PorterDuff.Mode mode) {
            return ((i5 + 31) * 31) + mode.hashCode();
        }

        PorterDuffColorFilter i(int i5, PorterDuff.Mode mode) {
            return c(Integer.valueOf(h(i5, mode)));
        }

        PorterDuffColorFilter j(int i5, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return d(Integer.valueOf(h(i5, mode)), porterDuffColorFilter);
        }
    }

    private interface b {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    public interface c {
        boolean a(Context context, int i5, Drawable drawable);

        PorterDuff.Mode b(int i5);

        Drawable c(P p5, Context context, int i5);

        ColorStateList d(Context context, int i5);

        boolean e(Context context, int i5, Drawable drawable);
    }

    private synchronized boolean a(Context context, long j5, Drawable drawable) {
        try {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState == null) {
                return false;
            }
            q.f<WeakReference<Drawable.ConstantState>> fVar = this.f8239d.get(context);
            if (fVar == null) {
                fVar = new q.f<>();
                this.f8239d.put(context, fVar);
            }
            fVar.j(j5, new WeakReference<>(constantState));
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    private void b(Context context, int i5, ColorStateList colorStateList) {
        if (this.f8236a == null) {
            this.f8236a = new WeakHashMap<>();
        }
        q.j<ColorStateList> jVar = this.f8236a.get(context);
        if (jVar == null) {
            jVar = new q.j<>();
            this.f8236a.put(context, jVar);
        }
        jVar.b(i5, colorStateList);
    }

    private void c(Context context) {
        if (this.f8241f) {
            return;
        }
        this.f8241f = true;
        Drawable drawableI = i(context, C0775a.f17622a);
        if (drawableI == null || !p(drawableI)) {
            this.f8241f = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
    }

    private static long d(TypedValue typedValue) {
        return (typedValue.assetCookie << 32) | typedValue.data;
    }

    private Drawable e(Context context, int i5) throws Resources.NotFoundException {
        if (this.f8240e == null) {
            this.f8240e = new TypedValue();
        }
        TypedValue typedValue = this.f8240e;
        context.getResources().getValue(i5, typedValue, true);
        long jD = d(typedValue);
        Drawable drawableH = h(context, jD);
        if (drawableH != null) {
            return drawableH;
        }
        c cVar = this.f8242g;
        Drawable drawableC = cVar == null ? null : cVar.c(this, context, i5);
        if (drawableC != null) {
            drawableC.setChangingConfigurations(typedValue.changingConfigurations);
            a(context, jD, drawableC);
        }
        return drawableC;
    }

    private static PorterDuffColorFilter f(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return k(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static synchronized P g() {
        try {
            if (f8234i == null) {
                P p5 = new P();
                f8234i = p5;
                o(p5);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f8234i;
    }

    private synchronized Drawable h(Context context, long j5) {
        q.f<WeakReference<Drawable.ConstantState>> fVar = this.f8239d.get(context);
        if (fVar == null) {
            return null;
        }
        WeakReference<Drawable.ConstantState> weakReferenceG = fVar.g(j5);
        if (weakReferenceG != null) {
            Drawable.ConstantState constantState = weakReferenceG.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            fVar.k(j5);
        }
        return null;
    }

    public static synchronized PorterDuffColorFilter k(int i5, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilterI;
        a aVar = f8235j;
        porterDuffColorFilterI = aVar.i(i5, mode);
        if (porterDuffColorFilterI == null) {
            porterDuffColorFilterI = new PorterDuffColorFilter(i5, mode);
            aVar.j(i5, mode, porterDuffColorFilterI);
        }
        return porterDuffColorFilterI;
    }

    private ColorStateList m(Context context, int i5) {
        q.j<ColorStateList> jVar;
        WeakHashMap<Context, q.j<ColorStateList>> weakHashMap = this.f8236a;
        if (weakHashMap == null || (jVar = weakHashMap.get(context)) == null) {
            return null;
        }
        return jVar.g(i5);
    }

    private static void o(P p5) {
    }

    private static boolean p(Drawable drawable) {
        return (drawable instanceof androidx.vectordrawable.graphics.drawable.f) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    private Drawable q(Context context, int i5) throws XmlPullParserException, Resources.NotFoundException, IOException {
        int next;
        q.i<String, b> iVar = this.f8237b;
        if (iVar == null || iVar.isEmpty()) {
            return null;
        }
        q.j<String> jVar = this.f8238c;
        if (jVar != null) {
            String strG = jVar.g(i5);
            if ("appcompat_skip_skip".equals(strG) || (strG != null && this.f8237b.get(strG) == null)) {
                return null;
            }
        } else {
            this.f8238c = new q.j<>();
        }
        if (this.f8240e == null) {
            this.f8240e = new TypedValue();
        }
        TypedValue typedValue = this.f8240e;
        Resources resources = context.getResources();
        resources.getValue(i5, typedValue, true);
        long jD = d(typedValue);
        Drawable drawableH = h(context, jD);
        if (drawableH != null) {
            return drawableH;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i5);
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
                this.f8238c.b(i5, name);
                b bVar = this.f8237b.get(name);
                if (bVar != null) {
                    drawableH = bVar.a(context, xml, attributeSetAsAttributeSet, context.getTheme());
                }
                if (drawableH != null) {
                    drawableH.setChangingConfigurations(typedValue.changingConfigurations);
                    a(context, jD, drawableH);
                }
            } catch (Exception e6) {
                Log.e("ResourceManagerInternal", "Exception while inflating drawable", e6);
            }
        }
        if (drawableH == null) {
            this.f8238c.b(i5, "appcompat_skip_skip");
        }
        return drawableH;
    }

    private Drawable u(Context context, int i5, boolean z5, Drawable drawable) {
        ColorStateList colorStateListL = l(context, i5);
        if (colorStateListL != null) {
            Drawable drawableR = androidx.core.graphics.drawable.a.r(drawable.mutate());
            androidx.core.graphics.drawable.a.o(drawableR, colorStateListL);
            PorterDuff.Mode modeN = n(i5);
            if (modeN != null) {
                androidx.core.graphics.drawable.a.p(drawableR, modeN);
            }
            return drawableR;
        }
        c cVar = this.f8242g;
        if ((cVar == null || !cVar.e(context, i5, drawable)) && !w(context, i5, drawable) && z5) {
            return null;
        }
        return drawable;
    }

    static void v(Drawable drawable, Y y5, int[] iArr) {
        int[] state = drawable.getState();
        if (drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
            drawable.setState(new int[0]);
            drawable.setState(state);
        }
        boolean z5 = y5.f8465d;
        if (z5 || y5.f8464c) {
            drawable.setColorFilter(f(z5 ? y5.f8462a : null, y5.f8464c ? y5.f8463b : f8233h, iArr));
        } else {
            drawable.clearColorFilter();
        }
    }

    public synchronized Drawable i(Context context, int i5) {
        return j(context, i5, false);
    }

    synchronized Drawable j(Context context, int i5, boolean z5) {
        Drawable drawableQ;
        try {
            c(context);
            drawableQ = q(context, i5);
            if (drawableQ == null) {
                drawableQ = e(context, i5);
            }
            if (drawableQ == null) {
                drawableQ = androidx.core.content.a.e(context, i5);
            }
            if (drawableQ != null) {
                drawableQ = u(context, i5, z5, drawableQ);
            }
            if (drawableQ != null) {
                I.b(drawableQ);
            }
        } catch (Throwable th) {
            throw th;
        }
        return drawableQ;
    }

    synchronized ColorStateList l(Context context, int i5) {
        ColorStateList colorStateListM;
        colorStateListM = m(context, i5);
        if (colorStateListM == null) {
            c cVar = this.f8242g;
            colorStateListM = cVar == null ? null : cVar.d(context, i5);
            if (colorStateListM != null) {
                b(context, i5, colorStateListM);
            }
        }
        return colorStateListM;
    }

    PorterDuff.Mode n(int i5) {
        c cVar = this.f8242g;
        if (cVar == null) {
            return null;
        }
        return cVar.b(i5);
    }

    public synchronized void r(Context context) {
        q.f<WeakReference<Drawable.ConstantState>> fVar = this.f8239d.get(context);
        if (fVar != null) {
            fVar.b();
        }
    }

    synchronized Drawable s(Context context, g0 g0Var, int i5) {
        try {
            Drawable drawableQ = q(context, i5);
            if (drawableQ == null) {
                drawableQ = g0Var.a(i5);
            }
            if (drawableQ == null) {
                return null;
            }
            return u(context, i5, false, drawableQ);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void t(c cVar) {
        this.f8242g = cVar;
    }

    boolean w(Context context, int i5, Drawable drawable) {
        c cVar = this.f8242g;
        return cVar != null && cVar.a(context, i5, drawable);
    }
}
