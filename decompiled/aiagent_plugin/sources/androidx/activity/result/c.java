package androidx.activity.result;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.i;
import androidx.lifecycle.m;
import androidx.lifecycle.p;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: ActivityResultRegistry.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Random f166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Map<String, Integer> f167b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ArrayList<String> f168c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final transient Map<String, a<?>> f169d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final Map<String, Object> f170e;
    final Bundle f;
    private final Map<Integer, String> g;
    private final Map<String, b> h;

    /* JADX INFO: compiled from: ActivityResultRegistry.java */
    private static class a<O> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final androidx.activity.result.a<O> f177a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final androidx.activity.result.a.a<?, O> f178b;

        a(androidx.activity.result.a<O> r3, androidx.activity.result.a.a<?, O> r4) {
            this.f177a = (androidx.activity.result.a) ZeusTransformUtils.wrapperContextForParams(r3, androidx.activity.result.a.class, "com.obric.aiagent.plugin");
            this.f178b = r4;
        }
    }

    /* JADX INFO: compiled from: ActivityResultRegistry.java */
    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final i f179a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ArrayList<m> f180b;

        b(i r1) {
            this.f179a = r1;
            this.f180b = new ArrayList();
        }

        void a(m r3) {
            m r4 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.aiagent.plugin");
            this.f179a.a(r4);
            this.f180b.add(r4);
        }

        void a() {
            Iterator<m> r0 = this.f180b.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            m r1 = (m) ZeusTransformUtils.preCheckCast(r0.next(), m.class, "com.obric.aiagent.plugin");
            this.f179a.b(r1);
            goto L4
        L6:
            this.f180b.clear();
        }
    }

    public abstract <I, O> void a(int r1, androidx.activity.result.a.a<I, O> r2, I r3, androidx.core.app.a r4);

    public c() {
        this.f166a = new Random();
        this.g = new HashMap();
        this.f167b = new HashMap();
        this.h = new HashMap();
        this.f168c = new ArrayList();
        this.f169d = new HashMap();
        this.f170e = new HashMap();
        this.f = new Bundle();
    }

    public final <I, O> androidx.activity.result.b<I> a(final String r5, p r6, final androidx.activity.result.a.a<I, O> r7, androidx.activity.result.a<O> r8) {
        p r9 = (p) ZeusTransformUtils.wrapperContextForParams(r6, p.class, "com.obric.aiagent.plugin");
        final androidx.activity.result.a r10 = (androidx.activity.result.a) ZeusTransformUtils.wrapperContextForParams(r8, androidx.activity.result.a.class, "com.obric.aiagent.plugin");
        i r0 = r9.getLifecycle();
        if (r0.b().a(i.b.f2057d) == true) goto L10;
        b(r5);
        b r11 = (b) ZeusTransformUtils.preCheckCast(this.h.get(r5), b.class, "com.obric.aiagent.plugin");
        if (r11 != null) goto L7;
        r11 = new b(r0);
    L7:
        r11.a(new ActivityResultRegistry$1(this, r5, r10, r7));
        this.h.put(r5, r11);
        return new AnonymousClass1(this, r5, r7);
    L10:
        throw new IllegalStateException("LifecycleOwner " + r9 + " is attempting to register while current state is " + r0.b() + ". LifecycleOwners must call register before they are STARTED.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <I, O> androidx.activity.result.b<I> a(final String r4, final androidx.activity.result.a.a<I, O> r5, androidx.activity.result.a<O> r6) {
        androidx.activity.result.a r7 = (androidx.activity.result.a) ZeusTransformUtils.wrapperContextForParams(r6, androidx.activity.result.a.class, "com.obric.aiagent.plugin");
        b(r4);
        this.f169d.put(r4, new a(r7, r5));
        if (this.f170e.containsKey(r4) == false) goto L5;
        Object r0 = this.f170e.get(r4);
        this.f170e.remove(r4);
        r7.a(r0);
    L5:
        ActivityResult r1 = (ActivityResult) ZeusTransformUtils.preCheckCast(this.f.getParcelable(r4), ActivityResult.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L9;
        this.f.remove(r4);
        r7.a(r5.a(r1.getResultCode(), r1.getData()));
    L9:
        return new AnonymousClass2(this, r4, r5);
    }

    final void a(String r7) {
        if (this.f168c.contains(r7) == true) goto L7;
        Integer r0 = (Integer) ZeusTransformUtils.preCheckCast(this.f167b.remove(r7), Integer.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L7;
        this.g.remove(r0);
    L7:
        this.f169d.remove(r7);
        if (this.f170e.containsKey(r7) == false) goto L11;
        a("ActivityResultRegistry", "Dropping pending result for request " + r7 + ": " + this.f170e.get(r7));
        this.f170e.remove(r7);
    L11:
        if (this.f.containsKey(r7) == false) goto L13;
        a("ActivityResultRegistry", "Dropping pending result for request " + r7 + ": " + this.f.getParcelable(r7));
        this.f.remove(r7);
    L13:
        b r1 = (b) ZeusTransformUtils.preCheckCast(this.h.get(r7), b.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L17;
        r1.a();
        this.h.remove(r7);
        return;
    }

    public final void a(Bundle r4) {
        r4.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList(this.f167b.values()));
        r4.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList(this.f167b.keySet()));
        r4.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList(this.f168c));
        r4.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) ZeusTransformUtils.preCheckCast(this.f.clone(), Bundle.class, "com.obric.aiagent.plugin"));
        r4.putSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT", this.f166a);
    }

    public final void b(Bundle r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        ArrayList<Integer> r0 = r7.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
        ArrayList<String> r1 = r7.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
        if (r1 == null) goto L17;
        if (r0 == null) goto L22;
        this.f168c = r7.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
        this.f166a = (Random) ZeusTransformUtils.preCheckCast(r7.getSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT"), Random.class, "com.obric.aiagent.plugin");
        this.f.putAll(r7.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
        int r8 = 0;
    L10:
        if (r8 >= r1.size()) goto L23;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.get(r8), String.class, "com.obric.aiagent.plugin");
        if (this.f167b.containsKey(r2) == false) goto L16;
        Integer r3 = (Integer) ZeusTransformUtils.preCheckCast(this.f167b.remove(r2), Integer.class, "com.obric.aiagent.plugin");
        if (this.f.containsKey(r2) == true) goto L16;
        this.g.remove(r3);
    L16:
        a(((Integer) ZeusTransformUtils.preCheckCast(r0.get(r8), Integer.class, "com.obric.aiagent.plugin")).intValue(), (String) ZeusTransformUtils.preCheckCast(r1.get(r8), String.class, "com.obric.aiagent.plugin"));
        r8 = r8 + 1;
        goto L10
    L23:
        return;
    L22:
        return;
    }

    public final boolean a(int r4, int r5, Intent r6) {
        String r7 = (String) ZeusTransformUtils.preCheckCast(this.g.get(Integer.valueOf(r4)), String.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L6;
        return false;
    L6:
        a(r7, r5, r6, (a) ZeusTransformUtils.preCheckCast(this.f169d.get(r7), a.class, "com.obric.aiagent.plugin"));
        return true;
    }

    public final <O> boolean a(int r4, O r5) {
        String r6 = (String) ZeusTransformUtils.preCheckCast(this.g.get(Integer.valueOf(r4)), String.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L6;
        return false;
    L6:
        a r0 = (a) ZeusTransformUtils.preCheckCast(this.f169d.get(r6), a.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L9;
    L14:
        this.f.remove(r6);
        this.f170e.put(r6, r5);
        return true;
    L9:
        if (r0.f177a == null) goto L14;
        androidx.activity.result.a<O> r1 = r0.f177a;
        if (this.f168c.remove(r6) == false) goto L17;
        r1.a(r5);
        return true;
    L17:
        return true;
    }

    private <O> void a(String r2, int r3, Intent r4, a<O> r5) {
        if (r5 != null) goto L4;
    L8:
        this.f170e.remove(r2);
        this.f.putParcelable(r2, new ActivityResult(r3, r4));
        return;
    L4:
        if (r5.f177a == null) goto L8;
        if (this.f168c.contains(r2) == false) goto L8;
        r5.f177a.a(r5.f178b.a(r3, r4));
        this.f168c.remove(r2);
    }

    private void b(String r4) {
        if (((Integer) ZeusTransformUtils.preCheckCast(this.f167b.get(r4), Integer.class, "com.obric.aiagent.plugin")) == null) goto L5;
        return;
    L5:
        a(a(), r4);
    }

    private int a() {
        int r0 = this.f166a.nextInt(2147418112);
    L3:
        int r1 = r0 + 65536;
        if (this.g.containsKey(Integer.valueOf(r1)) == false) goto L6;
        r0 = this.f166a.nextInt(2147418112);
        goto L3
    L6:
        return r1;
    }

    private void a(int r3, String r4) {
        this.g.put(Integer.valueOf(r3), r4);
        this.f167b.put(r4, Integer.valueOf(r3));
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }
}
