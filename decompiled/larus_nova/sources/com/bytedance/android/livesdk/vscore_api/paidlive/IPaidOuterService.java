package com.bytedance.android.livesdk.vscore_api.paidlive;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ServiceLookup("com.bytedance.android.livesdk.chatroom.paidlive.PaidOuterService")
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bg\u0018\u0000 \f2\u00020\u0001:\u0001\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0019\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/vscore_api/paidlive/IPaidOuterService;", "Lcom/bytedance/android/live/base/IService;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/os/Bundle;", "bundle", "", "startPaidPrivilegeFullPage", "", "panelType", "openPanelInRoom", "(Ljava/lang/Integer;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "vs-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IPaidOuterService extends IService {
    public static final a Companion = null;
    public static final int PANEL_TYPE_MULTI_CAMERA = 6;
    public static final int PANEL_TYPE_RESOLUTION = 4;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f159403a = null;

        public a() {
        }

        static {
            f159403a = new a();
        }
    }

    static {
        Companion = a.f159403a;
    }

    void openPanelInRoom(Integer r100);

    void startPaidPrivilegeFullPage(Context r100, Bundle r101);
}
