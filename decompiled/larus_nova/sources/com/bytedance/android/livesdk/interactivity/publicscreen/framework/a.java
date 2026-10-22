package com.bytedance.android.livesdk.interactivity.publicscreen.framework;

import com.alipay.sdk.m.p.e;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.base.model.message.t;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f138909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f138910b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f138911c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f138912d;

    @Override // com.bytedance.android.live.base.model.message.t
    public final boolean canText() {
        return true;
    }

    @Override // com.bytedance.android.live.base.model.message.t
    public final m0 getBaseMessage() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.message.t
    public final long getConsumeTime() {
        return 0;
    }

    @Override // tlc.d
    public final long getDelayDispatchMs() {
        return 0;
    }

    @Override // tlc.d
    public final int getGeneralMessageType() {
        return 0;
    }

    @Override // com.bytedance.android.live.base.model.message.t
    public final long getHttpSendTime() {
        return 0;
    }

    @Override // tlc.d, com.bytedance.android.livesdkapi.message.IExternalLiveMessage
    public final int getIntType() {
        return 0;
    }

    @Override // com.bytedance.android.live.base.model.message.t
    public final Map<String, String> getMessageExtra() {
        return null;
    }

    @Override // tlc.d
    public final int getMessageFrom() {
        return 0;
    }

    @Override // tlc.d
    public final long getMessageId() {
        return 0;
    }

    @Override // com.bytedance.android.live.base.model.message.t
    public final byte[] getRawPayload() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.message.t
    public final long getReceiveTime() {
        return 0;
    }

    @Override // tlc.d
    public final long getRoomId() {
        return 0;
    }

    @Override // com.bytedance.android.live.base.model.message.t
    public final long getTimestamp() {
        return 0;
    }

    @Override // com.bytedance.android.live.base.model.message.t
    public final boolean isCurrentRoom(long r100) {
        return true;
    }

    @Override // com.bytedance.android.live.base.model.message.t
    public final boolean isFirstHistoryMessage() {
        return false;
    }

    @Override // tlc.d
    public final boolean isFromFirstRequest() {
        return false;
    }

    @Override // com.bytedance.android.live.base.model.message.t
    public final boolean isFromOtherIntercomRoom() {
        return false;
    }

    @Override // tlc.d
    public final boolean isGlobalMessage() {
        return false;
    }

    @Override // com.bytedance.android.live.base.model.message.t
    public final boolean isInsert() {
        return false;
    }

    @Override // tlc.d
    public final boolean needMonitor() {
        return false;
    }

    @Override // tlc.d
    public final void setConsumeTime(long r100) {
    }

    @Override // tlc.d
    public final void setDecodeEndTime(long r100) {
    }

    @Override // tlc.d
    public final void setDecodeStartTime(long r100) {
    }

    @Override // tlc.d
    public final void setEnqueueDispatchTime(long r100) {
    }

    @Override // tlc.d
    public final void setHttpSendTime(long r100) {
    }

    @Override // com.bytedance.android.live.base.model.message.t
    public final void setIsFirstHistoryMessage(boolean r100) {
    }

    @Override // tlc.d
    public final void setIsFromFirstRequest(boolean r100) {
    }

    @Override // tlc.d
    public final void setIsInsert(boolean r100) {
    }

    @Override // tlc.d
    public final void setReceiveTime(long r100) {
    }

    @Override // com.bytedance.android.live.base.model.message.t
    public final void setTooMuchMsg(boolean r100) {
    }

    @Override // com.bytedance.android.live.base.model.message.t
    public final boolean supportDisplayText() {
        return false;
    }

    public a() {
        this.f138909a = "--default--";
    }

    @Override // tlc.d
    public final String getMessageMethod() {
        return this.f138909a;
    }

    @Override // xlc.b
    public final String getWRDSKey() {
        return this.f138909a;
    }

    @Override // xlc.b
    public final String getWRDSSubKey() {
        return this.f138912d;
    }

    @Override // xlc.b
    public final long getWRDSVersion() {
        return this.f138911c;
    }

    @Override // xlc.b
    public final boolean isWRDSMessage() {
        return this.f138910b;
    }

    @Override // tlc.d
    public final void setMessageMethod(String r100) {
        Intrinsics.checkNotNullParameter(r100, e.f25671s);
        this.f138909a = r100;
    }

    @Override // xlc.b
    public final void setWRDSMessage(boolean r100) {
        this.f138910b = r100;
    }

    @Override // xlc.b
    public final void setWRDSSubKey(String r100) {
        this.f138912d = r100;
    }

    @Override // xlc.b
    public final void setWRDSVersion(long r100) {
        this.f138911c = r100;
    }
}
