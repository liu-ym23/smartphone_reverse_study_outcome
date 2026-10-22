package com.stepos.policy.sdk.manager;

import android.content.Context;
import com.stepos.policy.sdk.bean.DeleteInfoBean;
import com.stepos.policy.sdk.bean.DeleteInfoEncryptMultiBean;
import com.stepos.policy.sdk.bean.KeyInfo;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import com.stepos.policy.sdk.util.PolicySdkSafeCertEncryptor;
import d5.i;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import javax.crypto.Cipher;
import kotlin.Pair;
import kotlin.collections.EmptyList;
import kotlin.collections.a;
import kotlin.jvm.internal.g;
import mb.m;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class WithdrawalManagerWithoutSecureService {
    public static final String CRT_FILE = "policysdk_certificate.crt";
    public static final WithdrawalManagerWithoutSecureService INSTANCE = new WithdrawalManagerWithoutSecureService();
    public static final int KEY_LEVEL_CRT = 3;

    private WithdrawalManagerWithoutSecureService() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ArrayList<DeleteInfoBean> getEncryptByDeleteInfoList(Context context, ArrayList<DeleteInfoEncryptMultiBean> arrayList) throws IOException {
        Collection<String> collectionValues;
        Collection collectionO0;
        ArrayList<DeleteInfoEncryptMultiBean> customDeleteInfoList = arrayList;
        Context context2 = context;
        g.f(context2, "context");
        g.f(customDeleteInfoList, "customDeleteInfoList");
        ArrayList<DeleteInfoBean> arrayList2 = new ArrayList<>();
        try {
            Collection<String> collection = EmptyList.f10001a;
            int size = customDeleteInfoList.size();
            int i10 = 0;
            while (i10 < size) {
                DeleteInfoEncryptMultiBean deleteInfoEncryptMultiBean = customDeleteInfoList.get(i10);
                i10++;
                DeleteInfoEncryptMultiBean deleteInfoEncryptMultiBean2 = deleteInfoEncryptMultiBean;
                LinkedHashMap<String, String> bindMap = deleteInfoEncryptMultiBean2.getBindMap();
                if (bindMap != null && (collectionValues = bindMap.values()) != null && (collectionO0 = a.O0(collectionValues)) != null) {
                    collection = collectionO0;
                }
                i iVar = new i();
                InputStream it = context2.getAssets().open(CRT_FILE);
                try {
                    PolicySdkSafeCertEncryptor policySdkSafeCertEncryptor = PolicySdkSafeCertEncryptor.INSTANCE;
                    g.e(it, "it");
                    Pair<Pair<Integer, String>, Cipher> pairEncryptorByPublicKey = policySdkSafeCertEncryptor.encryptorByPublicKey(it);
                    Pair<Integer, String> pair = pairEncryptorByPublicKey.f9985a;
                    ArrayList arrayList3 = new ArrayList(m.Z(collection, 10));
                    for (String str : collection) {
                        Cipher cipher = pairEncryptorByPublicKey.f9986b;
                        byte[] bytes = str.getBytes(gc.a.f9106b);
                        g.e(bytes, "this as java.lang.String).getBytes(charset)");
                        arrayList3.add(Base64.getUrlEncoder().encodeToString(cipher.doFinal(bytes)));
                    }
                    ArrayList arrayListP0 = a.P0(arrayList3);
                    it.close();
                    String str2 = pair.f9986b;
                    int iIntValue = pair.f9985a.intValue();
                    i iVar2 = new i();
                    HashMap map = new HashMap();
                    map.put("provider", context2.getPackageName());
                    String strH = iVar2.h(map);
                    g.e(strH, "Gson().toJson(HashMap<St…e)\n                    })");
                    if (str2 != null) {
                        LinkedHashMap<String, String> bindMap2 = deleteInfoEncryptMultiBean2.getBindMap();
                        if (bindMap2 != 0) {
                            int i11 = 0;
                            for (String key : bindMap2.keySet()) {
                                int i12 = i11 + 1;
                                if (i11 < arrayListP0.size()) {
                                    g.e(key, "key");
                                    bindMap2.put(key, arrayListP0.get(i11));
                                }
                                i11 = i12;
                            }
                        }
                        PolicySdkLogUtils.Companion.d("encryptMultiCustomDeleteInfoListBySecure", "  encrypted groupBy= " + deleteInfoEncryptMultiBean2.getBindMap() + ' ');
                        String keyInfoJson = iVar.h(new KeyInfo(str2, String.valueOf(iIntValue), String.valueOf(3), strH));
                        String bindIdJson = iVar.h(deleteInfoEncryptMultiBean2.getBindMap());
                        String serviceId = deleteInfoEncryptMultiBean2.getServiceId();
                        g.e(bindIdJson, "bindIdJson");
                        g.e(keyInfoJson, "keyInfoJson");
                        arrayList2.add(new DeleteInfoBean(serviceId, bindIdJson, keyInfoJson));
                    }
                    context2 = context;
                    customDeleteInfoList = arrayList;
                } finally {
                }
            }
            return arrayList2;
        } catch (Exception e10) {
            PolicySdkLogUtils.Companion.e("getEncryptByDeleteInfoList", "error =" + e10 + ' ');
            return arrayList2;
        }
    }
}
