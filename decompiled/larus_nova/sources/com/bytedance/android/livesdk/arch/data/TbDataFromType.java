package com.bytedance.android.livesdk.arch.data;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/arch/data/TbDataFromType;", "", "", SocialConstants.PARAM_APP_DESC, "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Unknown", "Direct", "DoubleCheckFail", "DoubleCheckSuccess", "toolbarservice-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum TbDataFromType extends Enum<TbDataFromType> {
    public static final a Companion = null;
    public static final TbDataFromType Direct = null;
    public static final TbDataFromType DoubleCheckFail = null;
    public static final TbDataFromType DoubleCheckSuccess = null;
    public static final TbDataFromType Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TbDataFromType[] f103770a = null;
    private final String desc;

    public static final class a {
        public a() {
        }
    }

    static {
        TbDataFromType r100 = new TbDataFromType("Unknown", 0, "Unknown");
        Unknown = r100;
        TbDataFromType r101 = new TbDataFromType("Direct", 1, "Direct Load");
        Direct = r101;
        TbDataFromType r102 = new TbDataFromType("DoubleCheckFail", 2, "Double Check Error");
        DoubleCheckFail = r102;
        TbDataFromType r103 = new TbDataFromType("DoubleCheckSuccess", 3, "Double check Success");
        DoubleCheckSuccess = r103;
        f103770a = new TbDataFromType[]{r100, r101, r102, r103};
        Companion = new a();
    }

    public static TbDataFromType valueOf(String r100) {
        return (TbDataFromType) r27.a.a(TbDataFromType.class, r100);
    }

    public static TbDataFromType[] values() {
        return (TbDataFromType[]) f103770a.clone();
    }

    public final String getDesc() {
        return this.desc;
    }

    public TbDataFromType(String r100, int r101, String r102) {
        super(r100, r101);
        this.desc = r102;
    }
}
