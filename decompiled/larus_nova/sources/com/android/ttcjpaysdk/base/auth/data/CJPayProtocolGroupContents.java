package com.android.ttcjpaysdk.base.auth.data;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00070\fj\b\u0012\u0004\u0012\u00020\u0007`\r2\u0006\u0010\u000e\u001a\u00020\u0004J\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000e\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u0011R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/android/ttcjpaysdk/base/auth/data/CJPayProtocolGroupContents;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "()V", "guide_message", "", "protocol_check_box", "protocol_group_names", "Lorg/json/JSONObject;", "protocol_list", "", "Lcom/android/ttcjpaysdk/base/auth/data/CJPayProtocol;", "getProtocolJsonListByGroup", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "groupName", "getProtocolListByGroup", "isNeedCheckBox", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayProtocolGroupContents implements CJPayObject {
    public String guide_message;
    public String protocol_check_box;
    public JSONObject protocol_group_names;
    public List<CJPayProtocol> protocol_list;

    public final boolean isNeedCheckBox() {
        return Intrinsics.areEqual("1", this.protocol_check_box);
    }

    public CJPayProtocolGroupContents() {
        this.guide_message = "";
        this.protocol_check_box = "1";
        this.protocol_group_names = new JSONObject();
        this.protocol_list = new ArrayList();
    }

    public final ArrayList<JSONObject> getProtocolJsonListByGroup(String r100) {
        Intrinsics.checkNotNullParameter(r100, "groupName");
        ArrayList<JSONObject> r101 = new ArrayList();
        List<CJPayProtocol> r102 = this.protocol_list;
        if (r102 == null) goto L12;
        Iterator<CJPayProtocol> r103 = r102.iterator();
    L6:
        if (r103.hasNext() == false) goto L12;
        CJPayProtocol r104 = r103.next();
        if (TextUtils.equals(r100, r104.group) == false) goto L6;
        JSONObject r105 = CJPayJsonParser.toJsonObject(r104);
        if (r105 == null) goto L6;
        r101.add(r105);
    L12:
        return r101;
    }

    public final List<CJPayProtocol> getProtocolListByGroup(String r100) {
        Intrinsics.checkNotNullParameter(r100, "groupName");
        ArrayList r101 = new ArrayList();
        List<CJPayProtocol> r102 = this.protocol_list;
        if (r102 == null) goto L10;
        Iterator<CJPayProtocol> r103 = r102.iterator();
    L6:
        if (r103.hasNext() == false) goto L10;
        CJPayProtocol r104 = r103.next();
        if (TextUtils.equals(r100, r104.group) == false) goto L6;
        r101.add(r104);
    L10:
        return r101;
    }
}
