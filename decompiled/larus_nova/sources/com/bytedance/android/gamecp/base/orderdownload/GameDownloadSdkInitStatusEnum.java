package com.bytedance.android.gamecp.base.orderdownload;

import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/gamecp/base/orderdownload/GameDownloadSdkInitStatusEnum;", "", "", BaseSwitches.V, "I", "getV", "()I", "DEFAULT", "INIT_FINISH", "WAIT_INIT", "gamecp-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum GameDownloadSdkInitStatusEnum extends Enum<GameDownloadSdkInitStatusEnum> {
    public static final GameDownloadSdkInitStatusEnum DEFAULT = null;
    public static final GameDownloadSdkInitStatusEnum INIT_FINISH = null;
    public static final GameDownloadSdkInitStatusEnum WAIT_INIT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GameDownloadSdkInitStatusEnum[] f51697a = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final int f51698v;

    static {
        GameDownloadSdkInitStatusEnum r100 = new GameDownloadSdkInitStatusEnum("DEFAULT", 0, -1);
        DEFAULT = r100;
        GameDownloadSdkInitStatusEnum r101 = new GameDownloadSdkInitStatusEnum("INIT_FINISH", 1, 0);
        INIT_FINISH = r101;
        GameDownloadSdkInitStatusEnum r102 = new GameDownloadSdkInitStatusEnum("WAIT_INIT", 2, 1);
        WAIT_INIT = r102;
        f51697a = new GameDownloadSdkInitStatusEnum[]{r100, r101, r102};
    }

    public static GameDownloadSdkInitStatusEnum valueOf(String r100) {
        return (GameDownloadSdkInitStatusEnum) a.a(GameDownloadSdkInitStatusEnum.class, r100);
    }

    public static GameDownloadSdkInitStatusEnum[] values() {
        return (GameDownloadSdkInitStatusEnum[]) f51697a.clone();
    }

    public final int getV() {
        return this.f51698v;
    }

    public GameDownloadSdkInitStatusEnum(String r100, int r101, int r102) {
        super(r100, r101);
        this.f51698v = r102;
    }

    public /* synthetic */ GameDownloadSdkInitStatusEnum(String r100, int r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L5;
        r102 = -1;
    L5:
        this(r100, r101, r102);
    }
}
