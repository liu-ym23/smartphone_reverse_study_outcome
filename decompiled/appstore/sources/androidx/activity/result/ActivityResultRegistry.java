package androidx.activity.result;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.random.Random;

/* JADX INFO: loaded from: classes.dex */
public abstract class ActivityResultRegistry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f185b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f186c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList f187d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final transient Map f188e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map f189f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Bundle f190g;

    public class a implements LifecycleEventObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f191a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ActivityResultCallback f192b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ActivityResultContract f193c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ActivityResultRegistry f194d;

        public a(ActivityResultRegistry r10, String r11, ActivityResultCallback r12, ActivityResultContract r13) {
            this.f194d = r10;
            this.f191a = r11;
            this.f192b = r12;
            this.f193c = r13;
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(LifecycleOwner r10, Lifecycle.Event r11) {
            if (Lifecycle.Event.ON_START.equals(r11) == false) goto L11;
            this.f194d.f188e.put(this.f191a, new d(this.f192b, this.f193c));
            if (this.f194d.f189f.containsKey(this.f191a) == false) goto L7;
            Object r12 = this.f194d.f189f.get(this.f191a);
            this.f194d.f189f.remove(this.f191a);
            this.f192b.onActivityResult(r12);
        L7:
            ActivityResult r13 = (ActivityResult) this.f194d.f190g.getParcelable(this.f191a);
            if (r13 == null) goto L17;
            this.f194d.f190g.remove(this.f191a);
            this.f192b.onActivityResult(this.f193c.c(r13.getResultCode(), r13.getData()));
            return;
        L17:
            return;
        L11:
            if (Lifecycle.Event.ON_STOP.equals(r11) == false) goto L14;
            this.f194d.f188e.remove(this.f191a);
            return;
        L14:
            if (Lifecycle.Event.ON_DESTROY.equals(r11) == false) goto L20;
            this.f194d.l(this.f191a);
            return;
        }
    }

    public class b extends ActivityResultLauncher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f195a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ActivityResultContract f196b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ActivityResultRegistry f197c;

        public b(ActivityResultRegistry r10, String r11, ActivityResultContract r12) {
            this.f197c = r10;
            this.f195a = r11;
            this.f196b = r12;
        }

        @Override // androidx.activity.result.ActivityResultLauncher
        public void b(Object r10, androidx.core.app.b r11) {
            Integer r12 = (Integer) this.f197c.f185b.get(this.f195a);
            if (r12 == null) goto L11;
            this.f197c.f187d.add(this.f195a);
            this.f197c.f(r12.intValue(), this.f196b, r10, r11);     // Catch: Exception -> L7
            return;
        L7:
            e = move-exception;
            this.f197c.f187d.remove(this.f195a);
            throw e;
        L11:
            throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + this.f196b + " and input " + r10 + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
        }

        @Override // androidx.activity.result.ActivityResultLauncher
        public void c() {
            this.f197c.l(this.f195a);
        }
    }

    public class c extends ActivityResultLauncher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f198a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ActivityResultContract f199b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ActivityResultRegistry f200c;

        public c(ActivityResultRegistry r10, String r11, ActivityResultContract r12) {
            this.f200c = r10;
            this.f198a = r11;
            this.f199b = r12;
        }

        @Override // androidx.activity.result.ActivityResultLauncher
        public void b(Object r10, androidx.core.app.b r11) {
            Integer r12 = (Integer) this.f200c.f185b.get(this.f198a);
            if (r12 == null) goto L11;
            this.f200c.f187d.add(this.f198a);
            this.f200c.f(r12.intValue(), this.f199b, r10, r11);     // Catch: Exception -> L7
            return;
        L7:
            e = move-exception;
            this.f200c.f187d.remove(this.f198a);
            throw e;
        L11:
            throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + this.f199b + " and input " + r10 + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
        }

        @Override // androidx.activity.result.ActivityResultLauncher
        public void c() {
            this.f200c.l(this.f198a);
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ActivityResultCallback f201a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ActivityResultContract f202b;

        public d(ActivityResultCallback r10, ActivityResultContract r11) {
            this.f201a = r10;
            this.f202b = r11;
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Lifecycle f203a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayList f204b;

        public e(Lifecycle r10) {
            this.f203a = r10;
            this.f204b = new ArrayList();
        }

        public void a() {
            Iterator r10 = this.f204b.iterator();
        L4:
            if (r10.hasNext() == false) goto L6;
            LifecycleEventObserver r11 = (LifecycleEventObserver) r10.next();
            this.f203a.d(r11);
            goto L4
        L6:
            this.f204b.clear();
        }

        public void addObserver(@NonNull LifecycleEventObserver r10) {
            this.f203a.a(r10);
            this.f204b.add(r10);
        }
    }

    public ActivityResultRegistry() {
        this.f184a = new HashMap();
        this.f185b = new HashMap();
        this.f186c = new HashMap();
        this.f187d = new ArrayList();
        this.f188e = new HashMap();
        this.f189f = new HashMap();
        this.f190g = new Bundle();
    }

    public final void a(int r10, String r11) {
        this.f184a.put(Integer.valueOf(r10), r11);
        this.f185b.put(r11, Integer.valueOf(r10));
    }

    public final boolean b(int r10, int r11, Intent r12) {
        String r13 = (String) this.f184a.get(Integer.valueOf(r10));
        if (r13 != null) goto L6;
        return false;
    L6:
        d(r13, r11, r12, (d) this.f188e.get(r13));
        return true;
    }

    public final boolean c(int r10, Object r11) {
        String r12 = (String) this.f184a.get(Integer.valueOf(r10));
        if (r12 != null) goto L6;
        return false;
    L6:
        d r13 = (d) this.f188e.get(r12);
        if (r13 == null) goto L14;
        ActivityResultCallback r14 = r13.f201a;
        if (r14 == null) goto L14;
        if (this.f187d.remove(r12) == false) goto L17;
        r14.onActivityResult(r11);
        return true;
    L17:
        return true;
    L14:
        this.f190g.remove(r12);
        this.f189f.put(r12, r11);
        return true;
    }

    public final void d(String r10, int r11, Intent r12, d r13) {
        if (r13 != null) goto L4;
    L8:
        this.f189f.remove(r10);
        this.f190g.putParcelable(r10, new ActivityResult(r11, r12));
        return;
    L4:
        if (r13.f201a == null) goto L8;
        if (this.f187d.contains(r10) == false) goto L8;
        r13.f201a.onActivityResult(r13.f202b.c(r11, r12));
        this.f187d.remove(r10);
    }

    public final int e() {
        int r10 = Random.Default.nextInt(2147418112);
    L3:
        int r11 = r10 + 65536;
        if (this.f184a.containsKey(Integer.valueOf(r11)) == false) goto L6;
        r10 = Random.Default.nextInt(2147418112);
        goto L3
    L6:
        return r11;
    }

    public abstract void f(int r10, ActivityResultContract r11, Object r12, androidx.core.app.b r13);

    public final void g(Bundle r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        ArrayList<Integer> r11 = r10.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
        ArrayList<String> r12 = r10.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
        if (r12 == null) goto L17;
        if (r11 == null) goto L22;
        this.f187d = r10.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
        this.f190g.putAll(r10.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
        int r13 = 0;
    L10:
        if (r13 >= r12.size()) goto L23;
        String r14 = r12.get(r13);
        if (this.f185b.containsKey(r14) == false) goto L16;
        Integer r15 = (Integer) this.f185b.remove(r14);
        if (this.f190g.containsKey(r14) == true) goto L16;
        this.f184a.remove(r15);
    L16:
        a(r11.get(r13).intValue(), r12.get(r13));
        r13 = r13 + 1;
        goto L10
    L23:
        return;
    L22:
        return;
    }

    public final void h(Bundle r10) {
        r10.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList(this.f185b.values()));
        r10.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList(this.f185b.keySet()));
        r10.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList(this.f187d));
        r10.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) this.f190g.clone());
    }

    public final ActivityResultLauncher i(String r10, ActivityResultContract r11, ActivityResultCallback r12) {
        k(r10);
        this.f188e.put(r10, new d(r12, r11));
        if (this.f189f.containsKey(r10) == false) goto L5;
        Object r13 = this.f189f.get(r10);
        this.f189f.remove(r10);
        r12.onActivityResult(r13);
    L5:
        ActivityResult r14 = (ActivityResult) this.f190g.getParcelable(r10);
        if (r14 == null) goto L9;
        this.f190g.remove(r10);
        r12.onActivityResult(r11.c(r14.getResultCode(), r14.getData()));
    L9:
        return new c(this, r10, r11);
    }

    public final ActivityResultLauncher j(String r10, LifecycleOwner r11, ActivityResultContract r12, ActivityResultCallback r13) {
        Lifecycle r14 = r11.getLifecycle();
        if (r14.b().isAtLeast(Lifecycle.State.STARTED) == true) goto L10;
        k(r10);
        e r15 = (e) this.f186c.get(r10);
        if (r15 != null) goto L7;
        r15 = new e(r14);
    L7:
        r15.addObserver(new a(this, r10, r13, r12));
        this.f186c.put(r10, r15);
        return new b(this, r10, r12);
    L10:
        throw new IllegalStateException("LifecycleOwner " + r11 + " is attempting to register while current state is " + r14.b() + ". LifecycleOwners must call register before they are STARTED.");
    }

    public final void k(String r10) {
        if (((Integer) this.f185b.get(r10)) == null) goto L5;
        return;
    L5:
        a(e(), r10);
    }

    public final void l(String r10) {
        if (this.f187d.contains(r10) == true) goto L7;
        Integer r11 = (Integer) this.f185b.remove(r10);
        if (r11 == null) goto L7;
        this.f184a.remove(r11);
    L7:
        this.f188e.remove(r10);
        if (this.f189f.containsKey(r10) == false) goto L11;
        Log.w("ActivityResultRegistry", "Dropping pending result for request " + r10 + ": " + this.f189f.get(r10));
        this.f189f.remove(r10);
    L11:
        if (this.f190g.containsKey(r10) == false) goto L13;
        Log.w("ActivityResultRegistry", "Dropping pending result for request " + r10 + ": " + this.f190g.getParcelable(r10));
        this.f190g.remove(r10);
    L13:
        e r12 = (e) this.f186c.get(r10);
        if (r12 == null) goto L17;
        r12.a();
        this.f186c.remove(r10);
        return;
    }
}
