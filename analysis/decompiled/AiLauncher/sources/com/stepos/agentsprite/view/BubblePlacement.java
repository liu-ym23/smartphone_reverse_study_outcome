package com.stepos.agentsprite.view;

import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/stepos/agentsprite/view/BubblePlacement;", "", "<init>", "(Ljava/lang/String;I)V", "AboveStart", "AboveCenter", "AboveEnd", "Start", "End", "BelowStart", "BelowCenter", "BelowEnd", "Overlay", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BubblePlacement {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ BubblePlacement[] $VALUES;
    public static final BubblePlacement AboveStart = new BubblePlacement("AboveStart", 0);
    public static final BubblePlacement AboveCenter = new BubblePlacement("AboveCenter", 1);
    public static final BubblePlacement AboveEnd = new BubblePlacement("AboveEnd", 2);
    public static final BubblePlacement Start = new BubblePlacement("Start", 3);
    public static final BubblePlacement End = new BubblePlacement("End", 4);
    public static final BubblePlacement BelowStart = new BubblePlacement("BelowStart", 5);
    public static final BubblePlacement BelowCenter = new BubblePlacement("BelowCenter", 6);
    public static final BubblePlacement BelowEnd = new BubblePlacement("BelowEnd", 7);
    public static final BubblePlacement Overlay = new BubblePlacement("Overlay", 8);

    private static final /* synthetic */ BubblePlacement[] $values() {
        return new BubblePlacement[]{AboveStart, AboveCenter, AboveEnd, Start, End, BelowStart, BelowCenter, BelowEnd, Overlay};
    }

    static {
        BubblePlacement[] bubblePlacementArr$values = $values();
        $VALUES = bubblePlacementArr$values;
        $ENTRIES = a.a(bubblePlacementArr$values);
    }

    private BubblePlacement(String str, int i10) {
    }

    public static InterfaceC4149a<BubblePlacement> getEntries() {
        return $ENTRIES;
    }

    public static BubblePlacement valueOf(String str) {
        return (BubblePlacement) Enum.valueOf(BubblePlacement.class, str);
    }

    public static BubblePlacement[] values() {
        return (BubblePlacement[]) $VALUES.clone();
    }
}
