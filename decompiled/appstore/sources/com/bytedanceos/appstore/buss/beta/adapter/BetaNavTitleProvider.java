package com.bytedanceos.appstore.buss.beta.adapter;

import android.view.View;
import com.bytedanceos.appstore.buss.beta.entity.BetaNavTitleEntity;
import com.bytedanceos.appstore.buss.constant.NavItemType;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.provider.BaseNodeProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.obric.appstore.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013RH\u0010\u001b\u001a6\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00060\u0014j\u0002`\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010 \u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001d¨\u0006!"}, d2 = {"Lcom/bytedanceos/appstore/buss/beta/adapter/BetaNavTitleProvider;", "Lcom/chad/library/adapter/base/provider/BaseNodeProvider;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "helper", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "item", "", "a", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/chad/library/adapter/base/entity/node/BaseNode;)V", "Landroid/view/View;", "view", "data", "", "position", "c", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Landroid/view/View;Lcom/chad/library/adapter/base/entity/node/BaseNode;I)V", "Lcom/bytedanceos/appstore/buss/beta/entity/BetaNavTitleEntity;", "entity", "b", "(Lcom/bytedanceos/appstore/buss/beta/entity/BetaNavTitleEntity;)I", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isOpenSidebar", "Lcom/bytedanceos/appstore/buss/beta/adapter/SelectNavListener;", "Lkotlin/jvm/functions/Function2;", "listener", "getItemViewType", "()I", "itemViewType", "getLayoutId", "layoutId", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BetaNavTitleProvider extends BaseNodeProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function2 f8403a;

    public void a(BaseViewHolder r10, BaseNode r11) {
        q.g(r10, "helper");
        q.g(r11, "item");
        if ((r11 instanceof BetaNavTitleEntity) == false) goto L5;
        BetaNavTitleEntity r12 = (BetaNavTitleEntity) r11;
    L6:
        if (r12 == null) goto L25;
        int r13 = r12.getJsonType();
        if (r13 != 1) goto L10;
        r10.setGone(R.id.tv_nav_title, false);
        r10.setGone(R.id.iv_nav_dot, false);
        r10.setGone(R.id.iv_dotted_line, true);
        r10.setGone(R.id.tv_count, !r12.getShowCount());
        r10.setText(R.id.tv_nav_title, r12.getTitle());
        boolean r14 = r12.getSelected();
        int r15 = R.color.tv_nav_un_selector;
        if (r14 == false) goto L16;
        int r16 = R.color.tv_nav_selector;
    L17:
        r10.setTextColorRes(R.id.tv_nav_title, r16);
        if (r12.getSelected() == false) goto L20;
        r15 = R.color.tv_nav_selector;
    L20:
        r10.setTextColorRes(R.id.tv_count, r15);
        r10.setImageResource(R.id.iv_nav_dot, b(r12));
        r10.setText(R.id.tv_count, String.valueOf(r12.getCountNum()));
        if (r12.getSelected() == false) goto L23;
        r10.itemView.setBackgroundResource(R.drawable.icon_nav_bg_p);
        return;
    L23:
        r10.itemView.setBackground(null);
        return;
    L16:
        r16 = R.color.tv_nav_un_selector;
        goto L17
    L10:
        if (r13 == 2) goto L12;
        r10.setGone(R.id.tv_nav_title, true);
        r10.setGone(R.id.iv_nav_dot, true);
        r10.setGone(R.id.tv_count, true);
        r10.setGone(R.id.iv_dotted_line, true);
        r10.itemView.setBackground(null);
        return;
    L12:
        r10.setGone(R.id.tv_nav_title, true);
        r10.setGone(R.id.iv_nav_dot, true);
        r10.setGone(R.id.tv_count, true);
        r10.setGone(R.id.iv_dotted_line, false);
        r10.itemView.setBackground(null);
        return;
    L25:
        return;
    L5:
        r12 = null;
        goto L6
    }

    public final int b(BetaNavTitleEntity r10) {
        String r11 = r10.getIconId();
        int r12 = r11.hashCode();
        switch(r12) {
            case -1194062357: goto L287;
            case -1194062356: goto L280;
            case -1194062355: goto L273;
            case -1194062354: goto L267;
            case -1194062353: goto L260;
            case -1194062352: goto L253;
            case -1194062351: goto L246;
            case -1194062350: goto L239;
            case -1194062349: goto L232;
            default: goto L5;
        };
    L5:
        switch(r12) {
            case 1638772645: goto L225;
            case 1638772646: goto L218;
            case 1638772647: goto L211;
            case 1638772648: goto L204;
            case 1638772649: goto L197;
            case 1638772650: goto L190;
            case 1638772651: goto L183;
            case 1638772652: goto L176;
            case 1638772653: goto L169;
            case 1638772654: goto L163;
            default: goto L7;
        };
    L7:
        switch(r12) {
            case 1638772676: goto L156;
            case 1638772677: goto L149;
            case 1638772678: goto L142;
            case 1638772679: goto L135;
            case 1638772680: goto L128;
            case 1638772681: goto L121;
            case 1638772682: goto L115;
            case 1638772683: goto L108;
            case 1638772684: goto L101;
            case 1638772685: goto L94;
            default: goto L8;
        };
    L8:
        switch(r12) {
            case 1638772707: goto L87;
            case 1638772708: goto L81;
            case 1638772709: goto L74;
            case 1638772710: goto L67;
            case 1638772711: goto L60;
            case 1638772712: goto L53;
            case 1638772713: goto L46;
            case 1638772714: goto L39;
            case 1638772715: goto L33;
            case 1638772716: goto L26;
            default: goto L9;
        };
    L9:
        switch(r12) {
            case 1638772738: goto L19;
            case 1638772739: goto L12;
            default: goto L292;
        };
    L292:
        r10.getSelected();
    L367:
        return R.drawable.icon_nav_all_recommend_nor;
    L12:
        if (r11.equals("icon_41") == false) goto L292;
        if (r10.getSelected() == false) goto L17;
        return R.drawable.icon_nav_tnt_pre;
    L17:
        return R.drawable.icon_nav_tnt_nor;
    L19:
        if (r11.equals("icon_40") == false) goto L292;
        if (r10.getSelected() == false) goto L24;
        return R.drawable.icon_nav_one_step_pre;
    L24:
        return R.drawable.icon_nav_one_step_nor;
    L26:
        if (r11.equals("icon_39") == false) goto L292;
        if (r10.getSelected() == false) goto L298;
    L297:
        return R.drawable.icon_nav_system_app_pre;
    L298:
        return R.drawable.icon_nav_system_app_nor;
    L33:
        if (r11.equals("icon_38") == false) goto L292;
        if (r10.getSelected() == false) goto L298;
    L39:
        if (r11.equals("icon_37") == false) goto L292;
        if (r10.getSelected() == false) goto L44;
        return R.drawable.icon_nav_wish_pre;
    L44:
        return R.drawable.icon_nav_wish_nor;
    L46:
        if (r11.equals("icon_36") == false) goto L292;
        if (r10.getSelected() == false) goto L51;
        return R.drawable.icon_nav_my_app_pre;
    L51:
        return R.drawable.icon_nav_my_app_nor;
    L53:
        if (r11.equals("icon_35") == false) goto L292;
        if (r10.getSelected() == false) goto L58;
        return R.drawable.icon_nav_app_update_pre;
    L58:
        return R.drawable.icon_nav_app_update_nor;
    L60:
        if (r11.equals("icon_34") == false) goto L292;
        if (r10.getSelected() == false) goto L65;
        return R.drawable.icon_nav_game_gift_pre;
    L65:
        return R.drawable.icon_nav_game_gift_nor;
    L67:
        if (r11.equals("icon_33") == false) goto L292;
        if (r10.getSelected() == false) goto L308;
    L307:
        return R.drawable.icon_nav_game_7_pre;
    L308:
        return R.drawable.icon_nav_game_7_nor;
    L74:
        if (r11.equals("icon_32") == false) goto L292;
        if (r10.getSelected() == false) goto L79;
        return R.drawable.icon_nav_game_new_pre;
    L79:
        return R.drawable.icon_nav_game_new_nor;
    L81:
        if (r11.equals("icon_31") == false) goto L292;
        if (r10.getSelected() == true) goto L312;
        return R.drawable.icon_nav_hot_game_nor;
    L312:
        return R.drawable.icon_nav_hot_game_pre;
    L87:
        if (r11.equals("icon_30") == false) goto L292;
        if (r10.getSelected() == false) goto L92;
        return R.drawable.icon_nav_game_hot_pre;
    L92:
        return R.drawable.icon_nav_game_hot_nor;
    L94:
        if (r11.equals("icon_29") == false) goto L292;
        if (r10.getSelected() == false) goto L99;
        return R.drawable.icon_nav_all_game_pre;
    L99:
        return R.drawable.icon_nav_all_game_nor;
    L101:
        if (r11.equals("icon_28") == false) goto L292;
        if (r10.getSelected() == false) goto L106;
        return R.drawable.icon_nav_game_9_pre;
    L106:
        return R.drawable.icon_nav_game_9_nor;
    L108:
        if (r11.equals("icon_27") == false) goto L292;
        if (r10.getSelected() == false) goto L113;
        return R.drawable.icon_nav_game_8_pre;
    L113:
        return R.drawable.icon_nav_game_8_nor;
    L115:
        if (r11.equals("icon_26") == false) goto L292;
        if (r10.getSelected() == false) goto L308;
    L121:
        if (r11.equals("icon_25") == false) goto L292;
        if (r10.getSelected() == false) goto L126;
        return R.drawable.icon_nav_game_6_pre;
    L126:
        return R.drawable.icon_nav_game_6_nor;
    L128:
        if (r11.equals("icon_24") == false) goto L292;
        if (r10.getSelected() == false) goto L133;
        return R.drawable.icon_nav_game_5_pre;
    L133:
        return R.drawable.icon_nav_game_5_nor;
    L135:
        if (r11.equals("icon_23") == false) goto L292;
        if (r10.getSelected() == false) goto L140;
        return R.drawable.icon_nav_game_4_pre;
    L140:
        return R.drawable.icon_nav_game_4_nor;
    L142:
        if (r11.equals("icon_22") == false) goto L292;
        if (r10.getSelected() == false) goto L147;
        return R.drawable.icon_nav_game_3_pre;
    L147:
        return R.drawable.icon_nav_game_3_nor;
    L149:
        if (r11.equals("icon_21") == false) goto L292;
        if (r10.getSelected() == false) goto L154;
        return R.drawable.icon_nav_game_2_pre;
    L154:
        return R.drawable.icon_nav_game_2_nor;
    L156:
        if (r11.equals("icon_20") == false) goto L292;
        if (r10.getSelected() == false) goto L161;
        return R.drawable.icon_nav_game_1_pre;
    L161:
        return R.drawable.icon_nav_game_1_nor;
    L163:
        if (r11.equals("icon_19") == false) goto L292;
        if (r10.getSelected() == false) goto L298;
    L169:
        if (r11.equals("icon_18") == false) goto L292;
        if (r10.getSelected() == false) goto L174;
        return R.drawable.icon_nav_read_consulting_pre;
    L174:
        return R.drawable.icon_nav_read_consulting_nor;
    L176:
        if (r11.equals("icon_17") == false) goto L292;
        if (r10.getSelected() == false) goto L181;
        return R.drawable.icon_nav_financial_services_pre;
    L181:
        return R.drawable.icon_nav_financial_services_nor;
    L183:
        if (r11.equals("icon_16") == false) goto L292;
        if (r10.getSelected() == false) goto L188;
        return R.drawable.icon_nav_children_mum_pre;
    L188:
        return R.drawable.icon_nav_children_mum_nor;
    L190:
        if (r11.equals("icon_15") == false) goto L292;
        if (r10.getSelected() == false) goto L195;
        return R.drawable.icon_nav_social_communication_pre;
    L195:
        return R.drawable.icon_nav_social_communication_nor;
    L197:
        if (r11.equals("icon_14") == false) goto L292;
        if (r10.getSelected() == false) goto L202;
        return R.drawable.icon_nav_study_education_pre;
    L202:
        return R.drawable.icon_nav_study_education_nor;
    L204:
        if (r11.equals("icon_13") == false) goto L292;
        if (r10.getSelected() == false) goto L209;
        return R.drawable.icon_nav_business_office_pre;
    L209:
        return R.drawable.icon_nav_business_office_nor;
    L211:
        if (r11.equals("icon_12") == false) goto L292;
        if (r10.getSelected() == false) goto L216;
        return R.drawable.icon_nav_video_image_pre;
    L216:
        return R.drawable.icon_nav_video_image_nor;
    L218:
        if (r11.equals("icon_11") == false) goto L292;
        if (r10.getSelected() == false) goto L223;
        return R.drawable.icon_nav_transportation_pre;
    L223:
        return R.drawable.icon_nav_transportation_nor;
    L225:
        if (r11.equals("icon_10") == false) goto L292;
        if (r10.getSelected() == false) goto L230;
        return R.drawable.icon_nav_live_practical_pre;
    L230:
        return R.drawable.icon_nav_live_practical_nor;
    L232:
        if (r11.equals("icon_9") == false) goto L292;
        if (r10.getSelected() == false) goto L237;
        return R.drawable.icon_nav_system_tool_pre;
    L237:
        return R.drawable.icon_nav_system_tool_nor;
    L239:
        if (r11.equals("icon_8") == false) goto L292;
        if (r10.getSelected() == false) goto L244;
        return R.drawable.icon_nav_game_rank_pre;
    L244:
        return R.drawable.icon_nav_game_rank_nor;
    L246:
        if (r11.equals("icon_7") == false) goto L292;
        if (r10.getSelected() == false) goto L251;
        return R.drawable.icon_nav_rank_all_pre;
    L251:
        return R.drawable.icon_nav_rank_all_nor;
    L253:
        if (r11.equals("icon_6") == false) goto L292;
        if (r10.getSelected() == false) goto L258;
        return R.drawable.icon_nav_rank_week_pre;
    L258:
        return R.drawable.icon_nav_rank_week_nor;
    L260:
        if (r11.equals("icon_5") == false) goto L292;
        if (r10.getSelected() == false) goto L265;
        return R.drawable.icon_nav_game_sub_pre;
    L265:
        return R.drawable.icon_nav_game_sub_nor;
    L267:
        if (r11.equals("icon_4") == false) goto L292;
        if (r10.getSelected() == true) goto L312;
        return R.drawable.icon_nav_hot_game_nor;
    L273:
        if (r11.equals("icon_3") == false) goto L292;
        if (r10.getSelected() == false) goto L278;
        return R.drawable.icon_nav_popular_nowadays_pre;
    L278:
        return R.drawable.icon_nav_popular_nowadays_nor;
    L280:
        if (r11.equals("icon_2") == false) goto L292;
        if (r10.getSelected() == false) goto L285;
        return R.drawable.icon_nav_installed_necessary_pre;
    L285:
        return R.drawable.icon_nav_installed_necessary_nor;
    L287:
        if (r11.equals("icon_1") == false) goto L292;
        if (r10.getSelected() == false) goto L367;
        return R.drawable.icon_nav_all_recommend_pre;
    }

    public void c(BaseViewHolder r10, View r11, BaseNode r12, int r13) {
        q.g(r10, "helper");
        q.g(r11, "view");
        q.g(r12, "data");
        if ((r12 instanceof BetaNavTitleEntity) == false) goto L5;
        BetaNavTitleEntity r14 = (BetaNavTitleEntity) r12;
    L6:
        if (r14 != null) goto L8;
        return;
    L8:
        if (r14.getJsonType() != 1) goto L12;
        this.f8403a.mo0invoke(Boolean.FALSE, r12);
        return;
    L12:
        return;
    L5:
        r14 = null;
        goto L6
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public /* bridge */ /* synthetic */ void convert(BaseViewHolder r10, BaseNode r11) {
        a(r10, r11);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int getItemViewType() {
        return NavItemType.NAV_TITLE_TYPE.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int getLayoutId() {
        return R.layout.tv_item_nav_title;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public /* bridge */ /* synthetic */ void onClick(BaseViewHolder r10, View r11, BaseNode r12, int r13) {
        c(r10, r11, r12, r13);
    }
}
