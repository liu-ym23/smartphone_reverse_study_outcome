package com.bytedance.android.live.profile.ui.base;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b+\b\u0017\u0018\u00002\u00020\u0001:%\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006."}, d2 = {"Lcom/bytedance/android/live/profile/ui/base/ComponentType;", "", "key", "", "description", "(Ljava/lang/String;Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "getKey", "AnchorHomeland", "AnchorImageEntry", "BasicButtonArea", "BusinessOpenArea", "CommentComponent", "CommonComponent", "DSLShopComponent", "DressParallaxEffect", "DressPreview", "DressPreviewDefault", "DressSuspension", "DynamicOperate", "EmptyComponent", "EnterEffect", "Exhibition", "ExitEffect", "FansClubVip", "GiftExhibition", "GroupAnchorGiftExhibition", "GroupLiveMember", "LocalLifeGroupShop", "MultiLinkPermanentRoom", "MyLiveAvatarNameComponent", "MyLiveTopRightArea", "OldHonourWall", "OldTagList", "PanelEffect", "ShopComponent", "SkinCustom", "SpreadMore", "StandardHonourWall", "StandardTagList", "TabsComponent", "TextDesc", "TextInfo", "Unknown", "VisitorCount", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ComponentType {
    private final String description;
    private final String key;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/profile/ui/base/ComponentType$AnchorHomeland;", "Lcom/bytedance/android/live/profile/ui/base/ComponentType;", "()V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class AnchorHomeland extends ComponentType {
        public static final AnchorHomeland INSTANCE = null;

        static {
            INSTANCE = new AnchorHomeland();
        }

        private AnchorHomeland() {
            super("AnchorHomeland", "主播家园");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/profile/ui/base/ComponentType$AnchorImageEntry;", "Lcom/bytedance/android/live/profile/ui/base/ComponentType;", "()V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class AnchorImageEntry extends ComponentType {
        public static final AnchorImageEntry INSTANCE = null;

        static {
            INSTANCE = new AnchorImageEntry();
        }

        private AnchorImageEntry() {
            super("AnchorImageEntry", "主播形象入口");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/profile/ui/base/ComponentType$BasicButtonArea;", "Lcom/bytedance/android/live/profile/ui/base/ComponentType;", "()V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class BasicButtonArea extends ComponentType {
        public static final BasicButtonArea INSTANCE = null;

        static {
            INSTANCE = new BasicButtonArea();
        }

        private BasicButtonArea() {
            super("BasicButtonArea", "基础操作区");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/profile/ui/base/ComponentType$BusinessOpenArea;", "Lcom/bytedance/android/live/profile/ui/base/ComponentType;", "key", "", "description", "(Ljava/lang/String;Ljava/lang/String;)V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static class BusinessOpenArea extends ComponentType {
        /* JADX WARN: Multi-variable type inference failed */
        public BusinessOpenArea() {
            Object[] r100 = 0 == true ? 1 : 0;
            this(null, r100, 3, 0 == true ? 1 : 0);
        }

        public BusinessOpenArea(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "description");
            super(r100, r101);
        }

        public /* synthetic */ BusinessOpenArea(String r100, String r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = "BusinessOpenArea";
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = "底部业务开放区";
        L8:
            this(r100, r101);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/profile/ui/base/ComponentType$CommentComponent;", "Lcom/bytedance/android/live/profile/ui/base/ComponentType;", "()V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class CommentComponent extends ComponentType {
        public static final CommentComponent INSTANCE = null;

        static {
            INSTANCE = new CommentComponent();
        }

        private CommentComponent() {
            super("CommentComponent", "评论");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/profile/ui/base/ComponentType$CommonComponent;", "Lcom/bytedance/android/live/profile/ui/base/ComponentType;", "()V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class CommonComponent extends ComponentType {
        public static final CommonComponent INSTANCE = null;

        static {
            INSTANCE = new CommonComponent();
        }

        private CommonComponent() {
            super("CommonComponent", "基础信息");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/profile/ui/base/ComponentType$DSLShopComponent;", "Lcom/bytedance/android/live/profile/ui/base/ComponentType$BusinessOpenArea;", "()V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class DSLShopComponent extends BusinessOpenArea {
        public static final DSLShopComponent INSTANCE = null;

        static {
            INSTANCE = new DSLShopComponent();
        }

        private DSLShopComponent() {
            super("DSLShopComponent", "DSL店铺区");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/profile/ui/base/ComponentType$DressParallaxEffect;", "Lcom/bytedance/android/live/profile/ui/base/ComponentType;", "()V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class DressParallaxEffect extends ComponentType {
        public static final DressParallaxEffect INSTANCE = null;

        static {
            INSTANCE = new DressParallaxEffect();
        }

        private DressParallaxEffect() {
            super("DressParallaxEffect", "闪卡装扮特效");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/profile/ui/base/ComponentType$DressPreview;", "Lcom/bytedance/android/live/profile/ui/base/ComponentType$DressSuspension;", "()V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class DressPreview extends DressSuspension {
        public static final DressPreview INSTANCE = null;

        static {
            INSTANCE = new DressPreview();
        }

        private DressPreview() {
            super("DressPreview", "装扮预览");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/profile/ui/base/ComponentType$DressPreviewDefault;", "Lcom/bytedance/android/live/profile/ui/base/ComponentType$DressSuspension;", "()V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class DressPreviewDefault extends DressSuspension {
        public static final DressPreviewDefault INSTANCE = null;

        static {
            INSTANCE = new DressPreviewDefault();
        }

        private DressPreviewDefault() {
            super("DressPreviewDefault", "装扮预览默认");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/profile/ui/base/ComponentType$DressSuspension;", "Lcom/bytedance/android/live/profile/ui/base/ComponentType;", "key", "", "description", "(Ljava/lang/String;Ljava/lang/String;)V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static class DressSuspension extends ComponentType {
        /* JADX WARN: Multi-variable type inference failed */
        public DressSuspension() {
            Object[] r100 = 0 == true ? 1 : 0;
            this(null, r100, 3, 0 == true ? 1 : 0);
        }

        public DressSuspension(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "description");
            super(r100, r101);
        }

        public /* synthetic */ DressSuspension(String r100, String r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = "DressSuspension";
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = "装扮悬浮模块";
        L8:
            this(r100, r101);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/profile/ui/base/ComponentType$DynamicOperate;", "Lcom/bytedance/android/live/profile/ui/base/ComponentType;", "()V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class DynamicOperate extends ComponentType {
        public static final DynamicOperate INSTANCE = null;

        static {
            INSTANCE = new DynamicOperate();
        }

        private DynamicOperate() {
            super("DynamicOperate", "动态操作区");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/profile/ui/base/ComponentType$EmptyComponent;", "Lcom/bytedance/android/live/profile/ui/base/ComponentType;", "()V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class EmptyComponent extends ComponentType {
        public static final EmptyComponent INSTANCE = null;

        static {
            INSTANCE = new EmptyComponent();
        }

        private EmptyComponent() {
            super("EmptyComponent", "空组件");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/profile/ui/base/ComponentType$EnterEffect;", "Lcom/bytedance/android/live/profile/ui/base/ComponentType;", "()V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class EnterEffect extends ComponentType {
        public static final EnterEffect INSTANCE = null;

        static {
            INSTANCE = new EnterEffect();
        }

        private EnterEffect() {
            super("EnterEffect", "进场动效");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/profile/ui/base/ComponentType$Exhibition;", "Lcom/bytedance/android/live/profile/ui/base/ComponentType;", "key", "", "description", "(Ljava/lang/String;Ljava/lang/String;)V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static class Exhibition extends ComponentType {
        /* JADX WARN: Multi-variable type inference failed */
        public Exhibition() {
            Object[] r100 = 0 == true ? 1 : 0;
            this(null, r100, 3, 0 == true ? 1 : 0);
        }

        public Exhibition(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "description");
            super(r100, r101);
        }

        public /* synthetic */ Exhibition(String r100, String r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = "Exhibition";
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = "礼物展馆";
        L8:
            this(r100, r101);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/profile/ui/base/ComponentType$ExitEffect;", "Lcom/bytedance/android/live/profile/ui/base/ComponentType;", "()V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ExitEffect extends ComponentType {
        public static final ExitEffect INSTANCE = null;

        static {
            INSTANCE = new ExitEffect();
        }

        private ExitEffect() {
            super("ExitEffect", "出场动效");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/profile/ui/base/ComponentType$FansClubVip;", "Lcom/bytedance/android/live/profile/ui/base/ComponentType;", "()V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class FansClubVip extends ComponentType {
        public static final FansClubVip INSTANCE = null;

        static {
            INSTANCE = new FansClubVip();
        }

        private FansClubVip() {
            super("FansClubVip", "单行的粉丝团和会员");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/profile/ui/base/ComponentType$GiftExhibition;", "Lcom/bytedance/android/live/profile/ui/base/ComponentType$Exhibition;", "()V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class GiftExhibition extends Exhibition {
        public static final GiftExhibition INSTANCE = null;

        static {
            INSTANCE = new GiftExhibition();
        }

        private GiftExhibition() {
            super("GiftExhibition", "新礼物展馆");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/profile/ui/base/ComponentType$GroupAnchorGiftExhibition;", "Lcom/bytedance/android/live/profile/ui/base/ComponentType$Exhibition;", "()V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class GroupAnchorGiftExhibition extends Exhibition {
        public static final GroupAnchorGiftExhibition INSTANCE = null;

        static {
            INSTANCE = new GroupAnchorGiftExhibition();
        }

        private GroupAnchorGiftExhibition() {
            super("GroupAnchorGiftExhibition", "团播主播礼物展馆");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/profile/ui/base/ComponentType$GroupLiveMember;", "Lcom/bytedance/android/live/profile/ui/base/ComponentType;", "()V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class GroupLiveMember extends ComponentType {
        public static final GroupLiveMember INSTANCE = null;

        static {
            INSTANCE = new GroupLiveMember();
        }

        private GroupLiveMember() {
            super("GroupLiveMember", "团播成员列表");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/profile/ui/base/ComponentType$LocalLifeGroupShop;", "Lcom/bytedance/android/live/profile/ui/base/ComponentType$BusinessOpenArea;", "()V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class LocalLifeGroupShop extends BusinessOpenArea {
        public static final LocalLifeGroupShop INSTANCE = null;

        static {
            INSTANCE = new LocalLifeGroupShop();
        }

        private LocalLifeGroupShop() {
            super("LocalLifeGroupShop", "商达橱窗");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/profile/ui/base/ComponentType$MultiLinkPermanentRoom;", "Lcom/bytedance/android/live/profile/ui/base/ComponentType;", "()V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class MultiLinkPermanentRoom extends ComponentType {
        public static final MultiLinkPermanentRoom INSTANCE = null;

        static {
            INSTANCE = new MultiLinkPermanentRoom();
        }

        private MultiLinkPermanentRoom() {
            super("MultiLinkPermanentRoom", "常驻嘉宾/常驻聊天室");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/profile/ui/base/ComponentType$MyLiveAvatarNameComponent;", "Lcom/bytedance/android/live/profile/ui/base/ComponentType;", "()V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class MyLiveAvatarNameComponent extends ComponentType {
        public static final MyLiveAvatarNameComponent INSTANCE = null;

        static {
            INSTANCE = new MyLiveAvatarNameComponent();
        }

        private MyLiveAvatarNameComponent() {
            super("MyLiveAvatarNameComponent", "我的直播头像昵称吸顶");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/profile/ui/base/ComponentType$MyLiveTopRightArea;", "Lcom/bytedance/android/live/profile/ui/base/ComponentType;", "()V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class MyLiveTopRightArea extends ComponentType {
        public static final MyLiveTopRightArea INSTANCE = null;

        static {
            INSTANCE = new MyLiveTopRightArea();
        }

        private MyLiveTopRightArea() {
            super("MyLiveTopRightArea", "我的直播右上角轮播消息展示区");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/profile/ui/base/ComponentType$OldHonourWall;", "Lcom/bytedance/android/live/profile/ui/base/ComponentType;", "()V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class OldHonourWall extends ComponentType {
        public static final OldHonourWall INSTANCE = null;

        static {
            INSTANCE = new OldHonourWall();
        }

        private OldHonourWall() {
            super("OldHonourWall", "旧荣誉墙");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/profile/ui/base/ComponentType$OldTagList;", "Lcom/bytedance/android/live/profile/ui/base/ComponentType;", "()V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class OldTagList extends ComponentType {
        public static final OldTagList INSTANCE = null;

        static {
            INSTANCE = new OldTagList();
        }

        private OldTagList() {
            super("OldTagList", "旧标签");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/profile/ui/base/ComponentType$PanelEffect;", "Lcom/bytedance/android/live/profile/ui/base/ComponentType;", "()V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class PanelEffect extends ComponentType {
        public static final PanelEffect INSTANCE = null;

        static {
            INSTANCE = new PanelEffect();
        }

        private PanelEffect() {
            super("PanelEffect", "面板特效");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/profile/ui/base/ComponentType$ShopComponent;", "Lcom/bytedance/android/live/profile/ui/base/ComponentType$BusinessOpenArea;", "()V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ShopComponent extends BusinessOpenArea {
        public static final ShopComponent INSTANCE = null;

        static {
            INSTANCE = new ShopComponent();
        }

        private ShopComponent() {
            super("ShopComponent", "店铺区");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/profile/ui/base/ComponentType$SkinCustom;", "Lcom/bytedance/android/live/profile/ui/base/ComponentType;", "()V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class SkinCustom extends ComponentType {
        public static final SkinCustom INSTANCE = null;

        static {
            INSTANCE = new SkinCustom();
        }

        private SkinCustom() {
            super("SkinCustom", "旧皮肤特效");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/profile/ui/base/ComponentType$SpreadMore;", "Lcom/bytedance/android/live/profile/ui/base/ComponentType;", "()V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class SpreadMore extends ComponentType {
        public static final SpreadMore INSTANCE = null;

        static {
            INSTANCE = new SpreadMore();
        }

        private SpreadMore() {
            super("SpreadMore", "我的直播荣誉墙下面的展开更多");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/profile/ui/base/ComponentType$StandardHonourWall;", "Lcom/bytedance/android/live/profile/ui/base/ComponentType;", "()V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class StandardHonourWall extends ComponentType {
        public static final StandardHonourWall INSTANCE = null;

        static {
            INSTANCE = new StandardHonourWall();
        }

        private StandardHonourWall() {
            super("StandardHonourWall", "新荣誉墙");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/profile/ui/base/ComponentType$StandardTagList;", "Lcom/bytedance/android/live/profile/ui/base/ComponentType;", "()V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class StandardTagList extends ComponentType {
        public static final StandardTagList INSTANCE = null;

        static {
            INSTANCE = new StandardTagList();
        }

        private StandardTagList() {
            super("StandardTagList", "新标签");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/profile/ui/base/ComponentType$TabsComponent;", "Lcom/bytedance/android/live/profile/ui/base/ComponentType;", "()V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class TabsComponent extends ComponentType {
        public static final TabsComponent INSTANCE = null;

        static {
            INSTANCE = new TabsComponent();
        }

        private TabsComponent() {
            super("TabsComponent", "我的直播多tab");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/profile/ui/base/ComponentType$TextDesc;", "Lcom/bytedance/android/live/profile/ui/base/ComponentType;", "()V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class TextDesc extends ComponentType {
        public static final TextDesc INSTANCE = null;

        static {
            INSTANCE = new TextDesc();
        }

        private TextDesc() {
            super("TextDesc", "个人介绍");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/profile/ui/base/ComponentType$TextInfo;", "Lcom/bytedance/android/live/profile/ui/base/ComponentType;", "()V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class TextInfo extends ComponentType {
        public static final TextInfo INSTANCE = null;

        static {
            INSTANCE = new TextInfo();
        }

        private TextInfo() {
            super("TextInfo", "关注、粉丝介绍");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/profile/ui/base/ComponentType$Unknown;", "Lcom/bytedance/android/live/profile/ui/base/ComponentType;", "()V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Unknown extends ComponentType {
        public static final Unknown INSTANCE = null;

        static {
            INSTANCE = new Unknown();
        }

        private Unknown() {
            super("Unknown", "未知组件");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/profile/ui/base/ComponentType$VisitorCount;", "Lcom/bytedance/android/live/profile/ui/base/ComponentType;", "()V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class VisitorCount extends ComponentType {
        public static final VisitorCount INSTANCE = null;

        static {
            INSTANCE = new VisitorCount();
        }

        private VisitorCount() {
            super("VisitorCount", "访客数量");
        }
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getKey() {
        return this.key;
    }

    public ComponentType(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "description");
        this.key = r100;
        this.description = r101;
    }
}
