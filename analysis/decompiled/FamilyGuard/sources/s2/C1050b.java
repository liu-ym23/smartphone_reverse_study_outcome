package s2;

import android.text.TextUtils;
import android.util.Log;
import com.stepos.familyguard.R;
import l2.m;
import q2.l;

/* renamed from: s2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1050b {
    public static String a(m mVar) {
        Log.d("RelationUtils", "getMasterName  RelationUser masterRoleName: " + mVar.f18261s + "  masterRoleType:" + mVar.f18260r);
        if (!TextUtils.isEmpty(mVar.f18261s)) {
            return mVar.f18261s;
        }
        int i5 = mVar.f18260r;
        return i5 == 0 ? P1.a.b(R.string.fg_role_family, new Object[0]) : P1.a.b(l.a(i5).f19926b, new Object[0]);
    }
}
