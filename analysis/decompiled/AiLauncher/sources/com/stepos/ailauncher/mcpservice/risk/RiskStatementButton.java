package com.stepos.ailauncher.mcpservice.risk;

import com.autonavi.aps.amapapi.config.Const;
import h9.InterfaceC4149a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001aB-\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u000bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0015\u0010\u000bR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0016\u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/stepos/ailauncher/mcpservice/risk/RiskStatementButton;", "", "", "id", "text", "subtext", "Lcom/stepos/ailauncher/mcpservice/risk/RiskStatementButton$Style;", "style", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/ailauncher/mcpservice/risk/RiskStatementButton$Style;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "c", "getSubtext", "Lcom/stepos/ailauncher/mcpservice/risk/RiskStatementButton$Style;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/ailauncher/mcpservice/risk/RiskStatementButton$Style;", "Style", "mcpservice_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class RiskStatementButton {
    private final String id;
    private final Style style;
    private final String subtext;
    private final String text;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/mcpservice/risk/RiskStatementButton$Style;", "", "<init>", "(Ljava/lang/String;I)V", "NORMAL", "REJECT", "EMPHASIS", "mcpservice_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Style {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ Style[] $VALUES;
        public static final Style NORMAL = new Style("NORMAL", 0);
        public static final Style REJECT = new Style("REJECT", 1);
        public static final Style EMPHASIS = new Style("EMPHASIS", 2);

        private static final /* synthetic */ Style[] $values() {
            return new Style[]{NORMAL, REJECT, EMPHASIS};
        }

        static {
            Style[] styleArr$values = $values();
            $VALUES = styleArr$values;
            $ENTRIES = kotlin.enums.a.a(styleArr$values);
        }

        private Style(String str, int i10) {
        }

        public static InterfaceC4149a<Style> getEntries() {
            return $ENTRIES;
        }

        public static Style valueOf(String str) {
            return (Style) Enum.valueOf(Style.class, str);
        }

        public static Style[] values() {
            return (Style[]) $VALUES.clone();
        }
    }

    public RiskStatementButton(String id, String text, String str, Style style) {
        kotlin.jvm.internal.p.i(id, "id");
        kotlin.jvm.internal.p.i(text, "text");
        kotlin.jvm.internal.p.i(style, "style");
        this.id = id;
        this.text = text;
        this.subtext = str;
        this.style = style;
    }

    /* renamed from: a, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: b, reason: from getter */
    public final Style getStyle() {
        return this.style;
    }

    /* renamed from: c, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RiskStatementButton)) {
            return false;
        }
        RiskStatementButton riskStatementButton = (RiskStatementButton) other;
        return kotlin.jvm.internal.p.d(this.id, riskStatementButton.id) && kotlin.jvm.internal.p.d(this.text, riskStatementButton.text) && kotlin.jvm.internal.p.d(this.subtext, riskStatementButton.subtext) && this.style == riskStatementButton.style;
    }

    public int hashCode() {
        int iHashCode = ((this.id.hashCode() * 31) + this.text.hashCode()) * 31;
        String str = this.subtext;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.style.hashCode();
    }

    public String toString() {
        return "RiskStatementButton(id=" + this.id + ", text=" + this.text + ", subtext=" + this.subtext + ", style=" + this.style + ")";
    }

    public /* synthetic */ RiskStatementButton(String str, String str2, String str3, Style style, int i10, kotlin.jvm.internal.i iVar) {
        this(str, str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? Style.NORMAL : style);
    }
}
