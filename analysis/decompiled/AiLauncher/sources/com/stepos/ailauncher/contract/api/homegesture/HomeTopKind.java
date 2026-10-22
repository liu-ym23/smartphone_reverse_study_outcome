package com.stepos.ailauncher.contract.api.homegesture;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.core.download.ModelFlowMeta;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/ailauncher/contract/api/homegesture/HomeTopKind;", "", "wire", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getWire", "()Ljava/lang/String;", ModelFlowMeta.PLAN_NONE, "POPUP", "SHEET", "ROOT", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HomeTopKind {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ HomeTopKind[] $VALUES;
    private final String wire;
    public static final HomeTopKind NONE = new HomeTopKind(ModelFlowMeta.PLAN_NONE, 0, "none");
    public static final HomeTopKind POPUP = new HomeTopKind("POPUP", 1, "popup");
    public static final HomeTopKind SHEET = new HomeTopKind("SHEET", 2, ChatTracker.CONTENT_SHEET);
    public static final HomeTopKind ROOT = new HomeTopKind("ROOT", 3, Parameters.ROOT);

    private static final /* synthetic */ HomeTopKind[] $values() {
        return new HomeTopKind[]{NONE, POPUP, SHEET, ROOT};
    }

    static {
        HomeTopKind[] homeTopKindArr$values = $values();
        $VALUES = homeTopKindArr$values;
        $ENTRIES = a.a(homeTopKindArr$values);
    }

    private HomeTopKind(String str, int i10, String str2) {
        this.wire = str2;
    }

    public static InterfaceC4149a<HomeTopKind> getEntries() {
        return $ENTRIES;
    }

    public static HomeTopKind valueOf(String str) {
        return (HomeTopKind) Enum.valueOf(HomeTopKind.class, str);
    }

    public static HomeTopKind[] values() {
        return (HomeTopKind[]) $VALUES.clone();
    }

    public final String getWire() {
        return this.wire;
    }
}
