package androidx.compose.ui.node;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000,\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a1\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0007H\u0007¢\u0006\u0002\u0010\b\u001a\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0000\u001a\u000e\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u0003H\u0000\u001a\f\u0010\u000f\u001a\u00020\u000e*\u00020\u0003H\u0000\"\u000e\u0010\f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"getOrAddAdapter", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/ui/node/ViewAdapter;", "Landroid/view/View;", "id", "", "factory", "Lkotlin/Function0;", "(Landroid/view/View;ILkotlin/jvm/functions/Function0;)Landroidx/compose/ui/node/ViewAdapter;", "tagKey", "key", "", "viewAdaptersKey", "getViewAdapterIfExists", "Landroidx/compose/ui/node/MergedViewAdapter;", "getViewAdapter", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ViewInterop_androidKt {
    private static final int viewAdaptersKey = 0;

    static {
        viewAdaptersKey = tagKey("ViewAdapter");
    }

    public static final MergedViewAdapter getViewAdapter(View r100) {
        int r101 = viewAdaptersKey;
        Object r102 = r100.getTag(r101);
        if ((r102 instanceof MergedViewAdapter) == false) goto L5;
        MergedViewAdapter r103 = (MergedViewAdapter) r102;
    L6:
        if (r103 != null) goto L9;
        MergedViewAdapter r104 = new MergedViewAdapter();
        r100.setTag(r101, r104);
        return r104;
    L9:
        return r103;
    L5:
        r103 = null;
        goto L6
    }

    public static final MergedViewAdapter getViewAdapterIfExists(View r100) {
        Object r101 = r100.getTag(viewAdaptersKey);
        if ((r101 instanceof MergedViewAdapter) == true) goto L7;
        return null;
    L7:
        return (MergedViewAdapter) r101;
    }

    public static final int tagKey(String r100) {
        return r100.hashCode() | 50331648;
    }

    public static final <T extends ViewAdapter> T getOrAddAdapter(View r100, int r101, Function0<? extends T> r102) {
        MergedViewAdapter r103 = getViewAdapter(r100);
        List<ViewAdapter> r104 = r103.getAdapters();
        int r105 = r104.size();
        int r106 = 0;
    L3:
        T r107 = null;
        if (r106 >= r105) goto L12;
        Object r108 = ListProtector.get(r104, r106);
        if (((ViewAdapter) r108).getId() != r101) goto L8;
        boolean r109 = true;
    L9:
        if (r109 == true) goto L14;
        r106 = r106 + 1;
    L14:
        if ((r108 instanceof ViewAdapter) == false) goto L16;
        r107 = (T) r108;
    L16:
        if (r107 != null) goto L21;
        T r110 = r102.invoke();
        r103.getAdapters().add(r110);
        return r110;
    L21:
        return r107;
    L8:
        r109 = false;
        goto L9
    L12:
        r108 = null;
        goto L14
    }
}
