package com.android.ttcjpaysdk.thirdparty.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayDiscount implements Serializable, Parcelable, CJPayObject {
    public static final Parcelable.Creator<CJPayDiscount> CREATOR = null;
    public String discount_abstract;
    public long discount_amount;
    public long discount_begin_time;
    public long discount_end_time;
    public String discount_exts;
    public String discount_id;
    public String discount_name;
    public String discount_rule_desc;
    public String discount_type;
    public String enable_overlap;
    public boolean isChecked;
    public long max_deduction_amount;
    public String merchant_id;
    public long min_payed_amount;
    public String msg;
    public long reached_amount;
    public String status;
    public String uid;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public JSONObject toJson() {
        JSONObject r100 = new JSONObject();
        r100.put("merchant_id", this.merchant_id);     // Catch: JSONException -> L5
        r100.put("discount_id", this.discount_id);     // Catch: JSONException -> L5
        r100.put("discount_amount", this.discount_amount);     // Catch: JSONException -> L5
        r100.put("status", this.status);     // Catch: JSONException -> L5
        r100.put("msg", this.msg);     // Catch: JSONException -> L5
        r100.put("uid", this.uid);     // Catch: JSONException -> L5
        r100.put("discount_name", this.discount_name);     // Catch: JSONException -> L5
        r100.put("discount_type", this.discount_type);     // Catch: JSONException -> L5
        r100.put("discount_begin_time", this.discount_begin_time);     // Catch: JSONException -> L5
        r100.put("discount_end_time", this.discount_end_time);     // Catch: JSONException -> L5
        r100.put("discount_rule_desc", this.discount_rule_desc);     // Catch: JSONException -> L5
        r100.put("enable_overlap", this.enable_overlap);     // Catch: JSONException -> L5
        r100.put("discount_abstract", this.discount_abstract);     // Catch: JSONException -> L5
        r100.put("discount_exts", this.discount_exts);     // Catch: JSONException -> L5
        r100.put("reached_amount", this.reached_amount);     // Catch: JSONException -> L5
        r100.put("min_payed_amount", this.min_payed_amount);     // Catch: JSONException -> L5
        r100.put("max_deduction_amount", this.max_deduction_amount);     // Catch: JSONException -> L5
        return r100;
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayDiscount#toJson", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayDiscount#toJson", e);
        e.printStackTrace();
        return null;
    }

    public String toJsonString() {
        JSONObject r100 = new JSONObject();
        r100.put("merchant_id", this.merchant_id);     // Catch: JSONException -> L5
        r100.put("discount_id", this.discount_id);     // Catch: JSONException -> L5
        r100.put("discount_amount", this.discount_amount);     // Catch: JSONException -> L5
        r100.put("status", this.status);     // Catch: JSONException -> L5
        r100.put("msg", this.msg);     // Catch: JSONException -> L5
        r100.put("uid", this.uid);     // Catch: JSONException -> L5
        r100.put("discount_name", this.discount_name);     // Catch: JSONException -> L5
        r100.put("discount_type", this.discount_type);     // Catch: JSONException -> L5
        r100.put("discount_begin_time", this.discount_begin_time);     // Catch: JSONException -> L5
        r100.put("discount_end_time", this.discount_end_time);     // Catch: JSONException -> L5
        r100.put("discount_rule_desc", this.discount_rule_desc);     // Catch: JSONException -> L5
        r100.put("enable_overlap", this.enable_overlap);     // Catch: JSONException -> L5
        r100.put("discount_abstract", this.discount_abstract);     // Catch: JSONException -> L5
        r100.put("discount_exts", this.discount_exts);     // Catch: JSONException -> L5
        r100.put("reached_amount", this.reached_amount);     // Catch: JSONException -> L5
        r100.put("min_payed_amount", this.min_payed_amount);     // Catch: JSONException -> L5
        r100.put("max_deduction_amount", this.max_deduction_amount);     // Catch: JSONException -> L5
        return r100.toString();
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayDiscount#toJsonString", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayDiscount#toJsonString", e);
        e.printStackTrace();
        return "";
    }

    public CJPayDiscount() {
        this.merchant_id = "";
        this.discount_id = "";
        this.discount_amount = 0;
        this.status = "";
        this.msg = "";
        this.uid = "";
        this.discount_name = "";
        this.discount_type = "";
        this.discount_begin_time = 0;
        this.discount_end_time = 0;
        this.discount_rule_desc = "";
        this.enable_overlap = "";
        this.discount_abstract = "";
        this.discount_exts = "";
        this.reached_amount = 0;
        this.min_payed_amount = 0;
        this.max_deduction_amount = 0;
        this.isChecked = false;
    }

    public CJPayDiscount(Parcel r100) {
        this.merchant_id = "";
        this.discount_id = "";
        this.discount_amount = 0;
        this.status = "";
        this.msg = "";
        this.uid = "";
        this.discount_name = "";
        this.discount_type = "";
        this.discount_begin_time = 0;
        this.discount_end_time = 0;
        this.discount_rule_desc = "";
        this.enable_overlap = "";
        this.discount_abstract = "";
        this.discount_exts = "";
        this.reached_amount = 0;
        this.min_payed_amount = 0;
        this.max_deduction_amount = 0;
        boolean r101 = false;
        this.isChecked = false;
        this.merchant_id = r100.readString();
        this.discount_id = r100.readString();
        this.discount_amount = r100.readLong();
        this.status = r100.readString();
        this.msg = r100.readString();
        this.uid = r100.readString();
        this.discount_name = r100.readString();
        this.discount_type = r100.readString();
        this.discount_begin_time = r100.readLong();
        this.discount_end_time = r100.readLong();
        this.discount_rule_desc = r100.readString();
        this.enable_overlap = r100.readString();
        this.discount_abstract = r100.readString();
        this.discount_exts = r100.readString();
        this.reached_amount = r100.readLong();
        this.min_payed_amount = r100.readLong();
        this.max_deduction_amount = r100.readLong();
        Integer r102 = 1;
        if (r100.readInt() != r102.intValue()) goto L5;
        r101 = true;
    L5:
        this.isChecked = r101;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.merchant_id);
        r100.writeString(this.discount_id);
        r100.writeLong(this.discount_amount);
        r100.writeString(this.status);
        r100.writeString(this.msg);
        r100.writeString(this.uid);
        r100.writeString(this.discount_name);
        r100.writeString(this.discount_type);
        r100.writeLong(this.discount_begin_time);
        r100.writeLong(this.discount_end_time);
        r100.writeString(this.discount_rule_desc);
        r100.writeString(this.enable_overlap);
        r100.writeString(this.discount_abstract);
        r100.writeString(this.discount_exts);
        r100.writeLong(this.reached_amount);
        r100.writeLong(this.min_payed_amount);
        r100.writeLong(this.max_deduction_amount);
        r100.writeInt(this.isChecked ? 1 : 0);
    }
}
