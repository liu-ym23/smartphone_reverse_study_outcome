package ao0;

import com.bytedance.android.livesdkapi.ILiveResponseExtraInfo;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements ILiveResponseExtraInfo.IStatusInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f15694b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f15695c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f15696d;

    @Override // com.bytedance.android.livesdkapi.ILiveResponseExtraInfo.IStatusInfo
    public final int getCode() {
        return this.f15693a;
    }

    @Override // com.bytedance.android.livesdkapi.ILiveResponseExtraInfo.IStatusInfo
    public final String getMessage() {
        return this.f15694b;
    }

    @Override // com.bytedance.android.livesdkapi.ILiveResponseExtraInfo.IStatusInfo
    public final String getPrompts() {
        return this.f15695c;
    }

    @Override // com.bytedance.android.livesdkapi.ILiveResponseExtraInfo.IStatusInfo
    public final String getVerifyConfig() {
        return this.f15696d;
    }

    public a(int r100, String r101, String r102) {
        this.f15693a = r100;
        this.f15694b = r101;
        this.f15695c = r102;
        this.f15696d = null;
    }
}
