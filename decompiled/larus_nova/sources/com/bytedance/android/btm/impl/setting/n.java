package com.bytedance.android.btm.impl.setting;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.lazydata.LazyData;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR(\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/btm/impl/setting/n;", "", "", "", "btmPageList", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "setBtmPageList", "(Ljava/util/List;)V", "<init>", "()V", "btm-impl_cnRelease"}, k = 1, mv = {1, 4, 0})
@LazyData
public final class n {

    @SerializedName("btm_page_list")
    private List<String> btmPageList;

    public n() {
        this.btmPageList = CollectionsKt.listOf(new String[]{"a1.b1923", "a1.b250658", "a1.b330690", "a1128.b0438", "a1128.b293805", "a1128.b53302", "a1128.b4809", "a1128.b6207", "a1128.b626969", "a1128.b8477", "a1128.b887131", "a1128.b90199", "a1128.b9655", "a2552.b15297", "a2552.b735718"});
    }

    public final List<String> a() {
        return this.btmPageList;
    }
}
