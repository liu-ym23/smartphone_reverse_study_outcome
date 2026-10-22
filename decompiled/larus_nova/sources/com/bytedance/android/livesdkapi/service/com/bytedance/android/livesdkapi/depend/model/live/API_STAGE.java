package com.bytedance.android.livesdkapi.service.com.bytedance.android.livesdkapi.depend.model.live;

import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/com/bytedance/android/livesdkapi/depend/model/live/API_STAGE;", "", SocialConstants.PARAM_APP_DESC, "", "value", "", "(Ljava/lang/String;ILjava/lang/String;I)V", "getDesc", "()Ljava/lang/String;", "getValue", "()I", "NOT_SEND_REQUEST", "HAS_SEND_REQUEST", "HAS_RECEIVE_DATA", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum API_STAGE extends Enum<API_STAGE> {
    private static final /* synthetic */ API_STAGE[] $VALUES = null;
    public static final API_STAGE HAS_RECEIVE_DATA = null;
    public static final API_STAGE HAS_SEND_REQUEST = null;
    public static final API_STAGE NOT_SEND_REQUEST = null;
    private final String desc;
    private final int value;

    static {
        API_STAGE r100 = new API_STAGE("NOT_SEND_REQUEST", 0, "未发送请求", 0);
        NOT_SEND_REQUEST = r100;
        API_STAGE r101 = new API_STAGE("HAS_SEND_REQUEST", 1, "已发送请求", 1);
        HAS_SEND_REQUEST = r101;
        API_STAGE r102 = new API_STAGE("HAS_RECEIVE_DATA", 2, "请求返回", 2);
        HAS_RECEIVE_DATA = r102;
        $VALUES = new API_STAGE[]{r100, r101, r102};
    }

    public static API_STAGE valueOf(String r100) {
        return (API_STAGE) a.a(API_STAGE.class, r100);
    }

    public static API_STAGE[] values() {
        return (API_STAGE[]) $VALUES.clone();
    }

    public final String getDesc() {
        return this.desc;
    }

    public final int getValue() {
        return this.value;
    }

    private API_STAGE(String r100, int r101, String r102, int r103) {
        super(r100, r101);
        this.desc = r102;
        this.value = r103;
    }
}
