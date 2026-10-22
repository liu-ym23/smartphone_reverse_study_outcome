package com.stepos.common;

import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/stepos/common/ChatContentType;", "", "common_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChatContentType {

    /* renamed from: a, reason: collision with root package name */
    public static final ChatContentType f3540a;
    public static final ChatContentType b;
    public static final ChatContentType c;
    public static final ChatContentType d;
    public static final ChatContentType e;
    public static final ChatContentType f;
    public static final /* synthetic */ ChatContentType[] g;

    static {
        ChatContentType chatContentType = new ChatContentType("TEXT", 0);
        f3540a = chatContentType;
        ChatContentType chatContentType2 = new ChatContentType("IMAGE", 1);
        b = chatContentType2;
        ChatContentType chatContentType3 = new ChatContentType("AUDIO", 2);
        c = chatContentType3;
        ChatContentType chatContentType4 = new ChatContentType("VIDEO", 3);
        d = chatContentType4;
        ChatContentType chatContentType5 = new ChatContentType("FILE", 4);
        e = chatContentType5;
        ChatContentType chatContentType6 = new ChatContentType("AUDIO_STREAM", 5);
        ChatContentType chatContentType7 = new ChatContentType("BYTES", 6);
        f = chatContentType7;
        ChatContentType[] chatContentTypeArr = {chatContentType, chatContentType2, chatContentType3, chatContentType4, chatContentType5, chatContentType6, chatContentType7};
        g = chatContentTypeArr;
        a.a(chatContentTypeArr);
    }

    public static ChatContentType valueOf(String str) {
        return (ChatContentType) Enum.valueOf(ChatContentType.class, str);
    }

    public static ChatContentType[] values() {
        return (ChatContentType[]) g.clone();
    }
}
