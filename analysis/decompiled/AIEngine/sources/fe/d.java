package fe;

import android.view.View;
import stepos.support.v7.widget.PermissionScrollView;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d implements PermissionScrollView.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f8859a;

    public d(f fVar) {
        this.f8859a = fVar;
    }

    @Override // stepos.support.v7.widget.PermissionScrollView.a
    public final void onScrollChange(View view, int i10, int i11, int i12, int i13) {
        f fVar = this.f8859a;
        f.a(fVar, view, fVar.f8864d, fVar.f8869j);
    }
}
