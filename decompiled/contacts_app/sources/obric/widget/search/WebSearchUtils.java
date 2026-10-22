package obric.widget.search;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.obric.oui.sheet.v2.OSheetBaseKt;
import obric.widget.search.data.SearchConfigTypeData;

/* JADX INFO: loaded from: classes5.dex */
public class WebSearchUtils {
    private static ArrayMap<String, Bitmap> sMap;

    public WebSearchUtils() {
    }

    static {
        sMap = new ArrayMap();
    }

    public static Drawable getBoomIconDrawable(Context context, SearchConfigTypeData data) {
        if (TextUtils.isEmpty(data.getImgUrl()) == true) goto L13;
        Bitmap r0 = sMap.get(data.getIdentifier());
        if (r0 != null) goto L7;
        Bitmap r1 = data.getBoomIconBitmapBySettings(context);
        if (r1 == null) goto L13;
        r1.setDensity(OSheetBaseKt.SHEET_LANDSCAPE_MAX_WIDTH);
        sMap.put(data.getIdentifier(), r1);
        return new BitmapDrawable(context.getResources(), r1);
    L7:
        return new BitmapDrawable(context.getResources(), r0);
    L13:
        return context.getDrawable(data.getBoomIconId());
    }
}
