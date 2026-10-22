package com.android.ttcjpaysdk.base.auth.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/base/auth/data/CJPayProtocol;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "()V", "group", "", "name", "protocol_no", "template_url", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayProtocol implements CJPayObject {
    public String group;
    public String name;
    public String protocol_no;
    public String template_url;

    public CJPayProtocol() {
        this.protocol_no = "";
        this.name = "";
        this.template_url = "";
        this.group = "";
    }
}
