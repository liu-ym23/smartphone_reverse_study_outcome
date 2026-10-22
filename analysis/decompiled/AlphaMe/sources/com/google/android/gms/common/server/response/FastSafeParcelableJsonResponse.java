package com.google.android.gms.common.server.response;

import B0.f;
import android.util.Base64;
import com.airbnb.lottie.h;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import com.stepos.statsrpk.c;
import e1.AbstractC0551a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import s.AbstractC0831a;

@ShowFirstParty
@KeepForSdk
/* loaded from: classes.dex */
public abstract class FastSafeParcelableJsonResponse implements SafeParcelable {
    public static final Object k(FastJsonResponse$Field fastJsonResponse$Field, Object obj) {
        StringToIntConverter stringToIntConverter = fastJsonResponse$Field.f9915k;
        if (stringToIntConverter == null) {
            return obj;
        }
        String str = (String) stringToIntConverter.f9899c.get(((Integer) obj).intValue());
        return (str == null && stringToIntConverter.f9898b.containsKey("gms_unknown")) ? "gms_unknown" : str;
    }

    public static final void n(StringBuilder sb, FastJsonResponse$Field fastJsonResponse$Field, Object obj) {
        int i4 = fastJsonResponse$Field.f9906b;
        if (i4 == 11) {
            Class cls = fastJsonResponse$Field.f9912h;
            c.l(cls);
            sb.append(((FastSafeParcelableJsonResponse) cls.cast(obj)).toString());
        } else {
            if (i4 != 7) {
                sb.append(obj);
                return;
            }
            sb.append("\"");
            sb.append(AbstractC0551a.a((String) obj));
            sb.append("\"");
        }
    }

    public abstract Map c();

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!getClass().isInstance(obj)) {
            return false;
        }
        FastSafeParcelableJsonResponse fastSafeParcelableJsonResponse = (FastSafeParcelableJsonResponse) obj;
        for (FastJsonResponse$Field fastJsonResponse$Field : c().values()) {
            if (h(fastJsonResponse$Field)) {
                if (!fastSafeParcelableJsonResponse.h(fastJsonResponse$Field) || !h.m(f(fastJsonResponse$Field), fastSafeParcelableJsonResponse.f(fastJsonResponse$Field))) {
                    return false;
                }
            } else if (fastSafeParcelableJsonResponse.h(fastJsonResponse$Field)) {
                return false;
            }
        }
        return true;
    }

    public final Object f(FastJsonResponse$Field fastJsonResponse$Field) {
        if (fastJsonResponse$Field.f9912h == null) {
            return g();
        }
        Object objG = g();
        String str = fastJsonResponse$Field.f9910f;
        if (objG != null) {
            throw new IllegalStateException("Concrete field shouldn't be value object: " + str);
        }
        try {
            return getClass().getMethod("get" + Character.toUpperCase(str.charAt(0)) + str.substring(1), new Class[0]).invoke(this, new Object[0]);
        } catch (Exception e4) {
            throw new RuntimeException(e4);
        }
    }

    public Object g() {
        return null;
    }

    public final boolean h(FastJsonResponse$Field fastJsonResponse$Field) {
        if (fastJsonResponse$Field.f9908d != 11) {
            return i();
        }
        if (fastJsonResponse$Field.f9909e) {
            throw new UnsupportedOperationException("Concrete type arrays not supported");
        }
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    public final int hashCode() {
        int iHashCode = 0;
        for (FastJsonResponse$Field fastJsonResponse$Field : c().values()) {
            if (h(fastJsonResponse$Field)) {
                Object objF = f(fastJsonResponse$Field);
                c.l(objF);
                iHashCode = (iHashCode * 31) + objF.hashCode();
            }
        }
        return iHashCode;
    }

    public boolean i() {
        return false;
    }

    @Override // 
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public final String toString() {
        Map mapC = c();
        StringBuilder sb = new StringBuilder(100);
        for (String str : mapC.keySet()) {
            FastJsonResponse$Field fastJsonResponse$Field = (FastJsonResponse$Field) mapC.get(str);
            if (h(fastJsonResponse$Field)) {
                Object objK = k(fastJsonResponse$Field, f(fastJsonResponse$Field));
                if (sb.length() == 0) {
                    sb.append("{");
                } else {
                    sb.append(",");
                }
                AbstractC0831a.h(sb, "\"", str, "\":");
                if (objK != null) {
                    switch (fastJsonResponse$Field.f9908d) {
                        case 8:
                            sb.append("\"");
                            sb.append(Base64.encodeToString((byte[]) objK, 0));
                            sb.append("\"");
                            break;
                        case 9:
                            sb.append("\"");
                            sb.append(Base64.encodeToString((byte[]) objK, 10));
                            sb.append("\"");
                            break;
                        case 10:
                            f.E0(sb, (HashMap) objK);
                            break;
                        default:
                            if (fastJsonResponse$Field.f9907c) {
                                ArrayList arrayList = (ArrayList) objK;
                                sb.append("[");
                                int size = arrayList.size();
                                for (int i4 = 0; i4 < size; i4++) {
                                    if (i4 > 0) {
                                        sb.append(",");
                                    }
                                    Object obj = arrayList.get(i4);
                                    if (obj != null) {
                                        n(sb, fastJsonResponse$Field, obj);
                                    }
                                }
                                sb.append("]");
                                break;
                            } else {
                                n(sb, fastJsonResponse$Field, objK);
                                break;
                            }
                    }
                } else {
                    sb.append("null");
                }
            }
        }
        if (sb.length() > 0) {
            sb.append("}");
        } else {
            sb.append("{}");
        }
        return sb.toString();
    }
}
