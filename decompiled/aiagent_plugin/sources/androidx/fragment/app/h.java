package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.aj;
import androidx.lifecycle.am;
import androidx.lifecycle.ao;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: FragmentManagerViewModel.java */
/* JADX INFO: loaded from: classes.dex */
final class h extends aj {
    private static final String TAG = "FragmentManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final am.b f1810a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashMap<String, Fragment> f1811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HashMap<String, h> f1812c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashMap<String, ao> f1813d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f1814e;
    private boolean f;
    private boolean g;
    private boolean h;

    static {
        f1810a = new AnonymousClass1();
    }

    static h a(ao r3) {
        return (h) ZeusTransformUtils.preCheckCast(new am(r3, f1810a).a(h.class), h.class, "com.obric.aiagent.plugin");
    }

    h(boolean r2) {
        this.f1811b = new HashMap();
        this.f1812c = new HashMap();
        this.f1813d = new HashMap();
        this.f = false;
        this.g = false;
        this.h = false;
        this.f1814e = r2;
    }

    void a(boolean r1) {
        this.h = r1;
    }

    @Override // androidx.lifecycle.aj
    public void a() {
        if (FragmentManager.a(3) == false) goto L5;
        a(TAG, "onCleared called for " + this);
    L5:
        this.f = true;
    }

    boolean b() {
        return this.f;
    }

    void a(Fragment r5) {
        if (this.h == false) goto L9;
        if (FragmentManager.a(2) == false) goto L15;
        b(TAG, "Ignoring addRetainedFragment as the state is already saved");
        return;
    L15:
        return;
    L9:
        if (this.f1811b.containsKey(r5.mWho) == false) goto L11;
        return;
    L11:
        this.f1811b.put(r5.mWho, r5);
        if (FragmentManager.a(2) == false) goto L16;
        b(TAG, "Updating retained Fragments: Added " + r5);
        return;
    }

    Fragment a(String r2) {
        return (Fragment) ZeusTransformUtils.preCheckCast(this.f1811b.get(r2), Fragment.class, "com.obric.aiagent.plugin");
    }

    Collection<Fragment> c() {
        return new ArrayList(this.f1811b.values());
    }

    boolean b(Fragment r2) {
        if (this.f1811b.containsKey(r2.mWho) == true) goto L6;
        return true;
    L6:
        if (this.f1814e == false) goto L10;
        return this.f;
    L10:
        return !this.g;
    }

    void c(Fragment r4) {
        if (this.h == false) goto L9;
        if (FragmentManager.a(2) == false) goto L17;
        b(TAG, "Ignoring removeRetainedFragment as the state is already saved");
        return;
    L17:
        return;
    L9:
        if (this.f1811b.remove(r4.mWho) == null) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == true) goto L14;
        return;
    L14:
        if (FragmentManager.a(2) == false) goto L19;
        b(TAG, "Updating retained Fragments: Removed " + r4);
        return;
    L19:
        return;
    L11:
        r3 = false;
        goto L12
    }

    h d(Fragment r4) {
        h r0 = (h) ZeusTransformUtils.preCheckCast(this.f1812c.get(r4.mWho), h.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        h r1 = new h(this.f1814e);
        this.f1812c.put(r4.mWho, r1);
        return r1;
    L6:
        return r0;
    }

    ao e(Fragment r4) {
        ao r0 = (ao) ZeusTransformUtils.preCheckCast(this.f1813d.get(r4.mWho), ao.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        ao r1 = new ao();
        this.f1813d.put(r4.mWho, r1);
        return r1;
    L6:
        return r0;
    }

    void f(Fragment r4) {
        if (FragmentManager.a(3) == false) goto L5;
        a(TAG, "Clearing non-config state for " + r4);
    L5:
        h r0 = (h) ZeusTransformUtils.preCheckCast(this.f1812c.get(r4.mWho), h.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L8;
        r0.a();
        this.f1812c.remove(r4.mWho);
    L8:
        ao r1 = (ao) ZeusTransformUtils.preCheckCast(this.f1813d.get(r4.mWho), ao.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L12;
        r1.b();
        this.f1813d.remove(r4.mWho);
        return;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L19:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L19;
        h r6 = (h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.aiagent.plugin");
        if (this.f1811b.equals(r6.f1811b) == false) goto L18;
        if (this.f1812c.equals(r6.f1812c) == false) goto L18;
        if (this.f1813d.equals(r6.f1813d) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        return (((this.f1811b.hashCode() * 31) + this.f1812c.hashCode()) * 31) + this.f1813d.hashCode();
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("FragmentManagerViewModel{");
        r0.append(Integer.toHexString(System.identityHashCode(this)));
        r0.append("} Fragments (");
        Iterator<Fragment> r1 = this.f1811b.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        r0.append(r1.next());
        if (r1.hasNext() == false) goto L4;
        r0.append(", ");
        goto L4
    L8:
        r0.append(") Child Non Config (");
        Iterator<String> r2 = this.f1812c.keySet().iterator();
    L10:
        if (r2.hasNext() == false) goto L14;
        r0.append((String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.aiagent.plugin"));
        if (r2.hasNext() == false) goto L10;
        r0.append(", ");
        goto L10
    L14:
        r0.append(") ViewModelStores (");
        Iterator<String> r6 = this.f1813d.keySet().iterator();
    L16:
        if (r6.hasNext() == false) goto L20;
        r0.append((String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.aiagent.plugin"));
        if (r6.hasNext() == false) goto L16;
        r0.append(", ");
        goto L16
    L20:
        r0.append(')');
        return r0.toString();
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.v(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }
}
