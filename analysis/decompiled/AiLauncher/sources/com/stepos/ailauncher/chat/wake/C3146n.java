package com.stepos.ailauncher.chat.wake;

import com.autonavi.aps.amapapi.config.Const;
import k5.C4814a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0000\u0018\u0000 \u000f2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\t\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/n;", "", "<init>", "()V", "", "source", "", "circleActive", "touchInProgress", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;ZZ)Z", Const.INTENT_KEY_PKGNAME, "(Z)Z", "suppressedAiKeyPress", "Z", "Companion", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.wake.n, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3146n {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private boolean suppressedAiKeyPress;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\t\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/n$a;", "", "<init>", "()V", "", "source", "", "circleActive", "touchInProgress", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;ZZ)Z", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.wake.n$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final boolean a(String source, boolean circleActive, boolean touchInProgress) {
            if (!circleActive || !touchInProgress || source == null) {
                return false;
            }
            switch (source.hashCode()) {
                case -1418033720:
                    return source.equals(C4814a.AI_KEY_CLICK2);
                case -1350521956:
                    return source.equals(C4814a.HEADSET_WAKEUP);
                case 643045183:
                    return source.equals(C4814a.AI_KEY_LONG_CLICK_START);
                case 1080244305:
                    return source.equals("ai_key_click");
                default:
                    return false;
            }
        }

        public Companion() {
        }
    }

    public final boolean a(String source, boolean circleActive, boolean touchInProgress) {
        if (kotlin.jvm.internal.p.d(source, C4814a.AI_KEY_LONG_CLICK_END)) {
            boolean z10 = this.suppressedAiKeyPress;
            this.suppressedAiKeyPress = false;
            return z10;
        }
        boolean zA = INSTANCE.a(source, circleActive, touchInProgress);
        if (kotlin.jvm.internal.p.d(source, C4814a.AI_KEY_LONG_CLICK_START)) {
            this.suppressedAiKeyPress = zA;
        }
        return zA;
    }

    public final boolean b(boolean circleActive) {
        if (circleActive || !this.suppressedAiKeyPress) {
            return false;
        }
        this.suppressedAiKeyPress = false;
        return true;
    }
}
