package ch.qos.logback.core.pattern.parser;

import ch.qos.logback.core.pattern.util.IEscapeUtil;
import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import ch.qos.logback.core.pattern.util.RestrictedEscapeUtil;
import ch.qos.logback.core.spi.ScanException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.internal.ws.WebSocketProtocol;

/* loaded from: classes.dex */
class TokenStream {
    final IEscapeUtil escapeUtil;
    final IEscapeUtil optionEscapeUtil;
    final String pattern;
    final int patternLength;
    int pointer;
    TokenizerState state;

    /* renamed from: ch.qos.logback.core.pattern.parser.TokenStream$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$ch$qos$logback$core$pattern$parser$TokenStream$TokenizerState;

        static {
            int[] iArr = new int[TokenizerState.values().length];
            $SwitchMap$ch$qos$logback$core$pattern$parser$TokenStream$TokenizerState = iArr;
            try {
                iArr[TokenizerState.LITERAL_STATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$ch$qos$logback$core$pattern$parser$TokenStream$TokenizerState[TokenizerState.FORMAT_MODIFIER_STATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$ch$qos$logback$core$pattern$parser$TokenStream$TokenizerState[TokenizerState.OPTION_STATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$ch$qos$logback$core$pattern$parser$TokenStream$TokenizerState[TokenizerState.KEYWORD_STATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$ch$qos$logback$core$pattern$parser$TokenStream$TokenizerState[TokenizerState.RIGHT_PARENTHESIS_STATE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public enum TokenizerState {
        LITERAL_STATE,
        FORMAT_MODIFIER_STATE,
        KEYWORD_STATE,
        OPTION_STATE,
        RIGHT_PARENTHESIS_STATE
    }

    public TokenStream(String str) {
        this(str, new RegularEscapeUtil());
    }

    private void addValuedToken(int i4, StringBuffer stringBuffer, List<Token> list) {
        if (stringBuffer.length() > 0) {
            list.add(new Token(i4, stringBuffer.toString()));
            stringBuffer.setLength(0);
        }
    }

    private void handleFormatModifierState(char c4, List<Token> list, StringBuffer stringBuffer) {
        if (c4 == '(') {
            addValuedToken(1002, stringBuffer, list);
            list.add(Token.BARE_COMPOSITE_KEYWORD_TOKEN);
            this.state = TokenizerState.LITERAL_STATE;
        } else {
            if (!Character.isJavaIdentifierStart(c4)) {
                stringBuffer.append(c4);
                return;
            }
            addValuedToken(1002, stringBuffer, list);
            this.state = TokenizerState.KEYWORD_STATE;
            stringBuffer.append(c4);
        }
    }

    private void handleKeywordState(char c4, List<Token> list, StringBuffer stringBuffer) {
        if (Character.isJavaIdentifierPart(c4)) {
            stringBuffer.append(c4);
            return;
        }
        if (c4 == '{') {
            addValuedToken(1004, stringBuffer, list);
            this.state = TokenizerState.OPTION_STATE;
            return;
        }
        if (c4 == '(') {
            addValuedToken(WebSocketProtocol.CLOSE_NO_STATUS_CODE, stringBuffer, list);
            this.state = TokenizerState.LITERAL_STATE;
            return;
        }
        if (c4 == '%') {
            addValuedToken(1004, stringBuffer, list);
            list.add(Token.PERCENT_TOKEN);
            this.state = TokenizerState.FORMAT_MODIFIER_STATE;
        } else {
            if (c4 == ')') {
                addValuedToken(1004, stringBuffer, list);
                this.state = TokenizerState.RIGHT_PARENTHESIS_STATE;
                return;
            }
            addValuedToken(1004, stringBuffer, list);
            if (c4 == '\\') {
                int i4 = this.pointer;
                if (i4 < this.patternLength) {
                    String str = this.pattern;
                    this.pointer = i4 + 1;
                    this.escapeUtil.escape("%()", stringBuffer, str.charAt(i4), this.pointer);
                }
            } else {
                stringBuffer.append(c4);
            }
            this.state = TokenizerState.LITERAL_STATE;
        }
    }

    private void handleLiteralState(char c4, List<Token> list, StringBuffer stringBuffer) {
        if (c4 == '%') {
            addValuedToken(1000, stringBuffer, list);
            list.add(Token.PERCENT_TOKEN);
            this.state = TokenizerState.FORMAT_MODIFIER_STATE;
        } else if (c4 == ')') {
            addValuedToken(1000, stringBuffer, list);
            this.state = TokenizerState.RIGHT_PARENTHESIS_STATE;
        } else if (c4 != '\\') {
            stringBuffer.append(c4);
        } else {
            escape("%()", stringBuffer);
        }
    }

    private void handleRightParenthesisState(char c4, List<Token> list, StringBuffer stringBuffer) {
        list.add(Token.RIGHT_PARENTHESIS_TOKEN);
        if (c4 != ')') {
            if (c4 == '\\') {
                escape("%{}", stringBuffer);
                this.state = TokenizerState.LITERAL_STATE;
            } else if (c4 == '{') {
                this.state = TokenizerState.OPTION_STATE;
            } else {
                stringBuffer.append(c4);
                this.state = TokenizerState.LITERAL_STATE;
            }
        }
    }

    private void processOption(char c4, List<Token> list, StringBuffer stringBuffer) throws ScanException {
        new OptionTokenizer(this).tokenize(c4, list);
    }

    public void escape(String str, StringBuffer stringBuffer) {
        int i4 = this.pointer;
        if (i4 < this.patternLength) {
            String str2 = this.pattern;
            this.pointer = i4 + 1;
            this.escapeUtil.escape(str, stringBuffer, str2.charAt(i4), this.pointer);
        }
    }

    public void optionEscape(String str, StringBuffer stringBuffer) {
        int i4 = this.pointer;
        if (i4 < this.patternLength) {
            String str2 = this.pattern;
            this.pointer = i4 + 1;
            this.optionEscapeUtil.escape(str, stringBuffer, str2.charAt(i4), this.pointer);
        }
    }

    public List tokenize() throws ScanException {
        ArrayList arrayList = new ArrayList();
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            int i4 = this.pointer;
            if (i4 >= this.patternLength) {
                break;
            }
            char cCharAt = this.pattern.charAt(i4);
            this.pointer++;
            int i5 = AnonymousClass1.$SwitchMap$ch$qos$logback$core$pattern$parser$TokenStream$TokenizerState[this.state.ordinal()];
            if (i5 == 1) {
                handleLiteralState(cCharAt, arrayList, stringBuffer);
            } else if (i5 == 2) {
                handleFormatModifierState(cCharAt, arrayList, stringBuffer);
            } else if (i5 == 3) {
                processOption(cCharAt, arrayList, stringBuffer);
            } else if (i5 == 4) {
                handleKeywordState(cCharAt, arrayList, stringBuffer);
            } else if (i5 == 5) {
                handleRightParenthesisState(cCharAt, arrayList, stringBuffer);
            }
        }
        int i6 = AnonymousClass1.$SwitchMap$ch$qos$logback$core$pattern$parser$TokenStream$TokenizerState[this.state.ordinal()];
        if (i6 == 1) {
            addValuedToken(1000, stringBuffer, arrayList);
        } else {
            if (i6 == 2 || i6 == 3) {
                throw new ScanException("Unexpected end of pattern string");
            }
            if (i6 == 4) {
                arrayList.add(new Token(1004, stringBuffer.toString()));
            } else if (i6 == 5) {
                arrayList.add(Token.RIGHT_PARENTHESIS_TOKEN);
            }
        }
        return arrayList;
    }

    public TokenStream(String str, IEscapeUtil iEscapeUtil) {
        this.optionEscapeUtil = new RestrictedEscapeUtil();
        this.state = TokenizerState.LITERAL_STATE;
        this.pointer = 0;
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("null or empty pattern string not allowed");
        }
        this.pattern = str;
        this.patternLength = str.length();
        this.escapeUtil = iEscapeUtil;
    }
}
