package com.zyql.common.utils.update.model;

import A9.d;
import A9.e;
import A9.f;
import B9.A;
import B9.V;
import B9.d0;
import B9.h0;
import C7.c;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import g1.AbstractC1451a;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import kotlinx.serialization.UnknownFieldException;
import x9.b;
import z9.g;

@Metadata(d1 = {"\u0000@\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000*\u0004\b\u0001\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00030\u0002B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0017\b\u0016\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bJ#\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0013¢\u0006\u0004\b\u0016\u0010\u0015R\u0017\u0010\u0018\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"com/zyql/common/utils/update/model/BaseResponse.$serializer", ExifInterface.GPS_DIRECTION_TRUE, "LB9/A;", "Lcom/zyql/common/utils/update/model/BaseResponse;", AppAgent.CONSTRUCT, "()V", "Lx9/b;", "typeSerial0", "(Lx9/b;)V", "LA9/f;", "encoder", "value", "LC7/r;", "serialize", "(LA9/f;Lcom/zyql/common/utils/update/model/BaseResponse;)V", "LA9/e;", "decoder", "deserialize", "(LA9/e;)Lcom/zyql/common/utils/update/model/BaseResponse;", "", "childSerializers", "()[Lx9/b;", "typeParametersSerializers", "Lz9/g;", "descriptor", "Lz9/g;", "getDescriptor", "()Lz9/g;", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@c
/* loaded from: classes3.dex */
public /* synthetic */ class BaseResponse$$serializer<T> implements A {
    private final g descriptor;
    private final /* synthetic */ b typeSerial0;

    private BaseResponse$$serializer() {
        V v10 = new V("com.zyql.common.utils.update.model.BaseResponse", this, 3);
        v10.j("code", false);
        v10.j(NotificationCompat.CATEGORY_MESSAGE, true);
        v10.j(SettingsConfig.KEY_DATA, true);
        this.descriptor = v10;
    }

    private final /* synthetic */ b getTypeSerial0() {
        return this.typeSerial0;
    }

    @Override // B9.A
    public final b[] childSerializers() {
        h0 h0Var = h0.f242a;
        return new b[]{h0Var, AbstractC1451a.G(h0Var), AbstractC1451a.G(this.typeSerial0)};
    }

    @Override // x9.InterfaceC2123a
    public final BaseResponse<T> deserialize(e decoder) {
        int i;
        String str;
        String str2;
        Object objDecodeNullableSerializableElement;
        k.f(decoder, "decoder");
        g gVar = this.descriptor;
        A9.c cVarBeginStructure = decoder.beginStructure(gVar);
        String strDecodeStringElement = null;
        if (cVarBeginStructure.decodeSequentially()) {
            String strDecodeStringElement2 = cVarBeginStructure.decodeStringElement(gVar, 0);
            String str3 = (String) cVarBeginStructure.decodeNullableSerializableElement(gVar, 1, h0.f242a, null);
            objDecodeNullableSerializableElement = cVarBeginStructure.decodeNullableSerializableElement(gVar, 2, this.typeSerial0, null);
            str = strDecodeStringElement2;
            i = 7;
            str2 = str3;
        } else {
            boolean z10 = true;
            int i6 = 0;
            String str4 = null;
            Object objDecodeNullableSerializableElement2 = null;
            while (z10) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(gVar);
                if (iDecodeElementIndex == -1) {
                    z10 = false;
                } else if (iDecodeElementIndex == 0) {
                    strDecodeStringElement = cVarBeginStructure.decodeStringElement(gVar, 0);
                    i6 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    str4 = (String) cVarBeginStructure.decodeNullableSerializableElement(gVar, 1, h0.f242a, str4);
                    i6 |= 2;
                } else {
                    if (iDecodeElementIndex != 2) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    objDecodeNullableSerializableElement2 = cVarBeginStructure.decodeNullableSerializableElement(gVar, 2, this.typeSerial0, objDecodeNullableSerializableElement2);
                    i6 |= 4;
                }
            }
            i = i6;
            str = strDecodeStringElement;
            str2 = str4;
            objDecodeNullableSerializableElement = objDecodeNullableSerializableElement2;
        }
        cVarBeginStructure.endStructure(gVar);
        return new BaseResponse<>(i, str, str2, objDecodeNullableSerializableElement, (d0) null);
    }

    @Override // x9.f, x9.InterfaceC2123a
    public final g getDescriptor() {
        return this.descriptor;
    }

    @Override // x9.f
    public final void serialize(f encoder, BaseResponse<T> value) {
        k.f(encoder, "encoder");
        k.f(value, "value");
        g gVar = this.descriptor;
        d dVarBeginStructure = encoder.beginStructure(gVar);
        BaseResponse.write$Self$utils_release(value, dVarBeginStructure, gVar, this.typeSerial0);
        dVarBeginStructure.endStructure(gVar);
    }

    @Override // B9.A
    public final b[] typeParametersSerializers() {
        return new b[]{this.typeSerial0};
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseResponse$$serializer(b typeSerial0) {
        this();
        k.f(typeSerial0, "typeSerial0");
        this.typeSerial0 = typeSerial0;
    }
}
