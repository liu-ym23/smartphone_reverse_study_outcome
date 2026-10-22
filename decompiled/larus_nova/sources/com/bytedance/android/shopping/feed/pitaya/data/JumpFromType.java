package com.bytedance.android.shopping.feed.pitaya.data;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/feed/pitaya/data/JumpFromType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "GUESS_U_LIKE", "MAIN_CARD", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum JumpFromType extends Enum<JumpFromType> {
    public static final JumpFromType GUESS_U_LIKE = null;
    public static final JumpFromType MAIN_CARD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ JumpFromType[] f175127a = null;
    private final String type;

    static {
        JumpFromType r100 = new JumpFromType("GUESS_U_LIKE", 0, "guess_u_like");
        GUESS_U_LIKE = r100;
        JumpFromType r101 = new JumpFromType("MAIN_CARD", 1, "main_card");
        MAIN_CARD = r101;
        f175127a = new JumpFromType[]{r100, r101};
    }

    public static JumpFromType valueOf(String r100) {
        return (JumpFromType) a.a(JumpFromType.class, r100);
    }

    public static JumpFromType[] values() {
        return (JumpFromType[]) f175127a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public JumpFromType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
