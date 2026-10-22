package com.obric.autoaction.presentation.island.template;

import com.obric.livecard.api.entity.CommonExpandedTemplate;
import com.obric.livecard.api.entity.IslandWidget;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: OAutoExpandCardTemplate.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class OAutoDialogueIslandTemplate {
    private final OAutoExpandCardTemplate dialogue;
    private final CommonExpandedTemplate normal;

    public static /* synthetic */ OAutoDialogueIslandTemplate copy$default(OAutoDialogueIslandTemplate r0, OAutoExpandCardTemplate r1, CommonExpandedTemplate r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.dialogue;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.normal;
    L9:
        return r0.copy(r1, r2);
    }

    public final OAutoExpandCardTemplate component1() {
        return this.dialogue;
    }

    public final CommonExpandedTemplate component2() {
        return this.normal;
    }

    public final OAutoDialogueIslandTemplate copy(OAutoExpandCardTemplate r1, CommonExpandedTemplate r2) {
        o.e(r1, "dialogue");
        o.e(r2, "normal");
        return new OAutoDialogueIslandTemplate(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, OAutoDialogueIslandTemplate.class) == true) goto L8;
        return false;
    L8:
        OAutoDialogueIslandTemplate r6 = (OAutoDialogueIslandTemplate) ZeusTransformUtils.preCheckCast(r5, OAutoDialogueIslandTemplate.class, "com.obric.aiagent.plugin");
        if (o.a(this.dialogue, r6.dialogue) == true) goto L12;
        return false;
    L12:
        if (o.a(this.normal, r6.normal) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.dialogue.hashCode() * 31) + this.normal.hashCode();
    }

    public String toString() {
        return "OAutoDialogueIslandTemplate(dialogue=" + this.dialogue + ", normal=" + this.normal + ')';
    }

    public OAutoDialogueIslandTemplate(OAutoExpandCardTemplate r2, CommonExpandedTemplate r3) {
        o.e(r2, "dialogue");
        o.e(r3, "normal");
        this.dialogue = r2;
        this.normal = r3;
    }

    public final OAutoExpandCardTemplate getDialogue() {
        return this.dialogue;
    }

    public final CommonExpandedTemplate getNormal() {
        return this.normal;
    }

    public static /* synthetic */ IslandWidget create$default(OAutoDialogueIslandTemplate r0, Boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        return r0.create(r1);
    }

    public final IslandWidget create(Boolean r14) {
        return new IslandWidget("com.obric.island_applet:action_dialogue_island", this, r14, null, null, null, null, null, null, 504, null);
    }
}
