package com.bytedance.android.format.host.api;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.format.model.j0;
import com.bytedance.android.format.model.v;
import com.bytedance.android.format.model.y;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u0000 \u00152\u00020\u0001:\u0004\u0016\u0017\u0018\u0019J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH&J4\u0010\u0014\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/format/host/api/IHostShare;", "", "Landroidx/fragment/app/FragmentActivity;", "fragmentActivity", "Lcom/bytedance/android/format/host/api/IHostShare$c;", "params", "Lcom/bytedance/android/format/host/api/IHostShare$b;", "callback", "", "openSharePanel", "Lcom/bytedance/android/format/model/y;", "config", "Lcom/bytedance/android/format/model/j0;", "addShareContactsListComponent", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "contactList", "Lcom/bytedance/android/format/model/v;", "message", "sendShareMessage", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "ShareType", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IHostShare {
    public static final a Companion = null;
    public static final String SHARE_INFO_UID = "uid";

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/format/host/api/IHostShare$ShareType;", "", "H5_LINK_CARD", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ShareType extends Enum<ShareType> {
        public static final ShareType H5_LINK_CARD = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ShareType[] f51324a = null;

        static {
            ShareType r100 = new ShareType();
            H5_LINK_CARD = r100;
            f51324a = new ShareType[]{r100};
        }

        public static ShareType valueOf(String r100) {
            return (ShareType) r27.a.a(ShareType.class, r100);
        }

        public static ShareType[] values() {
            return (ShareType[]) f51324a.clone();
        }

        public ShareType() {
            super("H5_LINK_CARD", 0);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f51325a = null;

        public a() {
        }

        static {
            f51325a = new a();
        }
    }

    public interface b {
    }

    public static final class c {
    }

    static {
        Companion = a.f51325a;
    }

    j0 addShareContactsListComponent(y r100);

    void openSharePanel(FragmentActivity r100, c r101, b r102);

    void sendShareMessage(Context r100, List<? extends Object> r101, v r102, b r103);
}
