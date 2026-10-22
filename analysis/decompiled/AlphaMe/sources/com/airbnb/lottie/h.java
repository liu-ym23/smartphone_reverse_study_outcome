package com.airbnb.lottie;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.room.AbstractC0351g;
import androidx.work.impl.WorkDatabase;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import com.stepos.activeview.utils.Constants;
import com.stepos.alphame.R;
import d.C0527a;
import e2.AbstractC0552a;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import r.AbstractC0827a;
import s0.C0844b;
import s0.ThreadFactoryC0845c;
import t0.J;
import t0.N;
import w2.C0975b;
import z2.InterfaceC1006a;

/* loaded from: classes.dex */
public abstract class h {
    public static F1.p A(JsonReader jsonReader) {
        boolean z4;
        try {
            try {
                jsonReader.peek();
                z4 = false;
                try {
                    return (F1.p) H1.z.f801z.b(jsonReader);
                } catch (EOFException e4) {
                    e = e4;
                    if (z4) {
                        return F1.r.f449a;
                    }
                    throw new F1.q(5, e);
                }
            } catch (EOFException e5) {
                e = e5;
                z4 = true;
            }
        } catch (MalformedJsonException e6) {
            throw new F1.q(5, e6);
        } catch (IOException e7) {
            throw new F1.q(5, e7);
        } catch (NumberFormatException e8) {
            throw new F1.q(5, e8);
        }
    }

    public static Y.b B(MappedByteBuffer mappedByteBuffer) throws IOException {
        long jO;
        ByteBuffer byteBufferDuplicate = mappedByteBuffer.duplicate();
        C0527a c0527a = new C0527a(byteBufferDuplicate);
        c0527a.p(4);
        int i4 = ((ByteBuffer) c0527a.f12410b).getShort() & UShort.MAX_VALUE;
        if (i4 > 100) {
            throw new IOException("Cannot read metadata.");
        }
        c0527a.p(6);
        int i5 = 0;
        while (true) {
            if (i5 >= i4) {
                jO = -1;
                break;
            }
            int i6 = ((ByteBuffer) c0527a.f12410b).getInt();
            c0527a.p(4);
            jO = c0527a.o();
            c0527a.p(4);
            if (1835365473 == i6) {
                break;
            }
            i5++;
        }
        if (jO != -1) {
            c0527a.p((int) (jO - ((ByteBuffer) c0527a.f12410b).position()));
            c0527a.p(12);
            long jO2 = c0527a.o();
            for (int i7 = 0; i7 < jO2; i7++) {
                int i8 = ((ByteBuffer) c0527a.f12410b).getInt();
                long jO3 = c0527a.o();
                c0527a.o();
                if (1164798569 == i8 || 1701669481 == i8) {
                    byteBufferDuplicate.position((int) (jO3 + jO));
                    Y.b bVar = new Y.b();
                    byteBufferDuplicate.order(ByteOrder.LITTLE_ENDIAN);
                    bVar.b(byteBufferDuplicate, byteBufferDuplicate.position() + byteBufferDuplicate.getInt(byteBufferDuplicate.position()));
                    return bVar;
                }
            }
        }
        throw new IOException("Cannot read metadata.");
    }

    public static String C(Context context, String str) {
        Matcher matcher = Pattern.compile("#include\\s+(<([^>]+)>|\"([^\"]+)\")").matcher(str);
        StringBuffer stringBuffer = new StringBuffer(str.length());
        while (matcher.find()) {
            String strGroup = matcher.group(2);
            String strGroup2 = matcher.group(3);
            if (strGroup == null) {
                strGroup = strGroup2 != null ? strGroup2 : "";
            }
            matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(w(context, strGroup)));
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    public static boolean D(Context context, String str, String str2, String str3, String str4) throws PackageManager.NameNotFoundException {
        long jA = J.a(context);
        if (jA < 1000001) {
            return true;
        }
        B0.c cVar = AbstractC0552a.f12506a;
        String packageName = context.getPackageName();
        cVar.getClass();
        return !TextUtils.isEmpty(str4) && str4.equals(B0.c.b(str, str2, packageName, jA, str3));
    }

    public static final void E(View view, j0.h hVar) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setTag(R.id.view_tree_saved_state_registry_owner, hVar);
    }

    public static void F(Drawable drawable, int i4) {
        E.a.g(drawable, i4);
    }

    public static void G(Drawable drawable, ColorStateList colorStateList) {
        E.a.h(drawable, colorStateList);
    }

    public static void H(Drawable drawable, PorterDuff.Mode mode) {
        E.a.i(drawable, mode);
    }

    public static final V.f I(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new V.f(name);
    }

    public static int J(int i4, Context context) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(android.R.style.Animation.Activity, new int[]{i4});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    public static final void K(t0.r rVar, final WorkDatabase workDatabase, C0844b c0844b, final List list, final B0.r rVar2, final Set set) {
        B0.u uVarG = workDatabase.g();
        final String str = rVar2.f167a;
        final B0.r rVarI = uVarG.i(str);
        if (rVarI == null) {
            throw new IllegalArgumentException(B0.g.n("Worker with ", str, " doesn't exist"));
        }
        if (rVarI.f168b.a()) {
            return;
        }
        if (rVarI.d() ^ rVar2.d()) {
            StringBuilder sb = new StringBuilder("Can't update ");
            N n4 = N.f15353a;
            sb.append((String) n4.invoke(rVarI));
            sb.append(" Worker to ");
            throw new UnsupportedOperationException(B0.g.r(sb, (String) n4.invoke(rVar2), " Worker. Update operation must preserve worker's type."));
        }
        final boolean zE = rVar.e(str);
        if (!zE) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((t0.t) it.next()).a(str);
            }
        }
        workDatabase.runInTransaction(new Runnable() { // from class: t0.L
            @Override // java.lang.Runnable
            public final void run() {
                WorkDatabase workDatabase2 = workDatabase;
                Intrinsics.checkNotNullParameter(workDatabase2, "$workDatabase");
                B0.r oldWorkSpec = rVarI;
                Intrinsics.checkNotNullParameter(oldWorkSpec, "$oldWorkSpec");
                B0.r newWorkSpec = rVar2;
                Intrinsics.checkNotNullParameter(newWorkSpec, "$newWorkSpec");
                List schedulers = list;
                Intrinsics.checkNotNullParameter(schedulers, "$schedulers");
                String workSpecId = str;
                Intrinsics.checkNotNullParameter(workSpecId, "$workSpecId");
                Set tags = set;
                Intrinsics.checkNotNullParameter(tags, "$tags");
                B0.u uVarG2 = workDatabase2.g();
                B0.w wVarH = workDatabase2.h();
                B0.r workSpec = B0.r.b(newWorkSpec, null, oldWorkSpec.f168b, null, null, oldWorkSpec.f177k, oldWorkSpec.f180n, oldWorkSpec.f185s, oldWorkSpec.f186t + 1, oldWorkSpec.f187u, oldWorkSpec.f188v, 4447229);
                if (newWorkSpec.f188v == 1) {
                    workSpec.f187u = newWorkSpec.f187u;
                    workSpec.f188v++;
                }
                Intrinsics.checkNotNullParameter(schedulers, "schedulers");
                Intrinsics.checkNotNullParameter(workSpec, "workSpec");
                androidx.room.A a4 = uVarG2.f191a;
                a4.assertNotSuspendingTransaction();
                a4.beginTransaction();
                try {
                    uVarG2.f193c.handle(workSpec);
                    a4.setTransactionSuccessful();
                    a4.endTransaction();
                    android.support.v4.media.session.c cVar = (android.support.v4.media.session.c) wVarH;
                    ((androidx.room.A) cVar.f2364b).assertNotSuspendingTransaction();
                    k0.j jVarAcquire = ((androidx.room.G) cVar.f2366d).acquire();
                    if (workSpecId == null) {
                        jVarAcquire.bindNull(1);
                    } else {
                        jVarAcquire.bindString(1, workSpecId);
                    }
                    ((androidx.room.A) cVar.f2364b).beginTransaction();
                    try {
                        jVarAcquire.executeUpdateDelete();
                        ((androidx.room.A) cVar.f2364b).setTransactionSuccessful();
                        ((androidx.room.A) cVar.f2364b).endTransaction();
                        ((androidx.room.G) cVar.f2366d).release(jVarAcquire);
                        cVar.w(workSpecId, tags);
                        if (zE) {
                            return;
                        }
                        uVarG2.k(workSpecId, -1L);
                        workDatabase2.f().a(workSpecId);
                    } catch (Throwable th) {
                        ((androidx.room.A) cVar.f2364b).endTransaction();
                        ((androidx.room.G) cVar.f2366d).release(jVarAcquire);
                        throw th;
                    }
                } catch (Throwable th2) {
                    a4.endTransaction();
                    throw th2;
                }
            }
        });
        if (zE) {
            return;
        }
        t0.w.b(c0844b, workDatabase, list);
    }

    public static void L(F1.p pVar, JsonWriter jsonWriter) {
        H1.z.f801z.c(jsonWriter, pVar);
    }

    public static void M(int i4, int i5) {
        String strS;
        if (i4 < 0 || i4 >= i5) {
            if (i4 < 0) {
                strS = com.stepos.statsrpk.c.S("%s (%s) must not be negative", MapBundleKey.MapObjKey.OBJ_SL_INDEX, Integer.valueOf(i4));
            } else {
                if (i5 < 0) {
                    throw new IllegalArgumentException(AbstractC0351g.m("negative size: ", i5));
                }
                strS = com.stepos.statsrpk.c.S("%s (%s) must be less than size (%s)", MapBundleKey.MapObjKey.OBJ_SL_INDEX, Integer.valueOf(i4), Integer.valueOf(i5));
            }
            throw new IndexOutOfBoundsException(strS);
        }
    }

    public static String N(int i4) {
        if (i4 == 0) {
            return "GRANULARITY_PERMISSION_LEVEL";
        }
        if (i4 == 1) {
            return "GRANULARITY_COARSE";
        }
        if (i4 == 2) {
            return "GRANULARITY_FINE";
        }
        throw new IllegalArgumentException();
    }

    public static void O(int i4, int i5, int i6) {
        if (i4 < 0 || i5 < i4 || i5 > i6) {
            throw new IndexOutOfBoundsException((i4 < 0 || i4 > i6) ? P(i4, i6, "start index") : (i5 < 0 || i5 > i6) ? P(i5, i6, "end index") : com.stepos.statsrpk.c.S("end index (%s) must not be less than start index (%s)", Integer.valueOf(i5), Integer.valueOf(i4)));
        }
    }

    public static String P(int i4, int i5, String str) {
        if (i4 < 0) {
            return com.stepos.statsrpk.c.S("%s (%s) must not be negative", str, Integer.valueOf(i4));
        }
        if (i5 >= 0) {
            return com.stepos.statsrpk.c.S("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i4), Integer.valueOf(i5));
        }
        throw new IllegalArgumentException(AbstractC0351g.m("negative size: ", i5));
    }

    public static final ExecutorService a(boolean z4) {
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), new ThreadFactoryC0845c(z4));
        Intrinsics.checkNotNullExpressionValue(executorServiceNewFixedThreadPool, "newFixedThreadPool(\n    …)),\n        factory\n    )");
        return executorServiceNewFixedThreadPool;
    }

    public static final void b(q.g gVar, int i4) {
        Intrinsics.checkNotNullParameter(gVar, "<this>");
        int[] iArr = new int[i4];
        gVar.getClass();
        Intrinsics.checkNotNullParameter(iArr, "<set-?>");
        gVar.f13951a = iArr;
        Object[] objArr = new Object[i4];
        Intrinsics.checkNotNullParameter(objArr, "<set-?>");
        gVar.f13952b = objArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean c(int r9, android.graphics.Rect r10, android.graphics.Rect r11, android.graphics.Rect r12) {
        /*
            boolean r0 = d(r9, r10, r11)
            boolean r1 = d(r9, r10, r12)
            r2 = 0
            if (r1 != 0) goto L78
            if (r0 != 0) goto Lf
            goto L78
        Lf:
            java.lang.String r0 = "direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}."
            r1 = 130(0x82, float:1.82E-43)
            r3 = 33
            r4 = 66
            r5 = 17
            r6 = 1
            if (r9 == r5) goto L3d
            if (r9 == r3) goto L36
            if (r9 == r4) goto L2f
            if (r9 != r1) goto L29
            int r7 = r10.bottom
            int r8 = r12.top
            if (r7 > r8) goto L77
            goto L43
        L29:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            r9.<init>(r0)
            throw r9
        L2f:
            int r7 = r10.right
            int r8 = r12.left
            if (r7 > r8) goto L77
            goto L43
        L36:
            int r7 = r10.top
            int r8 = r12.bottom
            if (r7 < r8) goto L77
            goto L43
        L3d:
            int r7 = r10.left
            int r8 = r12.right
            if (r7 < r8) goto L77
        L43:
            if (r9 == r5) goto L77
            if (r9 != r4) goto L48
            goto L77
        L48:
            int r11 = y(r9, r10, r11)
            if (r9 == r5) goto L6a
            if (r9 == r3) goto L65
            if (r9 == r4) goto L60
            if (r9 != r1) goto L5a
            int r9 = r12.bottom
            int r10 = r10.bottom
        L58:
            int r9 = r9 - r10
            goto L6f
        L5a:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            r9.<init>(r0)
            throw r9
        L60:
            int r9 = r12.right
            int r10 = r10.right
            goto L58
        L65:
            int r9 = r10.top
            int r10 = r12.top
            goto L58
        L6a:
            int r9 = r10.left
            int r10 = r12.left
            goto L58
        L6f:
            int r9 = java.lang.Math.max(r6, r9)
            if (r11 >= r9) goto L76
            r2 = r6
        L76:
            return r2
        L77:
            return r6
        L78:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.h.c(int, android.graphics.Rect, android.graphics.Rect, android.graphics.Rect):boolean");
    }

    public static boolean d(int i4, Rect rect, Rect rect2) {
        if (i4 != 17) {
            if (i4 != 33) {
                if (i4 != 66) {
                    if (i4 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return rect2.right >= rect.left && rect2.left <= rect.right;
        }
        return rect2.bottom >= rect.top && rect2.top <= rect.bottom;
    }

    public static final V.f e(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new V.f(name);
    }

    public static void f(String str, boolean z4) {
        if (!z4) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void g(int i4) {
        if (i4 < 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void h(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static X.x i(Context context) {
        ProviderInfo providerInfo;
        H.d dVar;
        ApplicationInfo applicationInfo;
        PackageManager packageManager = context.getPackageManager();
        h(packageManager, "Package manager required to locate emoji font provider");
        Iterator<ResolveInfo> it = packageManager.queryIntentContentProviders(new Intent("androidx.content.action.LOAD_EMOJI_FONT"), 0).iterator();
        while (true) {
            if (!it.hasNext()) {
                providerInfo = null;
                break;
            }
            providerInfo = it.next().providerInfo;
            if (providerInfo != null && (applicationInfo = providerInfo.applicationInfo) != null && (applicationInfo.flags & 1) == 1) {
                break;
            }
        }
        if (providerInfo == null) {
            dVar = null;
        } else {
            try {
                String str = providerInfo.authority;
                String str2 = providerInfo.packageName;
                Signature[] signatureArr = packageManager.getPackageInfo(str2, 64).signatures;
                ArrayList arrayList = new ArrayList();
                for (Signature signature : signatureArr) {
                    arrayList.add(signature.toByteArray());
                }
                dVar = new H.d(str, str2, "emojicompat-emoji-font", Collections.singletonList(arrayList));
            } catch (PackageManager.NameNotFoundException e4) {
                Log.wtf("emoji2.text.DefaultEmojiConfig", e4);
            }
        }
        if (dVar == null) {
            return null;
        }
        return new X.x(new X.w(context, dVar));
    }

    public static C0975b j(Context context, String str, String str2) {
        return new C0975b(C(context, w(context, str)), C(context, w(context, str2)));
    }

    public static void k(InterfaceC1006a interfaceC1006a) {
        if (interfaceC1006a != null) {
            try {
                interfaceC1006a.dispose();
            } catch (Exception e4) {
                Log.d("RenderFilter", "dispose failed", e4);
            }
        }
    }

    public static final V.f l(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new V.f(name);
    }

    public static boolean m(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static View n(int i4, View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View viewFindViewById = viewGroup.getChildAt(i5).findViewById(i4);
            if (viewFindViewById != null) {
                return viewFindViewById;
            }
        }
        return null;
    }

    public static final V.f o(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new V.f(name);
    }

    public static Set p() {
        try {
            Object objInvoke = Class.forName("android.text.EmojiConsistency").getMethod("getEmojiConsistencySet", new Class[0]).invoke(null, new Object[0]);
            if (objInvoke == null) {
                return Collections.emptySet();
            }
            Set set = (Set) objInvoke;
            Iterator it = set.iterator();
            while (it.hasNext()) {
                if (!(it.next() instanceof int[])) {
                    return Collections.emptySet();
                }
            }
            return set;
        } catch (Throwable unused) {
            return Collections.emptySet();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002d, code lost:
    
        if (r2 == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
    
        r0 = Z2.C0128h.f2217g;
        r1 = r0.get(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0037, code lost:
    
        if ((r1 instanceof Z2.C0143q) == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003d, code lost:
    
        if (((Z2.C0143q) r1).f2235d == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003f, code lost:
    
        r2.p();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0043, code lost:
    
        Z2.C0128h.f2216f.set(r2, 536870911);
        r0.set(r2, Z2.C0116b.f2207a);
        r4 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0051, code lost:
    
        if (r4 != null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0054, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005b, code lost:
    
        return new Z2.C0128h(2, r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final Z2.C0128h q(kotlin.coroutines.Continuation r6) {
        /*
            boolean r0 = r6 instanceof d3.i
            if (r0 != 0) goto Lb
            Z2.h r0 = new Z2.h
            r1 = 1
            r0.<init>(r1, r6)
            return r0
        Lb:
            r0 = r6
            d3.i r0 = (d3.i) r0
            r0.getClass()
        L11:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = d3.i.f12454h
            java.lang.Object r2 = r1.get(r0)
            X.r r3 = d3.AbstractC0539a.f12444c
            r4 = 0
            if (r2 != 0) goto L21
            r1.set(r0, r3)
            r2 = r4
            goto L2d
        L21:
            boolean r5 = r2 instanceof Z2.C0128h
            if (r5 == 0) goto L5c
            boolean r1 = r1.compareAndSet(r0, r2, r3)
            if (r1 == 0) goto L11
            Z2.h r2 = (Z2.C0128h) r2
        L2d:
            if (r2 == 0) goto L55
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = Z2.C0128h.f2217g
            java.lang.Object r1 = r0.get(r2)
            boolean r3 = r1 instanceof Z2.C0143q
            if (r3 == 0) goto L43
            Z2.q r1 = (Z2.C0143q) r1
            java.lang.Object r1 = r1.f2235d
            if (r1 == 0) goto L43
            r2.p()
            goto L51
        L43:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r1 = Z2.C0128h.f2216f
            r3 = 536870911(0x1fffffff, float:1.0842021E-19)
            r1.set(r2, r3)
            Z2.b r1 = Z2.C0116b.f2207a
            r0.set(r2, r1)
            r4 = r2
        L51:
            if (r4 != 0) goto L54
            goto L55
        L54:
            return r4
        L55:
            Z2.h r0 = new Z2.h
            r1 = 2
            r0.<init>(r1, r6)
            return r0
        L5c:
            if (r2 == r3) goto L11
            boolean r1 = r2 instanceof java.lang.Throwable
            if (r1 == 0) goto L63
            goto L11
        L63:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Inconsistent state "
            r0.<init>(r1)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = r0.toString()
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.h.q(kotlin.coroutines.Continuation):Z2.h");
    }

    public static final int r(q.g gVar, Object obj, int i4) {
        Intrinsics.checkNotNullParameter(gVar, "<this>");
        int i5 = gVar.f13953c;
        if (i5 == 0) {
            return -1;
        }
        Intrinsics.checkNotNullParameter(gVar, "<this>");
        try {
            int iA = AbstractC0827a.a(gVar.f13953c, i4, gVar.f13951a);
            if (iA < 0 || Intrinsics.areEqual(obj, gVar.f13952b[iA])) {
                return iA;
            }
            int i6 = iA + 1;
            while (i6 < i5 && gVar.f13951a[i6] == i4) {
                if (Intrinsics.areEqual(obj, gVar.f13952b[i6])) {
                    return i6;
                }
                i6++;
            }
            for (int i7 = iA - 1; i7 >= 0 && gVar.f13951a[i7] == i4; i7--) {
                if (Intrinsics.areEqual(obj, gVar.f13952b[i7])) {
                    return i7;
                }
            }
            return ~i6;
        } catch (IndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public static final V.f s(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new V.f(name);
    }

    public static boolean t(int i4, Rect rect, Rect rect2) {
        if (i4 == 17) {
            int i5 = rect.right;
            int i6 = rect2.right;
            return (i5 > i6 || rect.left >= i6) && rect.left > rect2.left;
        }
        if (i4 == 33) {
            int i7 = rect.bottom;
            int i8 = rect2.bottom;
            return (i7 > i8 || rect.top >= i8) && rect.top > rect2.top;
        }
        if (i4 == 66) {
            int i9 = rect.left;
            int i10 = rect2.left;
            return (i9 < i10 || rect.right <= i10) && rect.right < rect2.right;
        }
        if (i4 != 130) {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        int i11 = rect.top;
        int i12 = rect2.top;
        return (i11 < i12 || rect.bottom <= i12) && rect.bottom < rect2.bottom;
    }

    public static boolean u(EditText editText) {
        return editText.getInputType() != 0;
    }

    public static boolean v(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            boolean z4 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
            T2.d.a("NetInfoUtils", "isOnline:" + z4);
            return z4;
        } catch (SecurityException e4) {
            T2.d.b("NetInfoUtils", "Security exception:" + e4.toString());
            return true;
        }
    }

    public static String w(Context context, String str) throws IOException {
        try {
            InputStream inputStreamOpen = context.getAssets().open(str);
            Z1.a aVar = C2.b.f337a;
            Charset charsetForName = Charset.forName(Constants.UTF_8_CODE);
            C2.h hVar = new C2.h();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStreamOpen, charsetForName);
            char[] cArr = (char[]) C2.b.f337a.get();
            while (true) {
                int i4 = inputStreamReader.read(cArr);
                if (-1 == i4) {
                    break;
                }
                hVar.write(cArr, 0, i4);
            }
            String string = hVar.f347a.toString();
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
            throw new androidx.fragment.app.A("loadAssetsString failed, content=null, context=" + context + ", path=" + str, 6);
        } catch (Exception e4) {
            throw new androidx.fragment.app.A("loadAssetsString failed, context=" + context + ", path=" + str, 6, e4);
        }
    }

    public static final V.f x(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new V.f(name);
    }

    public static int y(int i4, Rect rect, Rect rect2) {
        int i5;
        int i6;
        if (i4 == 17) {
            i5 = rect.left;
            i6 = rect2.right;
        } else if (i4 == 33) {
            i5 = rect.top;
            i6 = rect2.bottom;
        } else if (i4 == 66) {
            i5 = rect2.left;
            i6 = rect.right;
        } else {
            if (i4 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            i5 = rect2.top;
            i6 = rect.bottom;
        }
        return Math.max(0, i5 - i6);
    }

    public static int z(int i4, Rect rect, Rect rect2) {
        if (i4 != 17) {
            if (i4 != 33) {
                if (i4 != 66) {
                    if (i4 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return Math.abs(((rect.width() / 2) + rect.left) - ((rect2.width() / 2) + rect2.left));
        }
        return Math.abs(((rect.height() / 2) + rect.top) - ((rect2.height() / 2) + rect2.top));
    }
}
