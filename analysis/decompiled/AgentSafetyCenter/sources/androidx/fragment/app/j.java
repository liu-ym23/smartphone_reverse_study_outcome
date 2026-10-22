package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.SharedElementCallback;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import androidx.activity.f0;
import androidx.lifecycle.c1;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.invoke.VarHandle;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import p.q0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class j extends androidx.activity.p {
    static final String LIFECYCLE_TAG = "android:support:lifecycle";
    boolean mCreated;
    final androidx.lifecycle.z mFragmentLifecycleRegistry;
    final l mFragments;
    boolean mResumed;
    boolean mStopped;

    public j() {
        i iVar = new i();
        iVar.f1286h = this;
        Handler handler = new Handler();
        v vVar = new v();
        vVar.f1305a = new ArrayList();
        a0 a0Var = new a0();
        a0Var.f1248a = new ArrayList();
        a0Var.f1249b = new HashMap();
        a0Var.f1250c = new HashMap();
        VarHandle.storeStoreFence();
        vVar.f1307c = a0Var;
        m mVar = new m();
        mVar.f1292c = vVar;
        VarHandle.storeStoreFence();
        vVar.f1309e = mVar;
        vVar.f1311g = new f0(vVar);
        vVar.f1312h = new AtomicInteger();
        vVar.i = Collections.synchronizedMap(new HashMap());
        vVar.f1313j = Collections.synchronizedMap(new HashMap());
        Collections.synchronizedMap(new HashMap());
        new CopyOnWriteArrayList();
        vVar.f1314k = new CopyOnWriteArrayList();
        int i = 0;
        n nVar = new n(i);
        nVar.f1294b = vVar;
        VarHandle.storeStoreFence();
        vVar.f1315l = nVar;
        n nVar2 = new n(1);
        nVar2.f1294b = vVar;
        VarHandle.storeStoreFence();
        vVar.f1316m = nVar2;
        n nVar3 = new n(2);
        nVar3.f1294b = vVar;
        VarHandle.storeStoreFence();
        vVar.f1317n = nVar3;
        n nVar4 = new n(3);
        nVar4.f1294b = vVar;
        VarHandle.storeStoreFence();
        vVar.f1318o = nVar4;
        p pVar = new p();
        pVar.f1297a = vVar;
        VarHandle.storeStoreFence();
        vVar.f1319p = pVar;
        vVar.f1320q = -1;
        q qVar = new q();
        qVar.f1299a = vVar;
        VarHandle.storeStoreFence();
        vVar.f1323t = qVar;
        vVar.f1327x = new ArrayDeque();
        r rVar = new r(i);
        rVar.f1301f = vVar;
        VarHandle.storeStoreFence();
        vVar.F = rVar;
        iVar.f1285g = vVar;
        iVar.f1283c = this;
        iVar.f1284f = handler;
        VarHandle.storeStoreFence();
        l lVar = new l();
        lVar.f1291a = iVar;
        VarHandle.storeStoreFence();
        this.mFragments = lVar;
        this.mFragmentLifecycleRegistry = new androidx.lifecycle.z(this, true);
        this.mStopped = true;
        t4.d savedStateRegistry = getSavedStateRegistry();
        f fVar = new f(i);
        fVar.f1279b = this;
        VarHandle.storeStoreFence();
        savedStateRegistry.c(LIFECYCLE_TAG, fVar);
        g gVar = new g(0);
        gVar.f1281b = this;
        VarHandle.storeStoreFence();
        addOnConfigurationChangedListener(gVar);
        g gVar2 = new g(1);
        gVar2.f1281b = this;
        VarHandle.storeStoreFence();
        addOnNewIntentListener(gVar2);
        h hVar = new h();
        hVar.f1282a = this;
        VarHandle.storeStoreFence();
        addOnContextAvailableListener(hVar);
    }

    public final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mFragments.f1291a.f1285g.f1309e.onCreateView(view, str, context, attributeSet);
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (shouldDumpInternalState(strArr)) {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            String str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.mCreated);
            printWriter.print(" mResumed=");
            printWriter.print(this.mResumed);
            printWriter.print(" mStopped=");
            printWriter.print(this.mStopped);
            if (getApplication() != null) {
                q0 q0Var = k4.a.a(this).f7242b.f7240b;
                if (q0Var.f9616g > 0) {
                    printWriter.print(str2);
                    printWriter.println("Loaders:");
                    if (q0Var.f9616g > 0) {
                        if (q0Var.d(0) != null) {
                            od.f.j();
                            return;
                        }
                        printWriter.print(str2);
                        printWriter.print("  #");
                        printWriter.print(q0Var.f9614c[0]);
                        printWriter.print(": ");
                        throw null;
                    }
                }
            }
            v vVar = this.mFragments.f1291a.f1285g;
            vVar.getClass();
            String strN = k0.a.n(str, "    ");
            a0 a0Var = vVar.f1307c;
            ArrayList arrayList = a0Var.f1248a;
            HashMap map = a0Var.f1249b;
            if (!map.isEmpty()) {
                printWriter.print(str);
                printWriter.println("Active Fragments:");
                Iterator it = map.values().iterator();
                while (it.hasNext()) {
                    if (it.next() != null) {
                        od.f.j();
                        return;
                    } else {
                        printWriter.print(str);
                        printWriter.println("null");
                    }
                }
            }
            int size2 = arrayList.size();
            if (size2 > 0) {
                printWriter.print(str);
                printWriter.println("Added Fragments:");
                if (size2 > 0) {
                    if (arrayList.get(0) != null) {
                        od.f.j();
                        return;
                    }
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(0);
                    printWriter.print(": ");
                    throw null;
                }
            }
            ArrayList arrayList2 = vVar.f1308d;
            if (arrayList2 != null && (size = arrayList2.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack:");
                for (int i = 0; i < size; i++) {
                    a aVar = (a) vVar.f1308d.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(aVar.toString());
                    aVar.b(strN, printWriter, true);
                }
            }
            printWriter.print(str);
            printWriter.println("Back Stack Index: " + vVar.f1312h.get());
            synchronized (vVar.f1305a) {
                try {
                    int size3 = vVar.f1305a.size();
                    if (size3 > 0) {
                        printWriter.print(str);
                        printWriter.println("Pending Actions:");
                        for (int i3 = 0; i3 < size3; i3++) {
                            a aVar2 = (a) vVar.f1305a.get(i3);
                            printWriter.print(str);
                            printWriter.print("  #");
                            printWriter.print(i3);
                            printWriter.print(": ");
                            printWriter.println(aVar2);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            printWriter.print(str);
            printWriter.println("FragmentManager misc state:");
            printWriter.print(str);
            printWriter.print("  mHost=");
            printWriter.println(vVar.f1321r);
            printWriter.print(str);
            printWriter.print("  mContainer=");
            printWriter.println(vVar.f1322s);
            printWriter.print(str);
            printWriter.print("  mCurState=");
            printWriter.print(vVar.f1320q);
            printWriter.print(" mStateSaved=");
            printWriter.print(vVar.f1328y);
            printWriter.print(" mStopped=");
            printWriter.print(vVar.f1329z);
            printWriter.print(" mDestroyed=");
            printWriter.println(vVar.A);
        }
    }

    public u getSupportFragmentManager() {
        return this.mFragments.f1291a.f1285g;
    }

    @Deprecated
    public k4.a getSupportLoaderManager() {
        return k4.a.a(this);
    }

    public void markFragmentsCreated() {
        u supportFragmentManager = getSupportFragmentManager();
        androidx.lifecycle.p pVar = androidx.lifecycle.p.f1418c;
        Iterator it = supportFragmentManager.f1307c.c().iterator();
        while (it.hasNext()) {
            if (it.next() != null) {
                od.f.j();
                return;
            }
        }
    }

    @Override // androidx.activity.p, android.app.Activity
    public void onActivityResult(int i, int i3, Intent intent) {
        this.mFragments.a();
        super.onActivityResult(i, i3, intent);
    }

    @Override // androidx.activity.p, d3.c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mFragmentLifecycleRegistry.f(androidx.lifecycle.o.ON_CREATE);
        v vVar = this.mFragments.f1291a.f1285g;
        vVar.f1328y = false;
        vVar.f1329z = false;
        vVar.E.getClass();
        vVar.c(1);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View viewDispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(null, str, context, attributeSet);
        return viewDispatchFragmentsOnCreateView == null ? super.onCreateView(str, context, attributeSet) : viewDispatchFragmentsOnCreateView;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        v vVar = this.mFragments.f1291a.f1285g;
        boolean zIsChangingConfigurations = true;
        vVar.A = true;
        vVar.e(true);
        Iterator it = vVar.b().iterator();
        if (it.hasNext()) {
            ((d0) it.next()).a();
            throw null;
        }
        a0 a0Var = vVar.f1307c;
        i iVar = vVar.f1321r;
        if (iVar != null) {
            zIsChangingConfigurations = a0Var.f1251d.f1342e;
        } else {
            j jVar = iVar.f1283c;
            if (jVar != null) {
                zIsChangingConfigurations = true ^ jVar.isChangingConfigurations();
            }
        }
        if (zIsChangingConfigurations) {
            Iterator it2 = vVar.i.values().iterator();
            while (it2.hasNext()) {
                ArrayList arrayList = ((c) it2.next()).f1273c;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    String str = (String) obj;
                    y yVar = a0Var.f1251d;
                    yVar.getClass();
                    if (u.h(3)) {
                        Log.d("FragmentManager", "Clearing non-config state for saved state of Fragment " + str);
                    }
                    HashMap map = yVar.f1341d;
                    HashMap map2 = yVar.f1340c;
                    y yVar2 = (y) map2.get(str);
                    if (yVar2 != null) {
                        yVar2.d();
                        map2.remove(str);
                    }
                    c1 c1Var = (c1) map.get(str);
                    if (c1Var != null) {
                        c1Var.a();
                        map.remove(str);
                    }
                }
            }
        }
        vVar.c(-1);
        i iVar2 = vVar.f1321r;
        if (iVar2 != null) {
            iVar2.f1286h.removeOnTrimMemoryListener(vVar.f1316m);
        }
        i iVar3 = vVar.f1321r;
        if (iVar3 != null) {
            iVar3.f1286h.removeOnConfigurationChangedListener(vVar.f1315l);
        }
        i iVar4 = vVar.f1321r;
        if (iVar4 != null) {
            iVar4.f1286h.removeOnMultiWindowModeChangedListener(vVar.f1317n);
        }
        i iVar5 = vVar.f1321r;
        if (iVar5 != null) {
            iVar5.f1286h.removeOnPictureInPictureModeChangedListener(vVar.f1318o);
        }
        i iVar6 = vVar.f1321r;
        if (iVar6 != null) {
            iVar6.f1286h.removeMenuProvider(vVar.f1319p);
        }
        vVar.f1321r = null;
        vVar.f1322s = null;
        if (vVar.f1310f != null) {
            Iterator it3 = vVar.f1311g.f700b.iterator();
            while (it3.hasNext()) {
                ((androidx.activity.d) it3.next()).cancel();
            }
            vVar.f1310f = null;
        }
        d.e eVar = vVar.f1324u;
        if (eVar != null) {
            eVar.b();
            vVar.f1325v.b();
            vVar.f1326w.b();
        }
        this.mFragmentLifecycleRegistry.f(androidx.lifecycle.o.ON_DESTROY);
    }

    @Override // androidx.activity.p, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i != 6) {
            return false;
        }
        v vVar = this.mFragments.f1291a.f1285g;
        if (vVar.f1320q < 1) {
            return false;
        }
        Iterator it = vVar.f1307c.c().iterator();
        while (it.hasNext()) {
            if (it.next() != null) {
                od.f.j();
                return false;
            }
        }
        return false;
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.f1291a.f1285g.c(5);
        this.mFragmentLifecycleRegistry.f(androidx.lifecycle.o.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    @Override // androidx.activity.p, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.mFragments.a();
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onResume() {
        this.mFragments.a();
        super.onResume();
        this.mResumed = true;
        this.mFragments.f1291a.f1285g.e(true);
    }

    public void onResumeFragments() {
        this.mFragmentLifecycleRegistry.f(androidx.lifecycle.o.ON_RESUME);
        v vVar = this.mFragments.f1291a.f1285g;
        vVar.f1328y = false;
        vVar.f1329z = false;
        vVar.E.getClass();
        vVar.c(7);
    }

    @Override // android.app.Activity
    public void onStart() {
        this.mFragments.a();
        super.onStart();
        this.mStopped = false;
        if (!this.mCreated) {
            this.mCreated = true;
            v vVar = this.mFragments.f1291a.f1285g;
            vVar.f1328y = false;
            vVar.f1329z = false;
            vVar.E.getClass();
            vVar.c(4);
        }
        this.mFragments.f1291a.f1285g.e(true);
        this.mFragmentLifecycleRegistry.f(androidx.lifecycle.o.ON_START);
        v vVar2 = this.mFragments.f1291a.f1285g;
        vVar2.f1328y = false;
        vVar2.f1329z = false;
        vVar2.E.getClass();
        vVar2.c(5);
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.mFragments.a();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        v vVar = this.mFragments.f1291a.f1285g;
        vVar.f1329z = true;
        vVar.E.getClass();
        vVar.c(4);
        this.mFragmentLifecycleRegistry.f(androidx.lifecycle.o.ON_STOP);
    }

    public void setEnterSharedElementCallback(d3.g gVar) {
        setEnterSharedElementCallback((SharedElementCallback) null);
    }

    public void setExitSharedElementCallback(d3.g gVar) {
        setExitSharedElementCallback((SharedElementCallback) null);
    }

    public void startActivityFromFragment(e eVar, @SuppressLint({"UnknownNullness"}) Intent intent, int i, Bundle bundle) {
        if (i != -1) {
            throw null;
        }
        startActivityForResult(intent, -1, bundle);
    }

    @Deprecated
    public void startIntentSenderFromFragment(e eVar, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i3, int i10, int i11, Bundle bundle) throws IntentSender.SendIntentException {
        if (i != -1) {
            throw null;
        }
        startIntentSenderForResult(intentSender, i, intent, i3, i10, i11, bundle);
    }

    public void supportPostponeEnterTransition() {
        postponeEnterTransition();
    }

    public void supportStartPostponedEnterTransition() {
        startPostponedEnterTransition();
    }

    public void startActivityFromFragment(e eVar, @SuppressLint({"UnknownNullness"}) Intent intent, int i) {
        startActivityFromFragment(eVar, intent, i, (Bundle) null);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View viewDispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view, str, context, attributeSet);
        return viewDispatchFragmentsOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : viewDispatchFragmentsOnCreateView;
    }

    @Deprecated
    public void onAttachFragment(e eVar) {
    }

    @Deprecated
    public final void validateRequestPermissionsRequestCode(int i) {
    }
}
