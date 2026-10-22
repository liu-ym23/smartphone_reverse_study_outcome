package d;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.AbstractC0533m;
import androidx.lifecycle.InterfaceC0537q;
import androidx.lifecycle.InterfaceC0539t;
import e.AbstractC0674a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import n4.AbstractC0886c;

/* renamed from: d.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0643d {

    /* renamed from: a, reason: collision with root package name */
    private final Map<Integer, String> f16541a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    final Map<String, Integer> f16542b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, e> f16543c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    ArrayList<String> f16544d = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    final transient Map<String, C0204d<?>> f16545e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    final Map<String, Object> f16546f = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    final Bundle f16547g = new Bundle();

    /* renamed from: d.d$a */
    class a implements InterfaceC0537q {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f16548a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ InterfaceC0641b f16549b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ AbstractC0674a f16550c;

        a(String str, InterfaceC0641b interfaceC0641b, AbstractC0674a abstractC0674a) {
            this.f16548a = str;
            this.f16549b = interfaceC0641b;
            this.f16550c = abstractC0674a;
        }

        @Override // androidx.lifecycle.InterfaceC0537q
        public void f(InterfaceC0539t interfaceC0539t, AbstractC0533m.a aVar) {
            if (!AbstractC0533m.a.ON_START.equals(aVar)) {
                if (AbstractC0533m.a.ON_STOP.equals(aVar)) {
                    AbstractC0643d.this.f16545e.remove(this.f16548a);
                    return;
                } else {
                    if (AbstractC0533m.a.ON_DESTROY.equals(aVar)) {
                        AbstractC0643d.this.l(this.f16548a);
                        return;
                    }
                    return;
                }
            }
            AbstractC0643d.this.f16545e.put(this.f16548a, new C0204d<>(this.f16549b, this.f16550c));
            if (AbstractC0643d.this.f16546f.containsKey(this.f16548a)) {
                Object obj = AbstractC0643d.this.f16546f.get(this.f16548a);
                AbstractC0643d.this.f16546f.remove(this.f16548a);
                this.f16549b.a(obj);
            }
            C0640a c0640a = (C0640a) AbstractC0643d.this.f16547g.getParcelable(this.f16548a);
            if (c0640a != null) {
                AbstractC0643d.this.f16547g.remove(this.f16548a);
                this.f16549b.a(this.f16550c.c(c0640a.c(), c0640a.a()));
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [I] */
    /* renamed from: d.d$b */
    class b<I> extends AbstractC0642c<I> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f16552a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AbstractC0674a f16553b;

        b(String str, AbstractC0674a abstractC0674a) {
            this.f16552a = str;
            this.f16553b = abstractC0674a;
        }

        @Override // d.AbstractC0642c
        public void b(I i5, androidx.core.app.c cVar) throws Exception {
            Integer num = AbstractC0643d.this.f16542b.get(this.f16552a);
            if (num != null) {
                AbstractC0643d.this.f16544d.add(this.f16552a);
                try {
                    AbstractC0643d.this.f(num.intValue(), this.f16553b, i5, cVar);
                    return;
                } catch (Exception e6) {
                    AbstractC0643d.this.f16544d.remove(this.f16552a);
                    throw e6;
                }
            }
            throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + this.f16553b + " and input " + i5 + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
        }

        @Override // d.AbstractC0642c
        public void c() {
            AbstractC0643d.this.l(this.f16552a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [I] */
    /* renamed from: d.d$c */
    class c<I> extends AbstractC0642c<I> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f16555a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AbstractC0674a f16556b;

        c(String str, AbstractC0674a abstractC0674a) {
            this.f16555a = str;
            this.f16556b = abstractC0674a;
        }

        @Override // d.AbstractC0642c
        public void b(I i5, androidx.core.app.c cVar) throws Exception {
            Integer num = AbstractC0643d.this.f16542b.get(this.f16555a);
            if (num != null) {
                AbstractC0643d.this.f16544d.add(this.f16555a);
                try {
                    AbstractC0643d.this.f(num.intValue(), this.f16556b, i5, cVar);
                    return;
                } catch (Exception e6) {
                    AbstractC0643d.this.f16544d.remove(this.f16555a);
                    throw e6;
                }
            }
            throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + this.f16556b + " and input " + i5 + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
        }

        @Override // d.AbstractC0642c
        public void c() {
            AbstractC0643d.this.l(this.f16555a);
        }
    }

    /* renamed from: d.d$d, reason: collision with other inner class name */
    private static class C0204d<O> {

        /* renamed from: a, reason: collision with root package name */
        final InterfaceC0641b<O> f16558a;

        /* renamed from: b, reason: collision with root package name */
        final AbstractC0674a<?, O> f16559b;

        C0204d(InterfaceC0641b<O> interfaceC0641b, AbstractC0674a<?, O> abstractC0674a) {
            this.f16558a = interfaceC0641b;
            this.f16559b = abstractC0674a;
        }
    }

    /* renamed from: d.d$e */
    private static class e {

        /* renamed from: a, reason: collision with root package name */
        final AbstractC0533m f16560a;

        /* renamed from: b, reason: collision with root package name */
        private final ArrayList<InterfaceC0537q> f16561b = new ArrayList<>();

        e(AbstractC0533m abstractC0533m) {
            this.f16560a = abstractC0533m;
        }

        void a(InterfaceC0537q interfaceC0537q) {
            this.f16560a.a(interfaceC0537q);
            this.f16561b.add(interfaceC0537q);
        }

        void b() {
            ArrayList<InterfaceC0537q> arrayList = this.f16561b;
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                InterfaceC0537q interfaceC0537q = arrayList.get(i5);
                i5++;
                this.f16560a.d(interfaceC0537q);
            }
            this.f16561b.clear();
        }
    }

    private void a(int i5, String str) {
        this.f16541a.put(Integer.valueOf(i5), str);
        this.f16542b.put(str, Integer.valueOf(i5));
    }

    private <O> void d(String str, int i5, Intent intent, C0204d<O> c0204d) {
        if (c0204d == null || c0204d.f16558a == null || !this.f16544d.contains(str)) {
            this.f16546f.remove(str);
            this.f16547g.putParcelable(str, new C0640a(i5, intent));
        } else {
            c0204d.f16558a.a(c0204d.f16559b.c(i5, intent));
            this.f16544d.remove(str);
        }
    }

    private int e() {
        int iB = AbstractC0886c.f18940a.b(2147418112);
        while (true) {
            int i5 = iB + 65536;
            if (!this.f16541a.containsKey(Integer.valueOf(i5))) {
                return i5;
            }
            iB = AbstractC0886c.f18940a.b(2147418112);
        }
    }

    private void k(String str) {
        if (this.f16542b.get(str) != null) {
            return;
        }
        a(e(), str);
    }

    public final boolean b(int i5, int i6, Intent intent) {
        String str = this.f16541a.get(Integer.valueOf(i5));
        if (str == null) {
            return false;
        }
        d(str, i6, intent, this.f16545e.get(str));
        return true;
    }

    public final <O> boolean c(int i5, O o5) {
        InterfaceC0641b<?> interfaceC0641b;
        String str = this.f16541a.get(Integer.valueOf(i5));
        if (str == null) {
            return false;
        }
        C0204d<?> c0204d = this.f16545e.get(str);
        if (c0204d == null || (interfaceC0641b = c0204d.f16558a) == null) {
            this.f16547g.remove(str);
            this.f16546f.put(str, o5);
            return true;
        }
        if (!this.f16544d.remove(str)) {
            return true;
        }
        interfaceC0641b.a(o5);
        return true;
    }

    public abstract <I, O> void f(int i5, AbstractC0674a<I, O> abstractC0674a, I i6, androidx.core.app.c cVar);

    public final void g(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
        if (stringArrayList == null || integerArrayList == null) {
            return;
        }
        this.f16544d = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
        this.f16547g.putAll(bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
        for (int i5 = 0; i5 < stringArrayList.size(); i5++) {
            String str = stringArrayList.get(i5);
            if (this.f16542b.containsKey(str)) {
                Integer numRemove = this.f16542b.remove(str);
                if (!this.f16547g.containsKey(str)) {
                    this.f16541a.remove(numRemove);
                }
            }
            a(integerArrayList.get(i5).intValue(), stringArrayList.get(i5));
        }
    }

    public final void h(Bundle bundle) {
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(this.f16542b.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(this.f16542b.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(this.f16544d));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) this.f16547g.clone());
    }

    public final <I, O> AbstractC0642c<I> i(String str, InterfaceC0539t interfaceC0539t, AbstractC0674a<I, O> abstractC0674a, InterfaceC0641b<O> interfaceC0641b) {
        AbstractC0533m lifecycle = interfaceC0539t.getLifecycle();
        if (lifecycle.b().d(AbstractC0533m.b.STARTED)) {
            throw new IllegalStateException("LifecycleOwner " + interfaceC0539t + " is attempting to register while current state is " + lifecycle.b() + ". LifecycleOwners must call register before they are STARTED.");
        }
        k(str);
        e eVar = this.f16543c.get(str);
        if (eVar == null) {
            eVar = new e(lifecycle);
        }
        eVar.a(new a(str, interfaceC0641b, abstractC0674a));
        this.f16543c.put(str, eVar);
        return new b(str, abstractC0674a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <I, O> AbstractC0642c<I> j(String str, AbstractC0674a<I, O> abstractC0674a, InterfaceC0641b<O> interfaceC0641b) {
        k(str);
        this.f16545e.put(str, new C0204d<>(interfaceC0641b, abstractC0674a));
        if (this.f16546f.containsKey(str)) {
            Object obj = this.f16546f.get(str);
            this.f16546f.remove(str);
            interfaceC0641b.a(obj);
        }
        C0640a c0640a = (C0640a) this.f16547g.getParcelable(str);
        if (c0640a != null) {
            this.f16547g.remove(str);
            interfaceC0641b.a(abstractC0674a.c(c0640a.c(), c0640a.a()));
        }
        return new c(str, abstractC0674a);
    }

    final void l(String str) {
        Integer numRemove;
        if (!this.f16544d.contains(str) && (numRemove = this.f16542b.remove(str)) != null) {
            this.f16541a.remove(numRemove);
        }
        this.f16545e.remove(str);
        if (this.f16546f.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f16546f.get(str));
            this.f16546f.remove(str);
        }
        if (this.f16547g.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f16547g.getParcelable(str));
            this.f16547g.remove(str);
        }
        e eVar = this.f16543c.get(str);
        if (eVar != null) {
            eVar.b();
            this.f16543c.remove(str);
        }
    }
}
