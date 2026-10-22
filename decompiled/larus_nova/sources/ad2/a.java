package ad2;

import ad2.c0;
import com.bytedance.android.livesdk.jsbridge.methods.upload.UploadMediaResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;

/* JADX INFO: loaded from: classes9.dex */
public abstract class a<P extends c0, R extends UploadMediaResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public a() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
