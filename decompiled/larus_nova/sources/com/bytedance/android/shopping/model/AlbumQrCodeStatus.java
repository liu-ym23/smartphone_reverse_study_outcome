package com.bytedance.android.shopping.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/model/AlbumQrCodeStatus;", "", "", "value", "I", "getValue", "()I", "CLOSE_ALBUM", "SUCCESS", "ERROR", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final enum AlbumQrCodeStatus extends Enum<AlbumQrCodeStatus> {
    public static final AlbumQrCodeStatus CLOSE_ALBUM = null;
    public static final AlbumQrCodeStatus ERROR = null;
    public static final AlbumQrCodeStatus SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AlbumQrCodeStatus[] f178640a = null;
    private final int value;

    static {
        AlbumQrCodeStatus r100 = new AlbumQrCodeStatus("CLOSE_ALBUM", 0, 0);
        CLOSE_ALBUM = r100;
        AlbumQrCodeStatus r101 = new AlbumQrCodeStatus("SUCCESS", 1, 1);
        SUCCESS = r101;
        AlbumQrCodeStatus r102 = new AlbumQrCodeStatus("ERROR", 2, 2);
        ERROR = r102;
        f178640a = new AlbumQrCodeStatus[]{r100, r101, r102};
    }

    public static AlbumQrCodeStatus valueOf(String r100) {
        return (AlbumQrCodeStatus) a.a(AlbumQrCodeStatus.class, r100);
    }

    public static AlbumQrCodeStatus[] values() {
        return (AlbumQrCodeStatus[]) f178640a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public AlbumQrCodeStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
