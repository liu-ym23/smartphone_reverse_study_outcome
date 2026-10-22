package com.android.ttcjpaysdk.base.auth.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/base/auth/data/CJPayAuthContent;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "()V", "business_brief_info", "Lcom/android/ttcjpaysdk/base/auth/data/TTCJPayDisplayContent;", "not_agreement_content", "", "not_agreement_url", "propose_contents", "", "propose_desc", "tips_content", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayAuthContent implements CJPayObject {
    public TTCJPayDisplayContent business_brief_info;
    public String not_agreement_content;
    public String not_agreement_url;
    public List<String> propose_contents;
    public String propose_desc;
    public String tips_content;

    public CJPayAuthContent() {
        this.business_brief_info = new TTCJPayDisplayContent(null, null, 3, null);
        this.propose_desc = "";
        this.propose_contents = new ArrayList();
        this.not_agreement_url = "";
        this.not_agreement_content = "";
        this.tips_content = "";
    }
}
