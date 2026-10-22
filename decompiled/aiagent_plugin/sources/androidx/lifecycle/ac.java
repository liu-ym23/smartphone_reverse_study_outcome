package androidx.lifecycle;

import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SavedStateHandle.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f1989a = null;
    private static final Class<? extends Object>[] g = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, Object> f1990b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, androidx.savedstate.a.c> f1991c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<String, Object<?>> f1992d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<String, kotlinx.coroutines.b.x<Object>> f1993e;
    private final androidx.savedstate.a.c f;

    /* JADX INFO: compiled from: SavedStateHandle.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final ac a(Bundle r6, Bundle r7) {
            if (r6 != null) goto L12;
            if (r7 == null) goto L29;
            Map r8 = (Map) ZeusTransformUtils.preCheckCast(new HashMap(), Map.class, "com.obric.aiagent.plugin");
            Iterator<String> r0 = r7.keySet().iterator();
        L8:
            if (r0.hasNext() == false) goto L11;
            String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.aiagent.plugin");
            d.h.b.o.c(r1, "key");
            r8.put(r1, r7.get(r1));
            goto L8
        L11:
            return new ac(r8);
        L29:
            return new ac();
        L12:
            ArrayList r9 = r6.getParcelableArrayList("keys");
            ArrayList r10 = r6.getParcelableArrayList("values");
            int r2 = 0;
            if (r9 == null) goto L18;
            if (r10 == null) goto L18;
            if (r9.size() != r10.size()) goto L18;
            boolean r3 = true;
        L19:
            if (r3 == false) goto L26;
            Map r4 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
            int r5 = r9.size();
        L21:
            if (r2 >= r5) goto L24;
            Object r11 = r9.get(r2);
            d.h.b.o.a(r11, "null cannot be cast to non-null type kotlin.String");
            r4.put((String) ZeusTransformUtils.preCheckCast(r11, String.class, "com.obric.aiagent.plugin"), r10.get(r2));
            r2 = r2 + 1;
            goto L21
        L24:
            return new ac(r4);
        L26:
            throw new IllegalStateException("Invalid bundle passed as restored state".toString());
        L18:
            r3 = false;
            goto L19
        }

        public final boolean a(Object r6) {
            if (r6 != null) goto L5;
            return true;
        L5:
            Class[] r0 = ac.b();
            int r1 = r0.length;
            int r3 = 0;
        L6:
            if (r3 >= r1) goto L11;
            Class r4 = r0[r3];
            d.h.b.o.a(r4);
            if (ZeusTransformUtils.instanceOf(r4, r6) == true) goto L9;
            r3 = r3 + 1;
            goto L6
        L9:
            return true;
        L11:
            return false;
        }
    }

    public static /* synthetic */ Bundle lambda$aOleo1gUX16wvwW_8YD6JFltbgs(ac r0) {
        return a(r0);
    }

    public static final /* synthetic */ Class[] b() {
        return g;
    }

    private static final Bundle a(ac r6) {
        d.h.b.o.e(r6, "this$0");
        Iterator r0 = d.a.ao.d(r6.f1991c).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r6.a((String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.aiagent.plugin"), ((androidx.savedstate.a.c) ZeusTransformUtils.preCheckCast(r1.getValue(), androidx.savedstate.a.c.class, "com.obric.aiagent.plugin")).saveState());
        goto L4
    L6:
        Set<String> r2 = r6.f1990b.keySet();
        ArrayList r3 = new ArrayList(r2.size());
        ArrayList r4 = new ArrayList(r3.size());
        Iterator<String> r5 = r2.iterator();
    L8:
        if (r5.hasNext() == false) goto L11;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.aiagent.plugin");
        r3.add(r7);
        r4.add(r6.f1990b.get(r7));
        goto L8
    L11:
        return androidx.core.os.e.a(new d.m[]{d.s.a("keys", r3), d.s.a("values", r4)});
    }

    public ac(Map<String, ? extends Object> r5) {
        Map<? extends String, ? extends Object> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "initialState");
        Map<String, Object> r0 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        this.f1990b = r0;
        this.f1991c = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        this.f1992d = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        this.f1993e = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        this.f = new $$Lambda$ac$aOleo1gUX16wvwW_8YD6JFltbgs(this);
        r0.putAll(r6);
    }

    public ac() {
        this.f1990b = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        this.f1991c = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        this.f1992d = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        this.f1993e = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        this.f = new $$Lambda$ac$aOleo1gUX16wvwW_8YD6JFltbgs(this);
    }

    public final androidx.savedstate.a.c a() {
        return this.f;
    }

    public final <T> void a(String r4, T r5) {
        d.h.b.o.e(r4, "key");
        if (f1989a.a(r5) == false) goto L16;
        Object<?> r0 = this.f1992d.get(r4);
        if (ZeusTransformUtils.instanceOf(r0, v.class) == false) goto L7;
        v r1 = (v) ZeusTransformUtils.preCheckCast(r0, v.class, "com.obric.aiagent.plugin");
    L8:
        if (r1 == null) goto L10;
        r1.b(r5);
    L11:
        kotlinx.coroutines.b.x r3 = (kotlinx.coroutines.b.x) ZeusTransformUtils.preCheckCast(this.f1993e.get(r4), kotlinx.coroutines.b.x.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L18;
        r3.b(r5);
        return;
    L18:
        return;
    L10:
        this.f1990b.put(r4, r5);
        goto L11
    L7:
        r1 = null;
        goto L8
    L16:
        StringBuilder r6 = new StringBuilder().append("Can't put value with type ");
        d.h.b.o.a(r5);
        throw new IllegalArgumentException(r6.append(r5.getClass()).append(" into saved state").toString());
    }

    static {
        f1989a = new a(null);
        Class<? extends Object>[] r0 = new Class[29];
        r0[0] = Boolean.TYPE;
        r0[1] = boolean[].class;
        r0[2] = Double.TYPE;
        r0[3] = double[].class;
        r0[4] = Integer.TYPE;
        r0[5] = int[].class;
        r0[6] = Long.TYPE;
        r0[7] = long[].class;
        r0[8] = String.class;
        r0[9] = String[].class;
        r0[10] = Binder.class;
        r0[11] = Bundle.class;
        r0[12] = Byte.TYPE;
        r0[13] = byte[].class;
        r0[14] = Character.TYPE;
        r0[15] = char[].class;
        r0[16] = CharSequence.class;
        r0[17] = CharSequence[].class;
        r0[18] = ArrayList.class;
        r0[19] = Float.TYPE;
        r0[20] = float[].class;
        r0[21] = Parcelable.class;
        r0[22] = Parcelable[].class;
        r0[23] = Serializable.class;
        r0[24] = Short.TYPE;
        r0[25] = short[].class;
        r0[26] = SparseArray.class;
        if (Build.VERSION.SDK_INT < 21) goto L5;
        Class<Size> r1 = Size.class;
    L6:
        r0[27] = r1;
        if (Build.VERSION.SDK_INT < 21) goto L9;
        Class<SizeF> r2 = SizeF.class;
    L10:
        r0[28] = r2;
        g = r0;
        return;
    L9:
        r2 = Integer.TYPE;
        goto L10
    L5:
        r1 = Integer.TYPE;
        goto L6
    }
}
