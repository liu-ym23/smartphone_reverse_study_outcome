package co.nstant.in.cbor.decoder;

import co.nstant.in.cbor.CborDecoder;
import co.nstant.in.cbor.CborException;
import co.nstant.in.cbor.model.SimpleValue;
import co.nstant.in.cbor.model.SimpleValueType;
import co.nstant.in.cbor.model.Special;
import co.nstant.in.cbor.model.SpecialType;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class SpecialDecoder extends AbstractDecoder<Special> {
    private final DoublePrecisionFloatDecoder doublePrecisionFloatDecoder;
    private final HalfPrecisionFloatDecoder halfPrecisionFloatDecoder;
    private final SinglePrecisionFloatDecoder singlePrecisionFloatDecoder;

    /* JADX INFO: renamed from: co.nstant.in.cbor.decoder.SpecialDecoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$co$nstant$in$cbor$model$SimpleValueType = null;
        static final /* synthetic */ int[] $SwitchMap$co$nstant$in$cbor$model$SpecialType = null;

        static {
            $SwitchMap$co$nstant$in$cbor$model$SpecialType = new int[SpecialType.values().length];
            $SwitchMap$co$nstant$in$cbor$model$SpecialType[SpecialType.BREAK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
        L71:
            $SwitchMap$co$nstant$in$cbor$model$SpecialType[SpecialType.SIMPLE_VALUE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L53:
            $SwitchMap$co$nstant$in$cbor$model$SpecialType[SpecialType.IEEE_754_HALF_PRECISION_FLOAT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L51:
            $SwitchMap$co$nstant$in$cbor$model$SpecialType[SpecialType.IEEE_754_SINGLE_PRECISION_FLOAT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L59:
            $SwitchMap$co$nstant$in$cbor$model$SpecialType[SpecialType.IEEE_754_DOUBLE_PRECISION_FLOAT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L21
        L67:
            $SwitchMap$co$nstant$in$cbor$model$SpecialType[SpecialType.SIMPLE_VALUE_NEXT_BYTE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L25
        L73:
            $SwitchMap$co$nstant$in$cbor$model$SpecialType[SpecialType.UNALLOCATED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L28
        L29:
            $SwitchMap$co$nstant$in$cbor$model$SimpleValueType = new int[SimpleValueType.values().length];
            $SwitchMap$co$nstant$in$cbor$model$SimpleValueType[SimpleValueType.FALSE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L32
        L63:
            $SwitchMap$co$nstant$in$cbor$model$SimpleValueType[SimpleValueType.TRUE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L35
        L69:
            $SwitchMap$co$nstant$in$cbor$model$SimpleValueType[SimpleValueType.NULL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L38
        L49:
            $SwitchMap$co$nstant$in$cbor$model$SimpleValueType[SimpleValueType.UNDEFINED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L41
        L55:
            $SwitchMap$co$nstant$in$cbor$model$SimpleValueType[SimpleValueType.UNALLOCATED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L44
        L61:
            $SwitchMap$co$nstant$in$cbor$model$SimpleValueType[SimpleValueType.RESERVED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L47
            return;
        }
    }

    @Override // co.nstant.in.cbor.decoder.AbstractDecoder
    public /* bridge */ /* synthetic */ Special decode(int r1) throws CborException {
        return decode(r1);
    }

    public SpecialDecoder(CborDecoder decoder, InputStream inputStream) {
        super(decoder, inputStream);
        this.halfPrecisionFloatDecoder = new HalfPrecisionFloatDecoder(decoder, inputStream);
        this.singlePrecisionFloatDecoder = new SinglePrecisionFloatDecoder(decoder, inputStream);
        this.doublePrecisionFloatDecoder = new DoublePrecisionFloatDecoder(decoder, inputStream);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // co.nstant.in.cbor.decoder.AbstractDecoder
    public Special decode(int initialByte) throws CborException {
        switch(AnonymousClass1.$SwitchMap$co$nstant$in$cbor$model$SpecialType[SpecialType.ofByte(initialByte).ordinal()]) {
            case 1: goto L29;
            case 2: goto L15;
            case 3: goto L13;
            case 4: goto L11;
            case 5: goto L9;
            case 6: goto L7;
            default: goto L5;
        };
    L5:
        throw new CborException("Not implemented");
    L7:
        return new SimpleValue(nextSymbol());
    L9:
        return this.doublePrecisionFloatDecoder.decode(initialByte);
    L11:
        return this.singlePrecisionFloatDecoder.decode(initialByte);
    L13:
        return this.halfPrecisionFloatDecoder.decode(initialByte);
    L15:
        switch(AnonymousClass1.$SwitchMap$co$nstant$in$cbor$model$SimpleValueType[SimpleValueType.ofByte(initialByte).ordinal()]) {
            case 1: goto L27;
            case 2: goto L25;
            case 3: goto L23;
            case 4: goto L21;
            case 5: goto L19;
            default: goto L17;
        };
    L17:
        throw new CborException("Not implemented");
    L19:
        return new SimpleValue(initialByte & 31);
    L21:
        return SimpleValue.UNDEFINED;
    L23:
        return SimpleValue.NULL;
    L25:
        return SimpleValue.TRUE;
    L27:
        return SimpleValue.FALSE;
    L29:
        return Special.BREAK;
    }
}
