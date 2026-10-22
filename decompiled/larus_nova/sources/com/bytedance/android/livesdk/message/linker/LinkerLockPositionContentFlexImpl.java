package com.bytedance.android.livesdk.message.linker;

import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.LinkerLockPositionContent")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\r\u0010\u000eR;\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/message/linker/LinkerLockPositionContentFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/message/linker/LinkerLockPositionContent;", "", "Lcom/bytedance/android/live/liveinteract/multianchor/model/LinkmicPositionItem;", "<set-?>", "lockedPositions$delegate", "Ljava/lang/Object;", "getLockedPositions", "()Ljava/util/List;", "setLockedPositions", "(Ljava/util/List;)V", "lockedPositions", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkerLockPositionContentFlexImpl extends FlexModelBase<LinkerLockPositionContent> implements LinkerLockPositionContent, vh7.h {

    @SerializedName("locked_positions")
    protected List<? extends LinkmicPositionItem> _$$lockedPositions;

    public LinkerLockPositionContentFlexImpl() {
        super(LinkerLockPositionContent.class);
    }

    public LinkerLockPositionContentFlexImpl(am3.g r100) {
        super(LinkerLockPositionContent.class);
        this._$$lockedPositions = new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L7;
        this._$$lockedPositions.add(vh7.f.a(r100, LinkmicPositionItem.class));
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L9:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.message.linker.LinkerLockPositionContent
    public final List<LinkmicPositionItem> getLockedPositions() {
        return this._$$lockedPositions;
    }

    @Override // com.bytedance.android.livesdk.message.linker.LinkerLockPositionContent
    public final void setLockedPositions(List<? extends LinkmicPositionItem> r100) {
        this._$$lockedPositions = r100;
    }
}
