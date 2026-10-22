package r1;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import k4.z;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c extends z {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f5069b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TextPaint f5070c;
    public final /* synthetic */ z d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ d f5071e;

    public c(d dVar, Context context, TextPaint textPaint, z zVar) {
        this.f5071e = dVar;
        this.f5069b = context;
        this.f5070c = textPaint;
        this.d = zVar;
    }

    @Override // k4.z
    public final void A(Typeface typeface, boolean z) {
        this.f5071e.f(this.f5069b, this.f5070c, typeface);
        this.d.A(typeface, z);
    }

    @Override // k4.z
    public final void z(int i8) {
        this.d.z(i8);
    }
}
