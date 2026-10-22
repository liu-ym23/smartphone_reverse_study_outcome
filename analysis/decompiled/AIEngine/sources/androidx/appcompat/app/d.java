package androidx.appcompat.app;

import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AlertController;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d implements AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AlertController f318a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AlertController.b f319b;

    public d(AlertController.b bVar, AlertController alertController) {
        this.f319b = bVar;
        this.f318a = alertController;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        AlertController.b bVar = this.f319b;
        DialogInterface.OnClickListener onClickListener = bVar.f251n;
        AlertController alertController = this.f318a;
        onClickListener.onClick(alertController.f214b, i10);
        if (bVar.r) {
            return;
        }
        alertController.f214b.dismiss();
    }
}
