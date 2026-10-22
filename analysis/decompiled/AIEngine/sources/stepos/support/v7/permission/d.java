package stepos.support.v7.permission;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import com.stepos.aiengine.R;
import com.stepos.core.common.util.TraceIdKeys;
import java.util.ArrayList;
import java.util.Locale;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d implements Comparable<d> {

    /* renamed from: a, reason: collision with root package name */
    public final b f12315a;

    /* renamed from: b, reason: collision with root package name */
    public final String f12316b;

    /* renamed from: c, reason: collision with root package name */
    public final a f12317c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f12318d = new ArrayList();

    public d(String str, a aVar, b bVar) {
        this.f12316b = str;
        this.f12317c = aVar;
        this.f12315a = bVar;
    }

    public final String a(Context context) throws Resources.NotFoundException {
        String string;
        a aVar;
        if ("zh_CN".equals(Locale.getDefault().toString()) && (aVar = this.f12317c) != null) {
            String str = aVar.f12310b;
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        PackageManager packageManager = this.f12315a.f12311a;
        String str2 = this.f12316b;
        if ("stepos.permission-group.NETWORK".equals(str2)) {
            string = context.getResources().getString(R.string.stepos_permissiongroup_name_net);
        } else if ("stepos.permission-group.CHANGE_NETWORK".equals(str2)) {
            string = context.getResources().getString(R.string.stepos_permissiongroup_name_change_network);
        } else if ("stepos.permission-group.BLUETOOTH".equals(str2)) {
            string = context.getResources().getString(R.string.stepos_permissiongroup_name_bluetooth);
        } else if ("stepos.permission-group.OTHER".equals(str2)) {
            string = context.getResources().getString(R.string.stepos_permissiongroup_name_other);
        } else {
            try {
                string = packageManager.getPermissionGroupInfo(str2, TraceIdKeys.MAX_LENGTH).loadDescription(packageManager).toString();
            } catch (PackageManager.NameNotFoundException unused) {
                string = null;
            }
        }
        return TextUtils.isEmpty(string) ? str2 : string;
    }

    @Override // java.lang.Comparable
    public final int compareTo(d dVar) {
        a aVar;
        d dVar2 = dVar;
        a aVar2 = this.f12317c;
        if (aVar2 != null && (aVar = dVar2.f12317c) != null) {
            return aVar2.f12309a - aVar.f12309a;
        }
        if (aVar2 != null) {
            return -1;
        }
        return dVar2.f12317c != null ? 1 : 0;
    }
}
