package co.nstant.in.cbor;

import co.nstant.in.cbor.encoder.ArrayEncoder;
import co.nstant.in.cbor.encoder.ByteStringEncoder;
import co.nstant.in.cbor.encoder.MapEncoder;
import co.nstant.in.cbor.encoder.NegativeIntegerEncoder;
import co.nstant.in.cbor.encoder.SpecialEncoder;
import co.nstant.in.cbor.encoder.TagEncoder;
import co.nstant.in.cbor.encoder.UnicodeStringEncoder;
import co.nstant.in.cbor.encoder.UnsignedIntegerEncoder;
import co.nstant.in.cbor.model.Array;
import co.nstant.in.cbor.model.ByteString;
import co.nstant.in.cbor.model.DataItem;
import co.nstant.in.cbor.model.MajorType;
import co.nstant.in.cbor.model.Map;
import co.nstant.in.cbor.model.NegativeInteger;
import co.nstant.in.cbor.model.SimpleValue;
import co.nstant.in.cbor.model.Special;
import co.nstant.in.cbor.model.Tag;
import co.nstant.in.cbor.model.UnicodeString;
import co.nstant.in.cbor.model.UnsignedInteger;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CborEncoder {
    private final ArrayEncoder arrayEncoder;
    private final ByteStringEncoder byteStringEncoder;
    private final MapEncoder mapEncoder;
    private final NegativeIntegerEncoder negativeIntegerEncoder;
    private final SpecialEncoder specialEncoder;
    private final TagEncoder tagEncoder;
    private final UnicodeStringEncoder unicodeStringEncoder;
    private final UnsignedIntegerEncoder unsignedIntegerEncoder;

    /* JADX INFO: renamed from: co.nstant.in.cbor.CborEncoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$co$nstant$in$cbor$model$MajorType = null;

        static {
            $SwitchMap$co$nstant$in$cbor$model$MajorType = new int[MajorType.values().length];
            $SwitchMap$co$nstant$in$cbor$model$MajorType[MajorType.UNSIGNED_INTEGER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
        L40:
            $SwitchMap$co$nstant$in$cbor$model$MajorType[MajorType.NEGATIVE_INTEGER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L30:
            $SwitchMap$co$nstant$in$cbor$model$MajorType[MajorType.BYTE_STRING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L28:
            $SwitchMap$co$nstant$in$cbor$model$MajorType[MajorType.UNICODE_STRING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L32:
            $SwitchMap$co$nstant$in$cbor$model$MajorType[MajorType.ARRAY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L36:
            $SwitchMap$co$nstant$in$cbor$model$MajorType[MajorType.MAP.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L42:
            $SwitchMap$co$nstant$in$cbor$model$MajorType[MajorType.SPECIAL.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
        L38:
            $SwitchMap$co$nstant$in$cbor$model$MajorType[MajorType.TAG.ordinal()] = 8;     // Catch: NoSuchFieldError -> L26
            return;
        }
    }

    public CborEncoder(OutputStream outputStream) {
        outputStream.getClass();
        this.unsignedIntegerEncoder = new UnsignedIntegerEncoder(this, outputStream);
        this.negativeIntegerEncoder = new NegativeIntegerEncoder(this, outputStream);
        this.byteStringEncoder = new ByteStringEncoder(this, outputStream);
        this.unicodeStringEncoder = new UnicodeStringEncoder(this, outputStream);
        this.arrayEncoder = new ArrayEncoder(this, outputStream);
        this.mapEncoder = new MapEncoder(this, outputStream);
        this.tagEncoder = new TagEncoder(this, outputStream);
        this.specialEncoder = new SpecialEncoder(this, outputStream);
    }

    public void encode(List<DataItem> dataItems) throws CborException {
        Iterator<DataItem> r0 = dataItems.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        DataItem dataItem = r0.next();
        encode(dataItem);
        goto L4
    }

    public void encode(DataItem dataItem) throws CborException {
        if (dataItem != null) goto L5;
        dataItem = SimpleValue.NULL;
    L5:
        if (dataItem.hasTag() == false) goto L8;
        Tag tagDi = dataItem.getTag();
        this.tagEncoder.encode2(tagDi);
    L8:
        switch(AnonymousClass1.$SwitchMap$co$nstant$in$cbor$model$MajorType[dataItem.getMajorType().ordinal()]) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            default: goto L10;
        };
    L11:
        this.tagEncoder.encode2((Tag) dataItem);
        return;
    L12:
        this.specialEncoder.encode2((Special) dataItem);
        return;
    L13:
        this.mapEncoder.encode2((Map) dataItem);
        return;
    L14:
        this.arrayEncoder.encode2((Array) dataItem);
        return;
    L15:
        this.unicodeStringEncoder.encode2((UnicodeString) dataItem);
        return;
    L16:
        this.byteStringEncoder.encode2((ByteString) dataItem);
        return;
    L17:
        this.negativeIntegerEncoder.encode2((NegativeInteger) dataItem);
        return;
    L18:
        this.unsignedIntegerEncoder.encode2((UnsignedInteger) dataItem);
        return;
    L10:
        throw new CborException("Unknown major type");
    }
}
