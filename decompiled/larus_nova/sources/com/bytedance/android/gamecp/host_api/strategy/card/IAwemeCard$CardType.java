package com.bytedance.android.gamecp.host_api.strategy.card;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"com/bytedance/android/gamecp/host_api/strategy/card/IAwemeCard$CardType", "", "Lcom/bytedance/android/gamecp/host_api/strategy/card/IAwemeCard$CardType;", "", "type", "I", "getType", "()I", "UNDEFINED", "VIDEO", "IMAGE_TEXT", "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum IAwemeCard$CardType extends Enum<IAwemeCard$CardType> {
    public static final IAwemeCard$CardType IMAGE_TEXT = null;
    public static final IAwemeCard$CardType UNDEFINED = null;
    public static final IAwemeCard$CardType VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IAwemeCard$CardType[] f57429a = null;
    private final int type;

    static {
        IAwemeCard$CardType r100 = new IAwemeCard$CardType("UNDEFINED", 0, 0);
        UNDEFINED = r100;
        IAwemeCard$CardType r101 = new IAwemeCard$CardType("VIDEO", 1, 1);
        VIDEO = r101;
        IAwemeCard$CardType r102 = new IAwemeCard$CardType("IMAGE_TEXT", 2, 2);
        IMAGE_TEXT = r102;
        f57429a = new IAwemeCard$CardType[]{r100, r101, r102};
    }

    public static IAwemeCard$CardType valueOf(String r100) {
        return (IAwemeCard$CardType) a.a(IAwemeCard$CardType.class, r100);
    }

    public static IAwemeCard$CardType[] values() {
        return (IAwemeCard$CardType[]) f57429a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public IAwemeCard$CardType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
