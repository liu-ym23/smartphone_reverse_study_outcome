package com.android.ttcjpaysdk.verify.data;

import android.util.Base64;
import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00030\nj\b\u0012\u0004\u0012\u00020\u0003`\u000bJ\u0006\u0010\f\u001a\u00020\rR\u0012\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/verify/data/DyVerifyToken;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "verify_flow", "", "product", "Lcom/android/ttcjpaysdk/verify/data/DyVerifyProduct;", "event_type", "domain", "(Ljava/lang/String;Lcom/android/ttcjpaysdk/verify/data/DyVerifyProduct;Ljava/lang/String;Ljava/lang/String;)V", "getVerifyList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "isValid", "", "Companion", "dy-verify-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DyVerifyToken implements CJPayObject {
    public static final Companion Companion = null;
    public String domain;
    public String event_type;
    public DyVerifyProduct product;
    public String verify_flow;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/verify/data/DyVerifyToken$Companion;", "", "()V", "getVerifyToken", "Lcom/android/ttcjpaysdk/verify/data/DyVerifyToken;", "token", "", "dy-verify-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final DyVerifyToken getVerifyToken(String r110) {
            if (r110 != null) goto L20;
        L14:
            DyVerifyToken r111 = new DyVerifyToken(null, null, null, null, 15, null);     // Catch: Exception -> L16
        L19:
            return r111;
        L16:
            e = move-exception;
            CJBasicCommonUtils.reportCatchException("DyVerifyToken#getVerifyToken", e);
            CJBasicCommonUtils.logCatch("CJCatch", "DyVerifyToken#getVerifyToken", e);
            return new DyVerifyToken(null, null, null, null, 15, null);
        L20:
            if (r110.length() <= 0) goto L6;
            boolean r100 = true;
        L7:
            if (r100 == true) goto L10;
            r110 = null;
        L10:
            if (r110 == null) goto L14;
            r111 = (DyVerifyToken) CJPayJsonParser.fromJson(new String(Base64.decode(r110, 2), Charsets.UTF_8), DyVerifyToken.class);     // Catch: Exception -> L16
            if (r111 != null) goto L19;
            r111 = new DyVerifyToken(null, null, null, null, 15, null);     // Catch: Exception -> L16
            goto L19
        L6:
            r100 = false;
            goto L7
        }
    }

    static {
        Companion = new Companion(null);
    }

    public DyVerifyToken() {
        this(null, null, null, null, 15, null);
    }

    public final ArrayList<String> getVerifyList() {
    L13:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("DyVerifyToken#getVerifyList", th);
        CJBasicCommonUtils.logCatch("CJCatch", "DyVerifyToken#getVerifyList", th);
        return new ArrayList();
    L3:
        if ((!StringsKt.isBlank(this.verify_flow)) == false) goto L23;
        List r100 = StringsKt.split$default(new Regex("\\s").replace(this.verify_flow, ""), new String[]{"&&"}, false, 0, 6, null);     // Catch: Throwable -> L13
        ArrayList r101 = new ArrayList();     // Catch: Throwable -> L13
        Iterator r102 = r100.iterator();     // Catch: Throwable -> L13
    L6:
        if (r102.hasNext() == false) goto L22;
        Object r103 = r102.next();     // Catch: Throwable -> L13
        if ((!StringsKt.isBlank((String) r103)) == false) goto L6;
        r101.add(r103);     // Catch: Throwable -> L13
        goto L6
    L22:
        return new ArrayList(r101);
    L23:
        return new ArrayList();
    }

    public final boolean isValid() {
        if (this.verify_flow.length() <= 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L8;
    L10:
        return false;
    L8:
        if (this.product.isValid(getVerifyList()) == false) goto L10;
        return true;
    L5:
        r100 = false;
        goto L6
    }

    public DyVerifyToken(String r100, DyVerifyProduct r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "verify_flow");
        Intrinsics.checkNotNullParameter(r101, "product");
        Intrinsics.checkNotNullParameter(r102, "event_type");
        Intrinsics.checkNotNullParameter(r103, "domain");
        this.verify_flow = r100;
        this.product = r101;
        this.event_type = r102;
        this.domain = r103;
    }

    public /* synthetic */ DyVerifyToken(String r110, DyVerifyProduct r210, String r211, String r212, int r213, DefaultConstructorMarker r214) {
        String r100 = "";
        if ((r213 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r213 & 2) == 0) goto L9;
        DyVerifyProduct r102 = new DyVerifyProduct(null, null, null, null, null, null, null, null, null, null, null, null, UnixStat.PERM_MASK, null);
    L11:
        if ((r213 & 4) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r213 & 8) != 0) goto L18;
        r100 = r212;
    L18:
        this(r101, r102, r103, r100);
        return;
    L13:
        r103 = r211;
        goto L15
    L9:
        r102 = r210;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
