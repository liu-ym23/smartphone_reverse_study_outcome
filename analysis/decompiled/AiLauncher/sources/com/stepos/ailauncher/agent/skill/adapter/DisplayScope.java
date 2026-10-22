package com.stepos.ailauncher.agent.skill.adapter;

import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/adapter/DisplayScope;", "", "<init>", "(Ljava/lang/String;I)V", "HOME_ESSENTIAL", "HOME_OTHER", "ESSENTIAL_SUBPAGE", "TESTING", "COMMUNITY_SUBPAGE", "INSTALLED", "SEARCH", "SKILL_DETAIL", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DisplayScope {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ DisplayScope[] $VALUES;
    public static final DisplayScope HOME_ESSENTIAL = new DisplayScope("HOME_ESSENTIAL", 0);
    public static final DisplayScope HOME_OTHER = new DisplayScope("HOME_OTHER", 1);
    public static final DisplayScope ESSENTIAL_SUBPAGE = new DisplayScope("ESSENTIAL_SUBPAGE", 2);
    public static final DisplayScope TESTING = new DisplayScope("TESTING", 3);
    public static final DisplayScope COMMUNITY_SUBPAGE = new DisplayScope("COMMUNITY_SUBPAGE", 4);
    public static final DisplayScope INSTALLED = new DisplayScope("INSTALLED", 5);
    public static final DisplayScope SEARCH = new DisplayScope("SEARCH", 6);
    public static final DisplayScope SKILL_DETAIL = new DisplayScope("SKILL_DETAIL", 7);

    private static final /* synthetic */ DisplayScope[] $values() {
        return new DisplayScope[]{HOME_ESSENTIAL, HOME_OTHER, ESSENTIAL_SUBPAGE, TESTING, COMMUNITY_SUBPAGE, INSTALLED, SEARCH, SKILL_DETAIL};
    }

    static {
        DisplayScope[] displayScopeArr$values = $values();
        $VALUES = displayScopeArr$values;
        $ENTRIES = a.a(displayScopeArr$values);
    }

    private DisplayScope(String str, int i10) {
    }

    public static InterfaceC4149a<DisplayScope> getEntries() {
        return $ENTRIES;
    }

    public static DisplayScope valueOf(String str) {
        return (DisplayScope) Enum.valueOf(DisplayScope.class, str);
    }

    public static DisplayScope[] values() {
        return (DisplayScope[]) $VALUES.clone();
    }
}
