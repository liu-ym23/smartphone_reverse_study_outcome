package stepos.support.v7.app;

import android.content.DialogInterface;
import stepos.support.v7.app.g0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b0 implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ fe.c f12076a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g0 f12077b;

    public b0(g0 g0Var, fe.c cVar) {
        this.f12077b = g0Var;
        this.f12076a = cVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i10) {
        fe.c cVar = this.f12076a;
        boolean zIsChecked = cVar.getCheckBox().isChecked();
        cVar.getItemCheckedMap();
        g0.a aVar = this.f12077b.f12115j;
        if (aVar == null) {
            return;
        }
        aVar.onPermissionClick(dialogInterface, zIsChecked, false);
    }
}
