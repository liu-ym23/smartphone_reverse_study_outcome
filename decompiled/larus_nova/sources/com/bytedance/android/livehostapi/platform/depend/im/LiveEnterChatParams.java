package com.bytedance.android.livehostapi.platform.depend.im;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b*\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010?\u001a\u00020\nH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR\u001a\u0010\u001e\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR\u001a\u0010!\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000eR\u001a\u0010$\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0018\"\u0004\b&\u0010\u001aR\u001a\u0010'\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\f\"\u0004\b)\u0010\u000eR\u001a\u0010*\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\u001a\u0010-\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\u001a\u00100\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR\u001a\u00103\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0018\"\u0004\b5\u0010\u001aR\u001a\u00106\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\f\"\u0004\b8\u0010\u000eR\u001a\u00109\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\f\"\u0004\b;\u0010\u000eR\u001a\u0010<\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\f\"\u0004\b>\u0010\u000e¨\u0006@"}, d2 = {"Lcom/bytedance/android/livehostapi/platform/depend/im/LiveEnterChatParams;", "", "()V", "autoFullModeOnInput", "", "getAutoFullModeOnInput", "()Z", "setAutoFullModeOnInput", "(Z)V", "cUid", "", "getCUid", "()Ljava/lang/String;", "setCUid", "(Ljava/lang/String;)V", "checkMsg", "getCheckMsg", "setCheckMsg", "cid", "getCid", "setCid", "enterFrom", "", "getEnterFrom", "()I", "setEnterFrom", "(I)V", "enterFromForMob", "getEnterFromForMob", "setEnterFromForMob", "enterMethodForMob", "getEnterMethodForMob", "setEnterMethodForMob", "extraJsonForMob", "getExtraJsonForMob", "setExtraJsonForMob", "floatPageHeightPx", "getFloatPageHeightPx", "setFloatPageHeightPx", "liveExtra", "getLiveExtra", "setLiveExtra", "localGroupChatOnly", "getLocalGroupChatOnly", "setLocalGroupChatOnly", "needFloatMode", "getNeedFloatMode", "setNeedFloatMode", "needShowAdReportBtn", "getNeedShowAdReportBtn", "setNeedShowAdReportBtn", "role", "getRole", "setRole", "spUid", "getSpUid", "setSpUid", "type", "getType", "setType", "uid", "getUid", "setUid", "toString", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveEnterChatParams {
    private boolean autoFullModeOnInput;
    private String cUid;
    private String checkMsg;
    private String cid;
    private int enterFrom;
    private String enterFromForMob;
    private String enterMethodForMob;
    private String extraJsonForMob;
    private int floatPageHeightPx;
    private String liveExtra;
    private boolean localGroupChatOnly;
    private boolean needFloatMode;
    private boolean needShowAdReportBtn;
    private int role;
    private String spUid;
    private String type;
    private String uid;

    public String toString() {
        return "LiveEnterChatParams(type='" + this.type + "', cid='" + this.cid + "', uid='" + this.uid + "', needFloatMode=" + this.needFloatMode + ", floatPageHeightPx=" + this.floatPageHeightPx + ", needShowAdReportBtn=" + this.needShowAdReportBtn + ", autoFullModeOnInput=" + this.autoFullModeOnInput + ", localGroupChatOnly=" + this.localGroupChatOnly + ", enterFrom=" + this.enterFrom + ", enterFromForMob='" + this.enterFromForMob + "', enterMethodForMob='" + this.enterMethodForMob + "', extraJsonForMob='" + this.extraJsonForMob + "')";
    }

    public LiveEnterChatParams() {
        this.liveExtra = "";
        this.type = "";
        this.spUid = "0";
        this.cUid = "0";
        this.cid = "";
        this.uid = "";
        this.floatPageHeightPx = -1;
        this.enterFrom = -1;
        this.enterFromForMob = "";
        this.enterMethodForMob = "";
        this.extraJsonForMob = "";
    }

    public final boolean getAutoFullModeOnInput() {
        return this.autoFullModeOnInput;
    }

    public final String getCUid() {
        return this.cUid;
    }

    public final String getCheckMsg() {
        return this.checkMsg;
    }

    public final String getCid() {
        return this.cid;
    }

    public final int getEnterFrom() {
        return this.enterFrom;
    }

    public final String getEnterFromForMob() {
        return this.enterFromForMob;
    }

    public final String getEnterMethodForMob() {
        return this.enterMethodForMob;
    }

    public final String getExtraJsonForMob() {
        return this.extraJsonForMob;
    }

    public final int getFloatPageHeightPx() {
        return this.floatPageHeightPx;
    }

    public final String getLiveExtra() {
        return this.liveExtra;
    }

    public final boolean getLocalGroupChatOnly() {
        return this.localGroupChatOnly;
    }

    public final boolean getNeedFloatMode() {
        return this.needFloatMode;
    }

    public final boolean getNeedShowAdReportBtn() {
        return this.needShowAdReportBtn;
    }

    public final int getRole() {
        return this.role;
    }

    public final String getSpUid() {
        return this.spUid;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUid() {
        return this.uid;
    }

    public final void setAutoFullModeOnInput(boolean r100) {
        this.autoFullModeOnInput = r100;
    }

    public final void setCUid(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.cUid = r100;
    }

    public final void setCheckMsg(String r100) {
        this.checkMsg = r100;
    }

    public final void setCid(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.cid = r100;
    }

    public final void setEnterFrom(int r100) {
        this.enterFrom = r100;
    }

    public final void setEnterFromForMob(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enterFromForMob = r100;
    }

    public final void setEnterMethodForMob(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enterMethodForMob = r100;
    }

    public final void setExtraJsonForMob(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.extraJsonForMob = r100;
    }

    public final void setFloatPageHeightPx(int r100) {
        this.floatPageHeightPx = r100;
    }

    public final void setLiveExtra(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.liveExtra = r100;
    }

    public final void setLocalGroupChatOnly(boolean r100) {
        this.localGroupChatOnly = r100;
    }

    public final void setNeedFloatMode(boolean r100) {
        this.needFloatMode = r100;
    }

    public final void setNeedShowAdReportBtn(boolean r100) {
        this.needShowAdReportBtn = r100;
    }

    public final void setRole(int r100) {
        this.role = r100;
    }

    public final void setSpUid(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.spUid = r100;
    }

    public final void setType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.type = r100;
    }

    public final void setUid(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.uid = r100;
    }
}
