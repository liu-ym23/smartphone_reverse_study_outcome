package net.sourceforge.jeval;

/* loaded from: classes2.dex */
public class EvaluationResult {
    private char quoteCharacter;
    private String result;

    public EvaluationResult(String str, char c4) {
        this.result = str;
        this.quoteCharacter = c4;
    }

    public Double getDouble() throws NumberFormatException {
        return new Double(this.result);
    }

    public char getQuoteCharacter() {
        return this.quoteCharacter;
    }

    public String getResult() {
        return this.result;
    }

    public String getUnwrappedString() {
        String str = this.result;
        if (str == null || str.length() < 2 || this.result.charAt(0) != this.quoteCharacter) {
            return null;
        }
        String str2 = this.result;
        if (str2.charAt(str2.length() - 1) != this.quoteCharacter) {
            return null;
        }
        String str3 = this.result;
        return str3.substring(1, str3.length() - 1);
    }

    public boolean isBooleanFalse() {
        String str = this.result;
        return str != null && EvaluationConstants.BOOLEAN_STRING_FALSE.equals(str);
    }

    public boolean isBooleanTrue() {
        String str = this.result;
        return str != null && EvaluationConstants.BOOLEAN_STRING_TRUE.equals(str);
    }

    public boolean isString() {
        String str = this.result;
        if (str != null && str.length() >= 2 && this.result.charAt(0) == this.quoteCharacter) {
            String str2 = this.result;
            if (str2.charAt(str2.length() - 1) == this.quoteCharacter) {
                return true;
            }
        }
        return false;
    }

    public void setQuoteCharacter(char c4) {
        this.quoteCharacter = c4;
    }

    public void setResult(String str) {
        this.result = str;
    }
}
