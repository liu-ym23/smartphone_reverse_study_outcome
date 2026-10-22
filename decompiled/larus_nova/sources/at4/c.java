package at4;

import com.bytedance.ee.bear.bitable.infoarch.nativeview.card.CardRecordData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.card.record.cover.CardCoverData;
import com.bytedance.ee.bear.bitable.uikit.Action;
import com.bytedance.ee.bear.bitable.uikit.ActionPayload;
import gv4.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements gv4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CardRecordData f16229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ gv4.a f16230b;

    @Override // gv4.a
    public final void a(Action r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        CardCoverData r101 = this.f16229a.getCardCover();
        if (r101 == null) goto L6;
        ActionPayload r102 = r101.getClickAction();
        if (r102 == null) goto L6;
    L7:
        if (r102 == null) goto L12;
        gv4.a r103 = this.f16230b;
        if (r103 == null) goto L13;
        r103.a(r102);
        return;
    L13:
        return;
    L12:
        return;
    L6:
        r102 = this.f16229a.getClickAction();
        goto L7
    }

    public c(CardRecordData r100, e r101) {
        this.f16229a = r100;
        this.f16230b = r101;
    }
}
