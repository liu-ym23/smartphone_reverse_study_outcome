package ch.qos.logback.core.rolling.helper;

/* loaded from: classes.dex */
public class TokenConverter {
    static final int DATE = 1;
    static final int IDENTITY = 0;
    static final int INTEGER = 1;
    TokenConverter next;
    int type;

    public TokenConverter(int i4) {
        this.type = i4;
    }

    public TokenConverter getNext() {
        return this.next;
    }

    public int getType() {
        return this.type;
    }

    public void setNext(TokenConverter tokenConverter) {
        this.next = tokenConverter;
    }

    public void setType(int i4) {
        this.type = i4;
    }
}
