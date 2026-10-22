package p7;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b extends a {

    /* renamed from: d, reason: collision with root package name */
    public int[] f11460d;

    /* renamed from: e, reason: collision with root package name */
    public int f11461e;

    /* renamed from: f, reason: collision with root package name */
    public String f11462f;

    /* renamed from: g, reason: collision with root package name */
    public String f11463g;

    @Override // p7.a
    public final String a(l.b bVar) {
        return null;
    }

    @Override // p7.a
    public final l.b b() {
        return null;
    }

    @Override // p7.a
    public final Intent[] d(Context context) {
        int[] iArr;
        if (this.f11461e != 1 || (iArr = this.f11460d) == null) {
            Intent intent = new Intent();
            intent.putExtra("strategy_package_name", this.f11463g);
            intent.putExtra("strategy_type", 64);
            intent.putExtra("strategy_child_type", this.f11461e);
            if (this.f11461e == 2) {
                intent.putExtra("strategy_params", this.f11462f);
            }
            return new Intent[]{intent};
        }
        Intent[] intentArr = new Intent[iArr.length];
        for (int i10 = 0; i10 < this.f11460d.length; i10++) {
            s7.a.b(this.f11457a, "send notifyId " + this.f11460d[i10] + " to PushManagerService");
            Intent intent2 = new Intent();
            intent2.putExtra("strategy_package_name", this.f11463g);
            intent2.putExtra("strategy_type", 64);
            intent2.putExtra("strategy_child_type", this.f11461e);
            intent2.putExtra("strategy_params", "" + this.f11460d[i10]);
            intentArr[i10] = intent2;
        }
        return intentArr;
    }

    @Override // p7.a
    public final String e() {
        return null;
    }

    @Override // p7.a
    public final boolean f() {
        int[] iArr;
        int i10 = this.f11461e;
        return i10 == 0 || ((iArr = this.f11460d) != null && iArr.length > 0 && i10 == 1) || (i10 == 2 && !TextUtils.isEmpty(this.f11462f));
    }
}
