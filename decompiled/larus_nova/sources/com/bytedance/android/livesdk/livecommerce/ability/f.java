package com.bytedance.android.livesdk.livecommerce.ability;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/ability/f;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "service", "Ljava/lang/String;", "getService", "()Ljava/lang/String;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f147637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f147638b;

    @SerializedName("service")
    private final String service;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L12;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.service, r101.service) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f147637a, r101.f147637a) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f147638b, r101.f147638b) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.service;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f147637a;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        T r107 = this.f147638b;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "LiveAtomicAction(service=" + this.service + ", action=" + this.f147637a + ", params=" + this.f147638b + ")";
    }

    public f(String r100, String r101, T r102) {
        Intrinsics.checkNotNullParameter(r101, "action");
        this.service = r100;
        this.f147637a = r101;
        this.f147638b = r102;
    }
}
