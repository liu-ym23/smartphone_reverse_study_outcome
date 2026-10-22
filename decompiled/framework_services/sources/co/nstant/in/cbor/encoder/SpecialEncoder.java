package co.nstant.in.cbor.encoder;

import co.nstant.in.cbor.CborEncoder;
import co.nstant.in.cbor.CborException;
import co.nstant.in.cbor.model.DoublePrecisionFloat;
import co.nstant.in.cbor.model.HalfPrecisionFloat;
import co.nstant.in.cbor.model.SimpleValue;
import co.nstant.in.cbor.model.SimpleValueType;
import co.nstant.in.cbor.model.SinglePrecisionFloat;
import co.nstant.in.cbor.model.Special;
import co.nstant.in.cbor.model.SpecialType;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.usb.descriptors.UsbDescriptor;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class SpecialEncoder extends AbstractEncoder<Special> {
    private final DoublePrecisionFloatEncoder doublePrecisionFloatEncoder;
    private final HalfPrecisionFloatEncoder halfPrecisionFloatEncoder;
    private final SinglePrecisionFloatEncoder singlePrecisionFloatEncoder;

    /* JADX INFO: renamed from: co.nstant.in.cbor.encoder.SpecialEncoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$co$nstant$in$cbor$model$SimpleValueType = null;
        static final /* synthetic */ int[] $SwitchMap$co$nstant$in$cbor$model$SpecialType = null;

        static {
            $SwitchMap$co$nstant$in$cbor$model$SpecialType = new int[SpecialType.values().length];
            $SwitchMap$co$nstant$in$cbor$model$SpecialType[SpecialType.BREAK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
        L71:
            $SwitchMap$co$nstant$in$cbor$model$SpecialType[SpecialType.SIMPLE_VALUE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L53:
            $SwitchMap$co$nstant$in$cbor$model$SpecialType[SpecialType.UNALLOCATED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L51:
            $SwitchMap$co$nstant$in$cbor$model$SpecialType[SpecialType.IEEE_754_HALF_PRECISION_FLOAT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L59:
            $SwitchMap$co$nstant$in$cbor$model$SpecialType[SpecialType.IEEE_754_SINGLE_PRECISION_FLOAT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L21
        L67:
            $SwitchMap$co$nstant$in$cbor$model$SpecialType[SpecialType.IEEE_754_DOUBLE_PRECISION_FLOAT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L25
        L73:
            $SwitchMap$co$nstant$in$cbor$model$SpecialType[SpecialType.SIMPLE_VALUE_NEXT_BYTE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L28
        L29:
            $SwitchMap$co$nstant$in$cbor$model$SimpleValueType = new int[SimpleValueType.values().length];
            $SwitchMap$co$nstant$in$cbor$model$SimpleValueType[SimpleValueType.FALSE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L32
        L63:
            $SwitchMap$co$nstant$in$cbor$model$SimpleValueType[SimpleValueType.NULL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L35
        L69:
            $SwitchMap$co$nstant$in$cbor$model$SimpleValueType[SimpleValueType.TRUE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L38
        L49:
            $SwitchMap$co$nstant$in$cbor$model$SimpleValueType[SimpleValueType.UNDEFINED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L41
        L55:
            $SwitchMap$co$nstant$in$cbor$model$SimpleValueType[SimpleValueType.UNALLOCATED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L44
        L61:
            $SwitchMap$co$nstant$in$cbor$model$SimpleValueType[SimpleValueType.RESERVED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L47
            return;
        }
    }

    @Override // co.nstant.in.cbor.encoder.AbstractEncoder
    public /* bridge */ /* synthetic */ void encode(Special r1) throws CborException {
        encode2(r1);
    }

    public SpecialEncoder(CborEncoder encoder, OutputStream outputStream) {
        super(encoder, outputStream);
        this.halfPrecisionFloatEncoder = new HalfPrecisionFloatEncoder(encoder, outputStream);
        this.singlePrecisionFloatEncoder = new SinglePrecisionFloatEncoder(encoder, outputStream);
        this.doublePrecisionFloatEncoder = new DoublePrecisionFloatEncoder(encoder, outputStream);
    }

    /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
    public void encode2(Special dataItem) throws CborException {
        switch(AnonymousClass1.$SwitchMap$co$nstant$in$cbor$model$SpecialType[dataItem.getSpecialType().ordinal()]) {
            case 1: goto L33;
            case 2: goto L27;
            case 3: goto L26;
            case 4: goto L21;
            case 5: goto L16;
            case 6: goto L11;
            case 7: goto L6;
            default: goto L39;
        };
    L27:
        SimpleValue simpleValue = (SimpleValue) dataItem;
        switch(AnonymousClass1.$SwitchMap$co$nstant$in$cbor$model$SimpleValueType[simpleValue.getSimpleValueType().ordinal()]) {
            case 1: goto L31;
            case 2: goto L31;
            case 3: goto L31;
            case 4: goto L31;
            case 5: goto L30;
            default: goto L42;
        };
    L30:
        write(simpleValue.getValue() | UsbDescriptor.CLASSID_WIRELESS);
        return;
    L31:
        SimpleValueType type = simpleValue.getSimpleValueType();
        write(type.getValue() | UsbDescriptor.CLASSID_WIRELESS);
        return;
    L42:
        return;
    L33:
        write(255);
        return;
    L39:
        return;
    L6:
        if ((dataItem instanceof SimpleValue) == false) goto L9;
        SimpleValue simpleValueNextByte = (SimpleValue) dataItem;
        write(FrameworkStatsLog.INTEGRITY_RULES_PUSHED);
        write(simpleValueNextByte.getValue());
        return;
    L9:
        throw new CborException("Wrong data item type");
    L11:
        if ((dataItem instanceof DoublePrecisionFloat) == false) goto L14;
        this.doublePrecisionFloatEncoder.encode2((DoublePrecisionFloat) dataItem);
        return;
    L14:
        throw new CborException("Wrong data item type");
    L16:
        if ((dataItem instanceof SinglePrecisionFloat) == false) goto L19;
        this.singlePrecisionFloatEncoder.encode2((SinglePrecisionFloat) dataItem);
        return;
    L19:
        throw new CborException("Wrong data item type");
    L21:
        if ((dataItem instanceof HalfPrecisionFloat) == false) goto L24;
        this.halfPrecisionFloatEncoder.encode2((HalfPrecisionFloat) dataItem);
        return;
    L24:
        throw new CborException("Wrong data item type");
    L26:
        throw new CborException("Unallocated special type");
    }
}
