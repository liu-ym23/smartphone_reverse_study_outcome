package v2;

import android.content.Context;
import android.content.Intent;

/* renamed from: v2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1183b extends f {
    public C1183b(Context context) {
        super(context);
    }

    @Override // v2.f
    protected Intent g() {
        return new Intent("com.stepos.digitalwellbeing.dws").setPackage(f().getApplicationContext().getPackageName());
    }

    public C1183b(Context context, boolean z5) {
        super(context, z5);
    }
}
