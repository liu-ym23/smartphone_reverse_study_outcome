package com.android.ttcjpaysdk.base.service.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002BG\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004¢\u0006\u0002\u0010\rJ\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0004R\u0012\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/bean/WxH5PayConfig;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "schema", "", "schema_host", "enable_config", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/service/bean/WxH5PayEnableConfig;", "Lkotlin/collections/ArrayList;", "use_ab", "", "ab_key", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;ZLjava/lang/String;)V", "isWxH5PayUseAnnieX", "openFrom", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WxH5PayConfig implements CJPayObject, Serializable {
    public String ab_key;
    public ArrayList<WxH5PayEnableConfig> enable_config;
    public String schema;
    public String schema_host;
    public boolean use_ab;

    public WxH5PayConfig() {
        this(null, null, null, false, null, 31, null);
    }

    public final boolean isWxH5PayUseAnnieX(String r100) {
        Intrinsics.checkNotNullParameter(r100, "openFrom");
        ArrayList<WxH5PayEnableConfig> r101 = this.enable_config;
        if ((r101 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r102 = r101.iterator();
    L9:
        if (r102.hasNext() == false) goto L18;
        if (((WxH5PayEnableConfig) r102.next()).isEnable(r100) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r101.isEmpty() == false) goto L7;
        return false;
    }

    public WxH5PayConfig(String r100, String r101, ArrayList<WxH5PayEnableConfig> r102, boolean r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r101, "schema_host");
        Intrinsics.checkNotNullParameter(r102, "enable_config");
        Intrinsics.checkNotNullParameter(r104, "ab_key");
        this.schema = r100;
        this.schema_host = r101;
        this.enable_config = r102;
        this.use_ab = r103;
        this.ab_key = r104;
    }

    public /* synthetic */ WxH5PayConfig(String r100, String r101, ArrayList r102, boolean r103, String r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = "";
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r105 = "";
    L11:
        if ((r110 & 4) == 0) goto L13;
        r102 = new ArrayList();
    L13:
        ArrayList r106 = r102;
        if ((r110 & 8) == 0) goto L16;
        boolean r107 = false;
    L18:
        if ((r110 & 16) == 0) goto L20;
        String r113 = "";
    L21:
        this(r112, r105, r106, r107, r113);
        return;
    L20:
        r113 = r104;
        goto L21
    L16:
        r107 = r103;
        goto L18
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
