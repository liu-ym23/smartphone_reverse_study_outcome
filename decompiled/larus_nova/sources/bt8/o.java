package bt8;

import android.view.View;
import com.larus.bmhome.view.actionbar.edit.kmp.widget.KmpCommandWidget;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class o implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KmpCommandWidget f20649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ cq8.i f20650b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.larus.bmhome.actionbar.model.c f20651c;

    public static final class a implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KmpCommandWidget f20652a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ cq8.i f20653b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.larus.bmhome.actionbar.model.c f20654c;

        public a(KmpCommandWidget r100, cq8.i r101, com.larus.bmhome.actionbar.model.c r102) {
            this.f20652a = r100;
            this.f20653b = r101;
            this.f20654c = r102;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            r100.removeOnLayoutChangeListener(this);
            KmpCommandWidget.Y5(this.f20652a, this.f20653b, this.f20654c);
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        this.f20649a.removeOnAttachStateChangeListener(this);
        KmpCommandWidget r101 = this.f20649a;
        cq8.i r102 = this.f20650b;
        com.larus.bmhome.actionbar.model.c r103 = this.f20651c;
        if (r101.isLaidOut() == true) goto L5;
    L7:
        r101.addOnLayoutChangeListener(new a(r101, r102, r103));
        return;
    L5:
        if (r101.isLayoutRequested() == true) goto L7;
        KmpCommandWidget.Y5(r101, r102, r103);
    }

    public o(KmpCommandWidget r100, cq8.i r101, com.larus.bmhome.actionbar.model.c r102) {
        this.f20649a = r100;
        this.f20650b = r101;
        this.f20651c = r102;
    }
}
