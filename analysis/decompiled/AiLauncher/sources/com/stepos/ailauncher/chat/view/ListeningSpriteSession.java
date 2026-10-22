package com.stepos.ailauncher.chat.view;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h9.InterfaceC4149a;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0003\u0016\r\u001aB-\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\u000bJ\r\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000bR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u000eR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0018\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/stepos/ailauncher/chat/view/ListeningSpriteSession;", "", "Lkotlin/Function0;", "LY8/t;", UxipConstants.f30640D, "onEnd", "Lcom/stepos/ailauncher/chat/view/ListeningSpriteSession$b;", "ownership", "<init>", "(Lp9/a;Lp9/a;Lcom/stepos/ailauncher/chat/view/ListeningSpriteSession$b;)V", "c", "()V", Const.INTENT_KEY_UMID, Const.INTENT_KEY_APIKEY, "Lp9/a;", "Lcom/stepos/ailauncher/chat/view/ListeningSpriteSession$b;", "Lcom/stepos/ailauncher/chat/view/ListeningSpriteSession$Phase;", "phase", "Lcom/stepos/ailauncher/chat/view/ListeningSpriteSession$Phase;", M5.b.CREDENTIAL_TOKEN, "Ljava/lang/Object;", "", Const.INTENT_KEY_PKGNAME, "()Z", "isOpen", "Companion", "Phase", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ListeningSpriteSession {
    private static final a Companion = new a(null);
    private static final b sharedOwnership = new b();
    private final InterfaceC5063a<Y8.t> onEnd;
    private final InterfaceC5063a<Y8.t> onStart;
    private final b ownership;
    private Phase phase;
    private Object token;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/chat/view/ListeningSpriteSession$Phase;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "PENDING", "LISTENING", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Phase {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ Phase[] $VALUES;
        public static final Phase IDLE = new Phase("IDLE", 0);
        public static final Phase PENDING = new Phase("PENDING", 1);
        public static final Phase LISTENING = new Phase("LISTENING", 2);

        private static final /* synthetic */ Phase[] $values() {
            return new Phase[]{IDLE, PENDING, LISTENING};
        }

        static {
            Phase[] phaseArr$values = $values();
            $VALUES = phaseArr$values;
            $ENTRIES = kotlin.enums.a.a(phaseArr$values);
        }

        private Phase(String str, int i10) {
        }

        public static InterfaceC4149a<Phase> getEntries() {
            return $ENTRIES;
        }

        public static Phase valueOf(String str) {
            return (Phase) Enum.valueOf(Phase.class, str);
        }

        public static Phase[] values() {
            return (Phase[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/stepos/ailauncher/chat/view/ListeningSpriteSession$a;", "", "<init>", "()V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0004\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/chat/view/ListeningSpriteSession$b;", "", "<init>", "()V", "current", "Ljava/lang/Object;", Const.INTENT_KEY_APIKEY, "()Ljava/lang/Object;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/Object;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b {
        private Object current;

        /* renamed from: a, reason: from getter */
        public final Object getCurrent() {
            return this.current;
        }

        public final void b(Object obj) {
            this.current = obj;
        }
    }

    public ListeningSpriteSession(InterfaceC5063a<Y8.t> onStart, InterfaceC5063a<Y8.t> onEnd, b ownership) {
        kotlin.jvm.internal.p.i(onStart, "onStart");
        kotlin.jvm.internal.p.i(onEnd, "onEnd");
        kotlin.jvm.internal.p.i(ownership, "ownership");
        this.onStart = onStart;
        this.onEnd = onEnd;
        this.ownership = ownership;
        this.phase = Phase.IDLE;
    }

    public final void a() {
        boolean zB = b();
        this.phase = Phase.IDLE;
        if (zB) {
            this.ownership.b(null);
        }
        this.token = null;
        if (zB) {
            this.onEnd.invoke();
        }
    }

    public final boolean b() {
        return this.phase != Phase.IDLE && this.ownership.getCurrent() == this.token;
    }

    public final void c() {
        if (b()) {
            return;
        }
        Object obj = new Object();
        this.token = obj;
        this.ownership.b(obj);
        this.phase = Phase.PENDING;
    }

    public final void d() {
        if (this.phase == Phase.IDLE) {
            c();
        }
        if (b()) {
            Phase phase = this.phase;
            Phase phase2 = Phase.LISTENING;
            if (phase == phase2) {
                return;
            }
            this.phase = phase2;
            this.onStart.invoke();
        }
    }

    public /* synthetic */ ListeningSpriteSession(InterfaceC5063a interfaceC5063a, InterfaceC5063a interfaceC5063a2, b bVar, int i10, kotlin.jvm.internal.i iVar) {
        this(interfaceC5063a, interfaceC5063a2, (i10 & 4) != 0 ? sharedOwnership : bVar);
    }
}
