package bt8;

import android.view.View;
import com.larus.bmhome.view.actionbar.edit.kmp.widget.KmpCommandWidget;

/* JADX INFO: loaded from: classes26.dex */
public final class n implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KmpCommandWidget f20642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ cq8.i f20643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.larus.bmhome.actionbar.model.c f20644c;

    public n(KmpCommandWidget r100, cq8.i r101, com.larus.bmhome.actionbar.model.c r102) {
        this.f20642a = r100;
        this.f20643b = r101;
        this.f20644c = r102;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        r100.removeOnLayoutChangeListener(this);
        KmpCommandWidget.Y5(this.f20642a, this.f20643b, this.f20644c);
    }
}
