package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONObject;
import com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;

/* JADX INFO: loaded from: classes28.dex */
public class JSONLibDataFormatSerializer implements ObjectSerializer {
    public JSONLibDataFormatSerializer() {
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer r100, Object r101, Object r102, Type r103, int r104) throws IOException {
        if (r101 != null) goto L5;
        r100.out.writeNull();
        return;
    L5:
        Date r105 = (Date) r101;
        JSONObject r106 = new JSONObject();
        r106.put2("date", Integer.valueOf(r105.getDate()));
        r106.put2(BdpGameHostBaseUIService.DATE_PICKER_TYPE_DAY, Integer.valueOf(r105.getDay()));
        r106.put2("hours", Integer.valueOf(r105.getHours()));
        r106.put2(DocumentType.MINUTES_NAME, Integer.valueOf(r105.getMinutes()));
        r106.put2(BdpGameHostBaseUIService.DATE_PICKER_TYPE_MONTH, Integer.valueOf(r105.getMonth()));
        r106.put2("seconds", Integer.valueOf(r105.getSeconds()));
        r106.put2("time", Long.valueOf(r105.getTime()));
        r106.put2("timezoneOffset", Integer.valueOf(r105.getTimezoneOffset()));
        r106.put2(BdpGameHostBaseUIService.DATE_PICKER_TYPE_YEAR, Integer.valueOf(r105.getYear()));
        r100.write(r106);
    }
}
