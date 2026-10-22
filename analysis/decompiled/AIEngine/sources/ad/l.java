package ad;

import java.nio.charset.Charset;
import kotlin.text.Regex;
import mb.y;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final String f100a;

    /* renamed from: b, reason: collision with root package name */
    public final String f101b;

    /* renamed from: c, reason: collision with root package name */
    public final String f102c;

    /* renamed from: d, reason: collision with root package name */
    public final String[] f103d;

    public l(String mediaType, String str, String str2, String[] parameterNamesAndValues) {
        kotlin.jvm.internal.g.f(mediaType, "mediaType");
        kotlin.jvm.internal.g.f(parameterNamesAndValues, "parameterNamesAndValues");
        this.f100a = mediaType;
        this.f101b = str;
        this.f102c = str2;
        this.f103d = parameterNamesAndValues;
    }

    public static Charset a(l lVar) {
        String str;
        lVar.getClass();
        Regex regex = bd.d.f3219a;
        String[] strArr = lVar.f103d;
        int i10 = 0;
        int iZ = y.z(0, strArr.length - 1, 2);
        if (iZ < 0) {
            str = null;
            break;
        }
        while (!gc.o.f0(strArr[i10], "charset")) {
            if (i10 == iZ) {
                str = null;
                break;
            }
            i10 += 2;
        }
        str = strArr[i10 + 1];
        if (str == null) {
            return null;
        }
        try {
            return Charset.forName(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public final boolean equals(Object obj) {
        Regex regex = bd.d.f3219a;
        return (obj instanceof l) && kotlin.jvm.internal.g.b(((l) obj).f100a, this.f100a);
    }

    public final int hashCode() {
        Regex regex = bd.d.f3219a;
        return this.f100a.hashCode();
    }

    public final String toString() {
        Regex regex = bd.d.f3219a;
        return this.f100a;
    }
}
