package androidx.compose.ui.text.android;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import defpackage.DeepThinkTopHeaderComponent$runCollapseAnimation$2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a8\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0005H\u0080\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001a]\u0010\u0006\u001a\u0002H\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\b\"\u0010\b\u0002\u0010\u0007*\n\u0012\u0006\b\u0000\u0012\u0002H\b0\t*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\n\u001a\u0002H\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\b0\u0005H\u0080\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010\f\u001aJ\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\b0\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\b*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\b0\u000eH\u0080\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¨\u0006\u000f"}, d2 = {"fastForEach", "", ExifInterface.GPS_DIRECTION_TRUE, "", "action", "Lkotlin/Function1;", "fastMapTo", "C", "R", "", com.bytedance.android.ec.core.event.a.KEY_DESTINATION, "transform", "(Ljava/util/List;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "fastZipWithNext", "Lkotlin/Function2;", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ListUtils_androidKt {
    public static final <T> void fastForEach(List<? extends T> r100, Function1<? super T, Unit> r101) {
        int r102 = r100.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r101.invoke((Object) ListProtector.get(r100, r103));
        r103 = r103 + 1;
        goto L3
    }

    public static final <T, R> List<R> fastZipWithNext(List<? extends T> r100, Function2<? super T, ? super T, ? extends R> r101) {
        if (r100.size() <= 1) goto L5;
        ArrayList r102 = new ArrayList();
        int r103 = 0;
        DeepThinkTopHeaderComponent$runCollapseAnimation$2.a r104 = (Object) ListProtector.get(r100, 0);
        int r105 = CollectionsKt.getLastIndex(r100);
    L7:
        if (r103 >= r105) goto L9;
        r103 = r103 + 1;
        DeepThinkTopHeaderComponent$runCollapseAnimation$2.a r106 = (Object) ListProtector.get(r100, r103);
        r102.add(r101.invoke(r104, r106));
        r104 = r106;
        goto L7
    L9:
        return r102;
    L5:
        return CollectionsKt.emptyList();
    }

    public static final <T, R, C extends Collection<? super R>> C fastMapTo(List<? extends T> r100, C r101, Function1<? super T, ? extends R> r102) {
        int r103 = r100.size();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        r101.add(r102.invoke((Object) ListProtector.get(r100, r104)));
        r104 = r104 + 1;
        goto L3
    L5:
        return r101;
    }
}
