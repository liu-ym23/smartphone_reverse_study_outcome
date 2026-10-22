package a87;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements f {
    public a() {
    }

    @Override // a87.f
    public final Bundle a(Context r100, Bundle r101, String r102) {
        if (r101 != null) goto L5;
        return null;
    L5:
        String r103 = r101.getString("_storage_key");
        String r104 = r101.getString("_key");
        if (TextUtils.isEmpty(r103) == false) goto L8;
        return null;
    L8:
        if (TextUtils.isEmpty(r104) == true) goto L13;
        Bundle r105 = new Bundle();
        int r106 = q77.a.f531973a;
        r105.putBoolean("_result", j77.i.f497636a.a(r100, true, r103, r102).contains(r104));
        return r105;
    L13:
        return null;
    }
}
