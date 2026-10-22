package com.android.ttcjpaysdk.base.settings.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\u0002\u0010\tR\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/bean/CJPayEncryptConfig;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "enable_cert", "", "encrypt_update_available_scene", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "(ILjava/util/ArrayList;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayEncryptConfig implements CJPayObject, Serializable {
    public int enable_cert;
    public ArrayList<String> encrypt_update_available_scene;

    /* JADX WARN: Multi-variable type inference failed */
    public CJPayEncryptConfig() {
        int r100 = 0;
        this(r100, null, 3, 0 == true ? 1 : 0);
    }

    public CJPayEncryptConfig(int r100, ArrayList<String> r101) {
        Intrinsics.checkNotNullParameter(r101, "encrypt_update_available_scene");
        this.enable_cert = r100;
        this.encrypt_update_available_scene = r101;
    }

    public /* synthetic */ CJPayEncryptConfig(int r100, ArrayList r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = new ArrayList();
    L8:
        this(r100, r101);
    }
}
