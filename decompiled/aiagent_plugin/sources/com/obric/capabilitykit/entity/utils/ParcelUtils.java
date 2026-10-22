package com.obric.capabilitykit.entity.utils;

import android.os.Parcel;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.apm.impl.a;
import d.h.b.o;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
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

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.w(r0, r1);
    }

    private final int addOrThrow(int r3, int r4) {
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
        o.e(r5, "<this>");
        int r0 = r5.dataPosition();
        if (isLengthPrefixed(r5.readInt()) == false) goto L7;
        int r1 = r5.readInt();
        if (r1 < 0) goto L7;
        Integer r4 = Integer.valueOf(addOrThrow(r5.dataPosition(), r1));
    L14:
        r5.setDataPosition(r0);     // Catch: Exception -> L10
        return r5.readValue(r6);
    L10:
        INVOKESTATIC_com_obric_capabilitykit_entity_utils_ParcelUtils_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w("ParcelUtils", "unsupported type");
        if (r4 == null) goto L13;
        r5.setDataPosition(r4.intValue());
    L13:
        return null;
    L7:
        r4 = null;
        goto L14
    }

    public final void skipValueSafely(Parcel r3, ClassLoader r4) {
        o.e(r3, "<this>");
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

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_capabilitykit_entity_utils_ParcelUtils_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2) {
        if (a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }
}
