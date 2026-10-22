package Z0;

import android.content.Context;
import androidx.fragment.app.C0284f;
import com.google.android.gms.common.api.internal.C0403a;
import com.google.android.gms.common.api.internal.C0407e;
import g1.HandlerC0575c;
import j1.C0633a;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public final Context f2150a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2151b;

    /* renamed from: c, reason: collision with root package name */
    public final android.support.v4.media.session.c f2152c;

    /* renamed from: d, reason: collision with root package name */
    public final b f2153d;

    /* renamed from: e, reason: collision with root package name */
    public final C0403a f2154e;

    /* renamed from: f, reason: collision with root package name */
    public final int f2155f;

    /* renamed from: g, reason: collision with root package name */
    public final y0.e f2156g;

    /* renamed from: h, reason: collision with root package name */
    public final C0407e f2157h;

    public f(Context context, android.support.v4.media.session.c cVar, e eVar) {
        String str;
        com.google.android.gms.common.internal.g gVar = com.google.android.gms.common.internal.g.f9808b;
        com.stepos.statsrpk.c.m(context, "Null context is not permitted.");
        com.stepos.statsrpk.c.m(cVar, "Api must not be null.");
        com.stepos.statsrpk.c.m(eVar, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.f2150a = context.getApplicationContext();
        try {
            str = (String) Context.class.getMethod("getAttributionTag", new Class[0]).invoke(context, new Object[0]);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            str = null;
        }
        this.f2151b = str;
        this.f2152c = cVar;
        this.f2153d = gVar;
        this.f2154e = new C0403a(cVar, str);
        C0407e c0407eF = C0407e.f(this.f2150a);
        this.f2157h = c0407eF;
        this.f2155f = c0407eF.f9648h.getAndIncrement();
        this.f2156g = eVar.f2149a;
        HandlerC0575c handlerC0575c = c0407eF.f9653m;
        handlerC0575c.sendMessage(handlerC0575c.obtainMessage(7, this));
    }

    public final C0284f a() {
        C0284f c0284f = new C0284f();
        c0284f.f3748e = C0633a.f13129a;
        c0284f.f3744a = null;
        Set setEmptySet = Collections.emptySet();
        if (((q.g) c0284f.f3745b) == null) {
            c0284f.f3745b = new q.g(0);
        }
        ((q.g) c0284f.f3745b).addAll(setEmptySet);
        Context context = this.f2150a;
        c0284f.f3747d = context.getClass().getName();
        c0284f.f3746c = context.getPackageName();
        return c0284f;
    }
}
