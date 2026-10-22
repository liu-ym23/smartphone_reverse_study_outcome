package com.stepos.ailauncher.agent.analytics;

import Y8.j;
import Z8.A;
import Z8.F;
import Z8.Q;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.agent.analytics.SkillAnalytics;
import com.stepos.ailauncher.agent.skill.InstallKind;
import com.stepos.ailauncher.agent.skill.SkillItem;
import com.stepos.ailauncher.agent.skill.SkillStatus;
import com.stepos.ailauncher.agent.skill.adapter.DisplayScope;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.ailauncher.task.space.C3577a2;
import com.stepos.statsapp.v3.UsageStatsProxy3;
import h8.C4148a;
import h9.InterfaceC4149a;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.enums.a;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0015\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002Z[B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\nJ\u001d\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\nJ\u001d\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\nJ%\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J/\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0012¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u001d\u0010\u001cJ\u0015\u0010 \u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J%\u0010%\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u0014¢\u0006\u0004\b%\u0010&J\r\u0010'\u001a\u00020\b¢\u0006\u0004\b'\u0010\u0003J\u0015\u0010(\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b(\u0010)J;\u0010-\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010*\u001a\u0004\u0018\u00010\u00142\b\u0010+\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010,\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b-\u0010.J#\u00102\u001a\u00020\b2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u0002000/H\u0002¢\u0006\u0004\b2\u00103J\u0013\u00104\u001a\u00020\u0014*\u00020\u0004H\u0002¢\u0006\u0004\b4\u00105J\u0015\u00107\u001a\u00020\u0014*\u0004\u0018\u000106H\u0002¢\u0006\u0004\b7\u00108J\u0013\u00109\u001a\u00020\u0014*\u00020\u0006H\u0002¢\u0006\u0004\b9\u0010:J\u0013\u0010;\u001a\u00020\u0014*\u00020\u0006H\u0002¢\u0006\u0004\b;\u0010:J\u0013\u0010<\u001a\u00020\u0014*\u00020\u0006H\u0002¢\u0006\u0004\b<\u0010:J\u0013\u0010=\u001a\u00020\u0014*\u00020\u0006H\u0002¢\u0006\u0004\b=\u0010:J\u0013\u0010>\u001a\u00020\u0014*\u00020\u0006H\u0002¢\u0006\u0004\b>\u0010:J5\u0010C\u001a\u00020\b2\u0006\u0010?\u001a\u00020\u00142\b\u0010@\u001a\u0004\u0018\u00010\u00142\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140AH\u0002¢\u0006\u0004\bC\u0010DR\u0014\u0010E\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010H\u001a\u00020G8\u0002X\u0082T¢\u0006\u0006\n\u0004\bH\u0010IR\u0014\u0010J\u001a\u00020\u00168\u0002X\u0082T¢\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010L\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\bL\u0010FR\u0014\u0010M\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\bM\u0010FR\u0014\u0010N\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\bN\u0010FR\u0014\u0010O\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\bO\u0010FR\u0014\u0010P\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\bP\u0010FR\u0014\u0010Q\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\bQ\u0010FR\u0014\u0010R\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\bR\u0010FR\u0014\u0010S\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\bS\u0010FR\u0014\u0010T\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\bT\u0010FR\u0014\u0010U\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\bU\u0010FR \u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u0002000/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010WR \u0010X\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u0002000/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010WR \u0010Y\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u0002000/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010W¨\u0006\\"}, d2 = {"Lcom/stepos/ailauncher/agent/analytics/SkillAnalytics;", "", "<init>", "()V", "Lcom/stepos/ailauncher/agent/skill/SkillItem;", "item", "Lcom/stepos/ailauncher/agent/skill/adapter/DisplayScope;", "scope", "LY8/t;", "t", "(Lcom/stepos/ailauncher/agent/skill/SkillItem;Lcom/stepos/ailauncher/agent/skill/adapter/DisplayScope;)V", "u", "v", Const.INTENT_KEY_UMID, "Lcom/stepos/ailauncher/agent/analytics/SkillAnalytics$ClickTarget;", "target", "c", "(Lcom/stepos/ailauncher/agent/skill/SkillItem;Lcom/stepos/ailauncher/agent/skill/adapter/DisplayScope;Lcom/stepos/ailauncher/agent/analytics/SkillAnalytics$ClickTarget;)V", "", "success", "", "failReason", "", "durationMs", "e", "(Lcom/stepos/ailauncher/agent/skill/SkillItem;ZLjava/lang/String;J)V", "enable", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/agent/skill/SkillItem;Z)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "Lcom/stepos/ailauncher/agent/skill/InstallKind;", "kind", "f", "(Lcom/stepos/ailauncher/agent/skill/InstallKind;)V", "toolName", "version", "installStatus", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lcom/stepos/ailauncher/agent/skill/SkillItem;)V", "oldVersion", "newVersion", "errorCode", "k", "(Lcom/stepos/ailauncher/agent/skill/SkillItem;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/stepos/ailauncher/agent/analytics/SkillAnalytics$a;", C3081a.FOCUS_MAP_NAME, "w", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "o", "(Lcom/stepos/ailauncher/agent/skill/SkillItem;)Ljava/lang/String;", "Lcom/stepos/ailauncher/agent/skill/SkillStatus;", "s", "(Lcom/stepos/ailauncher/agent/skill/SkillStatus;)Ljava/lang/String;", "q", "(Lcom/stepos/ailauncher/agent/skill/adapter/DisplayScope;)Ljava/lang/String;", "m", "n", "p", "r", "eventName", "pageName", "", "props", "l", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "TAG", "Ljava/lang/String;", "", "PENDING_MAX", "I", "PENDING_TIMEOUT_MS", "J", "EVENT_MARKET_PAGE_EXPOSURE", "EVENT_MARKET_ENTRY_CLICK", "EVENT_MARKET_CARD_EXPOSE", "EVENT_MARKET_CARD_CLICK", "EVENT_MARKET_INSTALL_RESULT", "EVENT_CLI_STATUS_CHANGE", "EVENT_CLI_UNINSTALL_CLICK", "EVENT_SKILL_DETAIL_SHOW", "EVENT_MARKET_INSTALL_SHOW", "EVENT_MUSTHAVE_SUBPAGE_SHOW", "pendingInstall", "Ljava/util/concurrent/ConcurrentHashMap;", "pendingToggle", "pendingUninstall", Const.INTENT_KEY_APIKEY, "ClickTarget", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SkillAnalytics {
    private static final String EVENT_CLI_STATUS_CHANGE = "market_skill_status_change";
    private static final String EVENT_CLI_UNINSTALL_CLICK = "market_skill_uninstall_click";
    private static final String EVENT_MARKET_CARD_CLICK = "market_skill_card_click";
    private static final String EVENT_MARKET_CARD_EXPOSE = "market_skill_card_expose";
    private static final String EVENT_MARKET_ENTRY_CLICK = "market_skill_entry_click";
    private static final String EVENT_MARKET_INSTALL_RESULT = "market_skill_install_result";
    private static final String EVENT_MARKET_INSTALL_SHOW = "market_install_show";
    private static final String EVENT_MARKET_PAGE_EXPOSURE = "market_skill_page_show";
    private static final String EVENT_MUSTHAVE_SUBPAGE_SHOW = "market_musthave_subpage_show";
    private static final String EVENT_SKILL_DETAIL_SHOW = "market_skill_detail_show";
    private static final int PENDING_MAX = 64;
    private static final long PENDING_TIMEOUT_MS = 120000;
    private static final String TAG = "SkillAnalytics";
    public static final SkillAnalytics INSTANCE = new SkillAnalytics();
    private static final ConcurrentHashMap<String, Pending> pendingInstall = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, Pending> pendingToggle = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, Pending> pendingUninstall = new ConcurrentHashMap<>();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/agent/analytics/SkillAnalytics$ClickTarget;", "", "wire", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getWire", "()Ljava/lang/String;", "CARD", "INSTALL_BUTTON", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class ClickTarget {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ ClickTarget[] $VALUES;
        public static final ClickTarget CARD = new ClickTarget("CARD", 0, "card");
        public static final ClickTarget INSTALL_BUTTON = new ClickTarget("INSTALL_BUTTON", 1, "install_button");
        private final String wire;

        private static final /* synthetic */ ClickTarget[] $values() {
            return new ClickTarget[]{CARD, INSTALL_BUTTON};
        }

        static {
            ClickTarget[] clickTargetArr$values = $values();
            $VALUES = clickTargetArr$values;
            $ENTRIES = a.a(clickTargetArr$values);
        }

        private ClickTarget(String str, int i10, String str2) {
            this.wire = str2;
        }

        public static InterfaceC4149a<ClickTarget> getEntries() {
            return $ENTRIES;
        }

        public static ClickTarget valueOf(String str) {
            return (ClickTarget) Enum.valueOf(ClickTarget.class, str);
        }

        public static ClickTarget[] values() {
            return (ClickTarget[]) $VALUES.clone();
        }

        public final String getWire() {
            return this.wire;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/stepos/ailauncher/agent/analytics/SkillAnalytics$a;", "", "Lcom/stepos/ailauncher/agent/skill/adapter/DisplayScope;", "scope", "", "ts", "<init>", "(Lcom/stepos/ailauncher/agent/skill/adapter/DisplayScope;J)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ailauncher/agent/skill/adapter/DisplayScope;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/agent/skill/adapter/DisplayScope;", "J", Const.INTENT_KEY_PKGNAME, "()J", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.agent.analytics.SkillAnalytics$a, reason: from toString */
    public static final /* data */ class Pending {
        private final DisplayScope scope;
        private final long ts;

        public Pending(DisplayScope scope, long j10) {
            p.i(scope, "scope");
            this.scope = scope;
            this.ts = j10;
        }

        /* renamed from: a, reason: from getter */
        public final DisplayScope getScope() {
            return this.scope;
        }

        /* renamed from: b, reason: from getter */
        public final long getTs() {
            return this.ts;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Pending)) {
                return false;
            }
            Pending pending = (Pending) other;
            return this.scope == pending.scope && this.ts == pending.ts;
        }

        public int hashCode() {
            return (this.scope.hashCode() * 31) + Long.hashCode(this.ts);
        }

        public String toString() {
            return "Pending(scope=" + this.scope + ", ts=" + this.ts + ")";
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[InstallKind.values().length];
            try {
                iArr[InstallKind.SKILL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InstallKind.CLI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[InstallKind.AGENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[DisplayScope.values().length];
            try {
                iArr2[DisplayScope.HOME_ESSENTIAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[DisplayScope.HOME_OTHER.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[DisplayScope.ESSENTIAL_SUBPAGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[DisplayScope.TESTING.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[DisplayScope.COMMUNITY_SUBPAGE.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[DisplayScope.INSTALLED.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[DisplayScope.SEARCH.ordinal()] = 7;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[DisplayScope.SKILL_DETAIL.ordinal()] = 8;
            } catch (NoSuchFieldError unused11) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class c<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return b9.b.d(Long.valueOf(((Pending) ((Map.Entry) t10).getValue()).getTs()), Long.valueOf(((Pending) ((Map.Entry) t11).getValue()).getTs()));
        }
    }

    public static final boolean x(long j10, Map.Entry it) {
        p.i(it, "it");
        return j10 - ((Pending) it.getValue()).getTs() > PENDING_TIMEOUT_MS;
    }

    public final void b(SkillItem item, boolean enable) {
        String strP;
        p.i(item, "item");
        try {
            Pending pendingRemove = pendingToggle.remove(item.getIdentifier());
            DisplayScope scope = pendingRemove != null ? pendingRemove.getScope() : null;
            SkillAnalytics skillAnalytics = INSTANCE;
            Pair pairA = j.a("object_type", skillAnalytics.o(item));
            Pair pairA2 = j.a("tool_name", item.getName());
            Pair pairA3 = j.a("action_type", enable ? "open" : "close");
            if (scope == null || (strP = skillAnalytics.p(scope)) == null) {
                strP = "market_page";
            }
            skillAnalytics.l(EVENT_CLI_STATUS_CHANGE, null, kotlin.collections.a.m(pairA, pairA2, pairA3, j.a("operation_source", strP)));
        } catch (Throwable th) {
            C4148a.t(TAG, "analytics report failed", th, false, 8, null);
        }
    }

    public final void c(SkillItem item, DisplayScope scope, ClickTarget target) {
        p.i(item, "item");
        p.i(scope, "scope");
        p.i(target, "target");
        try {
            SkillAnalytics skillAnalytics = INSTANCE;
            skillAnalytics.l(EVENT_MARKET_CARD_CLICK, com.stepos.ailauncher.chat.trace.c.POSITION_MARKET, kotlin.collections.a.m(j.a("object_type", skillAnalytics.o(item)), j.a("tool_name", item.getName()), j.a("click_source", skillAnalytics.m(scope)), j.a("click_target", target.getWire())));
        } catch (Throwable th) {
            C4148a.t(TAG, "analytics report failed", th, false, 8, null);
        }
    }

    public final void d(SkillItem item, DisplayScope scope) {
        p.i(item, "item");
        p.i(scope, "scope");
        try {
            SkillAnalytics skillAnalytics = INSTANCE;
            skillAnalytics.l(EVENT_MARKET_CARD_EXPOSE, com.stepos.ailauncher.chat.trace.c.POSITION_MARKET, kotlin.collections.a.m(j.a("object_type", skillAnalytics.o(item)), j.a("tool_name", item.getName()), j.a("skill_source", skillAnalytics.q(scope)), j.a("status", skillAnalytics.s(item.getStatus()))));
        } catch (Throwable th) {
            C4148a.t(TAG, "analytics report failed", th, false, 8, null);
        }
    }

    public final void e(SkillItem item, boolean success, String failReason, long durationMs) {
        String strN;
        p.i(item, "item");
        try {
            Pending pendingRemove = pendingInstall.remove(item.getIdentifier());
            DisplayScope scope = pendingRemove != null ? pendingRemove.getScope() : null;
            SkillAnalytics skillAnalytics = INSTANCE;
            Pair pairA = j.a("object_type", skillAnalytics.o(item));
            Pair pairA2 = j.a("tool_name", item.getName());
            if (scope == null || (strN = skillAnalytics.n(scope)) == null) {
                strN = "market_page";
            }
            Map<String, String> mapP = kotlin.collections.a.p(pairA, pairA2, j.a("install_source", strN), j.a("result", success ? "success" : "fail"), j.a("duration", String.valueOf(durationMs)));
            if (!success && failReason != null && failReason.length() != 0) {
                mapP.put("error_code", failReason);
            }
            skillAnalytics.l(EVENT_MARKET_INSTALL_RESULT, null, mapP);
        } catch (Throwable th) {
            C4148a.t(TAG, "analytics report failed", th, false, 8, null);
        }
    }

    public final void f(InstallKind kind) {
        String str;
        p.i(kind, "kind");
        try {
            int i10 = b.$EnumSwitchMapping$0[kind.ordinal()];
            if (i10 == 1) {
                str = C3577a2.TYPE_SKILL;
            } else if (i10 == 2) {
                str = "cli";
            } else {
                if (i10 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                str = "agent";
            }
            INSTANCE.l(EVENT_MARKET_INSTALL_SHOW, com.stepos.ailauncher.chat.trace.c.POSITION_MARKET, Q.f(j.a("asset_type", str)));
        } catch (Throwable th) {
            C4148a.t(TAG, "analytics report failed", th, false, 8, null);
        }
    }

    public final void g(SkillItem item, boolean success) {
        String strR;
        p.i(item, "item");
        try {
            Pending pendingRemove = pendingUninstall.remove(item.getIdentifier());
            DisplayScope scope = pendingRemove != null ? pendingRemove.getScope() : null;
            SkillAnalytics skillAnalytics = INSTANCE;
            Pair pairA = j.a("object_type", skillAnalytics.o(item));
            Pair pairA2 = j.a("tool_name", item.getName());
            if (scope == null || (strR = skillAnalytics.r(scope)) == null) {
                strR = "skill_detail_page";
            }
            skillAnalytics.l(EVENT_CLI_UNINSTALL_CLICK, null, kotlin.collections.a.m(pairA, pairA2, j.a("uninstall_source", strR), j.a("result", success ? "success" : "fail")));
        } catch (Throwable th) {
            C4148a.t(TAG, "analytics report failed", th, false, 8, null);
        }
    }

    public final void h() {
        try {
            INSTANCE.l(EVENT_MUSTHAVE_SUBPAGE_SHOW, com.stepos.ailauncher.chat.trace.c.POSITION_MARKET, kotlin.collections.a.i());
        } catch (Throwable th) {
            C4148a.t(TAG, "analytics report failed", th, false, 8, null);
        }
    }

    public final void i(String toolName, String version, String installStatus) {
        p.i(toolName, "toolName");
        p.i(version, "version");
        p.i(installStatus, "installStatus");
        try {
            INSTANCE.l(EVENT_SKILL_DETAIL_SHOW, com.stepos.ailauncher.chat.trace.c.POSITION_MARKET, kotlin.collections.a.m(j.a("tool_name", toolName), j.a("version", version), j.a("install_status", installStatus)));
        } catch (Throwable th) {
            C4148a.t(TAG, "analytics report failed", th, false, 8, null);
        }
    }

    public final void j(SkillItem item) {
        p.i(item, "item");
        try {
            SkillAnalytics skillAnalytics = INSTANCE;
            skillAnalytics.l("market_skill_update_click", "skill_detail", kotlin.collections.a.m(j.a("object_type", skillAnalytics.o(item)), j.a("tool_name", item.getName()), j.a("click_source", skillAnalytics.m(DisplayScope.SKILL_DETAIL))));
        } catch (Throwable th) {
            C4148a.t(TAG, "analytics report failed", th, false, 8, null);
        }
    }

    public final void k(SkillItem item, String oldVersion, String newVersion, boolean success, String errorCode) {
        p.i(item, "item");
        try {
            SkillAnalytics skillAnalytics = INSTANCE;
            Pair pairA = j.a("object_type", skillAnalytics.o(item));
            Pair pairA2 = j.a("tool_name", item.getName());
            if (oldVersion == null) {
                oldVersion = "";
            }
            Pair pairA3 = j.a("old_version", oldVersion);
            if (newVersion == null) {
                newVersion = "";
            }
            Map<String, String> mapP = kotlin.collections.a.p(pairA, pairA2, pairA3, j.a("new_version", newVersion), j.a("result", success ? "success" : "fail"));
            if (!success && errorCode != null && errorCode.length() != 0) {
                mapP.put("error_code", errorCode);
            }
            skillAnalytics.l("market_skill_update_result", "skill_detail", mapP);
        } catch (Throwable th) {
            C4148a.t(TAG, "analytics report failed", th, false, 8, null);
        }
    }

    public final void l(String eventName, String pageName, Map<String, String> props) {
        UsageStatsProxy3.getInstance().onEvent(eventName, pageName, props);
        C4148a.d(TAG, "report event=" + eventName + " page=" + pageName + " props=" + props, false, 4, null);
    }

    public final String m(DisplayScope displayScope) {
        switch (b.$EnumSwitchMapping$1[displayScope.ordinal()]) {
            case 1:
                return "must_have_market";
            case 2:
                return "other_market";
            case 3:
                return "must_have_subpage";
            case 4:
                return W4.a.ENTRY_TEST_ZONE;
            case 5:
                return "community";
            case 6:
                return "installed_manager";
            case 7:
                return "search_result";
            case 8:
                return "skill_detail_page";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final String n(DisplayScope displayScope) {
        switch (b.$EnumSwitchMapping$1[displayScope.ordinal()]) {
            case 3:
                return "must_have_subpage";
            case 4:
                return W4.a.ENTRY_TEST_ZONE;
            case 5:
                return "community";
            case 6:
                return "installed_manager";
            case 7:
                return "search_result";
            case 8:
                return "skill_detail_page";
            default:
                return "market_page";
        }
    }

    public final String o(SkillItem skillItem) {
        return skillItem.getInstallKind() == InstallKind.CLI ? "cli_tool" : C3577a2.TYPE_SKILL;
    }

    public final String p(DisplayScope displayScope) {
        int i10 = b.$EnumSwitchMapping$1[displayScope.ordinal()];
        return i10 != 3 ? i10 != 4 ? i10 != 5 ? i10 != 6 ? i10 != 8 ? "market_page" : W4.a.SOURCE_DETAIL : "installed_manager" : "community" : W4.a.ENTRY_TEST_ZONE : "must_have_subpage";
    }

    public final String q(DisplayScope displayScope) {
        switch (b.$EnumSwitchMapping$1[displayScope.ordinal()]) {
            case 1:
                return "must_have_market";
            case 2:
                return "other_market";
            case 3:
                return "must_have_subpage";
            case 4:
                return W4.a.ENTRY_TEST_ZONE;
            case 5:
                return "community";
            case 6:
                return "installed_manager";
            case 7:
                return "search_result";
            case 8:
                return "skill_detail_page";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final String r(DisplayScope displayScope) {
        switch (b.$EnumSwitchMapping$1[displayScope.ordinal()]) {
            case 1:
            case 2:
                return "market_skill_page";
            case 3:
                return "must_have_subpage";
            case 4:
                return W4.a.ENTRY_TEST_ZONE;
            case 5:
                return "community";
            case 6:
                return "installed";
            case 7:
                return "search_result";
            case 8:
                return "skill_detail_page";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final String s(SkillStatus skillStatus) {
        Object objB;
        if (skillStatus == null) {
            return "unknown";
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            SerializedName serializedName = (SerializedName) SkillStatus.class.getField(skillStatus.name()).getAnnotation(SerializedName.class);
            objB = Result.b(serializedName != null ? serializedName.value() : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        String str = (String) (Result.g(objB) ? null : objB);
        if (str != null) {
            return str;
        }
        String lowerCase = skillStatus.name().toLowerCase(Locale.ROOT);
        p.h(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    public final void t(SkillItem item, DisplayScope scope) {
        p.i(item, "item");
        p.i(scope, "scope");
        ConcurrentHashMap<String, Pending> concurrentHashMap = pendingInstall;
        w(concurrentHashMap);
        concurrentHashMap.putIfAbsent(item.getIdentifier(), new Pending(scope, System.currentTimeMillis()));
    }

    public final void u(SkillItem item, DisplayScope scope) {
        p.i(item, "item");
        p.i(scope, "scope");
        ConcurrentHashMap<String, Pending> concurrentHashMap = pendingToggle;
        w(concurrentHashMap);
        concurrentHashMap.putIfAbsent(item.getIdentifier(), new Pending(scope, System.currentTimeMillis()));
    }

    public final void v(SkillItem item, DisplayScope scope) {
        p.i(item, "item");
        p.i(scope, "scope");
        ConcurrentHashMap<String, Pending> concurrentHashMap = pendingUninstall;
        w(concurrentHashMap);
        concurrentHashMap.putIfAbsent(item.getIdentifier(), new Pending(scope, System.currentTimeMillis()));
    }

    public final void w(ConcurrentHashMap<String, Pending> map) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        Set<Map.Entry<String, Pending>> setEntrySet = map.entrySet();
        p.h(setEntrySet, "<get-entries>(...)");
        A.J(setEntrySet, new InterfaceC5074l() { // from class: W4.d
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(SkillAnalytics.x(jCurrentTimeMillis, (Map.Entry) obj));
            }
        });
        if (map.size() > 64) {
            Set<Map.Entry<String, Pending>> setEntrySet2 = map.entrySet();
            p.h(setEntrySet2, "<get-entries>(...)");
            Iterator it = F.f1(F.c1(setEntrySet2, new c()), map.size() - 64).iterator();
            while (it.hasNext()) {
                map.remove(((Map.Entry) it.next()).getKey());
            }
        }
    }
}
