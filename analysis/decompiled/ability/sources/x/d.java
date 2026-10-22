package x;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.util.UUID;
import w.AbstractC2079a;

/* loaded from: classes2.dex */
public final class d extends AbstractC2079a {
    public final /* synthetic */ int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(int i) {
        super(1);
        this.c = i;
    }

    @Override // w.AbstractC2079a
    public final Object a(Object[] objArr) {
        Boolean boolValueOf;
        switch (this.c) {
            case 0:
                SharedPreferences sharedPreferences = (SharedPreferences) objArr[0];
                String string = sharedPreferences.getString("cdid", "");
                if (!TextUtils.isEmpty(string)) {
                    return string;
                }
                String string2 = UUID.randomUUID().toString();
                sharedPreferences.edit().putString("cdid", string2).apply();
                return string2;
            case 1:
                return new i((Context) objArr[0]);
            case 2:
                return Boolean.valueOf(D2.c.a((Context) objArr[0], "com.huawei.hwid"));
            case 3:
                try {
                    PackageManager packageManager = ((Context) objArr[0]).getPackageManager();
                    if (packageManager != null) {
                        return Boolean.valueOf(packageManager.resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null);
                    }
                } catch (Exception unused) {
                }
                return Boolean.FALSE;
            case 4:
                return Boolean.valueOf("1".equals(k.a()));
            default:
                try {
                    PackageInfo packageInfoB = D2.c.b((Context) objArr[0], "com.heytap.openid", 0);
                    if (packageInfoB == null) {
                        boolValueOf = Boolean.FALSE;
                    } else {
                        boolValueOf = Boolean.valueOf(packageInfoB.getLongVersionCode() >= 1);
                    }
                    return boolValueOf;
                } catch (Exception e) {
                    e.printStackTrace();
                    return Boolean.FALSE;
                }
        }
    }
}
