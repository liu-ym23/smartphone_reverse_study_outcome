package com.stepos.ailauncher.chat.risk;

import com.autonavi.aps.amapapi.config.Const;
import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ%\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/stepos/ailauncher/chat/risk/RiskInlineHostPolicy;", "", "<init>", "()V", "", "leftForNewChat", "trackerHostsThisSession", "conversationBodyForeground", "inputActiveForSession", "c", "(ZZZZ)Z", "modeIsLive", "shouldShowInline", "Lcom/stepos/ailauncher/chat/risk/RiskInlineHostPolicy$RetryTick;", Const.INTENT_KEY_APIKEY, "(ZZZ)Lcom/stepos/ailauncher/chat/risk/RiskInlineHostPolicy$RetryTick;", Const.INTENT_KEY_PKGNAME, "(ZZ)Z", "RetryTick", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RiskInlineHostPolicy {
    public static final RiskInlineHostPolicy INSTANCE = new RiskInlineHostPolicy();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/chat/risk/RiskInlineHostPolicy$RetryTick;", "", "<init>", "(Ljava/lang/String;I)V", "SwitchToInline", "KeepRetrying", "Stop", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class RetryTick {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ RetryTick[] $VALUES;
        public static final RetryTick SwitchToInline = new RetryTick("SwitchToInline", 0);
        public static final RetryTick KeepRetrying = new RetryTick("KeepRetrying", 1);
        public static final RetryTick Stop = new RetryTick("Stop", 2);

        private static final /* synthetic */ RetryTick[] $values() {
            return new RetryTick[]{SwitchToInline, KeepRetrying, Stop};
        }

        static {
            RetryTick[] retryTickArr$values = $values();
            $VALUES = retryTickArr$values;
            $ENTRIES = a.a(retryTickArr$values);
        }

        private RetryTick(String str, int i10) {
        }

        public static InterfaceC4149a<RetryTick> getEntries() {
            return $ENTRIES;
        }

        public static RetryTick valueOf(String str) {
            return (RetryTick) Enum.valueOf(RetryTick.class, str);
        }

        public static RetryTick[] values() {
            return (RetryTick[]) $VALUES.clone();
        }
    }

    public final RetryTick a(boolean modeIsLive, boolean shouldShowInline, boolean conversationBodyForeground) {
        return !modeIsLive ? RetryTick.Stop : shouldShowInline ? RetryTick.SwitchToInline : conversationBodyForeground ? RetryTick.KeepRetrying : RetryTick.Stop;
    }

    public final boolean b(boolean modeIsLive, boolean conversationBodyForeground) {
        return modeIsLive && conversationBodyForeground;
    }

    public final boolean c(boolean leftForNewChat, boolean trackerHostsThisSession, boolean conversationBodyForeground, boolean inputActiveForSession) {
        if (leftForNewChat) {
            return false;
        }
        if (trackerHostsThisSession) {
            return true;
        }
        if (conversationBodyForeground) {
            return inputActiveForSession;
        }
        return false;
    }
}
