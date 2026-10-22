package com.bytedance.android.live.revlink.impl.plantform;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.link.model.p;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class g {
    public static final List<p> a(List<? extends p> r100, List<? extends p> r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$subtractList");
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L11;
        IBaseUser r104 = ((p) r103.next()).getUser();
        if (r104 == null) goto L9;
        String r105 = r104.getIdString();
        if (r105 == null) goto L9;
    L10:
        r102.add(r105);
    L9:
        r105 = "";
        goto L10
    L11:
        ArrayList r106 = new ArrayList();
        Iterator<T> r107 = r100.iterator();
    L13:
        if (r107.hasNext() == false) goto L38;
        Object r108 = r107.next();
        p r109 = (p) r108;
        String r110 = null;
        if (r109 == null) goto L19;
        IBaseUser r111 = r109.getUser();
        if (r111 == null) goto L19;
        String r112 = r111.getIdString();
    L20:
        boolean r113 = true;
        if (r112 != null) goto L23;
    L26:
        boolean r114 = true;
    L27:
        if (r114 == true) goto L35;
        if (r109 == null) goto L33;
        IBaseUser r115 = r109.getUser();
        if (r115 == null) goto L33;
        r110 = r115.getIdString();
    L33:
        if (CollectionsKt.contains(r102, r110) == true) goto L35;
    L36:
        if (r113 == false) goto L13;
        r106.add(r108);
    L35:
        r113 = false;
        goto L36
    L23:
        if (r112.length() == 0) goto L26;
        r114 = false;
    L19:
        r112 = null;
        goto L20
    L38:
        return r106;
    }
}
