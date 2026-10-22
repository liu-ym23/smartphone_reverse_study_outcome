package qe;

import a2.i;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import com.stepos.agentsafetycenter.R;
import java.util.ArrayList;
import java.util.Locale;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class c implements Comparable {

    /* renamed from: c, reason: collision with root package name */
    public i f10223c;

    /* renamed from: f, reason: collision with root package name */
    public String f10224f;

    /* renamed from: g, reason: collision with root package name */
    public a f10225g;

    /* renamed from: h, reason: collision with root package name */
    public ArrayList f10226h;

    public final String a(Context context) throws Resources.NotFoundException {
        String string;
        String str = this.f10224f;
        a aVar = this.f10225g;
        if ("zh_CN".equals(Locale.getDefault().toString()) && aVar != null && !TextUtils.isEmpty(aVar.f10219b)) {
            return aVar.f10219b;
        }
        PackageManager packageManager = (PackageManager) this.f10223c.f49f;
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
        a aVar2 = this.f10225g;
        if (aVar2 != null && (aVar = cVar.f10225g) != null) {
            return aVar2.f10218a - aVar.f10218a;
        }
        if (aVar2 != null) {
            return -1;
        }
        return cVar.f10225g != null ? 1 : 0;
    }
}
