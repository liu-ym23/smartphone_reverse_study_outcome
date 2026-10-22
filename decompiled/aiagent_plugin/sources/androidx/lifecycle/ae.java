package androidx.lifecycle;

import android.os.Bundle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: SavedStateHandleSupport.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ae implements androidx.savedstate.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final androidx.savedstate.a f1998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f1999b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Bundle f2000c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d.f f2001d;

    /* JADX INFO: compiled from: SavedStateHandleSupport.kt */
    static final class a extends d.h.b.p implements d.h.a.a<af> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ap f2002a;

        a(ap r3) {
            this.f2002a = (ap) ZeusTransformUtils.wrapperContextForParams(r3, ap.class, "com.obric.aiagent.plugin");
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ af invoke() {
            return a();
        }

        public final af a() {
            return ad.a(this.f2002a);
        }
    }

    public ae(androidx.savedstate.a r3, ap r4) {
        ap r5 = (ap) ZeusTransformUtils.wrapperContextForParams(r4, ap.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "savedStateRegistry");
        d.h.b.o.e(r5, "viewModelStoreOwner");
        this.f1998a = r3;
        this.f2001d = d.g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new a(r5), d.h.a.a.class, "com.obric.aiagent.plugin"));
    }

    private final af b() {
        return (af) ZeusTransformUtils.preCheckCast(this.f2001d.b(), af.class, "com.obric.aiagent.plugin");
    }

    @Override // androidx.savedstate.a.c
    public Bundle saveState() {
        Bundle r0 = new Bundle();
        Bundle r1 = this.f2000c;
        if (r1 == null) goto L5;
        r0.putAll(r1);
    L5:
        Iterator<Map.Entry<String, ac>> r2 = b().b().entrySet().iterator();
    L7:
        if (r2.hasNext() == false) goto L11;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.aiagent.plugin");
        Bundle r5 = ((ac) ZeusTransformUtils.preCheckCast(r3.getValue(), ac.class, "com.obric.aiagent.plugin")).a().saveState();
        if (d.h.b.o.a(r5, Bundle.EMPTY) == true) goto L7;
        r0.putBundle(r4, r5);
        goto L7
    L11:
        this.f1999b = false;
        return r0;
    }

    public final void a() {
        if (this.f1999b == true) goto L11;
        Bundle r0 = this.f1998a.a("androidx.lifecycle.internal.SavedStateHandlesProvider");
        Bundle r1 = new Bundle();
        Bundle r2 = this.f2000c;
        if (r2 == null) goto L7;
        r1.putAll(r2);
    L7:
        if (r0 == null) goto L9;
        r1.putAll(r0);
    L9:
        this.f2000c = r1;
        this.f1999b = true;
        b();
        return;
    }

    public final Bundle a(String r5) {
        d.h.b.o.e(r5, "key");
        a();
        Bundle r0 = this.f2000c;
        if (r0 == null) goto L5;
        Bundle r1 = r0.getBundle(r5);
    L6:
        Bundle r2 = this.f2000c;
        if (r2 == null) goto L9;
        r2.remove(r5);
    L9:
        Bundle r6 = this.f2000c;
        boolean r3 = true;
        if (r6 != null) goto L12;
    L14:
        r3 = false;
    L15:
        if (r3 == false) goto L17;
        this.f2000c = null;
    L17:
        return r1;
    L12:
        if (r6.isEmpty() != true) goto L14;
    L5:
        r1 = null;
        goto L6
    }
}
