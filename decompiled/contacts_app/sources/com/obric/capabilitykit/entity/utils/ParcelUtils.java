package com.obric.capabilitykit.entity.utils;

import android.os.Parcel;
import com.GlobalProxyLancet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004H\u0002J\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u0001*\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0014\u0010\u0015\u001a\u00020\u0016*\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/capabilitykit/entity/utils/ParcelUtils;", "", "()V", "VAL_LIST", "", "VAL_MAP", "VAL_OBJECTARRAY", "VAL_PARCELABLE", "VAL_PARCELABLEARRAY", "VAL_SERIALIZABLE", "VAL_SPARSEARRAY", "addOrThrow", "a", "b", "isLengthPrefixed", "", "type", "readValueSafely", "Landroid/os/Parcel;", "loader", "Ljava/lang/ClassLoader;", "skipValueSafely", "", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ParcelUtils {
    public static final ParcelUtils INSTANCE = null;
    private static final int VAL_LIST = 11;
    private static final int VAL_MAP = 2;
    private static final int VAL_OBJECTARRAY = 17;
    private static final int VAL_PARCELABLE = 4;
    private static final int VAL_PARCELABLEARRAY = 16;
    private static final int VAL_SERIALIZABLE = 21;
    private static final int VAL_SPARSEARRAY = 12;

    static {
        INSTANCE = new ParcelUtils();
    }

    private ParcelUtils() {
    }

    private final int addOrThrow(int r3, int r4) throws IllegalArgumentException {
        if (r4 != 0) goto L4;
        return r3;
    L4:
        if (r4 > 0) goto L6;
    L9:
        if (r4 >= 0) goto L15;
        if (r3 < (Integer.MIN_VALUE - r4)) goto L15;
        return r3 + r4;
    L15:
        throw new IllegalArgumentException("Addition overflow: " + r3 + " + " + r4);
    L6:
        if (r3 > (Integer.MAX_VALUE - r4)) goto L9;
        return r3 + r4;
    }

    private final boolean isLengthPrefixed(int r1) {
        if (r1 != 2) goto L5;
    L17:
        return true;
    L5:
        if (r1 == 4) goto L17;
        if (r1 == 21) goto L17;
        if (r1 == 11) goto L17;
        if (r1 == 12) goto L17;
        if (r1 == 16) goto L17;
        if (r1 == 17) goto L17;
        return false;
    }

    public final Object readValueSafely(Parcel r5, ClassLoader r6) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        int r0 = r5.dataPosition();
        if (isLengthPrefixed(r5.readInt()) == false) goto L7;
        int r1 = r5.readInt();
        if (r1 < 0) goto L7;
        Integer r4 = Integer.valueOf(addOrThrow(r5.dataPosition(), r1));
    L14:
        r5.setDataPosition(r0);     // Catch: Exception -> L10
        return r5.readValue(r6);
    L10:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w("ParcelUtils", "unsupported type");
        if (r4 == null) goto L13;
        r5.setDataPosition(r4.intValue());
    L13:
        return null;
    L7:
        r4 = null;
        goto L14
    }

    public final void skipValueSafely(Parcel r3, ClassLoader r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        int r0 = r3.dataPosition();
        if (isLengthPrefixed(r3.readInt()) == false) goto L8;
        int r5 = r3.readInt();
        if (r5 >= 0) goto L7;
        return;
    L7:
        r3.setDataPosition(addOrThrow(r3.dataPosition(), r5));
        return;
    L8:
        r3.setDataPosition(r0);
        r3.readValue(r4);
    }
}
