package butterknife.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public final class Utils {
    private static final TypedValue VALUE = null;

    static {
        VALUE = new TypedValue();
    }

    private Utils() {
        throw new AssertionError("No instances.");
    }

    @SafeVarargs
    public static <T> T[] arrayFilteringNull(T... r100) {
        int r101 = r100.length;
        int r102 = 0;
        int r103 = 0;
    L3:
        if (r102 >= r101) goto L8;
        T r104 = r100[r102];
        if (r104 == null) goto L7;
        r100[r103] = r104;
        r103 = r103 + 1;
    L7:
        r102 = r102 + 1;
        goto L3
    L8:
        if (r103 != r101) goto L11;
        return r100;
    L11:
        return (T[]) Arrays.copyOf(r100, r103);
    }

    @SafeVarargs
    public static <T> List<T> listFilteringNull(T... r100) {
        return new ImmutableList(arrayFilteringNull(r100));
    }

    public static float getFloat(Context r100, int r101) {
        TypedValue r102 = VALUE;
        r100.getResources().getValue(r101, r102, true);
        if (r102.type != 4) goto L7;
        return r102.getFloat();
    L7:
        throw new Resources.NotFoundException("Resource ID #0x" + Integer.toHexString(r101) + " type #0x" + Integer.toHexString(r102.type) + " is not valid");
    }

    private static String getResourceEntryName(View r100, int r101) {
        if (r100.isInEditMode() == false) goto L7;
        return "<unavailable while editing>";
    L7:
        return r100.getContext().getResources().getResourceEntryName(r101);
    }

    public static View findRequiredView(View r100, int r101, String r102) {
        View r103 = r100.findViewById(r101);
        if (r103 == null) goto L6;
        return r103;
    L6:
        throw new IllegalStateException("Required view '" + getResourceEntryName(r100, r101) + "' with ID " + r101 + " for " + r102 + " was not found. If this view is optional add '@Nullable' (fields) or '@Optional' (methods) annotation.");
    }

    public static Drawable getTintedDrawable(Context r100, int r101, int r102) {
        Resources.Theme r103 = r100.getTheme();
        TypedValue r104 = VALUE;
        if (r103.resolveAttribute(r102, r104, true) == false) goto L7;
        Drawable r105 = DrawableCompat.wrap(ContextCompat.getDrawable(r100, r101).mutate());
        DrawableCompat.setTint(r105, ContextCompat.getColor(r100, r104.resourceId));
        return r105;
    L7:
        throw new Resources.NotFoundException("Required tint color attribute with name " + r100.getResources().getResourceEntryName(r102) + " and attribute ID " + r102 + " was not found.");
    }

    public static <T> T castView(View r100, int r101, String r102, Class<T> r103) {
        return r103.cast(r100);
    L4:
        e = move-exception;
        throw new IllegalStateException("View '" + getResourceEntryName(r100, r101) + "' with ID " + r101 + " for " + r102 + " was of the wrong type. See cause for more info.", e);
    }

    public static <T> T findOptionalViewAsType(View r100, int r101, String r102, Class<T> r103) {
        return (T) castView(r100.findViewById(r101), r101, r102, r103);
    }

    public static <T> T findRequiredViewAsType(View r100, int r101, String r102, Class<T> r103) {
        return (T) castView(findRequiredView(r100, r101, r102), r101, r102, r103);
    }

    public static <T> T castParam(Object r100, String r101, int r102, String r103, int r104, Class<T> r105) {
        return r105.cast(r100);
    L4:
        e = move-exception;
        throw new IllegalStateException("Parameter #" + (r102 + 1) + " of method '" + r101 + "' was of the wrong type for parameter #" + (r104 + 1) + " of method '" + r103 + "'. See cause for more info.", e);
    }
}
