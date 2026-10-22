package androidx.core.os;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a;\u0010\u0000\u001a\u00020\u00012.\u0010\u0002\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00040\u0003\"\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"bundleOf", "Landroid/os/Bundle;", "pairs", "", "Lkotlin/Pair;", "", "", "([Lkotlin/Pair;)Landroid/os/Bundle;", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BundleKt {
    public static final Bundle bundleOf() {
        return new Bundle(0);
    }

    public static final Bundle bundleOf(Pair<String, ? extends Object>... r100) {
        Bundle r101 = new Bundle(r100.length);
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L95;
        Pair<String, ? extends Object> r104 = r100[r103];
        String r105 = r104.component1();
        Object r106 = r104.component2();
        if (r106 != null) goto L8;
        r101.putString(r105, null);
    L92:
        r103 = r103 + 1;
        goto L3
    L8:
        if ((r106 instanceof Boolean) == false) goto L11;
        r101.putBoolean(r105, ((Boolean) r106).booleanValue());
        goto L92
    L11:
        if ((r106 instanceof Byte) == false) goto L14;
        r101.putByte(r105, ((Number) r106).byteValue());
        goto L92
    L14:
        if ((r106 instanceof Character) == false) goto L17;
        r101.putChar(r105, ((Character) r106).charValue());
        goto L92
    L17:
        if ((r106 instanceof Double) == false) goto L20;
        r101.putDouble(r105, ((Number) r106).doubleValue());
        goto L92
    L20:
        if ((r106 instanceof Float) == false) goto L23;
        r101.putFloat(r105, ((Number) r106).floatValue());
        goto L92
    L23:
        if ((r106 instanceof Integer) == false) goto L26;
        r101.putInt(r105, ((Number) r106).intValue());
        goto L92
    L26:
        if ((r106 instanceof Long) == false) goto L29;
        r101.putLong(r105, ((Number) r106).longValue());
        goto L92
    L29:
        if ((r106 instanceof Short) == false) goto L32;
        r101.putShort(r105, ((Number) r106).shortValue());
        goto L92
    L32:
        if ((r106 instanceof Bundle) == false) goto L35;
        r101.putBundle(r105, (Bundle) r106);
        goto L92
    L35:
        if ((r106 instanceof CharSequence) == false) goto L38;
        r101.putCharSequence(r105, (CharSequence) r106);
        goto L92
    L38:
        if ((r106 instanceof Parcelable) == false) goto L41;
        r101.putParcelable(r105, (Parcelable) r106);
        goto L92
    L41:
        if ((r106 instanceof boolean[]) == false) goto L44;
        r101.putBooleanArray(r105, (boolean[]) r106);
        goto L92
    L44:
        if ((r106 instanceof byte[]) == false) goto L47;
        r101.putByteArray(r105, (byte[]) r106);
        goto L92
    L47:
        if ((r106 instanceof char[]) == false) goto L50;
        r101.putCharArray(r105, (char[]) r106);
        goto L92
    L50:
        if ((r106 instanceof double[]) == false) goto L53;
        r101.putDoubleArray(r105, (double[]) r106);
        goto L92
    L53:
        if ((r106 instanceof float[]) == false) goto L56;
        r101.putFloatArray(r105, (float[]) r106);
        goto L92
    L56:
        if ((r106 instanceof int[]) == false) goto L59;
        r101.putIntArray(r105, (int[]) r106);
        goto L92
    L59:
        if ((r106 instanceof long[]) == false) goto L62;
        r101.putLongArray(r105, (long[]) r106);
        goto L92
    L62:
        if ((r106 instanceof short[]) == false) goto L65;
        r101.putShortArray(r105, (short[]) r106);
        goto L92
    L65:
        if ((r106 instanceof Object[]) == false) goto L81;
        Class<?> r107 = r106.getClass().getComponentType();
        Intrinsics.checkNotNull(r107);
        if (Parcelable.class.isAssignableFrom(r107) == false) goto L70;
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type kotlin.Array<android.os.Parcelable>");
        r101.putParcelableArray(r105, (Parcelable[]) r106);
        goto L92
    L70:
        if (String.class.isAssignableFrom(r107) == false) goto L73;
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
        r101.putStringArray(r105, (String[]) r106);
        goto L92
    L73:
        if (CharSequence.class.isAssignableFrom(r107) == false) goto L76;
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type kotlin.Array<kotlin.CharSequence>");
        r101.putCharSequenceArray(r105, (CharSequence[]) r106);
        goto L92
    L76:
        if (Serializable.class.isAssignableFrom(r107) == false) goto L79;
        r101.putSerializable(r105, (Serializable) r106);
        goto L92
    L79:
        throw new IllegalArgumentException("Illegal value array type " + r107.getCanonicalName() + " for key \"" + r105 + Typography.quote);
    L81:
        if ((r106 instanceof Serializable) == false) goto L84;
        r101.putSerializable(r105, (Serializable) r106);
        goto L92
    L84:
        if ((r106 instanceof IBinder) == false) goto L87;
        r101.putBinder(r105, (IBinder) r106);
        goto L92
    L87:
        if ((r106 instanceof Size) == false) goto L90;
        BundleApi21ImplKt.putSize(r101, r105, (Size) r106);
        goto L92
    L90:
        if ((r106 instanceof SizeF) == false) goto L94;
        BundleApi21ImplKt.putSizeF(r101, r105, (SizeF) r106);
        goto L92
    L94:
        throw new IllegalArgumentException("Illegal value type " + r106.getClass().getCanonicalName() + " for key \"" + r105 + Typography.quote);
    L95:
        return r101;
    }
}
