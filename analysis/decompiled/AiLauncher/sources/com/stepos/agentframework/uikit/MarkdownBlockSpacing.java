package com.stepos.agentframework.uikit;

import com.autonavi.aps.amapapi.config.Const;
import h9.InterfaceC4149a;
import java.util.Set;
import kotlin.Metadata;
import kotlin.text.Regex;
import kotlin.text.RegexOption;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001(B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0010\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0014J\u0017\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010 \u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u001fH\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u001fH\u0002¢\u0006\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010&¨\u0006)"}, d2 = {"Lcom/stepos/agentframework/uikit/MarkdownBlockSpacing;", "", "<init>", "()V", "LYb/u;", "node", "Lcom/stepos/agentframework/uikit/MarkdownBlockSpacing$Kind;", "f", "(LYb/u;)Lcom/stepos/agentframework/uikit/MarkdownBlockSpacing$Kind;", "before", "after", "", "supplementaryParagraph", "", "c", "(Lcom/stepos/agentframework/uikit/MarkdownBlockSpacing$Kind;Lcom/stepos/agentframework/uikit/MarkdownBlockSpacing$Kind;Z)I", Const.INTENT_KEY_PKGNAME, "(LYb/u;LYb/u;Z)I", "item", Const.INTENT_KEY_BACKGROUND_COMMAND, "(LYb/u;)I", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(LYb/u;)LYb/u;", "kind", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lcom/stepos/agentframework/uikit/MarkdownBlockSpacing$Kind;)Z", "", "html", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)Lcom/stepos/agentframework/uikit/MarkdownBlockSpacing$Kind;", "LYb/w;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(LYb/w;)Lcom/stepos/agentframework/uikit/MarkdownBlockSpacing$Kind;", "e", "(LYb/w;)Z", "Lkotlin/text/Regex;", "videoTag", "Lkotlin/text/Regex;", "imageTag", "Kind", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MarkdownBlockSpacing {
    public static final MarkdownBlockSpacing INSTANCE = new MarkdownBlockSpacing();
    private static final Regex imageTag;
    private static final Regex videoTag;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/stepos/agentframework/uikit/MarkdownBlockSpacing$Kind;", "", "<init>", "(Ljava/lang/String;I)V", "HEADING", "PARAGRAPH", "BULLET_LIST", "ORDERED_LIST", "TABLE", "CODE", "IMAGE", "VIDEO", "ARTIFACT", "QUOTE", "RULE", "OTHER", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Kind {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ Kind[] $VALUES;
        public static final Kind HEADING = new Kind("HEADING", 0);
        public static final Kind PARAGRAPH = new Kind("PARAGRAPH", 1);
        public static final Kind BULLET_LIST = new Kind("BULLET_LIST", 2);
        public static final Kind ORDERED_LIST = new Kind("ORDERED_LIST", 3);
        public static final Kind TABLE = new Kind("TABLE", 4);
        public static final Kind CODE = new Kind("CODE", 5);
        public static final Kind IMAGE = new Kind("IMAGE", 6);
        public static final Kind VIDEO = new Kind("VIDEO", 7);
        public static final Kind ARTIFACT = new Kind("ARTIFACT", 8);
        public static final Kind QUOTE = new Kind("QUOTE", 9);
        public static final Kind RULE = new Kind("RULE", 10);
        public static final Kind OTHER = new Kind("OTHER", 11);

        private static final /* synthetic */ Kind[] $values() {
            return new Kind[]{HEADING, PARAGRAPH, BULLET_LIST, ORDERED_LIST, TABLE, CODE, IMAGE, VIDEO, ARTIFACT, QUOTE, RULE, OTHER};
        }

        static {
            Kind[] kindArr$values = $values();
            $VALUES = kindArr$values;
            $ENTRIES = kotlin.enums.a.a(kindArr$values);
        }

        private Kind(String str, int i10) {
        }

        public static InterfaceC4149a<Kind> getEntries() {
            return $ENTRIES;
        }

        public static Kind valueOf(String str) {
            return (Kind) Enum.valueOf(Kind.class, str);
        }

        public static Kind[] values() {
            return (Kind[]) $VALUES.clone();
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Kind.values().length];
            try {
                iArr[Kind.TABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Kind.CODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Kind.IMAGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Kind.VIDEO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Kind.ARTIFACT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Kind.QUOTE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        RegexOption regexOption = RegexOption.IGNORE_CASE;
        videoTag = new Regex("^<video(?:\\s[^>]*)?>.*</video>$", (Set<? extends RegexOption>) Z8.Y.j(regexOption, RegexOption.DOT_MATCHES_ALL));
        imageTag = new Regex("^<img\\b[^>]*>$", regexOption);
    }

    public final int a(Yb.u node) {
        kotlin.jvm.internal.p.i(node, "node");
        int i10 = 0;
        for (Yb.u uVarG = node.g(); uVarG != null; uVarG = uVarG.g()) {
            if (!(uVarG instanceof Yb.r)) {
                i10++;
            }
        }
        return i10;
    }

    public final int b(Yb.u before, Yb.u after, boolean supplementaryParagraph) {
        kotlin.jvm.internal.p.i(before, "before");
        kotlin.jvm.internal.p.i(after, "after");
        if ((before.f() instanceof Yb.t) && before.f() == after.f() && (((before instanceof Yb.s) || (after instanceof Yb.s)) && !(before instanceof Yb.A) && !(after instanceof Yb.A))) {
            return 4;
        }
        return c(f(before), f(after), supplementaryParagraph || (before.f() != null && !(before.f() instanceof Yb.h) && before.f() == after.f()));
    }

    public final int c(Kind before, Kind after, boolean supplementaryParagraph) {
        kotlin.jvm.internal.p.i(before, "before");
        kotlin.jvm.internal.p.i(after, "after");
        Kind kind = Kind.RULE;
        if (before == kind || after == kind) {
            return 24;
        }
        Kind kind2 = Kind.HEADING;
        if (after == kind2) {
            return before == kind2 ? 8 : 24;
        }
        if (before == kind2) {
            return (after == Kind.PARAGRAPH || after == Kind.QUOTE) ? 8 : 12;
        }
        if (after == Kind.PARAGRAPH) {
            return (supplementaryParagraph && j(before)) ? 12 : 24;
        }
        return 12;
    }

    public final Kind d(String html) {
        if (videoTag.k(La.H.D1(html).toString())) {
            return Kind.VIDEO;
        }
        if (imageTag.k(La.H.D1(html).toString())) {
            return Kind.IMAGE;
        }
        return null;
    }

    public final boolean e(Yb.w node) {
        boolean z10 = false;
        for (Yb.u uVarC = node.c(); uVarC != null; uVarC = uVarC.e()) {
            if (uVarC instanceof Yb.y) {
                z10 = true;
            } else {
                if (!(uVarC instanceof Yb.z)) {
                    return false;
                }
                String strM = ((Yb.z) uVarC).m();
                kotlin.jvm.internal.p.h(strM, "getLiteral(...)");
                if (!La.H.x0(strM)) {
                    return false;
                }
            }
        }
        return z10;
    }

    public final Kind f(Yb.u node) {
        kotlin.jvm.internal.p.i(node, "node");
        if (node instanceof Yb.l) {
            return Kind.HEADING;
        }
        if (node instanceof Yb.w) {
            if (J.INSTANCE.b(node)) {
                return Kind.IMAGE;
            }
            Yb.w wVar = (Yb.w) node;
            if (e(wVar)) {
                return Kind.HEADING;
            }
            Kind kindI = i(wVar);
            return kindI == null ? Kind.PARAGRAPH : kindI;
        }
        if (node instanceof Yb.d) {
            return Kind.BULLET_LIST;
        }
        if (node instanceof Yb.v) {
            return Kind.ORDERED_LIST;
        }
        if (node instanceof Yb.c) {
            return Kind.QUOTE;
        }
        if (node instanceof Rb.a) {
            return Kind.TABLE;
        }
        if ((node instanceof Yb.j) || (node instanceof Yb.p)) {
            return Kind.CODE;
        }
        if (node instanceof Yb.A) {
            return Kind.RULE;
        }
        if (!(node instanceof Yb.m)) {
            return Kind.OTHER;
        }
        String strN = ((Yb.m) node).n();
        kotlin.jvm.internal.p.h(strN, "getLiteral(...)");
        Kind kindD = d(strN);
        return kindD == null ? Kind.OTHER : kindD;
    }

    public final int g(Yb.u item) {
        kotlin.jvm.internal.p.i(item, "item");
        return item.d() instanceof Yb.s ? 8 : 4;
    }

    public final Yb.u h(Yb.u node) {
        kotlin.jvm.internal.p.i(node, "node");
        Yb.u uVarE = node.e();
        while (uVarE instanceof Yb.r) {
            uVarE = ((Yb.r) uVarE).e();
        }
        return uVarE;
    }

    public final Kind i(Yb.w node) {
        if (!(node.c() instanceof Yb.n)) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        for (Yb.u uVarC = node.c(); uVarC != null; uVarC = uVarC.e()) {
            if (uVarC instanceof Yb.n) {
                sb2.append(((Yb.n) uVarC).m());
            } else {
                if (!(uVarC instanceof Yb.z)) {
                    return null;
                }
                sb2.append(((Yb.z) uVarC).m());
            }
        }
        String string = sb2.toString();
        kotlin.jvm.internal.p.h(string, "toString(...)");
        return d(string);
    }

    public final boolean j(Kind kind) {
        switch (a.$EnumSwitchMapping$0[kind.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return true;
            default:
                return false;
        }
    }
}
