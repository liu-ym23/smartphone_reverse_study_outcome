package com.stepos.policy.sdk.manager;

import android.content.Context;
import com.stepos.policy.sdk.bean.DeleteInfoBean;
import com.stepos.policy.sdk.bean.DeleteInfoEncryptMultiBean;
import com.stepos.policy.sdk.bean.KeyInfo;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import com.stepos.policy.sdk.util.PolicySdkSafeCertEncryptor;
import hc.a;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import javax.crypto.Cipher;
import jb.g;
import kb.l;
import kb.m;
import kb.s;
import m7.e;
import t.o;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class WithdrawalManagerWithoutSecureService {
    public static final String CRT_FILE = "policysdk_certificate.crt";
    public static final WithdrawalManagerWithoutSecureService INSTANCE = new WithdrawalManagerWithoutSecureService();
    public static final int KEY_LEVEL_CRT = 3;

    private WithdrawalManagerWithoutSecureService() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ArrayList<DeleteInfoBean> getEncryptByDeleteInfoList(Context context, ArrayList<DeleteInfoEncryptMultiBean> arrayList) throws IOException {
        List list;
        Collection<String> collectionValues;
        context.getClass();
        arrayList.getClass();
        ArrayList<DeleteInfoBean> arrayList2 = new ArrayList<>();
        try {
            List<String> listL0 = s.f7404c;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                DeleteInfoEncryptMultiBean deleteInfoEncryptMultiBean = arrayList.get(i);
                i++;
                DeleteInfoEncryptMultiBean deleteInfoEncryptMultiBean2 = deleteInfoEncryptMultiBean;
                LinkedHashMap<String, String> bindMap = deleteInfoEncryptMultiBean2.getBindMap();
                if (bindMap != null && (collectionValues = bindMap.values()) != null) {
                    listL0 = l.L0(collectionValues);
                }
                e eVar = new e();
                InputStream inputStreamOpen = context.getAssets().open(CRT_FILE);
                try {
                    PolicySdkSafeCertEncryptor policySdkSafeCertEncryptor = PolicySdkSafeCertEncryptor.INSTANCE;
                    inputStreamOpen.getClass();
                    g gVarEncryptorByPublicKey = policySdkSafeCertEncryptor.encryptorByPublicKey(inputStreamOpen);
                    Object obj = gVarEncryptorByPublicKey.f6759c;
                    ArrayList arrayList3 = new ArrayList(m.m0(listL0, 10));
                    for (String str : listL0) {
                        Cipher cipher = (Cipher) gVarEncryptorByPublicKey.f6760f;
                        byte[] bytes = str.getBytes(a.f5448a);
                        bytes.getClass();
                        arrayList3.add(Base64.getUrlEncoder().encodeToString(cipher.doFinal(bytes)));
                    }
                    ArrayList arrayList4 = new ArrayList(arrayList3);
                    o.d(inputStreamOpen, null);
                    ArrayList arrayList5 = arrayList4;
                    String str2 = (String) ((g) obj).f6760f;
                    int iIntValue = ((Number) ((g) obj).f6759c).intValue();
                    e eVar2 = new e();
                    HashMap map = new HashMap();
                    map.put("provider", context.getPackageName());
                    String strE = eVar2.e(map);
                    if (str2 != null) {
                        LinkedHashMap<String, String> bindMap2 = deleteInfoEncryptMultiBean2.getBindMap();
                        if (bindMap2 != 0) {
                            int i3 = 0;
                            for (String str3 : bindMap2.keySet()) {
                                int i10 = i3 + 1;
                                List list2 = listL0;
                                if (i3 < arrayList5.size()) {
                                    str3.getClass();
                                    bindMap2.put(str3, arrayList5.get(i3));
                                }
                                i3 = i10;
                                listL0 = list2;
                            }
                        }
                        list = listL0;
                        PolicySdkLogUtils.Companion.d("encryptMultiCustomDeleteInfoListBySecure", "  encrypted groupBy= " + deleteInfoEncryptMultiBean2.getBindMap() + ' ');
                        arrayList2.add(new DeleteInfoBean(deleteInfoEncryptMultiBean2.getServiceId(), eVar.e(deleteInfoEncryptMultiBean2.getBindMap()), eVar.e(new KeyInfo(str2, String.valueOf(iIntValue), String.valueOf(3), strE))));
                    } else {
                        list = listL0;
                    }
                    listL0 = list;
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
