package com.stepos.agentframework.floatcard.api;

import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/agentframework/floatcard/api/FloatCardScene;", "", "<init>", "(Ljava/lang/String;I)V", "Any", "WakeDialog", "ChatMainActivity", "Chat", "floatcard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FloatCardScene {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ FloatCardScene[] $VALUES;
    public static final FloatCardScene Any = new FloatCardScene("Any", 0);
    public static final FloatCardScene WakeDialog = new FloatCardScene("WakeDialog", 1);
    public static final FloatCardScene ChatMainActivity = new FloatCardScene("ChatMainActivity", 2);
    public static final FloatCardScene Chat = new FloatCardScene("Chat", 3);

    private static final /* synthetic */ FloatCardScene[] $values() {
        return new FloatCardScene[]{Any, WakeDialog, ChatMainActivity, Chat};
    }

    static {
        FloatCardScene[] floatCardSceneArr$values = $values();
        $VALUES = floatCardSceneArr$values;
        $ENTRIES = a.a(floatCardSceneArr$values);
    }

    private FloatCardScene(String str, int i10) {
    }

    public static InterfaceC4149a<FloatCardScene> getEntries() {
        return $ENTRIES;
    }

    public static FloatCardScene valueOf(String str) {
        return (FloatCardScene) Enum.valueOf(FloatCardScene.class, str);
    }

    public static FloatCardScene[] values() {
        return (FloatCardScene[]) $VALUES.clone();
    }
}
