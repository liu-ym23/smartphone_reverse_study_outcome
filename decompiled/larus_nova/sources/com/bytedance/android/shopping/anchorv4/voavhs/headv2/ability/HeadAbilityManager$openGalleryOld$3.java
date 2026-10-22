package com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "position", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/m;", AbsMethodDelegate.TAG_INVOKE, "(I)Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/m;", "findTargetHeaderTab"}, k = 3, mv = {1, 4, 3})
final class HeadAbilityManager$openGalleryOld$3 extends Lambda implements Function1<Integer, com.bytedance.android.shopping.anchorv4.voavhs.headv2.m> {
    final /* synthetic */ List $headerTabList;
    final /* synthetic */ Ref.IntRef $lastHeaderTabIndex;

    public HeadAbilityManager$openGalleryOld$3(Ref.IntRef r100, List r101) {
        this.$lastHeaderTabIndex = r100;
        this.$headerTabList = r101;
        super(1);
    }

    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.m invoke(int r100) {
        int r101 = this.$lastHeaderTabIndex.element;
        if (r101 >= 0) goto L5;
    L9:
        this.$lastHeaderTabIndex.element = 0;
    L11:
        if (this.$lastHeaderTabIndex.element >= this.$headerTabList.size()) goto L16;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.m r102 = (com.bytedance.android.shopping.anchorv4.voavhs.headv2.m) ListProtector.get(this.$headerTabList, this.$lastHeaderTabIndex.element);
        if (r102.a(r100) == true) goto L14;
        this.$lastHeaderTabIndex.element++;
        goto L11
    L14:
        return r102;
    L16:
        return null;
    L5:
        if (r101 >= this.$headerTabList.size()) goto L9;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.m r103 = (com.bytedance.android.shopping.anchorv4.voavhs.headv2.m) ListProtector.get(this.$headerTabList, this.$lastHeaderTabIndex.element);
        if (r103.a(r100) == false) goto L9;
        return r103;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ com.bytedance.android.shopping.anchorv4.voavhs.headv2.m invoke(Integer r100) {
        return invoke(r100.intValue());
    }
}
