package K7;

import android.text.TextUtils;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public final String f4111a;

    /* renamed from: b, reason: collision with root package name */
    public final d f4112b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f4113c;

    public e(String str, d dVar) {
        this.f4111a = str;
        this.f4112b = dVar;
        this.f4113c = (TextUtils.isEmpty(str) || dVar == null) ? false : true;
    }

    public String a() {
        if (this.f4113c) {
            return this.f4112b.f4110d;
        }
        return null;
    }

    public String b() {
        if (this.f4113c) {
            return this.f4112b.f4109c;
        }
        return null;
    }

    public String c() {
        if (this.f4113c) {
            return this.f4112b.f4108b;
        }
        return null;
    }

    public boolean d() {
        return this.f4113c;
    }
}
