package com.android.ttcjpaysdk.thirdparty.fingerprint.utils;

import android.text.TextUtils;
import com.alipay.sdk.m.k.b;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.android.ttcjpaysdk.thirdparty.fingerprint.CJPayFingerprintPresenter;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\bJ\"\u0010\u0010\u001a\u00020\u00002\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006J\u0010\u0010\u0011\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0012\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0013\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0014\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0015\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0016\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\bR\"\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/fingerprint/utils/FingerprintParamsBuilder;", "", "()V", "bioIdArray", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "encryptedPwd", "", "key", "memberBizOrderNo", "source", "token", "tradeNo", "uid", "build", "setBioIdArray", "setEncryptedPwd", "setKey", "setMemberBizOrderNo", "setSource", "setTradeNo", "setUid", "bdpay-fingerprint_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FingerprintParamsBuilder {
    private ArrayList<Integer> bioIdArray;
    private String encryptedPwd;
    private String key;
    private String memberBizOrderNo;
    private String source;
    private String token;
    private String tradeNo;
    private String uid;

    public FingerprintParamsBuilder() {
    }

    public final String build() {
        JSONObject r100 = CJPayFingerprintPresenter.buildCommonParams(this.uid);
        String r101 = this.encryptedPwd;     // Catch: JSONException -> L40
        if (r101 == null) goto L7;
        r100.put("mobile_pwd", r101);     // Catch: JSONException -> L40
    L7:
        String r102 = this.key;     // Catch: JSONException -> L40
        if (r102 == null) goto L11;
        r100.put("key", r102);     // Catch: JSONException -> L40
    L11:
        String r103 = this.token;     // Catch: JSONException -> L40
        if (r103 == null) goto L14;
        r100.put("token", r103);     // Catch: JSONException -> L40
    L14:
        String r104 = this.memberBizOrderNo;     // Catch: JSONException -> L40
        if (r104 == null) goto L17;
        r100.put("member_biz_order_no", r104);     // Catch: JSONException -> L40
    L17:
        r100.put("is_jail_broken", CJPayBasicUtils.isJailBroken());     // Catch: JSONException -> L40
        HashMap r105 = new HashMap();     // Catch: JSONException -> L40
        if (TextUtils.isEmpty(this.tradeNo) == true) goto L20;
        String r106 = this.tradeNo;     // Catch: JSONException -> L40
        Intrinsics.checkNotNull(r106);     // Catch: JSONException -> L40
        r105.put(b.B0, r106);     // Catch: JSONException -> L40
    L20:
        ArrayList<Integer> r107 = this.bioIdArray;     // Catch: JSONException -> L40
        if (r107 == null) goto L26;
        Intrinsics.checkNotNull(r107);     // Catch: JSONException -> L40
        if (r107.size() <= 0) goto L26;
        r105.put("bio_ids", String.valueOf(this.bioIdArray));     // Catch: JSONException -> L40
    L26:
        if (TextUtils.isEmpty(this.source) == true) goto L29;
        String r108 = this.source;     // Catch: JSONException -> L40
        Intrinsics.checkNotNull(r108);     // Catch: JSONException -> L40
        r105.put("source", r108);     // Catch: JSONException -> L40
    L29:
        if ((!r105.isEmpty()) == false) goto L31;
        r100.put("exts", CJPayFingerprintPresenter.mapToJSONObj(r105));     // Catch: JSONException -> L40
    L31:
        ArrayList r109 = new ArrayList();     // Catch: JSONException -> L40
        if (TextUtils.isEmpty(this.token) == true) goto L35;
        r109.add("key");     // Catch: JSONException -> L40
    L38:
        CJPayFingerprintPresenter.buildSecureParams(r100, r109);     // Catch: JSONException -> L40
    L43:
        return CJPayFingerprintPresenter.massageBase64Str(r100.toString());
    L35:
        if (TextUtils.isEmpty(this.memberBizOrderNo) == false) goto L37;
        r109.add("mobile_pwd");     // Catch: JSONException -> L40
        goto L38
    L37:
        r109.add("key");     // Catch: JSONException -> L40
    L40:
        e = move-exception;
        e.printStackTrace();
        goto L43
    }

    public final FingerprintParamsBuilder setBioIdArray(ArrayList<Integer> r100) {
        this.bioIdArray = r100;
        return this;
    }

    public final FingerprintParamsBuilder setEncryptedPwd(String r100) {
        this.encryptedPwd = r100;
        return this;
    }

    public final FingerprintParamsBuilder setKey(String r100) {
        this.key = r100;
        return this;
    }

    public final FingerprintParamsBuilder setMemberBizOrderNo(String r100) {
        this.memberBizOrderNo = r100;
        return this;
    }

    public final FingerprintParamsBuilder setSource(String r100) {
        this.source = r100;
        return this;
    }

    public final FingerprintParamsBuilder setTradeNo(String r100) {
        this.tradeNo = r100;
        return this;
    }

    public final FingerprintParamsBuilder setUid(String r100) {
        this.uid = r100;
        return this;
    }
}
