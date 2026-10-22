package com.bytedance.ai.bridge.context;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ai/bridge/context/RefType;", "", "<init>", "(Ljava/lang/String;I)V", EffectConstants.NORMAL, "WEAK", "applet-bridge_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RefType extends Enum<RefType> {
    public static final RefType NORMAL = null;
    public static final RefType WEAK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RefType[] f35237a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f35238b = null;

    public static EnumEntries<RefType> getEntries() {
        return f35238b;
    }

    static {
        RefType r100 = new RefType(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        RefType r101 = new RefType("WEAK", 1);
        WEAK = r101;
        RefType[] r102 = {r100, r101};
        f35237a = r102;
        f35238b = EnumEntriesKt.enumEntries(r102);
    }

    public static RefType[] values() {
        return (RefType[]) f35237a.clone();
    }

    public static RefType valueOf(String r100) {
        return (RefType) a.a(RefType.class, r100);
    }

    public RefType(String r100, int r101) {
        super(r100, r101);
    }
}
