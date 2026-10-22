package com.android.ttcjpaysdk.base.ui.data;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
public class PayTypeVoucherMsgV2 implements CJPayObject, Serializable {
    public ArrayList<PayTypeVoucherMsgV2Tag> tag12;
    public ArrayList<PayTypeVoucherMsgV2Tag> tag34;
    public ArrayList<PayTypeVoucherMsgV2Tag> tag56;

    public static class PayTypeVoucherMsgV2Tag implements CJPayObject, Serializable {
        public String event_type;
        public ArrayList<VoucherDetailLabel> label;
        public String voucher_msg_sub_type;
        public String voucher_msg_type;
        public String voucher_pos;

        public static class VoucherDetailLabel implements CJPayObject, Serializable {
            public String icon_url;
            public String text;
            public String type;

            public boolean isPictureType() {
                return TextUtils.equals(this.type, "picture");
            }

            public boolean isTextType() {
                return TextUtils.equals(this.type, "text");
            }

            public VoucherDetailLabel() {
                this.text = "";
                this.type = "";
                this.icon_url = "";
            }
        }

        public boolean isCombineType() {
            return TextUtils.equals(this.event_type, "combine_pay");
        }

        public boolean isDefaultType() {
            return TextUtils.equals(this.event_type, "default");
        }

        public boolean isThisPayCanUse() {
            return TextUtils.equals(this.voucher_msg_type, "this_pay_can_use");
        }

        public PayTypeVoucherMsgV2Tag() {
            this.event_type = "";
            this.label = new ArrayList();
            this.voucher_msg_type = "";
            this.voucher_msg_sub_type = "";
            this.voucher_pos = "";
        }
    }

    public static final enum VoucherV2Tag extends Enum<VoucherV2Tag> {
        private static final /* synthetic */ VoucherV2Tag[] $VALUES = null;
        public static final VoucherV2Tag TAG12 = null;
        public static final VoucherV2Tag TAG34 = null;
        public static final VoucherV2Tag TAG56 = null;

        private static /* synthetic */ VoucherV2Tag[] $values() {
            return new VoucherV2Tag[]{TAG12, TAG34, TAG56};
        }

        static {
            TAG12 = new VoucherV2Tag("TAG12", 0);
            TAG34 = new VoucherV2Tag("TAG34", 1);
            TAG56 = new VoucherV2Tag("TAG56", 2);
            $VALUES = $values();
        }

        public static VoucherV2Tag[] values() {
            return (VoucherV2Tag[]) $VALUES.clone();
        }

        public static VoucherV2Tag valueOf(String r100) {
            return (VoucherV2Tag) a.a(VoucherV2Tag.class, r100);
        }

        private VoucherV2Tag(String r100, int r101) {
            super(r100, r101);
        }
    }

    public List<String> getCombineVoucherMsgV2OfCardList() {
        return getVoucherMsgV2(VoucherV2Tag.TAG56, true);
    }

    public List<String> getVoucherMsgV2OfCardList() {
        return getVoucherMsgV2(VoucherV2Tag.TAG56, false);
    }

    public PayTypeVoucherMsgV2() {
        this.tag12 = new ArrayList();
        this.tag34 = new ArrayList();
        this.tag56 = new ArrayList();
    }

    private List<String> getVoucherMsgV2(VoucherV2Tag r100, boolean r101) {
        ArrayList r102 = new ArrayList();
        if (VoucherV2Tag.TAG12 != r100) goto L6;
        ArrayList<PayTypeVoucherMsgV2Tag> r103 = this.tag12;
    L12:
        if (r101 == false) goto L14;
        String r104 = "combine_pay";
    L15:
        int r105 = 0;
    L17:
        if (r105 >= r103.size()) goto L30;
        PayTypeVoucherMsgV2Tag r106 = (PayTypeVoucherMsgV2Tag) ListProtector.get(r103, r105);
        if (r104.equals(r106.event_type) == false) goto L29;
        int r107 = 0;
    L22:
        if (r107 >= r106.label.size()) goto L29;
        if ("text".equals(((PayTypeVoucherMsgV2Tag.VoucherDetailLabel) ListProtector.get(r106.label, r107)).type) == true) goto L26;
        r107 = r107 + 1;
        goto L22
    L26:
        if (TextUtils.isEmpty(((PayTypeVoucherMsgV2Tag.VoucherDetailLabel) ListProtector.get(r106.label, r107)).text) == true) goto L29;
        r102.add(((PayTypeVoucherMsgV2Tag.VoucherDetailLabel) ListProtector.get(r106.label, r107)).text);
    L29:
        r105 = r105 + 1;
        goto L17
    L30:
        return r102;
    L14:
        r104 = "default";
        goto L15
    L6:
        if (VoucherV2Tag.TAG34 != r100) goto L9;
        r103 = this.tag34;
        goto L12
    L9:
        if (VoucherV2Tag.TAG56 != r100) goto L11;
        r103 = this.tag56;
        goto L12
    L11:
        r103 = null;
        goto L12
    }
}
