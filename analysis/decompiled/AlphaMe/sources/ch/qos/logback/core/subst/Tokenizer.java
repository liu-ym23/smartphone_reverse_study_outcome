package ch.qos.logback.core.subst;

import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.spi.ScanException;
import ch.qos.logback.core.subst.Token;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class Tokenizer {
    final String pattern;
    final int patternLength;
    TokenizerState state = TokenizerState.LITERAL_STATE;
    int pointer = 0;

    /* renamed from: ch.qos.logback.core.subst.Tokenizer$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$ch$qos$logback$core$subst$Tokenizer$TokenizerState;

        static {
            int[] iArr = new int[TokenizerState.values().length];
            $SwitchMap$ch$qos$logback$core$subst$Tokenizer$TokenizerState = iArr;
            try {
                iArr[TokenizerState.LITERAL_STATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$ch$qos$logback$core$subst$Tokenizer$TokenizerState[TokenizerState.START_STATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$ch$qos$logback$core$subst$Tokenizer$TokenizerState[TokenizerState.DEFAULT_VAL_STATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum TokenizerState {
        LITERAL_STATE,
        START_STATE,
        DEFAULT_VAL_STATE
    }

    public Tokenizer(String str) {
        this.pattern = str;
        this.patternLength = str.length();
    }

    private void addLiteralToken(List<Token> list, StringBuilder sb) {
        if (sb.length() == 0) {
            return;
        }
        list.add(new Token(Token.Type.LITERAL, sb.toString()));
    }

    private void handleDefaultValueState(char c4, List<Token> list, StringBuilder sb) {
        if (c4 == '$') {
            sb.append(CoreConstants.COLON_CHAR);
            addLiteralToken(list, sb);
            sb.setLength(0);
            this.state = TokenizerState.START_STATE;
            return;
        }
        if (c4 == '-') {
            list.add(Token.DEFAULT_SEP_TOKEN);
            this.state = TokenizerState.LITERAL_STATE;
        } else {
            sb.append(CoreConstants.COLON_CHAR);
            sb.append(c4);
            this.state = TokenizerState.LITERAL_STATE;
        }
    }

    private void handleLiteralState(char c4, List<Token> list, StringBuilder sb) {
        if (c4 == '$') {
            addLiteralToken(list, sb);
            sb.setLength(0);
            this.state = TokenizerState.START_STATE;
            return;
        }
        if (c4 == ':') {
            addLiteralToken(list, sb);
            sb.setLength(0);
            this.state = TokenizerState.DEFAULT_VAL_STATE;
        } else if (c4 == '{') {
            addLiteralToken(list, sb);
            list.add(Token.CURLY_LEFT_TOKEN);
            sb.setLength(0);
        } else {
            if (c4 != '}') {
                sb.append(c4);
                return;
            }
            addLiteralToken(list, sb);
            list.add(Token.CURLY_RIGHT_TOKEN);
            sb.setLength(0);
        }
    }

    private void handleStartState(char c4, List<Token> list, StringBuilder sb) {
        if (c4 == '{') {
            list.add(Token.START_TOKEN);
        } else {
            sb.append('$');
            sb.append(c4);
        }
        this.state = TokenizerState.LITERAL_STATE;
    }

    public List<Token> tokenize() throws ScanException {
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i4 = this.pointer;
            if (i4 >= this.patternLength) {
                break;
            }
            char cCharAt = this.pattern.charAt(i4);
            this.pointer++;
            int i5 = AnonymousClass1.$SwitchMap$ch$qos$logback$core$subst$Tokenizer$TokenizerState[this.state.ordinal()];
            if (i5 == 1) {
                handleLiteralState(cCharAt, arrayList, sb);
            } else if (i5 == 2) {
                handleStartState(cCharAt, arrayList, sb);
            } else if (i5 == 3) {
                handleDefaultValueState(cCharAt, arrayList, sb);
            }
        }
        int i6 = AnonymousClass1.$SwitchMap$ch$qos$logback$core$subst$Tokenizer$TokenizerState[this.state.ordinal()];
        if (i6 == 1) {
            addLiteralToken(arrayList, sb);
        } else if (i6 == 2) {
            throw new ScanException("Unexpected end of pattern string");
        }
        return arrayList;
    }
}
