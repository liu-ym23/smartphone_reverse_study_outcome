package b0c;

import com.larksuite.framework.utils.b;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import e0c.k;

/* JADX INFO: loaded from: classes37.dex */
public final class a {
    public static final String a(User r100) {
        if (r100 == null) goto L5;
        String r101 = r100.localizedDisplayName(((zzb.a) k.a(b.f285948a, zzb.a.class)).getLanguageSetting());
        if (r101 == null) goto L5;
        return r101;
    L5:
        return "";
    }
}
