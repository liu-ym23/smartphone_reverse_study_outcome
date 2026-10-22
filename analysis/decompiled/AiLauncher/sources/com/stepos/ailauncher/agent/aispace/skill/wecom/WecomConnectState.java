package com.stepos.ailauncher.agent.aispace.skill.wecom;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/wecom/WecomConnectState;", "", "<init>", "(Ljava/lang/String;I)V", "Idle", "Installing", "Qr", "WaitingScan", "WaitingOperation", "Reviewing", "Connecting", "Connected", "InstallFailedNetwork", "InstallFailedGeneric", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class WecomConnectState {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ WecomConnectState[] $VALUES;
    public static final WecomConnectState Idle = new WecomConnectState("Idle", 0);
    public static final WecomConnectState Installing = new WecomConnectState("Installing", 1);
    public static final WecomConnectState Qr = new WecomConnectState("Qr", 2);
    public static final WecomConnectState WaitingScan = new WecomConnectState("WaitingScan", 3);
    public static final WecomConnectState WaitingOperation = new WecomConnectState("WaitingOperation", 4);
    public static final WecomConnectState Reviewing = new WecomConnectState("Reviewing", 5);
    public static final WecomConnectState Connecting = new WecomConnectState("Connecting", 6);
    public static final WecomConnectState Connected = new WecomConnectState("Connected", 7);
    public static final WecomConnectState InstallFailedNetwork = new WecomConnectState("InstallFailedNetwork", 8);
    public static final WecomConnectState InstallFailedGeneric = new WecomConnectState("InstallFailedGeneric", 9);

    private static final /* synthetic */ WecomConnectState[] $values() {
        return new WecomConnectState[]{Idle, Installing, Qr, WaitingScan, WaitingOperation, Reviewing, Connecting, Connected, InstallFailedNetwork, InstallFailedGeneric};
    }

    static {
        WecomConnectState[] wecomConnectStateArr$values = $values();
        $VALUES = wecomConnectStateArr$values;
        $ENTRIES = kotlin.enums.a.a(wecomConnectStateArr$values);
    }

    private WecomConnectState(String str, int i10) {
    }

    public static InterfaceC4149a<WecomConnectState> getEntries() {
        return $ENTRIES;
    }

    public static WecomConnectState valueOf(String str) {
        return (WecomConnectState) Enum.valueOf(WecomConnectState.class, str);
    }

    public static WecomConnectState[] values() {
        return (WecomConnectState[]) $VALUES.clone();
    }
}
