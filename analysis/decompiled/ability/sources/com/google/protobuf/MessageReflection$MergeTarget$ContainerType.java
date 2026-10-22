package com.google.protobuf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class MessageReflection$MergeTarget$ContainerType {

    /* renamed from: a, reason: collision with root package name */
    public static final MessageReflection$MergeTarget$ContainerType f2857a;
    public static final MessageReflection$MergeTarget$ContainerType b;
    public static final /* synthetic */ MessageReflection$MergeTarget$ContainerType[] c;

    static {
        MessageReflection$MergeTarget$ContainerType messageReflection$MergeTarget$ContainerType = new MessageReflection$MergeTarget$ContainerType("MESSAGE", 0);
        f2857a = messageReflection$MergeTarget$ContainerType;
        MessageReflection$MergeTarget$ContainerType messageReflection$MergeTarget$ContainerType2 = new MessageReflection$MergeTarget$ContainerType("EXTENSION_SET", 1);
        b = messageReflection$MergeTarget$ContainerType2;
        c = new MessageReflection$MergeTarget$ContainerType[]{messageReflection$MergeTarget$ContainerType, messageReflection$MergeTarget$ContainerType2};
    }

    public static MessageReflection$MergeTarget$ContainerType valueOf(String str) {
        return (MessageReflection$MergeTarget$ContainerType) Enum.valueOf(MessageReflection$MergeTarget$ContainerType.class, str);
    }

    public static MessageReflection$MergeTarget$ContainerType[] values() {
        return (MessageReflection$MergeTarget$ContainerType[]) c.clone();
    }
}
