package org.yaml.snakeyaml.reader;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.scanner.Constant;

/* loaded from: classes5.dex */
public class StreamReader {
    private final char[] buffer;
    private int column;
    private int dataLength;
    private int[] dataWindow;
    private int documentIndex;
    private boolean eof;
    private int index;
    private int line;
    private String name;
    private int pointer;
    private final Reader stream;

    public StreamReader(String str) {
        this(new StringReader(str));
        this.name = "'string'";
    }

    private boolean ensureEnoughData() {
        return ensureEnoughData(0);
    }

    public static boolean isPrintable(int i10) {
        if ((i10 >= 32 && i10 <= 126) || i10 == 9 || i10 == 10 || i10 == 13 || i10 == 133) {
            return true;
        }
        if (i10 >= 160 && i10 <= 55295) {
            return true;
        }
        if (i10 < 57344 || i10 > 65533) {
            return i10 >= 65536 && i10 <= 1114111;
        }
        return true;
    }

    private void moveIndices(int i10) {
        this.index += i10;
        this.documentIndex += i10;
    }

    private void update() throws IOException {
        try {
            Reader reader = this.stream;
            char[] cArr = this.buffer;
            int i10 = reader.read(cArr, 0, cArr.length - 1);
            if (i10 <= 0) {
                this.eof = true;
                return;
            }
            int i11 = this.dataLength;
            int i12 = this.pointer;
            int i13 = i11 - i12;
            this.dataWindow = Arrays.copyOfRange(this.dataWindow, i12, i11 + i10);
            int i14 = i10 - 1;
            if (Character.isHighSurrogate(this.buffer[i14])) {
                if (this.stream.read(this.buffer, i10, 1) == -1) {
                    throw new ReaderException(this.name, this.index + i10, this.buffer[i14], "The last char is HighSurrogate (no LowSurrogate detected).");
                }
                i10++;
            }
            int i15 = 32;
            int iCharCount = 0;
            while (iCharCount < i10) {
                int iCodePointAt = Character.codePointAt(this.buffer, iCharCount);
                this.dataWindow[i13] = iCodePointAt;
                if (isPrintable(iCodePointAt)) {
                    iCharCount += Character.charCount(iCodePointAt);
                } else {
                    iCharCount = i10;
                    i15 = iCodePointAt;
                }
                i13++;
            }
            this.dataLength = i13;
            this.pointer = 0;
            if (i15 != 32) {
                throw new ReaderException(this.name, (this.index + i13) - 1, i15, "special characters are not allowed");
            }
        } catch (IOException e10) {
            throw new YAMLException(e10);
        }
    }

    public void forward() {
        forward(1);
    }

    public int getColumn() {
        return this.column;
    }

    public int getDocumentIndex() {
        return this.documentIndex;
    }

    public int getIndex() {
        return this.index;
    }

    public int getLine() {
        return this.line;
    }

    public Mark getMark() {
        return new Mark(this.name, this.index, this.line, this.column, this.dataWindow, this.pointer);
    }

    public int peek() {
        if (ensureEnoughData()) {
            return this.dataWindow[this.pointer];
        }
        return 0;
    }

    public String prefix(int i10) {
        if (i10 == 0) {
            return "";
        }
        if (ensureEnoughData(i10)) {
            return new String(this.dataWindow, this.pointer, i10);
        }
        int[] iArr = this.dataWindow;
        int i11 = this.pointer;
        return new String(iArr, i11, Math.min(i10, this.dataLength - i11));
    }

    public String prefixForward(int i10) {
        String strPrefix = prefix(i10);
        this.pointer += i10;
        moveIndices(i10);
        this.column += i10;
        return strPrefix;
    }

    public void resetDocumentIndex() {
        this.documentIndex = 0;
    }

    private boolean ensureEnoughData(int i10) throws IOException {
        if (!this.eof && this.pointer + i10 >= this.dataLength) {
            update();
        }
        return this.pointer + i10 < this.dataLength;
    }

    public static boolean isPrintable(String str) {
        int length = str.length();
        int iCharCount = 0;
        while (iCharCount < length) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (!isPrintable(iCodePointAt)) {
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        return true;
    }

    public void forward(int i10) {
        for (int i11 = 0; i11 < i10 && ensureEnoughData(); i11++) {
            int[] iArr = this.dataWindow;
            int i12 = this.pointer;
            this.pointer = i12 + 1;
            int i13 = iArr[i12];
            moveIndices(1);
            if (Constant.LINEBR.has(i13) || (i13 == 13 && ensureEnoughData() && this.dataWindow[this.pointer] != 10)) {
                this.line++;
                this.column = 0;
            } else if (i13 != 65279) {
                this.column++;
            }
        }
    }

    public int peek(int i10) {
        if (ensureEnoughData(i10)) {
            return this.dataWindow[this.pointer + i10];
        }
        return 0;
    }

    public StreamReader(Reader reader) {
        this.pointer = 0;
        this.index = 0;
        this.documentIndex = 0;
        this.line = 0;
        this.column = 0;
        if (reader != null) {
            this.name = "'reader'";
            this.dataWindow = new int[0];
            this.dataLength = 0;
            this.stream = reader;
            this.eof = false;
            this.buffer = new char[1024];
            return;
        }
        throw new NullPointerException("Reader must be provided.");
    }
}
