package com.stepos.ailauncher.contract.api.homegesture;

import com.stepos.ailauncher.chat.wake.Q;
import h9.InterfaceC4149a;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.a;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;", "", "wire", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getWire", "()Ljava/lang/String;", "DESKTOP", "BOARD", "MINUS_ONE", "LOCK", "Companion", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HomeRootToken {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ HomeRootToken[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String wire;
    public static final HomeRootToken DESKTOP = new HomeRootToken("DESKTOP", 0, "desktop");
    public static final HomeRootToken BOARD = new HomeRootToken("BOARD", 1, "board");
    public static final HomeRootToken MINUS_ONE = new HomeRootToken("MINUS_ONE", 2, Q.SESSION_MINUS_ONE);
    public static final HomeRootToken LOCK = new HomeRootToken("LOCK", 3, "lock");

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken$Companion;", "", "<init>", "()V", "fromWire", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;", "wire", "", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final HomeRootToken fromWire(String wire) {
            HomeRootToken next;
            Iterator<HomeRootToken> it = HomeRootToken.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (p.d(next.getWire(), wire)) {
                    break;
                }
            }
            return next;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ HomeRootToken[] $values() {
        return new HomeRootToken[]{DESKTOP, BOARD, MINUS_ONE, LOCK};
    }

    static {
        HomeRootToken[] homeRootTokenArr$values = $values();
        $VALUES = homeRootTokenArr$values;
        $ENTRIES = a.a(homeRootTokenArr$values);
        INSTANCE = new Companion(null);
    }

    private HomeRootToken(String str, int i10, String str2) {
        this.wire = str2;
    }

    public static InterfaceC4149a<HomeRootToken> getEntries() {
        return $ENTRIES;
    }

    public static HomeRootToken valueOf(String str) {
        return (HomeRootToken) Enum.valueOf(HomeRootToken.class, str);
    }

    public static HomeRootToken[] values() {
        return (HomeRootToken[]) $VALUES.clone();
    }

    public final String getWire() {
        return this.wire;
    }
}
