package com.stepos.ailauncher.task.amap;

import android.content.Context;
import com.stepos.ailauncher.contract.api.amap.IPoiDetailPageProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/stepos/ailauncher/task/amap/a;", "Lcom/stepos/ailauncher/contract/api/amap/IPoiDetailPageProvider;", "<init>", "()V", "Landroid/content/Context;", "context", "", "detailJson", "LY8/t;", "open", "(Landroid/content/Context;Ljava/lang/String;)V", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a implements IPoiDetailPageProvider {
    @Override // com.stepos.ailauncher.contract.api.amap.IPoiDetailPageProvider
    public void open(Context context, String detailJson) {
        p.i(context, "context");
        p.i(detailJson, "detailJson");
        PoiDetailSheetActivity.INSTANCE.c(context, detailJson);
    }
}
