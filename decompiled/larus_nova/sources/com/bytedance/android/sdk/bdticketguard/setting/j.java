package com.bytedance.android.sdk.bdticketguard.setting;

import com.bytedance.android.sdk.bdticketguard.r0;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends a<List<? extends String>> {
    public j(List r100, Function0 r101) {
        super("bd_ticket_guard_pubkey_recovery_methods", r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.util.List<? extends java.lang.String>] */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.util.List<? extends java.lang.String>] */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.util.ArrayList] */
    @Override // com.bytedance.android.sdk.bdticketguard.setting.a
    public final List<? extends String> b(JSONObject r100, String r101, List<? extends String> r102) {
        ?? r103 = (List) r102;
        if (r100 == null) goto L5;
        JSONArray r104 = r100.optJSONArray(r101);
    L6:
        if (r104 == null) goto L15;
        r103 = new ArrayList(r104.length());
        int r105 = r104.length();
        int r106 = 0;
    L9:
        if (r106 >= r105) goto L15;
        r103.add(JSONArrayProtectorUtils.getString(r104, r106));     // Catch: Exception -> L12
    L14:
        r106 = r106 + 1;
    L12:
        e = move-exception;
        int r107 = r0.f163979a;
        r0.d(6, "TicketGuardSettings", "parse StringList " + r101 + " error", e);
    L15:
        return r103;
    L5:
        r104 = null;
        goto L6
    }
}
