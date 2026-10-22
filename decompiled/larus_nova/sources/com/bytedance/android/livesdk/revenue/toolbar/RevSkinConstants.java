package com.bytedance.android.livesdk.revenue.toolbar;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/toolbar/RevSkinConstants;", "", "", "value", "I", "getValue", "()I", "Gift", "BackUpBorder", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RevSkinConstants extends Enum<RevSkinConstants> {
    public static final RevSkinConstants BackUpBorder = null;
    public static final RevSkinConstants Gift = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RevSkinConstants[] f157521a = null;
    private final int value;

    static {
        RevSkinConstants r100 = new RevSkinConstants("Gift", 0, 3);
        Gift = r100;
        RevSkinConstants r101 = new RevSkinConstants("BackUpBorder", 1, 12);
        BackUpBorder = r101;
        f157521a = new RevSkinConstants[]{r100, r101};
    }

    public static RevSkinConstants valueOf(String r100) {
        return (RevSkinConstants) a.a(RevSkinConstants.class, r100);
    }

    public static RevSkinConstants[] values() {
        return (RevSkinConstants[]) f157521a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public RevSkinConstants(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
