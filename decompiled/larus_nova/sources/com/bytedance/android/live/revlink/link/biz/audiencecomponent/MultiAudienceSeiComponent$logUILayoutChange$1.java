package com.bytedance.android.live.revlink.link.biz.audiencecomponent;

import com.bytedance.android.live.revlink.impl.multianchor.ui.UILayout;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"getMultiUILayoutFromIndex", "Lcom/bytedance/android/live/revlink/impl/multianchor/ui/UILayout;", "index", "", "isHorizontal", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
final class MultiAudienceSeiComponent$logUILayoutChange$1 extends Lambda implements Function2<Integer, Boolean, UILayout> {
    public static final MultiAudienceSeiComponent$logUILayoutChange$1 INSTANCE = null;

    static {
        INSTANCE = new MultiAudienceSeiComponent$logUILayoutChange$1();
    }

    public MultiAudienceSeiComponent$logUILayoutChange$1() {
        super(2);
    }

    public final UILayout invoke(int r100, boolean r101) {
        if (r100 == 1) goto L11;
        if (r100 != 2) goto L12;
        if (r101 == false) goto L14;
        return UILayout.FULL_RECORD;
    L14:
        return UILayout.FULL;
    L12:
        return UILayout.Normal;
    L11:
        return UILayout.Enlarge;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ UILayout invoke(Integer r100, Boolean r101) {
        return invoke(r100.intValue(), r101.booleanValue());
    }

    public static /* synthetic */ UILayout invoke$default(MultiAudienceSeiComponent$logUILayoutChange$1 r100, int r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = false;
    L6:
        return r100.invoke(r101, r102);
    }
}
