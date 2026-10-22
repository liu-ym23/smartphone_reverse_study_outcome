package K4;

import android.text.TextUtils;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f907a;
    public final String b;
    public final byte[] c;

    public a(String str, String str2, String str3) {
        this.f907a = str;
        this.b = str2;
        if (TextUtils.isEmpty(str3)) {
            this.c = null;
        } else {
            this.c = str3.getBytes(StandardCharsets.ISO_8859_1);
        }
    }

    public final String toString() {
        return "AccountInfo{nickName='" + this.f907a + "', phone='" + this.b + "', iconBytes=" + Arrays.toString(this.c) + '}';
    }
}
