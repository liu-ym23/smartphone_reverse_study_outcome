package com.bytedanceos.appstore.buss.adapter.app.pager.adapter;

import com.bytedanceos.appstore.buss.adapter.app.base.BasePagerAdapter;
import com.bytedanceos.appstore.buss.adapter.app.pager.provider.PagerVideoProvider;
import com.bytedanceos.appstore.buss.entity.AppEntityWrap;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.entity.item.ItemType;
import com.bytedanceos.common.toolbox.ServerElements;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlin.text.n;
import kotlin.text.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\u000b\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u000fJ\r\u0010\u0011\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedanceos/appstore/buss/adapter/app/pager/adapter/PageAppsAdapter;", "Lcom/bytedanceos/appstore/buss/adapter/app/base/BasePagerAdapter;", "", "pageName", "<init>", "(Ljava/lang/String;)V", "", "Lcom/bytedanceos/appstore/buss/entity/AppEntityWrap;", "data", "", "position", "getItemType", "(Ljava/util/List;I)I", "", "onResume", "()V", "onPause", "b", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PageAppsAdapter extends BasePagerAdapter {
    /* JADX WARN: Multi-variable type inference failed */
    public PageAppsAdapter() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final void b() {
        BaseItemProvider<AppEntityWrap> r10 = getItemProvider(ItemType.PAGER_VIDEO.ordinal());
        q.e(r10, "null cannot be cast to non-null type com.bytedanceos.appstore.buss.adapter.app.pager.provider.PagerVideoProvider");
        ((PagerVideoProvider) r10).c();
    }

    @Override // com.chad.library.adapter.base.BaseProviderMultiAdapter
    public int getItemType(List<? extends AppEntityWrap> r10, int r11) {
        q.g(r10, "data");
        AppEntityWrap r12 = r10.get(r11);
        String r13 = r12.getName();
        if (r13 == null) goto L108;
        switch(r13.hashCode()) {
            case 0: goto L47;
            case 1149660: goto L43;
            case 3322014: goto L40;
            case 650735693: goto L37;
            case 702192350: goto L33;
            case 717168563: goto L30;
            case 753068662: goto L27;
            case 753187897: goto L24;
            case 765976499: goto L21;
            case 985141366: goto L18;
            case 996730857: goto L15;
            case 1022576952: goto L12;
            case 1089086835: goto L8;
            default: goto L108;
        };
    L8:
        if (r13.equals("视频推荐") == false) goto L108;
        return ItemType.PAGER_VIDEO.ordinal();
    L12:
        if (r13.equals("腾讯专区") == false) goto L108;
    L111:
        return ItemType.PAGER_HORIZONTAL.ordinal();
    L15:
        if (r13.equals("网易专区") == true) goto L111;
    L18:
        if (r13.equals("系统工具") == true) goto L111;
    L21:
        if (r13.equals("影音图像") == true) goto L111;
    L24:
        if (r13.equals("必备游戏") == false) goto L108;
    L110:
        return ItemType.PAGER_VERTICAL.ordinal();
    L27:
        if (r13.equals("必备应用") == true) goto L110;
    L30:
        if (r13.equals("学习教育") == true) goto L111;
    L33:
        if (r13.equals("大图横滑") == true) goto L110;
    L37:
        if (r13.equals("儿童母婴") == true) goto L111;
    L40:
        if (r13.equals(ServerElements.LIST) == true) goto L111;
    L43:
        if (r13.equals("购物") == true) goto L111;
    L47:
        if (r13.equals("") == false) goto L108;
        String r14 = r12.getTemplate();
        if (r14 == null) goto L57;
        Integer r15 = n.g(r14);
        if (r15 == null) goto L57;
        if (r15.intValue() != 6) goto L57;
        return ItemType.PAGER_HORIZONTAL.ordinal();
    L57:
        String r16 = r12.getTemplate();
        if (r16 == null) goto L65;
        Integer r17 = n.g(r16);
        if (r17 == null) goto L65;
        if (r17.intValue() != 7) goto L65;
        return ItemType.PAGER_VERTICAL.ordinal();
    L65:
        String r18 = r12.getTemplate();
        if (r18 == null) goto L73;
        Integer r19 = n.g(r18);
        if (r19 == null) goto L73;
        if (r19.intValue() != 10) goto L73;
        return ItemType.PAGER_BANNER_SMALL.ordinal();
    L73:
        if (r11 != 0) goto L75;
        String r20 = r10.get(r11).getVideo_url();
        if (r20 == null) goto L90;
        if (o.r(r20) == true) goto L90;
        return ItemType.ENTITY_VIDEO.ordinal();
    L90:
        if (r10.get(r11).getApps() == null) goto L120;
        List<CommonAppEntity> r21 = r10.get(r11).getApps();
        String r22 = null;
        if (r21 == null) goto L94;
        Integer r23 = Integer.valueOf(r21.size());
    L95:
        q.d(r23);
        if (r23.intValue() <= 0) goto L120;
        List<CommonAppEntity> r24 = r10.get(r11).getApps();
        if (r24 == null) goto L102;
        CommonAppEntity r25 = r24.get(0);
        if (r25 == null) goto L102;
        r22 = r25.getVideo_url();
    L102:
        if (r22 == null) goto L119;
        if (o.r(r22) == false) goto L120;
    L119:
        return ItemType.PAGER_HORIZONTAL.ordinal();
    L94:
        r23 = null;
    L120:
        return ItemType.PAGER_VIDEO.ordinal();
    L75:
        if (r11 == 1) goto L117;
        if (r11 == 2) goto L116;
        if (r11 == 3) goto L117;
        return ItemType.EMPTY.ordinal();
    L116:
        return ItemType.PAGER_VERTICAL.ordinal();
    L117:
        return ItemType.PAGER_HORIZONTAL.ordinal();
    L108:
        return ItemType.EMPTY.ordinal();
    }

    public final void onPause() {
        BaseItemProvider<AppEntityWrap> r10 = getItemProvider(ItemType.PAGER_VIDEO.ordinal());
        q.e(r10, "null cannot be cast to non-null type com.bytedanceos.appstore.buss.adapter.app.pager.provider.PagerVideoProvider");
        ((PagerVideoProvider) r10).d();
    }

    public final void onResume() {
        BaseItemProvider<AppEntityWrap> r10 = getItemProvider(ItemType.PAGER_VIDEO.ordinal());
        q.e(r10, "null cannot be cast to non-null type com.bytedanceos.appstore.buss.adapter.app.pager.provider.PagerVideoProvider");
        ((PagerVideoProvider) r10).e();
    }

    public PageAppsAdapter(String r10) {
        super(r10);
    }

    public /* synthetic */ PageAppsAdapter(String r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = "";
    L5:
        this(r10);
    }
}
