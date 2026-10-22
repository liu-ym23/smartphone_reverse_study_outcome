package com.bytedance.android.livehostapi.business;

import android.content.Context;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H&¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/IAssignUiModeDelegate;", "", "afterAttachBaseContext", "", "newBase", "Landroid/content/Context;", "beforeAttachBaseContext", "createContextWithAssignUiModeForActivity", "originContext", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IAssignUiModeDelegate {
    void afterAttachBaseContext(Context r100);

    void beforeAttachBaseContext(Context r100);

    Context createContextWithAssignUiModeForActivity(Context r100);
}
