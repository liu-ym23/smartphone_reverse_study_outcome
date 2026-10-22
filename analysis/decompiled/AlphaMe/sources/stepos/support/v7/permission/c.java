package stepos.support.v7.permission;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.stepos.alphame.R;
import java.util.ArrayList;
import java.util.Locale;
import stepos.support.v7.app.C0872q;

/* loaded from: classes2.dex */
public final class c implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final C0872q f14645a;

    /* renamed from: b, reason: collision with root package name */
    public final String f14646b;

    /* renamed from: c, reason: collision with root package name */
    public final a f14647c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f14648d = new ArrayList();

    public c(String str, a aVar, C0872q c0872q) {
        this.f14646b = str;
        this.f14647c = aVar;
        this.f14645a = c0872q;
    }

    public final String a(Context context) {
        String string;
        a aVar;
        if ("zh_CN".equals(Locale.getDefault().toString()) && (aVar = this.f14647c) != null && !TextUtils.isEmpty(aVar.f14641b)) {
            return aVar.f14641b;
        }
        Object obj = this.f14645a.f14583b;
        String str = this.f14646b;
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
                string = ((PackageManager) obj).getPermissionGroupInfo(str, 128).loadDescription((PackageManager) obj).toString();
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
        a aVar2 = this.f14647c;
        if (aVar2 != null && (aVar = cVar.f14647c) != null) {
            return aVar2.f14640a - aVar.f14640a;
        }
        if (aVar2 != null) {
            return -1;
        }
        return cVar.f14647c != null ? 1 : 0;
    }
}
