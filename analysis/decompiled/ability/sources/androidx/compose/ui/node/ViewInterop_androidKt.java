package androidx.compose.ui.node;

import S7.a;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a3\u0010\u0007\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a\u0017\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u0015\u0010\u000e\u001a\u0004\u0018\u00010\r*\u00020\u0002H\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0013\u0010\u0010\u001a\u00020\r*\u00020\u0002H\u0000¢\u0006\u0004\b\u0010\u0010\u000f\"\u0014\u0010\u0011\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/node/ViewAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "", "id", "Lkotlin/Function0;", "factory", "getOrAddAdapter", "(Landroid/view/View;ILS7/a;)Landroidx/compose/ui/node/ViewAdapter;", "", "key", "tagKey", "(Ljava/lang/String;)I", "Landroidx/compose/ui/node/MergedViewAdapter;", "getViewAdapterIfExists", "(Landroid/view/View;)Landroidx/compose/ui/node/MergedViewAdapter;", "getViewAdapter", "viewAdaptersKey", "I", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ViewInterop_androidKt {
    private static final int viewAdaptersKey = tagKey("ViewAdapter");

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final <T extends ViewAdapter> T getOrAddAdapter(View view, int i, a aVar) {
        ViewAdapter viewAdapter;
        MergedViewAdapter viewAdapter2 = getViewAdapter(view);
        List<ViewAdapter> adapters = viewAdapter2.getAdapters();
        int size = adapters.size();
        int i6 = 0;
        while (true) {
            if (i6 >= size) {
                viewAdapter = null;
                break;
            }
            viewAdapter = adapters.get(i6);
            if (viewAdapter.getId() == i) {
                break;
            }
            i6++;
        }
        T t9 = viewAdapter instanceof ViewAdapter ? (T) viewAdapter : null;
        if (t9 != null) {
            return t9;
        }
        T t10 = (T) aVar.invoke();
        viewAdapter2.getAdapters().add(t10);
        return t10;
    }

    public static final MergedViewAdapter getViewAdapter(View view) {
        int i = viewAdaptersKey;
        Object tag = view.getTag(i);
        MergedViewAdapter mergedViewAdapter = tag instanceof MergedViewAdapter ? (MergedViewAdapter) tag : null;
        if (mergedViewAdapter != null) {
            return mergedViewAdapter;
        }
        MergedViewAdapter mergedViewAdapter2 = new MergedViewAdapter();
        view.setTag(i, mergedViewAdapter2);
        return mergedViewAdapter2;
    }

    public static final MergedViewAdapter getViewAdapterIfExists(View view) {
        Object tag = view.getTag(viewAdaptersKey);
        if (tag instanceof MergedViewAdapter) {
            return (MergedViewAdapter) tag;
        }
        return null;
    }

    public static final int tagKey(String str) {
        return str.hashCode() | 50331648;
    }
}
