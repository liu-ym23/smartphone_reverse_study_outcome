package W1;

import a2.AbstractC0155a;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import d2.AbstractC0536a;
import k.AbstractC0650d;

/* loaded from: classes.dex */
public final class a extends AbstractC0650d {

    /* renamed from: d, reason: collision with root package name */
    public int[] f1987d;

    /* renamed from: e, reason: collision with root package name */
    public int f1988e;

    /* renamed from: f, reason: collision with root package name */
    public String f1989f;

    /* renamed from: g, reason: collision with root package name */
    public String f1990g;

    @Override // k.AbstractC0650d
    public final AbstractC0536a d() {
        return null;
    }

    @Override // k.AbstractC0650d
    public final String e(AbstractC0536a abstractC0536a) {
        return null;
    }

    @Override // k.AbstractC0650d
    public final Intent[] f(Context context) {
        int[] iArr;
        if (this.f1988e != 1 || (iArr = this.f1987d) == null) {
            Intent intent = new Intent();
            intent.putExtra("strategy_package_name", this.f1990g);
            intent.putExtra("strategy_type", 64);
            intent.putExtra("strategy_child_type", this.f1988e);
            if (this.f1988e == 2) {
                intent.putExtra("strategy_params", this.f1989f);
            }
            return new Intent[]{intent};
        }
        Intent[] intentArr = new Intent[iArr.length];
        for (int i4 = 0; i4 < this.f1987d.length; i4++) {
            AbstractC0155a.b((String) this.f13181a, "send notifyId " + this.f1987d[i4] + " to PushManagerService");
            Intent intent2 = new Intent();
            intent2.putExtra("strategy_package_name", this.f1990g);
            intent2.putExtra("strategy_type", 64);
            intent2.putExtra("strategy_child_type", this.f1988e);
            intent2.putExtra("strategy_params", "" + this.f1987d[i4]);
            intentArr[i4] = intent2;
        }
        return intentArr;
    }

    @Override // k.AbstractC0650d
    public final String g() {
        return null;
    }

    @Override // k.AbstractC0650d
    public final boolean h() {
        int[] iArr;
        int i4 = this.f1988e;
        return i4 == 0 || ((iArr = this.f1987d) != null && iArr.length > 0 && i4 == 1) || (i4 == 2 && !TextUtils.isEmpty(this.f1989f));
    }
}
