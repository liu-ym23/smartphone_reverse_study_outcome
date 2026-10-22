package g6;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

/* loaded from: classes.dex */
public final class b extends a {

    /* renamed from: e, reason: collision with root package name */
    public int[] f3855e;

    /* renamed from: f, reason: collision with root package name */
    public int f3856f;

    /* renamed from: g, reason: collision with root package name */
    public String f3857g;

    /* renamed from: h, reason: collision with root package name */
    public String f3858h;

    @Override // g6.a
    public final a a() {
        return null;
    }

    @Override // g6.a
    public final String b(a aVar) {
        return null;
    }

    @Override // g6.a
    public final Intent[] f(Context context) {
        int[] iArr;
        if (this.f3856f != 1 || (iArr = this.f3855e) == null) {
            Intent intent = new Intent();
            intent.putExtra("strategy_package_name", this.f3858h);
            intent.putExtra("strategy_type", 64);
            intent.putExtra("strategy_child_type", this.f3856f);
            if (this.f3856f == 2) {
                intent.putExtra("strategy_params", this.f3857g);
            }
            return new Intent[]{intent};
        }
        Intent[] intentArr = new Intent[iArr.length];
        for (int i2 = 0; i2 < this.f3855e.length; i2++) {
            j6.a.b(this.f3852b, "send notifyId " + this.f3855e[i2] + " to PushManagerService");
            Intent intent2 = new Intent();
            intent2.putExtra("strategy_package_name", this.f3858h);
            intent2.putExtra("strategy_type", 64);
            intent2.putExtra("strategy_child_type", this.f3856f);
            intent2.putExtra("strategy_params", "" + this.f3855e[i2]);
            intentArr[i2] = intent2;
        }
        return intentArr;
    }

    @Override // g6.a
    public final String g() {
        return null;
    }

    @Override // g6.a
    public final boolean h() {
        int[] iArr;
        int i2 = this.f3856f;
        return i2 == 0 || ((iArr = this.f3855e) != null && iArr.length > 0 && i2 == 1) || (i2 == 2 && !TextUtils.isEmpty(this.f3857g));
    }
}
