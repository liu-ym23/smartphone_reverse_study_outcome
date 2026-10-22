package stepos.support.v7.permission;

import android.content.Context;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public int f40841a;

    /* renamed from: b, reason: collision with root package name */
    public String f40842b;

    /* renamed from: c, reason: collision with root package name */
    public int f40843c;

    /* renamed from: d, reason: collision with root package name */
    public int f40844d;

    public a(int i10, String str, int i11) {
        this.f40841a = i10;
        this.f40842b = str;
        this.f40844d = i11;
    }

    public String a(Context context) {
        return this.f40843c != 0 ? context.getResources().getString(this.f40843c) : this.f40842b;
    }

    public int b() {
        return this.f40841a;
    }
}
