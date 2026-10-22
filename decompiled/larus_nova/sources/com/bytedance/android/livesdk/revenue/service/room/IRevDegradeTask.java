package com.bytedance.android.livesdk.revenue.service.room;

import com.ss.android.lark.chat.core.dependency.ForwardDependency$ForwardLocation;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/service/room/IRevDegradeTask;", "", "onDegrade", "", ForwardDependency$ForwardLocation.FLAG, "", "onRecover", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IRevDegradeTask {
    void onDegrade(int r100);

    void onRecover(int r100);
}
