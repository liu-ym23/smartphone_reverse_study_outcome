package stepos.support.v7.permission;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.stepos.ability.R;
import java.util.ArrayList;
import java.util.Locale;
import w0.C2086g;

/* loaded from: classes4.dex */
public final class c implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final C2086g f6372a;
    public final String b;
    public final a c;
    public final ArrayList d = new ArrayList();

    public c(String str, a aVar, C2086g c2086g) {
        this.b = str;
        this.c = aVar;
        this.f6372a = c2086g;
    }

    public final String a(Context context) {
        String string;
        a aVar;
        if ("zh_CN".equals(Locale.getDefault().toString()) && (aVar = this.c) != null && !TextUtils.isEmpty(aVar.b)) {
            return aVar.b;
        }
        PackageManager packageManager = (PackageManager) this.f6372a.f6811a;
        String str = this.b;
        if ("stepos.permission-group.NETWORK".equals(str)) {
            string = context.getResources().getString(R.string.stepos_permissiongroup_name_net);
        } else if ("stepos.permission-group.CHANGE_NETWORK".equals(str)) {
            string = context.getResources().getString(R.string.stepos_permissiongroup_name_change_network);
        } else if ("stepos.permission-group.BLUETOOTH".equals(str)) {
            string = context.getResources().getString(R.string.stepos_permissiongroup_name_bluetooth);
        } else if ("stepos.permission-group.OTHER".equals(str)) {
            string = context.getResources().getString(R.string.stepos_permissiongroup_name_other);
        } else {
            try {
                string = packageManager.getPermissionGroupInfo(str, 128).loadDescription(packageManager).toString();
            } catch (PackageManager.NameNotFoundException unused) {
                string = null;
            }
        }
        return TextUtils.isEmpty(string) ? str : string;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        a aVar;
        c cVar = (c) obj;
        a aVar2 = this.c;
        if (aVar2 != null && (aVar = cVar.c) != null) {
            return aVar2.f6370a - aVar.f6370a;
        }
        if (aVar2 != null) {
            return -1;
        }
        return cVar.c != null ? 1 : 0;
    }
}
