package w4;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e extends androidx.datastore.preferences.protobuf.f {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f13598b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TextPaint f13599c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ androidx.datastore.preferences.protobuf.f f13600d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ d f13601e;

    public e(d dVar, Context context, TextPaint textPaint, androidx.datastore.preferences.protobuf.f fVar) {
        this.f13601e = dVar;
        this.f13598b = context;
        this.f13599c = textPaint;
        this.f13600d = fVar;
    }

    @Override // androidx.datastore.preferences.protobuf.f
    public final void g(int i10) {
        this.f13600d.g(i10);
    }

    @Override // androidx.datastore.preferences.protobuf.f
    public final void h(Typeface typeface, boolean z) {
        this.f13601e.f(this.f13598b, this.f13599c, typeface);
        this.f13600d.h(typeface, z);
    }
}
