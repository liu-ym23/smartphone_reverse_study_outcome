package android.support.v4.media.session;

import B0.f;
import B0.g;
import B0.j;
import B0.v;
import B0.w;
import C.o;
import Z2.I;
import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationManager;
import android.os.Handler;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import androidx.appcompat.app.C0185k;
import androidx.appcompat.app.K;
import androidx.appcompat.widget.A;
import androidx.appcompat.widget.W;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.i;
import androidx.lifecycle.AbstractC0328z;
import androidx.lifecycle.EnumC0326x;
import androidx.lifecycle.G;
import androidx.lifecycle.InterfaceC0321s;
import androidx.lifecycle.g0;
import androidx.lifecycle.h0;
import androidx.lifecycle.k0;
import androidx.lifecycle.m0;
import androidx.lifecycle.n0;
import androidx.lifecycle.o0;
import androidx.lifecycle.q0;
import androidx.lifecycle.r0;
import androidx.lifecycle.s0;
import androidx.lifecycle.t0;
import androidx.lifecycle.u0;
import androidx.room.E;
import androidx.room.k;
import com.stepos.alphame.awareness.AwarenessDataItem;
import com.stepos.alphame.utils.Property;
import com.stepos.statsrpk.IRpkStatsInterface;
import com.stepos.statsrpk.RpkEvent;
import com.stepos.statsrpk.RpkInfo;
import com.stepos.statsrpk.service.RpkUsageStatsService;
import d0.AbstractC0533c;
import d0.C0531a;
import d0.C0534d;
import j0.C0631f;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.internal.Intrinsics;
import stepos.support.v7.app.Z;
import t0.J;
import v.C0944d;
import v.C0945e;
import w.C0956b;
import w.C0968n;

/* loaded from: classes.dex */
public final class c implements i, G.b, w {

    /* renamed from: e, reason: collision with root package name */
    public static c f2362e;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2363a;

    /* renamed from: b, reason: collision with root package name */
    public Object f2364b;

    /* renamed from: c, reason: collision with root package name */
    public Object f2365c;

    /* renamed from: d, reason: collision with root package name */
    public Object f2366d;

    public /* synthetic */ c(int i4, Object obj, Object obj2, Object obj3) {
        this.f2363a = i4;
        this.f2366d = obj;
        this.f2364b = obj2;
        this.f2365c = obj3;
    }

    public static byte[] c(Context context, String str, int i4) {
        T2.d.d("SharedPreferencesHelper", "init SharedPreferences, name: com.stepos.statsapp.v3.simple_crypto_AES");
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.stepos.statsapp.v3.simple_crypto_AES", 0);
        T2.d.a("SharedPreferencesHelper", "com.stepos.statsapp.v3.simple_crypto_AES structure complete");
        String string = sharedPreferences.getString(str, "");
        if (!TextUtils.isEmpty(string)) {
            byte[] bArrDecode = Base64.decode(string, 2);
            if (bArrDecode.length == i4) {
                return bArrDecode;
            }
        }
        byte[] bArr = new byte[i4];
        new SecureRandom().nextBytes(bArr);
        sharedPreferences.edit().putString(str, Base64.encodeToString(bArr, 2)).commit();
        return bArr;
    }

    public static c y(int i4, int i5, Context context, AttributeSet attributeSet, int[] iArr) {
        return new c(context, context.obtainStyledAttributes(attributeSet, iArr, i4, i5));
    }

    public final void A() {
        ((TypedArray) this.f2365c).recycle();
    }

    public final void B(C0945e c0945e, int i4, int i5, int i6) {
        int i7 = c0945e.f15552b0;
        int i8 = c0945e.f15554c0;
        c0945e.f15552b0 = 0;
        c0945e.f15554c0 = 0;
        c0945e.P(i5);
        c0945e.M(i6);
        if (i7 < 0) {
            c0945e.f15552b0 = 0;
        } else {
            c0945e.f15552b0 = i7;
        }
        if (i8 < 0) {
            c0945e.f15554c0 = 0;
        } else {
            c0945e.f15554c0 = i8;
        }
        C0945e c0945e2 = (C0945e) this.f2366d;
        c0945e2.f15605t0 = i4;
        c0945e2.S();
    }

    public final void C(C0945e c0945e) {
        ((ArrayList) this.f2364b).clear();
        int size = c0945e.f15674q0.size();
        for (int i4 = 0; i4 < size; i4++) {
            C0944d c0944d = (C0944d) c0945e.f15674q0.get(i4);
            int[] iArr = c0944d.f15580p0;
            if (iArr[0] == 3 || iArr[1] == 3) {
                ((ArrayList) this.f2364b).add(c0944d);
            }
        }
        c0945e.f15604s0.f15745b = true;
    }

    public final SecretKeySpec a() {
        try {
            return new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec("262t1#x23&^ya1bk".toCharArray(), (byte[]) this.f2365c, 100, 256)).getEncoded(), "AES");
        } catch (Exception e4) {
            throw new RuntimeException("Deal with exceptions properly!", e4);
        }
    }

    public final void b(RpkEvent rpkEvent, RpkInfo rpkInfo) {
        T2.d.a("RpkEmitter", "rpk track: " + rpkEvent + "," + rpkInfo);
        IRpkStatsInterface iRpkStatsInterface = (IRpkStatsInterface) this.f2366d;
        if (iRpkStatsInterface != null) {
            try {
                iRpkStatsInterface.track(rpkEvent, rpkInfo);
            } catch (RemoteException e4) {
                e4.printStackTrace();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.airbnb.lottie.A d() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 338
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.c.d():com.airbnb.lottie.A");
    }

    public final n0 e(Class modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        String canonicalName = modelClass.getCanonicalName();
        if (canonicalName != null) {
            return f(modelClass, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(canonicalName));
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public final n0 f(Class modelClass, String key) {
        n0 viewModel;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        t0 t0Var = (t0) this.f2364b;
        t0Var.getClass();
        Intrinsics.checkNotNullParameter(key, "key");
        n0 viewModel2 = (n0) t0Var.f3982a.get(key);
        if (!modelClass.isInstance(viewModel2)) {
            C0534d c0534d = new C0534d((AbstractC0533c) this.f2366d);
            c0534d.b(o0.f3974b, key);
            try {
                viewModel = ((q0) this.f2365c).c(modelClass, c0534d);
            } catch (AbstractMethodError unused) {
                viewModel = ((q0) this.f2365c).a(modelClass);
            }
            t0 t0Var2 = (t0) this.f2364b;
            t0Var2.getClass();
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(viewModel, "viewModel");
            n0 n0Var = (n0) t0Var2.f3982a.put(key, viewModel);
            if (n0Var != null) {
                n0Var.onCleared();
            }
            return viewModel;
        }
        Object obj = (q0) this.f2365c;
        s0 s0Var = obj instanceof s0 ? (s0) obj : null;
        if (s0Var != null) {
            Intrinsics.checkNotNull(viewModel2);
            k0 k0Var = (k0) s0Var;
            Intrinsics.checkNotNullParameter(viewModel2, "viewModel");
            AbstractC0328z abstractC0328z = k0Var.f3962d;
            if (abstractC0328z != null) {
                C0631f c0631f = k0Var.f3963e;
                Intrinsics.checkNotNull(c0631f);
                Intrinsics.checkNotNull(abstractC0328z);
                h0.a(viewModel2, c0631f, abstractC0328z);
            }
        }
        Intrinsics.checkNotNull(viewModel2, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
        return viewModel2;
    }

    public final boolean g(int i4, boolean z4) {
        return ((TypedArray) this.f2365c).getBoolean(i4, z4);
    }

    public final ColorStateList h(int i4) {
        int resourceId;
        ColorStateList colorStateListX;
        return (!((TypedArray) this.f2365c).hasValue(i4) || (resourceId = ((TypedArray) this.f2365c).getResourceId(i4, 0)) == 0 || (colorStateListX = f.x(resourceId, (Context) this.f2364b)) == null) ? ((TypedArray) this.f2365c).getColorStateList(i4) : colorStateListX;
    }

    public final int i(int i4, int i5) {
        return ((TypedArray) this.f2365c).getDimensionPixelOffset(i4, i5);
    }

    public final int j(int i4, int i5) {
        return ((TypedArray) this.f2365c).getDimensionPixelSize(i4, i5);
    }

    @Override // androidx.core.widget.i
    public final void k(NestedScrollView nestedScrollView) {
        switch (this.f2363a) {
            case 1:
                C0185k.b(nestedScrollView, (View) this.f2364b, (View) this.f2365c);
                break;
            default:
                Z.s(nestedScrollView, (View) this.f2364b, (View) this.f2365c);
                break;
        }
    }

    public final Drawable l(int i4) {
        int resourceId;
        return (!((TypedArray) this.f2365c).hasValue(i4) || (resourceId = ((TypedArray) this.f2365c).getResourceId(i4, 0)) == 0) ? ((TypedArray) this.f2365c).getDrawable(i4) : I.o((Context) this.f2364b, resourceId);
    }

    public final Drawable m(int i4) {
        int resourceId;
        Drawable drawableF;
        if (!((TypedArray) this.f2365c).hasValue(i4) || (resourceId = ((TypedArray) this.f2365c).getResourceId(i4, 0)) == 0) {
            return null;
        }
        A a4 = A.a();
        Context context = (Context) this.f2364b;
        synchronized (a4) {
            drawableF = a4.f2723a.f(context, resourceId, true);
        }
        return drawableF;
    }

    public final float n(float f4, int i4) {
        return ((TypedArray) this.f2365c).getFloat(i4, f4);
    }

    public final Typeface o(int i4, int i5, W w4) {
        int resourceId = ((TypedArray) this.f2365c).getResourceId(i4, 0);
        if (resourceId == 0) {
            return null;
        }
        if (((TypedValue) this.f2366d) == null) {
            this.f2366d = new TypedValue();
        }
        Context context = (Context) this.f2364b;
        TypedValue typedValue = (TypedValue) this.f2366d;
        ThreadLocal threadLocal = o.f272a;
        if (context.isRestricted()) {
            return null;
        }
        return o.a(context, resourceId, typedValue, i5, w4, true, false);
    }

    @Override // G.b
    public final void onCancel() {
        ((Animator) this.f2364b).end();
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Animator from operation " + ((androidx.fragment.app.q0) this.f2365c) + " has been canceled.");
        }
    }

    public final int p(int i4, int i5) {
        return ((TypedArray) this.f2365c).getInt(i4, i5);
    }

    public final Location q(String str) {
        try {
            if (((LocationManager) this.f2365c).isProviderEnabled(str)) {
                return ((LocationManager) this.f2365c).getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e4) {
            Log.d("TwilightManager", "Failed to get last known location", e4);
            return null;
        }
    }

    public final int r(int i4, int i5) {
        return ((TypedArray) this.f2365c).getResourceId(i4, i5);
    }

    public final String s(int i4) {
        return ((TypedArray) this.f2365c).getString(i4);
    }

    public final ArrayList t(String str) {
        E eD = E.d(1, "SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?");
        if (str == null) {
            eD.bindNull(1);
        } else {
            eD.bindString(1, str);
        }
        ((androidx.room.A) this.f2364b).assertNotSuspendingTransaction();
        Cursor cursorH = J.H((androidx.room.A) this.f2364b, eD);
        try {
            ArrayList arrayList = new ArrayList(cursorH.getCount());
            while (cursorH.moveToNext()) {
                arrayList.add(cursorH.isNull(0) ? null : cursorH.getString(0));
            }
            return arrayList;
        } finally {
            cursorH.close();
            eD.e();
        }
    }

    public final String toString() {
        switch (this.f2363a) {
            case 5:
                String string = "[ ";
                if (((t.i) this.f2364b) != null) {
                    for (int i4 = 0; i4 < 9; i4++) {
                        StringBuilder sbS = g.s(string);
                        sbS.append(((t.i) this.f2364b).f15308h[i4]);
                        sbS.append(AwarenessDataItem.PERMISSION_SPLITTER);
                        string = sbS.toString();
                    }
                }
                StringBuilder sbV = g.v(string, "] ");
                sbV.append((t.i) this.f2364b);
                return sbV.toString();
            default:
                return super.toString();
        }
    }

    public final CharSequence u(int i4) {
        return ((TypedArray) this.f2365c).getText(i4);
    }

    public final boolean v(int i4) {
        return ((TypedArray) this.f2365c).hasValue(i4);
    }

    public final void w(String id, Set tags) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(tags, "tags");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(tags, "tags");
        Iterator it = tags.iterator();
        while (it.hasNext()) {
            v vVar = new v((String) it.next(), id);
            ((androidx.room.A) this.f2364b).assertNotSuspendingTransaction();
            ((androidx.room.A) this.f2364b).beginTransaction();
            try {
                ((k) this.f2365c).insert(vVar);
                ((androidx.room.A) this.f2364b).setTransactionSuccessful();
            } finally {
                ((androidx.room.A) this.f2364b).endTransaction();
            }
        }
    }

    public final boolean x(int i4, C0944d c0944d, C0968n c0968n) {
        C0956b c0956b = (C0956b) this.f2365c;
        int[] iArr = c0944d.f15580p0;
        c0956b.f15732a = iArr[0];
        c0956b.f15733b = iArr[1];
        c0956b.f15734c = c0944d.r();
        ((C0956b) this.f2365c).f15735d = c0944d.l();
        C0956b c0956b2 = (C0956b) this.f2365c;
        c0956b2.f15740i = false;
        c0956b2.f15741j = i4;
        boolean z4 = c0956b2.f15732a == 3;
        boolean z5 = c0956b2.f15733b == 3;
        boolean z6 = z4 && c0944d.f15545W > Property.DEFAULT_FLOAT_VALUE;
        boolean z7 = z5 && c0944d.f15545W > Property.DEFAULT_FLOAT_VALUE;
        int[] iArr2 = c0944d.f15584t;
        if (z6 && iArr2[0] == 4) {
            c0956b2.f15732a = 1;
        }
        if (z7 && iArr2[1] == 4) {
            c0956b2.f15733b = 1;
        }
        c0968n.b(c0944d, c0956b2);
        c0944d.P(((C0956b) this.f2365c).f15736e);
        c0944d.M(((C0956b) this.f2365c).f15737f);
        C0956b c0956b3 = (C0956b) this.f2365c;
        c0944d.f15528E = c0956b3.f15739h;
        c0944d.J(c0956b3.f15738g);
        C0956b c0956b4 = (C0956b) this.f2365c;
        c0956b4.f15741j = 0;
        return c0956b4.f15740i;
    }

    public final void z(EnumC0326x enumC0326x) {
        m0 m0Var = (m0) this.f2366d;
        if (m0Var != null) {
            m0Var.run();
        }
        m0 m0Var2 = new m0((androidx.lifecycle.I) this.f2364b, enumC0326x);
        this.f2366d = m0Var2;
        Handler handler = (Handler) this.f2365c;
        Intrinsics.checkNotNull(m0Var2);
        handler.postAtFrontOfQueue(m0Var2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(t0 store, q0 factory) {
        this(store, factory, 0);
        this.f2363a = 10;
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(factory, "factory");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public c(u0 owner) {
        q0 defaultViewModelProviderFactory;
        AbstractC0533c defaultViewModelCreationExtras;
        this.f2363a = 10;
        Intrinsics.checkNotNullParameter(owner, "owner");
        t0 viewModelStore = owner.getViewModelStore();
        Intrinsics.checkNotNullParameter(owner, "owner");
        boolean z4 = owner instanceof InterfaceC0321s;
        if (z4) {
            defaultViewModelProviderFactory = ((InterfaceC0321s) owner).getDefaultViewModelProviderFactory();
        } else {
            if (r0.f3981a == null) {
                r0.f3981a = new r0();
            }
            defaultViewModelProviderFactory = r0.f3981a;
            Intrinsics.checkNotNull(defaultViewModelProviderFactory);
        }
        Intrinsics.checkNotNullParameter(owner, "owner");
        if (z4) {
            defaultViewModelCreationExtras = ((InterfaceC0321s) owner).getDefaultViewModelCreationExtras();
        } else {
            defaultViewModelCreationExtras = C0531a.f12411b;
        }
        this(viewModelStore, defaultViewModelProviderFactory, defaultViewModelCreationExtras);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public c(u0 owner, g0 factory) {
        AbstractC0533c defaultViewModelCreationExtras;
        this.f2363a = 10;
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(factory, "factory");
        t0 viewModelStore = owner.getViewModelStore();
        Intrinsics.checkNotNullParameter(owner, "owner");
        if (owner instanceof InterfaceC0321s) {
            defaultViewModelCreationExtras = ((InterfaceC0321s) owner).getDefaultViewModelCreationExtras();
        } else {
            defaultViewModelCreationExtras = C0531a.f12411b;
        }
        this(viewModelStore, factory, defaultViewModelCreationExtras);
    }

    public /* synthetic */ c(Comparable comparable, Parcelable parcelable, ResultReceiver resultReceiver) {
        this.f2363a = 0;
        this.f2364b = comparable;
        this.f2365c = parcelable;
        this.f2366d = resultReceiver;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c() {
        this(20);
        this.f2363a = 20;
    }

    public c(Context context, RpkInfo rpkInfo) {
        this.f2363a = 21;
        this.f2364b = context;
        this.f2365c = rpkInfo;
        Intent intent = new Intent((Context) this.f2364b, (Class<?>) RpkUsageStatsService.class);
        com.stepos.statsrpk.b bVar = new com.stepos.statsrpk.b(this);
        boolean zBindService = ((Context) this.f2364b).bindService(intent, bVar, 1);
        T2.d.a("RpkEmitter", "bindService, " + bVar + " result: " + zBindService);
        if (zBindService) {
            synchronized (bVar) {
                try {
                    bVar.wait();
                } catch (InterruptedException e4) {
                    T2.d.f("RpkEmitter", "Exception:" + e4.toString() + " -Cause:" + e4.getCause());
                }
            }
        }
    }

    public c(com.google.android.gms.common.internal.service.a aVar, y0.e eVar) {
        this.f2363a = 15;
        this.f2364b = "ClientTelemetry.API";
        this.f2365c = aVar;
        this.f2366d = eVar;
    }

    public c(List list) {
        this.f2363a = 13;
        this.f2366d = list;
        this.f2364b = new ArrayList(list.size());
        this.f2365c = new ArrayList(list.size());
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((List) this.f2364b).add(((L0.g) list.get(i4)).f1179b.c());
            ((List) this.f2365c).add(((L0.g) list.get(i4)).f1180c.c());
        }
    }

    public c(G provider) {
        this.f2363a = 9;
        Intrinsics.checkNotNullParameter(provider, "provider");
        this.f2364b = new androidx.lifecycle.I(provider);
        this.f2365c = new Handler();
    }

    public c(androidx.room.A a4) {
        this.f2363a = 12;
        this.f2364b = a4;
        this.f2365c = new B0.b(this, a4, 6);
        this.f2366d = new j(this, a4, 2);
    }

    public c(t.g gVar, t.g gVar2) {
        this.f2363a = 5;
        this.f2366d = gVar;
        this.f2365c = gVar2;
    }

    public c(Context context, String str) {
        this.f2363a = 14;
        Context applicationContext = context.getApplicationContext();
        this.f2365c = applicationContext;
        this.f2364b = str;
        B0.c cVar = new B0.c();
        cVar.f136a = applicationContext.getApplicationContext();
        cVar.f137b = str;
        this.f2366d = cVar;
    }

    public c(t0 store, q0 factory, AbstractC0533c defaultCreationExtras) {
        this.f2363a = 10;
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(defaultCreationExtras, "defaultCreationExtras");
        this.f2364b = store;
        this.f2365c = factory;
        this.f2366d = defaultCreationExtras;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(t0 t0Var, q0 q0Var, int i4) {
        this(t0Var, q0Var, C0531a.f12411b);
        this.f2363a = 10;
    }

    public c(Context context, TypedArray typedArray) {
        this.f2363a = 4;
        this.f2364b = context;
        this.f2365c = typedArray;
    }

    public c(Context context, LocationManager locationManager) {
        this.f2363a = 2;
        this.f2366d = new K();
        this.f2364b = context;
        this.f2365c = locationManager;
    }

    public c(C0945e c0945e) {
        this.f2363a = 6;
        this.f2364b = new ArrayList();
        this.f2365c = new C0956b();
        this.f2366d = c0945e;
    }

    public c(int i4) {
        this.f2363a = i4;
        if (i4 != 11) {
            switch (i4) {
                case 18:
                    return;
                case 19:
                    this.f2365c = new LinkedList();
                    return;
                case 20:
                    this.f2364b = "com.stepos.statsapp.v3.simple_crypto_AES";
                    return;
                default:
                    this.f2364b = null;
                    this.f2365c = null;
                    this.f2366d = null;
                    throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
            }
        }
        this.f2364b = Collections.emptyList();
        this.f2365c = Collections.emptyList();
    }
}
