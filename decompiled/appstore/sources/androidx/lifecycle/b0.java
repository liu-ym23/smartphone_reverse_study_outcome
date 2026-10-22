package androidx.lifecycle;

import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.savedstate.SavedStateRegistry;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: loaded from: classes.dex */
public final class b0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f3500f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Class[] f3501g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f3502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f3503b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f3504c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f3505d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SavedStateRegistry.SavedStateProvider f3506e;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final b0 a(Bundle r10, Bundle r11) {
            if (r10 != null) goto L11;
            if (r11 == null) goto L25;
            HashMap r12 = new HashMap();
            Iterator<String> r13 = r11.keySet().iterator();
        L7:
            if (r13.hasNext() == false) goto L10;
            String r14 = r13.next();
            kotlin.jvm.internal.q.f(r14, "key");
            r12.put(r14, r11.get(r14));
            goto L7
        L10:
            return new b0(r12);
        L25:
            return new b0();
        L11:
            ClassLoader r15 = b0.class.getClassLoader();
            kotlin.jvm.internal.q.d(r15);
            r10.setClassLoader(r15);
            ArrayList r16 = r10.getParcelableArrayList("keys");
            ArrayList r17 = r10.getParcelableArrayList("values");
            if (r16 == null) goto L22;
            if (r17 == null) goto L22;
            if (r16.size() != r17.size()) goto L22;
            LinkedHashMap r18 = new LinkedHashMap();
            int r19 = r16.size();
            int r20 = 0;
        L17:
            if (r20 >= r19) goto L20;
            Object r21 = r16.get(r20);
            kotlin.jvm.internal.q.e(r21, "null cannot be cast to non-null type kotlin.String");
            r18.put((String) r21, r17.get(r20));
            r20 = r20 + 1;
            goto L17
        L20:
            return new b0(r18);
        L22:
            throw new IllegalStateException("Invalid bundle passed as restored state");
        }

        public final boolean b(Object r10) {
            if (r10 != null) goto L5;
            return true;
        L5:
            Class[] r11 = b0.b();
            int r12 = r11.length;
            int r13 = 0;
        L6:
            if (r13 >= r12) goto L11;
            Class r14 = r11[r13];
            kotlin.jvm.internal.q.d(r14);
            if (r14.isInstance(r10) == true) goto L9;
            r13 = r13 + 1;
            goto L6
        L9:
            return true;
        L11:
            return false;
        }

        public a() {
        }
    }

    static {
        f3500f = new a(null);
        f3501g = new Class[]{Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};
    }

    public b0(Map r10) {
        kotlin.jvm.internal.q.g(r10, "initialState");
        LinkedHashMap r11 = new LinkedHashMap();
        this.f3502a = r11;
        this.f3503b = new LinkedHashMap();
        this.f3504c = new LinkedHashMap();
        this.f3505d = new LinkedHashMap();
        this.f3506e = new a0(this);
        r11.putAll(r10);
    }

    public static /* synthetic */ Bundle a(b0 r10) {
        return f(r10);
    }

    public static final /* synthetic */ Class[] b() {
        return f3501g;
    }

    public static final Bundle f(b0 r10) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        Iterator r11 = kotlin.collections.k0.s(r10.f3503b).entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Map.Entry r12 = (Map.Entry) r11.next();
        r10.g((String) r12.getKey(), ((SavedStateRegistry.SavedStateProvider) r12.getValue()).saveState());
        goto L4
    L6:
        Set r13 = r10.f3502a.keySet();
        ArrayList r14 = new ArrayList(r13.size());
        ArrayList r15 = new ArrayList(r14.size());
        Iterator r16 = r13.iterator();
    L8:
        if (r16.hasNext() == false) goto L11;
        String r17 = (String) r16.next();
        r14.add(r17);
        r15.add(r10.f3502a.get(r17));
        goto L8
    L11:
        return androidx.core.os.c.a(new Pair[]{kotlin.d.a("keys", r14), kotlin.d.a("values", r15)});
    }

    public final Object c(String r10) {
        kotlin.jvm.internal.q.g(r10, "key");
        return this.f3502a.get(r10);
    L5:
        d(r10);
        return null;
    }

    public final Object d(String r10) {
        kotlin.jvm.internal.q.g(r10, "key");
        Object r11 = this.f3502a.remove(r10);
        androidx.appcompat.widget.p.a(this.f3504c.remove(r10));
        this.f3505d.remove(r10);
        return r11;
    }

    public final SavedStateRegistry.SavedStateProvider e() {
        return this.f3506e;
    }

    public final void g(String r10, Object r11) {
        kotlin.jvm.internal.q.g(r10, "key");
        if (f3500f.b(r11) == false) goto L16;
        Object r12 = this.f3504c.get(r10);
        if ((r12 instanceof MutableLiveData) == false) goto L7;
        MutableLiveData r13 = (MutableLiveData) r12;
    L8:
        if (r13 == null) goto L10;
        r13.p(r11);
    L11:
        MutableStateFlow r14 = (MutableStateFlow) this.f3505d.get(r10);
        if (r14 == null) goto L18;
        r14.setValue(r11);
        return;
    L18:
        return;
    L10:
        this.f3502a.put(r10, r11);
        goto L11
    L7:
        r13 = null;
        goto L8
    L16:
        StringBuilder r15 = new StringBuilder();
        r15.append("Can't put value with type ");
        kotlin.jvm.internal.q.d(r11);
        r15.append(r11.getClass());
        r15.append(" into saved state");
        throw new IllegalArgumentException(r15.toString());
    }

    public b0() {
        this.f3502a = new LinkedHashMap();
        this.f3503b = new LinkedHashMap();
        this.f3504c = new LinkedHashMap();
        this.f3505d = new LinkedHashMap();
        this.f3506e = new a0(this);
    }
}
