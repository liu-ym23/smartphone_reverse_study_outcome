package com.android.ttcjpaysdk.kmp.base.http;

import com.byted.cast.common.Constants;
import jd6.d;
import kotlin.Metadata;
import okio.BufferedSink;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b¸\u0006\u0000"}, d2 = {"com/bytedance/kmp/network/KmpNetworkManagerImpl$postString$2", "Lcom/bytedance/kmp/network/requet/RequestBody;", "contentType", "", "writeTo", "", Constants.ROLE_SINK, "Lokio/BufferedSink;", "network_service_release"}, k = 1, mv = {2, 1, 0}, xi = 176)
public final class CJNetworkManager$postString$$inlined$postString$default$1 extends d {
    final /* synthetic */ String $content;
    final /* synthetic */ String $contentType;

    @Override // jd6.d
    public String contentType() {
        return this.$contentType;
    }

    @Override // jd6.d
    public void writeTo(BufferedSink r100) {
        if (r100 == null) goto L4;
        r100.writeUtf8(this.$content);
    L4:
        if (r100 == null) goto L7;
        r100.flush();
        return;
    }

    public CJNetworkManager$postString$$inlined$postString$default$1(String r100, String r101) {
        this.$contentType = r100;
        this.$content = r101;
    }
}
