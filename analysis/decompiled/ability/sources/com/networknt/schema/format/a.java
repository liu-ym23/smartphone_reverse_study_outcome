package com.networknt.schema.format;

import androidx.core.app.NotificationCompat;
import com.networknt.org.apache.commons.validator.routines.EmailValidator;
import x3.d;

/* loaded from: classes3.dex */
public final class a implements d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3016a;
    public final EmailValidator b;

    public a(int i) {
        this.f3016a = i;
        switch (i) {
            case 1:
                this.b = new IPv6AwareEmailValidator(true, true);
                break;
            default:
                this.b = new IPv6AwareEmailValidator(true, true);
                break;
        }
    }

    @Override // x3.d
    public final String a() {
        switch (this.f3016a) {
            case 0:
                return "format.email";
            default:
                return "format.idn-email";
        }
    }

    @Override // x3.d
    public final String getName() {
        switch (this.f3016a) {
            case 0:
                return NotificationCompat.CATEGORY_EMAIL;
            default:
                return "idn-email";
        }
    }

    @Override // x3.d
    public final boolean matches(String str) {
        switch (this.f3016a) {
        }
        return this.b.a(str);
    }
}
