package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.business;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.broadcastgame.api.model.InteractEntranceCell;
import com.bytedance.android.live.broadcastgame.api.model.k0;
import com.bytedance.android.live.broadcastgame.api.model.s;
import com.bytedance.android.live.broadcastgame.api.model.t;
import com.bytedance.android.live.broadcastgame.api.model.v;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010%\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"containId", "Lcom/bytedance/android/live/broadcastgame/api/model/InteractEntranceCell;", "id", "", "recentGroupType", "", "openFeatureCellMap", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final class OpenFeatureListHandler$modifyRecentUsedList$1 extends Lambda implements Function3<String, Long, Map<String, InteractEntranceCell>, InteractEntranceCell> {
    public static final OpenFeatureListHandler$modifyRecentUsedList$1 INSTANCE = null;

    static {
        INSTANCE = new OpenFeatureListHandler$modifyRecentUsedList$1();
    }

    public OpenFeatureListHandler$modifyRecentUsedList$1() {
        super(3);
    }

    public final InteractEntranceCell invoke(String r210, long r211, Map<String, InteractEntranceCell> r212) {
        Intrinsics.checkNotNullParameter(r210, "id");
        Intrinsics.checkNotNullParameter(r212, "openFeatureCellMap");
        InteractEntranceCell r100 = r212.get(r210);
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.groupType == r211) goto L11;
        int r101 = r100.interactType;
        String r102 = r100.title;
        String r103 = r100.desc;
        ImageModel r104 = r100.icon;
        List<String> r110 = r100.serverScenes;
        String r111 = r100.extra;
        List<v> r112 = r100.labels;
        k0 r113 = r100.rightButton;
        String r114 = r100.gameCardExtra;
        String r115 = r100.extendExtra;
        String r105 = r100.iconLabel;
        List<String> r106 = r100.selectKeys;
        String r107 = r100.titleLabel;
        List<t> r108 = r100.highlightLabel;
        List<s> r109 = r100.highlightDesc;
        String r116 = r100.highlightIcon;
        Intrinsics.checkNotNullParameter(r102, "title");
        return new InteractEntranceCell(r101, r102, r103, r104, r211, r110, r111, r112, r113, r114, r115, r105, r106, r107, r108, r109, r116);
    L11:
        return r100;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ InteractEntranceCell invoke(String r100, Long r101, Map<String, InteractEntranceCell> r102) {
        return invoke(r100, r101.longValue(), r102);
    }
}
