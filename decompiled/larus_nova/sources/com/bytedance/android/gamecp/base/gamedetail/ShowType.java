package com.bytedance.android.gamecp.base.gamedetail;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/gamecp/base/gamedetail/ShowType;", "", "", "type", "I", "getType", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, EffectConstants.NORMAL, "FLOAT", "SPLIT_SCREEN", "gamecp-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ShowType extends Enum<ShowType> {
    public static final a Companion = null;
    public static final ShowType FLOAT = null;
    public static final ShowType NORMAL = null;
    public static final ShowType SPLIT_SCREEN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ShowType[] f51535a = null;
    private final int type;

    public static final class a {
        public a() {
        }
    }

    static {
        ShowType r100 = new ShowType(EffectConstants.NORMAL, 0, 0);
        NORMAL = r100;
        ShowType r101 = new ShowType("FLOAT", 1, 1);
        FLOAT = r101;
        ShowType r102 = new ShowType("SPLIT_SCREEN", 2, 2);
        SPLIT_SCREEN = r102;
        f51535a = new ShowType[]{r100, r101, r102};
        Companion = new a();
    }

    public static ShowType valueOf(String r100) {
        return (ShowType) r27.a.a(ShowType.class, r100);
    }

    public static ShowType[] values() {
        return (ShowType[]) f51535a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public ShowType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
