package com.bytedance.android.livesdk.livecommerce.intro.model.vo;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/vo/IntroUpdateType;", "", "CREATE", "UPDATE", "MUST_SHOW_NEW_CARD", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum IntroUpdateType extends Enum<IntroUpdateType> {
    public static final IntroUpdateType CREATE = null;
    public static final IntroUpdateType MUST_SHOW_NEW_CARD = null;
    public static final IntroUpdateType UPDATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IntroUpdateType[] f148478a = null;

    static {
        IntroUpdateType r100 = new IntroUpdateType("CREATE", 0);
        CREATE = r100;
        IntroUpdateType r101 = new IntroUpdateType("UPDATE", 1);
        UPDATE = r101;
        IntroUpdateType r102 = new IntroUpdateType("MUST_SHOW_NEW_CARD", 2);
        MUST_SHOW_NEW_CARD = r102;
        f148478a = new IntroUpdateType[]{r100, r101, r102};
    }

    public static IntroUpdateType valueOf(String r100) {
        return (IntroUpdateType) a.a(IntroUpdateType.class, r100);
    }

    public static IntroUpdateType[] values() {
        return (IntroUpdateType[]) f148478a.clone();
    }

    public IntroUpdateType(String r100, int r101) {
        super(r100, r101);
    }
}
