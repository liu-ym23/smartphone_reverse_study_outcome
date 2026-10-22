package org.yaml.snakeyaml.scanner;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import io.ktor.http.LinkHeader;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.comments.CommentType;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.reader.StreamReader;
import org.yaml.snakeyaml.tokens.AliasToken;
import org.yaml.snakeyaml.tokens.AnchorToken;
import org.yaml.snakeyaml.tokens.BlockEndToken;
import org.yaml.snakeyaml.tokens.BlockEntryToken;
import org.yaml.snakeyaml.tokens.BlockMappingStartToken;
import org.yaml.snakeyaml.tokens.BlockSequenceStartToken;
import org.yaml.snakeyaml.tokens.CommentToken;
import org.yaml.snakeyaml.tokens.DirectiveToken;
import org.yaml.snakeyaml.tokens.DocumentEndToken;
import org.yaml.snakeyaml.tokens.DocumentStartToken;
import org.yaml.snakeyaml.tokens.FlowEntryToken;
import org.yaml.snakeyaml.tokens.FlowMappingEndToken;
import org.yaml.snakeyaml.tokens.FlowMappingStartToken;
import org.yaml.snakeyaml.tokens.FlowSequenceEndToken;
import org.yaml.snakeyaml.tokens.FlowSequenceStartToken;
import org.yaml.snakeyaml.tokens.KeyToken;
import org.yaml.snakeyaml.tokens.ScalarToken;
import org.yaml.snakeyaml.tokens.StreamEndToken;
import org.yaml.snakeyaml.tokens.StreamStartToken;
import org.yaml.snakeyaml.tokens.TagToken;
import org.yaml.snakeyaml.tokens.TagTuple;
import org.yaml.snakeyaml.tokens.Token;
import org.yaml.snakeyaml.tokens.ValueToken;
import org.yaml.snakeyaml.util.ArrayStack;
import org.yaml.snakeyaml.util.UriEncoder;

/* loaded from: classes5.dex */
public final class ScannerImpl implements Scanner {
    public static final Map<Character, Integer> ESCAPE_CODES;
    public static final Map<Character, String> ESCAPE_REPLACEMENTS;
    private static final Pattern NOT_HEXA = Pattern.compile("[^0-9A-Fa-f]");
    private final ArrayStack<Integer> indents;
    private Token lastToken;
    private final LoaderOptions loaderOptions;
    private final boolean parseComments;
    private final Map<Integer, SimpleKey> possibleSimpleKeys;
    private final StreamReader reader;
    private final List<Token> tokens;
    private boolean done = false;
    private int flowLevel = 0;
    private int tokensTaken = 0;
    private int indent = -1;
    private boolean allowSimpleKey = true;

    public static class Chomping {
        private final int increment;
        private final Boolean value;

        public Chomping(Boolean bool, int i10) {
            this.value = bool;
            this.increment = i10;
        }

        public boolean chompTailIsNotFalse() {
            Boolean bool = this.value;
            return bool == null || bool.booleanValue();
        }

        public boolean chompTailIsTrue() {
            Boolean bool = this.value;
            return bool != null && bool.booleanValue();
        }

        public int getIncrement() {
            return this.increment;
        }
    }

    static {
        HashMap map = new HashMap();
        ESCAPE_REPLACEMENTS = map;
        HashMap map2 = new HashMap();
        ESCAPE_CODES = map2;
        map.put('0', "\u0000");
        map.put('a', "\u0007");
        map.put('b', "\b");
        map.put('t', "\t");
        map.put('n', "\n");
        map.put('v', "\u000b");
        map.put('f', "\f");
        map.put('r', "\r");
        map.put('e', "\u001b");
        map.put(' ', " ");
        map.put(Character.valueOf(JsonFactory.DEFAULT_QUOTE_CHAR), "\"");
        map.put('\\', "\\");
        map.put('N', "\u0085");
        map.put('_', " ");
        map.put('L', "\u2028");
        map.put('P', "\u2029");
        map2.put('x', 2);
        map2.put('u', 4);
        map2.put('U', 8);
    }

    public ScannerImpl(StreamReader streamReader, LoaderOptions loaderOptions) {
        if (loaderOptions == null) {
            throw new NullPointerException("LoaderOptions must be provided.");
        }
        this.parseComments = loaderOptions.isProcessComments();
        this.reader = streamReader;
        this.tokens = new ArrayList(100);
        this.indents = new ArrayStack<>(10);
        this.possibleSimpleKeys = new LinkedHashMap();
        this.loaderOptions = loaderOptions;
        fetchStreamStart();
    }

    private void addAllTokens(List<Token> list) {
        this.lastToken = list.get(list.size() - 1);
        this.tokens.addAll(list);
    }

    private boolean addIndent(int i10) {
        int i11 = this.indent;
        if (i11 >= i10) {
            return false;
        }
        this.indents.push(Integer.valueOf(i11));
        this.indent = i10;
        return true;
    }

    private void addToken(Token token) {
        this.lastToken = token;
        this.tokens.add(token);
    }

    private boolean atEndOfPlain() {
        int i10;
        int column = this.reader.getColumn();
        int i11 = 0;
        while (true) {
            int iPeek = this.reader.peek(i11);
            if (iPeek == 0 || !Constant.NULL_BL_T_LINEBR.has(iPeek)) {
                break;
            }
            int i12 = i11 + 1;
            column = (Constant.LINEBR.has(iPeek) || (iPeek == 13 && this.reader.peek(i11 + 2) == 10) || iPeek == 65279) ? 0 : column + 1;
            i11 = i12;
        }
        if (this.reader.peek(i11) == 35 || this.reader.peek(i11 + 1) == 0 || ((i10 = this.flowLevel) == 0 && column < this.indent)) {
            return true;
        }
        if (i10 == 0) {
            int i13 = 1;
            while (true) {
                int i14 = i11 + i13;
                int iPeek2 = this.reader.peek(i14);
                if (iPeek2 == 0) {
                    break;
                }
                Constant constant = Constant.NULL_BL_T_LINEBR;
                if (constant.has(iPeek2)) {
                    break;
                }
                if (iPeek2 == 58 && constant.has(this.reader.peek(i14 + 1))) {
                    return true;
                }
                i13++;
            }
        }
        return false;
    }

    private boolean checkBlockEntry() {
        return Constant.NULL_BL_T_LINEBR.has(this.reader.peek(1));
    }

    private boolean checkDirective() {
        return this.reader.getColumn() == 0;
    }

    private boolean checkDocumentEnd() {
        return this.reader.getColumn() == 0 && "...".equals(this.reader.prefix(3)) && Constant.NULL_BL_T_LINEBR.has(this.reader.peek(3));
    }

    private boolean checkDocumentStart() {
        return this.reader.getColumn() == 0 && "---".equals(this.reader.prefix(3)) && Constant.NULL_BL_T_LINEBR.has(this.reader.peek(3));
    }

    private boolean checkKey() {
        if (this.flowLevel != 0) {
            return true;
        }
        return Constant.NULL_BL_T_LINEBR.has(this.reader.peek(1));
    }

    private boolean checkPlain() {
        int iPeek = this.reader.peek();
        Constant constant = Constant.NULL_BL_T_LINEBR;
        if (!constant.hasNo(iPeek, "-?:,[]{}#&*!|>'\"%@`")) {
            if (!constant.hasNo(this.reader.peek(1))) {
                return false;
            }
            if (iPeek != 45 && (this.flowLevel != 0 || "?:".indexOf(iPeek) == -1)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkValue() {
        if (this.flowLevel != 0) {
            return true;
        }
        return Constant.NULL_BL_T_LINEBR.has(this.reader.peek(1));
    }

    private String escapeChar(String str) {
        for (Character ch : ESCAPE_REPLACEMENTS.keySet()) {
            if (ESCAPE_REPLACEMENTS.get(ch).equals(str)) {
                return "\\" + ch;
            }
        }
        return str;
    }

    private void fetchAlias() {
        savePossibleSimpleKey();
        this.allowSimpleKey = false;
        addToken(scanAnchor(false));
    }

    private void fetchAnchor() {
        savePossibleSimpleKey();
        this.allowSimpleKey = false;
        addToken(scanAnchor(true));
    }

    private void fetchBlockEntry() {
        if (this.flowLevel == 0) {
            if (!this.allowSimpleKey) {
                throw new ScannerException(null, null, "sequence entries are not allowed here", this.reader.getMark());
            }
            if (addIndent(this.reader.getColumn())) {
                Mark mark = this.reader.getMark();
                addToken(new BlockSequenceStartToken(mark, mark));
            }
        }
        this.allowSimpleKey = true;
        removePossibleSimpleKey();
        Mark mark2 = this.reader.getMark();
        this.reader.forward();
        addToken(new BlockEntryToken(mark2, this.reader.getMark()));
    }

    private void fetchBlockScalar(char c10) {
        this.allowSimpleKey = true;
        removePossibleSimpleKey();
        addAllTokens(scanBlockScalar(c10));
    }

    private void fetchDirective() {
        unwindIndent(-1);
        removePossibleSimpleKey();
        this.allowSimpleKey = false;
        addAllTokens(scanDirective());
    }

    private void fetchDocumentEnd() {
        fetchDocumentIndicator(false);
    }

    private void fetchDocumentIndicator(boolean z10) {
        unwindIndent(-1);
        removePossibleSimpleKey();
        this.allowSimpleKey = false;
        Mark mark = this.reader.getMark();
        this.reader.forward(3);
        Mark mark2 = this.reader.getMark();
        addToken(z10 ? new DocumentStartToken(mark, mark2) : new DocumentEndToken(mark, mark2));
    }

    private void fetchDocumentStart() {
        fetchDocumentIndicator(true);
    }

    private void fetchDouble() {
        fetchFlowScalar(JsonFactory.DEFAULT_QUOTE_CHAR);
    }

    private void fetchFlowCollectionEnd(boolean z10) {
        removePossibleSimpleKey();
        this.flowLevel--;
        this.allowSimpleKey = false;
        Mark mark = this.reader.getMark();
        this.reader.forward();
        Mark mark2 = this.reader.getMark();
        addToken(z10 ? new FlowMappingEndToken(mark, mark2) : new FlowSequenceEndToken(mark, mark2));
    }

    private void fetchFlowCollectionStart(boolean z10) {
        savePossibleSimpleKey();
        this.flowLevel++;
        this.allowSimpleKey = true;
        Mark mark = this.reader.getMark();
        this.reader.forward(1);
        Mark mark2 = this.reader.getMark();
        addToken(z10 ? new FlowMappingStartToken(mark, mark2) : new FlowSequenceStartToken(mark, mark2));
    }

    private void fetchFlowEntry() {
        this.allowSimpleKey = true;
        removePossibleSimpleKey();
        Mark mark = this.reader.getMark();
        this.reader.forward();
        addToken(new FlowEntryToken(mark, this.reader.getMark()));
    }

    private void fetchFlowMappingEnd() {
        fetchFlowCollectionEnd(true);
    }

    private void fetchFlowMappingStart() {
        fetchFlowCollectionStart(true);
    }

    private void fetchFlowScalar(char c10) {
        savePossibleSimpleKey();
        this.allowSimpleKey = false;
        addToken(scanFlowScalar(c10));
    }

    private void fetchFlowSequenceEnd() {
        fetchFlowCollectionEnd(false);
    }

    private void fetchFlowSequenceStart() {
        fetchFlowCollectionStart(false);
    }

    private void fetchFolded() {
        fetchBlockScalar('>');
    }

    private void fetchKey() {
        if (this.flowLevel == 0) {
            if (!this.allowSimpleKey) {
                throw new ScannerException(null, null, "mapping keys are not allowed here", this.reader.getMark());
            }
            if (addIndent(this.reader.getColumn())) {
                Mark mark = this.reader.getMark();
                addToken(new BlockMappingStartToken(mark, mark));
            }
        }
        this.allowSimpleKey = this.flowLevel == 0;
        removePossibleSimpleKey();
        Mark mark2 = this.reader.getMark();
        this.reader.forward();
        addToken(new KeyToken(mark2, this.reader.getMark()));
    }

    private void fetchLiteral() {
        fetchBlockScalar('|');
    }

    private void fetchMoreTokens() {
        if (this.reader.getDocumentIndex() > this.loaderOptions.getCodePointLimit()) {
            throw new YAMLException("The incoming YAML document exceeds the limit: " + this.loaderOptions.getCodePointLimit() + " code points.");
        }
        scanToNextToken();
        stalePossibleSimpleKeys();
        unwindIndent(this.reader.getColumn());
        int iPeek = this.reader.peek();
        if (iPeek == 0) {
            fetchStreamEnd();
            return;
        }
        if (iPeek == 42) {
            fetchAlias();
            return;
        }
        if (iPeek != 58) {
            if (iPeek == 91) {
                fetchFlowSequenceStart();
                return;
            }
            if (iPeek == 93) {
                fetchFlowSequenceEnd();
                return;
            }
            if (iPeek == 33) {
                fetchTag();
                return;
            }
            if (iPeek == 34) {
                fetchDouble();
                return;
            }
            if (iPeek != 62) {
                if (iPeek != 63) {
                    switch (iPeek) {
                        case 37:
                            if (checkDirective()) {
                                fetchDirective();
                                return;
                            }
                            break;
                        case 38:
                            fetchAnchor();
                            return;
                        case 39:
                            fetchSingle();
                            return;
                        default:
                            switch (iPeek) {
                                case 44:
                                    fetchFlowEntry();
                                    return;
                                case 45:
                                    if (checkDocumentStart()) {
                                        fetchDocumentStart();
                                        return;
                                    } else if (checkBlockEntry()) {
                                        fetchBlockEntry();
                                        return;
                                    }
                                    break;
                                case 46:
                                    if (checkDocumentEnd()) {
                                        fetchDocumentEnd();
                                        return;
                                    }
                                    break;
                                default:
                                    switch (iPeek) {
                                        case 123:
                                            fetchFlowMappingStart();
                                            return;
                                        case 124:
                                            if (this.flowLevel == 0) {
                                                fetchLiteral();
                                                return;
                                            }
                                            break;
                                        case 125:
                                            fetchFlowMappingEnd();
                                            return;
                                    }
                            }
                    }
                } else if (checkKey()) {
                    fetchKey();
                    return;
                }
            } else if (this.flowLevel == 0) {
                fetchFolded();
                return;
            }
        } else if (checkValue()) {
            fetchValue();
            return;
        }
        if (checkPlain()) {
            fetchPlain();
            return;
        }
        String strEscapeChar = escapeChar(String.valueOf(Character.toChars(iPeek)));
        if (iPeek == 9) {
            strEscapeChar = strEscapeChar + "(TAB)";
        }
        throw new ScannerException("while scanning for the next token", null, String.format("found character '%s' that cannot start any token. (Do not use %s for indentation)", strEscapeChar, strEscapeChar), this.reader.getMark());
    }

    private void fetchPlain() {
        savePossibleSimpleKey();
        this.allowSimpleKey = false;
        addToken(scanPlain());
    }

    private void fetchSingle() {
        fetchFlowScalar('\'');
    }

    private void fetchStreamEnd() {
        unwindIndent(-1);
        removePossibleSimpleKey();
        this.allowSimpleKey = false;
        this.possibleSimpleKeys.clear();
        Mark mark = this.reader.getMark();
        addToken(new StreamEndToken(mark, mark));
        this.done = true;
    }

    private void fetchStreamStart() {
        Mark mark = this.reader.getMark();
        addToken(new StreamStartToken(mark, mark));
    }

    private void fetchTag() {
        savePossibleSimpleKey();
        this.allowSimpleKey = false;
        addToken(scanTag());
    }

    private void fetchValue() {
        SimpleKey simpleKeyRemove = this.possibleSimpleKeys.remove(Integer.valueOf(this.flowLevel));
        if (simpleKeyRemove != null) {
            addToken(simpleKeyRemove.getTokenNumber() - this.tokensTaken, new KeyToken(simpleKeyRemove.getMark(), simpleKeyRemove.getMark()));
            if (this.flowLevel == 0 && addIndent(simpleKeyRemove.getColumn())) {
                addToken(simpleKeyRemove.getTokenNumber() - this.tokensTaken, new BlockMappingStartToken(simpleKeyRemove.getMark(), simpleKeyRemove.getMark()));
            }
            this.allowSimpleKey = false;
        } else {
            int i10 = this.flowLevel;
            if (i10 == 0 && !this.allowSimpleKey) {
                throw new ScannerException(null, null, "mapping values are not allowed here", this.reader.getMark());
            }
            if (i10 == 0 && addIndent(this.reader.getColumn())) {
                Mark mark = this.reader.getMark();
                addToken(new BlockMappingStartToken(mark, mark));
            }
            this.allowSimpleKey = this.flowLevel == 0;
            removePossibleSimpleKey();
        }
        Mark mark2 = this.reader.getMark();
        this.reader.forward();
        addToken(new ValueToken(mark2, this.reader.getMark()));
    }

    private List<Token> makeTokenList(Token... tokenArr) {
        ArrayList arrayList = new ArrayList();
        for (Token token : tokenArr) {
            if (token != null && (this.parseComments || !(token instanceof CommentToken))) {
                arrayList.add(token);
            }
        }
        return arrayList;
    }

    private boolean needMoreTokens() {
        if (this.done) {
            return false;
        }
        if (this.tokens.isEmpty()) {
            return true;
        }
        stalePossibleSimpleKeys();
        return nextPossibleSimpleKey() == this.tokensTaken;
    }

    private int nextPossibleSimpleKey() {
        if (this.possibleSimpleKeys.isEmpty()) {
            return -1;
        }
        return this.possibleSimpleKeys.values().iterator().next().getTokenNumber();
    }

    private void removePossibleSimpleKey() {
        SimpleKey simpleKeyRemove = this.possibleSimpleKeys.remove(Integer.valueOf(this.flowLevel));
        if (simpleKeyRemove != null && simpleKeyRemove.isRequired()) {
            throw new ScannerException("while scanning a simple key", simpleKeyRemove.getMark(), "could not find expected ':'", this.reader.getMark());
        }
    }

    private void savePossibleSimpleKey() {
        boolean z10 = this.flowLevel == 0 && this.indent == this.reader.getColumn();
        boolean z11 = this.allowSimpleKey;
        if (!z11 && z10) {
            throw new YAMLException("A simple key is required only if it is the first token in the current line");
        }
        if (z11) {
            removePossibleSimpleKey();
            this.possibleSimpleKeys.put(Integer.valueOf(this.flowLevel), new SimpleKey(this.tokensTaken + this.tokens.size(), z10, this.reader.getIndex(), this.reader.getLine(), this.reader.getColumn(), this.reader.getMark()));
        }
    }

    private Token scanAnchor(boolean z10) {
        Constant constant;
        Mark mark = this.reader.getMark();
        String str = this.reader.peek() == 42 ? "alias" : LinkHeader.Parameters.Anchor;
        this.reader.forward();
        int i10 = 0;
        int iPeek = this.reader.peek(0);
        while (true) {
            constant = Constant.NULL_BL_T_LINEBR;
            if (!constant.hasNo(iPeek, ":,[]{}/.*&")) {
                break;
            }
            i10++;
            iPeek = this.reader.peek(i10);
        }
        if (i10 == 0) {
            throw new ScannerException("while scanning an " + str, mark, "unexpected character found " + String.valueOf(Character.toChars(iPeek)) + "(" + iPeek + ")", this.reader.getMark());
        }
        String strPrefixForward = this.reader.prefixForward(i10);
        int iPeek2 = this.reader.peek();
        if (!constant.hasNo(iPeek2, "?:,]}%@`")) {
            Mark mark2 = this.reader.getMark();
            return z10 ? new AnchorToken(strPrefixForward, mark, mark2) : new AliasToken(strPrefixForward, mark, mark2);
        }
        throw new ScannerException("while scanning an " + str, mark, "unexpected character found " + String.valueOf(Character.toChars(iPeek2)) + "(" + iPeek2 + ")", this.reader.getMark());
    }

    private List<Token> scanBlockScalar(char c10) throws NumberFormatException {
        int iMax;
        String str;
        Mark mark;
        int i10;
        int i11;
        String str2;
        Mark mark2;
        int i12 = 0;
        int i13 = 1;
        boolean z10 = c10 == '>';
        StringBuilder sb2 = new StringBuilder();
        Mark mark3 = this.reader.getMark();
        this.reader.forward();
        Chomping chompingScanBlockScalarIndicators = scanBlockScalarIndicators(mark3);
        int increment = chompingScanBlockScalarIndicators.getIncrement();
        CommentToken commentTokenScanBlockScalarIgnoredLine = scanBlockScalarIgnoredLine(mark3);
        int i14 = this.indent + 1;
        if (i14 < 1) {
            i14 = 1;
        }
        if (increment == -1) {
            Object[] objArrScanBlockScalarIndentation = scanBlockScalarIndentation();
            str = (String) objArrScanBlockScalarIndentation[0];
            int iIntValue = ((Integer) objArrScanBlockScalarIndentation[1]).intValue();
            mark = (Mark) objArrScanBlockScalarIndentation[2];
            iMax = Math.max(i14, iIntValue);
        } else {
            iMax = (i14 + increment) - 1;
            Object[] objArrScanBlockScalarBreaks = scanBlockScalarBreaks(iMax);
            str = (String) objArrScanBlockScalarBreaks[0];
            mark = (Mark) objArrScanBlockScalarBreaks[1];
        }
        String strScanLineBreak = "";
        while (this.reader.getColumn() == iMax && this.reader.peek() != 0) {
            sb2.append(str);
            int i15 = " \t".indexOf(this.reader.peek()) == -1 ? i13 : i12;
            int i16 = i12;
            while (true) {
                i10 = i12;
                if (!Constant.NULL_OR_LINEBR.hasNo(this.reader.peek(i16))) {
                    break;
                }
                i16++;
                i12 = i10;
            }
            sb2.append(this.reader.prefixForward(i16));
            strScanLineBreak = scanLineBreak();
            Object[] objArrScanBlockScalarBreaks2 = scanBlockScalarBreaks(iMax);
            str2 = (String) objArrScanBlockScalarBreaks2[i10];
            Mark mark4 = (Mark) objArrScanBlockScalarBreaks2[i13];
            i11 = i13;
            if (this.reader.getColumn() != iMax || this.reader.peek() == 0) {
                mark2 = mark4;
                break;
            }
            if (!z10 || !"\n".equals(strScanLineBreak) || i15 == 0 || " \t".indexOf(this.reader.peek()) != -1) {
                sb2.append(strScanLineBreak);
            } else if (str2.isEmpty()) {
                sb2.append(' ');
            }
            mark = mark4;
            str = str2;
            i12 = i10;
            i13 = i11;
        }
        i10 = i12;
        i11 = i13;
        str2 = str;
        mark2 = mark;
        if (chompingScanBlockScalarIndicators.chompTailIsNotFalse()) {
            sb2.append(strScanLineBreak);
        }
        if (chompingScanBlockScalarIndicators.chompTailIsTrue()) {
            sb2.append(str2);
        }
        ScalarToken scalarToken = new ScalarToken(sb2.toString(), false, mark3, mark2, DumperOptions.ScalarStyle.createStyle(Character.valueOf(c10)));
        Token[] tokenArr = new Token[2];
        tokenArr[i10] = commentTokenScanBlockScalarIgnoredLine;
        tokenArr[i11] = scalarToken;
        return makeTokenList(tokenArr);
    }

    private Object[] scanBlockScalarBreaks(int i10) {
        StringBuilder sb2 = new StringBuilder();
        Mark mark = this.reader.getMark();
        for (int column = this.reader.getColumn(); column < i10 && this.reader.peek() == 32; column++) {
            this.reader.forward();
        }
        while (true) {
            String strScanLineBreak = scanLineBreak();
            if (strScanLineBreak.isEmpty()) {
                return new Object[]{sb2.toString(), mark};
            }
            sb2.append(strScanLineBreak);
            mark = this.reader.getMark();
            for (int column2 = this.reader.getColumn(); column2 < i10 && this.reader.peek() == 32; column2++) {
                this.reader.forward();
            }
        }
    }

    private CommentToken scanBlockScalarIgnoredLine(Mark mark) {
        while (this.reader.peek() == 32) {
            this.reader.forward();
        }
        CommentToken commentTokenScanComment = this.reader.peek() == 35 ? scanComment(CommentType.IN_LINE) : null;
        int iPeek = this.reader.peek();
        if (!scanLineBreak().isEmpty() || iPeek == 0) {
            return commentTokenScanComment;
        }
        throw new ScannerException("while scanning a block scalar", mark, "expected a comment or a line break, but found " + String.valueOf(Character.toChars(iPeek)) + "(" + iPeek + ")", this.reader.getMark());
    }

    private Object[] scanBlockScalarIndentation() {
        StringBuilder sb2 = new StringBuilder();
        Mark mark = this.reader.getMark();
        int column = 0;
        while (Constant.LINEBR.has(this.reader.peek(), " \r")) {
            if (this.reader.peek() != 32) {
                sb2.append(scanLineBreak());
                mark = this.reader.getMark();
            } else {
                this.reader.forward();
                if (this.reader.getColumn() > column) {
                    column = this.reader.getColumn();
                }
            }
        }
        return new Object[]{sb2.toString(), Integer.valueOf(column), mark};
    }

    private Chomping scanBlockScalarIndicators(Mark mark) throws NumberFormatException {
        Boolean bool;
        int iPeek = this.reader.peek();
        int i10 = -1;
        if (iPeek == 45 || iPeek == 43) {
            bool = iPeek == 43 ? Boolean.TRUE : Boolean.FALSE;
            this.reader.forward();
            int iPeek2 = this.reader.peek();
            if (Character.isDigit(iPeek2)) {
                i10 = Integer.parseInt(String.valueOf(Character.toChars(iPeek2)));
                if (i10 == 0) {
                    throw new ScannerException("while scanning a block scalar", mark, "expected indentation indicator in the range 1-9, but found 0", this.reader.getMark());
                }
                this.reader.forward();
            }
        } else {
            bool = null;
            if (Character.isDigit(iPeek)) {
                i10 = Integer.parseInt(String.valueOf(Character.toChars(iPeek)));
                if (i10 == 0) {
                    throw new ScannerException("while scanning a block scalar", mark, "expected indentation indicator in the range 1-9, but found 0", this.reader.getMark());
                }
                this.reader.forward();
                int iPeek3 = this.reader.peek();
                if (iPeek3 == 45 || iPeek3 == 43) {
                    bool = iPeek3 == 43 ? Boolean.TRUE : Boolean.FALSE;
                    this.reader.forward();
                }
            }
        }
        int iPeek4 = this.reader.peek();
        if (!Constant.NULL_BL_LINEBR.hasNo(iPeek4)) {
            return new Chomping(bool, i10);
        }
        throw new ScannerException("while scanning a block scalar", mark, "expected chomping or indentation indicators, but found " + String.valueOf(Character.toChars(iPeek4)) + "(" + iPeek4 + ")", this.reader.getMark());
    }

    private CommentToken scanComment(CommentType commentType) {
        Mark mark = this.reader.getMark();
        this.reader.forward();
        int i10 = 0;
        while (Constant.NULL_OR_LINEBR.hasNo(this.reader.peek(i10))) {
            i10++;
        }
        return new CommentToken(commentType, this.reader.prefixForward(i10), mark, this.reader.getMark());
    }

    private List<Token> scanDirective() {
        Mark mark;
        List listScanTagDirectiveValue;
        Mark mark2 = this.reader.getMark();
        this.reader.forward();
        String strScanDirectiveName = scanDirectiveName(mark2);
        if (YAMLFactory.FORMAT_NAME_YAML.equals(strScanDirectiveName)) {
            listScanTagDirectiveValue = scanYamlDirectiveValue(mark2);
            mark = this.reader.getMark();
        } else if ("TAG".equals(strScanDirectiveName)) {
            listScanTagDirectiveValue = scanTagDirectiveValue(mark2);
            mark = this.reader.getMark();
        } else {
            mark = this.reader.getMark();
            int i10 = 0;
            while (Constant.NULL_OR_LINEBR.hasNo(this.reader.peek(i10))) {
                i10++;
            }
            if (i10 > 0) {
                this.reader.forward(i10);
            }
            listScanTagDirectiveValue = null;
        }
        return makeTokenList(new DirectiveToken(strScanDirectiveName, listScanTagDirectiveValue, mark2, mark), scanDirectiveIgnoredLine(mark2));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private org.yaml.snakeyaml.tokens.CommentToken scanDirectiveIgnoredLine(org.yaml.snakeyaml.error.Mark r6) {
        /*
            r5 = this;
        L0:
            org.yaml.snakeyaml.reader.StreamReader r0 = r5.reader
            int r0 = r0.peek()
            r1 = 32
            if (r0 != r1) goto L10
            org.yaml.snakeyaml.reader.StreamReader r0 = r5.reader
            r0.forward()
            goto L0
        L10:
            org.yaml.snakeyaml.reader.StreamReader r0 = r5.reader
            int r0 = r0.peek()
            r1 = 35
            if (r0 != r1) goto L25
            org.yaml.snakeyaml.comments.CommentType r0 = org.yaml.snakeyaml.comments.CommentType.IN_LINE
            org.yaml.snakeyaml.tokens.CommentToken r0 = r5.scanComment(r0)
            boolean r1 = r5.parseComments
            if (r1 == 0) goto L25
            goto L26
        L25:
            r0 = 0
        L26:
            org.yaml.snakeyaml.reader.StreamReader r1 = r5.reader
            int r1 = r1.peek()
            java.lang.String r2 = r5.scanLineBreak()
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L6d
            if (r1 != 0) goto L39
            goto L6d
        L39:
            char[] r0 = java.lang.Character.toChars(r1)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            org.yaml.snakeyaml.scanner.ScannerException r2 = new org.yaml.snakeyaml.scanner.ScannerException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "expected a comment or a line break, but found "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = "("
            r3.append(r0)
            r3.append(r1)
            java.lang.String r0 = ")"
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            org.yaml.snakeyaml.reader.StreamReader r5 = r5.reader
            org.yaml.snakeyaml.error.Mark r5 = r5.getMark()
            java.lang.String r1 = "while scanning a directive"
            r2.<init>(r1, r6, r0, r5)
            throw r2
        L6d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.yaml.snakeyaml.scanner.ScannerImpl.scanDirectiveIgnoredLine(org.yaml.snakeyaml.error.Mark):org.yaml.snakeyaml.tokens.CommentToken");
    }

    private String scanDirectiveName(Mark mark) {
        int i10 = 0;
        int iPeek = this.reader.peek(0);
        while (Constant.ALPHA.has(iPeek)) {
            i10++;
            iPeek = this.reader.peek(i10);
        }
        if (i10 == 0) {
            throw new ScannerException("while scanning a directive", mark, "expected alphabetic or numeric character, but found " + String.valueOf(Character.toChars(iPeek)) + "(" + iPeek + ")", this.reader.getMark());
        }
        String strPrefixForward = this.reader.prefixForward(i10);
        int iPeek2 = this.reader.peek();
        if (!Constant.NULL_BL_LINEBR.hasNo(iPeek2)) {
            return strPrefixForward;
        }
        throw new ScannerException("while scanning a directive", mark, "expected alphabetic or numeric character, but found " + String.valueOf(Character.toChars(iPeek2)) + "(" + iPeek2 + ")", this.reader.getMark());
    }

    private Token scanFlowScalar(char c10) {
        boolean z10 = c10 == '\"';
        StringBuilder sb2 = new StringBuilder();
        Mark mark = this.reader.getMark();
        int iPeek = this.reader.peek();
        this.reader.forward();
        scanFlowScalarNonSpaces(z10, mark, sb2);
        while (this.reader.peek() != iPeek) {
            scanFlowScalarSpaces(mark, sb2);
            scanFlowScalarNonSpaces(z10, mark, sb2);
        }
        this.reader.forward();
        return new ScalarToken(sb2.toString(), false, mark, this.reader.getMark(), DumperOptions.ScalarStyle.createStyle(Character.valueOf(c10)));
    }

    private String scanFlowScalarBreaks(Mark mark) {
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            String strPrefix = this.reader.prefix(3);
            if (("---".equals(strPrefix) || "...".equals(strPrefix)) && Constant.NULL_BL_T_LINEBR.has(this.reader.peek(3))) {
                throw new ScannerException("while scanning a quoted scalar", mark, "found unexpected document separator", this.reader.getMark());
            }
            while (" \t".indexOf(this.reader.peek()) != -1) {
                this.reader.forward();
            }
            String strScanLineBreak = scanLineBreak();
            if (strScanLineBreak.isEmpty()) {
                return sb2.toString();
            }
            sb2.append(strScanLineBreak);
        }
    }

    private void scanFlowScalarNonSpaces(boolean z10, Mark mark, StringBuilder sb2) {
        while (true) {
            int i10 = 0;
            while (Constant.NULL_BL_T_LINEBR.hasNo(this.reader.peek(i10), "'\"\\")) {
                i10++;
            }
            if (i10 != 0) {
                sb2.append(this.reader.prefixForward(i10));
            }
            int iPeek = this.reader.peek();
            if (!z10 && iPeek == 39 && this.reader.peek(1) == 39) {
                sb2.append('\'');
                this.reader.forward(2);
            } else if ((z10 && iPeek == 39) || (!z10 && "\"\\".indexOf(iPeek) != -1)) {
                sb2.appendCodePoint(iPeek);
                this.reader.forward();
            } else {
                if (!z10 || iPeek != 92) {
                    return;
                }
                this.reader.forward();
                int iPeek2 = this.reader.peek();
                if (!Character.isSupplementaryCodePoint(iPeek2)) {
                    Map<Character, String> map = ESCAPE_REPLACEMENTS;
                    char c10 = (char) iPeek2;
                    if (map.containsKey(Character.valueOf(c10))) {
                        sb2.append(map.get(Character.valueOf(c10)));
                        this.reader.forward();
                    }
                }
                if (!Character.isSupplementaryCodePoint(iPeek2)) {
                    Map<Character, Integer> map2 = ESCAPE_CODES;
                    char c11 = (char) iPeek2;
                    if (map2.containsKey(Character.valueOf(c11))) {
                        int iIntValue = map2.get(Character.valueOf(c11)).intValue();
                        this.reader.forward();
                        String strPrefix = this.reader.prefix(iIntValue);
                        if (NOT_HEXA.matcher(strPrefix).find()) {
                            throw new ScannerException("while scanning a double-quoted scalar", mark, "expected escape sequence of " + iIntValue + " hexadecimal numbers, but found: " + strPrefix, this.reader.getMark());
                        }
                        try {
                            sb2.appendCodePoint(Integer.parseInt(strPrefix, 16));
                            this.reader.forward(iIntValue);
                        } catch (IllegalArgumentException unused) {
                            throw new ScannerException("while scanning a double-quoted scalar", mark, "found unknown escape character " + strPrefix, this.reader.getMark());
                        }
                    }
                }
                if (scanLineBreak().isEmpty()) {
                    throw new ScannerException("while scanning a double-quoted scalar", mark, "found unknown escape character " + String.valueOf(Character.toChars(iPeek2)) + "(" + iPeek2 + ")", this.reader.getMark());
                }
                sb2.append(scanFlowScalarBreaks(mark));
            }
        }
    }

    private void scanFlowScalarSpaces(Mark mark, StringBuilder sb2) {
        int i10 = 0;
        while (" \t".indexOf(this.reader.peek(i10)) != -1) {
            i10++;
        }
        String strPrefixForward = this.reader.prefixForward(i10);
        if (this.reader.peek() == 0) {
            throw new ScannerException("while scanning a quoted scalar", mark, "found unexpected end of stream", this.reader.getMark());
        }
        String strScanLineBreak = scanLineBreak();
        if (strScanLineBreak.isEmpty()) {
            sb2.append(strPrefixForward);
            return;
        }
        String strScanFlowScalarBreaks = scanFlowScalarBreaks(mark);
        if (!"\n".equals(strScanLineBreak)) {
            sb2.append(strScanLineBreak);
        } else if (strScanFlowScalarBreaks.isEmpty()) {
            sb2.append(' ');
        }
        sb2.append(strScanFlowScalarBreaks);
    }

    private String scanLineBreak() {
        int iPeek = this.reader.peek();
        if (iPeek != 13 && iPeek != 10 && iPeek != 133) {
            if (iPeek != 8232 && iPeek != 8233) {
                return "";
            }
            this.reader.forward();
            return String.valueOf(Character.toChars(iPeek));
        }
        if (iPeek == 13 && 10 == this.reader.peek(1)) {
            this.reader.forward(2);
            return "\n";
        }
        this.reader.forward();
        return "\n";
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private org.yaml.snakeyaml.tokens.Token scanPlain() {
        /*
            r14 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            org.yaml.snakeyaml.reader.StreamReader r1 = r14.reader
            org.yaml.snakeyaml.error.Mark r1 = r1.getMark()
            int r2 = r14.indent
            r3 = 1
            int r2 = r2 + r3
            java.lang.String r4 = ""
            r6 = r1
            r5 = r4
        L13:
            org.yaml.snakeyaml.reader.StreamReader r7 = r14.reader
            int r7 = r7.peek()
            r8 = 35
            if (r7 != r8) goto L1f
            goto L8f
        L1f:
            r7 = 0
            r9 = r7
        L21:
            org.yaml.snakeyaml.reader.StreamReader r10 = r14.reader
            int r10 = r10.peek(r9)
            org.yaml.snakeyaml.scanner.Constant r11 = org.yaml.snakeyaml.scanner.Constant.NULL_BL_T_LINEBR
            boolean r12 = r11.has(r10)
            if (r12 != 0) goto L5a
            r12 = 58
            if (r10 != r12) goto L49
            org.yaml.snakeyaml.reader.StreamReader r12 = r14.reader
            int r13 = r9 + 1
            int r12 = r12.peek(r13)
            int r13 = r14.flowLevel
            if (r13 == 0) goto L42
            java.lang.String r13 = ",[]{}"
            goto L43
        L42:
            r13 = r4
        L43:
            boolean r11 = r11.has(r12, r13)
            if (r11 != 0) goto L5a
        L49:
            int r11 = r14.flowLevel
            if (r11 == 0) goto L57
            java.lang.String r11 = ",?[]{}"
            int r10 = r11.indexOf(r10)
            r11 = -1
            if (r10 == r11) goto L57
            goto L5a
        L57:
            int r9 = r9 + 1
            goto L21
        L5a:
            if (r9 != 0) goto L5d
            goto L8f
        L5d:
            r14.allowSimpleKey = r7
            r0.append(r5)
            org.yaml.snakeyaml.reader.StreamReader r5 = r14.reader
            java.lang.String r5 = r5.prefixForward(r9)
            r0.append(r5)
            org.yaml.snakeyaml.reader.StreamReader r5 = r14.reader
            org.yaml.snakeyaml.error.Mark r6 = r5.getMark()
            java.lang.String r5 = r14.scanPlainSpaces()
            boolean r7 = r5.isEmpty()
            if (r7 != 0) goto L8f
            org.yaml.snakeyaml.reader.StreamReader r7 = r14.reader
            int r7 = r7.peek()
            if (r7 == r8) goto L8f
            int r7 = r14.flowLevel
            if (r7 != 0) goto L13
            org.yaml.snakeyaml.reader.StreamReader r7 = r14.reader
            int r7 = r7.getColumn()
            if (r7 >= r2) goto L13
        L8f:
            org.yaml.snakeyaml.tokens.ScalarToken r14 = new org.yaml.snakeyaml.tokens.ScalarToken
            java.lang.String r0 = r0.toString()
            r14.<init>(r0, r1, r6, r3)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: org.yaml.snakeyaml.scanner.ScannerImpl.scanPlain():org.yaml.snakeyaml.tokens.Token");
    }

    private String scanPlainSpaces() {
        int i10 = 0;
        while (true) {
            if (this.reader.peek(i10) != 32 && this.reader.peek(i10) != 9) {
                break;
            }
            i10++;
        }
        String strPrefixForward = this.reader.prefixForward(i10);
        String strScanLineBreak = scanLineBreak();
        if (strScanLineBreak.isEmpty()) {
            return strPrefixForward;
        }
        this.allowSimpleKey = true;
        String strPrefix = this.reader.prefix(3);
        if ("---".equals(strPrefix) || ("...".equals(strPrefix) && Constant.NULL_BL_T_LINEBR.has(this.reader.peek(3)))) {
            return "";
        }
        if (this.parseComments && atEndOfPlain()) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            if (this.reader.peek() == 32) {
                this.reader.forward();
            } else {
                String strScanLineBreak2 = scanLineBreak();
                if (strScanLineBreak2.isEmpty()) {
                    if ("\n".equals(strScanLineBreak)) {
                        return sb2.length() == 0 ? " " : sb2.toString();
                    }
                    return strScanLineBreak + ((Object) sb2);
                }
                sb2.append(strScanLineBreak2);
                String strPrefix2 = this.reader.prefix(3);
                if ("---".equals(strPrefix2) || ("...".equals(strPrefix2) && Constant.NULL_BL_T_LINEBR.has(this.reader.peek(3)))) {
                    break;
                }
            }
        }
        return "";
    }

    private Token scanTag() {
        String strScanTagUri;
        Mark mark = this.reader.getMark();
        int iPeek = this.reader.peek(1);
        String strScanTagHandle = null;
        if (iPeek == 60) {
            this.reader.forward(2);
            strScanTagUri = scanTagUri("tag", mark);
            int iPeek2 = this.reader.peek();
            if (iPeek2 != 62) {
                throw new ScannerException("while scanning a tag", mark, "expected '>', but found '" + String.valueOf(Character.toChars(iPeek2)) + "' (" + iPeek2 + ")", this.reader.getMark());
            }
            this.reader.forward();
        } else if (Constant.NULL_BL_T_LINEBR.has(iPeek)) {
            this.reader.forward();
            strScanTagUri = "!";
        } else {
            int i10 = 1;
            while (true) {
                if (!Constant.NULL_BL_LINEBR.hasNo(iPeek)) {
                    this.reader.forward();
                    strScanTagHandle = "!";
                    break;
                }
                if (iPeek == 33) {
                    strScanTagHandle = scanTagHandle("tag", mark);
                    break;
                }
                i10++;
                iPeek = this.reader.peek(i10);
            }
            strScanTagUri = scanTagUri("tag", mark);
        }
        int iPeek3 = this.reader.peek();
        if (!Constant.NULL_BL_LINEBR.hasNo(iPeek3)) {
            return new TagToken(new TagTuple(strScanTagHandle, strScanTagUri), mark, this.reader.getMark());
        }
        throw new ScannerException("while scanning a tag", mark, "expected ' ', but found '" + String.valueOf(Character.toChars(iPeek3)) + "' (" + iPeek3 + ")", this.reader.getMark());
    }

    private String scanTagDirectiveHandle(Mark mark) {
        String strScanTagHandle = scanTagHandle("directive", mark);
        int iPeek = this.reader.peek();
        if (iPeek == 32) {
            return strScanTagHandle;
        }
        throw new ScannerException("while scanning a directive", mark, "expected ' ', but found " + String.valueOf(Character.toChars(iPeek)) + "(" + iPeek + ")", this.reader.getMark());
    }

    private String scanTagDirectivePrefix(Mark mark) {
        String strScanTagUri = scanTagUri("directive", mark);
        int iPeek = this.reader.peek();
        if (!Constant.NULL_BL_LINEBR.hasNo(iPeek)) {
            return strScanTagUri;
        }
        throw new ScannerException("while scanning a directive", mark, "expected ' ', but found " + String.valueOf(Character.toChars(iPeek)) + "(" + iPeek + ")", this.reader.getMark());
    }

    private List<String> scanTagDirectiveValue(Mark mark) {
        while (this.reader.peek() == 32) {
            this.reader.forward();
        }
        String strScanTagDirectiveHandle = scanTagDirectiveHandle(mark);
        while (this.reader.peek() == 32) {
            this.reader.forward();
        }
        String strScanTagDirectivePrefix = scanTagDirectivePrefix(mark);
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(strScanTagDirectiveHandle);
        arrayList.add(strScanTagDirectivePrefix);
        return arrayList;
    }

    private String scanTagHandle(String str, Mark mark) {
        int iPeek = this.reader.peek();
        if (iPeek != 33) {
            throw new ScannerException("while scanning a " + str, mark, "expected '!', but found " + String.valueOf(Character.toChars(iPeek)) + "(" + iPeek + ")", this.reader.getMark());
        }
        int i10 = 1;
        int iPeek2 = this.reader.peek(1);
        if (iPeek2 != 32) {
            int i11 = 1;
            while (Constant.ALPHA.has(iPeek2)) {
                i11++;
                iPeek2 = this.reader.peek(i11);
            }
            if (iPeek2 != 33) {
                this.reader.forward(i11);
                throw new ScannerException("while scanning a " + str, mark, "expected '!', but found " + String.valueOf(Character.toChars(iPeek2)) + "(" + iPeek2 + ")", this.reader.getMark());
            }
            i10 = 1 + i11;
        }
        return this.reader.prefixForward(i10);
    }

    private String scanTagUri(String str, Mark mark) {
        StringBuilder sb2 = new StringBuilder();
        int iPeek = this.reader.peek(0);
        int i10 = 0;
        while (Constant.URI_CHARS.has(iPeek)) {
            if (iPeek == 37) {
                sb2.append(this.reader.prefixForward(i10));
                sb2.append(scanUriEscapes(str, mark));
                i10 = 0;
            } else {
                i10++;
            }
            iPeek = this.reader.peek(i10);
        }
        if (i10 != 0) {
            sb2.append(this.reader.prefixForward(i10));
        }
        if (sb2.length() != 0) {
            return sb2.toString();
        }
        throw new ScannerException("while scanning a " + str, mark, "expected URI, but found " + String.valueOf(Character.toChars(iPeek)) + "(" + iPeek + ")", this.reader.getMark());
    }

    private void scanToNextToken() {
        boolean z10;
        CommentType commentType;
        int column;
        Token token;
        if (this.reader.getIndex() == 0 && this.reader.peek() == 65279) {
            this.reader.forward();
        }
        int i10 = -1;
        boolean z11 = false;
        while (!z11) {
            Mark mark = this.reader.getMark();
            int column2 = this.reader.getColumn();
            int i11 = 0;
            while (this.reader.peek(i11) == 32) {
                i11++;
            }
            if (i11 > 0) {
                this.reader.forward(i11);
            }
            if (this.reader.peek() == 35) {
                if (column2 != 0 && ((token = this.lastToken) == null || token.getTokenId() != Token.ID.BlockEntry)) {
                    commentType = CommentType.IN_LINE;
                    column = this.reader.getColumn();
                } else if (i10 == this.reader.getColumn()) {
                    column = i10;
                    commentType = CommentType.IN_LINE;
                } else {
                    commentType = CommentType.BLOCK;
                    column = -1;
                }
                CommentToken commentTokenScanComment = scanComment(commentType);
                if (this.parseComments) {
                    addToken(commentTokenScanComment);
                }
                i10 = column;
                z10 = true;
            } else {
                z10 = false;
            }
            String strScanLineBreak = scanLineBreak();
            if (strScanLineBreak.isEmpty()) {
                z11 = true;
            } else {
                if (this.parseComments && !z10 && column2 == 0) {
                    addToken(new CommentToken(CommentType.BLANK_LINE, strScanLineBreak, mark, this.reader.getMark()));
                }
                if (this.flowLevel == 0) {
                    this.allowSimpleKey = true;
                }
            }
        }
    }

    private String scanUriEscapes(String str, Mark mark) {
        int i10 = 1;
        while (this.reader.peek(i10 * 3) == 37) {
            i10++;
        }
        Mark mark2 = this.reader.getMark();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i10);
        while (this.reader.peek() == 37) {
            this.reader.forward();
            try {
                byteBufferAllocate.put((byte) Integer.parseInt(this.reader.prefix(2), 16));
                this.reader.forward(2);
            } catch (NumberFormatException unused) {
                int iPeek = this.reader.peek();
                String strValueOf = String.valueOf(Character.toChars(iPeek));
                int iPeek2 = this.reader.peek(1);
                throw new ScannerException("while scanning a " + str, mark, "expected URI escape sequence of 2 hexadecimal numbers, but found " + strValueOf + "(" + iPeek + ") and " + String.valueOf(Character.toChars(iPeek2)) + "(" + iPeek2 + ")", this.reader.getMark());
            }
        }
        byteBufferAllocate.flip();
        try {
            return UriEncoder.decode(byteBufferAllocate);
        } catch (CharacterCodingException e10) {
            throw new ScannerException("while scanning a " + str, mark, "expected URI in UTF-8: " + e10.getMessage(), mark2);
        }
    }

    private Integer scanYamlDirectiveNumber(Mark mark) {
        int iPeek = this.reader.peek();
        if (!Character.isDigit(iPeek)) {
            throw new ScannerException("while scanning a directive", mark, "expected a digit, but found " + String.valueOf(Character.toChars(iPeek)) + "(" + iPeek + ")", this.reader.getMark());
        }
        int i10 = 0;
        while (Character.isDigit(this.reader.peek(i10))) {
            i10++;
        }
        String strPrefixForward = this.reader.prefixForward(i10);
        if (i10 <= 3) {
            return Integer.valueOf(Integer.parseInt(strPrefixForward));
        }
        throw new ScannerException("while scanning a YAML directive", mark, "found a number which cannot represent a valid version: " + strPrefixForward, this.reader.getMark());
    }

    private List<Integer> scanYamlDirectiveValue(Mark mark) {
        while (this.reader.peek() == 32) {
            this.reader.forward();
        }
        Integer numScanYamlDirectiveNumber = scanYamlDirectiveNumber(mark);
        int iPeek = this.reader.peek();
        if (iPeek != 46) {
            throw new ScannerException("while scanning a directive", mark, "expected a digit or '.', but found " + String.valueOf(Character.toChars(iPeek)) + "(" + iPeek + ")", this.reader.getMark());
        }
        this.reader.forward();
        Integer numScanYamlDirectiveNumber2 = scanYamlDirectiveNumber(mark);
        int iPeek2 = this.reader.peek();
        if (!Constant.NULL_BL_LINEBR.hasNo(iPeek2)) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(numScanYamlDirectiveNumber);
            arrayList.add(numScanYamlDirectiveNumber2);
            return arrayList;
        }
        throw new ScannerException("while scanning a directive", mark, "expected a digit or ' ', but found " + String.valueOf(Character.toChars(iPeek2)) + "(" + iPeek2 + ")", this.reader.getMark());
    }

    private void stalePossibleSimpleKeys() {
        if (this.possibleSimpleKeys.isEmpty()) {
            return;
        }
        Iterator<SimpleKey> it = this.possibleSimpleKeys.values().iterator();
        while (it.hasNext()) {
            SimpleKey next = it.next();
            if (next.getLine() != this.reader.getLine() || this.reader.getIndex() - next.getIndex() > 1024) {
                if (next.isRequired()) {
                    throw new ScannerException("while scanning a simple key", next.getMark(), "could not find expected ':'", this.reader.getMark());
                }
                it.remove();
            }
        }
    }

    private void unwindIndent(int i10) {
        if (this.flowLevel != 0) {
            return;
        }
        while (this.indent > i10) {
            Mark mark = this.reader.getMark();
            this.indent = this.indents.pop().intValue();
            addToken(new BlockEndToken(mark, mark));
        }
    }

    @Override // org.yaml.snakeyaml.scanner.Scanner
    public boolean checkToken(Token.ID id) {
        while (needMoreTokens()) {
            fetchMoreTokens();
        }
        return !this.tokens.isEmpty() && this.tokens.get(0).getTokenId() == id;
    }

    @Override // org.yaml.snakeyaml.scanner.Scanner
    public Token getToken() {
        this.tokensTaken++;
        return this.tokens.remove(0);
    }

    @Override // org.yaml.snakeyaml.scanner.Scanner
    public Token peekToken() {
        while (needMoreTokens()) {
            fetchMoreTokens();
        }
        return this.tokens.get(0);
    }

    @Override // org.yaml.snakeyaml.scanner.Scanner
    public void resetDocumentIndex() {
        this.reader.resetDocumentIndex();
    }

    private void addToken(int i10, Token token) {
        if (i10 == this.tokens.size()) {
            this.lastToken = token;
        }
        this.tokens.add(i10, token);
    }

    @Override // org.yaml.snakeyaml.scanner.Scanner
    public boolean checkToken(Token.ID... idArr) {
        while (needMoreTokens()) {
            fetchMoreTokens();
        }
        if (!this.tokens.isEmpty()) {
            if (idArr.length == 0) {
                return true;
            }
            Token.ID tokenId = this.tokens.get(0).getTokenId();
            for (Token.ID id : idArr) {
                if (tokenId == id) {
                    return true;
                }
            }
        }
        return false;
    }
}
