package com.bytedance.android.livesdkapi.service.com.bytedance.android.livesdkapi.depend.model.live;

import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/com/bytedance/android/livesdkapi/depend/model/live/PRELOAD_STAGE;", "", SocialConstants.PARAM_APP_DESC, "", "value", "", "(Ljava/lang/String;ILjava/lang/String;I)V", "getDesc", "()Ljava/lang/String;", "getValue", "()I", "NOT_INVOKE_PRELOAD", "HAS_INVOKE_PRELOAD", "INTERACTION_FINISH", "START_LOAD_PRELOAD_COMPONENT", "PRELOAD_COMPONENT_FINISH", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PRELOAD_STAGE extends Enum<PRELOAD_STAGE> {
    private static final /* synthetic */ PRELOAD_STAGE[] $VALUES = null;
    public static final PRELOAD_STAGE HAS_INVOKE_PRELOAD = null;
    public static final PRELOAD_STAGE INTERACTION_FINISH = null;
    public static final PRELOAD_STAGE NOT_INVOKE_PRELOAD = null;
    public static final PRELOAD_STAGE PRELOAD_COMPONENT_FINISH = null;
    public static final PRELOAD_STAGE START_LOAD_PRELOAD_COMPONENT = null;
    private final String desc;
    private final int value;

    static {
        PRELOAD_STAGE r100 = new PRELOAD_STAGE("NOT_INVOKE_PRELOAD", 0, "未触发预加载", 0);
        NOT_INVOKE_PRELOAD = r100;
        PRELOAD_STAGE r101 = new PRELOAD_STAGE("HAS_INVOKE_PRELOAD", 1, "触发了预加载", 1);
        HAS_INVOKE_PRELOAD = r101;
        PRELOAD_STAGE r102 = new PRELOAD_STAGE("INTERACTION_FINISH", 2, "交互层创建完成", 2);
        INTERACTION_FINISH = r102;
        PRELOAD_STAGE r103 = new PRELOAD_STAGE("START_LOAD_PRELOAD_COMPONENT", 3, "开始加载preload组件", 3);
        START_LOAD_PRELOAD_COMPONENT = r103;
        PRELOAD_STAGE r104 = new PRELOAD_STAGE("PRELOAD_COMPONENT_FINISH", 4, "preload组件加载完成", 4);
        PRELOAD_COMPONENT_FINISH = r104;
        $VALUES = new PRELOAD_STAGE[]{r100, r101, r102, r103, r104};
    }

    public static PRELOAD_STAGE valueOf(String r100) {
        return (PRELOAD_STAGE) a.a(PRELOAD_STAGE.class, r100);
    }

    public static PRELOAD_STAGE[] values() {
        return (PRELOAD_STAGE[]) $VALUES.clone();
    }

    public final String getDesc() {
        return this.desc;
    }

    public final int getValue() {
        return this.value;
    }

    private PRELOAD_STAGE(String r100, int r101, String r102, int r103) {
        super(r100, r101);
        this.desc = r102;
        this.value = r103;
    }
}
