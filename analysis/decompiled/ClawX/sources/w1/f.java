package w1;

import com.google.android.material.internal.CheckableImageButton;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class f extends p {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f6097e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(o oVar, int i8) {
        super(oVar);
        this.f6097e = i8;
    }

    @Override // w1.p
    public void q() {
        switch (this.f6097e) {
            case 0:
                o oVar = this.f6140b;
                oVar.f6131p = null;
                CheckableImageButton checkableImageButton = oVar.f6123g;
                checkableImageButton.setOnLongClickListener(null);
                k4.v.k0(checkableImageButton, null);
                break;
        }
    }
}
