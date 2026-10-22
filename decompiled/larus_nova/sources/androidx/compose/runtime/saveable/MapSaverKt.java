package androidx.compose.runtime.saveable;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.serval.svg.SVGRenderEngine;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001ax\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00030\u0001\"\u0004\b\u0000\u0010\u00022:\u0010\u0004\u001a6\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00030\n0\u0005¢\u0006\u0002\b\f2\"\u0010\r\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00030\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u000e¨\u0006\u000f"}, d2 = {"mapSaver", "Landroidx/compose/runtime/saveable/Saver;", ExifInterface.GPS_DIRECTION_TRUE, "", SVGRenderEngine.SAVE, "Lkotlin/Function2;", "Landroidx/compose/runtime/saveable/SaverScope;", "Lkotlin/ParameterName;", "name", "value", "", "", "Lkotlin/ExtensionFunctionType;", SVGRenderEngine.RESTORE, "Lkotlin/Function1;", "runtime-saveable"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class MapSaverKt {
    public static /* synthetic */ List a(Function2 r100, SaverScope r101, Object r102) {
        return mapSaver$lambda$2(r100, r101, r102);
    }

    public static /* synthetic */ Object b(Function1 r100, List r101) {
        return mapSaver$lambda$4(r100, r101);
    }

    public static final <T> Saver<T, Object> mapSaver(final Function2<? super SaverScope, ? super T, ? extends Map<String, ? extends Object>> r100, final Function1<? super Map<String, ? extends Object>, ? extends T> r101) {
        return ListSaverKt.listSaver(new b(r100), new c(r101));
    }

    private static final Object mapSaver$lambda$4(Function1 r100, List r101) {
        LinkedHashMap r102 = new LinkedHashMap();
        int r103 = 0;
        if ((r101.size() % 2) != 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L13;
    L8:
        if (r103 >= r101.size()) goto L11;
        Object r105 = ListProtector.get(r101, r103);
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type kotlin.String");
        r102.put((String) r105, ListProtector.get(r101, r103 + 1));
        r103 = r103 + 2;
        goto L8
    L11:
        return r100.invoke(r102);
    L13:
        throw new IllegalStateException("non-zero remainder".toString());
    L5:
        r104 = false;
        goto L6
    }

    private static final List mapSaver$lambda$2(Function2 r100, SaverScope r101, Object r102) {
        ArrayList r103 = new ArrayList();
        Iterator r104 = ((Map) r100.invoke(r101, r102)).entrySet().iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        Map.Entry r105 = (Map.Entry) r104.next();
        r103.add(r105.getKey());
        r103.add(r105.getValue());
        goto L4
    L6:
        return r103;
    }
}
