package com.bytedance.android.livesdkapi.room.handler.enterroom;

import com.bytedance.android.live.network.annotation.PbRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0007\b\t\n\u000b\fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0007\r\u000e\u000f\u0010\u0011\u0012\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/enterroom/EnterKey;", "", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "PreviewComment", "PreviewEnterSchema", "PreviewGameCp", "PreviewLifeIcon", "PreviewRightBottomCard", "PreviewToolbar", "Lcom/bytedance/android/livesdkapi/room/handler/enterroom/EnterKey$PreviewComment;", "Lcom/bytedance/android/livesdkapi/room/handler/enterroom/EnterKey$PreviewEnterSchema;", "Lcom/bytedance/android/livesdkapi/room/handler/enterroom/EnterKey$PreviewGameCp;", "Lcom/bytedance/android/livesdkapi/room/handler/enterroom/EnterKey$PreviewLifeIcon;", "Lcom/bytedance/android/livesdkapi/room/handler/enterroom/EnterKey$PreviewRightBottomCard;", "Lcom/bytedance/android/livesdkapi/room/handler/enterroom/EnterKey$PreviewToolbar;", "Lcom/bytedance/android/livesdkapi/room/handler/enterroom/UnknownEnterKey;", "live-room-controller-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class EnterKey {
    private final String name;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/enterroom/EnterKey$PreviewComment;", "Lcom/bytedance/android/livesdkapi/room/handler/enterroom/EnterKey;", "()V", "live-room-controller-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class PreviewComment extends EnterKey {
        public static final PreviewComment INSTANCE = null;

        static {
            INSTANCE = new PreviewComment();
        }

        private PreviewComment() {
            super("preview_comment", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/enterroom/EnterKey$PreviewEnterSchema;", "Lcom/bytedance/android/livesdkapi/room/handler/enterroom/EnterKey;", "()V", "live-room-controller-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class PreviewEnterSchema extends EnterKey {
        public static final PreviewEnterSchema INSTANCE = null;

        static {
            INSTANCE = new PreviewEnterSchema();
        }

        private PreviewEnterSchema() {
            super("preview_enter_schema", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/enterroom/EnterKey$PreviewGameCp;", "Lcom/bytedance/android/livesdkapi/room/handler/enterroom/EnterKey;", "()V", "live-room-controller-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class PreviewGameCp extends EnterKey {
        public static final PreviewGameCp INSTANCE = null;

        static {
            INSTANCE = new PreviewGameCp();
        }

        private PreviewGameCp() {
            super("gamecp", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/enterroom/EnterKey$PreviewLifeIcon;", "Lcom/bytedance/android/livesdkapi/room/handler/enterroom/EnterKey;", "()V", "live-room-controller-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class PreviewLifeIcon extends EnterKey {
        public static final PreviewLifeIcon INSTANCE = null;

        static {
            INSTANCE = new PreviewLifeIcon();
        }

        private PreviewLifeIcon() {
            super("preview_life_icon", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0005B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/enterroom/EnterKey$PreviewRightBottomCard;", "Lcom/bytedance/android/livesdkapi/room/handler/enterroom/EnterKey;", "name", "", "(Ljava/lang/String;)V", "ExplainCard", "live-room-controller-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static class PreviewRightBottomCard extends EnterKey {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/enterroom/EnterKey$PreviewRightBottomCard$ExplainCard;", "Lcom/bytedance/android/livesdkapi/room/handler/enterroom/EnterKey$PreviewToolbar;", "()V", "live-room-controller-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class ExplainCard extends PreviewToolbar {
            public static final ExplainCard INSTANCE = null;

            static {
                INSTANCE = new ExplainCard();
            }

            private ExplainCard() {
                super("explain_card");
            }
        }

        public PreviewRightBottomCard(String r100) {
            Intrinsics.checkNotNullParameter(r100, "name");
            super(r100, null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0004\u0005\u0006\u0007\bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/enterroom/EnterKey$PreviewToolbar;", "Lcom/bytedance/android/livesdkapi/room/handler/enterroom/EnterKey;", "name", "", "(Ljava/lang/String;)V", "GameCp", "Gift", "Revenue", "ShoppingCart", "live-room-controller-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static class PreviewToolbar extends EnterKey {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/enterroom/EnterKey$PreviewToolbar$GameCp;", "Lcom/bytedance/android/livesdkapi/room/handler/enterroom/EnterKey$PreviewToolbar;", "()V", "live-room-controller-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class GameCp extends PreviewToolbar {
            public static final GameCp INSTANCE = null;

            static {
                INSTANCE = new GameCp();
            }

            private GameCp() {
                super("gamecp_toolbar");
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/enterroom/EnterKey$PreviewToolbar$Gift;", "Lcom/bytedance/android/livesdkapi/room/handler/enterroom/EnterKey$PreviewToolbar;", "()V", "live-room-controller-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Gift extends PreviewToolbar {
            public static final Gift INSTANCE = null;

            static {
                INSTANCE = new Gift();
            }

            private Gift() {
                super(PbRequest.SwitchType.GIFT);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/enterroom/EnterKey$PreviewToolbar$Revenue;", "Lcom/bytedance/android/livesdkapi/room/handler/enterroom/EnterKey$PreviewToolbar;", "()V", "live-room-controller-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Revenue extends PreviewToolbar {
            public static final Revenue INSTANCE = null;

            static {
                INSTANCE = new Revenue();
            }

            private Revenue() {
                super("revenue");
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/enterroom/EnterKey$PreviewToolbar$ShoppingCart;", "Lcom/bytedance/android/livesdkapi/room/handler/enterroom/EnterKey$PreviewToolbar;", "()V", "live-room-controller-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class ShoppingCart extends PreviewToolbar {
            public static final ShoppingCart INSTANCE = null;

            static {
                INSTANCE = new ShoppingCart();
            }

            private ShoppingCart() {
                super("shopping_cart");
            }
        }

        public PreviewToolbar(String r100) {
            Intrinsics.checkNotNullParameter(r100, "name");
            super(r100, null);
        }
    }

    public final String getName() {
        return this.name;
    }

    private EnterKey(String r100) {
        this.name = r100;
    }

    public /* synthetic */ EnterKey(String r100, DefaultConstructorMarker r101) {
        this(r100);
    }
}
