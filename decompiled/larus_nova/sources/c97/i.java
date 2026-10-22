package c97;

import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;

/* JADX INFO: loaded from: classes21.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f22895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f22896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f22897c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PolarisFileWrapper f22898d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f22899e;

    public i() {
        this.f22899e = true;
    }

    public final boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if (r100 != null) goto L9;
        return false;
    L9:
        if ((r100 instanceof i) == true) goto L11;
        return false;
    L11:
        i r101 = (i) r100;
        if (TextUtils.equals(this.f22896b, r101.f22896b) == true) goto L14;
    L18:
        return false;
    L14:
        if (TextUtils.equals(this.f22897c, r101.f22897c) == false) goto L18;
        if (TextUtils.equals(this.f22895a, r101.f22895a) == false) goto L18;
        return true;
    }
}
