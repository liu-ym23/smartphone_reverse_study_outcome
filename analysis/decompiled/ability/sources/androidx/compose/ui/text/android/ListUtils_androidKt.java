package androidx.compose.ui.text.android;

import H4.o;
import S7.k;
import S7.n;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001f\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a?\u0010\u0005\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0002H\u0080\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a_\u0010\f\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0007\"\u0010\b\u0002\u0010\t*\n\u0012\u0006\b\u0000\u0012\u00028\u00010\b*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\n\u001a\u00028\u00022\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0080\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0004\b\f\u0010\r\u001aQ\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0007*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000eH\u0080\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlin/Function1;", "LC7/r;", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "fastForEach", "(Ljava/util/List;LS7/k;)V", "R", "", "C", "destination", "transform", "fastMapTo", "(Ljava/util/List;Ljava/util/Collection;LS7/k;)Ljava/util/Collection;", "Lkotlin/Function2;", "fastZipWithNext", "(Ljava/util/List;LS7/n;)Ljava/util/List;", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ListUtils_androidKt {
    public static final <T> void fastForEach(List<? extends T> list, k kVar) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            kVar.invoke(list.get(i));
        }
    }

    public static final <T, R, C extends Collection<? super R>> C fastMapTo(List<? extends T> list, C c, k kVar) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            c.add(kVar.invoke(list.get(i)));
        }
        return c;
    }

    public static final <T, R> List<R> fastZipWithNext(List<? extends T> list, n nVar) {
        if (list.size() <= 1) {
            return EmptyList.f4893a;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        T t9 = list.get(0);
        int iH = o.H(list);
        while (i < iH) {
            i++;
            T t10 = list.get(i);
            arrayList.add(nVar.invoke(t9, t10));
            t9 = t10;
        }
        return arrayList;
    }
}
