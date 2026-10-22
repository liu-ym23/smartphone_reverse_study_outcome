package androidx.compose.foundation.text.input.internal;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\u001a6\u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001H\u0002¨\u0006\u0005"}, d2 = {"mergeNullableLists", "", ExifInterface.GPS_DIRECTION_TRUE, SoloKtvContext.SOLO_PAGE_FIRST, "second", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextFieldLayoutStateCacheKt {
    public static final /* synthetic */ List access$mergeNullableLists(List r100, List r101) {
        return mergeNullableLists(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> List<T> mergeNullableLists(List<? extends T> r100, List<? extends T> r101) {
        List<? extends T> r102 = r100;
        boolean r103 = false;
        if (r102 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L20;
        List<? extends T> r105 = r101;
        if (r105 != null) goto L13;
    L16:
        boolean r106 = true;
    L17:
        if (r106 == false) goto L20;
        return null;
    L13:
        if (r105.isEmpty() == true) goto L16;
        r106 = false;
    L20:
        if (r102 != null) goto L22;
    L25:
        boolean r107 = true;
    L26:
        if (r107 == false) goto L28;
        return r101;
    L28:
        List<? extends T> r108 = r101;
        if (r108 != null) goto L31;
    L32:
        r103 = true;
    L33:
        if (r103 == false) goto L35;
        return r100;
    L35:
        List r109 = CollectionsKt.createListBuilder();
        r109.addAll(r102);
        r109.addAll(r108);
        return CollectionsKt.build(r109);
    L31:
        if (r108.isEmpty() == false) goto L33;
    L22:
        if (r102.isEmpty() == true) goto L25;
        r107 = false;
        goto L26
    L5:
        if (r102.isEmpty() == true) goto L8;
        r104 = false;
        goto L9
    }
}
