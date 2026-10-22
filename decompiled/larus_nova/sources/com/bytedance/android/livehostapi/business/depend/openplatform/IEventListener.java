package com.bytedance.android.livehostapi.business.depend.openplatform;

import android.os.Bundle;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/openplatform/IEventListener;", "", "onEvent", "Landroid/os/Bundle;", ControlRule.KEY_EXTRA_DATA, "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IEventListener {
    Bundle onEvent(Bundle r100);
}
