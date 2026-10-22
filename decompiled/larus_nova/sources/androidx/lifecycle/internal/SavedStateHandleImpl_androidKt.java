package androidx.lifecycle.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0000\"\u001c\u0010\u0004\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"isAcceptableType", "", "value", "", "ACCEPTABLE_CLASSES", "", "Ljava/lang/Class;", "lifecycle-viewmodel-savedstate"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SavedStateHandleImpl_androidKt {
    private static final List<Class<? extends Object>> ACCEPTABLE_CLASSES = null;

    static {
        ACCEPTABLE_CLASSES = ArraysKt.filterNotNull(new Class[]{Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class});
    }

    public static final boolean isAcceptableType(Object r100) {
        if (r100 == null) goto L22;
        List<Class<? extends Object>> r101 = ACCEPTABLE_CLASSES;
        if ((r101 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r102 = r101.iterator();
    L11:
        if (r102.hasNext() == false) goto L8;
        if (((Class) r102.next()).isInstance(r100) == false) goto L11;
        boolean r103 = true;
    L15:
        if (r103 == true) goto L23;
        return false;
    L23:
        return true;
    L8:
        r103 = false;
        goto L15
    L7:
        if (r101.isEmpty() == false) goto L9;
    L22:
        return true;
    }
}
