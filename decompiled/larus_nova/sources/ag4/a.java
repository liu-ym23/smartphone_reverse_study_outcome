package ag4;

import android.app.Application;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import java.util.Arrays;
import java.util.List;
import kotlin.TypeCastException;

/* JADX INFO: loaded from: classes15.dex */
public final class a {
    public static final int b(int r100) {
        return ContextCompat.getColor(uf4.a.a(), r100);
    }

    public static final Drawable c(int r100) {
        return ContextCompat.getDrawable(uf4.a.a(), r100);
    }

    public static final String d(int r100) {
        return uf4.a.a().getString(r100);
    }

    public static final String a(int r100, List<? extends Object> r101) {
        Application r102 = uf4.a.a();
        Object[] r103 = r101.toArray(new Object[0]);
        if (r103 == null) goto L7;
        return r102.getString(r100, Arrays.copyOf(r103, r103.length));
    L7:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
