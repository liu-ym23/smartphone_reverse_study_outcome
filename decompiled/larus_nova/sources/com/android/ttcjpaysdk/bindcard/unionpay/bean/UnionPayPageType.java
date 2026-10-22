package com.android.ttcjpaysdk.bindcard.unionpay.bean;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/unionpay/bean/UnionPayPageType;", "", "(Ljava/lang/String;I)V", "TYPE_IDENTITY_VERIFY", "TYPE_FACE_VERIFY", "TYPE_PASSWORD_VERIFY", "TYPE_UNION_PAY_SIGN", "TYPE_UNION_CARD_LIST", "TYPE_DEFAULT", "bdpay-bindcard-unionpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum UnionPayPageType extends Enum<UnionPayPageType> {
    private static final /* synthetic */ UnionPayPageType[] $VALUES = null;
    public static final UnionPayPageType TYPE_DEFAULT = null;
    public static final UnionPayPageType TYPE_FACE_VERIFY = null;
    public static final UnionPayPageType TYPE_IDENTITY_VERIFY = null;
    public static final UnionPayPageType TYPE_PASSWORD_VERIFY = null;
    public static final UnionPayPageType TYPE_UNION_CARD_LIST = null;
    public static final UnionPayPageType TYPE_UNION_PAY_SIGN = null;

    private static final /* synthetic */ UnionPayPageType[] $values() {
        return new UnionPayPageType[]{TYPE_IDENTITY_VERIFY, TYPE_FACE_VERIFY, TYPE_PASSWORD_VERIFY, TYPE_UNION_PAY_SIGN, TYPE_UNION_CARD_LIST, TYPE_DEFAULT};
    }

    public static UnionPayPageType valueOf(String r100) {
        return (UnionPayPageType) a.a(UnionPayPageType.class, r100);
    }

    public static UnionPayPageType[] values() {
        return (UnionPayPageType[]) $VALUES.clone();
    }

    static {
        TYPE_IDENTITY_VERIFY = new UnionPayPageType("TYPE_IDENTITY_VERIFY", 0);
        TYPE_FACE_VERIFY = new UnionPayPageType("TYPE_FACE_VERIFY", 1);
        TYPE_PASSWORD_VERIFY = new UnionPayPageType("TYPE_PASSWORD_VERIFY", 2);
        TYPE_UNION_PAY_SIGN = new UnionPayPageType("TYPE_UNION_PAY_SIGN", 3);
        TYPE_UNION_CARD_LIST = new UnionPayPageType("TYPE_UNION_CARD_LIST", 4);
        TYPE_DEFAULT = new UnionPayPageType("TYPE_DEFAULT", 5);
        $VALUES = $values();
    }

    private UnionPayPageType(String r100, int r101) {
        super(r100, r101);
    }
}
