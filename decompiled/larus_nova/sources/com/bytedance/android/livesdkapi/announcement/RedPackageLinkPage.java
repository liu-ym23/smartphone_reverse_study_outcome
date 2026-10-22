package com.bytedance.android.livesdkapi.announcement;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdkapi/announcement/RedPackageLinkPage;", "Lcom/bytedance/android/livesdkapi/announcement/AnnounceCommand;", "()V", "LinkCommand", "UnLinkCommand", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public class RedPackageLinkPage implements AnnounceCommand {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/announcement/RedPackageLinkPage$LinkCommand;", "Lcom/bytedance/android/livesdkapi/announcement/RedPackageLinkPage;", "()V", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class LinkCommand extends RedPackageLinkPage {
        public static final LinkCommand INSTANCE = null;

        static {
            INSTANCE = new LinkCommand();
        }

        private LinkCommand() {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/announcement/RedPackageLinkPage$UnLinkCommand;", "Lcom/bytedance/android/livesdkapi/announcement/RedPackageLinkPage;", "()V", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class UnLinkCommand extends RedPackageLinkPage {
        public static final UnLinkCommand INSTANCE = null;

        static {
            INSTANCE = new UnLinkCommand();
        }

        private UnLinkCommand() {
        }
    }

    public RedPackageLinkPage() {
    }
}
