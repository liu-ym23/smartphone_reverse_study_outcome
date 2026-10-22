package com.stepos.ailauncher.foundation.appui.card.provider.alipay;

import N5.CardEnvelope;
import Z8.C1173v;
import Z8.Y;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.H;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.o0;
import com.stepos.ame.sdk.SkillStoreKt;
import h9.InterfaceC4149a;
import io.ktor.sse.ServerSentEventKt;
import java.util.List;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001:\u0003H\u0015+B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0015\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u001b\u0010\u000eJ\u0017\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001c\u001a\u00020\u0004¢\u0006\u0004\b\u001e\u0010\u001fJ%\u0010\"\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040!2\u0006\u0010 \u001a\u00020\u001d¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u0004\u0018\u00010\u00042\u0006\u0010 \u001a\u00020\u001d¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b&\u0010\u001aJ+\u0010+\u001a\u00020*2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010'\u001a\u0004\u0018\u00010\u00042\b\u0010)\u001a\u0004\u0018\u00010(¢\u0006\u0004\b+\u0010,J-\u0010/\u001a\u0004\u0018\u00010.2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010-\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b/\u00100J3\u00101\u001a\u00020.2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010-\u001a\u0004\u0018\u00010\u00042\u0006\u0010)\u001a\u00020(H\u0002¢\u0006\u0004\b1\u00102R\u0014\u00103\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b3\u00104R\u001d\u00106\u001a\b\u0012\u0004\u0012\u00020\u0006058\u0006¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u0014\u0010:\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b:\u00104R\u0014\u0010;\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b;\u00104R\u0014\u0010<\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b<\u00104R\u0014\u0010=\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b=\u00104R\u0014\u0010>\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b>\u00104R\u0014\u0010?\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b?\u00104R\u0014\u0010@\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b@\u00104R\u0014\u0010A\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bA\u00104R\u0014\u0010B\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bB\u00104R\u0014\u0010D\u001a\u00020C8\u0006X\u0086T¢\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010F\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\bF\u00104R\u0014\u0010G\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\bG\u00104¨\u0006I"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiIsland;", "", "<init>", "()V", "", "taskId", "", "status", "f", "(Ljava/lang/String;I)Ljava/lang/String;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiIsland$Phase;", "phase", "", Const.INTENT_KEY_UMID, "(Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiIsland$Phase;)Z", "n", "(Ljava/lang/Integer;)Z", "liveId", "o", "(Ljava/lang/String;)Ljava/lang/String;", "cardSubtitle", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/Integer;Ljava/lang/String;)Ljava/lang/String;", "k", "(Ljava/lang/Integer;)Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiIsland$Phase;", "p", "(Ljava/lang/Integer;)Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "payload", "LN5/i;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;)LN5/i;", "envelope", "Lkotlin/Pair;", "l", "(LN5/i;)Lkotlin/Pair;", "m", "(LN5/i;)Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_COMMAND, "payloadTitle", "Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/H$a;", "shown", "Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiIsland$b;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/Integer;Ljava/lang/String;Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/H$a;)Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiIsland$b;", "incoming", "Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiIsland$a;", "c", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiIsland$Phase;Ljava/lang/Integer;Ljava/lang/String;)Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiIsland$a;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiIsland$Phase;Ljava/lang/Integer;Ljava/lang/String;Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/H$a;)Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiIsland$a;", "TASK_PREFIX", "Ljava/lang/String;", "", "statuses", "Ljava/util/Set;", "e", "()Ljava/util/Set;", "REASON_INCOMPLETE", "REASON_NO_TEXT", "REASON_STATUS", "REASON_SAME", "REASON_CLOSED", "REASON_ENDED", "LABEL_ENDED", "LABEL_CANCELLED", "LABEL_COMPLETED", "", "COLLAPSE_AFTER_MS", "J", "KEY_ITEMS", "KEY_PRIMARY_INFO", "Phase", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AlipayXuiIsland {
    public static final long COLLAPSE_AFTER_MS = 5000;
    private static final String KEY_ITEMS = "items";
    private static final String KEY_PRIMARY_INFO = "primaryInfo";
    public static final String LABEL_CANCELLED = "已取消";
    public static final String LABEL_COMPLETED = "已完成";
    public static final String LABEL_ENDED = "已结束";
    public static final String REASON_CLOSED = "closed";
    public static final String REASON_ENDED = "ended";
    public static final String REASON_INCOMPLETE = "incomplete";
    public static final String REASON_NO_TEXT = "noText";
    public static final String REASON_SAME = "same";
    public static final String REASON_STATUS = "status";
    public static final String TASK_PREFIX = "alipay_xui:";
    public static final AlipayXuiIsland INSTANCE = new AlipayXuiIsland();
    private static final Set<Integer> statuses = Y.j(2, 3, 7, 4, 5, 6);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiIsland$Phase;", "", "traceName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getTraceName", "()Ljava/lang/String;", "EXEC", "WAITING", "CONFIRMATION", "TERMINAL", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Phase {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ Phase[] $VALUES;
        private final String traceName;
        public static final Phase EXEC = new Phase("EXEC", 0, "exec");
        public static final Phase WAITING = new Phase("WAITING", 1, Z5.b.FALLBACK_STATE_WAITING);
        public static final Phase CONFIRMATION = new Phase("CONFIRMATION", 2, "confirmation");
        public static final Phase TERMINAL = new Phase("TERMINAL", 3, o0.TRACK_STATUS_TERMINAL);

        private static final /* synthetic */ Phase[] $values() {
            return new Phase[]{EXEC, WAITING, CONFIRMATION, TERMINAL};
        }

        static {
            Phase[] phaseArr$values = $values();
            $VALUES = phaseArr$values;
            $ENTRIES = kotlin.enums.a.a(phaseArr$values);
        }

        private Phase(String str, int i10, String str2) {
            this.traceName = str2;
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

        public final String getTraceName() {
            return this.traceName;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiIsland$a;", "", "", "title", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland$a, reason: from toString */
    public static final /* data */ class Copy {
        private final String content;
        private final String title;

        public Copy(String title, String content) {
            kotlin.jvm.internal.p.i(title, "title");
            kotlin.jvm.internal.p.i(content, "content");
            this.title = title;
            this.content = content;
        }

        /* renamed from: a, reason: from getter */
        public final String getContent() {
            return this.content;
        }

        /* renamed from: b, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Copy)) {
                return false;
            }
            Copy copy = (Copy) other;
            return kotlin.jvm.internal.p.d(this.title, copy.title) && kotlin.jvm.internal.p.d(this.content, copy.content);
        }

        public int hashCode() {
            return (this.title.hashCode() * 31) + this.content.hashCode();
        }

        public String toString() {
            return "Copy(title=" + this.title + ", content=" + this.content + ")";
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiIsland$b;", "", "<init>", "()V", Const.INTENT_KEY_APIKEY, "c", Const.INTENT_KEY_PKGNAME, "Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiIsland$b$a;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiIsland$b$b;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiIsland$b$c;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class b {

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\nR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0018\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiIsland$b$a;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiIsland$b;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiIsland$Phase;", "phase", "", "title", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "<init>", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiIsland$Phase;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiIsland$Phase;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiIsland$Phase;", "Ljava/lang/String;", "c", Const.INTENT_KEY_APIKEY, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland$b$a, reason: from toString */
        public static final /* data */ class Show extends b {
            private final String content;
            private final Phase phase;
            private final String title;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Show(Phase phase, String title, String content) {
                super(null);
                kotlin.jvm.internal.p.i(phase, "phase");
                kotlin.jvm.internal.p.i(title, "title");
                kotlin.jvm.internal.p.i(content, "content");
                this.phase = phase;
                this.title = title;
                this.content = content;
            }

            /* renamed from: a, reason: from getter */
            public final String getContent() {
                return this.content;
            }

            /* renamed from: b, reason: from getter */
            public final Phase getPhase() {
                return this.phase;
            }

            /* renamed from: c, reason: from getter */
            public final String getTitle() {
                return this.title;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Show)) {
                    return false;
                }
                Show show = (Show) other;
                return this.phase == show.phase && kotlin.jvm.internal.p.d(this.title, show.title) && kotlin.jvm.internal.p.d(this.content, show.content);
            }

            public int hashCode() {
                return (((this.phase.hashCode() * 31) + this.title.hashCode()) * 31) + this.content.hashCode();
            }

            public String toString() {
                return "Show(phase=" + this.phase + ", title=" + this.title + ", content=" + this.content + ")";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiIsland$b$b;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiIsland$b;", "", "reason", "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland$b$b, reason: collision with other inner class name and from toString */
        public static final /* data */ class Skip extends b {
            private final String reason;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Skip(String reason) {
                super(null);
                kotlin.jvm.internal.p.i(reason, "reason");
                this.reason = reason;
            }

            /* renamed from: a, reason: from getter */
            public final String getReason() {
                return this.reason;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Skip) && kotlin.jvm.internal.p.d(this.reason, ((Skip) other).reason);
            }

            public int hashCode() {
                return this.reason.hashCode();
            }

            public String toString() {
                return "Skip(reason=" + this.reason + ")";
            }
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\nR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0018\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiIsland$b$c;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiIsland$b;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiIsland$Phase;", "phase", "", "title", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "<init>", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiIsland$Phase;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiIsland$Phase;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiIsland$Phase;", "Ljava/lang/String;", "c", Const.INTENT_KEY_APIKEY, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland$b$c, reason: from toString */
        public static final /* data */ class Update extends b {
            private final String content;
            private final Phase phase;
            private final String title;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Update(Phase phase, String title, String content) {
                super(null);
                kotlin.jvm.internal.p.i(phase, "phase");
                kotlin.jvm.internal.p.i(title, "title");
                kotlin.jvm.internal.p.i(content, "content");
                this.phase = phase;
                this.title = title;
                this.content = content;
            }

            /* renamed from: a, reason: from getter */
            public final String getContent() {
                return this.content;
            }

            /* renamed from: b, reason: from getter */
            public final Phase getPhase() {
                return this.phase;
            }

            /* renamed from: c, reason: from getter */
            public final String getTitle() {
                return this.title;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Update)) {
                    return false;
                }
                Update update = (Update) other;
                return this.phase == update.phase && kotlin.jvm.internal.p.d(this.title, update.title) && kotlin.jvm.internal.p.d(this.content, update.content);
            }

            public int hashCode() {
                return (((this.phase.hashCode() * 31) + this.title.hashCode()) * 31) + this.content.hashCode();
            }

            public String toString() {
                return "Update(phase=" + this.phase + ", title=" + this.title + ", content=" + this.content + ")";
            }
        }

        public /* synthetic */ b(kotlin.jvm.internal.i iVar) {
            this();
        }

        public b() {
        }
    }

    public final b a(Integer status, String payloadTitle, H.Memory shown) {
        Phase phaseK = k(status);
        if (phaseK == null) {
            return new b.Skip("status");
        }
        if (shown != null && shown.getClosed() && !n(Integer.valueOf(shown.getStatus())) && n(status)) {
            return new b.Skip(REASON_ENDED);
        }
        if (shown != null) {
            int iF = shown.getStatus();
            if (status != null && iF == status.intValue() && shown.getClosed()) {
                return new b.Skip(REASON_CLOSED);
            }
        }
        String strD = N5.j.INSTANCE.d(payloadTitle);
        if (shown != null) {
            int iF2 = shown.getStatus();
            if (status != null && iF2 == status.intValue() && !shown.getClosed()) {
                Copy copyI = i(phaseK, status, strD, shown);
                return (kotlin.jvm.internal.p.d(shown.getTitle(), copyI.getTitle()) && kotlin.jvm.internal.p.d(shown.getContent(), copyI.getContent())) ? new b.Skip(REASON_SAME) : new b.Update(phaseK, copyI.getTitle(), copyI.getContent());
            }
        }
        Copy copyC = c(phaseK, status, strD);
        if (copyC == null) {
            return new b.Skip(phaseK == Phase.TERMINAL ? REASON_NO_TEXT : REASON_INCOMPLETE);
        }
        return new b.Show(phaseK, copyC.getTitle(), copyC.getContent());
    }

    public final String b(Integer status, String cardSubtitle) {
        if (k(status) != Phase.TERMINAL) {
            return cardSubtitle == null ? "" : cardSubtitle;
        }
        String strP = p(status);
        return strP == null ? "" : strP;
    }

    public final Copy c(Phase phase, Integer status, String incoming) {
        String strP;
        if (incoming == null) {
            return null;
        }
        if (phase == Phase.TERMINAL) {
            strP = p(status);
            if (strP == null) {
                strP = "";
            }
        } else {
            strP = incoming;
        }
        if (strP.length() == 0) {
            return null;
        }
        return new Copy(incoming, strP);
    }

    public final boolean d(Phase phase) {
        kotlin.jvm.internal.p.i(phase, "phase");
        return phase != Phase.EXEC;
    }

    public final Set<Integer> e() {
        return statuses;
    }

    public final String f(String taskId, int status) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        return TASK_PREFIX + taskId + ServerSentEventKt.COLON + status;
    }

    public final String g(Integer status) {
        return (status != null && status.intValue() == 7) ? "WAITING" : (status != null && status.intValue() == 3) ? "WAITING" : (status != null && status.intValue() == 4) ? "COMPLETED" : (status != null && status.intValue() == 5) ? "COMPLETED" : (status != null && status.intValue() == 6) ? "COMPLETED" : "RUNNING";
    }

    public final boolean h(Phase phase) {
        kotlin.jvm.internal.p.i(phase, "phase");
        return phase == Phase.CONFIRMATION || phase == Phase.WAITING;
    }

    public final Copy i(Phase phase, Integer status, String incoming, H.Memory shown) {
        if (phase != Phase.TERMINAL) {
            String strG = shown.getTitle();
            if (incoming == null) {
                incoming = shown.getContent();
            }
            return new Copy(strG, incoming);
        }
        if (incoming == null) {
            incoming = shown.getTitle();
        }
        String strP = p(status);
        if (strP == null) {
            strP = "";
        }
        if (strP.length() == 0) {
            strP = shown.getContent();
        }
        return new Copy(incoming, strP);
    }

    public final CardEnvelope j(String payload) {
        Object objB;
        JsonObject asJsonObject;
        JsonElement jsonElement;
        Object objB2;
        Object objB3;
        kotlin.jvm.internal.p.i(payload, "payload");
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(JsonParser.parseString(payload).getAsJsonObject());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        JsonObject jsonObject = (JsonObject) objB;
        if (jsonObject == null || (asJsonObject = jsonObject.getAsJsonObject("result")) == null || (jsonElement = asJsonObject.get("structuredContent")) == null) {
            return null;
        }
        if (!jsonElement.isJsonObject()) {
            if (!jsonElement.isJsonPrimitive() || !jsonElement.getAsJsonPrimitive().isString()) {
                return null;
            }
            try {
                objB3 = Result.b(JsonParser.parseString(jsonElement.getAsString()));
            } catch (Throwable th2) {
                Result.Companion companion3 = Result.INSTANCE;
                objB3 = Result.b(C4849c.a(th2));
            }
            if (Result.g(objB3)) {
                objB3 = null;
            }
            jsonElement = (JsonElement) objB3;
            if (jsonElement == null) {
                return null;
            }
        }
        try {
            objB2 = Result.b((CardEnvelope) N5.k.INSTANCE.b().fromJson(jsonElement, CardEnvelope.class));
        } catch (Throwable th3) {
            Result.Companion companion4 = Result.INSTANCE;
            objB2 = Result.b(C4849c.a(th3));
        }
        return (CardEnvelope) (Result.g(objB2) ? null : objB2);
    }

    public final Phase k(Integer status) {
        if (status != null && status.intValue() == 2) {
            return Phase.EXEC;
        }
        if (status != null && status.intValue() == 3) {
            return Phase.CONFIRMATION;
        }
        if (status != null && status.intValue() == 7) {
            return Phase.WAITING;
        }
        if ((status != null && status.intValue() == 4) || ((status != null && status.intValue() == 5) || (status != null && status.intValue() == 6))) {
            return Phase.TERMINAL;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final kotlin.Pair<java.lang.String, java.lang.String> l(N5.CardEnvelope r7) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland.l(N5.i):kotlin.Pair");
    }

    public final String m(CardEnvelope envelope) {
        JsonElement jsonElement;
        String simpleName;
        List listM;
        AlipayXuiActionDetail detail;
        kotlin.jvm.internal.p.i(envelope, "envelope");
        N5.k kVar = N5.k.INSTANCE;
        JsonObject jsonObjectC = kVar.c(envelope.e());
        if (jsonObjectC == null || (jsonElement = jsonObjectC.get("items")) == null) {
            listM = C1173v.m();
        } else {
            try {
                listM = (List) kVar.b().fromJson(jsonElement, new TypeToken<List<? extends AlipayXuiItem>>() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland$resolvedAppLink$$inlined$parseList$1
                }.getType());
                if (listM == null) {
                    listM = C1173v.m();
                }
            } catch (Exception e10) {
                R5.b bVar = R5.b.INSTANCE;
                Pair pairA = Y8.j.a("key", "items");
                Pair pairA2 = Y8.j.a("targetType", AlipayXuiItem.class.getSimpleName());
                if (jsonElement.isJsonArray()) {
                    simpleName = "array(size=" + jsonElement.getAsJsonArray().size() + ")";
                } else {
                    simpleName = jsonElement.isJsonObject() ? "object" : jsonElement.isJsonPrimitive() ? "primitive" : jsonElement.getClass().getSimpleName();
                }
                bVar.h("CardJson.parseList.fail", pairA, pairA2, Y8.j.a("elementKind", simpleName), Y8.j.a("exception", e10.getClass().getSimpleName()), Y8.j.a("message", e10.getMessage()));
                listM = C1173v.m();
            }
        }
        AlipayXuiItem alipayXuiItem = (AlipayXuiItem) Z8.F.t0(listM, 0);
        AlipayXuiAction action = alipayXuiItem != null ? alipayXuiItem.getAction() : null;
        N5.j jVar = N5.j.INSTANCE;
        String strD = jVar.d((action == null || (detail = action.getDetail()) == null) ? null : detail.getAppLink());
        if (strD == null) {
            return jVar.d(action != null ? action.getAppLink() : null);
        }
        return strD;
    }

    public final boolean n(Integer status) {
        if (status != null && status.intValue() == 2) {
            return true;
        }
        if (status != null && status.intValue() == 3) {
            return true;
        }
        return status != null && status.intValue() == 7;
    }

    public final String o(String liveId) {
        String strR0;
        int iA0;
        kotlin.jvm.internal.p.i(liveId, "liveId");
        if (!La.D.X(liveId, TASK_PREFIX, false, 2, null) || (iA0 = La.H.A0((strR0 = La.H.R0(liveId, TASK_PREFIX)), ':', 0, false, 6, null)) <= 0) {
            return null;
        }
        String strSubstring = strR0.substring(0, iA0);
        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        if (La.H.x0(strSubstring)) {
            return null;
        }
        return strSubstring;
    }

    public final String p(Integer status) {
        if (status != null && status.intValue() == 4) {
            return LABEL_ENDED;
        }
        if (status != null && status.intValue() == 5) {
            return LABEL_CANCELLED;
        }
        if (status != null && status.intValue() == 6) {
            return LABEL_COMPLETED;
        }
        return null;
    }
}
