package adb;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.ss.android.lark.export.flexlayout.FlexLayoutProperty;
import com.ss.android.lark.tangram.base.style.TCStyle;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import q6c.d;

/* JADX INFO: loaded from: classes35.dex */
public final class a extends d<r6c.a, FlexLayoutProperty> {
    @Override // q6c.d, q6c.c
    public final s6c.a c() {
        String r100 = this.f531876b;
        FlexLayoutProperty r101 = ((FlexLayoutProperty) this.f531879e).clone();
        TCStyle r102 = this.f531877c;
        if (r102 == null) goto L5;
        TCStyle r103 = r102.clone();
    L6:
        com.ss.android.lark.export.flexlayout.a r104 = new com.ss.android.lark.export.flexlayout.a(r100, r101, r103);
        AbstractCollection r105 = this.f531878d;
        if (r105 == null) goto L13;
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator r107 = r105.iterator();
    L10:
        if (r107.hasNext() == false) goto L12;
        r106.add(((q6c.a) r107.next()).c());
        goto L10
    L12:
        ArrayList<s6c.a> r108 = new ArrayList(r106);
        Intrinsics.checkNotNullParameter(r108, "<set-?>");
        r104.f540888i = r108;
    L13:
        r104.f540887h = false;
        return r104;
    L5:
        r103 = null;
        goto L6
    }

    public a(FlexLayoutProperty r100, TCStyle r101, vcb.d r102) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_PROPS);
        Intrinsics.checkNotNullParameter(r102, "dependency");
        super(r100, r101, r102);
    }
}
