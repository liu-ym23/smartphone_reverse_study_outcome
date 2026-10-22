package K0;

import I.h;
import com.google.android.material.button.MaterialButton;
import com.stepos.common.widget.Switch;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class a extends h {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1024c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(int i4) {
        super(2, (Object) 100);
        this.f1024c = i4;
        if (i4 != 4) {
        } else {
            this(new Q0.c(1.0f, 1.0f));
        }
    }

    @Override // K0.d
    public H0.b c() {
        switch (this.f1024c) {
            case 0:
                return new H0.c(0, (List) this.f825b);
            case 1:
                return new H0.d(0, (List) this.f825b);
            case 2:
                return new H0.c(2, (List) this.f825b);
            case 3:
                return new H0.d(1, (List) this.f825b);
            case 4:
                return new H0.c(3, (List) this.f825b);
            case 5:
                return new H0.h((List) this.f825b);
            default:
                return new H0.c(4, (List) this.f825b);
        }
    }

    @Override // I.h
    public float e(Object obj) {
        switch (this.f1024c) {
            case 0:
                return ((MaterialButton) obj).getDisplayedWidthIncrease();
            default:
                return ((Switch) obj).f11852m;
        }
    }

    @Override // I.h
    public void g(Object obj, float f4) {
        switch (this.f1024c) {
            case 0:
                ((MaterialButton) obj).setDisplayedWidthIncrease(f4);
                break;
            default:
                ((Switch) obj).setThumbPosition(f4);
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(int i4, ArrayList arrayList) {
        super(arrayList, 2);
        this.f1024c = i4;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Q0.c cVar) {
        super(2, cVar);
        this.f1024c = 4;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(String str, int i4) {
        super(str, 1);
        this.f1024c = i4;
    }
}
