package androidx.core.os;

import android.os.Build;
import android.os.PersistableBundle;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J$\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0007¨\u0006\r"}, d2 = {"Landroidx/core/os/PersistableBundleApi21ImplKt;", "", "()V", "createPersistableBundle", "Landroid/os/PersistableBundle;", "capacity", "", "putValue", "", "persistableBundle", "key", "", "value", "core-ktx_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class PersistableBundleApi21ImplKt {
    public static final PersistableBundleApi21ImplKt INSTANCE = null;

    static {
        INSTANCE = new PersistableBundleApi21ImplKt();
    }

    private PersistableBundleApi21ImplKt() {
    }

    @JvmStatic
    public static final PersistableBundle createPersistableBundle(int r100) {
        return new PersistableBundle(r100);
    }

    @JvmStatic
    public static final void putValue(PersistableBundle r100, String r101, Object r102) {
        if (r102 != null) goto L5;
        r100.putString(r101, null);
        return;
    L5:
        if ((r102 instanceof Boolean) == false) goto L12;
        if (Build.VERSION.SDK_INT < 22) goto L10;
        PersistableBundleApi22ImplKt.putBoolean(r100, r101, ((Boolean) r102).booleanValue());
        return;
    L10:
        throw new IllegalArgumentException("Unsupported value type boolean for key \"" + r101 + "\" (requires API level 22+)");
    L12:
        if ((r102 instanceof Double) == false) goto L15;
        r100.putDouble(r101, ((Number) r102).doubleValue());
        return;
    L15:
        if ((r102 instanceof Integer) == false) goto L18;
        r100.putInt(r101, ((Number) r102).intValue());
        return;
    L18:
        if ((r102 instanceof Long) == false) goto L21;
        r100.putLong(r101, ((Number) r102).longValue());
        return;
    L21:
        if ((r102 instanceof String) == false) goto L24;
        r100.putString(r101, (String) r102);
        return;
    L24:
        if ((r102 instanceof PersistableBundle) == false) goto L27;
        r100.putPersistableBundle(r101, (PersistableBundle) r102);
        return;
    L27:
        if ((r102 instanceof boolean[]) == false) goto L34;
        if (Build.VERSION.SDK_INT < 22) goto L32;
        PersistableBundleApi22ImplKt.putBooleanArray(r100, r101, (boolean[]) r102);
        return;
    L32:
        throw new IllegalArgumentException("Unsupported value type boolean[] for key \"" + r101 + "\" (requires API level 22+)");
    L34:
        if ((r102 instanceof double[]) == false) goto L37;
        r100.putDoubleArray(r101, (double[]) r102);
        return;
    L37:
        if ((r102 instanceof int[]) == false) goto L40;
        r100.putIntArray(r101, (int[]) r102);
        return;
    L40:
        if ((r102 instanceof long[]) == false) goto L43;
        r100.putLongArray(r101, (long[]) r102);
        return;
    L43:
        if ((r102 instanceof Object[]) == false) goto L51;
        Class<?> r103 = r102.getClass().getComponentType();
        Intrinsics.checkNotNull(r103);
        if (String.class.isAssignableFrom(r103) == false) goto L49;
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
        r100.putStringArray(r101, (String[]) r102);
        return;
    L49:
        throw new IllegalArgumentException("Unsupported value array type " + r103.getCanonicalName() + " for key \"" + r101 + Typography.quote);
    L51:
        throw new IllegalArgumentException("Unsupported value type " + r102.getClass().getCanonicalName() + " for key \"" + r101 + Typography.quote);
    }
}
