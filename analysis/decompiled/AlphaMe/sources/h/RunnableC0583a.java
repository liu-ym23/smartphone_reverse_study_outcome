package h;

import B0.g;
import K.S;
import Q.e;
import X.n;
import android.app.Application;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.os.SystemClock;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.C0195d;
import androidx.appcompat.widget.C0217o;
import androidx.appcompat.widget.C0229u0;
import androidx.appcompat.widget.SearchView$SearchAutoComplete;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.f;
import androidx.room.A;
import androidx.room.q;
import androidx.room.r;
import androidx.viewpager.widget.ViewPager;
import androidx.work.Worker;
import com.airbnb.lottie.C;
import com.airbnb.lottie.x;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.common.api.internal.p;
import com.google.android.gms.common.api.internal.s;
import com.google.android.gms.common.api.internal.zact;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import com.stepos.alphame.utils.Property;
import com.stepos.common.app.LibraryInitProvider;
import com.stepos.common.picker.WheelPicker;
import com.stepos.common.widget.CircularProgressButton;
import com.stepos.common.widget.DatePicker;
import com.stepos.common.widget.EmptyView;
import com.stepos.common.widget.F;
import com.stepos.common.widget.ScrollTextView;
import com.stepos.common.widget.SwimmingAnimationView;
import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Lock;
import k0.C0673a;
import k0.InterfaceC0674b;
import k0.j;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import stepos.support.v7.app.b0;
import stepos.support.v7.app.c0;

/* renamed from: h.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0583a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12685a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f12686b;

    public /* synthetic */ RunnableC0583a(int i4, Object obj) {
        this.f12685a = i4;
        this.f12686b = obj;
    }

    public final Set a() {
        r rVar = (r) this.f12686b;
        Set setCreateSetBuilder = SetsKt.createSetBuilder();
        Cursor cursorQuery$default = A.query$default(rVar.f4230a, new C0673a("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"), null, 2, null);
        try {
            Cursor cursor = cursorQuery$default;
            while (cursor.moveToNext()) {
                setCreateSetBuilder.add(Integer.valueOf(cursor.getInt(0)));
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(cursorQuery$default, null);
            Set setBuild = SetsKt.build(setCreateSetBuilder);
            if (!setBuild.isEmpty()) {
                if (((r) this.f12686b).f4237h == null) {
                    throw new IllegalStateException("Required value was null.".toString());
                }
                j jVar = ((r) this.f12686b).f4237h;
                if (jVar == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                jVar.executeUpdateDelete();
            }
            return setBuild;
        } finally {
        }
    }

    @Override // java.lang.Runnable
    public final void run() throws ClassNotFoundException {
        C0217o c0217o;
        Set setEmptySet;
        Object pVar;
        char c4 = 1;
        int i4 = 0;
        switch (this.f12685a) {
            case 0:
                AbstractC0585c abstractC0585c = (AbstractC0585c) this.f12686b;
                abstractC0585c.a(true);
                abstractC0585c.invalidateSelf();
                return;
            case 1:
                C0229u0 c0229u0 = (C0229u0) this.f12686b;
                c0229u0.f3182l = null;
                c0229u0.drawableStateChanged();
                return;
            case 2:
                SearchView$SearchAutoComplete searchView$SearchAutoComplete = (SearchView$SearchAutoComplete) this.f12686b;
                if (searchView$SearchAutoComplete.f2914f) {
                    ((InputMethodManager) searchView$SearchAutoComplete.getContext().getSystemService("input_method")).showSoftInput(searchView$SearchAutoComplete, 0);
                    searchView$SearchAutoComplete.f2914f = false;
                    return;
                }
                return;
            case 3:
                ActionMenuView actionMenuView = ((Toolbar) this.f12686b).f2984a;
                if (actionMenuView == null || (c0217o = actionMenuView.f2791t) == null) {
                    return;
                }
                c0217o.l();
                return;
            case 4:
                f fVar = (f) this.f12686b;
                if (fVar.f3380o) {
                    if (fVar.f3378m) {
                        fVar.f3378m = false;
                        androidx.core.widget.a aVar = fVar.f3366a;
                        aVar.getClass();
                        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                        aVar.f3360e = jCurrentAnimationTimeMillis;
                        aVar.f3362g = -1L;
                        aVar.f3361f = jCurrentAnimationTimeMillis;
                        aVar.f3363h = 0.5f;
                    }
                    androidx.core.widget.a aVar2 = fVar.f3366a;
                    if ((aVar2.f3362g > 0 && AnimationUtils.currentAnimationTimeMillis() > aVar2.f3362g + aVar2.f3364i) || !fVar.f()) {
                        fVar.f3380o = false;
                        return;
                    }
                    if (fVar.f3379n) {
                        fVar.f3379n = false;
                        long jUptimeMillis = SystemClock.uptimeMillis();
                        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, 0);
                        fVar.f3368c.onTouchEvent(motionEventObtain);
                        motionEventObtain.recycle();
                    }
                    if (aVar2.f3361f == 0) {
                        throw new RuntimeException("Cannot compute scroll delta before calling start()");
                    }
                    long jCurrentAnimationTimeMillis2 = AnimationUtils.currentAnimationTimeMillis();
                    float fA = aVar2.a(jCurrentAnimationTimeMillis2);
                    long j4 = jCurrentAnimationTimeMillis2 - aVar2.f3361f;
                    aVar2.f3361f = jCurrentAnimationTimeMillis2;
                    fVar.f3382q.scrollListBy((int) (j4 * ((fA * 4.0f) + ((-4.0f) * fA * fA)) * aVar2.f3359d));
                    View view = fVar.f3368c;
                    WeakHashMap weakHashMap = S.f939a;
                    view.postOnAnimation(this);
                    return;
                }
                return;
            case 5:
                ((e) this.f12686b).n(0);
                return;
            case 6:
                Lock closeLock$room_runtime_release = ((r) this.f12686b).f4230a.getCloseLock$room_runtime_release();
                closeLock$room_runtime_release.lock();
                try {
                    try {
                        try {
                        } catch (SQLiteException e4) {
                            Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e4);
                            setEmptySet = SetsKt.emptySet();
                        }
                    } catch (IllegalStateException e5) {
                        Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e5);
                        setEmptySet = SetsKt.emptySet();
                    }
                    if (((r) this.f12686b).a() && ((r) this.f12686b).f4235f.compareAndSet(true, false) && !((r) this.f12686b).f4230a.inTransaction()) {
                        InterfaceC0674b writableDatabase = ((r) this.f12686b).f4230a.getOpenHelper().getWritableDatabase();
                        writableDatabase.beginTransactionNonExclusive();
                        try {
                            setEmptySet = a();
                            writableDatabase.setTransactionSuccessful();
                            if (!setEmptySet.isEmpty()) {
                                r rVar = (r) this.f12686b;
                                synchronized (rVar.f4239j) {
                                    try {
                                        Iterator it = rVar.f4239j.iterator();
                                        while (true) {
                                            m.e eVar = (m.e) it;
                                            if (eVar.hasNext()) {
                                                ((q) ((Map.Entry) eVar.next()).getValue()).a(setEmptySet);
                                            } else {
                                                Unit unit = Unit.INSTANCE;
                                            }
                                        }
                                    } catch (Throwable th) {
                                        throw th;
                                    }
                                }
                                return;
                            }
                            return;
                        } finally {
                            writableDatabase.endTransaction();
                        }
                    }
                    return;
                } finally {
                    closeLock$room_runtime_release.unlock();
                    ((r) this.f12686b).getClass();
                }
            case 7:
                ((ViewPager) this.f12686b).setScrollState(0);
                return;
            case 8:
                Object obj = this.f12686b;
                try {
                    ((Worker) obj).f4311a.j(((Worker) obj).a());
                    return;
                } catch (Throwable th2) {
                    ((Worker) obj).f4311a.k(th2);
                    return;
                }
            case 9:
                if (((C) this.f12686b).f4529f == null || ((C) this.f12686b).f4528e.isCancelled()) {
                    return;
                }
                com.airbnb.lottie.A a4 = ((C) this.f12686b).f4529f;
                Object obj2 = a4.f4519a;
                if (obj2 != null) {
                    C c5 = (C) this.f12686b;
                    c5.getClass();
                    Iterator it2 = new ArrayList(c5.f4525b).iterator();
                    while (it2.hasNext()) {
                        ((x) it2.next()).a(obj2);
                    }
                    return;
                }
                C c6 = (C) this.f12686b;
                Throwable th3 = a4.f4520b;
                c6.getClass();
                ArrayList arrayList = new ArrayList(c6.f4526c);
                if (arrayList.isEmpty()) {
                    Log.w("LOTTIE", "Lottie encountered an error but no failure listener was added.", th3);
                    return;
                }
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    ((x) it3.next()).a(th3);
                }
                return;
            case 10:
                ((com.google.android.gms.common.api.internal.q) this.f12686b).e();
                return;
            case 11:
                com.google.android.gms.common.internal.e eVar2 = ((com.google.android.gms.common.api.internal.q) ((p) this.f12686b).f9664b).f9666b;
                eVar2.c(eVar2.getClass().getName().concat(" disconnecting because it was signed out."));
                return;
            case 12:
                ((s) ((zact) this.f12686b).zah).c(new ConnectionResult(4));
                return;
            case 13:
                k kVar = (k) this.f12686b;
                kVar.f9657c = false;
                e eVar3 = ((BottomSheetBehavior) kVar.f9656b).f10420O;
                if (eVar3 != null && eVar3.f()) {
                    kVar.a(kVar.f9658d);
                    return;
                }
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) kVar.f9656b;
                if (bottomSheetBehavior.f10419N == 2) {
                    bottomSheetBehavior.n(kVar.f9658d);
                    return;
                }
                return;
            case 14:
                CheckableImageButton checkableImageButton = ((TextInputLayout) this.f12686b).f10954c.f11041g;
                checkableImageButton.performClick();
                checkableImageButton.jumpDrawablesToCurrentState();
                return;
            case 15:
                try {
                    Class.forName("com.meizu.nightmode.MzHighContrastManager");
                    Log.i("[LibraryInitProvider]", "start init");
                    Application application = (Application) ((LibraryInitProvider) this.f12686b).getContext().getApplicationContext();
                    if (application == null || B0.e.f140d != null) {
                        StringBuilder sb = new StringBuilder("init return application is null :");
                        sb.append(application == null);
                        Log.i("HighContrast_Common", sb.toString());
                        return;
                    } else {
                        B0.e.f140d = new B0.e(application);
                        Log.i("HighContrast_Common", "sInstance init success");
                        new Thread(new n(c4 == true ? 1 : 0)).start();
                        return;
                    }
                } catch (Exception unused) {
                    Log.i("[LibraryInitProvider]", "not Support high contrast");
                    return;
                }
            case 16:
                com.stepos.common.picker.k kVar2 = (com.stepos.common.picker.k) this.f12686b;
                if (kVar2.f11382d) {
                    if (SystemClock.uptimeMillis() - kVar2.f11387i <= kVar2.f11386h) {
                        Log.w("SoundPoolHelper", "play so fast, has filter this time.");
                        return;
                    }
                    kVar2.f11387i = SystemClock.uptimeMillis();
                    Log.i("SoundPoolHelper", "play sound pool result:" + kVar2.f11381c.play(kVar2.f11383e, 1.0f, 1.0f, 0, 0, 1.0f));
                    return;
                }
                return;
            case 17:
                WheelPicker wheelPicker = (WheelPicker) this.f12686b;
                wheelPicker.requestLayout();
                int i5 = WheelPicker.f11342z;
                wheelPicker.b();
                wheelPicker.c();
                return;
            case 18:
                ((CircularProgressButton) this.f12686b).invalidate();
                return;
            case 19:
                ScrollTextView scrollTextView = ((DatePicker) this.f12686b).f11541g;
                if (scrollTextView != null) {
                    scrollTextView.getLayoutDirection();
                    return;
                }
                return;
            case 20:
                ((EmptyView) ((A.e) this.f12686b).f24b).f11609d.setMovementMethod(LinkMovementMethod.getInstance());
                return;
            case 21:
                ((com.stepos.common.widget.s) this.f12686b).f11966b.f11723j.dismiss();
                return;
            case 22:
                F f4 = (F) this.f12686b;
                if (f4.f11623d) {
                    f4.f11622c.play(f4.f11624e, 0.5f, 0.5f, 0, 0, 1.0f);
                    return;
                }
                return;
            case 23:
                ((SwimmingAnimationView) ((C0195d) this.f12686b).f3075b).f11828h.start();
                return;
            case 24:
                Object obj3 = this.f12686b;
                com.stepos.statsapp.v3.lib.plugin.emitter.remote.e eVar4 = (com.stepos.statsapp.v3.lib.plugin.emitter.remote.e) obj3;
                if (eVar4.f12331f.f1791a.getAll().size() >= 500) {
                    T2.d.a("V3OfflineEmitter", "Sp data more than 500, into the clear.");
                    eVar4.f12331f.f1791a.edit().clear().commit();
                }
                Log.d("V3OfflineEmitter", "init thread:" + Thread.currentThread().getName());
                Iterator<Map.Entry<String, ?>> it4 = eVar4.f12331f.f1791a.getAll().entrySet().iterator();
                while (it4.hasNext()) {
                    String key = it4.next().getKey();
                    try {
                        long j5 = Integer.parseInt(key);
                        if (((com.stepos.statsapp.v3.lib.plugin.emitter.remote.e) obj3).f12332g < j5) {
                            ((com.stepos.statsapp.v3.lib.plugin.emitter.remote.e) obj3).f12332g = j5;
                        }
                    } catch (Exception e6) {
                        T2.d.b("V3OfflineEmitter", e6.getMessage());
                        eVar4.f12331f.f1791a.edit().remove(key).apply();
                    }
                }
                return;
            case 25:
                StringBuilder sb2 = new StringBuilder("clean sessionId: ");
                com.stepos.statsrpk.f fVar2 = (com.stepos.statsrpk.f) this.f12686b;
                sb2.append(fVar2.f12372c);
                T2.d.a("RpkPageController", sb2.toString());
                fVar2.f12372c = null;
                return;
            case 26:
                g.y(this.f12686b);
                int i6 = W2.f.f2028b;
                throw null;
            case 27:
                A3.a aVar3 = (A3.a) this.f12686b;
                ConcurrentLinkedQueue concurrentLinkedQueue = aVar3.f72c;
                if (concurrentLinkedQueue.isEmpty()) {
                    return;
                }
                long jNanoTime = System.nanoTime();
                Iterator it5 = concurrentLinkedQueue.iterator();
                while (it5.hasNext()) {
                    A3.c cVar = (A3.c) it5.next();
                    if (cVar.f81i > jNanoTime) {
                        return;
                    }
                    if (concurrentLinkedQueue.remove(cVar)) {
                        aVar3.f73d.d(cVar);
                    }
                }
                return;
            case 28:
                B3.b bVar = (B3.b) this.f12686b;
                int size = bVar.f218a.size();
                if (size >= bVar.f219b) {
                    int i7 = bVar.f220c;
                    if (size > i7) {
                        int i8 = size - i7;
                        while (i4 < i8) {
                            bVar.f218a.poll();
                            i4++;
                        }
                        return;
                    }
                    return;
                }
                int i9 = bVar.f220c - size;
                while (i4 < i9) {
                    AbstractQueue abstractQueue = bVar.f218a;
                    switch (((B3.e) bVar).f225f) {
                        case 0:
                            pVar = new rx.internal.util.unsafe.p(B3.f.f227b);
                            break;
                        default:
                            pVar = new rx.internal.util.unsafe.j(B3.f.f227b);
                            break;
                    }
                    abstractQueue.add(pVar);
                    i4++;
                }
                return;
            default:
                c0 c0Var = (c0) this.f12686b;
                Menu menuW = c0Var.w();
                L3.k kVar3 = menuW instanceof L3.k ? (L3.k) menuW : null;
                if (kVar3 != null) {
                    kVar3.v();
                }
                try {
                    menuW.clear();
                    b0 b0Var = c0Var.f14440c;
                    if (!b0Var.f14435a.onCreatePanelMenu(0, menuW) || !b0Var.onPreparePanel(0, null, menuW)) {
                        menuW.clear();
                    }
                    if (kVar3 != null) {
                        return;
                    } else {
                        return;
                    }
                } finally {
                    if (kVar3 != null) {
                        kVar3.u();
                    }
                }
        }
    }
}
