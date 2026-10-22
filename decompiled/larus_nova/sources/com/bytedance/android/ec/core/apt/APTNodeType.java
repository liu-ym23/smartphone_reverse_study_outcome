package com.bytedance.android.ec.core.apt;

import com.obric.miniapp.alarm.AlarmSessionType;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/ec/core/apt/APTNodeType;", "", "", "value", "I", "getValue", "()I", "DEFAULT", "ENTER_PAGE", "QUIT_PAGE", "NETWORK", AlarmSessionType.EVENT, "OUTER_SCHEMA", "DIFF", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum APTNodeType extends Enum<APTNodeType> {
    public static final APTNodeType DEFAULT = null;
    public static final APTNodeType DIFF = null;
    public static final APTNodeType ENTER_PAGE = null;
    public static final APTNodeType EVENT = null;
    public static final APTNodeType NETWORK = null;
    public static final APTNodeType OUTER_SCHEMA = null;
    public static final APTNodeType QUIT_PAGE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ APTNodeType[] f43825a = null;
    private final int value;

    static {
        APTNodeType r100 = new APTNodeType("DEFAULT", 0, 0);
        DEFAULT = r100;
        APTNodeType r101 = new APTNodeType("ENTER_PAGE", 1, 1);
        ENTER_PAGE = r101;
        APTNodeType r102 = new APTNodeType("QUIT_PAGE", 2, 2);
        QUIT_PAGE = r102;
        APTNodeType r103 = new APTNodeType("NETWORK", 3, 3);
        NETWORK = r103;
        APTNodeType r104 = new APTNodeType(AlarmSessionType.EVENT, 4, 4);
        EVENT = r104;
        APTNodeType r105 = new APTNodeType("OUTER_SCHEMA", 5, 5);
        OUTER_SCHEMA = r105;
        APTNodeType r106 = new APTNodeType("DIFF", 6, 99);
        DIFF = r106;
        f43825a = new APTNodeType[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static APTNodeType valueOf(String r100) {
        return (APTNodeType) a.a(APTNodeType.class, r100);
    }

    public static APTNodeType[] values() {
        return (APTNodeType[]) f43825a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public APTNodeType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
