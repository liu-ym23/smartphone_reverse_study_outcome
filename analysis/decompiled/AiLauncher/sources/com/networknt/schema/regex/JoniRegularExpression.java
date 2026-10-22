package com.networknt.schema.regex;

import com.stepos.agentframework.chatui.longtext.b;
import com.stepos.ailauncher.chat.wake.circle.F;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;
import org.jcodings.ApplyAllCaseFoldFunction;
import org.jcodings.CaseFoldCodeItem;
import org.jcodings.CodeRange;
import org.jcodings.Encoding;
import org.jcodings.IntHolder;
import org.jcodings.specific.UTF8Encoding;
import org.jcodings.unicode.UnicodeCodeRange;
import org.joni.Regex;
import org.joni.Syntax;
import org.joni.exception.SyntaxException;

/* loaded from: classes2.dex */
class JoniRegularExpression implements RegularExpression {
    private static final Syntax SYNTAX = new Syntax(Syntax.ECMAScript.name, Syntax.ECMAScript.op, Syntax.ECMAScript.op2 | b.BLOCK_CHARS, Syntax.ECMAScript.op3, Syntax.ECMAScript.behavior, Syntax.ECMAScript.options, Syntax.ECMAScript.metaCharTable);
    private final Pattern INVALID_ESCAPE_PATTERN;
    private final Regex pattern;

    public static class Arrays {
        public static boolean equals(byte[] bArr, byte[] bArr2, int i10, int i11) {
            int length;
            if (bArr == bArr2) {
                return true;
            }
            if (bArr == null || bArr2 == null || i11 - i10 != (length = bArr.length)) {
                return false;
            }
            for (int i12 = 0; i12 < length; i12++) {
                if (bArr[i12] != bArr2[i12 + i10]) {
                    return false;
                }
            }
            return true;
        }
    }

    public static class DelegatingEncoding extends Encoding {
        protected final Encoding delegate;

        public DelegatingEncoding(Encoding encoding) {
            super(new String(encoding.getName()), encoding.minLength(), encoding.maxLength());
            this.delegate = encoding;
        }

        public void applyAllCaseFold(int i10, ApplyAllCaseFoldFunction applyAllCaseFoldFunction, Object obj) {
            this.delegate.applyAllCaseFold(i10, applyAllCaseFoldFunction, obj);
        }

        public CaseFoldCodeItem[] caseFoldCodesByString(int i10, byte[] bArr, int i11, int i12) {
            return this.delegate.caseFoldCodesByString(i10, bArr, i11, i12);
        }

        public int caseMap(IntHolder intHolder, byte[] bArr, IntHolder intHolder2, int i10, byte[] bArr2, int i11, int i12) {
            return this.delegate.caseMap(intHolder, bArr, intHolder2, i10, bArr2, i11, i12);
        }

        public int codeToMbc(int i10, byte[] bArr, int i11) {
            return this.delegate.codeToMbc(i10, bArr, i11);
        }

        public int codeToMbcLength(int i10) {
            return this.delegate.codeToMbcLength(i10);
        }

        public int[] ctypeCodeRange(int i10, IntHolder intHolder) {
            return this.delegate.ctypeCodeRange(i10, intHolder);
        }

        public Charset getCharset() {
            return this.delegate.getCharset();
        }

        public String getCharsetName() {
            return this.delegate.getCharsetName();
        }

        public boolean isCodeCType(int i10, int i11) {
            return this.delegate.isCodeCType(i10, i11);
        }

        public boolean isMbcCrnl(byte[] bArr, int i10, int i11) {
            return this.delegate.isMbcCrnl(bArr, i10, i11);
        }

        public boolean isNewLine(byte[] bArr, int i10, int i11) {
            return this.delegate.isNewLine(bArr, i10, i11);
        }

        public boolean isReverseMatchAllowed(byte[] bArr, int i10, int i11) {
            return this.delegate.isReverseMatchAllowed(bArr, i10, i11);
        }

        public int leftAdjustCharHead(byte[] bArr, int i10, int i11, int i12) {
            return this.delegate.leftAdjustCharHead(bArr, i10, i11, i12);
        }

        public int length(byte b10) {
            return this.delegate.length(b10);
        }

        public int mbcCaseFold(int i10, byte[] bArr, IntHolder intHolder, int i11, byte[] bArr2) {
            return this.delegate.mbcCaseFold(i10, bArr, intHolder, i11, bArr2);
        }

        public int mbcToCode(byte[] bArr, int i10, int i11) {
            return this.delegate.mbcToCode(bArr, i10, i11);
        }

        public int propertyNameToCType(byte[] bArr, int i10, int i11) {
            return this.delegate.propertyNameToCType(bArr, i10, i11);
        }

        public int strCodeAt(byte[] bArr, int i10, int i11, int i12) {
            return this.delegate.strCodeAt(bArr, i10, i11, i12);
        }

        public int strLength(byte[] bArr, int i10, int i11) {
            return this.delegate.strLength(bArr, i10, i11);
        }

        public byte[] toLowerCaseTable() {
            return this.delegate.toLowerCaseTable();
        }

        public int length(byte[] bArr, int i10, int i11) {
            return this.delegate.length(bArr, i10, i11);
        }
    }

    public static class ECMAScriptUTF8Encoding extends DelegatingEncoding {
        private static final int[] CR_DIGIT = {1, 48, 57};
        private static final int[] CR_WORD = {4, 48, 57, 65, 90, 95, 95, 97, 122};
        private static final int[] CR_SPACE = {10, 9, 13, 32, 32, F.LOOP_END_FRAME, F.LOOP_END_FRAME, 5760, 5760, b.THRESHOLD, 8202, 8232, 8233, 8239, 8239, 8287, 8287, 12288, 12288, 65279, 65279};
        private static final byte[] PROPERTY_NAME_DIGIT = {100, 105, 103, 105, 116};
        public static final ECMAScriptUTF8Encoding INSTANCE = new ECMAScriptUTF8Encoding();

        public ECMAScriptUTF8Encoding() {
            super(UTF8Encoding.INSTANCE);
        }

        @Override // com.networknt.schema.regex.JoniRegularExpression.DelegatingEncoding
        public int[] ctypeCodeRange(int i10, IntHolder intHolder) {
            if (i10 == 4) {
                intHolder.value = 128;
                return CR_DIGIT;
            }
            if (i10 == 9) {
                intHolder.value = 128;
                return CR_SPACE;
            }
            if (i10 != 12) {
                return this.delegate.ctypeCodeRange(i10, intHolder);
            }
            intHolder.value = 128;
            return CR_WORD;
        }

        @Override // com.networknt.schema.regex.JoniRegularExpression.DelegatingEncoding
        public boolean isCodeCType(int i10, int i11) {
            return i11 != 4 ? i11 != 9 ? i11 != 12 ? this.delegate.isCodeCType(i10, i11) : CodeRange.isInCodeRange(CR_WORD, i10) : CodeRange.isInCodeRange(CR_SPACE, i10) : CodeRange.isInCodeRange(CR_DIGIT, i10);
        }

        @Override // com.networknt.schema.regex.JoniRegularExpression.DelegatingEncoding
        public int propertyNameToCType(byte[] bArr, int i10, int i11) {
            return Arrays.equals(PROPERTY_NAME_DIGIT, bArr, i10, i11) ? UnicodeCodeRange.ND.ordinal() : this.delegate.propertyNameToCType(bArr, i10, i11);
        }
    }

    public JoniRegularExpression(String str) {
        this(str, SYNTAX);
    }

    @Override // com.networknt.schema.regex.RegularExpression
    public boolean matches(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        return this.pattern.matcher(bytes).search(0, bytes.length, 0) >= 0;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.joni.exception.SyntaxException */
    public void validate(String str) throws SyntaxException {
        if (this.INVALID_ESCAPE_PATTERN.matcher(str).matches()) {
            throw new SyntaxException("Invalid escape");
        }
    }

    public JoniRegularExpression(String str, Syntax syntax) throws SyntaxException {
        this.INVALID_ESCAPE_PATTERN = Pattern.compile(".*\\\\([aeg-jl-moqyzACE-OQ-RT-VX-Z1-9]|k([^<]|$)|c$|[pP]([^{]|$)|u([^{0-9]|$)|x([0-9a-fA-F][^0-9a-fA-F]|[^0-9a-fA-F][0-9a-fA-F]|[^0-9a-fA-F][^0-9a-fA-F]|.?$)).*");
        validate(str);
        byte[] bytes = RegularExpressions.replaceDollarAnchors(str).getBytes(StandardCharsets.UTF_8);
        this.pattern = new Regex(bytes, 0, bytes.length, 8, ECMAScriptUTF8Encoding.INSTANCE, syntax);
    }
}
