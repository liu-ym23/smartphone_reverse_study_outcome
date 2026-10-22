package ax4;

import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.contract.net.SimpleRequestResult;

/* JADX INFO: loaded from: classes16.dex */
public final class f implements NetService.c<SimpleRequestResult> {
    public f() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r100) throws NetService.ParseException {
        return (SimpleRequestResult) JSON.parseObject(r100, SimpleRequestResult.class);
    }
}
