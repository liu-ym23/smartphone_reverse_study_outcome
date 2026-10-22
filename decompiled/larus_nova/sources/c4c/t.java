package c4c;

import com.bytedance.lark.pb.search.v2.ShieldP2PChatMeta;
import com.ss.android.lark.search.dto.info.SearchShieldP2PChatInfo;

/* JADX INFO: loaded from: classes38.dex */
public final class t {
    public t() {
    }

    public static SearchShieldP2PChatInfo a(ShieldP2PChatMeta r100) {
        if (r100 == null) goto L4;
        SearchShieldP2PChatInfo r101 = new SearchShieldP2PChatInfo();
        r101.setRegistered(r100.is_registered.booleanValue());
        r101.setTenantId(r100.tenant_id);
        r101.setMaiLAddress(r100.mail_address);
        r101.setDoNotDisturbEndTime(r100.do_not_disturb_end_time);
        r101.setAcceptSmsPhoneUrgent(r100.accept_sms_phone_urgent.booleanValue());
        r101.setChatterId(r100.chatter_id);
        r101.setCustomStatus(r100.custom_statuses);
        r101.setTagData(n.a(r100.relation_tag));
        return r101;
    L4:
        return null;
    }
}
