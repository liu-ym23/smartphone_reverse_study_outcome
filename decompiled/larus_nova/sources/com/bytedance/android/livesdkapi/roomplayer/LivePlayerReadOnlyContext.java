package com.bytedance.android.livesdkapi.roomplayer;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/LivePlayerReadOnlyContext;", "", "client", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerClient;", "(Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerClient;)V", "clientCode", "", "getClientCode", "()I", "createScene", "", "getCreateScene", "()Ljava/lang/String;", "useScene", "getUseScene", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePlayerReadOnlyContext {
    private final ILivePlayerClient client;
    private final int clientCode;
    private final String createScene;
    private final String useScene;

    public final int getClientCode() {
        return this.clientCode;
    }

    public final String getCreateScene() {
        return this.createScene;
    }

    public final String getUseScene() {
        return this.useScene;
    }

    public LivePlayerReadOnlyContext(ILivePlayerClient r100) {
        this.client = r100;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        this.clientCode = r101;
        String r102 = "";
        if (r100 == null) goto L14;
        LivePlayerClientContext r103 = r100.context();
        if (r103 == null) goto L14;
        ILivePlayerScene r104 = r103.getCreateScene();
        if (r104 == null) goto L14;
        String r105 = r104.getScene();
        if (r105 == null) goto L14;
    L15:
        this.createScene = r105;
        if (r100 == null) goto L25;
        LivePlayerClientContext r106 = r100.context();
        if (r106 == null) goto L25;
        ILivePlayerScene r107 = r106.getUseScene();
        if (r107 == null) goto L25;
        String r108 = r107.getScene();
        if (r108 == null) goto L25;
        r102 = r108;
    L25:
        this.useScene = r102;
        return;
    L14:
        r105 = "";
        goto L15
    L5:
        r101 = -1;
        goto L6
    }
}
