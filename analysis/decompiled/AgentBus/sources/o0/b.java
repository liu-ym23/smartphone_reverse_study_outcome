package o0;

import android.graphics.Rect;
import android.view.autofill.AutofillId;
import j1.y;
import k.u;
import m.x;
import p1.p;

/* loaded from: classes.dex */
public final class b extends g {

    /* renamed from: a, reason: collision with root package name */
    public final a7.d f7172a;

    /* renamed from: b, reason: collision with root package name */
    public final p f7173b;

    /* renamed from: c, reason: collision with root package name */
    public final y f7174c;

    /* renamed from: d, reason: collision with root package name */
    public final q1.a f7175d;

    /* renamed from: e, reason: collision with root package name */
    public final String f7176e;

    /* renamed from: f, reason: collision with root package name */
    public final AutofillId f7177f;

    /* renamed from: g, reason: collision with root package name */
    public final u f7178g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f7179h;

    public b(a7.d dVar, p pVar, y yVar, q1.a aVar, String str) {
        this.f7172a = dVar;
        this.f7173b = pVar;
        this.f7174c = yVar;
        this.f7175d = aVar;
        this.f7176e = str;
        new Rect();
        yVar.setImportantForAutofill(1);
        AutofillId autofillId = yVar.getAutofillId();
        if (autofillId == null) {
            throw x.i("Required value was null.");
        }
        this.f7177f = autofillId;
        this.f7178g = new u();
    }
}
