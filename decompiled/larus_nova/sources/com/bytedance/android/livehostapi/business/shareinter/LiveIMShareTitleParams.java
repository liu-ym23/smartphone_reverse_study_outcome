package com.bytedance.android.livehostapi.business.shareinter;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\u0006R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livehostapi/business/shareinter/LiveIMShareTitleParams;", "", "()V", "bigSceneType", "", "supportCancel", "", "supportWarning", "getBigSceneType", "isSupportCancel", "isSupportWarning", "Builder", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveIMShareTitleParams {
    private String bigSceneType;
    private boolean supportCancel;
    private boolean supportWarning;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livehostapi/business/shareinter/LiveIMShareTitleParams$Builder;", "", "()V", "bigSceneType", "", "supportCancel", "", "supportWarning", "build", "Lcom/bytedance/android/livehostapi/business/shareinter/LiveIMShareTitleParams;", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Builder {
        private String bigSceneType;
        private boolean supportCancel;
        private boolean supportWarning;

        public Builder() {
        }

        public final LiveIMShareTitleParams build() {
            LiveIMShareTitleParams r100 = new LiveIMShareTitleParams();
            LiveIMShareTitleParams.access$setBigSceneType$p(r100, this.bigSceneType);
            LiveIMShareTitleParams.access$setSupportWarning$p(r100, this.supportWarning);
            LiveIMShareTitleParams.access$setSupportCancel$p(r100, this.supportCancel);
            return r100;
        }
    }

    public LiveIMShareTitleParams() {
    }

    public final String getBigSceneType() {
        return this.bigSceneType;
    }

    public final boolean isSupportCancel() {
        return this.supportCancel;
    }

    public final boolean isSupportWarning() {
        return this.supportWarning;
    }

    public static final /* synthetic */ String access$getBigSceneType$p(LiveIMShareTitleParams r100) {
        return r100.bigSceneType;
    }

    public static final /* synthetic */ boolean access$getSupportCancel$p(LiveIMShareTitleParams r100) {
        return r100.supportCancel;
    }

    public static final /* synthetic */ boolean access$getSupportWarning$p(LiveIMShareTitleParams r100) {
        return r100.supportWarning;
    }

    public static final /* synthetic */ void access$setBigSceneType$p(LiveIMShareTitleParams r100, String r101) {
        r100.bigSceneType = r101;
    }

    public static final /* synthetic */ void access$setSupportCancel$p(LiveIMShareTitleParams r100, boolean r101) {
        r100.supportCancel = r101;
    }

    public static final /* synthetic */ void access$setSupportWarning$p(LiveIMShareTitleParams r100, boolean r101) {
        r100.supportWarning = r101;
    }
}
