package com.android.ttcjpaysdk.base.ui.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\t\u001a\u00020\nR\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/FinanceRisk;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "data", "", "compress_type", "encrypt_type", "version_code", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "toJson", "Lorg/json/JSONObject;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FinanceRisk implements CJPayObject {
    public String compress_type;
    public String data;
    public String encrypt_type;
    public int version_code;

    public FinanceRisk() {
        this(null, null, null, 0, 15, null);
    }

    public final JSONObject toJson() {
        JSONObject r100 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r100, "data", this.data);
        KtSafeMethodExtensionKt.safePut(r100, "compress_type", this.compress_type);
        KtSafeMethodExtensionKt.safePut(r100, "encrypt_type", this.encrypt_type);
        KtSafeMethodExtensionKt.safePut(r100, "version_code", Integer.valueOf(this.version_code));
        return r100;
    }

    public FinanceRisk(String r100, String r101, String r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "compress_type");
        Intrinsics.checkNotNullParameter(r102, "encrypt_type");
        this.data = r100;
        this.compress_type = r101;
        this.encrypt_type = r102;
        this.version_code = r103;
    }

    public /* synthetic */ FinanceRisk(String r100, String r101, String r102, int r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = "";
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = -1;
    L14:
        this(r100, r101, r102, r103);
    }
}
