package com.stepos.ailauncher.chat;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/stepos/ailauncher/chat/MainPagePreLoadAction;", "", "actionName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getActionName", "()Ljava/lang/String;", "IMG", "Doc", "Voice", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MainPagePreLoadAction {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ MainPagePreLoadAction[] $VALUES;
    private final String actionName;
    public static final MainPagePreLoadAction IMG = new MainPagePreLoadAction("IMG", 0, "IMG");
    public static final MainPagePreLoadAction Doc = new MainPagePreLoadAction("Doc", 1, "Doc");
    public static final MainPagePreLoadAction Voice = new MainPagePreLoadAction("Voice", 2, "Voice");

    private static final /* synthetic */ MainPagePreLoadAction[] $values() {
        return new MainPagePreLoadAction[]{IMG, Doc, Voice};
    }

    static {
        MainPagePreLoadAction[] mainPagePreLoadActionArr$values = $values();
        $VALUES = mainPagePreLoadActionArr$values;
        $ENTRIES = kotlin.enums.a.a(mainPagePreLoadActionArr$values);
    }

    private MainPagePreLoadAction(String str, int i10, String str2) {
        this.actionName = str2;
    }

    public static InterfaceC4149a<MainPagePreLoadAction> getEntries() {
        return $ENTRIES;
    }

    public static MainPagePreLoadAction valueOf(String str) {
        return (MainPagePreLoadAction) Enum.valueOf(MainPagePreLoadAction.class, str);
    }

    public static MainPagePreLoadAction[] values() {
        return (MainPagePreLoadAction[]) $VALUES.clone();
    }

    public final String getActionName() {
        return this.actionName;
    }
}
