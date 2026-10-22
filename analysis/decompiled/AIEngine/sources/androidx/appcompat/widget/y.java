package androidx.appcompat.widget;

import androidx.appcompat.widget.AppCompatSpinner;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class y extends i0 {

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ AppCompatSpinner.e f950m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ AppCompatSpinner f951n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(AppCompatSpinner appCompatSpinner, AppCompatSpinner appCompatSpinner2, AppCompatSpinner.e eVar) {
        super(appCompatSpinner2);
        this.f951n = appCompatSpinner;
        this.f950m = eVar;
    }

    @Override // androidx.appcompat.widget.i0
    public final l.f b() {
        return this.f950m;
    }

    @Override // androidx.appcompat.widget.i0
    public final boolean c() {
        AppCompatSpinner appCompatSpinner = this.f951n;
        if (appCompatSpinner.getInternalPopup().isShowing()) {
            return true;
        }
        appCompatSpinner.h.show(appCompatSpinner.getTextDirection(), appCompatSpinner.getTextAlignment());
        return true;
    }
}
