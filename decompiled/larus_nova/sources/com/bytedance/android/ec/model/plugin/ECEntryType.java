package com.bytedance.android.ec.model.plugin;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/ec/model/plugin/ECEntryType;", "", "ON_CLICK_EVENT", "ON_PAGE_CREATE", "FROM_JS_BRIDGE", "FROM_SCHEMA", "FROM_ROUTER", "PASSIVE_DISPLAY", AccountType.OTHERS, "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final enum ECEntryType extends Enum<ECEntryType> {
    public static final ECEntryType FROM_JS_BRIDGE = null;
    public static final ECEntryType FROM_ROUTER = null;
    public static final ECEntryType FROM_SCHEMA = null;
    public static final ECEntryType ON_CLICK_EVENT = null;
    public static final ECEntryType ON_PAGE_CREATE = null;
    public static final ECEntryType OTHERS = null;
    public static final ECEntryType PASSIVE_DISPLAY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ECEntryType[] f47893a = null;

    static {
        ECEntryType r100 = new ECEntryType("ON_CLICK_EVENT", 0);
        ON_CLICK_EVENT = r100;
        ECEntryType r101 = new ECEntryType("ON_PAGE_CREATE", 1);
        ON_PAGE_CREATE = r101;
        ECEntryType r102 = new ECEntryType("FROM_JS_BRIDGE", 2);
        FROM_JS_BRIDGE = r102;
        ECEntryType r103 = new ECEntryType("FROM_SCHEMA", 3);
        FROM_SCHEMA = r103;
        ECEntryType r104 = new ECEntryType("FROM_ROUTER", 4);
        FROM_ROUTER = r104;
        ECEntryType r105 = new ECEntryType("PASSIVE_DISPLAY", 5);
        PASSIVE_DISPLAY = r105;
        ECEntryType r106 = new ECEntryType(AccountType.OTHERS, 6);
        OTHERS = r106;
        f47893a = new ECEntryType[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static ECEntryType valueOf(String r100) {
        return (ECEntryType) a.a(ECEntryType.class, r100);
    }

    public static ECEntryType[] values() {
        return (ECEntryType[]) f47893a.clone();
    }

    public ECEntryType(String r100, int r101) {
        super(r100, r101);
    }
}
