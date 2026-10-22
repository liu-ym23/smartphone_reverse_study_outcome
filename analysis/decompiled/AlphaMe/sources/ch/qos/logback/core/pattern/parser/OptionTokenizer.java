package ch.qos.logback.core.pattern.parser;

import ch.qos.logback.core.pattern.parser.TokenStream;
import ch.qos.logback.core.pattern.util.AsIsEscapeUtil;
import ch.qos.logback.core.pattern.util.IEscapeUtil;
import ch.qos.logback.core.spi.ScanException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class OptionTokenizer {
    private static final int EXPECTING_STATE = 0;
    private static final int QUOTED_COLLECTING_STATE = 2;
    private static final int RAW_COLLECTING_STATE = 1;
    final IEscapeUtil escapeUtil;
    final String pattern;
    final int patternLength;
    char quoteChar;
    int state;
    final TokenStream tokenStream;

    public OptionTokenizer(TokenStream tokenStream) {
        this(tokenStream, new AsIsEscapeUtil());
    }

    public void emitOptionToken(List<Token> list, List<String> list2) {
        list.add(new Token(1006, list2));
        this.tokenStream.state = TokenStream.TokenizerState.LITERAL_STATE;
    }

    public void escape(String str, StringBuffer stringBuffer) {
        TokenStream tokenStream = this.tokenStream;
        int i4 = tokenStream.pointer;
        if (i4 < this.patternLength) {
            String str2 = this.pattern;
            tokenStream.pointer = i4 + 1;
            this.escapeUtil.escape(str, stringBuffer, str2.charAt(i4), this.tokenStream.pointer);
        }
    }

    public void tokenize(char c4, List<Token> list) throws ScanException {
        StringBuffer stringBuffer = new StringBuffer();
        ArrayList arrayList = new ArrayList();
        while (this.tokenStream.pointer < this.patternLength) {
            int i4 = this.state;
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 == 2) {
                        char c5 = this.quoteChar;
                        if (c4 == c5) {
                            arrayList.add(stringBuffer.toString());
                            stringBuffer.setLength(0);
                            this.state = 0;
                        } else if (c4 == '\\') {
                            escape(String.valueOf(c5), stringBuffer);
                        } else {
                            stringBuffer.append(c4);
                        }
                    }
                } else if (c4 == ',') {
                    arrayList.add(stringBuffer.toString().trim());
                    stringBuffer.setLength(0);
                    this.state = 0;
                } else {
                    if (c4 == '}') {
                        arrayList.add(stringBuffer.toString().trim());
                        emitOptionToken(list, arrayList);
                        return;
                    }
                    stringBuffer.append(c4);
                }
            } else if (c4 != '\t' && c4 != '\n' && c4 != '\r' && c4 != ' ') {
                if (c4 == '\"' || c4 == '\'') {
                    this.state = 2;
                    this.quoteChar = c4;
                } else if (c4 == ',') {
                    continue;
                } else if (c4 == '}') {
                    emitOptionToken(list, arrayList);
                    return;
                } else {
                    stringBuffer.append(c4);
                    this.state = 1;
                }
            }
            c4 = this.pattern.charAt(this.tokenStream.pointer);
            this.tokenStream.pointer++;
        }
        if (c4 != '}') {
            throw new ScanException("Unexpected end of pattern string in OptionTokenizer");
        }
        int i5 = this.state;
        if (i5 == 0) {
            emitOptionToken(list, arrayList);
        } else {
            if (i5 != 1) {
                throw new ScanException("Unexpected end of pattern string in OptionTokenizer");
            }
            arrayList.add(stringBuffer.toString().trim());
            emitOptionToken(list, arrayList);
        }
    }

    public OptionTokenizer(TokenStream tokenStream, IEscapeUtil iEscapeUtil) {
        this.state = 0;
        this.tokenStream = tokenStream;
        this.pattern = tokenStream.pattern;
        this.patternLength = tokenStream.patternLength;
        this.escapeUtil = iEscapeUtil;
    }
}
