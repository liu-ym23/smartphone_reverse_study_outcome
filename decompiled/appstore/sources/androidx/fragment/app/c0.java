package androidx.fragment.app;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f3311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f3312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f3313c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public y f3314d;

    public c0() {
        this.f3311a = new ArrayList();
        this.f3312b = new HashMap();
        this.f3313c = new HashMap();
    }

    public void A(y r10) {
        this.f3314d = r10;
    }

    public Bundle B(String r10, Bundle r11) {
        if (r11 == null) goto L6;
        return (Bundle) this.f3313c.put(r10, r11);
    L6:
        return (Bundle) this.f3313c.remove(r10);
    }

    public void a(Fragment r10) {
        if (this.f3311a.contains(r10) == true) goto L14;
        ArrayList r11 = this.f3311a;
        monitor-enter(r11);
        this.f3311a.add(r10);     // Catch: Throwable -> L10
        monitor-exit(r11);     // Catch: Throwable -> L10
        r10.mAdded = true;
        return;
    L10:
        th = move-exception;
        throw th;
    L14:
        throw new IllegalStateException("Fragment already added: " + r10);
    }

    public void b() {
        this.f3312b.values().removeAll(Collections.singleton(null));
    }

    public boolean c(String r10) {
        if (this.f3312b.get(r10) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void d(int r10) {
        Iterator r11 = this.f3312b.values().iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        a0 r12 = (a0) r11.next();
        if (r12 == null) goto L4;
        r12.t(r10);
        goto L4
    }

    public void e(String r10, FileDescriptor r11, PrintWriter r12, String[] r13) {
        String r14 = r10 + "    ";
        if (this.f3312b.isEmpty() == true) goto L11;
        r12.print(r10);
        r12.println("Active Fragments:");
        Iterator r15 = this.f3312b.values().iterator();
    L6:
        if (r15.hasNext() == false) goto L11;
        a0 r16 = (a0) r15.next();
        r12.print(r10);
        if (r16 != null) goto L9;
        r12.println("null");
        goto L6
    L9:
        Fragment r17 = r16.k();
        r12.println(r17);
        r17.dump(r14, r11, r12, r13);
    L11:
        int r18 = this.f3311a.size();
        if (r18 <= 0) goto L16;
        r12.print(r10);
        r12.println("Added Fragments:");
        int r19 = 0;
    L14:
        if (r19 >= r18) goto L24;
        Fragment r20 = (Fragment) this.f3311a.get(r19);
        r12.print(r10);
        r12.print("  #");
        r12.print(r19);
        r12.print(": ");
        r12.println(r20.toString());
        r19 = r19 + 1;
        goto L14
    L24:
        return;
    }

    public Fragment f(String r10) {
        a0 r11 = (a0) this.f3312b.get(r10);
        if (r11 != null) goto L5;
        return null;
    L5:
        return r11.k();
    }

    public Fragment g(int r10) {
        int r11 = this.f3311a.size() - 1;
    L3:
        if (r11 < 0) goto L10;
        Fragment r12 = (Fragment) this.f3311a.get(r11);
        if (r12 == null) goto L9;
        if (r12.mFragmentId != r10) goto L9;
        return r12;
    L9:
        r11 = r11 - 1;
        goto L3
    L10:
        Iterator r13 = this.f3312b.values().iterator();
    L12:
        if (r13.hasNext() == false) goto L18;
        a0 r14 = (a0) r13.next();
        if (r14 == null) goto L12;
        Fragment r15 = r14.k();
        if (r15.mFragmentId != r10) goto L12;
        return r15;
    L18:
        return null;
    }

    public Fragment h(String r10) {
        if (r10 == null) goto L11;
        int r11 = this.f3311a.size() - 1;
    L4:
        if (r11 < 0) goto L11;
        Fragment r12 = (Fragment) this.f3311a.get(r11);
        if (r12 == null) goto L10;
        if (r10.equals(r12.mTag) == false) goto L10;
        return r12;
    L10:
        r11 = r11 - 1;
    L11:
        if (r10 == null) goto L20;
        Iterator r13 = this.f3312b.values().iterator();
    L14:
        if (r13.hasNext() == false) goto L32;
        a0 r14 = (a0) r13.next();
        if (r14 == null) goto L14;
        Fragment r15 = r14.k();
        if (r10.equals(r15.mTag) == false) goto L14;
        return r15;
    L32:
        return null;
    L20:
        return null;
    }

    public Fragment i(String r10) {
        Iterator r11 = this.f3312b.values().iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        a0 r12 = (a0) r11.next();
        if (r12 == null) goto L4;
        Fragment r13 = r12.k().findFragmentByWho(r10);
        if (r13 == null) goto L4;
        return r13;
    L10:
        return null;
    }

    public int j(Fragment r10) {
        ViewGroup r11 = r10.mContainer;
        if (r11 != null) goto L5;
        return -1;
    L5:
        int r12 = this.f3311a.indexOf(r10);
        int r13 = r12 - 1;
    L6:
        if (r13 < 0) goto L14;
        Fragment r14 = (Fragment) this.f3311a.get(r13);
        if (r14.mContainer != r11) goto L13;
        View r15 = r14.mView;
        if (r15 == null) goto L13;
        return r11.indexOfChild(r15) + 1;
    L13:
        r13 = r13 - 1;
    L14:
        r12 = r12 + 1;
        if (r12 >= this.f3311a.size()) goto L23;
        Fragment r16 = (Fragment) this.f3311a.get(r12);
        if (r16.mContainer != r11) goto L14;
        View r17 = r16.mView;
        if (r17 == null) goto L14;
        return r11.indexOfChild(r17);
    L23:
        return -1;
    }

    public List k() {
        ArrayList r10 = new ArrayList();
        Iterator r11 = this.f3312b.values().iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        a0 r12 = (a0) r11.next();
        if (r12 == null) goto L4;
        r10.add(r12);
        goto L4
    L8:
        return r10;
    }

    public List l() {
        ArrayList r10 = new ArrayList();
        Iterator r11 = this.f3312b.values().iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        a0 r12 = (a0) r11.next();
        if (r12 != null) goto L7;
        r10.add(null);
        goto L4
    L7:
        r10.add(r12.k());
        goto L4
    L9:
        return r10;
    }

    public HashMap m() {
        return this.f3313c;
    }

    public a0 n(String r10) {
        return (a0) this.f3312b.get(r10);
    }

    public List o() {
        if (this.f3311a.isEmpty() == true) goto L5;
        ArrayList r10 = this.f3311a;
        monitor-enter(r10);
        ArrayList r11 = new ArrayList(this.f3311a);     // Catch: Throwable -> L11
        monitor-exit(r10);     // Catch: Throwable -> L11
        return r11;
    L11:
        th = move-exception;
        throw th;
    L5:
        return Collections.emptyList();
    }

    public y p() {
        return this.f3314d;
    }

    public Bundle q(String r10) {
        return (Bundle) this.f3313c.get(r10);
    }

    public void r(a0 r10) {
        Fragment r11 = r10.k();
        if (c(r11.mWho) == false) goto L5;
        return;
    L5:
        this.f3312b.put(r11.mWho, r10);
        if (r11.mRetainInstanceChangedWhileDetached == false) goto L13;
        if (r11.mRetainInstance == false) goto L10;
        this.f3314d.f(r11);
    L11:
        r11.mRetainInstanceChangedWhileDetached = false;
        goto L13
    L10:
        this.f3314d.p(r11);
    L13:
        if (FragmentManager.L0(2) == false) goto L16;
        Log.v("FragmentManager", "Added fragment to active set " + r11);
        return;
    }

    public void s(a0 r10) {
        Fragment r11 = r10.k();
        if (r11.mRetainInstance == false) goto L6;
        this.f3314d.p(r11);
    L6:
        if (this.f3312b.get(r11.mWho) == r10) goto L9;
        return;
    L9:
        if (((a0) this.f3312b.put(r11.mWho, null)) != null) goto L12;
        return;
    L12:
        if (FragmentManager.L0(2) == false) goto L15;
        Log.v("FragmentManager", "Removed fragment from active set " + r11);
        return;
    }

    public void t() {
        Iterator r10 = this.f3311a.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        Fragment r11 = (Fragment) r10.next();
        a0 r12 = (a0) this.f3312b.get(r11.mWho);
        if (r12 == null) goto L4;
        r12.m();
        goto L4
    L8:
        Iterator r13 = this.f3312b.values().iterator();
    L10:
        if (r13.hasNext() == false) goto L23;
        a0 r14 = (a0) r13.next();
        if (r14 == null) goto L10;
        r14.m();
        Fragment r15 = r14.k();
        if (r15.mRemoving == false) goto L10;
        if (r15.isInBackStack() == true) goto L10;
        if (r15.mBeingSaved == true) goto L20;
    L22:
        s(r14);
        goto L10
    L20:
        if (this.f3313c.containsKey(r15.mWho) == true) goto L22;
        B(r15.mWho, r14.r());
        goto L22
    }

    public void u(Fragment r10) {
        ArrayList r11 = this.f3311a;
        monitor-enter(r11);
        this.f3311a.remove(r10);     // Catch: Throwable -> L8
        monitor-exit(r11);     // Catch: Throwable -> L8
        r10.mAdded = false;
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void v() {
        this.f3312b.clear();
    }

    public void w(List r10) {
        this.f3311a.clear();
        if (r10 == null) goto L15;
        Iterator r11 = r10.iterator();
    L6:
        if (r11.hasNext() == false) goto L20;
        String r12 = (String) r11.next();
        Fragment r13 = f(r12);
        if (r13 == null) goto L14;
        if (FragmentManager.L0(2) == false) goto L12;
        Log.v("FragmentManager", "restoreSaveState: added (" + r12 + "): " + r13);
    L12:
        a(r13);
        goto L6
    L14:
        throw new IllegalStateException("No instantiated fragment for (" + r12 + ")");
    L20:
        return;
    }

    public void x(HashMap r10) {
        this.f3313c.clear();
        this.f3313c.putAll(r10);
    }

    public ArrayList y() {
        ArrayList r10 = new ArrayList(this.f3312b.size());
        Iterator r11 = this.f3312b.values().iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        a0 r12 = (a0) r11.next();
        if (r12 == null) goto L4;
        Fragment r13 = r12.k();
        B(r13.mWho, r12.r());
        r10.add(r13.mWho);
        if (FragmentManager.L0(2) == false) goto L4;
        Log.v("FragmentManager", "Saved state of " + r13 + ": " + r13.mSavedFragmentState);
        goto L4
    L10:
        return r10;
    }

    public ArrayList z() {
        ArrayList r10 = this.f3311a;
        monitor-enter(r10);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.f3311a.isEmpty() == false) goto L11;
        monitor-exit(r10);     // Catch: Throwable -> L9
        return null;
    L11:
        ArrayList r11 = new ArrayList(this.f3311a.size());     // Catch: Throwable -> L9
        Iterator r12 = this.f3311a.iterator();     // Catch: Throwable -> L9
    L13:
        if (r12.hasNext() == false) goto L17;
        Fragment r13 = (Fragment) r12.next();     // Catch: Throwable -> L9
        r11.add(r13.mWho);     // Catch: Throwable -> L9
        if (FragmentManager.L0(2) == false) goto L13;
        Log.v("FragmentManager", "saveAllState: adding fragment (" + r13.mWho + "): " + r13);     // Catch: Throwable -> L9
        goto L13
    L17:
        monitor-exit(r10);     // Catch: Throwable -> L9
        return r11;
    }
}
