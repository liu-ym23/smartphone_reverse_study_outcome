package com.autonavi.aps.protocol.aps.common.e;

import com.autonavi.aps.protocol.aps.common.enums.Version;
import com.autonavi.aps.protocol.aps.response.model.b.a;
import com.autonavi.aps.protocol.aps.response.model.vo.fields.FormatType;

/* loaded from: classes.dex */
public class b {
    public static byte[] a(byte[] bArr, Version version, a.C0216a c0216a, com.autonavi.aps.protocol.aps.authority.a aVar) {
        if (bArr == null) {
            return null;
        }
        if (c0216a.e()) {
            try {
                bArr = e.b(bArr);
            } catch (Exception unused) {
            }
        }
        FormatType formatTypeFromString = FormatType.fromString(c0216a.a());
        if (formatTypeFromString == FormatType.XML) {
            return c0216a.f() ? f.a(bArr) : c0216a.b() ? i.a(bArr, aVar.a().get(version).getBytes()) : bArr;
        }
        if (formatTypeFromString == FormatType.BIN) {
            return c0216a.b() ? i.a(bArr, aVar.a().get(version).getBytes()) : bArr;
        }
        if (formatTypeFromString != FormatType.JSON) {
            return (formatTypeFromString == FormatType.PB && c0216a.b()) ? i.a(bArr, aVar.a().get(version).getBytes()) : bArr;
        }
        if (c0216a.b()) {
            bArr = i.a(bArr, aVar.a().get(version).getBytes());
        }
        return c0216a.f() ? f.a(bArr) : bArr;
    }
}
