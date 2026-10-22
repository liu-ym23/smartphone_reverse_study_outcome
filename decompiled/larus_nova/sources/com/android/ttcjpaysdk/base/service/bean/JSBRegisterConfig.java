package com.android.ttcjpaysdk.base.service.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.ktextension.CJSchemaExtensionKt;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\rB)\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\u0002\u0010\tJ\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fR\"\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/bean/JSBRegisterConfig;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "enable", "", "configList", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/service/bean/JSBRegisterConfig$Config;", "Lkotlin/collections/ArrayList;", "(ZLjava/util/ArrayList;)V", "inConfigList", "url", "", "Config", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class JSBRegisterConfig implements CJPayObject, Serializable {
    public ArrayList<Config> configList;
    public boolean enable;

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0006j\b\u0012\u0004\u0012\u00020\u0004`\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0006j\b\u0012\u0004\u0012\u00020\u0004`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/bean/JSBRegisterConfig$Config;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "host", "", "pathList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;Ljava/util/ArrayList;)V", "isRegister", "", "url", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Config implements CJPayObject, Serializable {
        public String host;
        public ArrayList<String> pathList;

        /* JADX WARN: Multi-variable type inference failed */
        public Config() {
            Object[] r100 = 0 == true ? 1 : 0;
            this(null, r100, 3, 0 == true ? 1 : 0);
        }

        public final boolean isRegister(String r100) {
            Intrinsics.checkNotNullParameter(r100, "url");
            String r101 = CJSchemaExtensionKt.host(r100);
            String r102 = "";
            if (r101 != null) goto L5;
            r101 = "";
        L5:
            String r103 = CJSchemaExtensionKt.path(r100);
            if (r103 == null) goto L10;
            r102 = r103;
        L10:
            if (Intrinsics.areEqual(this.host, r101) == false) goto L18;
            if (this.pathList.contains(r102) == false) goto L18;
            if ((!StringsKt.isBlank(r101)) == false) goto L18;
            if ((!StringsKt.isBlank(r102)) == false) goto L18;
            return true;
        L18:
            if (Intrinsics.areEqual(this.host, r101) == true) goto L20;
        L26:
            return false;
        L20:
            if ((!StringsKt.isBlank(r101)) == false) goto L26;
            if (StringsKt.isBlank(r102) == false) goto L26;
            if (this.pathList.contains(HTTP.URL_DEFAULT) == false) goto L26;
            return true;
        }

        public Config(String r100, ArrayList<String> r101) {
            Intrinsics.checkNotNullParameter(r100, "host");
            Intrinsics.checkNotNullParameter(r101, "pathList");
            this.host = r100;
            this.pathList = r101;
        }

        public /* synthetic */ Config(String r100, ArrayList r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = "";
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = new ArrayList();
        L8:
            this(r100, r101);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public JSBRegisterConfig() {
        boolean r100 = false;
        this(r100, null, 3, 0 == true ? 1 : 0);
    }

    public final boolean inConfigList(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Iterator<T> r101 = this.configList.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        if (((Config) r101.next()).isRegister(r100) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public JSBRegisterConfig(boolean r100, ArrayList<Config> r101) {
        Intrinsics.checkNotNullParameter(r101, "configList");
        this.enable = r100;
        this.configList = r101;
    }

    public /* synthetic */ JSBRegisterConfig(boolean r100, ArrayList r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = new ArrayList();
    L8:
        this(r100, r101);
    }
}
