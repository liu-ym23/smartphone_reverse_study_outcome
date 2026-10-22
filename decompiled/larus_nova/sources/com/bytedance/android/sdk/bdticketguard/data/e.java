package com.bytedance.android.sdk.bdticketguard.data;

import android.content.SharedPreferences;
import com.bytedance.android.sdk.bdticketguard.l1;
import com.bytedance.android.sdk.bdticketguard.r0;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public static final void a(JSONObject r210, d r211) {
        if (r211 == null) goto L149;
        f r100 = r211.f163608a;
        if (r100 == null) goto L7;
        r210.put("tee_gen_with_cert", r100.f163615a);
        r210.put("tee_gen_with_p256", r100.f163616b);
        r210.put("tee_gen_with_sp", r100.f163617c);
        r210.put("tee_gen_with_notrequire_auth", r100.f163618d);
    L7:
        g r101 = r211.f163609b;
        int r102 = -2;
        Boolean r103 = null;
        long r104 = 0;
        String r105 = "";
        if (r101 == null) goto L99;
        r210.put("tee_is_load_separated", r101.f163619a ? 1 : 0);
        r210.put("tee_load_stage", r101.f163620b);
        r210.put("tee_pubkey_source", r101.f163626h);
        r210.put("tee_key_source", r101.f163626h);
        r210.put("tee_key_source_index", r101.f163627i);
        r210.put("tee_key_fix_duration_ns", r101.f163628j);
        Iterator<? extends Pair<String, ? extends Throwable>> r110 = r101.f163629k.iterator();
    L11:
        if (r110.hasNext() == false) goto L17;
        Pair<String, ? extends Throwable> r111 = r110.next();
        String r112 = "tee_key_recovery_error_" + r111.getFirst();
        if ((r111.getSecond() instanceof RecoverConditionNotMetException) == false) goto L15;
        String r113 = "Condition not met: " + r111.getSecond().getMessage();
    L16:
        r210.put(r112, r113);
        goto L11
    L15:
        r113 = r0.e(r111.getSecond());
        goto L16
    L17:
        r210.put("tee_failed_key_recovery_methods", CollectionsKt.joinToString$default(r101.f163629k, ",", null, null, 0, null, TeeKeyExtrasKt$putTeeKeyLoadData$1.INSTANCE, 30, null));
        r210.put("tee_key_pair_recovery_enabled_methods", CollectionsKt.joinToString$default(r101.f163625g, ",", null, null, 0, null, null, 62, null));
        if (r101.f163621c == true) goto L27;
        l1 r114 = r101.f163624f;
        if (r114 == null) goto L27;
        Throwable r115 = r114.f163947a;
        if (r115 == null) goto L27;
        String r116 = r0.e(r115);
        if (r116 == null) goto L27;
    L28:
        r210.put("tee_pub_load_error", r116);
        l1 r117 = r101.f163624f;
        if (r117 == null) goto L31;
        long r118 = r117.f163948b;
    L32:
        r210.put("tee_pub_load_timestamp", r118);
        l1 r119 = r101.f163623e;
        if (r119 == null) goto L39;
        Throwable r120 = r119.f163947a;
        if (r120 == null) goto L39;
        String r121 = r0.e(r120);
        if (r121 == null) goto L39;
    L40:
        r210.put("tee_priv_load_error", r121);
        l1 r122 = r101.f163623e;
        if (r122 == null) goto L43;
        long r123 = r122.f163948b;
    L44:
        r210.put("tee_priv_load_timestamp", r123);
        l1 r124 = r101.f163624f;
        if (r124 == null) goto L51;
        Throwable r125 = r124.f163947a;
        if (r125 == null) goto L51;
        String r126 = r0.e(r125);
        if (r126 == null) goto L51;
    L52:
        r210.put("tee_system_load_pub_error", r126);
        l1 r127 = r101.f163623e;
        if (r127 == null) goto L59;
        Throwable r128 = r127.f163947a;
        if (r128 == null) goto L59;
        String r129 = r0.e(r128);
        if (r129 == null) goto L59;
    L60:
        r210.put("tee_system_load_priv_error", r129);
        l1 r130 = r101.f163624f;
        if (r130 == null) goto L63;
        Boolean r131 = Boolean.valueOf(r130.a());
    L64:
        Boolean r132 = Boolean.TRUE;
        if (Intrinsics.areEqual(r131, r132) == false) goto L68;
        int r133 = 0;
    L72:
        r210.put("tee_system_load_pub_result", r133);
        l1 r134 = r101.f163623e;
        if (r134 == null) goto L75;
        Boolean r135 = Boolean.valueOf(r134.a());
    L77:
        if (Intrinsics.areEqual(r135, r132) == false) goto L80;
        int r136 = 0;
    L84:
        r210.put("tee_system_load_priv_result", r136);
        Boolean r137 = r101.f163630l;
        if (Intrinsics.areEqual(r137, r132) == false) goto L88;
        int r138 = 1;
    L92:
        r210.put("tee_recovered_with_sp_pubkey", r138);
        r210.put("recovery_phase_times", r101.f163631m);
        goto L99
    L88:
        if (Intrinsics.areEqual(r137, Boolean.FALSE) == false) goto L90;
        r138 = 0;
        goto L92
    L90:
        if (r137 != null) goto L94;
        r138 = -1;
        goto L92
    L94:
        throw new NoWhenBranchMatchedException();
    L80:
        if (Intrinsics.areEqual(r135, Boolean.FALSE) == false) goto L82;
        r136 = -1;
        goto L84
    L82:
        if (r135 != null) goto L96;
        r136 = -2;
        goto L84
    L96:
        throw new NoWhenBranchMatchedException();
    L75:
        r135 = null;
        goto L77
    L68:
        if (Intrinsics.areEqual(r131, Boolean.FALSE) == false) goto L70;
        r133 = -1;
        goto L72
    L70:
        if (r131 != null) goto L98;
        r133 = -2;
        goto L72
    L98:
        throw new NoWhenBranchMatchedException();
    L63:
        r131 = null;
    L59:
        r129 = "";
    L51:
        r126 = "";
        goto L52
    L43:
        r123 = 0;
    L39:
        r121 = "";
        goto L40
    L31:
        r118 = 0;
    L27:
        r116 = "";
    L99:
        r210.put("tee_is_loaded_with_new_proc", r211.f163610c ? 1 : 0);
        Boolean r106 = r211.f163611d;
        Boolean r139 = Boolean.TRUE;
        r210.put("tee_sp_contains_alias", Intrinsics.areEqual(r106, r139) ? 1 : 0);
        r210.put("tee_key_store_contains_alias", Intrinsics.areEqual(r211.f163612e, r139) ? 1 : 0);
        l1 r107 = r211.f163613f;
        if (r107 == null) goto L106;
        Throwable r108 = r107.f163947a;
        if (r108 == null) goto L106;
        String r109 = r0.e(r108);
        if (r109 == null) goto L106;
    L107:
        r210.put("tee_contains_alias_error", r109);
        l1 r140 = r211.f163613f;
        if (r140 == null) goto L110;
        Boolean r141 = Boolean.valueOf(r140.a());
    L112:
        if (Intrinsics.areEqual(r141, r139) == false) goto L115;
        int r142 = 0;
    L119:
        r210.put("tee_contains_alias_result", r142);
        l1 r143 = r211.f163613f;
        if (r143 == null) goto L122;
        long r144 = r143.f163948b;
    L123:
        r210.put("tee_contains_alias_timestamp", r144);
        l1 r145 = r211.f163614g;
        if (r145 == null) goto L130;
        Throwable r146 = r145.f163947a;
        if (r146 == null) goto L130;
        String r147 = r0.e(r146);
        if (r147 == null) goto L130;
        r105 = r147;
    L130:
        r210.put("tee_gen_key_pair_error", r105);
        l1 r148 = r211.f163614g;
        if (r148 == null) goto L134;
        r103 = Boolean.valueOf(r148.a());
    L134:
        if (Intrinsics.areEqual(r103, r139) == false) goto L137;
        r102 = 0;
    L140:
        r210.put("tee_gen_key_pair_result", r102);
        l1 r149 = r211.f163614g;
        if (r149 == null) goto L143;
        r104 = r149.f163948b;
    L143:
        r210.put("tee_gen_key_pair_timestamp", r104);
        return;
    L137:
        if (Intrinsics.areEqual(r103, Boolean.FALSE) == false) goto L139;
        r102 = -1;
        goto L140
    L139:
        if (r103 == null) goto L140;
        throw new NoWhenBranchMatchedException();
    L122:
        r144 = 0;
        goto L123
    L115:
        if (Intrinsics.areEqual(r141, Boolean.FALSE) == false) goto L117;
        r142 = -1;
        goto L119
    L117:
        if (r141 != null) goto L148;
        r142 = -2;
        goto L119
    L148:
        throw new NoWhenBranchMatchedException();
    L110:
        r141 = null;
    L106:
        r109 = "";
        goto L107
    }

    public static final SharedPreferences.Editor b(SharedPreferences.Editor r100, String r101, d r102) {
        if (r102 == null) goto L19;
        String r103 = r101.concat("_genWithCert");
        f r104 = r102.f163608a;
        int r105 = -1;
        if (r104 == null) goto L6;
        int r106 = r104.f163615a;
    L7:
        r100.putInt(r103, r106);
        String r107 = r101.concat("_genWithP256");
        f r108 = r102.f163608a;
        if (r108 == null) goto L10;
        int r109 = r108.f163616b;
    L11:
        r100.putInt(r107, r109);
        String r110 = r101.concat("_genWithSp");
        f r111 = r102.f163608a;
        if (r111 == null) goto L14;
        int r112 = r111.f163617c;
    L15:
        r100.putInt(r110, r112);
        String r113 = r101.concat("_genWithNotRequireAuth");
        f r114 = r102.f163608a;
        if (r114 == null) goto L18;
        r105 = r114.f163618d;
    L18:
        r100.putInt(r113, r105);
        goto L19
    L14:
        r112 = -1;
        goto L15
    L10:
        r109 = -1;
        goto L11
    L6:
        r106 = -1;
    L19:
        return r100;
    }
}
