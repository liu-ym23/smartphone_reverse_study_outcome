package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0013\u0010\b\"\u0004\b\u0014\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/GetSilenceBlockTypeResponseData;", "", "", "isValid", "", "blockType", "J", "getBlockType", "()J", "setBlockType", "(J)V", "", "toastText", "Ljava/lang/String;", "getToastText", "()Ljava/lang/String;", "setToastText", "(Ljava/lang/String;)V", "latestTimestamp", "getLatestTimestamp", "setLatestTimestamp", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GetSilenceBlockTypeResponseData implements vh7.h {
    public static final a Companion = null;
    public static final long OPERATION_DEFAULT = 0;
    public static final long OPERATION_DIALOG = 2;
    public static final long OPERATION_TOAST = 1;

    @SerializedName("block_type")
    protected long blockType;
    private long latestTimestamp;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_TASK_TOKEN_TOAST_TEXT)
    protected String toastText;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public GetSilenceBlockTypeResponseData() {
    }

    public final boolean isValid() {
        if ((System.currentTimeMillis() - this.latestTimestamp) >= 3000) goto L5;
        return true;
    L5:
        return false;
    }

    public final long getBlockType() {
        return this.blockType;
    }

    public final long getLatestTimestamp() {
        return this.latestTimestamp;
    }

    public final String getToastText() {
        return this.toastText;
    }

    public GetSilenceBlockTypeResponseData(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.blockType = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.toastText = am3.h.c(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }

    public final void setBlockType(long r100) {
        this.blockType = r100;
    }

    public final void setLatestTimestamp(long r100) {
        this.latestTimestamp = r100;
    }

    public final void setToastText(String r100) {
        this.toastText = r100;
    }
}
