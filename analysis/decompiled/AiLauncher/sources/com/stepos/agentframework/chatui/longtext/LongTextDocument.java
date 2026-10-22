package com.stepos.agentframework.chatui.longtext;

import La.D;
import La.H;
import La.m;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h9.InterfaceC4149a;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\r\b\u0080\b\u0018\u00002\u00020\u0001:\u0006\u0017\u001b\u001a\u001c\u0015\u001dB1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\rR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u0019\u001a\u0004\b\u001a\u0010\u000fR\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u001b\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/stepos/agentframework/chatui/longtext/LongTextDocument;", "", "", "text", "", "Lcom/stepos/agentframework/chatui/longtext/LongTextDocument$a;", "blocks", "", "htmlFragments", "htmlTags", "<init>", "(Ljava/lang/String;Ljava/util/List;ILjava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_UMID, "Ljava/util/List;", Const.INTENT_KEY_APIKEY, "()Ljava/util/List;", "I", Const.INTENT_KEY_PKGNAME, "c", "e", "Kind", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class LongTextDocument {
    private final List<Block> blocks;
    private final int htmlFragments;
    private final String htmlTags;
    private final String text;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/agentframework/chatui/longtext/LongTextDocument$Kind;", "", "<init>", "(Ljava/lang/String;I)V", "BOLD", "ITALIC", "CODE", "LINK", "HEADING", "STRIKETHROUGH", "QUOTE", "RULE", "UNDERLINE", "SUBSCRIPT", "SUPERSCRIPT", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Kind {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ Kind[] $VALUES;
        public static final Kind BOLD = new Kind("BOLD", 0);
        public static final Kind ITALIC = new Kind("ITALIC", 1);
        public static final Kind CODE = new Kind("CODE", 2);
        public static final Kind LINK = new Kind("LINK", 3);
        public static final Kind HEADING = new Kind("HEADING", 4);
        public static final Kind STRIKETHROUGH = new Kind("STRIKETHROUGH", 5);
        public static final Kind QUOTE = new Kind("QUOTE", 6);
        public static final Kind RULE = new Kind("RULE", 7);
        public static final Kind UNDERLINE = new Kind("UNDERLINE", 8);
        public static final Kind SUBSCRIPT = new Kind("SUBSCRIPT", 9);
        public static final Kind SUPERSCRIPT = new Kind("SUPERSCRIPT", 10);

        private static final /* synthetic */ Kind[] $values() {
            return new Kind[]{BOLD, ITALIC, CODE, LINK, HEADING, STRIKETHROUGH, QUOTE, RULE, UNDERLINE, SUBSCRIPT, SUPERSCRIPT};
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

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0012R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0017\u001a\u0004\b\u0019\u0010\u0012R\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010 \u001a\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/stepos/agentframework/chatui/longtext/LongTextDocument$a;", "", "", "start", com.stepos.ailauncher.container.wallpaper.a.PHASE_END, "", "Lcom/stepos/agentframework/chatui/longtext/LongTextDocument$d;", "styles", "Lcom/stepos/agentframework/chatui/longtext/LongTextDocument$e;", "tableRow", "Lcom/stepos/agentframework/chatui/longtext/LongTextDocument$c;", "codeBlock", "<init>", "(IILjava/util/List;Lcom/stepos/agentframework/chatui/longtext/LongTextDocument$e;Lcom/stepos/agentframework/chatui/longtext/LongTextDocument$c;)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "c", Const.INTENT_KEY_PKGNAME, "Ljava/util/List;", Const.INTENT_KEY_UMID, "()Ljava/util/List;", "Lcom/stepos/agentframework/chatui/longtext/LongTextDocument$e;", "e", "()Lcom/stepos/agentframework/chatui/longtext/LongTextDocument$e;", "Lcom/stepos/agentframework/chatui/longtext/LongTextDocument$c;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/agentframework/chatui/longtext/LongTextDocument$c;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.longtext.LongTextDocument$a, reason: from toString */
    public static final /* data */ class Block {
        private final CodeBlock codeBlock;
        private final int end;
        private final int start;
        private final List<Style> styles;
        private final TableRow tableRow;

        public Block(int i10, int i11, List<Style> styles, TableRow tableRow, CodeBlock codeBlock) {
            p.i(styles, "styles");
            this.start = i10;
            this.end = i11;
            this.styles = styles;
            this.tableRow = tableRow;
            this.codeBlock = codeBlock;
        }

        /* renamed from: a, reason: from getter */
        public final CodeBlock getCodeBlock() {
            return this.codeBlock;
        }

        /* renamed from: b, reason: from getter */
        public final int getEnd() {
            return this.end;
        }

        /* renamed from: c, reason: from getter */
        public final int getStart() {
            return this.start;
        }

        public final List<Style> d() {
            return this.styles;
        }

        /* renamed from: e, reason: from getter */
        public final TableRow getTableRow() {
            return this.tableRow;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Block)) {
                return false;
            }
            Block block = (Block) other;
            return this.start == block.start && this.end == block.end && p.d(this.styles, block.styles) && p.d(this.tableRow, block.tableRow) && p.d(this.codeBlock, block.codeBlock);
        }

        public int hashCode() {
            int iHashCode = ((((Integer.hashCode(this.start) * 31) + Integer.hashCode(this.end)) * 31) + this.styles.hashCode()) * 31;
            TableRow tableRow = this.tableRow;
            int iHashCode2 = (iHashCode + (tableRow == null ? 0 : tableRow.hashCode())) * 31;
            CodeBlock codeBlock = this.codeBlock;
            return iHashCode2 + (codeBlock != null ? codeBlock.hashCode() : 0);
        }

        public String toString() {
            return "Block(start=" + this.start + ", end=" + this.end + ", styles=" + this.styles + ", tableRow=" + this.tableRow + ", codeBlock=" + this.codeBlock + ")";
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u000bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0012\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/stepos/agentframework/chatui/longtext/LongTextDocument$b;", "", "", "start", com.stepos.ailauncher.container.wallpaper.a.PHASE_END, "<init>", "(II)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.longtext.LongTextDocument$b, reason: from toString */
    public static final /* data */ class Cell {
        private final int end;
        private final int start;

        public Cell(int i10, int i11) {
            this.start = i10;
            this.end = i11;
        }

        /* renamed from: a, reason: from getter */
        public final int getEnd() {
            return this.end;
        }

        /* renamed from: b, reason: from getter */
        public final int getStart() {
            return this.start;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Cell)) {
                return false;
            }
            Cell cell = (Cell) other;
            return this.start == cell.start && this.end == cell.end;
        }

        public int hashCode() {
            return (Integer.hashCode(this.start) * 31) + Integer.hashCode(this.end);
        }

        public String toString() {
            return "Cell(start=" + this.start + ", end=" + this.end + ")";
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0012\u0010\bR\u0017\u0010\u0013\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/stepos/agentframework/chatui/longtext/LongTextDocument$c;", "", "", "literal", "info", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "getInfo", "markdown", Const.INTENT_KEY_PKGNAME, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.longtext.LongTextDocument$c, reason: from toString */
    public static final /* data */ class CodeBlock {
        private final String info;
        private final String literal;
        private final String markdown;

        public CodeBlock(String literal, String info) {
            Integer numValueOf;
            p.i(literal, "literal");
            p.i(info, "info");
            this.literal = literal;
            this.info = info;
            Iterator it = Regex.f(new Regex("~+"), literal, 0, 2, null).iterator();
            if (it.hasNext()) {
                numValueOf = Integer.valueOf(((m) it.next()).getValue().length());
                while (it.hasNext()) {
                    Integer numValueOf2 = Integer.valueOf(((m) it.next()).getValue().length());
                    if (numValueOf.compareTo(numValueOf2) < 0) {
                        numValueOf = numValueOf2;
                    }
                }
            } else {
                numValueOf = null;
            }
            String strP = D.P("~", Math.max(3, (numValueOf != null ? numValueOf.intValue() : 0) + 1));
            String str = this.info;
            String str2 = this.literal;
            this.markdown = strP + str + "\n" + str2 + ((H.j0(str2, '\n', false, 2, null) || this.literal.length() == 0) ? "" : "\n") + strP;
        }

        /* renamed from: a, reason: from getter */
        public final String getLiteral() {
            return this.literal;
        }

        /* renamed from: b, reason: from getter */
        public final String getMarkdown() {
            return this.markdown;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CodeBlock)) {
                return false;
            }
            CodeBlock codeBlock = (CodeBlock) other;
            return p.d(this.literal, codeBlock.literal) && p.d(this.info, codeBlock.info);
        }

        public int hashCode() {
            return (this.literal.hashCode() * 31) + this.info.hashCode();
        }

        public String toString() {
            return "CodeBlock(literal=" + this.literal + ", info=" + this.info + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ8\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0010R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0017\u0010\u0010R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001b\u001a\u0004\b\u001c\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/stepos/agentframework/chatui/longtext/LongTextDocument$d;", "", "", "start", com.stepos.ailauncher.container.wallpaper.a.PHASE_END, "Lcom/stepos/agentframework/chatui/longtext/LongTextDocument$Kind;", "kind", "", UxipConstants.f30680s, "<init>", "(IILcom/stepos/agentframework/chatui/longtext/LongTextDocument$Kind;Ljava/lang/String;)V", Const.INTENT_KEY_APIKEY, "(IILcom/stepos/agentframework/chatui/longtext/LongTextDocument$Kind;Ljava/lang/String;)Lcom/stepos/agentframework/chatui/longtext/LongTextDocument$d;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "e", "c", "Lcom/stepos/agentframework/chatui/longtext/LongTextDocument$Kind;", Const.INTENT_KEY_UMID, "()Lcom/stepos/agentframework/chatui/longtext/LongTextDocument$Kind;", "Ljava/lang/String;", "f", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.longtext.LongTextDocument$d, reason: from toString */
    public static final /* data */ class Style {
        private final int end;
        private final Kind kind;
        private final int start;
        private final String value;

        public Style(int i10, int i11, Kind kind, String value) {
            p.i(kind, "kind");
            p.i(value, "value");
            this.start = i10;
            this.end = i11;
            this.kind = kind;
            this.value = value;
        }

        public static /* synthetic */ Style b(Style style, int i10, int i11, Kind kind, String str, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i10 = style.start;
            }
            if ((i12 & 2) != 0) {
                i11 = style.end;
            }
            if ((i12 & 4) != 0) {
                kind = style.kind;
            }
            if ((i12 & 8) != 0) {
                str = style.value;
            }
            return style.a(i10, i11, kind, str);
        }

        public final Style a(int start, int end, Kind kind, String value) {
            p.i(kind, "kind");
            p.i(value, "value");
            return new Style(start, end, kind, value);
        }

        /* renamed from: c, reason: from getter */
        public final int getEnd() {
            return this.end;
        }

        /* renamed from: d, reason: from getter */
        public final Kind getKind() {
            return this.kind;
        }

        /* renamed from: e, reason: from getter */
        public final int getStart() {
            return this.start;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Style)) {
                return false;
            }
            Style style = (Style) other;
            return this.start == style.start && this.end == style.end && this.kind == style.kind && p.d(this.value, style.value);
        }

        /* renamed from: f, reason: from getter */
        public final String getValue() {
            return this.value;
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.start) * 31) + Integer.hashCode(this.end)) * 31) + this.kind.hashCode()) * 31) + this.value.hashCode();
        }

        public String toString() {
            return "Style(start=" + this.start + ", end=" + this.end + ", kind=" + this.kind + ", value=" + this.value + ")";
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0011R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u001a\u0010\u0019R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\n\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\n\u0010\u001b\u001a\u0004\b\u001e\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/stepos/agentframework/chatui/longtext/LongTextDocument$e;", "", "", "tableId", "", "Lcom/stepos/agentframework/chatui/longtext/LongTextDocument$b;", "cells", "columnChars", "", "header", "last", "<init>", "(ILjava/util/List;Ljava/util/List;ZZ)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "I", "e", "Ljava/util/List;", Const.INTENT_KEY_APIKEY, "()Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "Z", "c", "()Z", Const.INTENT_KEY_UMID, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.longtext.LongTextDocument$e, reason: from toString */
    public static final /* data */ class TableRow {
        private final List<Cell> cells;
        private final List<Integer> columnChars;
        private final boolean header;
        private final boolean last;
        private final int tableId;

        public TableRow(int i10, List<Cell> cells, List<Integer> columnChars, boolean z10, boolean z11) {
            p.i(cells, "cells");
            p.i(columnChars, "columnChars");
            this.tableId = i10;
            this.cells = cells;
            this.columnChars = columnChars;
            this.header = z10;
            this.last = z11;
        }

        public final List<Cell> a() {
            return this.cells;
        }

        public final List<Integer> b() {
            return this.columnChars;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getHeader() {
            return this.header;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getLast() {
            return this.last;
        }

        /* renamed from: e, reason: from getter */
        public final int getTableId() {
            return this.tableId;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TableRow)) {
                return false;
            }
            TableRow tableRow = (TableRow) other;
            return this.tableId == tableRow.tableId && p.d(this.cells, tableRow.cells) && p.d(this.columnChars, tableRow.columnChars) && this.header == tableRow.header && this.last == tableRow.last;
        }

        public int hashCode() {
            return (((((((Integer.hashCode(this.tableId) * 31) + this.cells.hashCode()) * 31) + this.columnChars.hashCode()) * 31) + Boolean.hashCode(this.header)) * 31) + Boolean.hashCode(this.last);
        }

        public String toString() {
            return "TableRow(tableId=" + this.tableId + ", cells=" + this.cells + ", columnChars=" + this.columnChars + ", header=" + this.header + ", last=" + this.last + ")";
        }
    }

    public LongTextDocument(String text, List<Block> blocks, int i10, String htmlTags) {
        p.i(text, "text");
        p.i(blocks, "blocks");
        p.i(htmlTags, "htmlTags");
        this.text = text;
        this.blocks = blocks;
        this.htmlFragments = i10;
        this.htmlTags = htmlTags;
    }

    public final List<Block> a() {
        return this.blocks;
    }

    /* renamed from: b, reason: from getter */
    public final int getHtmlFragments() {
        return this.htmlFragments;
    }

    /* renamed from: c, reason: from getter */
    public final String getHtmlTags() {
        return this.htmlTags;
    }

    /* renamed from: d, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LongTextDocument)) {
            return false;
        }
        LongTextDocument longTextDocument = (LongTextDocument) other;
        return p.d(this.text, longTextDocument.text) && p.d(this.blocks, longTextDocument.blocks) && this.htmlFragments == longTextDocument.htmlFragments && p.d(this.htmlTags, longTextDocument.htmlTags);
    }

    public int hashCode() {
        return (((((this.text.hashCode() * 31) + this.blocks.hashCode()) * 31) + Integer.hashCode(this.htmlFragments)) * 31) + this.htmlTags.hashCode();
    }

    public String toString() {
        return "LongTextDocument(text=" + this.text + ", blocks=" + this.blocks + ", htmlFragments=" + this.htmlFragments + ", htmlTags=" + this.htmlTags + ")";
    }
}
