package androidx.fragment.app;

import android.util.Log;
import android.view.ViewGroup;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: FragmentStore.java */
/* JADX INFO: loaded from: classes.dex */
class l {
    private static final String TAG = "FragmentManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<Fragment> f1821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashMap<String, k> f1822b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private h f1823c;

    l() {
        this.f1821a = new ArrayList();
        this.f1822b = new HashMap();
    }

    void a(h r1) {
        this.f1823c = r1;
    }

    h a() {
        return this.f1823c;
    }

    void b() {
        this.f1822b.clear();
    }

    void a(List<String> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        this.f1821a.clear();
        if (r7 == null) goto L15;
        Iterator r8 = r7.iterator();
    L6:
        if (r8.hasNext() == false) goto L20;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.aiagent.plugin");
        Fragment r2 = e(r0);
        if (r2 == null) goto L14;
        if (FragmentManager.a(2) == false) goto L12;
        a(TAG, "restoreSaveState: added (" + r0 + "): " + r2);
    L12:
        a(r2);
        goto L6
    L14:
        throw new IllegalStateException("No instantiated fragment for (" + r0 + ")");
    L20:
        return;
    }

    void a(k r4) {
        Fragment r0 = r4.a();
        if (b(r0.mWho) == false) goto L5;
        return;
    L5:
        this.f1822b.put(r0.mWho, r4);
        if (r0.mRetainInstanceChangedWhileDetached == false) goto L13;
        if (r0.mRetainInstance == false) goto L10;
        this.f1823c.a(r0);
    L11:
        r0.mRetainInstanceChangedWhileDetached = false;
        goto L13
    L10:
        this.f1823c.c(r0);
    L13:
        if (FragmentManager.a(2) == false) goto L16;
        a(TAG, "Added fragment to active set " + r0);
        return;
    }

    void a(Fragment r3) {
        if (this.f1821a.contains(r3) == true) goto L14;
        ArrayList<Fragment> r0 = this.f1821a;
        monitor-enter(r0);
        this.f1821a.add(r3);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        r3.mAdded = true;
        return;
    L10:
        th = move-exception;
        throw th;
    L14:
        throw new IllegalStateException("Fragment already added: " + r3);
    }

    void a(int r4) {
        Iterator<k> r3 = this.f1822b.values().iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        k r0 = (k) ZeusTransformUtils.preCheckCast(r3.next(), k.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L4;
        r0.a(r4);
        goto L4
    }

    void c() {
        Iterator<Fragment> r0 = this.f1821a.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Fragment r1 = (Fragment) ZeusTransformUtils.preCheckCast(r0.next(), Fragment.class, "com.obric.aiagent.plugin");
        k r2 = (k) ZeusTransformUtils.preCheckCast(this.f1822b.get(r1.mWho), k.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L4;
        r2.c();
        goto L4
    L8:
        Iterator<k> r3 = this.f1822b.values().iterator();
    L10:
        if (r3.hasNext() == false) goto L21;
        k r4 = (k) ZeusTransformUtils.preCheckCast(r3.next(), k.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L10;
        r4.c();
        Fragment r5 = r4.a();
        if (r5.mRemoving == true) goto L16;
    L18:
        boolean r6 = false;
    L19:
        if (r6 == false) goto L10;
        b(r4);
        goto L10
    L16:
        if (r5.isInBackStack() == true) goto L18;
        r6 = true;
        goto L19
    }

    void b(Fragment r2) {
        ArrayList<Fragment> r0 = this.f1821a;
        monitor-enter(r0);
        this.f1821a.remove(r2);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        r2.mAdded = false;
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void b(k r3) {
        Fragment r4 = r3.a();
        if (r4.mRetainInstance == false) goto L6;
        this.f1823c.c(r4);
    L6:
        if (((k) ZeusTransformUtils.preCheckCast(this.f1822b.put(r4.mWho, null), k.class, "com.obric.aiagent.plugin")) != null) goto L9;
        return;
    L9:
        if (FragmentManager.a(2) == false) goto L12;
        a(TAG, "Removed fragment from active set " + r4);
        return;
    }

    void d() {
        this.f1822b.values().removeAll(Collections.singleton(null));
    }

    ArrayList<FragmentState> e() {
        ArrayList<FragmentState> r0 = new ArrayList(this.f1822b.size());
        Iterator<k> r5 = this.f1822b.values().iterator();
    L4:
        if (r5.hasNext() == false) goto L10;
        k r1 = (k) ZeusTransformUtils.preCheckCast(r5.next(), k.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L4;
        Fragment r2 = r1.a();
        FragmentState r3 = r1.m();
        r0.add(r3);
        if (FragmentManager.a(2) == false) goto L4;
        a(TAG, "Saved state of " + r2 + ": " + r3.mSavedFragmentState);
        goto L4
    L10:
        return r0;
    }

    ArrayList<String> f() {
        ArrayList<Fragment> r0 = this.f1821a;
        monitor-enter(r0);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (this.f1821a.isEmpty() == true) goto L7;
        ArrayList<String> r1 = new ArrayList(this.f1821a.size());     // Catch: Throwable -> L17
        Iterator<Fragment> r6 = this.f1821a.iterator();     // Catch: Throwable -> L17
    L11:
        if (r6.hasNext() == false) goto L15;
        Fragment r2 = (Fragment) ZeusTransformUtils.preCheckCast(r6.next(), Fragment.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        r1.add(r2.mWho);     // Catch: Throwable -> L17
        if (FragmentManager.a(2) == false) goto L11;
        a(TAG, "saveAllState: adding fragment (" + r2.mWho + "): " + r2);     // Catch: Throwable -> L17
        goto L11
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L17
        return r1;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L17
        return null;
    }

    List<k> g() {
        ArrayList r0 = new ArrayList();
        Iterator<k> r4 = this.f1822b.values().iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        k r1 = (k) ZeusTransformUtils.preCheckCast(r4.next(), k.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L4;
        r0.add(r1);
        goto L4
    L8:
        return r0;
    }

    List<Fragment> h() {
        if (this.f1821a.isEmpty() == true) goto L5;
        ArrayList<Fragment> r0 = this.f1821a;
        monitor-enter(r0);
        ArrayList r1 = new ArrayList(this.f1821a);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r1;
    L11:
        th = move-exception;
        throw th;
    L5:
        return Collections.emptyList();
    }

    List<Fragment> i() {
        ArrayList r0 = new ArrayList();
        Iterator<k> r4 = this.f1822b.values().iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        k r1 = (k) ZeusTransformUtils.preCheckCast(r4.next(), k.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L7;
        r0.add(null);
        goto L4
    L7:
        r0.add(r1.a());
        goto L4
    L9:
        return r0;
    }

    Fragment b(int r5) {
        int r0 = this.f1821a.size();
    L3:
        r0 = r0 - 1;
        if (r0 < 0) goto L11;
        Fragment r1 = (Fragment) ZeusTransformUtils.preCheckCast(this.f1821a.get(r0), Fragment.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L3;
        if (r1.mFragmentId != r5) goto L3;
        return r1;
    L11:
        Iterator<k> r4 = this.f1822b.values().iterator();
    L13:
        if (r4.hasNext() == false) goto L19;
        k r2 = (k) ZeusTransformUtils.preCheckCast(r4.next(), k.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L13;
        Fragment r3 = r2.a();
        if (r3.mFragmentId != r5) goto L13;
        return r3;
    L19:
        return null;
    }

    Fragment a(String r5) {
        if (r5 == null) goto L12;
        int r1 = this.f1821a.size() - 1;
    L5:
        if (r1 < 0) goto L12;
        Fragment r2 = (Fragment) ZeusTransformUtils.preCheckCast(this.f1821a.get(r1), Fragment.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L11;
        if (r5.equals(r2.mTag) == false) goto L11;
        return r2;
    L11:
        r1 = r1 - 1;
    L12:
        if (r5 == null) goto L21;
        Iterator<k> r4 = this.f1822b.values().iterator();
    L15:
        if (r4.hasNext() == false) goto L33;
        k r3 = (k) ZeusTransformUtils.preCheckCast(r4.next(), k.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L15;
        Fragment r6 = r3.a();
        if (r5.equals(r6.mTag) == false) goto L15;
        return r6;
    L33:
        return null;
    L21:
        return null;
    }

    boolean b(String r1) {
        if (this.f1822b.get(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    k c(String r2) {
        return (k) ZeusTransformUtils.preCheckCast(this.f1822b.get(r2), k.class, "com.obric.aiagent.plugin");
    }

    Fragment d(String r4) {
        Iterator<k> r3 = this.f1822b.values().iterator();
    L4:
        if (r3.hasNext() == false) goto L10;
        k r0 = (k) ZeusTransformUtils.preCheckCast(r3.next(), k.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L4;
        Fragment r1 = r0.a().findFragmentByWho(r4);
        if (r1 == null) goto L4;
        return r1;
    L10:
        return null;
    }

    Fragment e(String r2) {
        k r1 = (k) ZeusTransformUtils.preCheckCast(this.f1822b.get(r2), k.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
        return null;
    L5:
        return r1.a();
    }

    int c(Fragment r7) {
        ViewGroup r0 = r7.mContainer;
        if (r0 != null) goto L5;
        return -1;
    L5:
        int r8 = this.f1821a.indexOf(r7);
        int r2 = r8 - 1;
    L7:
        if (r2 < 0) goto L15;
        Fragment r3 = (Fragment) ZeusTransformUtils.preCheckCast(this.f1821a.get(r2), Fragment.class, "com.obric.aiagent.plugin");
        if (r3.mContainer != r0) goto L14;
        if (r3.mView == null) goto L14;
        return r0.indexOfChild(r3.mView) + 1;
    L14:
        r2 = r2 - 1;
    L15:
        r8 = r8 + 1;
        if (r8 >= this.f1821a.size()) goto L24;
        Fragment r4 = (Fragment) ZeusTransformUtils.preCheckCast(this.f1821a.get(r8), Fragment.class, "com.obric.aiagent.plugin");
        if (r4.mContainer != r0) goto L15;
        if (r4.mView == null) goto L15;
        return r0.indexOfChild(r4.mView);
    L24:
        return -1;
    }

    void a(String r6, FileDescriptor r7, PrintWriter r8, String[] r9) {
        String r0 = r6 + "    ";
        if (this.f1822b.isEmpty() == true) goto L11;
        r8.print(r6);
        r8.println("Active Fragments:");
        Iterator<k> r1 = this.f1822b.values().iterator();
    L6:
        if (r1.hasNext() == false) goto L11;
        k r3 = (k) ZeusTransformUtils.preCheckCast(r1.next(), k.class, "com.obric.aiagent.plugin");
        r8.print(r6);
        if (r3 != null) goto L9;
        r8.println("null");
        goto L6
    L9:
        Fragment r4 = r3.a();
        r8.println(r4);
        r4.dump(r0, r7, r8, r9);
    L11:
        int r10 = this.f1821a.size();
        if (r10 <= 0) goto L16;
        r8.print(r6);
        r8.println("Added Fragments:");
        int r11 = 0;
    L14:
        if (r11 >= r10) goto L24;
        Fragment r2 = (Fragment) ZeusTransformUtils.preCheckCast(this.f1821a.get(r11), Fragment.class, "com.obric.aiagent.plugin");
        r8.print(r6);
        r8.print("  #");
        r8.print(r11);
        r8.print(": ");
        r8.println(r2.toString());
        r11 = r11 + 1;
        goto L14
    L24:
        return;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.v(r1, r2);
    }
}
