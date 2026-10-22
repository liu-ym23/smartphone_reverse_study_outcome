package ax4;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.contract.net.DefaultResponse;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements NetService.c<DefaultResponse> {
    public a() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r100) throws NetService.ParseException {
        return new DefaultResponse(r100);
    }
}
