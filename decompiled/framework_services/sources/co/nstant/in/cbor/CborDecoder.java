package co.nstant.in.cbor;

import co.nstant.in.cbor.decoder.ArrayDecoder;
import co.nstant.in.cbor.decoder.ByteStringDecoder;
import co.nstant.in.cbor.decoder.MapDecoder;
import co.nstant.in.cbor.decoder.NegativeIntegerDecoder;
import co.nstant.in.cbor.decoder.SpecialDecoder;
import co.nstant.in.cbor.decoder.TagDecoder;
import co.nstant.in.cbor.decoder.UnicodeStringDecoder;
import co.nstant.in.cbor.decoder.UnsignedIntegerDecoder;
import co.nstant.in.cbor.model.Array;
import co.nstant.in.cbor.model.DataItem;
import co.nstant.in.cbor.model.LanguageTaggedString;
import co.nstant.in.cbor.model.MajorType;
import co.nstant.in.cbor.model.Number;
import co.nstant.in.cbor.model.RationalNumber;
import co.nstant.in.cbor.model.Tag;
import co.nstant.in.cbor.model.UnicodeString;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CborDecoder {
    private final ArrayDecoder arrayDecoder;
    private boolean autoDecodeInfinitiveArrays;
    private boolean autoDecodeInfinitiveByteStrings;
    private boolean autoDecodeInfinitiveMaps;
    private boolean autoDecodeInfinitiveUnicodeStrings;
    private boolean autoDecodeLanguageTaggedStrings;
    private boolean autoDecodeRationalNumbers;
    private final ByteStringDecoder byteStringDecoder;
    private final InputStream inputStream;
    private final MapDecoder mapDecoder;
    private final NegativeIntegerDecoder negativeIntegerDecoder;
    private boolean rejectDuplicateKeys;
    private final SpecialDecoder specialDecoder;
    private final TagDecoder tagDecoder;
    private final UnicodeStringDecoder unicodeStringDecoder;
    private final UnsignedIntegerDecoder unsignedIntegerDecoder;

    /* JADX INFO: renamed from: co.nstant.in.cbor.CborDecoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$co$nstant$in$cbor$model$MajorType = null;

        static {
            $SwitchMap$co$nstant$in$cbor$model$MajorType = new int[MajorType.values().length];
            $SwitchMap$co$nstant$in$cbor$model$MajorType[MajorType.ARRAY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
        L45:
            $SwitchMap$co$nstant$in$cbor$model$MajorType[MajorType.BYTE_STRING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L35:
            $SwitchMap$co$nstant$in$cbor$model$MajorType[MajorType.MAP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L31:
            $SwitchMap$co$nstant$in$cbor$model$MajorType[MajorType.NEGATIVE_INTEGER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L37:
            $SwitchMap$co$nstant$in$cbor$model$MajorType[MajorType.UNICODE_STRING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L41:
            $SwitchMap$co$nstant$in$cbor$model$MajorType[MajorType.UNSIGNED_INTEGER.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L47:
            $SwitchMap$co$nstant$in$cbor$model$MajorType[MajorType.SPECIAL.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
        L43:
            $SwitchMap$co$nstant$in$cbor$model$MajorType[MajorType.TAG.ordinal()] = 8;     // Catch: NoSuchFieldError -> L26
        L33:
            $SwitchMap$co$nstant$in$cbor$model$MajorType[MajorType.INVALID.ordinal()] = 9;     // Catch: NoSuchFieldError -> L29
            return;
        }
    }

    public CborDecoder(InputStream inputStream) {
        this.autoDecodeInfinitiveArrays = true;
        this.autoDecodeInfinitiveMaps = true;
        this.autoDecodeInfinitiveByteStrings = true;
        this.autoDecodeInfinitiveUnicodeStrings = true;
        this.autoDecodeRationalNumbers = true;
        this.autoDecodeLanguageTaggedStrings = true;
        this.rejectDuplicateKeys = false;
        inputStream.getClass();
        this.inputStream = inputStream;
        this.unsignedIntegerDecoder = new UnsignedIntegerDecoder(this, inputStream);
        this.negativeIntegerDecoder = new NegativeIntegerDecoder(this, inputStream);
        this.byteStringDecoder = new ByteStringDecoder(this, inputStream);
        this.unicodeStringDecoder = new UnicodeStringDecoder(this, inputStream);
        this.arrayDecoder = new ArrayDecoder(this, inputStream);
        this.mapDecoder = new MapDecoder(this, inputStream);
        this.tagDecoder = new TagDecoder(this, inputStream);
        this.specialDecoder = new SpecialDecoder(this, inputStream);
    }

    public static List<DataItem> decode(byte[] bytes) throws CborException {
        return new CborDecoder(new ByteArrayInputStream(bytes)).decode();
    }

    public List<DataItem> decode() throws CborException {
        List<DataItem> dataItems = new LinkedList();
    L3:
        DataItem dataItem = decodeNext();
        if (dataItem == null) goto L6;
        dataItems.add(dataItem);
        goto L3
    L6:
        return dataItems;
    }

    public void decode(DataItemListener dataItemListener) throws CborException {
        dataItemListener.getClass();
        DataItem dataItem = decodeNext();
    L3:
        if (dataItem == null) goto L5;
        dataItemListener.onDataItem(dataItem);
        dataItem = decodeNext();
        goto L3
    }

    public DataItem decodeNext() throws CborException {
        int symbol = this.inputStream.read();     // Catch: IOException -> L47
        if (symbol != (-1)) goto L8;
        return null;
    L8:
        switch(AnonymousClass1.$SwitchMap$co$nstant$in$cbor$model$MajorType[MajorType.ofByte(symbol).ordinal()]) {
            case 1: goto L46;
            case 2: goto L44;
            case 3: goto L42;
            case 4: goto L40;
            case 5: goto L38;
            case 6: goto L36;
            case 7: goto L34;
            case 8: goto L11;
            default: goto L10;
        };
    L11:
        Tag tag = this.tagDecoder.decode(symbol);
        DataItem next = decodeNext();
        if (next == null) goto L32;
        if (this.autoDecodeRationalNumbers == false) goto L20;
        if (tag.getValue() != 30) goto L20;
        return decodeRationalNumber(next);
    L20:
        if (this.autoDecodeLanguageTaggedStrings == true) goto L22;
    L25:
        DataItem itemToTag = next;
    L27:
        if (itemToTag.hasTag() == false) goto L29;
        itemToTag = itemToTag.getTag();
        goto L27
    L29:
        itemToTag.setTag(tag);
        return next;
    L22:
        if (tag.getValue() != 38) goto L25;
        return decodeLanguageTaggedString(next);
    L32:
        throw new CborException("Unexpected end of stream: tag without following data item.");
    L10:
        throw new CborException("Not implemented major type " + symbol);
    L34:
        return this.specialDecoder.decode(symbol);
    L36:
        return this.unsignedIntegerDecoder.decode(symbol);
    L38:
        return this.unicodeStringDecoder.decode(symbol);
    L40:
        return this.negativeIntegerDecoder.decode(symbol);
    L42:
        return this.mapDecoder.decode(symbol);
    L44:
        return this.byteStringDecoder.decode(symbol);
    L46:
        return this.arrayDecoder.decode(symbol);
    L47:
        ioException = move-exception;
        throw new CborException(ioException);
    }

    private DataItem decodeLanguageTaggedString(DataItem dataItem) throws CborException {
        if ((dataItem instanceof Array) == false) goto L19;
        Array array = (Array) dataItem;
        if (array.getDataItems().size() != 2) goto L17;
        DataItem languageDataItem = array.getDataItems().get(0);
        if ((languageDataItem instanceof UnicodeString) == false) goto L15;
        DataItem stringDataItem = array.getDataItems().get(1);
        if ((stringDataItem instanceof UnicodeString) == false) goto L13;
        UnicodeString language = (UnicodeString) languageDataItem;
        UnicodeString string = (UnicodeString) stringDataItem;
        return new LanguageTaggedString(language, string);
    L13:
        throw new CborException("Error decoding LanguageTaggedString: second data item is not an UnicodeString");
    L15:
        throw new CborException("Error decoding LanguageTaggedString: first data item is not an UnicodeString");
    L17:
        throw new CborException("Error decoding LanguageTaggedString: array size is not 2");
    L19:
        throw new CborException("Error decoding LanguageTaggedString: not an array");
    }

    private DataItem decodeRationalNumber(DataItem dataItem) throws CborException {
        if ((dataItem instanceof Array) == false) goto L19;
        Array array = (Array) dataItem;
        if (array.getDataItems().size() != 2) goto L17;
        DataItem numeratorDataItem = array.getDataItems().get(0);
        if ((numeratorDataItem instanceof Number) == false) goto L15;
        DataItem denominatorDataItem = array.getDataItems().get(1);
        if ((denominatorDataItem instanceof Number) == false) goto L13;
        Number numerator = (Number) numeratorDataItem;
        Number denominator = (Number) denominatorDataItem;
        return new RationalNumber(numerator, denominator);
    L13:
        throw new CborException("Error decoding RationalNumber: second data item is not a number");
    L15:
        throw new CborException("Error decoding RationalNumber: first data item is not a number");
    L17:
        throw new CborException("Error decoding RationalNumber: array size is not 2");
    L19:
        throw new CborException("Error decoding RationalNumber: not an array");
    }

    public boolean isAutoDecodeInfinitiveArrays() {
        return this.autoDecodeInfinitiveArrays;
    }

    public void setAutoDecodeInfinitiveArrays(boolean autoDecodeInfinitiveArrays) {
        this.autoDecodeInfinitiveArrays = autoDecodeInfinitiveArrays;
    }

    public boolean isAutoDecodeInfinitiveMaps() {
        return this.autoDecodeInfinitiveMaps;
    }

    public void setAutoDecodeInfinitiveMaps(boolean autoDecodeInfinitiveMaps) {
        this.autoDecodeInfinitiveMaps = autoDecodeInfinitiveMaps;
    }

    public boolean isAutoDecodeInfinitiveByteStrings() {
        return this.autoDecodeInfinitiveByteStrings;
    }

    public void setAutoDecodeInfinitiveByteStrings(boolean autoDecodeInfinitiveByteStrings) {
        this.autoDecodeInfinitiveByteStrings = autoDecodeInfinitiveByteStrings;
    }

    public boolean isAutoDecodeInfinitiveUnicodeStrings() {
        return this.autoDecodeInfinitiveUnicodeStrings;
    }

    public void setAutoDecodeInfinitiveUnicodeStrings(boolean autoDecodeInfinitiveUnicodeStrings) {
        this.autoDecodeInfinitiveUnicodeStrings = autoDecodeInfinitiveUnicodeStrings;
    }

    public boolean isAutoDecodeRationalNumbers() {
        return this.autoDecodeRationalNumbers;
    }

    public void setAutoDecodeRationalNumbers(boolean autoDecodeRationalNumbers) {
        this.autoDecodeRationalNumbers = autoDecodeRationalNumbers;
    }

    public boolean isAutoDecodeLanguageTaggedStrings() {
        return this.autoDecodeLanguageTaggedStrings;
    }

    public void setAutoDecodeLanguageTaggedStrings(boolean autoDecodeLanguageTaggedStrings) {
        this.autoDecodeLanguageTaggedStrings = autoDecodeLanguageTaggedStrings;
    }

    public boolean isRejectDuplicateKeys() {
        return this.rejectDuplicateKeys;
    }

    public void setRejectDuplicateKeys(boolean rejectDuplicateKeys) {
        this.rejectDuplicateKeys = rejectDuplicateKeys;
    }
}
