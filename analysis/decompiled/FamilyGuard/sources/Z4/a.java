package Z4;

import android.content.Context;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private int f6657a;

    /* renamed from: b, reason: collision with root package name */
    private String f6658b;

    /* renamed from: c, reason: collision with root package name */
    private int f6659c;

    /* renamed from: d, reason: collision with root package name */
    private int f6660d;

    public a(int i5, String str, int i6) {
        this.f6657a = i5;
        this.f6658b = str;
        this.f6660d = i6;
    }

    public String a(Context context) {
        return this.f6659c != 0 ? context.getResources().getString(this.f6659c) : this.f6658b;
    }

    public int b() {
        return this.f6657a;
    }
}
