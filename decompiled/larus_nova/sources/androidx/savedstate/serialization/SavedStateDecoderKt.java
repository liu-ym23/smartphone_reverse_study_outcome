package androidx.savedstate.serialization;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import juc.v;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlinx.serialization.modules.d;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000$\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a0\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\n\u0010\u0003\u001a\u00060\u0004j\u0002`\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0086\b¢\u0006\u0002\u0010\b\u001a;\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\n2\n\u0010\u0003\u001a\u00060\u0004j\u0002`\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"decodeFromSavedState", ExifInterface.GPS_DIRECTION_TRUE, "", "savedState", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "configuration", "Landroidx/savedstate/serialization/SavedStateConfiguration;", "(Landroid/os/Bundle;Landroidx/savedstate/serialization/SavedStateConfiguration;)Ljava/lang/Object;", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/DeserializationStrategy;Landroid/os/Bundle;Landroidx/savedstate/serialization/SavedStateConfiguration;)Ljava/lang/Object;", "savedstate"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SavedStateDecoderKt {
    public static final <T> T decodeFromSavedState(juc.c<? extends T> r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "deserializer");
        Intrinsics.checkNotNullParameter(r101, "savedState");
        return (T) decodeFromSavedState$default(r100, r101, null, 4, null);
    }

    public static final /* synthetic */ <T> T decodeFromSavedState(Bundle r100, SavedStateConfiguration r101) {
        Intrinsics.checkNotNullParameter(r100, "savedState");
        Intrinsics.checkNotNullParameter(r101, "configuration");
        d r102 = r101.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        return (T) decodeFromSavedState(v.d(r102, null), r100, r101);
    }

    public static final <T> T decodeFromSavedState(juc.c<? extends T> r100, Bundle r101, SavedStateConfiguration r102) {
        Intrinsics.checkNotNullParameter(r100, "deserializer");
        Intrinsics.checkNotNullParameter(r101, "savedState");
        Intrinsics.checkNotNullParameter(r102, "configuration");
        return (T) new SavedStateDecoder(r101, r102).decodeSerializableValue(r100);
    }

    public static /* synthetic */ Object decodeFromSavedState$default(Bundle r100, SavedStateConfiguration r101, int r102, Object r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = SavedStateConfiguration.DEFAULT;
    L5:
        Intrinsics.checkNotNullParameter(r100, "savedState");
        Intrinsics.checkNotNullParameter(r101, "configuration");
        d r104 = r101.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        return decodeFromSavedState(v.d(r104, null), r100, r101);
    }

    public static /* synthetic */ Object decodeFromSavedState$default(juc.c r100, Bundle r101, SavedStateConfiguration r102, int r103, Object r104) {
        if ((r103 & 4) == 0) goto L6;
        r102 = SavedStateConfiguration.DEFAULT;
    L6:
        return decodeFromSavedState(r100, r101, r102);
    }
}
