package com.obric.capabilitykit.entity.utils;

import android.os.Parcel;
import android.util.Log;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.channels.Channel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004H\u0002J\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u0001*\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0014\u0010\u0015\u001a\u00020\u0016*\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/capabilitykit/entity/utils/ParcelUtils;", "", "()V", "VAL_LIST", "", "VAL_MAP", "VAL_OBJECTARRAY", "VAL_PARCELABLE", "VAL_PARCELABLEARRAY", "VAL_SERIALIZABLE", "VAL_SPARSEARRAY", "addOrThrow", "a", "b", "isLengthPrefixed", "", "type", "readValueSafely", "Landroid/os/Parcel;", "loader", "Ljava/lang/ClassLoader;", "skipValueSafely", "", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ParcelUtils {

    @NotNull
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

    private final int addOrThrow(int r10, int r11) throws IllegalArgumentException {
        if (r11 != 0) goto L4;
        return r10;
    L4:
        if (r11 > 0) goto L6;
    L9:
        if (r11 >= 0) goto L15;
        if (r10 < (Integer.MIN_VALUE - r11)) goto L15;
        return r10 + r11;
    L15:
        throw new IllegalArgumentException("Addition overflow: " + r10 + " + " + r11);
    L6:
        if (r10 > (Channel.UNLIMITED - r11)) goto L9;
        return r10 + r11;
    }

    private final boolean isLengthPrefixed(int r10) {
        if (r10 != 2) goto L5;
    L17:
        return true;
    L5:
        if (r10 == 4) goto L17;
        if (r10 == 21) goto L17;
        if (r10 == 11) goto L17;
        if (r10 == 12) goto L17;
        if (r10 == 16) goto L17;
        if (r10 == 17) goto L17;
        return false;
    }

    @Nullable
    public final Object readValueSafely(@NotNull Parcel r10, @Nullable ClassLoader r11) {
        q.g(r10, "<this>");
        int r12 = r10.dataPosition();
        if (isLengthPrefixed(r10.readInt()) == false) goto L7;
        int r13 = r10.readInt();
        if (r13 < 0) goto L7;
        Integer r14 = Integer.valueOf(addOrThrow(r10.dataPosition(), r13));
    L14:
        r10.setDataPosition(r12);     // Catch: Exception -> L10
        return r10.readValue(r11);
    L10:
        Log.w("ParcelUtils", "unsupported type");
        if (r14 == null) goto L13;
        r10.setDataPosition(r14.intValue());
    L13:
        return null;
    L7:
        r14 = null;
        goto L14
    }

    public final void skipValueSafely(@NotNull Parcel r10, @Nullable ClassLoader r11) {
        q.g(r10, "<this>");
        int r12 = r10.dataPosition();
        if (isLengthPrefixed(r10.readInt()) == false) goto L8;
        int r13 = r10.readInt();
        if (r13 >= 0) goto L7;
        return;
    L7:
        r10.setDataPosition(addOrThrow(r10.dataPosition(), r13));
        return;
    L8:
        r10.setDataPosition(r12);
        r10.readValue(r11);
    }
}
