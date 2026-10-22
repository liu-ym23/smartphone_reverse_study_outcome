package b1c;

import android.content.Context;
import android.text.TextUtils;
import com.larksuite.framework.utils.z;

/* JADX INFO: loaded from: classes37.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f16967a;

    public b(Context r100) {
        this.f16967a = r100;
    }

    public final String a(String r100) {
        String r101 = z.c(this.f16967a);
        if (TextUtils.isEmpty(r100) == false) goto L10;
        if (TextUtils.isEmpty(r101) == false) goto L10;
        throw new IllegalArgumentException("shared preference name should be passed!");
    L10:
        if (TextUtils.isEmpty(r100) == false) goto L14;
        return r101 + ":unknown";
    L14:
        if (TextUtils.isEmpty(r101) == false) goto L17;
        return r100;
    L17:
        return r101 + ":" + r100;
    }
}
