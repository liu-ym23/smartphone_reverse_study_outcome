package com.stepos.core.ability.session;

import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import sb.a;
import v1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ChatMessage {
    private final String content;
    private final Role role;
    private final long timestamp;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Role {
        private static final /* synthetic */ a $ENTRIES;
        private static final /* synthetic */ Role[] $VALUES;
        public static final Role USER = new Role("USER", 0);
        public static final Role ASSISTANT = new Role("ASSISTANT", 1);
        public static final Role SYSTEM = new Role("SYSTEM", 2);

        private static final /* synthetic */ Role[] $values() {
            return new Role[]{USER, ASSISTANT, SYSTEM};
        }

        static {
            Role[] roleArr$values = $values();
            $VALUES = roleArr$values;
            $ENTRIES = kotlin.enums.a.a(roleArr$values);
        }

        private Role(String str, int i10) {
        }

        public static a<Role> getEntries() {
            return $ENTRIES;
        }

        public static Role valueOf(String str) {
            return (Role) Enum.valueOf(Role.class, str);
        }

        public static Role[] values() {
            return (Role[]) $VALUES.clone();
        }
    }

    public ChatMessage(Role role, String content, long j10) {
        g.f(role, "role");
        g.f(content, "content");
        this.role = role;
        this.content = content;
        this.timestamp = j10;
    }

    public static /* synthetic */ ChatMessage copy$default(ChatMessage chatMessage, Role role, String str, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            role = chatMessage.role;
        }
        if ((i10 & 2) != 0) {
            str = chatMessage.content;
        }
        if ((i10 & 4) != 0) {
            j10 = chatMessage.timestamp;
        }
        return chatMessage.copy(role, str, j10);
    }

    public final Role component1() {
        return this.role;
    }

    public final String component2() {
        return this.content;
    }

    public final long component3() {
        return this.timestamp;
    }

    public final ChatMessage copy(Role role, String content, long j10) {
        g.f(role, "role");
        g.f(content, "content");
        return new ChatMessage(role, content, j10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChatMessage)) {
            return false;
        }
        ChatMessage chatMessage = (ChatMessage) obj;
        return this.role == chatMessage.role && g.b(this.content, chatMessage.content) && this.timestamp == chatMessage.timestamp;
    }

    public final String getContent() {
        return this.content;
    }

    public final Role getRole() {
        return this.role;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return Long.hashCode(this.timestamp) + d.a(this.role.hashCode() * 31, 31, this.content);
    }

    public String toString() {
        Role role = this.role;
        String str = this.content;
        long j10 = this.timestamp;
        StringBuilder sb2 = new StringBuilder("ChatMessage(role=");
        sb2.append(role);
        sb2.append(", content=");
        sb2.append(str);
        sb2.append(", timestamp=");
        return ai.onnxruntime.a.m(sb2, j10, ")");
    }

    public /* synthetic */ ChatMessage(Role role, String str, long j10, int i10, e eVar) {
        this(role, str, (i10 & 4) != 0 ? System.currentTimeMillis() : j10);
    }
}
