package com.stepos.policy.sdk.manager;

import A1.e;
import V3.m;
import V3.r;
import W3.C0403n;
import android.content.Context;
import com.stepos.policy.sdk.bean.DeleteInfoBean;
import com.stepos.policy.sdk.bean.DeleteInfoEncryptMultiBean;
import com.stepos.policy.sdk.bean.KeyInfo;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import com.stepos.policy.sdk.util.PolicySdkSafeCertEncryptor;
import f4.C0721a;
import j4.k;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import javax.crypto.Cipher;
import r4.C1020c;

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
        List listU;
        ArrayList<DeleteInfoEncryptMultiBean> arrayList2 = arrayList;
        Context context2 = context;
        k.g(context2, "context");
        k.g(arrayList2, "customDeleteInfoList");
        ArrayList<DeleteInfoBean> arrayList3 = new ArrayList<>();
        try {
            List<String> listH = C0403n.h();
            int size = arrayList2.size();
            int i5 = 0;
            while (i5 < size) {
                DeleteInfoEncryptMultiBean deleteInfoEncryptMultiBean = arrayList2.get(i5);
                i5++;
                DeleteInfoEncryptMultiBean deleteInfoEncryptMultiBean2 = deleteInfoEncryptMultiBean;
                LinkedHashMap<String, String> bindMap = deleteInfoEncryptMultiBean2.getBindMap();
                if (bindMap != null && (collectionValues = bindMap.values()) != null && (listU = C0403n.U(collectionValues)) != null) {
                    listH = listU;
                }
                e eVar = new e();
                InputStream inputStreamOpen = context2.getAssets().open(CRT_FILE);
                try {
                    PolicySdkSafeCertEncryptor policySdkSafeCertEncryptor = PolicySdkSafeCertEncryptor.INSTANCE;
                    k.f(inputStreamOpen, "it");
                    m<m<Integer, String>, Cipher> mVarEncryptorByPublicKey = policySdkSafeCertEncryptor.encryptorByPublicKey(inputStreamOpen);
                    m<Integer, String> mVarC = mVarEncryptorByPublicKey.c();
                    ArrayList arrayList4 = new ArrayList(C0403n.r(listH, 10));
                    for (String str : listH) {
                        Cipher cipherD = mVarEncryptorByPublicKey.d();
                        byte[] bytes = str.getBytes(C1020c.f20083b);
                        k.f(bytes, "this as java.lang.String).getBytes(charset)");
                        arrayList4.add(Base64.getUrlEncoder().encodeToString(cipherD.doFinal(bytes)));
                    }
                    m mVarA = r.a(mVarC, C0403n.W(arrayList4));
                    C0721a.a(inputStreamOpen, null);
                    List list = (List) mVarA.d();
                    String str2 = (String) ((m) mVarA.c()).d();
                    int iIntValue = ((Number) ((m) mVarA.c()).c()).intValue();
                    e eVar2 = new e();
                    HashMap map = new HashMap();
                    map.put("provider", context2.getPackageName());
                    String strR = eVar2.r(map);
                    k.f(strR, "Gson().toJson(HashMap<St…e)\n                    })");
                    if (str2 != null && list != null) {
                        LinkedHashMap<String, String> bindMap2 = deleteInfoEncryptMultiBean2.getBindMap();
                        if (bindMap2 != 0) {
                            int i6 = 0;
                            for (String str3 : bindMap2.keySet()) {
                                int i7 = i6 + 1;
                                if (i6 < list.size()) {
                                    k.f(str3, "key");
                                    bindMap2.put(str3, list.get(i6));
                                }
                                i6 = i7;
                            }
                        }
                        PolicySdkLogUtils.Companion.d("encryptMultiCustomDeleteInfoListBySecure", "  encrypted groupBy= " + deleteInfoEncryptMultiBean2.getBindMap() + ' ');
                        String strR2 = eVar.r(new KeyInfo(str2, String.valueOf(iIntValue), String.valueOf(3), String.valueOf(strR)));
                        String strR3 = eVar.r(deleteInfoEncryptMultiBean2.getBindMap());
                        String serviceId = deleteInfoEncryptMultiBean2.getServiceId();
                        k.f(strR3, "bindIdJson");
                        k.f(strR2, "keyInfoJson");
                        arrayList3.add(new DeleteInfoBean(serviceId, strR3, strR2));
                    }
                    context2 = context;
                    arrayList2 = arrayList;
                } finally {
                }
            }
            return arrayList3;
        } catch (Exception e6) {
            PolicySdkLogUtils.Companion.e("getEncryptByDeleteInfoList", "error =" + e6 + ' ');
            return arrayList3;
        }
    }
}
