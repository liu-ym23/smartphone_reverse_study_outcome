package com.stepos.agentframework.adapter.coze.bean;

import com.google.gson.annotations.SerializedName;
import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/stepos/agentframework/adapter/coze/bean/Type;", "", "event", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getEvent", "()Ljava/lang/String;", "ANSWER", "VERBOSE", "FUNCTION_CALL", "TOOL_RESPONSE", "FOLLOW_UP", "protocol_coze_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Type {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ Type[] $VALUES;
    private final String event;

    @SerializedName("answer")
    public static final Type ANSWER = new Type("ANSWER", 0, "answer");

    @SerializedName("verbose")
    public static final Type VERBOSE = new Type("VERBOSE", 1, "verbose");

    @SerializedName("function_call")
    public static final Type FUNCTION_CALL = new Type("FUNCTION_CALL", 2, "function_call");

    @SerializedName("tool_response")
    public static final Type TOOL_RESPONSE = new Type("TOOL_RESPONSE", 3, "tool_response");

    @SerializedName("follow_up")
    public static final Type FOLLOW_UP = new Type("FOLLOW_UP", 4, "follow_up");

    private static final /* synthetic */ Type[] $values() {
        return new Type[]{ANSWER, VERBOSE, FUNCTION_CALL, TOOL_RESPONSE, FOLLOW_UP};
    }

    static {
        Type[] typeArr$values = $values();
        $VALUES = typeArr$values;
        $ENTRIES = a.a(typeArr$values);
    }

    private Type(String str, int i10, String str2) {
        this.event = str2;
    }

    public static InterfaceC4149a<Type> getEntries() {
        return $ENTRIES;
    }

    public static Type valueOf(String str) {
        return (Type) Enum.valueOf(Type.class, str);
    }

    public static Type[] values() {
        return (Type[]) $VALUES.clone();
    }

    public final String getEvent() {
        return this.event;
    }
}
