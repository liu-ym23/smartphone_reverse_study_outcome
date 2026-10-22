package com.stepos.agentframework.uikit.code;

import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/agentframework/uikit/code/CodeTokenKind;", "", "<init>", "(Ljava/lang/String;I)V", "COMMENT", "STRING", "KEY", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CodeTokenKind {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ CodeTokenKind[] $VALUES;
    public static final CodeTokenKind COMMENT = new CodeTokenKind("COMMENT", 0);
    public static final CodeTokenKind STRING = new CodeTokenKind("STRING", 1);
    public static final CodeTokenKind KEY = new CodeTokenKind("KEY", 2);

    private static final /* synthetic */ CodeTokenKind[] $values() {
        return new CodeTokenKind[]{COMMENT, STRING, KEY};
    }

    static {
        CodeTokenKind[] codeTokenKindArr$values = $values();
        $VALUES = codeTokenKindArr$values;
        $ENTRIES = a.a(codeTokenKindArr$values);
    }

    private CodeTokenKind(String str, int i10) {
    }

    public static InterfaceC4149a<CodeTokenKind> getEntries() {
        return $ENTRIES;
    }

    public static CodeTokenKind valueOf(String str) {
        return (CodeTokenKind) Enum.valueOf(CodeTokenKind.class, str);
    }

    public static CodeTokenKind[] values() {
        return (CodeTokenKind[]) $VALUES.clone();
    }
}
