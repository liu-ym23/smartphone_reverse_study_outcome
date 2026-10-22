package o0;

import android.graphics.Rect;
import android.view.autofill.AutofillManager;
import c7.r;
import p7.p;
import q7.m;

/* loaded from: classes.dex */
public final class a extends m implements p {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ b f7170g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f7171h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(b bVar, int i2) {
        super(4);
        this.f7170g = bVar;
        this.f7171h = i2;
    }

    @Override // p7.p
    public final Object u(Object obj, Object obj2, Object obj3, Object obj4) {
        int iIntValue = ((Number) obj).intValue();
        int iIntValue2 = ((Number) obj2).intValue();
        int iIntValue3 = ((Number) obj3).intValue();
        int iIntValue4 = ((Number) obj4).intValue();
        b bVar = this.f7170g;
        a7.d dVar = bVar.f7172a;
        ((AutofillManager) dVar.f411g).notifyViewEntered(bVar.f7174c, this.f7171h, new Rect(iIntValue, iIntValue2, iIntValue3, iIntValue4));
        return r.f1986a;
    }
}
