package id;

import ad.o;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.text.LineBreakConfig;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.AnimationUtils;
import android.view.animation.PathInterpolator;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.fragment.app.s;
import androidx.recyclerview.widget.RecyclerView;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import com.fasterxml.jackson.core.JsonFactory;
import com.google.crypto.tink.shaded.protobuf.Reader;
import com.stepos.agentsafetycenter.R;
import g5.u;
import g9.z0;
import h5.d0;
import h5.r;
import java.lang.invoke.VarHandle;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Matcher;
import k0.c1;
import k0.e0;
import k0.j0;
import k0.z;
import kb.q;
import l0.k0;
import m.d2;
import n3.m0;
import v1.g2;
import v1.s1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public static i1.f f5963a;

    /* renamed from: b, reason: collision with root package name */
    public static ArrayList f5964b;

    public static final s3.a D(View view) {
        s3.a aVar = (s3.a) view.getTag(R.id.pooling_container_listener_holder_tag);
        if (aVar != null) {
            return aVar;
        }
        s3.a aVar2 = new s3.a();
        aVar2.f11367a = new ArrayList();
        VarHandle.storeStoreFence();
        view.setTag(R.id.pooling_container_listener_holder_tag, aVar2);
        return aVar2;
    }

    public static boolean G(String str, String str2) {
        return str.startsWith(str2.concat("(")) && str.endsWith(")");
    }

    public static z0 L(String str) {
        String lowerCase;
        String string;
        if (str == null || (string = hc.h.w0(str).toString()) == null) {
            lowerCase = null;
        } else {
            lowerCase = string.toLowerCase(Locale.ROOT);
            lowerCase.getClass();
        }
        if (lowerCase != null) {
            int iHashCode = lowerCase.hashCode();
            if (iHashCode != -747485124) {
                if (iHashCode != -489747819) {
                    if (iHashCode == 92906313 && lowerCase.equals("allow")) {
                        return z0.f4660c;
                    }
                } else if (lowerCase.equals("ask_always")) {
                    return z0.f4662g;
                }
            } else if (lowerCase.equals("ask_on_sensitive")) {
                return z0.f4661f;
            }
        }
        return null;
    }

    public static void M(String str, int i, char... cArr) {
        throw new DateTimeParseException(String.format("Expected character %s at position %d, found %s: %s", Arrays.toString(cArr), Integer.valueOf(i + 1), Character.valueOf(str.charAt(i)), str), str, i);
    }

    public static final b.m N(s sVar, xb.l lVar, k0.s sVar2) {
        sVar2.Y(-1408504823);
        z.z(sVar, sVar2);
        c1 c1VarZ = z.z(lVar, sVar2);
        String str = (String) t0.a.j(new Object[0], null, b.e.f1692f, sVar2, 3080, 6);
        e0 e0Var = b.k.f1707a;
        sVar2.Y(1418020823);
        d.i iVar = (d.i) sVar2.j(b.k.f1707a);
        if (iVar == null) {
            Object baseContext = (Context) sVar2.j(AndroidCompositionLocals_androidKt.f982b);
            while (true) {
                if (!(baseContext instanceof ContextWrapper)) {
                    baseContext = null;
                    break;
                }
                if (baseContext instanceof d.i) {
                    break;
                }
                baseContext = ((ContextWrapper) baseContext).getBaseContext();
            }
            iVar = (d.i) baseContext;
        }
        sVar2.q(false);
        if (iVar == null) {
            od.f.e("No ActivityResultRegistryOwner was provided via LocalActivityResultRegistryOwner");
            return null;
        }
        d.h activityResultRegistry = iVar.getActivityResultRegistry();
        sVar2.Y(-3687241);
        Object objM = sVar2.M();
        Object obj = k0.m.f6974a;
        if (objM == obj) {
            objM = new b.a();
            sVar2.i0(objM);
        }
        sVar2.q(false);
        b.a aVar = (b.a) objM;
        sVar2.Y(-3687241);
        Object objM2 = sVar2.M();
        Object obj2 = objM2;
        if (objM2 == obj) {
            b.m mVar = new b.m();
            mVar.f1709a = aVar;
            VarHandle.storeStoreFence();
            sVar2.i0(mVar);
            obj2 = mVar;
        }
        sVar2.q(false);
        b.m mVar2 = (b.m) obj2;
        b.d dVar = new b.d(aVar, activityResultRegistry, str, sVar, c1VarZ);
        boolean zF = sVar2.f(activityResultRegistry) | sVar2.f(str) | sVar2.f(sVar);
        Object objM3 = sVar2.M();
        if (zF || objM3 == obj) {
            objM3 = new j0(dVar);
            sVar2.i0(objM3);
        }
        sVar2.q(false);
        return mVar2;
    }

    public static int O(Context context, int i, int i3) {
        TypedValue typedValueE = p5.f.E(i, context);
        return (typedValueE == null || typedValueE.type != 16) ? i3 : typedValueE.data;
    }

    public static TimeInterpolator P(Context context, int i, TimeInterpolator timeInterpolator) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i, typedValue, true)) {
            return timeInterpolator;
        }
        if (typedValue.type != 3) {
            g5.f.s("Motion easing theme attribute must be an @interpolator resource for ?attr/motionEasing*Interpolator attributes or a string for ?attr/motionEasing* attributes.");
            return null;
        }
        String strValueOf = String.valueOf(typedValue.string);
        if (!G(strValueOf, "cubic-bezier") && !G(strValueOf, "path")) {
            return AnimationUtils.loadInterpolator(context, typedValue.resourceId);
        }
        if (G(strValueOf, "cubic-bezier")) {
            String[] strArrSplit = strValueOf.substring(13, strValueOf.length() - 1).split(",");
            if (strArrSplit.length == 4) {
                return new PathInterpolator(y(0, strArrSplit), y(1, strArrSplit), y(2, strArrSplit), y(3, strArrSplit));
            }
            o.j(strArrSplit.length, "Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: ");
            return null;
        }
        if (!G(strValueOf, "path")) {
            g5.f.s("Invalid motion easing type: ".concat(strValueOf));
            return null;
        }
        String strSubstring = strValueOf.substring(5, strValueOf.length() - 1);
        Path path = new Path();
        try {
            f3.c.b(ac.a.p(strSubstring), path);
            return new PathInterpolator(path);
        } catch (RuntimeException e10) {
            od.f.g("Error in parsing ".concat(strSubstring), e10);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [kb.s] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.util.ArrayList] */
    public static List Q(Context context) {
        Object objL;
        int i;
        ServiceInfo serviceInfo;
        String str;
        Object objL2;
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService(AccessibilityManager.class);
        ?? arrayList = kb.s.f7404c;
        if (accessibilityManager != null) {
            try {
                objL = accessibilityManager.getEnabledAccessibilityServiceList(-1);
            } catch (Throwable th) {
                objL = c.l(th);
            }
            Throwable thB = jb.i.b(objL);
            if (thB != null) {
                Log.w("RiskyA11yInspector", "getEnabledAccessibilityServiceList failed", thB);
            }
            Object obj = arrayList;
            if (!(objL instanceof jb.h)) {
                obj = objL;
            }
            List list = (List) obj;
            list.getClass();
            ArrayList arrayList2 = new ArrayList();
            Iterator it = list.iterator();
            while (true) {
                i = 0;
                if (!it.hasNext()) {
                    break;
                }
                AccessibilityServiceInfo accessibilityServiceInfo = (AccessibilityServiceInfo) it.next();
                ResolveInfo resolveInfo = accessibilityServiceInfo.getResolveInfo();
                o8.j jVar = null;
                if (resolveInfo != null && (serviceInfo = resolveInfo.serviceInfo) != null && (str = serviceInfo.packageName) != null) {
                    ApplicationInfo applicationInfo = serviceInfo.applicationInfo;
                    int i3 = applicationInfo != null ? applicationInfo.flags : 0;
                    boolean z10 = ((i3 & 1) == 0 && (i3 & 128) == 0) ? false : true;
                    try {
                        objL2 = accessibilityServiceInfo.getResolveInfo().loadLabel(context.getPackageManager()).toString();
                    } catch (Throwable th2) {
                        objL2 = c.l(th2);
                    }
                    boolean z11 = objL2 instanceof jb.h;
                    Object obj2 = objL2;
                    if (z11) {
                        obj2 = "";
                    }
                    String str2 = (CharSequence) obj2;
                    if (hc.h.g0(str2)) {
                        str2 = str;
                    }
                    jVar = new o8.j();
                    jVar.f9315a = str;
                    jVar.f9316b = str2;
                    jVar.f9317c = z10;
                    VarHandle.storeStoreFence();
                }
                if (jVar != null) {
                    arrayList2.add(jVar);
                }
            }
            Set set = o8.l.f9320a;
            String packageName = context.getPackageName();
            packageName.getClass();
            arrayList = new ArrayList();
            int size = arrayList2.size();
            while (i < size) {
                Object obj3 = arrayList2.get(i);
                i++;
                o8.j jVar2 = (o8.j) obj3;
                if (!jVar2.f9315a.equals(packageName) && !jVar2.f9317c && !o8.l.f9320a.contains(jVar2.f9315a)) {
                    arrayList.add(obj3);
                }
            }
        }
        ArrayList arrayList3 = new ArrayList(kb.m.m0(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList3.add(((o8.j) it2.next()).f9316b);
        }
        return kb.l.L0(kb.l.N0(arrayList3));
    }

    public static final void R(k0 k0Var, int i, Object obj) {
        k0Var.f7692g[(k0Var.f7693h - k0Var.f7688c[k0Var.f7689d - 1].f7685b) + i] = obj;
    }

    public static final void S(k0 k0Var, int i, Object obj, int i3, Object obj2) {
        int i10 = k0Var.f7693h - k0Var.f7688c[k0Var.f7689d - 1].f7685b;
        Object[] objArr = k0Var.f7692g;
        objArr[i + i10] = obj;
        objArr[i10 + i3] = obj2;
    }

    public static final double U(long j10) {
        return ((j10 >>> 11) * RecyclerView.ItemAnimator.FLAG_MOVED) + (j10 & 2047);
    }

    public static final f6.a a(int i) {
        f6.a aVar = new f6.a();
        aVar.f3916c = i;
        if (i > 0) {
            VarHandle.storeStoreFence();
            return aVar;
        }
        g5.f.s("px must be > 0.");
        return null;
    }

    public static final long b(int i) {
        long j10 = (i << 32) | (0 & 4294967295L);
        int i3 = m1.a.f8185p;
        return j10;
    }

    public static final d6.e c(Context context, i6.f fVar) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(ConnectivityManager.class);
        int i = 22;
        if (connectivityManager == null || d3.a.a(context, "android.permission.ACCESS_NETWORK_STATE") != 0) {
            return new f7.f(i);
        }
        try {
            p5.m mVar = new p5.m(7);
            mVar.f9741f = connectivityManager;
            mVar.f9742g = fVar;
            d6.f fVar2 = new d6.f(mVar, 0);
            mVar.f9743h = fVar2;
            connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().addCapability(12).build(), fVar2);
            VarHandle.storeStoreFence();
            return mVar;
        } catch (Exception unused) {
            return new f7.f(i);
        }
    }

    public static final long d(float f5, float f10) {
        return (Float.floatToRawIntBits(f10) & 4294967295L) | (Float.floatToRawIntBits(f5) << 32);
    }

    public static void e(char c9, int i, int i3, String str) {
        if (i3 >= str.length()) {
            throw new DateTimeParseException(androidx.activity.b.j("Unexpected end of input, missing field ", k0.a.D(i), ": ", str), str, i3);
        }
        if (str.charAt(i3) != c9) {
            throw new DateTimeParseException(String.format("Expected character %s at position %d, found %s: %s", Character.valueOf(c9), Integer.valueOf(i3 + 1), Character.valueOf(str.charAt(i3)), str), str, i3);
        }
    }

    public static final StateListDrawable f(Context context, float[] fArr, int i, boolean z10) {
        fArr.getClass();
        StateListDrawable stateListDrawable = new StateListDrawable();
        if (z10) {
            int[] iArr = {android.R.attr.state_pressed};
            int color = context.getColor(R.color.stepos_list_item_pressed);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadii((float[]) fArr.clone());
            gradientDrawable.setColor(color);
            stateListDrawable.addState(iArr, gradientDrawable);
        }
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setCornerRadii((float[]) fArr.clone());
        gradientDrawable2.setColor(i);
        stateListDrawable.addState(new int[0], gradientDrawable2);
        return stateListDrawable;
    }

    /* JADX WARN: Type inference failed for: r5v3, types: [pb.h, xb.p] */
    public static final void i(View view) {
        view.getClass();
        gc.l lVarA = td.h.A((pb.h) td.h.I(new m0(view, null, 0)).f4705b);
        while (lVarA.hasNext()) {
            ArrayList arrayList = D((View) lVarA.next()).f11367a;
            for (int iX = ac.a.x(arrayList); -1 < iX; iX--) {
                v1.a aVar = ((s1) arrayList.get(iX)).f14533a;
                g2 g2Var = aVar.f14326g;
                if (g2Var != null) {
                    g2Var.a();
                }
                aVar.f14326g = null;
                aVar.requestLayout();
            }
        }
    }

    public static final void j(r rVar, String str) {
        d0 d0VarB;
        WorkDatabase workDatabase = rVar.f5372c;
        workDatabase.getClass();
        p5.s sVarC = workDatabase.C();
        p5.c cVarX = workDatabase.x();
        ArrayList arrayListI = ac.a.I(str);
        while (!arrayListI.isEmpty()) {
            String str2 = (String) q.q0(arrayListI);
            int i = sVarC.i(str2);
            if (i != 3 && i != 4) {
                WorkDatabase_Impl workDatabase_Impl = sVarC.f9791a;
                workDatabase_Impl.b();
                p5.h hVar = sVarC.f9795e;
                z4.j jVarA = hVar.a();
                jVarA.h(1, str2);
                try {
                    workDatabase_Impl.c();
                    try {
                        jVarA.d();
                        workDatabase_Impl.v();
                    } finally {
                    }
                } finally {
                    hVar.c(jVarA);
                }
            }
            arrayListI.addAll(cVarX.l(str2));
        }
        h5.d dVar = rVar.f5375f;
        dVar.getClass();
        synchronized (dVar.f5324j) {
            u.d().a(h5.d.f5315k, "Processor cancelling " + str);
            dVar.f5323h.add(str);
            d0VarB = dVar.b(str);
        }
        h5.d.d(str, d0VarB, 1);
        Iterator it = rVar.f5374e.iterator();
        while (it.hasNext()) {
            ((h5.f) it.next()).c(str);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0053, code lost:
    
        if (t.c1.f(r9, r1, yb.k.a(r7, r2) ? r0.getWidth() : i6.d.d(r7.f3927a, r8), yb.k.a(r7, r2) ? r0.getHeight() : i6.d.d(r7.f3928b, r8), r8) == 1.0d) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Bitmap k(android.graphics.drawable.Drawable r5, android.graphics.Bitmap.Config r6, f6.g r7, f6.f r8, boolean r9) {
        /*
            Method dump skipped, instructions count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: id.k.k(android.graphics.drawable.Drawable, android.graphics.Bitmap$Config, f6.g, f6.f, boolean):android.graphics.Bitmap");
    }

    public static StaticLayout l(CharSequence charSequence, TextPaint textPaint, int i, int i3, TextDirectionHeuristic textDirectionHeuristic, Layout.Alignment alignment, int i10, TextUtils.TruncateAt truncateAt, int i11, int i12, boolean z10, int i13, int i14, int i15, int i16) {
        if (i3 < 0) {
            i2.a.a("invalid start value");
        }
        int length = charSequence.length();
        if (i3 < 0 || i3 > length) {
            i2.a.a("invalid end value");
        }
        if (i10 < 0) {
            i2.a.a("invalid maxLines value");
        }
        if (i < 0) {
            i2.a.a("invalid width value");
        }
        if (i11 < 0) {
            i2.a.a("invalid ellipsizedWidth value");
        }
        StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequence, 0, i3, textPaint, i);
        builderObtain.setTextDirection(textDirectionHeuristic);
        builderObtain.setAlignment(alignment);
        builderObtain.setMaxLines(i10);
        builderObtain.setEllipsize(truncateAt);
        builderObtain.setEllipsizedWidth(i11);
        builderObtain.setLineSpacing(0.0f, 1.0f);
        builderObtain.setIncludePad(z10);
        builderObtain.setBreakStrategy(i13);
        builderObtain.setHyphenationFrequency(i16);
        builderObtain.setIndents(null, null);
        builderObtain.setJustificationMode(i12);
        builderObtain.setUseLineSpacingFromFallbacks(true);
        builderObtain.setLineBreakConfig(new LineBreakConfig.Builder().setLineBreakStyle(i14).setLineBreakWordStyle(i15).build());
        if (Build.VERSION.SDK_INT >= 35) {
            builderObtain.setUseBoundsForWidth(false);
        }
        return builderObtain.build();
    }

    public static void m(float f5, float f10, float f11, float f12) {
        new PathInterpolator(f5, f10, f11, f12);
    }

    public static ArrayList n(Context context) throws PackageManager.NameNotFoundException {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        if (context != null) {
            PackageManager packageManager = context.getPackageManager();
            for (String str : a9.o.f293b) {
                try {
                    packageManager.getPackageInfo(str, 0);
                    arrayList.add(str);
                } catch (Exception unused) {
                }
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.addAll(a9.o.f293b);
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            String str2 = (String) obj;
            String strC = k0.a.C("/storage/emulated/0/Android/data/.", str2, "/.garbage");
            String strC2 = k0.a.C("/storage/emulated/0/Android/data/.", str2, "/.garbage/.garbage.db");
            a9.m mVar = new a9.m();
            mVar.f290a = strC;
            mVar.f291b = strC2;
            VarHandle.storeStoreFence();
            String strC3 = k0.a.C("/storage/emulated/0/Android/.", str2, "/.garbage");
            String strC4 = k0.a.C("/storage/emulated/0/Android/.", str2, "/.garbage/.garbage.db");
            a9.m mVar2 = new a9.m();
            mVar2.f290a = strC3;
            mVar2.f291b = strC4;
            VarHandle.storeStoreFence();
            q.p0(ac.a.F(mVar, mVar2), arrayList2);
        }
        return arrayList2;
    }

    public static final boolean o(String str, String str2) {
        str.getClass();
        if (str.equals(str2)) {
            return true;
        }
        if (str.length() != 0) {
            int i = 0;
            int i3 = 0;
            int i10 = 0;
            while (true) {
                if (i < str.length()) {
                    char cCharAt = str.charAt(i);
                    int i11 = i10 + 1;
                    if (i10 == 0 && cCharAt != '(') {
                        break;
                    }
                    if (cCharAt == '(') {
                        i3++;
                    } else if (cCharAt == ')' && i3 - 1 == 0 && i10 != str.length() - 1) {
                        break;
                    }
                    i++;
                    i10 = i11;
                } else if (i3 == 0) {
                    return yb.k.a(hc.h.w0(str.substring(1, str.length() - 1)).toString(), str2);
                }
            }
        }
        return false;
    }

    public static long p(int i, int i3, int i10, int i11) {
        int i12 = 262142;
        int iMin = Math.min(i10, 262142);
        int iMin2 = Reader.READ_DONE;
        int iMin3 = i11 == Integer.MAX_VALUE ? Integer.MAX_VALUE : Math.min(i11, 262142);
        int i13 = iMin3 == Integer.MAX_VALUE ? iMin : iMin3;
        if (i13 >= 8191) {
            if (i13 < 32767) {
                i12 = 65534;
            } else if (i13 < 65535) {
                i12 = 32766;
            } else {
                if (i13 >= 262143) {
                    o2.b.j(i13);
                    throw new androidx.fragment.app.d();
                }
                i12 = 8190;
            }
        }
        if (i3 != Integer.MAX_VALUE) {
            iMin2 = Math.min(i12, i3);
        }
        return o2.b.a(Math.min(i12, i), iMin2, iMin, iMin3);
    }

    public static long q(int i, int i3, int i10, int i11) {
        int i12 = 262142;
        int iMin = Math.min(i, 262142);
        int iMin2 = Reader.READ_DONE;
        int iMin3 = i3 == Integer.MAX_VALUE ? Integer.MAX_VALUE : Math.min(i3, 262142);
        int i13 = iMin3 == Integer.MAX_VALUE ? iMin : iMin3;
        if (i13 >= 8191) {
            if (i13 < 32767) {
                i12 = 65534;
            } else if (i13 < 65535) {
                i12 = 32766;
            } else {
                if (i13 >= 262143) {
                    o2.b.j(i13);
                    throw new androidx.fragment.app.d();
                }
                i12 = 8190;
            }
        }
        if (i11 != Integer.MAX_VALUE) {
            iMin2 = Math.min(i12, i11);
        }
        return o2.b.a(iMin, iMin3, Math.min(i12, i10), iMin2);
    }

    public static final void r(r rVar, String str) {
        str.getClass();
        rVar.getClass();
        WorkDatabase workDatabase = rVar.f5372c;
        workDatabase.getClass();
        a4.l lVar = new a4.l(8);
        lVar.f185f = workDatabase;
        lVar.f186g = str;
        lVar.f187h = rVar;
        VarHandle.storeStoreFence();
        workDatabase.u(lVar);
    }

    public static final String s(Collection collection) {
        collection.getClass();
        return !collection.isEmpty() ? hc.i.M(kb.l.B0(collection, ",\n", "\n", "\n", null, 56)).concat("},") : " }";
    }

    public static ad.s t(String str) {
        str.getClass();
        Matcher matcher = ad.s.f568d.matcher(str);
        if (!matcher.lookingAt()) {
            od.f.q(str, "No subtype found for: \"");
            return null;
        }
        String strGroup = matcher.group(1);
        strGroup.getClass();
        Locale locale = Locale.US;
        locale.getClass();
        String lowerCase = strGroup.toLowerCase(locale);
        lowerCase.getClass();
        String strGroup2 = matcher.group(2);
        strGroup2.getClass();
        strGroup2.toLowerCase(locale).getClass();
        ArrayList arrayList = new ArrayList();
        Matcher matcher2 = ad.s.f569e.matcher(str);
        int iEnd = matcher.end();
        while (iEnd < str.length()) {
            matcher2.region(iEnd, str.length());
            if (!matcher2.lookingAt()) {
                throw new IllegalArgumentException(("Parameter is not formatted correctly: \"" + str.substring(iEnd) + "\" for: \"" + str + JsonFactory.DEFAULT_QUOTE_CHAR).toString());
            }
            String strGroup3 = matcher2.group(1);
            if (strGroup3 == null) {
                iEnd = matcher2.end();
            } else {
                String strGroup4 = matcher2.group(2);
                if (strGroup4 == null) {
                    strGroup4 = matcher2.group(3);
                } else if (hc.o.U(strGroup4, "'", false) && hc.o.P(strGroup4, "'", false) && strGroup4.length() > 2) {
                    strGroup4 = strGroup4.substring(1, strGroup4.length() - 1);
                }
                arrayList.add(strGroup3);
                arrayList.add(strGroup4);
                iEnd = matcher2.end();
            }
        }
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        ad.s sVar = new ad.s();
        sVar.f570a = str;
        sVar.f571b = lowerCase;
        sVar.f572c = strArr;
        VarHandle.storeStoreFence();
        return sVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0050, code lost:
    
        if (r5.f3474c == r9.hashCode()) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.content.res.ColorStateList u(int r8, android.content.Context r9) throws android.content.res.Resources.NotFoundException {
        /*
            android.content.res.Resources r0 = r9.getResources()
            android.content.res.Resources$Theme r9 = r9.getTheme()
            java.lang.ThreadLocal r1 = e3.k.f3478a
            e3.i r1 = new e3.i
            r1.<init>()
            r1.f3475a = r0
            r1.f3476b = r9
            java.lang.invoke.VarHandle.storeStoreFence()
            java.lang.Object r2 = e3.k.f3480c
            monitor-enter(r2)
            java.util.WeakHashMap r3 = e3.k.f3479b     // Catch: java.lang.Throwable -> L45
            java.lang.Object r3 = r3.get(r1)     // Catch: java.lang.Throwable -> L45
            android.util.SparseArray r3 = (android.util.SparseArray) r3     // Catch: java.lang.Throwable -> L45
            r4 = 0
            if (r3 == 0) goto L59
            int r5 = r3.size()     // Catch: java.lang.Throwable -> L45
            if (r5 <= 0) goto L59
            java.lang.Object r5 = r3.get(r8)     // Catch: java.lang.Throwable -> L45
            e3.h r5 = (e3.h) r5     // Catch: java.lang.Throwable -> L45
            if (r5 == 0) goto L59
            android.content.res.Configuration r6 = r5.f3473b     // Catch: java.lang.Throwable -> L45
            android.content.res.Configuration r7 = r0.getConfiguration()     // Catch: java.lang.Throwable -> L45
            boolean r6 = r6.equals(r7)     // Catch: java.lang.Throwable -> L45
            if (r6 == 0) goto L56
            if (r9 != 0) goto L48
            int r6 = r5.f3474c     // Catch: java.lang.Throwable -> L45
            if (r6 == 0) goto L52
            goto L48
        L45:
            r8 = move-exception
            goto Ld2
        L48:
            if (r9 == 0) goto L56
            int r6 = r5.f3474c     // Catch: java.lang.Throwable -> L45
            int r7 = r9.hashCode()     // Catch: java.lang.Throwable -> L45
            if (r6 != r7) goto L56
        L52:
            android.content.res.ColorStateList r3 = r5.f3472a     // Catch: java.lang.Throwable -> L45
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L45
            goto L5b
        L56:
            r3.remove(r8)     // Catch: java.lang.Throwable -> L45
        L59:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L45
            r3 = r4
        L5b:
            if (r3 == 0) goto L5e
            return r3
        L5e:
            java.lang.ThreadLocal r2 = e3.k.f3478a
            java.lang.Object r3 = r2.get()
            android.util.TypedValue r3 = (android.util.TypedValue) r3
            if (r3 != 0) goto L70
            android.util.TypedValue r3 = new android.util.TypedValue
            r3.<init>()
            r2.set(r3)
        L70:
            r2 = 1
            r0.getValue(r8, r3, r2)
            int r2 = r3.type
            r3 = 28
            if (r2 < r3) goto L7f
            r3 = 31
            if (r2 > r3) goto L7f
            goto L90
        L7f:
            android.content.res.XmlResourceParser r2 = r0.getXml(r8)
            android.content.res.ColorStateList r4 = e3.c.a(r0, r2, r9)     // Catch: java.lang.Exception -> L88
            goto L90
        L88:
            r2 = move-exception
            java.lang.String r3 = "ResourcesCompat"
            java.lang.String r5 = "Failed to inflate ColorStateList, leaving it to the framework"
            android.util.Log.w(r3, r5, r2)
        L90:
            if (r4 == 0) goto Lcd
            java.lang.Object r2 = e3.k.f3480c
            monitor-enter(r2)
            java.util.WeakHashMap r0 = e3.k.f3479b     // Catch: java.lang.Throwable -> La8
            java.lang.Object r3 = r0.get(r1)     // Catch: java.lang.Throwable -> La8
            android.util.SparseArray r3 = (android.util.SparseArray) r3     // Catch: java.lang.Throwable -> La8
            if (r3 != 0) goto Laa
            android.util.SparseArray r3 = new android.util.SparseArray     // Catch: java.lang.Throwable -> La8
            r3.<init>()     // Catch: java.lang.Throwable -> La8
            r0.put(r1, r3)     // Catch: java.lang.Throwable -> La8
            goto Laa
        La8:
            r8 = move-exception
            goto Lcb
        Laa:
            e3.h r0 = new e3.h     // Catch: java.lang.Throwable -> La8
            android.content.res.Resources r1 = r1.f3475a     // Catch: java.lang.Throwable -> La8
            android.content.res.Configuration r1 = r1.getConfiguration()     // Catch: java.lang.Throwable -> La8
            r0.<init>()     // Catch: java.lang.Throwable -> La8
            r0.f3472a = r4     // Catch: java.lang.Throwable -> La8
            r0.f3473b = r1     // Catch: java.lang.Throwable -> La8
            if (r9 != 0) goto Lbd
            r9 = 0
            goto Lc1
        Lbd:
            int r9 = r9.hashCode()     // Catch: java.lang.Throwable -> La8
        Lc1:
            r0.f3474c = r9     // Catch: java.lang.Throwable -> La8
            java.lang.invoke.VarHandle.storeStoreFence()     // Catch: java.lang.Throwable -> La8
            r3.append(r8, r0)     // Catch: java.lang.Throwable -> La8
            monitor-exit(r2)     // Catch: java.lang.Throwable -> La8
            goto Ld1
        Lcb:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> La8
            throw r8
        Lcd:
            android.content.res.ColorStateList r4 = r0.getColorStateList(r8, r9)
        Ld1:
            return r4
        Ld2:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L45
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: id.k.u(int, android.content.Context):android.content.res.ColorStateList");
    }

    public static Drawable v(int i, Context context) {
        return d2.c().d(i, context);
    }

    public static float y(int i, String[] strArr) throws NumberFormatException {
        float f5 = Float.parseFloat(strArr[i]);
        if (f5 >= 0.0f && f5 <= 1.0f) {
            return f5;
        }
        throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + f5);
    }

    public abstract int A();

    public abstract int B(View view);

    public abstract int C(androidx.coordinatorlayout.widget.a aVar);

    public abstract int E();

    public abstract boolean F(float f5);

    public abstract boolean H(View view);

    public abstract boolean I(float f5, float f10);

    public abstract void J(Throwable th);

    public abstract void K(p5.i iVar);

    public abstract boolean T(View view, float f5);

    public abstract void V(ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i3);

    public abstract int g(ViewGroup.MarginLayoutParams marginLayoutParams);

    public abstract float h(int i);

    public abstract int w();

    public abstract int x();

    public abstract int z();
}
