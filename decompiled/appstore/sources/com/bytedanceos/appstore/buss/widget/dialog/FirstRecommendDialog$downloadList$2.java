package com.bytedanceos.appstore.buss.widget.dialog;

import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00040\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", "kotlin.jvm.PlatformType", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class FirstRecommendDialog$downloadList$2 extends Lambda implements Function0<List<CommonAppEntity>> {
    public static final FirstRecommendDialog$downloadList$2 INSTANCE = null;

    static {
        INSTANCE = new FirstRecommendDialog$downloadList$2();
    }

    public FirstRecommendDialog$downloadList$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<CommonAppEntity> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<CommonAppEntity> invoke2() {
        return Collections.synchronizedList(new ArrayList());
    }
}
