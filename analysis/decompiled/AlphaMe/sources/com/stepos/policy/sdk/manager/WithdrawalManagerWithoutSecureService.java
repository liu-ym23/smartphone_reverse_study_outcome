package com.stepos.policy.sdk.manager;

import F1.n;
import android.content.Context;
import ch.qos.logback.core.CoreConstants;
import com.stepos.policy.sdk.bean.DeleteInfoBean;
import com.stepos.policy.sdk.bean.DeleteInfoEncryptMultiBean;
import com.stepos.policy.sdk.bean.KeyInfo;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import com.stepos.policy.sdk.util.PolicySdkSafeCertEncryptor;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import javax.crypto.Cipher;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0006\u0010\u000b\u001a\u00020\f2\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\bj\b\u0012\u0004\u0012\u00020\u000e`\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/stepos/policy/sdk/manager/WithdrawalManagerWithoutSecureService;", "", "()V", "CRT_FILE", "", "KEY_LEVEL_CRT", "", "getEncryptByDeleteInfoList", "Ljava/util/ArrayList;", "Lcom/stepos/policy/sdk/bean/DeleteInfoBean;", "Lkotlin/collections/ArrayList;", CoreConstants.CONTEXT_SCOPE_VALUE, "Landroid/content/Context;", "customDeleteInfoList", "Lcom/stepos/policy/sdk/bean/DeleteInfoEncryptMultiBean;", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nWithdrawalManagerWithoutSecureService.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WithdrawalManagerWithoutSecureService.kt\ncom/stepos/policy/sdk/manager/WithdrawalManagerWithoutSecureService\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,95:1\n1#2:96\n1549#3:97\n1620#3,3:98\n*S KotlinDebug\n*F\n+ 1 WithdrawalManagerWithoutSecureService.kt\ncom/stepos/policy/sdk/manager/WithdrawalManagerWithoutSecureService\n*L\n41#1:97\n41#1:98,3\n*E\n"})
/* loaded from: classes.dex */
public final class WithdrawalManagerWithoutSecureService {

    @NotNull
    public static final String CRT_FILE = "policysdk_certificate.crt";

    @NotNull
    public static final WithdrawalManagerWithoutSecureService INSTANCE = new WithdrawalManagerWithoutSecureService();
    public static final int KEY_LEVEL_CRT = 3;

    private WithdrawalManagerWithoutSecureService() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final ArrayList<DeleteInfoBean> getEncryptByDeleteInfoList(@NotNull Context context, @NotNull ArrayList<DeleteInfoEncryptMultiBean> customDeleteInfoList) throws IOException {
        Collection<String> collectionValues;
        List list;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(customDeleteInfoList, "customDeleteInfoList");
        ArrayList<DeleteInfoBean> arrayList = new ArrayList<>();
        try {
            List<String> listEmptyList = CollectionsKt.emptyList();
            Iterator<DeleteInfoEncryptMultiBean> it = customDeleteInfoList.iterator();
            while (it.hasNext()) {
                DeleteInfoEncryptMultiBean next = it.next();
                LinkedHashMap<String, String> bindMap = next.getBindMap();
                if (bindMap != null && (collectionValues = bindMap.values()) != null && (list = CollectionsKt.toList(collectionValues)) != null) {
                    listEmptyList = list;
                }
                n nVar = new n();
                InputStream it2 = context.getAssets().open(CRT_FILE);
                try {
                    PolicySdkSafeCertEncryptor policySdkSafeCertEncryptor = PolicySdkSafeCertEncryptor.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(it2, "it");
                    Pair<Pair<Integer, String>, Cipher> pairEncryptorByPublicKey = policySdkSafeCertEncryptor.encryptorByPublicKey(it2);
                    Pair<Integer, String> first = pairEncryptorByPublicKey.getFirst();
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.e(listEmptyList));
                    for (String str : listEmptyList) {
                        Cipher second = pairEncryptorByPublicKey.getSecond();
                        byte[] bytes = str.getBytes(Charsets.UTF_8);
                        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                        arrayList2.add(Base64.getUrlEncoder().encodeToString(second.doFinal(bytes)));
                    }
                    Pair pair = TuplesKt.to(first, CollectionsKt.toMutableList((Collection) arrayList2));
                    CloseableKt.closeFinally(it2, null);
                    List list2 = (List) pair.getSecond();
                    String str2 = (String) ((Pair) pair.getFirst()).getSecond();
                    int iIntValue = ((Number) ((Pair) pair.getFirst()).getFirst()).intValue();
                    n nVar2 = new n();
                    HashMap map = new HashMap();
                    map.put("provider", context.getPackageName());
                    String strG = nVar2.g(map);
                    Intrinsics.checkNotNullExpressionValue(strG, "Gson().toJson(HashMap<St…e)\n                    })");
                    if (str2 != null && list2 != null) {
                        LinkedHashMap<String, String> bindMap2 = next.getBindMap();
                        if (bindMap2 != 0) {
                            int i4 = 0;
                            for (String key : bindMap2.keySet()) {
                                int i5 = i4 + 1;
                                if (i4 < list2.size()) {
                                    Intrinsics.checkNotNullExpressionValue(key, "key");
                                    bindMap2.put(key, list2.get(i4));
                                }
                                i4 = i5;
                            }
                        }
                        PolicySdkLogUtils.INSTANCE.d("encryptMultiCustomDeleteInfoListBySecure", "  encrypted groupBy= " + next.getBindMap() + ' ');
                        String keyInfoJson = nVar.g(new KeyInfo(str2, String.valueOf(iIntValue), String.valueOf(3), String.valueOf(strG)));
                        String bindIdJson = nVar.g(next.getBindMap());
                        String serviceId = next.getServiceId();
                        Intrinsics.checkNotNullExpressionValue(bindIdJson, "bindIdJson");
                        Intrinsics.checkNotNullExpressionValue(keyInfoJson, "keyInfoJson");
                        arrayList.add(new DeleteInfoBean(serviceId, bindIdJson, keyInfoJson));
                    }
                } finally {
                }
            }
        } catch (Exception e4) {
            PolicySdkLogUtils.INSTANCE.e("getEncryptByDeleteInfoList", "error =" + e4 + ' ');
        }
        return arrayList;
    }
}
