package com.android.ttcjpaysdk.base.auth.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.baidu.platform.comapi.map.MapBundleKey;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B]\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0007¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012R\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/android/ttcjpaysdk/base/auth/data/TTCJPayAuthContent;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "business_brief_info", "Lcom/android/ttcjpaysdk/base/auth/data/TTCJPayDisplayContent;", "propose_desc", "", "propose_contents", "", "not_agreement_url", "authorize_item", "", "agreement_contents", "second_agreement_contents", "Lcom/android/ttcjpaysdk/base/auth/data/TTCJPayMultiAgreement;", "(Lcom/android/ttcjpaysdk/base/auth/data/TTCJPayDisplayContent;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;ILjava/util/List;Ljava/util/List;)V", "parseJson", "", MapBundleKey.MapObjKey.OBJ_SL_OBJ, "Lorg/json/JSONObject;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TTCJPayAuthContent implements CJPayObject {
    public List<TTCJPayDisplayContent> agreement_contents;
    public int authorize_item;
    public TTCJPayDisplayContent business_brief_info;
    public String not_agreement_url;
    public List<String> propose_contents;
    public String propose_desc;
    public List<TTCJPayMultiAgreement> second_agreement_contents;

    public TTCJPayAuthContent() {
        this(null, null, null, null, 0, null, null, 127, null);
    }

    public final void parseJson(JSONObject r110) {
        if (r110 == null) goto L22;
        this.business_brief_info.parseJson(r110.optJSONObject("business_brief_info"));
        this.propose_desc = r110.optString("propose_desc");
        this.not_agreement_url = r110.optString("not_agreement_url");
        if (r110.has("authorize_item") == false) goto L6;
        int r100 = r110.optInt("authorize_item");
    L7:
        this.authorize_item = r100;
        JSONArray r101 = r110.optJSONArray("propose_contents");
        int r102 = 0;
        if (r101 == null) goto L12;
        int r103 = r101.length();
        int r104 = 0;
    L10:
        if (r104 >= r103) goto L12;
        this.propose_contents.add(r101.optString(r104));
        r104 = r104 + 1;
    L12:
        JSONArray r105 = r110.optJSONArray("agreement_contents");
        if (r105 == null) goto L17;
        int r106 = r105.length();
        int r107 = 0;
    L15:
        if (r107 >= r106) goto L17;
        List<TTCJPayDisplayContent> r108 = this.agreement_contents;
        TTCJPayDisplayContent r109 = new TTCJPayDisplayContent(null, null, 3, null);
        r109.parseJson(r105.optJSONObject(r107));
        r108.add(r109);
        r107 = r107 + 1;
    L17:
        JSONArray r111 = r110.optJSONArray("second_agreement_contents");
        if (r111 == null) goto L26;
        int r112 = r111.length();
    L20:
        if (r102 >= r112) goto L27;
        List<TTCJPayMultiAgreement> r113 = this.second_agreement_contents;
        TTCJPayMultiAgreement r114 = new TTCJPayMultiAgreement(null, null, 3, null);
        r114.parseJson(r111.optJSONObject(r102));
        r113.add(r114);
        r102 = r102 + 1;
        goto L20
    L27:
        return;
    L26:
        return;
    L6:
        r100 = 1;
        goto L7
    }

    public TTCJPayAuthContent(TTCJPayDisplayContent r100, String r101, List<String> r102, String r103, int r104, List<TTCJPayDisplayContent> r105, List<TTCJPayMultiAgreement> r106) {
        Intrinsics.checkNotNullParameter(r100, "business_brief_info");
        Intrinsics.checkNotNullParameter(r101, "propose_desc");
        Intrinsics.checkNotNullParameter(r102, "propose_contents");
        Intrinsics.checkNotNullParameter(r103, "not_agreement_url");
        Intrinsics.checkNotNullParameter(r105, "agreement_contents");
        Intrinsics.checkNotNullParameter(r106, "second_agreement_contents");
        this.business_brief_info = r100;
        this.propose_desc = r101;
        this.propose_contents = r102;
        this.not_agreement_url = r103;
        this.authorize_item = r104;
        this.agreement_contents = r105;
        this.second_agreement_contents = r106;
    }

    public /* synthetic */ TTCJPayAuthContent(TTCJPayDisplayContent r100, String r101, List r110, String r111, int r112, List r113, List r114, int r115, DefaultConstructorMarker r116) {
        if ((r115 & 1) == 0) goto L5;
        TTCJPayDisplayContent r102 = new TTCJPayDisplayContent(null, null, 3, null);
    L6:
        String r103 = "";
        if ((r115 & 2) == 0) goto L9;
        String r104 = "";
    L11:
        if ((r115 & 4) == 0) goto L13;
        List r105 = new ArrayList();
    L15:
        if ((r115 & 8) != 0) goto L19;
        r103 = r111;
    L19:
        if ((r115 & 16) == 0) goto L21;
        int r106 = 1;
    L23:
        if ((r115 & 32) == 0) goto L25;
        List r107 = new ArrayList();
    L27:
        if ((r115 & 64) == 0) goto L29;
        List r108 = new ArrayList();
    L30:
        this(r102, r104, r105, r103, r106, r107, r108);
        return;
    L29:
        r108 = r114;
        goto L30
    L25:
        r107 = r113;
        goto L27
    L21:
        r106 = r112;
        goto L23
    L13:
        r105 = r110;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r102 = r100;
        goto L6
    }
}
