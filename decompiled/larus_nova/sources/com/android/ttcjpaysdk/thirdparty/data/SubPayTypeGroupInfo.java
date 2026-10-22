package com.android.ttcjpaysdk.thirdparty.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000ej\b\u0012\u0004\u0012\u00020\t`\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/data/SubPayTypeGroupInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "choose", "", "credit_pay_desc", "", "display_new_bank_card_count", "", "group_title", "group_type", "new_bank_card_fold_desc", "sub_pay_type_index_list", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "GroupType", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubPayTypeGroupInfo implements CJPayObject, Serializable {
    public boolean choose;
    public String credit_pay_desc;
    public int display_new_bank_card_count;
    public String group_title;
    public String group_type;
    public String new_bank_card_fold_desc;
    public ArrayList<Integer> sub_pay_type_index_list;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/data/SubPayTypeGroupInfo$GroupType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "GROUP_TYPE_PAYMENT_TOOL", "GROUP_TYPE_PAYMENT_TOOL_COMBINE", "GROUP_TYPE_FINANCE_CHANNEL", "GROUP_TYPE_ACCOUNT", "GROUP_TYPE_BANK_CARDS", "GROUP_TYPE_NEW_CARDS", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum GroupType extends Enum<GroupType> {
        private static final /* synthetic */ GroupType[] $VALUES = null;
        public static final GroupType GROUP_TYPE_ACCOUNT = null;
        public static final GroupType GROUP_TYPE_BANK_CARDS = null;
        public static final GroupType GROUP_TYPE_FINANCE_CHANNEL = null;
        public static final GroupType GROUP_TYPE_NEW_CARDS = null;
        public static final GroupType GROUP_TYPE_PAYMENT_TOOL = null;
        public static final GroupType GROUP_TYPE_PAYMENT_TOOL_COMBINE = null;
        private final String value;

        private static final /* synthetic */ GroupType[] $values() {
            return new GroupType[]{GROUP_TYPE_PAYMENT_TOOL, GROUP_TYPE_PAYMENT_TOOL_COMBINE, GROUP_TYPE_FINANCE_CHANNEL, GROUP_TYPE_ACCOUNT, GROUP_TYPE_BANK_CARDS, GROUP_TYPE_NEW_CARDS};
        }

        public static GroupType valueOf(String r100) {
            return (GroupType) a.a(GroupType.class, r100);
        }

        public static GroupType[] values() {
            return (GroupType[]) $VALUES.clone();
        }

        static {
            GROUP_TYPE_PAYMENT_TOOL = new GroupType("GROUP_TYPE_PAYMENT_TOOL", 0, "payment_tool");
            GROUP_TYPE_PAYMENT_TOOL_COMBINE = new GroupType("GROUP_TYPE_PAYMENT_TOOL_COMBINE", 1, "payment_tool_combine");
            GROUP_TYPE_FINANCE_CHANNEL = new GroupType("GROUP_TYPE_FINANCE_CHANNEL", 2, "finance_channel");
            GROUP_TYPE_ACCOUNT = new GroupType("GROUP_TYPE_ACCOUNT", 3, "account");
            GROUP_TYPE_BANK_CARDS = new GroupType("GROUP_TYPE_BANK_CARDS", 4, "bank_cards");
            GROUP_TYPE_NEW_CARDS = new GroupType("GROUP_TYPE_NEW_CARDS", 5, "new_cards");
            $VALUES = $values();
        }

        public final String getValue() {
            return this.value;
        }

        private GroupType(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public SubPayTypeGroupInfo() {
        this.group_type = "";
        this.group_title = "";
        this.credit_pay_desc = "";
        this.new_bank_card_fold_desc = "";
        this.sub_pay_type_index_list = new ArrayList();
    }
}
