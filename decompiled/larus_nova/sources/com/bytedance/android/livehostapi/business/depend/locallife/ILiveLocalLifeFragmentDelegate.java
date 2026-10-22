package com.bytedance.android.livehostapi.business.depend.locallife;

import android.content.Context;
import android.os.Bundle;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\b\u001a\u00020\tH&J\u001a\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/locallife/ILiveLocalLifeFragmentDelegate;", "", "params", "Landroid/os/Bundle;", "getParams", "()Landroid/os/Bundle;", "setParams", "(Landroid/os/Bundle;)V", "dismissPage", "", "show", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "tag", "", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveLocalLifeFragmentDelegate {
    void dismissPage();

    Bundle getParams();

    void setParams(Bundle r100);

    void show(Context r100, String r101);
}
