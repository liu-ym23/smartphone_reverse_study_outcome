package com.stepos.policy.sdk.manager;

import D7.v;
import D7.w;
import android.content.Context;
import com.google.gson.Gson;
import com.stepos.policy.sdk.bean.DeleteInfoBean;
import com.stepos.policy.sdk.bean.DeleteInfoEncryptMultiBean;
import com.stepos.policy.sdk.bean.KeyInfo;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import com.stepos.policy.sdk.util.PolicySdkSafeCertEncryptor;
import j9.AbstractC1607a;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import javax.crypto.Cipher;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0006\u0010\u000b\u001a\u00020\f2\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\bj\b\u0012\u0004\u0012\u00020\u000e`\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/stepos/policy/sdk/manager/WithdrawalManagerWithoutSecureService;", "", "()V", "CRT_FILE", "", "KEY_LEVEL_CRT", "", "getEncryptByDeleteInfoList", "Ljava/util/ArrayList;", "Lcom/stepos/policy/sdk/bean/DeleteInfoBean;", "Lkotlin/collections/ArrayList;", "context", "Landroid/content/Context;", "customDeleteInfoList", "Lcom/stepos/policy/sdk/bean/DeleteInfoEncryptMultiBean;", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class WithdrawalManagerWithoutSecureService {
    public static final String CRT_FILE = "policysdk_certificate.crt";
    public static final WithdrawalManagerWithoutSecureService INSTANCE = new WithdrawalManagerWithoutSecureService();
    public static final int KEY_LEVEL_CRT = 3;

    private WithdrawalManagerWithoutSecureService() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ArrayList<DeleteInfoBean> getEncryptByDeleteInfoList(Context context, ArrayList<DeleteInfoEncryptMultiBean> customDeleteInfoList) throws IOException {
        Collection<String> collectionValues;
        Collection collectionF1;
        k.f(context, "context");
        k.f(customDeleteInfoList, "customDeleteInfoList");
        ArrayList<DeleteInfoBean> arrayList = new ArrayList<>();
        try {
            Collection collection = EmptyList.f4893a;
            Iterator<DeleteInfoEncryptMultiBean> it = customDeleteInfoList.iterator();
            while (it.hasNext()) {
                DeleteInfoEncryptMultiBean next = it.next();
                LinkedHashMap<String, String> bindMap = next.getBindMap();
                if (bindMap != null && (collectionValues = bindMap.values()) != null && (collectionF1 = v.f1(collectionValues)) != null) {
                    collection = collectionF1;
                }
                Gson gson = new Gson();
                InputStream it2 = context.getAssets().open(CRT_FILE);
                try {
                    PolicySdkSafeCertEncryptor policySdkSafeCertEncryptor = PolicySdkSafeCertEncryptor.INSTANCE;
                    k.e(it2, "it");
                    Pair<Pair<Integer, String>, Cipher> pairEncryptorByPublicKey = policySdkSafeCertEncryptor.encryptorByPublicKey(it2);
                    Object obj = pairEncryptorByPublicKey.f4886a;
                    Collection<String> collection2 = collection;
                    ArrayList arrayList2 = new ArrayList(w.c0(collection2, 10));
                    for (String str : collection2) {
                        Cipher cipher = (Cipher) pairEncryptorByPublicKey.b;
                        byte[] bytes = str.getBytes(AbstractC1607a.f4778a);
                        k.e(bytes, "this as java.lang.String).getBytes(charset)");
                        arrayList2.add(Base64.getUrlEncoder().encodeToString(cipher.doFinal(bytes)));
                    }
                    ArrayList arrayListG1 = v.g1(arrayList2);
                    it2.close();
                    String str2 = (String) ((Pair) obj).b;
                    int iIntValue = ((Number) ((Pair) obj).f4886a).intValue();
                    Gson gson2 = new Gson();
                    HashMap map = new HashMap();
                    map.put("provider", context.getPackageName());
                    String json = gson2.toJson(map);
                    k.e(json, "Gson().toJson(HashMap<St…e)\n                    })");
                    if (str2 != null) {
                        LinkedHashMap<String, String> bindMap2 = next.getBindMap();
                        if (bindMap2 != 0) {
                            int i = 0;
                            for (String key : bindMap2.keySet()) {
                                int i6 = i + 1;
                                if (i < arrayListG1.size()) {
                                    k.e(key, "key");
                                    bindMap2.put(key, arrayListG1.get(i));
                                }
                                i = i6;
                            }
                        }
                        PolicySdkLogUtils.INSTANCE.d("encryptMultiCustomDeleteInfoListBySecure", "  encrypted groupBy= " + next.getBindMap() + ' ');
                        String keyInfoJson = gson.toJson(new KeyInfo(str2, String.valueOf(iIntValue), String.valueOf(3), json));
                        String bindIdJson = gson.toJson(next.getBindMap());
                        String serviceId = next.getServiceId();
                        k.e(bindIdJson, "bindIdJson");
                        k.e(keyInfoJson, "keyInfoJson");
                        arrayList.add(new DeleteInfoBean(serviceId, bindIdJson, keyInfoJson));
                    }
                } finally {
                }
            }
            return arrayList;
        } catch (Exception e) {
            PolicySdkLogUtils.INSTANCE.e("getEncryptByDeleteInfoList", "error =" + e + ' ');
            return arrayList;
        }
    }
}
