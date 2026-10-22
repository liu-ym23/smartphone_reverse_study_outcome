package com.bytedance.android.livesdkapi.depend.model.live.linker;

import am3.g;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerRTCActionContent;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerRTCActionContent;", "()V", ReportConstant.COMMON_ACTION_TYPE, "", "getActionType", "()I", "setActionType", "(I)V", "joinRtcContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerRTCActionJoinRTCContent;", "getJoinRtcContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerRTCActionJoinRTCContent;", "setJoinRtcContent", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerRTCActionJoinRTCContent;)V", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkerRTCActionContent extends FlexModelBase<ILinkerRTCActionContent> implements ILinkerRTCActionContent, h {
    public static final int CONTENT_ACTION_TYPE_JOIN_RTC = 1;
    public static final int CONTENT_ACTION_TYPE_UNKNOWN = 0;
    public static final Companion Companion = null;

    @SerializedName("type")
    protected int actionType;

    @SerializedName("join_rtc_content")
    protected ILinkerRTCActionJoinRTCContent joinRtcContent;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerRTCActionContent$Companion;", "", "()V", "CONTENT_ACTION_TYPE_JOIN_RTC", "", "CONTENT_ACTION_TYPE_UNKNOWN", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public LinkerRTCActionContent() {
        super(ILinkerRTCActionContent.class);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerRTCActionContent
    public int getActionType() {
        return this.actionType;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerRTCActionContent
    public ILinkerRTCActionJoinRTCContent getJoinRtcContent() {
        return this.joinRtcContent;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerRTCActionJoinRTCContent, java.lang.Object] */
    public LinkerRTCActionContent(g r100) {
        super(ILinkerRTCActionContent.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.actionType = r100.i();
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.joinRtcContent = f.a(r100, ILinkerRTCActionJoinRTCContent.class);
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerRTCActionContent
    public void setActionType(int r100) {
        this.actionType = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerRTCActionContent
    public void setJoinRtcContent(ILinkerRTCActionJoinRTCContent r100) {
        this.joinRtcContent = r100;
    }
}
