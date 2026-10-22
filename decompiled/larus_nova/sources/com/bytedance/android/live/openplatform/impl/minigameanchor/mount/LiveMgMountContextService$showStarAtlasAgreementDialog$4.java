package com.bytedance.android.live.openplatform.impl.minigameanchor.mount;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"protocols2Str", "", "protocols", "", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class LiveMgMountContextService$showStarAtlasAgreementDialog$4 extends Lambda implements Function1<List<? extends Integer>, String> {
    public static final LiveMgMountContextService$showStarAtlasAgreementDialog$4 INSTANCE = null;

    static {
        INSTANCE = new LiveMgMountContextService$showStarAtlasAgreementDialog$4();
    }

    public LiveMgMountContextService$showStarAtlasAgreementDialog$4() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(List<Integer> r100) {
        StringBuilder r101 = new StringBuilder();
        if (r100 == null) goto L15;
        Iterator<T> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L15;
        int r103 = ((Number) r102.next()).intValue();
        if (r101.toString().length() != 0) goto L10;
        boolean r104 = true;
    L11:
        if (r104 == true) goto L12;
        r101.append(",");
        r101.append(String.valueOf(r103));
        goto L6
    L12:
        r101.append(String.valueOf(r103));
        goto L6
    L10:
        r104 = false;
    L15:
        return r101.toString();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(List<? extends Integer> r100) {
        return invoke2(r100);
    }
}
