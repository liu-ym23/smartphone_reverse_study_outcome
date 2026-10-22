package androidx.preference;

import android.text.TextUtils;

/* loaded from: classes.dex */
public final class B {

    /* renamed from: a, reason: collision with root package name */
    public final int f4002a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4003b;

    /* renamed from: c, reason: collision with root package name */
    public final String f4004c;

    public B(Preference preference) {
        this.f4004c = preference.getClass().getName();
        this.f4002a = preference.f4068E;
        this.f4003b = preference.f4069F;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof B)) {
            return false;
        }
        B b4 = (B) obj;
        return this.f4002a == b4.f4002a && this.f4003b == b4.f4003b && TextUtils.equals(this.f4004c, b4.f4004c);
    }

    public final int hashCode() {
        return this.f4004c.hashCode() + ((((527 + this.f4002a) * 31) + this.f4003b) * 31);
    }
}
