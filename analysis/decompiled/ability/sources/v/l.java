package v;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* loaded from: classes2.dex */
public final class l extends A8.b {
    public final SharedPreferences b;
    public final SharedPreferences c;

    public l(Context context, String str) {
        if (context == null) {
            throw new IllegalArgumentException("context can't be null");
        }
        this.b = context.getSharedPreferences("snssdk_openudid", 0);
        this.c = context.getSharedPreferences(str, 0);
    }

    @Override // A8.b
    public final void J0(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        SharedPreferences.Editor editorEdit = P0(str).edit();
        editorEdit.putString(str, str2);
        editorEdit.apply();
    }

    @Override // A8.b
    public final String M0(String str) {
        return P0(str).getString(str, null);
    }

    public final SharedPreferences P0(String str) {
        return "device_id".equals(str) ? this.c : this.b;
    }
}
