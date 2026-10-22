package io.ktor.util.date;

import Y8.h;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import lb.InterfaceC4883a;
import ob.c;
import ob.d;
import pb.C5101i0;
import pb.I0;
import pb.M;
import pb.X;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"io/ktor/util/date/GMTDate.$serializer", "Lpb/M;", "Lio/ktor/util/date/GMTDate;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", UxipConstants.f30680s, "LY8/t;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lio/ktor/util/date/GMTDate;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lio/ktor/util/date/GMTDate;", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "ktor-utils"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* synthetic */ class GMTDate$$serializer implements M<GMTDate> {
    public static final GMTDate$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        GMTDate$$serializer gMTDate$$serializer = new GMTDate$$serializer();
        INSTANCE = gMTDate$$serializer;
        I0 i02 = new I0("io.ktor.util.date.GMTDate", gMTDate$$serializer, 9);
        i02.n("seconds", false);
        i02.n("minutes", false);
        i02.n("hours", false);
        i02.n("dayOfWeek", false);
        i02.n("dayOfMonth", false);
        i02.n("dayOfYear", false);
        i02.n("month", false);
        i02.n("year", false);
        i02.n("timestamp", false);
        descriptor = i02;
    }

    private GMTDate$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // pb.M
    public final KSerializer<?>[] childSerializers() {
        h[] hVarArr = GMTDate.$childSerializers;
        X x10 = X.f38325a;
        return new KSerializer[]{x10, x10, x10, hVarArr[3].getValue(), x10, x10, hVarArr[6].getValue(), x10, C5101i0.f38365a};
    }

    @Override // lb.InterfaceC4883a
    public final GMTDate deserialize(Decoder decoder) {
        int iDecodeIntElement;
        Month month;
        WeekDay weekDay;
        int iDecodeIntElement2;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        long jDecodeLongElement;
        p.i(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        c cVarBeginStructure = decoder.beginStructure(serialDescriptor);
        h[] hVarArr = GMTDate.$childSerializers;
        int i15 = 7;
        if (cVarBeginStructure.decodeSequentially()) {
            iDecodeIntElement = cVarBeginStructure.decodeIntElement(serialDescriptor, 0);
            int iDecodeIntElement3 = cVarBeginStructure.decodeIntElement(serialDescriptor, 1);
            int iDecodeIntElement4 = cVarBeginStructure.decodeIntElement(serialDescriptor, 2);
            WeekDay weekDay2 = (WeekDay) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 3, (InterfaceC4883a) hVarArr[3].getValue(), null);
            int iDecodeIntElement5 = cVarBeginStructure.decodeIntElement(serialDescriptor, 4);
            int iDecodeIntElement6 = cVarBeginStructure.decodeIntElement(serialDescriptor, 5);
            month = (Month) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 6, (InterfaceC4883a) hVarArr[6].getValue(), null);
            iDecodeIntElement2 = cVarBeginStructure.decodeIntElement(serialDescriptor, 7);
            i10 = iDecodeIntElement6;
            i11 = 511;
            i12 = iDecodeIntElement5;
            i13 = iDecodeIntElement4;
            weekDay = weekDay2;
            i14 = iDecodeIntElement3;
            jDecodeLongElement = cVarBeginStructure.decodeLongElement(serialDescriptor, 8);
        } else {
            boolean z10 = true;
            iDecodeIntElement = 0;
            int iDecodeIntElement7 = 0;
            int iDecodeIntElement8 = 0;
            int iDecodeIntElement9 = 0;
            Month month2 = null;
            long jDecodeLongElement2 = 0;
            int iDecodeIntElement10 = 0;
            int iDecodeIntElement11 = 0;
            int i16 = 0;
            WeekDay weekDay3 = null;
            while (z10) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case -1:
                        z10 = false;
                    case 0:
                        i16 |= 1;
                        iDecodeIntElement = cVarBeginStructure.decodeIntElement(serialDescriptor, 0);
                        i15 = 7;
                    case 1:
                        iDecodeIntElement9 = cVarBeginStructure.decodeIntElement(serialDescriptor, 1);
                        i16 |= 2;
                        i15 = 7;
                    case 2:
                        iDecodeIntElement8 = cVarBeginStructure.decodeIntElement(serialDescriptor, 2);
                        i16 |= 4;
                    case 3:
                        weekDay3 = (WeekDay) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 3, (InterfaceC4883a) hVarArr[3].getValue(), weekDay3);
                        i16 |= 8;
                    case 4:
                        iDecodeIntElement7 = cVarBeginStructure.decodeIntElement(serialDescriptor, 4);
                        i16 |= 16;
                    case 5:
                        iDecodeIntElement11 = cVarBeginStructure.decodeIntElement(serialDescriptor, 5);
                        i16 |= 32;
                    case 6:
                        month2 = (Month) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 6, (InterfaceC4883a) hVarArr[6].getValue(), month2);
                        i16 |= 64;
                    case 7:
                        iDecodeIntElement10 = cVarBeginStructure.decodeIntElement(serialDescriptor, i15);
                        i16 |= 128;
                    case 8:
                        jDecodeLongElement2 = cVarBeginStructure.decodeLongElement(serialDescriptor, 8);
                        i16 |= 256;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            month = month2;
            weekDay = weekDay3;
            iDecodeIntElement2 = iDecodeIntElement10;
            i10 = iDecodeIntElement11;
            i11 = i16;
            i12 = iDecodeIntElement7;
            i13 = iDecodeIntElement8;
            i14 = iDecodeIntElement9;
            jDecodeLongElement = jDecodeLongElement2;
        }
        int i17 = iDecodeIntElement;
        cVarBeginStructure.endStructure(serialDescriptor);
        return new GMTDate(i11, i17, i14, i13, weekDay, i12, i10, month, iDecodeIntElement2, jDecodeLongElement, null);
    }

    @Override // kotlinx.serialization.KSerializer, lb.m, lb.InterfaceC4883a
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // lb.m
    public final void serialize(Encoder encoder, GMTDate value) {
        p.i(encoder, "encoder");
        p.i(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        d dVarBeginStructure = encoder.beginStructure(serialDescriptor);
        GMTDate.write$Self$ktor_utils(value, dVarBeginStructure, serialDescriptor);
        dVarBeginStructure.endStructure(serialDescriptor);
    }

    @Override // pb.M
    public KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
