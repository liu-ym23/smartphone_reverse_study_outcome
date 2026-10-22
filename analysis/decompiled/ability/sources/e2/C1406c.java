package e2;

import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;

/* renamed from: e2.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1406c {

    /* renamed from: a, reason: collision with root package name */
    public final String f4335a;
    public final String b;
    public String c;
    public A0.b d;
    public A5.c f;
    public String g;
    public int h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public String f4336j;
    public HashMap k;
    public int e = 0;
    public String l = null;
    public boolean m = false;

    public C1406c(String str, String str2, String str3) {
        this.f4335a = str;
        this.c = str3;
        if (TextUtils.isEmpty(str3)) {
            Log.e("InitConfig", "channel is empty, please check!!!");
        }
        this.b = str2;
        if (TextUtils.isEmpty(str2)) {
            Log.e("InitConfig", "token is empty, please check!!!");
        }
    }
}
