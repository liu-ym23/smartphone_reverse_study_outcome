package com.bytedance.android.livesdk.arch.intercept;

import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/arch/intercept/InterceptType;", "", "", SocialConstants.PARAM_APP_DESC, "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "BizCheck", "ConfigCheck", "toolbarservice-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum InterceptType extends Enum<InterceptType> {
    public static final InterceptType BizCheck = null;
    public static final InterceptType ConfigCheck = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InterceptType[] f103808a = null;
    private final String desc;

    static {
        InterceptType r100 = new InterceptType("BizCheck", 0, "业务二次确认");
        BizCheck = r100;
        InterceptType r101 = new InterceptType("ConfigCheck", 1, "配置条件检查");
        ConfigCheck = r101;
        f103808a = new InterceptType[]{r100, r101};
    }

    public static InterceptType valueOf(String r100) {
        return (InterceptType) a.a(InterceptType.class, r100);
    }

    public static InterceptType[] values() {
        return (InterceptType[]) f103808a.clone();
    }

    public final String getDesc() {
        return this.desc;
    }

    public InterceptType(String r100, int r101, String r102) {
        super(r100, r101);
        this.desc = r102;
    }
}
