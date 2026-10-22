package com.bytedance.ai.bridge.security;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ai/bridge/security/AppletJSBBridgeChannel;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "AIBRIDGE", "XBRIDGE", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AppletJSBBridgeChannel extends Enum<AppletJSBBridgeChannel> {
    public static final AppletJSBBridgeChannel AIBRIDGE = null;
    public static final AppletJSBBridgeChannel XBRIDGE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AppletJSBBridgeChannel[] f36098a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f36099b = null;
    private final String value;

    public static EnumEntries<AppletJSBBridgeChannel> getEntries() {
        return f36099b;
    }

    static {
        AppletJSBBridgeChannel r100 = new AppletJSBBridgeChannel("AIBRIDGE", 0, "aibridge");
        AIBRIDGE = r100;
        AppletJSBBridgeChannel r101 = new AppletJSBBridgeChannel("XBRIDGE", 1, "xbridge");
        XBRIDGE = r101;
        AppletJSBBridgeChannel[] r102 = {r100, r101};
        f36098a = r102;
        f36099b = EnumEntriesKt.enumEntries(r102);
    }

    public static AppletJSBBridgeChannel[] values() {
        return (AppletJSBBridgeChannel[]) f36098a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static AppletJSBBridgeChannel valueOf(String r100) {
        return (AppletJSBBridgeChannel) a.a(AppletJSBBridgeChannel.class, r100);
    }

    public AppletJSBBridgeChannel(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
