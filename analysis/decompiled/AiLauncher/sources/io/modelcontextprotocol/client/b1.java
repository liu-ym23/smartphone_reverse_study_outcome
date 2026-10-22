package io.modelcontextprotocol.client;

import com.autonavi.aps.amapapi.config.Const;

/* loaded from: classes4.dex */
public final /* synthetic */ class b1 {
    public static /* synthetic */ String a(Object[] objArr, Class cls, String str) {
        String[] strArrSplit = str.length() == 0 ? new String[0] : str.split(Const.STR_MART_SEMICOLON);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(cls.getSimpleName());
        sb2.append("[");
        for (int i10 = 0; i10 < strArrSplit.length; i10++) {
            sb2.append(strArrSplit[i10]);
            sb2.append("=");
            sb2.append(objArr[i10]);
            if (i10 != strArrSplit.length - 1) {
                sb2.append(", ");
            }
        }
        sb2.append("]");
        return sb2.toString();
    }
}
