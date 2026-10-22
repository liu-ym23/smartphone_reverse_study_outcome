package com.android.ttcjpaysdk.base.service.bean;

import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \t2\u00020\u0001:\u0001\tB3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0006j\b\u0012\u0004\u0012\u00020\u0003`\u0007¢\u0006\u0002\u0010\bR\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0006j\b\u0012\u0004\u0012\u00020\u0003`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/bean/ReuseHostDomain;", "", "bd_host_domain", "", "integrated_host_domain", "h5_path_list", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ReuseHostDomain {
    public static final Companion Companion = null;
    public String bd_host_domain;
    public ArrayList<String> h5_path_list;
    public String integrated_host_domain;

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/bean/ReuseHostDomain$Companion;", "", "()V", "fromJson", "Lcom/android/ttcjpaysdk/base/service/bean/ReuseHostDomain;", "jsonString", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public final ReuseHostDomain fromJson(String r100) {
            Intrinsics.checkNotNullParameter(r100, "jsonString");
            ReuseHostDomain r101 = new ReuseHostDomain(null, null, null, 7, null);
            JSONObject r102 = new JSONObject(r100);     // Catch: Exception -> L5
            r101.bd_host_domain = r102.optString("bd_host_domain");     // Catch: Exception -> L5
            r101.integrated_host_domain = r102.optString("integrated_host_domain");     // Catch: Exception -> L5
            ReuseHostDomainKt.toStringList(r102.optJSONArray("h5_path_list"), r101.h5_path_list);     // Catch: Exception -> L5
        L7:
            return r101;
        L5:
            e = move-exception;
            CJBasicCommonUtils.reportCatchException("ReuseHostDomain#fromJson", e);
            CJBasicCommonUtils.logCatch("CJCatch", "ReuseHostDomain#fromJson", e);
            e.printStackTrace();
            goto L7
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ReuseHostDomain() {
        this(null, null, null, 7, null);
    }

    @JvmStatic
    public static final ReuseHostDomain fromJson(String r100) {
        return Companion.fromJson(r100);
    }

    public ReuseHostDomain(String r100, String r101, ArrayList<String> r102) {
        Intrinsics.checkNotNullParameter(r100, "bd_host_domain");
        Intrinsics.checkNotNullParameter(r101, "integrated_host_domain");
        Intrinsics.checkNotNullParameter(r102, "h5_path_list");
        this.bd_host_domain = r100;
        this.integrated_host_domain = r101;
        this.h5_path_list = r102;
    }

    public /* synthetic */ ReuseHostDomain(String r100, String r101, ArrayList r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = new ArrayList();
    L11:
        this(r100, r101, r102);
    }
}
