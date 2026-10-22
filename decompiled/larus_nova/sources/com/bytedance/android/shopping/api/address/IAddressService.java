package com.bytedance.android.shopping.api.address;

import kotlin.Metadata;
import o83.d;
import o83.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J,\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005H&J8\u0010\u0013\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&J\u0014\u0010\u0014\u001a\u00020\u00122\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0015H&J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0017\u001a\u00020\u0003H&¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/shopping/api/address/IAddressService;", "", "btmNode", "", "btm", "", "addressType", "Lo83/a;", "getAddress", "Lorg/json/JSONObject;", "address", "sourceType", "", "isSession", "Lo83/e;", "callback", "Lo83/d;", "extraParams", "", "setAddress", "showAddressUpdateDialog", "Lcom/bytedance/android/shopping/api/address/AddressUpdateDialogConfig;", "getAddressUpdateDialogConfig", "bizCode", "getBtmCodeInSaas", "ec-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IAddressService {

    public static final class a {
        public static /* synthetic */ o83.a a(IAddressService r100, Object r101, String r102, int r103) {
            if ((r103 & 1) == 0) goto L6;
            r101 = null;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = null;
        L9:
            if ((r103 & 4) == 0) goto L11;
            int r104 = -1;
        L13:
            return r100.getAddress(r101, r102, r104);
        L11:
            r104 = 0;
            goto L13
        }

        public static /* synthetic */ void b(IAddressService r100, JSONObject r101, int r102, boolean r103, d r110, int r111) {
            if ((r111 & 16) == 0) goto L5;
            r110 = null;
        L5:
            r100.setAddress(r101, r102, r103, null, r110);
        }
    }

    o83.a getAddress(Object r100, String r101, int r102);

    AddressUpdateDialogConfig getAddressUpdateDialogConfig();

    String getBtmCodeInSaas(String r100);

    void setAddress(JSONObject r100, int r101, boolean r102, e r103, d r104);

    void showAddressUpdateDialog(String r100);
}
