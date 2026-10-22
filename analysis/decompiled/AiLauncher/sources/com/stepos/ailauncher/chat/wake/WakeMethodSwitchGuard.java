package com.stepos.ailauncher.chat.wake;

import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.core.download.ModelFlowMeta;
import h8.C4148a;
import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/WakeMethodSwitchGuard;", "Lcom/stepos/ailauncher/chat/wake/N1;", "<init>", "()V", "", "source", "Lcom/stepos/ailauncher/chat/wake/WakeMethodSwitchGuard$WakeSwitch;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Lcom/stepos/ailauncher/chat/wake/WakeMethodSwitchGuard$WakeSwitch;", "Landroid/content/Context;", "context", "", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;Ljava/lang/String;)Z", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "WakeSwitch", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class WakeMethodSwitchGuard implements N1 {
    public static final WakeMethodSwitchGuard INSTANCE = new WakeMethodSwitchGuard();
    private static final String name = "WakeMethodSwitch";

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/WakeMethodSwitchGuard$WakeSwitch;", "", "<init>", "(Ljava/lang/String;I)V", "VOICE", "NAVIGATION", "HEADSET", ModelFlowMeta.PLAN_NONE, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class WakeSwitch {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ WakeSwitch[] $VALUES;
        public static final WakeSwitch VOICE = new WakeSwitch("VOICE", 0);
        public static final WakeSwitch NAVIGATION = new WakeSwitch("NAVIGATION", 1);
        public static final WakeSwitch HEADSET = new WakeSwitch("HEADSET", 2);
        public static final WakeSwitch NONE = new WakeSwitch(ModelFlowMeta.PLAN_NONE, 3);

        private static final /* synthetic */ WakeSwitch[] $values() {
            return new WakeSwitch[]{VOICE, NAVIGATION, HEADSET, NONE};
        }

        static {
            WakeSwitch[] wakeSwitchArr$values = $values();
            $VALUES = wakeSwitchArr$values;
            $ENTRIES = kotlin.enums.a.a(wakeSwitchArr$values);
        }

        private WakeSwitch(String str, int i10) {
        }

        public static InterfaceC4149a<WakeSwitch> getEntries() {
            return $ENTRIES;
        }

        public static WakeSwitch valueOf(String str) {
            return (WakeSwitch) Enum.valueOf(WakeSwitch.class, str);
        }

        public static WakeSwitch[] values() {
            return (WakeSwitch[]) $VALUES.clone();
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WakeSwitch.values().length];
            try {
                iArr[WakeSwitch.VOICE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WakeSwitch.NAVIGATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[WakeSwitch.HEADSET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[WakeSwitch.NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.stepos.ailauncher.chat.wake.N1
    public boolean a(Context context, String source) {
        kotlin.jvm.internal.p.i(context, "context");
        int i10 = a.$EnumSwitchMapping$0[b(source).ordinal()];
        boolean zS = true;
        if (i10 == 1) {
            zS = com.stepos.ailauncher.chat.manager.U0.INSTANCE.s();
        } else if (i10 == 2) {
            zS = com.stepos.ailauncher.chat.manager.U0.INSTANCE.r();
        } else if (i10 == 3) {
            zS = com.stepos.ailauncher.chat.manager.U0.INSTANCE.q();
        } else if (i10 != 4) {
            throw new NoWhenBranchMatchedException();
        }
        if (!zS) {
            C4148a.d("WakeGuard", "WakeMethodSwitch: source=" + source + " switch off, deny", false, 4, null);
        }
        return zS;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001c, code lost:
    
        if (r1.equals(k5.C4814a.HOME_KEY_LONG_CLICK) == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0025, code lost:
    
        if (r1.equals(k5.C4814a.BOTTOM_BAR_KEY_LONG_CLICK) == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002a, code lost:
    
        return com.stepos.ailauncher.chat.wake.WakeMethodSwitchGuard.WakeSwitch.NAVIGATION;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.ailauncher.chat.wake.WakeMethodSwitchGuard.WakeSwitch b(java.lang.String r1) {
        /*
            r0 = this;
            if (r1 == 0) goto L37
            int r0 = r1.hashCode()
            switch(r0) {
                case -1350521956: goto L2b;
                case -951070683: goto L1f;
                case -926107835: goto L16;
                case 293766892: goto La;
                default: goto L9;
            }
        L9:
            goto L37
        La:
            java.lang.String r0 = "voice_wakeup"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L37
            com.stepos.ailauncher.chat.wake.WakeMethodSwitchGuard$WakeSwitch r0 = com.stepos.ailauncher.chat.wake.WakeMethodSwitchGuard.WakeSwitch.VOICE
            return r0
        L16:
            java.lang.String r0 = "home_key_long_click"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L28
            goto L37
        L1f:
            java.lang.String r0 = "bottom_bar_key_long_click"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L28
            goto L37
        L28:
            com.stepos.ailauncher.chat.wake.WakeMethodSwitchGuard$WakeSwitch r0 = com.stepos.ailauncher.chat.wake.WakeMethodSwitchGuard.WakeSwitch.NAVIGATION
            return r0
        L2b:
            java.lang.String r0 = "headset_wakeup"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L34
            goto L37
        L34:
            com.stepos.ailauncher.chat.wake.WakeMethodSwitchGuard$WakeSwitch r0 = com.stepos.ailauncher.chat.wake.WakeMethodSwitchGuard.WakeSwitch.HEADSET
            return r0
        L37:
            com.stepos.ailauncher.chat.wake.WakeMethodSwitchGuard$WakeSwitch r0 = com.stepos.ailauncher.chat.wake.WakeMethodSwitchGuard.WakeSwitch.NONE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.wake.WakeMethodSwitchGuard.b(java.lang.String):com.stepos.ailauncher.chat.wake.WakeMethodSwitchGuard$WakeSwitch");
    }

    @Override // com.stepos.ailauncher.chat.wake.N1
    public String getName() {
        return name;
    }
}
