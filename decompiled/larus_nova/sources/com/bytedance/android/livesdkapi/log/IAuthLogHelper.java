package com.bytedance.android.livesdkapi.log;

import com.larus.bmhome.share.panel.ShareChannel;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0002\n\u000bJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\t\u001a\u00020\u0003H&¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/log/IAuthLogHelper;", "", "authPopupClick", "", "buttonType", "Lcom/bytedance/android/livesdkapi/log/IAuthLogHelper$ButtonType;", "authPopupShow", "awemeAuthSwitch", "oneClickPopupClick", "oneClickPopupShow", "ButtonType", "RequestPage", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IAuthLogHelper {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/log/IAuthLogHelper$ButtonType;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "CONFIRM", "CANCEL", "DOUYIN_LOGIN", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ButtonType extends Enum<ButtonType> {
        private static final /* synthetic */ ButtonType[] $VALUES = null;
        public static final ButtonType CANCEL = null;
        public static final ButtonType CONFIRM = null;
        public static final ButtonType DOUYIN_LOGIN = null;
        private final String type;

        static {
            ButtonType r100 = new ButtonType("CONFIRM", 0, "confirm");
            CONFIRM = r100;
            ButtonType r101 = new ButtonType("CANCEL", 1, "cancel");
            CANCEL = r101;
            ButtonType r102 = new ButtonType("DOUYIN_LOGIN", 2, "douyin_login");
            DOUYIN_LOGIN = r102;
            $VALUES = new ButtonType[]{r100, r101, r102};
        }

        public static ButtonType valueOf(String r100) {
            return (ButtonType) a.a(ButtonType.class, r100);
        }

        public static ButtonType[] values() {
            return (ButtonType[]) $VALUES.clone();
        }

        public final String getType() {
            return this.type;
        }

        private ButtonType(String r100, int r101, String r102) {
            super(r100, r101);
            this.type = r102;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/log/IAuthLogHelper$RequestPage;", "", "page", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getPage", "()Ljava/lang/String;", "AWEME", "PHONE", "ONECLICK", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum RequestPage extends Enum<RequestPage> {
        private static final /* synthetic */ RequestPage[] $VALUES = null;
        public static final RequestPage AWEME = null;
        public static final RequestPage ONECLICK = null;
        public static final RequestPage PHONE = null;
        private final String page;

        static {
            RequestPage r100 = new RequestPage("AWEME", 0, ShareChannel.DOUYIN);
            AWEME = r100;
            RequestPage r101 = new RequestPage("PHONE", 1, "phone");
            PHONE = r101;
            RequestPage r102 = new RequestPage("ONECLICK", 2, "oneclick");
            ONECLICK = r102;
            $VALUES = new RequestPage[]{r100, r101, r102};
        }

        public static RequestPage valueOf(String r100) {
            return (RequestPage) a.a(RequestPage.class, r100);
        }

        public static RequestPage[] values() {
            return (RequestPage[]) $VALUES.clone();
        }

        public final String getPage() {
            return this.page;
        }

        private RequestPage(String r100, int r101, String r102) {
            super(r100, r101);
            this.page = r102;
        }
    }

    void authPopupClick(ButtonType r100);

    void authPopupShow();

    void awemeAuthSwitch();

    void oneClickPopupClick(ButtonType r100);

    void oneClickPopupShow();
}
